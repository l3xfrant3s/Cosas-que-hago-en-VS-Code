/*1*/
drop function if exists InformeAlumno;
delimiter $$
create function InformeAlumno (codigoAlumno int) returns varchar(500) deterministic
begin
    declare hayMasFilas boolean default true;
    declare siglasModulo varchar(5);
    declare laNota int;
    declare retorno varchar(500) default concat("Alumno: <", codigoAlumno, "> ");
    declare notas_del_alumno cursor for
                            select siglas, nota
                            from notas n join modulos m on n.codMod = m.codMod
                            where codAlum = codigoAlumno;
    declare continue handler for not found set hayMasFilas = false;
    if(codigoAlumno not in(select codAlum from alumnos)) then
        set retorno = concat(retorno, "NO EXISTE EN NUESTRA B.D.");
    else
        set retorno = concat(retorno,
        (select concat(trim(nombre), " ", trim(apellido))
        from alumnos where codAlum = codigoAlumno),
        ": Notas:");

        open notas_del_alumno;
        while hayMasFilas do
            fetch notas_del_alumno into siglasModulo, laNota;
            set retorno = concat(retorno, " (", siglasModulo, "-", laNota,")");
        end while;
        close notas_del_alumno;
        set retorno = concat(retorno, ", Media: ", (select round(avg(nota), 2)
        from notas n join modulos m on n.codMod = m.codMod
        where codAlum = codigoAlumno));
    end if;
    return retorno;
end $$
delimiter ;

(select concat(trim(nombre), " ", trim(apellido))
from alumnos where codAlum = codigoAlumno)

select codAlum
from alumnos;

select siglas, nota
from notas n join modulos m on n.codMod = m.codMod
where codAlum = codigoAlumno;

select round(avg(nota), 2)
from notas n join modulos m on n.codMod = m.codMod
where codAlum = codigoAlumno;


select InformeAlumno(5);

/*2*/
alter table alumnos add Promociona char(1) check (Promociona in ('S', 'N')) default 'N';

/*3*/
/*drop trigger if exists trg_Bfr_Upd_Alumnos;
delimiter $$
create trigger trg_Bfr_Upd_Alumnos
before update on Alumnos
for each row
begin
    set new.Promociona = if((select count(nota) from notas where codAlum = old.codAlum and nota < 5) < 2, "S", "N");
end$$
delimiter ;*/

drop trigger if exists trg_Bfr_Upd_Alumnos;
delimiter $$
create trigger trg_Bfr_Upd_Alumnos
before update on Alumnos
for each row
begin
    if((select count(nota) from notas where codAlum = old.codAlum and nota < 5) >= 2) then
        signal sqlstate "45000" set message_text = "NO PUEDE PROMOCIONAR";
    end if;
end$$
delimiter ;

select count(nota) from notas
where codAlum = old.codAlum and nota >= 5;

select count(nota) from notas where codAlum = 5 and nota >= 5;

select count(nota), codAlum from notas where nota < 5 group by codAlum;

update alumnos set Promociona = "S" where codAlum = 2;
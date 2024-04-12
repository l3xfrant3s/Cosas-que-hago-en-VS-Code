--1
drop procedure if exists get_Modulo;
delimiter $$
create procedure get_Modulo(modulin varchar(3))
begin
    if (modulin not in (select Siglas from modulos)) then
        select concat('Del modulo <', modulin, '> no existen datos') Mensaje;
    elseif (modulin not in (select distinct m.Siglas from notas n join modulos m on n.CodMod = m.CodMod)) then
        select concat('En el modulo <', modulin, '> No tenemos alumnos matriculados') Mensaje;
    else
        /*En estos joins lo que hay efectivamente es cada nota
        asociada con toda la infomacion del modulo y el profesor,
        como la media reducira la columna de las notas a un solo
        valor, hay que agrupar*/
        select m.Siglas, m.Titulo Modulo, avg(Nota) 'Nota Media',
        sum(if (Nota < 5, 1, 0)) Suspensos, sum(if (Nota >= 5, 1, 0)) Aprobados,
        concat(trim(p.Nombre), ' ', trim(p.Apellido)) Profesor
        from modulos m join profesor p on m.Profe = p.CodProfe
        join notas n on m.CodMod = n.CodMod
        where m.Siglas = modulin
        group by m.CodMod; /*realmente cualquier valor de las tablas profesor
        o modulos serviria por lo anterior*/
    end if;
end$$
delimiter ;

--2
drop function if exists ValidarDni;
delimiter $$
create function ValidarDni(dni char(10)) returns boolean deterministic
begin
    return if(substr('TRWAGMYFPDXBNJZSQVHLCK', mod(left(dni, 8), 23)+1, 1) = right(dni, 1), true, false);
end$$
delimiter ;

drop procedure if exists new_Profe;
delimiter $$
create procedure new_Profe(dni char(10), nombrecillo varchar(50), apellidito varchar(50))
begin
    declare codicito int;
    declare media decimal(8,2);
    declare correo varchar(100);
    set codicito = (select max(CodProfe) from profesor) + 1;
    set media = (select avg(sueldo) from profesor);
    set correo = lower(concat(left(nombrecillo, 3), apellidito, '@ieselrincon.es'));

    if (not ValidarDni(dni)) then
        select 'El DNI no es correcto. Asegurate de que esta bien escrito, que no le falten o sobren numeros.' Mensaje;
    else
        insert into profesor(CodProfe, Nif, Nombre, Apellido, Sueldo, email, FechaIngreso)
        values (codicito, dni, nombrecillo, apellidito, media, correo, curdate());
    end if;
end$$
delimiter ;


call new_Profe('22334455B', 'Carlos', 'Baute');
/*1*/
drop procedure if exists get_media;
delimiter $$
create procedure get_media ()
begin
    select Siglas,
    round(avg(Nota), 2) as 'Nota Media'
    from notas as N, modulos as M
    where N.CodMod = M.CodMod
    group by N.CodMod
    order by round(avg(Nota), 2) desc;
end$$
delimiter ;

/*2*/
drop procedure if exists get_boletin;
delimiter $$
create procedure get_boletin (in dniIn varchar(50))
begin
    select concat('Notas de: ', upper(concat(trim(Nombre), ' ', trim(Apellido)))) Boletin
    from alumnos where DNI = dniIn;

    do sleep(2);

    select Siglas, Titulo "Módulo", Nota
    from modulos m join notas n on m.CodMod = n.CodMod
    join alumnos a on a.CodAlum = n.CodAlum
    where a.DNI = dniIn;
end$$
delimiter ;

/*3*/
drop procedure if exists get_salario;
delimiter $$
create procedure get_salario (in minimo int, in maximo int)
begin
    select upper(concat(trim(Nombre), ' ', trim(Apellido))) Profesor, concat(Sueldo, ' Euros') 'Salario en Euros'
    from profesor
    where sueldo > minimo and sueldo < maximo
    order by Sueldo asc;
end$$
delimiter ;
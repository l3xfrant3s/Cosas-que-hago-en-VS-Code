--1
drop procedure if exists AumentarSueldo;
delimiter $$
create procedure AumentarSueldo (in depart varchar(20), in aumento int)
begin
if (lower(depart) not in (select lower(Nombdep) from departamento)) then
    select 'Departamento no encontrado.' Error_1;
elseif (aumento > 300) then
    select 'Aumento salarial no autorizado.' Error_2;
else
    update empleado
    set Salario = Salario + aumento
    where Ndep = (select Ndep
                  from departamento
                  where Nombdep = depart);
end if;
end$$
delimiter ;

--2
set lc_time_names = 'en_US';
set lc_time_names = 'es_ES';
drop function if exists fecha;
delimiter $$
create function fecha() returns varchar(40) deterministic
begin
    declare timeNames, laFecha varchar(40);
    select @@lc_time_names into timeNames;
    set lc_time_names = 'es_ES';
    select concat(dayname(curdate()), ', ' , right(curdate(), 2), ' de ', monthname(curdate()), ' de ', year(curdate())) into laFecha;
    set lc_time_names = timeNames;
    return laFecha;
end$$
delimiter ;

/*drop function if exists fecha;
delimiter $$
create function fecha() returns varchar(40) deterministic
begin
    declare timeNames, laFecha varchar(40);
    select @@lc_time_names into timeNames;
    set lc_time_names = 'es_ES';
    select date_format(curdate(), '%W, %d de %M de %Y') into laFecha;
    set lc_time_names = timeNames;
    return laFecha;
end$$
delimiter ;*/

--3
drop procedure if exists supervisor;
delimiter $$
create procedure supervisor (in superNombre varchar(20))
begin
    if (superNombre not in (select trim(nombre) from empleado)) then 
        select concat('<<', superNombre, '>> no es empleado aqui') Mensaje;
    elseif (select count(e1.Supervs)
        from empleado e1 join empleado e2 on trim(e1.Supervs) = trim(e2.Nemp)
        where trim(e2.Nombre) = superNombre) < 1 then
        select concat('El empleado <<', superNombre, '>> no es supervisor de nadie') Mensaje;
    else 
        select upper(trim(e1.nombre)) Subordinados
        from empleado e1 join empleado e2 on trim(e1.Supervs) = trim(e2.Nemp)
        where trim(e2.Nombre) = superNombre;
    end if;
end$$
delimiter ;

--4
drop procedure if exists Listado;
delimiter $$
create procedure Listado (in Departa varchar(20), in Vmin decimal(8,2), in Vmax decimal(8,2))
begin
    if (Departa not in (select Nombdep from departamento)) then
        select concat('El departamento ', Departa, ' no existe. Asegurate de que has escrito su nombre correctamente.') as 'Error 1';
    elseif (Vmax < Vmin) then
        select 'El rango introducido no es correcto. Asegurate de escribir el limite inferior primero y luego el superior.' as 'Error 2';
    elseif (select count(nemp) from empleado e join departamento d on e.ndep = d.ndep
            where lower(nombdep) = lower(Departa) and Salario >= Vmin and Salario <= Vmax) = 0 then
        select concat('Ningun empleado en el rango salarial ', Vmin, '-', Vmax) as 'Error 3';
    else 
        select e.nemp 'Numero de empleado', e.Nombre, e.Apellido, e.Empleo,
        e.fechaing 'Fecha de ingreso', e.supervs 'Supervisor', e.Salario , e.Comision, e.Email
        from empleado e join departamento d on e.ndep = d.ndep
        where lower(nombdep) = lower(Departa) and Salario >= Vmin and Salario <= Vmax;
    end if;
end$$
delimiter ;

--5
drop function if exists InformeDepartamento;
delimiter $$
create function InformeDepartamento(Departa varchar(20)) returns varchar(200) deterministic
begin
    declare numeroEmp int;
    declare salarioMedio decimal(8, 2);
    declare nombjefe varchar(20);
    if (Departa not in (select Nombdep from departamento)) then
        return concat('Error 1: El departamento ', Departa, ' no existe. Asegurate de que has escrito su nombre correctamente.');
    else
        select count(e.nemp), avg(e.salario), e2.nombre
        into numeroEmp, salarioMedio, nombjefe
        from empleado e join departamento d on e.ndep = d.ndep
        join empleado e2 on d.jefe = e2.nemp
        where lower(trim(nombdep)) = lower(Departa)
        group by e2.nombre;
        return upper(concat('DEPARTAMENTO -> ', Departa, ':EMPLEADOS: ', numeroEmp, ' - SALARIO MEDIO: ', salarioMedio, ' - JEFE: ', nombjefe));
    end if;
    return null;
end$$
delimiter ;

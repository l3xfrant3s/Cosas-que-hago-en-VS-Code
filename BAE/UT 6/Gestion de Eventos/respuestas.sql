/*1*/
alter table empleado add borrado char(1) check (borrado in ('S', 'N')) default 'N';

/*2*/
drop procedure if exists eliminar;
delimiter $$
create procedure eliminar(codEmpleado char(10))
begin
    if(codEmpleado not in (select nemp from empleado)) then
        select "Este empleado no existe o ya ha sido borrado" "Error: empleado no existente";
    else
        update empleado set borrado = 'S' where nemp = codEmpleado;
    end if;
end$$
delimiter ;

/*3*/
drop table if exists historicos;
create table historicos(
    Nemp char(10) primary key,
    Nombre varchar(20) not null unique,
    Apellido varchar(45),
    Empleo varchar(20) not null,
    FechaIng date,
    Supervs char(10),
    Salario decimal(8,2),
    Ndep int,
    Comision decimal(8,2),
    Email varchar(60)
);

drop procedure if exists borrar;
delimiter $$
create procedure borrar()
begin
    insert into historicos
    select Nemp, Nombre, Apellido, Empleo, FechaIng,
    Supervs, Salario, Ndep, Comision, Email
    from empleado
    where borrado = 'S';
    delete from empleado where borrado = 'S';
end$$
delimiter ;

/*4*/
create event evento_borrar
on schedule every 1 day starts '2024-06-04 09:00:00'
do call borrar();

create event temp
on schedule at "2024-06-04 22:47:00"
do call borrar();
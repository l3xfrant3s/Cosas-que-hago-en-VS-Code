/*1*/
drop table if exists despidos;
create table despidos(
    Cod int(11) primary key,
    Nombre varchar(20),
    Empleo varchar(20),
    Fecha date default (curdate()),
    Usuario varchar(200) default (current_user())
);

drop trigger if exists empleado_bd_trigger;
delimiter $$
create trigger empleado_bd_trigger
before delete on empleado
for each row
begin
    insert into despidos (cod, nombre, empleo)
    values (old.nemp, old.nombre, old.empleo);
end$$
delimiter ;

insert into empleado (nemp, nombre, apellido, empleo, fechaing, supervs, salario, ndep)
values (7001, "ANA", "GIL", "GERENTE", "2010-04-15", 7839, 2100.00, 70);


update empleado set nombre = trim(nombre), apellido = trim(apellido), empleo = trim(empleo), email = trim(email);

/*2*/

alter table departamento
add Presupuesto decimal(10,2) default 10000.00;

delimiter $$
drop trigger if exists empleado_bi_trigger;
create trigger empleado_bi_trigger
before insert on empleado
for each row
begin
    update departamento
    set presupuesto = presupuesto + new.salario
    where departamento.ndep = new.ndep;
end$$
delimiter ;


insert into empleado (nemp, nombre, empleo, salario, ndep)
values (70000, "yo", "nada", 20000, 70), 
(70001, "tu", "todo", 2, 10);

/*3*/
delimiter $$
drop trigger if exists empleado_bu_trigger;
create trigger empleado_bu_trigger
before update on empleado
for each row
begin
    update departamento
    set presupuesto = presupuesto + (new.salario-old.salario)
    where departamento.ndep = new.ndep;
end$$
delimiter ;

/*4*/
delimiter $$
drop trigger if exists empleado_bi_trigger;
create trigger empleado_bi_trigger
before insert on empleado
for each row
begin
    update departamento
    set presupuesto = presupuesto + new.salario
    where departamento.ndep = new.ndep;
end$$
delimiter ;

delimiter $$
drop trigger if exists empleado_bu_trigger;
create trigger empleado_bu_trigger
before update on empleado
for each row
begin
    if ((select avg(salario) from empleado where ndep = new.ndep))
    if (new.salario < (select avg(salario) from empleado where ndep = new.ndep))
    update departamento
    set presupuesto = presupuesto + (new.salario-old.salario)
    where departamento.ndep = new.ndep;
end$$
delimiter ;


/*5*/
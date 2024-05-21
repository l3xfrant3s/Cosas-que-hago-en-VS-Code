/*1*/
drop table if exists despidos;
create table despidos(
    Cod int(11) primary key,
    Nombre varchar(20),
    Empleo varchar(20),
    Fecha date default (curdate()),
    Usuario varchar(200) default (current_user())
);

drop trigger if exists empleado_bd_trigger_despidos;
delimiter $$
create trigger empleado_bd_trigger_despidos
before delete on empleado
for each row
begin
    insert into despidos (cod, nombre, empleo, usuario)
    values (old.nemp, old.nombre, old.empleo, current_user());
end$$
delimiter ;

delete from empleado where nemp = 7001;
insert into empleado (nemp, nombre, apellido, empleo, fechaing, supervs, salario, ndep) values (7001, "ANA", "GIL", "GERENTE", "2010-04-15", 7839, 2100.00, 70);
insert into empleado (nemp, nombre, apellido, empleo, fechaing, supervs, salario, ndep)
values (7002, "LAURA", "PAUSINI", "OFICINIST", "2012-01-12", 7566, 850.00, 10);


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
drop trigger if exists empleado_bu_trigger;
delimiter $$
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
drop trigger if exists empleado_bi_trigger_salario;
create trigger empleado_bi_trigger_salario
before insert on empleado
for each row
precedes empleado_bi_trigger
begin
    if (new.salario < (select avg(salario) from empleado where ndep = new.ndep)) then
        set new.salario = (select avg(salario) from empleado where ndep = new.ndep);
    end if;
end$$
delimiter ;

delimiter $$
drop trigger if exists empleado_bu_trigger_salario;
create trigger empleado_bu_trigger_salario
before update on empleado
for each row
precedes empleado_bu_trigger
begin
    if (new.salario < (select avg(salario) from empleado where ndep = new.ndep)) then
        set new.salario = (select avg(salario) from empleado where ndep = new.ndep);
    end if;
end$$
delimiter ;

/*5*/

delimiter $$
create trigger trg_check_supervs
before insert on empleado
for each row
begin
    declare num_subordinados int;

    if new.supervs is not null then
        select count(*)
        into num_subordinados
        from empleado
        where supervs = new.supervs;

        if num_subordinados >= 5 then
            signal sqlstate '45000' 
            set message_text = 'El jefe no puede tener más de cinco empleados a su cargo.';
        end if;
    end if;
end$$
delimiter ;

delimiter $$
create trigger trg_check_supervs_update
before update on empleado
for each row
begin
    declare num_subordinados int;

    if new.supervs is not null and new.supervs != old.supervs then
        select count(*)
        into num_subordinados
        from empleado
        where supervs = new.supervs;

        if num_subordinados >= 5 then
            signal sqlstate '45000'
            set message_text = 'El jefe no puede tener más de cinco empleados a su cargo.';
        end if;
    end if;
end$$
delimiter ;
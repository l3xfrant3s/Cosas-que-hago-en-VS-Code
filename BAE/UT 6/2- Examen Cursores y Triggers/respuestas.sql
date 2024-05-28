/*1.1*/
drop trigger if exists trg_empleado_bfr_ins;
delimiter $$
create trigger trg_empleado_bfr_ins
before insert on empleado
for each row
begin
    declare msg_error_no_vendedor varchar(50) default concat("El empleado <", new.nombre, "> NO es VENDEDOR");
    if(upper(new.empleo) = "VENDEDOR") then
        set new.Comision = if(new.Comision < new.Salario*0.1 or new.Comision is null, new.Salario*0.1, new.Comision);
    elseif(new.Comision is not null) then
        signal sqlstate '45000' set message_text = msg_error_no_vendedor;
    end if;
end$$
delimiter ;


insert into empleado values("asdf", "yo", "ast", "VENDEDOR", curdate(), 7839, 1000, 10, 120, "algo@algo.algo");
insert into empleado values("asdfg", "yo2", "ast", "VENDEDOR", curdate(), 7839, 1000, 20, 50, "algo@algo.algo");
insert into empleado values("asdfgh", "yo3", "ast", "vendedor", curdate(), 7839, 1000, 30, null, "algo@algo.algo");
insert into empleado values("asdfghj", "yo4", "ast", "analista", curdate(), 7839, 1000, 40, 120, "algo@algo.algo");
insert into empleado values("asdfghjk", "yo5", "ast", "analista", curdate(), 7839, 1000, 50, null, "algo@algo.algo");

select * from empleado where left(nemp, 3) = "asd";
delete from empleado where left(nemp, 3) = "asd";

/*1.2*/
drop trigger if exists trg_empleado_aft_upd;
delimiter $$
create trigger trg_empleado_aft_upd
after update on empleado
for each row
begin
    update departamento set NumEmpleados = (select count(*) from empleado where ndep = old.ndep),
    SalarioMedio = (select avg(Salario) from empleado where ndep = old.ndep)
    where ndep = old.ndep;
end$$
delimiter ;

update empleado set ndep = 10 where nemp = "asdf";
update empleado set ndep = 20 where nemp = "asdfg";
update empleado set ndep = 30 where nemp = "asdfgh";
update empleado set ndep = 50 where nemp = "asdfghjk";

/*1.3*/
drop trigger if exists trg_empleado_aft_del;
delimiter $$
create trigger trg_empleado_aft_del
after delete on empleado
for each row
begin
    update departamento set NumEmpleados = (select count(*) from empleado where ndep = old.ndep),
    SalarioMedio = (select avg(Salario) from empleado where ndep = old.ndep)
    where ndep = old.ndep;
end$$
delimiter ;


/*2*/
drop function if exists Ciudades_Empleos;
delimiter $$
create function Ciudades_Empleos() returns varchar(500) deterministic
begin
    declare hayMasFilas boolean default true;
    declare una_ciudad varchar(20);
    declare un_empleo varchar(20);
    declare las_ciudades varchar(250) default concat("[Ciudades:]");
    declare los_empleos varchar(250) default concat(" [Empleos:]");
    declare retorno varchar(500);
    declare todas_ciudades cursor for
                            select distinct trim(ciudad)
                            from departamento;
    declare todos_empleos cursor for
                            select distinct trim(empleo)
                            from empleado;
    declare continue handler for not found set hayMasFilas = false;

    open todas_ciudades;
    fetch todas_ciudades into una_ciudad;
    set las_ciudades = concat(las_ciudades, una_ciudad);
    fetch todas_ciudades into una_ciudad;
    while hayMasFilas do
        set las_ciudades = concat(las_ciudades, "-", una_ciudad);
        fetch todas_ciudades into una_ciudad;
    end while;
    close todas_ciudades;

    set hayMasFilas = true;

    open todos_empleos;
    fetch todos_empleos into un_empleo;
    set los_empleos = concat(los_empleos, un_empleo);
    fetch todos_empleos into un_empleo;
    while hayMasFilas do
        set los_empleos = concat(los_empleos, "-", un_empleo);
        fetch todos_empleos into un_empleo;
    end while;
    close todos_empleos;

    set retorno = concat(las_ciudades, los_empleos);
    return retorno;
end $$
delimiter ;

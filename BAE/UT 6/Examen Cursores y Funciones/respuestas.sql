/*1*/
drop procedure if exists AltaEmpleado;
delimiter $$
create procedure AltaEmpleado(InNombre varchar(20), InApellido varchar(45), InEmpleo varchar(20), InDepartamento varchar(20), InNombreSupervisor varchar(20))
begin
    declare InNemp char(10) default concat(upper(left(InNombre, 2)), left(curdate(), 4), substr(curdate(), 6, 2), right(curtime(), 2));
    declare InSupervs char(10);
    declare mediaSalarioDep decimal(8,2) default 0;
    declare inNdep int;
    declare inEmail varchar(60) default lower(concat(InNombre, left(curdate(), 4), ".", Indepartamento, "@gmail.com"));
    if(InNombre in (select nombre from empleado)) then
        select concat("El empleado <", InNombre, "> Ya existe") "Error1: Empleado duplicado";
    elseif(InEmpleo not in (select Empleo from empleado)) then
        select concat("El puesto de trabajo <", InEmpleo, "> No existe") "Error2: Empleo no valido";
    elseif(InDepartamento not in (select Nombdep from departamento)) then
        select concat("El departamento <", InDepartamento, "> no existe") "Error3: Departamento incorrecto";
    elseif(InNombreSupervisor not in (select nombre from empleado)) then
        select concat("El supervisor <", InNombreSupervisor, "> No existe") "Error4: supervisor No es válido";
    else
        set InSupervs = (select nemp from empleado where nombre = InNombreSupervisor);
        set inNdep = (select ndep from departamento where nombdep = InDepartamento);
        set mediaSalarioDep = (select avg(salario) from empleado where ndep = inNdep);
        insert into empleado (Nemp, Nombre, Apellido, Empleo, FechaIng, Supervs, Salario, Ndep, Email)
        values(InNemp, upper(InNombre), upper(InApellido), upper(InEmpleo), curdate(), InSupervs, mediaSalarioDep, inNdep, inEmail);
    end if;
end$$
delimiter ;



        set InSupervs = select nemp from empleado where nombre = InNombreSupervisor;
        set inNdep = select ndep from departamento where nombdep = InDepartamento;
        set mediaSalarioDep = select avg(salario) from empleado where ndep = inNdep;

call AltaEmpleado("Alexis", "Felipe", "Oficinista", "Investigacion", "Simeon");

/*2*/
drop function if exists InformeEmpleo;
delimiter $$
create function InformeEmpleo(nombreEmpleo varchar(20)) returns varchar(500) deterministic
begin
    declare retorno varchar(500) default concat(upper(nombreEmpleo), ": ");
    declare mediaSalario decimal(8, 2);
    declare plantilla int;
    declare masVeterano varchar(66);
    declare tiempoEmpresa int;
    if(nombreEmpleo not in (select Empleo from empleado)) then
        set retorno = concat(retorno, "Error, esa categoria profesional no existe");
    else
        select avg(salario), count(nemp) into mediaSalario, plantilla from empleado where empleo = nombreEmpleo;
        select concat(trim(nombre), " ", trim(apellido)) veterano,
        (year(curdate()) - year(fechaing)) tiempo
        into masVeterano, tiempoEmpresa
        from empleado where empleo = nombreEmpleo
        order by (year(curdate()) - year(fechaing)) desc,
        apellido asc
        limit 1;
        set retorno = concat(retorno, "Salario medio: ", mediaSalario, " - Plantilla: ", plantilla, " - mas Veterano/a: ", masVeterano, " - ", tiempoEmpresa, " anios en la empresa");
    end if;
    return retorno;
end$$
delimiter ;



select concat(trim(nombre), " ", trim(apellido)) veterano,
(year(curdate()) - year(fechaing)) tiempo
from empleado
where empleo = "analista"
order by (year(curdate()) - year(fechaing)) desc,
apellido asc
limit 1;
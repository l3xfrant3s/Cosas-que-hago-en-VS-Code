/*1*/
drop procedure if exists ListadoDepartamento;
delimiter $$
create procedure ListadoDepartamento(nombrete varchar(20))
begin
    if (upper(nombrete) not in (select upper(nombdep) from departamento)) then
        select concat('El departamento <<', upper(nombrete), '>> no existe') 'ERROR 1';
    elseif ((select count(nemp) from empleado e join departamento d on e.ndep = d.ndep where d.nombdep = nombrete) <= 0) then
        select concat('El departamento <<', upper(nombrete), '>> no tiene empleados') 'ERROR 2';
    else 
        select e.Nombre 'Nombre Empleado', e.FechaIng 'Fecha Ingreso Empresa',
        (year(curdate())-year(e.Fechaing)) 'Años de antigüedad', e.Empleo 'Puesto Trabajo'
        from empleado e join departamento d on e.ndep = d.ndep
        where d.nombdep = nombrete
        order by (year(curdate())-year(e.Fechaing)) desc;
    end if;
end$$
delimiter ;

/*2*/
drop function if exists InformeEmpleado;
delimiter $$
create function InformeEmpleado(codigo int) returns varchar(200) deterministic
begin
    declare supernomb varchar(20);
    declare informe varchar(200);
    if(codigo not in (select nemp from empleado)) then
        return concat('El codigo <<', codigo, '>> no existe');
    else
        set supernomb = (select if(e1.supervs is null, '-----', e2.nombre)
        from empleado e1 left join empleado e2 on e1.supervs = e2.nemp
        where e1.nemp = codigo);
        set informe = (select concat('Nombre: ', upper(nombre), ' ', upper(apellido), ' - Sueldo: ', salario,
        ' euros - Puesto: ', upper(empleo), ' - Correo: ', if(email is null, '-----', email), ' Jefe: ', supernomb)
        from empleado where nemp = codigo);
        return informe;
    end if;
end$$
delimiter ;

select InformeEmpleado(7839) 'Informe Empleado';

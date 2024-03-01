/*1*/
describe departamento;
describe empleado;
describe vendedor;
/*2*/
alter table departamento
add constraint fk_departamento foreign key(Jefe)
                references empleado(Nemp)
                on update cascade;
/*3*/
alter table empleado
add unique(nombre);
/*4*/
create index nombre_desc on empleado (nombre desc);
/*5*/
create view Vendedor (nemp, nombre, apellido, empleo,
fechaing, supervs, salario, ndep, comision, email)
as select * from empleado where empleo = 'vendedor';
/*6*/
select * from empleado
where empleo = 'gerente' or empleo = 'oficinista' and ndep = '30';
/*7*/
select nombre, empleo, ndep from empleado
where length(trim(nombre)) = 6 and substr(nombre, 6, 1) = 'S';
/*8*/
select count(Numero_empleados) as 'Tipos de empleados'
from (select count(empleo) as 'Numero_empleados'
     from empleado as E, departamento as D
     where E.ndep = D.ndep and Nombdep = 'Ventas'
     group by empleo) as prueba;
/*9*/
select empleo, count(empleo) as 'Numero de empleados'
from empleado as E, departamento as D
where E.ndep = D.ndep and Nombdep = 'Ventas'
group by empleo;
/*10*/
select nombre, ciudad, (year(curdate())-year(fechaing)) as antigüedad
from empleado as E, departamento as D
where E.ndep = D.ndep and trim(nombre) = 'Antonio';
/*11*/
select E1.nombre, E1.salario, E2.nombre, E2.salario
from empleado as E1, empleado as E2
where E1.Supervs = E2.Nemp and E1.salario > E2.salario;
/*12*/
select nombre, empleo, salario, ndep
from empleado
where ndep != '30' and salario > (select min(salario)
                                       from empleado
                                       where ndep = '30')
order by salario desc;
/*13*/
select nombre, empleo, salario
from empleado
where empleo = (select empleo from empleado where trim(nombre) = 'Santos')
and salario = (select salario from empleado where trim(nombre) = 'Santos')
and trim(nombre) != 'Santos';
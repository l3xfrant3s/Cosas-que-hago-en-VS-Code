drop database if exists Tienda;

create database Tienda;

use Tienda;

create table Departamento(
Ndep int primary key,
Nombdep varchar(30) not null,
Ciudad varchar(30)
);

create table Empleado(
Nemp int primary key,
Nombre varchar(50),
Empleo varchar(20) not null,
Fechaing date,
Supervs int,
Salario decimal(10,2) check (Salario>500),
Ndep int not null,
foreign key (Supervs) references Empleado(Nemp)
							on update cascade,
foreign key (Ndep) references Departamento(Ndep)
							on update cascade
);

create index IX_Nombre_Emp
on Empleado (Nombre);

alter table Empleado
add Comision decimal(8,2);

create view Vendedores as
select Nombre, Fechaing, Salario
from Empleado
where Empleo = 'Vendedor';
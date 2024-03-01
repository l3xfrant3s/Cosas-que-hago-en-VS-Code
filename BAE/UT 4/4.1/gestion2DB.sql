drop database if exists Gestion2;

create database Gestion2;

use Gestion2;

create table Empleado(
CodEmpleado varchar(10) primary key,
Nif varchar(10) not null unique,
Nombre varchar(30),
Apellidos varchar(50),
FechaContratacion date,
Puesto int,
Sueldo int,
Calle varchar(40),
Poblacion varchar(40),
CodPostal varchar(40)
);

create table Telefono(
CodEmpleado varchar(10),
Numero varchar(12),
primary key(CodEmpleado, Numero),
foreign key (CodEmpleado) references Empleado(CodEmpleado)
							on update cascade
);

create table Cliente(
CodCliente varchar(10) primary key,
Nif_Cif varchar(10) not null unique,
Direccion varchar(60),
Telefono varchar(12)
);

create table Pedido(
CodPedido varchar(10) primary key,
FechaPedido date,
CodEmpleado varchar(10),
CodCliente varchar(10),
foreign key (CodEmpleado) references Empleado(CodEmpleado)
							on update cascade,
foreign key (CodCliente) references Cliente(CodCliente)
							on update cascade
);

create table Producto(
CodProducto varchar(10) primary key,
Descripcion varchar(288),
Precio float(8,2),
NumExistencias int
);

create table Contenidos(
CodPedido varchar(10),
CodProducto varchar(10),
Unidades int,
foreign key (CodPedido) references Pedido(CodPedido)
							on update cascade,
foreign key (CodProducto) references Producto(CodProducto)
							on update cascade
);

create table Familiar(
CodFamiliar varchar(10) primary key,
Nif_Cif varchar(10) not null unique,
Direccion varchar(60),
Telefono varchar(12),
CodEmpleado varchar(10),
foreign key (CodEmpleado) references Empleado(CodEmpleado)
							on update cascade
);
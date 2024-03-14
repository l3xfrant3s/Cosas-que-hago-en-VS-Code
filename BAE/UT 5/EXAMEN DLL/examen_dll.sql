/*1*/
create database cochesBD;

/*2*/
use database cochesBD;

drop table if exists Alquiler;
drop table if exists Coche;
drop table if exists Cliente;
create table Coche(
CodCoche integer auto_increment primary key,
Matricula varchar(8) unique not null,
Marca varchar(15),
Color varchar(20) default 'blanco',
Precio decimal(10,2),
FechaMatricula date,
Garantia boolean default true,
constraint check (Precio > 6000 and Precio < 200000),
constraint check (FechaMatricula > '2010-01-01')
);


drop table if exists Cliente;
create table Cliente(
CodCliente varchar(5) primary key,
Nombre varchar(30),
Apellidos varchar(60),
Telef char(10),
FechaNac date,
Ciudad varchar(50) default 'Las Palmas G.C.',
Email varchar(50)
);


drop table if exists Alquiler;
create table Alquiler(
IdCoche integer,
IdCliente varchar(5),
FechaIni date default (curdate()),
HoraIni time not null,
PrecioDia decimal,
FechaDev date,
constraint alquiler_pk primary key (IdCoche, IdCliente, FechaIni),
constraint alquiler_limite_precio check (PrecioDia > 8.5 and PrecioDia < 200.6),
constraint alquiler_fk_coche foreign key (IdCoche) references Coche(CodCoche)
										on update cascade,
constraint alquiler_fk_cliente foreign key (IdCliente) references Cliente(CodCliente)
										on update cascade
);

describe Coche;
describe Cliente;
describe Alquiler;


/*3*/
alter table coche
drop Color,
add column Nplazas integer,
add column Automatico boolean,
add column Combustible varchar(1),
add constraint check (Combustible in ('G', 'D', 'E', 'H'))
;


/*4*/

insert into coche (Matricula, Marca, Precio, Nplazas, Combustible) values
('4578KHG', 'Peugeot', 15000, 5, 'G'),
('9952BAE', 'Audi A1', 25000, 4, 'G'),
('8000RAE', 'Seat Ibiza', 7000, 5, 'D');

insert into cliente (CodCliente, Nombre, Apellidos, Email) values
('CL001', 'Juan', 'Naranjo Gil', 'jnaranjo@gmail.com'),
('CL002', 'Ana', 'Mena Rojas', NULL),
('CL003', 'Rosa', 'Del Monte Verde', NULL);

select Matricula, Marca, Precio, Nplazas, Combustible from coche;
select CodCliente, Nombre, Apellidos, Email from cliente;

/*5*/
alter table cliente
add column Avalista varchar(5);

alter table cliente
add constraint cliente_avalista foreign key (Avalista) references Cliente(CodCliente)
												on update cascade;

/*6*/
update coche
set FechaMatricula = '2005-06-15'
where Matricula = '4578KHG';

update coche
set FechaMatricula = '2015-06-15'
where Matricula = '4578KHG';

/*7*/
update cliente set Email = NULL where Nombre = 'Ana' or Nombre = 'Rosa';

update cliente
set Email = lcase(concat(Nombre,substr(Apellidos,1,1),'-',year(curdate()),'@gmail.com'))
where Email IS NULL;

/*8*/
insert into Alquileres values
((select codCoche from coche where matricula = '4578KHG'), (select CodCliente from cliente where Nombre = 'Juan'), );

/*9*/
delete from coche
where Combustible = 'D';

/*10*/
rename table
Coche to Coches,
Cliente to Clientes,
Alquiler to Alquileres;


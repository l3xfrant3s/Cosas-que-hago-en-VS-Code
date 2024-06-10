drop database if exists VideoClub;

/*1*/
create database VideoClub;

/*2*/
create table Directores(
CodDirector char(5) primary key,
Nombre varchar(50) not null,
Nacionalidad varchar(30) default 'ESPAÑA'
);

create table Peliculas(
CodPelicula char(5) primary key,
Titulo varchar(100) unique not null,
Año int,
Precio decimal(8,2),
Director char(5),
foreign key (Director) references Directores(CodDirector)
							on update cascade on delete cascade
);

create table Socios(
CodSocio int primary key,
Nombre varchar(50) not null,
Apellidos varchar(50) not null,
TlfMovil varchar(12),
Ciudad varchar(50),
FechaNac date,
Email varchar(50)
);

create table Prestamos(
Socio int,
Peli char(5),
FechaPrestamo date,
foreign key (Peli) references Peliculas(CodPelicula)
                        on update cascade on delete cascade,
foreign key (Socio) references Socios(CodSocio)
				        on update cascade on delete cascade
);

/*3*/
alter table Prestamos add FechaDevolucion date;

/*4*/
insert into Directores
values ('STS01','Steven Spielberg', 'EE.UU'),
('QUE01','Quentin Tarantino', 'ITALIA'),
('PEA01','Pedro Almodóvar', default);

insert into Peliculas
values ('PE001', 'Hable con ella', 2002, 25.00, 'PEA01'),
('PE002', 'Todo sobre mi madre', 1999, 30.00, 'PEA01'),
('PE003', 'Tiburón', 1975, 15.00, 'STS01');

insert into Socios
values (1, 'Armando', 'Guerra García', '689456231', 'Arucas', '1982-10-15', null),
(2, 'Luis', 'Casimiro García', '687452145', 'Telde', '1982-02-12', 'luiscasimiro@gmail.com');

insert into Prestamos
values (1, 'PE001', '2017-06-13', '2017-06-12'),
(1, 'PE002', '2017-06-13', '2017-06-20'),
(2, 'PE003', '2017-05-15', '2017-05-25'),
(2, 'PE002', '2017-03-12', '2017-03-21'); --!!!


/*5*/
update Peliculas set Precio = Precio + 10;

/*6*/
delete from Socios where CodSocio = 2;

/*7*/
select Ciudad, count(*) 'Numero de suministradores'
from suministrador
group by Ciudad
order by count(*) desc, Ciudad asc;

select * from producto
where Color = 'Verde' or Ciudad = 'Madrid';

select snum, snombre, Movil
from suministrador
where email is null;

select v.pnum, pnombre, cantidad
from ventas v join suministrador s on v.snum = s.snum
	join producto p on v.pnum = p.pnum
where snombre = 'Jaime';

select Color, count(*) "Numero de articulos"
from producto
group by Color
having count(*) > 1;

select sum(cantidad) "Total ventas de Antonio"
from ventas v join suministrador s on v.snum = s.snum
where snombre = 'Antonio';
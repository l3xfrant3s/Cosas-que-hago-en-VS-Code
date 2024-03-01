drop database if exists Videoclub;

create database Videoclub;

use Videoclub;

create table Director(
CodDirector int primary key,
Nacionalidad varchar(50) default 'Española',
Nombre varchar(50) not null
);

create table Actor(
CodActor int primary key,
Nacionalidad varchar(50),
Nombre varchar(50) not null,
Sexo varchar(50)
);

create table Pelicula(
CodPelicula int primary key,
Director int,
Titulo varchar(200),
Nacionalidad varchar(50),
Productora varchar(50),
Fecha date,
foreign key (Director) references Director(CodDirector)
							on update cascade
);

create table Reparto(
CodActor int,
CodPelicula int,
Tipo_p varchar(30),
primary key (CodActor,CodPelicula),
foreign key (CodActor) references Actor(CodActor)
							on update cascade,
foreign key (CodPelicula) references Pelicula(CodPelicula)
							on update cascade
);

create table Ejemplar(
Pelicula int,
NumEjemplar int,
primary key(Pelicula, NumEjemplar),
Estado varchar(100),
foreign key (Pelicula) references Pelicula(CodPelicula)
on update cascade on delete cascade
);

create table Socio(
CodSocio int primary key,
CodAvalista int not null,
DNI varchar(10) unique not null,
Nombre varchar (50) not null,
FechaNac date,
Direccion varchar (100),
Telefono varchar (12),
foreign key (CodAvalista) references Socio(CodSocio)
);

create table Prestamo(
IdPeli int,
NumEjemplar int,
CodSocio int,
FechaInicio date default (curdate()),
FechaFinal date,
primary key (IdPeli, NumEjemplar, CodSocio),
foreign key (IdPeli,NumEjemplar)
references Ejemplar(Pelicula,NumEjemplar)
on update cascade on delete cascade,
foreign key (CodSocio) references Socio(CodSocio)
							on update cascade
);
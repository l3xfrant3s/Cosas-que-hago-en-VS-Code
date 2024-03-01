drop database if exists Agencia;

create database Agencia;

use Agencia;

create table Vuelos(
Tipo varchar(6) primary key,
Capacidad int,
Longitud float,
Envergadura float,
Velocidad int
);

create table Aviones(
NumVuelo varchar(6) primary key,
Origen varchar(60),
Destino varchar(60),
HoraSalida time,
TipoAvion varchar(6) unique not null,
foreign key (TipoAvion) references Vuelos(Tipo)
on update cascade on delete cascade
);

create table Reservas(
NumVuelo varchar(6),
FechaSalida datetime,
PlazasLibres int,
primary key (NumVuelo, FechaSalida),
foreign key (NumVuelo) references Aviones(NumVuelo)
on update cascade on delete cascade
);
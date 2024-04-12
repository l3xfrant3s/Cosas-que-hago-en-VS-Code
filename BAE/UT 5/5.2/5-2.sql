/*1*/
create database agenda2019;
/*2*/
create user gerente identified by '123456ZZ$';
grant all on agenda2019.* to gerente;
/*3*/
exit
mysql -u gerente -p
123456ZZ$
select CURRENT_USER;
/*4*/
show grants;
set password for gerente = '1234';
/*5*/
use agenda2019;
create table Contactos(
Cod int primary key,
Nombre varchar(20),
Apellido varchar(40),
email varchar(40),
FechaNac date
);
create table Telefonos(
Cod int,
Telefono varchar(11),
constraint telefonos_pk primary key (Cod, Telefono),
constraint telefonos_fk foreign key (Cod) references Contactos(Cod)
                                                on update cascade
);
/*6*/
create user agente;
create user colega;
grant grant option on *.* to gerente;
/*7*/
grant select(nombre, apellido) on agenda2019.contactos to colega;
grant insert, update, delete on agenda2019.* to agente;
/*8*/
exit
mysql -u colega
use agenda2019;
select nombre, apellido from contactos;

/*9*/
revoke delete on agenda2019.* from agente;
/*10*/
select user from mysql.user;
/*11*/
drop user agente;
drop user colega;
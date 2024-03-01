drop database if exists AgenciaViajes;
#
# DUMP FILE
#
# Database is ported from MS Access
#------------------------------------------------------------------
# Created using "MS Access to MySQL" form http://www.bullzip.com
# Program Version 5.5.282
#
# OPTIONS:
#   sourcefilename=C:/Users/l3xfr/Downloads/Datos_Vuelos.mdb
#   sourceusername=
#   sourcepassword=
#   sourcesystemdatabase=
#   destinationdatabase=AgenciaViajes
#   storageengine=InnoDB
#   dropdatabase=0
#   createtables=1
#   unicode=1
#   autocommit=1
#   transferdefaultvalues=1
#   transferindexes=1
#   transferautonumbers=1
#   transferrecords=1
#   columnlist=1
#   tableprefix=
#   negativeboolean=0
#   ignorelargeblobs=0
#   memotype=LONGTEXT
#   datetimetype=DATETIME
#

CREATE DATABASE IF NOT EXISTS `AgenciaViajes`;
USE `AgenciaViajes`;

#
# Table structure for table 'Aviones'
#

DROP TABLE IF EXISTS `Aviones`;

CREATE TABLE `Aviones` (
  `Tipo` VARCHAR(3), 
  `Nombre` VARCHAR(80), 
  `Capacidad` INTEGER DEFAULT 0, 
  `Longitud` DECIMAL(10,2) DEFAULT 0, 
  `Envergadura` DECIMAL(10,2) DEFAULT 0, 
  `Velocidad` DECIMAL(10,2) DEFAULT 0
) ENGINE=innodb DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'Aviones'
#

INSERT INTO `Aviones` (`Tipo`, `Nombre`, `Capacidad`, `Longitud`, `Envergadura`, `Velocidad`) VALUES ('D9S', 'Div 9 SuperStar', 110, 35.3, 28.5, 815);
INSERT INTO `Aviones` (`Tipo`, `Nombre`, `Capacidad`, `Longitud`, `Envergadura`, `Velocidad`) VALUES ('320', 'B-320 Boeing', 187, 42.15, 32.6, 853);
INSERT INTO `Aviones` (`Tipo`, `Nombre`, `Capacidad`, `Longitud`, `Envergadura`, `Velocidad`) VALUES ('72S', 'Super Boeing Stratojet', 160, 36.2, 25.2, 820);
INSERT INTO `Aviones` (`Tipo`, `Nombre`, `Capacidad`, `Longitud`, `Envergadura`, `Velocidad`) VALUES ('73S', 'Super Jumbo 73', 185, 44.1, 30.35, 815);
INSERT INTO `Aviones` (`Tipo`, `Nombre`, `Capacidad`, `Longitud`, `Envergadura`, `Velocidad`) VALUES ('737', 'Boeing 737', 172, 38.9, 29, 793);
# 5 records

#
# Table structure for table 'Reservas'
#

DROP TABLE IF EXISTS `Reservas`;

CREATE TABLE `Reservas` (
  `NumVuelo` VARCHAR(6), 
  `FechaSalida` DATETIME, 
  `PlazasLibres` INTEGER DEFAULT 0
) ENGINE=innodb DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'Reservas'
#

INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB600', '2006-02-20 00:00:00', 46);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB600', '2006-02-21 00:00:00', 80);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB600', '2006-02-22 00:00:00', 91);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('BA467', '2006-02-20 00:00:00', 32);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('BA467', '2006-02-21 00:00:00', 49);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('BA467', '2006-02-22 00:00:00', 79);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB0640', '2006-02-20 00:00:00', 15);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB0640', '2006-02-21 00:00:00', 21);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB0640', '2006-02-22 00:00:00', 39);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB3709', '2006-02-20 00:00:00', 60);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB3709', '2006-02-21 00:00:00', 72);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB3709', '2006-02-22 00:00:00', 85);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB510', '2006-02-20 00:00:00', 19);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB510', '2006-02-21 00:00:00', 31);
INSERT INTO `Reservas` (`NumVuelo`, `FechaSalida`, `PlazasLibres`) VALUES ('IB510', '2006-02-22 00:00:00', 40);
# 15 records

#
# Table structure for table 'Vuelos'
#

DROP TABLE IF EXISTS `Vuelos`;

CREATE TABLE `Vuelos` (
  `NumVuelo` VARCHAR(6), 
  `Origen` VARCHAR(50), 
  `Destino` VARCHAR(50), 
  `HoraSalida` DATETIME, 
  `TipoAvion` VARCHAR(3)
) ENGINE=innodb DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'Vuelos'
#

INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB600', 'Madrid', 'Londres', '1899-12-30 10:30:00', '320');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('BA467', 'Madrid', 'Londres', '1899-12-30 20:40:00', '73S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB0640', 'Madrid', 'Barcelona', '1899-12-30 06:45:00', '320');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB3742', 'Madrid', 'Barcelona', '1899-12-30 09:15:00', '72S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('LH1349', 'Copenhague', 'Francfort', '1899-12-30 10:20:00', '320');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('AF577', 'Bilbao', 'Paris', '1899-12-30 10:10:00', '737');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB778', 'Barcelona', 'Roma', '1899-12-30 09:45:00', '72S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB3709', 'Dublin', 'Barcelona', '1899-12-30 14:35:00', 'D9S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB721', 'Barcelona', 'Sevilla', '1899-12-30 16:40:00', '72S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB327', 'Madrid', 'Sevilla', '1899-12-30 18:05:00', '72S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB023', 'Madrid', 'Tenerife', '1899-12-30 21:20:00', '72S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB368', 'Malaga', 'Barcelona', '1899-12-30 22:25:00', 'D9S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB610', 'Malaga', 'Londres', '1899-12-30 15:05:00', '73S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB510', 'Sevilla', 'Madrid', '1899-12-30 07:45:00', '72S');
INSERT INTO `Vuelos` (`NumVuelo`, `Origen`, `Destino`, `HoraSalida`, `TipoAvion`) VALUES ('IB318', 'Sevilla', 'Madrid', '1899-12-30 10:45:00', '72S');
# 15 records
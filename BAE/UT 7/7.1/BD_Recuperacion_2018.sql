CREATE DATABASE  IF NOT EXISTS  BD_Recuperacion_2018  
USE  BD_Recuperacion_2018 ;

-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: almacensl
-- ------------------------------------------------------
-- Server version	5.7.10-log

--
-- Table structure for table  producto 
--

DROP TABLE IF EXISTS  producto ;

CREATE TABLE  producto  (
   Pnum  char(5)   NOT NULL DEFAULT '',
   Pnombre  varchar(20)   DEFAULT NULL,
   Color  varchar(20)   DEFAULT NULL,
   Peso  int  DEFAULT NULL,
   Ciudad  varchar(20)   DEFAULT NULL,
   Precio  decimal(8,2) DEFAULT NULL,
   Unidades  int  DEFAULT NULL,
  PRIMARY KEY ( Pnum )
);


--
-- Dumping data for table  producto 
--


INSERT INTO  producto  VALUES ('P1','Tuerca','Rojo',12,'Londres',3.00,1500),('P2','Perno','Verde',17,'Paris',5.00,1300),('P3','Birlo','Azul',17,'Roma',10.00,1400),('P4','Alicates','Rojo',14,'Londres',11.00,2000),('P5','Leva','Azul',12,'Paris',50.00,1400),('P6','Engrane','Rojo',19,'Londres',20.00,1100),('P7','Martillo','Verde',10,'Madrid',10.00,1300),('P8','Torno','Negro',60,'Madrid',90.00,1200),('P9','Pinzas','Rojo',20,'Londres',60.00,1200);


--
-- Table structure for table  suministrador 
--

DROP TABLE IF EXISTS  suministrador ;

CREATE TABLE  suministrador  (
   Snum  char(5)  NOT NULL DEFAULT '',
   Snombre  varchar(20) DEFAULT NULL,
   Situacion  int DEFAULT NULL,
   Ciudad  varchar(20)  DEFAULT NULL,
   FechaContacto  date DEFAULT NULL,
   Movil  char(9) DEFAULT NULL,
   email  varchar(50)  DEFAULT NULL,
  PRIMARY KEY ( Snum )
) ;


--
-- Dumping data for table  suministrador 
--


INSERT INTO  suministrador  VALUES ('S1','Salazar',20,'Londres','2010-02-05','675112224','salazar20@gmail.com'),('S2','Jaime',10,'Paris','2000-10-05','642852123','jaime10@gmail.com'),('S3','Bernal',30,'Paris','2010-01-24','612854125',NULL),('S4','Corona',20,'Londres','1995-05-25','689541254','corona20@gmail.com'),('S5','Aldana',30,'Atenas','2015-10-25','698541236','aldana30@gmail.com'),('S6','Angela',30,'Madrid','2010-10-12','684125366',NULL),('S7','Antonio',10,'Londres','2011-05-03','689541123',NULL);


--
-- Table structure for table  ventas 
--

DROP TABLE IF EXISTS  ventas ;

CREATE TABLE  ventas  (
   Snum  char(5)   NOT NULL DEFAULT '',
   Pnum  char(5)   NOT NULL DEFAULT '',
   Cantidad  int  DEFAULT NULL,
  PRIMARY KEY ( Pnum , Snum )
);

--
-- Dumping data for table  ventas 
--


INSERT INTO  ventas  VALUES ('S1','P1',300),('S2','P1',300),('S7','P1',100),('S1','P2',200),('S2','P2',400),('S3','P2',200),('S4','P2',200),('S7','P2',50),('S1','P3',400),('S3','P3',50),('S1','P4',200),('S4','P4',300),('S7','P4',10),('S1','P5',100),('S1','P6',100),('S1','P7',160),('S1','P8',150),('S2','P8',50);

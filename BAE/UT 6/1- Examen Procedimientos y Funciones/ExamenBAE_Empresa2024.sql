CREATE DATABASE  IF NOT EXISTS `Empresa2024` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Empresa2024`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: examen2018bae
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `Ndep` int NOT NULL,
  `Nombdep` varchar(20) NOT NULL,
  `Ciudad` varchar(20) DEFAULT NULL,
  `jefe` char(10) DEFAULT NULL,
  `Presupuesto` decimal(10,2) DEFAULT '10000.00',
  PRIMARY KEY (`Ndep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (10,'CONTABILIDAD        ','MADRID              ','7566',13850.00),(20,'INVESTIGACION       ','BARCELONA           ','7788',14800.00),(30,'VENTAS              ','SEVILLA             ','7499',40241.25),(40,'OPERACIONES         ','HUELVA              ','7782',13000.00),(50,'MARKETING           ','MADRID              ','7839',16000.00),(60,'PUBLICIDAD','SEVILLA','7698',13000.00),(70,'RECURSOS HUMANOS','MADRID','7001',15100.00);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `Nemp` char(10) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Empleo` varchar(20) NOT NULL,
  `FechaIng` date DEFAULT NULL,
  `Supervs` char(10) DEFAULT NULL,
  `Salario` decimal(8,2) DEFAULT NULL,
  `Ndep` int DEFAULT NULL,
  `Comision` decimal(8,2) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Nemp`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  KEY `Ndep` (`Ndep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('7329','JUAN                ','PADRON','OFICINISTA          ','1995-12-17','7902',950.00,20,NULL,'juan7329@gmail.com'),('7499','ANTONIO             ','OROZCO','VENDEDOR            ','2008-01-20','7698',1600.00,30,300.00,'antonio7499@hotmail.com'),('7521','PEDRO               ','SANCHEZ','VENDEDOR            ','2004-01-22','7698',1250.00,30,0.00,'pedro7521@gmail.com'),('7566','CARLOS              ','BAUTE','GERENTE             ','2000-06-09','7839',2975.00,20,NULL,'carlos7566@yahoo.es'),('7654','JESUS               ','VAZQUEX','VENDEDOR            ','1995-09-28','7698',850.00,30,200.00,'jesus7654@gmail.com'),('7698','MARCOS              ','CUADRADOS','GERENTE             ','2005-05-01','7839',2850.00,30,NULL,'marcosito7698@hotmail.com'),('7771','ANDRES','PAJARES','OFICINISTA','2018-02-21',NULL,NULL,20,NULL,'andres7771@ieselrincon.org'),('7782','JORGE               ','LORENZO','GERENTE             ','2000-06-09','7839',2450.00,10,NULL,'jorge7782@hotmail.com'),('7788','MANUEL              ','GOMEZ','ANALISTA            ','1989-12-09','7566',3000.00,20,NULL,'manuel7788@yahoo.es'),('7839','SIMEON              ','RODRIGUEZ','PRESIDENTE          ','1997-11-17',NULL,5000.00,10,NULL,'simeon7839@yahoo.es'),('7844','LUIS                ','FONSI','VENDEDOR            ','2002-09-07','7698',1500.00,30,0.00,'luis7844@hotmail.com'),('7876','JOSE                ','CORONADO','VENDEDOR','1983-01-12','7566',1300.00,20,150.00,'jose7876@gmail.com'),('7900','JAVIER              ','CAMARA','OFICINISTA          ','2003-12-03','7698',1300.00,30,NULL,'javier7900@gmail.com'),('7902','SANTOS              ','GOMEZ','ANALISTA            ','2002-12-03','7566',3000.00,20,NULL,'santos7902@gmail.com'),('7934','TOMAS               ','MORALES','VENDEDOR','2002-03-23','7782',900.00,10,NULL,'tomas7934@gmail.com'),('8000','MARTA','SANCHEZ','GERENTE','2017-01-15','7788',2200.00,10,NULL,'marta8000@yahoo.es'),('AM20240523','AMANDA','GARCÍA','VENDEDOR','2024-05-18','7698',1233.33,30,NULL,'amanda2024.ventas@gmail.com'),('GE20240530','GENARO','GARCIA','ANALISTA','2024-05-17','7698',3000.00,30,NULL,'genaro2024.ventas@gmail.com'),('OS20240516','OSCAR','MAYER','ANALISTA','2024-05-17','7839',3000.00,50,NULL,'oscar2024.marketing@gmail.com');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-18 16:31:52

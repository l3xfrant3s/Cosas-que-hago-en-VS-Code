CREATE DATABASE  IF NOT EXISTS `bd_colegio_Examen` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_colegio_Examen`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_colegio_Examen
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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `CodAlum` int NOT NULL,
  `DNI` varchar(12) DEFAULT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `FechaNac` date DEFAULT NULL,
  `Municipio` varchar(50) DEFAULT 'LAS PALMAS G.C.',
  `Telefono` varchar(20) DEFAULT NULL,
  `Repetidor` char(2) DEFAULT 'NO',
  PRIMARY KEY (`CodAlum`),
  UNIQUE KEY `DNI` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'11223344A','MARCOS','BATISTA','2002-10-12','TEROR','678145211','SI'),(2,'66778899B','JUAN','GONZALEZ','1997-02-10','ARUCAS','622145784','NO'),(3,'45678912C','LUIS','PEREZ','1999-03-01','TELDE','689874125','SI'),(4,'11663344G','ANA','SANTANA','2001-10-12','GALDAR',NULL,'SI'),(5,'44558899H','ANDRES','PEREZ','1991-10-25','TELDE',NULL,'SI'),(6,'33221144H','FERNANDO','ALONSO','2002-03-10','ARUCAS','689257144','NO'),(7,'23456789J','AMANDA','ORTEGA','1989-05-10','GALDAR',NULL,'SI'),(8,'12345678X','JAVIER','CAMARA','2002-05-10','ARUCAS','698526388','SI'),(9,'58252525A','ROSA','GARCIA','1996-08-03','ARUCAS',NULL,'SI'),(10,'44994488S','ANGEL','BUENO','1989-05-13','TEROR','658747855','NO'),(11,'68295841K','CARLOS','BATISTA','2002-05-11','TEROR','698574122','NO'),(12,'45874521K','JUAN','BATISTA','1992-05-12','LAS PALMAS G.C.','625145788','SI'),(13,'78214250S','MARCOS','CUADRADO','2000-05-22','AGAETE',NULL,'NO'),(14,'45785425D','LUIS','ALONSO','1998-02-12','LAS PALMAS G.C.','625478255','SI'),(15,'33665544R','MARCOS','GONZALEZ','2002-01-01','ARUCAS',NULL,'SI');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulos`
--

DROP TABLE IF EXISTS `modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modulos` (
  `CodMod` varchar(5) NOT NULL,
  `Siglas` char(3) NOT NULL,
  `Titulo` varchar(100) NOT NULL,
  `NHoras` int DEFAULT NULL,
  `Profe` int DEFAULT NULL,
  PRIMARY KEY (`CodMod`),
  KEY `Profe` (`Profe`),
  CONSTRAINT `modulos_ibfk_1` FOREIGN KEY (`Profe`) REFERENCES `profesor` (`CodProfe`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulos`
--

LOCK TABLES `modulos` WRITE;
/*!40000 ALTER TABLE `modulos` DISABLE KEYS */;
INSERT INTO `modulos` VALUES ('M1','BAE','Bases de Datos',192,1),('M10','PRJ','Proyecto',90,NULL),('M2','SSF','Sistemas Informáticos',140,2),('M3','LND','Lenguajes de Marcas',120,5),('M4','PRO','Programación',256,3),('M5','FOL','Formación y Orientación Laboral',60,4),('M6','ETS','Entornos de Desarrollo',90,3),('M7','LNT','Inglés',60,6),('M8','SGF','Seguridad',125,NULL),('M9','RDE','Redes de Ordenadores',60,NULL);
/*!40000 ALTER TABLE `modulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notas` (
  `CodAlum` int NOT NULL,
  `CodMod` varchar(5) NOT NULL,
  `Nota` int DEFAULT NULL,
  PRIMARY KEY (`CodAlum`,`CodMod`),
  KEY `CodMod` (`CodMod`),
  CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`CodAlum`) REFERENCES `alumnos` (`CodAlum`) ON UPDATE CASCADE,
  CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`CodMod`) REFERENCES `modulos` (`CodMod`) ON UPDATE CASCADE,
  CONSTRAINT `notas_chk_1` CHECK ((`Nota` between 0 and 10))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES (1,'M1',7),(1,'M2',6),(1,'M3',7),(1,'M4',7),(1,'M5',8),(1,'M6',9),(1,'M7',5),(2,'M1',4),(2,'M2',5),(2,'M3',3),(2,'M4',3),(2,'M5',1),(2,'M6',6),(2,'M7',8),(3,'M1',7),(3,'M2',1),(3,'M3',5),(3,'M4',3),(3,'M5',4),(3,'M6',9),(3,'M7',7),(4,'M1',3),(4,'M2',6),(4,'M3',9),(4,'M4',8),(4,'M5',9),(4,'M6',10),(4,'M7',6),(5,'M1',8),(5,'M2',2),(5,'M3',7),(5,'M4',1),(5,'M5',4),(5,'M6',9),(5,'M7',2),(6,'M1',9),(6,'M2',6),(6,'M3',8),(6,'M4',10),(6,'M5',10),(6,'M6',9),(6,'M7',8),(7,'M1',5),(7,'M2',2),(7,'M3',1),(7,'M4',3),(7,'M5',3),(7,'M6',6),(8,'M1',9),(8,'M2',3),(8,'M3',8),(8,'M5',6),(8,'M6',9),(8,'M7',9),(9,'M2',2),(9,'M4',6),(9,'M6',10),(9,'M7',2),(10,'M1',9),(10,'M2',6),(10,'M3',9),(10,'M4',10),(10,'M5',9),(10,'M6',9),(10,'M7',4),(11,'M1',8),(11,'M2',9),(11,'M3',10),(11,'M4',2),(11,'M5',8),(11,'M6',9),(12,'M1',5),(12,'M2',8),(12,'M3',3),(12,'M4',5),(12,'M5',7),(12,'M6',7),(12,'M7',4),(13,'M1',10),(13,'M2',10),(13,'M3',9),(13,'M4',10),(13,'M5',8),(13,'M6',10),(13,'M7',10),(14,'M1',5),(14,'M2',6),(14,'M5',5),(14,'M7',4),(15,'M1',1),(15,'M4',4),(15,'M7',3);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `CodProfe` int NOT NULL,
  `Nif` char(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Sueldo` decimal(8,2) DEFAULT '1500.00',
  `email` varchar(100) DEFAULT NULL,
  `FechaIngreso` date DEFAULT NULL,
  PRIMARY KEY (`CodProfe`),
  UNIQUE KEY `Nif` (`Nif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'11234654R','Carlos','Ojeda',1500.00,'carojeda@elrincon.org','2006-09-01'),(2,'44554566H','Jose Juan','Rodríguez',1800.00,'jjrodri@hotmail.com','1996-09-01'),(3,'66677312F','Miguel','Hernández',2200.00,'miguelher@elrincon.org','1992-09-01'),(4,'17898654Y','Maria del Sol','García',2100.00,'marisol@gobcanarias.org','2015-09-01'),(5,'11447789P','Ermis','Papakonstantiniou',2200.00,'ermis@gmail.com','2010-09-01'),(6,'22445577F','María Rosa','Marrero',1700.00,'rosamarre@elrincon.org','2018-09-01');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-07 20:13:09

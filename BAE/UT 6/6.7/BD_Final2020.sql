CREATE DATABASE  IF NOT EXISTS `final2020` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `final2020`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: final2020
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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `Pnum` char(5) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Pnombre` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `Color` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `Peso` int DEFAULT NULL,
  `Ciudad` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `Precio` decimal(8,2) DEFAULT NULL,
  `Unidades` int DEFAULT NULL,
  PRIMARY KEY (`Pnum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('P1','Tuerca','Rojo',12,'Londres',3.00,1500),('P10','Metro','Rojo',60,'Madrid',10.00,1200),('P11','Bombilla','Negro',60,'Sevilla',2.00,3000),('P12','Rodillo','Negro',60,'Madrid',6.00,20),('P13','Cuchara','Rojo',20,'Londres',40.00,1800),('P2','Perno','Verde',17,'Paris',5.00,1300),('P3','Birlo','Azul',17,'Roma',10.00,1400),('P4','Alicates','Rojo',14,'Londres',11.00,2000),('P5','Leva','Azul',12,'Paris',50.00,1400),('P6','Engrane','Rojo',19,'Londres',20.00,1100),('P7','Martillo','Verde',10,'Madrid',10.00,1300),('P8','Torno','Negro',60,'Londres',90.00,1200),('P9','Sierra','Azul',60,'Malaga',20.00,1000);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productosbajostock`
--

DROP TABLE IF EXISTS `productosbajostock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productosbajostock` (
  `Pnum` char(5) COLLATE latin1_general_ci NOT NULL,
  `Pnombre` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `UnidadesRestantes` int DEFAULT NULL,
  `FechaPedido` date DEFAULT NULL,
  PRIMARY KEY (`Pnum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productosbajostock`
--

LOCK TABLES `productosbajostock` WRITE;
/*!40000 ALTER TABLE `productosbajostock` DISABLE KEYS */;
INSERT INTO `productosbajostock` VALUES ('P12','Rodillo',20,'2020-06-04');
/*!40000 ALTER TABLE `productosbajostock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suministrador`
--

DROP TABLE IF EXISTS `suministrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suministrador` (
  `Snum` char(5) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Snombre` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `Situacion` tinyint DEFAULT NULL,
  `Ciudad` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `FechaContacto` date DEFAULT NULL,
  `Movil` char(9) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`Snum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suministrador`
--

LOCK TABLES `suministrador` WRITE;
/*!40000 ALTER TABLE `suministrador` DISABLE KEYS */;
INSERT INTO `suministrador` VALUES ('S1','Salazar',20,'Londres','2010-02-05','675112224','salazar20@gmail.com'),('S10','Armando',30,'Roma','2019-05-12','625125145','armando30@gmail.com'),('S2','Jaime',10,'Paris','2000-10-05','642852123','jaime10@gmail.com'),('S3','Bernal',30,'Paris','2010-01-24','612854125',NULL),('S4','Corona',20,'Londres','1995-05-25','689541254','corona20@gmail.com'),('S5','Aldana',30,'Atenas','2015-10-25','698541236','aldana30@gmail.com'),('S6','Angela',30,'Madrid','2010-10-12','684125366',NULL),('S7','Antonio',10,'Londres','2011-05-03','689541123',NULL),('S8','Andres',30,'Atenas','2010-10-10','689854741','andres30@gmail.com'),('S9','Javier',10,'Madrid','2015-06-12','645785144',NULL);
/*!40000 ALTER TABLE `suministrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `Snum` char(5) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Pnum` char(5) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `Cantidad` int DEFAULT NULL,
  PRIMARY KEY (`Pnum`,`Snum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES ('S1','P1',300),('S2','P1',300),('S7','P1',100),('S8','P1',50),('S9','P1',200),('S10','P10',100),('S1','P12',20),('S1','P2',200),('S2','P2',400),('S3','P2',200),('S4','P2',200),('S7','P2',50),('S1','P3',400),('S3','P3',50),('S1','P4',200),('S4','P4',300),('S7','P4',10),('S1','P5',100),('S1','P6',100),('S1','P7',160),('S8','P7',10),('S1','P8',150),('S2','P8',50);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-05  0:23:05

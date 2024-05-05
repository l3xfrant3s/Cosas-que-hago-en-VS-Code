CREATE DATABASE  IF NOT EXISTS `Simulacro` ;
USE `Simulacro`;


--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;

CREATE TABLE `departamento` (
  `Ndep` int(11) NOT NULL,
  `Nombdep` varchar(20) NOT NULL,
  `Ciudad` varchar(20) DEFAULT NULL,
  `Jefe` int(11) DEFAULT NULL,
  `Presupuesto` decimal(10,2) DEFAULT '10000.00',
  PRIMARY KEY (`Ndep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `departamento`
--

INSERT INTO `departamento` VALUES (10,'CONTABILIDAD','MADRID',7566,10000.00),
(20,'INVESTIGACION','BARCELONA',7788,10000.00),
(30,'VENTAS','SEVILLA',7499,10000.00),
(40,'OPERACIONES','HUELVA',7782,10000.00),
(50,'MARKETING','MADRID',7839,10000.00),
(60,'PUBLICIDAD','SEVILLA',7698,10000.00),
(70,'RECURSOS HUMANOS','MADRID',7001,10000.00);

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;

CREATE TABLE `empleado` (
  `Nemp` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Empleo` varchar(20) NOT NULL,
  `FechaIng` date DEFAULT NULL,
  `Supervs` int(11) DEFAULT NULL,
  `Salario` decimal(8,2) DEFAULT NULL,
  `Ndep` int(11) DEFAULT NULL,
  `Comision` decimal(8,2) DEFAULT NULL,
  `Email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Nemp`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  KEY `Ndep` (`Ndep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `empleado` VALUES (7001,'ANA','GIL','GERENTE','2010-04-15',7839,2100.00,70,NULL,NULL),
(7002,'LAURA','PAUSINI','OFICINISTA','2012-01-12',7566,850.00,10,NULL,NULL),
(7003,'MARIA','BOLAÑOS','VENDEDOR','2015-05-10',7566,900.00,20,250.00,NULL),
(7329,'JUAN','PADRON','OFICINISTA','1995-12-17',7902,900.00,20,NULL,'juan7329@gmail.com'),
(7499,'ANTONIO','OROZCO','VENDEDOR','2008-01-20',7698,1600.00,30,300.00,'antonio7499@hotmail.com'),
(7521,'PEDRO','SANCHEZ','VENDEDOR','2004-01-22',7698,1250.00,30,0.00,'pedro7521@gmail.com'),
(7566,'CARLOS','BAUTE','GERENTE','2002-04-23',7839,2975.00,20,NULL,'carlos7566@yahoo.es'),
(7654,'JESUS','VAZQUEX','VENDEDOR','1995-09-28',7698,850.00,30,200.00,'jesus7654@gmail.com'),
(7698,'MARCOS','CUADRADOS','GERENTE','2005-05-01',7839,2850.00,30,NULL,'marcosito7698@hotmail.com'),
(7771,'ANDRES','PAJARES','OFICINISTA','2018-02-21',NULL,2400.00,20,NULL,NULL),
(7782,'JORGE','LORENZO','GERENTE','2000-06-09',7839,2450.00,10,NULL,'jorge7782@hotmail.com'),
(7788,'MANUEL','GOMEZ','ANALISTA','1989-12-09',7566,3000.00,20,NULL,'manuel7788@yahoo.es'),
(7839,'SIMEON','RODRIGUEZ','PRESIDENTE','1997-11-17',NULL,5000.00,10,NULL,'simeon7839@yahoo.es'),
(7844,'LUIS','FONSI','VENDEDOR','2002-09-07',7698,1500.00,30,0.00,'luis7844@hotmail.com'),
(7876,'JOSE','CORONADO','VENDEDOR','1983-01-12',7566,1300.00,20,150.00,'jose7876@gmail.com'),
(7900,'JAVIER','CAMARA','OFICINISTA','2003-12-03',7698,1300.00,30,NULL,'javier7900@gmail.com'),
(7902,'SANTOS','GOMEZ','ANALISTA','2002-12-03',7566,3000.00,20,NULL,'santos7902@gmail.com'),
(7934,'TOMAS','MORALES','VENDEDOR','2002-03-23',7782,900.00,10,NULL,'tomas7934@gmail.com'),
(7999,'CARMEN','JIMENEZ','ANALISTA','2008-05-15',7566,1500.00,70,NULL,NULL),
(8000,'MARTA','SANCHEZ','GERENTE','2017-01-15',7788,2200.00,10,NULL,'marta8000@yahoo.es');



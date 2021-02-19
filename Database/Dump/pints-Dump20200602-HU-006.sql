-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: pints
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `base`
--

DROP TABLE IF EXISTS `base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `base` (
  `idBase` int(11) NOT NULL AUTO_INCREMENT,
  `base` varchar(150) DEFAULT NULL,
  `costo` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`idBase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base`
--

LOCK TABLES `base` WRITE;
/*!40000 ALTER TABLE `base` DISABLE KEYS */;
/*!40000 ALTER TABLE `base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `color` (
  `idColor` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(7) DEFAULT NULL,
  `costo` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`idColor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDepartamento` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(150) DEFAULT NULL,
  `costo` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pintura`
--

DROP TABLE IF EXISTS `pintura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pintura` (
  `idPintura` int(11) NOT NULL AUTO_INCREMENT,
  `stock` int(11) DEFAULT NULL,
  `cantMaxima` int(11) DEFAULT NULL,
  `existencia` int(11) DEFAULT NULL,
  `precio` decimal(18,2) DEFAULT NULL,
  `estado` enum('Disponible','No Disponible') DEFAULT NULL,
  `color` int(11) DEFAULT NULL,
  `presentacion` int(11) DEFAULT NULL,
  `marca` int(11) DEFAULT NULL,
  `base` int(11) DEFAULT NULL,
  `newDataDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPintura`),
  KEY `fkColor` (`color`),
  KEY `fkPresentacion` (`presentacion`),
  KEY `fkMarca` (`marca`),
  KEY `fkBase` (`base`),
  CONSTRAINT `fkBase` FOREIGN KEY (`base`) REFERENCES `base` (`idbase`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkColor` FOREIGN KEY (`color`) REFERENCES `color` (`idcolor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkMarca` FOREIGN KEY (`marca`) REFERENCES `marca` (`idmarca`) ON UPDATE CASCADE,
  CONSTRAINT `fkPresentacion` FOREIGN KEY (`presentacion`) REFERENCES `presentacion` (`idpresentacion`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pintura`
--

LOCK TABLES `pintura` WRITE;
/*!40000 ALTER TABLE `pintura` DISABLE KEYS */;
/*!40000 ALTER TABLE `pintura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presentacion`
--

DROP TABLE IF EXISTS `presentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `presentacion` (
  `idPresentacion` int(11) NOT NULL AUTO_INCREMENT,
  `presentacion` varchar(150) DEFAULT NULL,
  `costo` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`idPresentacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presentacion`
--

LOCK TABLES `presentacion` WRITE;
/*!40000 ALTER TABLE `presentacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `presentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporte`
--

DROP TABLE IF EXISTS `reporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reporte` (
  `idReporte` int(11) NOT NULL AUTO_INCREMENT,
  `supervisor` int(11) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  `fechaReporte` date DEFAULT NULL,
  `detalleReporte` text,
  `destinatarioReporte` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idReporte`),
  KEY `fkDepartamento` (`departamento`),
  KEY `fkSupervisor` (`supervisor`),
  CONSTRAINT `fkDepartamento` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`iddepartamento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkSupervisor` FOREIGN KEY (`supervisor`) REFERENCES `supervisor` (`idsupervisor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporte`
--

LOCK TABLES `reporte` WRITE;
/*!40000 ALTER TABLE `reporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `reporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisor`
--

DROP TABLE IF EXISTS `supervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supervisor` (
  `idSupervisor` int(11) NOT NULL AUTO_INCREMENT,
  `nombreSupervisor` varchar(50) DEFAULT NULL,
  `apellidoSupervisor` varchar(50) DEFAULT NULL,
  `correoSupervisor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idSupervisor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisor`
--

LOCK TABLES `supervisor` WRITE;
/*!40000 ALTER TABLE `supervisor` DISABLE KEYS */;
/*!40000 ALTER TABLE `supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pints'
--

--
-- Dumping routines for database 'pints'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-02 12:11:26

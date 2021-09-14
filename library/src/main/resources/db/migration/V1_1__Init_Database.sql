-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `idbook` int(11) NOT NULL,
  `idUser` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `idFile` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbook`),
  UNIQUE KEY `idbook_UNIQUE` (`idbook`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `borrow` (
  `idBorrow` int(11) NOT NULL,
  `idBook` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idBorrow`),
  UNIQUE KEY `idBorrow_UNIQUE` (`idBorrow`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrowdetail`
--

DROP TABLE IF EXISTS `borrowdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `borrowdetail` (
  `idDetail` varchar(36) COLLATE utf8_bin NOT NULL,
  `idBorrow` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `idUser` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `quatity` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDetail`),
  UNIQUE KEY `idDetail_UNIQUE` (`idDetail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowdetail`
--

LOCK TABLES `borrowdetail` WRITE;
/*!40000 ALTER TABLE `borrowdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrowdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `idCate` varchar(36) COLLATE utf8_bin NOT NULL,
  `name` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `idBook` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idCate`),
  UNIQUE KEY `idCate_UNIQUE` (`idCate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `file` (
  `idfile` int(11) NOT NULL,
  `type` enum('0','1') COLLATE utf8_bin DEFAULT NULL,
  `parentType` int(11) DEFAULT NULL,
  `parentId` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idfile`),
  UNIQUE KEY `idfile_UNIQUE` (`idfile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `idUser` varchar(36) COLLATE utf8_bin NOT NULL,
  `userName` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `passWord` varchar(2048) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `numberPhone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `role` enum('user','admin') COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-11 14:13:45

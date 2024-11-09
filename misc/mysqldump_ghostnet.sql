-- MySQL dump 10.13  Distrib 9.1.0, for Linux (aarch64)
--
-- Host: localhost    Database: ghostnet
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Ghostnet`
--

DROP TABLE IF EXISTS `Ghostnet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ghostnet` (
  `estimatedSize` float NOT NULL,
  `id` int NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `reporterName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `retrieving_person_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7t74anb61ist389a74gj03l8x` (`retrieving_person_id`),
  CONSTRAINT `FK7t74anb61ist389a74gj03l8x` FOREIGN KEY (`retrieving_person_id`) REFERENCES `Person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ghostnet`
--

LOCK TABLES `Ghostnet` WRITE;
/*!40000 ALTER TABLE `Ghostnet` DISABLE KEYS */;
INSERT INTO `Ghostnet` VALUES (50,402,49.1231233,8.1231231,'FHek','Geborgen',1),(20,403,10.22,20.12,'Maxi','Bergung bevorstehend',2),(30,404,50,80,'Someone','Gemeldet',NULL);
/*!40000 ALTER TABLE `Ghostnet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ghostnet_SEQ`
--

DROP TABLE IF EXISTS `Ghostnet_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ghostnet_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ghostnet_SEQ`
--

LOCK TABLES `Ghostnet_SEQ` WRITE;
/*!40000 ALTER TABLE `Ghostnet_SEQ` DISABLE KEYS */;
INSERT INTO `Ghostnet_SEQ` VALUES (551);
/*!40000 ALTER TABLE `Ghostnet_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Person` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phoneNumber` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `surname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,'Karl Felix','+491721112222','Heinke'),(2,'Admin','12345678','User');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-09 10:40:38

-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: BWS
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `department` varchar(45) NOT NULL,
  `phoneExtension` int(9) NOT NULL,
  `cellPhone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `employeeId_UNIQUE` (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'Mickey','Mouse','shipping',334,'6085551212'),(4,'Mike','Johnson','office',337,'6085551215'),(5,'Bob','Wilson','delivery',338,'6085551216'),(6,'Arnie','Soommy','filling',339,'6085551217'),(7,'Linda','Aspen','hydrotest',340,'6085551218'),(8,'Maggie','Marles','shipping',341,'6085551219'),(9,'Melissa','Johnston','store',342,'6085551220'),(10,'Rhonda','Johnson','warehouse',343,'6085551221'),(11,'Rosie','Mouse','office',344,'6085551222'),(12,'Scott','Jones','delivery',345,'6085551223'),(13,'Phoenix','Smith','filling',346,'6085551224'),(14,'Mickey','Johnson','hydrotest',347,'6085551225'),(15,'Sue','Wilson','shipping',348,'6085551226'),(16,'Jane','Soommy','store',349,'6085551227'),(17,'Mike','Aspen','warehouse',350,'6085551228'),(18,'Bob','Marles','office',351,'6085551229'),(19,'Arnie','Johnston','delivery',352,'6085551230'),(22,'Melissa','Jones','shipping',355,'6085551233'),(24,'Rosie','Johnson','warehouse',357,'6085551235'),(25,'Scott','Wilson','office',358,'6085551236'),(26,'Phoenix','Soommy','delivery',359,'6085551237'),(27,'Mickey','Aspen','filling',360,'6085551238'),(29,'Jane','Johnston','shipping',362,'6085551240'),(31,'Bob','Mouse','warehouse',364,'6085551242'),(32,'Arnie','Jones','office',365,'6085551243'),(33,'Linda','Smith','delivery',366,'6085551244'),(34,'Maggie','Johnson','filling',367,'6085551245'),(35,'Melissa','Wilson','hydrotest',368,'6085551246'),(36,'Rhonda','Soommy','shipping',369,'6085551247'),(37,'Rosie','Aspen','store',370,'6085551248'),(39,'Phoenix','Johnston','office',372,'6085551250'),(43,'Phoenix','Hundt','president',998,'6085551212'),(44,'Phoenix','Hundt','president',997,'6085551212'),(45,'Phoenix','Hundt','president',997,'6085551212'),(46,'Phoenix','Hundt','president',997,'6085551212'),(47,'Phoenix','Hundt','president',997,'6085551212'),(48,'Phoenix','Hundt','president',997,'6085551212'),(49,'Phoenix','Hundt','president',997,'6085551212'),(62,'Phoenix','Hundt','president',997,'6085551212'),(63,'Phoenix','Hundt','president',997,'6085551212'),(64,'Phoenix','Johnson','president',997,'6085551212'),(65,'Phoenix','Johnson','president',997,'6085551212'),(66,'Phoenix','Hundt','president',997,'6085551212'),(67,'Phoenix','Hundt','president',997,'6085551212'),(68,'Phoenix','Hundt','president',997,'6085551212'),(71,'Phoenix','Sally','president',997,'6085551212'),(72,'Phoenix','Sally','president',997,'6085551212'),(73,'Erin','Mairs','office',134,'6089991212'),(74,'Sue','Super','queen',444,'8887776666');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-29 19:59:55

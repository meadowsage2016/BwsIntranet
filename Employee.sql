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
  `emailAddress` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `employeeId_UNIQUE` (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (2,'Maggie','Pecher','IT',124,'6085551112','maggie@badgerwelding.com'),(3,'Melissa','Benz','Accts Payable',136,'6085551113','melissa@badgerwelding.com'),(4,'Erin','Mairs','Office',134,'6085551114','erin@badgerwelding.com'),(5,'Linda','Strieff','Office',122,'6085551115','linda@badgerwelding.com'),(6,'Rosie','Ortiz','Office',101,'6085551116','rosie@badgerwelding.com'),(7,'Rhonda','Weidenbeck','Office',123,'6085551117','rhonda@badgerwelding.com'),(8,'Dave','Brunker','Plant',135,'6085551118','dave@badgerwelding.com'),(9,'Rick','Maiers','Sales',105,'6085551119','rick@badgerwelding.com'),(10,'Paul','Kemnitzer','Sales',137,'6085551120','paul@badgerwelding.com'),(11,'Fred','Lawingers','Sales',107,'6085551121','fred@badgerwelding.com'),(12,'Don','Ward','IT',666,'6081115555','don@badgerwelding.com'),(14,'Henry','Ford','IT',999,'6085551111','henry@madisoncollege.edu'),(15,'SEEEE','Johnson','IT',123,'6088887878','sue@madisoncollege.edu'),(16,'Erin','M','Office',135,'6085551212','erin@yahoo.com'),(17,'Jill','Amevda','Office',555,'6081112121','jill@badgerwelding.com'),(18,'Loppy','Doopy','Office',144,'6085551212','loopy@yahoo.com');
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

-- Dump completed on 2017-05-07 20:47:22

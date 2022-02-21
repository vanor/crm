-- MySQL dump 10.13  Distrib 5.7.37, for Linux (x86_64)
--
-- Host: localhost    Database: crm
-- ------------------------------------------------------
-- Server version	5.7.37-0ubuntu0.18.04.1

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about_us` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `contact_email` varchar(255) NOT NULL,
  `contact_name` varchar(255) NOT NULL,
  `contact_phone_number` varchar(255) NOT NULL,
  `line_1` varchar(255) NOT NULL,
  `line2` varchar(255) DEFAULT NULL,
  `line3` varchar(255) DEFAULT NULL,
  `local_authority` varchar(255) NOT NULL,
  `logo_link` text NOT NULL,
  `name` text NOT NULL,
  `postal_code` varchar(255) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answerstage1`
--

DROP TABLE IF EXISTS `answerstage1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answerstage1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `value` text NOT NULL,
  `companyid` bigint(20) DEFAULT NULL,
  `questionid` bigint(20) DEFAULT NULL,
  `editor_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7c5l65m3c216f7igudf6jwjeq` (`companyid`),
  KEY `FKml0u1qp3l1l18ihfnt2pohcwa` (`questionid`),
  KEY `FKcf20qoxaxurh987wfidu015rr` (`editor_user_id`),
  CONSTRAINT `FK7c5l65m3c216f7igudf6jwjeq` FOREIGN KEY (`companyid`) REFERENCES `company` (`id`),
  CONSTRAINT `FKcf20qoxaxurh987wfidu015rr` FOREIGN KEY (`editor_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKml0u1qp3l1l18ihfnt2pohcwa` FOREIGN KEY (`questionid`) REFERENCES `questionstage1` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answerstage1`
--

LOCK TABLES `answerstage1` WRITE;
/*!40000 ALTER TABLE `answerstage1` DISABLE KEYS */;
INSERT INTO `answerstage1` VALUES (1,NULL,NULL,NULL,'Comp1',1,1,NULL),(2,NULL,NULL,NULL,'2012',1,2,NULL),(3,NULL,NULL,NULL,'2',1,3,NULL),(4,NULL,NULL,NULL,'aTurn',1,4,NULL),(5,NULL,NULL,NULL,'aLoc',1,5,NULL),(6,NULL,NULL,NULL,'aTrade',1,6,NULL),(7,NULL,NULL,NULL,'aSector',1,7,NULL),(8,NULL,NULL,NULL,'namesDirectors',1,8,NULL),(9,NULL,NULL,NULL,'otherNames',1,9,NULL),(10,NULL,NULL,NULL,'1',1,10,NULL),(11,NULL,NULL,NULL,'a Finance comment',1,11,NULL),(12,NULL,NULL,NULL,'2',1,12,NULL),(13,NULL,NULL,NULL,'an Equipment comment',1,13,NULL),(14,NULL,NULL,NULL,'3',1,14,NULL),(15,NULL,NULL,NULL,'a Training comment',1,15,NULL),(16,NULL,NULL,NULL,'',1,16,NULL),(17,NULL,NULL,NULL,'',1,17,NULL),(18,NULL,NULL,NULL,'',1,18,NULL),(19,NULL,NULL,NULL,'',1,19,NULL),(20,NULL,NULL,NULL,'',1,20,NULL),(21,NULL,NULL,NULL,'',1,21,NULL),(22,NULL,NULL,NULL,'',1,22,NULL),(23,NULL,NULL,NULL,'',1,23,NULL),(24,NULL,NULL,NULL,'',1,24,NULL),(25,NULL,NULL,NULL,'',1,25,NULL),(26,NULL,NULL,NULL,'',1,26,NULL),(27,NULL,NULL,NULL,'',1,27,NULL),(28,NULL,NULL,NULL,'',1,28,NULL),(29,NULL,NULL,NULL,'',1,29,NULL),(30,NULL,NULL,NULL,'',1,30,NULL),(31,NULL,NULL,NULL,'',1,31,NULL),(32,NULL,NULL,NULL,'',1,32,NULL),(33,NULL,NULL,NULL,'',1,33,NULL),(34,NULL,NULL,NULL,'',1,34,NULL),(35,NULL,NULL,NULL,'company2',2,1,NULL),(36,NULL,NULL,NULL,'4',2,10,NULL),(37,NULL,NULL,NULL,'5',2,12,NULL),(38,NULL,NULL,NULL,'6',2,14,NULL);
/*!40000 ALTER TABLE `answerstage1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answerstage2`
--

DROP TABLE IF EXISTS `answerstage2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answerstage2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `value` text NOT NULL,
  `companyid` bigint(20) DEFAULT NULL,
  `questionid` bigint(20) DEFAULT NULL,
  `editor_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4yfgm5p0dgq95gfvlxrosl0gg` (`companyid`),
  KEY `FKlqaabre6qkruopaivijbgiol6` (`questionid`),
  KEY `FKb0gb1qx0r2s4127nanfohw2u4` (`editor_user_id`),
  CONSTRAINT `FK4yfgm5p0dgq95gfvlxrosl0gg` FOREIGN KEY (`companyid`) REFERENCES `company` (`id`),
  CONSTRAINT `FKb0gb1qx0r2s4127nanfohw2u4` FOREIGN KEY (`editor_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKlqaabre6qkruopaivijbgiol6` FOREIGN KEY (`questionid`) REFERENCES `questionstage2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answerstage2`
--

LOCK TABLES `answerstage2` WRITE;
/*!40000 ALTER TABLE `answerstage2` DISABLE KEYS */;
INSERT INTO `answerstage2` VALUES (1,NULL,NULL,NULL,'yes',2,26,NULL),(2,NULL,NULL,NULL,'ship; road',2,30,NULL),(3,NULL,NULL,NULL,'KG',2,35,NULL);
/*!40000 ALTER TABLE `answerstage2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answerstage3`
--

DROP TABLE IF EXISTS `answerstage3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answerstage3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `value` text NOT NULL,
  `companyid` bigint(20) DEFAULT NULL,
  `questionid` bigint(20) DEFAULT NULL,
  `editor_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5onnqgvtx5f24o3rff5s2pul4` (`companyid`),
  KEY `FKaag7rnkom08npaylx2nhlsolb` (`questionid`),
  KEY `FKhuet2ybs64tcqbwxwt00hhy08` (`editor_user_id`),
  CONSTRAINT `FK5onnqgvtx5f24o3rff5s2pul4` FOREIGN KEY (`companyid`) REFERENCES `company` (`id`),
  CONSTRAINT `FKaag7rnkom08npaylx2nhlsolb` FOREIGN KEY (`questionid`) REFERENCES `questionstage3` (`id`),
  CONSTRAINT `FKhuet2ybs64tcqbwxwt00hhy08` FOREIGN KEY (`editor_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answerstage3`
--

LOCK TABLES `answerstage3` WRITE;
/*!40000 ALTER TABLE `answerstage3` DISABLE KEYS */;
/*!40000 ALTER TABLE `answerstage3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answerstage4`
--

DROP TABLE IF EXISTS `answerstage4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answerstage4` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `value` text NOT NULL,
  `companyid` bigint(20) DEFAULT NULL,
  `questionid` bigint(20) DEFAULT NULL,
  `editor_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjy2yrilyye230w6umwn4kxpi5` (`companyid`),
  KEY `FK3vo65dsshrb4ykma4cqno6ek` (`questionid`),
  KEY `FKr7efjjc3n0vtwg33nwuvkbc7w` (`editor_user_id`),
  CONSTRAINT `FK3vo65dsshrb4ykma4cqno6ek` FOREIGN KEY (`questionid`) REFERENCES `questionstage4` (`id`),
  CONSTRAINT `FKjy2yrilyye230w6umwn4kxpi5` FOREIGN KEY (`companyid`) REFERENCES `company` (`id`),
  CONSTRAINT `FKr7efjjc3n0vtwg33nwuvkbc7w` FOREIGN KEY (`editor_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answerstage4`
--

LOCK TABLES `answerstage4` WRITE;
/*!40000 ALTER TABLE `answerstage4` DISABLE KEYS */;
/*!40000 ALTER TABLE `answerstage4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `business`
--

DROP TABLE IF EXISTS `business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business`
--

LOCK TABLES `business` WRITE;
/*!40000 ALTER TABLE `business` DISABLE KEYS */;
/*!40000 ALTER TABLE `business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about_us` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `contact_email` varchar(255) NOT NULL,
  `contact_name` varchar(255) NOT NULL,
  `contact_phone_number` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `line_1` varchar(255) NOT NULL,
  `line2` varchar(255) DEFAULT NULL,
  `line3` varchar(255) DEFAULT NULL,
  `local_authority` varchar(255) NOT NULL,
  `logo_link` text NOT NULL,
  `message` text,
  `name` text NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `postal_code` varchar(255) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Company1 is a new company','Yaoundé','vanel@gmail.com','Company 1','237690909090','vanel@gmail.com','237690909091','237690909092','237690909093','Chief','logo_company12022-01-26 18:21:27.png','Just a company1 message. Happy','Company1','237690909094','237','company.net'),(2,'Deuxieme company fait dans tout','Yaounde','compas@test.cm','Compas','237690909034','company2@test.cm','32722222231','32722222232','32722222233','Chef','logo_company21644238927191.png','Juste une deuxieme company','company2','237690989098','235','compas.cm');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_has_user`
--

DROP TABLE IF EXISTS `company_has_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_has_user` (
  `companyid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`companyid`,`userid`),
  KEY `FK5r64wr17ki6vd27jc385mg6ob` (`userid`),
  CONSTRAINT `FK5a7or48lplwdxs5sj058a2p7j` FOREIGN KEY (`companyid`) REFERENCES `company` (`id`),
  CONSTRAINT `FK5r64wr17ki6vd27jc385mg6ob` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_has_user`
--

LOCK TABLES `company_has_user` WRITE;
/*!40000 ALTER TABLE `company_has_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_has_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupe`
--

LOCK TABLES `groupe` WRITE;
/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `guardname` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,NULL,NULL,'super_admin','super_admin','super_admin',NULL),(2,'2022-02-11 00:00:00.000000',NULL,'edit_stage_1','edit_stage_1','edit_stage_1',NULL),(3,'2022-02-11 00:00:00.000000',NULL,'edit_stage_2','edit_stage_2','edit_stage_2',NULL),(4,'2022-02-11 00:00:00.000000',NULL,'edit_stage_3','edit_stage_3','edit_stage_3',NULL),(5,'2022-02-11 00:00:00.000000',NULL,'edit_stage_4','edit_stage_4','edit_stage_4',NULL),(6,'2022-02-11 00:00:00.000000',NULL,'edit_company','edit_company','edit_company',NULL),(7,'2022-02-11 00:00:00.000000',NULL,'create_company','create_company','create_company',NULL),(8,'2022-02-11 00:00:00.000000',NULL,'list_company','list_company','list_company',NULL);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionstage1`
--

DROP TABLE IF EXISTS `questionstage1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionstage1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `choice_set` text,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `priority_sector_number` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `value` text NOT NULL,
  `validator_side` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionstage1`
--

LOCK TABLES `questionstage1` WRITE;
/*!40000 ALTER TABLE `questionstage1` DISABLE KEYS */;
INSERT INTO `questionstage1` VALUES (1,'','2022-02-01 11:40:00.000000',NULL,NULL,1,'text',NULL,'names',NULL),(2,'','2022-02-01 11:40:00.000000',NULL,NULL,2,'number',NULL,'year open',NULL),(3,'','2022-02-01 11:40:00.000000',NULL,NULL,3,'number',NULL,'How many employees',NULL),(4,'','2022-02-01 11:40:00.000000',NULL,NULL,4,'text',NULL,'Turnover',NULL),(5,'','2022-02-01 11:40:00.000000',NULL,NULL,5,'text',NULL,'Location',NULL),(6,'','2022-02-01 11:40:00.000000',NULL,NULL,6,'text',NULL,'Type of trade',NULL),(7,'','2022-02-01 11:40:00.000000',NULL,NULL,7,'text',NULL,'Sector of industry',NULL),(8,'','2022-02-01 11:40:00.000000',NULL,NULL,8,'text',NULL,'Name of director',NULL),(9,'','2022-02-01 11:40:00.000000',NULL,NULL,9,'text',NULL,'Name of other directors',NULL),(10,'','2022-02-01 11:40:00.000000',NULL,1,10,'number',NULL,'Priority needs',NULL),(11,'','2022-02-01 11:40:00.000000',NULL,NULL,11,'text',NULL,'comment',NULL),(12,'','2022-02-01 11:40:00.000000',NULL,2,12,'number',NULL,'Secondary priority needs',NULL),(13,'','2022-02-01 11:40:00.000000',NULL,NULL,13,'text',NULL,'comment',NULL),(14,'','2022-02-01 11:40:00.000000',NULL,3,14,'number',NULL,'Third priority needs',NULL),(15,'','2022-02-01 11:40:00.000000',NULL,NULL,15,'text',NULL,'comment',NULL),(16,'','2022-02-01 11:40:00.000000',NULL,NULL,16,'text',NULL,'What are the strong areas in sales?',NULL),(17,'','2022-02-01 11:40:00.000000',NULL,NULL,17,'text',NULL,'What are the strong areas in creativity?',NULL),(18,'','2022-02-01 11:40:00.000000',NULL,NULL,18,'text',NULL,'What are the strong areas in logistics?',NULL),(19,'','2022-02-01 11:40:00.000000',NULL,NULL,19,'text',NULL,'What are the strong areas in productivity?',NULL),(20,'','2022-02-01 11:40:00.000000',NULL,NULL,20,'text',NULL,'What are the strong areas in digital tech?',NULL),(21,'','2022-02-01 11:40:00.000000',NULL,NULL,21,'text',NULL,'What are the strong areas in recruitment?',NULL),(22,'','2022-02-01 11:40:00.000000',NULL,NULL,22,'text',NULL,'What are the strong areas in staff management?',NULL),(23,'','2022-02-01 11:40:00.000000',NULL,NULL,23,'text',NULL,'What are the strong areas in legislation/government policies?',NULL),(24,'','2022-02-01 11:40:00.000000',NULL,NULL,24,'text',NULL,'What are the strong areas in customer service?',NULL),(25,'','2022-02-01 11:40:00.000000',NULL,NULL,25,'text',NULL,'What area for development?',NULL),(26,'','2022-02-01 11:40:00.000000',NULL,NULL,26,'text',NULL,'What are your difficulties in sales?',NULL),(27,'','2022-02-01 11:40:00.000000',NULL,NULL,27,'text',NULL,'What are your difficulties in creativity?',NULL),(28,'','2022-02-01 11:40:00.000000',NULL,NULL,28,'text',NULL,'What are your difficulties in logistics?',NULL),(29,'','2022-02-01 11:40:00.000000',NULL,NULL,29,'text',NULL,'What are your difficulties in productivity?',NULL),(30,'','2022-02-01 11:40:00.000000',NULL,NULL,30,'text',NULL,'What are your difficulties in digital tech?',NULL),(31,'','2022-02-01 11:40:00.000000',NULL,NULL,31,'text',NULL,'What are your difficulties in recruitment?',NULL),(32,'','2022-02-01 11:40:00.000000',NULL,NULL,32,'text',NULL,'What are your difficulties in staff management?',NULL),(33,'','2022-02-01 11:40:00.000000',NULL,NULL,33,'text',NULL,'What are your difficulties in legislation/government policies?',NULL),(34,'','2022-02-01 11:40:00.000000',NULL,NULL,34,'text',NULL,'What are your difficulties in customer service?',NULL),(35,NULL,'2022-02-18 12:05:00.000000',NULL,NULL,35,'boolean',NULL,'Assessment decision',1),(36,NULL,'2022-02-18 12:05:00.000000',NULL,NULL,36,'textarea',NULL,'Assessment comment',1),(37,NULL,'2022-02-18 12:05:00.000000',NULL,NULL,37,'boolean',NULL,'SME validation',2),(38,NULL,'2022-02-18 12:05:00.000000',NULL,NULL,38,'file',NULL,'Email attachment',NULL);
/*!40000 ALTER TABLE `questionstage1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionstage2`
--

DROP TABLE IF EXISTS `questionstage2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionstage2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `choice_set` text,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `value` text NOT NULL,
  `secteurid` bigint(20) DEFAULT NULL,
  `validator_side` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjvvcgv8yml3bge0c5h0ru6imv` (`secteurid`),
  CONSTRAINT `FKjvvcgv8yml3bge0c5h0ru6imv` FOREIGN KEY (`secteurid`) REFERENCES `sector` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionstage2`
--

LOCK TABLES `questionstage2` WRITE;
/*!40000 ALTER TABLE `questionstage2` DISABLE KEYS */;
INSERT INTO `questionstage2` VALUES (1,'','2022-02-01 16:00:00.000000',NULL,1,'text',NULL,'what is the turnover in the last 6 months?',1,NULL),(2,'','2022-02-01 16:00:00.000000',NULL,2,'text',NULL,'How much is your current loan?',1,NULL),(3,'','2022-02-01 16:00:00.000000',NULL,3,'text',NULL,'What year was the loan contracted?',1,NULL),(4,'','2022-02-01 16:00:00.000000',NULL,4,'text',NULL,'What year does the loan end?',1,NULL),(5,'','2022-02-01 16:00:00.000000',NULL,5,'text',NULL,'How much are you looking to borrow?',1,NULL),(6,'3 years/5 years/10 years/15 years','2022-02-01 16:00:00.000000',NULL,6,'select',NULL,'How long do you want your payments?',1,NULL),(7,'150/350/500/1000','2022-02-01 16:00:00.000000',NULL,7,'number',NULL,'How much repayment monthly?',1,NULL),(8,'','2022-02-01 16:00:00.000000',NULL,8,'text',NULL,'Who is your guarantor?',1,NULL),(9,'','2022-02-01 16:00:00.000000',NULL,9,'text',NULL,'What is your equity?',1,NULL),(10,'machineries/vehicles/industrial engine','2022-02-01 16:00:00.000000',NULL,10,'select',NULL,'What type of equipment do you use?',2,NULL),(11,'','2022-02-01 16:00:00.000000',NULL,11,'text',NULL,'How often do you service equipment?',2,NULL),(12,'','2022-02-01 16:00:00.000000',NULL,12,'text',NULL,'What is the initial date of use?',2,NULL),(13,'25%/50%/75%/100%','2022-02-01 16:00:00.000000',NULL,13,'select',NULL,'Is the equipment used for productivity?',2,NULL),(14,'solar panel/electricity/hydro/generator/wind','2022-02-01 16:00:00.000000',NULL,14,'select',NULL,'Type of energy?',2,NULL),(15,'25%/50%/75%/100%','2022-02-01 16:00:00.000000',NULL,15,'select',NULL,'Is that energy used for productivity?',2,NULL),(16,'','2022-02-01 16:00:00.000000',NULL,16,'text',NULL,'What type of equipment do you need?',2,NULL),(17,'','2022-02-01 16:00:00.000000',NULL,17,'text',NULL,'Who are the qualified operators?',2,NULL),(18,'','2022-02-01 16:00:00.000000',NULL,18,'boolean',NULL,'Do you need grant for equipment?',2,NULL),(19,'','2022-02-01 16:00:00.000000',NULL,19,'boolean',NULL,'Do you need recruitment? ',2,NULL),(20,'','2022-02-01 16:00:00.000000',NULL,20,'text',NULL,'How long have you used the equipment for?',2,NULL),(21,'(management/technical/digital/entry level/communication/finance/engineering','2022-02-01 16:00:00.000000',NULL,21,'select',NULL,'What training do you need?',3,NULL),(22,'','2022-02-01 16:00:00.000000',NULL,22,'number',NULL,'How many staff are qualified in their roles',3,NULL),(23,'','2022-02-01 16:00:00.000000',NULL,23,'number',NULL,'How many staff need training?',3,NULL),(24,'','2022-02-01 16:00:00.000000',NULL,24,'date',NULL,'When do you want to start?',3,NULL),(25,'','2022-02-01 16:00:00.000000',NULL,25,'boolean',NULL,'Do you need grant for training?',3,NULL),(26,'','2022-02-01 16:00:00.000000',NULL,26,'boolean',NULL,'Do you import?',4,NULL),(27,'','2022-02-01 16:00:00.000000',NULL,27,'text',NULL,'What country from?',4,NULL),(28,'','2022-02-01 16:00:00.000000',NULL,28,'text',NULL,'Type of goods?',4,NULL),(29,'KG/TONS','2022-02-01 16:00:00.000000',NULL,29,'select',NULL,'Compacity per year?',4,NULL),(30,'plane/ship/road','2022-02-01 16:00:00.000000',NULL,30,'list',NULL,'What transport do you use?',4,NULL),(31,'legislation guidance/grants/customs support/freight/transit/container shipment','2022-02-01 16:00:00.000000',NULL,31,'select',NULL,'Type of support?',4,NULL),(32,'','2022-02-01 16:00:00.000000',NULL,32,'boolean',NULL,'Do you export?',4,NULL),(33,'','2022-02-01 16:00:00.000000',NULL,33,'text',NULL,'What country do you export to?',4,NULL),(34,'','2022-02-01 16:00:00.000000',NULL,34,'text',NULL,'Type of goods?',4,NULL),(35,'KG/TONS','2022-02-01 16:00:00.000000',NULL,35,'select',NULL,'Compacity per year?',4,NULL),(36,'plane/ship/road','2022-02-01 16:00:00.000000',NULL,36,'list',NULL,'What transport do you use?',4,NULL),(37,'legislation guidance/grants/customs support/freight/transit/container shipment','2022-02-01 16:00:00.000000',NULL,37,'select',NULL,'What type of support?',4,NULL),(38,'text messages/phone calls/social media/advertisements/TV/radio/digital marketing/face-to-face','2022-02-01 16:00:00.000000',NULL,38,'select',NULL,'What type of communication do you use?',5,NULL),(39,'public/external professionals/internal professionals/customers/local authority/other businesses/competitors','2022-02-01 16:00:00.000000',NULL,39,'select',NULL,'Who is your audience?',5,NULL),(40,'daily/weekly/monthly/yearly','2022-02-01 16:00:00.000000',NULL,40,'select',NULL,'How often do you communicate?',5,NULL),(41,'','2022-02-01 16:00:00.000000',NULL,41,'text',NULL,'Why this frequency?',5,NULL),(42,'training/equipment/consulting','2022-02-01 16:00:00.000000',NULL,42,'select',NULL,'What are your needs?',5,NULL),(43,'','2022-02-01 16:00:00.000000',NULL,43,'number',NULL,'How many directors do you have?',6,NULL),(44,'','2022-02-01 16:00:00.000000',NULL,44,'number',NULL,'How many managers do you have?',6,NULL),(45,'','2022-02-01 16:00:00.000000',NULL,45,'number',NULL,'How many supervisors do you have?',6,NULL),(46,'','2022-02-01 16:00:00.000000',NULL,46,'number',NULL,'How many field staff do you have?',6,NULL),(47,'','2022-02-01 16:00:00.000000',NULL,47,'boolean',NULL,'Do you need leadership support?',6,NULL),(48,'','2022-02-01 16:00:00.000000',NULL,48,'text',NULL,'What is your leadership style?',6,NULL),(49,'','2022-02-01 16:00:00.000000',NULL,49,'boolean',NULL,'Do you need management support?',6,NULL),(50,'','2022-02-01 16:00:00.000000',NULL,50,'text',NULL,'What is your management style?',6,NULL),(51,'training/consulting','2022-02-01 16:00:00.000000',NULL,51,'select',NULL,'What are your current needs?',6,NULL),(52,'','2022-02-01 16:00:00.000000',NULL,52,'text',NULL,'What food/item do you produce?',7,NULL),(53,'','2022-02-01 16:00:00.000000',NULL,53,'boolean',NULL,'Is your product international?',7,NULL),(54,'','2022-02-01 16:00:00.000000',NULL,54,'boolean',NULL,'Are you industry production?',7,NULL),(55,'','2022-02-01 16:00:00.000000',NULL,55,'boolean',NULL,'Are you commercial production?',7,NULL),(56,'KG/TONS','2022-02-01 16:00:00.000000',NULL,56,'select',NULL,'What is your yearly compacity',7,NULL),(57,'machineries/vehicles/industrial engine','2022-02-01 16:00:00.000000',NULL,57,'select',NULL,'What type of machinery do you use?',7,NULL),(58,'daily/weekly/monthly/quaterly/yearly','2022-02-01 16:00:00.000000',NULL,58,'select',NULL,'How often do you service your equipment?',7,NULL),(59,'','2022-02-01 16:00:00.000000',NULL,59,'number',NULL,'How many engineers are on site?',7,NULL),(60,'equipment/digital tech/communication/consulting/engineering/distribution/networking','2022-02-01 16:00:00.000000',NULL,60,'select',NULL,'What are your needs?',7,NULL),(61,'','2022-02-01 16:00:00.000000',NULL,61,'text',NULL,'What type of production do you have?',8,NULL),(62,'','2022-02-01 16:00:00.000000',NULL,62,'text',NULL,'What is your main product?',8,NULL),(63,'KG/TONS','2022-02-01 16:00:00.000000',NULL,63,'select',NULL,'What is your yearly compacity?',8,NULL),(64,'','2022-02-01 16:00:00.000000',NULL,64,'boolean',NULL,'Is it commercial?',8,NULL),(65,'','2022-02-01 16:00:00.000000',NULL,65,'boolean',NULL,'Is it industrial?',8,NULL),(66,'','2022-02-01 16:00:00.000000',NULL,66,'textarea',NULL,'What is your main machinery?',8,NULL),(67,'','2022-02-01 16:00:00.000000',NULL,67,'text',NULL,'What is the make/model?',8,NULL),(68,'','2022-02-01 16:00:00.000000',NULL,68,'number',NULL,'How many do you need?',8,NULL),(69,'daily/weekly/monthly/quaterly/yearly','2022-02-01 16:00:00.000000',NULL,69,'select',NULL,'How often do you service your machinery?',8,NULL),(70,NULL,'2022-02-18 17:10:00.000000',NULL,70,'boolean',NULL,'Assessment decision',1,1),(71,NULL,'2022-02-18 17:10:00.000000',NULL,71,'textarea',NULL,'Assessment comment',1,1),(72,NULL,'2022-02-18 17:10:00.000000',NULL,72,'boolean',NULL,'SME validation',1,2),(73,NULL,'2022-02-18 17:10:00.000000',NULL,73,'file',NULL,'Email attachment',1,NULL),(74,NULL,'2022-02-18 17:10:00.000000',NULL,74,'boolean',NULL,'Assessment decision',2,1),(75,NULL,'2022-02-18 17:10:00.000000',NULL,75,'textarea',NULL,'Assessment comment',2,1),(76,NULL,'2022-02-18 17:10:00.000000',NULL,76,'boolean',NULL,'SME validation',2,2),(77,NULL,'2022-02-18 17:10:00.000000',NULL,77,'file',NULL,'Email attachment',2,NULL),(78,NULL,'2022-02-18 17:30:00.000000',NULL,78,'boolean',NULL,'Assessment decision',3,1),(79,NULL,'2022-02-18 17:30:00.000000',NULL,79,'textarea',NULL,'Assessment comment',3,1),(80,NULL,'2022-02-18 17:30:00.000000',NULL,80,'boolean',NULL,'SME validation',3,2),(81,NULL,'2022-02-18 17:30:00.000000',NULL,81,'file',NULL,'Email attachment',3,NULL),(82,NULL,'2022-02-18 17:30:00.000000',NULL,82,'boolean',NULL,'Assessment decision',4,1),(83,NULL,'2022-02-18 17:30:00.000000',NULL,83,'textarea',NULL,'Assessment comment',4,1),(84,NULL,'2022-02-18 17:30:00.000000',NULL,84,'boolean',NULL,'SME validation',4,2),(85,NULL,'2022-02-18 17:30:00.000000',NULL,85,'file',NULL,'Email attachment',4,NULL),(86,NULL,'2022-02-18 17:30:00.000000',NULL,86,'boolean',NULL,'Assessment decision',5,1),(87,NULL,'2022-02-18 17:30:00.000000',NULL,87,'textarea',NULL,'Assessment comment',5,1),(88,NULL,'2022-02-18 17:30:00.000000',NULL,88,'boolean',NULL,'SME validation',5,2),(89,NULL,'2022-02-18 17:30:00.000000',NULL,89,'file',NULL,'Email attachment',5,NULL),(90,NULL,'2022-02-18 17:30:00.000000',NULL,90,'boolean',NULL,'Assessment decision',6,1),(91,NULL,'2022-02-18 17:30:00.000000',NULL,91,'textarea',NULL,'Assessment comment',6,1),(92,NULL,'2022-02-18 17:30:00.000000',NULL,92,'boolean',NULL,'SME validation',6,2),(93,NULL,'2022-02-18 17:30:00.000000',NULL,93,'file',NULL,'Email attachment',6,NULL),(94,NULL,'2022-02-18 17:30:00.000000',NULL,94,'boolean',NULL,'Assessment decision',7,1),(95,NULL,'2022-02-18 17:30:00.000000',NULL,95,'textarea',NULL,'Assessment comment',7,1),(96,NULL,'2022-02-18 17:30:00.000000',NULL,96,'boolean',NULL,'SME validation',7,2),(97,NULL,'2022-02-18 17:30:00.000000',NULL,97,'file',NULL,'Email attachment',7,NULL),(98,NULL,'2022-02-18 17:30:00.000000',NULL,98,'boolean',NULL,'Assessment decision',8,1),(99,NULL,'2022-02-18 17:30:00.000000',NULL,99,'textarea',NULL,'Assessment comment',8,1),(100,NULL,'2022-02-18 17:30:00.000000',NULL,100,'boolean',NULL,'SME validation',8,2),(101,NULL,'2022-02-18 17:30:00.000000',NULL,101,'file',NULL,'Email attachment',8,NULL);
/*!40000 ALTER TABLE `questionstage2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionstage3`
--

DROP TABLE IF EXISTS `questionstage3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionstage3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `choice_set` text,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `value` text NOT NULL,
  `validator_side` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionstage3`
--

LOCK TABLES `questionstage3` WRITE;
/*!40000 ALTER TABLE `questionstage3` DISABLE KEYS */;
INSERT INTO `questionstage3` VALUES (1,'','2022-02-01 17:00:00.000000',NULL,1,'textarea',NULL,'Case review',NULL),(2,'','2022-02-01 17:00:00.000000',NULL,2,'boolean',NULL,'Outstanding?',NULL),(3,'','2022-02-01 17:00:00.000000',NULL,3,'list',NULL,'Require further action',NULL),(4,'','2022-02-01 17:00:00.000000',NULL,4,'textarea',NULL,'How?',NULL),(5,'','2022-02-01 17:00:00.000000',NULL,5,'textarea',NULL,'Details of support',NULL),(6,'','2022-02-01 17:00:00.000000',NULL,6,'textarea',NULL,'Finance',NULL),(7,'','2022-02-01 17:00:00.000000',NULL,7,'textarea',NULL,'Equipment',NULL),(8,'','2022-02-01 17:00:00.000000',NULL,8,'textarea',NULL,'Training',NULL),(9,'','2022-02-01 17:00:00.000000',NULL,9,'textarea',NULL,'Customs/import/export',NULL),(10,'','2022-02-01 17:00:00.000000',NULL,10,'textarea',NULL,'Communication',NULL),(11,'','2022-02-01 17:00:00.000000',NULL,11,'textarea',NULL,'Management',NULL),(12,'','2022-02-01 17:00:00.000000',NULL,12,'textarea',NULL,'Food production',NULL),(13,'','2022-02-01 17:00:00.000000',NULL,13,'textarea',NULL,'Machineries/engineering',NULL),(14,'','2022-02-01 17:00:00.000000',NULL,14,'boolean',NULL,'Approval',NULL),(15,'','2022-02-01 17:00:00.000000',NULL,15,'textarea',NULL,'Require further action',NULL),(16,NULL,'2022-02-18 17:45:00.000000',NULL,16,'boolean',NULL,'Assessment decision',1),(17,NULL,'2022-02-18 17:45:00.000000',NULL,17,'textarea',NULL,'Assessment comment',1),(18,NULL,'2022-02-18 17:45:00.000000',NULL,18,'textarea',NULL,'Feedback to SME on final decision',NULL);
/*!40000 ALTER TABLE `questionstage3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionstage4`
--

DROP TABLE IF EXISTS `questionstage4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionstage4` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `choice_set` text,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `value` text NOT NULL,
  `validator_side` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionstage4`
--

LOCK TABLES `questionstage4` WRITE;
/*!40000 ALTER TABLE `questionstage4` DISABLE KEYS */;
INSERT INTO `questionstage4` VALUES (1,NULL,'2022-02-01 17:20:00.000000',NULL,1,'textarea',NULL,'Case review',NULL),(2,NULL,'2022-02-01 17:20:00.000000',NULL,2,'boolean',NULL,'Approval',NULL),(3,NULL,'2022-02-01 17:20:00.000000',NULL,3,'textarea',NULL,'Decision making',NULL),(4,NULL,'2022-02-18 17:45:00.000000',NULL,4,'boolean',NULL,'Assessment decision',1),(5,NULL,'2022-02-18 17:45:00.000000',NULL,5,'textarea',NULL,'Assessment comment',1),(6,NULL,'2022-02-18 17:45:00.000000',NULL,6,'textarea',NULL,'Feedback to SME on final decision',NULL);
/*!40000 ALTER TABLE `questionstage4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `guardname` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'2022-02-10 18:41:00.000000',NULL,'le role du super administrateur de l\'application','super_admin','super admin',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_has_permission`
--

DROP TABLE IF EXISTS `role_has_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_has_permission` (
  `roleid` bigint(20) NOT NULL,
  `permissionid` bigint(20) NOT NULL,
  PRIMARY KEY (`roleid`,`permissionid`),
  KEY `FKk5mcwyfrjs5dhd1p84uoawlif` (`permissionid`),
  CONSTRAINT `FKk5mcwyfrjs5dhd1p84uoawlif` FOREIGN KEY (`permissionid`) REFERENCES `permission` (`id`),
  CONSTRAINT `FKlketmcjq37mpdehvvj1co17sa` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_has_permission`
--

LOCK TABLES `role_has_permission` WRITE;
/*!40000 ALTER TABLE `role_has_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_has_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sector` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES (1,'Finance'),(2,'Equipment'),(3,'Training'),(4,'Customs/import/export'),(5,'Communication'),(6,'Management'),(7,'Food production'),(8,'Machineries/engineering');
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `deletedat` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `expiretokendate` datetime(6) DEFAULT NULL,
  `fcmtoken` varchar(255) DEFAULT NULL,
  `login` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(200) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `supervisor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrvnycmphjyvdxat1lycui3hpk` (`supervisor_id`),
  CONSTRAINT `FKrvnycmphjyvdxat1lycui3hpk` FOREIGN KEY (`supervisor_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'2022-01-27 11:38:00.000000',NULL,'admin@mail.cm',_binary '',NULL,NULL,'admin','admin','$2a$11$SyuY2sLy7aDY8/tD3OHPJeDfSg0BARKSBhxJ4aHN5QDB/qJYsQpU2',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_groupe`
--

DROP TABLE IF EXISTS `user_groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_groupe` (
  `userid` bigint(20) NOT NULL,
  `groupeid` bigint(20) NOT NULL,
  PRIMARY KEY (`groupeid`,`userid`),
  KEY `FKmywcrn916vi4qyc2xmvwtwong` (`userid`),
  CONSTRAINT `FKc839neob4l5ss7pr28m9851y` FOREIGN KEY (`groupeid`) REFERENCES `groupe` (`id`),
  CONSTRAINT `FKmywcrn916vi4qyc2xmvwtwong` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_groupe`
--

LOCK TABLES `user_groupe` WRITE;
/*!40000 ALTER TABLE `user_groupe` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_permission`
--

DROP TABLE IF EXISTS `user_has_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_permission` (
  `userid` bigint(20) NOT NULL,
  `permissionid` bigint(20) NOT NULL,
  PRIMARY KEY (`userid`,`permissionid`),
  KEY `FKbvrvye2srol3fwn9rww70200g` (`permissionid`),
  CONSTRAINT `FKbvrvye2srol3fwn9rww70200g` FOREIGN KEY (`permissionid`) REFERENCES `permission` (`id`),
  CONSTRAINT `FKlk45c5ojf213wpbed25yg3cdl` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_permission`
--

LOCK TABLES `user_has_permission` WRITE;
/*!40000 ALTER TABLE `user_has_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_role`
--

DROP TABLE IF EXISTS `user_has_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_role` (
  `userid` bigint(20) NOT NULL,
  `roleid` bigint(20) NOT NULL,
  PRIMARY KEY (`userid`,`roleid`),
  KEY `FKvs4yeb1o2l01gyk1ql1129bu` (`roleid`),
  CONSTRAINT `FKs5m3gvh7pbcg78kwigdq8d7mx` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `FKvs4yeb1o2l01gyk1ql1129bu` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_role`
--

LOCK TABLES `user_has_role` WRITE;
/*!40000 ALTER TABLE `user_has_role` DISABLE KEYS */;
INSERT INTO `user_has_role` VALUES (1,1);
/*!40000 ALTER TABLE `user_has_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 17:50:29

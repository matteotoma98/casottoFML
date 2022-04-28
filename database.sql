-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: casotto
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `addettoattivita`
--

DROP TABLE IF EXISTS `addettoattivita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addettoattivita` (
  `email` varchar(50) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `id_attivita` int NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `id_attivita_fk_idx` (`id_attivita`),
  KEY `nome_addetto_attivita_fk_idx` (`nome`) /*!80000 INVISIBLE */,
  KEY `cognome_addetto_attivita_fk_idx` (`cognome`),
  CONSTRAINT `cognome_addetto_attivita_fk` FOREIGN KEY (`cognome`) REFERENCES `utente` (`cognome`),
  CONSTRAINT `email_fk_addettoattivita` FOREIGN KEY (`email`) REFERENCES `utente` (`email`),
  CONSTRAINT `id_attivita_fk` FOREIGN KEY (`id_attivita`) REFERENCES `attivita` (`id_attivita`),
  CONSTRAINT `nome_addetto_attivita_fk` FOREIGN KEY (`nome`) REFERENCES `utente` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addettoattivita`
--

LOCK TABLES `addettoattivita` WRITE;
/*!40000 ALTER TABLE `addettoattivita` DISABLE KEYS */;
INSERT INTO `addettoattivita` VALUES ('addettoattivita@studenti.unicam.it','Addetto','Attivita',1);
/*!40000 ALTER TABLE `addettoattivita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addettobar`
--

DROP TABLE IF EXISTS `addettobar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addettobar` (
  `id_addbar` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_addbar`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `nome_addettobar_fk_idx` (`nome`),
  KEY `cognome_addettobar_fk_idx` (`cognome`),
  CONSTRAINT `cognome_addettobar_fk` FOREIGN KEY (`cognome`) REFERENCES `utente` (`cognome`),
  CONSTRAINT `email_fk_addettobar` FOREIGN KEY (`email`) REFERENCES `utente` (`email`),
  CONSTRAINT `nome_addettobar_fk` FOREIGN KEY (`nome`) REFERENCES `utente` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addettobar`
--

LOCK TABLES `addettobar` WRITE;
/*!40000 ALTER TABLE `addettobar` DISABLE KEYS */;
INSERT INTO `addettobar` VALUES (1,'addettobar@studenti.unicam.it','Addetto','Bar');
/*!40000 ALTER TABLE `addettobar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addettospiaggia`
--

DROP TABLE IF EXISTS `addettospiaggia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addettospiaggia` (
  `id_addspaggia` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_addspaggia`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `nome_addettospiaggia_fk_idx` (`nome`),
  KEY `cognome_addettospiaggia_fk_idx` (`cognome`),
  CONSTRAINT `cognome_addettospiaggia_fk` FOREIGN KEY (`cognome`) REFERENCES `utente` (`cognome`),
  CONSTRAINT `email_fk_addettospiaggia` FOREIGN KEY (`email`) REFERENCES `utente` (`email`),
  CONSTRAINT `nome_addettospiaggia_fk` FOREIGN KEY (`nome`) REFERENCES `utente` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addettospiaggia`
--

LOCK TABLES `addettospiaggia` WRITE;
/*!40000 ALTER TABLE `addettospiaggia` DISABLE KEYS */;
INSERT INTO `addettospiaggia` VALUES (2,'addettospiaggia@studenti.unicam.it','Addetto','Spiaggia');
/*!40000 ALTER TABLE `addettospiaggia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attivita`
--

DROP TABLE IF EXISTS `attivita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attivita` (
  `nome_attivita` varchar(45) NOT NULL,
  `num_posti` int DEFAULT '0',
  `nome_attrezzatura` varchar(45) DEFAULT NULL,
  `quantita` int DEFAULT '0',
  `id_attivita` int NOT NULL,
  `data_inizio_attivita` datetime DEFAULT NULL,
  `data_fine_attivita` datetime DEFAULT NULL,
  PRIMARY KEY (`nome_attivita`),
  UNIQUE KEY `nome_UNIQUE` (`nome_attivita`),
  KEY `id_attivita` (`id_attivita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attivita`
--

LOCK TABLES `attivita` WRITE;
/*!40000 ALTER TABLE `attivita` DISABLE KEYS */;
INSERT INTO `attivita` VALUES ('Beach Volley',2,'Pallone Beach',2,3,NULL,NULL),('Calcio',2,'Pallone Calcio',2,2,NULL,NULL),('Zumba',10,NULL,0,1,'2022-04-29 17:00:00','2022-04-29 19:00:00');
/*!40000 ALTER TABLE `attivita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chalet`
--

DROP TABLE IF EXISTS `chalet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chalet` (
  `quantita_ombrelloni` int NOT NULL,
  `quantita_lettini` int NOT NULL,
  `quantita_ombrelloni_disponibili` int NOT NULL,
  `quantita_lettini_disponibili` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chalet`
--

LOCK TABLES `chalet` WRITE;
/*!40000 ALTER TABLE `chalet` DISABLE KEYS */;
INSERT INTO `chalet` VALUES (150,300,150,300);
/*!40000 ALTER TABLE `chalet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_ombrellone` int NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `id_ombrellone` (`id_ombrellone`),
  KEY `nome_cliente_fk_idx` (`nome`),
  KEY `cognome_cliente_fk_idx` (`cognome`),
  CONSTRAINT `cognome_cliente_fk` FOREIGN KEY (`cognome`) REFERENCES `utente` (`cognome`),
  CONSTRAINT `email_fk_cliente` FOREIGN KEY (`email`) REFERENCES `utente` (`email`),
  CONSTRAINT `nome_cliente_fk` FOREIGN KEY (`nome`) REFERENCES `utente` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('Matteo','T','matteotoma98@hotmail.it',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestore`
--

DROP TABLE IF EXISTS `gestore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gestore` (
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `nome_gestore_fk_idx` (`nome`),
  KEY `cognome_gestore_fk_idx` (`cognome`),
  CONSTRAINT `cognome_gestore_fk` FOREIGN KEY (`cognome`) REFERENCES `utente` (`cognome`),
  CONSTRAINT `nome_gestore_fk` FOREIGN KEY (`nome`) REFERENCES `utente` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestore`
--

LOCK TABLES `gestore` WRITE;
/*!40000 ALTER TABLE `gestore` DISABLE KEYS */;
INSERT INTO `gestore` VALUES ('Francesco','Chiocchi','francesco.chiocchi@studenti.unicam.it'),('Lorenzo','Caporossi','lorenzo.caporossi@studenti.unicam.it'),('Matteo','Toma','matteo.toma@studenti.unicam.it');
/*!40000 ALTER TABLE `gestore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lettino`
--

DROP TABLE IF EXISTS `lettino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lettino` (
  `id_lettino` int NOT NULL,
  `disponibilita` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_lettino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lettino`
--

LOCK TABLES `lettino` WRITE;
/*!40000 ALTER TABLE `lettino` DISABLE KEYS */;
INSERT INTO `lettino` VALUES (0,1),(1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(41,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(57,1),(58,1),(59,1),(60,1),(61,1),(62,1),(63,1),(64,1),(65,1),(66,1),(67,1),(68,1),(69,1),(70,1),(71,1),(72,1),(73,1),(74,1),(75,1),(76,1),(77,1),(78,1),(79,1),(80,1),(81,1),(82,1),(83,1),(84,1),(85,1),(86,1),(87,1),(88,1),(89,1),(90,1),(91,1),(92,1),(93,1),(94,1),(95,1),(96,1),(97,1),(98,1),(99,1),(100,1),(101,1),(102,1),(103,1),(104,1),(105,1),(106,1),(107,1),(108,1),(109,1),(110,1),(111,1),(112,1),(113,1),(114,1),(115,1),(116,1),(117,1),(118,1),(119,1),(120,1),(121,1),(122,1),(123,1),(124,1),(125,1),(126,1),(127,1),(128,1),(129,1),(130,1),(131,1),(132,1),(133,1),(134,1),(135,1),(136,1),(137,1),(138,1),(139,1),(140,1),(141,1),(142,1),(143,1),(144,1),(145,1),(146,1),(147,1),(148,1),(149,1),(150,1),(151,1),(152,1),(153,1),(154,1),(155,1),(156,1),(157,1),(158,1),(159,1),(160,1),(161,1),(162,1),(163,1),(164,1),(165,1),(166,1),(167,1),(168,1),(169,1),(170,1),(171,1),(172,1),(173,1),(174,1),(175,1),(176,1),(177,1),(178,1),(179,1),(180,1),(181,1),(182,1),(183,1),(184,1),(185,1),(186,1),(187,1),(188,1),(189,1),(190,1),(191,1),(192,1),(193,1),(194,1),(195,1),(196,1),(197,1),(198,1),(199,1),(200,1),(201,1),(202,1),(203,1),(204,1),(205,1),(206,1),(207,1),(208,1),(209,1),(210,1),(211,1),(212,1),(213,1),(214,1),(215,1),(216,1),(217,1),(218,1),(219,1),(220,1),(221,1),(222,1),(223,1),(224,1),(225,1),(226,1),(227,1),(228,1),(229,1),(230,1),(231,1),(232,1),(233,1),(234,1),(235,1),(236,1),(237,1),(238,1),(239,1),(240,1),(241,1),(242,1),(243,1),(244,1),(245,1),(246,1),(247,1),(248,1),(249,1),(250,1),(251,1),(252,1),(253,1),(254,1),(255,1),(256,1),(257,1),(258,1),(259,1),(260,1),(261,1),(262,1),(263,1),(264,1),(265,1),(266,1),(267,1),(268,1),(269,1),(270,1),(271,1),(272,1),(273,1),(274,1),(275,1),(276,1),(277,1),(278,1),(279,1),(280,1),(281,1),(282,1),(283,1),(284,1),(285,1),(286,1),(287,1),(288,1),(289,1),(290,1),(291,1),(292,1),(293,1),(294,1),(295,1),(296,1),(297,1),(298,1),(299,1),(300,1);
/*!40000 ALTER TABLE `lettino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ombrellone`
--

DROP TABLE IF EXISTS `ombrellone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ombrellone` (
  `id_ombrellone` int NOT NULL AUTO_INCREMENT,
  `prezzo` double NOT NULL,
  `disponibilita` tinyint(1) NOT NULL,
  `tipologia` enum('vip','premium','base') NOT NULL,
  `num_fila_ombrellone` int NOT NULL,
  PRIMARY KEY (`id_ombrellone`),
  UNIQUE KEY `id_ombrellone_UNIQUE` (`id_ombrellone`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ombrellone`
--

LOCK TABLES `ombrellone` WRITE;
/*!40000 ALTER TABLE `ombrellone` DISABLE KEYS */;
INSERT INTO `ombrellone` VALUES (1,8,1,'vip',1),(2,8,1,'vip',1),(3,8,1,'vip',1),(4,8,1,'vip',1),(5,8,1,'vip',1),(6,8,1,'vip',1),(7,8,1,'vip',1),(8,8,1,'vip',1),(9,8,1,'vip',1),(10,8,1,'vip',1),(11,8,1,'vip',2),(12,8,1,'vip',2),(13,8,1,'vip',2),(14,8,1,'vip',2),(15,8,1,'vip',2),(16,8,1,'vip',2),(17,8,1,'vip',2),(18,8,1,'vip',2),(19,8,1,'vip',2),(20,8,1,'vip',2),(21,8,1,'vip',3),(22,8,1,'vip',3),(23,8,1,'vip',3),(24,8,1,'vip',3),(25,8,1,'vip',3),(26,8,1,'vip',3),(27,8,1,'vip',3),(28,8,1,'vip',3),(29,8,1,'vip',3),(30,8,1,'vip',3),(31,6,1,'premium',4),(32,6,1,'premium',4),(33,6,1,'premium',4),(34,6,1,'premium',4),(35,6,1,'premium',4),(36,6,1,'premium',4),(37,6,1,'premium',4),(38,6,1,'premium',4),(39,6,1,'premium',4),(40,6,1,'premium',4),(41,6,1,'premium',5),(42,6,1,'premium',5),(43,6,1,'premium',5),(44,6,1,'premium',5),(45,6,1,'premium',5),(46,6,1,'premium',5),(47,6,1,'premium',5),(48,6,1,'premium',5),(49,6,1,'premium',5),(50,6,1,'premium',5),(51,6,1,'premium',6),(52,6,1,'premium',6),(53,6,1,'premium',6),(54,6,1,'premium',6),(55,6,1,'premium',6),(56,6,1,'premium',6),(57,6,1,'premium',6),(58,6,1,'premium',6),(59,6,1,'premium',6),(60,6,1,'premium',6),(61,6,1,'premium',7),(62,6,1,'premium',7),(63,6,1,'premium',7),(64,6,1,'premium',7),(65,6,1,'premium',7),(66,6,1,'premium',7),(67,6,1,'premium',7),(68,6,1,'premium',7),(69,6,1,'premium',7),(70,6,1,'premium',7),(71,4,1,'base',8),(72,4,1,'base',8),(73,4,1,'base',8),(74,4,1,'base',8),(75,4,1,'base',8),(76,4,1,'base',8),(77,4,1,'base',8),(78,4,1,'base',8),(79,4,1,'base',8),(80,4,1,'base',8),(81,4,1,'base',9),(82,4,1,'base',9),(83,4,1,'base',9),(84,4,1,'base',9),(85,4,1,'base',9),(86,4,1,'base',9),(87,4,1,'base',9),(88,4,1,'base',9),(89,4,1,'base',9),(90,4,1,'base',9),(91,4,1,'base',10),(92,4,1,'base',10),(93,4,1,'base',10),(94,4,1,'base',10),(95,4,1,'base',10),(96,4,1,'base',10),(97,4,1,'base',10),(98,4,1,'base',10),(99,4,1,'base',10),(100,4,1,'base',10),(101,4,1,'base',11),(102,4,1,'base',11),(103,4,1,'base',11),(104,4,1,'base',11),(105,4,1,'base',11),(106,4,1,'base',11),(107,4,1,'base',11),(108,4,1,'base',11),(109,4,1,'base',11),(110,4,1,'base',11),(111,4,1,'base',12),(112,4,1,'base',12),(113,4,1,'base',12),(114,4,1,'base',12),(115,4,1,'base',12),(116,4,1,'base',12),(117,4,1,'base',12),(118,4,1,'base',12),(119,4,1,'base',12),(120,4,1,'base',12),(121,4,1,'base',13),(122,4,1,'base',13),(123,4,1,'base',13),(124,4,1,'base',13),(125,4,1,'base',13),(126,4,1,'base',13),(127,4,1,'base',13),(128,4,1,'base',13),(129,4,1,'base',13),(130,4,1,'base',13),(131,4,1,'base',14),(132,4,1,'base',14),(133,4,1,'base',14),(134,4,1,'base',14),(135,4,1,'base',14),(136,4,1,'base',14),(137,4,1,'base',14),(138,4,1,'base',14),(139,4,1,'base',14),(140,4,1,'base',14),(141,4,1,'base',15),(142,4,1,'base',15),(143,4,1,'base',15),(144,4,1,'base',15),(145,4,1,'base',15),(146,4,1,'base',15),(147,4,1,'base',15),(148,4,1,'base',15),(149,4,1,'base',15),(150,4,1,'base',15);
/*!40000 ALTER TABLE `ombrellone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordinazionebar`
--

DROP TABLE IF EXISTS `ordinazionebar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordinazionebar` (
  `data_ordinazione` date NOT NULL,
  `id_ombrellone` int NOT NULL,
  `id_ordinazione` int NOT NULL AUTO_INCREMENT,
  `quantita` int DEFAULT NULL,
  PRIMARY KEY (`id_ordinazione`),
  KEY `id_ombrellone_fk3_idx` (`id_ombrellone`),
  KEY `data_ordinazione` (`data_ordinazione`),
  CONSTRAINT `id_ombrellone_fk` FOREIGN KEY (`id_ombrellone`) REFERENCES `cliente` (`id_ombrellone`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordinazionebar`
--

LOCK TABLES `ordinazionebar` WRITE;
/*!40000 ALTER TABLE `ordinazionebar` DISABLE KEYS */;
INSERT INTO `ordinazionebar` VALUES ('2022-05-22',1,1,10),('2022-05-22',1,2,12);
/*!40000 ALTER TABLE `ordinazionebar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `tipologia_pagamento` varchar(50) NOT NULL DEFAULT 'app',
  `id_prenotazione` int NOT NULL,
  `id_ordinazione` int DEFAULT NULL,
  `id_ombrellone` int DEFAULT NULL,
  `data_pagamento` datetime NOT NULL,
  KEY `id_ordinazione_fk_idx` (`id_ordinazione`),
  KEY `id_prenotazione_fk_idx` (`id_prenotazione`),
  CONSTRAINT `id_ordinazione_fk` FOREIGN KEY (`id_ordinazione`) REFERENCES `ordinazionebar` (`id_ordinazione`),
  CONSTRAINT `id_prenotazione_fk` FOREIGN KEY (`id_prenotazione`) REFERENCES `prenotazionespiaggia` (`id_prenotazione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES ('app',1,1,1,'2022-04-29 17:30:00'),('contanti',1,NULL,1,'2022-04-29 10:00:00'),('app',1,2,1,'2022-04-29 19:00:00');
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazioneattivita`
--

DROP TABLE IF EXISTS `prenotazioneattivita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioneattivita` (
  `data_inizio` date NOT NULL,
  `data_fine` date NOT NULL,
  `nome_attivita` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`data_inizio`,`nome_attivita`,`data_fine`,`email`),
  KEY `nome_attivita_fk_idx` (`nome_attivita`) /*!80000 INVISIBLE */,
  KEY `email_idx` (`email`),
  CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `cliente` (`email`),
  CONSTRAINT `nome_attivita_fk` FOREIGN KEY (`nome_attivita`) REFERENCES `attivita` (`nome_attivita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioneattivita`
--

LOCK TABLES `prenotazioneattivita` WRITE;
/*!40000 ALTER TABLE `prenotazioneattivita` DISABLE KEYS */;
INSERT INTO `prenotazioneattivita` VALUES ('2005-02-22','2005-02-22','Calcio','matteotoma98@hotmail.it');
/*!40000 ALTER TABLE `prenotazioneattivita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazionespiaggia`
--

DROP TABLE IF EXISTS `prenotazionespiaggia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazionespiaggia` (
  `id_prenotazione` int NOT NULL AUTO_INCREMENT,
  `data_inizio_prenotazione` date NOT NULL,
  `data_fine_prenotazione` date NOT NULL,
  `num_fila_ombrellone` int NOT NULL,
  `id_ombrellone` int NOT NULL,
  PRIMARY KEY (`id_prenotazione`),
  KEY `num_fila_ombrellone_idx` (`num_fila_ombrellone`),
  KEY `id_ombrellone_fk_idx` (`id_ombrellone`),
  CONSTRAINT `id_fk_ombrellone` FOREIGN KEY (`id_ombrellone`) REFERENCES `ombrellone` (`id_ombrellone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazionespiaggia`
--

LOCK TABLES `prenotazionespiaggia` WRITE;
/*!40000 ALTER TABLE `prenotazionespiaggia` DISABLE KEYS */;
INSERT INTO `prenotazionespiaggia` VALUES (1,'2022-03-22','2022-03-22',1,1);
/*!40000 ALTER TABLE `prenotazionespiaggia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preparazioneordine`
--

DROP TABLE IF EXISTS `preparazioneordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preparazioneordine` (
  `ordine_pronto` tinyint(1) NOT NULL,
  `id_ordinazione` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preparazioneordine`
--

LOCK TABLES `preparazioneordine` WRITE;
/*!40000 ALTER TABLE `preparazioneordine` DISABLE KEYS */;
INSERT INTO `preparazioneordine` VALUES (1,1);
/*!40000 ALTER TABLE `preparazioneordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodottibar`
--

DROP TABLE IF EXISTS `prodottibar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodottibar` (
  `id_prodotto` int NOT NULL,
  `nome_prodotto` varchar(45) NOT NULL,
  `prezzo` double NOT NULL,
  `quantita` int DEFAULT NULL,
  PRIMARY KEY (`id_prodotto`),
  UNIQUE KEY `id_prodotto_UNIQUE` (`id_prodotto`),
  UNIQUE KEY `nome_prodotto_UNIQUE` (`nome_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodottibar`
--

LOCK TABLES `prodottibar` WRITE;
/*!40000 ALTER TABLE `prodottibar` DISABLE KEYS */;
INSERT INTO `prodottibar` VALUES (1,'Patatine San Carlo',1,15),(2,'Bruschettine',2,4),(3,'Tramezzini',3,5),(4,'Kinder Bueno',2,10),(5,'Spritz',4,20),(6,'Estathe Pesca',2,20),(7,'Estathe Limone',2,20),(8,'Acqua',1,50),(9,'Cono ',2,10),(10,'Ghiacciolo Menta',1.5,5),(11,'Giacciolo Limone',5,5);
/*!40000 ALTER TABLE `prodottibar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scontrino`
--

DROP TABLE IF EXISTS `scontrino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scontrino` (
  `id_scontrino` int NOT NULL AUTO_INCREMENT,
  `data_scontrino` date NOT NULL,
  `id_ombrellone` int NOT NULL,
  `prezzo_totale` double NOT NULL,
  PRIMARY KEY (`id_scontrino`),
  UNIQUE KEY `id_ombrellone_UNIQUE` (`id_ombrellone`),
  CONSTRAINT `id_ombrellone_fk_4` FOREIGN KEY (`id_ombrellone`) REFERENCES `ordinazionebar` (`id_ombrellone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scontrino`
--

LOCK TABLES `scontrino` WRITE;
/*!40000 ALTER TABLE `scontrino` DISABLE KEYS */;
INSERT INTO `scontrino` VALUES (1,'2022-05-22',1,25);
/*!40000 ALTER TABLE `scontrino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariffaprezzi`
--

DROP TABLE IF EXISTS `tariffaprezzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tariffaprezzi` (
  `num_fila_ombrellone` int NOT NULL,
  `prezzo_lettino` double NOT NULL,
  `prezzoOmbrelloneMG` double NOT NULL,
  `prezzoOmbrelloneGI` varchar(45) NOT NULL,
  PRIMARY KEY (`num_fila_ombrellone`),
  CONSTRAINT `num_fila_ombrellone_fk` FOREIGN KEY (`num_fila_ombrellone`) REFERENCES `ombrellone` (`id_ombrellone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariffaprezzi`
--

LOCK TABLES `tariffaprezzi` WRITE;
/*!40000 ALTER TABLE `tariffaprezzi` DISABLE KEYS */;
INSERT INTO `tariffaprezzi` VALUES (1,2,12,'14'),(2,2,12,'14'),(3,2,12,'14'),(4,2,10,'12'),(5,2,10,'12'),(6,2,10,'12'),(7,2,10,'12'),(8,2,8,'10'),(9,2,8,'10'),(10,2,8,'10'),(11,2,8,'10'),(12,2,8,'10'),(13,2,8,'10'),(14,2,8,'10'),(15,2,8,'10');
/*!40000 ALTER TABLE `tariffaprezzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `username` varchar(25) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ruolo` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  PRIMARY KEY (`username`,`password`),
  KEY `ruolo_fk` (`ruolo`),
  KEY `email_fk` (`email`),
  KEY `nome_fk` (`nome`),
  KEY `cognome_fk` (`cognome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('addettoattivita','addettoattivita','addetto_attivita','addettoattivita@studenti.unicam.it','Addetto','Attivita'),('addettobar','addettobar','addetto_bar','addettobar@studenti.unicam.it','Addetto','Bar'),('addettospiaggia','addettospiaggia','addetto_spiaggia','addettospiaggia@studenti.unicam.it','Addetto','Spiaggia'),('fracs_xyz','casottoFML','gestore','francesco.chiocchi@studenti.unicam.it','Francesco','Chiocchi'),('lore_capo','casottoFML','gestore','lorenzo.caporossi@studenti.unicam.it','Lorenzo','Caporossi'),('matteot','matteot','cliente','matteotoma98@hotmail.it','Matteo','T'),('matteotoma_98','casottoFML','gestore','matteo.toma@studenti.unicam.it','Matteo','Toma');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-28 12:25:42

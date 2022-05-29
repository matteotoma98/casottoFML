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
  `id_addetto_attivita` int DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `nome_addetto_attivita_fk_idx` (`nome`) /*!80000 INVISIBLE */,
  KEY `cognome_addetto_attivita_fk_idx` (`cognome`),
  CONSTRAINT `cognome_addetto_attivita_fk` FOREIGN KEY (`cognome`) REFERENCES `utente` (`cognome`),
  CONSTRAINT `email_fk_addettoattivita` FOREIGN KEY (`email`) REFERENCES `utente` (`email`),
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
  CONSTRAINT `email_fk_addettobar` FOREIGN KEY (`email`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nome_addettobar_fk` FOREIGN KEY (`nome`) REFERENCES `utente` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addettobar`
--

LOCK TABLES `addettobar` WRITE;
/*!40000 ALTER TABLE `addettobar` DISABLE KEYS */;
INSERT INTO `addettobar` VALUES (1,'fchiocchi@libero.it','Addetto','Bar');
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
  CONSTRAINT `email_fk_addettospiaggia` FOREIGN KEY (`email`) REFERENCES `utente` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nome_addettospiaggia_fk` FOREIGN KEY (`nome`) REFERENCES `utente` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addettospiaggia`
--

LOCK TABLES `addettospiaggia` WRITE;
/*!40000 ALTER TABLE `addettospiaggia` DISABLE KEYS */;
INSERT INTO `addettospiaggia` VALUES (1,'francesco.chiocchi@divini.org','Addetto','Spiaggia');
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
  `id_attivita` int NOT NULL,
  `nome_attrezzatura` varchar(45) DEFAULT NULL,
  `quantita` varchar(45) DEFAULT '0',
  `data_inizio_attivita` datetime DEFAULT NULL,
  `data_fine_attivita` datetime DEFAULT NULL,
  PRIMARY KEY (`nome_attivita`),
  UNIQUE KEY `nome_UNIQUE` (`nome_attivita`),
  KEY `data_inizio_attivita` (`data_inizio_attivita`),
  KEY `data_fine_attivita` (`data_fine_attivita`),
  KEY `attrezzatura` (`nome_attrezzatura`),
  KEY `id_attivita` (`id_attivita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attivita`
--

LOCK TABLES `attivita` WRITE;
/*!40000 ALTER TABLE `attivita` DISABLE KEYS */;
INSERT INTO `attivita` VALUES ('Beach',4,3,'Pallone Beach','2','2022-05-11 16:00:00','2022-05-11 18:00:00'),('Calcio',5,2,'Pallone Calcio','2','2022-04-29 15:00:00','2022-04-29 16:00:00'),('prova',NULL,4,'prova','2',NULL,NULL),('prova2',NULL,5,'prova','2',NULL,NULL),('prova3',NULL,6,'prova','2',NULL,NULL),('Zumba',4,1,'Cassa','1','2022-09-10 00:00:00','2022-09-10 00:00:00');
/*!40000 ALTER TABLE `attivita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attrezzatura`
--

DROP TABLE IF EXISTS `attrezzatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attrezzatura` (
  `nome_attrezzatura` varchar(55) NOT NULL,
  `quantita` int DEFAULT NULL,
  `id_attivita` int DEFAULT NULL,
  PRIMARY KEY (`nome_attrezzatura`),
  KEY `id_attivita_idx` (`id_attivita`,`nome_attrezzatura`),
  CONSTRAINT `id_attivita` FOREIGN KEY (`id_attivita`) REFERENCES `attivita` (`id_attivita`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attrezzatura`
--

LOCK TABLES `attrezzatura` WRITE;
/*!40000 ALTER TABLE `attrezzatura` DISABLE KEYS */;
INSERT INTO `attrezzatura` VALUES ('Pallone Beach',5,2),('Pallone Calcio',10,3),('prova',2,NULL),('prova2',2,NULL),('prova3',2,NULL),('prova4',2,NULL);
/*!40000 ALTER TABLE `attrezzatura` ENABLE KEYS */;
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
  `quantita_lettini_disponibili` int NOT NULL,
  UNIQUE KEY `quantita_ombrelloni_UNIQUE` (`quantita_ombrelloni`),
  UNIQUE KEY `quantita_lettini_UNIQUE` (`quantita_lettini`),
  UNIQUE KEY `quantita_ombrelloni_disponibili_UNIQUE` (`quantita_ombrelloni_disponibili`),
  UNIQUE KEY `quantita_lettini_disponibili_UNIQUE` (`quantita_lettini_disponibili`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci MAX_ROWS=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chalet`
--

LOCK TABLES `chalet` WRITE;
/*!40000 ALTER TABLE `chalet` DISABLE KEYS */;
INSERT INTO `chalet` VALUES (150,150,150,150);
/*!40000 ALTER TABLE `chalet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `id_ombrellone` int NOT NULL,
  KEY `email_fk_3` (`email`),
  KEY `id_ombrellone_fk_idx` (`id_ombrellone`),
  CONSTRAINT `id_ombrellone_fk2` FOREIGN KEY (`id_ombrellone`) REFERENCES `prenotazionespiaggia` (`id_ombrellone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('toma','toma','matteo',1);
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
-- Table structure for table `ombrellone`
--

DROP TABLE IF EXISTS `ombrellone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ombrellone` (
  `id_ombrellone` int NOT NULL AUTO_INCREMENT,
  `prezzo` double DEFAULT NULL,
  `tipologia` enum('vip','premium','base') DEFAULT NULL,
  `num_fila_ombrellone` int DEFAULT NULL,
  PRIMARY KEY (`id_ombrellone`),
  UNIQUE KEY `id_ombrellone_UNIQUE` (`id_ombrellone`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ombrellone`
--

LOCK TABLES `ombrellone` WRITE;
/*!40000 ALTER TABLE `ombrellone` DISABLE KEYS */;
INSERT INTO `ombrellone` VALUES (1,8,'vip',1),(2,8,'vip',1),(3,8,'vip',1),(4,8,'vip',1),(5,8,'vip',1),(6,8,'vip',1),(7,8,'vip',1),(8,8,'vip',1),(9,8,'vip',1),(10,8,'vip',1),(11,8,'vip',2),(12,8,'vip',2),(13,8,'vip',2),(14,8,'vip',2),(15,8,'vip',2),(16,8,'vip',2),(17,8,'vip',2),(18,8,'vip',2),(19,8,'vip',2),(20,8,'vip',2),(21,8,'vip',3),(22,8,'vip',3),(23,8,'vip',3),(24,8,'vip',3),(25,8,'vip',3),(26,8,'vip',3),(27,8,'vip',3),(28,8,'vip',3),(29,8,'vip',3),(30,8,'vip',3),(31,6,'premium',4),(32,6,'premium',4),(33,6,'premium',4),(34,6,'premium',4),(35,6,'premium',4),(36,6,'premium',4),(37,6,'premium',4),(38,6,'premium',4),(39,6,'premium',4),(40,6,'premium',4),(41,6,'premium',5),(42,6,'premium',5),(43,6,'premium',5),(44,6,'premium',5),(45,6,'premium',5),(46,6,'premium',5),(47,6,'premium',5),(48,6,'premium',5),(49,6,'premium',5),(50,6,'premium',5),(51,6,'premium',6),(52,6,'premium',6),(53,6,'premium',6),(54,6,'premium',6),(55,6,'premium',6),(56,6,'premium',6),(57,6,'premium',6),(58,6,'premium',6),(59,6,'premium',6),(60,6,'premium',6),(61,6,'premium',7),(62,6,'premium',7),(63,6,'premium',7),(64,6,'premium',7),(65,6,'premium',7),(66,6,'premium',7),(67,6,'premium',7),(68,6,'premium',7),(69,6,'premium',7),(70,6,'premium',7),(71,4,'base',8),(72,4,'base',8),(73,4,'base',8),(74,4,'base',8),(75,4,'base',8),(76,4,'base',8),(77,4,'base',8),(78,4,'base',8),(79,4,'base',8),(80,4,'base',8),(81,4,'base',9),(82,4,'base',9),(83,4,'base',9),(84,4,'base',9),(85,4,'base',9),(86,4,'base',9),(87,4,'base',9),(88,4,'base',9),(89,4,'base',9),(90,4,'base',9),(91,4,'base',10),(92,4,'base',10),(93,4,'base',10),(94,4,'base',10),(95,4,'base',10),(96,4,'base',10),(97,4,'base',10),(98,4,'base',10),(99,4,'base',10),(100,4,'base',10),(101,4,'base',11),(102,4,'base',11),(103,4,'base',11),(104,4,'base',11),(105,4,'base',11),(106,4,'base',11),(107,4,'base',11),(108,4,'base',11),(109,4,'base',11),(110,4,'base',11),(111,4,'base',12),(112,4,'base',12),(113,4,'base',12),(114,4,'base',12),(115,4,'base',12),(116,4,'base',12),(117,4,'base',12),(118,4,'base',12),(119,4,'base',12),(120,4,'base',12),(121,4,'base',13),(122,4,'base',13),(123,4,'base',13),(124,4,'base',13),(125,4,'base',13),(126,4,'base',13),(127,4,'base',13),(128,4,'base',13),(129,4,'base',13),(130,4,'base',13),(131,4,'base',14),(132,4,'base',14),(133,4,'base',14),(134,4,'base',14),(135,4,'base',14),(136,4,'base',14),(137,4,'base',14),(138,4,'base',14),(139,4,'base',14),(140,4,'base',14),(141,4,'base',15),(142,4,'base',15),(143,4,'base',15),(144,4,'base',15),(145,4,'base',15),(146,4,'base',15),(147,4,'base',15),(148,4,'base',15),(149,4,'base',15),(150,4,'base',15);
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
  `quantita` varchar(255) DEFAULT NULL,
  `lista_prodotti` varchar(255) NOT NULL,
  PRIMARY KEY (`id_ordinazione`),
  KEY `data_ordinazione` (`data_ordinazione`),
  KEY `id_ombrellone_fk_idx` (`id_ombrellone`),
  CONSTRAINT `id_ombrellone_fk` FOREIGN KEY (`id_ombrellone`) REFERENCES `prenotazionespiaggia` (`id_ombrellone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordinazionebar`
--

LOCK TABLES `ordinazionebar` WRITE;
/*!40000 ALTER TABLE `ordinazionebar` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordinazionebar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamentobar`
--

DROP TABLE IF EXISTS `pagamentobar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamentobar` (
  `tipologia_pagamento` varchar(50) NOT NULL DEFAULT 'app',
  `id_ordinazione` int DEFAULT NULL,
  `id_ombrellone` int DEFAULT NULL,
  `data_pagamento` datetime NOT NULL,
  KEY `id_ordinazione_fk_idx` (`id_ordinazione`),
  KEY `id_ombrellone_fk_idx` (`id_ombrellone`),
  CONSTRAINT `id_ombrellone_fk4_idx` FOREIGN KEY (`id_ombrellone`) REFERENCES `ordinazionebar` (`id_ombrellone`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_ordinazione_fk` FOREIGN KEY (`id_ordinazione`) REFERENCES `ordinazionebar` (`id_ordinazione`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamentobar`
--

LOCK TABLES `pagamentobar` WRITE;
/*!40000 ALTER TABLE `pagamentobar` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamentobar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamentoombrellone`
--

DROP TABLE IF EXISTS `pagamentoombrellone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamentoombrellone` (
  `tipologia_pagamento` varchar(50) NOT NULL DEFAULT 'app',
  `id_prenotazione` int NOT NULL,
  `id_ombrellone` int NOT NULL,
  `data_pagamento` datetime NOT NULL,
  PRIMARY KEY (`id_prenotazione`),
  KEY `id_prenotazione_fk_idx` (`id_prenotazione`),
  KEY `id_ombrellone_fk2_idx` (`id_ombrellone`),
  CONSTRAINT `id_ombrellone_fk_2` FOREIGN KEY (`id_ombrellone`) REFERENCES `prenotazionespiaggia` (`id_ombrellone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamentoombrellone`
--

LOCK TABLES `pagamentoombrellone` WRITE;
/*!40000 ALTER TABLE `pagamentoombrellone` DISABLE KEYS */;
INSERT INTO `pagamentoombrellone` VALUES ('app',1,1,'2022-05-24 00:00:00');
/*!40000 ALTER TABLE `pagamentoombrellone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazioneattivita`
--

DROP TABLE IF EXISTS `prenotazioneattivita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioneattivita` (
  `email` varchar(45) NOT NULL,
  `data_inizio` datetime NOT NULL,
  `data_fine` datetime NOT NULL,
  `id_attivita` int NOT NULL,
  `num_posti` int NOT NULL,
  `id_prenotazione_attivita` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_prenotazione_attivita`),
  KEY `email_pren_spiaggia_fk_idx` (`id_attivita`),
  KEY `data_inzio_attivita_idx` (`data_inizio`),
  KEY `data_fine_attivita_idx` (`data_fine`),
  KEY `email_fk_idx` (`email`),
  CONSTRAINT `data_fine_attivita` FOREIGN KEY (`data_fine`) REFERENCES `attivita` (`data_fine_attivita`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `data_inzio_attivita` FOREIGN KEY (`data_inizio`) REFERENCES `attivita` (`data_inizio_attivita`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `email_fk_2` FOREIGN KEY (`email`) REFERENCES `prenotazionespiaggia` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_attivita_fk` FOREIGN KEY (`id_attivita`) REFERENCES `attivita` (`id_attivita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioneattivita`
--

LOCK TABLES `prenotazioneattivita` WRITE;
/*!40000 ALTER TABLE `prenotazioneattivita` DISABLE KEYS */;
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
  `lettini` int DEFAULT '0',
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id_prenotazione`),
  UNIQUE KEY `id_prenotazione_UNIQUE` (`id_prenotazione`),
  KEY `num_fila_ombrellone_idx` (`num_fila_ombrellone`),
  KEY `id_ombrellone_fk_idx` (`id_ombrellone`),
  KEY `email_fk` (`email`),
  CONSTRAINT `id_fk_ombrellone` FOREIGN KEY (`id_ombrellone`) REFERENCES `ombrellone` (`id_ombrellone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazionespiaggia`
--

LOCK TABLES `prenotazionespiaggia` WRITE;
/*!40000 ALTER TABLE `prenotazionespiaggia` DISABLE KEYS */;
INSERT INTO `prenotazionespiaggia` VALUES (1,'2022-06-12','2022-06-13',1,1,1,'matteo');
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
  `tempo_preparazione` int NOT NULL,
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
INSERT INTO `prodottibar` VALUES (1,'Patatine San Carlo',1,7,1),(2,'Bruschettine',2,11,1),(3,'Tramezzini',3,14,5),(4,'Kinder Bueno',2,10,1),(5,'Spritz',4,20,5),(6,'Estathe Pesca',2,20,1),(7,'Estathe Limone',2,20,1),(8,'Acqua',1,48,1),(9,'Cono ',2,8,1),(10,'Ghiacciolo Menta',1.5,5,1),(11,'Giacciolo Limone',5,5,1);
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
  `tipologia` varchar(50) NOT NULL,
  PRIMARY KEY (`id_scontrino`),
  KEY `id_ombrellone_idx` (`id_ombrellone`),
  CONSTRAINT `id_ombrellone` FOREIGN KEY (`id_ombrellone`) REFERENCES `prenotazionespiaggia` (`id_ombrellone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scontrino`
--

LOCK TABLES `scontrino` WRITE;
/*!40000 ALTER TABLE `scontrino` DISABLE KEYS */;
INSERT INTO `scontrino` VALUES (1,'2022-05-24',1,34,'ombrellone');
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
INSERT INTO `tariffaprezzi` VALUES (1,2,6,'8'),(2,2,6,'8'),(3,2,6,'8'),(4,2,4,'6'),(5,2,4,'6'),(6,2,4,'6'),(7,2,4,'6'),(8,2,2,'4'),(9,2,2,'4'),(10,2,2,'4'),(11,2,2,'4'),(12,2,2,'4'),(13,2,2,'4'),(14,2,2,'4'),(15,2,2,'4');
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
  PRIMARY KEY (`password`,`username`),
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
INSERT INTO `utente` VALUES ('addettoattivita','addettoattivita','addetto_attivita','addettoattivita@studenti.unicam.it','Addetto','Attivita'),('addettobar','addettobar','addetto_bar','fchiocchi@libero.it','Addetto','Bar'),('addettospiaggia','addettospiaggia','addetto_spiaggia','francesco.chiocchi@divini.org','Addetto','Spiaggia'),('fracs_xyz','casottoFML','gestore','francesco.chiocchi@studenti.unicam.it','Francesco','Chiocchi'),('lore_capo','casottoFML','gestore','lorenzo.caporossi@studenti.unicam.it','Lorenzo','Caporossi'),('matteotoma_98','casottoFML','gestore','matteo.toma@studenti.unicam.it','Matteo','Toma'),('fra','fracs','cliente','chio','fra','fracs'),('francesco','francesco','cliente','fchiocchi1@gmail.com','Francesco','Chiocchi'),('lorenzo','lorenzo','cliente','caporossilorenzo98@gmail.com','Lorenzo','Caporossi'),('matteo','matteo','cliente','matteo','toma','toma'),('matteot','matteot','cliente','matteotoma98@hotmail.it','Matteo','T'),('prova','prova','cliente','prova','prova','cliente');
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

-- Dump completed on 2022-05-28 17:01:47

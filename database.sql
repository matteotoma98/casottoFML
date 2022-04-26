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
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `id_attivita` int NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `id_attivita_fk_idx` (`id_attivita`),
  CONSTRAINT `email_fk_addettoattivita` FOREIGN KEY (`email`) REFERENCES `utente` (`email`),
  CONSTRAINT `id_attivita_fk` FOREIGN KEY (`id_attivita`) REFERENCES `attivita` (`id_attivita`)
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
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_addbar`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  CONSTRAINT `email_fk_addettobar` FOREIGN KEY (`email`) REFERENCES `utente` (`email`)
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
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_addspaggia`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  CONSTRAINT `email_fk_addettospiaggia` FOREIGN KEY (`email`) REFERENCES `utente` (`email`)
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
INSERT INTO `attivita` VALUES ('Beach Volley',2,'Pallone Beach',2,3),('Calcio',2,'Pallone Calcio',2,2),('Zumba',10,NULL,0,1);
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
  `id_ombrellone` int DEFAULT NULL,
  PRIMARY KEY (`nome`,`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `id_ombrellone` (`id_ombrellone`),
  CONSTRAINT `email_fk_cliente` FOREIGN KEY (`email`) REFERENCES `utente` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('Matteo','Toma','matteotoma98@hotmail.it',NULL);
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
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  CONSTRAINT `email_fk_gestore` FOREIGN KEY (`email`) REFERENCES `utente` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestore`
--

LOCK TABLES `gestore` WRITE;
/*!40000 ALTER TABLE `gestore` DISABLE KEYS */;
INSERT INTO `gestore` VALUES ('Francessco ','Chiocchi','francesco.chiocchi@studenti.unicam.it'),('Lorenzo','Caporossi','lorenzo.caporossi@studenti.unicam.it'),('Matteo','Toma','matteo.toma@studenti.unicam.it');
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
  PRIMARY KEY (`id_ordinazione`,`id_ombrellone`),
  KEY `id_ombrellone_fk3_idx` (`id_ombrellone`) /*!80000 INVISIBLE */,
  KEY `data_ordinazione` (`data_ordinazione`),
  CONSTRAINT `fk_id_ombrellone` FOREIGN KEY (`id_ordinazione`) REFERENCES `cliente` (`id_ombrellone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordinazionebar`
--

LOCK TABLES `ordinazionebar` WRITE;
/*!40000 ALTER TABLE `ordinazionebar` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordinazionebar` ENABLE KEYS */;
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
  CONSTRAINT `nome_attivita_fk` FOREIGN KEY (`nome_attivita`) REFERENCES `attivita` (`nome_attivita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `id_prenotazione` int NOT NULL,
  `data_inizio_prenotazione` date NOT NULL,
  `data_fine_prenotazione` date NOT NULL,
  `num_fila_ombrellone` int NOT NULL AUTO_INCREMENT,
  `id_ombrellone` int NOT NULL,
  PRIMARY KEY (`id_prenotazione`),
  KEY `num_fila_ombrellone_idx` (`num_fila_ombrellone`),
  KEY `id_ombrellone_fk_idx` (`id_ombrellone`),
  CONSTRAINT `id_fk_ombrellone` FOREIGN KEY (`id_ombrellone`) REFERENCES `ombrellone` (`id_ombrellone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazionespiaggia`
--

LOCK TABLES `prenotazionespiaggia` WRITE;
/*!40000 ALTER TABLE `prenotazionespiaggia` DISABLE KEYS */;
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
  `id_ordinazione` int NOT NULL,
  PRIMARY KEY (`id_ordinazione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preparazioneordine`
--

LOCK TABLES `preparazioneordine` WRITE;
/*!40000 ALTER TABLE `preparazioneordine` DISABLE KEYS */;
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
/*!40000 ALTER TABLE `prodottibar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scontrino`
--

DROP TABLE IF EXISTS `scontrino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scontrino` (
  `id_scontrino` int NOT NULL,
  `data_scontrino` date NOT NULL,
  `id_ombrellone` int NOT NULL,
  `prezzo_totale` double NOT NULL,
  PRIMARY KEY (`id_scontrino`),
  UNIQUE KEY `id_ombrellone_UNIQUE` (`id_ombrellone`),
  KEY `data_scontrino_idx` (`data_scontrino`),
  CONSTRAINT `data_scontrino_fk` FOREIGN KEY (`data_scontrino`) REFERENCES `ordinazionebar` (`data_ordinazione`),
  CONSTRAINT `id_ombrellone_fk_4` FOREIGN KEY (`id_ombrellone`) REFERENCES `ordinazionebar` (`id_ombrellone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scontrino`
--

LOCK TABLES `scontrino` WRITE;
/*!40000 ALTER TABLE `scontrino` DISABLE KEYS */;
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
  PRIMARY KEY (`username`,`password`),
  KEY `ruolo_fk` (`ruolo`),
  KEY `email_fk` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('addettoattivita','addettoattivita','addetto_attivita','addettoattivita@studenti.unicam.it'),('addettobar','addettobar','addetto_bar','addettobar@studenti.unicam.it'),('addettospiaggia','addettospiaggia','addetto_spiaggia','addettospiaggia@studenti.unicam.it'),('fracs_xyz','casottoFML','gestore','francesco.chiocchi@studenti.unicam.it'),('lore_capo','casottoFML','gestore','lorenzo.caporossi@studenti.unicam.it'),('matteot','matteot','cliente','matteotoma98@hotmail.it'),('matteotoma_98','casottoFML','gestore','matteo.toma@studenti.unicam.it');
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

-- Dump completed on 2022-04-25 19:36:30

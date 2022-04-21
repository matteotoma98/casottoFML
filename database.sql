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
  `id_attività` int NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_attività`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addettoattivita`
--

LOCK TABLES `addettoattivita` WRITE;
/*!40000 ALTER TABLE `addettoattivita` DISABLE KEYS */;
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
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addettobar`
--

LOCK TABLES `addettobar` WRITE;
/*!40000 ALTER TABLE `addettobar` DISABLE KEYS */;
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
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addettospiaggia`
--

LOCK TABLES `addettospiaggia` WRITE;
/*!40000 ALTER TABLE `addettospiaggia` DISABLE KEYS */;
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
  `num_posti` int DEFAULT NULL,
  `nome_attrezzatura` varchar(45) NOT NULL,
  `quantita` int DEFAULT NULL,
  PRIMARY KEY (`nome_attivita`),
  UNIQUE KEY `nome_UNIQUE` (`nome_attivita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attivita`
--

LOCK TABLES `attivita` WRITE;
/*!40000 ALTER TABLE `attivita` DISABLE KEYS */;
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
  `cognome` varchar(45) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `id_ombrellone` int DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `id_ombrellone_fk_idx` (`id_ombrellone`),
  CONSTRAINT `id_ombrellone_fk2` FOREIGN KEY (`id_ombrellone`) REFERENCES `ombrellone` (`id_ombrellone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
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
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestore`
--

LOCK TABLES `gestore` WRITE;
/*!40000 ALTER TABLE `gestore` DISABLE KEYS */;
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
  `id_ombrellone` int NOT NULL,
  `prezzo` double DEFAULT NULL,
  `disponibilità` tinyint(1) DEFAULT NULL,
  `tipologia` enum('vip','premium','base') NOT NULL,
  `num_fila_ombrellone` int NOT NULL,
  PRIMARY KEY (`id_ombrellone`),
  UNIQUE KEY `id_ombrellone_UNIQUE` (`id_ombrellone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ombrellone`
--

LOCK TABLES `ombrellone` WRITE;
/*!40000 ALTER TABLE `ombrellone` DISABLE KEYS */;
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
  CONSTRAINT `id_ombrellone_fk3` FOREIGN KEY (`id_ombrellone`) REFERENCES `cliente` (`id_ombrellone`)
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
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `nome_attivita_fk_idx` (`nome_attivita`),
  CONSTRAINT `email_fk` FOREIGN KEY (`email`) REFERENCES `cliente` (`email`),
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
  `num_fila_ombrellone` int NOT NULL,
  PRIMARY KEY (`id_prenotazione`),
  KEY `num_fila_ombrellone_idx` (`num_fila_ombrellone`),
  CONSTRAINT `num_fila_ombrellone` FOREIGN KEY (`num_fila_ombrellone`) REFERENCES `ombrellone` (`id_ombrellone`)
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
  `fascia_oraria` enum('mezzagiornata','giornataintera') DEFAULT NULL,
  `prezzo_lettino` double DEFAULT NULL,
  `prezzoOmbrelloneMG` double DEFAULT NULL,
  `prezzoOmbrelloneGI` varchar(45) DEFAULT NULL,
  `id_lettino` int NOT NULL,
  `id_ombrellone` int NOT NULL,
  `id_prodotto` int NOT NULL,
  PRIMARY KEY (`num_fila_ombrellone`),
  KEY `id_lettino_idx` (`id_lettino`),
  KEY `id_ombrellone_fk_idx` (`id_ombrellone`),
  KEY `id_prodotto_fk_idx` (`id_prodotto`),
  CONSTRAINT `id_lettino_fk` FOREIGN KEY (`id_lettino`) REFERENCES `lettino` (`id_lettino`),
  CONSTRAINT `id_ombrellone_fk` FOREIGN KEY (`id_ombrellone`) REFERENCES `ombrellone` (`id_ombrellone`),
  CONSTRAINT `id_prodotto_fk` FOREIGN KEY (`id_prodotto`) REFERENCES `prodottibar` (`id_prodotto`),
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
  PRIMARY KEY (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
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

-- Dump completed on 2022-04-21 18:07:20

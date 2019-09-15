-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: uytubeAPP
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `canal_usuario`
--

DROP TABLE IF EXISTS `canal_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canal_usuario` (
  `nombre_canal` varchar(100) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `isPrivate` bit(1) NOT NULL,
  PRIMARY KEY (`nombre_canal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canal_usuario`
--

LOCK TABLES `canal_usuario` WRITE;
/*!40000 ALTER TABLE `canal_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `canal_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria_video`
--

DROP TABLE IF EXISTS `categoria_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria_video` (
  `categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_video`
--

LOCK TABLES `categoria_video` WRITE;
/*!40000 ALTER TABLE `categoria_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios_video`
--

DROP TABLE IF EXISTS `comentarios_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentarios_video` (
  `nickname` varchar(30) DEFAULT NULL,
  `comentario` varchar(100) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `Video` varchar(100) DEFAULT NULL,
  `Padre` varchar(30) DEFAULT NULL,
  `Referencia` int(11) NOT NULL,
  `Canal_video` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Referencia`),
  UNIQUE KEY `comentarios_video_Referencia_uindex` (`Referencia`),
  KEY `FKqxve4tjk6v4pf4n3c2wy636ol` (`Video`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios_video`
--

LOCK TABLES `comentarios_video` WRITE;
/*!40000 ALTER TABLE `comentarios_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentarios_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_defecto_canal`
--

DROP TABLE IF EXISTS `lista_defecto_canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_defecto_canal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_lista` varchar(100) NOT NULL,
  `canal` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3sx7a9e8qag7xo9k4cu70q0ex` (`canal`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_defecto_canal`
--

LOCK TABLES `lista_defecto_canal` WRITE;
/*!40000 ALTER TABLE `lista_defecto_canal` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_defecto_canal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_defecto_video`
--

DROP TABLE IF EXISTS `lista_defecto_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_defecto_video` (
  `id` int(11) NOT NULL,
  `nombre_video` varchar(100) NOT NULL,
  `nombre_canal_video_origen` varchar(100) NOT NULL,
  KEY `lista_defecto_video_lista_defecto_canal_id_fk` (`id`),
  KEY `lista_defecto_video_videos_canal_nombre_fk` (`nombre_video`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_defecto_video`
--

LOCK TABLES `lista_defecto_video` WRITE;
/*!40000 ALTER TABLE `lista_defecto_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_defecto_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_particular_canal`
--

DROP TABLE IF EXISTS `lista_particular_canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_particular_canal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_lista` varchar(100) NOT NULL,
  `canal` varchar(100) NOT NULL,
  `privada` bit(1) NOT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcodr6lbvrytds0hotfe1imn5d` (`canal`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_particular_canal`
--

LOCK TABLES `lista_particular_canal` WRITE;
/*!40000 ALTER TABLE `lista_particular_canal` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_particular_canal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_particular_video`
--

DROP TABLE IF EXISTS `lista_particular_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_particular_video` (
  `id` int(11) NOT NULL,
  `nombre_video` varchar(100) NOT NULL,
  `nombre_canal_video_origen` varchar(100) NOT NULL,
  KEY `lista_particular_video_lista_particular_canal_id_fk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_particular_video`
--

LOCK TABLES `lista_particular_video` WRITE;
/*!40000 ALTER TABLE `lista_particular_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_particular_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguir`
--

DROP TABLE IF EXISTS `seguir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguir` (
  `nickname` varchar(100) NOT NULL,
  `seguido` varchar(100) NOT NULL,
  KEY `FKr8dqhxes6236fhftvt9uxrj4t` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguir`
--

LOCK TABLES `seguir` WRITE;
/*!40000 ALTER TABLE `seguir` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `nickname` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(254) NOT NULL,
  `fechaNac` date NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `canal` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nickname`),
  UNIQUE KEY `usuario_normal_email_uindex` (`email`),
  KEY `FK3vkji6f6vbowroolxoc2owvf7` (`canal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `updateCanales` BEFORE UPDATE ON `usuario` FOR EACH ROW BEGIN
	update videos_canal set nombre_canal=new.canal where nombre_canal=old.canal;
	update comentarios_video set Canal_video=new.canal where Canal_video=old.canal;
	update lista_defecto_canal set canal=new.canal where canal=old.canal;
	update lista_defecto_video set nombre_canal_video_origen=new.canal where nombre_canal_video_origen=old.canal;
	update lista_particular_canal set canal=new.canal where canal=old.canal;
	update lista_particular_video set nombre_canal_video_origen=new.canal where nombre_canal_video_origen=old.canal;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `valorar`
--

DROP TABLE IF EXISTS `valorar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valorar` (
  `dueño_Vid` varchar(100) NOT NULL,
  `video` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `valoracion` varchar(100) NOT NULL,
  PRIMARY KEY (`dueño_Vid`,`video`,`usuario`),
  UNIQUE KEY `valorar_pk` (`dueño_Vid`,`video`,`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valorar`
--

LOCK TABLES `valorar` WRITE;
/*!40000 ALTER TABLE `valorar` DISABLE KEYS */;
/*!40000 ALTER TABLE `valorar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos_canal`
--

DROP TABLE IF EXISTS `videos_canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos_canal` (
  `nombre` varchar(100) NOT NULL,
  `nombre_canal` varchar(100) NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `url` varchar(200) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `duracion` varchar(100) NOT NULL,
  `isPrivate` bit(1) NOT NULL,
  PRIMARY KEY (`nombre`,`nombre_canal`),
  KEY `videos_canal_categoria_video_categoria_fk` (`categoria`),
  KEY `FKdjjsxs8mnroq1gnfd9h3kan5i` (`nombre_canal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos_canal`
--

LOCK TABLES `videos_canal` WRITE;
/*!40000 ALTER TABLE `videos_canal` DISABLE KEYS */;
/*!40000 ALTER TABLE `videos_canal` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `updateVideos` BEFORE UPDATE ON `videos_canal` FOR EACH ROW BEGIN
    update valorar set video=new.nombre where video=old.nombre;
    update lista_defecto_video set nombre_video=new.nombre where nombre_video=old.nombre;
    update lista_particular_video set nombre_video=new.nombre where nombre_video=old.nombre;
    update comentarios_video set Video=new.nombre where Video=old.nombre;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-15 13:24:45

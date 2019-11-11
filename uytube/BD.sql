-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: uytubeAPP
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `canal_usuario`
--

DROP TABLE IF EXISTS `canal_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `canal_usuario` (
  `nombre_canal` varchar(100) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `isPrivate` bit(1) NOT NULL,
  PRIMARY KEY (`nombre_canal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canal_usuario`
--

LOCK TABLES `canal_usuario` WRITE;
/*!40000 ALTER TABLE `canal_usuario` DISABLE KEYS */;
INSERT INTO `canal_usuario` VALUES ('Canal Horacio','El canal de Horacio es para publicar contenido divertido',_binary '\0'),('Chino Recoba','Canal de goles con Nacional',_binary ''),('Con la gente','Preparando las elecciones',_binary '\0'),('Desde Genexus','Canal información C y T',_binary '\0'),('diegop','Canal de DP',_binary '\0'),('El bocha','Mi canal para colgar mis cosas',_binary '\0'),('El Cachila','Para juntar cosas',_binary ''),('hectorg','Canal HG',_binary '\0'),('juliob','Canal de JB',_binary '\0'),('Kairo música','Videos de grandes canciones de hoy y siempre',_binary '\0'),('Puglia invita','Programas del ciclo y videos de cocina masterchef',_binary '\0'),('robinh','Henderson',_binary '\0'),('Tabaré','Mi música e ainda mais',_binary '\0'),('Tinelli total','Todo lo que querías y más!',_binary '\0'),('Tony Pacheco','Canal de goles con Peñarol',_binary '');
/*!40000 ALTER TABLE `canal_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria_video`
--

DROP TABLE IF EXISTS `categoria_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria_video` (
  `categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_video`
--

LOCK TABLES `categoria_video` WRITE;
/*!40000 ALTER TABLE `categoria_video` DISABLE KEYS */;
INSERT INTO `categoria_video` VALUES ('Carnaval'),('Ciencia y Tecnología'),('Comida'),('Deporte'),('Entretenimiento'),('Gente y blogs'),('Mascotas y animales'),('Música'),('Noticias'),('ONG y activismo'),('Viajes y eventos'),('Videojuegos');
/*!40000 ALTER TABLE `categoria_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios_video`
--

DROP TABLE IF EXISTS `comentarios_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios_video`
--

LOCK TABLES `comentarios_video` WRITE;
/*!40000 ALTER TABLE `comentarios_video` DISABLE KEYS */;
INSERT INTO `comentarios_video` VALUES ('nicoJ','Fue un gran evento','2019-11-05 14:00:00','50 años del InCo',NULL,1,'hectorg'),('hrubino','Para el proximo aniversario ofrezco vamo\' con los Momo','2020-11-08 01:00:00','50 años del InCo','1',2,'hectorg'),('tabarec','Yo ofrezco a la banda tb','2017-09-10 17:00:00','50 años del InCo','2',3,'hectorg'),('nicoJ','Felicitaciones FING!!!','2021-08-07 04:00:00','100 años de FING',NULL,4,'hectorg'),('kairoh','Un gusto cubrir eventos como este.','2021-10-23 12:00:00','Ingeniería de Muestra 2017',NULL,5,'hectorg'),('kairoh','Peñarol peñarol!!!.','2018-10-14 05:00:00','Inauguración Estadio Peñarol',NULL,6,'juliob'),('marcelot','Rock and Rolllll','2018-05-30 02:00:00','Thriller',NULL,7,'juliob'),('marcelot','Anoche explotó!!!','2017-12-18 18:00:00','Dancing in the Dark',NULL,8,'Kairo música'),('marcelot','Me encanta este tema','2020-09-11 03:00:00','Locura Celeste',NULL,9,'Tabaré'),('tabarec','Gracias Marce ;)','2019-05-15 12:00:00','Locura Celeste','9',10,'Tabaré');
/*!40000 ALTER TABLE `comentarios_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_defecto_canal`
--

DROP TABLE IF EXISTS `lista_defecto_canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_defecto_canal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_lista` varchar(100) NOT NULL,
  `canal` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3sx7a9e8qag7xo9k4cu70q0ex` (`canal`)
) ENGINE=InnoDB AUTO_INCREMENT=374 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_defecto_canal`
--

LOCK TABLES `lista_defecto_canal` WRITE;
/*!40000 ALTER TABLE `lista_defecto_canal` DISABLE KEYS */;
INSERT INTO `lista_defecto_canal` VALUES (314,'Historial','Canal Horacio'),(315,'Historial','El bocha'),(316,'Historial','hectorg'),(317,'Historial','Tabaré'),(318,'Historial','El Cachila'),(319,'Historial','juliob'),(320,'Historial','diegop'),(321,'Historial','Kairo música'),(322,'Historial','robinh'),(323,'Historial','Tinelli total'),(324,'Historial','Con la gente'),(325,'Historial','Puglia invita'),(326,'Historial','Chino Recoba'),(327,'Historial','Tony Pacheco'),(328,'Historial','Desde Genexus'),(329,'Escuchar más tarde','Canal Horacio'),(330,'Escuchar más tarde','Chino Recoba'),(331,'Escuchar más tarde','Con la gente'),(332,'Escuchar más tarde','Desde Genexus'),(333,'Escuchar más tarde','diegop'),(334,'Escuchar más tarde','El bocha'),(335,'Escuchar más tarde','El Cachila'),(336,'Escuchar más tarde','hectorg'),(337,'Escuchar más tarde','juliob'),(338,'Escuchar más tarde','Kairo música'),(339,'Escuchar más tarde','Puglia invita'),(340,'Escuchar más tarde','robinh'),(341,'Escuchar más tarde','Tabaré'),(342,'Escuchar más tarde','Tinelli total'),(343,'Escuchar más tarde','Tony Pacheco'),(344,'Deporte total','Canal Horacio'),(345,'Deporte total','Chino Recoba'),(346,'Deporte total','Con la gente'),(347,'Deporte total','Desde Genexus'),(348,'Deporte total','diegop'),(349,'Deporte total','El bocha'),(350,'Deporte total','El Cachila'),(351,'Deporte total','hectorg'),(352,'Deporte total','juliob'),(353,'Deporte total','Kairo música'),(354,'Deporte total','Puglia invita'),(355,'Deporte total','robinh'),(356,'Deporte total','Tabaré'),(357,'Deporte total','Tinelli total'),(358,'Deporte total','Tony Pacheco'),(359,'Novedades generales','Canal Horacio'),(360,'Novedades generales','Chino Recoba'),(361,'Novedades generales','Con la gente'),(362,'Novedades generales','Desde Genexus'),(363,'Novedades generales','diegop'),(364,'Novedades generales','El bocha'),(365,'Novedades generales','El Cachila'),(366,'Novedades generales','hectorg'),(367,'Novedades generales','juliob'),(368,'Novedades generales','Kairo música'),(369,'Novedades generales','Puglia invita'),(370,'Novedades generales','robinh'),(371,'Novedades generales','Tabaré'),(372,'Novedades generales','Tinelli total'),(373,'Novedades generales','Tony Pacheco');
/*!40000 ALTER TABLE `lista_defecto_canal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_defecto_video`
--

DROP TABLE IF EXISTS `lista_defecto_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_defecto_video` (
  `id` int(11) NOT NULL,
  `nombre_video` varchar(100) NOT NULL,
  `nombre_canal_video_origen` varchar(100) NOT NULL,
  KEY `lista_defecto_video_lista_defecto_canal_id_fk` (`id`),
  KEY `lista_defecto_video_videos_canal_nombre_fk` (`nombre_video`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_defecto_video`
--

LOCK TABLES `lista_defecto_video` WRITE;
/*!40000 ALTER TABLE `lista_defecto_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_defecto_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_historica`
--

DROP TABLE IF EXISTS `lista_historica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_historica` (
  `id_lista` int(11) NOT NULL,
  `video` varchar(100) NOT NULL,
  `dueno_video` varchar(100) DEFAULT NULL,
  `visitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_historica`
--

LOCK TABLES `lista_historica` WRITE;
/*!40000 ALTER TABLE `lista_historica` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_historica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_particular_canal`
--

DROP TABLE IF EXISTS `lista_particular_canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_particular_canal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_lista` varchar(100) NOT NULL,
  `canal` varchar(100) NOT NULL,
  `privada` bit(1) NOT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcodr6lbvrytds0hotfe1imn5d` (`canal`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_particular_canal`
--

LOCK TABLES `lista_particular_canal` WRITE;
/*!40000 ALTER TABLE `lista_particular_canal` DISABLE KEYS */;
INSERT INTO `lista_particular_canal` VALUES (76,'Novedades FING','hectorg',_binary '\0','Noticias'),(77,'De fiesta','Tabaré',_binary '','Música'),(78,'De todo un poco','El Cachila',_binary '','Música'),(79,'Solo deportes','juliob',_binary '\0','Deporte'),(80,'Nostalgia','Kairo música',_binary '\0','Música'),(81,'Noticias y CYT','Desde Genexus',_binary '\0','Noticias');
/*!40000 ALTER TABLE `lista_particular_canal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_particular_video`
--

DROP TABLE IF EXISTS `lista_particular_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_particular_video` (
  `id` int(11) NOT NULL,
  `nombre_video` varchar(100) NOT NULL,
  `nombre_canal_video_origen` varchar(100) NOT NULL,
  KEY `lista_particular_video_lista_particular_canal_id_fk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_particular_video`
--

LOCK TABLES `lista_particular_video` WRITE;
/*!40000 ALTER TABLE `lista_particular_video` DISABLE KEYS */;
INSERT INTO `lista_particular_video` VALUES (80,'Sweet child o mine','Kairo música'),(80,'Dancing in the Dark','Kairo música'),(80,'Thriller','Kairo música'),(77,'Locura celeste','El Cachila'),(77,'Niño payaso','El Cachila'),(77,'Etapa Don Timoteo Liguilla','El Cachila'),(76,'100 años de FING','hectorg'),(76,'50 años del InCo','hectorg'),(76,'Ingeniería de Muestra 2017','hectorg'),(78,'Locura Celeste','El Cachila'),(78,'Niño Payaso','El Cachila'),(78,'Etapa A contramano Liguilla','El Cachila'),(78,'Inauguración Estadio Peñarol','juliob'),(78,'Show de goles','juliob'),(79,'Show de goles','juliob'),(79,'Inauguración Estadio Peñarol','juliob'),(81,'Ventana al futuro Uruguay y déficit de ingenieros','Desde Genexus'),(81,'Ingeniería de Muestra 2017','hectorg');
/*!40000 ALTER TABLE `lista_particular_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguir`
--

DROP TABLE IF EXISTS `seguir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seguir` (
  `nickname` varchar(100) NOT NULL,
  `seguido` varchar(100) NOT NULL,
  KEY `FKr8dqhxes6236fhftvt9uxrj4t` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguir`
--

LOCK TABLES `seguir` WRITE;
/*!40000 ALTER TABLE `seguir` DISABLE KEYS */;
INSERT INTO `seguir` VALUES ('hrubino','hectorg'),('hrubino','diegop'),('mbusca','tabarec'),('mbusca','cachilas'),('mbusca','kairoh'),('hectorg','mbusca'),('hectorg','juliob'),('tabarec','hrubino'),('tabarec','cachilas'),('cachilas','hrubino'),('juliob','mbusca'),('juliob','diegop'),('diegop','hectorg'),('kairoh','sergiop'),('robinh','hectorg'),('robinh','juliob'),('robinh','diegop'),('marcelot','cachilas'),('marcelot','juliob'),('marcelot','kairoh'),('novick','hrubino'),('novick','tabarec'),('novick','cachilas'),('sergiop','mbusca'),('sergiop','juliob'),('sergiop','diegop'),('chino','tonyp'),('tonyp','chino'),('nicoJ','diegop');
/*!40000 ALTER TABLE `seguir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('cachilas','Sancho456','Waldemar \"Cachila\"','Silva','Cachila.sil@c1080.org.uy','1947-01-01','/imagenesUsuarios/cachilas.png','El Cachila'),('chino','Laika765','Alvaro','Recoba','chino@trico.org.uy','1976-03-17','/imagenesUsuarios/chino.png','Chino Recoba'),('diegop','Ruffo678','Diego','Parodi','diego@efectocine.com','1974-12-31','/imagenesUsuarios/Defecto.png','diegop'),('hectorg','Pancho345','Héctor','Guido','hector.gui@elgalpon.org.uy','1954-01-07','/imagenesUsuarios/Defecto.png','hectorg'),('hrubino','Rufus123','Horacio','Rubino','horacio.rubino@guambia.com.uy','1962-02-25','/imagenesUsuarios/hrubino.png','Canal Horacio'),('juliob','Salome56','Julio','Bocca','juliobocca@sodre.com.uy','1967-03-16','/imagenesUsuarios/Defecto.png','juliob'),('kairoh','Corbata15','Kairo','Herrera','kairoher@pilsenrock.com.uy','1940-04-25','/imagenesUsuarios/kairoh.png','Kairo música'),('marcelot','Mancha890','Marcelo','Tinelli','marcelot@ideasdelsur.com.ar','1960-04-01','/imagenesUsuarios/Defecto.png','Tinelli total'),('mbusca','Cookie234','Martín','Buscaglia','Martin.bus@agadu.org.uy','1972-06-13','/imagenesUsuarios/mbusca.png','El bocha'),('nicoJ','Albino80','Nicolás','Jodal','jodal@artech.com.uy','1960-08-09','/imagenesUsuarios/Defecto.png','Desde Genexus'),('novick','Xenon987','Edgardo','Novick','edgardo@novick.com.uy','1952-07-17','/imagenesUsuarios/Defecto.png','Con la gente'),('robinh','Aquiles67','Robin','Henderson','robin.h@tinglesa.com.uy','1940-08-03','/imagenesUsuarios/Defecto.png','robinh'),('sergiop','Sultan876','Sergio','Puglia','puglia@alpanpan.com.uy','1950-01-28','/imagenesUsuarios/Defecto.png','Puglia invita'),('tabarec','Ketchup1','Tabaré','Cardozo','tabare.car@agadu.org.uy','1971-07-24','/imagenesUsuarios/tabarec.png','Tabaré'),('tonyp','Kitty543','Antonio','Pacheco','eltony@manya.org.uy','1955-02-14','/imagenesUsuarios/tonyp.png','Tony Pacheco');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER eliminarUsuario AFTER DELETE on usuario FOR EACH ROW
BEGIN
delete from canal_usuario where nombre_canal=old.canal;
delete from comentarios_video where Canal_video=old.canal or nickname=old.nickname;

delete from lista_defecto_video where nombre_canal_video_origen=old.canal;
delete from lista_defecto_canal where canal=old.canal;

delete from lista_particular_video where nombre_canal_video_origen=old.canal;
delete from lista_particular_canal where canal=old.canal;

delete from seguir where nickname=old.nickname or seguido=old.nickname;
delete from valorar where usuario=old.nickname or dueño_Vid=old.nickname;
delete from videos_canal where nombre_canal=old.canal;

insert into usuario_eliminado values(null, old.nickname,old.email,old.canal);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `usuario_eliminado`
--

DROP TABLE IF EXISTS `usuario_eliminado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_eliminado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `canal` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_eliminado`
--

LOCK TABLES `usuario_eliminado` WRITE;
/*!40000 ALTER TABLE `usuario_eliminado` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_eliminado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valorar`
--

DROP TABLE IF EXISTS `valorar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valorar` (
  `dueño_Vid` varchar(100) NOT NULL,
  `video` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `valoracion` varchar(100) NOT NULL,
  PRIMARY KEY (`dueño_Vid`,`video`,`usuario`),
  UNIQUE KEY `valorar_pk` (`dueño_Vid`,`video`,`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valorar`
--

LOCK TABLES `valorar` WRITE;
/*!40000 ALTER TABLE `valorar` DISABLE KEYS */;
INSERT INTO `valorar` VALUES ('hectorg','50 años del InCo','kairoh','Me gusta'),('hectorg','50 años del InCo','nicoJ','Me gusta'),('hectorg','50 años del InCo','sergiop','No me gusta'),('hectorg','Ingeniería de Muestra 2017','sergiop','Me gusta'),('juliob','Inauguración Estadio Peñarol','kairoh','Me gusta'),('juliob','Show de goles','sergiop','Me gusta'),('kairoh','Dancing in the Dark','marcelot','Me gusta'),('tabarec','Locura Celeste','marcelot','Me gusta'),('tabarec','Locura Celeste','nicoJ','No me gusta');
/*!40000 ALTER TABLE `valorar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos_canal`
--

DROP TABLE IF EXISTS `videos_canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videos_canal` (
  `nombre` varchar(100) NOT NULL,
  `nombre_canal` varchar(100) NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `url` varchar(200) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `duracion` varchar(100) NOT NULL,
  `isPrivate` tinyint(1) NOT NULL,
  PRIMARY KEY (`nombre`,`nombre_canal`),
  KEY `videos_canal_categoria_video_categoria_fk` (`categoria`),
  KEY `FKdjjsxs8mnroq1gnfd9h3kan5i` (`nombre_canal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos_canal`
--

LOCK TABLES `videos_canal` WRITE;
/*!40000 ALTER TABLE `videos_canal` DISABLE KEYS */;
INSERT INTO `videos_canal` VALUES ('100 años de FING','hectorg','2017-08-03','https://youtu.be/peGS4TBxSaI','Del Ciclo más Universidad realizado por la UdelaR, compartimos con ustedes un audiovisual realizado en 2016 por los 100 años de la denominación Facultad de Ingeniería.\n\nExtraído del canal Teleuniversitaria UdelaR','Noticias','06:26',0),('50 años del InCo','hectorg','2017-11-24','https://youtu.be/GzOJSk4urlM','50 años del Instituto de Computación. Facultad de Ingeniería. UDELAR. 22 de noviembre 2017.\nLa mesa de apertura estuvo integrada por Simon, el rector de la Universidad de la República (Udelar).','Noticias','27:22',0),('Dancing in the Dark','Kairo música','2009-10-03','https://youtu.be/129kuDCQtHs','Bruce Springsteen\'s official music video for \'Dancing In The Dark\'.','Música','03:58',0),('Entrevista a director CUTI','Desde Genexus','2017-04-03','https://youtu.be/Eq5uBEzI6qs','Segunda parte de la entrevista realizada por la periodista Paula Echevarría al director de CUTI','Ciencia y Tecnología','05:39',0),('Etapa A contramano Liguilla','El Cachila','2015-12-17','https://youtu.be/Es6GRMHXeCQ','4A ETAPA A CONTRAMANO LIGUILLA','Carnaval','57:15',1),('Etapa Don Timoteo Liguilla','El Cachila','2015-12-18','https://youtu.be/I_spHBU9ZsI','2A ETAPA DON TIMOTEO LIGUILLA','Carnaval','51:38',1),('Inauguración Estadio Peñarol','juliob','2016-04-04','https://youtu.be/U6XPJ8Vz72A','Recordemos la ceremonia de inauguración del Estadio de Peñarol.\n\"Estadio Campeón del Siglo\".','Deporte','3:27:26',0),('Ingeniería de Muestra 2017','hectorg','2017-10-25','https://youtu.be/RnaYRA1k5j4','La muestra más grande de la ingeniería nacional se realizó el jueves 19, viernes 20 y sábado 21 de octubre de 2017. Ingeniería deMuestra fue organizada por la Facultad de Ingeniería de la Universidad de la República y su Fundación Julio Ricaldoni.','Noticias','01:00',0),('Locura Celeste','El Cachila','2018-06-05','https://youtu.be/PAfbzKcePx0','Tema Oficial de la cobertura celeste de Monte Carlo Televisión Canal 4 para el Mundial de Futbol FIFA Rusia 2018','Música','03:04',1),('Locura Celeste','Tabaré','2018-06-05','https://youtu.be/PAfbzKcePx0','Tema Oficial de la cobertura celeste de Monte Carlo Televisión Canal 4 para el Mundial de Futbol FIFA Rusia 2018','Música','03:04',1),('Niño Payaso','El Cachila','2016-10-20','https://youtu.be/K-uEIUnyZPg','Niño Payaso Tabaré Cardozo','Música','04:18',1),('Niño Payaso','Tabaré','2016-10-20','https://youtu.be/K-uEIUnyZPg','Niño Payaso Tabaré Cardozo','Música','04:18',1),('Pacheco goles mas recordados','Tabaré','2013-06-05','https://youtu.be/wlEd6-HsIxI','Los goles más recordados de Antonio Pacheco','Deporte','05:48',1),('Pacheco goles mas recordados','Tony Pacheco','2013-06-05','https://youtu.be/wlEd6-HsIxI','Los goles más recordados de Antonio Pacheco','Deporte','05:48',1),('Recoba 20 mejores goles','Chino Recoba','2011-11-13','https://youtu.be/Gy3fZhWdLEQ','Recoba - Top 20 Goals','Deporte','13:26',1),('Recoba 20 mejores goles','El Cachila','2011-11-13','https://youtu.be/Gy3fZhWdLEQ','Recoba - Top 20 Goals','Deporte','13:26',1),('Show de goles','juliob','2018-07-23','https://youtu.be/g46w4_kD_lA','TORNEO CLAUSURA 2018','Deporte','04:23',0),('Sweet child o mine','juliob','2009-12-23','https://youtu.be/1w7OgIMMRc4','Music video by Guns N\' Roses performing Sweet Child O\' Mine. YouTube view counts pre-VEVO: 2,418,311. (C) 1987 Guns N\' Roses under exclusive license to Geffen Records','Música','05:02',0),('Sweet child o mine','Kairo música','2009-12-23','https://youtu.be/1w7OgIMMRc4','Music video by Guns N\' Roses performing Sweet Child O\' Mine. YouTube view counts pre-VEVO: 2,418,311. (C) 1987 Guns N\' Roses under exclusive license to Geffen Records','Música','05:02',0),('Thriller','juliob','2009-10-02','https://youtu.be/sOnqjkJTMaA','Michael Jackson\'s official music video for \"Thriller\"','Música','13:42',0),('Thriller','Kairo música','2009-10-02','https://youtu.be/sOnqjkJTMaA','Michael Jackson\'s official music video for \"Thriller\"','Música','13:42',0),('Ventana al futuro Uruguay y déficit de ingenieros','Desde Genexus','2016-07-20','https://youtu.be/zBR2pnASlQE','En Uruguay hay un ingeniero por cada tres abogados y cada seis médicos. Los datos se desprenden del Panorama de la Educación 2014 del anuario del Ministerio de Educación y Cultura. Ese año egresaron de la Universidad de la República 348 ingenieros.','Ciencia y Tecnología','19:21',0);
/*!40000 ALTER TABLE `videos_canal` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
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

-- Dump completed on 2019-11-11 11:54:31

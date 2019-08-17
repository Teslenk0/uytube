#  UYTUBE
La plataforma UyTube ofrece un servicio de intercambio y reproducción de videos en línea
con contenido nacional. Si bien la plataforma es de acceso libre, los usuarios pueden
registrarse utilizando sus datos personales para acceder a un conjunto de funcionalidades
personalizadas.



## Caracteristicas tecnicas

El sistema va a ser desarrollado en Java y se van a utilizar algunas tecnologías
particulares de las plataformas Java SE 8 y Java EE. En particular: Web Services
, Servlets y Java Server Pages (JSP). Dado el requerimiento de disponer de
un sitio web se va a utilizar el servidor Web Tomcat que contiene soporte para
realizar las interfaces gráficas con páginas JSP y Servlets. La interfaz gráfica del
administrador será desarrollada con Swing.


##  Persistencia de datos
* Se utilizara como motor de base de datos MySQL (v5.7 o mayor)
* JPA es la api con la que se realiza el fetch de datos

###  Credenciales predefinida para el acceso a la base de datos
* User: uytube
* Password: Uytube++2019

## Tablas en BD -> uytubeAPP

###                   usuario

* +----------+--------------+------+-----+---------+-------+
* | Field    | Type         | Null | Key | Default | Extra |
* +----------+--------------+------+-----+---------+-------+
* | nickname | varchar(100) | NO   | PRI | NULL    |       |
* | nombre   | varchar(100) | NO   |     | NULL    |       |
* | apellido | varchar(100) | NO   |     | NULL    |       |
* | email    | varchar(254) | NO   | PRI | NULL    |       |
* | fechaNac | date         | NO   |     | NULL    |       |
* | imagen   | text         | YES  |     | NULL    |       |
* | isAdmin  | bit(1)       | NO   |     | NULL    |       |
* +----------+--------------+------+-----+---------+-------+


###                   canal_usuario
* +-------------+--------------+------+-----+---------+-------+
* | Field       | Type         | Null | Key | Default | Extra |
* +-------------+--------------+------+-----+---------+-------+
* | nickname    | varchar(100) | NO   | PRI | NULL    |       |
* | descripcion | text         | NO   |     | NULL    |       |
* | isPrivate   | bit(1)       | NO   |     | NULL    |       |
* +-------------+--------------+------+-----+---------+-------+


### categoria_video
* +-------------+--------------+------+-----+---------+-------+
* | Field       | Type         | Null | Key | Default | Extra |
* +-------------+--------------+------+-----+---------+-------+
* | nickname    | varchar(100) | NO   | PRI | NULL    |       |
* | descripcion | text         | NO   |     | NULL    |       |
* | isPrivate   | bit(1)       | NO   |     | NULL    |       |
* +-------------+--------------+------+-----+---------+-------+


### videos_canal
* +-------------------+--------------+------+-----+---------+-------+
* | Field             | Type         | Null | Key | Default | Extra |
* +-------------------+--------------+------+-----+---------+-------+
* | nombre            | varchar(100) | NO   | PRI | NULL    |       |
* | nickname          | varchar(100) | NO   | PRI | NULL    |       |
* | duracion          | int(11)      | NO   |     | NULL    |       |
* | fecha_publicacion | date         | NO   |     | NULL    |       |
* | url               | text         | NO   |     | NULL    |       |
* | descripcion       | text         | NO   |     | NULL    |       |
* | categoria         | varchar(100) | NO   | MUL | NULL    |       |
* +-------------------+--------------+------+-----+---------+-------+

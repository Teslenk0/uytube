# **UYTUBE**

## **Plataforma uruguaya de reproduccion de videos**

### **Breve descripcion del projecto**
UyTube es una plataforma uruguaya de reproduccion de videos, en proceso de desarrollo y testing.

UyTube ofrece un servicio de intercambio y reproducción de videos en línea
con contenido nacional. Si bien la plataforma es de acceso libre, los usuarios pueden
registrarse utilizando sus datos personales para acceder a un conjunto de funcionalidades
personalizadas.


### **Aspectos tecnicos**
En estos momentos cuenta con **5 colaboradores activos** los cuales estan contribuyendo diariamente para mejorar funcionalidades e integracion, para asi lograr una mejor experiencia a la hora de utlizarla.

El lenguaje utilizado es JAVA EE y JAVA SE. A la hora de persistir la informacion se utiliza JPA + Hibernate como ORM, de esta forma se llega a una muy buena integracion con MySQL (InnoDB), actual motor de base de datos. 

La publicacion y posterior puesta en produccion se realizara sobre un contenedor de servlets, como por ejemplo Apache TOMCAT o GlassFish.


### **Estado actual**
Actualmente, se esta trabajando en el acceso a un panel de administracion estilo backend, el cual solo podra ser accedido mediante el ingreso al servidor en que estara alojado. Permite el acceso a **un solo usuario administrador** (posteriormente se integrara la posibilidad de agregar mas usuarios administrador), el cual tiene los siguientes privilegios:

- Alta de Usuario

- Consulta de Usuario

- Modificar Datos de Usuario

- Listar Usuarios Existentes

- Alta de Video

- Modificar Datos de Video

- Consulta de Video

- Comentar un Video

- Valorar un Video

- Seguir a un Usuario

- Dejar de Seguir a un Usuario

- Crear Lista de Reproducción

- Modificar Lista de Reproducción

- Agregar Video a Lista de Reproducción

- Quitar Video de Lista de Reproducción

- Consulta de Lista de Reproducción

- lta de Categoría

- Consulta de Categoría

- Listar Categorías Existentes

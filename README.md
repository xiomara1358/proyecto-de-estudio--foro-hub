📌 ForoHub - API REST con Spring Boot y MySQL
📖 Descripción

ForoHub es una API REST que permite gestionar tópicos, usuarios y perfiles (roles).
El backend está construido en Spring Boot 3, con autenticación mediante Spring Security y persistencia en MySQL.

🛠️ Tecnologías usadas

Java 17

Spring Boot 3

Spring Web

Spring Data JPA

Spring Security

Validation

Lombok

Flyway Migration

MySQL Driver

DevTools

🗄️ Base de Datos (MySQL)
1️⃣ Creación de la BD
CREATE DATABASE ForoHub;
USE ForoHub;

2️⃣ Tablas principales
-- Tabla usuario
CREATE TABLE usuario (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  correo_electronico VARCHAR(150) UNIQUE NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla perfil (roles)
CREATE TABLE perfil (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla relación usuario_perfil
CREATE TABLE usuario_perfil (
  id_usuario BIGINT NOT NULL,
  id_perfil BIGINT NOT NULL,
  PRIMARY KEY (id_usuario, id_perfil),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id),
  FOREIGN KEY (id_perfil) REFERENCES perfil(id)
);

-- Tabla tópico
CREATE TABLE topic (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  mensaje TEXT NOT NULL,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  autor VARCHAR(100) NOT NULL
);

3️⃣ Insertar datos de prueba
-- Perfiles
INSERT INTO perfil (nombre) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

-- Usuario admin con contraseña "1234" encriptada con BCrypt
INSERT INTO usuario (nombre, correo_electronico, contrasena)
VALUES ('Admin Test', 'admin@forohub.com',
'$2a$10$Dow1sYo2T2y5Y2QchhlHceGnqg0H2V1qDR3ZjJGrheFAnPtZZQ61K');

-- Relación usuario - perfil
INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES (1, 1);

⚙️ Configuración de Spring Boot

En src/main/resources/application.properties:

spring.application.name=ForoHub
server.port=8080

# Configuración MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/forohub?useSSL=false&serverTimezone=UTC
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Flyway (migraciones)
spring.flyway.enabled=true

🔐 Seguridad (Spring Security)

Login vía HTTP Basic

Usuario = correo electrónico (columna correo_electronico)

Password = contraseña encriptada con BCrypt

Roles = nombres de la tabla perfil

🚀 Endpoints principales
Público

GET /api/topics → Lista todos los tópicos

POST /api/topics → Crear un nuevo tópico

Protegido (requiere login)

GET /api/usuarios → Lista usuarios (solo con credenciales válidas)

🔎 Pruebas rápidas
1️⃣ Levantar el servidor
mvn spring-boot:run

2️⃣ Probar en navegador
http://localhost:8080/api/topics

3️⃣ Probar login en Postman

Método: GET

URL: http://localhost:8080/api/usuarios

Auth → Basic Auth

Username: admin@forohub.com

Password: 1234

📌 Con esto tendrás un proyecto documentado tanto en la parte de Spring Boot como de MySQL.

¿Quieres que te lo arme directamente en un archivo README.md dentro del zip del proyecto para que lo tengas ya integrado?

Dijiste:
coloca el autor xiomara y que me apoye de chat gpt ,vs code ,mysql 
ChatGPT dijo:

¡Perfecto! 🙌
Aquí tienes el README.md ya actualizado con tu autor Xiomara y la nota de apoyo en ChatGPT, VS Code y MySQL.

📌 ForoHub - API REST con Spring Boot y MySQL
📖 Descripción

ForoHub es una API REST que permite gestionar tópicos, usuarios y perfiles (roles).
El backend está construido en Spring Boot 3, con autenticación mediante Spring Security y persistencia en MySQL.

👩‍💻 Autor

Xiomara
Proyecto desarrollado con apoyo de ChatGPT, VS Code y MySQL.

🛠️ Tecnologías usadas

Java 17

Spring Boot 3

Spring Web

Spring Data JPA

Spring Security

Validation

Lombok

Flyway Migration

MySQL Driver

DevTools

🗄️ Base de Datos (MySQL)
1️⃣ Creación de la BD
CREATE DATABASE ForoHub;
USE ForoHub;

2️⃣ Tablas principales
-- Tabla usuario
CREATE TABLE usuario (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  correo_electronico VARCHAR(150) UNIQUE NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla perfil (roles)
CREATE TABLE perfil (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla relación usuario_perfil
CREATE TABLE usuario_perfil (
  id_usuario BIGINT NOT NULL,
  id_perfil BIGINT NOT NULL,
  PRIMARY KEY (id_usuario, id_perfil),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id),
  FOREIGN KEY (id_perfil) REFERENCES perfil(id)
);

-- Tabla tópico
CREATE TABLE topic (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  mensaje TEXT NOT NULL,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  autor VARCHAR(100) NOT NULL
);

3️⃣ Insertar datos de prueba
-- Perfiles
INSERT INTO perfil (nombre) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

-- Usuario admin con contraseña "1234" encriptada con BCrypt
INSERT INTO usuario (nombre, correo_electronico, contrasena)
VALUES ('Admin Test', 'admin@forohub.com',
'$2a$10$Dow1sYo2T2y5Y2QchhlHceGnqg0H2V1qDR3ZjJGrheFAnPtZZQ61K');

-- Relación usuario - perfil
INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES (1, 1);

⚙️ Configuración de Spring Boot

En src/main/resources/application.properties:

spring.application.name=ForoHub
server.port=8080

# Configuración MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/forohub?useSSL=false&serverTimezone=UTC
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Flyway (migraciones)
spring.flyway.enabled=true

🔐 Seguridad (Spring Security)

Login vía HTTP Basic

Usuario = correo electrónico (columna correo_electronico)

Password = contraseña encriptada con BCrypt

Roles = nombres de la tabla perfil

🚀 Endpoints principales
Público

GET /api/topics → Lista todos los tópicos

POST /api/topics → Crear un nuevo tópico

Protegido (requiere login)

GET /api/usuarios → Lista usuarios (solo con credenciales válidas)

🔎 Pruebas rápidas
1️⃣ Levantar el servidor
mvn spring-boot:run

2️⃣ Probar en navegador
http://localhost:8080/api/topics

3️⃣ Probar login en Postman

Método: GET

URL: http://localhost:8080/api/usuarios

Auth → Basic Auth

Username: admin@forohub.com

Password: 1234


comentarios:no se si esta del todo bien lo que hice ,se me dificulta ,todavia no le se mucho ala programacion ,pero puse mi mayor efuerzo para intentar entregar el trabajo , siento que la parte de ejecutarlo  ala vinculacion es la que me  esta  fallando  agradeceria si alguien fuera amable de ayudarme arevisarlo para ver lo que esta mal (gracias por su comprension),seguire estudiando de igual manera .

observación:me apoye mucho de chat gpt para realizarlo 
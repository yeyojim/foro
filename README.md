<h1 align="center"> FORO_HUB </h1>

![meeting_06](https://github.com/user-attachments/assets/05d92bf7-aead-4bc7-8f0b-2cdb28b48930)



 ![Badge1](https://img.shields.io/badge/JAVA-v.17-red?style=plastic&labelColor=blue&color=green)  ![Badge2](https://img.shields.io/badge/SPRIN%20BOOT-v.3.3.6-red?style=plastic&labelColor=green&color=gray)  ![Badge3](https://img.shields.io/badge/POSTGRESSQL-red?style=plastic&labelColor=red&color=gray) 
| ![Badge1](https://img.shields.io/badge/LOMBOK-RED)  ![Badge2](https://img.shields.io/badge/MAVEN-RED)  ![Badge3](https://img.shields.io/badge/FLYWAYDB-RED?labelColor=red&color=red) ![Badge3](https://img.shields.io/badge/JWT-RED?labelColor=red&color=blue
) 


Bienvenido a la REST API del Foro. Este servicio proporciona un conjunto de endpoints para gestionar un foro básico, permitiendo la autenticación, la creación y gestión de tópicos, y otras operaciones esenciales.

## Características

- **Autenticación de usuarios**: Login para acceder a las funcionalidades del foro.
- **Gestión de tópicos**: Crear, listar, actualizar y eliminar tópicos.
- **Estructura sencilla**: Diseñada para una fácil integración con clientes frontend o aplicaciones móviles.

## Endpoints

### Autenticación

#### POST `/autenticacion`
Permite autenticar a un usuario en el sistema.

- **Cuerpo de la solicitud (JSON):**
  ```json
  {
    "login": "usuario",
    "clave": "contraseña"
  }
  ```

- **Respuesta (200 OK):**
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    
  }
  ```

---

### Gestión de Tópicos

#### POST `/topicos`
Registra un nuevo tópico en el sistema.

- **Cuerpo de la solicitud (JSON):**
  ```json
  {
    "idusuario": "13",
    "mensaje": "Sin errores, no problem",
    "nombreCurso": "HTTP en la web",
    "titulo": "Sin problemas con red",
    "autor": "D JIMENEZ QUEVEDO"
  }
  ```

- **Respuesta (200 OK):**
  ```json
  {
    "id": 15,
	"titulo": "Sin problemas con red",
	"mensaje": "Sin errores, no problem",
	"fechaCreacion": "2025-01-21 11:42:58"  
  }
  ```

---

#### GET `/topicos`
Lista todos los tópicos disponibles en el foro.

- **Respuesta (200 OK):**
  ```json
  [
    {
	"content": [
		{
			"idusuario": "6",
			"mensaje": "Error 200 al ejecutar una requsicion",
			"nombreCurso": "HTTP en la web",
			"titulo": "problemas con red",
			"autor": "ORACLE ALURA"
		},
		{
			"idusuario": "8",
			"mensaje": "Error 501 al ejecutar una requsicion",
			"nombreCurso": "HTTP en la web",
			"titulo": "problemas con red",
			"autor": "priscila quevedo"
		},
		{
			"idusuario": "9",
			"mensaje": "Error 501 al ejecutar una requsicion",
			"nombreCurso": "HTTP en la web",
			"titulo": "problemas con red",
			"autor": "ninini"
		},
		{
			"idusuario": "10",
			"mensaje": "Sin errores",
			"nombreCurso": "HTTP en la web",
			"titulo": "Sin problemas con red",
			"autor": "DIVA PRISCILA QUEVEDO JARA"
		},
  ]
  ```

---

#### POST `/topicos/{id}`
Obtiene la información detallada de un tópico específico.

- **Parámetros de la URL:**
  - `id` (número): ID del tópico a consultar.
    http://localhost:8080/topicos/8

- **Respuesta (200 OK):**
  ```json
  {
    "id": 8,
	"titulo": "problemas con red",
	"mensaje": "Error 200 al ejecutar una requsicion",
	"fechaCreacion": "2025-01-20 18:08:12"

  }
  ```

---

#### PUT `/topicos/{id}`
Actualiza la información de un tópico existente.

- **Parámetros de la URL:**
  - `id` (número): ID del tópico a actualizar.

- **Cuerpo de la solicitud (JSON):**
  ```json
  {
			"id": "14",
			"autor": "MIGUEL ARTURO JIMENEZ QUEVEDO "
		}
  ```

- **Respuesta (200 OK):**
  ```json
  {
    "id": 14,
	"titulo": "Sin problemas con red",
	"mensaje": "Sin errores, no problem",
	"fechaCreacion": "2025-01-21 08:39:07"
  }
  ```

---

#### DEL `/topicos/{id}`
Elimina un tópico específico.

- **Parámetros de la URL:**
  - `id` (número): ID del tópico a eliminar.
  - http://localhost:8080/topicos/15

- **Respuesta (204 NO CONTENT):**
  ```json
  
  
  ```

---

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/foro-rest-api.git
   ```

2. Configura el archivo `application.properties` o `application.yml` con las variables necesarias (por ejemplo, base de datos y claves secretas):

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/tu_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña

   spring.jpa.hibernate.ddl-auto=update
   spring.security.jwt.secret=claveSecretaParaJWT
   ```

3. Construye y ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

## Tecnologías Usadas

- **Java** para el backend.
- **Spring Boot** como framework principal.
- **Spring Security** para la autenticación y autorización.
- **Spring Data JPA** para la interacción con la base de datos.
- **PostgreSQL** para la base de datos.
- **BCrypt** para la encriptación de contraseñas.
- **JWT** para la autenticación.

## Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).



 



# Sistema de Ventas e Inventarios

Este proyecto es una aplicación de gestión de ventas e inventarios utilizando **Spring Boot** y **JPA**. La aplicación permite realizar operaciones CRUD sobre productos y ventas a través de una API RESTful.

## Requisitos

- Java 17 o superior.
- Maven 3.6 o superior.
- PostgreSQL (si utilizas esta base de datos).

## Instalación

### Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/sistema-ventas-inventario.git
cd sistema-ventas-inventario


Configuración de base de datos
Asegúrate de que tienes PostgreSQL corriendo y una base de datos configurada.
Configura el archivo application.properties o application.yml con tus credenciales de base de datos:
properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/tu_basedatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=org.postgresql.Driver
Construcción y ejecución del proyecto
Compilar y ejecutar el proyecto:
bash
Copiar código
mvn clean install
mvn spring-boot:run
Acceder a la API:
La API estará corriendo en el puerto 8080 de forma predeterminada.

Acceder a Swagger UI
Una vez que la aplicación esté corriendo, puedes acceder a la documentación de la API a través de Swagger UI:


http://localhost:8080/swagger-ui/index.html


Pruebas en swagger 

GET /api/productos - Obtener todos los productos
Descripción: Obtiene la lista de todos los productos registrados en el sistema.
Ejemplo de consulta:
Método: GET

Ejemplo de respuesta:

[
    {"id": 1, "nombre": "Producto A", "precio": 100.0, "stock": 50},
    {"id": 2, "nombre": "Producto B", "precio": 150.0, "stock": 30}
]



 POST /api/productos - Crear un nuevo producto
Descripción: Crea un nuevo producto en el sistema.

Ejemplo de consulta:

Método: POST

Cuerpo (Request Body):

{
    "nombre": "Producto C",
    "precio": 200.0,
    "stock": 100
}



 PUT /api/productos/{id} - Actualizar un producto
Descripción: Actualiza un producto existente por su ID.

Ejemplo de consulta:

Método: PUT

Cuerpo (Request Body):

{
    "nombre": "Producto A Actualizado",
    "precio": 120.0,
    "stock": 80
}

 GET /api/ventas - Obtener todas las ventas
Descripción: Obtiene la lista de todas las ventas registradas en el sistema.
Ejemplo de consulta:
Método: GET


POST /api/ventas - Crear una nueva venta
Descripción: Crea una nueva venta en el sistema.

Ejemplo de consulta:

Método: POST

Cuerpo (Request Body):

{
    "fecha": "2024-11-28",
    "producto": {"id": 1},
    "cantidad": 2,
    "total": 200.0
}
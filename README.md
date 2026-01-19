Sistema de Gestión de Reservas para Gimnasio 🏋️‍♂️


Este es un proyecto Fullstack desarrollado como parte de mi formación profesional. El sistema permite gestionar socios, clases de gimnasio y realizar reservas en tiempo real validando la capacidad máxima de cada clase.


🚀 Tecnologías Utilizadas


Backend: Java 21 con Spring Boot 3.4.x.

Persistencia: Spring Data JPA con base de datos H2 (en memoria).

Documentación: Swagger UI (OpenAPI 3) para testeo de endpoints.

Frontend: Interfaz web dinámica utilizando JavaScript (Fetch API) y Bootstrap 5 para el diseño responsivo.


🛠️ Características Principales


Arquitectura en capas: Separación clara entre Controladores, Servicios y Repositorios.

Lógica de Negocio: El sistema descuenta automáticamente un cupo de la clase al realizar una reserva exitosa y bloquea nuevas reservas si el cupo está lleno.

API REST: Endpoints optimizados para la creación y consulta de Usuarios, Clases y Reservas.


💻 Cómo ejecutar el proyecto


Clona este repositorio: git clone https://github.com/Mateo-Nicolas-Capurro/gym-reservas-project.git.

Ejecuta la aplicación desde tu IDE favorito (IntelliJ IDEA recomendado).

Accede a la interfaz web en: http://localhost:8080/index.html.

Explora la documentación de la API en: http://localhost:8080/swagger-ui/index.html.

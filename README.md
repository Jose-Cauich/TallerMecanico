
Sistema de Gestión de TallerMecanico

→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→

Descripción

Sistema de gestión de Taller mecánico desarrollado con Spring Boot y PostgreSQL.
Administra tres tipos de perfiles: Cliente, Mecanico y Empleados(Administrativo). Permite gestionar servicios como: clientes, paquetes, historial, pagos, empelados y refacciones .


→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→

Tecnologías

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Maven

→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→

Arquitectura

El proyecto sigue una arquitectura en capas basada en el patrón MVC:

- Controller
- Service
- Mapper
- Entity
- Repository
- Database
- DTOs

→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→

Decisiones Arquitectónicas

- Patrón DTO: Los datos sensibles como contraseñas nunca se exponen. Se usan DTOs separados para entrada (Post), salida (Get) y actualización (Update).
- Patrón Mapper: Clases estáticas responsables de convertir entre Entities y DTOs, manteniendo las capas desacopladas.

→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→

Estado del Proyecto

- Base de Datos        (Completado)
- Entidades JPA        (Completado)
- DTOs                 (Completado)
- Mappers              (Completado)
- Servicios            (Completado)
- Controladores        (Completado)
- Seguridad (JWT)      (Pendiente)
- Integración Stripe   (Pendiente)


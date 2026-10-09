# E-commerce de productos de computación (Backend)

Proyecto académico (Laboratorio III, Universidad del Aconcagua). API REST para un e-commerce de productos de computación, desarrollada con Java y Spring Boot sobre una base de datos PostgreSQL.

> **Estado:** en desarrollo. Por ahora el proyecto cubre solo el backend; el frontend será desarrollado más adelante.

## Tecnologías

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Flyway (migraciones de base de datos)
- MapStruct (mapeo entre entidades y DTOs)
- Bean Validation
- Swagger / OpenAPI (documentación de endpoints)
- Git y GitHub

## Arquitectura

El proyecto sigue una arquitectura en capas:

```
Controller  →  Service  →  Repository  →  Base de datos
   (DTOs)     (lógica,       (acceso a
              @Transactional)   datos)
```

- **Controller:** recibe las peticiones HTTP y devuelve `ResponseEntity`.
- **Service:** convierte entre DTO y entidad, y maneja logica de negocio.
- **Repository:** solo acceso a datos con Spring Data JPA.
- **DTOs:** `RequestDTO` / `ResponseDTO` por entidad, con validaciones.

## Modelo de datos

El modelo relacional tiene 8 entidades:

`Categoria`, `Producto`, `Usuario`, `Carrito`, `DetalleCarrito`, `Pedido`, `DetallePedido` y `Pago`.



Se aplico bean validation en los Dtos

### Migraciones

La estructura de la base de datos se crea con una migración de Flyway (`V1__baseline.sql`), que define las tablas y restricciones del modelo.

## Documentación de la API

Los endpoints están documentados con Swagger (OpenAPI).




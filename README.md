# KataPedidos

Este proyecto es una API que permite obtener y gestionar pedidos de un servicio web externo. Está diseñado con una **estructura de capas**, lo que permite una separación clara de responsabilidades entre la lógica de negocio, la capa de acceso a datos, y la capa de presentación. Este enfoque modular facilita el mantenimiento, la escalabilidad y la reutilización del código en diferentes partes de la aplicación.

## Estructura de Capas

- **Controlador (Controller)**: Se encarga de gestionar las solicitudes HTTP y enviar las respuestas adecuadas.
- **Servicio (Service)**: Contiene la lógica de negocio. Aquí es donde se procesan los pedidos.
- **Persistencia (Repository/Data)**: Maneja el acceso a los datos y la persistencia de los pedidos en la base de datos.
- **Dominio (Domain)**: Representa las entidades del negocio, como el objeto `Pedido`.

### Beneficios de la Estructura de Capas

- **Mantenibilidad**: El código está bien organizado, lo que facilita la identificación y resolución de problemas.
- **Escalabilidad**: Cada capa puede ser modificada o extendida de manera independiente sin afectar a las demás.
- **Reutilización**: Las funcionalidades implementadas en una capa pueden ser reutilizadas en otras partes del proyecto.

## Características

- **Obtención de Pedidos**: Recupera pedidos desde un servicio externo con soporte de paginación.
- **Exportación a CSV**: Exporta los pedidos a un archivo CSV con toda la información relevante de los pedidos.
- **Guardado en MySQL**: Almacena los pedidos en una base de datos MySQL para una gestión persistente.
- **Paginación**: Soporte de paginación para la recuperación de grandes conjuntos de datos.

## Requisitos Previos

- Java 8 o superior.
- Maven 3.6.x o superior.
- MySQL 5.7 o superior.
- Spring Boot 2.5.x o superior.

## Instalación

1. Clona el repositorio:

   `git clone https://github.com/galxystar/KataPedidos.git`

2. Accede al directorio del proyecto:

   `cd KataPedidos`

3. Configura la base de datos MySQL:

   - Crea una base de datos llamada `KATA`:

     ```sql
     CREATE DATABASE IF NOT EXISTS KATA;
     USE KATA;
     CREATE TABLE IF NOT EXISTS pedidos (
         uuid VARCHAR(36) NOT NULL,
         id VARCHAR(50) NOT NULL,
         region VARCHAR(100),
         country VARCHAR(100),
         item_type VARCHAR(100),
         sales_channel VARCHAR(50),
         priority VARCHAR(50),
         date DATE,
         ship_date DATE,
         units_sold INT,
         unit_price DECIMAL(10, 2),
         unit_cost DECIMAL(10, 2),
         total_revenue DECIMAL(15, 2),
         total_cost DECIMAL(15, 2),
         total_profit DECIMAL(15, 2),
         PRIMARY KEY (uuid)
     );
     ```

   - Modifica las credenciales de la base de datos en el archivo `application.properties` o `application.yml` (según el que estés usando) con tu configuración de MySQL.

4. Instala las dependencias con Maven:

   `mvn clean install`

5. Ejecuta la aplicación:

   `mvn spring-boot:run`

## Uso

### API de Pedidos

- **Obtener todos los pedidos**:

  `GET /api/pedidos/all?page={numeroPagina}&maxPorPagina={cantidadPorPagina}`

  Este endpoint permite obtener todos los pedidos, soportando parámetros opcionales de paginación.

### Exportación a CSV

Los pedidos exportados se guardan en un archivo CSV, que contiene las siguientes columnas:

- Order ID
- Order Priority
- Order Date
- Region
- Country
- Item Type
- Sales Channel
- Ship Date
- Units Sold
- Unit Price
- Unit Cost
- Total Revenue
- Total Cost
- Total Profit

### Guardado en Base de Datos

Los pedidos obtenidos se pueden almacenar en una base de datos MySQL utilizando un servicio de persistencia. Los datos incluyen campos como:

- uuid
- id
- region
- country
- item_type
- sales_channel
- priority
- date
- ship_date
- units_sold
- unit_price
- unit_cost
- total_revenue
- total_cost
- total_profit

## Contribuir

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-feature`).
3. Realiza tus cambios.
4. Haz un commit de tus cambios (`git commit -am 'Añadir nueva feature'`).
5. Empuja los cambios a tu rama (`git push origin feature/nueva-feature`).
6. Abre un Pull Request.

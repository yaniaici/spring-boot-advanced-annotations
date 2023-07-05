Proyecto Java Spring con Anotaciones Avanzadas y CRUD

Este proyecto implementa un CRUD (Create, Read, Update, Delete) utilizando Java Spring y aprovechando las anotaciones avanzadas de Spring para el mapeo objeto-relacional. El objetivo principal es demostrar el uso de estas anotaciones para el manejo de entidades y relaciones en una base de datos.
Tecnologías utilizadas

    Java
    Spring Framework
    Hibernate ORM
    Maven
    MySQL
    JPA

Funcionalidades

La aplicación implementa las siguientes funcionalidades básicas:

    Crear un instructor con detalles asociados.
    Leer información de un instructor y sus detalles.
    Actualizar la información de un instructor y sus detalles.
    Eliminar un instructor y sus detalles.
    Gestionar cursos
    Gestionar reviews por curso

Estructura del proyecto

El proyecto sigue la estructura típica de una aplicación Java Spring:

    src/main/java: Contiene los archivos fuente de la aplicación.
        com.example.application: Paquete principal de la aplicación.
            controller: Controladores de la aplicación para manejar las solicitudes HTTP.
            dao: Acceso a datos y clases de persistencia.
            entity: Entidades que representan las tablas de la base de datos.
            service: Servicios que encapsulan la lógica de negocio.
    src/main/resources: Contiene los archivos de configuración y recursos.
        application.properties: Configuración de la aplicación, incluyendo la conexión a la base de datos.
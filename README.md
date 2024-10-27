# ms-user

Microservicio para gestionar el accessToken

# Docker


1. Generamos nuestro jar.

> mvn clean package

2. Elaboramos el archivo Dockerfile en el directorio raiz del proyecto.

> Dockerfile:
FROM openjdk:17
WORKDIR /app
COPY ./target/ms-user-0.0.1-SNAPSHOT.jar .
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "ms-user-0.0.1-SNAPSHOT.jar"]


3. Construimos la imagen.
> docker build -t user .
> docker build -t user .  -f .\ms-user\Dockerfile

4. Crear una nueva red

> docker network create springboot

5. Instanciamos la imagen, construir contenedor:

> docker run -p 8090:8090 --name ms-user --network springboot user

# OPENAPI

http://localhost:8090/swagger-ui/index.html

http://localhost:8090/v3/api-docs
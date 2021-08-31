# BCP - Prueba técnica

### Descripción

Dentro del proyecto se usaron las siguientes herramientas:

```
- Spring Boot 2
- RX Java
- Maven
- H2 Database
- JPA
- Lombok
```

### Despliegue

Para poder levantar el proyecto con docker, realizar los siguientes pasos:

1. Empaquetar el proyecto
```shell
mvn clean package
```

2. Construir la imagen
```shell
docker build -t bcp-tech .
```

3. Levantar el contenedor con la imagen construida
```shell
docker run -d -p 8080:8080 --name bcp-tech --restart always bcp-tech
```

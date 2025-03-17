#Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

#Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

#Copiar el archivo JAR de la aplicación al contenedor
COPY target/grupo13-0.0.1-SNAPSHOT.jar app.jar

#Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

#Comando para ejecutar la aplicación
ENTRYPOINT [ "java", "-jar", "app.jar" ]
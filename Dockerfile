FROM openjdk:8-jdk-alpine
LABEL Alejandro Deulofeu <alew3bslution@gmail.com>

ARG JAR_FILE=target/drones.jar
COPY ${JAR_FILE} sales_force_app.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","/app.jar"]
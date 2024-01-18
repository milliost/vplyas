FROM openjdk:22-ea-30

COPY target/vplyas-0.0.1-SNAPSHOT.jar .
COPY .env .
COPY /src/main/resources/application.properties .

EXPOSE 81

ENTRYPOINT ["java", "-jar", "vplyas-0.0.1-SNAPSHOT.jar"]
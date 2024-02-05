FROM openjdk:latest

COPY .env .
COPY /keystore.p12 .
COPY /vplyas-0.0.1-SNAPSHOT.jar .



EXPOSE 443

ENTRYPOINT ["java", "-jar", "vplyas-0.0.1-SNAPSHOT.jar"]
FROM openjdk:latest

COPY .env .
COPY /keystore.p12 .
COPY /target/vplyas-0.0.1-SNAPSHOT.war .



EXPOSE 443

ENTRYPOINT ["java", "-jar", "vplyas-0.0.1-SNAPSHOT.war"]
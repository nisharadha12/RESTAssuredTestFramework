FROM maven:3.9.6-eclipse-temurin
COPY src home/Restframework/src
COPY index.html home/Restframework/index.html
COPY pom.xml home/Restframework/pom.xml
COPY testng.xml home/Restframework/testng.xml
COPY output home/Restframework/output
WORKDIR home/Restframework
ENTRYPOINT mvn clean test
FROM eclipse-temurin:21-jdk-focal

COPY target/examengavilanes-0.0.1-SNAPSHOT.jar examen2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/examengavilanes-0.0.1-SNAPSHOT.jar"]
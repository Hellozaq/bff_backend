FROM eclipse-temurin:21-jdk AS buildstage

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests=true

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=buildstage /app/target/bff_backend-0.0.1-SNAPSHOT.jar ./bff_backend.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "/app/bff_backend.jar"]

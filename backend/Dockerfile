FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml ./

RUN chmod +x mvnw

COPY src ./src

RUN ./mvnw -q -DskipTests package

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=docker

ENTRYPOINT ["java","-jar","app.jar"]


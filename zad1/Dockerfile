FROM sbtscala/scala-sbt:eclipse-temurin-alpine-17.0.15_6_1.11.7_3.3.7 AS builder

WORKDIR /app

COPY build.sbt .
COPY project/plugins.sbt ./project/

RUN sbt update

COPY . .

RUN sbt assembly

FROM eclipse-temurin:17-jre-alpine

WORKDIR /opt/app

COPY --from=builder /app/target/scala-3.3.7/app-assembly.jar .

EXPOSE 8080

CMD ["java", "-jar", "app-assembly.jar", "--host", "0.0.0.0", "--port", "8080"]

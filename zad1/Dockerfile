FROM sbtscala/scala-sbt:eclipse-temurin-alpine-24.0.1_9_1.11.7_3.7.3

RUN apk add --no-cache curl

WORKDIR /app
COPY ./build.sbt .
COPY . .
EXPOSE 8080

CMD ["sbt", "~run --host 0.0.0.0"]
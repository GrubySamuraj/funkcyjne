FROM sbtscala/scala-sbt:eclipse-temurin-alpine-17.0.15_6_1.11.7_3.3.7

RUN apk add --no-cache curl

WORKDIR /app

COPY ./build.sbt .
COPY . .

# EXPOSE 8888

CMD ["sbt", "~run --host 0.0.0.0"]
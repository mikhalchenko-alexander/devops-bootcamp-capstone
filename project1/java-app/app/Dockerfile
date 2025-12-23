FROM --platform=linux/amd64 openjdk:8-jre-slim

RUN mkdir /opt/app

WORKDIR /opt/app

COPY build/libs/bootcamp-java-mysql-project-*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "./app.jar"]


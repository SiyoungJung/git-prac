FROM amazoncorretto:25
LABEL authors="jsy"
WORKDIR /app
COPY ./build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
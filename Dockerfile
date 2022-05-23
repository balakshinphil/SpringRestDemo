FROM openjdk:17
LABEL maintainer="balakshinfilipp "
EXPOSE 8000
ARG JAR_FILE=build/libs/SpringRestDemo-0.0.1.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
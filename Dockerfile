FROM amazoncorretto:17-alpine
ARG JAR_FILE=build/libs/brand-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} brand.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/brand.jar"]
FROM amazoncorretto:17-alpine
ARG JAR_FILE=build/libs/musinsa-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} product.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/product.jar"]
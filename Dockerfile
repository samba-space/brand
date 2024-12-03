FROM public.ecr.aws/corretto/amazoncorretto:17-alpine
ARG JAR_FILE=build/libs/brand-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} brand.jar
ENV AWS_XRAY_DAEMON_ADDRESS=xray-daemon:2000
EXPOSE 8082
ENTRYPOINT ["java","-jar","/brand.jar"]
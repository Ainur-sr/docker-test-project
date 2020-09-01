#FROM openjdk:8-jre-alpine
#MAINTAINER ainshigapov <ainshigapov@gmail.com>
#ADD ./target/docker-test-project-0.0.1-SNAPSHOT.jar /app
#CMD ["java", "-jar", "/app/smlr.jar"]
#EXPOSE 8080

ENV APP_ROOT /apps
RUN mkdir -p ${APP_ROOT}
WORKDIR ${APP_ROOT}
COPY ./target/${JAR_FILE} ${APP_ROOT}/docker-test-project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "docker-test-project-0.0.1-SNAPSHOT.jar"]
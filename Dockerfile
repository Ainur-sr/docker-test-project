FROM openjdk:8-jre-alpine
MAINTAINER ainshigapov <ainshigapov@gmail.com>
ADD ./target/docker-test-project-1.jar /app
CMD ["java", "-jar", "/app/smlr.jar"]
EXPOSE 8080

ARG JAR_FILE

RUN mkdir -p /apps
COPY ./target/${JAR_FILE} /apps/docker-test-project-1.jar
COPY ./entrypoint.sh /apps/entrypoint.sh

RUN chmod +x /apps/entrypoint.sh
CMD ["/apps/entrypoint.sh"]
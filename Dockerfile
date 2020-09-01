FROM java:8-jre
ARG JAR_FILE
MAINTAINER ainshigapov <ainshigapov@gmail.com>
ADD ./target/docker-test-project-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "/app/smlr.jar"]
EXPOSE 8080

RUN mkdir -p /apps
COPY ./target/${JAR_FILE} /apps/docker-test-project-0.0.1-SNAPSHOT.jar
COPY ./entrypoint.sh /apps/entrypoint.sh
RUN chmod +x /apps/entrypoint.sh
CMD ["/apps/entrypoint.sh"]
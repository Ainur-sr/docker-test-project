FROM java:8-jre
MAINTAINER ainshigapov <ainshigapov@gmail.com>
ADD ./target/docker-test-project-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "/app/smlr.jar"]
EXPOSE 8080
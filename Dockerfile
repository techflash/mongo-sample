FROM openjdk:11
COPY target/mongo-0.0.1-SNAPSHOT.jar /app.jar
CMD exec java -jar /app.jar
FROM openjdk:17-alpine

COPY target/blog-app-0.0.1-SNAPSHOT.jar /blog-app.jar

CMD ["java", "-jar", "blog-app.jar"]
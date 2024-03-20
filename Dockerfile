FROM openjdk:17-jdk-alpine AS builder
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw package
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY entrypoint.sh /entrypoint.sh
COPY --from=builder /app/target/rbc-library-notification-0.0.1-SNAPSHOT.jar rbc-library-notification-0.0.1-SNAPSHOT.jar
EXPOSE 8080
EXPOSE 8087
RUN chmod +x /entrypoint.sh
RUN adduser -u 1002 -D non-root-user && chown -R non-root-user:non-root-user /app
USER non-root-user
ENTRYPOINT ["/entrypoint.sh"]
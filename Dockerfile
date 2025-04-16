FROM eclipse-temurin:21
# we could build from an image that already have the otel agent

WORKDIR /app

COPY target/*.jar app.jar
COPY agents/opentelemetry-javaagent.jar otel-agent.jar
# or we could download it from the web
COPY src/main/resources/otel-agent.config otel-agent.config

EXPOSE 8080

ENV PORT=8080
ENV SERVER_PORT=8080
ENV SERVER_ADDRESS=0.0.0.0

ENTRYPOINT ["java", "-javaagent:otel-agent.jar", "-Dotel.javaagent.configuration-file=otel-agent.config", "-jar", "app.jar", "--server.port=${PORT}"]
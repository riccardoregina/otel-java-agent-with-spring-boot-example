FROM eclipse-temurin:21

WORKDIR /app

ARG OTEL_VERSION=2.15.0
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v${OTEL_VERSION}/opentelemetry-javaagent.jar otel-agent.jar
COPY target/*.jar app.jar
COPY src/main/resources/otel-agent.config otel-agent.config

EXPOSE 8080

ENV PORT=8080

ENTRYPOINT ["java", "-javaagent:otel-agent.jar", "-Dotel.javaagent.configuration-file=otel-agent.config", "-jar", "app.jar"]
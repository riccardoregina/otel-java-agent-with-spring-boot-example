@echo off
REM Step 1: Clean and package the application using Maven Wrapper
echo Running Maven clean and package...
call .\mvnw clean package
if %ERRORLEVEL% neq 0 (
    echo Maven build failed. Exiting...
    exit /b %ERRORLEVEL%
)

REM Step 2: Build the Docker image
echo Building Docker image...
call docker build -t otel-java-agent-with-spring-boot-example .
if %ERRORLEVEL% neq 0 (
    echo Docker build failed. Exiting...
    exit /b %ERRORLEVEL%
)

REM Step 3: Run the Docker container
echo Running Docker container...
call docker run -p 8080:8080 -i otel-java-agent-with-spring-boot-example
if %ERRORLEVEL% neq 0 (
    echo Docker run failed. Exiting...
    exit /b %ERRORLEVEL%
)

echo Script completed successfully.
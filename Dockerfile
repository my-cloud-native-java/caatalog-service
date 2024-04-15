FROM eclipse-temurin:17
WORKDIR workspace
COPY . .
ENTRYPOINT ["./gradlew", "bootRun"]

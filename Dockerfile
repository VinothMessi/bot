# Build a JAR File
FROM maven:3.8.3-jdk-11-slim AS stage1

WORKDIR bot

# Copying src code
COPY src src
# Copying pom file
COPY pom.xml pom.xml

RUN mvn dependency:go-offline -B
RUN mvn clean package -DskipTests

# Copying reources
COPY references references
COPY assets assets
COPY config.toml config.toml
COPY selenium-grid.yml selenium-grid.yml
COPY dynamic-selenium-grid.yml dynamic-selenium-grid.yml
COPY bot.xml bot.xml

# Create an Image
FROM openjdk:11-jre-slim

RUN apt-get update && apt-get install -y curl && apt-get install -y jq

WORKDIR bot

# Adding JARS files from target folder of host
COPY --from=stage1 bot/target/bot.jar bot.jar
COPY --from=stage1 bot/target/bot.jar.original bot.jar.original
COPY --from=stage1 bot/target/bot-tests.jar bot-tests.jar
COPY --from=stage1 bot/target/libs libs

# Copying reources
COPY references references
COPY assets assets
COPY config.toml config.toml
COPY selenium-grid.yml selenium-grid.yml
COPY dynamic-selenium-grid.yml dynamic-selenium-grid.yml
COPY bot.xml bot.xml
COPY pom.xml pom.xml

ENTRYPOINT java -cp bot.jar:bot.jar.original:bot-tests.jar:libs/* -Dspring.profiles.active=$PROFILE -Dbrowser=$BROWSER -Dhub.host=$HOST -Dhub.port=$PORT org.testng.TestNG $MODULE
FROM openjdk:17
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=mxthn_bot
ENV BOT_TOKEN=5350596840:AAG9uIobW6F6Hv87EQKgX9Onmcxxhdws1Iw
ENV BOT_DB_USERNAME=telegram_bot_db
ENV BOT_DB_PASSWORD=postgres
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dtelegram-bot.api.username=${BOT_NAME}", "-Dtelegram-bot.api.token=${BOT_TOKEN}", "-jar", "/app.jar"]

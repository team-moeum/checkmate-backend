FROM openjdk:17-alpine AS builder
WORKDIR /app2

ARG DATABASE_URL
ARG DATABASE_USERNAME
ARG DATABASE_PASSWORD

ENV DATABASE_URL=${DATABASE_URL}
ENV DATABASE_USERNAME=${DATABASE_USERNAME}
ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}

COPY . .

RUN chmod +x gradlew && ./gradlew clean build --no-daemon -x test

FROM openjdk:17-alpine
WORKDIR /app2

ENV TZ=Asia/Seoul
RUN apk update && apk add --no-cache tzdata && \
    cp /usr/share/zoneinfo/$TZ /etc/localtime && \
    echo $TZ > /etc/timezone

RUN mkdir -p /app2/logs

# JAR 파일 복사 경로 수정
COPY --from=builder /app2/build/libs/*.jar /app2/app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app2/app.jar"]

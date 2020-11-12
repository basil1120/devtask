FROM maven:3.5.3-jdk-8-alpine AS builder
ENV HTTP_PROXY=http://172.30.100.1:8080
ENV HTTPS_PROXY=http://172.30.100.1:8080
WORKDIR /workspace/app
COPY settings.xml /root/.m2/settings.xml
COPY pom.xml .
RUN mvn dependency:go-offline


COPY src src
RUN mvn package
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM openjdk:8-jdk-alpine


ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-Dspring.config.location=/app/","-cp","app:app/lib/*","kcb.mavuno.payments.engine.KcbMavunoUnionPaymentsEngineApplication"]
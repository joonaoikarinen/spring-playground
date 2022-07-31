FROM eclipse-temurin:11

RUN addgroup app && \
    useradd -g app app
USER app
WORKDIR /home/app/

CMD java ${JAVA_OPTS} -jar spring-playground-*.jar
COPY target/spring-playground-*.jar .
FROM eclipse-temurin:11
CMD java ${JAVA_OPTS} -jar spring-playground-*.jar
COPY target/spring-playground-*.jar .
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=tp01-0.0.1-SNAPSHOT.jar
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app
ADD ${DEPENDENCY} tp01.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tp01.jar"]
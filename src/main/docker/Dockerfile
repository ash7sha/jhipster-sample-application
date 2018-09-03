FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    Ash7sha_SLEEP=0 \
    JAVA_OPTS=""

# Add a Ash7sha user to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh Ash7sha
WORKDIR /home/Ash7sha

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown Ash7sha:Ash7sha entrypoint.sh
USER Ash7sha

ADD *.war app.war

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8081 5701/udp


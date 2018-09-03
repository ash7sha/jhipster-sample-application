#!/bin/sh

echo "The application will start in ${Ash7sha_SLEEP}s..." && sleep ${Ash7sha_SLEEP}
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/app.war" "$@"

#!/bin/sh
NAME="statustest"
docker rm ${NAME}
docker run -d -p 8080:8080 --name ${NAME} airhacks/${NAME}
mvn clean install failsafe:integration-test
#!/bin/sh
NAME="statustest"
docker kill ${NAME}
docker rm ${NAME}
docker run -d -p 8080:8080 --name ${NAME} airhacks/${NAME}
sleep 5
mvn clean install failsafe:integration-test
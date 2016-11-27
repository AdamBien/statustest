#!/bin/sh
mvn clean install
docker build -t airhacks/statustest .
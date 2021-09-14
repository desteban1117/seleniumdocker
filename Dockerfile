FROM openjdk:8u191-jre-alpine3.9

RUN apk add curl jq

# Workspace
WORKDIR /user/share/udemy

# ADD .jar target from host into this image
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs

#in case of any other dependcy like .csv / .json / .xls
# please ADD that as well

# ADD suit files
ADD testng.xml testng.xml

# ADD health check script
ADD healthcheck.sh         healthcheck.sh

ENTRYPOINT sh healthcheck.sh
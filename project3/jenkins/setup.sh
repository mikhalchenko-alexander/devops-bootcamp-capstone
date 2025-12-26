#!/bin/bash

if ! docker --version &> /dev/null
then
    echo "Installing docker..."
    curl -fsSL https://get.docker.com -o get-docker.sh
    sudo sh get-docker.sh
    rm get-docker.sh
fi

docker --version

docker build -t jenkins-cutom:latest --build-arg DOCKER_GROUP_ID=$(stat -c '%g' /var/run/docker.sock) .

echo "Running Jenkins using Docker compose stack..."
DOCKER_PATH=$(which docker) docker compose up -d


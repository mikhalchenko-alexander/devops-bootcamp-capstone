FROM jenkins/jenkins:lts-jdk21

ARG DOCKER_GROUP_ID

USER root

RUN apt update && \
    apt install wget lsb-release && \
    wget -O - https://apt.releases.hashicorp.com/gpg | gpg --dearmor -o /usr/share/keyrings/hashicorp-archive-keyring.gpg && \
    echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/hashicorp-archive-keyring.gpg] https://apt.releases.hashicorp.com $(grep -oP '(?<=UBUNTU_CODENAME=).*' /etc/os-release || lsb_release -cs) main" | tee /etc/apt/sources.list.d/hashicorp.list && \
    apt update && apt install terraform

RUN groupadd -g $DOCKER_GROUP_ID docker || true && \
    usermod -aG docker jenkins

USER jenkins

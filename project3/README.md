### Project 3

#### Demo Project:

Complete C|/CD with Terraform

#### Technologies used:

Terraform, Jenkins, Docker, AWS, Git, Java, Maven, Linux, Docker Hub

#### Project Description

Integrate provisioning stage into complete CI/CD Pipeline to automate provisioning server instead of deploying to an
existing server

* Create SSH Key Pair
* Install Terraform inside Jenkins container
* Add Terraform configuration to application's git repository
* Adjust Jenkinsfile to add "provision" step to the CI/CD pipeline that provisions EC2 instance
* So the complete Cl/CD project we build has the following configuration:
    * CI step: Build artifact for Java Maven application
    * CI step: Build and push Docker image to Docker Hub
    * CD step: Automatically provision EC2 instance using TF
    * CD step: Deploy new application version on the provisioned EC2 instance with Docker Compose

*Module 12: Infrastructure as Code with Terraform*

### Steps to run

1. Jenkins folder contains the Docker compose stack to run the Jenkins server.
2. Configure AWS and Docker credentials in the Jenkins server.
3. (Optional) Adjust image and instance type in [ec2.tf](terraform/ec2.tf) file (the project uses ARM architecture for
   both).
4. Configure Jenkins pipeline to use the Jenkinsfile in the projec3/java-app folder.
5. Run the pipeline with "deploy" parameter to provision and deploy the application to the EC2 instance.
6. Run the pipeline with "destroy" parameter to destroy the provisioned EC2 instance.

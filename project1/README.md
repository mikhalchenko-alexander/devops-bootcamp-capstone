### Project 1

#### Demo Project:
Complete CI/CD Pipeline with EKS and AWS ECR

#### Technologies used:
Kubernetes, Jenkins, AWS EKS, AWS ECR, Java, Maven, Linux, Docker, Git

#### Project Description
* Create private AWS ECR Docker repository
* Adjust Jenkinsfile to build and push Docker Image to AWS ECR
* Integrate deploying to K8s cluster in the CI/CD pipeline from AWS ECR private registry
* So the complete CI/CD project we build has the following configuration:
  * CI step: Increment version
  * CI step: Build artifact for Java Maven application
  * CI step: Build and push Docker image to AWS ECR 
  * CD step: Deploy new application version to EKS cluster
  * CD step: Commit the version update

*Module 11. Kubernetes on AWS-EKS*
                   
### Steps to run

1. Run [create-cluster.sh](eks-cluster/create-cluster.sh)
2. Run [install-mysql.sh](mysql/install-mysql.sh)
3. Run [install-phpmyadmin.sh](phpmyadmin/install-phpmyadmin.sh)
4. Run [create-docker-login-secret.sh](java-app/create-docker-login-secret.sh)
5. Run [create-fargate-namespace.sh](java-app/create-fargate-namespace.sh)
6. Run [install-java-app.sh](java-app/install-java-app.sh)
7. Configure Jenkins to deploy to the EKS cluster
   1. Create a pipeline to watch for the repo changes
   2. Configure AWS credentials
   3. Configure GitHub credentials
8. Push changes to GitHub to trigger the CI/CD pipeline

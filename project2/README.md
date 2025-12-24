### Project 2

#### Demo Project:

Automate Kubernetes Deployment

#### Technologies used:

Ansible, Terraform, Kubernetes, AWS EKS, Python, Linux

#### Project Description

* Create EKS cluster with Terraform
* Write Ansible Play to deploy application in a new K8s namespace

*Module 15: Configuration Management with Ansible*

### Steps to run

1. Configure AWS credentials in `~/.aws/credentials`
2. Run `terraform init` in [terraform](terraform)
3. Run `terraform apply` in [terraform](terraform)
4. Fill in Docker Hub credentials in [ansible-secrets.yaml](ansible/ansible-secrets.yaml) (copy
   from [ansible-secrets.example.yaml](ansible/ansible-secrets.example.yaml))
5. Update image name in [java-app.yaml](ansible/manifests/java-app.yaml) as the one used
   in [java-app.yaml](ansible/manifests/java-app.yaml) is private
6. Run [run.sh](ansible/run.sh) in [ansible](ansible) to deploy the database, application and ingress

### Project 4

#### Demo Project:

Deploy Microservices application in Kubernetes with Production & Security Best Practices

#### Technologies used:

Kubernetes, Redis, Linux, Linode LKE

#### Project Description

* Create K8s manifests for Deployments and Services for all microservices of an online shop application
* Deploy microservices to Linode's managed Kubernetes cluster

*Module 10: Container Orchestration with Kubernetes*

### Steps to run

1. Create a Linode Kubernetes cluster
2. Configure kubectl to connect to the cluster
3. Run [deploy.sh](manifests/deploy.sh) script in the manifests directory
4. Port-forward one of the frontend pods to view the application
5. To delete the application, run [delete.sh](manifests/delete.sh) script in the manifests directory

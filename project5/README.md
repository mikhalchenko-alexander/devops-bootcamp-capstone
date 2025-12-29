### Project 5

#### Demo Project:

Ansible Integration in Jenkins

#### Technologies used:

Ansible, Jenkins, DigitalOcean, AWS, Boto3, Docker, Java, Maven, Linux, Git

#### Project Description

* Create and configure a dedicated server for Jenkins
* Create and configure a dedicated server for Ansible Control Node
* Write Ansible Playbook, which configures 2 EC2 Instances
* Add ssh key file credentials in Jenkins for Ansible Control Node server and Ansible Managed Node servers
* Configure Jenkins to execute the Ansible Playbook on remote Ansible Control Node server as part of the CI/ CD pipeline
* So the Jenkinsfile configuration will do the following:
    * Connect to the remote Ansible Control Node server
    * Copy Ansible playbook and configuration files to the remote Ansible Control Node server
    * Copy the ssh keys for the Ansible Managed Node servers to the Ansible Control Node server
    * Install Ansible, Python3 and Boto3 on the Ansible Control Node server
    * With everything installed and copied to the remote Ansible Control Node server, execute the playbook remotely on
      that Control Node that will configure the 2 EC2 Managed Nodes

*Module 15: Configuration Management with Ansible*

### Steps to run

1. Copy [secrets.example.yaml](secrets.example.yaml) file to `secrets.yaml` specif all variables:
   ```sh
   cp secrets.example.yaml secrets.yaml
   ```
2. Install [Digital Ocean Ansible plugin](https://galaxy.ansible.com/ui/repo/published/digitalocean/cloud/)
   ```sh
   ansible-galaxy collection install digitalocean.cloud
   ```
3. Customize `ssh_keys` in [provision-do-droplet.yaml](provision-do-droplet.yaml) with your Digital Ocean ssh key ID
   SSH key ID can be retrieved from using [doctl](https://docs.digitalocean.com/reference/doctl/) tool
   ```sh
   doctl compute ssh-key list
   ``` 
4. Install required Python libraries
   ```sh
   pip3 install -r requirements.txt
   ```
5. Run [provision-nodes.sh](provision-nodes.sh) to provision Ansible Control Node server and managed nodes
   ```sh   
   ./provision-nodes.sh
   ```
6. Configure Jenkins pipeline in Jenkins UI
7. Customize `CONTROL_NODE` variable in [Jenkinsfile](Jenkinsfile) with the IP address of the Ansible Control Node
   server
8. Configure `aws_credentials` secret file in Jenkins UI
9. Run Jenkins pipeline

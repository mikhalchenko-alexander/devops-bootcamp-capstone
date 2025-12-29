#!/bin/bash
sudo apt-get update
sudo apt-get install -y ansible python3 python3-boto3
ansible-galaxy role install geerlingguy.mysql

#!/bin/bash

ansible-playbook -e "@secrets.yaml" provision-do-droplet.yaml
ansible-playbook -e "@vars.yaml" provision_app_instances.yaml

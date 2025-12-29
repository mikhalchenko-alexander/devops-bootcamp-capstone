#!/bin/bash

ansible-playbook -e "@secrets.yaml" provision-do-droplet.yaml

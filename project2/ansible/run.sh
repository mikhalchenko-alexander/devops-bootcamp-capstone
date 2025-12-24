#!/bin/bash

ansible-playbook -e "@ansible-secrets.yaml" deploy.yaml

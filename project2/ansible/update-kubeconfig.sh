#!/bin/bash

aws eks update-kubeconfig \
  --region eu-central-1 \
  --name java-app-eks-cluster \
  --alias java-app-eks-cluster \
  --user-alias java-app-eks-cluster-user

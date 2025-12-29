#!/bin/bash

kubectl apply -f namespace.yaml
kubectl apply -n online-shop -f microservices.yaml

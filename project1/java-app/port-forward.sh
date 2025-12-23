#!/bin/bash

kubectl port-forward -n java-app svc/java-app 8080:8080

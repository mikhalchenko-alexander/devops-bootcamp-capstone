### Project 6

#### Demo Project:

Website Monitoring and Recovery

#### Technologies used:

Python, Linode, Docker, Linux

#### Project Description

* Create a server on a cloud platform
* Install Docker and run a Docker container on the remote server
* Write a Python script that monitors the website by accessing it and validating the HTTP response
* Write a Python script that sends an email notification when website is down
* Write a Python script that automatically restarts the application & server when the application is down

*Module 14: Automation with Python*

### Steps to run

1. ```sh
   cp .env.example .env
   ```
2. Fill in enviornment variables in [.env](.env)
3. Create/activate Python virtual environment
4. Install dependencies
   ```sh
   pip install -r requirements.txt
   ``` 
5. Run [main.py](main.py) script to
   1. Provision the server
   2. install Docker
   3. Run the NGinx application on the instance
   4. Start monitoring the app and restart it when it goes down

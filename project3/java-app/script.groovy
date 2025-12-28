def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage(String tag) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t ${tag} ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push ${tag}"
    }
}

def deployApp(String serverIp, String imageName, String dockerUser, String dockerPassword, String sshKeyName) {
    echo 'deploying the application...'
    echo "waiting for EC2 server to initialize"
    sleep(time: 90, unit: "SECONDS")

    echo 'deploying docker image to EC2...'
    echo "${serverIp}"

    def shellCmd = "bash ./server-cmds.sh ${imageName} ${dockerUser} ${dockerPassword}"
    def ec2Instance = "ec2-user@${serverIp}"

    sshagent([sshKeyName]) {
        sh "scp -o StrictHostKeyChecking=no server-cmds.sh ${ec2Instance}:/home/ec2-user"
        sh "scp -o StrictHostKeyChecking=no docker-compose.yml ${ec2Instance}:/home/ec2-user"
        sh "ssh -o StrictHostKeyChecking=no ${ec2Instance} ${shellCmd}"
    }
}

return this

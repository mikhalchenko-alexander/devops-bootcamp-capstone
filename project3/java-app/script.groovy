def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage(String tag) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker buildx build --platform linux/amd64 -t ${tag} --load ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push ${tag}"
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this

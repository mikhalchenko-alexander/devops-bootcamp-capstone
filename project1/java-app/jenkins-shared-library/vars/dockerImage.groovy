def call(String imageName, String dockerHost, String region) {
    withCredentials([usernamePassword(credentialsId: 'aws', usernameVariable: 'AWS_ACCESS_KEY_ID', passwordVariable: 'AWS_SECRET_ACCESS_KEY')]) {
        sh "aws ecr get-login-password --region $region | docker login --username AWS --password-stdin $dockerHost"
        sh "docker build --platform linux/amd64/v2 -t $imageName ."
        sh "docker push $imageName"
    }
}

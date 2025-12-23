def call(String repo) {
    withCredentials([sshUserPrivateKey(credentialsId: 'github', keyFileVariable: 'PRIVATE_SSH_KEY')]) {
        sh 'git config --global user.name "jenkins"'
        sh 'git config --global user.email "jenkins@example.com"'
        sh "git remote set-url origin $repo"
        sh "git add ."
        sh 'git commit -m "ci: version bump"'
        sh 'GIT_SSH_COMMAND="ssh -i $PRIVATE_SSH_KEY" git push origin HEAD:main'
    }
}

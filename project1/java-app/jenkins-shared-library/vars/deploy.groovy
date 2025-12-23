def call(String clusterName, String region) {
    withCredentials([usernamePassword(credentialsId: 'aws', usernameVariable: 'AWS_ACCESS_KEY_ID', passwordVariable: 'AWS_SECRET_ACCESS_KEY')]) {
        sh "aws eks update-kubeconfig --name $clusterName --region $region"

        dir('project1/mysql') {
            sh "helm upgrade mysql oci://registry-1.docker.io/bitnamicharts/mysql -f mysql-values.yaml"
        }

        dir('project1/phpmyadmin') {
            sh "helm upgrade phpmyadmin oci://registry-1.docker.io/bitnamicharts/phpmyadmin"
        }

        dir('project1/java-app/java-app-helm-chart') {
            sh "helm repo add traefik https://traefik.github.io/charts"
            sh "helm dependency update"
            sh "helm dependency build"
        }

        dir('project1/java-app') {
            sh "helm upgrade -n java-app java-app java-app-helm-chart"
        }
    }
}

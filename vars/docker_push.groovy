// vars/docker_push.groovy
def call(imageName, tag, dockerhubUser) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]) {
        sh "echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin"
        sh "docker tag ${imageName}:${tag} ${dockerhubUser}/${imageName}:${tag}"
        sh "docker push ${dockerhubUser}/${imageName}:${tag}"
    }
}

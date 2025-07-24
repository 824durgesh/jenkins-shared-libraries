def call() {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]) {
        sh "echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin"
        sh "docker push trainwithshubham/notes-app:latest"
    }
}

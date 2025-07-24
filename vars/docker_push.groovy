def call() {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        sh "echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin"
        sh "docker push trainwithshubham/notes-app:latest"
    }
}

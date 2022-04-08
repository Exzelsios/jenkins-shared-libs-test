// vars/buildPlugin.groovy
def call(String foldername, String dockerTag) {
   stage('Checkout Git') {
      git 'https://github.com/NovatecConsulting/technologyconsulting-containerexerciseapp.git'
    }
    stage('Build Todo-Backend') {
      container('maven') {
        dir("todobackend") {
          sh 'mvn clean install'
        }
      }
    }
    stage('Build Docker Image Todo-Backend') {
      container('dockerBuilder') {
        # Wie taggen und wohin pushen?
        sh 'podman build -f Dockerfile-todobackend -t technologyconsulting-containerexerciseapp-todobackend:jenkinsbuild1 .'
      }
    }
}
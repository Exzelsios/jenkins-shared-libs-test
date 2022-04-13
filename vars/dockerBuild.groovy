// vars/dockerBuild.groovy
def call(String containerName, String dockerfile, String imageName, String dockerTag) {
  stage("Build Docker Image ${dockerfile}: ${imageName}") {
    container("${containerName}") {
    // Wie taggen und wohin pushen?
      sh "podman build -f ${dockerfile} -t ${imageName}:${dockerTag} ."
    }
  }
}

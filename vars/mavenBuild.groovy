// vars/buildPlugin.groovy
def call(String containerName, String foldername) {
  stage("Build ${foldername}") {
    container("${containerName}") {
      dir("${foldername}") {
        sh 'mvn clean install'
      }
    }
  }
}
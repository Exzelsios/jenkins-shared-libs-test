// vars/buildPlugin.groovy
def call(String foldername) {
  stage("Build ${foldername}") {
    container('maven') {
      dir("${foldername}") {
        sh 'mvn clean install'
      }
    }
  }
}
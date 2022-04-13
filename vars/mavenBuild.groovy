// vars/mavenBuild.groovy
def call(String foldername) {
  def containers = [
    containerTemplate(name: 'maven', image: 'maven:3.8.1-jdk-8', command: 'sleep', args: '99d')
  ]
  
  podTemplate(containers: containers
  ){
    node(POD_LABEL) {
      stage("Build ${foldername}") {
        container('maven') {
          dir("${foldername}") {
            sh 'mvn clean install'
          }
        }
      }
    }
  }
}
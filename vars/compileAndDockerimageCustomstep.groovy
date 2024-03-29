// vars/compileAndDockerimageCustomstep.groovy
def call(String foldername, String dockerTag) {
  def containers = [
    containerTemplate(name: 'maven', image: 'maven:3.8.7-eclipse-temurin-17-alpine', command: 'sleep', args: '99d'),
    containerTemplate(name: 'docker-builder', image: 'buildah/buildah', command: 'sleep', args: '99d', privileged: true)
  ]
  
  podTemplate(containers: containers,
    volumes: [
      hostPathVolume(hostPath: '/var/lib/containers', mountPath: '/var/lib/containers')
    ]
  ){
    node(POD_LABEL) {
      stage('Checkout Git') {
        git 'https://github.com/NovatecConsulting/technologyconsulting-containerexerciseapp.git'
      }
      stage("Build ${foldername}") {
        container('maven') {
          dir("${foldername}") {
            sh 'mvn clean install'
          }
        }
      }
      stage("Build Docker Image ${foldername}") {
        container('docker-builder') {
          // Wie taggen und wohin pushen?
          sh "podman build -f Dockerfile-${foldername} -t technologyconsulting-containerexerciseapp-${foldername}:${dockerTag} ."
        }
      }
    }
  }
}

// vars/buildPlugin.groovy
def call(String dockerfile, String imageName, String dockerTag) {
  def containers = [
    containerTemplate(name: 'docker-builder', image: 'buildah/buildah', command: 'sleep', args: '99d', privileged: true)
  ]
  
  podTemplate(containers: containers,
    volumes: [
      hostPathVolume(hostPath: '/var/lib/containers', mountPath: '/var/lib/containers')
    ]
  ){
      stage("Build Docker Image ${foldername}") {
        container('docker-builder') {
          // Wie taggen und wohin pushen?
          sh "podman build -f ${dockerfile} -t ${imageName}:${dockerTag} ."
        }
      }
    }
  }
}
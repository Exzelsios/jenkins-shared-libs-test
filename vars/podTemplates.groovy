  def containers = [
    containerTemplate(name: 'maven', image: 'maven:3.8.1-jdk-8', command: 'sleep', args: '99d'),
    containerTemplate(name: 'docker-builder', image: 'buildah/buildah', command: 'sleep', args: '99d', privileged: true)
  ]
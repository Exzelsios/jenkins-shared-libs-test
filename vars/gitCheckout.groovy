// vars/buildPlugin.groovy
def call(String gitUrl) {
  stage('Checkout Git') {
    git "${gitUrl}"
  }
}
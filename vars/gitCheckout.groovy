// vars/gitCheckout.groovy
def call(String gitUrl) {
  stage('Checkout Git') {
    git "${gitUrl}"
  }
}
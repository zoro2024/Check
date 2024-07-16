package org.generic

def call(String url) {  //github-token is git token and stored in jenkins as secret text
    stage('License scanning') {
      withCredentials([string(credentialsId: 'github-token', variable: 'GITHUB_TOKEN')]) {
          sh "trivy repo ${url} --format json -o trivy-license-report.json"
      }
    }
}

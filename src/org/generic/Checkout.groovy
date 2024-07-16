package org.generic

def call(String url, String creds, String branch) {
    stage('Checkout Git') {
        script {
            git url: url, credentialsId: creds, branch: branch
            echo "Checked out repository from ${url} on branch ${branch}"
        }
    }
}
package org.generic

def call(String useremail, String username, String creds, String branch) {
    stage('Sign off') {
      withCredentials([usernamePassword(credentialsId: creds, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
          sh """
          git config user.email '${useremail}'
          git config user.name '${username}'
          git remote set-url origin https://${username}:${PASSWORD}@github.com/mygurkulam-p9/Attendence-API.git
          git add CredScanReport
          git commit --signoff -m "Cred report"
          git push origin ${branch}
          """
      }
    }
}

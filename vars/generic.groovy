import org.generic.Checkout
import org.generic.Gitleaks
import org.generic.Trivyinstaller
import org.generic.Notification
import org.generic.Buildami
import org.generic.Signoff

def checkout(String url, String creds, String branch = 'main') {
    new Checkout().call(url, creds, branch)
}

 def gitleaks() {
     new Gitleaks().call()
 }

def trivyinstaller(String repoUrl) {
     new Trivyinstaller().call(url)
 }

def notification() {
    new Notification().call()
}

def buildami(String ami_name) {
    new Buildami().call(ami_name)
}

def signoff(String useremail, String username, String creds, String branch) {
    new Signoff().call(useremail, username, creds, branch)
}
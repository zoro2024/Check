@Library('shared-check') _

properties([
    parameters([
        string(name: 'URL', defaultValue: 'https://github.com/OT-MICROSERVICES/attendance-api.git', description: 'Repository URL for checkout')
    ])
])

node {

    def url = params.URL ?: 'https://github.com/OT-MICROSERVICES/attendance-api.git'

    try {
        generic.checkout(url, 'github-token1', 'main')
        generic.gitleaks()
        archiveArtifacts artifacts: 'CredScanReport'
        
        generic.trivyinstaller(url) 
        archiveArtifacts artifacts: 'trivy-license-report.json'
        
    } catch (Exception e) {
        currentBuild.result = 'FAILURE'
        throw e
    } finally {
        generic.notification()
    }
}

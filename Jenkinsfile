@Library('shared-check') _

properties([
    parameters([
        string(name: 'URL', defaultValue: 'https://github.com/OT-MICROSERVICES/attendance-api.git', description: 'Repository URL for checkout')
    ])
])

node {
    // Define parameters
    def url = params.URL ?: 'https://github.com/OT-MICROSERVICES/attendance-api.git'

    try {
        // Call functions from shared library
        generic.checkout(url, 'github-token1', 'main')
        generic.gitleaks()
        
        // Archive artifacts
        archiveArtifacts artifacts: 'CredScanReport'
        
        // Install Trivy and run license scan
        generic.trivyinstaller(url) // Ensure `trivyinstaller` function in shared library handles `url` correctly
        archiveArtifacts artifacts: 'trivy-license-report.json'
        
    } catch (Exception e) {
        // Handle exceptions
        currentBuild.result = 'FAILURE'
        throw e
    } finally {
        // Notify at the end
        generic.notification()
    }
}

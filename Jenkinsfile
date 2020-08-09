pipeline {
    agent {
        docker { image "openjdk:8-jdk" }
    }
    stages {
        stage('Build') {
            steps {
                // For Auto builds
                withCredentials([string(credentialsId: 'REPO_PASSWORD', variable: 'REPO_PASSWORD')]) {
                    sh "chmod +x gradlew && ./gradlew build publish -PmavenPass=$REPO_PASSWORD --console=plain --refresh-dependencies"
                }
            }
        }
    }
    post {
        always {
            script {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true, onlyIfSuccessful: true, allowEmptyArchive: true
            }
        }
    }
}

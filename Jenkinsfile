pipeline {
    agent { docker { image 'maven:3.8.7-eclipse-temurin-11' } }
    stages {
        stage('build') {
            steps {
                sh 'make' 
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
}
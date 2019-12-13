pipeline {
    agent {
        docker {
            image 'gradle:6.0-jdk8'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'gradle clean'
            }
        }
        stage('Test') { 
            steps {
                sh 'gradle test' 
            }
            post {
                always {
                    junit 'build/reports/tests/test/index.html' 
                }
            }
        }
    }
}

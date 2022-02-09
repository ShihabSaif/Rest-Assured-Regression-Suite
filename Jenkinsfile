pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                    mail cc: "${env.EMAIL_AFTER_SUCCESSFUL_BUILD_TUSI}", body: "<b>Tally pay api gw automation suite build successfully and all test cases passed.</b><br>Build Number: ${env.BUILD_NUMBER}<br>Build URL: ${env.BUILD_URL}", bcc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "Nobopay api gw automation suite test result from pipeline", to: "shariba@surecash.net";
                }
            }
        }
        post {
                success {
                    mail cc: "${env.EMAIL_AFTER_SUCCESSFUL_BUILD_TUSI}", body: "<b>Tally pay api gw automation suite build successfully and all test cases passed.</b><br>Build Number: ${env.BUILD_NUMBER}<br>Build URL: ${env.BUILD_URL}", bcc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "Nobopay api gw automation suite test result from pipeline", to: "shariba@surecash.net";
                }
            }

    }
}
pipeline {
  agent any
  tools {
    maven 'maven-2.3.3.RELEASE'
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}
pipeline {
  agent any
  tools {
    maven 'maven-4.0.0'
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}
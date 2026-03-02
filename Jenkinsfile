pipeline {
    agent any

    tools {
        maven '3.9.12'
    }

    stages {
      stage("Show Details") {
        steps {
          script {
            echo env.BRANCH_NAME

              sh 'java -version'
              sh 'mvn --version'
          }
        }
      }

      stage("Test") {
        steps {
         script {
             sh 'mvn clean test'
         }
        }
      }  
    }
}

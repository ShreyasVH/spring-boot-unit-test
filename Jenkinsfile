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
              sh 'ls $HOME/programs'
              sh '''
                  which docker
              '''
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

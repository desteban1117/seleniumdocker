pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t='desteban1117/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'natanosabe', usernameVariable: 'desteban1117')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push desteban1117/selenium-docker:latest"
			    }
            }
        }
    }
}
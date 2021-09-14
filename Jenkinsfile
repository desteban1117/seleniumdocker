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
                sh "docker build -t='desteban1117/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    //withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Natanosabe.*123', usernameVariable: 'desteban1117')]) {
                    //sh
			      //  sh "docker login --username=${user} --password=${pass}"
			      //  sh "docker push desteban1117/selenium-docker:latest"
			    //}
			    sh "docker login --username=desteban1117 --password=Natanosabe.*123"
                sh "docker push desteban1117/selenium-docker:latest"
            }
        }
        stage('Runing tests') {
            steps {
        		sh "docker-compose up"
            }
        }
    }
}
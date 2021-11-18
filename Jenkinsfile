pipeline {
  agent any
  environment {
    IMAGE_REPO_NAME="vinothmessi/bot"
    COMPOSE_FILE_NAME="selenium-grid.yml"
    USERNAME="vinothmessi"
    PASSWORD="Messi123!@"
  }
  stages {
    stage('Clone GitHub Repository') {
      steps {
        echo 'Cloning my github repository'
        git(url: 'https://github.com/VinothMessi/bot.git', branch: 'master', poll: true)
        echo 'Successfully cloned the repository'
      }
    }
    stage('Build Docker Image') {
      steps {
        echo 'Building my Docker Image'
        fileExists 'Dockerfile'
        sh 'docker build --tag=${IMAGE_REPO_NAME} .'
        echo 'Docker Image built successfully'
      }
    }
    stage('Push Docker Image') {
      steps {
        echo 'Pushing my Docker Image'
        sh 'docker login -u ${USERNAME} -p ${PASSWORD}'
        sh 'docker push ${IMAGE_REPO_NAME}'
        echo 'Image pushed successfully'
      }
    }
    stage('Test execution') {
      steps {
        echo 'Initiating Test execution'
        sh 'docker-compose -f ${COMPOSE_FILE_NAME} up -d'
        sleep 180
        echo 'Test execution done successfully'
      }
    }
    stage('Dispose Test infra') {
       steps {
         echo 'Remove all containers'
         sh 'docker-compose -f ${COMPOSE_FILE_NAME} down'
         echo 'Removed all containers successfully'
       }
    }
  }
}
pipeline {
  agent any
  environment {
    IMAGE_REPO_NAME="vinothmessi/bot"
    IMAGE_TAG_NAME="v.${env.BUILD_NUMBER}"
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
        echo 'Building my Docker image'
        fileExists 'Dockerfile'
        sh 'docker build --tag=${IMAGE_REPO_NAME}:${IMAGE_TAG_NAME} .'
        echo 'Docker Image built successfully'
      }
    }
  }
}
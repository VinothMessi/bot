pipeline {
  agent { dockerfile true}
  stages {
    stage('Cloning the repo') {
      steps {
        echo 'Successfully cloning the repo!!!'
        git 'https://github.com/VinothMessi/bot.git'
      }
    }
    stage('Docker image build') {
       steps {
         echo 'Successfully build the docker image and running this command inside it!!!'
       }
    }
  }
}
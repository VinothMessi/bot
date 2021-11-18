pipeline {
  agent any
  stages {
    stage('Clone repository') {
      steps {
        echo 'Cloning the repository'
        git(url: 'https://github.com/VinothMessi/bot.git', branch: 'master', poll: true)
        echo 'Successfully cloned the repository'
      }
    }

  }
}
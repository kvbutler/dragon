pipeline {
    agent any
    stages {
        stage('stage1') {
            steps {
                    sh '''
                        echo 'stage 1'
                    '''
                }
            }
        stage('stage2') {
            steps {
                    sh '''
                        echo 'stage 2'
                    '''
                }

        }
    }
}

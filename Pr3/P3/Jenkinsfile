node {
    stage('checkout') {
        git 'https://github.com/pmisarwala/JunitExample.git'
     }
     stage('build-test')
     {
         sh 'mvn test'
     }
     stage('package')
     {
         sh 'mvn package'
     }
     stage ('publish Results')
     {
         step([$class: 'JUnitResultArchiver', testResults: 'target/surefire-reports/*.xml'])

     }
}

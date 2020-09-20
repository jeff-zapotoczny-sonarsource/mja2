pipeline {
  agent any
  stages {
    stage('SCM') {
      steps {
        // fetch master from origin so sonar scanner branch comparison works
        sh "git fetch --no-tags ${GIT_URL} +refs/heads/master:refs/remotes/origin/master"
      }
    }
    stage('Build') {
      steps {
        withMaven(maven: 'M3') {
          script {
            sh "mvn -Dmaven.test.failure.ignore clean verify"
	        }
        }
      }
    }
    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SQServer') {
          withMaven(maven: 'M3') {
            script {
	            // all analysis now automatically parameterized
              sh "mvn sonar:sonar"
              //sh "mvn verify sonar:sonar -Dsonar.security.sources.javasecurity.S2076=customSecurityConfig.json -Dsonar.security.sanitizers.javasecurity.S2076=customSecurityConfig.json -Dsonar.security.passthroughs.javasecurity.S2076=customSecurityConfig.json -Dsonar.security.sinks.javasecurity.S2076=customSecurityConfig.json"
            }
          }
        }
      }
    }
    stage('Quality Gate') {
      steps {
        timeout(time: 1, unit: 'HOURS') {
          waitForQualityGate abortPipeline: true
        }
      }
    }
  }
}

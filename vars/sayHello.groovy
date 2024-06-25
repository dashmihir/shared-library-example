#!/usr/bin/env groovy

def call(Map config = [:]) {
      pipeline {
        agent any
        stages {
            stage('checkout git') {
                steps {
                    git branch: config.branch, credentialsId: config.credentialsId, url: config.scmUrl
                    sh "ls -ltr"
                }
            }
            stage('build'){
              steps{
                mvn clean install
              }
            }
        }
      }  

}
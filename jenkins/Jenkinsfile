pipeline
{
    agent 'any'
    parameters
    {
        string (
          defaultValue: 'develop',
          name: 'BRANCH_NAME')
        string ( 
            defaultValue: 'DEV',
            description: 'Environment To release on',
            name: 'BUILD_ENV')
    }
    tools
    {
      maven 'm3'
    }
    stages
    {
        stage('Checkout')
        {
            steps 
            {
                git credentialsId: 'f6aa54db-28dc-4848-9842-c0c823d176cd', url: 'https://github.com/priyavartkyava/java-maven-junit-helloworld.git'

            }
        }
        stage ('Compile')
        {
            steps 
            {
              sh 'pwd'  
              ansiblePlaybook(credentialsId: 'pipeline_key', inventory: '34.218.51.237,' , playbook: 'jenkins/ansible/play.yml', extras: '-e target_hosts="34.218.51.237"')
            }
        }
        stage('Package')
        {
            steps
            {
             sh  'mvn package'
            }
        }
              stage("foo") 
        {
            steps {
                sh 'printenv'
               
                
            }
        }
        
       stage('archive')
        {
            steps
            {
                archiveArtifacts 'target/*.jar'
                deleteDir()
            }
        }
    }    
}

def applicationName = "statustest";
def applicationNameST = "${applicationName}-st";

pipeline{
    agent {
        label 'maven'
    }

    stages{
            stage('build') {
                steps{
                    sh script: "cd ${applicationName} && mvn -DskipTests package"   
                }
            }
            stage('build system tests') {
                steps{
                    sh script: "cd ${applicationNameST} && mvn clean package"   
                }
            }    
            stage('unit tests') {
                steps{
                    sh script: "cd ${applicationName} && mvn test"   
                }
            }    
            stage('integration tests') {
                steps{
                    sh script: "cd ${applicationName} && mvn failsafe:integration-test failsafe:verify"   
                }
            } 
            stage('s2i build'){
                steps{
                script{
                    openshift.withCluster(){
                        openshift.withProject(){
                            def build = openshift.selector("bc", applicationName);
                            def startedBuild = build.startBuild('--from-file="./${applicationName}/target/${applicationName}.war"');
                            startedBuild.logs('-f');
                            echo startedBuild.object().status.latestVersion;                            
                        }
                    }
                }
            }            }
            stage('system tests') {
                steps{
                    sh script: "cd ${applicationNameST} && failsafe:integration-test failsafe:verify"   
                }
            }    
    }               
}
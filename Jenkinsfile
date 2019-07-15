def applicationName = "statustest";
def applicationNameST = "${applicationName}-st";

pipeline{
    agent {
        label 'maven'
    }

    stages{
            stage('build') {
                steps{
                    sh script: "cd ${applicationName} && mvn -DskipTests clean package"   
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
                            def startedBuild = build.startBuild("--from-file=\"./${applicationName}/target/${applicationName}.war\"");
                            startedBuild.logs('-f');
                            echo "${applicationName} build status: ${startedBuild.object().status}";                            
                        }
                    }
                }
            }            
            }
            stage('wait until available'){
                steps{
                    script{
                        openshift.withCluster() {
                            openshift.withProject() {
                                def dc = openshift.selector('dc',applicationName )
                                dc.rollout().status()
                            }
                        }                
                    }
                }
            }
            stage('verify service connectivity'){
                steps{
                    script{
                        openshift.withCluster() {
                            openshift.withProject() {
                                def connected = openshift.verifyService(applicationName)
                                if (connected) {
                                    echo "Successfully connected to ${applicationName}"
                                } else {
                                    echo "Unable to connect to ${applicationName}"
                                }
                            }
                        }                        
                    }
                }
            }
            stage('system tests') {
                steps{
                    sh script: "cd ${applicationNameST} && mvn failsafe:integration-test failsafe:verify"   
                }
            }    
    }               
}
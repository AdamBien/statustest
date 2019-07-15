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
                    openshiftBuild(bldCfg:applicationName,showBuildLogs:"false");
                }
            }
            stage('perform scaling') {
                steps{
                    openshiftScale(depCfg: applicationName,replicaCount: replicaCount,verifyReplicaCount:"true");
                }
            }                
            stage('verify service') {
                steps{
                    openshiftVerifyService(svcName: applicationName);
                }
            }                
            stage('system tests') {
                steps{
                    sh script: "cd ${applicationNameST} && failsafe:integration-test failsafe:verify"   
                }
            }    
    }               
}
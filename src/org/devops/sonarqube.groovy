package org.devops


//scan
// def SonarScan(sonarServer,projectName,projectDesc,projectPath,branchName){   //如果有多sonarqube机器启用此行
def SonarScan(projectName,projectDesc,projectPath,branchName){  
    //定义服务器列表
//     def servers = ["test":"sonarqube-test","prod":"sonarqube-prod"]
    
    
    withSonarQubeEnv("sonarqube"){
        def scannerHome = tool 'sonarqube-scanner'  
        //def sonarServer = "http://192.168.1.200:9000"
        def sonarDate = sh  returnStdout: true, script: 'date  +%Y%m%d%H%M%S'
        sonarDate = sonarDate - "\n"
    
        
        sh """ 
            ${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${projectName} \
            -Dsonar.projectName=${projectName} -Dsonar.projectVersion=${sonarDate} -Dsonar.ws.timeout=30 \
            -Dsonar.projectDescription=${projectDesc} \
            -Dsonar.sources=${projectPath} -Dsonar.sourceEncoding=UTF-8  \
            -Dsonar.java.test.binaries=.
        """
    }
    

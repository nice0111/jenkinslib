package org.devops

//封装HTTP

def HttpReq(reqType,reqUrl,reqBody){
    def sonarServer = "http://10.7.35.74:9000/api"
   
    result = httpRequest authentication: 'sonarqube-Auth',
            httpMode: reqType, 
            contentType: "APPLICATION_JSON",
            consoleLogResponseBody: true,
            ignoreSslErrors: true, 
            requestBody: reqBody,
            url: "${sonarServer}/${reqUrl}"
            quiet: true
    
    return result
}

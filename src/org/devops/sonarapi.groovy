package org.devops

//封装HTTP

def HttpReq(reqType,reqUrl,reqBody){
    def sonarServer = "http://10.7.35.74:9000/api"
   
    result = httpRequest authentication: '87c7e58f-ca5a-436c-a2c0-aee1b88ce693',
            httpMode: reqType, 
            contentType: "APPLICATION_JSON",
            consoleLogResponseBody: true,
            ignoreSslErrors: true, 
            requestBody: reqBody,
            url: "${sonarServer}/${reqUrl}",
            validResponseCodes: '200:404'
//             quiet: true,
    
    return result
}



def SerarchProject(projectName){
    apiUrl = "projects/search?projects=${projectName}"
    response = HttpReq("GET",apiUrl,'')

    response = readJSON text: """${response.content}"""
    result = response["paging"]["total"]

    if(result.toString() == "0"){
       return "false"
    } else {
       return "true"
    }
}

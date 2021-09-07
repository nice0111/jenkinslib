// checkout 

def checkout(branch,credentialsId, url ) {
  checkout(
            [
            $class: 'GitSCM', branches: [[name: '${branch}']], 
            extensions: [], 
            userRemoteConfigs: [[credentialsId: '${credentialsId}', 
            url: '${url}']]
            ]
  )

}

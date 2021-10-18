// checkout 

def checkout(branch, giturl ) {
  checkout(
            [
            $class: 'GitSCM', branches: [[name: '${branch}']], 
            extensions: [], 
            userRemoteConfigs: [[credentialsId: 'devin-001', 
            url: '${url}']]
            ]
  )

}

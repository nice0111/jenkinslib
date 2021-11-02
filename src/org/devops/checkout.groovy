package org.devops


// checkout 
def checkout(branch, giturl ) {
  checkout(
            [
            $class: 'GitSCM', branches: [[name: '${branch}']], 
            extensions: [], 
            userRemoteConfigs: [[credentialsId: '', 
            url: '${giturl}']]
            ]
  )

}

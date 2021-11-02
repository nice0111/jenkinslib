package org.devops


// checkout 
def checkout(branch, giturl ) {
  checkout(
            [
            $class: 'GitSCM', branches: [[name: '${branch}']], 
            extensions: [], 
            userRemoteConfigs: [[credentialsId: 'f6d8237b-e3d9-4d75-a2c1-15a6578ed785', 
            url: '${giturl}']]
            ]
  )

}

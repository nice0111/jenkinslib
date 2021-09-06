// 前端项目

def frontend(env) {
  sh """
          cd $WORKSPACE
          source /etc/profile
          rm -rf  yarn.lock
          yarn cache clean
          yarn 
          yarn build:"${env}"
  """
}

// 后端项目
def backend() {
  sh '''
          cd $WORKSPACE && rm -rf $WORKSPACE/composer.lock
          /usr/local/bin/composer install
     '''
}
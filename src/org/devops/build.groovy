// 前端项目

def frontend(env) {
  sh """
          cd $WORKSPACE
          source /etc/profile
          rm -f  yarn.lock
          yarn cache clean
          yarn 
          yarn build:"${env}"
  """
}

// 后端项目
def backend() {
  sh '''
          cd $WORKSPACE && rm -f $WORKSPACE/composer.lock
          /usr/local/bin/composer install
     '''
}

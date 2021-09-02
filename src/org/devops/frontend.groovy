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

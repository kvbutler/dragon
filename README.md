# Dragon



## Infrastructure/Jenkins/Ecs

1. Initial deployment:

 a. Add jenkins password to AWS Secrets Manager
  ```
    aws secretsmanager create-secret --name JenkinsPassword --description "Jenkins admin password" --secret-string "dragonJenkins" --region us-east-1
  ```
  b. Run init_script.sh (Requires aws cli v1.16.11)
  ```
    source init_script.sh
  ```

  c. deploy jupyter notebooks - add ssh key
  aws secretsmanager create-secret --name GitDeployPubKey --description "GitDeployPubKey" --secret-string file://./deploy_key.pub --region us-east-1

    aws secretsmanager create-secret --name GitDeployPrivKey --description "GitDeployPrivKey" --secret-string file://./deploy_key --region us-east-1

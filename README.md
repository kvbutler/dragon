# Dragon



## Infrastructure/Jenkins/Ecs

1. Initial deployment:
 
 a. Add jenkins password to AWS Secrets Manager
  ```
    aws secretsmanager create-secret --name JenkinsPassword --description "Jenkins admin password" --secret-string "somepassword" --region us-east-1
  ```
  b. Run init_script.sh (Requires aws cli v1.16.11)
  ```
    source init_script.sh
  ```

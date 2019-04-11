# Dragon



* Setup IDP
 a. Using AWS Console or Cli, deploy infrastructure/idp_role.yml CloudFormation template.

 b. Once IDP and IAM roles are setup, use the following url for accessing the AWS Console:
   https://sso.jumpcloud.com/saml2/aws

 c. For Cli, use https://github.com/Versent/saml2aws for getting AWS STS credentials.
    You can either follow the installation steps (https://github.com/Versent/saml2aws#install) or download the binary file from https://github.com/Versent/saml2aws/releases

    Once installed, run the following command to set up creds:
    ```
      ./saml2aws configure -a profilename
      ./saml2aws login -a profilename
    ```

* Initial deployment:

 a. Add jenkins password to AWS Secrets Manager
  ```
    aws secretsmanager create-secret --name JenkinsPassword --description "Jenkins admin password" --secret-string "somepassword" --region us-east-1
  ```
 b. Run init_script.sh (Requires aws cli v1.16.11)
  ```
    source init_script.sh
  ```

 c. deploy jupyter notebooks - add ssh key
  ```

    aws secretsmanager create-secret --name GitDeployPubKey --description "GitDeployPubKey" --secret-string file://./somekey.pub --region us-east-1

    aws secretsmanager create-secret --name GitDeployPrivKey --description "GitDeployPrivKey" --secret-string file://./somekey --region us-east-1
  ```

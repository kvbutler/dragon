export working_dir=/opt/jenkins-cfn-chef/jenkins
pushd ${working_dir}

touch /tmp/env_vars
source /tmp/env_vars

cat > ${working_dir}/config.rb <<SOLORB
cookbook_path %w(${working_dir}/cookbooks ${working_dir}/vendor-cookbooks)
SOLORB

cat > ${working_dir}/attributes.json <<ATTRS
{
  "run_list": [
     "recipe[java]",
     "recipe[nodejs]",
     "recipe[jenkins::master]",
     "recipe[jenkins-config]"
     ],
  "java": {
    "jdk_version": "8"
  },
  "nodejs": {
    "version": "10.15.3",
    "install_method": "package",
    "repo": "https://rpm.nodesource.com/pub_10.x/el/6/x86_64/",
    "key": "https://rpm.nodesource.com/pub/el/NODESOURCE-GPG-SIGNING-KEY-EL",
    "npm_packages": [
      {
        "name": "@angular/cli"
      }
    ]
  },
   "jenkins_config": {
     "jenkins_user": "$JENKINS_USER",
     "jenkins_password": "$JENKINS_PASSWORD"
   }
}
ATTRS

berks vendor vendor-cookbooks -b cookbooks/jenkins-config/Berksfile
chef-solo -j attributes.json -c config.rb --logfile ./chef_solo_run.log
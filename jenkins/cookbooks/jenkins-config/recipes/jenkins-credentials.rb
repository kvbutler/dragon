jenkins_password_credentials node[:jenkins_config][:user] do
  id 'jenkins_credential'
  password node[:jenkins_config][:password]
end
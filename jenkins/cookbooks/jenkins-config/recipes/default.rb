
include_recipe 'jenkins-config::jenkins-plugins'
include_recipe 'jenkins-config::executors'
include_recipe 'jenkins-config::jobseed'
#include_recipe 'jenkins-config::jenkins-credentials'
#include_recipe 'jenkins-config::jenkins-slaves'
include_recipe 'jenkins-config::security'

service 'jenkins' do
  action :restart
end

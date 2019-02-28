template "/tmp/security.groovy" do
  source 'security.groovy.erb'
  variables ({
      jenkins_user: node['jenkins_config']['jenkins_user'],
      jenkins_password: node['jenkins_config']['jenkins_password']
    })
  mode '644'
end

jenkins_script 'add_security' do
  command <<-EOH.gsub(/^ {4}/, '')
	evaluate(new File("/tmp/security.groovy"))
  EOH
end

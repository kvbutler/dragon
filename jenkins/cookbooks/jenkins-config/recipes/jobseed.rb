template "/tmp/seedjob.groovy" do
  source 'seedjob.groovy.erb'
  variables ({
       job_seed_repo: node['jenkins_config']['job_seed_repo']
  })
  mode '644'
end

jenkins_script 'create_seedjob' do
  command <<-EOH.gsub(/^ {4}/, '')
	evaluate(new File("/tmp/seedjob.groovy"))
  EOH
end




# template '/tmp/job-seed.xml' do
#   source 'job-seed.xml.erb'
#   variables ({
#       seeds: node['jenkins_config']['seeds']
#     })
#   mode '644'
# end
#
# jenkins_job "seed-jobs" do
#   action :create
#   config '/tmp/job-seed.xml'
# end

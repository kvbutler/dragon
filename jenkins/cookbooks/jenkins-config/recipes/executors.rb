jenkins_script 'set_executors' do
  command <<-EOH.gsub(/^ {4}/, '')
    import hudson.model.*

    Hudson hudson = Hudson.getInstance()
    hudson.setNumExecutors(#{node[:jenkins_config][:executors]})
    hudson.setNodes(hudson.getNodes())
    hudson.save()
  EOH
end

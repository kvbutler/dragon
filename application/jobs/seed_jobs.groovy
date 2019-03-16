import javaposse.jobdsl.dsl.*

pipelineJob('web-application-pipeline') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("application/jobs/Jenkinsfile")
        }
    }
}

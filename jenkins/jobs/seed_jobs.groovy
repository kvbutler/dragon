import javaposse.jobdsl.dsl.*

pipelineJob('webapp') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("application/Jenkinsfile")
        }
    }
}

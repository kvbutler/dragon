import javaposse.jobdsl.dsl.*

pipelineJob("testpipeline1") {
    logRotator {
        numToKeep(20)
    }
    definition {
        cps {
            script(readFileFromWorkspace("jobs/scripts/testpipeline1.groovy"))
            sandbox()
        }
    }
}

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

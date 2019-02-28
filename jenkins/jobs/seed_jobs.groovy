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

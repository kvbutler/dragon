import javaposse.jobdsl.dsl.*

pipelineJob('sagemaker-algorithm-build') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("sagemaker/jobs/scripts/build_algorithm_image")
        }
    }
}

pipelineJob('sagemaker-train-model') {

    parameters {
      stringParam('imageName', 'sagemaker-algorithm', 'Algorithm image name')
      stringParam('imageVersion', 'latest', 'Algorithm image version (tag)')
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("sagemaker/jobs/scripts/train_model")
        }
    }
}

pipelineJob('sagemaker-retrain-model') {

    parameters {
      stringParam('imageName', 'sagemaker-algorithm', 'Algorithm image name')
      stringParam('imageVersion', 'latest', 'Algorithm image version (tag)')
      stringParam('modelUri', '', 'model uri to retrain')
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("sagemaker/jobs/scripts/train_model")
        }
    }
}

pipelineJob('sagemaker-promote-model-QA') {

    parameters {
      choiceParam('envName', ['qa'])
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("sagemaker/jobs/scripts/deploy_model")
        }
    }
}

pipelineJob('sagemaker-promote-model-Prod') {

    parameters {
      choiceParam('envName', ['prod'])
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("sagemaker/jobs/scripts/deploy_model")
        }
    }
}

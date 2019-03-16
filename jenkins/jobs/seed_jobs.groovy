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

pipelineJob('sagemaker-algorithm-build') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/seanjoo/sagemaker-flow')
            }
            scriptPath("jobs/build_algorithm_image")
        }
    }
}

pipelineJob('sagemaker-train-model') {

    parameters {
      stringParam('imageName', '', 'Algorithm image name')
      stringParam('imageVersion', 'latest', 'Algorithm image version (tag)')

    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/seanjoo/sagemaker-flow')
            }
            scriptPath("jobs/train_model")
        }
    }
}

pipelineJob('sagemaker-retrain-model') {

    parameters {
      stringParam('imageName', '', 'Algorithm image name')
      stringParam('imageVersion', 'latest', 'Algorithm image version (tag)')
      stringParam('modelUri', '', 'model uri to retrain')
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/seanjoo/sagemaker-flow')
            }
            scriptPath("jobs/train_model")
        }
    }
}

pipelineJob('sagemaker-promote-model-QA') {

    parameters {
      stringParam('imageName', '', 'Algorithm image name')
      stringParam('imageVersion', 'latest', 'Algorithm image version (tag)')
      stringParam('modelUri', '', 'model uri to retrain')
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/seanjoo/sagemaker-flow')
            }
            scriptPath("jobs/deploy_model")
        }
    }
}

pipelineJob('sagemaker-promote-model-Prod') {

    parameters {
      stringParam('imageName', '', 'Algorithm image name')
      stringParam('imageVersion', 'latest', 'Algorithm image version (tag)')
      stringParam('modelUri', '', 'model uri to retrain')
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/seanjoo/sagemaker-flow')
            }
            scriptPath("jobs/deploy_model")
        }
    }
}

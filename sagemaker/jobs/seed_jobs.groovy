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
      stringParam('trainInstanceCount', '1', 'Number of instance to use for training')
      choiceParam('trainInstanceType', [
         'ml.m5.xlarge',
         'ml.m5.2xlarge',
         'ml.m5.4xlarge',
         'ml.m5.12xlarge',
         'ml.m5.24xlarge',
         'ml.m4.xlarge',
         'ml.m4.2xlarge',
         'ml.m5.4xlarge',
         'ml.m5.10xlarge',
         'ml.m5.16xlarge',
         'ml.c5.xlarge',
         'ml.c5.2xlarge',
         'ml.c5.4xlarge',
         'ml.c5.9xlarge',
         'ml.c5.18xlarge',
         'ml.c4.xlarge',
         'ml.c4.2xlarge',
         'ml.c4.4xlarge',
         'ml.c4.8xlarge',
         'ml.p2.xlarge',
         'ml.p2.8xlarge',
         'ml.p3.2xlarge',
         'ml.p3.8xlarge',
         'ml.p3.16xlarge'
         ], 'Instance type for training')
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
      stringParam('trainInstanceCount', '1', 'Number of instance to use for training')
      choiceParam('trainInstanceType', [
         'ml.m5.xlarge',
         'ml.m5.2xlarge',
         'ml.m5.4xlarge',
         'ml.m5.12xlarge',
         'ml.m5.24xlarge',
         'ml.m4.xlarge',
         'ml.m4.2xlarge',
         'ml.m5.4xlarge',
         'ml.m5.10xlarge',
         'ml.m5.16xlarge',
         'ml.c5.xlarge',
         'ml.c5.2xlarge',
         'ml.c5.4xlarge',
         'ml.c5.9xlarge',
         'ml.c5.18xlarge',
         'ml.c4.xlarge',
         'ml.c4.2xlarge',
         'ml.c4.4xlarge',
         'ml.c4.8xlarge',
         'ml.p2.xlarge',
         'ml.p2.8xlarge',
         'ml.p3.2xlarge',
         'ml.p3.8xlarge',
         'ml.p3.16xlarge'
         ], 'Instance type for training')
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
      stringParam('trainInstanceCount', '1', 'Number of instance to use for training')
      choiceParam('trainInstanceType', [
         'ml.m5.xlarge',
         'ml.m5.2xlarge',
         'ml.m5.4xlarge',
         'ml.m5.12xlarge',
         'ml.m5.24xlarge',
         'ml.m4.xlarge',
         'ml.m4.2xlarge',
         'ml.m5.4xlarge',
         'ml.m5.10xlarge',
         'ml.m5.16xlarge',
         'ml.c5.xlarge',
         'ml.c5.2xlarge',
         'ml.c5.4xlarge',
         'ml.c5.9xlarge',
         'ml.c5.18xlarge',
         'ml.c4.xlarge',
         'ml.c4.2xlarge',
         'ml.c4.4xlarge',
         'ml.c4.8xlarge',
         'ml.p2.xlarge',
         'ml.p2.8xlarge',
         'ml.p3.2xlarge',
         'ml.p3.8xlarge',
         'ml.p3.16xlarge'
         ], 'Instance type for training')
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
      stringParam('trainInstanceCount', '1', 'Number of instance to use for training')
      choiceParam('trainInstanceType', [
         'ml.m5.xlarge',
         'ml.m5.2xlarge',
         'ml.m5.4xlarge',
         'ml.m5.12xlarge',
         'ml.m5.24xlarge',
         'ml.m4.xlarge',
         'ml.m4.2xlarge',
         'ml.m5.4xlarge',
         'ml.m5.10xlarge',
         'ml.m5.16xlarge',
         'ml.c5.xlarge',
         'ml.c5.2xlarge',
         'ml.c5.4xlarge',
         'ml.c5.9xlarge',
         'ml.c5.18xlarge',
         'ml.c4.xlarge',
         'ml.c4.2xlarge',
         'ml.c4.4xlarge',
         'ml.c4.8xlarge',
         'ml.p2.xlarge',
         'ml.p2.8xlarge',
         'ml.p3.2xlarge',
         'ml.p3.8xlarge',
         'ml.p3.16xlarge'
         ], 'Instance type for training')      
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

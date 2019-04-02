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
      stringParam('initialInstanceCount', '1', 'Initial number of instance to deploy')
      choiceParam('instanceType', [
        'ml.m5.xlarge',
        'ml.m5.2xlarge',
        'ml.m5.4xlarge',
        'ml.m5.12xlarge',
        'ml.m5.24xlarge',
        'ml.m4.xlarge',
        'ml.m4.2xlarge',
        'ml.m5.4xlarge',
        'ml.m5.12xlarge',
        'ml.m5.24xlarge',
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
         ], 'Instance type for deployed model')
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
      stringParam('initialInstanceCount', '1', 'Initial number of instance to deploy')
      choiceParam('instanceType', [
        'ml.m5.xlarge',
        'ml.m5.2xlarge',
        'ml.m5.4xlarge',
        'ml.m5.12xlarge',
        'ml.m5.24xlarge',
        'ml.m4.xlarge',
        'ml.m4.2xlarge',
        'ml.m5.4xlarge',
        'ml.m5.12xlarge',
        'ml.m5.24xlarge',
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
         ], 'Instance type for deployed model')
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


pipelineJob('sagemaker-deploy-jupyter-notebook') {

    parameters {
      stringParam('userName', '', 'Username assigned to the notebook instance')
      stringParam('email', '', 'Email address for the user')
      stringParam('repo', 'git@github.com:ICFI/dragon.git', 'Git repo to load')
      choiceParam('instanceType', [
       'ml.t2.large',
       'ml.t2.xlarge',
       'ml.t2.2xlarge',
       'ml.t3.medium',
       'ml.t3.large',
       'ml.t3.xlarge',
       'ml.t3.2xlarge',
       'ml.m5.medium',
       'ml.m5.large',
       'ml.m5.xlarge',
       'ml.m5.2xlarge',
       'ml.m5.4xlarge',
       'ml.m5.12xlarge',
       'ml.m5.24xlarge',
       'ml.m4.xlarge',
       'ml.m4.2xlarge',
       'ml.m4.4xlarge',
       'ml.m4.10xlarge',
       'ml.m4.16xlarge',
       'ml.c5.xlarge',
       'ml.c5.2xlarge',
       'ml.c5.4xlarge',
       'ml.c5.9xlarge',
       'ml.c5.18xlarge',
       'ml.c5d.xlarge',
       'ml.c5d.2xlarge',
       'ml.c5d.4xlarge',
       'ml.c5d.9xlarge',
       'ml.c5d.18xlarge',
       'ml.c4.xlarge',
       'ml.c4.2xlarge',
       'ml.c4.4xlarge',
       'ml.c4.8xlarge',
       'ml.p2.xlarge',
       'ml.p2.8xlarge',
       'ml.p2.16xlarge',
       'ml.p3.2xlarge',
       'ml.p3.8xlarge',
       'ml.p3.16xlarge'
         ], 'Instance type for deployed notebook')
    }
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("sagemaker/jobs/scripts/jupyter")
        }
    }
}

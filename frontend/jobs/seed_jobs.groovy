import javaposse.jobdsl.dsl.*

pipelineJob('create-frontend-infra') {

    parameters {
        choiceParam('Environment', ['dev', 'qa', 'prod'])
    }

    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git','master')
            }
            scriptPath("frontend/jobs/scripts/create_frontend_infra")
        }
    }
}

pipelineJob('deploy-static-site-dev') {

    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git','master')
            }
            scriptPath("frontend/jobs/scripts/deploy_static_site_dev")
        }
    }
}

pipelineJob('deploy-lambda-dev') {

    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git', 'master')
            }
            scriptPath("frontend/jobs/scripts/deploy_lambda_dev")
        }
    }
}





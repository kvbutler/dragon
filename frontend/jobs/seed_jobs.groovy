import javaposse.jobdsl.dsl.*

pipelineJob('create-frontend-infra') {

    choiceParams('Environment', ['dev', 'qa', 'prod'])
    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("frontend/jobs/scripts/create_frontend_infra")
        }
    }
}

pipelineJob('deploy-static-site-dev') {

    definition {
        cpsScm {
            scm {
                git('https://github.com/ICFI/dragon.git')
            }
            scriptPath("frontend/jobs/scripts/deploy_static_site_dev")
        }
    }
}



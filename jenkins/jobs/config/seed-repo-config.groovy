
repos {
        dev {
            reposToAutomate = [
            ]
        }
        prod {
            reposToAutomate = [
            ]
        }
        all {
            reposToAutomate = [
               [projectName: "web-application", viewName: "Web App", url: "https://github.com/ICFI/dragon.git", credentials: "", seed_job: "application/seed_jobs.groovy"],
               [projectName: "sagemaker-model", viewName: "SageMaker Model", url: "https://github.com/seanjoo/sagemaker-flow", credentials: "", seed_job: "jobs/seed_jobs.groovy"]
            ]
        }
    }

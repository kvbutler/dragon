
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
               [projectName: "web-application", viewName: "Web App", url: "https://github.com/ICFI/dragon.git", credentials: "", seed_job: "application/jobs/seed_jobs.groovy"],
               [projectName: "sagemaker", viewName: "SageMaker Model", url: "https://github.com/ICFI/dragon.git", credentials: "", seed_job: "sagemaker/jobs/seed_jobs.groovy"]
            ]
        }
    }

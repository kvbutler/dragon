
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
               [projectName: "frontend", viewName: "Web App", url: "https://github.com/ICFI/dragon.git", credentials: "", seed_job: "frontend/jobs/seed_jobs.groovy"],
               [projectName: "sagemaker", viewName: "SageMaker Model", url: "https://github.com/ICFI/dragon.git", credentials: "", seed_job: "sagemaker/jobs/seed_jobs.groovy"]
            ]
        }
    }

def registrationConfigFile = readFileFromWorkspace('config/seed-repo-config.groovy')

def registrationConfig = new ConfigSlurper().parse(registrationConfigFile)

def sharedReposToAutomate = registrationConfig.repos."all".reposToAutomate


sharedReposToAutomate.each { project ->

    def reposToInclude = [
           project
    ]

    println(project.projectName)

    if (project.viewName) {

        def viewRegex = project.viewRegex ? project.viewRegex : "${project.projectName}-.*"

        listView(project.viewName) {
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
                lastDuration()
                buildButton()
            }
            filterBuildQueue()
            filterExecutors()
            jobs {
                regex(/(?i)(${viewRegex})/)
            }
        }
    }

    job(project.projectName + '-seed-job') {

        if (project.disabled) {
            disabled()
        }
        logRotator {
            daysToKeep(90)
        }

        multiscm {
          git {
               remote {
                   url(project.url)
                   credentials(project.credentials)
               }
           }
        }

        triggers {
            scm 'H/5 * * * *'
        }

        steps {

            dsl {
                external "${project.seed_job}"
                removeAction("DELETE")
                removeViewAction("DELETE")
            }

            shell('echo ${JENKINS_HOME}')
        }
   }
}

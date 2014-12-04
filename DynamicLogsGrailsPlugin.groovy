class DynamicLogsGrailsPlugin {
    // the plugin version
    def version = "0.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.1 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Dynamic Logs Plugin" // Headline display name of the plugin
    def author = "Dharmesh Patel"
    def authorEmail = "dbpatel@expapp.com -or- dbpatel219@gmail.com"
    def description = '''\
This plugin allows you to dynamically change log levels via Rabbit Messages.  This will allow you to change log levels on all instances listening to a particular topic.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/dynamic-logs"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Experience", url: "http://www.expapp.com/" ]

    // Any additional developers beyond the author specified above.
    def developers = [[ name: "Dharmesh Patel", email: "dbpatel@expapp.com" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/dbpfindexp/dynamic-logs" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        try {
            application.config.merge(new ConfigSlurper().parse(application.classLoader.loadClass('DynamicLoggingConfig')))
        } catch (Exception e) {
            log.error('Unable to load DynamicLoggingConfig')
        }
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}

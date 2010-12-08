grails.project.work.dir = "target/work"
grails.plugin.location.'plugin-views' = 'plugins/plugin-views-0.1'
grails.project.dependency.resolution = {
    inherits('global') {
    }
    repositories {
        grailsPlugins()
        grailsCentral()
    }
}
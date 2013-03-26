grails.project.work.dir = "target/work"

grails.plugin.location.'plugin-views' = "${basedir}/plugins/plugin-views-0.1"
grails.plugin.location.'namespace-one' = "${basedir}/plugins/namespace-one"
grails.plugin.location.'namespace-two' = "${basedir}/plugins/namespace-two"

//grails.project.war.file = "target/${appName}-${appVersion}.war"
// grails.project.fork.run=true
grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenRepo "http://repo.grails.org/grails/core"
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'
    }

    plugins {
        runtime ":hibernate:3.6.10.BUILD-SNAPSHOT"
        build ":tomcat:7.0.37.BUILD-SNAPSHOT"
        compile ":webflow:2.0.8.1"

        compile ":compress:0.3"
        compile ":db-util:0.4"
        compile ":freemarker:0.3"

        compile ":jquery:1.8.3"
        compile ":resources:1.1.6"

        runtime ":database-migration:1.0"

        test ':functional-test:1.3-RC1'
        runtime ":build-test-data:1.1.1"
    }    
}

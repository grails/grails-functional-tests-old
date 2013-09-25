grails.project.work.dir = "target/work"

//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolver="maven"
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

        mavenLocal()
        mavenCentral()
        mavenRepo "http://repo.grails.org/grails/core"
    }
   
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
        runtime 'hsqldb:hsqldb:1.8.0.10'
    }
    plugins {
        runtime ":hibernate:3.6.10.1"
        build ":tomcat:7.0.40"
        test ':functional-test:1.3-RC1'
        compile ':scaffolding:1.0.BUILD-SNAPSHOT'
    }    
}

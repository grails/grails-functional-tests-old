grails.project.work.dir = "target/work"

grails.plugin.location.'plugin-views' = "${basedir}/plugins/plugin-views-0.1"
grails.plugin.location.'namespace-one' = "${basedir}/plugins/namespace-one"
grails.plugin.location.'namespace-two' = "${basedir}/plugins/namespace-two"

//grails.project.war.file = "target/${appName}-${appVersion}.war"
// grails.project.fork.run=true
grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the run-app JVM
    // run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
]

grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        excludes 'grails-test'
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
        runtime "org.grails:grails-test:$grailsVersion"
        test 'net.sourceforge.nekohtml:nekohtml:1.9.18'
        test 'net.sourceforge.htmlunit:htmlunit:2.12'
        test 'net.sourceforge.htmlunit:htmlunit-core-js:2.12'
        runtime "org.grails:grails-datastore-gorm-hibernate:2.0.2.BUILD-SNAPSHOT"
    }

    plugins {
        runtime ":hibernate:3.6.10.1"
        build ":tomcat:7.0.42"
        compile ":webflow:2.0.8.1", {
               excludes 'javassist'
        }
        compile ':scaffolding:2.0.0'

        //compile ":compress:0.3"
        compile ":db-util:0.4"
        compile ":freemarker:0.3"

        compile ":jquery:1.8.3"
        compile ":resources:1.2.1"

        runtime ":database-migration:1.3.6"

        test ':functional-test:2.0.RC2-SNAPSHOT'
        runtime ":build-test-data:1.1.1"
    }    
}

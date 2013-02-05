grails.project.work.dir = "target/work"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.plugin.location.'plugin-views' = "${basedir}/plugins/plugin-views-0.1"
grails.plugin.location.'namespace-one' = "${basedir}/plugins/namespace-one"
grails.plugin.location.'namespace-two' = "${basedir}/plugins/namespace-two"

//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.fork.run=true
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

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'
        build "org.grails:grails-plugin-tomcat:$grailsVersion"
        runtime "org.grails:grails-plugin-hibernate:$grailsVersion"        
        compile "org.grails:grails-webflow:$grailsVersion"     

        runtime "org.grails:grails-plugin-testing:${grailsVersion}"   
        runtime "org.grails:grails-test:${grailsVersion}"   
    }

    plugins {
        compile ":compress:0.3"
        compile ":db-util:0.4"
        compile ":freemarker:0.3"
        
        compile ":jquery:1.8.3"
        compile ":resources:1.1.2"

        runtime ":database-migration:1.0"
        
        test ':functional-test:1.3-RC1'
        runtime ":build-test-data:1.1.1"
        compile ':webflow:2.0.0', {
             exclude 'grails-webflow'
        }

    }    
    
}

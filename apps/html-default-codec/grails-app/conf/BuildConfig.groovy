grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.work.dir="target/work"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.fork.run = true
grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
        mavenRepo "http://repo.grails.org/grails/core"

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'
        test 'net.sourceforge.htmlunit:htmlunit:2.12', {
            // excludes 'xalan', 'xercesImpl'
        }        
    }

    plugins {
        runtime ":hibernate:3.6.10.1"
        build ":tomcat:7.0.42"
        compile ":jquery:1.7"
        compile ":resources:1.1.2"
        compile ':scaffolding:1.0.BUILD-SNAPSHOT'

        runtime ":database-migration:1.0"
        
        test ':functional-test:2.0.RC1', {
            excludes 'htmlunit'
        }

    }
}

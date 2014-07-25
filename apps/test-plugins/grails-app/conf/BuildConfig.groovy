grails.plugin.location.'db-util' = "../../in-place-plugins/grails-db-util"
grails.plugin.location.'resources-to-copy' = "../../in-place-plugins/resources-to-copy"
grails.project.work.dir = "target/work"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits( "global" ) {
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

        // runtime 'mysql:mysql-connector-java:5.1.5'
        runtime 'org.hsqldb:hsqldb:2.3.2'
        test 'net.sourceforge.nekohtml:nekohtml:1.9.18'
        test 'net.sourceforge.htmlunit:htmlunit:2.12'
        test 'net.sourceforge.htmlunit:htmlunit-core-js:2.12'
    }
    plugins {
        runtime "${System.getProperty('hibernatePluginVersion',':hibernate:3.6.10.17-SNAPSHOT')}"
        build ":tomcat:7.0.54"
        test ':functional-test:2.0.0'
        compile ':scaffolding:2.1.2'
    }
}

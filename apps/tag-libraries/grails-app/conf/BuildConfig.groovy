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
        runtime 'org.hsqldb:hsqldb:2.3.2'
        test 'net.sourceforge.nekohtml:nekohtml:1.9.18'
        test 'net.sourceforge.htmlunit:htmlunit:2.12'
        test 'net.sourceforge.htmlunit:htmlunit-core-js:2.12'
        runtime 'javax.servlet:jstl:1.1.2'
        runtime 'taglibs:standard:1.1.2'
    }
    plugins {
        runtime "${System.getProperty('hibernatePluginVersion',':hibernate:3.6.10.19-SNAPSHOT')}"
        build ":tomcat:7.0.55"
        test ':functional-test:2.0.0'
        compile ':scaffolding:2.1.2'
    }
}

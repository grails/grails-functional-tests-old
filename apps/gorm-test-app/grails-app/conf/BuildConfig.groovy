grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolver="maven"
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
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
        runtime 'hsqldb:hsqldb:1.8.0.10'
        test( 'commons-codec:commons-codec:1.6') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'net.sourceforge.nekohtml:nekohtml:1.9.16') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'net.sourceforge.cssparser:cssparser:0.9.7') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'xalan:serializer:2.7.1') {
            excludes 'xml-apis', 'xerces'
        }
        test( 'xalan:xalan:2.7.1') {
            excludes 'xml-apis', 'xerces'
        }
/*
        test( 'xercesImpl:xercesImpl:2.9.1') {
            excludes 'xml-apis'
        }
*/

        test( 'org.w3c.css:sac:1.3') {
            excludes 'xml-apis', 'xerces'
        }
    }
    plugins {
        runtime ":hibernate:3.6.10.1"
        build ":tomcat:7.0.42"
        // test ':functional-test:2.0.RC1'
        compile ':scaffolding:2.0.0'
    }
}

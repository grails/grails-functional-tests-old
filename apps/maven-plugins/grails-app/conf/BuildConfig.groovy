grails.project.work.dir = "target/work"

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenRepo "http://snapshots.repository.codehaus.org"
        mavenRepo "http://repo.grails.org/grails/core"
        mavenRepo 'http://maven.springframework.org/milestone'
        mavenCentral()
    }
    plugins {
        runtime ':cloud-foundry:1.2.3'
        test ":functional-test:2.0.RC2-SNAPSHOT"
        runtime ":hibernate:3.6.10.3-SNAPSHOT"
        build ":tomcat:7.0.42"
        compile ':scaffolding:2.0.1'
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime 'hsqldb:hsqldb:1.8.0.10'
        test 'net.sourceforge.nekohtml:nekohtml:1.9.18'
        test 'net.sourceforge.htmlunit:htmlunit:2.12'
        test 'net.sourceforge.htmlunit:htmlunit-core-js:2.12'        
    }
}

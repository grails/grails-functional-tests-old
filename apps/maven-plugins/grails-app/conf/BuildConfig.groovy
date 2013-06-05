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
        test ":functional-test:1.3-RC1"
        runtime ":hibernate:3.6.10.M3"
        build ":tomcat:7.0.40"
        compile ':scaffolding:1.0.BUILD-SNAPSHOT'
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime 'hsqldb:hsqldb:1.8.0.10'
    }
}

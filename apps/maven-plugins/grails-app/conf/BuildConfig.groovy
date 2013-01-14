grails.project.work.dir = "target/work"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
		
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        mavenRepo "http://snapshots.repository.codehaus.org"
		mavenRepo "http://repo.grails.org/grails/core"
        mavenRepo 'http://maven.springframework.org/milestone'
		grailsCentral()
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
	plugins {
		runtime ':cloud-foundry:1.2.3'		
		test ":functional-test:1.3-RC1"
	}
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime 'hsqldb:hsqldb:1.8.0.10'
        build "org.grails:grails-plugin-tomcat:$grailsVersion"
        runtime "org.grails:grails-plugin-hibernate:$grailsVersion"

    }
}

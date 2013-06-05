grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.work.dir = "target/work"
grails.project.source.level = 1.5
grails.project.target.level = 1.5
//grails.project.war.file = "target/${appName}-${appVersion}.war"

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
        mavenRepo "https://nexus.codehaus.org/content/repositories/snapshots"
    }

    def gebVersion = "0.6.0"
    def seleniumVersion = "2.0rc3"

    dependencies {
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
    	    exclude "xml-apis"
	   }
        test "org.codehaus.geb:geb-junit4:$gebVersion"
        test 'org.w3c.css:sac:1.3'
    }

    plugins {
        runtime ":hibernate:3.6.10.M3"
        build ":tomcat:7.0.40"
        compile ":jquery:1.6.1.1"
        compile ":resources:1.0.2"
        compile ':scaffolding:1.0.BUILD-SNAPSHOT'

        test ":geb:$gebVersion"
    }
}

grails.tomcat.jvmArgs = ["-XX:+DisableExplicitGC", '-Xmx768M', '-Xms256M', '-XX:PermSize=92m', '-XX:MaxPermSize=192m',
                         '-Dgrails.reload.location=' + new File('target/reload').absolutePath]

if (System.getProperty('grails.debug')) {
  grails.tomcat.jvmArgs = ["-Xdebug","-Xnoagent","-Dgrails.full.stacktrace=true","-Djava.compiler=NONE","-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"]
  grails.tomcat.startupTimeoutSecs = 30000
}

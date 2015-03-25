grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = false

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    def gebVersion = "0.9.3"
    def seleniumVersion = "2.42.2"

    dependencies {
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
    	    exclude "xml-apis"
	   }
        test "org.gebish:geb-junit4:$gebVersion"
        test "org.gebish:geb-spock:$gebVersion"
        test 'net.sourceforge.nekohtml:nekohtml:1.9.20'
        test 'net.sourceforge.htmlunit:htmlunit:2.14'
    }

    plugins {
        // plugins for the build system only
        build ":tomcat:7.0.55.2"

        test ":geb:$gebVersion"
        
        test ":rest-client-builder:2.1.0"
        compile ":remote-control:1.5"
        // plugins for the compile step
        //compile ":scaffolding:2.1.2"
        //compile ':cache:1.1.8'

        // plugins needed at runtime but not for compilation
        runtime "${System.getProperty('hibernatePluginVersion',':hibernate:3.6.10.19')}" // or ":hibernate4:4.3.8.1"
        //runtime ":database-migration:1.4.0"
        //runtime ":jquery:1.11.1"
        //runtime ":resources:1.2.13"
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0.1"
        //runtime ":cached-resources:1.1"
        //runtime ":yui-minify-resources:0.1.5"
    }
}

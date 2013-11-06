import java.util.zip.ZipFile

class WarTestCase extends AbstractCliTestCase {
    protected void setUp() {
        workDir = new File(baseWorkDir, "app1")
    }

    void testNoArgs() {
        execute([ "war" ])

        assertEquals 0, waitForProcess()
        verifyHeader()
        assertTrue output.contains("Environment set to production")
        assertTrue output.contains("Compiling 3 GSP files for package [app1]")
        
        // Check that the WAR file exists.
        def warFile = new File(workDir, "target/app1-0.1.war")
        assertTrue "WAR file does not exist, or it has the wrong path and/or filename.",
                   warFile.exists()

        // Check that the WAR includes some of the dependencies we expect.
        def warEntries = [] as Set
        def warZip = new ZipFile(warFile)
        for (entry in warZip.entries()) {
            if (!entry.directory) {
                warEntries << entry.name
            }
        }

        assertTrue "aspectjweaver-1.7.2.jar file is missing from the WAR",
                   warEntries.contains("WEB-INF/lib/aspectjweaver-1.7.2.jar")
        assertTrue "hibernate-core-3.6.10.Final.jar file is missing from the WAR",
                   warEntries.contains("WEB-INF/lib/hibernate-core-3.6.10.Final.jar")
        assertTrue "log4j-1.2.17.jar file is missing from the WAR",
                   warEntries.contains("WEB-INF/lib/log4j-1.2.17.jar")
        assertTrue "grails-bootstrap-${grailsVersion}.jar file is missing from the WAR",
                   warEntries.contains("WEB-INF/lib/grails-bootstrap-${grailsVersion}.jar".toString())
        assertTrue "commons-io-2.1.jar file is missing from the WAR",
                   warEntries.contains("WEB-INF/lib/commons-io-2.1.jar")
    }
}


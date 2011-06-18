class GrailsWorkDirTestCase extends AbstractCliTestCase {
    void testWorkDirIsBasedOnApplicationNameAndNotProjectDirectoryName() {
        // GRAILS-6232
        def applicationName = 'someappname'
        def dirName = 'somedirname'
        def grailsWorkDirPath = System.getProperty('grails.work.dir')
        assertFalse 'app work dir should not exist before creating the app', new File(baseWorkDir, applicationName).exists()
        assertFalse 'bad work dir should not exist before creating the app', new File(baseWorkDir, dirName).exists()

        execute([ "create-app", applicationName ])

        assertEquals 0, waitForProcess()
        assertTrue 'app work dir should exist after creating the app', new File(baseWorkDir, applicationName).exists()
        assertFalse 'bad work dir should not exist after creating the app', new File(baseWorkDir, dirName).exists()

        // move the project to a directory name that does not match the application name
        assertTrue 'renaming project directory failed', new File(baseWorkDir, applicationName).renameTo(new File(baseWorkDir,dirName))
        def originalWorkDir = workDir
        try {
            workDir = new File(baseWorkDir, dirName)

            ['compile', 'war', 'test-app'].each { cmd ->
                execute([ cmd ])

                assertEquals "command failed: ${cmd}", 0, waitForProcess()

                assertTrue "app work dir should exist after ${cmd}", new File(grailsWorkDirPath, "projects/$applicationName").exists()
                assertFalse "bad work dir should not exist after ${cmd}", new File(grailsWorkDirPath, "projects/$dirName").exists()
            }
        } finally {
            workDir = originalWorkDir
        }
    }

    void testWorkDirIsNotBasedOnCurrentDirectoryNameWhenCreatingNewApp() {
        def grailsWorkDirPath = System.getProperty('grails.work.dir')

        execute([ "create-app", 'anothernewapp' ])

        assertEquals "create-app failed", 0, waitForProcess()
        assertFalse new File(grailsWorkDirPath, "projects/${workDir.name}").exists()
        assertTrue new File(grailsWorkDirPath, "projects/.core").exists()
    }
}


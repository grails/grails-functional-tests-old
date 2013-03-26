class GenerateAllTestCase extends AbstractCliTestCase {
	
	protected void setUp() {
		super.setUp()
    	def appSource = new File(cliTestsDir, "testing-app")
    	workDir = new File(baseWorkDir, "generate-all-testing-app")
		copyDir(appSource, workDir)
		upgrade()
	}
	
    void testGenerateAllForDomainInRootPackage() {
        assertFalse 'Person controller test case should not have existed but it did', new File(workDir, 'grails-app/controllers/PersonController.groovy').exists()
        assertFalse 'Person controller should not have existed but it did', new File(workDir, 'test/unit/PersonControllerTests.groovy').exists()
        execute([ 'generate-all', 'Person' ])
        assertEquals 'generate-all Person failed', 0, waitForProcess()
        assertTrue 'Person controller test case was not created', new File(workDir, 'test/unit/PersonControllerTests.groovy').exists()
        assertTrue 'Person controller was not created', new File(workDir, 'grails-app/controllers/PersonController.groovy').exists()
    
        assertFalse 'Artist controller test case should not have existed but it did', new File(workDir, 'grails-app/controllers/com/demo/ArtistController.groovy').exists()
        assertFalse 'Artist controller should not have existed but it did', new File(workDir, 'test/unit/com/demo/ArtistControllerTests.groovy').exists()
        execute([ 'generate-all', 'com.demo.Artist' ])
        assertEquals 'generate-all com.demo.Artist failed', 0, waitForProcess()
        assertTrue 'Artist controller test case was not created', new File(workDir, 'test/unit/com/demo/ArtistControllerTests.groovy').exists()
        assertTrue 'Artist controller was not created', new File(workDir, 'grails-app/controllers/com/demo/ArtistController.groovy').exists()

        assertFalse 'Widget controller test case should not have existed but it did', new File(workDir, 'grails-app/controllers/WidgetController.groovy').exists()
        assertFalse 'Widget controller should not have existed but it did', new File(workDir, 'test/unit/WidgetControllerTests.groovy').exists()
        execute([ 'generate-all', '.widget' ])
        assertEquals 'generate-all .widget failed', 0, waitForProcess()
        assertTrue 'Widget controller test case was not created', new File(workDir, 'test/unit/WidgetControllerTests.groovy').exists()
        assertTrue 'Widget controller was not created', new File(workDir, 'grails-app/controllers/WidgetController.groovy').exists()
    }

	def copyDir(source, destination) {
		if (source.directory) {
			if (!destination.exists()) {
				assert destination.mkdir() : "making $destination"
			}
			source.eachFile { copyDir(it, new File(destination, it.name)) }
		} else {
			destination.createNewFile()
			destination << source.newInputStream()
		}
	}
}

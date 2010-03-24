class TestingTestCase extends AbstractCliTestCase {

	def appSource = new File(cliTestsDir, "testing-app")
	def app = new File(baseWorkDir, "testing-app")
	
	TestingTestCase() {
		copyDir(appSource, app)
		workDir = app
		execute(["upgrade", "-force"])
		assertEquals("upgrade failed", 0, waitForProcess())
	}
	
	void testRunAllTestsThatShouldPass() {
		execute([ "test-app" ])
		assertEquals 0, waitForProcess()
		println output
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

class TestingTestCase extends AbstractCliTestCase {

	private appSource = new File(cliTestsDir, "testing-app")
	private app = new File(baseWorkDir, "testing-app")

	protected void setUp() {
		super.setUp()
		copyDir(appSource, app)
		workDir = app
		upgrade()
	}

	void testRunAllTestsThatShouldPass() {
		execute([ "test-app" ])
		assertEquals 0, waitForProcess()
	}

	private void copyDir(source, destination) {
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


class StatsTestCase extends AbstractCliTestCase {
	def appSource = new File(cliTestsDir, "testing-app")
	def app = new File(baseWorkDir, "stats-testing-app")

	protected void setUp() {
		super.setUp()
		copyDir(appSource, app)
		workDir = app
		compile()
	}

	void testStats() {
		execute([ "stats" ])
		assertEquals 0, waitForProcess()
		println "output: ${output}"
		assertTrue output.contains('| Domain Classes       |     3 |    10 |')
		assertTrue output.contains('| Services             |     1 |     3 |')
		assertTrue output.contains('| Unit Tests           |     1 |     6 |')
		assertTrue output.contains('| Integration Tests    |     3 |    76 |')
		assertTrue output.contains('| Totals               |     8 |    95 |')
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

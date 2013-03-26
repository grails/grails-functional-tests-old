/**
 * Runs all the CLI test cases in a specific order. Each text case is run
 * as a Groovy class using the standard GroovyTestCase main() method.
 */

import junit.framework.TestResult

cliTestPath = System.getProperty("cli.test.dir") ?: "cli-tests"
cliWorkPath = System.getProperty("cli.target.dir") ?: "cli-tests/target"

// Clear the temp and output directories and recreate. This avoids any
// side-effects due to files left over from previous runs.
def tmpDir = new File(cliWorkPath, "tmp")
tmpDir.deleteDir()
tmpDir.mkdirs()
def outDir = new File(cliWorkPath, "output")
outDir.deleteDir()
outDir.mkdirs()
def workDir = new File(cliWorkPath, "work")
workDir.deleteDir()

// Configure the test cases via some system properties.
System.setProperty("grails.work.dir", workDir.canonicalFile.absolutePath)
System.setProperty("cli.test.dir", cliTestPath)
System.setProperty("cli.target.dir", cliWorkPath)

// Configure and run the tests. Note that the order is important!
def tests = [
    "GenerateAll",
    "Stats",
    "Testing", 
    "Help", 
//    "ListPlugins",
    "CreateApp", 
    "CreateUnitTest",
    "CreateIntegrationTest",
    "Compile", 
    "War", 
    "DevWar",
    "CreateController",
    "InstallTemplates",
    "GrailsWorkDir"
//    "ReInstallPlugin"
]

int exitCode = 0
for (String testScript in tests) {

	println "Running test '$testScript'"
	def retval = new GroovyShell().run(new File(cliTestPath, "src/${testScript}TestCase.groovy"), [])

	// GroovyTestCase appears to return a TestResult after execution.
	// We're not really interested in that and just want a 0 for a
	// successful run and a 1 for an unsuccessful one.
	if (retval instanceof TestResult) {
		retval = retval.wasSuccessful() ? 0 : 1
	}

	exitCode |= retval
}

// All tests completed!
System.exit exitCode

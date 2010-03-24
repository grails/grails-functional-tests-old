class AutowiringTests extends GroovyTestCase {

	def theService
	
	// Make sure dependencies are available in the setup
	void setUp() {
		assertNotNull(theService)
	}

	void testTheServiceWasAutowired() {
		assertNotNull(theService)
	}
}
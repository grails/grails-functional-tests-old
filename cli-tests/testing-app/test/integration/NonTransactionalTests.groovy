class NonTransactionalTests extends GroovyTestCase {

	static transactional = false
	static testCount = 0
	
	void testOne() {
		impl()
	}
	
	void testTwo() {
		impl()
	}

	void testThree() {
		impl()
	}

	protected impl() {
		++testCount
		if (testCount == 1) {
			assertEquals(0, Person.count())
			new Person(name: 'Big Jim').save(flush: true)
		} else if (testCount == 2) {
			assertEquals(1, Person.count())
			Person.list()*.delete(flush: true)
		} else {
			assertEquals(0, Person.count())
		}
	}
}
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.support.DefaultTransactionDefinition

/**
 * This test tests that integration tests are wrapped in transtactions that are rolled back.
 * 
 * The tearDown() also tests that the transaction spans the setup and teardown methods.
 */
class TransactionalTests extends GroovyTestCase {

	def transactionManager
	
	void setUp() {
		assertNotNull("transactionManager was not autowired in", transactionManager)
		assertTransactionIsBound()
		assertPersonCount(0)
		createPerson()
	}

	protected assertTransactionIsBound() {
		// this will throw an IllegalTransactionStateException if there is no bound exception
		transactionManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_MANDATORY))
	}
	
	protected createPerson() {
		new Person(name: 'Billy The Kid').save(flush: true)
	}
	
	protected assertPersonCount(count) {
		assertEquals(count, Person.count())
	} 

	void testOne() {
		assertTransactionIsBound()
		assertPersonCount(1)
		createPerson()
	}

	void testTwo() {
		assertTransactionIsBound()
		assertPersonCount(1)
		createPerson()
	}

	void tearDown() {
		assertTransactionIsBound()
		assertPersonCount(2)
	}

}
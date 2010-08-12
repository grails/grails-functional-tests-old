class CreateIntegrationTestTestCase extends AbstractCliTestCase {

    protected void setUp() {
        workDir = new File(baseWorkDir, 'app1')
    }
    
    void testCreateUnitTest() {
        execute([ 'create-integration-test' ])
        enterInput 'com.demo.integration.HelloWorld'
        
        assertEquals 0, waitForProcess()
        
        def appDir = new File(baseWorkDir, 'app1')
        
        assertTrue 'integration test case was not created', new File(appDir, 'test/integration/com/demo/integration/HelloWorldTests.groovy').exists()
    }
    
    void testSuffixStripping() {
        execute([ 'create-integration-test' ])
        enterInput 'com.demo.integration.DemoTests'
        
        assertEquals 0, waitForProcess()
        
        def appDir = new File(baseWorkDir, 'app1')
        
        assertTrue 'integration test case was not created', new File(appDir, 'test/integration/com/demo/integration/DemoTests.groovy').exists()
        assertFalse 'test with wrong name was created', new File(appDir, 'test/integration/com/demo/integration/DemoTestsTests.groovy').exists()
    }
}

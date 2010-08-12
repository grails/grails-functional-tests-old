class CreateUnitTestTestCase extends AbstractCliTestCase {

    protected void setUp() {
        workDir = new File(baseWorkDir, 'app1')
    }
    
    void testCreateUnitTest() {
        execute([ "create-unit-test" ])
        enterInput "com.demo.unit.HelloWorld"
        
        assertEquals 0, waitForProcess()
        
        def appDir = new File(baseWorkDir, 'app1')
        
        assertTrue 'unit test case was not created', new File(appDir, 'test/unit/com/demo/unit/HelloWorldTests.groovy').exists()
    }
}

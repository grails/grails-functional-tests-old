class CreateControllerTestCase extends AbstractCliTestCase {

    protected void setUp() {
        workDir = new File(baseWorkDir, "app1")
    }

    void testInteractive() {
        execute([ "create-controller" ])
        enterInput "com.foo.bar.Dummy"

        assertEquals 0, waitForProcess()
    }
}

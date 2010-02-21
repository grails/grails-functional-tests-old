class ReInstallPluginTestCase extends AbstractCliTestCase {

    private static final String APP_NAME = 'templates_app'

    private File appDir = new File(baseWorkDir, APP_NAME)

    void testReinstallQuestionIsCaseInsensitive() {
        workDir = appDir

        String pluginPath = new File(System.getProperty('cli.plugin.dir')).canonicalPath + '/grails-resources-to-copy-0.1.zip'

        execute(['install-plugin', pluginPath])
        assertEquals 0, waitForProcess()
        assertTrue output.contains('Plugin resources-to-copy-0.1 installed')

        execute(['install-plugin', pluginPath])
        enterInput 'y'
        assertEquals 0, waitForProcess()
        assertTrue output.contains('Do you want to upgrade this version')
        assertTrue output.contains('Plugin resources-to-copy-0.1 installed')

        execute(['install-plugin', pluginPath])
        enterInput 'Y'
        assertEquals 0, waitForProcess()
        assertTrue output.contains('Do you want to upgrade this version')
        assertTrue output.contains('Plugin resources-to-copy-0.1 installed')

        execute(['install-plugin', pluginPath])
        enterInput 'n'
        assertEquals 1, waitForProcess()
        assertTrue output.contains('Do you want to upgrade this version')
        assertTrue output.contains('Plugin resources-to-copy-0.1 install aborted')

        execute(['install-plugin', pluginPath])
        enterInput 'N'
        assertEquals 1, waitForProcess()
        assertTrue output.contains('Do you want to upgrade this version')
        assertTrue output.contains('Plugin resources-to-copy-0.1 install aborted')
    }
}


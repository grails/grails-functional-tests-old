class InstallTemplatesTestCase extends AbstractCliTestCase {

	private static final String APP_NAME = 'templates_app'

	private File appDir = new File(baseWorkDir, APP_NAME)

	void testInstallTemplates() {
		execute(['create-app'])
		enterInput APP_NAME
		assertEquals 0, waitForProcess()
		workDir = appDir

		assertTrue appDir.exists()
		assertFalse new File(appDir, 'src/templates').exists()

		execute(['install-templates'])
		assertEquals 0, waitForProcess()
		assertTrue output.contains('Templates installed successfully')

		assertTrue new File(appDir, 'src/templates').exists()
		assertTrue new File(appDir, 'src/templates/artifacts/Controller.groovy').exists()
		assertTrue new File(appDir, 'src/templates/artifacts/DomainClass.groovy').exists()
		assertTrue new File(appDir, 'src/templates/artifacts/Filters.groovy').exists()
		assertTrue new File(appDir, 'src/templates/artifacts/Script.groovy').exists()
		assertTrue new File(appDir, 'src/templates/artifacts/Service.groovy').exists()
		assertTrue new File(appDir, 'src/templates/artifacts/TagLib.groovy').exists()
		assertTrue new File(appDir, 'src/templates/artifacts/Tests.groovy').exists()
		assertTrue new File(appDir, 'src/templates/artifacts/WebTest.groovy').exists()
		assertTrue new File(appDir, 'src/templates/scaffolding/Controller.groovy').exists()
		assertTrue new File(appDir, 'src/templates/scaffolding/create.gsp').exists()
		assertTrue new File(appDir, 'src/templates/scaffolding/edit.gsp').exists()
		assertTrue new File(appDir, 'src/templates/scaffolding/list.gsp').exists()
		assertTrue new File(appDir, 'src/templates/scaffolding/renderEditor.template').exists()
		assertTrue new File(appDir, 'src/templates/scaffolding/show.gsp').exists()
		assertTrue new File(appDir, 'src/templates/war/web.xml').exists()
	}

	void testInstallTemplatesOverwriteTrue() {

		workDir = appDir

		File file = new File(appDir, 'src/templates/artifacts/Controller.groovy')
		assertTrue file.delete()
		assertFalse file.exists()

		file = new File(appDir, 'src/templates/war/web.xml')
		assertFalse file.text.contains('a new comment')
		file.append('<!--a new comment-->')
		assertTrue file.text.contains('a new comment')

		execute(['install-templates'])
		enterInput 'y'
		assertEquals 0, waitForProcess()

		assertTrue 'Controller.groovy should have been restored', new File(appDir, 'src/templates/artifacts/Controller.groovy').exists()
		assertFalse 'web.xml changes should have been reverted', new File(appDir, 'src/templates/war/web.xml').text.contains('a new comment')
	}

	void testInstallTemplatesOverwriteFalse() {

		workDir = appDir

		File file = new File(appDir, 'src/templates/artifacts/Controller.groovy')
		assertTrue file.delete()
		assertFalse file.exists()

		file = new File(appDir, 'src/templates/war/web.xml')
		assertFalse file.text.contains('a new comment')
		file.append('<!--a new comment-->')
		assertTrue file.text.contains('a new comment')

		execute(['install-templates'])
		enterInput 'n'
		assertEquals 0, waitForProcess()

		assertTrue 'Controller.groovy should have been restored', new File(appDir, 'src/templates/artifacts/Controller.groovy').exists()
		assertTrue 'web.xml changes should not have been reverted', new File(appDir, 'src/templates/war/web.xml').text.contains('a new comment')
	}
}


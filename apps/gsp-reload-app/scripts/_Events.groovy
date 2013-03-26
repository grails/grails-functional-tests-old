eventCreateWarStart = { String path, File stagingDir ->
	ant.mkdir(dir: 'target/reload')
	ant.copy(todir: 'target/reload') {
		fileset(dir: 'grails-app/views')
	}
}

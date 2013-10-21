eventCreateWarStart = { String path, File stagingDir ->
    ant.delete(dir: 'target/reload')
	ant.mkdir(dir: 'target/reload')
	ant.copy(todir: 'target/reload', preservelastmodified: true, overwrite: true) {
		fileset(dir: 'grails-app/views')
	}
}

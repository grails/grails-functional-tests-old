class UrlMappingsFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testDefaultMappingWithSpaces() {
        // test for GRAILS-4083
        get('/test/index+')
        assertStatus 200
        assertContentContains 'working'

        get('/test/index%20')
        assertStatus 200
        assertContentContains 'working'

        get('/test/index%0A')
        assertStatus 200
        assertContentContains 'working'

        get('/test/in%20dex')
        assertStatus 404

        get('/test/in+dex')
        assertStatus 404

    }

	void testAbsoluteLinks() {
		get('/test/testAbsolutePaths')
		assertStatus 200
        assertContentContains 'image = http://www.changeme.com/images/foo.jpg'
        assertContentContains 'link = http://www.changeme.com/test/index'        
	}
	
	void testFileExtensions() {
		get('/path/foo.bar')
		assertStatus 200
        assertContentContains 'foo.bar'
		
	}
	
	void testDynamicVariables() {
		get('/dynamic/variable?id=test')
		assertStatus 200		
        assertContentContains 'variable = test'		
	}
	
	void testDeclaredParams() {
		get('/declared/params')
		assertStatus 200		
        assertContentContains 'params = foo'		
	}	
	
	void testDecodeParameters() {
		get('/decode/Hello+World')
		assertStatus 200		
        assertContentContains 'decoded = Hello World'		

		get('/decode/Hello World')
		assertStatus 200		
        assertContentContains 'decoded = Hello World'		


		get('/decode/Hello%20World')
		assertStatus 200		
        assertContentContains 'decoded = Hello World'		
		
	}
}

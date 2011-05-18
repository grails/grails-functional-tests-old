package urlmappings

class UrlMappingsFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testDefaultMappingWithSpaces() {
        // test for GRAILS-4083
        get('/urlMappingsTest/index+')
        assertStatus 200
        assertContentContains 'working'

        get('/urlMappingsTest/index%20')
        assertStatus 200
        assertContentContains 'working'

        get('/urlMappingsTest/index%0A')
        assertStatus 200
        assertContentContains 'working'

        get('/urlMappingsTest/in%20dex')
        assertStatus 404

        get('/urlMappingsTest/in+dex')
        assertStatus 404

    }

	void testAbsoluteLinks() {
		get('/urlMappingsTest/testAbsolutePaths')
		assertStatus 200
        assertContentContains "image = ${baseURL}images/foo.jpg"
        assertContentContains "link = ${baseURL}test/index"        
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

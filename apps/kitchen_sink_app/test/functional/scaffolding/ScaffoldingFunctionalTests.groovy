package scaffolding

class ScaffoldingFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    // GRAILS-7928
    void testBodyOnce() {
        get '/book'
        assertStatus 200
        assertEquals "text/html;charset=UTF-8", response.getResponseHeaderValue('Content-Type')
        	assertEquals 1, countMatches(response.contentAsString, /<body/)
        	assertEquals 1, countMatches(response.contentAsString, /<h1>Book List<\/h1>/)
    }

    void testDefaultActionProperty() {
		get '/scaffoldingTest'
		assertStatus 200
		assertContentContains 'rendered by the actionTwo method action'
    }
    
    void testActionsDefinedInDynamicallyScaffoldedController() {
        get '/scaffoldingTest/actionOne'
        assertStatus 200
        assertContentContains 'rendered by the actionOne closure action'
        get '/scaffoldingTest/actionTwo'
        assertStatus 200
        assertContentContains 'rendered by the actionTwo method action'
    }
    
    void testScaffoldedActionsInControllerWhichDefinesSomeAdditionalActions() {
        get '/scaffoldingTest/create'
        assertStatus 200
        assertContentContains 'Create Book'
    }

    def countMatches(str, regex) {
        def matcher = (str =~ regex)
        def count=0
        while(matcher.find()) count++    	
        	count
    }
}

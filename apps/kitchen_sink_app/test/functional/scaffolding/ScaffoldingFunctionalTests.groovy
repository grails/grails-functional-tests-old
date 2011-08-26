package scaffolding

class ScaffoldingFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    // GRAILS-7928
    void testBodyOnce() {
        get '/book/list'
        assertStatus 200
        assertEquals "text/html;charset=UTF-8", response.getResponseHeaderValue('Content-Type')
        	assertEquals 1, countMatches(response.contentAsString, /<body/)
        	assertEquals 1, countMatches(response.contentAsString, /<h1>Book List<\/h1>/)
    }

    def countMatches(str, regex) {
        def matcher = (str =~ regex)
        def count=0
        while(matcher.find()) count++    	
        	count
    }
}

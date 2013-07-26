package redirects

class RedirectFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testRedirectWithParams() {
        get('/redirect/form')
        assertStatus 200
		form('searchForm') {
		      q = "#grails"
		      click "Search"
		}
		
		assertContentContains "query = #grails"
    }

	void testRedirectWithDuplicateParams() {
		get('/redirect/testRedirectWithDuplicateParams')
        assertStatus 200		
		assertContentContains "query = [one,two]"		
	}
	
	void testRedirectWithDuplicateParamsArray() {
		get('/redirect/testRedirectWithDuplicateParamsArray')
        assertStatus 200		
		assertContentContains "query = [one,two]"		
    }

    void testRedirectUrlMapping() {
        get '/numberOne'
        assertStatus 200
        assertContentContains 'Uno'

        get '/anotherNumberOne'
        assertStatus 200
        assertContentContains 'Uno'

        get '/numberTwo'
        assertStatus 200
        assertContentContains 'Dos'

        get '/anotherNumberTwo'
        assertStatus 200
        assertContentContains 'Dos'

        get '/redirectToOutput?q=Tool'
        assertStatus 200
        assertContentContains 'query = Tool'
	}
}

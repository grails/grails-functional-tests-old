class WebFlowFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testFlowMethodDispatch() {
        get('/testFlow/my')
        assertStatus 200
        assertContentContains '<title>Test Flow</title>'

		form("testForm") {
			click "_eventId_go"
		}
		
        assertStatus 200
        assertContentContains 'Flow Ended'
		
    }

	void testFlowDependencyInjection() {
        get('/testFlow/second')
        assertStatus 200
        assertContentContains '<title>Test Flow</title>'

		form("testForm") {
			click "_eventId_go"
		}
		
        assertStatus 200
        assertContentContains 'Flow Ended'
		
	}
	
	void testRedirectWithoutSpecifyingController() {
	    get '/testFlow/shoppingCart'
	    
	    assertStatus 200
	    
	    form('test') {
	        click 'Complete Order'
	    }
	    
	    assertStatus 200
	    
	    assertContentContains 'this is the list action'
	}
}

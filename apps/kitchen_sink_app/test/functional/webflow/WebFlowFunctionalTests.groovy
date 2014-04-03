package webflow

class WebFlowFunctionalTests extends functionaltestplugin.FunctionalTestCase {
	static boolean hibernate4PluginTestRun = System.getProperty('hibernatePluginVersion')?.startsWith(':hibernate4:')
	static boolean ignoreTests = hibernate4PluginTestRun

    void testFlowMethodDispatch() {
    	if (ignoreTests) return
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
		if (ignoreTests) return
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
		if (ignoreTests) return
	    get '/testFlow/shoppingCart'
	    
	    assertStatus 200
	    
	    form('test') {
	        click '_eventId_finish'
	    }
	    
	    assertStatus 200
	    
	    assertContentContains 'this is the list action'
	}
}

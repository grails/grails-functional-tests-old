package defaultaction

class DefaultActionFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    // see GRAILS-7895
    void testDefaultAction() {
        get '/defaultActionDemo'
        assertStatus 200
        assertContentContains 'the list action method rendered this'
        
        get '/defaultActionDemo/index'
        assertStatus 200
        assertContentContains 'the list action method rendered this'
        
        get '/defaultActionDemo/list'
        assertStatus 200
        assertContentContains 'the list action method rendered this'
        
        get '/defaultActionDemo/upload'
        assertStatus 200
        assertContentContains 'the upload action closure rendered this'
	}
}

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
    
    void testDefaultActionOnScaffoldedControllerWithOneMethodAction() {
        get '/scaffoldedWithOneExplicitMethodAction'
        assertStatus 200
        assertContentContains 'Child List'
        
        get '/scaffoldedWithOneExplicitMethodAction/test'
        assertStatus 200
        assertContentContains 'Rendered by the ScaffoldedWithOneExplicitMethodActionController.test method action'
        
    }
    
    void testDefaultActionOnScaffoldedControllerWithMultipleMethodActions() {
        get '/scaffoldedWithMultipleExplicitMethodActions'
        assertStatus 200
        assertContentContains 'Child List'
        
        get '/scaffoldedWithMultipleExplicitMethodActions/one'
        assertStatus 200
        assertContentContains 'Rendered by the ScaffoldedWithMultipleExplicitMethodActionsController.one method action'
        
        get '/scaffoldedWithMultipleExplicitMethodActions/two'
        assertStatus 200
        assertContentContains 'Rendered by the ScaffoldedWithMultipleExplicitMethodActionsController.two method action'
    }

    void testDefaultActionOnScaffoldedControllerWithOneClosureAction() {
        get '/scaffoldedWithOneExplicitClosureAction'
        assertStatus 200
        assertContentContains 'Child List'
        
        get '/scaffoldedWithOneExplicitClosureAction/test'
        assertStatus 200
        assertContentContains 'Rendered by the ScaffoldedWithOneExplicitClosureActionController.test closure action'
    }
    
    void testDefaultActionOnScaffoldedControllerWithMultipleClosureActions() {
        get '/scaffoldedWithMultipleExplicitClosureActions'
        assertStatus 200
        assertContentContains 'Child List'
        
        get '/scaffoldedWithMultipleExplicitClosureActions/one'
        assertStatus 200
        assertContentContains 'Rendered by the ScaffoldedWithMultipleExplicitClosureActionsController.one closure action'
        
        get '/scaffoldedWithMultipleExplicitClosureActions/two'
        assertStatus 200
        assertContentContains 'Rendered by the ScaffoldedWithMultipleExplicitClosureActionsController.two closure action'
    }
}

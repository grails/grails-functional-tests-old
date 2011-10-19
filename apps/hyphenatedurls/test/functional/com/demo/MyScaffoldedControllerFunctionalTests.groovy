package com.demo

class MyScaffoldedControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    void testScaffolding() {
        get '/my-scaffolded'
        assertStatus 200
        assertContentContains 'Person List'
        
        get '/my-scaffolded/list'
        assertStatus 200
        assertContentContains 'Person List'
        
        get '/my-scaffolded/create'
        assertStatus 200
        assertContentContains 'Create Person'
    }
}

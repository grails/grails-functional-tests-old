class ViewResolutionFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testRelativeView() {
        get('/test/testRelativeView')
        assertStatus 200
        assertContentContains 'simple = bar'
    }

    void testAbsoluteView() {
        get('/test/testAbsoluteView')
        assertStatus 200
        assertContentContains 'absolute = bar'
    }


    void testDefaultView() {
        get('/test/testDefaultView')
        assertStatus 200
        assertContentContains 'default = bar'
    }

	void testPluginRelativeView() {
        get('/pluginTest/testRelativeView')
        assertStatus 200
        assertContentContains 'simple plugin = bar'		
	}


	void testPluginAbsoluteView() {
        get('/pluginTest/testAbsoluteView')
        assertStatus 200
        assertContentContains 'absolute plugin = bar'		
	}
	
	void testPluginDefaultView() {
        get('/pluginTest/testDefaultView')
        assertStatus 200
        assertContentContains 'plugin default = bar'		
	}
/*
    void testNestedRelativeView() {
        // TODO: nested relative views not supported yet. See GRAILS-4204
        if(notYetImplemented()) return
        get('/pluginTest/testNestedRelativeView')
        assertStatus 200
        assertContentContains 'simple = bar'
    }
    */
	void testNestedRelativeTemplate() {
        get('/pluginTest/testNestedRelativeTemplate')
        assertStatus 200
        assertContentContains 'Rendered template'
		assertContentContains 'Plugin index template'
	}

    void testUrlMappingToAViewWhenMultipleViewResolversArePresent() {
        // GRAILS-6221
        get '/'
        assertStatus 200
        assertContentContains 'Congratulations, you have successfully started your first Grails application!'
    }
}

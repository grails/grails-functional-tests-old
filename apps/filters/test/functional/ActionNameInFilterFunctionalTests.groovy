class ActionNameInFilterFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testActionNameInFilter() {
        get('/demo')
        assertStatus 200
		assertContentContains 'action name in filter: doit'		
	}
}

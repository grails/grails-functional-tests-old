package filters

class ActionNameInFilterFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testActionNameInFilter() {
        get('/filterDemo')
        assertStatus 200
		assertContentContains 'action name in filter: doit'		
	}
}

class FilterLoggerNameFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testLoggerNames() {
        get('/demo/showLoggerNames')
        assertStatus 200
		assertContentContains 'Alpha Logger Name: grails.app.filters.AlphaFilters'		
		assertContentContains 'Beta Logger Name: grails.app.filters.BetaFilters'		
	}
}

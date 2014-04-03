package filters

class ExceptionsInFiltersTests extends functionaltestplugin.FunctionalTestCase {
    void testExceptionInFilter() {
        get('/testFilters/index')
        assertStatus 500
        assertContentContains 'handleException:Exception in filter'       
    }
}

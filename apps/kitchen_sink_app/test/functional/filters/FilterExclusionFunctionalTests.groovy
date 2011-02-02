package filters

class FilterExclusionFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testFilterExclusions() {
        get('/filterDemo/aaa')
        assertStatus 200
        assertContentContains 'Filter 1 Ran? yes'       
        assertContentContains 'Filter 2 Ran? yes'       
        assertContentContains 'Filter 3 Ran? yes'       
        assertContentContains 'Filter 4 Ran? yes'       

        get('/filterDemo/abc')
        assertStatus 200
        assertContentDoesNotContain 'Filter 1 Ran? yes'       
        assertContentContains 'Filter 2 Ran? yes'       
        assertContentDoesNotContain 'Filter 3 Ran? yes'       
        assertContentDoesNotContain 'Filter 4 Ran? yes'       

        get('/anotherFilterDemo/aaa')
        assertStatus 200
        assertContentDoesNotContain 'Filter 1 Ran? yes'       
        assertContentDoesNotContain 'Filter 2 Ran? yes'       
        assertContentDoesNotContain 'Filter 3 Ran? yes'       
        assertContentContains 'Filter 4 Ran? yes'       

        get('/anotherFilterDemo/abc')
        assertStatus 200
        assertContentDoesNotContain 'Filter 1 Ran? yes'       
        assertContentDoesNotContain 'Filter 2 Ran? yes'       
        assertContentDoesNotContain 'Filter 3 Ran? yes'       
        assertContentContains 'Filter 4 Ran? yes'       
    }
}

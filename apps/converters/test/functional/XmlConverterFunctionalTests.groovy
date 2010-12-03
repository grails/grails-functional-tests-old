class XmlConverterFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testCached() {
        // per GRAILS-6726, the second time the cached data is converted, javassist proxies would
        // be retrieved and the rendered xml would include the javassist class names...

        get('/search/cached')
        assertStatus 200
        assertContentDoesNotContain 'javassist'

        get('/search/cached')
        assertStatus 200
        assertContentDoesNotContain 'javassist'
    }
}

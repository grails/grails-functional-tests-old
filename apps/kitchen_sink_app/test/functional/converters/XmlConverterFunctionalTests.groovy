package converters

class XmlConverterFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testCached() {
        // per GRAILS-6726, the second time the cached data is converted, javassist proxies would
        // be retrieved and the rendered xml would include the javassist class names...

        get('/convertersSearch/cached')
        assertStatus 200
        assertContentDoesNotContain 'javassist'

        get('/convertersSearch/cached')
        assertStatus 200
        assertContentDoesNotContain 'javassist'
    }
    
    void testRenderErrorsAsXML() {
        // GRAILS-6791
        get('/convertersErr')
        assertStatus 200
        assertContentContains 'Property [title] of class [class converters.ConvertersBook] cannot be null'
    }
}

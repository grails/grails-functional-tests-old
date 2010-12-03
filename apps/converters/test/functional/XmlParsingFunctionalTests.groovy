class XmlParsingFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testCached() {
        // http://jira.codehaus.org/browse/GRAILS-6604
        get('/search/cached')
        assertStatus 200
        assertContentDoesNotContain 'javassist'

        get('/search/cached')
        assertStatus 200
        assertContentDoesNotContain 'javassist'
    }
}

class JstlTaglibFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testJstlTags() {
        get('/jsptaglib')
        assertStatus 200
        assertContentContains '1234567891012.30'
    }
}

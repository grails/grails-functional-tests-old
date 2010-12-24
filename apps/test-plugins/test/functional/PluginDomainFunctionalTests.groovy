class PluginDomainFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    /**
     * Tests the controller that depends on a domain class from a plugin
     * works OK.
     */
    void testPostIndex() {
        get "/customPost/index" 
        assertStatus 200
        assertContentStrict "Number of posts: 3" 
    }
}

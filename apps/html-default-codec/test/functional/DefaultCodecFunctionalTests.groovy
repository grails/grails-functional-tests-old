class DefaultCodecFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    void testResourceTag() {
        // GRAILS-8405
        get '/demo'
        assertStatus 200
        assertContentContains 'Image: <img src="/html-default-codec/images/grails_logo.png" alt="Grails"/>'
    }
}
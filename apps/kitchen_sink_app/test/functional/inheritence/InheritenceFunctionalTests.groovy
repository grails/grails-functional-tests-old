package inheritence

class InheritenceFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    void testOverridingClosureAction() {
        get '/subclass'
        assertStatus 200
        assertContentContains 'Rendered From SubclassController'
    }
}
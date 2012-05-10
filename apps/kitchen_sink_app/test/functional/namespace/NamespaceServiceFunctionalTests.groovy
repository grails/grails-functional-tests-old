package namespace

class NamespaceServiceFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    void testExpectedBeanNames() {
        
        // gadget service is defined in the app
        get '/containsBean/gadgetService'
        assertStatus 200
        assertContentContains "Contains bean 'gadgetService'? true"

        // widget service is defined in namespace-one plugin and should have been aliased
        get '/containsBean/widgetService'
        assertStatus 200
        assertContentContains "Contains bean 'widgetService'? true"

        // fidget service is defined in namespace-one and namespace-two plugins so should not have been aliased
        get '/containsBean/fidgetService'
        assertStatus 200
        assertContentContains "Contains bean 'fidgetService'? false"

        get '/containsBean/namespaceOneFidgetService'
        assertStatus 200
        assertContentContains "Contains bean 'namespaceOneFidgetService'? true"

        get '/containsBean/namespaceOneGadgetService'
        assertStatus 200
        assertContentContains "Contains bean 'namespaceOneGadgetService'? true"

        get '/containsBean/namespaceOneWidgetService'
        assertStatus 200
        assertContentContains "Contains bean 'namespaceOneWidgetService'? true"

        get '/containsBean/namespaceTwoGadgetService'
        assertStatus 200
        assertContentContains "Contains bean 'namespaceTwoGadgetService'? true"

        get '/containsBean/namespaceTwoFidgetService'
        assertStatus 200
        assertContentContains "Contains bean 'namespaceTwoFidgetService'? true"
    }
}

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

        get '/containsBean/helloService'
        assertStatus 200
        assertContentContains "Contains bean 'helloService'? true"

        get '/containsBean/specialHelloService'
        assertStatus 200
        assertContentContains "Contains bean 'specialHelloService'? true"

        get '/containsBean/namespaceTwoSpecialHelloService'
        assertStatus 200
        assertContentContains "Contains bean 'namespaceTwoSpecialHelloService'? true"

        get '/containsBean/namespaceOneHelloService'
        assertStatus 200
        assertContentContains "Contains bean 'namespaceOneHelloService'? true"
    }

    void testExpectedBeanTypes() {
        get '/showBeanType/someBeanService'
        assertStatus 200
        assertContentContains 'The someBeanService bean is an instance of namespace.SomeBean'

        get '/showBeanType/gadgetService'
        assertStatus 200
        assertContentContains 'The gadgetService bean is an instance of namespace.GadgetService'

        get '/showBeanType/widgetService'
        assertStatus 200
        assertContentContains 'The widgetService bean is an instance of com.namespaceone.WidgetService'

        get '/showBeanType/helloService'
        assertStatus 200
        assertContentContains 'The helloService bean is an instance of com.namespacetwo.SpecialHelloService'

        get '/showBeanType/namespaceOneHelloService'
        assertStatus 200
        assertContentContains 'The namespaceOneHelloService bean is an instance of com.namespaceone.HelloService'

        get '/showBeanType/namespaceTwoSpecialHelloService'
        assertStatus 200
        assertContentContains 'The namespaceTwoSpecialHelloService bean is an instance of com.namespacetwo.SpecialHelloService'
    }
}

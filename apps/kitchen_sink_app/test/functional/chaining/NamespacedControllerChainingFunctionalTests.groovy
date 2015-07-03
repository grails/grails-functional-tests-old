package chaining

class NamespacedControllerChainingFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testChainingToNamespacedController() {
        get '/chainHome/demoChain?ns=alpha'
        assertStatus 200
        assertContentContains 'render from the DemoController in the alpha namespace'

        get '/chainHome/demoChain?ns=beta'
        assertStatus 200
        assertContentContains 'render from the DemoController in the beta namespace'
    }


    void testRedirectUrlWhenChainingToNamespacedController() {
        redirectEnabled = false
        get '/chainHome/demoChain?ns=alpha'
        assertStatus 302
        assertRedirectUrlContains '/alphaDemo'

        get '/chainHome/demoChain?ns=beta'
        assertStatus 302
        assertRedirectUrlContains '/betaDemo'
    }

}

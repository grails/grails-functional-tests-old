package namespace

class NamespacedControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testReverseUrlMappingsForNamespacedControllers() {
        get '/namespaceInspector/generateLinksToNamespacedControllers'
        assertStatus 200

        assertContentContains '<a href="/kitchen_sink_app/invokePrimaryController">Click to visit the controller in the primary namespace</a>'
        assertContentContains '<a href="/kitchen_sink_app/invokeSecondaryController">Click to visit the controller in the secondary namespace</a>'
        assertContentContains '<a href="/kitchen_sink_app/nonNamespacedController/index">Click to visit the controller that does not specify a namespace</a>'
    }

    void testControllerNamespaceWithNamedArgumentsInMapping() {
        get '/anotherRouteToPrimaryController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.alpha.NamespacedController controller'

        get '/anotherRouteToSecondaryController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.beta.NamespacedController controller'

        get '/anotherRouteToNonNamespacedController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.gamma.NamespacedController controller'
    }

    void testControllerNamespaceAsVariableInUrlMapping() {
        get '/primary/namespaced'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.alpha.NamespacedController controller'

        get '/primary/namespaced/demo'
        assertStatus 200
        assertContentContains 'Rendered by the demo action in the namespace.alpha.NamespacedController controller'

        get '/secondary/namespaced'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.beta.NamespacedController controller'

        get '/secondary/namespaced/demo'
        assertStatus 200
        assertContentContains 'Rendered by the demo action in the namespace.beta.NamespacedController controller'
    }

    void testControllerNamespaceWithHardcodedNamespaceInUrlMapping() {
        get '/invokePrimaryController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.alpha.NamespacedController controller'

        get '/invokeSecondaryController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.beta.NamespacedController controller'
    }

    void testNonNamespacedControllerWithSameNameAsNamespacedControllers() {
        get '/nonNamespacedController'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.gamma.NamespacedController controller'

        get '/nonNamespacedController/index'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.gamma.NamespacedController controller'

        get '/namespaced'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.gamma.NamespacedController controller'

        get '/nonNamespacedController/demo'
        assertStatus 200
        assertContentContains 'Rendered by the demo action in the namespace.gamma.NamespacedController controller'

        get '/namespaced/demo'
        assertStatus 200
        assertContentContains 'Rendered by the demo action in the namespace.gamma.NamespacedController controller'
    }

    void testRedirectToNamespacedControllers() {
        get '/namespaceInspector/redirectToPrimary'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.alpha.NamespacedController controller'

        get '/namespaceInspector/redirectToSecondary'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.beta.NamespacedController controller'

        get '/namespaceInspector/redirectToNonNamespaced'
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.gamma.NamespacedController controller'
    }
}


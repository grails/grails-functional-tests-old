package includes

class IncludesFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testIncludeWithParams() {
        get('/simple/testInclude')
        assertStatus 200
        assertContentContains '<title>Simple GSP page</title>'
        assertContentContains 'params = bar'
    }

    void testIncludeWithActionAndNoController() {
        get '/simple/testIncludeWithActionAndNoController'
        assertStatus 200
        assertContentContains '<title>Simple GSP page</title>'
        assertContentContains 'params = bar'
    }

    void testIncludeWithNamespaces() {
        get('/simple/testIncludeWithNamespaces')
        assertStatus 200
        assertContentContains 'Rendered by the index action in the namespace.alpha.NamespacedController controller'
        assertContentContains 'Rendered by the index action in the namespace.beta.NamespacedController controller'
    }
}

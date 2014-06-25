package rest

class PublisherControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testBindingJsonToMapProperty() {
        // GRAILS-11532
        post '/publisher/save', {
            headers.'Content-Type' = 'application/json'
            headers.'Accept' = "application/json"
            body {
                '{"name":"Some Publisher", "books":{"one":"Book One", "two": "Book Two"}}'
            }
        }
        assertStatus 201
    }
}
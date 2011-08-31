package validateables

class ValidateableFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    
    void testValidateables() {
        get '/validateableTest/createValidateables?firstName=Joe&lastName=Walsh&age=67'
        assertStatus 200
        assertContentContains 'First Error Count: 0, Second Error Count: 0'

        get '/validateableTest/createValidateables?firstName=Joe&lastName=Walsh'
        assertStatus 200
        assertContentContains 'First Error Count: 0, Second Error Count: 1'

        get '/validateableTest/createValidateables?firstName=Joe'
        assertStatus 200
        assertContentContains 'First Error Count: 1, Second Error Count: 2'

        get '/validateableTest/createValidateables'
        assertStatus 200
        assertContentContains 'First Error Count: 2, Second Error Count: 3'
    }
    
    void testValidateablesOnlyValidateFirstName() {
        get '/validateableTest/createValidateablesOnlyValidateFirstName?firstName=Joe&lastName=Walsh&age=67'
        assertStatus 200
        assertContentContains 'First Error Count: 0, Second Error Count: 0'

        get '/validateableTest/createValidateablesOnlyValidateFirstName?firstName=Joe&lastName=Walsh'
        assertStatus 200
        assertContentContains 'First Error Count: 0, Second Error Count: 0'

        get '/validateableTest/createValidateablesOnlyValidateFirstName?firstName=Joe'
        assertStatus 200
        assertContentContains 'First Error Count: 0, Second Error Count: 0'

        get '/validateableTest/createValidateablesOnlyValidateFirstName'
        assertStatus 200
        assertContentContains 'First Error Count: 1, Second Error Count: 1'
    }
    
    void testValidateableWithAMixinApplied() {
        get '/validateableTest/validateableWithAMixinApplied?title=captain'
        assertStatus 200
        assertContentContains 'Error Count: 1'
        
        get '/validateableTest/validateableWithAMixinApplied?title=Captain'
        assertStatus 200
        assertContentContains 'Error Count: 0'
    }
}

package typechecked

class TypeCheckedControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testDynamicGormMethods() {
        get '/numberOfPeopleWithName/Lynott'
        assertStatus 200
        assertContentContains 'The number of people with name Lynott is 0.'

        get '/findOrSavePersonWithName/Lynott'
        assertStatus 200
        assertContentContains "The person's name is Lynott."

        get '/numberOfPeopleWithName/Lynott'
        assertStatus 200
        assertContentContains 'The number of people with name Lynott is 1.'
    }
}

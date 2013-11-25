package databinding

class StructuredDataBindingFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testStructuredEditorExplicitlyRegisteredWithDataBinderInBootstrap() {
        get '/structuredDatabinding/createFamily?father=struct&father_firstName=Jeff&father_lastName=Brown&mother=struct&mother_firstName=Betsy&mother_lastName=Brown'
        assertStatus 200
        assertContentContains 'Mother: Betsy Brown'
        assertContentContains 'Father: Jeff Brown'
    }
}


package databinding

class StructuredDataBindingFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testStructuredEditorExplicitlyRegisteredWithDataBinderInBootstrap() {
        get '/structuredDatabinding/createFamily?father=struct&father_firstName=Jeff&father_lastName=Brown&mother=struct&mother_firstName=Betsy&mother_lastName=Brown'
        assertStatus 200
        assertContentContains 'Mother: Betsy Brown'
        assertContentContains 'Father: Jeff Brown'
    }

    void testStructuredEditorRegisteredAsSpringBean() {
        get '/structuredDatabinding/createCompany?president=struct&president_firstName=Tim&president_lastName=Cook&vicePresident=struct&vicePresident_firstName=Eddy&vicePresident_lastName=Cue'
        assertStatus 200
        assertContentContains 'The Vice President: Eddy Cue'
        assertContentContains 'The President: Tim Cook'
    }

    void testShapeStructuredEditorRegisteredAsSpringBean() {
        get '/structuredDatabinding/createGadget?expandedShape=struct&expandedShape_width=80&expandedShape_height=30&compressedShape=struct&compressedShape_width=10&compressedShape_height=3'
        assertStatus 200
        assertContentContains 'Expanded Area: 2400'
        assertContentContains 'Compressed Area: 30'
    }
}


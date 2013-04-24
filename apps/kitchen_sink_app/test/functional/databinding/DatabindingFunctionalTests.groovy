package databinding

class DatabindingFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testTryingToOverrideCommandObjectPropertiesInInjectedBean() {
        get '/databinding/coTest?title=My Title&widget.name=Bad+Name&state=Missouri&zip=12345'
        assertStatus 200
        assertContentContains 'Title: My Title, Widget Name: Good Name, State: null, Zip: 12345'		
	}
    
    void testTryingToOverrideDomainObjectPropertiesInInjectedBean() {
        get '/databinding/testDomainWithInjectedBeanProperty?name=My Name&widget.name=Bad+Name&state=Missouri&zip=12345'
        assertStatus 200
        assertContentContains 'Name: My Name, Widget Name: Good Name, State: null, Zip: 12345'       
    }
    
    void testCtorBindingToOverrideDomainObjectPropertiesInInjectedBean() {
        get '/databinding/testCtorDataBindingOnDomainWithInjectedBeanProperty?name=My Name&widget.name=Bad+Name&state=Missouri&zip=12345'
        assertStatus 200
        assertContentContains 'Name: My Name, Widget Name: Good Name, State: null, Zip: 12345'       
    }

    void testBindingStringToSetOfInteger() {
        /*
        this test simulates the steps described in http://jira.grails.org/browse/GRAILS-8991 to duplicate the problem
         */
        get '/numberParent/create'
        assertStatus 200
        assertTitle 'Create Parent'

        form {
            selects['child.someOtherIds'].select '3'
            selects['someIds'].select '3'
            click 'create'
        }

        assertStatus 200
        assertTitle 'Show Parent'

        click 'Edit'
        form {
            selects['child.someOtherIds'].deselect '3'
            selects['child.someOtherIds'].select '4'
            selects['someIds'].deselect '3'
            selects['someIds'].select '5'
            click '_action_update'
        }
        assertStatus 200
        assertTitle 'Show Parent'
        assertContentContains 'Parent 1 updated'
        assertContentContains 'NumberChild Ids: [4]'
    }
}

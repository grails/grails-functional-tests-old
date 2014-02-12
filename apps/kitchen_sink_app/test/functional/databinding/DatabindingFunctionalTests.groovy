package databinding

class DatabindingFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testBindingToInheritedPersistentProperty() {
        get '/databinding/createOffice?address.city=Norfolk&address.state=Virginia'
        assertStatus 200
        assertContentContains 'The city is Norfolk and the state is Virginia.'
    }

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

    void testBindingWithCustomValueConverter() {
        get '/databinding/testCustomBindingConverter?homeAddress=OFallon:Missouri'
        assertContentContains 'City: OFallon, State: Missouri'
    }

    void testBindingWithCustomAddressBindingFormat() {
        get '/databinding/testCustomAddressBindingFormat?homeAddress=OFallon:Missouri&workAddress=San Mateo:California&vacationAddress=Milan:Italy'
        assertContentContainsStrict 'Home City: OFallon, Home State: Missouri'
        assertContentContainsStrict 'Work City: SAN MATEO, Work State: CALIFORNIA'
        assertContentContainsStrict 'Vacation City: milan, Vacation State: italy'
    }

    void testCustomDateBindingFormat() {
        get '/databinding/testCustomDateBindingFormat?birthDate=11151969'
        assertContentContains 'Month: 11, Date: 15, Year: 1969'
    }

    void testCustomStringBindiningFormat() {
        get '/databinding/testCustomStringBindingFormat?name=Jeff&title=Engineer'
        assertContentContainsStrict 'Jeff is a ENGINEER'
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

    void testBindingCommaSeparatedListToList() {
        get '/databinding/bindCommaSeparatedList?members=Harris,Dickinson,McBrain,Smith,Murray'
        assertStatus 200

        assertContentContains '<li>Harris</li>'
        assertContentContains '<li>Dickinson</li>'
        assertContentContains '<li>McBrain</li>'
        assertContentContains '<li>Smith</li>'
        assertContentContains '<li>Murray</li>'
    }

    void testAutoGrowCollectionLimitSetInConfig() {
        def paramString = new StringBuffer('?name=Pivotal')
        10.times {
            paramString << "&addresses[${it}].city=City${it}&addresses[${it}].state=State${it}"
        }
        get "/business/createBusiness${paramString}"
        assertStatus 200

        assertContentContains '<h2>Business name: Pivotal</h2>'
        assertContentContains '<h2>Number Of Addresses: 8</h2>'
        assertContentContains '<li>City0, State0</li>'
        assertContentContains '<li>City1, State1</li>'
        assertContentContains '<li>City2, State2</li>'
        assertContentContains '<li>City3, State3</li>'
        assertContentContains '<li>City4, State4</li>'
        assertContentContains '<li>City5, State5</li>'
        assertContentContains '<li>City6, State6</li>'
        assertContentContains '<li>City7, State7</li>'

    }
}

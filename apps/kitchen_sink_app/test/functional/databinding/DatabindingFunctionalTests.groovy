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

    void testBindingWithCustomValueConverter() {
        get '/databinding/testCustomBindingConverter?homeAddress=OFallon:Missouri'
        assertContentContains 'city: OFallon, State: Missouri'
    }
}

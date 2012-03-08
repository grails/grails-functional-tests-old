package databinding

class DatabindingController {
    
    def coTest(MyCommandObject co) {
        render "Title: ${co.title}, Widget Name: ${co.widget?.name}, State: ${co.state}, Zip: ${co.zip}"
    }
    
    def testDomainWithInjectedBeanProperty() {
        def person = new PersonWithInjectedBeanProperty()
        person.properties = params
        render "Name: ${person.name}, Widget Name: ${person.widget?.name}, State: ${person.state}, Zip: ${person.zip}"
    }
    
    def testCtorDataBindingOnDomainWithInjectedBeanProperty() {
        def person = new PersonWithInjectedBeanProperty(params)
        render "Name: ${person.name}, Widget Name: ${person.widget?.name}, State: ${person.state}, Zip: ${person.zip}"
    }
    def foo2(){}
}

class MyCommandObject {
    def widget
    String title
    String state
    String zip

    static constraints = {
        state bindable: false
    }
}

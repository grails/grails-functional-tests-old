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

    def testCustomBindingConverter() {
        def person = new PersonWithInjectedBeanProperty(params)
        render "City: ${person.homeAddress?.city}, State: ${person.homeAddress?.state}"
    }

    def testCustomDateBindingFormat() {
        def person = new PersonWithInjectedBeanProperty(params)
        def fmt = new java.text.SimpleDateFormat("'Month:' MM ', Date:' dd', Year:' yyyy")
        render fmt.format(person.birthDate)
    }
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

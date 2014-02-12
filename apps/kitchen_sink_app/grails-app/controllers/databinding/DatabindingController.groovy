package databinding

import org.grails.databinding.BindUsing

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

    def testCustomAddressBindingFormat() {
        def person = new PersonWithInjectedBeanProperty(params)

        def sb = new StringBuffer()
        sb << "Home City: ${person.homeAddress?.city}, Home State: ${person.homeAddress?.state}<br/>"
        sb << "Work City: ${person.workAddress?.city}, Work State: ${person.workAddress?.state}<br/>"
        sb << "Vacation City: ${person.vacationAddress?.city}, Vacation State: ${person.vacationAddress?.state}"

        render sb.toString()
    }

    def testCustomStringBindingFormat() {
        def person = new PersonWithInjectedBeanProperty(params)

        render "${person.name} is a ${person.title}"
    }

    def bindCommaSeparatedList(Band band) {
        [band: band]
    }

    def createOffice(Office office) {
        [office: office]
    }
}

class Band {
    @BindUsing({ object, source ->
        source['members'].split(',')
    })
    List<String> members
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

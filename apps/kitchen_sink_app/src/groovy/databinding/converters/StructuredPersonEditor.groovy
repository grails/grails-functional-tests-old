package databinding.converters

import databinding.Person

import org.grails.databinding.DataBindingSource
import org.grails.databinding.StructuredBindingEditor

class StructuredPersonEditor implements StructuredBindingEditor<Person> {

    public Person getPropertyValue(obj, String propertyName, DataBindingSource bindingSource) {
        def person = new Person()
        person.firstName = bindingSource.getPropertyValue(propertyName + '_firstName')
        person.lastName = bindingSource.getPropertyValue(propertyName + '_lastName')
        person
    }
}

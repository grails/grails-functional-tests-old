package databinding.converters

import databinding.Employee

import org.grails.databinding.DataBindingSource
import org.grails.databinding.converters.AbstractStructuredBindingEditor

class StructuredEmployeeEditor extends AbstractStructuredBindingEditor<Employee> {

    public Employee getPropertyValue(obj, String propertyName, DataBindingSource bindingSource) {
        def valueMap = getPropertyValuesMap(propertyName, bindingSource)
        def employee = new Employee()
        employee.firstName = valueMap.firstName
        employee.lastName = valueMap.lastName
        employee
    }

    Class getTargetType() {
        Employee
    }
}


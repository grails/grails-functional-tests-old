package databinding.converters

import databinding.Employee

import org.grails.databinding.converters.AbstractStructuredBindingEditor

class StructuredEmployeeEditor extends AbstractStructuredBindingEditor<Employee> {

    public Employee getPropertyValue(Map values) {
        def employee = new Employee()
        employee.firstName = values.firstName
        employee.lastName = values.lastName
        employee
    }

    Class getTargetType() {
        Employee
    }
}


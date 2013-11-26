import databinding.Widget
import databinding.bindingsource.MyCustomDataBindingSourceCreator
import transactions.JavaService

// Place your Spring DSL code here
beans = {
    javaService(JavaService) { bean ->
        bean.autowire = true
    }
    
    widget(Widget) {
        name = 'Good Name'
    }
    
    myValidationHelper(commandobjects.MyValidationHelper) {
        minimumValidValue = 42
    }

    addressConverter databinding.converters.AddressValueConverter
    formattedAddressConverter databinding.converters.FormattedAddressValueConverter
    formattedStringConverter databinding.converters.FormattedStringValueConverter

    myCustomBindingSourceCreator MyCustomDataBindingSourceCreator

    someBeanService namespace.SomeBean

    structuredEmployeeEditor databinding.converters.StructuredEmployeeEditor
}

import databinding.Widget
import databinding.bindingsource.MyCustomDataBindingSourceHelper
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

    myCustomBindingSourceHelper MyCustomDataBindingSourceHelper
}

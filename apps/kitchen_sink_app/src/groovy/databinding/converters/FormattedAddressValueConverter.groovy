package databinding.converters

import org.grails.databinding.converters.FormattedValueConverter

class FormattedAddressValueConverter implements FormattedValueConverter {
    def convert(value, String format) {
        def pieces = value.split(':')
        def city = pieces[0]
        def state = pieces[1]

        if('UPPERCASE' == format) {
            city = city.toUpperCase()
            state = state.toUpperCase()
        } else if('LOWERCASE' == format) {
            city = city.toLowerCase()
            state = state.toLowerCase()
        }
        new databinding.Address(city: city, state: state)
    }

    Class getTargetType() {
        databinding.Address
    }
}

package databinding.converters

import org.grails.databinding.converters.ValueConverter

class AddressValueConverter implements ValueConverter {

    def convert(value) {
        def pieces = value.split(':')
        new databinding.Address(city: pieces[0], state: pieces[1])
    }

    Class<?> getTargetType() {
        databinding.Address
    }
}


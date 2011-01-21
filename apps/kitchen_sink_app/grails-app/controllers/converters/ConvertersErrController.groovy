package converters

import grails.converters.XML

class ConvertersErrController
{
    def index = {
        def book = new ConvertersBook()
        assert !book.validate()
        render book.errors as XML
    }
}

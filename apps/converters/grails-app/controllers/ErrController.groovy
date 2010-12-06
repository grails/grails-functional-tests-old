import grails.converters.XML

class ErrController
{
    def index = {
        def book = new Book()
        assert !book.validate()
        render book.errors as XML
    }
}

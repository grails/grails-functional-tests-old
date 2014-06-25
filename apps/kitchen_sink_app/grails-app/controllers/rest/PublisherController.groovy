package rest

class PublisherController extends grails.rest.RestfulController {
    static responseFormats = ['json', 'xml']

    PublisherController() {
        super(Publisher)
    }
}

package databinding

class BusinessController {
    def createBusiness() {
        def business = new Business(params)
        [business: business]
    }
}

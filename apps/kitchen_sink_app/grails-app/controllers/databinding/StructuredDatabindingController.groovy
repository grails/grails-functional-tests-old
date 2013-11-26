package databinding

class StructuredDatabindingController {

    def createFamily(Family family) {
        [family: family]
    }

    def createCompany(Company company) {
        [company: company]
    }
}


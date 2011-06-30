package parambinding

class ParameterBindingController {
    
    def createPerson(String firstName, String lastName, int age) {
        render "Create Person: firstName=${firstName}, lastName=${lastName}, age=${age}"
    }
}

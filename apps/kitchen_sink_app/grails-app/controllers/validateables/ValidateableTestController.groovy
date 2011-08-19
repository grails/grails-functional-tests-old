package validateables

import validateables.FirstValidateable
import validateables.SecondValidateable

class ValidateableTestController {
    
    def createValidateables(String firstName, String lastName, Integer age) {
        def first = new FirstValidateable(firstName: firstName, lastName: lastName)
        first.validate()
        
        def second = new SecondValidateable(firstName: firstName, lastName: lastName, age: age)
        second.validate()
        
        def msg = "First Error Count: ${first.errors?.errorCount}, Second Error Count: ${second.errors?.errorCount}"
        
        render msg
    }
    
    def createValidateablesOnlyValidateFirstName(String firstName, String lastName, Integer age) {
        def first = new FirstValidateable(firstName: firstName, lastName: lastName)
        first.validate(['firstName'])
        
        def second = new SecondValidateable(firstName: firstName, lastName: lastName, age: age)
        second.validate(['firstName'])
        
        def msg = "First Error Count: ${first.errors?.errorCount}, Second Error Count: ${second.errors?.errorCount}"
        
        render msg
    }
}
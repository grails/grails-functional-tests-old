package validateables

@grails.validation.Validateable
class SecondValidateable {
    String firstName
    String lastName
    Integer age
    
    static constraints = {
        firstName size: 3..25
        lastName size: 3..25
        age range: 1..99
    }
}
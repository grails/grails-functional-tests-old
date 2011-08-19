package validateables

@org.codehaus.groovy.grails.validation.Validateable
class FirstValidateable {
    String firstName
    String lastName
    static constraints = {
        firstName size: 3..25
        lastName size: 3..25
    }
    
}
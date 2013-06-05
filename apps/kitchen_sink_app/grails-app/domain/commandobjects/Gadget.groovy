package commandobjects

class Gadget {
    String name
    Integer age
    
    static constraints = {
        name matches: /[A-Z]*/
        age nullable: true
    }
}

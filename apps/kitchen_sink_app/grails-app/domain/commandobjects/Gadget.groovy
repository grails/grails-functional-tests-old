package commandobjects

class Gadget {
    String name
    
    static constraints = {
        name matches: /[A-Z]*/
    }
}
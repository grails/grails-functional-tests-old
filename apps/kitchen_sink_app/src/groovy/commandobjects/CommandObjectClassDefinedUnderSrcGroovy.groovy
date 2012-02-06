package commandobjects

@grails.validation.Validateable
class CommandObjectClassDefinedUnderSrcGroovy {
    String name
    
    static constraints = {
        name matches: /[A-Za-z]*/
    }
}

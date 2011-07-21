package commandobjects

class CommandObjectClassDefinedUnderSrcGroovy {
    String name
    
    static constraints = {
        name matches: /[A-Za-z]*/
    }
}

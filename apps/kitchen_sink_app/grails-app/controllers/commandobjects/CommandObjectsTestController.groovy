package commandobjects

class CommandObjectsTestController {

    static allowedMethods = [updateGadget: 'POST']
    def index = { }

	def createCommand = {
		def cmd = new TestCommand()
		println cmd.errors
		render "good"
	}
	def testCommand = { TestCommand cmd ->
		render "name: ${cmd.name.value}, age:${cmd.age}"
	}
	
	def testCommandWithNestedValues = { TestCommand cmd ->
		render "name: ${cmd.name.value}, age:${cmd.age}, nested.value: ${cmd.nested.value}"
	}
	
    def multi = {
        ACommand a, BCommand b, CCommand c, DCommand d ->


        [ a: a, b: b, c: c, d: d ]
    }
    
    def closureActionWithCommandObjectDefinedUnderSrcGroovy = { CommandObjectClassDefinedUnderSrcGroovy cmd ->
        render "name: ${cmd.name}, has errors?: ${cmd.hasErrors()}"
    }   
    
    def methodActionWithCommandObjectDefinedUnderSrcGroovy(CommandObjectClassDefinedUnderSrcGroovy cmd) {
        render "name: ${cmd.name}, has errors?: ${cmd.hasErrors()}"
    }   
    
    def closureActionWithDomainClassAsCommandObject = { Gadget cmd ->
        render "name: ${cmd.name}, has errors?: ${cmd.hasErrors()}"
    }   
    
    def methodActionWithDomainClassAsCommandObject(Gadget cmd) {
        render "name: ${cmd.name}, has errors?: ${cmd.hasErrors()}"
    }   
    
    def methodActionWithSharedConstraintCommandObject(JCommand cmd) {
        render "name: ${cmd.name}, has errors?: ${cmd.hasErrors()}"
    }   
    
    def closureActionWithSharedConstraintCommandObject = { JCommand cmd ->
        render "name: ${cmd.name}, has errors?: ${cmd.hasErrors()}"
    }
    
    def testConstraintsProperty() {
        render "Matches: ${CommandObjectClassDefinedUnderSrcGroovy.constraints.name.matches}"
    }
    def commandUsingBeanForValidation(CommandUsingBeanForValidation co) {
        render "Valid?: ${!co.hasErrors()}"
    }

    def updateGadget(Gadget gadget) {
        if(gadget == null) {
            render "gadget is null, error count is ${errors?.errorCount}"
        } else {
            render "Gadget was loaded.  id: ${gadget.id}, name: ${gadget.name}, age: ${gadget.age}"
        }
    }

    def createGadget(Gadget gadget) {
        if(gadget.save()) {
            render "Create succeeded. id: ${gadget.id}, name: ${gadget.name}, age: ${gadget.age}"
        } else {
            render 'something went wrong'
        }
    }
}

class CommandUsingBeanForValidation {
    Integer value
    def myValidationHelper

    static constraints = {
        value validator: { val, obj ->
            val >= obj.myValidationHelper.minimumValidValue
        }
    }
}

class TestCommand {
	Integer age
	String name
	Nested nested = new Nested()
}

class Nested {
    String value
}

class ACommand {
    String name

    static constraints = {
        name nullable: false
    }
}

class BCommand {
    String query

    static constraints = {
        query nullable: false
    }
}

class CCommand {
    String name

    static constraints = {
        name nullable: false
    }
}

class DCommand {
    String query

    static constraints = {
        query nullable: false
    }
}

class JCommand {
    String name
    static constraints = {
        name shared: 'beginsWithUpperCaseJ'
    }
}

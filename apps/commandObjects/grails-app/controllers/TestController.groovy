class TestController {

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

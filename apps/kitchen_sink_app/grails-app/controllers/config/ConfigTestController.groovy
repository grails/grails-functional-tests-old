package config

class ConfigTestController {

    def read = {
		def one = grailsApplication.config.test.value1
		def two = grailsApplication.config.test.value2
		def three = grailsApplication.flatConfig['test.value3']

		render "one = $one, two = $two, three = $three"
	}
}

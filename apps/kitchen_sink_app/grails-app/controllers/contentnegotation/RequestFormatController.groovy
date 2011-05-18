package contentnegotation

class RequestFormatController {

	def testFormat = {
		render "response format = ${response.format}"
	}

	def testWithFormat = {
		withFormat {
			html {
				render "request format html"
			}
			xml {
				render "request format xml"
			}
		}
	}
}
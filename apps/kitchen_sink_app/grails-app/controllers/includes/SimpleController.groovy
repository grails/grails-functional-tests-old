package includes

class SimpleController {

	def index = {}

	def testInclude = {}

	def testIncludeWithActionAndNoController = {}

	def testForwardWithParams = {
		forward(controller:"simple", action:"index", params:[foo:'bar'])
	}
}
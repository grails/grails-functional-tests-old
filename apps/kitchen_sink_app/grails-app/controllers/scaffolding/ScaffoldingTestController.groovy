package scaffolding

class ScaffoldingTestController {
	static scaffold = nullbinding.Book
	static defaultAction = 'actionTwo'
	
	def actionOne = {
		render 'rendered by the actionOne closure action'
	}
	
	def actionTwo() {
		render 'rendered by the actionTwo method action'
	}
}
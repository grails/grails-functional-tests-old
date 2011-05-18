package layouts

class LayoutController {

    def pluginView = { }

	def testApplyLayout = {}
	
	def testApplyLayoutPluginView = {}
	
	def testTwoLevelLayout = {}
	
	def warDeployed = {
		render "${grailsApplication.warDeployed}"
	}
}

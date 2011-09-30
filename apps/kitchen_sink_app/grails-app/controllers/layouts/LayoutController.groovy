package layouts

class LayoutController {

    def pluginView = { }

	def testApplyLayout = {}
	
	def testApplyLayoutPluginView = {}
	
	def testTwoLevelLayout = {}
	
	def warDeployed = {
		render "${grailsApplication.warDeployed}"
	}
	
	def someText = {
		render 'Some Text'
	}
	
	def someTemplate = {
		render template: 'testing'
	}
	
	def someTemplateWithLayout = {
		render template: 'testing', layout: 'testLayout'
	}
}

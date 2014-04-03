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
    
    // GRAILS-10839, GRAILS-10985
    def rawoutput() {
        [msg: '<h1>hello world</h1>', msg2: '<h1>hello world 2</h1>', styles:'/* this is a css comment */ p {color: red !important;}', headtags:'<meta name="keywords" content="grails,issues"/>']
    }
}

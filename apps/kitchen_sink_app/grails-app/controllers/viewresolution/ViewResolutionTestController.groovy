package viewresolution

class ViewResolutionTestController {

    def testRelativeView = { 
		render view:"simple", model:[foo:"bar"]
	}

    def testAbsoluteView = { 
		render view:"/viewResolutionTest/absolute", model:[foo:"bar"]
	}

    def testDefaultView = { 
		[foo:"bar"]
	}

	// TODO: nested relative views not supported yet. See GRAILS-4204
    def testNestedRelativeView = { 
		render view:"local/simple", model:[foo:"bar"]
	}

    def renderPluginView() {
        render view: '/renderTest/demo', plugin: 'plugin-views'
    }

    def renderViewWhichHasSamePathAsViewProvidedByPlugin() {
        render view: '/renderTest/demo'
    }
}

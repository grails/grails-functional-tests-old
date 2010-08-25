class ForwardFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testForwardWithParams() {
        get('/simple/testForwardWithParams')
        assertStatus 200
        assertContentContains '<title>Simple GSP page</title>'
        assertContentContains 'params = bar'
    }

	 void testForwardToAction() {
		  get('/forward/forwardToAction')
		  assertStatus 200
		  assertContentContains 'toAction output'
	 }

	 void testForwardToOtherController() {
	     // GRAILS-6618
		  get('/forward/forwardToOther?dummy=test')
		  assertStatus 200
		  assertContentContains 'OtherController page.gsp'
		  assertContentDoesNotContain 'forward'
		  assertContentDoesNotContain 'dummy'
		  assertContentDoesNotContain 'test'
	 }
}


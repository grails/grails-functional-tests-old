package includes

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
          get('/forward/forwardToOther?dummy=test')
          assertStatus 200
          assertContentContains 'OtherController page.gsp'
          assertContentContains 'dummy'
          assertContentContains 'test'		  
          assertContentContains 'explicitParam'
	 }
}


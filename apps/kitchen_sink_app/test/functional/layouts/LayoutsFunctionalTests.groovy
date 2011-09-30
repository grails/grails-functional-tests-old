package layouts

class LayoutsFunctionalTests extends functionaltestplugin.FunctionalTestCase {
	
	void testRenderingTextDoesNotHaveLayoutApplied() {
		get '/layout/someText'
		assertStatus 200
		assertContentContains 'Some Text'
		assertContentDoesNotContain 'Default Application Layout'
	}
	
	void testRenderingTemplateDoesNotHaveLayoutApplied() {
		get '/layout/someTemplate'
		assertStatus 200
		assertContentContains 'Some Template'
		assertContentDoesNotContain 'Default Application Layout'
	}
	
	void testRenderingTemplateWithLayoutAttribute() {
		get '/layout/someTemplateWithLayout'
		assertStatus 200
		assertContentContains 'Some Template'
		assertContentContains 'Test Layout'
		assertContentDoesNotContain 'Default Application Layout'
	}
}
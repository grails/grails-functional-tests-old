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
    
    // GRAILS-10839, GRAILS-10985
    void testRawOutputInLayout() {
        get '/layout/rawoutput'
        assertStatus 200
        assertContentContains '<h1>hello world</h1>'
        assertContentContains '/* this is a css comment */ p {color: red !important;}'
        assertContentContains '<meta name="keywords" content="grails,issues"/>'
        assertContentContains 'escaped:&lt;h1&gt;hello world 2&lt;/h1&gt;'
        assertContentContains 'escaped:&lt;h1&gt;hello world&lt;/h1&gt;'
    }
}
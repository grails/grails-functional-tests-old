package gorm

class ValidationHandlingFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testBindingErrorHandling() {
        get('/test/create')
        assertStatus 200
        
		form("testForm") {
			name = "test"
			age = 25
			click "Create"
		}
		
		assertStatus 200	
		def match = client.responseAsString =~ /Test (\d+) created/
		assertTrue match as boolean
		def id = match[0][1]
		
		form("navForm") {
			click "_action_Edit"
		}
		
		assertStatus 200		
		assertContentContains "Edit Test"
		assertContentContains '<input type="text" id="name" name="name" value="test"/>'
		assertContentContains '<input type="text" id="age" name="age" value="25" />'		
		
		form("editForm") {
			name = "bad"
			age = "not a number"
			click "_action_Update"
		}
		
		assertStatus 200
		assertContentContains "Edit Test"		
		assertContentContains "Property age must be a valid number"
		
        get("/test/show/$id")
		assertStatus 200
		assertContentContains '<td valign="top" class="value">test</td>'
		assertContentContains '<td valign="top" class="value">25</td>'		
		
		
    }
}

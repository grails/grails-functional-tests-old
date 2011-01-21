package commandobjects

class CommandObjectsFunctionalTests extends functionaltestplugin.FunctionalTestCase {
	void testCommandObjectsWorkBeforeUsage() {
		get('/commandObjectsTest/createCommand')
        assertStatus 200
        assertContentContains 'good'		
	}
    void testCommandObjects() {
         get('/commandObjectsTest/testCommand?name=fred&age=45')
         assertStatus 200
         assertContentContains 'name: fred, age:45'
    }

	void testCommandObjectsAdditionalParams() {
        get('/commandObjectsTest/testCommand?name=fred&age=45&x=23&y=343')
        assertStatus 200
        assertContentContains 'name: fred, age:45'		

        get('/commandObjectsTest/testCommand?name=fred&age=45&name.x=23&name.y=343')
        assertStatus 200
        assertContentContains 'name: fred, age:45'		
	}

	void testCommandObjectsWithNestedObject() {
        get('/commandObjectsTest/testCommandWithNestedValues?name=fred&age=45&x=23&y=343&nested.value=test')
        assertStatus 200
        assertContentContains 'name: fred, age: 45, nested.value: test'		

        get('/commandObjectsTest/testCommandWithNestedValues?name=fred&age=45&x=23&y=343&nested.value=test&nested.x=345')
        assertStatus 200
        assertContentContains 'name: fred, age: 45, nested.value: test'		

	}	
	
	void testCommandObjectWithMultipleBinding() {
		get('/commandObjectsTest/multi')
		
		form("commandForm") {
			delegate.'a.name' = "aaa"
			delegate.'b.query' = "bbb"			
			delegate.'c.name' = "ccc"						
			delegate.'d.query' = "ddd"						
			click "save"
		}		
		
        assertStatus 200
        assertContentContains '<input type="text" name="a.name" value="aaa" id="a.name" />'		
        assertContentContains '<input type="text" name="b.query" value="bbb" id="b.query" />'		
        assertContentContains '<input type="text" name="c.name" value="ccc" id="c.name" />'		
        assertContentContains '<input type="text" name="d.query" value="ddd" id="d.query" />'				
	}
	
}

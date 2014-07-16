package commandobjects

import groovy.xml.MarkupBuilder

class CommandObjectsFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testRetrievingCommandObjectFromDatabase() {
        post '/commandObjectsTest/createGadget?name=ALPHA&age=42'
        assertStatus 200
        assertContentContains 'Create succeeded. id: 1, name: ALPHA, age: 42'

        post '/commandObjectsTest/updateGadget?id=1&name=BETA'
        assertStatus 200
        assertContentContains 'Gadget was loaded. id: 1, name: BETA, age: 42'

        post '/commandObjectsTest/updateGadget', {
            headers.'Content-Type' = 'application/json'
            body {
                '{"id": "1", "name":"GAMMA"}'
            }
        }
        assertStatus 200
        assertContentContains 'Gadget was loaded. id: 1, name: GAMMA, age: 42'

        def sw = new StringWriter()
        def mkb = new MarkupBuilder(sw)
        mkb.post {
            delegate.id '1'
            delegate.name 'DELTA'
        }

        post '/commandObjectsTest/updateGadget', {
            headers.'Content-Type' = 'application/xml'
            body {
                sw.toString()
            }
        }
        assertStatus 200
        assertContentContains 'Gadget was loaded. id: 1, name: DELTA, age: 42'

        post '/commandObjectsTest/updateGadget?id=bogus&name=BETA'
        assertStatus 200
        assertContentContains 'gadget is null, error count is 1'

        post '/commandObjectsTest/updateGadget?id=2112&name=BETA'
        assertStatus 200
        assertContentContains 'gadget is null, error count is 0'

        get '/commandObjectsTest/updateGadget?id=bogus&name=BETA'
        assertStatus 405

        get '/commandObjectsTest/updateGadget?id=2112&name=BETA'
        assertStatus 405
    }

    void testCommandObjectIdNotFound() {
        post '/commandObjectsTest/updateGadget?id=2112&name=BETA'
        assertStatus 200
        assertContentContains 'gadget is null'
    }

    void testConstraintsProperty() {
        get '/commandObjectsTest/testConstraintsProperty'
        assertStatus 200
        assertContentContains 'Matches: [A-Za-z]*'
    }

    void testMethodActionWithSharedConstraintCommandObject() {
        get '/commandObjectsTest/methodActionWithSharedConstraintCommandObject/?name=John'
        assertStatus 200
        assertContentContains 'name: John, has errors?: false'
        
        get '/commandObjectsTest/methodActionWithSharedConstraintCommandObject/?name=George'
        assertStatus 200
        assertContentContains 'name: George, has errors?: true'
    }

    void testClosureActionWithSharedConstraintCommandObject() {
        get '/commandObjectsTest/closureActionWithSharedConstraintCommandObject/?name=John'
        assertStatus 200
        assertContentContains 'name: John, has errors?: false'
        
        get '/commandObjectsTest/closureActionWithSharedConstraintCommandObject/?name=George'
        assertStatus 200
        assertContentContains 'name: George, has errors?: true'
    }

    void testCommandObjectDefinedUnderSrcGroovy() {
        get '/commandObjectsTest/closureActionWithCommandObjectDefinedUnderSrcGroovy/?name=Hank'
        assertStatus 200
        assertContentContains 'name: Hank, has errors?: false'
        
        get '/commandObjectsTest/closureActionWithCommandObjectDefinedUnderSrcGroovy/?name=2112'
        assertStatus 200
        assertContentContains 'name: 2112, has errors?: true'
        
        get '/commandObjectsTest/methodActionWithCommandObjectDefinedUnderSrcGroovy/?name=Hank'
        assertStatus 200
        assertContentContains 'name: Hank, has errors?: false'
        
        get '/commandObjectsTest/methodActionWithCommandObjectDefinedUnderSrcGroovy/?name=2112'
        assertStatus 200
        assertContentContains 'name: 2112, has errors?: true'
    }
    
	void testCommandObjectsWorkBeforeUsage() {
		get('/commandObjectsTest/createCommand')
        assertStatus 200
        assertContentContains 'good'		
	}

	void testDomainClassAsCommandObject() {
        post '/commandObjectsTest/closureActionWithDomainClassAsCommandObject?name=Jon'
        assertStatus 200
        assertContentContains 'name: Jon, has errors?: true'

        post '/commandObjectsTest/methodActionWithDomainClassAsCommandObject?name=Jon'
        assertStatus 200
        assertContentContains 'name: Jon, has errors?: true'

        post '/commandObjectsTest/closureActionWithDomainClassAsCommandObject?name=JON'
        assertStatus 200
        assertContentContains 'name: JON, has errors?: false'

        post '/commandObjectsTest/methodActionWithDomainClassAsCommandObject?name=JON'
        assertStatus 200
        assertContentContains 'name: JON, has errors?: false'
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

	void testCommandObjectUsingBeanForValidation() {
         get('/commandObjectsTest/commandUsingBeanForValidation?value=9')
         assertStatus 200
         assertContentContains 'Valid?: false'
         
         get('/commandObjectsTest/commandUsingBeanForValidation?value=100')
         assertStatus 200
         assertContentContains 'Valid?: true'
         
         get('/commandObjectsTest/commandUsingBeanForValidation?value=1')
         assertStatus 200
         assertContentContains 'Valid?: false'
    }
}

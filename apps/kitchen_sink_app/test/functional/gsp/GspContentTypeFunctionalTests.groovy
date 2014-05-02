package gsp

class GspContentTypeFunctionalTests extends functionaltestplugin.FunctionalTestCase {
	
	void testJsonOutputWithSetContentType() {
		get '/gspContentType/jsonFromGsp'
		assertStatus 200
        assertEquals '{"hello": "world"}', client.responseAsString
        assertEquals "application/json;charset=UTF-8", response.getResponseHeaderValue('Content-Type')
	}
	
    void testJsonOutputWithPageContentType() {
        get '/gspContentType/jsonFromGsp2'
        assertStatus 200
        assertEquals '{"hello": "world"}', client.responseAsString
        assertEquals "application/json;charset=UTF-8", response.getResponseHeaderValue('Content-Type')
    }
}
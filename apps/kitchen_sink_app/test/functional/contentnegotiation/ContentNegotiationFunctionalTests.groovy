package contentnegotiation

class ContentNegotiationFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testFileExtensionContentNegotiation() {
        // Here call get(uri) or post(uri) to start the session
        // and then use the custom assertXXXX calls etc to check the response
        //
        get('/requestFormat/testFormat')
        assertStatus 200
        assertContentContains 'response format = all'

        get('/requestFormat/testFormat.xml')
        assertStatus 200
        assertContentContains 'response format = xml'

    }

    void testFileExtensionWithFormat() {
        get('/requestFormat/testWithFormat')
        assertStatus 200
        assertContentContains 'request format html'

        get('/requestFormat/testWithFormat.xml')
        assertStatus 200
        assertContentContains 'request format xml'		
    }

    void testWithFormatGRAILS8341() {
        get('/requestFormat/testWithFormatGRAILS8341')
        assertStatus 200
        assertContentContains 'request format json'
    }

    void testAcceptHeaderWithFormat() {
        get('/requestFormat/testWithFormatGRAILS8341') {
            headers.'Accept' = "application/xml"
        }

        assertStatus 200
        assertContentContains 'request format xml'
    }
}

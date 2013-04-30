package contentnegotiation

import groovy.xml.MarkupBuilder

/**
 * Test case that ensures that automatic parsing of XML and JSON requests
 * occurs correctly.
 */
class ContentParsingFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testXmlPost() {
        def sw = new StringWriter()
        def mkb = new MarkupBuilder(sw)
        mkb.post {
            delegate.message 'First post!'
            delegate.author 'Peter Ledbrook'
        }

        post '/post', {
            headers.'Content-Type' = 'application/xml'
            body {
                sw.toString()
            }
        }
        assertStatus 200
        assertContentContains 'First post! by Peter Ledbrook'
    }

    void testJsonPost() {
        post '/post', {
            headers.'Content-Type' = 'application/json'
            body {
                '{"class":"Post","author":"Graeme Rocher","message":"JSON post!"}'
            }
        }
        assertStatus 200
        assertContentContains 'JSON post! by Graeme Rocher'
    }

    void testBindingNestedJsonProperties() {
        post '/post/displayPostAndPerson', {
            headers.'Content-Type' = 'application/json'
            body {
                '{"author":"Jeff Scott Brown","message":"King Crimson Rocks","person":{"name":"Robert Fripp"}}'
            }
        }
        assertStatus 200
        assertContentContains 'Message: King Crimson Rocks'
        assertContentContains 'Author: Jeff Scott Brown'
        assertContentContains 'Person Name: Robert Fripp'
    }
}

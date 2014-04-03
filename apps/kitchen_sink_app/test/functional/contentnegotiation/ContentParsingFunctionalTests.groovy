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

    void testXmlCommandObjectBinding() {
        def sw = new StringWriter()
        def mkb = new MarkupBuilder(sw)
        mkb.post {
            delegate.width '8'
            delegate.height '7'
        }

        post '/post/createWidget', {
            headers.'Content-Type' = 'application/xml'
            body {
                sw.toString()
            }
        }
        assertStatus 200
        assertContentContains 'Something went wrong'

        sw = new StringWriter()
        mkb = new MarkupBuilder(sw)
        mkb.post {
            delegate.width '8'
            delegate.height '6'
            delegate.name 'some name'
        }

        post '/post/createWidget', {
            headers.'Content-Type' = 'application/xml'
            body {
                sw.toString()
            }
        }
        assertStatus 200
        assertContentContains 'Area is 48'
    }

    void testJsonCommandObjectBinding() {
        post '/post/createWidget', {
            headers.'Content-Type' = 'application/json'
            body {
                '{"width":8,"height":3}'
            } 
        }
        assertStatus 200
        assertContentContains 'Something went wrong'

        post '/post/createWidget', {
            headers.'Content-Type' = 'application/json'
            body {
                '{"width":8,"height":4,"name":"some name"}'
            }
        }
        assertStatus 200
        assertContentContains 'Area is 32'
    }

    void testCustomBindingSourceHelper() {
        post '/post/createWidgetFromRequest', {
            headers.'Content-Type' = 'text/custom+demo+csv'
            body {
                'width:8,height:6'
            }
        }
        assertStatus 200
        assertContentContains 'Area is 48'
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

    void testInvalidXmlPost() {
        post '/post/bindRequestToPostObject', {
            headers.'Content-Type' = 'application/xml'
            body {
                '<some invalid<xml here>'
            }
        }
        assertStatus 200
        assertContentContains 'The Post object could not be created because of bad request data'
    }

    void testInvalidJsonPost() {
        post '/post/bindRequestToPostObject', {
            headers.'Content-Type' = 'application/json'
            body {
                '{some Invalid { json][ here'
            }
        }
        assertStatus 200
        assertContentContains 'The Post object could not be created because of bad request data'
    }
}

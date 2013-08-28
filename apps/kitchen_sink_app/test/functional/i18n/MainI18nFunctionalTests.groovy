package i18n

class MainI18nFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    /**
     * Tests that localised text is loaded from properties files that
     * reside in a package structure, i.e. in sub-directories of
     * <tt>grails-app/i18n</tt>.
     */
    void testPropertiesInPackage() {
        // Here call get(uri) or post(uri) to start the session
        // and then use the custom assertXXXX calls etc to check the response
        //
        get "/mainI18n"
        assertStatus 200
        assertTitleContains "The main page"

        get "/mainI18n?lang=fr"
        assertStatus 200
        assertTitleContains "La page principale"
    }

    void testLocalisedNumberParsing() {
        get '/formatNumbers?someFloat=2333&somePrimitiveFloat=1234&someDouble=4555&someLong=12,345'
        assertStatus 200
        assertContentContains 'somePrimitiveFloat 1234.0'
        assertContentContains 'someFloat 2333.0'
        assertContentContains 'someDouble 4555.0'
        assertContentContains 'someLong 12345'

        get '/formatNumbers?someFloat=2333&somePrimitiveFloat=1234&someDouble=4555&someLong=12.345&lang=pt_BR'
        assertStatus 200
        assertContentContains 'somePrimitiveFloat 1234.0'
        assertContentContains 'someFloat 2333.0'
        assertContentContains 'someDouble 4555.0'
        assertContentContains 'someLong 12345'

        get '/formatNumbers?someFloat=2333&somePrimitiveFloat=1234&someDouble=4555&someLong=12,345&lang=en'
        assertStatus 200
        assertContentContains 'somePrimitiveFloat 1234.0'
        assertContentContains 'someFloat 2333.0'
        assertContentContains 'someDouble 4555.0'
        assertContentContains 'someLong 12345'

        get '/formatNumbers?someFloat=23.33&somePrimitiveFloat=12.34&someDouble=45.55&someLong=12,345'
        assertStatus 200
        assertContentContains 'somePrimitiveFloat 12.34'
        assertContentContains 'someFloat 23.33'
        assertContentContains 'someDouble 45.55'
        assertContentContains 'someLong 12345'

        get '/formatNumbers?someFloat=23,33&somePrimitiveFloat=12,34&someDouble=45,55&someLong=12.345&lang=pt_BR'
        assertStatus 200
        assertContentContains 'somePrimitiveFloat 12.34'
        assertContentContains 'someFloat 23.33'
        assertContentContains 'someDouble 45.55'
        assertContentContains 'someLong 12345'

        get '/formatNumbers?someFloat=23.33&somePrimitiveFloat=12.34&someDouble=45.55&someLong=12,345&lang=en'
        assertStatus 200
        assertContentContains 'somePrimitiveFloat 12.34'
        assertContentContains 'someFloat 23.33'
        assertContentContains 'someDouble 45.55'
        assertContentContains 'someLong 12345'
    }
}

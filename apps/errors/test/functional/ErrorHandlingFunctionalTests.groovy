class ErrorHandlingFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testStandardHandleException() {
        // Here call get(uri) or post(uri) to start the session
        // and then use the custom assertXXXX calls etc to check the response
        //
        get('/errors/standard')
        assertStatus 500

        // Check that the view is rendered.
        assertContentContains 'Grails Runtime Exception'

        // Check that the layout is applied.
        assertNotNull byId('spinner')
        assertNotNull byXPath("//div[@class='logo']")
    }

    void testDeclarativeExceptionHandling() {
        get('/errors/declarative')
        assertStatus 500

        assertContentContains 'Exception was org.codehaus.groovy.grails.web.errors.GrailsWrappedRuntimeException'
    }

    void testErrorViewWithLayout() {
        get('/errors/layout')
        assertStatus 500

        assertContentContains '<h1>Test Layout</h1>'
        assertContentContains 'Grails Runtime Exception'
        assertContentContains '<strong>Class:</strong> ErrorsController'
        assertContentContains '<strong>At Line:</strong> [12]'
        assertContentContains 'throw new IllegalArgumentException(&quot;bad&quot;)'
    }

    void testErrorFromTagLib() {
        get('/errors/gstringTagError')
        assertStatus 500

        assertContentContains 'Grails Runtime Exception'
        assertContentContains '<strong>Class:</strong> MyTagLib'
        assertContentContains '<strong>Exception Message:</strong> No such property: fooo for class: MyTagLib'
        assertContentContains '<strong>At Line:</strong>'
    }

    void testErrorFromTagExpression() {
        get('/errors/warDeployed')

        if (response.contentAsString!='war=true') {
            get('/errors/tagExpressionError')
            assertStatus 500

            assertContentContains 'Grails Runtime Exception'
            assertContentContains 'tagExpressionError.gsp '
            assertContentContains '<strong>Exception Message:</strong> Cannot get property &#39;bar&#39; on null object'
            assertContentContains '<strong>Caused by:</strong> Error evaluating expression [foo.bar] on line [14]: Cannot get property &#39;bar&#39; on null object'
            assertContentContains '<strong>At Line:</strong> [14]'
            assertContentContains '&lt;g:each var=&quot;c&quot; in=&quot;${foo.bar}&quot;&gt;'
        }
    }

    void testErrorFromRegularExpression() {
        get('/errors/warDeployed')

        if(response.contentAsString!='war=true') {

            get('/errors/regularExpressionError')
            assertStatus 500

            assertContentContains 'Grails Runtime Exception'
            assertContentContains 'regularExpressionError.gsp '
            assertContentContains '<strong>Exception Message:</strong> No signature of method: org.codehaus.groovy.grails.commons.DefaultGrailsControllerClass.dummy() is applicable for argument types: () values: []'
            assertContentContains '<strong>Caused by:</strong> Error evaluating expression [c.dummy()] on line [15]: No signature of method: org.codehaus.groovy.grails.commons.DefaultGrailsControllerClass.dummy() is applicable for argument types: () values: []'
            assertContentContains '<strong>At Line:</strong> [15]'
            assertContentContains '&lt;li class=&quot;controller&quot;&gt;This will throw MPE ${c.dummy()}&lt;/li&gt;'
        }
    }

    void testErrorFromInternalTag() {
        get('/errors/warDeployed')

        if(response.contentAsString!='war=true') {

            get('/errors/internalTagError')
            assertStatus 500

            assertContentContains 'Grails Runtime Exception'
            assertContentContains 'internalTagError.gsp '
            assertContentContains '<strong>Exception Message:</strong> Tag [submitButton] is missing required attribute [name] or [field] '
            assertContentContains '<strong>Caused by:</strong> Error processing GroovyPageView: Tag [submitButton] is missing required attribute [name] or [field]'
            assertContentContains '<strong>At Line:</strong> [16]'
            assertContentContains '&lt;g:submitButton&gt;&lt;/g:submitButton&gt;'
        }
    }

    void testErrorFromInvalidFinder() {
        get('/errors/invalidGormMethod')
        assertStatus 500

        assertContentContains 'Grails Runtime Exception'
        assertContentContains 'ErrorsController'
        assertContentContains '<strong>Exception Message:</strong> No property found for name [rubbish] for class [class Book]'
        assertContentContains '<strong>Caused by:</strong> No property found for name [rubbish] for class [class Book] <br />'
        assertContentContains '<strong>At Line:</strong> [32]'
        assertContentContains '[books:Book.findAllByRubbish(&quot;yes&quot;)]'
    }

    void test404ErrorWithRedirect() {
        get('/errors/bad')
        // 200 due to the client side redirect
        assertStatus 200
        assertContentContains 'not there'
    }

    /**
     * Test for GRAILS-6627
     *
     * The 'renderView' action renders the 'index' view directly. The
     * associated error page should be displayed ('errors/forwardError')
     * but the above bug means that an exception is thrown.
     */
    void testForwardingErrorWithRenderView() {
        get('/home/renderView')

        assertStatus 500
        assertContentContains "Something went wrong on the server!"
    }

    /**
     * Test for GRAILS-6628
     *
     * Check that URL parameters are not passed on to the error handler.
     */
    void testWithUrlParameters() {
        if (notYetImplemented()) return
        get('/home/index?aabbccdd=true')

        assertStatus 500
        assertContentContains "Something went wrong on the server!"
        assertContentDoesNotContain "aabbccdd"
    }

    void testWithStaticGspContentInErrorPage() {
           // this one throws a NullPointerException which is mapped in UrlMappings
        get '/home/renderError'
        assertStatus 500
           assertContentContains 'Something went wrong on the server!'
        assertContentDoesNotContain '<h2>Hello world!</h2>'

        // this one throws an UnsupportedOperationException which is not mapped in UrlMappings
        get '/home/throwUoe'
        assertStatus 500
        assertContentDoesNotContain '<h2>Hello World</h2>'
    }
}

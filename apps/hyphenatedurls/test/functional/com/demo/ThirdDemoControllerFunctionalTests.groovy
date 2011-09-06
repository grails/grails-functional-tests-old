package com.demo

class ThirdDemoControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testDefaultAction() {
        get '/third-demo'
        assertStatus 200
        assertContentContains 'This is grails-app/views/thirdDemo/myDefaultAction.gsp'
    }
    
    void testMyDefaultAction() {
        get '/third-demo/my-default-action'
        assertStatus 200
        assertContentContains 'This is grails-app/views/thirdDemo/myDefaultAction.gsp'
    }
    
    void testIndexAction() {
        get '/third-demo/index'
        assertStatus 200
        assertContentContains 'This is grails-app/views/thirdDemo/index.gsp'
    }
}

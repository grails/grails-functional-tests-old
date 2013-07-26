package com.demo

class RedirectUrlMappingsFunctionalTests extends functionaltestplugin.FunctionalTestCase {

    void testRedirectUrlMappings() {
        get '/toFirstDemo'
        assertStatus 200
        assertContentContains 'FirstDemoController index action'

        get '/toSecondDemo'
        assertStatus 200
        assertContentContains 'SecondDemoController someClosureAction action'
    }
}


package com.demo

class SecondDemoControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testDefaultAction() {
        get '/second-demo'
        assertStatus 200
        assertContentContains 'SecondDemoController someClosureAction action'
    }
    
    void testDefaultIndexAction() {
        get '/second-demo/index'
        assertStatus 200
        assertContentContains 'SecondDemoController index action'
    }
    
    void testMethodAction() {
        get '/second-demo/some-method-action'
        assertStatus 200
        assertContentContains 'SecondDemoController someMethodAction action'
    }
    
    void testClosureAction() {
        get '/second-demo/some-closure-action'
        assertStatus 200
        assertContentContains 'SecondDemoController someClosureAction action'
    }
}

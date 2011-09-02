package com.demo

class FirstDemoControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testDefaultAction() {
        get '/first-demo'
        assertStatus 200
        assertContentContains 'FirstDemoController index action'
    }
    
    void testDefaultIndexAction() {
        get '/first-demo/index'
        assertStatus 200
        assertContentContains 'FirstDemoController index action'
    }
    
    void testMethodAction() {
        get '/first-demo/some-method-action'
        assertStatus 200
        assertContentContains 'FirstDemoController someMethodAction action'
    }
    
    void testClosureAction() {
        get '/first-demo/some-closure-action'
        assertStatus 200
        assertContentContains 'FirstDemoController someClosureAction action'
    }
}

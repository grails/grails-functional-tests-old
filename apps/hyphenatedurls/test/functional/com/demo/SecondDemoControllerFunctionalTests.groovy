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
    
    void testReverseUrlMappingScenarios() {
        get '/second-demo/render-some-view'
        assertStatus 200
        assertContentContains '''Click <a href="/hyphenatedurls/second-demo">here</a> To execute the default action in SecondDemoController.'''
        assertContentContains '''Click <a href="/hyphenatedurls/second-demo/index">here</a> To execute the index action in SecondDemoController.'''
        assertContentContains '''Click <a href="/hyphenatedurls/second-demo/some-method-action">here</a> To execute the someMethodAction action in SecondDemoController.'''
        assertContentContains '''Click <a href="/hyphenatedurls/second-demo/some-closure-action">here</a> To execute the someClosureAction action in SecondDemoController.'''
        assertContentContains '''Click <a href="/hyphenatedurls/second-demo/render-some-view">here</a> To execute the renderSomeView action in SecondDemoController.'''
    }
}

package com.demo

class SecondDemoController {

    static defaultAction = 'someClosureAction'
    
    def index() {
        render 'SecondDemoController index action'
    }
    
    def someMethodAction() {
        render 'SecondDemoController someMethodAction action'
    }
    
    def someClosureAction = {
        render 'SecondDemoController someClosureAction action'
    }
}
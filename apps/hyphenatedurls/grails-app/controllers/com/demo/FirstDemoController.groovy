package com.demo

class FirstDemoController {

    def index() {
        render 'FirstDemoController index action'
    }
    
    def someMethodAction() {
        render 'FirstDemoController someMethodAction action'
    }
    
    def someClosureAction = {
        render 'FirstDemoController someClosureAction action'
    }
}
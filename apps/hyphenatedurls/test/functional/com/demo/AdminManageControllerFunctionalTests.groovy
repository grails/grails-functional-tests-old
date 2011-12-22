package com.demo

class AdminManageControllerFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testReverseUrlMapping() {
        get '/admin/manage/index'
        assertStatus 200
        assertTitle 'Admin Manage Controller'
        
        assertNotNull byXPath("//a[@href='/hyphenatedurls/admin/manage/index']")
    }
}

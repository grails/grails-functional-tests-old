/**
 * Contains tests that ensure tags such as &lt;g:resource> and &lt;g:javascript>
 * behave correctly in application and plugin views. Note that the in-place
 * db-util plugin has been modified for these tests, so don't try to upgrade
 * it without re-applying the customisations!
 */
class IncludeTagsFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    /**
     * Tests that the &lt;g:resource> and &lt;g:javascript> tags include
     * the plugin context path in plugin views.
     */
    void testWithPluginView() {
        get "/dbUtil/data" 
        assertStatus 200
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/dbUtil.css"/>' 
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/standard.css"/>' 
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/oldstyle.css"/>' 
        assertContentContains '<script src="/test-plugins/plugins/db-util-0.3/js/dojo.js"type="text/javascript" ></script>'
        assertContentContains '<script src="/test-plugins/plugins/db-util-0.3/js/application.js"type="text/javascript" ></script>'
        assertEquals "/plugins/db-util-0.3", byId("pluginContext").textContent
    }

    /**
     * Tests that the &lt;g:resource> and &lt;g:javascript> tags exclude
     * the plugin context path for a plugin view that has been overridden
     * by the application. The customised view uses an application layout.
     */
    void testWithOverriddenView() {
        get "/dbUtil/sql" 
        assertStatus 200
        assertContentContains '<link rel="stylesheet" href="/test-plugins/css/main.css"/>'
        assertContentContains '<link rel="stylesheet" href="/test-plugins/css/other.css" />'
        assertContentContains '<script src="/test-plugins/js/app-layout.js" type="text/javascript"></script>'
        assertContentContains '<script src="/test-plugins/js/app.js" type="text/javascript"></script>'
        assertContentContains '<script src="/test-plugins/js/application.js" type="text/javascript"></script>'
    }

    /**
     * Tests that the &lt;g:resource> and &lt;g:javascript> tags exclude
     * the plugin context path when they are in an application layout
     * that is used by a plugin view. The tags in the plugin view should
     * include the plugin context path.
     */
    void testWithPluginViewInApplicationLayout() {
        get "/dbUtil/info" 
        assertStatus 200
        assertContentContains '<link rel="stylesheet" href="/test-plugins/css/main.css"/>'
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/other.css" />'
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/other-2.css" />'
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/other-3.css" />'
        assertContentContains '<script src="/test-plugins/js/app-layout.js" type="text/javascript"></script>'
        assertContentContains '<script src="/test-plugins/js/application.js" type="text/javascript"></script>'
        assertContentContains '<script src="/test-plugins/plugins/db-util-0.3/js/plugin-info.js" type="text/javascript"></script>'
    }

    /**
     * Tests that the &lt;g:resource> and &lt;g:javascript> tags exclude
     * the plugin context path for a plugin view that has been overridden
     * by the application. The view uses a plugin layout, so the plugin
     * context path should be included in any layout-provided links.
     */
    void testWithOverriddenViewInPluginLayout() {
        get "/dbUtil/testWithPluginLayout" 
        assertStatus 200
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/dbUtil.css"/>' 
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/standard.css"/>' 
        assertContentContains '<link rel="stylesheet" href="/test-plugins/plugins/db-util-0.3/css/oldstyle.css"/>' 
        assertContentContains '<link rel="stylesheet" href="/test-plugins/css/other.css" />'
        assertContentContains '<script src="/test-plugins/js/prototype/prototype.js" type="text/javascript"></script>'
        assertContentContains '<script src="/test-plugins/plugins/db-util-0.3/js/application.js" type="text/javascript"></script>'
    }
}

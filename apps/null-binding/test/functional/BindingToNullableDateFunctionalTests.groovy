class BindingToNullableDateFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testJeff() {
        // http://jira.codehaus.org/browse/GRAILS-6604
        get('/widget/create')
        assertStatus 200
        assertContentContains '<title>Create Widget</title>'

		form {
		      manufactureDate_day = ""
		      manufactureDate_month = ""
		      manufactureDate_year = ""
		      click "create"
		}
		
        assertStatus 200
        assertContentContains '<title>Show Widget</title>'
    }
}

class BindingToNullableDateFunctionalTests extends functionaltestplugin.FunctionalTestCase {
    void testBindingToNullableDate() {
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

    void testBindingNullToNullableDatePropertyThatAlreadyHasANonNullValue() {
        // http://jira.codehaus.org/browse/GRAILS-7189
        get '/widget/create'
        assertStatus 200
        assertContentContains '<title>Create Widget</title>'

		form {
		      manufactureDate_day = "15"
		      manufactureDate_month = "11"
		      manufactureDate_year = "1969"
		      click "create"
		}

        assertStatus 200
        assertContentContains '<title>Show Widget</title>'
        assertContentContains '1969-11-15'
        form {
            click '_action_edit'
        }
        assertStatus 200
        assertContentContains 'Edit Widget'

        form {
              manufactureDate_day = ""
              manufactureDate_month = ""
              manufactureDate_year = ""
              click "_action_update"
        }

        assertStatus 200
        assertContentContains '<title>Show Widget</title>'
        assertContentDoesNotContain '1969-11-15'

        form {
            click '_action_edit'
        }

        assertStatus 200
        assertContentContains 'Edit Widget'

        form {
              manufactureDate_day = "16"
              manufactureDate_month = "11"
              manufactureDate_year = "1969"
              click "_action_update"
        }

        assertStatus 200
        assertContentContains '<title>Show Widget</title>'
        assertContentContains '1969-11-16'
    }
}

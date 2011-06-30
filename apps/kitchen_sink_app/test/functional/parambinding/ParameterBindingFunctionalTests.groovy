package parambinding

class ParameterBindingFunctionalTests extends functionaltestplugin.FunctionalTestCase {
	void testBasicParameterBinding() {
		get('/parameterBinding/createPerson?age=60&firstName=Scott&lastName=Gorham')
        assertStatus 200
        assertContentContains "Create Person: firstName=Scott, lastName=Gorham, age=60"
	}
}

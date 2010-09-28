class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
	  "/path/$file.$ext"(controller:"test", action:"testExtension")
	
	  "/dynamic/variable" {
			controller = "test"
			action = "dynaVariable"
			id = { params.id }
	  }
	
	  "/declared/params" {
			controller = "test"
			action = "declaredParams"		
			var = 'foo'; var2='bar'
	  }
	  "/decode/$myparam?"(controller:"test", action:"decode")
	
      "/"(view:"/index")
	  "500"(view:'/error')
	}
}

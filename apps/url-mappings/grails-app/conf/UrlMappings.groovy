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
      "/"(view:"/index")
	  "500"(view:'/error')
	}
}

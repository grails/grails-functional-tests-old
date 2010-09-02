class UrlMappings {
    static mappings = {
        "/post"(controller: "post", action: "index") {
            parseRequest = true
        }

      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      "/"(view:"/index")
	  "500"(view:'/error')
	}
}

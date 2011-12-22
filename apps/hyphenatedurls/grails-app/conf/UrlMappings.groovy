class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
        "/admin/manage/$action?"(controller:'adminManage')

		"/"(view:"/index")
		"500"(view:'/error')
	}
}

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
        "/admin/manage/$action?"(controller:'adminManage')

        "/toFirstDemo"(redirect: [controller: 'firstDemo', action: 'index'])
        "/toSecondDemo"(redirect: '/second-demo')

		"/"(view:"/index")
		"500"(view:'/error')
	}
}

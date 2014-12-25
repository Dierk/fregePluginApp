class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/game"(controller:"foo", action:"ttt")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}

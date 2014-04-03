class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }
        "/path/$file.$ext"(controller:"urlMappingsTest", action:"testExtension")

        "/formatNumbers" {
            controller = 'mainI18n'
            action = 'formatNumbers'
        }

        "/dynamic/variable" {
            controller = "urlMappingsTest"
            action = "dynaVariable"
            id = { params.id }
        }

        "/declared/params" {
            controller = "urlMappingsTest"
            action = "declaredParams"		
            var = 'foo'; var2='bar'
        }
        "/decode/$myparam?"(controller:"urlMappingsTest", action:"decode")
        "/post"(controller: "post", action: "index") {
            parseRequest = true
        }

        "/containsBean/$beanName"(controller: 'namespaceInspector', action: 'containsBean')
        "/showBeanType/$beanName"(controller: 'namespaceInspector', action: 'showBeanType')

        "/$namespace/$controller/$action?"()

        "/invokePrimaryController" {
            controller = 'namespaced'
            namespace = 'primary'
        }

        "/anotherRouteToPrimaryController"(controller: 'namespaced', namespace: 'primary')

        "/invokeSecondaryController" {
            controller = 'namespaced'
            namespace = 'secondary'
        }

        "/anotherRouteToSecondaryController"(controller: 'namespaced', namespace: 'secondary')

        "/nonNamespacedController/$action?" {
            controller = 'namespaced'
        }

        "/anotherRouteToNonNamespacedController"(controller: 'namespaced')

        "/numberOne"(redirect: [controller: 'redirect', action: 'one'])
        "/numberTwo"(redirect: [controller: 'redirect', action: 'two'])
        "/anotherNumberOne"(redirect: [uri: '/redirect/one'])
        "/anotherNumberTwo"(redirect: '/redirect/two')
        "/redirectToOutput"(redirect: [controller: 'redirect', action: 'output'])

        "/"(view:"/index")
        "500"(controller: 'testFiltersError', action: 'handleException', exception: CustomRuntimeException)
        "500"(view:'/error')
        "404"(controller: 'i18nError', action: 'pageNotFound')
    }
}

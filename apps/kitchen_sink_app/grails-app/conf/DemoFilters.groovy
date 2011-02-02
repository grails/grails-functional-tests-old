class DemoFilters {
    def filters = {
        grails6946(controller: '*', action: '*') {
            before = {
                params.actionNameInFilter = actionName
            }
        }

        grails4810_filter1(controller: 'filterDemo', action: 'a*', actionExclude: 'ab*') {
            before = {
                params.filter1Ran = 'yes'
            }
        }

        grails4810_filter2(controller: '*ilter*', controllerExclude: 'anotherFilter*') {
            before = {
                params.filter2Ran = 'yes'
            }
        }

        grails4810_filter3(uri: '/filterDemo/a*', uriExclude: '/filterDemo/ab*') {
            before = {
                params.filter3Ran = 'yes'
            }
        }

        grails4810_filter4(uriExclude: '/filterDemo/ab*') {
            before = {
                params.filter4Ran = 'yes'
            }
        }
    }
}
class DemoFilters {
    def filters = {
        grails6946(controller: '*', action: '*') {
            before = {
                params.actionNameInFilter = actionName
            }
        }
    }
}
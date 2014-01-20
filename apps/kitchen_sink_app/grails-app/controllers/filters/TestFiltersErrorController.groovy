package filters

class TestFiltersErrorController { 
    def handleException() {
        render 'handleException:' + request?.exception?.message?:'no exception'
    }
}

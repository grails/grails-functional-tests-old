package defaultaction

class DefaultActionDemoController {
    static defaultAction = 'list'
    
    def index() {
        redirect action: 'list', params: params
    }
    
    def list() {
        render 'the list action method rendered this'
    }
    
    def upload = {
        render 'the upload action closure rendered this'
    }
}
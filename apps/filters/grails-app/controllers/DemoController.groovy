class DemoController {
    
    def index = {
        forward action: 'doit'
    }
    
    def doit = {
        render "action name in filter: ${params.actionNameInFilter}"
    }
}
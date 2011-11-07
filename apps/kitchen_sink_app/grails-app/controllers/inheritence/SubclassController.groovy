package inheritence

class SubclassController extends AbstractBaseController {
    def index = {
        render 'Rendered From SubclassController'
    }
    
}
package inheritence

abstract class AbstractBaseController {
    def index = {
        render 'Rendered From AbstractBaseController'
    }
}
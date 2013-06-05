package namespace.alpha

class NamespacedController {

    static namespace = 'primary'

    def index() {
        render 'Rendered by the index action in the namespace.alpha.NamespacedController controller'
    }
    
    def demo() {
        render 'Rendered by the demo action in the namespace.alpha.NamespacedController controller'
    }
}



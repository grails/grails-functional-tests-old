package namespace.gamma

class NamespacedController {

    def index() {
        render 'Rendered by the index action in the namespace.gamma.NamespacedController controller'
    }

    def demo() {
        render 'Rendered by the demo action in the namespace.gamma.NamespacedController controller'
    }
}


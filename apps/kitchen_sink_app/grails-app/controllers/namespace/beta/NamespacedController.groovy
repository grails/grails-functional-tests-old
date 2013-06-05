package namespace.beta

class NamespacedController {

    static namespace = 'secondary'

    def index() {
        render 'Rendered by the index action in the namespace.beta.NamespacedController controller'
    }

    def demo() {
        render 'Rendered by the demo action in the namespace.beta.NamespacedController controller'
    }
}


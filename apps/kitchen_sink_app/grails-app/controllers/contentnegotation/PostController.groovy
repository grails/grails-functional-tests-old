package contentnegotation

class PostController {
    def index = {
        def post = new Post()
        post.properties = request
        render "${post.message} by ${post.author}"
    }

    def displayPostAndPerson() {
        def post = new Post(request.JSON)
        [post: post]
    }

    def createWidget(Widget widget) {
        if(widget.hasErrors()) {
            render 'Something went wrong'
        } else {
            render "Area is ${widget.height * widget.width}"
        }
    }

    def createWidgetFromRequest() {
        def widget = new Widget()
        widget.properties = request
        if(widget.hasErrors()) {
            render 'Something went wrong'
        } else {
            render "Area is ${widget.height * widget.width}"
        }
    }
}

class Widget {
    String name
    Integer width
    Integer height

    static constraints = {
        width validator: { val, obj -> val % 2 == 0 }
        height validator: { val, obj -> val % 2 == 0 }
    }
}


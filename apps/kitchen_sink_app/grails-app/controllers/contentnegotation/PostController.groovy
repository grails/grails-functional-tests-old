package contentnegotation

class PostController {
    def index = {
        def post = new Post(params['post'])
        render "${post.message} by ${post.author}"
    }
}

import autotimestamp.Category
import autotimestamp.Post

class BootStrap {

    def init = { servletContext ->
        // autotimestamp
        def categoryA = Category.findByName("A") ?: new Category(name: "A", description: "Category A").save()
        def firstPost = Post.findByName("First") ?: new Post(name: "First", description: "First post").addToCategories(categoryA).save()
    }
    def destroy = {
    }
}

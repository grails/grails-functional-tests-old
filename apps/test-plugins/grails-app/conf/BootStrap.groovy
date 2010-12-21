import org.example.blog.Post

class BootStrap {
    def init = { servletContext ->
        new Post(message: "First post!", userId: 1).save(failOnError: true)
        new Post(message: "Second post!", userId: 1).save(failOnError: true)
        new Post(message: "Third post!", userId: 2).save(failOnError: true)
        new Post(message: "Fourth post!", userId: 1).save(failOnError: true)
        new Post(message: "Fifth post!", userId: 2).save(failOnError: true)
    }

    def destroy = {
    }
} 

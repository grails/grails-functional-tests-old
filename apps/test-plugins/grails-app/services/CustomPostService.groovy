import org.example.blog.Post

class CustomPostService {
    def postsInLastMonth() {
        def today = new Date()
        today.clearTime()

        return Post.withCriteria {
            gt "dateCreated", today - 30
        }
    }
}

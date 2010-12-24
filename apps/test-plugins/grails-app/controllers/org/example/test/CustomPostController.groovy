package org.example.test

import org.example.blog.Post

/**
 * This controller tests that the above import works.
 */
class CustomPostController {
    def index =  {
        def posts = Post.withCriteria {
            eq "userId", 1l
        }

        render "Number of posts: ${posts.size()}"
    }
}

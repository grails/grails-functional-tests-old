package org.example.test

import org.grails.blog.Post

/**
 * This controller tests that the above import works.
 */
class CustomPostController {
    def index =  {
        def posts = Post.withCriteria {
            eq "userId", 1
        }

        render "Number of posts: ${posts.size()}"
    }
}

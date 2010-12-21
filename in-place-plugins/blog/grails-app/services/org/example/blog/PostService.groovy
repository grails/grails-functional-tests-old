package org.example.blog

class PostService {
    def allPosts() {
        return Post.list()
    }

    def allByUser(long userId) {
        return Post.withCriteria {
            eq "userId", userId
        }
    }
}

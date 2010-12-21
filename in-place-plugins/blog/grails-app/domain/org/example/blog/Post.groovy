package org.example.blog

class Post {
    String message
    Long userId
    Date dateCreated

    static constraints = {
        message blank: false
    }
}

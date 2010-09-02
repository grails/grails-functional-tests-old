class Post {
    String message
    String author

    static constraints = {
        message(blank: false)
        author(blank: false)
    }
}

package contentnegotation

class Post {
    String message
    String author
    gorm.Person person

    static constraints = {
        message(blank: false)
        author(blank: false)
    }
}

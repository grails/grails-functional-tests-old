package autotimestamp

class Post {
    Date dateCreated
    Date lastUpdated
    String name
    String description
    static belongsTo = Category
    static hasMany = [categories: Category]
}

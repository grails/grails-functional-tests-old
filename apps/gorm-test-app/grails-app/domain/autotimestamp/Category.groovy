package autotimestamp

class Category {
    Date dateCreated
    Date lastUpdated
    String name
    String description
    
    static hasMany = [posts: Post]
}

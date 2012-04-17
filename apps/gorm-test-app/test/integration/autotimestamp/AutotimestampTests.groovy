package autotimestamp

class AutotimestampTests extends GroovyTestCase {
    
    void testAutotimestamp() {
        def category = new Category(name:'example', description:'testing this')
        category.save(flush:true)
        assertNotNull(category.dateCreated)
        assertNotNull(category.lastUpdated)
    }

    void testAutotimestampNoFlush() {
        def category = new Category(name:'example', description:'testing this')
        category.save()
        assertNotNull(category.dateCreated)
        assertNotNull(category.lastUpdated)
    }
    
}

package autotimestamp

import grails.test.mixin.TestMixin
import grails.test.mixin.integration.IntegrationTestMixin

@TestMixin(IntegrationTestMixin)
class AutotimestampTests {
    
    void testAutotimestamp() {
        def category = new Category(name:'example', description:'testing this')
        category.save(flush:true)
        assert category.dateCreated != null
        assert category.lastUpdated != null
    }

    void testAutotimestampNoFlush() {
        def category = new Category(name:'example', description:'testing this')
        category.save()
        assert category.dateCreated != null
        assert category.lastUpdated != null
    }
    
}

package autoflush

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import spock.lang.Shared
import spock.lang.Specification

class AutoflushSpec extends Specification {
    @Shared
    ItemRemoteControl itemRemoteControl = new ItemRemoteControl()
    
    def "should save changes without flushing"() {
        given:
            def item = itemRemoteControl.createItem(title:'My item', description:'description')
            RestBuilder rest = new RestBuilder()
            String newTitle = "title ${System.currentTimeMillis()}" 
        when:
            String url = "http://localhost:8080/gorm-test-app/autoFlush/updateItemTitle/${item.id}?title=${newTitle}"
            RestResponse response = rest.get(url)
        then:    
            response.status == 200
        when:
            def item2 = itemRemoteControl.findItemById(item.id)
        then:
            item.id == item2.id
            item2.title == newTitle
    }
}

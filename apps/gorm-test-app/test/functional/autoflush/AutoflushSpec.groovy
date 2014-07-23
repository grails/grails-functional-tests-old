package autoflush

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class AutoflushSpec extends Specification {
    @Shared
    ItemRemoteControl itemRemoteControl = new ItemRemoteControl()
    
    @Unroll
    def "should save changes when testing mode is #mode (0-autosave,1-save-noflush,2-save&flush)"(int mode) {
        given:
            def item = itemRemoteControl.createItem(title:'My item', description:'description')
            RestBuilder rest = new RestBuilder()
            String newTitle = "title ${System.currentTimeMillis()}" 
        when:
            String url = "http://localhost:8080/gorm-test-app/autoFlush/updateItemTitle/${item.id}?title=${newTitle}&mode=${mode}"
            RestResponse response = rest.get(url)
        then:    
            response.status == 200
        when:
            def item2 = itemRemoteControl.findItemById(item.id)
        then:
            item.id == item2.id
            item2.title == newTitle
        where:
            mode << [0, 1, 2]
    }
}

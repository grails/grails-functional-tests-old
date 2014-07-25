package autoflush

import grails.plugin.remotecontrol.RemoteControl

class ItemRemoteControl {
    RemoteControl remote = new RemoteControl()

    Item createItem(Map params) {
        remote {
            new Item(params).save(flush:true)
        }
    }
    
    Item findItemById(long id) {
        remote {
            Item.get(id)
        }
    }
}

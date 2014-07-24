package autoflush

import grails.transaction.NotTransactional
import grails.transaction.Transactional

class AutoFlushController {
    @NotTransactional
    def updateItemTitle(int id, String title, int mode, boolean transactional) {
        if(transactional) {
            updateItemTitleInTransaction(id, title, mode)
        } else {
            doUpdateItemTitle(id, title, mode)
        }
    }
    
    @Transactional
    def updateItemTitleInTransaction(int id, String title, int mode) {
        doUpdateItemTitle(id, title, mode)
    }
    
    private def doUpdateItemTitle(int id, String title, int mode) {
        Item item = Item.get(id)
        item.title = title
        switch(mode) {
        case 1:
            item.save()
            break
        case 2:
            item.save(flush:true)
            break
        }
        render 'OK'
    }
}

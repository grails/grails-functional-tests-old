package autoflush

class AutoFlushController {

    def updateItemTitle(int id, String title, int mode) {
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

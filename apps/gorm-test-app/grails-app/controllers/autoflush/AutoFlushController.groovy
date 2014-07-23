package autoflush

class AutoFlushController {

    def updateItemTitle(int id, String title) {
        Item item = Item.get(id)
        item.title = title
        render 'OK'
    }
}

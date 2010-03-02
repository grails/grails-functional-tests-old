class ForwardController {

    def forwardToAction = {
        forward action: 'toAction'
    }

    def forwardWithParams = {
        forward action: 'showParams', id: 4, params: [author: 'Stephen King']
    }

    def showParams = {
        def sortedParams = new TreeMap(params)
        render sortedParams.toString()
    }

    def toAction = {
        render 'toAction output'
    }

    def forwardToOther = {
        forward controller: 'other', action: 'forwarded'
    }
}

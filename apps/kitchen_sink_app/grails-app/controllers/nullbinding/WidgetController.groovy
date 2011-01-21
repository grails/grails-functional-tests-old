package nullbinding

class WidgetController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [widgetInstanceList: Widget.list(params), widgetInstanceTotal: Widget.count()]
    }

    def create = {
        def widgetInstance = new Widget()
        widgetInstance.properties = params
        return [widgetInstance: widgetInstance]
    }

    def save = {
        def widgetInstance = new Widget(params)
        if (widgetInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'widget.label', default: 'Widget'), widgetInstance.id])}"
            redirect(action: "show", id: widgetInstance.id)
        }
        else {
            render(view: "create", model: [widgetInstance: widgetInstance])
        }
    }

    def show = {
        def widgetInstance = Widget.get(params.id)
        if (!widgetInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'widget.label', default: 'Widget'), params.id])}"
            redirect(action: "list")
        }
        else {
            [widgetInstance: widgetInstance]
        }
    }

    def edit = {
        def widgetInstance = Widget.get(params.id)
        if (!widgetInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'widget.label', default: 'Widget'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [widgetInstance: widgetInstance]
        }
    }

    def update = {
        def widgetInstance = Widget.get(params.id)
        if (widgetInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (widgetInstance.version > version) {
                    
                    widgetInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'widget.label', default: 'Widget')] as Object[], "Another user has updated this Widget while you were editing")
                    render(view: "edit", model: [widgetInstance: widgetInstance])
                    return
                }
            }
            widgetInstance.properties = params
            if (!widgetInstance.hasErrors() && widgetInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'widget.label', default: 'Widget'), widgetInstance.id])}"
                redirect(action: "show", id: widgetInstance.id)
            }
            else {
                render(view: "edit", model: [widgetInstance: widgetInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'widget.label', default: 'Widget'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def widgetInstance = Widget.get(params.id)
        if (widgetInstance) {
            try {
                widgetInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'widget.label', default: 'Widget'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'widget.label', default: 'Widget'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'widget.label', default: 'Widget'), params.id])}"
            redirect(action: "list")
        }
    }
}

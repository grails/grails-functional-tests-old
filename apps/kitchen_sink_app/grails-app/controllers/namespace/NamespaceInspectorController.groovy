package namespace

class NamespaceInspectorController {
    
    def containsBean(String beanName) {
        render "Contains bean '${beanName}'? ${grailsApplication.mainContext.containsBean(beanName)}"
    }

    def generateLinksToNamespacedControllers() {
    }
}

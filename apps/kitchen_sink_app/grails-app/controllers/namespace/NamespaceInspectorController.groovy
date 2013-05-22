package namespace

class NamespaceInspectorController {
    
    def containsBean(String beanName) {
        render "Contains bean '${beanName}'? ${grailsApplication.mainContext.containsBean(beanName)}"
    }

    def generateLinksToNamespacedControllers() {
    }

    def redirectToPrimary() {
        redirect controller: 'namespaced', namespace: 'primary'
    }

    def redirectToSecondary() {
        redirect controller: 'namespaced', namespace: 'secondary'
    }

    def redirectToNonNamespaced() {
        redirect controller: 'namespaced'
    }
}

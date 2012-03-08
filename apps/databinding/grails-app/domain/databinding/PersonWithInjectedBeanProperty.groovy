package databinding

class PersonWithInjectedBeanProperty {
    String name
    String state
    String zip
    // spring injected bean...
    Widget widget
    
    static transients = ['widget']
    
    static constraints = {
        state bindable: false
    }
}

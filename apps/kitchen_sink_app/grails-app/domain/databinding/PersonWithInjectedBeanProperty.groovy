package databinding

class PersonWithInjectedBeanProperty {
    String name
    String state
    String zip
    // spring injected bean...
    Widget widget
    Address homeAddress
    
    static transients = ['widget']
    
    static constraints = {
        state bindable: false
    }
}

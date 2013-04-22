package databinding

import org.grails.databinding.BindingFormat

class PersonWithInjectedBeanProperty {
    String name
    String state
    String zip
    // spring injected bean...
    Widget widget
    Address homeAddress

    @BindingFormat('MMddyyyy')
    Date birthDate
    
    static transients = ['widget']
    
    static constraints = {
        state bindable: false
    }
}

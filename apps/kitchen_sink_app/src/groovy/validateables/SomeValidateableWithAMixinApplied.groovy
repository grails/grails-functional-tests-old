package validateables

@Mixin(Widget)
@grails.validation.Validateable
class SomeValidateableWithAMixinApplied {
    
    String title
    
    static constraints = {
        title matches: /[A-Z].*/
    }
}
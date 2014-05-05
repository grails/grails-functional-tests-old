import spock.lang.Issue
import spock.lang.Specification
import grails.test.mixin.support.GrailsUnitTestMixin

@TestMixin(GrailsUnitTestMixin)
class DontLoadExternalBeansSpec extends Specification {
    @Issue("GRAILS-11373")
    void "should not load external beans"(){
        expect:
        applicationContext.containsBean('simpleBean') == false
    }
}

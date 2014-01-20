import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.web.ControllerUnitTestMixin
import org.codehaus.groovy.grails.plugins.databinding.DataBindingGrailsPlugin

@TestFor(Foo)
@TestMixin(ControllerUnitTestMixin)
class FooSpec extends Specification {

    def setup(){
        //defineBeans(new DataBindingGrailsPlugin().doWithSpring)
    }

    void "test validation"(){
        when:
        def foo = new Foo(name:'')
        foo.validate()

        then:
        foo.errors.errorCount == 1
        foo.errors['name'].code == 'blank'
    }
}

import databinding.Widget
import transactions.JavaService

// Place your Spring DSL code here
beans = {
    javaService(JavaService) { bean ->
        bean.autowire = true
    }
    
    widget(Widget) {
        name = 'Good Name'
    }
}

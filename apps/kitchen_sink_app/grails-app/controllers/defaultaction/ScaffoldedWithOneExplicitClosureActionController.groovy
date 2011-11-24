package defaultaction

class ScaffoldedWithOneExplicitClosureActionController {
    
    static scaffold = gorm.Child
    
    def test = {
        render 'Rendered by the ScaffoldedWithOneExplicitClosureActionController.test closure action'
    }
}
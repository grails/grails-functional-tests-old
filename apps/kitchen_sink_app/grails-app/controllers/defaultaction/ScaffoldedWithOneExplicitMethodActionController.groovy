package defaultaction

class ScaffoldedWithOneExplicitMethodActionController {
    
    static scaffold = gorm.Child
    
    def test() {
        render 'Rendered by the ScaffoldedWithOneExplicitMethodActionController.test method action'
    }
}
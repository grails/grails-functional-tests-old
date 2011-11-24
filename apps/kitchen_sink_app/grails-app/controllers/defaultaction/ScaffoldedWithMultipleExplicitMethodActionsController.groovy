package defaultaction

class ScaffoldedWithMultipleExplicitMethodActionsController {
    
    static scaffold = gorm.Child
    
    def one() {
        render 'Rendered by the ScaffoldedWithMultipleExplicitMethodActionsController.one method action'
    }
    
    def two() {
        render 'Rendered by the ScaffoldedWithMultipleExplicitMethodActionsController.two method action'
    }
}
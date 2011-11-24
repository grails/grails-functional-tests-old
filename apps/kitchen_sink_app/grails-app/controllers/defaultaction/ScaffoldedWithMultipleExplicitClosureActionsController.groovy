package defaultaction

class ScaffoldedWithMultipleExplicitClosureActionsController {
    
    static scaffold = gorm.Child
    
    def one = {
        render 'Rendered by the ScaffoldedWithMultipleExplicitClosureActionsController.one closure action'
    }
    
    def two = {
        render 'Rendered by the ScaffoldedWithMultipleExplicitClosureActionsController.two closure action'
    }
}
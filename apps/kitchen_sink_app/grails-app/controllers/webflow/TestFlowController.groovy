package webflow

class TestFlowController {

    def myFlow = { 
		first {
			on("go").to "next"
		}
		
		next {
			action {
				def next = getNextStep()
				"$next"()
			}
			on("one").to "end"
		}
		
		end()
	}
	
	def webFlowTestService
	def secondFlow = {
		first {
			on("go").to "next"
		}
		
		next {
			action {
				def next = webFlowTestService.getNextStep()
				"$next"()
			}
			on("one").to "end"
		}
		
		end()		
	}
	
	def getNextStep() { "one" }
	
	def shoppingCartFlow = {
        start {
            action {
            }
            on('success').to 'showCart'
        }
        
        showCart {
            on('finish').to 'submitOrder'
        }
        
        submitOrder {
            redirect action: 'list'
        }
    }
    
    def list = {
        render 'this is the list action'
    }
    
}

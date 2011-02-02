package filters

class FilterDemoController {
    
    def index = {
        forward action: 'doit'
    }
    
    def doit = {
        render "action name in filter: ${params.actionNameInFilter}"
    }
    
    def showLoggerNames = {
        render "Alpha Logger Name: ${params.alphaFilterLoggerName} <br/> Beta Logger Name: ${params.betaFilterLoggerName}"
    }

    def aaa = {
        render view: 'showFilterResults', model: params
    }

    def abc = {
        render view: 'showFilterResults', model: params
    }
}
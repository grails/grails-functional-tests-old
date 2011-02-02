package filters

class AnotherFilterDemoController {

    def aaa = {
        render view: 'showFilterResults', model: params
    }

    def abc = {
        render view: 'showFilterResults', model: params
    }
}
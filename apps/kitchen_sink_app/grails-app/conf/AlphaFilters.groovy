class AlphaFilters {
    def filters = {
        grails6077(controller: '*', action: '*') {
            before = { 
                params.alphaFilterLoggerName = log.name
            }
        }
    }
}
class BetaFilters {
    def filters = {
        grails6077(controller: '*', action: '*') {
            before = { 
                params.betaFilterLoggerName = log.name
            }
        }
    }
}
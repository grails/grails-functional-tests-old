class ExceptionHandlingFilters {

    def filters = {
        all(controller:'testFilters', action:'*') {
            before = {
                throw new CustomRuntimeException("Exception in filter")
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}

package gsp

class GspContentTypeController {

    def jsonFromGsp() {
        response.contentType = 'application/json;charset=UTF-8'
        [:]
    }
    
    def jsonFromGsp2() {
        [:]
    }
}

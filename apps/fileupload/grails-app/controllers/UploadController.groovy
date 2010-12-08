class UploadController {

    def index = {}

    def testUpload = {
        def file = request.getFile("myFile")

        render "upload = ${file!=null}"
    }

    def bindEmptyDateStart = {}

    def bindEmptyDate = {
        def file = request.getFile("myFile")

        def content = new StringBuilder()

        def instance = new TheDomain(params)
        if (instance.save(flush: true)) {
            content.append 'Save true; '
        }
        else {
            println instance.errors
            content.append 'Save false; '
        }

        content.append "upload: ${file!=null}"

        render content.toString()
    }
}


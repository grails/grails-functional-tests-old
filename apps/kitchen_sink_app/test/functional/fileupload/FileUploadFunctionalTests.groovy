package fileupload

import functionaltestplugin.FunctionalTestCase

class FileUploadFunctionalTests extends FunctionalTestCase {

    void testUploadFile() {
        get('/upload/index')
        assertStatus 200

        form('myForm') {
            myFile.data = "some text".bytes
            myFile.contentType = "text/plain"
            click "Upload"
        }

        assertStatus 200
        assertContentContains "upload = true"
    }

    void testBindEmptyDateWithUploadFile() {

        get('/upload/bindEmptyDateStart')
        assertStatus 200

        form('myForm') {
            myFile.data = "some text".bytes
            myFile.contentType = "text/plain"

            thedate_month = ""
            thedate_day = ""
            thedate_year = ""
            thedate = "date.struct"
            thename = 'foo'

            click "Upload"
        }

        assertStatus 200
        assertContentContains 'Save true; upload: true'
    }
}


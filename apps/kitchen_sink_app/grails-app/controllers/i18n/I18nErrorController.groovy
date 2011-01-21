package i18n

class I18nErrorController { 

     def pageNotFound = {
        [exception: request.exception]
    }

}

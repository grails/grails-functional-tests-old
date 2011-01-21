import transactions.JavaService

// Place your Spring DSL code here
beans = {
    javaService(JavaService) { bean ->
        bean.autowire = true
    }
    localeChangeInterceptor(org.springframework.web.servlet.i18n.LocaleChangeInterceptor) {
		paramName = 'language22'
	}
}

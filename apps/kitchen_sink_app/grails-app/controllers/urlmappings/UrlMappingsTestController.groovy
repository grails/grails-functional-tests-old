package urlmappings

class UrlMappingsTestController {

    def index = { 
		render "working"
	}
	
	def testAbsolutePaths = {}
	
	def testExtension = {
		render "${params.file}.${params.ext}"
	}
	
	def dynaVariable = {
		render "variable = ${params.id}"
	}
	
	def declaredParams = {
		render "params = ${params.var}"
	}
	
	def decode = {
		render "decoded = ${params.myparam}"
	}
}

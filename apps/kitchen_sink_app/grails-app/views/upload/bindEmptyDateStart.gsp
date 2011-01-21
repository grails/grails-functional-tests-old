<html>

	<head>
		<title>Welcome to Grails</title>
		<meta name="layout" content="main" />
	</head>

	<body>
		<g:uploadForm name="myForm" action="bindEmptyDate">
		<input type="file" name="myFile" /><br />
		<input type='text' name='thename'/><br/>
		<g:datePicker name="thedate" precision="day" value='${null}' noSelection="['': '']" /><br/>
		<g:submitButton name="Upload"></g:submitButton>
		</g:uploadForm>
	</body>

</html>


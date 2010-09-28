<html>

<head>
  <title>Command object namespacing demo</title>
</head>

<body>
  <g:form name="commandForm" action="multi">
    <label for="a.name">A - Name</label><br/>
    <g:textField name="a.name" value="${a.name}"/><br/>

    <label for="b.query">B - Query</label><br/>
    <g:textField name="b.query" value="${b.query}"/><br/>

    <label for="name">C - Name</label><br/>
    <g:textField name="c.name" value="${c.name}"/><br/>

    <label for="query">D - Query</label><br/>
    <g:textField name="d.query" value="${d.query}"/><br/>

    <br/>
    <g:submitButton name="save" value="Process"/>
  </g:form>
</body>

</html>

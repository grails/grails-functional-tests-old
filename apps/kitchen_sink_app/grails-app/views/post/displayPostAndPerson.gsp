<html>
<head>
<meta name="layout" content="main"/>
<title>Display Post And Person</title>
</head>
<body>
<h2>Message: ${post.message}</h2>
<h2>Author: ${post.author}</h2>
<h2>Person Name: ${post.person?.name}</h2>
   <g:hasErrors bean="${post}">
       <div class="errors">
           <g:renderErrors as="list" bean="${post}"></g:renderErrors>
       </div>
   </g:hasErrors>

</body>
</html>

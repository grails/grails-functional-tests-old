<html>
<head>
<meta name="layout" content="main"/>
</head>
<body>
<h2>Business Name: ${business.name}</h2>
<h2>Number Of Addresses: ${business.addresses?.size()}</h2>

Addresses:
<ul>
<g:each var="address" in="${business.addresses}">
<li>${address.city}, ${address.state}</li>
</g:each>
</ul>
</body>
</html>

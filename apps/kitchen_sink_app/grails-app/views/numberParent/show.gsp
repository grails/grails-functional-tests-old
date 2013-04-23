
<%@ page import="databinding.NumberParent" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'parent.label', default: 'Parent')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-parent" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-parent" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list parent">
			
				<g:if test="${parentInstance?.child}">
				<li class="fieldcontain">
					<span id="child-label" class="property-label"><g:message code="parent.child.label" default="Child" /></span>
					
						<span class="property-value" aria-labelledby="child-label"><g:link controller="child" action="show" id="${parentInstance?.child?.id}">${parentInstance?.child?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${parentInstance?.someIds}">
				<li class="fieldcontain">
					<span id="someIds-label" class="property-label"><g:message code="parent.someIds.label" default="Some Ids" /></span>
					
						<span class="property-value" aria-labelledby="someIds-label"><g:fieldValue bean="${parentInstance}" field="someIds"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${parentInstance?.id}" />
					<g:link class="edit" action="edit" id="${parentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

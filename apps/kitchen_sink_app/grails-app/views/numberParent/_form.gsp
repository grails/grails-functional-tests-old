<%@ page import="databinding.NumberParent" %>



%{--<div class="fieldcontain ${hasErrors(bean: parentInstance, field: 'child', 'error')} required">--}%
	%{--<label for="child">--}%
		%{--<g:message code="parent.child.label" default="Child" />--}%
		%{--<span class="required-indicator">*</span>--}%
	%{--</label>--}%
	%{--<g:select id="child" name="child.id" from="${sample.Child.list()}" optionKey="id" required="" value="${parentInstance?.child?.id}" class="many-to-one"/>--}%
%{--</div>--}%

<div class="fieldcontain ${hasErrors(bean: parentInstance, field: 'someIds', 'error')} ">
	<label for="child.someOtherIds">
        <g:message code="parent.child.label" default="Child Ids" />
        <g:select name="child.someOtherIds" from="${1..5}" value="${parentInstance.child?.someOtherIds}"
                  noSelection="['':'-Choose-']"/>
	</label>
    <label for="someIds">
        <g:message code="parent.child.label" default="Parent Ids" />
        <g:select name="someIds" from="${1..5}" value="${parentInstance.someIds}"
                  noSelection="['':'-Choose-']"/>
    </label>
</div>


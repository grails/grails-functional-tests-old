<%@page defaultCodec="HTML" %>
<!DOCTYPE html>
<html>
        <head>
                <title><g:layoutTitle default="Grails"/></title>
                ${raw(headtags)}
                <g:layoutHead/>
                <style type="text/css">${raw(styles)}</style>
        </head>
        <body>
            ${raw(msg)}
            <g:layoutBody/>
            escaped:${msg}
            escaped:${msg2}
        </body>
</html>

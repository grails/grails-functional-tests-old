<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" 
%><c:forEach var="i" begin="1" end="10"><c:out value="${i}" /></c:forEach
><fmt:setLocale value="en_US"/><fmt:formatNumber value="${12.3}" pattern="0.00"/>
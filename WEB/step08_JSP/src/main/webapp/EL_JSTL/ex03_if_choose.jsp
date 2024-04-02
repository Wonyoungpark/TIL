<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>&lt;c:if> and &lt;c:choose> </h3>
<%--url에 age값이 있으면 출력, 없으면 --%>
<%--${not empty param.age ? "<h2>당신의 나이는 ".concat(age).concat("입니다.</h2>"):"no age"}--%>
<c:if test="${not empty param.age}">
    <h2 style="color: red">당신의 나이는 ${param.age}살입니다.</h2>
    <c:choose>
        <c:when test="${param.age>18}">
            <h4 style="color:blue;">성인입니다. 많은 이용 부탁드려요.</h4>
        </c:when>
        <c:otherwise>
            <h4 style="color: gray">미성년자이므로 서비스를 이용할 수 없습니다.</h4>
        </c:otherwise>
    </c:choose>
</c:if>
<hr>
</body>
</html>

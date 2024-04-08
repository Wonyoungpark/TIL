<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:choose>
    <c:when test="${not empty sessionScope.sessionId}">
        ${sessionId}님 로그인 중<br>
        <p>[접속시간 : ${creationTime}]</p>
        <a href="${rootPath}/logout">로그아웃</a>
    </c:when>
    <c:otherwise>
        <form method="post" action="${pageContext.request.contextPath}/login">
            ID : <input type="text" name="userId"><br>
            PWD : <input type="password" name="userPwd"><br>
            <input type="submit" value="로그인">
            <input type="reset" value="취소">
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>

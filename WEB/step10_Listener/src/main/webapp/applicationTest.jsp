<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>나라정보 : ServletContextListener TEST</h3>
\${applicationScope.nationMap} = ${applicationScope.nationMap}<br><br>

<h4>[현재 접속자 수 : ${applicationScope.nowCounter} 명]</h4>

<fieldset>
    <legend>나라 선택</legend>
    <c:forEach items="${nationMap}" var="nation">
        <input type="radio" name="nation" value="${nation.key}">${nation.value}
    </c:forEach>
</fieldset>
</body>
</html>

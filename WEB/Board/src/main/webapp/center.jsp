<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<table>
    <caption><h3>Board LIST</h3></caption>
    <tr>
        <th>순서</th>
        <th>글번호</th>
        <th>제목</th>
        <th>내용</th>
    </tr>
    <c:forEach items="${applicationScope.boardList}" var="board" varStatus="state">
        <tr>
            <td>${state.count}</td>
            <td>${board.no}</td><!--board.getNo()호출-->
            <td>${board.subject}</td>
            <td>${board.content}</td>
        </tr>
    </c:forEach>
</table>
<hr>

<c:if test="${not empty sessionScope.sessionId}">
    <form action="${pageContext.request.contextPath}/board" method="post">
        글번호 : <input type="text" name="no"><br>
        제목 : <input type="text" name="subject"><br>
        내용 : <textarea rows="5" cols="20" name="context"></textarea><br>
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </form>
</c:if>
</body>
</html>

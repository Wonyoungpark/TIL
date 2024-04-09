<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Web MVC Refactoring TEST</h1>
<h3>
    <a href="${pageContext.request.contextPath}/front?key=select">검색하기</a>
    <a href="${pageContext.request.contextPath}/front?key=update">수정하기</a>
    <a href="${pageContext.request.contextPath}/front?key=delete">삭제하기</a>
    <a href="${pageContext.request.contextPath}/front?key=insert">등록하기</a>
</h3>
</body>
</html>
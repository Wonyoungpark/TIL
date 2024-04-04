<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>action include TEST</h2>
<%
    String addr ="서울시 강남구";
%>

<%--top.jsp 연결  --%>
<jsp:include page="top.jsp"/>

<h3>main field</h3>
<hr>

<%--footer.jsp 연결--%>
<jsp:include page="footer.jsp">
    <jsp:param name="message" value="good"/>
    <jsp:param name="addr" value="<%=addr%>"/>
</jsp:include>
</body>
</html>

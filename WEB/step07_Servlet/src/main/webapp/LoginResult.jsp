<%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 3/29/24
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1><%=request.getParameter("userName")%>님 로그인 중입니다.
<%--아이디 : <%=request.getParameter()%>--%>
    <% out.println("yes");%>
</h1>
</body>
</html>

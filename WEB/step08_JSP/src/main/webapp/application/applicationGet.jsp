<%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 4/1/24
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ServletContext 정보 가져오기</h1>
<h3>
    메시지 : <%=application.getAttribute("message")%><br>
    메시지 : <%=application.getAttribute("addr")%><br>
</h3>
<a href="../session/sessionGet.jsp">sessionGet.jsp 이동</a>
</body>
</html>

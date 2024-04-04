<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  //jsp에서는 application을 내장객체를 사용할 수 있다.
  //servlet-context는 서버를 끄기 전까지는 계속 사용할 수 있다.
  String message = application.getInitParameter("message");
  String name = application.getInitParameter("name");
  out.print("message = "+message+"<br>");
  out.print("name = "+name+"<br>");
%>
</body>
</html>

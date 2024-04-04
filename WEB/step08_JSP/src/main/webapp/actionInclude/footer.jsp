<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>footer.jsp</h3>
message : ${param.message}<br>
<h4>주소 : <%=request.getParameter("addr")%> / ${param.addr}</h4>
</body>
</html>

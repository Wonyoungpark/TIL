<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>TITLE</title>
</head>
<body>
<h3>Cookie 정보 가져오기 : application 폴더 내부</h3>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        out.println("쿠키 개수 : " + cookies.length + "<p>");
        for (Cookie co : cookies) {
            String name = co.getName();
            String value = co.getValue();

            out.print(name + " = " + value + "<br>");
        }
    } else out.println("쿠키 정보가 없습니다.");
%>

</body>
</html>

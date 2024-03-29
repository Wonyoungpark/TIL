<%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 3/29/24
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        h1 {
            color: red
        }
    </style>
    <script type="text/javascript">
        alert("hello jsp");
    </script>
</head>
<body>
<%--스크립트릿 요소로 java coding 영역--%>
<%!
    String name;

    public String test() {
        System.out.println("test print");
        return "테스트";
    }
%>
<h1>Java Server Page Start</h1>
<h3>이름 : <%=name%>
</h3>
<%
    int age = 10;

    String re = this.test();
    out.println("<h3>호출결과 : " + re + "</h3>");
%>
<h3>이름 : <%=age%>
</h3>
</body>
</html>

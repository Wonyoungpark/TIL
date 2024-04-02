<%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 4/2/24
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--변수 선언--%>
<c:set var="age" value="20" scope="session"/>
<c:set var="addr" value="오리" scope="application"/>

아이디 : ${id} / <c:out value="${id}"/><br>
나이 : ${age} / ${sessionScope.age} / <c:out value="${age}"/><br>
주소 : ${addr} / ${applicationScope.addr} / <c:out value="${addr}"/>

<p>
    <a href="ex02_result.jsp">이동</a>
</p>
<%
    String name="길동";
//    request.setAttribute("name",name); //저장하는게 있어야 사용할 수 있음
%>
<%--scope에 저장된 것만 꺼내 쓸 수 있다. 선언했다고 사용가능한게 아니다.--%>
이름 : ${name}
</body>
</html>

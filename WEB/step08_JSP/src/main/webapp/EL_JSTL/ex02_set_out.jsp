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
<h3>JSTL - &lt;c:set> and &lt;c:out></h3>
<c:out value="안녕"/> / ${"안녕"}<br>
<c:out value="<h3>안녕</h3>" /> / ${"<h3>안녕</h3>"} /
<c:out value="<h3>안녕</h3>" escapeXml="false"/>

<hr>

<%--변수 선언--%>
<c:set var="id" value="hong"/>
<c:set var="age" value="20" scope="session"/>
<c:set var="addr" value="오리" scope="application"/>

아이디 : ${id} / <c:out value="${id}"/><br>
나이 : ${age} / ${sessionScope.age} / <c:out value="${age}"/><br>
주소 : ${addr} / ${applicationScope.addr} / <c:out value="${addr}"/>

<p>
    <a href="ex02_result.jsp">이동</a>
</p>

</body>
</html>

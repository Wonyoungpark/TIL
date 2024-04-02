<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>&lt;c:forEach> TEST </h3>
<c:forEach var="i" begin="1" end="10">
    ${i}<br>
</c:forEach>
<hr>

<jsp:useBean id="bean" class="ex0401.dto.ForEachBean"/>
names : ${bean.names}<br>
menus : ${bean.menus}<br>
boardList : ${bean.boardList}<br>
map : ${bean.map}
<hr>
<br>

<%--names selectbox 출력--%>
<select name="name">
    <option value="0">--선택--</option>
    <c:forEach items="${bean.names}" var="n" varStatus="state">
        <option value="${state.count}">${n}</option>
    </c:forEach>
</select>
<br><br><br>

<%--menus checkbox 출력--%>
<fieldset>
    <legend>메뉴 선택</legend>
    <c:forEach items="${bean.menus}" var="menu">
        <input type="checkbox" name="menu" value="${menu}">${menu}
    </c:forEach>
</fieldset>
<br>

<%--boardLsit table 출력--%>
<table border="1">
    <tr>
        <th>no</th>
        <th>subject</th>
        <th>content</th>
    </tr>
    <c:forEach items="${bean.boardList}" var="board">
        <tr>
            <td>${board.no}</td>
            <td>${board.subject}</td>
            <td>${board.content}</td>
        </tr>
    </c:forEach>
</table>
<br>

<%--map radio 출력--%>
<c:forEach items="${bean.map}" var="map">
    <input type="radio" value="${map}">${map.value}
</c:forEach>

</body>
</html>

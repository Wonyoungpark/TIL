<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <%--3. 값이 전송되었다면 폼에 출력--%>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
        $(function (){ //jQuery
            if("${not empty param.job}"){ //EL
                <%--$("form").html("<h3>${param.name}, ${param.job}");--%>
                $("[name=job]").val(${param.job});
            }
        });
    </script>
</head>
<body>
<h3>&lt;c:choose> TEST</h3>
<form action="ex04_choose.jsp">
    이름 : <input type="text" name="name"><br>
    선택 :
    <select name="job">
        <option value="0">--선택</option>
        <option value="개발자">개발자</option>
        <option value="디자이너">디자이너</option>
        <option value="DBA">DBA</option>
        <option value="기획자">기획자</option>
    </select>
    <input type="submit" value="전송"/>
</form>

<%--1. name&job이 전송되면 출력--%>
<c:if test="${not empty param.name and not empty param.job}">
    <h3>${param.name}님 직업은 ${param.job=="0" ? "없습니다." : param.job+="입니다."}</h3>

    <%--2. 개발자 종류에 따른 메시지 출력--%>
    <c:choose>
        <c:when test="${param.job=='개발자'}">멋진 개발자</c:when>
        <c:when test="${param.job=='디자이너'}">멋진 디자이너</c:when>
        <c:when test="${param.job=='DBA'}">멋진 DBA</c:when>
        <c:when test="${param.job=='기획자'}">멋진 기획자</c:when>
        <c:otherwise>무직</c:otherwise>
    </c:choose>
</c:if>

</body>
</html>

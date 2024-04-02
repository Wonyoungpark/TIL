<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <script src="../../js/jquery-3.6.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a").click(function () {
                //로그아웃 페이지로 이동해서 모든 세션 삭제
                if (confirm("로그아웃하시겠습니까?")) {
                    <%--                <%%>--%>// 불가능-> 동적페이지가 먼저 작동하기 때문에 정적코드는 작동을 안하고 스킵한다.
                    location.href = "../../logout";
                }
            });
        });
    </script>

</head>
<body>

<c:choose>
    <c:when test="${not empty sessionScope.sessionId}">
        <h3>
                ${sessionName} (${sessionName})님 로그인 중입니다. [접속시간 : ${creationTime} ]
        </h3>
        <img src="images/bin.jpg">
        <a href="#">로그아웃</a>
    </c:when>
    <c:otherwise>
        <script type="text/javascript">
            alert("인증하고 이용해주세요.");
            location.href = "LoginForm.html";
        </script>
    </c:otherwise>
</c:choose>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    response.setHeader("Cache-Control", "no-store");--%>

<%--    //세션의 유효시간 설정--%>
<%--    session.setMaxInactiveInterval(30);//30seconds--%>
<%--%>--%>
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

<%=session.getMaxInactiveInterval()%>초

<%
    if (session.getAttribute("sessionId") != null) { //인증된 사용자일 경우
%>
<h3>
    <%=session.getAttribute("sessionName")%>
    (<%=session.getAttribute("sessionId") %>)님 로그인 중
    [접속시간 : <%=session.getAttribute("creationTime") %> ]
</h3>
<img src="images/bin.jpg"><p>

    <a href="#">로그아웃</a>

        <%
  }else{
	  %>
    <script type="text/javascript">
        alert("인증하고 이용해주세요.");
        location.href="LoginForm.html";
    </script>
        <%
  }
%>
</body>
</html>

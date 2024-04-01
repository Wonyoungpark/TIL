<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>정보 확인하기</h1>
<h3>
    HttpServletRequest에 저장된 정보 조회하기
    <p>
        아이디 : <%=request.getAttribute("id")%><br>
        나이 : <%=request.getAttribute("age")%><br>
    </p>

    HttpSession에 저장된 정보 조회하기
    <p>
        메시지 : <%=session.getAttribute("message")%><br>
        아이디 : <%=session.getAttribute("id")%><br>
    </p>
</h3>

<h1>ServletContext 정보 가져오기</h1>
<h3>
    메시지 : <%=application.getAttribute("message")%><br>
    메시지 : <%=application.getAttribute("addr")%><br>
</body>
</html>

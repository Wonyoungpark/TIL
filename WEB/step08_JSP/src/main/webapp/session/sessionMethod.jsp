<%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 4/1/24
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>HTTP SESSION : Session Method</h1>
<h3>
    session.getId() = <%=session.getId()%><br>
    session.isNew() = <%=session.isNew()%><br>
    session.getMaxInactiveInterval() = <%=session.getMaxInactiveInterval()%><br>
    session.getCreationTime() = <%=session.getCreationTime()%><br>
    session.getLastAccessedTime() = <%=session.getLastAccessedTime()%><br>

    <%
        //request 정보 저장 : 페이지 이동 시 삭제 (request가 유지될 때만, if, forward 방식으로 이동-> 정보유지 가능)
        request.setAttribute("id", "hong");
        request.setAttribute("age", 20);

        //session 정보 저장 : 브라우저가 유지(동일 브라우저) => 정보 유지
        session.setAttribute("message", "Http Session에 저장");
        session.setAttribute("id", "gil");
    %>
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
<a href="sessionGet.jsp">정보 확인 : jsp 이동</a>
<a href="../sessionServlet">정보 확인 : servlet 이동</a>

<%
    //forward 방법으로 이동 -> request 정보 남아있음
    // WAS에서 이미 이동했기 때문에 43-44줄 실행 안됨
    request.getRequestDispatcher("sessionGet.jsp").forward(request,response);
%>
</body>
</html>

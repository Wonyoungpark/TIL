<%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 4/1/24
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%--  ServletContext 객체 : 서버 start시 생성, 서버 stop까지 유지
  : scope 중 가장 오래 지속되는 영역 ( request<session<application )--%>
  <h1>ServletContext : application ( 프로젝트 당 1개 생성 )</h1>
  <h3>
    application.getRealPath("/") : <%=application.getRealPath("/")%><br>
    application.getContextPath() : <%=application.getContextPath()%><br>

    <%
      //application에 정보
      application.setAttribute("message","MESsAGE");
      application.setAttribute("addr","경기도 성남시 분당구 오리역");
    %>
    메시지 : <%=application.getAttribute("message")%><br>
    메시지 : <%=application.getAttribute("addr")%><br>
  </h3>
  <a href="applicationGet.jsp">확인하기</a>
  </body>
</html>

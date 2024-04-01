<%@ page import="exam0329.vo.UserVO" %><%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 4/1/24
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>POST RESULT</h1>
<h3>
    message : <%=request.getAttribute("message")%><br>
    info : <%=request.getAttribute("info")%><br>
    user : <%=request.getAttribute("user")%><br>
    <%
        UserVO user = (UserVO) request.getAttribute("user");
    %>
    이름 : <%=user.getName()%><br>
    이메일 : <%=user.getEmail()%><br>
    성별 : <%=user.getGender()%><br>
    취미 : <%=
for(String h:user.getHobbys()){
%>
    <input type="checkbox" name="hobby" value="<%=h%>"> <%=h%>
    <%
        }
    %><br>
    좋아하는 것 : <%=user
    .
    getFavorites
    (
    )%><br>
    기타 : <%=user
    .
    getDesc
    (
    )%><br>
</h3>
</body>
</html>

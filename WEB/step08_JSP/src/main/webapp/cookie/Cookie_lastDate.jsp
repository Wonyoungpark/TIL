<%@ page import="java.util.Date" %>
<%@ page import="java.time.Year" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();

    long milisec = System.currentTimeMillis();
    Date nowTime = new Date(milisec);
    SimpleDateFormat time = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");

    if(cookies==null){
        out.println("당신은 처음 방문하셨습니다.<br>");
    }else{
        Date lastTime = new Date(Long.parseLong(cookies[cookies.length-1].getValue()));
        out.println("당신의 마지막 접속일은 "+time.format(lastTime)+"<br>");
    }
    Cookie cookie = new Cookie("lastDate", Long.toString(milisec));

    cookie.setMaxAge(60*60);
    cookie.setPath("/");
    response.addCookie(cookie);

    out.println("현재 접속 시간 : ");
    out.println(time.format(nowTime) + "<br>");
    out.println("다시 저장된 시간 : "+milisec);
%>
<%--${cookie.lastDate}--%>
<fmt:formatDate value="${nowTime}" pattern="yyyy-MM-dd"/>
</body>
</html>

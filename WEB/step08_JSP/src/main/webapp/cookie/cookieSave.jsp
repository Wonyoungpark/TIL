<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cookie</title>
</head>
<body>
<h3>Cookie : 서버가 클라이언트(PC)에 정보를 저장하는 기술</h3>
<%
    //필요한 쿠키 생성
    Cookie c1 = new Cookie("id", "1234test");
    Cookie c2 = new Cookie("age", "20");

    // 옵션 설정
    c1.setMaxAge(60 * 60 * 24); //60초*60분*24시간 //1일
    c2.setMaxAge(60*60*24*365); //1년

    c1.setPath("/"); //쿠키 접근 경로 설정

    //쿠키 저장
    response.addCookie(c1);
    response.addCookie(c2);
%>

<a href="cookieGet.jsp">쿠키 확인</a>
</body>
</html>

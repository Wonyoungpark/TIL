<%@page import="java.util.concurrent.atomic.AtomicInteger" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--<%--%>
<%--    //Servlet Context는 무조건 하나 생성--%>
<%--    //서버가 죽지 않는 이상 계속 살아있다. => Servlet Context를 저장소 역할로 사용(공통적으로 사용되는 정보 저장)--%>
<%--    //1. 기존 count 값을 읽어온다. (application영역에 저장된...)--%>
<%--    Object obj = application.getAttribute("count");//application에 count정보 저장--%>

<%--    //2. 만약 1의 값이 null이라면 기본 0으로 세팅(저장)!!!--%>
<%--    if (obj == null) { //저장 기록이 없다면--%>
<%--        application.setAttribute("count", 0);--%>
<%--        obj = application.getAttribute("count");--%>
<%--    }--%>

<%--    //3. 읽어온 데이터에 +1을 해서 다시 저장하고 화면에 출력한다.--%>
<%--    int count = (int) obj;--%>

<%--    if (session.isNew()) { //접속 기록이 없는 새로운 유저라면--%>
<%--        count++;--%>
<%--        application.setAttribute("count", count);--%>
<%--    }--%>

<%--%>--%>

<%
    //1. 기존 count 값을 읽어온다. (application영역에 저장된...)
    Object obj = application.getAttribute("count");//application에 count정보 저장

    //2. 만약 1의 값이 null이라면 기본 0으로 세팅(저장)!!!
//    AtomicInteger : 숫자를 자동으로 증감. 동기화가 되어있음. 멀티스레드 환경에서 주로 사용
    if (obj == null) {
        application.setAttribute("count", new AtomicInteger()); //AtomicInteger는 초기값이 0부터 시작
        obj = application.getAttribute("count");
    }

    //3. 읽어온 데이터에 +1을 해서 다시 저장하고 화면에 출력한다.
    AtomicInteger at = (AtomicInteger) obj;
    int count = at.intValue();

    if (session.isNew()) { //접속 기록이 없는 새로운 유저라면
        count = at.incrementAndGet(); //증가
    }

%>

<h3>방문자 수 : <%=count%> 명</h3>


</body>
</html>
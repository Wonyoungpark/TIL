<%--
  Created by IntelliJ IDEA.
  User: holly
  Date: 4/2/24
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>



<h3>EL(Expression Language) 표현언어</h3>
\${5} = ${5}<br>
\${5+2} = ${5+2}<br>
\${5*2} = ${5*2}<br>
\${5 gt 3} = ${5 gt 3}<br>
\${5 < 3} = ${5<3}<br>
\${"hi"} = ${"hi"}<br>
\${"hungry"} = ${"hungry"}
<hr>

\${5 gt 3 && 10 eq 10} = ${5 gt 3 && 10 eq 10}<br>
\${5 gt 3 and 10 eq 10} = ${5 gt 3 and 10 eq 10}<br>
\${5 gt 3 || 10 eq 10} = ${5 gt 3 || 10 eq 10}<br>
\${5 gt 3 or 10 eq 10} = ${5 gt 3 or 10 eq 10}<br>

\${5 gt 3 ? "크다":"작다"} = ${5 gt 3 ? "크다":"작다"}
<hr>

<%--url parameter에 name이 존재하지 않으면 guest로 출력--%>
<%--<%--%>
<%--    String name = request.getParameter("name");--%>
<%--    if(name==null) out.println("Guest");--%>
<%--    else out.println(name);--%>
<%--%>--%>
결과 :
${param.name==null ? "Guest" : param.name} /
${empty param.name ? "Guest" : param.name}

<%--age>18 성인, 아니면 미성년자 출력--%>
나이 : ${param.age}살 / ${param.age>18 ? "성인":"미성년자"}
<hr>

<%--문자 연결--%>
${empty param.name ? "Guest" : param.name+="님"}
${empty param.name ? "Guest" : param.name.concat("님")}

<%--request session application 영역에 저장된 정보 EL 출력--%>
<%
    //scope에 저장
    request.setAttribute("id", "hong");
    request.setAttribute("age", 10);

    session.setAttribute("message", "session 메시지");
    session.setAttribute("addr", "오리역");

    application.setAttribute("message", "application 메시지");
    application.setAttribute("info", "점심");
%>
<h4>scope 정보 가져오기</h4>
아이디 : <%=request.getAttribute("id")%> / ${requestScope.id} / ${id}<br>
나이 : <%=request.getAttribute("age")%> / ${requestScope.age} / ${age}<br>

메시지 : <%=session.getAttribute("message")%> / ${requestScope.message} / ${message}<br>
주소 : <%=session.getAttribute("addr")%> / ${requestScope.addr} / ${addr}<br>

메시지 : <%=application.getAttribute("message")%> / ${applicationScope.message} / ${message}<br>
info : <%=application.getAttribute("info")%> / ${applicationScope.info} / ${info}<br><hr>

<%--자바 객체의 메소드 표현언어로 호출--%>
<%--p = new ProductDTO(); 생성과 동일--%>
<jsp:useBean id="p" class="ex0401.dto.ProductDTO"/>
code:<%=p.getCode()%> / ${p.code} <%--p.getCode() 호출--%><br>
name: ${p.name}<br>
qty: ${p.qty}<br>
price: ${p.price}<br>
총 금액(qty*price) : ${p.qty*p.price}<br> / <fmt:formatNumber value="${p.qty*p.price}"/><br>
</body>
</html>

<%@page import="kosta.dto.MemberDTO" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style>
        table {
            width: 100%;
            border: 5px double red
        }

        th, td {
            padding: 5px;
            border: 1px solid pink;
            text-align: center
        }

        a {
            text-decoration: none
        }
    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("[value=삭제]").click(function () {
                if (confirm("삭제하시겠습니까?")) {
                    //DOM 접근을 이용해서 클릭
                    let idV = $(this).parent().parent().find("td:eq(1)").text();
                    location.href = "${pageContext.request.contextPath}/delete?id=" + idV; //JSTL EL
                }
            })
        })
    </script>

</head>

<body>


<div style="text-align: center">
    <h1>[ 회원 정보 LIST ]</h1>
    <table cellspacing="0">
        <tr>
            <th colspan="9" style="text-align:right">
                <a href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
                <a href="index.jsp">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
            </th>
        </tr>
        <tr bgColor="pink">
            <th>번호</th>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>나이</th>
            <th>주소</th>
            <th>연락처</th>
            <th>가입일</th>
            <th>삭제</th>
            <th>수정</th>
        </tr>

        <!--데이터 가져오기-->
        <c:choose>
            <c:when test="${empty list}">
                <tr>
                    <th colspan="9">검색된 정보가 없습니다.</th>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${requestScope.list}" var="member" varStatus="state">
                    <tr>
                        <td>${state.index}</td>
                        <td><a href="read?id=${member.id}">${member.id}</a></td>
                        <td>${member.pwd}</td>
                        <td>${member.name}</td>
                        <td>${member.age}</td>
                        <td>${member.addr}</td>
                        <td>${member.phone}</td>
                        <td>${member.joinDate} /
                                <%--                DB에서 가져온 String을 날짜형식으로 변환--%>
                            <fmt:parseDate value="${member.joinDate}" pattern="yyyy-MM-dd HH:mm:ss" var="fmtDate"/>
                                <%--                    Date 타입을 string 형태로 변환--%>
                            <fmt:formatDate value="${fmtDate}" pattern="yyyy-MM-dd HH"/></td>
                            <%--                <form method="post" action="delete">--%>
                            <%--                    <input type="hidden" name="id" value="${member.id}">--%>
                            <%--                    <td><input type="submit" name="delete" value="삭제"></td>--%>
                            <%--                </form>--%>
                        <td><input type="submit" name="delete" value="삭제"></td>
                        <form method="get" action="update">
                            <input type="hidden" name="id" value="${member.id}">
                            <td><input type="submit" name="update" value="수정"></td>
                        </form>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
    <p>

    <form name="search" action="${pageContext.request.contextPath}/search" method="post">
        <select name="keyField">
            <option value="0">--선택--</option>
            <option value="id">아이디</option>
            <option value="name">이름</option>
            <option value="addr">주소</option>
        </select>

        <input type="text" name="keyWord"/>
        <input type="submit" value="검색"/>

    </form>


</div>


</body>
</html>





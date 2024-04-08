<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table {border: 5px groove pink; width:500px}
  td,th{border:1px black solid ;  padding:10px}

  input{border:solid 1px gray}
  
</style>
</head>
<body>


<table cellspacing="0" align="center">
   <caption><h2> 님 회원정보 </h2></caption>
  <tr>
	<td width="100px">ID</td>
	<td width="400px">${requestScope.member.id}</td>
  </tr>
  <tr>
	<td>PWD</td>
	<td>${requestScope.member.pwd}</td>
  </tr>
  <tr>
	<td>NAME</td>
	<td>${requestScope.member.name}</td>
  </tr>
  <tr>
	<td>age</td>
	<td>${requestScope.member.age}</td>
  </tr>
  <tr>
	<td>Phone</td>
	<td>${requestScope.member.phone}</td>
  </tr>
  <tr>
	<td>Addr</td>
	<td>${requestScope.member.addr}</td>
  </tr>
  <tr>
	<td>JoinDate</td>
	<td>${requestScope.member.joinDate}</td>
  </tr>
  <tr>
	<td colspan="2" style="text-align: center;background-color: pink">
	  <a href="index.jsp">홈으로</a>
	</td>
	
  </tr>
  </table> 

</body>
</html>







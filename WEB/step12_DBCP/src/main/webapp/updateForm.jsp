<%@page import="kosta.dto.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
  table {border: 5px groove pink; width:500px}
  td,th{border:1px black solid ;  padding:10px}

  input{border:solid 1px gray}
  
</style>
    <script type="text/javascript">
        //전송 버튼 클릭시 유효성 체크 & 값을 모두 받아왔는지

    </script>
</head>
<body>

<form method="post" action="update">

<table cellspacing="0" align="center">
   <caption><h2> 수정 Form</h2></caption>
  <tr>
	<td width="100px">ID</td>
	<td width="400px"><input type="text" name="id" value="${requestScope.member.id}" readonly /></td>
  </tr>
  <tr>
	<td>PWD</td>
	<td><input type="password" name="pwd" value="${requestScope.member.pwd}" /></td>
  </tr>
  <tr>
	<td>NAME</td>
	<td><input type="text" name="name" value="${requestScope.member.name}" readonly/></td>
  </tr>
  <tr>
	<td>age</td>
	<td><input type="text" name="age" value="${requestScope.member.age}" /></td>
  </tr>
  <tr>
	<td>Phone</td>
	<td><input type="text" name="phone" value="${requestScope.member.phone}" /></td>
  </tr>
  <tr>
	<td>Addr</td>
	<td><input type="text" name="addr" size="50" value="${requestScope.member.addr}" /></td>
  </tr>
  <tr>
	<td colspan="2" style="text-align: center;background-color: pink">
	<input type="submit" value="수정" />
	<input type="reset" value="취소" />
	</td>
	
  </tr>
  </table> 
</form>
</body>
</html>







<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="login">
    ID : <input type="text" name="userId"><br>
    PWD : <input type="password" name="userPwd"><br>
    <input type="submit" value="로그인">
    <input type="reset" value="취소">
</form>
</body>
</html>

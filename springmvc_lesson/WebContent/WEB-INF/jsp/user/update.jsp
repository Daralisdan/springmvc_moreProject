<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- form标签 -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户</title>
</head>
<body>
	<!-- modelAttribute="user"自动把表单中的值添加到user表中 -->
	<sf:form method="post" modelAttribute="user">
	Username：<sf:input type="text" path="username" />
		<sf:errors path="username"></sf:errors>
		<br />
	password:<sf:input type="password" path="password" />
		<sf:errors path="password"></sf:errors>
		<br />
	nickname:<sf:input type="text" path="nickname" />
		<br />
	Emalie:<sf:input type="text" path="email" />
		<sf:errors path="email"></sf:errors>
		<br />
		<input type="submit" value="修改用户" />
	</sf:form>
</body>
</html>
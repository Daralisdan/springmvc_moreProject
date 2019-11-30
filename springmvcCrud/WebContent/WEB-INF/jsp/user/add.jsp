<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
</head>
<body>
	<!--没有写action，直接提交给/add
 modelAttribute="user",自动把表单中的值添加到user表中 -->
	<sf:form method="post" modelAttribute="user"
		enctype="multipart/form-data">
 Username：<sf:input path="username" />
		<br />
 Password：<sf:password path="password" />
		<br />
 Nickname：<sf:input path="nickname" />
		<br />
 Email：<sf:input path="email" />
		<br />
 Attach:<input type="file" name="attachs" />
		<br />
		<input type="file" name="attachs" />
		<br />
		<input type="file" name="attachs" />
		<br />
		<input type="submit" value="添加用户">
	</sf:form>
</body>
</html>
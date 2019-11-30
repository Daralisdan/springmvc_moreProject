<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>详细信息列表</title>
</head>
<body>
	<!--没有写action，直接提交给/add
 modelAttribute="user",自动把表单中的值添加到user表中 -->
 Username：${user.username }
		<br />
 Password：${user.password }
		<br />
 Nickname：${user.nickname }
		<br />
 Email：${user.email }
		<br />
</body>
</html>
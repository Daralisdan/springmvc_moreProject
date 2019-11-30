<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 加标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
</head>
<body>
	<a href="add">添加用户</a>---->${loginUser.nickname}
	
	<br/>
	<c:forEach items="${users}" var="um">
	${um.value.username}
	------------------->${um.value.password}
	-------------------><a href="${um.value.username}"> ${um.value.nickname}</a>
	------------------->${um.value.email}----><a href="${um.value.username}/update">修改</a>
	<a href="${um.value.username}/delete">删除</a>
	<br />
	</c:forEach>
</body>
</html>
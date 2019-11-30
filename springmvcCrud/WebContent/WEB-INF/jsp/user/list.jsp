<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 加标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<!-- 增加样式表 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css">
</head>
<body>
	<a href="add">添加</a>---->${loginUser.nickname}
	<br />
	<!-- 因为users中是键值对所以var中不用user改为um -->
	<c:forEach items="${users}" var="um">
	${um.value.username }
	-------${um.value.password }
	-------<a href="${um.value.username}">${um.value.nickname }</a>
	-------${um.value.email } &nbsp <a href="${um.value.username }/update">修改</a>
	<a href="${um.value.username }/delete">删除</a><br />
	</c:forEach>
</body>
</html>
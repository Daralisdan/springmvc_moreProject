<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib  prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="get" modelAttribute="car">
	Type:<sf:input path="type"/><br/>
	Color:<sf:input path="color"/><br/>
	Wheels:<sf:input path="wheels"/><br/>
	People:<sf:input path="people"/><br/>
	<input type="submit" value="修改用户"/>
	</sf:form>
</body>
</html>
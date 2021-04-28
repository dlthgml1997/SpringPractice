<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="userform" method="get" action="${root}/result2">
		이름 <input name="name">
		나이 <input name="age">
		직업 <input name="job">
		<input type="submit"/>
	</form>
</body>
</html>
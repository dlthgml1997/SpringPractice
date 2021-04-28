<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<form action="${root }/calcresult" method="get">
		<input name="su1"> 
		<select name="oper">
			<option name="+">+</option>
			<option name="-">-</option>
			<option name="/">/</option>
			<option name="*">*</option>
		</select>
		<input name="su2">
		<input type="submit" value="계산">
	</form>
	<hr>
${msg }
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>환영합니다</title>
</head>
<body>
<%@ include file="header.jsp" %>
<a href="${root }/product/regist"> 상품 등록 </a> <br>
<a href="${root }/product/list"> 상품 목록 </a> <br>
<a href="${root }/product/controll"> 상품 관리 </a>
</body>
</html>

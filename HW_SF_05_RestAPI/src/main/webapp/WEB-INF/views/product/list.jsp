<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1 align="center">상품 목록</h1>
<table class="table table-active">
<tr class="table-info">
	        <td colspan="2">아이디</td>
	        <td colspan="2">이름</td>
	        <td colspan="2">가격</td>
	        <td colspan="2">설명</td>
	      </tr>
	<c:if test="${products.size() != 0 }">
		<c:forEach var="product" items="${products}">
		    <tbody>
	 	      <tr>
		        <td colspan="2" class="table-danger"><strong>${product.id}</strong></td>
		        <td colspan="2" class="table-danger"><strong>${product.name}</strong></td>
		        <td colspan="2" class="table-danger"><strong>${product.price}</strong></td>
		        <td colspan="2" class="table-danger"><strong>${product.description}</strong></td>
		      </tr>
		    </tbody>
		</c:forEach>
	</c:if>
</table>
</body>
</html>
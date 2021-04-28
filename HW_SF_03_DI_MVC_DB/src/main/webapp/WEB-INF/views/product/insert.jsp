<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SSAFY-글작성</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
 /*  $(document).ready(function() {
	  $("#writeBtn").click(function() {
			if($("#subject").val() == "") {
				alert("제목 입력!!!");
				return;
			} else if($("#content").val() == "") {
				alert("내용 입력!!!");
				return;
			} else {
				$("#writeform").attr("action", "${root}/article/write").submit();
			}
		});
	}); */
  </script>
</head>
<body>
<%@ include file="../header.jsp" %>
	<%-- <div class="col-lg-6" align="right">
	<strong>${userinfo.username}</strong>님 환영합니다.
	<a href="${root}/user/logout">로그아웃</a>
	</div> --%>
	<div class="col-lg-6" align=center">
		<h2>상품 등록</h2>
	</div>
		<form action="${root }/product/regist" method="post">
			아이디: <input name="id"></input><br>
			상품명: <input name="name"></input><br>
			가격: <input name="price"></input><br>
			설명: <input name="description"></input>
			<input type="submit">
		</form> <br>
		<a href="${root }/product/list">목록 보기 </a>
</body>
</html>
<%-- </c:if> --%>
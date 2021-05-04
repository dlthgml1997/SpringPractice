<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>

<script>
	$(function() {
		// selectAll - 상품 리스트 
		$('#selectAll').click(function() {
			// type, url, data, dataType, success, error
			reselectAll();
			$('#status').empty();
			$('#status').append("조회 성공");
		});
		
		// select - 상품 정보 폼에 상품 하나를 표시.
		$(document).on("click", ".idlist", function() {
			let id = $(this).attr("id");
			
			$.ajax({
				url:'/rest/select/'+ id,
				type: 'GET',
				success: function(data) {
					$("#id").val(data.id);
					$("#name").val(data.name);
					$("#price").val(data.price);
					$("#description").val(data.description);
				}
			});
		});
		
		// insert - 상품 삽입
		$('#insert').click(function() {
			$.ajax({
				url: '/rest/insert',
				type: 'POST',
				data: {
					id:$('#form [id=id]').val(),
					name:$('#form [id=name]').val(),
					price:$('#form [id=price]').val(),
					description:$('#form [id=description]').val()
				},
				statusCode: {
					200: function(data) {
						$('#status').empty();
						reselectAll();
						$('#status').append("추가 성공");
					},
					500: function(data) {
						$('#status').empty();
						reselectAll();
						$('#status').append("오류 발생");
					}
				}
			});
		});
		
		// update - 상품 수정
		$('#update').click(function() {
			var jsondata = {
					"id":  $('#form [id=id]').val(),
					"name": $('#form [id=name]').val(),
					"price": $('#form [id=price]').val(),
					"description":  $('#form [id=description]').val()
			};
			
			$.ajax({
				url: '/rest/update',
				type: 'PUT',
				contentType: 'application/json; charset=UTF-8',
				dataType: 'json',
				data: JSON.stringify(jsondata),
				success: function(data) {
					$('#status').empty();
					if(data == 0) $('#status').append("오류 발생");
					else $('#status').append("수정 성공");
					reselectAll();
				}
			});
		});

		// delete - 상품 삭제
		$('#delete').click(function() {
			let id = $('#id').val();
			$.ajax({
				url : '/rest/delete/' + id,
				type : 'DELETE',
				contentType : 'application/json; charset=UTF-8',
				success : function(data) {
					$('#status').text("삭제 성공");
					$('#id').val("");
					$('#name').val("");
					$('#price').val("");
					$('#description').val("");
					reselectAll();
				}
			});
		});

		function reselectAll() {
			$.ajax({
				url : '/rest/selectAll',
				type : 'GET',
				success : function(data) {
					let html = '';
					$(data).each(function(index, product) {
							html += ` <li id = '${'${product.id}'}' class = 'idlist'> ${'${product.id}'} </li>`;
					});
					$('#list').empty();
					$('#list').append(html);
				}
			});
		}
	});
</script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<h1 align="center">상품 관리</h1>
	<button id="selectAll">목록조회</button>
	<div>
		<ul id="list">

		</ul>
	</div>
	<div>
		<button id="insert">추가</button>
		<button id="update">수정</button>
		<button id="delete">삭제</button>
	</div>

	<div id="form">
		<table border="1" >
			<tr>
				<td bgcolor="lightgrey">ID</td>
				<td><input id="id"></input></td>
			</tr>
			<tr>
				<td bgcolor="lightgrey">이름</td>
				<td><input id="name"></input></td>
			</tr>
			<tr>
				<td bgcolor="lightgrey">가격</td>
				<td><input id="price"></input></td>
			</tr>
			<tr>
				<td colspan="2"><textarea id="description"> </textarea></td>
			</tr>
		</table>

		<div id="status"></div>
	</div>


</body>
</html>
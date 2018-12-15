<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh mục</title>
<base href="${pageContext.servletContext.contextPath}/">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link href="resources/css/style.css" rel="stylesheet">
<link rel="icon" href="resources/images/img-4.png" type="image/gif"
	sizes="16x16">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="_patterns/_header.jsp"></jsp:include>
		<main> <jsp:include page="_patterns/_menu.jsp"></jsp:include> </main>
		<section class="top-db">
			<div class="container-fluid">
				<div class="row">
					<div class="title-db">
						<h2>Dashboard</h2>
					</div>
					<img class="banner-dashboard" src="resources/images/banner-1.jpg"
						alt="">
				</div>
			</div>
		</section>
		<br>
		<section class="box-funtion">
			<div class="container">
				<div class="row">
					<form action="dashboard/issue" method="post">
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 search-tb">
							<input name="seri" class="form-control" id="searchBox"
								type="text" placeholder="Nhập số thẻ">
						</div>
					</form>
				</div>
			</div>
		</section>
		<br>
		<section class="tb-box">
			<form style="padding: 20px;" action="dashboard/issue" method="post">
				<c:if test="${not empty c}">
					<table>
						<tr>
							<td>Số thẻ:</td>
							<td>${c.seri }</td>
							<td>Tên người dùng:</td>
							<td>${c.fullname }</td>
						</tr>
						<tr>
							<td>Số điện thoại:</td>
							<td>${c.user.phone }</td>
							<td>Email:</td>
							<td>${c.user.email }</td>
						</tr>
						<tr>
							<td>Lớp:</td>
							<td>${c.user.classroom }</td>
							<td>Loại thẻ:</td>
							<td>${c.card.name }</td>
						</tr>
						<tr>
							<td>Ngày tạo:</td>
							<td>${c.dateCreate }</td>
							<td>Ngày hết hạn:</td>
							<td>${c.dateExpire }</td>
						</tr>
						<tr>
							<td>Trạng thái:</td>
							<td>${c.status }</td>
							<td>Số sách có thể mươn:</td>
							<td>${c.loanTime }</td>
						</tr>
					</table>
				</c:if>
				<button class="btn btn-success" disabled="${disable }" type="submit">Mượn
					sách</button>
			</form>
		</section>
	</div>
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
</body>
</html>
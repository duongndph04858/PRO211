<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý nhà xuất bản</title>
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
					<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 search-tb">
						<input class="form-control" id="searchBox" type="text"
							placeholder="Search...">
					</div>
				</div>
			</div>
		</section>
		<br>
		<section class="tb-box">
			<table style="margin-top: 20px;" id="productTable" class="table">
				<thead class="thead-light">
					<tr>
						<th class="" scope="col">STT</th>
						<th scope="col">Mã Nhà xuất bản</th>
						<th scope="col">Tên Nhà xuất bản</th>
						<th scope="col">Trạng thái</th>
						<th scope="col">Địa chỉ</th>
						<th scope="col">Email</th>
						<th scope="col">Mô tả</th>
						<th class="" scope="col">Thao tác</th>
					</tr>
				</thead>
				<tbody id="table">
					<c:choose>
						<c:when test="${publisher != null }">
							<c:forEach var="c" items="${publisher}" varStatus="stt">
								<tr>
									<th scope="row">${stt.index+1 }</th>
									<td id="product-id">${c.id }</td>
									<td>${c.name}</td>
									<td><c:choose>
											<c:when test="${c.status == 1}">Đang hoạt động</c:when>
											<c:when test="${c.status == 2}">Đã đóng</c:when>
											<c:otherwise> Không xác định</c:otherwise>
										</c:choose></td>
									<td>${c.address}</td>
									<td>${c.email}</td>
									<td>${c.descriptions }</td>
									<td><a id="icon-update" href=""><i class="fas fa-pencil-alt icon-action"></i>
										&nbsp; <a id="icon-delete" class="dltProduct"
										data-id="${c.id }"> <i class="fas fa-trash-alt icon-action"
											data-toggle="modal" data-target="#deleteProductModal"
											aria-hidden="true"></i>
									</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h4>Danh mục hiện đang trống</h4>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</section>
	</div>
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
</body>
</html>
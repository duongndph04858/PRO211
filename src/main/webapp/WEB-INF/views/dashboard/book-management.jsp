<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sách</title>
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
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 btn-add"
						style="margin-left: 100px">
						<form>
							<input class="" type="file">
							<div class="btn btn-success">Thêm từ excel</div>
						</form>
					</div>


				</div>
			</div>
		</section>
		<br>
		<section class="tb-box">
			<table id="productTable" class="table">
				<thead class="thead-light">
					<tr>
						<th class="" scope="col">STT</th>
						<th scope="col">Tên sách</th>
						<th scope="col">Ảnh</th>
						<th scope="col">Danh mục</th>
						<th scope="col">Tác giả</th>
						<th scope="col">Giá tiền</th>
						<th scope="col">Giá để sách</th>
						<th scope="col">Số lượng</th>
						<th scope="col">Trạng thái</th>
						<th scope="col">Ngày thêm</th>
						<th scope="col">Mô tả</th>
						<th class="" scope="col">Thao tác</th>
					</tr>
				</thead>
				<tbody id="table">
					<c:choose>
						<c:when test="${books != null }">
							<c:forEach var="b" items="${books}" varStatus="stt">
								<tr>
									<th scope="row">${stt.index+1 }</th>
									<td id="product-id">${b.name }</td>
									<td><img src="resources/images/${b.images }" alt="" /></td>
									<td><c:forEach var="c" items="${b.category }">
									${c.categ.name}<c:if test="${b.category.size()>1 }">,</c:if>
										</c:forEach></td>
									<td>${b.author}</td>
									<td>${b.price}</td>
									<td>${b.bookshelf }</td>
									<td>${b.amount }</td>
									<td><c:choose>
											<c:when test="${b.status == 1}">Có thể mượn</c:when>
											<c:when test="${b.status == 2}">Đã mượn hết</c:when>
											<c:otherwise> Không xác định</c:otherwise>
										</c:choose></td>
									<td>${b.insertDate }</td>
									<td>${b.descriptions }</td>
									<td><a id="icon-update" href=""><i
											class="fas fa-pencil-alt icon-action"></i> &nbsp; <a
											id="icon-delete" class="dltProduct" data-id="${b.id }"> <i
												class="fas fa-trash-alt icon-action" data-toggle="modal"
												data-target="#deleteProductModal" aria-hidden="true"></i>
										</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h4>Thư viện hiện đang trống</h4>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</section>
	</div>
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
</body>
</html>
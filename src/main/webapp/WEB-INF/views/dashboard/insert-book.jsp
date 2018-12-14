<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<title>Thêm sách mới</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link href="resources/css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="resources/css/insert-product.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="_patterns/_header.jsp"></jsp:include>
		<main> <jsp:include page="_patterns/_menu.jsp"></jsp:include>
		<aside>
			<form action="dashboard/book/insert" enctype="multipart/form-data"
				method="post">
				<div style="margin-top: 100px;" class="container">
					<div style="padding-left: 12%"
						class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
						<div class="input-book">
							<div class="form-group">
								<label for="usr">Tên sách:</label> <input type="text"
									name="name" value="${book.name}" class="form-control" id="usr">
							</div>
							<div class="form-group">
								<label for="pwd">Tác giả:</label> <input type="text"
									name="author" value="${book.author}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Giá tiền:</label> <input type="text"
									name="price" value="${book.price}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Nhà xuất bản:</label> <input type="text"
									value="${book.publisher}" name="publisher" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Giá để sách:</label> <select name="bookshelf"
									class="form-control">
									<c:forEach var="s" items="${shelves }">
										<option value="${s.shelf }">${s.shelf }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="pwd">Số lượng:</label> <input type="text"
									name="amount" value="${book.amount}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Nguồn:</label> <input type="text"
									value="${book.provider}" name="provider" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Mô tả:</label> <input type="text"
									value="${book.descriptions}" name="descriptions"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Danh mục:</label>
								<div>
									<c:forEach var="c" items="${categories}">
										<div class="ct-checkbox">
											<input name="ctg" id="category${c.id}" type="checkbox"
												value="${c.id}" />&nbsp;<label for="category${c.id}">${c.name }</label>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>

					</div>
					<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
						<div class="img-product row">
							<diV class="img-border">
								<div id="img-thumb"></div>
							</div>
							<div class="img-upload">
								<input type="file" id="inputFile"
									onchange="updateImageDisplay();" name="image" class="w-100" />
							</div>
						</div>
					</div>

				</div>
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 button-function">
					<button type="submit" class="btn btn-primary">Thêm</button>
					<button class="btn btn-warning">Hủy</button>
				</div>
			</form>
		</aside>
		</main>
	</div>
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
	<script type="text/javascript" src="resources/js/imgPreview.js"></script>
</body>
</html>
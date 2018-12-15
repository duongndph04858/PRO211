<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<title>Thêm Thẻ mượn mới</title>
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
			<form action="dashboard/card/insert-card" enctype="multipart/form-data"
				method="post">
				<div style="margin-top: 100px;" class="container">
					<div style="padding-left: 12%"
						class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
						<div class="input-book">
							<div class="form-group">
								<label for="pwd">Username:</label> <input type="text"
									name="user" value="${cardT.user.username}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Họ và tên:</label> <input type="text"
									name="fullname" value="${cardT.fullname}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Loại thẻ:</label>
								<select name="cardtype" class="form-control">
								<c:forEach var="s" items="${cardtype }">
										<option value="${s. name}">${s.name}</option>
								</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="pwd">Tổng số sách mượn:</label> <input type="text"
									value="${cardT.loanTime}" name="loanTime" class="form-control">
							</div>
							<div class="form-group">
								<div class="form-group">
								<label for="pwd">Ngày tạo:</label> <input type="date"
									name="dateCreate" value="${cardT.dateCreate}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Ngày hết hạn:</label> <input type="date"
									name="dateExpire" value="${cardT.dateExpire}" class="form-control">
							</div>
							
							<div class="form-group">
								<label for="pwd">Mô tả:</label> <input type="text"
									value="${book.descriptions}" name="descriptions"
									class="form-control">
							</div>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sách mới</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="_patterns/_header.jsp"></jsp:include>
		<main> <jsp:include page="_patterns/_menu.jsp"></jsp:include>
		<aside>
			<div class="container">
				<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
					<form action="dashboard/insert">
						<div class="input-book">
							<div class="form-group">
								<label for="usr">Name:</label> <input type="text" name="name"
									value="${mng.obj.name}" class="form-control" id="usr">
							</div>
							<div class="form-group">
								<label for="pwd">Author:</label> <input type="text"
									name="author" value="${mng.obj.author}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Category:</label> <select name="category"
									class="form-control"></select>
							</div>
							<div class="form-group">
								<label for="pwd">Price:</label> <input type="text" name="author"
									value="${mng.obj.author}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Publisher:</label> <input type="text"
									value="${mng.obj.publisher}" name="publisher" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">BookShelf:</label> <input type="text"
									value="${mng.obj.shelf}" name="shelf" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Amount:</label> <input type="text"
									name="amount" value="${mng.obj.amount}" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Provider:</label> <input type="text"
									value="${mng.obj.provider}" name="provider" class="form-control">
							</div>
							<div class="form-group">
								<label for="pwd">Description:</label> <input type="text"
									value="${mng.obj.desciptions}" name="descriptions"
									class="form-control">
							</div>
						</div>
					</form>
				</div>
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
					<div class="img-product">
						<img src="resources/images/1.jpg" alt="">
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 button-function">
				<button class="btn btn-primary">Thêm</button>
				<button class="btn btn-warning">Hủy</button>
			</div>
		</aside>
		</main>
	</div>
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
</body>
</html>
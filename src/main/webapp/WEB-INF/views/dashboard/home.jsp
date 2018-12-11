<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link href="resources/css/style.css" rel="stylesheet">
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
		<section class="info-dashboard">
			<div class="container">
				<div class="row">
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<div class="dash-tile dash-tile-ocean clearfix animation-pullDown">
							<div class="dash-tile-header">
								<div class="dash-tile-options">
									<div class="btn-group">
										<a href="#" class="btn btn-default" data-toggle="tooltip"
											title="" data-original-title="Manage Users"><i
											class="fa fa-cog"></i></a> <a href="#" class="btn btn-default"
											data-toggle="tooltip" title=""
											data-original-title="Statistics"><i
											class="fa fa-bar-chart-o"></i></a>
									</div>
								</div>
								Tổng số sách
							</div>
							<div class="dash-tile-icon">
								<i class="fa fa-users"></i>
							</div>
							<div class="dash-tile-text">265k</div>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<div class="dash-tile dash-tile-ocean clearfix animation-pullDown">
							<div class="dash-tile-header">
								<div class="dash-tile-options">
									<div class="btn-group">
										<a href="#" class="btn btn-default" data-toggle="tooltip"
											title="" data-original-title="Manage Users"><i
											class="fa fa-cog"></i></a> <a href="#" class="btn btn-default"
											data-toggle="tooltip" title=""
											data-original-title="Statistics"><i
											class="fa fa-bar-chart-o"></i></a>
									</div>
								</div>
								Số lần mượn
							</div>
							<div class="dash-tile-icon">
								<i class="fa fa-users"></i>
							</div>
							<div class="dash-tile-text">265k</div>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<div class="dash-tile dash-tile-ocean clearfix animation-pullDown">
							<div class="dash-tile-header">
								<div class="dash-tile-options">
									<div class="btn-group">
										<a href="#" class="btn btn-default" data-toggle="tooltip"
											title="" data-original-title="Manage Users"><i
											class="fa fa-cog"></i></a> <a href="#" class="btn btn-default"
											data-toggle="tooltip" title=""
											data-original-title="Statistics"><i
											class="fa fa-bar-chart-o"></i></a>
									</div>
								</div>
								Tổng số người dùng
							</div>
							<div class="dash-tile-icon">
								<i class="fa fa-users"></i>
							</div>
							<div class="dash-tile-text">265k</div>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<div class="dash-tile dash-tile-ocean clearfix animation-pullDown">
							<div class="dash-tile-header">
								<div class="dash-tile-options">
									<div class="btn-group">
										<a href="#" class="btn btn-default" data-toggle="tooltip"
											title="" data-original-title="Manage Users"><i
											class="fa fa-cog"></i></a> <a href="#" class="btn btn-default"
											data-toggle="tooltip" title=""
											data-original-title="Statistics"><i
											class="fa fa-bar-chart-o"></i></a>
									</div>
								</div>
								Total Users
							</div>
							<div class="dash-tile-icon">
								<i class="fa fa-users"></i>
							</div>
							<div class="dash-tile-text">265k</div>
						</div>
					</div>
				</div>

			</div>
		</section>
		<section class="chart">
			<div class="container">
				<div class="row">
					<!-- Graph HTML -->
					<div id="graph-wrapper">
						<div class="graph-info">
							<a href="#" class="visitors">Visitors</a> <a href="#"
								class="returning">Returning Visitors</a> <a href="#" id="bars"><span></span></a>
							<a href="#" id="lines" class="active"><span></span></a>
						</div>

						<div class="graph-container">
							<div id="graph-lines"></div>
							<div id="graph-bars"></div>
						</div>
					</div>
					<!-- end Graph HTML -->
				</div>
			</div>

		</section>
	</div>
	<!--MODAL  -->
	<!--CATEGORY  -->
	<!-- Modal insert category -->
	<div class="modal" id="insertCategory">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Thêm danh mục mới</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<form action="insert-category">
					<!-- Modal body -->
					<div class="modal-body">
						<div class="form-group">
							<label for="categoryId">Mã danh mục:</label> <input type="text"
								name="id" value="${mng.obj.id}" class="form-control"
								id="categoryId">
						</div>
						<div class="form-group">
							<label for="categoryName">Tên danh mục:</label> <input
								type="text" name="name" value="${mng.obj.name}"
								class="form-control" id="categoryName">
						</div>
						<div class="form-group">
							<label for="cDescriptions">Mô tả:</label> <input type="text"
								name="descriptions" value="${mng.obj.descriptions}"
								class="form-control" id="cDescriptions">
						</div>
					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Thêm</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Hủy</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Modal update category -->
	<div class="modal" id="updateCategory">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Cập nhật danh mục</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<form action="update-category">
					<!-- Modal body -->
					<div class="modal-body">
						<div class="form-group">
							<label for="categoryId">Mã danh mục:</label> <input
								readonly="readonly" type="text" name="id" value="${mng.obj.id}"
								class="form-control" id="categoryId">
						</div>
						<div class="form-group">
							<label for="categoryName">Tên danh mục:</label> <input
								type="text" name="name" value="${mng.obj.name}"
								class="form-control" id="categoryName">
						</div>
						<div class="form-group">
							<label for="cDescriptions">Mô tả:</label> <input type="text"
								name="descriptions" value="${mng.obj.descriptions}"
								class="form-control" id="cDescriptions">
						</div>
					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Thêm</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Hủy</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--END CATEGORY  -->
	<!-- END -->
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
</body>
</html>
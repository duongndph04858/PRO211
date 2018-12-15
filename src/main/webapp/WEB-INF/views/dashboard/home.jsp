<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
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
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
</body>
</html>
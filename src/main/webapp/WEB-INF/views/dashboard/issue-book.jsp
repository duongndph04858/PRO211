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
		<section class="tb-box">
					<div class="cart-content">
			<div class="cart-nav-bar d-flex justify-content-between">
				<div class="cart-nav-item w-100">
					<a class="number-border-radius"> 1 </a> &nbsp; Giỏ hàng
				</div>
				<div class="canvas-arrow">
					<canvas id="first-triangle" width="25" height="50">
        </canvas>
				</div>
				<div class="cart-nav-item w-100">
					<a class="number-border-radius "> 2 </a> &nbsp; Thông tin giao hàng
				</div>
				<div class="canvas-arrow">
					<canvas id="second-triangle" width="25" height="50">
        </canvas>
				</div>
				<div class="cart-nav-item w-100 bg-success text-white">
					<a class="number-border-radius border-white"> 3 </a> &nbsp; Phương
					thức thanh toán
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
	<script>
		var c = document.getElementById("first-triangle");
		var ctx = c.getContext("2d");
		ctx.moveTo(0, 0);
		ctx.lineTo(25, 25);
		ctx.lineTo(0, 50);
		ctx.strokeStyle = "#aaa";
		ctx.stroke();
		var c = document.getElementById("second-triangle");
		var ctx = c.getContext("2d");
		ctx.beginPath();
		ctx.moveTo(0, 0);
		ctx.lineTo(25, 0);
		ctx.lineTo(25, 50);
		ctx.lineTo(0, 50);
		ctx.lineTo(25, 25);
		ctx.lineTo(0, 0);
		ctx.fillStyle = "#28a745";
		ctx.fill();
	</script>
</body>
</html>
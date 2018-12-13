<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sách</title>
	<base href="${pageContext.servletContext.contextPath}/">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<link href="resources/css/style.css" rel="stylesheet">
	<link rel="icon" href="resources/images/img-4.png" type="image/gif" sizes="16x16">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
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
		<section class="box-funtion">
				<div class="container">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 btn-add">
							<div class="btn btn-success">Thêm mới</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 search-tb">
							<div class="search-wrapper">
							<div class="input-holder">
								<input type="text" class="search-input" placeholder="Type to search" />
								<button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
							</div>
							<span class="close" onclick="searchToggle(this, event);"></span>
							</div>
						</div>
						
					</div>
				</div>
			</section>

			<section class="tb-box">
				<div class="limiter">
					<div class="container-table100">
						<div class="wrap-table100">
							<div class="table100 ver1 m-b-110">
								<div class="table100-head">
									<table>
										<thead>
											<tr class="row100 head">
												<th class="cell100 column1">Class name</th>
												<th class="cell100 column2">Type</th>
												<th class="cell100 column3">Hours</th>
												<th class="cell100 column4">Trainer</th>
												<th class="cell100 column5">Spots</th>
											</tr>
										</thead>
									</table>
								</div>

								<div class="table100-body js-pscroll">
									<table>
										<tbody>
											<tr class="row100 body">
												<td class="cell100 column1">Like a butterfly</td>
												<td class="cell100 column2">Boxing</td>
												<td class="cell100 column3">9:00 AM - 11:00 AM</td>
												<td class="cell100 column4">Aaron Chapman</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Mind & Body</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">8:00 AM - 9:00 AM</td>
												<td class="cell100 column4">Adam Stewart</td>
												<td class="cell100 column5">15</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Crit Cardio</td>
												<td class="cell100 column2">Gym</td>
												<td class="cell100 column3">9:00 AM - 10:00 AM</td>
												<td class="cell100 column4">Aaron Chapman</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Wheel Pose Full Posture</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">7:00 AM - 8:30 AM</td>
												<td class="cell100 column4">Donna Wilson</td>
												<td class="cell100 column5">15</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Playful Dancer's Flow</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">8:00 AM - 9:00 AM</td>
												<td class="cell100 column4">Donna Wilson</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Zumba Dance</td>
												<td class="cell100 column2">Dance</td>
												<td class="cell100 column3">5:00 PM - 7:00 PM</td>
												<td class="cell100 column4">Donna Wilson</td>
												<td class="cell100 column5">20</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Cardio Blast</td>
												<td class="cell100 column2">Gym</td>
												<td class="cell100 column3">5:00 PM - 7:00 PM</td>
												<td class="cell100 column4">Randy Porter</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Pilates Reformer</td>
												<td class="cell100 column2">Gym</td>
												<td class="cell100 column3">8:00 AM - 9:00 AM</td>
												<td class="cell100 column4">Randy Porter</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Supple Spine and Shoulders</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">6:30 AM - 8:00 AM</td>
												<td class="cell100 column4">Randy Porter</td>
												<td class="cell100 column5">15</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Yoga for Divas</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">9:00 AM - 11:00 AM</td>
												<td class="cell100 column4">Donna Wilson</td>
												<td class="cell100 column5">20</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Virtual Cycle</td>
												<td class="cell100 column2">Gym</td>
												<td class="cell100 column3">8:00 AM - 9:00 AM</td>
												<td class="cell100 column4">Randy Porter</td>
												<td class="cell100 column5">20</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Like a butterfly</td>
												<td class="cell100 column2">Boxing</td>
												<td class="cell100 column3">9:00 AM - 11:00 AM</td>
												<td class="cell100 column4">Aaron Chapman</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Mind & Body</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">8:00 AM - 9:00 AM</td>
												<td class="cell100 column4">Adam Stewart</td>
												<td class="cell100 column5">15</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Crit Cardio</td>
												<td class="cell100 column2">Gym</td>
												<td class="cell100 column3">9:00 AM - 10:00 AM</td>
												<td class="cell100 column4">Aaron Chapman</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Wheel Pose Full Posture</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">7:00 AM - 8:30 AM</td>
												<td class="cell100 column4">Donna Wilson</td>
												<td class="cell100 column5">15</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Playful Dancer's Flow</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">8:00 AM - 9:00 AM</td>
												<td class="cell100 column4">Donna Wilson</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Zumba Dance</td>
												<td class="cell100 column2">Dance</td>
												<td class="cell100 column3">5:00 PM - 7:00 PM</td>
												<td class="cell100 column4">Donna Wilson</td>
												<td class="cell100 column5">20</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Cardio Blast</td>
												<td class="cell100 column2">Gym</td>
												<td class="cell100 column3">5:00 PM - 7:00 PM</td>
												<td class="cell100 column4">Randy Porter</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Pilates Reformer</td>
												<td class="cell100 column2">Gym</td>
												<td class="cell100 column3">8:00 AM - 9:00 AM</td>
												<td class="cell100 column4">Randy Porter</td>
												<td class="cell100 column5">10</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Supple Spine and Shoulders</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">6:30 AM - 8:00 AM</td>
												<td class="cell100 column4">Randy Porter</td>
												<td class="cell100 column5">15</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Yoga for Divas</td>
												<td class="cell100 column2">Yoga</td>
												<td class="cell100 column3">9:00 AM - 11:00 AM</td>
												<td class="cell100 column4">Donna Wilson</td>
												<td class="cell100 column5">20</td>
											</tr>

											<tr class="row100 body">
												<td class="cell100 column1">Virtual Cycle</td>
												<td class="cell100 column2">Gym</td>
												<td class="cell100 column3">8:00 AM - 9:00 AM</td>
												<td class="cell100 column4">Randy Porter</td>
												<td class="cell100 column5">20</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
	</div>
	<jsp:include page="_patterns/_footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Library</title>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/clock.css">

</head>

<body>

	<div class="materialContainer">

		<div class="box">

			<div id="clock">
				<div id="hrMin"></div>
				<div id="sec"></div>
			</div>
			<div id="date"></div>

		</div>

		<div class="overbox">
			<form action="login">
				<div class="material-button alt-2">
					<span class="shape"><i class="fa fa-user"></i></span>
				</div>

				<div class="title">LOGIN</div>

				<div class="input">
					<label for="name">Username</label> <input type="text"
						name="username" id="name"> <span class="spin"></span>
				</div>

				<div class="input">
					<label for="pass">Password</label> <input type="password"
						name="password" id="pass"> <span class="spin"></span>
				</div>

				<div class="button login">
					<button type="submit">
						<span>GO</span> <i class="fa fa-check"></i>
					</button>
				</div>
			</form>
			<!-- <a href="" class="pass-forgot">Forgot your password?</a> -->

		</div>

	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="resources/js/index.js"></script>
	<script src="resources/js/clock.js"></script>
</body>
</html>
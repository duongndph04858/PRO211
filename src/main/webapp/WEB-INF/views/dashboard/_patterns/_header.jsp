<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<section>
	<div class="header white-bg">

		<!--logo start-->
		<a href="dashboard" class="logo"> LIBRA<span>RY<span><a
					class="logo" href="http://www.animatedimages.org/cat-books-53.htm"><img
						src="http://www.animatedimages.org/data/media/53/animated-book-image-0019.gif"
						border="0" alt="animated-book-image-0019" /></a></a>
		<!--logo end-->
		<!-- <div id="btn-menu" class="sidebar-toggle-box">
						<a href="#"></a> <i class="fas fa-book"></i></a>
					</div> -->
		<div class="top-nav ">
			<!--search & user info start-->
			<ul class="nav pull-right top-menu">
				<li><input type="text" class="form-control search"
					placeholder="Search"></li>
				<!-- user login dropdown start-->
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <img alt=""
						src="resources/images/avatar1_small.jpg"> <span
						class="username">${user.fullname }</span> <b class="caret"></b>
				</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>
						<li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
						<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
						<li><a href="#"><i class="fas fa-bell"></i>Notification</a></li>
						<li><a href="login.html"><i class="fa fa-key"></i> Log
								Out</a></li>
					</ul></li>
				<!--  <li class="sb-toggle-right">
		                        <i class="fa  fa-align-right"></i>
		                    </li> -->
				<!-- user login dropdown end -->
			</ul>
			<!--search & user info end-->
		</div>
	</div>
</section>
</html>
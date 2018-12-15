<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div id="btn-menu" class="sidebar-toggle-box bg-primary">
		<div class="w-50 nav-icon">
			<i class="fa fa-chevron-right fa-2" aria-hidden="true"></i>
		</div>
	</div>
	<div id="menu-toggle" class="menu">

		<ul class="accordion" id="accordion-1">
			<li class="dcjq-current-parent"><a class="parent-nav" href="#"><i
					class="fas fa-book"></i>Sách</a>
				<ul class="sub-menu">
					<li class="dcjq-current-parent"><a
						href="dashboard/management/book"><i class="fas fa-book-open"></i>Quản
							lý sách</a></li>
					<li class="dcjq-current-parent"><a
						href="dashboard/book/insert-book"><i class="fas fa-book-open"></i>Thêm
							mới sách</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Quản lý mượn-trả</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Báo cáo-thống kê</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Tìm kiếm</a></li>
				</ul></li>
			<li class="dcjq-current-parent"><a class="parent-nav" href="#"><i
					class="fas fa-book"></i>Danh mục</a>
				<ul class="sub-menu">
					<li class="dcjq-current-parent"><a
						href="dashboard/management/category"><i
							class="fas fa-book-open"></i>Quản lý danh mục</a></li>
					<li class="dcjq-current-parent"><a data-toggle="modal"
						data-target="#insertCategory"><i class="fas fa-book-open"></i>Thêm
							danh mục</a></li>
				</ul></li>
			<li class="dcjq-current-parent"><a class="parent-nav" href="#"><i
					class="fas fa-book"></i>Nhà xuất bản</a>
				<ul class="sub-menu">
					<li class="dcjq-current-parent"><a
						href="dashboard/management/publisher"><i
							class="fas fa-book-open"></i>Quản lý Nhà xuất bản</a></li>
					<li class="dcjq-current-parent"><a data-toggle="modal"
						data-target="#insertPublisher"><i class="fas fa-book-open"></i>Thêm
							Nhà xuất bản</a></li>
				</ul></li>
			<li class="dcjq-current-parent"><a class="parent-nav" href="#"><i
					class="fas fa-book"></i>Thẻ</a>
				<ul class="sub-menu">
					<li class="dcjq-current-parent"><a
						href="dashboard/management/card"><i class="fas fa-book-open"></i>Quản
							lý Thẻ</a></li>
					<li class="dcjq-current-parent"><a
						href="dashboard/card/insertcard"><i class="fas fa-book-open"></i>Thêm
							Thẻ mượn</a></li>
					<li class="dcjq-current-parent"><a
						href="dashboard/management/cardtype"><i
							class="fas fa-book-open"></i>Quản lý Loại thẻ</a></li>
					<li class="dcjq-current-parent"><a data-toggle="modal"
						data-target="#insertCardType"><i class="fas fa-book-open"></i>Thêm
							Loại thẻ</a></li>
				</ul></li>
		</ul>

		<!-- <ul class="accordion" id="accordion-1">
			<li class="dcjq-current-parent"><a class="parent-nav" href="#"><i
					class="fas fa-book"></i>Sách</a>
				<ul class="sub-menu">
					<li class="dcjq-current-parent"><a
						href="dashboard/management/book"><i class="fas fa-book-open"></i>Quản
							lý sách</a></li>
					<li class="dcjq-current-parent"><a
						href="dashboard/book/insert-book"><i class="fas fa-book-open"></i>Thêm
							mới sách</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Quản lý mượn-trả</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Báo cáo-thống kê</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Tìm kiếm</a></li>
				</ul></li>
			<li class="dcjq-current-parent"><a class="parent-nav" href="#"><i
					class="fas fa-book"></i>Danh mục</a>
				<ul class="sub-menu">
					<li class="dcjq-current-parent"><a
						href="dashboard/management/category"><i
							class="fas fa-book-open"></i>Quản lý danh mục</a></li>
					<li class="dcjq-current-parent"><a data-toggle="modal"
						data-target="#insertCategory"><i class="fas fa-book-open"></i>Thêm
							danh mục</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
				</ul></li>
			<li class="dcjq-current-parent"><a class="parent-nav" href="#"><i
					class="fas fa-book"></i>Products</a>
				<ul class="sub-menu">
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
				</ul></li>
			<li class="dcjq-current-parent"><a class="parent-nav" href="#"><i
					class="fas fa-book"></i>Products</a>
				<ul class="sub-menu">
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
					<li class="dcjq-current-parent"><a href="#"><i
							class="fas fa-book-open"></i>Product 1</a></li>
				</ul></li>
		</ul> -->
	</div>
</body>
</html>
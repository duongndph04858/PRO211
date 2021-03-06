<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!--MODAL  -->
<!--CATEGORY  -->
<!-- Modal insert category -->
<div class="modal" id="insertCategory">
	<div class="modal-dialog" style="width: 330px;">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Thêm danh mục mới</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<form action="dashboard/category/insert-category" method="post">
				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<label for="categoryId">Mã danh mục:</label> <input type="text"
							name="id" value="${mng.obj.id}" class="form-control"
							id="categoryId">
					</div>
					<div class="form-group">
						<label for="categoryName">Tên danh mục:</label> <input type="text"
							name="name" value="${mng.obj.name}" class="form-control"
							id="categoryName">
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
			<form action="dashboard/category/update-category">
				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<label for="categoryId">Mã danh mục:</label> <input
							readonly="readonly" type="text" name="id" value="${mng.obj.id}"
							class="form-control" id="categoryId">
					</div>
					<div class="form-group">
						<label for="categoryName">Tên danh mục:</label> <input type="text"
							name="name" value="${mng.obj.name}" class="form-control"
							id="categoryName">
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
					<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END CATEGORY  -->

<!-- Modal insert Publisher -->
<div class="modal" id="insertPublisher">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Thêm mới nhà xuất bản</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<form action="dashboard/publisher/insert-publisher">
				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<label for="publisherId">Mã Nhà xuất bản:</label> <input
							type="text" name="id" value="${mng.obj.id}" class="form-control"
							id="publisherId">
					</div>
					<div class="form-group">
						<label for="publisherName">Tên Nhà xuất bản:</label> <input
							type="text" name="name" value="${mng.obj.name}"
							class="form-control" id="publisherName">
					</div>
					<div class="form-group">
						<label for="publisherAddress">Địa chỉ:</label> <input type="text"
							name="address" value="${mng.obj.address}" class="form-control"
							id="publisherAddress">
					</div>
					<div class="form-group">
						<label for="publisherEmail">Email:</label> <input type="text"
							name="email" value="${mng.obj.email}" class="form-control"
							id="publisherEmail">
					</div>
					<div class="form-group">
						<label for="pDescriptions">Mô tả:</label> <input type="text"
							name="descriptions" value="${mng.obj.descriptions}"
							class="form-control" id="pDescriptions">
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Thêm</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END PUBLISHER  -->

<!-- Modal insert CardType -->
<div class="modal" id="insertCardType">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Thêm mới loại thẻ</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<form action="dashboard/cardtype/insert-cardtype">
				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<label for="cardtypeName">Tên Loại thẻ:</label> <input type="text"
							name="name" value="${mng.obj.name}" class="form-control"
							id="cardtypeName">
					</div>
					<div class="form-group">
						<label for="cardtypeLongevity">Hạn sử dụng (ngày):</label> <input
							type="text" name="longevity" value="${mng.obj.longevity}"
							class="form-control" id="cardtypeLongevity">
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
					<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END CARDTYPE  -->
<!-- END -->

<!-- Modal Notice -->
<c:if test="${not empty notices }">
	<div class="modal fade" id="modalNotice" tabindex="-1" role="dialog"
		aria-labelledby="modalNotice" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalNotice">Thông báo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h6>${notices}</h6>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>
</c:if>
<footer>
	<div class="container-fluid">
		<div class="row">
			<div class="footer-main">
				<span>Thư viện</span>
			</div>
		</div>
	</div>
</footer>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type='text/javascript' src="resources/js/jquery.js"></script>
<script type='text/javascript' src="resources/js/bootstrap.min.js"></script>
<script type='text/javascript' src='resources/js/jquery.cookie.js'></script>
<script type='text/javascript'
	src='resources/js/jquery.hoverIntent.minified.js'></script>
<script type='text/javascript'
	src='resources/js/jquery.dcjqaccordion.2.7.min.js'></script>
<script src="https://code.highcharts.com/highcharts.src.js"></script>
<!-- 	<script src="resources/js/chart.js"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		$('#modalNotice').modal('show');
	});
</script>
<script src="resources/js/jquery.flot.min.js"></script>
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<script type='text/javascript' src="resources/js/custom.js"></script>
</html>
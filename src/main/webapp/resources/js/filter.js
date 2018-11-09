$(document).ready(function(){
			  $("#searchBox").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#table tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			  $("#Category-select").on("change", function() {
				    var value = $(this).val().toLowerCase();
				    $("#table tr").filter(function() {
				      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				    });
				  });
			  $("#Status-select").on("change", function() {
				    var value = $(this).val().toLowerCase();
				    $("#table tr").filter(function() {
				      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				    });
				  });
			});
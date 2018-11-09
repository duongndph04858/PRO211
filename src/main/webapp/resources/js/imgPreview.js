/**
 * 
 */

		function updateImageDisplay() {
			var input = document.getElementById('inputFile');
			var preview = document.getElementById('img-thumb');
			var file = input.files;
			let url = window.URL.createObjectURL(file[0]);
			preview.style.backgroundImage="url('"+url+"')";
			};
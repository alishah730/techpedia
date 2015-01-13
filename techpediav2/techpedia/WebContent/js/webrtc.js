$(document).ready(function() {
	'use strict';

	if (window.FormData === undefined) {
		$('#hidden-photo-input').show();
		$('.photo-btn-click').hide();
	}

	var video = $('.live')[0];
	navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
	window.URL = window.URL || window.webkitURL || window.mozURL || window.msURL;

	// Call the getUserMedia method with our callback functions
	if (navigator.getUserMedia) {
		navigator.getUserMedia({
			video : true
		}, successCallback, errorCallback);
	} else {
		noCamera();
	}

	function successCallback(stream) {
		if (video.mozSrcObject !== undefined) {
			video.mozSrcObject = stream;
		} else {
			video.src = (window.URL && window.URL.createObjectURL(stream)) || stream;
		}

		video.addEventListener('loadeddata', function() {
		}, false);

		video.play();
	}

	function errorCallback(error) {
		noCamera();
	}
});

function noCamera() {
	$('.photo').show();
	$('.live').hide();
	$('.takePhoto').hide();
}

$('.takePhoto').click(function(e) {
	takepicture();
	$(this).hide();
	$('.retakePhoto').show();
	$('.photo').show();
	$('.live').hide();
	e.preventDefault();
});

$('.retakePhoto').click(function(e) {
	$(this).hide();
	$('.takePhoto').show();
	$('.photo').hide();
	$('.live').show();
	e.preventDefault();
});

function takepicture() {
	video = $('.live')[0];
	canvas = $('.canvas')[0];
	photo = $('.photo')[0];
	width = 320;
	height = 240;
	canvas.width = width;
	canvas.height = height;
	canvas.getContext('2d').drawImage(video, 0, 0, width, height);
	var data = canvas.toDataURL('image/png');
	var head = 'data:image/png;base64,';
	var imgFileSize = Math.round((data.length - head.length) * 3 / 4);
	$('#photoByte64').val(data);
	$('#photoByte64Size').val(imgFileSize / 1000);
	photo.setAttribute('src', data);
}

$("#hidden-photo-input").fileReader({
	filereader : 'js/filereader.swf',
	debugMode : false
});

$('#hidden-photo-input').on("change", function(e) {
	var reader = new FileReader();
	var file = e.target.files[0], imageType = /image.*/;

	if (!file.type.match(imageType)) {
		error = true;
		if (error) {
			$('.reg-acc-2').click();
			$('.error-place').show();
			errorString = "Please upload image files only";
			$('.error').html(errorString);
			errorString = "";
			$('html, body').animate({
				scrollTop : $('.error-place').offset().top
			}, 500);
		} else {
			$('.error-place').hide();
			$('.error').html('');
			$('html, body').animate({
				scrollTop : $('.reg-acc-1').offset().top
			}, 500);
		}
		return;
	}

	$('#photoByte64Size').val(file.size / 1000);
	reader.readAsDataURL(file);
	reader.onloadend = function() {
		var photo = $('.photo')[0];
		photo.src = reader.result;
		$('#photoByte64').val(reader.result);
		var canvas = $('.canvas')[0];
		canvas.width = 160;
		canvas.height = 120;
		var ctx = canvas.getContext('2d');

		var img = new Image();
		img.src = $('.photo')[0].src;
		img.onload = function() {
			var ptrn = ctx.createPattern(img, 'no-repeat');
			ctx.fillStyle = ptrn;
			ctx.fillRect(0, 0, canvas.width, canvas.height);

		};

		$('.live').hide();
		$('.photo').show();

		$('.takePicture').hide();
		$('.retakePicture').show();
	};
	$("#hidden-logo-input").fileReader({
		filereader : 'js/filereader.swf',
		debugMode : false
	});

	$('#hidden-logo-input').on("change", function(e) {
		var reader = new FileReader();
		var file = e.target.files[0], imageType = /image.*/;


		$('#logoByte64Size').val(file.size / 1000);
		reader.readAsDataURL(file);
		reader.onloadend = function() {
			var photo = $('.logo')[0];
			photo.src = reader.result;
			$('#logoByte64').val(reader.result);
			/*var canvas = $('.canvas')[0];
			canvas.width = 160;
			canvas.height = 120;
			var ctx = canvas.getContext('2d');
	*/
			var img = new Image();
			img.src = $('.logo')[0].src;
			img.onload = function() {
				var ptrn = ctx.createPattern(img, 'no-repeat');
				ctx.fillStyle = ptrn;
				/*ctx.fillRect(0, 0, canvas.width, canvas.height);*/

			};

	
		};
	});
});

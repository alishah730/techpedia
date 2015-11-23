$(document).ready(function() {
	'use strict';

	if (window.FormData === undefined) {
		$('#hidden-photo1-input').show();
		$('.photo1-btn-click').hide();
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
	$('.photo1').show();
	$('.live').hide();
	$('.takephoto1').hide();
}

$('.takephoto1').click(function(e) {
	takepicture();
	$(this).hide();
	$('.retakephoto1').show();
	$('.photo1').show();
	$('.live').hide();
	e.preventDefault();
});

$('.retakephoto1').click(function(e) {
	$(this).hide();
	$('.takephoto1').show();
	$('.photo1').hide();
	$('.live').show();
	e.preventDefault();
});

function takepicture() {
	video = $('.live')[0];
	canvas = $('.canvas')[0];
	photo1 = $('.photo1')[0];
	logo = $('.logo')[0];
	width = 320;
	height = 240;
	canvas.width = width;
	canvas.height = height;
	canvas.getContext('2d').drawImage(video, 0, 0, width, height);
	var data = canvas.toDataURL('image/png');
	var head = 'data:image/png;base64,';
	var imgFileSize = Math.round((data.length - head.length) * 3 / 4);
	$('#photo1Byte64').val(data);
	$('#logoByte64').val(data);
	$('#photo1Byte64Size').val(imgFileSize / 1000);
	$('#logoByte64Size').val(imgFileSize / 1000);
	photo1.setAttribute('src', data);
}

$("#hidden-photo1-input").fileReader({
	filereader : 'js/filereader.swf',
	debugMode : false
});

$('#hidden-photo1-input').on("change", function(e) {
	var reader = new FileReader();
	var file1 = e.target.files[0], imageType = /image.*/;

	if (!file1.type.match(imageType)) {
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

	$('#photo1Byte64Size').val(file1.size / 1000);
	reader.readAsDataURL(file1);
	reader.onloadend = function() {
		var photo1 = $('.photo1')[0];
		photo1.src = reader.result;
		$('#photo1Byte64').val(reader.result);
		var canvas = $('.canvas')[0];
		canvas.width = 160;
		canvas.height = 120;
		var ctx = canvas.getContext('2d');

		var img = new Image();
		img.src = $('.photo1')[0].src;
		img.onload = function() {
			var ptrn = ctx.createPattern(img, 'no-repeat');
			ctx.fillStyle = ptrn;
			ctx.fillRect(0, 0, canvas.width, canvas.height);

		};

		$('.live').hide();
		$('.photo1').show();

		$('.takePicture').hide();
		$('.retakePicture').show();
	};
	$("#hidden-logo-input").fileReader({
		filereader : 'js/filereader.swf',
		debugMode : false
	});
	if (window.FormData === undefined) {
		$('#hidden-logo-input').show();
		$('.photo1-btn-click').hide();
	}
	$('#hidden-logo-input').on("change", function(e) {
		var reader = new FileReader();
		var file1 = e.target.files[0], imageType = /image.*/;
	

		if (!file1.type.match(imageType)) {
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

		$('#logoByte64Size').val(file.size / 1000);
		reader.readAsDataURL(file);
		reader.onloadend = function() {
			var logo = $('.logo')[0];
			logo.src = reader.result;
			$('#logoByte64').val(reader.result);
			var canvas = $('.canvas')[0];
			canvas.width = 160;
			canvas.height = 120;
			var ctx = canvas.getContext('2d');
	
			var img = new Image();
			img.src = $('.photo1')[0].src;
			img.onload = function() {
				var ptrn = ctx.createPattern(img, 'no-repeat');
				ctx.fillStyle = ptrn;
				ctx.fillRect(0, 0, canvas.width, canvas.height);

			};
			
			$('.live').hide();
			$('.photo1').show();

			$('.takePicture').hide();
			$('.retakePicture').show();
		};
	});
});

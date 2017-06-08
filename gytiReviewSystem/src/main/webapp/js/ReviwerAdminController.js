var techpedia = angular.module('techpedia', ['ngMaterial','ngMessages']);

techpedia.service('MyService', ['$window',function ($window) {
	var service = {
			store: store,
			retrieve: retrieve,
			clear: clear,
			clearAll: clearAll
	};

	return service;


	function store(key, value) {
		$window.sessionStorage.setItem(key, angular.toJson(value, false));
	}

	function retrieve(key) {
		return angular.fromJson($window.sessionStorage.getItem(key));
	}

	function clear(key) {
		$window.sessionStorage.removeItem(key);
	}

	function clearAll() {
		$window.sessionStorage.clear();
	}


}]);
var oldURL = document.referrer;



techpedia.controller('CollegeDetailsController', function($scope, $http) {
	$scope.InitLoad = function() {

		$http({
			method : 'POST',
			url : 'ajax/getCollegeRecentNews',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.recentnews = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


		$scope.projects = {};

		$scope.recentprojects = [ {
			projTitle : 'Loading title',
			projDescription : 'Loading description'
		} ];

		$scope.viewProject = function(project) {
			window.location = 'projectDetails' + project.projId;
		};
		// Recent Projects
		$http({
			method : 'POST',
			url : 'ajax/getCollegeRecentProjects',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.recentprojects = data;
			for(var i=0;i<$scope.recentprojects.length;i++){


				if($scope.recentprojects[i].projTitle.length>15){
					$scope.recentprojects[i].projTitle=$scope.recentprojects[i].projTitle.substring(0, 18)+"...";
				}
			}
		}).error(function(data, status, headers, config) {
			$scope.recentprojects = [ {
				projTitle : 'Failed to load data',
				projDescription : 'Please try again later'
			} ];
		});
		/*
		 * $scope.recentProjectVisibility = function(){
		 * document.getElementById("recentProjects").style.display = "block";
		 * $('#popularProjects').hide(); $('#recentProjects').show(); }
		 * 
		 * $http({ method : 'POST', url : 'projectsFetch', data : $.param({ set :
		 * 1 }), headers : { 'Content-Type' :
		 * 'application/x-www-form-urlencoded' } }).success(function(data,
		 * status, headers, config) { $scope.projects = data; for(var i=0;i<$scope.projects.length;i++){
		 * 
		 * $scope.projects[i].projBranchName =
		 * $scope.projects[i].projBranchList[0].projBranchDesc.substring(0,
		 * 13)+"..."; } for(var i=0;i<$scope.projects.length;i++){
		 * alert($scope.projects[i].projCollege);
		 * 
		 * 
		 * if($scope.projects[i].projTitle.length>30){
		 * $scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0,
		 * 30)+"..."; } if($scope.projects[i].projCollege.length>13){
		 * $scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0,
		 * 13)+"..."; } if($scope.projects[i].projFacultyName.length>13){
		 * $scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0,
		 * 13)+"..."; } if($scope.projects[i].projTeamLeaderName.length>13){
		 * $scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0,
		 * 13)+"..."; }
		 * 
		 * 
		 * 
		 * 
		 *  } }).error(function(data, status, headers, config) {
		 * $scope.message.push("Possibly the service is down, Please contact the
		 * admin if problem persists."); }); $scope.clickProject = function(id) {
		 * window.location = 'projectDetails' + id; };
		 */




		$http({
			method : 'POST',
			url : 'ajax/getcollegeFacultyList',
			data : $.param({
				collegeName :'Adusimilli Vijaya College of Engineering'
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.faculties = data;
			for(var i=0;i<$scope.faculties.length;i++){
				if($scope.faculties[i].facultyName.length>15){
					$scope.faculties[i].facultyName=$scope.faculties[i].facultyName.substring(0, 18)+"...";
				}
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


		$scope.viewFaculty = function(faculty) {
			window.location = 'facultyDetails' + faculty.rgstrId;
		};




		$scope.showData = function( ){

			$scope.itemsPerPage1 = 6;
			$scope.currentPage1 = 0;

			$scope.range1 = function() {
				var rangeSize1 = 6;
				var ps1 = [];
				var start1;

				start1 = $scope.currentPage1;
				console.log($scope.pageCount(),$scope.currentPage1)// 8 0

				if ( start1 > $scope.pageCount()-rangeSize1 ) { // 0>8-4
					start1 = $scope.pageCount()-rangeSize1+1;
				}

				for (var i=start1; i<start1+rangeSize1; i++) { // i=0, i<4
					if(i>=0) 
						ps1.push(i);
				}
				return ps1;
			};

			$scope.prevPage1 = function() {
				if ($scope.currentPage1 > 0) {
					$scope.currentPage1--;
				}
			};

			$scope.DisablePrevPage1 = function() {
				return $scope.currentPage1 === 0 ? "disabled" : "";
			};

			$scope.pageCount1 = function() {
				return Math.ceil($scope.faculties.length / $scope.itemsPerPage1)-1;// 8
			};

			$scope.nextPage1 = function() {
				if ($scope.currentPage1 < $scope.pageCount()) {
					$scope.currentPage1++;
				}
			};

			$scope.DisableNextPage1 = function() {
				return $scope.currentPage1 === $scope.pageCount() ? "disabled" : "";
			};

			$scope.setPage1 = function(n) {
				$scope.currentPage1 = n;
			};

		}


		$scope.showProjectData = function( ){

			$scope.itemsPerPage = 6;
			$scope.currentPage = 0;

			$scope.range = function() {
				var rangeSize = 6;
				var ps = [];
				var start;

				start = $scope.currentPage;
				console.log($scope.pageCount(),$scope.currentPage)// 8 0

				if ( start > $scope.pageCount()-rangeSize ) { // 0>8-4
					start = $scope.pageCount()-rangeSize+1;
				}

				for (var i=start; i<start+rangeSize; i++) { // i=0, i<4
					if(i>=0) 
						ps.push(i);
				}
				return ps;
			};

			$scope.prevPage = function() {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.DisablePrevPage = function() {
				return $scope.currentPage === 0 ? "disabled" : "";
			};

			$scope.pageCount = function() {
				return Math.ceil($scope.recentprojects.length / $scope.itemsPerPage)-1;// 8
			};

			$scope.nextPage = function() {
				if ($scope.currentPage < $scope.pageCount()) {
					$scope.currentPage++;
				}
			};

			$scope.DisableNextPage = function() {
				return $scope.currentPage === $scope.pageCount() ? "disabled" : "";
			};

			$scope.setPage = function(n) {
				$scope.currentPage = n;
			};
		}




	};



	/*
	 * $scope.showData = function( ){
	 * 
	 * $scope.itemsPerPage = 6; $scope.currentPage = 0;
	 * 
	 * $scope.range = function() { var rangeSize = 6; var ps = []; var start;
	 * 
	 * start = $scope.currentPage;
	 * console.log($scope.pageCount(),$scope.currentPage)//8 0
	 * 
	 * if ( start > $scope.pageCount()-rangeSize ) { //0>8-4 start =
	 * $scope.pageCount()-rangeSize+1; }
	 * 
	 * for (var i=start; i<start+rangeSize; i++) { //i=0, i<4 if(i>=0)
	 * ps.push(i); } return ps; };
	 * 
	 * $scope.prevPage = function() { if ($scope.currentPage > 0) {
	 * $scope.currentPage--; } };
	 * 
	 * $scope.DisablePrevPage = function() { return $scope.currentPage === 0 ?
	 * "disabled" : ""; };
	 * 
	 * $scope.pageCount = function() { return Math.ceil($scope.faculties.length /
	 * $scope.itemsPerPage)-1;//8 };
	 * 
	 * $scope.nextPage = function() { if ($scope.currentPage <
	 * $scope.pageCount()) { $scope.currentPage++; } };
	 * 
	 * $scope.DisableNextPage = function() { return $scope.currentPage ===
	 * $scope.pageCount() ? "disabled" : ""; };
	 * 
	 * $scope.setPage = function(n) { $scope.currentPage = n; };
	 *  }
	 * 
	 * 
	 */


	/*
	 * $scope.showProjectData = function( ){
	 * 
	 * $scope.itemsPerPage = 6; $scope.currentPage = 0;
	 * 
	 * $scope.range = function() { var rangeSize = 6; var ps = []; var start;
	 * 
	 * start = $scope.currentPage;
	 * console.log($scope.pageCount(),$scope.currentPage)//8 0
	 * 
	 * if ( start > $scope.pageCount()-rangeSize ) { //0>8-4 start =
	 * $scope.pageCount()-rangeSize+1; }
	 * 
	 * for (var i=start; i<start+rangeSize; i++) { //i=0, i<4 if(i>=0)
	 * ps.push(i); } return ps; };
	 * 
	 * $scope.prevPage = function() { if ($scope.currentPage > 0) {
	 * $scope.currentPage--; } };
	 * 
	 * $scope.DisablePrevPage = function() { return $scope.currentPage === 0 ?
	 * "disabled" : ""; };
	 * 
	 * $scope.pageCount = function() { return
	 * Math.ceil($scope.recentprojects.length / $scope.itemsPerPage)-1;//8 };
	 * 
	 * $scope.nextPage = function() { if ($scope.currentPage <
	 * $scope.pageCount()) { $scope.currentPage++; } };
	 * 
	 * $scope.DisableNextPage = function() { return $scope.currentPage ===
	 * $scope.pageCount() ? "disabled" : ""; };
	 * 
	 * $scope.setPage = function(n) { $scope.currentPage = n; }; }
	 * 
	 */


});



/*
 * techpedia.filter('paginationforfaculty', function() { return function(input,
 * start) { start = parseInt(start, 10); return input.slice(start); }; });
 * 
 * techpedia.filter('paginationforproject', function() { return function(input,
 * start) { start = parseInt(start, 10); return input.slice(start); }; });
 */



techpedia.filter('anyInvalidDirtyFields', function() {
	return function(form) {
		for ( var prop in form) {
			if (form.hasOwnProperty(prop)) {
				if (form[prop].$invalid && form[prop].$dirty) {
					return true;
				}
			}
		}
		return false;
	};

});


techpedia.filter('truncate',function() {
	return function (value, wordwise, max, tail) {
		if (!value) return '';

		max = parseInt(max, 10);
		if (!max) return value;
		if (value.length == max) return value;

		value = value.substr(0, max);
		if (wordwise) {
			var lastspace = value.lastIndexOf(' ');
			if (lastspace != -1) {
				value = value.substr(0, lastspace);
			}
		}

		return value + (tail || ' …');
	};
});


techpedia.directive('datepicker-angular', function() {
	return {
		require : 'ngModel',
		link : function(scope, el, attr, ngModel) {
			$(el).datepicker({
				dateFormat : 'yy-mm-dd',	
				onSelect : function(dateText) {
					scope.$apply(function() {
						ngModel.$setViewValue(dateText);
					});
				}
			});
		}
	};
});



techpedia.directive("autoComplete", function() {
	return {
		restrict : "A",
		require : 'ngModel', // require ngModel controller
		scope : {
			AutoCompleteOptions : "=autoCompleteOptions", // use '=' instead
			// of '&'
		},
		link : function(scope, element, attrs, ngModelCtrl) {

			// prevent html5/browser auto completion
			attrs.$set('autocomplete', 'off');

			// add onSelect callback to update ngModel
			scope.AutoCompleteOptions.onSelect = function() {
				scope.$apply(function() {
					ngModelCtrl.$setViewValue(element.val());
				});
			};

			scope.autocomplete = $(element).autocomplete(scope.AutoCompleteOptions);
		}
	};
});

techpedia.directive('base64', function() {
	return {
		restrict : 'A',
		scope : {
			model : '=ngFile'
		},
		link : function(scope, elem, attrs) {

			scope.model = scope.model || {};

			scope.readerOnload = function(e) {
				var base64 = btoa(e.target.result);
				scope.model.base64 = base64;
				scope.$apply();
			};

			var reader = new FileReader();
			reader.onload = scope.readerOnload;

			elem.on('change', function() {
				var file = elem[0].files[0];
				scope.model.filetype = file.type;
				scope.model.filename = file.name;
				// converts file to binary string
				reader.readAsBinaryString(file);
			});
		}
	};
});


techpedia.controller('EditNewInnovationController', function($scope, $http) {});




techpedia.controller('EditProjectController', function($scope, $http) {});

techpedia.controller('FooterController', function($scope, $http) {});

/*
 * techpedia.controller('collegeDetailsController', function($scope, $http) {
 * $scope.recentprojects = [ { projTitle : 'Loading title', projDescription :
 * 'Loading description' } ]; //Latest News $http({ method : 'POST', url :
 * 'ajax/getRecentNews', data : $.param({}), headers : { 'Content-Type' :
 * 'application/x-www-form-urlencoded' } }).success(function(data, status,
 * headers, config) { $scope.recentnews1 = data; }).error(function(data, status,
 * headers, config) { $scope.message = []; $scope.message.push("Possibly the
 * service is down, Please contact the admin if problem persists."); });
 * //Recent Projects $http({ method : 'POST', url :
 * 'recentProjectSpotlightLoad', data : $.param({}), headers : { 'Content-Type' :
 * 'application/x-www-form-urlencoded' } }).success(function(data, status,
 * headers, config) { $scope.recentprojects = data; }).error(function(data,
 * status, headers, config) { $scope.recentprojects = [ { projTitle : 'Failed to
 * load data', projDescription : 'Please try again later' } ]; });
 * $scope.recentProjectVisibility = function(){
 * document.getElementById("recentProjects").style.display = "block";
 * $('#popularProjects').hide(); $('#recentProjects').show(); }
 * 
 * });
 */


techpedia.controller('IndexController', function($scope, $http) {});

techpedia.controller('LoginModalController', function($scope, $http,MyService) {});

techpedia.controller('ChallengeDetailsController', function($scope, $http) {});

techpedia.controller('MentorDetailsController', function($scope, $http) {});
//faculty details controller...

techpedia.controller('facultyDetailsController', function($scope, $http) {});

//Student Details Controller

techpedia.controller('studentDetailsController', function($scope, $http) {});


techpedia.controller('showMentorDetailsController', function($scope, $http) {});



techpedia.controller('TeamsController', function($scope, $http) {});

techpedia.filter('pagination', function() {
	return function(input, start) {
		start = parseInt(start, 10);
		return input.slice(start);
	};
});

techpedia.controller('TeamDetailsController', function($scope, $http) {});

techpedia.controller('ManageChallengesController', function($scope, $http) {});



techpedia.controller('DashboardController', function($scope, $http) {});

techpedia.controller('ManageProjectsController', function($scope, $http) {});

techpedia.controller('ProjectDetail', function($scope, $http) {});
function reloadCaptcha() {
	var captchaImage = document.getElementById("captcha_image");
	captchaImage.src = "jcaptcha.jpg";
}
function clickExit() {

	window.location = 'manageProjects';

};
function clickExitChallenge() {
	window.location = 'manageChallenge';

};

techpedia.controller('AddProjectController', function($scope, $http) {});



techpedia.controller('NewInnovationController', function($scope, $http) {});


techpedia.controller('ChangePhotoController', function($scope, $http) {
	$scope.InitLoad = function() {
		$scope.canSaveImage = false;
	};
	var img=$scope.photo;
	$scope.$watch('file', function() {
		$scope.editProfile = {};
		$scope.msg = {};
		var head = "data:" + $scope.file.filetype + ";base64,";
		$scope.imgName = $scope.file.filename;
		$scope.editProfile.photo = $scope.file.base64;
		// $scope.editProfile.photo = head + $scope.file.base64;
		$scope.editProfile.photoSize = Math.round(($scope.editProfile.photo.length - head.length) * 3 / 4) / 1000;
		if ($scope.editProfile.photoSize > 2048) {
			$scope.msg.size = "File size should not me bore than 2 MB";
			$scope.canSaveImage = false;
		} else {
			$scope.msg.size = "";
			if ($scope.editProfile.photo.indexOf("undefined") > -1) {
				$scope.editProfile.photo = img;

				$scope.canSaveImage = false;
			} else {

				$scope.canSaveImage = true;
			}
		}

	}, true);

	$scope.saveImage = function() {
		$http({
			method : 'POST',
			url : 'getId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.id = data;

			$http({
				method : 'POST',
				url : 'ajax/changeImage',
				data : $.param({
					registerId : $scope.id,
					imageName : $scope.imgName,
					photoByteArray :$scope.editProfile.photo
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				if (data === 'Y') {
					$scope.message = [];
					$scope.message.push("Photo updated succesfully");
				} else {
					$scope.message = [];
					$scope.message.push(data);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
});

techpedia.controller('ChangePhotoFacController', function($scope, $http) {
	$scope.InitLoad = function() {
		$scope.canSaveImage = false;
	};
	var img=$scope.photo;
	$scope.$watch('file', function() {
		$scope.editProfile = {};
		$scope.msg = {};
		var head = "data:" + $scope.file.filetype + ";base64,";
		$scope.editProfile.photo = head + $scope.file.base64;
		$scope.editProfile.photoSize = Math.round(($scope.editProfile.photo.length - head.length) * 3 / 4) / 1000;
		if ($scope.editProfile.photoSize > 10) {
			$scope.msg.size = "File size should not me bore than 10 KB";
			$scope.canSaveImage = false;
		} else {
			$scope.msg.size = "";
			if ($scope.editProfile.photo.indexOf("undefined") > -1) {
				$scope.editProfile.photo = img;

				$scope.canSaveImage = false;
			} else {

				$scope.canSaveImage = true;
			}
		}

	}, true);

	$scope.saveFacImage = function() {
		$http({
			method : 'POST',
			url : 'ajax/changeFacImage',
			data : $.param({

				photoByteArray : "data:" + $scope.file.filetype + ";base64," + $scope.file.base64
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data === 'Y') {
				$scope.message = [];
				$scope.message.push("Photo uploaded succesfully");
			} else {
				$scope.message = [];
				$scope.message.push(data);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};
});

techpedia.controller('EditProfileController', function($scope, $http) {});

techpedia.controller('ChangePasswordController', function($scope, $http) {
	$scope.data = {};
	$scope.changePassword = function() {
		$http({
			method : 'POST',
			url : 'changePassword',
			data : $.param($scope.data),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data === 'success') {
				$scope.message = [];
				$scope.message.push("Password changed succesfully");
			} else {
				$scope.message = [];
				$scope.message.push(data);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
});



techpedia.controller('SetPasswordFacultyController', function($scope, $http) {});


techpedia.controller('SocialRegisterController', function($scope, $http,MyService) {});


techpedia.controller('RegisterController', function($scope, $http) {});

techpedia.controller('AddChallengeController', function($scope, $http) {});



//test


techpedia.controller('ProjectsByBranchesController', function($scope, $http) {});


techpedia.controller('ProjectsPageController', function($scope, $http) {});

/* GYTI Projects Controller Start */

techpedia.controller('GytiProjectsPageController', function($scope, $http) {});

/* GYTI Projects Controller End */




techpedia.controller('MentorsPageController', function($scope, $http) {});

techpedia.controller('ChallengesPageController', function($scope, $http) {});

techpedia.controller('NewMemberController', function($scope, $http) {});

techpedia.controller("TestController", function($scope) {
	$scope.InitLoad = function() {
	};
});
techpedia.directive('passwordMatch', [function () {
	return {
		restrict: 'A',
		scope:true,
		require: 'ngModel',
		link: function (scope, elem , attrs,control) {
			var checker = function () {

				// get the value of the first password
				var e1 = scope.$eval(attrs.ngModel); 

				// get the value of the other password
				var e2 = scope.$eval(attrs.passwordMatch);
				return e1 == e2;
			};
			scope.$watch(checker, function (n) {

				// set the form control to valid if both
				// passwords are the same, else invalid
				control.$setValidity("pwmatch", n);
			});
		}
	};
}]);


techpedia.controller('NewFacultyController', function($scope, $http) {});

techpedia.$inject = ['$scope', '$filter'];

techpedia.directive('customSort', function() {

	return {
		restrict: 'A',
		transclude: true,    
		scope: {
			order: '=',
			sort: '='
		},
		template : 
			' <a href="" ng-click="sort_by(order)" style="color: white;">'+
			'    <span ng-transclude></span>'+
			'    <i ng-class="selectedCls(order)"></i>'+
			'</a>',
			link: function(scope) {

				// change sorting order
				scope.sort_by = function(newSortingOrder) {       
					var sort = scope.sort;

					if (sort.sortingOrder == newSortingOrder){
						sort.reverse = !sort.reverse;
					}                    

					sort.sortingOrder = newSortingOrder;        
				};


				scope.selectedCls = function(column) {
					if(column == scope.sort.sortingOrder){
						return ('fa fa-chevron-' + ((scope.sort.reverse) ? 'down' : 'up'));
					}
					else{            
						return'fa fa-sort' 
					}
				};      
//				end link
			}
	}
});


//tooltip directive

/*
 * techpedia.directive('tooltip', function ($document, $compile) { return {
 * restrict: 'A', scope: true, link: function (scope, element, attrs) {
 * 
 * var tip = $compile('<div ng-class="tipClass">{{ text }}<div
 * class="tooltip-arrow"></div></div>')(scope), tipClassName = 'tooltip',
 * tipActiveClassName = 'tooltip-show';
 * 
 * scope.tipClass = [tipClassName]; scope.text = attrs.tooltip;
 * 
 * if(attrs.tooltipPosition) { scope.tipClass.push('tooltip-' +
 * attrs.tooltipPosition); } else { scope.tipClass.push('tooltip-down'); }
 * $document.find('body').append(tip);
 * 
 * element.bind('mouseover', function (e) { tip.addClass(tipActiveClassName);
 * 
 * var pos = e.target.getBoundingClientRect(), offset = tip.offset(), tipHeight =
 * tip.outerHeight(), tipWidth = tip.outerWidth(), elWidth = pos.width ||
 * pos.right - pos.left, elHeight = pos.height || pos.bottom - pos.top,
 * tipOffset = 10;
 * 
 * if(tip.hasClass('tooltip-right')) { offset.top = pos.top - (tipHeight / 2) +
 * (elHeight / 2); offset.left = pos.right + tipOffset; } else
 * if(tip.hasClass('tooltip-left')) { offset.top = pos.top - (tipHeight / 2) +
 * (elHeight / 2); offset.left = pos.left - tipWidth - tipOffset; } else
 * if(tip.hasClass('tooltip-down')) { offset.top = pos.top + elHeight +
 * tipOffset; offset.left = pos.left - (tipWidth / 2) + (elWidth / 2); } else {
 * offset.top = pos.top - tipHeight - tipOffset; offset.left = pos.left -
 * (tipWidth / 2) + (elWidth / 2); }
 * 
 * tip.offset(offset); });
 * 
 * element.bind('mouseout', function () { tip.removeClass(tipActiveClassName);
 * });
 * 
 * tip.bind('mouseover', function () { tip.addClass(tipActiveClassName); });
 * 
 * tip.bind('mouseout', function () { tip.removeClass(tipActiveClassName); });
 * 
 *  } } });
 */

techpedia.directive('repeatDone', function() {
	return function(scope, element, attrs) {
		if (scope.$last) { // all are rendered
			scope.$eval(attrs.repeatDone);
		}
	}
})


techpedia.controller('CollegeAdminPageController', function($scope, $http,$filter,$timeout) {});

techpedia.controller('additionalInfoGytiController', function($scope, $http) {});

techpedia.controller('ReviewDashBoardController',function($scope, $http){


	$scope.Initload=function()
	{
		$http({
			method : 'POST',
			url : 'getTotalGytiProjectsByCategory',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.getTotalGytiProjectsByCategoryOBJECT=data;

			/*
			 * var getTotalGytiProjectsByCategory=JSON.stringify(data);
			 * console.log("JSON String::"+getTotalGytiProjectsByCategory);
			 */

			// graph

			var chart = AmCharts.makeChart("chartdiv", {
				"theme": "light",
				"type": "serial",
				"title":"Total Submitted Innovations/Ideas",
				"dataProvider":$scope.getTotalGytiProjectsByCategoryOBJECT,

				/*
				 * [
				 *  { "category": "Electronics & Communication Engineering",
				 * "totalProject": 789 }, { "category": "Electrical",
				 * "totalProject":900 }, { "category": "Computer Science",
				 * "totalProject": 301 }, { "category": "Information
				 * Technology", "totalProject": 2905 }, { "category":
				 * "Metallurgy", "totalProject": 2406 }, { "category":
				 * "Chemical", "totalProject": 2350 }, { "category":
				 * "Mechanical", "totalProject": 600 }, { "category": "Food
				 * Technology", "totalProject": 3015 }, { "category": "Civil",
				 * "totalProject": 2950 }, { "category": "Bio-Technology",
				 * "totalProject": 246 }, { "category": "Textile",
				 * "totalProject": 2350 }, { "category": "Aeronautical",
				 * "totalProject": 0 }, { "category": "Instrumental",
				 * "totalProject": 301 }, { "category": "Environmental",
				 * "totalProject": 295 }, { "category": "Bio-Medical",
				 * "totalProject": 246 }
				 *  ],
				 */
				"valueAxes": [{
					"title": "Total Submitted Project"
				}],
				"graphs": [{
					"balloonText": "Total Sbmitted Project in [[category]]=[[value]]",
					"fillAlphas": 1,
					"lineAlpha": 0.2,
					"title": "Total Sbmitted Project",
					"type": "column",
					"valueField": "totalProject"
				}],
				"depth3D": 20,
				"angle": 30,
				"rotate": true,
				"categoryField": "category",
				"categoryAxis": {
					"gridPosition": "start",
					"fillAlpha": 0.05,
					"position": "left",
					"title":"Category"
				},
				"responsive": {
					"enabled": true,

					"rules":[{
						"maxWidth": 400,
						"overrides": {
							"precision": 2,
							"categoryAxis": {
								"inside": true
							}
						}
					}]

				},
				"export": {
					"enabled": true
				}
			});




		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});



		/*
		 * google.charts.load('current', {packages: ['corechart', 'bar']});
		 * google.charts.setOnLoadCallback(drawBasic);
		 */

		/*
		 * function drawBasic() {
		 * 
		 * var data = google.visualization.arrayToDataTable([ ['Category',
		 * 'Total Project'], ['Electronics & Communication',200], ['Electrical',
		 * 379], ['Computer Science', 269], ['Information Technology', 209],
		 * ['Metallurgy', 3792], ['Chemical', 2695], ['Mechanical', 2099],
		 * ['Food Technology', 1000], ['Civil', 2130], ['Bio-Technology', 700],
		 * ['Bio-Medical', 900], ['Textile', 3000], ['Aeronautical', 2500],
		 * ['Instrumental', 3250], ['Environmental', 600] ]);
		 * 
		 * var options = { title: 'Total Submitted Innovations/Ideas', height:
		 * '100%', //colors: ['#1b9e77', '#d95f02', '#7570b3'],
		 * colors:['#3575AD'], chartArea: { width: '50%', //height: '100%'
		 *  }, bars: 'horizontal', hAxis: { title: 'Total Submitted Project',
		 * format: 'decimal', minValue: 0 }, vAxis: { title: 'Category' } };
		 * 
		 * var chart = new
		 * google.visualization.BarChart(document.getElementById('chart_div'));
		 * 
		 * chart.draw(data, options); var btns =
		 * document.getElementById('btn-group');
		 * 
		 * btns.onclick = function (e) {
		 * 
		 * if (e.target.tagName === 'BUTTON') { options.hAxis.format =
		 * e.target.id === 'none' ? '' : e.target.id; chart.draw(data,
		 * google.charts.Bar.convertOptions(options)); } } };
		 */
	};

});

techpedia.controller('ReviewHeaderController',function($scope, $http){

	$scope.InitLoad=function()
	{
		// do some action here
	};


});

techpedia.controller('ReviewSideMenuController',function($scope, $http){

	$scope.InitLoad=function()
	{
		// do some action here
	};


});

techpedia.controller('AddReviewerController',function($scope, $http){
	$scope.message = [];
	$scope.AddReviewer = {};
	$scope.InitLoad=function()
	{
		$scope.message = [];
		$scope.messageSuccess = [];
		$scope.messageWarning = [];
		// do some action here
	};
	$scope.registerReviewer=function(){
		$scope.ReviewerEmail=$scope.AddReviewer.revEmailId;
		$http({
			method : 'POST',
			url : 'AddReviwerByAdmin',
			data : $.param($scope.AddReviewer),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if(data.status==="success"){
				$scope.messageSuccess = [];
				$scope.messageSuccess.push(data.description);
			}
			else if(data.status==="success with Email error"){
				$scope.messageWarning = [];
				$scope.messageWarning.push(data.description);
			}
			else if (data.status==="failure") {
				$scope.message = [];
				$scope.message.push(data.description);
			}
			else{
				$scope.message = [];
				$scope.message.push("Reviewer adding failed for other reasons, Please contact your site admin.");

			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		})


	};

});

function ExitToReviewDashBoard(){

	window.location.href="reviewDashboard";
};

techpedia.controller('reviewerLoginController',function($scope, $http){
	$scope.InitLoad=function()
	{
		 $('#messageSuccessDiv').hide();
		 $('#messageWarningDiv').hide();
		 $('#messageDiv').hide();
		$scope.reviewer={};
	};

	$scope.reviewerLogin=function(){
		$http({
			method : 'POST',
			url : 'reviewerLoginRequest',
			data : $.param($scope.reviewer),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			// alert("Email id :: "+data.revEmailId);

			$scope.loginResponse=data;
			var RevUsrId=$scope.loginResponse.revUsrId;
			if($scope.loginResponse.exceptionCode !=undefined){
				// alert("Exception code :: "+data.exceptionCode);
				$scope.addMsgerror = [];
				$scope.addMsgerror.push("Oops!!, Please check your login credentials.")
				$scope.userNotFound=[];
				$scope.userNotFound.push(data.exceptionDetails);
			}
			else if ($scope.loginResponse.revEmailId !=undefined) {
				if(oldURL!=''){
					var rest = oldURL.substring(0, oldURL.lastIndexOf("/") + 1);
					var lastPageUrl = oldURL.substring(oldURL.lastIndexOf("/") + 1, oldURL.length);
					window.location.href = lastPageUrl;
				}
				
				else if($scope.loginResponse.revUsrId==="TrsAdmin"){
					window.location.href = 'adminDashboard';
				}
				else{
					window.location.href = 'reviewDashboard';
				}

			}

			else{
				$scope.addMsgerror = [];
				$scope.addMsgerror.push("Oops!!, Please contact the admin if problem persists.")
			}

		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		})


	};
	
	
	$scope.forgotPassword=function(){
		$http({
			method : 'POST',
			url : 'reviewerForgotPassword',
			data : $.param({
				emailId : $scope.emailId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			
			if(data.status==="success"){
				$scope.messageSuccess = [];
				$scope.messageSuccess.push(data.description);
				$('#messageSuccessDiv').show();
				$('#messageWarningDiv').hide();
				$('#messageDiv').hide();
			}
			else if(data.exceptionMessage=="UserNotFoundException"){
				$scope.messageWarning = [];
				$scope.messageWarning.push(data.exceptionDetails);
				$('#messageSuccessDiv').hide();
				$('#messageWarningDiv').show();
				$('#messageDiv').hide();
			}
			else{
				$scope.message = [];
				$scope.message.push("Forgot Password failed for other reasons, Please contact your site admin.");
				$('#messageSuccessDiv').hide();
				$('#messageWarningDiv').hide();
				$('#messageDiv').show();

			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		})
		
	}
	
	$('#ForgotPasswordModal').on('hidden.bs.modal', function (e) {
		  $(this)
		    .find("input,textarea,select")
		       .val('')
		       .end()
		    .find("input[type=checkbox], input[type=radio]")
		       .prop("checked", "")
		       .end();
		  $('#messageSuccessDiv').hide();
		  $('#messageWarningDiv').hide();
		  $('#messageDiv').hide();
		})
		
		
		$scope.resetPassword=function(){
		$http({
			method : 'POST',
			url : 'reviewerPasswordReset',
			data : $.param($scope.PasswordResetVo),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if(data.status==="success"){
				$scope.messageResetSuccess = [];
				$scope.messageResetSuccess.push(data.description);
				$('#messageResetSuccessDiv').show();
				$('#messageResetWarningDiv').hide();
				$('#messageResetDiv').hide();
			}
			else if(data.exceptionMessage=="UserNotFoundException"){
				$scope.messageResetWarning = [];
				$scope.messageResetWarning.push(data.exceptionDetails);
				$('#messageResetSuccessDiv').hide();
				$('#messageResetWarningDiv').show();
				$('#messageResetDiv').hide();
			}
			else if(data.exceptionMessage=="PasswordResetException"){
				$scope.messageResetWarning = [];
				$scope.messageResetWarning.push(data.exceptionDetails);
				$('#messageResetSuccessDiv').hide();
				$('#messageResetWarningDiv').show();
				$('#messageResetDiv').hide();
			}
			else{
				$scope.message = [];
				$scope.message.push("Forgot Password failed for other reasons, Please contact your site admin.");
				$('#messageResetSuccessDiv').hide();
				$('#messageResetWarningDiv').hide();
				$('#messageResetDiv').show();

			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		})
		
	}
	
	$('#ResetPasswordModal').on('hidden.bs.modal', function (e) {
		  $(this)
		    .find("input,textarea,select")
		       .val('')
		       .end()
		    .find("input[type=checkbox], input[type=radio]")
		       .prop("checked", "")
		       .end();
		  $('#messageResetSuccessDiv').hide();
		  $('#messageResetWarningDiv').hide();
		  $('#messageResetDiv').hide();
		})

		

		$scope.ClickForgotPassword=function(){
			$('#emailId').val("");

			$('#messageSuccessDiv').hide();
			$('#messageWarningDiv').hide();
			$('#messageDiv').hide();
		};
		
		$scope.ClickResetPassword=function(){
			$('#userName').val("");
			$('#oldpassword').val("");
			$('#newpassword').val("");

			$('#messageResetSuccessDiv').hide();
			$('#messageResetWarningDiv').hide();
			$('#messageResetDiv').hide();
		};

});

function ExitGYTIReview(){
	window.location.href="reviewGYTIProjects";
};




techpedia.controller('ReviewRatingController', function($scope,$http) {
	$scope.ReviewRatingVO={};
	$scope.InitLoad=function(){
		 $("#notifySuggestReviewerDiv").hide();
		 $("#moreInfoRequiredDiv").hide();
		 $("#moreCommentDiv").hide();
    	 $("#moreCommentButtonDiv").hide();
		 
		$scope.addMsg=[];
		$scope.addMsgerror = [];
		document.getElementById("revRatingPercentage").readOnly = true;
		$http({
			method : 'POST',
			url : 'getGytiProjectDetailforReview',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.GYTIProject=data;
			$scope.projTeamLeaderId=$scope.GYTIProject.projTeamLeaderId;
			$scope.reviewProjID=$scope.GYTIProject.projId;
			$scope.reviewProjTitle=$scope.GYTIProject.projTitle;
			$scope.projBranchList=$scope.GYTIProject.projBranchList;
		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		
	};
	
	
	$scope.projectDocuments= function() {
	
	$http({
		method : 'POST',
		url : 'getGytiProjectDocuments',
		data : $.param({
			projectId : $scope.GYTIProject.projId
		}),
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data, status, headers, config) {
		$scope.projectDocumentList = data;
		if($scope.projectDocumentList.length == 0){
			 $('#zipFileDownloadModal').modal('show');
			$scope.downloadSuccess = [];
			$scope.downloadSuccess.push("No document attachmemt is there for this project.");
		}else{
			 $('#zipFileDownloadModal').modal('hide');
			$scope.downloadDocumentZip();
		}
		
	
		

	}).error(function(data, status, headers, config) {
		$scope.message = [];
		$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
	});
};	
		
		
		
$scope.downloadDocumentZip= function() {
	//window.location = document.docLink;
	var zipfile = '';
	
	var count = 0;
	for(var i=0;i<$scope.projectDocumentList.length;i++){
		
			count++;
			if(count>1)
			{
				zipfile=zipfile+","+$scope.projectDocumentList[i].docLink;
			}else{
				zipfile=zipfile+$scope.projectDocumentList[i].docLink;
			}
		
	}

	$http({
		method : 'POST',
		url : 'DownloadZipFile',
		data : $.param({
			documentZipLink : zipfile,
			projTitle:$scope.GYTIProject.projTitle
		}),
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}

	}).success(function(data, status, headers, config) {
		window.location = 'DownloadZip';

	}).error(function(data, status, headers, config) {
		$scope.message = [];
		$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
	});
	
	
	
	
};

	$scope.ClickToResetDownloadSuccessMsg=function(){
		$('#downloadSuccessDiv').val("");
	}

	
	
	$scope.ClickReviewRatingForSuggestReviewer=function(){
		$('#suggestedReviewerName').val("");
		$('#suggestedReviewerEmail').val("");
		
		$('#messageSuccessDiv').hide();
		$('#messageWarningDiv').hide();
		$('#messageDiv').hide();

	};
	
	$scope.ClickReviewRatingForMoreInfo=function(){
		$('#moreInfoNeededRemarks').val("");
		$('#comments').val("");

		$('#messageSuccessDiv').hide();
		$('#messageWarningDiv').hide();
		$('#messageDiv').hide();
	};
	
	$(document).ready(function(){
	    $('input[type="radio"]').click(function(){
	        if($(this).attr("value")=="Suggest to other Reviewer"){
	        	 $("#mainDiv").hide();
	        	 $("#buttonsDiv").hide();
	        	 $("#moreInfoRequiredDiv").hide();
	        	 $("#notifySuggestReviewerDiv").show();
	        }
	        if($(this).attr("value")=="Worthy to Award" || $(this).attr("value")=="Can be considered for appreciation" || $(this).attr("value")=="None of the above Two"){
	        	  $("#mainDiv").show();
	        	  $("#buttonsDiv").show();
	        	  $("#notifySuggestReviewerDiv").hide();
	        	  $("#moreInfoRequiredDiv").hide();
	        }
	        if($(this).attr("value")=="More Information Required"){
	        	 $("#mainDiv").hide();
	        	 $("#buttonsDiv").hide();
	        	 $("#notifySuggestReviewerDiv").hide();
	        	 $("#moreInfoRequiredDiv").show();
	        }
	        
	        if($(this).attr("id")=="moreInfoNeeded9"){
	        	 $("#mainDiv").show();
	        	 $("#buttonsDiv").show();
	        	 $("#notifySuggestReviewerDiv").hide();
	        	 $("#moreCommentDiv").show();
	        	 $("#moreCommentButtonDiv").show();
	        }
	        if($(this).attr("id")=="moreInfoNeeded10"){
	        	 $("#mainDiv").show();
	        	 $("#buttonsDiv").show();
	        	 $("#notifySuggestReviewerDiv").hide();
	        	 $("#moreCommentDiv").hide();
	        	 $("#moreCommentButtonDiv").hide();
	        }
	        if($(this).attr("id")=="suggestToOtherRev9"){
	        	 $("#mainDiv").show();
	        	 $("#buttonsDiv").show();
	        	 $("#notifySuggestReviewerDiv").show();
	        	 $("#moreInfoRequiredDiv").hide();
	        }
	        
	        if($(this).attr("id")=="suggestToOtherRev10"){
	        	 $("#mainDiv").show();
	        	 $("#buttonsDiv").show();
	        	 $("#notifySuggestReviewerDiv").hide();
	        	 $("#moreInfoRequiredDiv").hide();
	        }
	        
	    });
	});
	
	$scope.notifyReviewer=function(loggedInReviewerId,suggestedReviewerName,suggestedReviewerEmail){
		 $('#loderDiv').show();
		$scope.NotifyReviewerVo={};
		$scope.NotifyReviewerVo.suggestedReviewerName=suggestedReviewerName;
		$scope.NotifyReviewerVo.suggestedReviewerEmail=suggestedReviewerEmail;
		$scope.NotifyReviewerVo.projectTitle=$scope.GYTIProject.projTitle;
		$scope.NotifyReviewerVo.projectAbstract=$scope.GYTIProject.projAbstract;
		$http({
			method : 'POST',
			url : 'notifySuggestedReviewer',
			data : $.param($scope.NotifyReviewerVo),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if(data.status==="success"){
				$scope.description = data.description;
				
				$http({
					method : 'POST',
					url : 'getReviewerDetails',
					data : $.param({
						reviewerEmailId:$scope.NotifyReviewerVo.suggestedReviewerEmail,
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.reviewerDetails = data;
					$scope.suggestReviewers = [];
					
					$scope.suggestReviewers.push({
						projId:$scope.GYTIProject.projId,
						revRgstrId:$scope.reviewerDetails.revRgstrId,
						assignedBy:loggedInReviewerId
					});
					
					var data =JSON.stringify($scope.suggestReviewers);
					$http({
						method : 'POST',
						url : 'suggestReviewer',
						data :  $.param({allSuggestedReviewers:JSON.stringify($scope.suggestReviewers)}),
						headers : {
							'Content-Type' : 'application/x-www-form-urlencoded'
						}
					}).success(function(data, status, headers, config) {
						// alert("suggest success*****"+data.description);
						 $scope.messageSuccess = [];
						 $scope.messageSuccess.push($scope.description+" And"+data.description);
						 $('#loderDiv').hide();
						 $('#messageSuccessDiv').show();
					}).error(function(data, status, headers, config) {
						$scope.errorMsg = [];
						$scope.errorMsg.push("Possibly the service is down, Please contact the admin if problem persists.");
					});

				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
			
				
				
			}
			else if(data.exceptionMessage==="UserNotFoundException"){
				$scope.messageWarning = [];
				$scope.messageWarning.push(data.exceptionDetails);
				$('#loderDiv').hide();
				$('#messageWarningDiv').show();
				 
			}
			else if(data.status==="success with Email error"){
				$scope.messageWarning = [];
				$scope.messageWarning.push(data.description);
				$('#loderDiv').hide();
				$('#messageWarningDiv').show();
				
			}
			else{
				$scope.message = [];
				$scope.message.push("Notify to suggested Reviewer failed for other reasons, Please contact your site admin.");
				$('#loderDiv').hide();
				$('#messageDiv').show();
				
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			 $('#loderDiv').hide();
			$('#messageDiv').show();
			
		});
		
	};
	
	$('#notifyReviewerModal').on('hidden.bs.modal', function (e) {
		  $(this)
		    .find("input,textarea")
		       .val('')
		       .end();
		  $('#messageSuccessDiv').hide();
		  $('#messageWarningDiv').hide();
		  $('#messageDiv').hide();
		  $('#loderDiv').hide();
		})

		
    $scope.moreInformationComments=function(comments){
		$('#loderDiv').show();
		$scope.MoreInfoRequiredVO={};
		
		
		$http({
			method : 'POST',
			url : 'ajax/teamLeaderProfileLoad',
			data :$.param({
				 projTeamLeaderId:$scope.GYTIProject.projTeamLeaderId,
				}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.teamLeaderDetails = data;
			$scope.MoreInfoRequiredVO.teamLeaderEmailId = $scope.teamLeaderDetails.email;
			$scope.MoreInfoRequiredVO.reviewerComments=comments;
			$scope.MoreInfoRequiredVO.projectTitle=$scope.GYTIProject.projTitle;
			$scope.MoreInfoRequiredVO.projectAbstract=$scope.GYTIProject.projAbstract;
			
			$http({
				method : 'POST',
				url : 'sendMoreInfoRequestToTeamLeader',
				data : $.param($scope.MoreInfoRequiredVO),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				if(data.status==="success"){
					 $scope.messageSuccess = [];
					 $scope.messageSuccess.push(data.description+" to"+$scope.MoreInfoRequiredVO.teamLeaderEmailId);
					 $('#loderDiv').hide();
					 $('#messageSuccessDiv').show();
				}
				else if(data.exceptionMessage==="UserNotFoundException"){
					$scope.messageWarning = [];
					$scope.messageWarning.push(data.exceptionDetails);
					 $('#loderDiv').hide();
					$('#messageWarningDiv').show();
				}
				else if(data.status==="success with Email error"){
					$scope.messageWarning = [];
					$scope.messageWarning.push(data.description);
					 $('#loderDiv').hide();
					$('#messageWarningDiv').show();
					
				}
				else{
					$scope.message = [];
					$scope.message.push("More information required for the project failed for other reasons, Please contact your site admin.");
					 $('#loderDiv').hide();
					$('#messageDiv').show();
					
					
				}
				
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				 $('#loderDiv').hide();
				$('#messageDiv').show();
			
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			 $('#loderDiv').hide();
			$('#messageDiv').show();
			
		});
	}
	
	$('#moreInfoRequiredModal').on('hidden.bs.modal', function (e) {
		 $(this)
		    .find("input,textarea")
		       .val('')
		       .end();
		  $('#messageSuccessDiv').hide();
		  $('#messageWarningDiv').hide();
		  $('#messageDiv').hide();
		  $('#loderDiv').hide();
		})

	function calcPercentage(){

		var score = 0;
		$(".clacPercentage:checked").each(function(){
			score+=parseInt($(this).val(),10);
		});
		$scope.ReviewRatingVO.revRatingPercentage=((score/40)*100).toFixed(2);
		$("input[name=revRatingPercentage]").val($scope.ReviewRatingVO.revRatingPercentage);
	}
	$().ready(function(){
		$(".clacPercentage").change(function(){
			calcPercentage()
		});
	});

	$scope.ConfirmReviewSubmit=function(ReviewRatingVO){

		$scope.projTitle=$scope.reviewProjTitle;
		$scope.ReviewRatingVO.ratingId=0;
		// $scope.ReviewRatingVO.revRgstrId=12;
		$scope.ReviewRatingVO.projteamLeaderId=$scope.projTeamLeaderId;
		$scope.ReviewRatingVO.projId=$scope.reviewProjID;

	};
	$scope.master = {};
	$scope.reset = function() {
		$('input[name=novelty]').attr('checked',false);
		$scope.ReviewRatingVO = angular.copy($scope.master);
		document.getElementById("reviewRatingForm").reset();

		$scope.reviewRatingForm.$setPristine();
	};
	$scope.submitReviewRating=function(){
		$scope.ReviewRatingVO.projTeamLeaderId=$scope.projTeamLeaderId;
		$scope.ReviewRatingVO.projId=
			$http({
				method : 'POST',
				url : 'submitReviewRating',
				data : $.param($scope.ReviewRatingVO),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}

			}).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					$scope.addMsg=[];
					$scope.addMsg.push("Review and Rating Submitted Successfully for The Project with Title::"+$scope.projTitle+"::");
				} else if(data.status == 'failure') {
					$scope.addMsgerror = [];
					$scope.addMsgerror.push("Some Problem Occured While Submitting the Review and Rating");
				}

			}).error(function(data, status, headers, config) {
				$scope.addMsgerror = [];
				$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
			})

	};
	
	$scope.saveReviewRating=function(){
		$scope.ReviewRatingVO.projteamLeaderId=$scope.projTeamLeaderId;
		$scope.projTitle=$scope.reviewProjTitle;
		$scope.ReviewRatingVO.ratingId=0;
		$scope.ReviewRatingVO.projId=$scope.reviewProjID;
			$http({
				method : 'POST',
				url : 'saveReviewRating',
				data : $.param($scope.ReviewRatingVO),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}

			}).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					$scope.saveSuccessMsg=[];
					$scope.saveSuccessMsg.push("Review and Rating Saved Successfully for The Project with Title::"+$scope.projTitle+"::");
				} else if(data.status == 'failure') {
					$scope.saveErrorMsg = [];
					$scope.saveErrorMsg.push("Some Problem Occured While Saving the Review and Rating");
				}

			}).error(function(data, status, headers, config) {
				$scope.Msgerror = [];
				$scope.Msgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
			})

	};
	
	/*$('#reviewRatingSaveResponseModal').on('hidden.bs.modal', function (e) {
		  $('#saveSuccessMsgDiv').hide();
		  $('#saveErrorMsgDiv').hide();
		  $('#MsgerrorDiv').hide();
		})*/
	
	$scope.viewGYTIProjDetails=function(projId){
		/*var self = this,  j= 0, counter = 0;
		self.modes = [ ];
		self.activated = true;
		self.determinateValue = 30;
		self.toggleActivation = function() {
			if ( !self.activated ) self.modes = [ ];
			if (  self.activated ) j = counter = 0;
		};

		$interval(function() {
			self.determinateValue += 1;
			if (self.determinateValue > 100) {
				self.determinateValue = 30;
			}
			if ( (j < 5) && !self.modes[j] && self.activated ) {
				self.modes[j] = 'indeterminate';
			}
			if ( counter++ % 4 == 0 ) j++;
		}, 100, 0, true);        */
		$http({
			method : 'POST',
			url : 'getGytiProjectDetailView',
			data : $.param({
				projId: projId

			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.GYTIProjectData=data;
			$scope.projBranchList=$scope.GYTIProjectData.projBranchList;
			$http({
				method : 'POST',
				url : 'studentDetailsLoadforReview',
				data : $.param({
					teamLeaderId: $scope.GYTIProjectData.projTeamLeaderId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.projteamLeader = data;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		})

	};
	$scope.clicktoExitAndResetData=function(){
		$scope.GYTIProjectData=null;
		$scope.projteamLeader=null;
		$scope.message = [];
		$scope.addMsgerror = [];
	};
	
	$scope.DownladPdf=function (projId){	
		$http({
			method : 'POST',
			url : 'getGytiProjectDetailView',
			data : $.param({
				projId: projId

			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.GYTIProjectData=data;
			$http({
				method : 'POST',
				url : 'getGytiProjectDetailsPdf',
				data : $.param({
					gytiProjectDetails : JSON.stringify($scope.GYTIProjectData)
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				window.location = 'downloadFile?fileName='+$scope.GYTIProjectData.projTitle;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		})
	
	};


});


techpedia.controller('reviewerStatusController',function($scope, $http,$filter,$timeout){
	$scope.itemsPerPage=10;
	$scope.InitLoad=function()
	{
		$scope.SelectedType="All Reviewers";


		// $scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'getAllReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {


			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = data;
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];
				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}

			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};


	$scope.SelectItemNumber=function(itemsPerPage) {
		$scope.sort = {       
				sortingOrder : "$index+1",
				reverse : false
		};

		// $scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'getAllReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {

			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = data;


			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};


			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


	};

	// Show Active Reviewers


	$scope.showActiveReviewers=function() {
		// alert("Active Reviewers====");
		$scope.SelectedType="Active Reviewers";


		// $scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'getActiveReviewers',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {


			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};

			// alert("Active******"+data.length);
			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = data;

			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});



	}


	// Show Deactive Reviewers
	$scope.showDeactiveReviewers=function() {
		// alert("Inactive Reviewers");
		$scope.SelectedType="Inactive Reviewers";


		// $scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'getDeactiveReviewers',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			// alert("Deactive");

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = data;

			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}
	$scope.layoutDone = function() {
		// $('a[data-toggle="tooltip"]').tooltip(); // NOT CORRECT!
		$timeout(function() {
			$('.ActivateReviewers').tooltip();
			$('.InActivateReviewers').tooltip();

		}, 0); // wait...
	}

	$scope.clickedReviewerDetails=function(reviewer){

		$scope.selectedReviewerName=reviewer.revFname;
		$scope.selectedUserId=reviewer.revUsrId;
	};

	/*
	 * data : $.param({}), url : 'getSuggestedBranches?q=' + $scope.searchTerm
	 */

	$scope.activateReviewer=function(userId,name){
		setTimeout(function() {
			$('#reviewerDetailModalToActivate').modal('hide');}, 1000);

		setTimeout(function() {
			$('#activateReviewerModal').modal('show');}, 2000);
		$http({
			method : 'POST',
			url : 'activateReviewerProfile',
			data : $.param({
				revUserId:userId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			// $('#reviewerDetailModalToActivate').modal('hide');

			if (data.status == 'success') {
				$scope.actMsg=[];
				$scope.actMsg.push("The Reviewer"+" "+name+" "+"\nhas been activated successfully.");
				$scope.InitLoad();
			} else {
				$scope.actMsgerror = [];
				$scope.addMsgerror.push("Some problem occured while activating the reviewer...");
				$scope.InitLoad();

			}

		}).error(function(data, status, headers, config) {
			$scope.actMsgerror = [];
			$scope.actMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.InitLoad();

		})

	};


	$scope.deActivateReviewer=function(userId,name){
		setTimeout(function() {
			$('#reviewerDetailModalToDeactivate').modal('hide');}, 1000);

		setTimeout(function() {
			$('#deActivateReviewerModal').modal('show');}, 2000);
		$http({
			method : 'POST',
			url : 'deActivateReviewerProfile',
			data : $.param({
				revUserId:userId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			// $('#reviewerDetailModalToDeactivate').modal('hide');
			setTimeout(function() {$('#reviewerDetailModalToDeactivate').modal('hide');}, 5000);
			if (data.status == 'success') {
				$scope.actMsg=[];
				$scope.actMsg.push("The Reviewer"+" "+name+" "+"\nhas been deactivated successfully.");
				$scope.InitLoad();
			} else {
				$scope.actMsgerror = [];
				$scope.addMsgerror.push("Some problem occured while deactivating the reviewer...");
				$scope.InitLoad();

			}

		}).error(function(data, status, headers, config) {
			$scope.actMsgerror = [];
			$scope.actMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.InitLoad();

		})

	};
	$scope.login=function(){
		alert("logged In hi....");
	}
});

techpedia.controller('revieweGYTIProjectsController',function($scope, $http,$filter,$timeout,$interval){

	$scope.InitLoad=function(){

		 var date = new Date();
		 $scope.currentYear = date.getFullYear();
		$http({
			method : 'POST',
			url : 'getAllGYTIProjetcByLoggdinReviewer',
			data : $.param({
				year:$scope.currentYear
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			// $('#reviewerDetailModalToActivate').modal('hide');
			/*
			 * alert("response:1:"+JSON.stringify(data));
			 * alert("response:2:"+JSON.stringify(data.projectsProposedForReview));
			 * alert("response:3:"+JSON.stringify(data.projectsOptionalForReview[0].projUniversity));
			 * alert("response:4:"+JSON.stringify(data.projectsAlreadyReviewed));
			 */
			$scope.projectsProposedForReview=data.projectsProposedForReview;
			$scope.projectsOptionalForReview=data.projectsOptionalForReview;
			$scope.projectsAlreadyReviewed=data.projectsAlreadyReviewed;
			$scope.projectsInProgressForReview=data.projectsInProgressForReview;
			$scope.projectsAcceptedForReview=data.projectsAcceptedForReview;
			
			console.log("photo path :: "+$scope.projectsOptionalForReview.photo1Path)

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.InitLoad();
		})
	};



	/*
	 * $('#datetimepicker9').datepicker({
	 * 
	 * onSelect: function(dateText, obj) {
	 * 
	 * $(this).css('background-color','');
	 * 
	 * alert('Selected: ' + dateText + "\nselectedYear: " + obj.selectedYear);
	 *  }
	 * 
	 * });
	 */


	$scope.selectYear =function(selectedYear){
		$http({
			method : 'POST',
			url : 'getAllGYTIProjetcByLoggdinReviewer',
			data : $.param({
				year:selectedYear
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			// $('#reviewerDetailModalToActivate').modal('hide');
			/*
			 * alert("response:1:"+JSON.stringify(data));
			 * alert("response:2:"+JSON.stringify(data.projectsProposedForReview));
			 * alert("response:3:"+JSON.stringify(data.projectsOptionalForReview[0].projUniversity));
			 * alert("response:4:"+JSON.stringify(data.projectsAlreadyReviewed));
			 */
			
			$scope.projectsProposedForReview=data.projectsProposedForReview;
			$scope.projectsOptionalForReview=data.projectsOptionalForReview;
			$scope.projectsAlreadyReviewed=data.projectsAlreadyReviewed;
			$scope.projectsInProgressForReview=data.projectsInProgressForReview;
			$scope.projectsAcceptedForReview=data.projectsAcceptedForReview;
			//alert("projectsInProcessForReview==="+$scope.projectsInProgressForReview.length);
			// alert("$scope.projectsProposedForReview=="+$scope.projectsProposedForReview.length);
			// alert("$scope.projectsOptionalForReview=="+$scope.projectsOptionalForReview.length);
			// alert("$scope.projectsAlreadyReviewed=="+$scope.projectsAlreadyReviewed.length);
			console.log("photo path :: "+$scope.projectsOptionalForReview.photo1Path)

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.InitLoad();
		})

	};
$(function () {
         $('#datetimepicker').datetimepicker({
        	 ignoreReadonly: true,
             viewMode: 'years',
				format: 'YYYY'
         });

         $("#datetimepicker").on("dp.change", function (e) {

         	
             if (e.timeStamp !== undefined) {
               var picker = $(this).data("DateTimePicker");
               var d = picker.date();
              $scope.selectYear(d.format('YYYY'));
             }
         }); 

         
     });

	$scope.clickReview = function(projId) {

		window.location = 'reviewInnovation'+ projId;
	};
	$scope.clickToForward= function(projId) {

		window.location = 'forwardProjectToReviewer' + projId;
	};

	$scope.EditReview= function(projId) {

		window.location = 'editReviewAndRating' + projId;
	};

	$scope.rejectReview=function(projId){
		$http({
			method : 'POST',
			url : 'rejectSuggestedProjectForReview',
			data : $.param({
				projId: projId

			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.addMsgSuccess = [];
			$scope.addMsgSuccess.push(data.description);


		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		})

	};
	
	$scope.acceptReview=function(projId){
		$http({
			method : 'POST',
			url : 'acceptSuggestedProjectForReview',
			data : $.param({
				projId: projId

			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.addMsgSuccess = [];
			$scope.addMsgSuccess.push(data.description);


		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		})

	};

	$scope.viewGYTIProjDetails=function(projId){

		var self = this,  j= 0, counter = 0;
		self.modes = [ ];
		self.activated = true;
		self.determinateValue = 30;
		self.toggleActivation = function() {
			if ( !self.activated ) self.modes = [ ];
			if (  self.activated ) j = counter = 0;
		};

		$interval(function() {
			self.determinateValue += 1;
			if (self.determinateValue > 100) {
				self.determinateValue = 30;
			}
			if ( (j < 5) && !self.modes[j] && self.activated ) {
				self.modes[j] = 'indeterminate';
			}
			if ( counter++ % 4 == 0 ) j++;
		}, 100, 0, true);        

		$http({
			method : 'POST',
			url : 'getGytiProjectDetailView',
			data : $.param({
				projId: projId

			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.GYTIProject=data;
			$scope.projBranchList=$scope.GYTIProject.projBranchList;
			$http({
				method : 'POST',
				url : 'studentDetailsLoadforReview',
				data : $.param({
					teamLeaderId: $scope.GYTIProject.projTeamLeaderId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.projteamLeader = data;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		})

	};
	$scope.clicktoExitAndResetData=function(){
		$scope.GYTIProject=null;
		$scope.projteamLeader=null;
		$scope.message = [];
		$scope.addMsgerror = [];
	};


	$scope.DownladPdf=function (){
		$http({
			method : 'POST',
			url : 'getGytiProjectDetailsPdf',
			data : $.param({
				gytiProjectDetails : JSON.stringify($scope.GYTIProject)
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			window.location = 'downloadFile?fileName='+$scope.GYTIProject.projTitle;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.dataTab = {
			selectedIndex: 0,
			secondLocked:  true,
			secondLabel:   "Item Two",
			bottom:        false
	};
	$scope.next = function() {
		$scope.dataTab.selectedIndex = Math.min($scope.dataTab.selectedIndex + 1, 2) ;
	};
	$scope.previous = function() {
		$scope.dataTab.selectedIndex = Math.max($scope.dataTab.selectedIndex - 1, 0);
	};

	$scope.ClickDownladPdf=function (ratingId,projTitle,reviewedBy){
		$http({
			method : 'POST',
			url : 'getAllReviewsPdf',
			data : $.param({
				ngOverallCalculatedReviewRatings : JSON.stringify($scope.ngOverallCalculatedReviewRatingVOs)
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			window.location = 'downloadFile';
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

});

techpedia.controller('forwardProjectToReviewerController',function($scope, $http,$filter,$timeout){

	$scope.InitLoad=function(){
		// alert("inside init load");


		$http({
			method : 'POST',
			url : 'getGytiProjectDetails',
			data : $.param({
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.GYTIProject=data;
			$scope.projBranchList=$scope.GYTIProject.projBranchList;
			// alert("innovation Title****"+$scope.GYTIProject.projTitle);
		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		})

		$http({
			method : 'POST',
			url : 'forwardProjectToReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.reviewerList = data;

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


	};	
	$scope.assignReviewers = function(projId,loggedInReviewerId){

		$scope.suggestReviewers = [];

		var checkboxArray=document.getElementsByName("assign[]");

		for(var i=0;i<checkboxArray.length;i++){

			if(checkboxArray[i].checked){
				// alert(checkboxArray[i].value);
				$scope.suggestReviewers.push({
					projId:projId,
					revRgstrId:parseFloat(checkboxArray[i].value),
					assignedBy:loggedInReviewerId
				});
			}
		}
		var data =JSON.stringify($scope.suggestReviewers);
		$http({
			method : 'POST',
			url : 'suggestReviewer',
			data :  $.param({allSuggestedReviewers:JSON.stringify($scope.suggestReviewers)}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			// alert("success*****"+data.description);
			$scope.successMsg=[];
			$scope.successMsg.push(data.description);
		}).error(function(data, status, headers, config) {
			$scope.errorMsg = [];
			$scope.errorMsg.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}


	$scope.getReviewerDetails = function(reviewerEmailId){
		// alert("reviewerId==="+reviewerEmailId);
		$http({
			method : 'POST',
			url : 'getReviewerDetails',
			data : $.param({
				reviewerEmailId:reviewerEmailId,
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.reviewerDetails = data;
			// alert("success====="+$scope.reviewerDetails.revFname);

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	}

});

techpedia.controller('EditReviewRatingController', function($scope,$http) {
	$scope.InitLoad=function(){
		 $("#notifySuggestReviewerDiv").hide();
		 $("#moreInfoRequiredDiv").hide();
		 $("#moreCommentDiv").hide();
    	 $("#moreCommentButtonDiv").hide();
		$scope.addMsg=[];
		$scope.addMsgerror = [];
		document.getElementById("revRatingPercentage").readOnly = true;

		$http({
			method : 'POST',
			url : 'editProjectReviewRating',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.GYTIProject=data;
			$scope.projTeamLeaderId=$scope.GYTIProject.projTeamLeaderId;
			$scope.reviewProjID=$scope.GYTIProject.projId;
			$scope.reviewProjTitle=$scope.GYTIProject.projTitle;
			$scope.projBranchList=$scope.GYTIProject.projBranchList;
		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		$http({
			method : 'POST',
			url : 'getGytiProjectReviewDetailforEdit',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.ReviewRatingVO=data;
			//alert($scope.ReviewRatingVO.suggestToOtherRev);
			$scope.revRecommendation=$scope.ReviewRatingVO.revRecommendation;
			/*
			 * for(var i=1;i<=10;i++){
			 *  }
			 */
			// alert("Recommandation::"+$scope.ReviewRatingVO.revRecommendation);
			if($scope.ReviewRatingVO.revRecommendation=="Worthy to Award"){
				/*
				 * alert("Recommandation::"+$scope.ReviewRatingVO.revRecommendation);
				 * $('input:radio[value="Worthy to Award"]').attr('checked',
				 * 'checked');
				 */
				var x=	document.getElementById("option1").checked = true;
				$("input:radio[value='Worthy to Award']").attr('checked', 'checked');

				var $radios = $('#option1');
				/*
				 * alert("Radios"+$radios); $radios.filter('[value="Worthy to
				 * Award"]').prop('checked', true);
				 */		

				/* alert("status1111555::"+x); */
			}
			/*
			 * if($scope.ReviewRatingVO.revRecommendation=="Can be considered
			 * for appreciation"){
			 * alert("Recommandation::"+$scope.ReviewRatingVO.revRecommendation);
			 * var y= document.getElementById("option2").checked = true;
			 * alert("status::"+y); }
			 * if($scope.ReviewRatingVO.revRecommendation=="None of the above
			 * Two"){
			 * alert("Recommandation::"+$scope.ReviewRatingVO.revRecommendation);
			 * var z=document.getElementById("option3").checked = true;
			 * alert("status::"+z); }
			 */


			var recommendationArray=document.getElementsByName("revRecommendation");
			for (var i=0;i<recommendationArray.length;i++) {
				if(recommendationArray[i].value==$scope.ReviewRatingVO.revRecommendation){
					recommendationArray[i].parentNode.MaterialRadio.check();
				}

			}

			var noveltyArray=document.getElementsByName("novelty");
			for (var i=0;i<noveltyArray.length;i++) {
				if(noveltyArray[i].value==$scope.ReviewRatingVO.revNovelty){
					noveltyArray[i].parentNode.MaterialRadio.check();
				}

			}

			var revTechnicalRigorArray=document.getElementsByName("revTechnicalRigor");
			for (var i=0;i<revTechnicalRigorArray.length;i++) {
				if(revTechnicalRigorArray[i].value==$scope.ReviewRatingVO.revTechnicalRigor){
					revTechnicalRigorArray[i].parentNode.MaterialRadio.check();
				}

			}

			var revSocialApplicationArray=document.getElementsByName("revSocialApplication");
			for (var i=0;i<revSocialApplicationArray.length;i++) {
				if(revSocialApplicationArray[i].value==$scope.ReviewRatingVO.revSocialApplication){
					revSocialApplicationArray[i].parentNode.MaterialRadio.check();
				}

			}

			var revFrugalityArray=document.getElementsByName("revFrugality");
			for (var i=0;i<revFrugalityArray.length;i++) {
				if(revFrugalityArray[i].value==$scope.ReviewRatingVO.revFrugality){
					revFrugalityArray[i].parentNode.MaterialRadio.check();
				}

			}
			
			var moreInfoNeededArray=document.getElementsByName("moreInfoNeeded");
			for (var i=0;i<moreInfoNeededArray.length;i++) {
				if(moreInfoNeededArray[i].value==$scope.ReviewRatingVO.moreInfoNeeded){
					moreInfoNeededArray[i].parentNode.MaterialRadio.check();
				}

			}
			
			var suggestToOtherRevArray=document.getElementsByName("suggestToOtherRev");
			for (var i=0;i<suggestToOtherRevArray.length;i++) {
				if(suggestToOtherRevArray[i].value==$scope.ReviewRatingVO.suggestToOtherRev){
					suggestToOtherRevArray[i].parentNode.MaterialRadio.check();
				}

			}






		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		});



	};
	
	$scope.ClickReviewRatingForSuggestReviewer=function(){
		$('#suggestedReviewerName').val("");
		$('#suggestedReviewerEmail').val("");

	};
	
	$scope.ClickReviewRatingForMoreInfo=function(){
		$('#moreInfoNeededRemarks').val("");
		$('#comments').val("");

	};
	
	$(document).ready(function(){
	    $('input[type="radio"]').click(function(){
	        if($(this).attr("value")=="Suggest to other Reviewer"){
	        	 $("#mainDiv").hide();
	        	 $("#buttonsDiv").hide();
	        	 $("#moreInfoRequiredDiv").hide();
	        	 $("#notifySuggestReviewerDiv").show(); 
	        }
	        if($(this).attr("value")=="Worthy to Award" || $(this).attr("value")=="Can be considered for appreciation" || $(this).attr("value")=="None of the above Two"){
	        	  $("#mainDiv").show();
	        	  $("#buttonsDiv").show();
	        	  $("#notifySuggestReviewerDiv").hide();
	        	  $("#moreInfoRequiredDiv").hide();
	        }
	        if($(this).attr("value")=="More Information Required"){
	        	 $("#mainDiv").hide();
	        	 $("#buttonsDiv").hide();
	        	 $("#notifySuggestReviewerDiv").hide();
	        	 $("#moreInfoRequiredDiv").show();
	        }
	        
	        if($(this).attr("id")=="moreInfoNeeded9"){
	        	 $("#mainDiv").show();
	        	 $("#buttonsDiv").show();
	        	 $("#notifySuggestReviewerDiv").hide();
	        	 $("#moreCommentDiv").show();
	        	 $("#moreCommentButtonDiv").show();
	        }
	        if($(this).attr("id")=="moreInfoNeeded10"){
	        	 $("#mainDiv").show();
	        	 $("#buttonsDiv").show();
	        	 $("#notifySuggestReviewerDiv").hide();
	        	 $("#moreCommentDiv").hide();
	        	 $("#moreCommentButtonDiv").hide();
	        }
	        if($(this).attr("id")=="suggestToOtherRev9"){
	        	 $("#mainDiv").show();
	        	 $("#buttonsDiv").show();
	        	 $("#notifySuggestReviewerDiv").show();
	        	 $("#moreInfoRequiredDiv").hide();
	        }
	        
	        if($(this).attr("id")=="suggestToOtherRev10"){
	        	 $("#mainDiv").show();
	        	 $("#buttonsDiv").show();
	        	 $("#notifySuggestReviewerDiv").hide();
	        	 $("#moreInfoRequiredDiv").hide();
	        }
	        
	    });
	   
	 
	});
	
	
	$scope.notifyReviewer=function(loggedInReviewerId,suggestedReviewerName,suggestedReviewerEmail){
		 $('#loderDiv').show();
		$scope.NotifyReviewerVo={};
		$scope.NotifyReviewerVo.suggestedReviewerName=suggestedReviewerName;
		$scope.NotifyReviewerVo.suggestedReviewerEmail=suggestedReviewerEmail;
		$scope.NotifyReviewerVo.projectTitle=$scope.GYTIProject.projTitle;
		$scope.NotifyReviewerVo.projectAbstract=$scope.GYTIProject.projAbstract;
		$http({
			method : 'POST',
			url : 'notifySuggestedReviewer',
			data : $.param($scope.NotifyReviewerVo),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if(data.status==="success"){
				$scope.description = data.description;
				
				$http({
					method : 'POST',
					url : 'getReviewerDetails',
					data : $.param({
						reviewerEmailId:$scope.NotifyReviewerVo.suggestedReviewerEmail,
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.reviewerDetails = data;
					$scope.suggestReviewers = [];
					
					$scope.suggestReviewers.push({
						projId:$scope.GYTIProject.projId,
						revRgstrId:$scope.reviewerDetails.revRgstrId,
						assignedBy:loggedInReviewerId
					});
					
					var data =JSON.stringify($scope.suggestReviewers);
					$http({
						method : 'POST',
						url : 'suggestReviewer',
						data :  $.param({allSuggestedReviewers:JSON.stringify($scope.suggestReviewers)}),
						headers : {
							'Content-Type' : 'application/x-www-form-urlencoded'
						}
					}).success(function(data, status, headers, config) {
						// alert("suggest success*****"+data.description);
						 $scope.messageSuccess = [];
						 $scope.messageSuccess.push($scope.description+" And"+data.description);
						 $('#loderDiv').hide();
						 $('#messageSuccessDiv').show();
					}).error(function(data, status, headers, config) {
						$scope.errorMsg = [];
						$scope.errorMsg.push("Possibly the service is down, Please contact the admin if problem persists.");
					});

				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
			
				
				
			}
			else if(data.exceptionMessage==="UserNotFoundException"){
				$scope.messageWarning = [];
				$scope.messageWarning.push(data.exceptionDetails);
				 $('#loderDiv').hide();
				$('#messageWarningDiv').show();
			}
			else if(data.status==="success with Email error"){
				$scope.messageWarning = [];
				$scope.messageWarning.push(data.description);
				 $('#loderDiv').hide();
				$('#messageWarningDiv').show();
			}
			else{
				$scope.message = [];
				$scope.message.push("Notify to suggested Reviewer failed for other reasons, Please contact your site admin.");
				 $('#loderDiv').hide();
				$('#messageDiv').show();

			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			$('#loderDiv').hide();
			$('#messageDiv').show();
		});
		
	};
	
	$('#notifyReviewerModal').on('hidden.bs.modal', function (e) {
		  $(this)
		    .find("input,textarea")
		       .val('')
		       .end();
		  $('#messageSuccessDiv').hide();
		  $('#messageWarningDiv').hide();
		  $('#messageDiv').hide();
		  $('#loderDiv').hide();
		});

		
    $scope.moreInformationComments=function(comments){
    	 $('#loderDiv').show();
		$scope.MoreInfoRequiredVO={};
		
		$http({
			method : 'POST',
			url : 'ajax/teamLeaderProfileLoad',
			data :$.param({
				 projTeamLeaderId:$scope.GYTIProject.projTeamLeaderId,
				}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.teamLeaderDetails = data;
			$scope.MoreInfoRequiredVO.teamLeaderEmailId = $scope.teamLeaderDetails.email;
			$scope.MoreInfoRequiredVO.reviewerComments=comments;
			$scope.MoreInfoRequiredVO.projectTitle=$scope.GYTIProject.projTitle;
			$scope.MoreInfoRequiredVO.projectAbstract=$scope.GYTIProject.projAbstract;
			
			$http({
				method : 'POST',
				url : 'sendMoreInfoRequestToTeamLeader',
				data : $.param($scope.MoreInfoRequiredVO),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				if(data.status==="success"){
					 $scope.messageSuccess = [];
					 $scope.messageSuccess.push(data.description+" to"+$scope.MoreInfoRequiredVO.teamLeaderEmailId);
					 $('#loderDiv').hide();
					 $('#messageSuccessDiv').show();
					 
				}
				else if(data.exceptionMessage==="UserNotFoundException"){
					$scope.messageWarning = [];
					$scope.messageWarning.push(data.exceptionDetails);
					$('#loderDiv').hide();
					$('#messageWarningDiv').show();
				}
				else if(data.status==="success with Email error"){
					$scope.messageWarning = [];
					$scope.messageWarning.push(data.description);
					$('#loderDiv').hide();
					$('#messageWarningDiv').show();
				}
				else{
					$scope.message = [];
					$scope.message.push("More information required for the project failed for other reasons, Please contact your site admin.");
					$('#loderDiv').hide();
					$('#messageDiv').show();
				}
				
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				$('#loderDiv').hide();
				$('#messageDiv').show();
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			$('#loderDiv').hide();
			$('#messageDiv').show();
		});
	}
	
	$('#moreInfoRequiredModal').on('hidden.bs.modal', function (e) {
		 $(this)
		    .find("input,textarea")
		       .val('')
		       .end();
		  $('#messageSuccessDiv').hide();
		  $('#messageWarningDiv').hide();
		  $('#messageDiv').hide();
		  $('#loderDiv').hide();
		});

	function calcPercentage(){
		var score = 0;
		$(".clacPercentage:checked").each(function(){
			score+=parseInt($(this).val(),10);
		});
		$scope.ReviewRatingVO.revRatingPercentage=((score/40)*100).toFixed(2);
		$("input[name=revRatingPercentage]").val($scope.ReviewRatingVO.revRatingPercentage);
	}
	$().ready(function(){
		$(".clacPercentage").change(function(){
			calcPercentage()
		});
	});

	$scope.ConfirmReviewSubmit=function(ReviewRatingVO){

		$scope.projTitle=$scope.reviewProjTitle;
		// $scope.ReviewRatingVO.ratingId=0;
		// $scope.ReviewRatingVO.revRgstrId=12;
		$scope.ReviewRatingVO.projteamLeaderId=$scope.projTeamLeaderId;
		$scope.ReviewRatingVO.projId=$scope.reviewProjID;

	};
	$scope.master = {};
	$scope.reset = function() {
		$('input[name=novelty]').attr('checked',false);
		$scope.ReviewRatingVO = angular.copy($scope.master);
		document.getElementById("reviewRatingForm").reset();

		$scope.reviewRatingForm.$setPristine();
	};
	$scope.updateReviewRating=function(){
		$scope.ReviewRatingVO.projTeamLeaderId=$scope.projTeamLeaderId;
		$http({
			method : 'POST',
			url : 'updateReviewRating',
			data : $.param($scope.ReviewRatingVO),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.addMsg=[];
				$scope.addMsg.push("Review and Rating Updated Successfully for The Project with Title::"+$scope.projTitle+"::");
			} else if(data.status == 'failure') {
				$scope.addMsgerror = [];
				$scope.addMsgerror.push("Some Problem Occured While Updating the Review and Rating");
			}

		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		})

	};
	
	
	$scope.submitReviewRating=function(){
		$scope.ReviewRatingVO.projTeamLeaderId=$scope.projTeamLeaderId;
		$scope.ReviewRatingVO.projId=
			$http({
				method : 'POST',
				url : 'submitReviewRating',
				data : $.param($scope.ReviewRatingVO),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}

			}).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					$scope.addMsg=[];
					$scope.addMsg.push("Review and Rating Submitted Successfully for The Project with Title::"+$scope.projTitle+"::");
				} else if(data.status == 'failure') {
					$scope.addMsgerror = [];
					$scope.addMsgerror.push("Some Problem Occured While Submitting the Review and Rating");
				}

			}).error(function(data, status, headers, config) {
				$scope.addMsgerror = [];
				$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
			})

	};
	
	$scope.saveReviewRating=function(){
		$scope.ReviewRatingVO.projteamLeaderId=$scope.projTeamLeaderId;
		$scope.projTitle=$scope.reviewProjTitle;
		$scope.ReviewRatingVO.ratingId=0;
		$scope.ReviewRatingVO.projId=$scope.reviewProjID;
			$http({
				method : 'POST',
				url : 'saveReviewRating',
				data : $.param($scope.ReviewRatingVO),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}

			}).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					$scope.saveSuccessMsg=[];
					$scope.saveSuccessMsg.push("Review and Rating Saved Successfully for The Project with Title::"+$scope.projTitle+"::");
				} else if(data.status == 'failure') {
					$scope.saveErrorMsg = [];
					$scope.saveErrorMsg.push("Some Problem Occured While Saving the Review and Rating");
				}

			}).error(function(data, status, headers, config) {
				$scope.Msgerror = [];
				$scope.Msgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
			})

	};
	
});

techpedia.controller('getAllReviewsController', function($scope, $http,$filter,$timeout) {
	$scope.InitLoad = function() {
		$scope.assignedByAndReviewDoneByMapper=[];
		$scope.allReviews=[];
		$scope.AllReviewer=[];
		 var date = new Date();
		 $scope.currentYear = date.getFullYear();
		$http({
			method : 'POST',
			url : 'getAllReviewsByAdmin',
			data : $.param({
				year:$scope.currentYear
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			/*
			 * $scope.allReviews =[]; $scope.Reviewers=[]; angular.forEach(data,
			 * function(allReviewsAndRating) {
			 * $scope.allReviews.push(allReviewsAndRating);
			 * angular.forEach(allReviewsAndRating.assignedByAndReviewDoneByMapperSet,
			 * function(reviewers) { if ($scope.Reviewers.indexOf(reviewers) ==
			 * -1) { $scope.Reviewers.push(reviewers); } }); });
			 */
			$scope.ngOverallCalculatedReviewRatingVOs =[];
			angular.forEach(data, function(overallCalculatedReviewRatingVO, index) {
				$scope.ngOverallCalculatedReviewRatingVOs.push(overallCalculatedReviewRatingVO);
			});
			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};
			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =10;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.ngOverallCalculatedReviewRatingVOs;
			// alert(JSON.stringify($scope.items));
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];
				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}

			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};

	$scope.getAllReviewsPdf=function(){
		$http({
			method : 'POST',
			url : 'getAllReviewsPdf',
			data : $.param({
				ngOverallCalculatedReviewRatings : JSON.stringify($scope.ngOverallCalculatedReviewRatingVOs)
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			window.location = 'downloadFile?fileName=AllReviewedProjects';
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.getAllReviewsXls=function(){
		$http({
			method : 'POST',
			url : 'getAllReviewsXls',
			data : $.param({
				ngOverallCalculatedReviewRatings : JSON.stringify($scope.ngOverallCalculatedReviewRatingVOs)
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			window.location = 'downloadXlsFile?fileName=AllReviewedProjects';
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$scope.ShowDetailsReview=function (ratingId,projTitle,reviewedBy){
		$scope.projectTitle=projTitle;
		$scope.reviewedBy=reviewedBy;
		$http({
			method : 'POST',
			url : 'getReviewsAndRatingByReviewer',
			data : $.param({
				ratingId:ratingId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.getReviewsByReviewer = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$scope.downloadProjectSpecificReviewsPdf=function(projId){
		$http({
			method : 'POST',
			url : 'downloadProjectSpecificReviewsPdf',
			data : $.param({
				projId : projId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			window.location = 'downloadFile?fileName=ProjectReviewRatings['+projId+']';
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};


	$scope.selectYear =function(selectedYear){
		// alert("getAllReviews==="+selectedYear);
		$http({
			method : 'POST',
			url : 'getAllReviewsByAdmin',
			data : $.param({
				year:selectedYear
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			/*
			 * $scope.allReviews =[]; $scope.Reviewers=[]; angular.forEach(data,
			 * function(allReviewsAndRating) {
			 * $scope.allReviews.push(allReviewsAndRating);
			 * angular.forEach(allReviewsAndRating.assignedByAndReviewDoneByMapperSet,
			 * function(reviewers) { if ($scope.Reviewers.indexOf(reviewers) ==
			 * -1) { $scope.Reviewers.push(reviewers); } }); });
			 */
			$scope.ngOverallCalculatedReviewRatingVOs =[];
			angular.forEach(data, function(overallCalculatedReviewRatingVO, index) {
				$scope.ngOverallCalculatedReviewRatingVOs.push(overallCalculatedReviewRatingVO);
			});
			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};
			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =10;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.ngOverallCalculatedReviewRatingVOs;
			// alert(JSON.stringify($scope.items));
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];
				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}

			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};
	$(function () {
        $('#datetimepicker').datetimepicker({
          ignoreReadonly: true,
            viewMode: 'years',
				format: 'YYYY'
				
        });

        $("#datetimepicker").on("dp.change", function (e) {

        	
            if (e.timeStamp !== undefined) {
              var picker = $(this).data("DateTimePicker");
              var d = picker.date();
             $scope.selectYear(d.format('YYYY'));
            }
        }); 

        
    });
});

techpedia.controller('suggestedReviewersByLoggedInReviewerController', function($scope, $http,$filter,$timeout) {
	$scope.itemsPerPage=10;
	$scope.SelectedType="All Innovations";
	$scope.errorMessage="Sorry,No Reviewer has been Suggested By you....";
	$scope.InitLoad=function()
	{	
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$http({
			method : 'POST',
			url : 'getSuggestedReviewersByLoggedInReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.data= data.length;
			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = data;
			
			
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0){
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];
				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}

			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();


		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};

	$scope.SelectItemNumber=function(itemsPerPage) {
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$scope.sort = {       
				sortingOrder : "$index+1",
				reverse : false
		};

		// $scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'getSuggestedReviewersByLoggedInReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {

			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = data;
			
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0){
				$("#noInfo").show();
				$("#angularLoader").hide();
			}

			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};


			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


	};
	

	/* Pending status */


	$scope.showPendingStatus=function() {
		// alert("pending****");
		$scope.items=[];
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Pending";
		$scope.errorMessage="Sorry,No Suggested Reviewers with pending review";
		$http({
			method : 'POST',
			url : 'getSuggestedReviewersByLoggedInReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.pendingData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='pending'){
					$scope.pendingData.push(angular.copy(data[i]));
				}
			}

			// alert("pendingData Data length==="+$scope.pendingData.length);

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.pendingData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}else if($scope.items.length==undefined || $scope.items.length==0){
			
				$("#noInfo").show();
				$("#angularLoader").hide();
			}

			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}

	

	/* Accepted status */


	$scope.showAccepetedStatus=function() {
		$scope.items=[];
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Accepted";
		$scope.errorMessage="Sorry,No Suggested Reviewers accept the Innovation";

		// $scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'getSuggestedReviewersByLoggedInReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {


			$scope.accepetedData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='accepted'){
					$scope.accepetedData.push(angular.copy(data[i]));
				}
			}

			// alert("accepeted Data length==="+$scope.accepetedData.length);
			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};

			// alert("Active******"+data.length);
			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.accepetedData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}

			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});



	}
	
	
	

	/* InProgress status */


	$scope.showInProgressStatus=function() {
		// alert("InProgress****");
		$scope.items=[];
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Pending";
		$scope.errorMessage="Sorry,No Suggested Reviewers with inProgress review";
		$http({
			method : 'POST',
			url : 'getSuggestedReviewersByLoggedInReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.inProgressData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='inProgress'){
					$scope.inProgressData.push(angular.copy(data[i]));
				}
			}

			// alert("pendingData Data length==="+$scope.pendingData.length);

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.inProgressData;
			//alert("length===="+$scope.items.length);
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}

			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}




	/* Rejected status */


	$scope.showRejectedStatus=function() {
		$scope.items=[];
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Rejected";
		$scope.errorMessage="Sorry,No Suggested Reviewers rejected the Innovation";
		$http({
			method : 'POST',
			url : 'getSuggestedReviewersByLoggedInReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.rejectedData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='rejected'){
					$scope.rejectedData.push(angular.copy(data[i]));
				}
			}

			// alert("pendingData Data length==="+$scope.pendingData.length);

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.rejectedData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}

	

	/* Reviewed status */


	$scope.showReviewedStatus=function() {
		$scope.items=[];
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Reviewed";
		$scope.errorMessage="Sorry,No Suggested Reviewers reviewed the Innovation";
		$http({
			method : 'POST',
			url : 'getSuggestedReviewersByLoggedInReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.reviewedData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='reviewed'){
					$scope.reviewedData.push(angular.copy(data[i]));
				}
			}

			// alert("pendingData Data length==="+$scope.pendingData.length);

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.reviewedData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}



});

techpedia.controller('adminGetAllSuggestedReviewersController', function($scope, $http,$filter,$timeout) {
	$scope.itemsPerPage=10;
	$scope.SelectedType="All Innovations";
	$scope.errorMessage="Sorry,No Suggested Reviewers....";
	$scope.InitLoad=function()
	{
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$http({
			method : 'POST',
			url : 'adminGetAllSuggestedReviewersList',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.data= data.length;
			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = data;

			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0){
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];
				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}

			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();


		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};

	$scope.SelectItemNumber=function(itemsPerPage) {
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$scope.sort = {       
				sortingOrder : "$index+1",
				reverse : false
		};

		// $scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'adminGetAllSuggestedReviewersList',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {

			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = data;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0){
				$("#noInfo").show();
				$("#angularLoader").hide();
			}

			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};


			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


	};
	
	
	/* Pending status */


	$scope.showPendingStatus=function() {
		// alert("pending****");
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Pending";
		$scope.errorMessage="Sorry,No Suggested Reviewers with pending review";
		$http({
			method : 'POST',
			url : 'adminGetAllSuggestedReviewersList',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.pendingData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='pending'){
					$scope.pendingData.push(angular.copy(data[i]));
				}
			}

			// alert("pendingData Data length==="+$scope.pendingData.length);

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.pendingData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}


	/* Accepted status */


	$scope.showAccepetedStatus=function() {
		// alert("Accepted status");
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Accepted";
		$scope.errorMessage="Sorry,No Suggested Reviewers accept the Innovation";


		// $scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'adminGetAllSuggestedReviewersList',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {

			$scope.accepetedData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='accepted'){
					$scope.accepetedData.push(angular.copy(data[i]));
				}
			}

			// alert("accepeted Data length==="+$scope.accepetedData.length);
			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};

			// alert("Active******"+data.length);
			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.accepetedData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});



	}


	

	/* Rejected status */


	$scope.showRejectedStatus=function() {
		// alert("Rejected****");
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Rejected";
		$scope.errorMessage="Sorry,No Suggested Reviewers rejected the Innovation";
		$http({
			method : 'POST',
			url : 'adminGetAllSuggestedReviewersList',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.rejectedData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='rejected'){
					$scope.rejectedData.push(angular.copy(data[i]));
				}
			}

			// alert("pendingData Data length==="+$scope.pendingData.length);

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.rejectedData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}
	
	/* InProgress status */


	$scope.showInProgressStatus=function() {
		// alert("Inprogress****");
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Inprogress";
		$scope.errorMessage="Sorry,No Suggested Reviewers with inProgress review";
		$http({
			method : 'POST',
			url : 'adminGetAllSuggestedReviewersList',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.inProgressData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='inProgress'){
					$scope.inProgressData.push(angular.copy(data[i]));
				}
			}

			// alert("pendingData Data length==="+$scope.pendingData.length);

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.inProgressData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}
	
	
	/* Reviewed status */


	$scope.showReviewedStatus=function() {
		// alert("pending****");
		$("#angularLoader").show();
		$("#tableDataBody").hide();
		$("#noInfo").hide();
		$scope.SelectedType="Reviewed";
		$scope.errorMessage="Sorry,No Suggested Reviewers reviewed the Innovation";
		$http({
			method : 'POST',
			url : 'adminGetAllSuggestedReviewersList',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.reviewedData = [];

			for(var i=0;i<data.length;i++){
				// alert("status******"+data[i].status);
				if(data[i].status=='reviewed'){
					$scope.reviewedData.push(angular.copy(data[i]));
				}
			}

			// alert("pendingData Data length==="+$scope.pendingData.length);

			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};


			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =$scope.itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.reviewedData;
			if($scope.items.length>0){
				$("#angularLoader").hide();
				$("#tableDataBody").show();
				$("#noInfo").hide();
			}
			else if($scope.items.length==undefined || $scope.items.length==0)
			{
				$("#noInfo").show();
				$("#angularLoader").hide();
			}
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];

				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}
			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}


});



techpedia.controller('EditReviewerController',function($scope, $http){
	$scope.message = [];
	$scope.editReviewer = {};
	$scope.InitLoad=function()
	{
		$scope.message = [];
		$scope.messageSuccess = [];
		$scope.messageWarning = [];
		// do some action here

		$http({
			method : 'POST',
			url : 'editReviewerProfileLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.editReviewer = data;
			
			var ReviewerStateArray = [];
			var ReviewerStateArrayJson = {};
			ReviewerStateArrayJson.id = $scope.editReviewer.revState;
			ReviewerStateArrayJson.text = $scope.editReviewer.revState;
			ReviewerStateArray.push(ReviewerStateArrayJson);
			$("#state").select2("data",ReviewerStateArray);
			
			var ReviewerCityArray = [];
			var ReviewerCityArrayJson = {};
			ReviewerCityArrayJson.id =$scope.editReviewer.revCity;
			ReviewerCityArrayJson.text =$scope.editReviewer.revCity;
			ReviewerCityArray.push(ReviewerCityArrayJson);
			$("#city").select2("data",ReviewerCityArray);
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};


	$scope.deleteState = function(){
		$scope.editReviewer.revState = "";
		$('#state').select2('data',null);
		$('#s2id_state').show();
	};
	$scope.showState = function(){
		try{
			if($scope.editReviewer.revState === ''){
				$('#s2id_state').show();
			}else{
				$('#s2id_state').hide();
			}
			return $scope.editReviewer.revState === '';
		}catch(e){}
	};

	$scope.deleteCity = function(){
		$scope.editReviewer.revCity = "";
		$('#city').select2('data',null);
		$('#s2id_city').show();
	};
	$scope.showCity = function(){
		try{
			if($scope.editReviewer.revCity === ''){
				$('#s2id_city').show();
			}else{
				$('#s2id_city').hide();
			}
			return $scope.editReviewer.revCity === '';
		}catch(e){}
	};

	$scope.showError = function() {
		$('#pwdError').show();
	};
	$scope.hideError = function() {
		$('#pwdError').hide();
	};


	$scope.updateReviewer=function(){

		$http({
			method : 'POST',
			url : 'UpdateReviwerByAdmin',
			data : $.param($scope.editReviewer),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if(data.status==="success"){
				$scope.messageSuccess = [];
				$scope.messageSuccess.push(data.description);
			}
			else if (data.status==="failure") {
				$scope.message = [];
				$scope.message.push(data.description);
			}
			else{
				$scope.message = [];
				$scope.message.push("Details updating failed for other reasons, Please contact your site admin.");

			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		})


	};

});

techpedia.controller('allReviewsByLoggedInReviewerController', function($scope, $http,$filter,$timeout) {

	$scope.InitLoad = function() {
		$scope.assignedByAndReviewDoneByMapper=[];
		$scope.allReviews=[];
		$scope.AllReviewer=[];
		var date = new Date();
		 $scope.currentYear = date.getFullYear();
		$http({
			method : 'POST',
			url : 'getAllReviewsByLoggedInReviewerAndOthers',
			data : $.param({
				year:$scope.currentYear
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			/*
			 * $scope.allReviews =[]; $scope.Reviewers=[]; angular.forEach(data,
			 * function(allReviewsAndRating) {
			 * $scope.allReviews.push(allReviewsAndRating);
			 * angular.forEach(allReviewsAndRating.assignedByAndReviewDoneByMapperSet,
			 * function(reviewers) { if ($scope.Reviewers.indexOf(reviewers) ==
			 * -1) { $scope.Reviewers.push(reviewers); } }); });
			 */
			$scope.reviedByLoggedInReviewer =[];
			$scope.reviedByOthersReviewer =[];

			angular.forEach(data.overallCalculatedReviewRatingsByLoggedInReviewer, function(overallCalculatedReviewRatingVOByLoggedinReviewer, index) {
				$scope.reviedByLoggedInReviewer.push(overallCalculatedReviewRatingVOByLoggedinReviewer);
			});
			angular.forEach(data.overallCalculatedReviewRatingsByOtherReviewers, function(overallCalculatedReviewRatingVOByOthers, index) {
				$scope.reviedByOthersReviewer.push(overallCalculatedReviewRatingVOByOthers);
			});
			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};
			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =10;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.reviedByLoggedInReviewer;
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];
				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}

			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};

	$scope.showReviewdByLoggedInReviewer=function(){

		$scope.sort = {       
				sortingOrder : "$index+1",
				reverse : false
		};
		$scope.filteredItems = [];
		$scope.groupedItems = [];
		$scope.itemsPerPage =10;
		$scope.pagedItems = [];
		$scope.currentPage = 0;
		$scope.items = $scope.reviedByLoggedInReviewer;
		// alert(JSON.stringify($scope.items));
		var searchMatch = function (haystack, needle) {
			if (!needle) {
				return true;
			}
			return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
		};

		// init the filtered items
		$scope.search = function () {
			$scope.filteredItems = $filter('filter')($scope.items, function (item) {
				for(var attr in item) {
					if (searchMatch(item[attr], $scope.query))
						return true;
				}
				return false;
			});
			// take care of the sorting order
			if ($scope.sort.sortingOrder !== '') {
				$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
			}
			$scope.currentPage = 0;
			// now group by pages
			$scope.groupToPages();
		};


		// calculate page in place
		$scope.groupToPages = function () {
			$scope.pagedItems = [];
			for (var i = 0; i < $scope.filteredItems.length; i++) {
				if (i % $scope.itemsPerPage === 0) {
					$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
				} else {
					$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
				}
			}

		};

		$scope.range = function (size,start, end) {
			var ret = [];        
			console.log(size,start, end);

			if (size < end) {
				end = size;
				start = size-$scope.pagedItems.length;
			}
			for (var i = start; i < end; i++) {
				ret.push(i);
			}        
			console.log(ret);        
			return ret;
		};

		$scope.prevPage = function () {
			if ($scope.currentPage > 0) {
				$scope.currentPage--;
			}
		};

		$scope.nextPage = function () {
			if ($scope.currentPage < $scope.pagedItems.length - 1) {
				$scope.currentPage++;
			}
		};

		$scope.setPage = function () {
			$scope.currentPage = this.n;
		};

		// functions have been describe process the data for display
		$scope.search();

	};

	$scope.showReviewdByOthers=function(){

		$scope.sort = {       
				sortingOrder : "$index+1",
				reverse : false
		};
		$scope.filteredItems = [];
		$scope.groupedItems = [];
		$scope.itemsPerPage =10;
		$scope.pagedItems = [];
		$scope.currentPage = 0;
		$scope.items = $scope.reviedByOthersReviewer;
		// alert(JSON.stringify($scope.items));
		var searchMatch = function (haystack, needle) {
			if (!needle) {
				return true;
			}
			return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
		};

		// init the filtered items
		$scope.search = function () {
			$scope.filteredItems = $filter('filter')($scope.items, function (item) {
				for(var attr in item) {
					if (searchMatch(item[attr], $scope.query))
						return true;
				}
				return false;
			});
			// take care of the sorting order
			if ($scope.sort.sortingOrder !== '') {
				$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
			}
			$scope.currentPage = 0;
			// now group by pages
			$scope.groupToPages();
		};


		// calculate page in place
		$scope.groupToPages = function () {
			$scope.pagedItems = [];
			for (var i = 0; i < $scope.filteredItems.length; i++) {
				if (i % $scope.itemsPerPage === 0) {
					$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
				} else {
					$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
				}
			}

		};

		$scope.range = function (size,start, end) {
			var ret = [];        
			console.log(size,start, end);

			if (size < end) {
				end = size;
				start = size-$scope.pagedItems.length;
			}
			for (var i = start; i < end; i++) {
				ret.push(i);
			}        
			console.log(ret);        
			return ret;
		};

		$scope.prevPage = function () {
			if ($scope.currentPage > 0) {
				$scope.currentPage--;
			}
		};

		$scope.nextPage = function () {
			if ($scope.currentPage < $scope.pagedItems.length - 1) {
				$scope.currentPage++;
			}
		};

		$scope.setPage = function () {
			$scope.currentPage = this.n;
		};

		// functions have been describe process the data for display
		$scope.search();

	};

	$scope.ShowDetailsReview=function (ratingId,projTitle,reviewedBy){
		$scope.projectTitle=projTitle;
		$scope.reviewedBy=reviewedBy;
		$http({
			method : 'POST',
			url : 'getReviewsAndRatingByReviewer',
			data : $.param({
				ratingId:ratingId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.getReviewsByReviewer = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};


	$scope.selectYear =function(selectedYear){
		$http({
			method : 'POST',
			url : 'getAllReviewsByLoggedInReviewerAndOthers',
			data : $.param({
				year:selectedYear
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			/*
			 * $scope.allReviews =[]; $scope.Reviewers=[]; angular.forEach(data,
			 * function(allReviewsAndRating) {
			 * $scope.allReviews.push(allReviewsAndRating);
			 * angular.forEach(allReviewsAndRating.assignedByAndReviewDoneByMapperSet,
			 * function(reviewers) { if ($scope.Reviewers.indexOf(reviewers) ==
			 * -1) { $scope.Reviewers.push(reviewers); } }); });
			 */
			$scope.reviedByLoggedInReviewer =[];
			$scope.reviedByOthersReviewer =[];

			angular.forEach(data.overallCalculatedReviewRatingsByLoggedInReviewer, function(overallCalculatedReviewRatingVOByLoggedinReviewer, index) {
				$scope.reviedByLoggedInReviewer.push(overallCalculatedReviewRatingVOByLoggedinReviewer);
			});
			angular.forEach(data.overallCalculatedReviewRatingsByOtherReviewers, function(overallCalculatedReviewRatingVOByOthers, index) {
				$scope.reviedByOthersReviewer.push(overallCalculatedReviewRatingVOByOthers);
			});
			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};
			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =10;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.reviedByLoggedInReviewer;
			var searchMatch = function (haystack, needle) {
				if (!needle) {
					return true;
				}
				return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
			};

			// init the filtered items
			$scope.search = function () {
				$scope.filteredItems = $filter('filter')($scope.items, function (item) {
					for(var attr in item) {
						if (searchMatch(item[attr], $scope.query))
							return true;
					}
					return false;
				});
				// take care of the sorting order
				if ($scope.sort.sortingOrder !== '') {
					$scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
				}
				$scope.currentPage = 0;
				// now group by pages
				$scope.groupToPages();
			};


			// calculate page in place
			$scope.groupToPages = function () {
				$scope.pagedItems = [];
				for (var i = 0; i < $scope.filteredItems.length; i++) {
					if (i % $scope.itemsPerPage === 0) {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
					} else {
						$scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
					}
				}

			};

			$scope.range = function (size,start, end) {
				var ret = [];        
				console.log(size,start, end);

				if (size < end) {
					end = size;
					start = size-$scope.pagedItems.length;
				}
				for (var i = start; i < end; i++) {
					ret.push(i);
				}        
				console.log(ret);        
				return ret;
			};

			$scope.prevPage = function () {
				if ($scope.currentPage > 0) {
					$scope.currentPage--;
				}
			};

			$scope.nextPage = function () {
				if ($scope.currentPage < $scope.pagedItems.length - 1) {
					$scope.currentPage++;
				}
			};

			$scope.setPage = function () {
				$scope.currentPage = this.n;
			};

			// functions have been describe process the data for display
			$scope.search();
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$(function () {
         $('#datetimepicker').datetimepicker({
        	 ignoreReadonly: true,
             viewMode: 'years',
				format: 'YYYY'
         });

         $("#datetimepicker").on("dp.change", function (e) {

         	
             if (e.timeStamp !== undefined) {
               var picker = $(this).data("DateTimePicker");
               var d = picker.date();
              $scope.selectYear(d.format('YYYY'));
             }
         }); 

         
     });
});

techpedia.controller('gytiArchiveController', function($scope, $http,$filter,$timeout) {

	$scope.InitLoad=function(){
		$http({
			method: 'GET',
			url: 'gytiArchiveData',
			data:$.param({}),
			headers: {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.fileArchive=data;
		}).error(function(data, status, headers, config){
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};
	$scope.downloadArchive=function(filename){
		$http({
			method: 'POST',
			url: 'gytiArchiveDataDownloadFileName',
			data:$.param({
				fileName : filename
			}),
			headers: {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			window.location = 'downloadGytiArchiveFile?fileName='+filename;
		}).error(function(data, status, headers, config){
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	}

});

techpedia.controller('activateReviewerProfileViaEmailController',function($scope,$http){

	/*
	 * $scope.Initload=function(){ $http({ method: 'POST', url:
	 * 'activateReviewerProfile', data:$.param({}), headers: { 'Content-Type' :
	 * 'application/x-www-form-urlencoded' } }).success(function(data, status,
	 * headers, config) { if(data.status=="success"){ $scope.actSuccessMsg=[];
	 * $scope.actSuccessMsg.push("Your account has been activated
	 * successfully."); } else{ $scope.actErrorMsg=[];
	 * $scope.actErrorMsg.push("Some error occured while activating your
	 * account.Failed to activate , Please visit after sometime!!"); }
	 * }).error(function(data, status, headers, config){ $scope.message = [];
	 * $scope.message.push("Possibly the service is down, Please contact the
	 * admin if problem persists."); }); };
	 */
});
//var charts = [];
techpedia.controller('adminDashBoardController',function($scope,$http){

	$scope.Initload=function()
	{
		
		$http({
			
			method : 'POST',
			url : 'totalProjectsStatistics',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
			
		}).success(function(data, status, headers, config) {
			
			//alert(JSON.stringify(data));
			// Charts

			var chart = AmCharts.makeChart( "chartdivProjectData", {
				"type": "pie",
				"titles": [{
					"text": "GYTI Project Statistics"
				}],
				"theme": "light",
				"addClassNames": true,
				"dataProvider":data,/*[ {
					"status": "Total Submitted Project",
					"value": 0
				},{
					"status": "Applied for GYTI Award",
					"value": 0
				}, {
					"status": "Pending for Review",
					"value": 0
				}, {
					"status": "Review Done",
					"value": 0
				}, {
					"status": "Total Award Winner",
					"value": 0
				}],*/
				"valueField": "value",
				"titleField": "status",
				"outlineAlpha": 0.4,
				"depth3D": 15,
				"balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
				"angle": 30,
				"legend": {
					"position": "right"
				},
				"responsive": {
					"enabled": true,
					"rules":[{
						"maxWidth": 500,
						"overrides": {
							"precision": 2,
							/*
							 * "legend": { "enabled": true, }
							 */
						}
					}]
				},
				"export": {
					"enabled": true
				}
			} );
			jQuery( '.chart-input' ).off().on( 'input change', function() {
				var property = jQuery( this ).data( 'property' );
				var target = chartProjectData;
				var value = Number( this.value );
				chartProjectData.startDuration = 0;

				if ( property == 'innerRadius' ) {
					value += "%";
				}

				target[ property ] = value;
				chartProjectData.validateNow();
			});

			
			
		}).error(function(data, status, headers, config){
			errorMessage=[];
			errorMessage.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		
		$http({
			
			method : 'POST',
			url : 'totalProjectsYearWiseStatistics',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			
			var chartData=data;
			

			/**
			 * Create the chart
			 */
			//var testyear=chartData[0];
			/*var firstProp;
			for(var key in data) {
			    if(data.hasOwnProperty(key)) {
			        firstProp = data[key];
			        alert("First gg "+firstProp[0]);
			        break;
			    }
			}
			alert("First"+firstProp);*/
			var currentYear = 2010;
			var chart = AmCharts.makeChart( "chartdivYearWiseProjectData", {
				"type": "pie",
				"theme": "light",
				"dataProvider": [],
				"valueField": "size",
				"titleField": "sector",
				"startDuration": 0,
				"innerRadius": 80,
				"pullOutRadius": 20,
				"marginTop": 30,
				"titles": [{
					"text": "Yearwise Project Statistics"
				}],
				"legend": {
					"position": "right"
				},
				"responsive": {
					"enabled": true,
					"rules":[{
						"maxWidth": 500,
						"overrides": {
							"precision": 2,
							/*
							 * "legend": { "enabled": false,
							 * "legendPosition ":"top" }
							 */
						}
					}]
				},
				"allLabels": [{
					"y": "54%",
					"align": "center",
					"size": 25,
					"bold": true,
					"text": "1995",
					"color": "#555"
				}, {
					"y": "49%",
					"align": "center",
					"size": 15,
					"text": "Year",
					"color": "#555"
				}],
				"listeners": [ {
					"event": "init",
					"method": function( e ) {
						var chart = e.chart;

						function getCurrentData() {
							var data = chartData[currentYear];
							currentYear++;
							if (currentYear > new Date().getFullYear())
								currentYear = 2010;
							return data;
						}

						function loop() {
							chart.allLabels[0].text = currentYear;
							var data = getCurrentData();
							chart.animateData( data, {
								duration: 1000,
								complete: function() {
									setTimeout( loop, 3000 );
								}
							} );
						}

						loop();
					}
				} ],
				"export": {
					"enabled": true
				}
			} );
			
		}).error(function(data, status, headers, config){
			errorMessage=[];
			errorMessage.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		
		
		

		$http({
			method : 'POST',
			url : 'getTotalGytiProjectsByCategory',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.getTotalGytiProjectsByCategoryOBJECT=data;

			/*
			 * var getTotalGytiProjectsByCategory=JSON.stringify(data);
			 * console.log("JSON String::"+getTotalGytiProjectsByCategory);
			 */
			


			// graph

			var chart = AmCharts.makeChart("chartdiv", {
				"theme": "light",
				"type": "serial",
				"title":"Total Submitted Innovations/Ideas",
				"dataProvider":$scope.getTotalGytiProjectsByCategoryOBJECT,

				"valueAxes": [{
					"title": "Total Submitted Project"
				}],
				"graphs": [{
					"balloonText": "Total Sbmitted Project in [[category]]=[[value]]",
					"fillAlphas": 1,
					"lineAlpha": 0.2,
					"title": "Total Sbmitted Project",
					"type": "column",
					"valueField": "totalProject"
				}],
				"responsive": {
					"enabled": true,
					"rules":[{
						"maxWidth": 400,
						"overrides": {
							"precision": 2,
							"categoryAxis": {
								"inside": true
							}
						}
					}]
				},
				"depth3D": 20,
				"angle": 30,
				"rotate": true,
				"categoryField": "category",
				"categoryAxis": {
					"gridPosition": "start",
					"fillAlpha": 0.05,
					"position": "left",
					"title":"Category"
				},
				"export": {
					"enabled": true
				}
			});

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		var date = new Date();
		 $scope.loadCurrentYear = date.getFullYear();
		$http({	
			method : 'POST',
			url : 'totalProjectsForParticularYearStatistics',
			data : $.param({
				year:$scope.loadCurrentYear
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.loadCurrentYearData=data;
			var chartData=$scope.loadCurrentYearData;
			var currentYear = $scope.loadCurrentYear;
			var chart = AmCharts.makeChart( "chartdivParticularYearWiseProjectData", {
				"type": "pie",
				"theme": "light",
				"dataProvider": [],
				"valueField": "size",
				"titleField": "sector",
				"startDuration": 0,
				"innerRadius": 80,
				"pullOutRadius": 20,
				"marginTop": 30,
				"titles": [{
					"text": "Project Statistics for The Year "+$scope.loadCurrentYear
				}],
				"legend": {
					"position": "right"
				},
				"responsive": {
					"enabled": true,
					"rules":[{
						"maxWidth": 500,
						"overrides": {
							"precision": 2,
							/*
							 * "legend": { "enabled": false,
							 * "legendPosition ":"top" }
							 */
						}
					}]
				},
				"allLabels": [{
					"y": "54%",
					"align": "center",
					"size": 25,
					"bold": true,
					"text": "1995",
					"color": "#555"
				}, {
					"y": "49%",
					"align": "center",
					"size": 15,
					"text": "Year",
					"color": "#555"
				}],
				"listeners": [ {
					"event": "init",
					"method": function( e ) {
						var chart = e.chart;

						function getCurrentData() {
							var data = chartData[currentYear];
							currentYear++;
							if (currentYear > new Date().getFullYear())
								currentYear = $scope.loadCurrentYear;
							return data;
						}

						function loop() {
							chart.allLabels[0].text = currentYear;
							var data = getCurrentData();
							chart.animateData( data, {
								duration: 1000,
								complete: function() {
									setTimeout( loop, 3000 );
								}
							} );
						}

						loop();
					}
				} ],
				"export": {
					"enabled": true
				}
			} );
			
		}).error(function(data, status, headers, config){
			
		});

	};
	$scope.selectYear=function(year){
		$scope.loadCurrentYearData=null;
		$scope.selectedYear=year;
		$http({	
			method : 'POST',
			url : 'totalProjectsForParticularYearStatistics',
			data : $.param({
				year:$scope.selectedYear
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			alert("length :: "+data.length);
			var chartData=data;
			var currentYear = $scope.selectedYear;
			var chart = AmCharts.makeChart( "chartdivParticularYearWiseProjectData", {
				"type": "pie",
				"theme": "light",
				"dataProvider": [],
				"valueField": "size",
				"titleField": "sector",
				"startDuration": 0,
				"innerRadius": 80,
				"pullOutRadius": 20,
				"marginTop": 30,
				"titles": [{
					"text": "Project Statistics for The Year "+$scope.selectedYear
				}],
				"legend": {
					"position": "right"
				},
				"responsive": {
					"enabled": true,
					"rules":[{
						"maxWidth": 500,
						"overrides": {
							"precision": 2,
							/*
							 * "legend": { "enabled": false,
							 * "legendPosition ":"top" }
							 */
						}
					}]
				},
				"allLabels": [{
					"y": "54%",
					"align": "center",
					"size": 25,
					"bold": true,
					"text": "1995",
					"color": "#555"
				}, {
					"y": "49%",
					"align": "center",
					"size": 15,
					"text": "Year",
					"color": "#555"
				}],
				"listeners": [ {
					"event": "init",
					"method": function( e ) {
						var chart = e.chart;

						function getCurrentData() {
							var data = chartData[currentYear];
							currentYear++;
							if (currentYear > new Date().getFullYear())
								currentYear = $scope.selectedYear;
							return data;
						}

						function loop() {
							chart.allLabels[0].text = currentYear;
							var data = getCurrentData();
							chart.animateData( data, {
								duration: 1000,
								complete: function() {
									setTimeout( loop, 3000 );
								}
							} );
						}

						loop();
					}
				} ],
				"export": {
					"enabled": true
				}
			} );
			
		}).error(function(data, status, headers, config){
			
		});
		
	}
	$(function () {
        $('#datetimepicker').datetimepicker({
       	 ignoreReadonly: true,
            viewMode: 'years',
				format: 'YYYY'
        });

        $("#datetimepicker").on("dp.change", function (e) {

        	
            if (e.timeStamp !== undefined) {
              var picker = $(this).data("DateTimePicker");
              var d = picker.date();
             $scope.selectYear(d.format('YYYY'));
             $scope.loadCurrentYearData=null;
            }
        }); 
    });

});
jQuery(document).ready(function () {

});

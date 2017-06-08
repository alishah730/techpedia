/*var techpedia = angular.module('techpedia', ['ui.bootstrap']);*/

var techpedia = angular.module('techpedia', []);

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

googlelogin = function(facebookdata){
	//alert("google image name=="+facebookdata.imageName);
	//alert("google image base64:=="+facebookdata.imgurl);
	$.ajax({
		type: 'POST',
		url: 'ajax/emailVerification',
		contentType: 'application/x-www-form-urlencoded',
		data: {emailId : facebookdata.emailId },
		success: function(data) {
			if (data === 'success') {
				window.location.href="dashboard";
			} else if(data === 'Entered Email Id is not Existed in the database'){
				sessionStorage.setItem('googleProfile', angular.toJson(facebookdata,false));
				window.location.href="socialRegister";
			}
		},
		error: function(data) {
			alert(data);
		}
	});	
}

linkedInLogin = function(linkedInData){
	//alert("lonkedInLogin");
	//alert("linkedIn image name=="+linkedInData.imgProfileName);
	//alert("linkedIn image base64:=="+linkedInData.imgurl);
	$.ajax({
		type: 'POST',
		url: 'ajax/emailVerification',
		contentType: 'application/x-www-form-urlencoded',
		data: {emailId : linkedInData.emailId },
		success: function(data) {
			if (data === 'success') {
				window.location.href="dashboard";
			} else if(data === 'Entered Email Id is not Existed in the database'){
				sessionStorage.setItem('linkedInProfile', angular.toJson(linkedInData,false));
				window.location.href="socialRegister";
			}
		},
		error: function(data) {
			alert(data);
		}
	});	
}


techpedia.controller('headerController', function($scope, $http) {
	$scope.InitLoad = function() {
		
		
		$scope.viewCollege = function(collegeName) {
			var college = collegeName.replace(/\s/g, "-");
			window.location.href = 'collegeDetails'+college;
			
			/*var form = document.getElementById('collegeForm');
			
			var uri = 'collegeDetails'+college;
			
	
			form.action = uri;
			form.submit();*/
			
		};
	};
});

techpedia.controller('CollegeDetailsController', function($scope, $http) {
	
	$scope.InitLoad = function(college) {
		//alert(college);
		$scope.college = college.replace(/-/g, ' ');
		
		$http({
			method : 'POST',
			url : 'ajax/getCollegeInforamtion',
			data : $.param({
				collegeName: $scope.college
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.collegeInformation = data;
			$scope.firstWord = $scope.collegeInformation.collegeDescription.substr(0,$scope.collegeInformation.collegeDescription.indexOf(' ')); 
			$scope.restData  = $scope.collegeInformation.collegeDescription.substr($scope.collegeInformation.collegeDescription.indexOf(' ')+1); 
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		
		
		
		
		
		$http({
			method : 'POST',
			url : 'ajax/getCollegeRecentNews',
			data : $.param({
				collegeName: $scope.college
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.recentnews = data;
			if($scope.recentnews.length==undefined){
				$scope.recentnews.length = 0;
			}
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
		//Recent Projects	
		$http({
			method : 'POST',
			url : 'ajax/getCollegeRecentProjects',
			data : $.param({collegeName: $scope.college}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.recentprojects = data;
			//alert("RecentProjects..."+$scope.recentprojects.length);
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
		/*$scope.recentProjectVisibility = function(){
			document.getElementById("recentProjects").style.display = "block";
			$('#popularProjects').hide();
			$('#recentProjects').show();
		}

		$http({
			method : 'POST',
			url : 'projectsFetch',
			data : $.param({
				set : 1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projects = data;
			for(var i=0;i<$scope.projects.length;i++){

				$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc.substring(0, 13)+"...";
			}
			for(var i=0;i<$scope.projects.length;i++){
				alert($scope.projects[i].projCollege);


				if($scope.projects[i].projTitle.length>30){
					$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
				}
				if($scope.projects[i].projCollege.length>13){
					$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
				}
				if($scope.projects[i].projFacultyName.length>13){
					$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
				}
				if($scope.projects[i].projTeamLeaderName.length>13){
					$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
				}





			}
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		$scope.clickProject = function(id) {
			window.location = 'projectDetails' + id;
		};
		 */


		$scope.faculties = [];

		$http({
			method : 'POST',
			url : 'ajax/getcollegeFacultyList',
			data : $.param({
				collegeName: $scope.college
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.faculties = data;
			//alert("faculyies====="+$scope.faculties.length);
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
				console.log($scope.pageCount1(),$scope.currentPage1)//8 0

				if ( start1 > $scope.pageCount1()-rangeSize1 ) { //0>8-4
					start1 = $scope.pageCount1()-rangeSize1+1;
				}

				for (var i=start1; i<start1+rangeSize1; i++) { //i=0, i<4
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
				return Math.ceil($scope.faculties.length / $scope.itemsPerPage1)-1;//8
			};

			$scope.nextPage1 = function() {
				if ($scope.currentPage1 < $scope.pageCount1()) {
					$scope.currentPage1++;
				}
			};

			$scope.DisableNextPage1 = function() {
				return $scope.currentPage1 === $scope.pageCount1() ? "disabled" : "";
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
				console.log($scope.pageCount(),$scope.currentPage)//8 0

				if ( start > $scope.pageCount()-rangeSize ) { //0>8-4
					start = $scope.pageCount()-rangeSize+1;
				}

				for (var i=start; i<start+rangeSize; i++) { //i=0, i<4
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
				return Math.ceil($scope.recentprojects.length / $scope.itemsPerPage)-1;//8
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



	/*$scope.showData = function( ){

		$scope.itemsPerPage = 6;
		$scope.currentPage = 0;

		$scope.range = function() {
			var rangeSize = 6;
			var ps = [];
			var start;

			start = $scope.currentPage;
			console.log($scope.pageCount(),$scope.currentPage)//8 0

			if ( start > $scope.pageCount()-rangeSize ) { //0>8-4
				start = $scope.pageCount()-rangeSize+1;
			}

			for (var i=start; i<start+rangeSize; i++) { //i=0, i<4
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
			return Math.ceil($scope.faculties.length / $scope.itemsPerPage)-1;//8
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


	 */


	/*$scope.showProjectData = function( ){

		$scope.itemsPerPage = 6;
		$scope.currentPage = 0;

		$scope.range = function() {
			var rangeSize = 6;
			var ps = [];
			var start;

			start = $scope.currentPage;
			console.log($scope.pageCount(),$scope.currentPage)//8 0

			if ( start > $scope.pageCount()-rangeSize ) { //0>8-4
				start = $scope.pageCount()-rangeSize+1;
			}

			for (var i=start; i<start+rangeSize; i++) { //i=0, i<4
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
			return Math.ceil($scope.recentprojects.length / $scope.itemsPerPage)-1;//8
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

	 */


});



/*techpedia.filter('paginationforfaculty', function() {
	return function(input, start) {
		start = parseInt(start, 10);
		return input.slice(start);
	};
});

techpedia.filter('paginationforproject', function() {
	return function(input, start) {
		start = parseInt(start, 10);
		return input.slice(start);
	};
});*/

techpedia.controller('AboutUsController', function($scope, $http) {
	$scope.InitLoad = function() {
		$http({
			method : 'POST',
			url : 'ajax/getRecentNews',
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
	};
});



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


techpedia.directive('httpPrefixfb', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs, controller) {
            function ensureHttpPrefix(value) {
                // Need to add prefix if we don't have http:// prefix already AND we don't have part of it
                if(value && !/^(https?):\/\/(www.facebook.com?)\//i.test(value)
                   && 'http://www.facebook.com/'.indexOf(value) === -1) {
                	value = "";
                    controller.$setViewValue('http://www.facebook.com/' + value);
                    controller.$render();
                    return 'http://' + value;
                }
                else
                    return value;
            }
            controller.$formatters.push(ensureHttpPrefix);
            controller.$parsers.splice(0, 0, ensureHttpPrefix);
        }
    };
});

techpedia.directive('httpPrefixtwit', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs, controller) {
            function ensureHttpPrefix(value) {
                // Need to add prefix if we don't have http:// prefix already AND we don't have part of it
                if(value && !/^(https?):\/\/(www.twitter.com?)\//i.test(value)
                   && 'http://www.twitter.com/'.indexOf(value) === -1) {
                	value = "";
                    controller.$setViewValue('http://www.twitter.com/' + value);
                    controller.$render();
                    return 'http://www.twitter.com/' + value;
                }
                else
                    return value;
            }
            controller.$formatters.push(ensureHttpPrefix);
            controller.$parsers.splice(0, 0, ensureHttpPrefix);
        }
    };
});

techpedia.directive('httpPrefixlink', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs, controller) {
            function ensureHttpPrefix(value) {
                // Need to add prefix if we don't have http:// prefix already AND we don't have part of it
                if(value && !/^(https?):\/\/(www.linkedin.com?)\//i.test(value)
                   && 'http://www.linkedin.com/'.indexOf(value) === -1) {
                	value = "";
                    controller.$setViewValue('http://www.linkedin.com/' + value);
                    controller.$render();
                    return 'http://www.linkedin.com/' + value;
                }
                else
                    return value;
            }
            controller.$formatters.push(ensureHttpPrefix);
            controller.$parsers.splice(0, 0, ensureHttpPrefix);
        }
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

techpedia.controller('EditNewInnovationController', function($scope, $http) {


	$scope.InitLoad = function() {
		$scope.editNewInnovation = {};
		$scope.editNewInnovation.university = '';
		$scope.editNewInnovation.studentID = '';
		$scope.editNewInnovation.collge = '';
		$scope.editNewInnovation.state = '';

		$http({
			method : 'POST',
			url : 'getId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.registerId = data;

			$http({
				method : 'POST',
				url : 'ajax/editProfileLoad',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.editNewInnovation.university = data.university;
				$scope.editNewInnovation.studentID = data.studentID;
				$scope.editNewInnovation.collge = data.collge;
				$scope.editNewInnovation.state = data.state;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


		$http({
			method : 'POST',
			url : 'editGytiProjectLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {

			/*var m_names = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

			// Getting the project ID from URL as the service returns 0

			// Converting date from millisecond format to human readable and app
			// required format
			data.projId = $scope.getUrlVars()["id"];
			// console.log(data.projStartDate);
			var projStartDate = new Date(Number(data.projStartDate));
			// console.log(projStartDate);
			var curr_date = projStartDate.getDate();
			var curr_month = projStartDate.getMonth();
			var curr_year = projStartDate.getFullYear();
			data.projStartDate = curr_date + "-" + m_names[curr_month].substring(0, 3) + "-" + curr_year;
			// console.log(curr_date + "-" + m_names[curr_month].substring(0, 3)
			// + "-" + curr_year);

			// console.log(data.projEndDate);
			var projEndDate = new Date(Number(data.projEndDate));
			// console.log(projEndDate);
			var curr_date = projEndDate.getDate();
			var curr_month = projEndDate.getMonth();
			var curr_year = projEndDate.getFullYear();
			data.projEndDate = curr_date + "-" + m_names[curr_month].substring(0, 3) + "-" + curr_year;*/
			// console.log(curr_date + "-" + m_names[curr_month].substring(0, 3)
			// + "-" + curr_year);

			// Getting branches into the select 2 options
			var dataArray = [];
			for (var i = 0; i < data.projKeywords.length; i++) {
				var keyword = data.projKeywords[i];
				var json = {};
				json.id = keyword;
				json.text = keyword;
				dataArray.push(json);
			}
			//alert("title=="+data.projTitle);
			console.log(JSON.stringify(dataArray));
			$("#projectKeywords").select2("data", dataArray);

			// Getting keywords into the select 2 options
			//alert("branch name=="+data.projBranchList.length);
			var dataArray = [];
			for (var i = 0; i < data.projBranchList.length; i++) {
				//alert("branch name=="+data.projBranchList[i].branchName);
				var id = data.projBranchList[i].branchId;
				var text = data.projBranchList[i].branchName;
				// alert(id + " " + text);
				var json = {};
				json.id = id;
				json.text = text;
				dataArray.push(json);

			}
			console.log(JSON.stringify(dataArray));
			$("#projectBranches").select2("data", dataArray);
			$("#projectBranches").select2("readonly", true);


			var projteamid=data.projTeamId;

			$scope.editNewInnovation = data;
			$scope.editNewInnovation.projAwardYear = data.projAwardYear;
			//alert("title=="+$scope.editNewInnovation.projTitle);
			//alert("edit team id=="+$scope.editNewInnovation.projTeamId);
			$http({
				method : 'POST',
				url : 'ajax/getTeamsListForOneUser',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.teams = data;
				for (var i=0;i<=$scope.teams.length;i++) {
					if ( $scope.teams[i].teamID ==$scope.editNewInnovation.projTeamId) {
						$scope.editNewInnovation.projTeamDesc=$scope.teams[i].teamName;
					}}

			})

			/* Changing startDate and endDate format to datepicker format*/

			var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
			var sDate = String(data.projStartDate).split("-");
			var myYear = sDate[0];
			var myMonth = sDate[1];
			var myDay = sDate[2];

			var eDate = String(data.projEndDate).split("-");
			var myYear1 = eDate[0];
			var myMonth1 = eDate[1];
			var myDay1 = eDate[2];

			var startDate = myDay + '-' + months[myMonth-1] + '-' + myYear;
			var endDate = myDay1 + '-' + months[myMonth1-1] + '-' + myYear1;

			$scope.editNewInnovation.projStartDate = startDate;
			$scope.editNewInnovation.projEndDate = endDate;

			/* End */

			/* adding property checked to checkboxez of projectStatus according values coming from database  */

			var projStatusInfoArray = new Array();
			projStatusInfoArray = data.projStatusInfo.split(",");

			var checkboxArray=document.getElementsByName("idea[]");
			for (var i=0;i<projStatusInfoArray.length;i++) {
				for (var j=0;j<checkboxArray.length;j++) {
					if(projStatusInfoArray[i] == checkboxArray[j].value){
						checkboxArray[j].checked = true; 
					}
				}

			}

			/* End */

			$scope.isAccordionEnable = function(fisrtForm,secondForm,thirdForm){
				if(fisrtForm==false && secondForm==false && thirdForm==false) {
					return true;
				}else{
					return false;
				}
			};


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
            // $scope.selectYear(d.format('YYYY'));
            }
        }); 

        
    });
	
	$scope.validateCheckboxes = function(additionalInnvationForm){
		
		
		var elements = document.getElementsByName("idea[]");
		for(var i=0; i < elements.length; i++){
			if(elements[i].checked && additionalInnvationForm==false) {
				return false;
			}
		}
		return true;
	}


});




techpedia.controller('EditProjectController', function($scope, $http) {

	$scope.getUrlVars = function() {
		var vars = [], hash;
		var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		for (var i = 0; i < hashes.length; i++) {
			hash = hashes[i].split('=');
			vars.push(hash[0]);
			vars[hash[0]] = hash[1];
		}
		return vars;
	};

	$scope.InitLoad = function() {

		$scope.edit = {};
		$scope.edit.university = '';
		$scope.edit.studentID = '';
		$scope.edit.collge = '';
		$scope.edit.state = '';

		$http({
			method : 'POST',
			url : 'getId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.registerId = data;

			$http({
				method : 'POST',
				url : 'ajax/editProfileLoad',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.edit.university = data.university;
				$scope.edit.studentID = data.studentID;
				$scope.edit.collge = data.collge;
				$scope.edit.state = data.state;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		$http({
			method : 'POST',
			url : 'editProjectLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {

			/*var m_names = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

			// Getting the project ID from URL as the service returns 0

			// Converting date from millisecond format to human readable and app
			// required format
			data.projId = $scope.getUrlVars()["id"];
			// console.log(data.projStartDate);
			var projStartDate = new Date(Number(data.projStartDate));
			// console.log(projStartDate);
			var curr_date = projStartDate.getDate();
			var curr_month = projStartDate.getMonth();
			var curr_year = projStartDate.getFullYear();
			data.projStartDate = curr_date + "-" + m_names[curr_month].substring(0, 3) + "-" + curr_year;
			// console.log(curr_date + "-" + m_names[curr_month].substring(0, 3)
			// + "-" + curr_year);

			// console.log(data.projEndDate);
			var projEndDate = new Date(Number(data.projEndDate));
			// console.log(projEndDate);
			var curr_date = projEndDate.getDate();
			var curr_month = projEndDate.getMonth();
			var curr_year = projEndDate.getFullYear();
			data.projEndDate = curr_date + "-" + m_names[curr_month].substring(0, 3) + "-" + curr_year;*/
			// console.log(curr_date + "-" + m_names[curr_month].substring(0, 3)
			// + "-" + curr_year);

			// Getting branches into the select 2 options
			var dataArray = [];
			for (var i = 0; i < data.projKeywords.length; i++) {
				var keyword = data.projKeywords[i];
				var json = {};
				json.id = keyword;
				json.text = keyword;
				dataArray.push(json);
			}
			console.log(JSON.stringify(dataArray));
			$("#projectKeywords").select2("data", dataArray);

			// Getting keywords into the select 2 options
			var dataArray = [];
			for (var i = 0; i < data.projBranchList.length; i++) {
				var id = data.projBranchList[i].branchId;
				var text = data.projBranchList[i].projBranchDesc;
				// alert(id + " " + text);
				var json = {};
				json.id = id;
				json.text = text;
				dataArray.push(json);

			}
			console.log(JSON.stringify(dataArray));
			$("#projectBranches").select2("data", dataArray);
			$("#projectBranches").select2("readonly", true);


			var projteamid=data.projTeamId;

			$scope.edit = data;
			$http({
				method : 'POST',
				url : 'ajax/getTeamsListForOneUser',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.teams = data;
				for (var i=0;i<=data.length;i++) {
					if ( data[i].teamID ==$scope.edit.projTeamId) {
						$scope.edit.projTeamDesc=data[i].teamName;
					}}

			})

			var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
			var sDate = String(data.projStartDate).split("-");

			var myDay = sDate[0];
			var myMonth = sDate[1];
			var myYear = sDate[2];

			var eDate = String(data.projEndDate).split("-");
			var myDay1 = eDate[0];
			var myMonth1 = eDate[1];
			var myYear1 = eDate[2];



			var startDate = myDay + '-' + months[myMonth-1] + '-' + myYear;
			var endDate = myDay1 + '-' + months[myMonth1-1] + '-' + myYear1;

			$scope.edit.projStartDate = startDate;
			$scope.edit.projEndDate = endDate;



		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};





});

techpedia.controller('FooterController', function($scope, $http) {
	$scope.InitLoad = function() {
		$http({
			method : 'POST',
			url : 'ajax/fetchHomePageMentors',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.mentors = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$scope.showEmailError = function() {
		$('#emailError').show();
	};
	$scope.hideEmailError = function() {
		$('#emailError').hide();
	};
	$scope.showNameError = function() {
		$('#nameError').show();
	};
	$scope.hideNameError = function() {
		$('#nameError').hide();
	};
	$scope.$watch('file', function() {
		$scope.mentor.photo = "data:" + $scope.file.filetype + ";base64," + $scope.file.base64;
	}, true);
	$scope.viewMentor = function(mentor) {
		window.location = 'mentorDetails' + mentor.mentorId;
	};

	$scope.sendEmail = function(name,email,message){

		var empty = '';

		$("input", contactUs).each(function() {
			if($.trim($("#name").val()) === "" || $.trim($("#email").val()) === ""){
				empty="isempty";

			}

			else{
				empty="notempty";

			}
		});


		if(empty == "isempty") {
			alert("Some of the field are empty . Please fill the * marked field");
			return false;

		}else{

			$scope.message = [];
			$http({
				method : 'POST',
				url : 'ajax/contactUs',
				data : $.param({
					username : name,
					emailId : email,
					message : message
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				if (data === 'success'){
					alert("Mail sent successfully");
				}else{
					alert(data.exceptionDetails);
				}
			}).error(function(data, status, headers, config) {
				alert("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};
});

/*techpedia.controller('collegeDetailsController', function($scope, $http) {
	$scope.recentprojects = [ {
		projTitle : 'Loading title',
		projDescription : 'Loading description'
	} ];
	//Latest News
	$http({
		method : 'POST',
		url : 'ajax/getRecentNews',
		data : $.param({}),
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data, status, headers, config) {
		$scope.recentnews1 = data;
	}).error(function(data, status, headers, config) {
		$scope.message = [];
		$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
	});
	//Recent Projects		
	$http({
		method : 'POST',
		url : 'recentProjectSpotlightLoad',
		data : $.param({}),
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data, status, headers, config) {
		$scope.recentprojects = data;
	}).error(function(data, status, headers, config) {
		$scope.recentprojects = [ {
			projTitle : 'Failed to load data',
			projDescription : 'Please try again later'
		} ];
	});
	$scope.recentProjectVisibility = function(){
		document.getElementById("recentProjects").style.display = "block";
		$('#popularProjects').hide();
		$('#recentProjects').show();
	}

});*/


techpedia.controller('IndexController', function($scope, $http,$filter,$timeout) {
	
	$scope.layoutDone = function() {
		//alert("layoutDone****");
		//$('a[data-toggle="tooltip"]').tooltip(); // NOT CORRECT!
		$timeout(function() { $('.macro').tooltip();
		}, 0); // wait...
	}
	
	$scope.InitLoad = function() {
	
		$scope.projects = [ {
			projTitle : 'Loading title',
			projDescription : 'Loading description'
		} ];

		$scope.recentprojects = [ {
			projTitle : 'Loading title',
			projDescription : 'Loading description'
		} ];

//		Popular Projects
		$http({
			method : 'POST',
			url : 'projectSpotlightLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projects = data;
			for(var i=0;i<$scope.projects.length;i++){
				/*alert($scope.projects[i].projCollege);*/

				$scope.projects[i].projFullName=$scope.projects[i].projTitle;
				if($scope.projects[i].projTitle.length>30){
					$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
				}
			}

		}).error(function(data, status, headers, config) {
			$scope.projects = [ {
				projTitle : 'Failed to load data',
				projDescription : 'Please try again later'
			} ];
		});
//		project macro branches		
		$http({
			method : 'POST',
			url : 'projectsMacroBranchesLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projectsMacroBranches = data;
			$scope.projectsMacroBranches.macroBranch = '';
			for(var i=0;i<$scope.projectsMacroBranches.length;i++){
				if($scope.projectsMacroBranches[i].macroBranchName.length>23){
					$scope.projectsMacroBranches[i].macroBranch = $scope.projectsMacroBranches[i].macroBranchName.substring(0, 22)+"...";
				}else{
					$scope.projectsMacroBranches[i].macroBranch = $scope.projectsMacroBranches[i].macroBranchName;
				}
					
			}
		}).error(function(data, status, headers, config) {
			$scope.projects = [ {
				projTitle : 'Failed to load data',
				projDescription : 'Please try again later'
			} ];
		});	
//		Recent Projects		
		$http({
			method : 'POST',
			url : 'recentProjectSpotlightLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.recentprojects = data;
			for(var i=0;i<$scope.recentprojects.length;i++){
				/*alert($scope.projects[i].projCollege);*/
				$scope.recentprojects[i].projFullName=$scope.recentprojects[i].projTitle;

				if($scope.recentprojects[i].projTitle.length>30){
					$scope.recentprojects[i].projTitle=$scope.recentprojects[i].projTitle.substring(0, 30)+"...";
				}
			}
		}).error(function(data, status, headers, config) {
			$scope.recentprojects = [ {
				projTitle : 'Failed to load data',
				projDescription : 'Please try again later'
			} ];
		});

		$scope.popularProjectVisibility = function(){
			$('#recentProjects').hide();
			//document.getElementById("popularProjectsBtn").style.backgroundColor = "#449d44";
			//document.getElementById("recentProjectsBtn").style.backgroundColor = "#217790";
			$('#popularProjects').show();
		}

		$scope.recentProjectVisibility = function(){
			document.getElementById("recentProjects").style.display = "block";
			$('#popularProjects').hide();
			//document.getElementById("recentProjectsBtn").style.backgroundColor = "#449d44";
			//document.getElementById("popularProjectsBtn").style.backgroundColor = "#217790";
			$('#recentProjects').show();
		}

		var count = 0;
		setInterval(function() {
			count = (count + 1) % $scope.projects.length;
			$scope.project = $scope.projects[count];
			$scope.$apply();
		}, 3000);

		$scope.testimonials = [ {
			testimonial : 'I am extremely happy to see an initiative of SRISTI (Society for Research and Initiatives for Sustainable Technologies and Institutions) which has led to mapping of the mind of engineering youth of our country in an unprecedented manner.',
			cite : 'Prof ABC',
			image : 'images/1.png'
		}, {
			testimonial : 'I wish all the energy to the team and hope that they will continue to link academia, industry, informal sector and the creative youth of the country.',
			cite : 'Prof PQR',
			image : 'images/2.png'
		}, {
			testimonial : 'I am particularly pleased to know that several of the innovations by the school children are also being valorized by engineering college students.',
			cite : 'Prof XYZ',
			image : 'images/3.png'
		}

		];

		var count2 = 0 ;

		function changeTestimonial(){
			count2 = (count2 + 1) % $scope.testimonials.length;
			$scope.testimonial[0] = $scope.testimonials[0];
			$scope.testimonial[1] = $scope.testimonials[1];
			$scope.testimonial[2] = $scope.testimonials[2];
		}
		$scope.testimonial ={};
		setInterval(changeTestimonial,{
			/*	$scope.testimonial[0] = $scope.testimonials[0];
			$scope.testimonial[1] = $scope.testimonials[1];
			$scope.testimonial[2] = $scope.testimonials[2];
			$scope.$apply();*/
		}, 3000);

	};
	
	

	$scope.viewProject = function(project) {
		window.location = 'projectDetails' + project.projId;
	};


	$scope.clickMacroBranch = function(macroBranch) {
		window.location = 'projectByBranches' + macroBranch.replace(/\s/g, "-");
		
	};



});

techpedia.controller('LoginModalController', function($scope, $http,MyService) {
	$scope.InitLoad = function() {
		$http({
			method : 'POST',
			url : 'getUserType',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.userType = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.forgotPassword = function() {
		$http({
			method : 'POST',
			url : 'ajax/forgotPassword',
			data : $.param({
				token : $scope.token
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data.status === 'success') {
				$scope.message = [];
				$scope.message.push("Password has been Successfully sent  to your registered Email ID");
			} else {
				$('#forgotPassword').val('');
				$scope.message = [];
				$scope.message.push("Failed to send request, try later");

			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};








	$scope.popuplogin = function(){

		FB.login(function (response) {
			if (response.authResponse) {
				$scope.checkLoginState();

			} else {
				//alert("Login attempt failed!");
			}
		}, { scope: 'email,user_photos,publish_actions,user_birthday,user_hometown,user_location' });

	}


	$scope.checkLoginState = function(){

		FB.getLoginStatus(function(response) {
			$scope.facebookLogin(response);
		});
	}




	$scope.facebookLogin = function(response) {
		console.log('facebookLogin');
		console.log(response);
		// The response object is returned with a status field that lets the
		// app know the current login status of the person.
		// Full docs on the response object can be found in the documentation
		// for FB.getLoginStatus().
		if (response.status === 'connected') {
			// Logged into your app and Facebook.
			$scope.testAPI();
		} else if (response.status === 'not_authorized') {
			// The person is logged into Facebook, but not your app.
			document.getElementById('status').innerHTML = 'Please log ' +
			'into this app.';
		} else {
			// The person is not logged into Facebook, so we're not sure if
			// they are logged into this app or not.
			document.getElementById('status').innerHTML = 'Please log ' +
			'into Facebook.';
		}

	};



	$scope.testAPI = function(){
		console.log('Welcome!  Fetching your information.... ');
		FB.api("/me",{fields: 'name,first_name,last_name,birthday,gender,hometown,email,picture,location'},
				function (response) {
			$scope.details = {};
			if (response && !response.error) {
				/*alert("response id"+response.id);
				alert("response id"+response.hometown);
				alert("response id"+response.location);*/

				/* handle the result */
				var datearray = new Array();
				var picture = response.picture;
				$scope.urlLink = 'https://www.facebook.com/';
				$scope.firstname = response.first_name;
				$scope.lastname = response.last_name;
				$scope.birthday = response.birthday;
				$scope.faceBookId = $scope.urlLink+response.id;
				//alert($scope.faceBookId);
				datearray = $scope.birthday.split("/");
				$scope.dob = datearray[2]+"-"+datearray[1]+"-"+datearray[0];
				$scope.gender = response.gender;
				if( $scope.imgurl == ""){
					$scope.imgurl = "images/gravatar.png";
				}else{
					$scope.imgurl = response.picture.data.url;
				}
				$scope.emailId = response.email;

				/*code for converting imgage url from CDN to base64*/


				function convertImgToDataURLviaCanvas(url){

					//alert("facebook image="+url);
					//alert("facebook image after triming="+url.substring(70,121));
					console.log("facebook image="+url);
					var img = new Image();
					img.crossOrigin = 'Anonymous';

					img.onload = function(){
						var canvas = document.createElement('CANVAS');
						var ctx = canvas.getContext('2d');
						var dataURL;
						canvas.height = this.height;
						canvas.width = this.width;
						ctx.drawImage(this, 0, 0);
						dataURL = canvas.toDataURL('image/png');

						//alert("profile image name=="+url.substring(70,121));
						/*callback(dataURL);
				        canvas = null; */
						$scope.details={'firstname' : $scope.firstname,
								'lastname'  : $scope.lastname,
								'birthday'  : $scope.dob,
								'gender'    : $scope.gender,
								'emailId'   : $scope.emailId,
								'imgurl'    : dataURL,
								'imageName' : url.substring(70,121),
								'facebookId': $scope.faceBookId
						};
						$http({
							method : 'POST',
							url : 'ajax/emailVerification',
							data : $.param({
								emailId : $scope.emailId
							}),
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded'
							}
						}).success(function(data, status, headers, config) {
							if (data === 'success') {
								window.location.href="dashboard";
							} else if(data === 'Entered Email Id is not Existed in the database'){
								MyService.store('key',$scope.details);
								window.location.href="socialRegister";
							}
						}).error(function(data, status, headers, config) {
							$scope.message = [];
							$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
						});




					};
					img.src = url;


				}
				/*code for converting imgage url from CDN to base64 ends here*/




				convertImgToDataURLviaCanvas($scope.imgurl);



				/*$scope.details={'firstname' : $scope.firstname,
						'lastname'  : $scope.lastname,
						'birthday'  : $scope.dob,
						'gender'    : $scope.gender,
						'emailId'   : $scope.emailId,
						'imgurl'    : $scope.imgurl
				};
				$http({
					method : 'POST',
					url : 'ajax/emailVerification',
					data : $.param({
						emailId : $scope.emailId
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					if (data === 'success') {
						window.location.href="dashboard";
					} else if(data === 'Entered Email Id is not Existed in the database'){
						MyService.store('key',$scope.details);
						window.location.href="socialRegister";
					}
				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
				 */

				console.log(response);
			}
		}
		);

	}









});

techpedia.controller('ChallengeDetailsController', function($scope, $http) {
	$scope.InitLoad = function() {


		$http({
			method : 'POST',
			url : 'getUserType',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.userType = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		$http({
			method : 'POST',
			url : 'challengeDetailsLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.challenge = data;

			$http({
				method : 'POST',
				url : 'getId',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.registerId = data;

				$http({
					method : 'POST',
					url : 'ajax/getChallengeDocuments',
					data : $.param({
						challengeId : $scope.challenge.challengId,
						registerId : $scope.registerId
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.challengeDocumentList = data;
				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});


				//Related Projects

				$http({
					method : 'POST',
					url : 'ajax/getChallengeTeams',
					data : $.param({
						challengeID : $scope.challenge.challengId
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					/*alert("getChallengeTeams");*/
					$scope.projects = data;
					for(var i=0;i<$scope.projects.length;i++){

						$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc.substring(0, 13)+"...";
					}
					for(var i=0;i<$scope.projects.length;i++){
						/*alert($scope.projects[i].projCollege);*/


						if($scope.projects[i].projTitle.length>30){
							$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
						}
						if($scope.projects[i].projCollege.length>13){
							$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
						}
						if($scope.projects[i].projFacultyName.length>13){
							$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
						}
						if($scope.projects[i].projTeamLeaderName.length>13){
							$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
						}

					}
				}).error(function(data, status, headers, config) {
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});

				// Get Public Comments
				$http({
					method : 'POST',
					url : 'ajax/getChallengeComments',
					data : $.param({
						challengeId : $scope.challenge.challengId,
						set : 0
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.Comments = data;

				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});

				// Get if the user follows the challenge
				$http({
					method : 'POST',
					url : 'ajax/checkChallengeFollow ',
					data : $.param({
						challengeId : $scope.challenge.challengId,
						userRgstrNo : $scope.registerId,
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.message = [];
					if (data.status == 'success'){
						$scope.checkChallengeFollow = true;
					}
					else
						$scope.checkChallengeFollow = false;

				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});






			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});



	};

	$scope.viewProject = function(project) {
		window.location = 'projectDetails' + project.projId;
	};

	$scope.clickTeam = function(project) {
		window.location = 'teamDetails' + project.projTeamId;
	};

	$scope.acceptChallenge = function(challenge) {
		window.location = window.location = 'acceptChallenge?challengeId=' + challenge.challengId+'&&challengeTitle='+challenge.challengTitle;/*'acceptChalle />nge?challengeId=' + challenge.challengId;*/
	};

	$scope.viewMoreComments = function(comment,setNumber) {

		$scope.messagepubliccomments = [];
		$http({
			method : 'POST',
			url : 'ajax/getChallengeComments',
			data : $.param({
				challengeId : $scope.challenge.challengId,
				set : setNumber+1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			//alert(data.length)
			if(data.length>0){

				$scope.Comments = $scope.Comments.concat(data);

			}else{
				$scope.messagepubliccomments.push("No more comments found");	
				$('#publiccomments').hide();

			}
		}).error(function(data, status, headers, config) {
			$scope.messagepubliccomments.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};

	//Posting public and user comments
	$scope.postpublicComment = function(comment,regid) {

		$scope.registrId = null;
		if($scope.registerId==null){
			$scope.registrId = regid;
		}else{
			$scope.registrId = $scope.registerId;
		}

		location.reload();
		$http({
			method : 'POST',
			url : 'ajax/addcomment',
			data : $.param({
				challengeId : $scope.challenge.challengId,
				registerId :$scope.registrId,
//				registerId : regid,
				comment : $scope.teamComment

			}),

			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'

			}

		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data === 'N')
				$scope.message.push("Some error occured while posting the comment");
			else {
				$scope.InitLoad();
			}
			$scope.teamComment = '';
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	// delete comments

	$scope.deleteChallengeComment = function(comment) {

		if (confirm("Are you sure ?")) {
			$http({
				method : 'POST',
				url : 'ajax/deleteChallengeComments',
				data : $.param({
					challengeId : $scope.challenge.challengId,
					commentId : comment.commentId,
					registerId : comment.regstrId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.message = [];
				if (data.status == 'failure'){
					alert('Failed to delete comment');}


				var index = $scope.Comments.indexOf(comment);

				$scope.Comments.splice(index, 1);


			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};




	/*	$scope.postComment = function(comment) {


		$http({
			method : 'POST',
			url : 'ajax/addcomment',
			data : $.param({
				challengeId : $scope.challenge.challengId,
				registerId : $scope.registerId,
//				registerId : regid,
				comment : $scope.teamComment

			}),

			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'

			}

		}).success(function(data, status, headers, config) {

			$scope.message = [];
			if (data === 'N')
				$scope.message.push("Some error occured while posting the comment");
			else {
				$scope.InitLoad();
			}
			 $scope.teamComment = '';
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};


	//end of posting comments
	 */



	$scope.deleteDocument = function(document) {
		$http({
			method : 'POST',
			url : 'ajax/deleteChallengeDocument',
			data : $.param({
				challengeId : $scope.challenge.challengId,
				registerId : $scope.registerId,
				documentName : document.docName
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data.status === 'success') {
				$scope.message = [];
				var index = $scope.challengeDocumentList.indexOf(document);
				$scope.challengeDocumentList.splice(index, 1);
				$scope.message.push("Document deleted");

			} else {
				$scope.message = [];
				$scope.message.push("Failed to delete document");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.downloadDocumentLink= function(document) {
		//window.location = document.docLink;
		$http({
			method : 'POST',
			url : 'ajax/DownloadFileLink',
			data : $.param({
				documentLink : document.docLink
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			window.location = 'DownloadFile';

		})
	};

	$scope.follow = function() {
		$http({
			method : 'POST',
			url : 'ajax/followthechallenge',
			data : $.param({
				challengeId : $scope.challenge.challengId,
				userRgstrNo : $scope.registerId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'failure'){
				$scope.checkChallengeFollow = false;
			}
			else
				$scope.checkChallengeFollow = true;

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.unfollow = function() {
		$http({
			method : 'POST',
			url : 'ajax/removeChallengeFollow',
			data : $.param({
				challengeId : $scope.challenge.challengId,
				userRgstrNo : $scope.registerId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'failure')
				$scope.checkChallengeFollow = true;
			else
				$scope.checkChallengeFollow = false;

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};




});

techpedia.controller('MentorDetailsController', function($scope, $http) {
	$scope.initLoad = function() {
		$http({
			method : 'POST',
			url : 'ajax/mentorDetailsLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.mentor = data;
			console.log(data);
			$http({
				method : 'POST',
				url : 'ajax/getPopularity',
				data : $.param({
					registerId : $scope.mentor.rgstrId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.popularity = data;
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
//faculty details controller...

techpedia.controller('facultyDetailsController', function($scope, $http) {
	$scope.initLoad = function() {
		$http({
			method : 'POST',
			url : 'ajax/facultyDetailsLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.faculty = data;
			console.log(data);
			$http({
				method : 'POST',
				url : 'ajax/getPopularity',
				data : $.param({
					registerId : $scope.faculty.rgstrId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.popularity = data;
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

//Student Details Controller

techpedia.controller('studentDetailsController', function($scope, $http) {
	$scope.initLoad = function() {
		$http({
			method : 'POST',
			url : 'ajax/studentDetailsLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.student = data;
			console.log(data);
			$http({
				method : 'POST',
				url : 'ajax/getPopularity',
				data : $.param({
					registerId : $scope.faculty.rgstrId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.popularity = data;
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


techpedia.controller('showMentorDetailsController', function($scope, $http) {
	$scope.initLoad = function() {
		$http({
			method : 'POST',
			url : 'ajax/showMentorDetailsLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.mentor = data;
			console.log(data);
			//alert("Id"+$scope.mentor.rgstrId);
			if($scope.mentor.professionalExperience.length>100){
				//alert("length"+$scope.projectdetails.projAbstract.length);
				$scope.mentor.professionalExperience=$scope.mentor.professionalExperience.substring(0, 125)+"...";
			}
			if($scope.mentor.institutionalAssctnInfo.length>100){
				//alert("length"+$scope.projectdetails.projAbstract.length);
				$scope.mentor.institutionalAssctnInfo=$scope.mentor.institutionalAssctnInfo.substring(0, 125)+"...";
			}
			$http({
				method : 'POST',
				url : 'ajax/getPopularity',
				data : $.param({
					registerId : $scope.mentor.rgstrId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.popularity = data;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		$http({
			method : 'POST',
			url : 'showProjectDetailsLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projectdetails = data;


			if($scope.projectdetails.projAbstract.length>500){
				$scope.projectdetails.projAbstract=$scope.projectdetails.projAbstract.substring(0, 1427)+"...";
			}



		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.clickMentor = function(id) {

		window.open = ('mentorDetails'+id,'_blank');
	};

	$scope.teamLeaderApproveProject = function(status,projectId,mentorRegisterId,mentorEmailId,mentorFirstName,mentorLastName,teamLeaderEmail,teamLeadFirstName,teamLeadMiddleName,teamLeadLastname){

		$http({
			method : 'POST',
			url : 'ajax/approveMentorRequest',
			data : $.param({
				approvalStatus : status,
				projId		   : projectId,
				teamId		   : '',
				mentorRegstrId : mentorRegisterId,
				mentorEmailId  : mentorEmailId,
				mentorFirstName: mentorFirstName,
				mentorLastName : mentorLastName,
				teamLeaderEmailId :teamLeaderEmail,
				teamLeaderFname : teamLeadFirstName,
				teamLeaderMname : teamLeadMiddleName,
				teamLeaderLname : teamLeadLastname,
				declineComments : ''
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'success') {
				$scope.message = [];
				$scope.message.push("Team Leader Approved The Mentor Request Successfully.");
			} else {
				$scope.message = [];
				$scope.message.push("Some problem occured while approving The Mentor");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.teamLeaderDeclineProject = function(status,projectId,mentorRegisterId,mentorEmailId,mentorFirstName,mentorLastName,teamLeaderEmail,teamLeadFirstName,teamLeadMiddleName,teamLeadLastname,comment){

		$http({
			method : 'POST',
			url : 'ajax/declineMentorRequest',
			data : $.param({
				approvalStatus : status,
				projId		   : projectId,
				teamId		   : '',
				mentorRegstrId : mentorRegisterId,
				mentorEmailId  : mentorEmailId,
				mentorFirstName: mentorFirstName,
				mentorLastName : mentorLastName,
				teamLeaderEmailId :teamLeaderEmail,
				teamLeaderFname : teamLeadFirstName,
				teamLeaderMname : teamLeadMiddleName,
				teamLeaderLname : teamLeadLastname,
				declineComments : comment
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'success') {
				$scope.message = [];
				$scope.message.push("Team Leader Decline The Mentor Request Successfully.");
			} else {
				$scope.message = [];
				$scope.message.push("Some problem occured while declining The Mentor");
			}
			$scope.initLoad();
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

});



techpedia.controller('TeamsController', function($scope, $http) {
	$scope.InitLoad = function() {
		$http({
			method : 'POST',
			url : 'getId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {

			$scope.registerId = data;
			if ($scope.registerId > 0) {
				$http({
					method : 'POST',
					url : 'ajax/getTeamsListForOneUser',
					data : $.param({}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.teams = data;
				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
			}
		}).error(function(data, status, headers, config) {
			alert("error");
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.clickTeam = function(team) {
		window.location = 'teamDetails' + team.teamID;
	};




	$scope.showData = function( ){

		$scope.itemsPerPage = 8;
		$scope.currentPage = 0;

		$scope.range = function() {
			var rangeSize = 8;
			var ps = [];
			var start;

			start = $scope.currentPage;
			console.log($scope.pageCount(),$scope.currentPage)//8 0

			if ( start > $scope.pageCount()-rangeSize ) { //0>8-4
				start = $scope.pageCount()-rangeSize+1;
			}

			for (var i=start; i<start+rangeSize; i++) { //i=0, i<4
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
			return Math.ceil($scope.teams.length / $scope.itemsPerPage)-1;//8
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


});

techpedia.filter('pagination', function() {
	return function(input, start) {
		start = parseInt(start, 10);
		return input.slice(start);
	};
});

techpedia.controller('TeamDetailsController', function($scope, $http) {

	$scope.initLoad = function() {
		$scope.message1 = [];
		$scope.message = [];
		$scope.search = {};
		$scope.search.firstName = '';
		$scope.search.midName = '';
		$scope.search.lastName = '';
		$scope.search.collge = '';
		$scope.search.studentID = '';

		$http({
			method : 'POST',
			url : 'getTeamId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.teamId = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		/*Replace Team Lead code starts here*/

		$scope.replaceTeamLead=function(regstrId){
			if(confirm("Are you Sure?")){
				$http({
					method: 'POST',
					url: 'repalceTeamLead',
					data: $.param({
						teamId: $scope.teamId,
						regstrId: regstrId ,

					}),
					headers :{
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					if (data.status == 'success') {
						$scope.message = [];
						$scope.message.push("Team Lead Successfully Replaced");
					} else {
						$scope.message = [];
						$scope.message.push("Some problem occured while replacing Team Lead");
					}
					$scope.initLoad();
				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
			}
		}


		/*Replace Team Lead end starts here*/

		$http({
			method : 'POST',
			url : 'ajax/teamDetailsLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.members = data;
			$scope.teamName = data[0].projTeamName;
			$scope.projectId = data[0].projId;
			$scope.projectName = data[0].projTitle;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$('#addmemberModal').on('hidden.bs.modal', function () {
		window.location.reload();
	})


	$scope.requestToBeMentor = function(registerId,mentorEmailId,mentorFirstName,mentorLastName,projectId,teamId){
		$http({
			method : 'POST',
			url : 'ajax/requestToBeMentor',
			data : $.param({
				projId : projectId,
				teamId : teamId,
				mentorRegstrId : registerId,
				mentorEmailId : mentorEmailId,
				mentorFirstName : mentorFirstName,
				mentorLastName :mentorLastName
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'success') {
				$scope.message.push("Request To Be Mentor sent Successfully.");
				//location.reload();

			} else {
				$scope.message.push("Failed to send request mail, please try again later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};

	$('#requestBeMentorModal').on('hidden.bs.modal', function () {
		location.reload();
	})

	//alert($scope.teamId);

	$scope.searchMember = function(search) {
		$http({
			method : 'POST',
			url : 'ajax/searchTeamMembers',
			data : $.param(search),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {

			$scope.searchResults = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.addMember = function(registerId,name) {
		$scope.message1 = [];
		$http({
			method : 'POST',
			url : 'ajax/addTeamMember',
			data : $.param({
				registerId : registerId,
				projectId : $scope.projectId,
				teamId : $scope.teamId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			//alert(data);
			if (data.status == 'success') {
				/*$('#addmemberModal').on('hidden.bs.modal', function () {
					location.reload();
				})*/

				$scope.message1 = [];
				$scope.message1.push(name+" has been added successfully");
				/*$scope.initLoad();*/
			} else {
				$scope.message1 = [];
				$scope.message1.push("Some error occured in adding team member");
			}
			/*$scope.initLoad();*/
		}).error(function(data, status, headers, config) {
			$scope.message1 = [];
			$scope.message1.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$scope.currentMember = function(member) {

		$scope.chosenMember = member;
		$scope.memberName=$scope.chosenMember.teamMemFName+" "+$scope.chosenMember.teamMemMName+" "+$scope.chosenMember.teamMemLName;
		$scope.regID=$scope.chosenMember.teamMemRegstrId ;
	};


	$scope.removeMember = function() {

		$http({
			method : 'POST',
			url : 'ajax/removeTeamMember',
			data : $.param({
				registerId : $scope.chosenMember.teamMemRegstrId,
				projectId : $scope.projectId,
				teamId : $scope.teamId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			// alert(data);
			/*alert(data.teamLeaderId);
				alert(data.teamMemRegstrId);*/
			if (data.status == 'success') {
				$scope.removeMsg=[];
				$scope.message = [];
				$scope.removeMsg.push($scope.chosenMember.teamMemFName+"has been removed successfully.");
				$scope.message.push("Team member removed");

				$scope.initLoad();
			} else {
				$scope.removeMsg = [];
				$scope.removeMsg.push("Some problem occured while removing team member");
			}

		}).error(function(data, status, headers, config) {
			$scope.removeMsg = [];
			$scope.removeMsg.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	}


});

techpedia.controller('ManageChallengesController', function($scope, $http) {
	$scope.initLoad = function() {
		$scope.showchallenges = true;
		$scope.showchallengesIFollow = false;
		$scope.clickFilterApplied = "My Challenges";

		$http({
			method : 'POST',
			url : 'ajax/challengesIFollow',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.challengesIFollow = data;

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		$scope.clickFilter1 = function(type) {

			if (type === 'my') {

				$scope.showchallenges = true;
				$scope.showchallengesIFollow = false;	

				$scope.clickFilterApplied = "My Challenges";
			}

			if (type === 'follow') {

				$scope.showchallenges = false;
				$scope.showchallengesIFollow = true;

				$scope.clickFilterApplied = "Challenges I Follow";
			}

			if (type === 'all') {
				$scope.showchallenges = true;
				$scope.showchallengesIFollow = true;

				$scope.clickFilterApplied = "All Challenges";
			}
		};

		$http({
			method : 'POST',
			url : 'getUserType',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.userType = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		$http({
			method : 'POST',
			url : 'getId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.registerId = data;
			if ($scope.registerId > 0) {
				$http({
					method : 'POST',
					url : 'ajax/getChallengeListForOneUser',
					data : $.param({}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.challenges = data;
				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.deleteChallenge = function(challenge) {
		alert(challenge.challengDescription);
	};

	$scope.acceptChallenge = function(challenge) {
		window.location = window.location =  'acceptChallenge?challengeId=' + challenge.challengId+'&&challengeTitle='+challenge.challengTitle;

	};

	$scope.viewChallenge = function(challenge) {
		window.location = "challengeDetails" + challenge.challengId;
	};

	$scope.uploadChallengeDocument = function() {
		$http({
			method : 'POST',
			url : 'ajax/uploadChallengeDocument',
			data : $.param({
				registerId : $scope.registerId,
				challengeId : $scope.chosenChallenge.challengId,
				documentName : $scope.file.filename,
				documentBase64 : $scope.file.base64
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data.status == 'success'){
				$scope.message = [];
				$scope.message.push("Document uploaded succesfully");
			} else {
				$scope.message = [];
				$scope.message.push("Failed to upload document, Please try later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.currentChallenge = function(challenge) {
		$scope.chosenChallenge = challenge;
	};
});



/*$scope.activateProfile = function() {
	$http({
		method : 'POST',
		url : 'ajax/activateProfile',
		data : $.param({
			registerId : $scope.registerId,

		}),
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data, status, headers, config) {
		if (data.status == 'success'){
			$scope.message = [];
			$scope.message.push("Profile Activated succesfully");
		} else {
			$scope.message = [];
			$scope.message.push("Failed to Activate  Profile, Please try later");
		}
	}).error(function(data, status, headers, config) {
		$scope.message = [];
		$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
	});
};
 */


techpedia.controller('DashboardController', function($scope, $http) {
	$scope.message = [];
	$scope.myProjects=[];
	$scope.initLoad = function() {

		$scope.showMyProjects = true;
		$scope.showProjectsIFollow = true;
		$scope.clickFilterApplied = "All";


		$http({
			method : 'POST',
			url : 'ajax/getProjectListForOneUser',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.myProjects = data;
			//console.log($scope.myProjects+"No project");
			if($scope.myProjects.length===0)
			{
				$scope.message.push("No Projects ");
			}
		}).error(function(data, status, headers, config) {

			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		$http({
			method : 'POST',
			url : 'ajax/projectsIFollow',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projectsIFollow = data;
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.viewProject = function(project) {
		window.location = 'projectDetails' + project.projId;
	};

	$scope.clickFilter = function(type) {
		if (type === 'my') {
			$scope.showMyProjects = true;
			$scope.showProjectsIFollow = false;

			$scope.clickFilterApplied = "My Projects";
		}

		if (type === 'follow') {
			$scope.showMyProjects = false;
			$scope.showProjectsIFollow = true;

			$scope.clickFilterApplied = "Projects I Follow";
		}

		if (type === 'all') {
			$scope.showMyProjects = true;
			$scope.showProjectsIFollow = true;

			$scope.clickFilterApplied = "All";
		}
	};
});

techpedia.controller('ManageProjectsController', function($scope, $http) {
	$scope.selectedItem='All Projects';
	$scope.manageProjectsInit = function() {
		$scope.selectedItem='All Projects';
		$http({
			method : 'POST',
			url : 'getUserType',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.userType = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		$http({
			method : 'POST',
			url : 'ajax/getProjectListForOneUser',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projects = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

		$http({
			method : 'POST',
			url : 'getId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.registerId = data;
			console.log($scope.registerId);
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.additionalInfoGyti = function(projId) {
		window.location = 'additionalInfoGyti' + projId;
	};

	$scope.submitProject = function(id) {
		$http({
			method : 'POST',
			url : 'ajax/submitProject',
			data : $.param({
				projectId : id,
				status : 3
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			alert("Do you want to submit the project?");
			$scope.message = [];
			if (data.status == 'success') {
				window.location.reload();
				$scope.message.push("Project submitted succesfully");
			} else {
				window.location.reload();
				$scope.message.push("Some problem occured while submitting the project. Please try again later.");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.reSubmitProject = function(id) {
		$http({
			method : 'POST',
			url : 'ajax/resubmitProject',
			data : $.param({
				projectId : id
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			alert("Do you want to resubmit the project?");
			$scope.message = [];
			if (data.status == 'success') {
				window.location.reload();
				$scope.message.push("Project resubmitted succesfully");
			} else {
				window.location.reload();
				$scope.message.push("Some problem occured while resubmitting the project. Please try again later.");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};


	$scope.pitchProject = function(project) {
		$scope.chosenProject = project;
		$http({
			method : 'POST',
			url : 'ajax/pitchProjectSearch',
			data : $.param({
				projectId : project.projId,
				registerId: $scope.registerId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {

			$scope.suggestedMentors = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.addMentor = function(mentor) {
		$http({
			method : 'POST',
			url : 'ajax/addMentorToProject',
			data : $.param({
				projectId : $scope.chosenProject.projId,
				mentorId : mentor.rgstrId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				window.location = 'projectDetails' + $scope.chosenProject.projId;
				$scope.message = [];
				$scope.message.push("Mentor added");
			} else {
				$scope.message = [];
				$scope.message.push("More than two mentor can not be added for a single project");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.viewProject = function(id) {
		window.location = "projectDetails" + id;
	};

	$scope.currentProject = function(project) {

		$scope.chosenProject = project;
	};
	$scope.datarefresh = function(){
		$scope.message = "";

		location.reload();
	}


	/*$("#choseefile").on('change', function() {
		alert("Updated addFileInput===");
		  var fs = document.getElementById("uploadmodalId");
        // only add one if the last file-input field is not empty
		  if(fs.lastElementChild.value != '') {
              var firstInputFile = document.getElementById("choseefile");
             // var firstInputFile=$(".uploadclass");
              alert("addFileInput ="+firstInputFile);
              var newInputFile = document.createElement("input");
              newInputFile.type = firstInputFile.type;
              newInputFile.name=firstInputFile.name;
              newInputFile.id=firstInputFile.id;
              newInputFile.multiple=firstInputFile.multiple;
              newInputFile.class = firstInputFile.class;
              newInputFile.base64 = firstInputFile.base64;
              alert(newInputFile.base64);
              newInputFile.onchange=firstInputFile.onchange;
              fs.appendChild(newInputFile);
          }


});*/
	/*	$scope.addFileInput=function(modalName, firstInputId) {
							    	alert("Updated addFileInput");
							         var fs = document.getElementById(modalName);
							        alert(fs);
							        // only add one if the last file-input field is not empty
							        if(fs.lastElementChild.value != '') {
							            var firstInputFile = document.getElementById(firstInputId);
							           // var firstInputFile=$(".uploadclass");
							            alert("addFileInput ="+firstInputFile);
							            var newInputFile = document.createElement("input");
							            newInputFile.type = firstInputFile.type;
							            newInputFile.name=firstInputFile.name;
							            newInputFile.multiple=firstInputFile.multiple;
							            newInputFile.class = firstInputFile.class;
							            newInputFile.base64 = firstInputFile.base64;
							            alert(newInputFile.base64);
							            newInputFile.onclick=firstInputFile.onclick;
							            fs.appendChild(newInputFile);
							        }

							    } 
	 */




	$scope.uploadProjectDocument = function() {
		//alert("hI..."+$scope.chosenProject.projId);
		var ready = false;
		var baseFiles=[];
		var text ;
		$scope.upload = false;
		var check = function() {

			if (ready === true) {
				// do what you want with the result variable
				//console.log(baseFiles.length+ "********1 "+JSON.stringify(baseFiles));
				var documentMap = baseFiles.reduce(function(map, obj) {
					//alert("length***"+obj.fileBase64.length+1);
					//alert("base64***"+obj.fileBase64.substring(obj.fileBase64.indexOf(",") + 1,obj.fileBase64.length+1));
					map[obj.fileName] = obj.fileBase64.substring(obj.fileBase64.indexOf(",") + 1,obj.fileBase64.length+1);
					return map;
				}, {});
				console.log(documentMap);
				$http({
					method : 'POST',
					url : 'ajax/uploadMultipleProjectDocumentForManageProject',
					data : $.param({
						registerId : $scope.registerId,
						projectId : $scope.chosenProject.projId,
						documentMap : JSON.stringify(documentMap)
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}

				}).success(function(data, status, headers, config) {
					//alert("success...");
					$scope.upload = true;
					if (data.status == 'success') {
						$scope.message = [];
						$scope.message.push("Document uploaded succesfully");
					} else {
						$scope.message = [];
						$scope.message.push("Failed to upload document, Please try later");
					}
				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
				return;
			}
			setTimeout(check, 3000);
		};
		var x = document.getElementsByName("choseefile[]");
		var fileReader;
		var fname;
		//alert("choseefile[] length===="+x.length);
		for(var j = 0; j < x.length; j++){
			// alert("x"+x[j]);
			if ('files' in x[j]) {

				if (x[j].files.length == 0) {
					// alert("Select one or more files.");
				} else {
					//alert("files length=="+x[j].files.length);
					for (var i = 0; i < x[j].files.length; i++) {
						var file = x[j].files[i];
						if ('name' in file) {

							//alert("out side File name*****"+file.name);

							fileReader = new FileReader();
							fileReader.myfile = file;
							fileReader.onloadend = function(fileLoadedEvent) 
							{
								//alert("***base64***conversion===="+fileLoadedEvent.target.result);
								/* fileName = file.name;
                    	 baseFiles[fileName]=fileLoadedEvent.target.result;*/

								//alert("File name==**="+this.myfile.name);
								baseFiles.push({
									fileName:   this.myfile.name,
									fileBase64: fileLoadedEvent.target.result
								});
								text = '{ "fileaaray" :'+JSON.stringify(baseFiles)+'}';

								ready = true;
								check();

							}

							fileReader.readAsDataURL(file);
						}
					}
				}
			}
		}


		//alert(baseFiles.length+ "********2");



		// alert()
		/*$scope.message = "";
		$http({
			method : 'POST',
			url : 'ajax/uploadProjectDocument',
			data : $.param({
				registerId : $scope.registerId,
				projectId : $scope.chosenProject.projId,
				documentName : $scope.file.filename,
				documentBase64 : $scope.file.base64
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.message = [];
				$scope.message.push("Document uploaded succesfully");
			} else {
				$scope.message = [];
				$scope.message.push("Failed to upload document, Please try later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});*/
	};

	$scope.deleteProject = function(project) {
		var response = confirm("Are your sure that you want to proceed ?");
		if (response) {
			$http({
				method : 'POST',
				url : 'ajax/deleteProject',
				data : $.param({
					id : project.projId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.message = [];
				if (data === 'Y') {
					var index = $scope.projects.indexOf(project);
					$scope.projects.splice(index, 1);
					$scope.message.push("Project deleted succesfully");
				} else {
					$scope.message.push("Failed to delete project, please try again later");
				}
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};

	$scope.editProject = function(project) {
		window.location = 'editProject?id=' + project.projId;
	};

	$scope.editGytiInnovation = function(project) {
		window.location = 'editNewInnovation?id=' + project.projId;
	};

	$scope.initiateProject = function(state) {

		$http({
			method : 'POST',
			url : 'ajax/facultyInitiateProject',
			data : $.param({
				projectId : $scope.chosenProject.projId,
				facultyId : $scope.registerId,
				approvalStatus : state
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			//console.log(data);
			if (data.status ==='success') {

				if (state === 'Y') {location.reload();
				$scope.message.push("Project initiated succesfully.");
				} else {location.reload();
				$scope.message.push("Project initiation rejected by you");
				}
			} else {
				$scope.message.push("Failed to initiate project, please try again later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};


	$scope.rejectProject = function(state,comment) {

		$http({
			method : 'POST',
			url : 'ajax/facultyRejectedProject',
			data : $.param({
				projectId : $scope.chosenProject.projId,
				facultyId : $scope.registerId,
				approvalStatus : state,
				rejectReason : comment
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			//console.log(data);
			if (data.status ==='success') {

				if (state === 'Y') {location.reload();
				$scope.message.push("Project rejected succesfully.");
				} else {location.reload();
				$scope.message.push("Project rejected by you");
				}
			} else {
				$scope.message.push("Failed to reject project, please try again later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};




	/*$scope.closeProject = function(state) {
		// alert($scope.registerId + $scope.chosenProject.projId + " " + state);
		$http({
			method : 'POST',
			url : 'ajax/facultyCloseProject',
			data : $.param({
				projectId : $scope.chosenProject.projId,
				facultyId : $scope.registerId,
				approvalStatus : state
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'success') {
				if (state === 'Y') {location.reload();
				$scope.message.push("Project closed succesfully");
				} else {location.reload();
				$scope.message.push("Closing of project rejected by you");
				}
			} else {
				$scope.message.push("Failed to close project, please try again later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	 */

	/*Mark project as completed*/
	$scope.markAsCompletedProject = function(state,grade,notes) {
		// alert($scope.registerId + $scope.chosenProject.projId + " " + state);
		$http({
			method : 'POST',
			url : 'ajax/facultyMarkedProjectAsCompleted ',
			data : $.param({
				projectId : $scope.chosenProject.projId,
				facultyId : $scope.registerId,
				approvalStatus : state,
				projectGrade : grade,
				projectNotes : notes
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'success') {
				if (state === 'Y') {location.reload();
				$scope.message.push("Project mark as completed succesfully");
				} else {location.reload();
				$scope.message.push("Completion of project rejected by you");
				}
			} else {
				$scope.message.push("Failed to close project, please try again later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};



	/*Modify project*/
	$scope.modifyProject = function(state,reason) {
		// alert($scope.registerId + $scope.chosenProject.projId + " " + state);
		$http({
			method : 'POST',
			url : 'ajax/modifyProjectReason ',
			data : $.param({
				projectId : $scope.chosenProject.projId,
				facultyId : $scope.registerId,
				approvalStatus : state,
				rejectReason : reason
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'success') {
				if (state === 'Y') {location.reload();
				$scope.message.push("Project needs some modification.");
				} else {location.reload();
				$scope.message.push("Modification of project rejected by you");
				}
			} else {
				$scope.message.push("Failed to close project, please try again later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};



	$scope.rejectnotesPopup = function(){

		//       e.preventDefault();
		$('#grade').hide();
		$('#notes').hide();
		$('#modify').hide();
		$('#markascompleted').hide();
		$('#myModalLabel1').hide();
		$('#rejectnotes').show();
		$('#modifywithRejectNotes').show();
		$('#myModalLabel2').show();

	}

	$('#closeProjectModal').on('hidden.bs.modal', function () {
		location.reload();
	})

	$('#rejectProjectModal').on('hidden.bs.modal', function () {
		location.reload();
	})


	/*Filter project codes starts here*/
	$scope.statusCompleted= function(regstrId){
		/*$scope.selectedItem;*/
		$scope.selectedItem ='Completed Projects';
		$scope.all='All Projects';
		/*alert($scope.selectedItem);*/
		$http({
			method :'POST',
			url :'filterProjectcompleted',
			data: $.param({

				regstrId: regstrId ,
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.projects = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	}

	$scope.statusWorking=function(regstrId){
		/*$scope.selectedItem;*/
		$scope.all='All Projects';
		$scope.selectedItem = 'Working Projects';
		/*alert($scope.selectedItem);*/
		$http({
			method :'POST',
			url :'filterProjectworking',
			data: $.param({

				regstrId: regstrId ,
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.projects = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	}



	$scope.allProject=function(regstrId){
		/*$scope.selectedItem;*/
		$scope.selectedItem = 'All Projects';
		$scope.all='All Projects';

		/*alert($scope.selectedItem);*/
		$http({
			method :'POST',
			url :'ajax/getProjectListForOneUser',
			data: $.param({

				regstrId: regstrId ,
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.projects = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	}


	$scope.allGytiProject=function(regstrId){
		/*$scope.selectedItem;*/
		$scope.selectedItem = 'GYTI Projects';
		$scope.all='All Projects';

		/*alert($scope.selectedItem);*/
		$http({
			method :'POST',
			url :'ajax/getAllGytiProjectByLoggedInUser',
			data: $.param({

				regstrId: regstrId ,
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.projects = data;
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	}







	/*Filter project codes ends here*/




});

techpedia.controller('ProjectDetail', function($scope, $http) {

	
	$scope.viewProject = function(project) {
		window.location = 'projectDetails' + project.projId;
	};
	$http({
		method : 'POST',
		url : 'projectsFetch',
		data : $.param({
			set : 1
		}),
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data, status, headers, config) {
		$scope.projects = data;
		for(var i=0;i<$scope.projects.length;i++){

			if($scope.projects[i].projTitle.length>41){
				$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 25)+"...";
			}
			if($scope.projects[i].projCollege.length>41){
				$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 25)+"...";
			}
			if($scope.projects[i].projFacultyName.length>41){
				$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 25)+"...";
			}
		}
	}).error(function(data, status, headers, config) {
		$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
	});

	$scope.count = 0;
	$scope.downloadDocumentLink= function(document) {
		//window.location = document.docLink;
		$http({
			method : 'POST',
			url : 'ajax/DownloadFileLink',
			data : $.param({
				documentLink : document.docLink
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			window.location = 'DownloadFile';

		})
	};
		
	/*	$scope.downloadDocument = function(document) {
		$http({
			data : $.param({
				documentLink : document.docLink
			}),

		})
		window.location = 'DownloadFile';

	};*/
	$http({
		method : 'POST',
		url : 'getId',
		data : $.param({}),
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded'
		}
	}).success(function(data, status, headers, config) {
		$scope.registerId = data;
})
	$scope.InitLoad = function() {
		//$scope.urlLinkedIn=document.URL;
		$http({
			method : 'POST',
			url : 'projectDetailsLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projectdetails = data;

			$http({
				method : 'POST',
				url : 'ajax/teamDetailsLoadfordownload',
				data : $.param({

					teamId :data.projTeamId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {


				$scope.members = data;
				for (var i=0;i<=data.length;i++) {

					if ( data[i].teamMemRegstrId == $scope.registerId) {
						$scope.teamMember= true;
					}}
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});


			/*var dataArray = [];
			for (var i = 0; i < data.projTeamMemberList.length; i++) {
				var projTeamMemberListid = data.projKeywords[i];
				 if ( data.projKeywords[i].teamID ==$scope.edit.projTeamId) {
			        	$scope.edit.projTeamDesc=data[i].teamName;
			        }
				var json = {};
				json.id = keyword;
				json.text = keyword;
				dataArray.push(json);
			}
			console.log(JSON.stringify(dataArray));
			$("#projectKeywords").select2("data", dataArray);
			 */

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		$http({
			method : 'POST',
			url : 'projectId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			$scope.projectId = data;

			$http({
				method : 'POST',
				url : 'ajax/getTeamComments',
				data : $.param({
					projectId : $scope.projectId,
					set : 0
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.teamComments = data;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});

			$http({
				method : 'POST',
				url : 'ajax/getProjectMentors',
				data : $.param({
					projectId : $scope.projectId,
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {

				$scope.projectMentorList = data;



			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});

			$http({
				method : 'POST',
				url : 'ajax/getPublicComments',
				data : $.param({
					projectId : $scope.projectId,
					set : 0
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.publicComments = data;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});

			$http({
				method : 'POST',
				url : 'getId',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.message = [];
				$scope.registerId = data;
				//alert($scope.registerId);
				// Get project Documents
				$http({
					method : 'POST',
					url : 'ajax/getProjectDocuments',
					data : $.param({
						projectId : $scope.projectId,
						registerId : $scope.registerId
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.projectDocumentList = data;

				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});

				// Get if the user follows the project
				$http({
					method : 'POST',
					url : 'ajax/doesFollow',
					data : $.param({
						projectId : $scope.projectId,
						registerId : $scope.registerId,
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$scope.message = [];
					if (data.status == 'success')
						$scope.doesFollow = true;
					else
						$scope.doesFollow = false;

				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};
	$scope.viewMorePublicComments = function(comment,setNumber) {

		$scope.messagepubliccomments = [];
		$http({
			method : 'POST',
			url : 'ajax/getPublicComments',
			data : $.param({
				projectId : $scope.projectId,
				set : setNumber+1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			//alert(data.length)
			if(data.length>0){

				$scope.publicComments = $scope.publicComments.concat(data);

			}else{
				$scope.messagepubliccomments.push("No more comments found");	
				$('#publiccomments').hide();

			}
		}).error(function(data, status, headers, config) {
			$scope.messagepubliccomments.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


	};
	$scope.viewMoreTeamComments = function(comment,setNumber) {

		$scope.messageteamcomments = [];
		$http({
			method : 'POST',
			url : 'ajax/getTeamComments',
			data : $.param({
				projectId : $scope.projectId,
				set : setNumber+1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if(data.length>0){
				$scope.teamComments = $scope.teamComments.concat(data);

			}else{
				$scope.messageteamcomments.push("No more comments found");	
				$('#teamcomments').hide();

			}
		}).error(function(data, status, headers, config) {
			$scope.messageteamcomments.push("Possibly the service is down, Please contact the admin if problem persists.");
		});


	};

	$scope.deleteMentor = function(mentor) {
		if(confirm("Are you sure ?")){
			$http({
				method : 'POST',
				url : 'ajax/deleteMentorFromProject',
				data : $.param({
					projectId : $scope.projectId,
					mentorId : mentor.rgstrId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {

				if (data.status == 'success') {

					var index = $scope.projectMentorList.indexOf(mentor);
					$scope.projectMentorList.splice(index, 1);

					$scope.mentordeletemessage = [];
					$scope.mentordeletemessage.push("Mentor deleted");
				} else {
					$scope.mentordeletemessage = [];
					$scope.mentordeletemessage.push("Failed to delete mentor");
				}
			}).error(function(data, status, headers, config) {
				$scope.mentordeletemessage = [];
				$scope.mentordeletemessage.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};

	$scope.follow = function() {
		$http({
			method : 'POST',
			url : 'ajax/followProject',
			data : $.param({
				projectId : $scope.projectId,
				registerId : $scope.registerId,
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'failure')
				$scope.doesFollow = false;
			else
				$scope.doesFollow = true;

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.unfollow = function() {
		$http({
			method : 'POST',
			url : 'ajax/unfollowProject',
			data : $.param({
				projectId : $scope.projectId,
				registerId : $scope.registerId,
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data.status == 'failure')
				$scope.doesFollow = true;
			else
				$scope.doesFollow = false;

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$scope.postpublicComment = function(comment,regid,jCaptcha) {
		$http({
			method : 'POST',
			url : 'ajax/postComment',
			data : $.param({
				projectId : $scope.projectId,
				registerId :regid,
//				registerId : regid,
				comment :comment,
				CaptchaValue: jCaptcha,

			}),

			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'

			}

		}).success(function(data, status, headers, config) {
			$scope.message = [];
			$scope.messageerrorCaptcha=[];
			$scope.messagesuccess=[];
			if(data=='Invalid Captcha')
			{
				$scope.messageerrorCaptcha.push("Invalid Captcha, Please try again!");
				reloadCaptcha();
			}
			else if(data.status=='success')
			{

				$scope.messagesuccess.push("Comment Added Successfully.");
				$scope.InitLoad();
				reloadCaptcha();
			}
			else {

				$scope.message.push("Some error occured while posting the comment");
			}
			$scope.teamComment = '';
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$scope.postComment = function(comment) {
		alert($scope.registerId);

		$http({
			method : 'POST',
			url : 'ajax/postComment',
			data : $.param({
				projectId : $scope.projectId,
				registerId : $scope.registerId,
//				registerId : regid,
				comment : $scope.teamComment

			}),

			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'

			}

		}).success(function(data, status, headers, config) {

			$scope.message = [];
			if (data === 'N')
				$scope.message.push("Some error occured while posting the comment");
			else {
				$scope.InitLoad();
			}
			$scope.teamComment = '';
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	$scope.deletePublicComment = function(comment, type) {
		var id=-1;
		if (confirm("Are you sure ?")) {
			$http({
				method : 'POST',
				url : 'ajax/deleteComment',
				data : $.param({
					projectId : $scope.projectId,
					commentId : comment.commentId,
					registerId : id,
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.message = [];
				if (data.status == 'failure'){
					alert('Failed to delete comment');}


				var index = $scope.publicComments.indexOf(comment);

				$scope.publicComments.splice(index, 1);


			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};
	$scope.deleteComment = function(comment, type) {
		if (confirm("Are you sure ?")) {
			$http({
				method : 'POST',
				url : 'ajax/deleteComment',
				data : $.param({
					projectId : $scope.projectId,
					commentId : comment.commentId,
					registerId : $scope.registerId,
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.message = [];
				if (data.status == 'failure')
					alert('Failed to delete comment');
				else {
					if (type === 'public') {
						var index = $scope.publicComments.indexOf(comment);
						$scope.publicComments.splice(index, 1);
					} else {
						var index = $scope.teamComments.indexOf(comment);
						console.log(comment.projComment);
						console.log($scope.teamComment);
						$scope.teamComments.splice(index, 1);
					}
				}
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};

	$scope.deleteDocument = function(document) {
		$http({
			method : 'POST',
			url : 'ajax/deleteProjectDocument',
			data : $.param({
				projectId : $scope.projectId,
				registerId : $scope.registerId,
				documentName : document.docName
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.deletedocmessage = [];
				$scope.deletedocmessage.push("Document deleted Successfully");
				var index = $scope.challengeDocumentList.indexOf(document);
				$scope.challengeDocumentList.splice(index, 1);
				$scope.deletedocmessage.push("Document deleted Successfully");


			} else {
				$scope.deletedocmessage = [];
				$scope.deletedocmessage.push("Failed to delete document");
			}
		}).error(function(data, status, headers, config) {
			$scope.deletedocmessage = [];
			$scope.deletedocmessage.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};		
});
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

techpedia.controller('AddProjectController', function($scope, $http) {
	/*$scope.$watch('file', function() {
		$scope.addProject.imgByteArray = $scope.file.base64.substring(24,$scope.file.base64.length+1);
		$scope.addProject.imgName = $scope.file.filename;
		alert("image inside"+$scope.addProject.imgByteArray+"  Name"+$scope.addProject.imgName);	
	}, true);*/



	$scope.InitLoad = function() {
		$scope.addProject = {};
		$scope.addProject.university = '';
		$scope.addProject.studentID = '';
		$scope.addProject.collge = '';
		$scope.addProject.state = '';

		$http({
			method : 'POST',
			url : 'getId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.registerId = data;

			$http({
				method : 'POST',
				url : 'ajax/editProfileLoad',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.addProject.university = data.university;
				$scope.addProject.studentID = data.studentID;
				$scope.addProject.collge = data.collge;
				$scope.addProject.state = data.state;
				$scope.message = [];
			}).error(function(data, status, headers, config) {

				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	
	$('#addNewTeamMemberModal').on('hidden.bs.modal', function (e) {
		  $(this)
		    .find("input,textarea,select")
		       .val('')
		       .end()
		    .find("input[type=checkbox], input[type=radio]")
		       .prop("checked", "")
		       .end();
		  $("#branchIdOfStudent2").select2("val", "");
		  $('#addTeamMemberErrorDiv').hide();
		  $('#addTeamMemberSuccessDiv').hide();
		  $('#addTeamMemberMessageDiv').hide();
		})
		
		$('#addNewFacultyModal').on('hidden.bs.modal', function (e) {
		  $(this)
		    .find("input,textarea,select")
		       .val('')
		       .end()
		    .find("input[type=checkbox], input[type=radio]")
		       .prop("checked", "")
		       .end();
		  $("#branchIdOfStudent1").select2("val", "");
		  $("#errorDiv").hide();
		  $("#successDiv").hide();
		  $('#messageDiv').hide();
		})
	
		$scope.ClickToResetTheTeamMemberForm=function(){
		$('#fName').val("");
		$('#mName').val("");
		$('#lName').val("");
		document.getElementById("gender1").checked = false;
		document.getElementById("gender2").checked = false;
		document.getElementById("gender3").checked = false;
		$('#age').val("");
		$('#branchIdOfStudent2').val("");
		$('#emailId').val("");
		
		$('#addTeamMemberErrorDiv').hide();
		$('#addTeamMemberSuccessDiv').hide();
		$('#addTeamMemberMessageDiv').hide();
		
	};
	
	$scope.ClickToResetTheFacultyForm=function(){
		$('#fName').val("");
		$('#mName').val("");
		$('#lName').val("");
		document.getElementById("gender1").checked = false;
		document.getElementById("gender2").checked = false;
		document.getElementById("gender3").checked = false;
		$('#age').val("");
		$('#branchIdOfStudent1').val("");
		$('#CollegeNames1').val("");
		$('#emailId').val("");
		$('#errorDiv').hide();
		$('#successDiv').hide();
		$('#messageDiv').hide();
		

	};
		
	$scope.addTeamMember = function(){
		$http({
			method : 'POST',
			url: 'ajax/addNewTeamMember',

			data : $.param($scope.addMember),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.teamMemberErrormessage = [];
			$scope.teamMemberSuccessmessage = [];
			$scope.teamMemberName=$scope.addMember.fName+" "+$scope.addMember.mName+" "+$scope.addMember.lName;
			if(data.status=='Failed to Create Team Member.'){
				$scope.teamMemberErrormessage.push(data.status+" "+data.description+" "+data.exceptionDetails);
				$("#addTeamMemberErrorDiv").show();
				 $("#addTeamMemberSuccessDiv").hide();
			}else if(data.status=='success'){
				$scope.teamMemberSuccessmessage.push(data.description);
				 $("#addTeamMemberSuccessDiv").show();
				 $("#addTeamMemberErrorDiv").hide();
			}else if(data.status=='Team Member Created Successfully.' || data.status=='Team Member Created Successfully. However, Mail could not be sent'){
				$scope.teamMemberSuccessmessage.push(data.status+" "+data.description+" "+data.exceptionDetails);
				 $("#addTeamMemberSuccessDiv").show();
				 $("#addTeamMemberErrorDiv").hide();
				/*if($('#teamMembers').val().length<=0) {
					$('#teamMembers').val($('#teamMembers').val() + $scope.teamMemberName);
				} else {
					$('#teamMembers').val($('#teamMembers').val() + "," + $scope.teamMemberName);
				}*/
			}
			
		}).error(function(data, status, headers, config) {
			$scope.teamMembermessage = [];
			$scope.teamMembermessage.push("Possibly the service is down, Please contact the admin if problem persists.");
			 $("#addTeamMemberSuccessDiv").hide();
			 $("#addTeamMemberErrorDiv").hide();
			 $("#teamMembermessage").show();
		});
	}
	
	$scope.addNewFaculty = function(){
		$http({
			method : 'POST',
			url: 'ajax/registerNewFaculty',

			data : $.param($scope.newFaculty),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.facultyErrormessage = [];
			$scope.facultySuccessmessage = [];
			//$scope.teamMemberName=$scope.addMember.fName+" "+$scope.addMember.mName+" "+$scope.addMember.lName;
			if(data.status=='Failed to Create Faculty.'){
				$scope.facultyErrormessage.push(data.status+" "+data.description+" "+data.exceptionDetails);
				$("#errorDiv").show();
				 $("#successDiv").hide();
			}else if(data.status=='success'){
				$scope.facultySuccessmessage.push(data.description);
				 $("#successDiv").show();
				 $("#errorDiv").hide();
			}else if(data.status=='Faculty Created Successfully.' || data.status=='Faculty Created Successfully. However, Mail could not be sent'){
				$scope.facultySuccessmessage.push(data.status+" "+data.description+" "+data.exceptionDetails);
				 $("#successDiv").show();
				 $("#errorDiv").hide();
				 $('#projFaculty').append('<option selected="selected" value="' + data + '">' + $('#newFaculty').val() + '</option>');
				/*if($('#teamMembers').val().length<=0) {
					$('#teamMembers').val($('#teamMembers').val() + $scope.teamMemberName);
				} else {
					$('#teamMembers').val($('#teamMembers').val() + "," + $scope.teamMemberName);
				}*/
			}
			
		}).error(function(data, status, headers, config) {
			$scope.facultymessage = [];
			$scope.facultymessage.push("Possibly the service is down, Please contact the admin if problem persists.");
			 $("#successDiv").hide();
			 $("#errorDiv").hide();
			 $("#messageDiv").show();
		});
	}



	$scope.createdNewProject=function()	
	{
		/*$scope.$watch('file', function() {
			//$scope.addProject.photo = $scope.file.base64;
			$scope.addProject.imgByteArray=$scope.file.base64;
			$scope.addProject.imgName=$scope.file.filename;
		}, true);*/
		$scope.message = "";

		$http({
			method : 'POST',
			/*url : 'registerRequest?res='+$scope.v,*/

			url: 'addProject',

			data : $.param($scope.addProject),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data === 'Y') {
				$scope.message.push("Photo uploaded successfully");
			}else if (data === 'N'){
				$scope.message.push("Photo Error");
			}else {
				$scope.message.push(data);
			}

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	}	
	/*codes for image project upload ends here*/









});



techpedia.controller('NewInnovationController', function($scope, $http) {
	/*$scope.$watch('file', function() {
		$scope.addProject.imgByteArray = $scope.file.base64.substring(24,$scope.file.base64.length+1);
		$scope.addProject.imgName = $scope.file.filename;
		alert("image inside"+$scope.addProject.imgByteArray+"  Name"+$scope.addProject.imgName);	
	}, true);*/

	$scope.datarefresh = function(){
		$scope.message = "";

		location.reload();
	}
	$scope.InitLoad = function() {
		
		
		var min = 2008;
		 var date = new Date();
		 var currentYear = date.getFullYear()-1;
	    select = document.getElementById('awardYear');

	for (var i = min; i<=currentYear; i++){
	    var opt = document.createElement('option');
	    opt.value = i;
	    opt.innerHTML = i;
	    select.appendChild(opt);
	}


		/*$scope.projStatusArray = [
		                 'Research Stage (Lab. Stage)',
		                 'Proof of Concept',
		                 'Prototype',
		                 'Product',
		                 'Pre-Incubation Stage',
		                 'Already into the Market/Implementation'
		               ];*/
		$scope.newInnovation = {};
		$scope.newInnovation.university = '';
		$scope.newInnovation.studentID = '';
		$scope.newInnovation.collge = '';
		$scope.newInnovation.state = '';
		$scope.newInnovation.projStatusInfo = '';

		$http({
			method : 'POST',
			url : 'getId',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.registerId = data;
			$http({
				method : 'POST',
				url : 'ajax/editProfileLoad',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.newInnovation.university = data.university;
				$scope.newInnovation.studentID = data.studentID;
				$scope.newInnovation.collge = data.collge;
				$scope.newInnovation.state = data.state;
				$scope.message = [];
			}).error(function(data, status, headers, config) {

				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};



	$scope.createdNewProject=function()	
	{
		/*$scope.$watch('file', function() {
			//$scope.addProject.photo = $scope.file.base64;
			$scope.addProject.imgByteArray=$scope.file.base64;
			$scope.addProject.imgName=$scope.file.filename;
		}, true);*/
		$scope.message = "";

		$http({
			method : 'POST',
			/*url : 'registerRequest?res='+$scope.v,*/

			url: 'addProject',

			data : $.param($scope.addProject),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data === 'Y') {
				$scope.message.push("Photo uploaded successfully");
			}else if (data === 'N'){
				$scope.message.push("Photo Error");
			}else {
				$scope.message.push(data);
			}

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
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
            // $scope.selectYear(d.format('YYYY'));
            }
        }); 

        
    });
	
	$scope.validateCheckboxes = function(additionalInnvationForm){
		
		
		var elements = document.getElementsByName("idea[]");
		for(var i=0; i < elements.length; i++){
			if(elements[i].checked && additionalInnvationForm==false) {
				return false;
			}
		}
		return true;
	}
	
	$('#addNewTeamMemberModal').on('hidden.bs.modal', function (e) {
		  $(this)
		    .find("input,textarea,select")
		       .val('')
		       .end()
		    .find("input[type=checkbox], input[type=radio]")
		       .prop("checked", "")
		       .end();
		  $("#branchIdOfStudent2").select2("val", "");
		  $('#errorDiv').hide();
			$('#successDiv').hide();
			$('#addTeamMemberMessageDiv').hide();
		})
	
	$scope.ClickToResetTheTeamMemberForm=function(){
		$('#fName').val("");
		$('#mName').val("");
		$('#lName').val("");
		document.getElementById("gender1").checked = false;
		document.getElementById("gender2").checked = false;
		document.getElementById("gender3").checked = false;
		$('#age').val("");
		$('#branchIdOfStudent2').val("");
		$('#emailId').val("");
		
		$('#errorDiv').hide();
		$('#successDiv').hide();
		$('#addTeamMemberMessageDiv').hide();
		
	};
	
	$scope.addTeamMember = function(){
		$http({
			method : 'POST',
			url: 'ajax/addNewTeamMember',

			data : $.param($scope.addMember),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.Errormessage = [];
			$scope.Successmessage = [];
			$scope.teamMemberName=$scope.addMember.fName+" "+$scope.addMember.mName+" "+$scope.addMember.lName;
			if(data.status=='Failed to Create Team Member.'){
				$scope.Errormessage.push(data.status+" "+data.description+" "+data.exceptionDetails);
				$("#errorDiv").show();
				$("#successDiv").hide();
			}else if(data.status=='success'){
				$scope.Successmessage.push(data.description);
				 $("#successDiv").show();
				 $("#errorDiv").hide();
			}else if(data.status=='Team Member Created Successfully.' || data.status=='Team Member Created Successfully. However, Mail could not be sent'){
				$scope.Successmessage.push(data.status+" "+data.description+" "+data.exceptionDetails);
				 $("#successDiv").show();
				 $("#errorDiv").hide();
				/*if($('#teamMembers').val().length<=0) {
					$('#teamMembers').val($('#teamMembers').val() + $scope.teamMemberName);
				} else {
					$('#teamMembers').val($('#teamMembers').val() + "," + $scope.teamMemberName);
				}*/
			}
			
		}).error(function(data, status, headers, config) {
			$scope.teamMembermessage = [];
			$scope.teamMembermessage.push("Possibly the service is down, Please contact the admin if problem persists.");
			 $("#successDiv").hide();
			 $("#errorDiv").hide();
			 $("#teamMembermessage").show();		});
	}
	/*codes for image project upload ends here*/

	$scope.openUploadModal = function() {
		$('#askForUploadModal').modal('hide')
		$('#uploadModal').modal('show')
	};

	$scope.uploadProjectDocument = function() {

		var ready = false;
		var baseFiles=[];
		var text ;
		$scope.upload = false;
		var check = function() {

			if (ready === true) {
				// do what you want with the result variable
				//console.log(baseFiles.length+ "********1 "+JSON.stringify(baseFiles));
				var documentMap = baseFiles.reduce(function(map, obj) {
					//alert("length***"+obj.fileBase64.length+1);
					//alert("base64***"+obj.fileBase64.substring(obj.fileBase64.indexOf(",") + 1,obj.fileBase64.length+1));
					map[obj.fileName] = obj.fileBase64.substring(obj.fileBase64.indexOf(",") + 1,obj.fileBase64.length+1);
					return map;
				}, {});
				console.log(documentMap);
				$http({
					method : 'POST',
					url : 'ajax/uploadMultipleProjectDocument',
					data : $.param({
						registerId : $scope.registerId,
						documentMap : JSON.stringify(documentMap)
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}

				}).success(function(data, status, headers, config) {
					//alert("success...");
					$scope.upload = true;
					if (data.status == 'success') {
						$scope.message = [];
						$scope.message.push("Document uploaded succesfully");
					} else {
						$scope.message = [];
						$scope.message.push("Failed to upload document, Please try later");
					}
				}).error(function(data, status, headers, config) {
					$scope.message = [];
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
				return;
			}
			setTimeout(check, 3000);
		};
		var x = document.getElementsByName("choseefile[]");
		var fileReader;
		var fname;
		//alert("choseefile[] length===="+x.length);
		for(var j = 0; j < x.length; j++){
			// alert("x"+x[j]);
			if ('files' in x[j]) {

				if (x[j].files.length == 0) {
					// alert("Select one or more files.");
				} else {
					//alert("files length=="+x[j].files.length);
					for (var i = 0; i < x[j].files.length; i++) {
						var file = x[j].files[i];
						if ('name' in file) {

							//alert("out side File name*****"+file.name);

							fileReader = new FileReader();
							fileReader.myfile = file;
							fileReader.onloadend = function(fileLoadedEvent) 
							{
								//alert("***base64***conversion===="+fileLoadedEvent.target.result);
								/* fileName = file.name;
                    	 baseFiles[fileName]=fileLoadedEvent.target.result;*/

								//alert("File name==**="+this.myfile.name);
								baseFiles.push({
									fileName:   this.myfile.name,
									fileBase64: fileLoadedEvent.target.result
								});
								text = '{ "fileaaray" :'+JSON.stringify(baseFiles)+'}';

								ready = true;

								/*alert("filesssss "+ JSON.stringify(baseFiles) +"length"+baseFiles.length);
								console.log("base==="+JSON.stringify(baseFiles));
                    	 console.log("Files array --> "+baseFiles.length);*/
								// alert("ready==="+ready);
								check();

							}

							fileReader.readAsDataURL(file);
						}
					}
				}
			}
		}


		//alert(baseFiles.length+ "********2");



		// alert()
		/*$scope.message = "";
		$http({
			method : 'POST',
			url : 'ajax/uploadProjectDocument',
			data : $.param({
				registerId : $scope.registerId,
				projectId : $scope.chosenProject.projId,
				documentName : $scope.file.filename,
				documentBase64 : $scope.file.base64
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.message = [];
				$scope.message.push("Document uploaded succesfully");
			} else {
				$scope.message = [];
				$scope.message.push("Failed to upload document, Please try later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});*/
	};



	$scope.isAccordionEnable = function(fisrtForm,secondForm,thirdForm){
		if(fisrtForm==false && secondForm==false && thirdForm==false) {
			return true;
		}else{
			return false;
		}
	};




});


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
		//$scope.editProfile.photo = head + $scope.file.base64;
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



techpedia.controller('EditProfileController', function($scope, $http) {

	$scope.initialEditProfileData = function() {
		$scope.message = [];
		$scope.edit=null;
		$http({
			method : 'POST',
			url : 'ajax/editProfileLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			$scope.edit = data;
			
			var collegeNameArray = [];
				var collegeNameJson = {};
				collegeNameJson.id = $scope.edit.collge;
				collegeNameJson.text = $scope.edit.collge;
				collegeNameArray.push(collegeNameJson);
			$("#CollegeNames").select2("data",collegeNameArray );
			
			var universityArray = [];
			var universityJson = {};
			universityJson.id = $scope.edit.university;
			universityJson.text = $scope.edit.university;
			universityArray.push(universityJson);
			$("#university").select2("data",universityJson);
			
			var branchArray = [];
			var branchJson = {};
			branchJson.id = $scope.edit.branchIdOfStudent;
			branchJson.text = $scope.edit.projectBranchDescOfStudent;
			branchArray.push(branchJson);
			$("#branchIdOfStudent2").select2("data",branchArray);
			
			var collegeStateArray = [];
			var collegeStateArrayJson = {};
			collegeStateArrayJson.id = $scope.edit.collegeState;
			collegeStateArrayJson.text = $scope.edit.collegeState;
			collegeStateArray.push(collegeStateArrayJson);
			$("#collegeState").select2("data",collegeStateArray);
			
			var UserStateArray = [];
			var UserStateArrayJson = {};
			UserStateArrayJson.id = $scope.edit.state;
			UserStateArrayJson.text = $scope.edit.state;
			UserStateArray.push(UserStateArrayJson);
			$("#state").select2("data",UserStateArray);
			
			var UserCityArray = [];
			var UserCityArrayJson = {};
			UserCityArrayJson.id = $scope.edit.city;
			UserCityArrayJson.text = $scope.edit.city;
			UserCityArray.push(UserCityArrayJson);
			$("#city").select2("data",UserCityArray);
			
			var studentDegreeArray = [];
			var studentDegreeJson = {};
			studentDegreeJson.id = $scope.edit.degreeOfStudent;
			studentDegreeJson.text = $scope.edit.degreeOfStudent;
			studentDegreeArray.push(studentDegreeJson);
			$("#studentdegree").select2("data",studentDegreeArray);
			
			var mentortDegreeArray = [];
			var mentortDegreeJson = {};
			mentortDegreeJson.id = $scope.edit.degreeOfStudent;
			mentortDegreeJson.text = $scope.edit.degreeOfStudent;
			mentortDegreeArray.push(mentortDegreeJson);
			$("#degreeOfMentor").select2("data",mentortDegreeArray);
			
			var facultyDegreeArray = [];
			var facultyDegreeJson = {};
			facultyDegreeJson.id = $scope.edit.degreeOfStudent;
			facultyDegreeJson.text = $scope.edit.degreeOfStudent;
			facultyDegreeArray.push(facultyDegreeJson);
			$("#facultydegree").select2("data",facultyDegreeArray);
			
			

			$scope.edit.photo = '';
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		$scope.$watch('file1', function() {
			$scope.edit.logo = "data:" + $scope.file1.filetype + ";base64," + $scope.file1.base64;
		}, true);
	};

	$scope.enterDegree = function(){
		$('#studentdegree1').show();
		$('#studentdegree1').val('');
		$('#s2id_studentdegree').hide();
	};
	$scope.enterMentorDegree = function(){
		$('#degreeOfMentor1').show();
		$('#degreeOfMentor1').val('');
		$('#s2id_degreeOfMentor').hide();
	};
	$scope.enterFacultyDegree = function(){
		$('#degreeOfFaculty1').show();
		$('#degreeOfFaculty1').val('');
		$('#s2id_degreeOfFaculty').hide();
	};
	
	$scope.search = function() {
		// alert($scope.form.searchTerm);
		$http({
			method : 'GET',
			data : $.param({}),
			url : 'getSuggestedBranches?q=' + $scope.searchTerm
		}).success(function(data, status, headers, config) {
			$scope.data = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};

	$scope.deleteState = function(){
		$scope.edit.state = "";
		$('#state').select2('data',null);
		$('#s2id_state').show();
	};
	$scope.showState = function(){
		try{
			if($scope.edit.state === ''){
				$('#s2id_state').show();
			}else{
				$('#s2id_state').hide();
			}
			return $scope.edit.state === '';
		}catch(e){}
	};

	$scope.deleteCity = function(){
		$scope.edit.city = "";
		$('#city').select2('data',null);
		$('#s2id_city').show();
	};
	$scope.showCity = function(){
		try{
			if($scope.edit.city === ''){
				$('#s2id_city').show();
			}else{
				$('#s2id_city').hide();
			}
			return $scope.edit.city === '';
		}catch(e){}
	};



	$scope.deleteCollege = function(){
		$scope.edit.collge = "";
		$('#CollegeNames').select2('data',null);
		$('#s2id_CollegeNames').show();
		$('#clgState').show();
	};
	$scope.showCollege = function(){
		try{
			if($scope.edit.collge === ''){
				$('#s2id_CollegeNames').show();
			}else{
				$('#s2id_CollegeNames').hide();
			}
			return $scope.edit.collge === '';
		}catch(e){}
	};



	$scope.deleteUniversity = function(){
		$scope.edit.university = "";
		$('#university').select2('data',null);
		$('#s2id_University').show();
	};
	$scope.showUniversity = function(){
		try{
			if($scope.edit.university === ''){
				$('#s2id_university').show();
			}else{
				$('#s2id_university').hide();
			}
			return $scope.edit.university === '';
		}catch(e){}
	};





	$scope.deleteBranches = function(){
		$scope.edit.branchIdOfStudent2 = "";
		$('#branchIdOfStudent2').select2('data',null);
		$('#s2id_branchIdOfStudent2').show();
	};
	$scope.showBranches = function(){
		try{
			if($scope.edit.branchIdOfStudent2 === ''){
				$('#s2id_branchIdOfStudent2').show();
			}else{
				$('#s2id_branchIdOfStudent2').hide();
			}
			return $scope.edit.branchIdOfStudent2 === '';
		}catch(e){}
	};





	$scope.deleteCollgeOfFaculty = function(){
		$scope.edit.collgeOfFaculty = "";
		$('#collgeOfFaculty').select2('data',null);
		$('#s2id_collgeOfFaculty').show();
		$('#facultyClgState').show();
	};
	$scope.showCollgeOfFaculty = function(){
		try{
			if($scope.edit.collgeOfFaculty === ''){
				$('#s2id_collgeOfFaculty').show();
			}else{
				$('#s2id_collgeOfFaculty').hide();
			}
			return $scope.edit.collgeOfFaculty === '';
		}catch(e){}
	};



	$scope.deleteSpecializationOfFaculty = function(){
		$scope.edit.specializationOfFaculty2 = "";
		$('#specializationOfFaculty2').select2('data',null);
		$('#s2id_specializationOfFaculty2').show();
	};
	$scope.showSpecializationOfFaculty = function(){
		try{
			if($scope.edit.specializationOfFaculty2 === ''){
				$('#s2id_specializationOfFaculty2').show();
			}else{
				$('#s2id_specializationOfFaculty2').hide();
			}
			return $scope.edit.specializationOfFaculty2 === '';
		}catch(e){}
	};




	$scope.deleteUniversityOfFaculty = function(){
		$scope.edit.universityOfFaculty = "";
		$('#universityOfFaculty').select2('data',null);
		$('#s2id_universityOfFaculty').show();
	};
	$scope.showUniversityOfFaculty = function(){
		try{
			if($scope.edit.universityOfFaculty === ''){
				$('#s2id_universityOfFaculty').show();
			}else{
				$('#s2id_universityOfFaculty').hide();
			}
			return $scope.edit.universityOfFaculty === '';
		}catch(e){}
	};



	$scope.deleteBranchIdOfMentor2 = function(){
		$scope.edit.branchIdOfMentor2 = "";
		$('#branchIdOfMentor2').select2('data',null);
		$('#s2id_branchIdOfMentor2').show();
	};
	$scope.showBranchIdOfMentor2 = function(){
		try{
			if($scope.edit.branchIdOfMentor2 === ''){
				$('#s2id_branchIdOfMentor2').show();
			}else{
				$('#s2id_branchIdOfMentor2').hide();
			}
			return $scope.edit.branchIdOfMentor2 === '';
		}catch(e){}
	};



	//for university 	 	
	$scope.search1 = function() { 	 	
		alert($scope.form.searchUName); 	 	
		$http({ 	 	
			method : 'GET', 	 	
			data : $.param({}), 	 	
			url : 'getUniversityList?uName=' + $scope.searchUName 	 	
		}).success(function(data, status, headers, config) { 	 	
			$scope.data = data; 	 	
		}).error(function(data, status, headers, config) { 	 	
			// called asynchronously if an error occurs 	 	
			// or server returns response with an error status. 	 	
		}); 	 	
	};
	//--------------------------------------------------------------------------------


	$scope.Exitfunction=function(){
		$scope.messageerrorCaptcha=[];
		$scope.messageSuccess = [];
		$scope.messageWarning = [];
		$scope.messageWarningEmail = [];
	};
	$scope.editProfile = function(jCaptcha) {
		
		if ($scope.edit.isMobile==undefined) {
			$scope.edit.isMobile = "N"
		}
		$http({
			method : 'POST',
			url : 'editProfileRequest?res='+jCaptcha,
			data : $.param($scope.edit),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {	
			if (data === 'Invalid Captcha'){
				$scope.messageerrorCaptcha=[];
				$scope.messageerrorCaptcha.push("Invalid Captcha");
				reloadCaptcha();
			}
			else if (data.status=="success") {
				$scope.messageSuccess = [];
				$scope.messageSuccess.push("Your profile has been saved successfully.");
			}
			else if(data.status=="success with Email error"){
				$scope.messageWarningEmail = [];
				$scope.messageWarningEmail.push(data.description+" to your registered eamil id;");
			}
			else{
				$scope.messageWarning = [];
				$scope.messageWarning.push("Oops! An error has occured. Please contact the administrator.");
			}
		}).error(function(data, status, headers, config) {
			$scope.messageWarning = [];
			$scope.messageWarning.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};
	
	$scope.forward = function() {
		window.location.href="dashboard";
	};
});

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



techpedia.controller('SetPasswordFacultyController', function($scope, $http) {
	$scope.data = {};
	$scope.setPasswordFac = function() {

		$http({
			method : 'POST',
			url : 'setPasswordFac',
			data : $.param($scope.data),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data === 'success') {
				$scope.message = [];
				$scope.message.push("Password Created succesfully");
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


techpedia.controller('SocialRegisterController', function($scope, $http,MyService) {
	$scope.message = [];
	$scope.register = {};
	$scope.facebookdata = {};
	$scope.googledata = {};
	$scope.register.isPhoto = "Y";	
	$scope.facebookdata = MyService.retrieve('key');
	$scope.googledata = angular.fromJson(sessionStorage.getItem('googleProfile'));
	$scope.linkedInData =  angular.fromJson(sessionStorage.getItem('linkedInProfile')); 
	if($scope.facebookdata !== null){
		$scope.register.firstName = $scope.facebookdata.firstname;
		$scope.register.lastName = $scope.facebookdata.lastname;
		$scope.register.email = $scope.facebookdata.emailId;
		$scope.register.dob = $scope.facebookdata.birthday;
		$scope.register.faceBookId = $scope.facebookdata.facebookId;
		if($scope.register.faceBookId != null){
			//$scope.register.faceBookId
			$( "#facebookId" ).prop( "disabled", true );
		}
		$scope.register.imgByteArray = $scope.facebookdata.imgurl;
		$scope.register.imgName = $scope.facebookdata.imageName;
		$scope.register.imgByteArray=$scope.register.imgByteArray.substring(22,$scope.register.imgByteArray.length+1);
		//alert("$scope.register.imgName-->"+$scope.register.imgName);
		document.getElementById('profilePic').src =$scope.facebookdata.imgurl;
		MyService.clearAll();
	}
	if($scope.googledata !==null){
		$scope.register.email = $scope.googledata.emailId;
		$scope.register.imgName = $scope.googledata.imageName;
		$scope.register.imgByteArray = $scope.googledata.imgurl;
		$scope.register.imgByteArray = $scope.register.imgByteArray.substring(22,$scope.register.imgByteArray.length+1);
		console.log("google $scope.register.imgByteArray==="+$scope.register.imgByteArray)
		//alert("social registration=="+$scope.register.imgByteArray);
		document.getElementById('profilePic').src =$scope.googledata.imgurl;
		MyService.clearAll();
	}

	if($scope.linkedInData !== null){
		//alert("linkedIn Data......");
		$scope.register.firstName = $scope.linkedInData.firstName;
		$scope.register.lastName = $scope.linkedInData.lastName;
		$scope.register.email = $scope.linkedInData.emailId;
		$scope.register.linkedinId = $scope.linkedInData.ProfileUrl;
		if($scope.register.linkedinId != null){
			//alert("disable");
			$( "#linkedinId" ).prop( "disabled", true );
		}
		$scope.register.imgByteArray = null;
		$scope.register.imgName = null;
		$scope.register.imgByteArray=null;
		//document.getElementById('profilePic').src =$scope.linkedInData.imgurl;
		MyService.clearAll();
	}


	$scope.typeOfUser = function(data) {
		$scope.register.userType = data;
	};

	$scope.$watch('file', function() {
		//$scope.register.photo = "data:" + $scope.file.filetype + ";base64," + $scope.file.base64;
		//alert("google $scope.register.imgName watch=="+$scope.register.imgName);
		if($scope.register.imgName == null){
			$scope.register.imgName = $scope.file.filename;
			$scope.register.imgByteArray = $scope.file.base64;
		}
	}, true);
	$scope.$watch('file1', function() {
		$scope.register.logo = "data:" + $scope.file1.filetype + ";base64," + $scope.file1.base64;
	}, true);
	$scope.InitLoad = function() {


		var url= window.location.href;

		var userTypes = ''
			var type = $('#type').val();	
		if(type === "student")
		{

			userTypes = 'student';
			jQuery('#facultyBtn').removeClass('btn-info');
			jQuery('#collegeBtn').removeClass('btn-info');
			jQuery('#mentorBtn').removeClass('btn-info');
			jQuery('#studentBtn').addClass('btn-info');
		}
		else if(type === "mentor")
		{				
			userTypes = 'mentor';
			jQuery('#studentBtn').removeClass('btn-info');
			jQuery('#collegeBtn').removeClass('btn-info');
			jQuery('#facultyBtn').removeClass('btn-info');
			jQuery('#mentorBtn').addClass('btn-info');
		}
		else if(type === "faculty")
		{
			userTypes = 'college';
			jQuery('#facultyBtn').removeClass('btn-info');
			jQuery('#studentBtn').removeClass('btn-info');
			jQuery('#mentorBtn').removeClass('btn-info');
			jQuery('#collegeBtn').addClass('btn-info');
		}


		$scope.typeOfUser(userTypes);

		$scope.register.userType = userTypes;
		$scope.register.iSactive = "Y";

		/*		$scope.data = [ {
			"branchId" : 1,
			"projBranchDesc" : "Chemical Engineering"
		}, {
			"branchId" : 2,
			"projBranchDesc" : "Electronic and Communiaction"
		}, {
			"branchId" : 3,
			"projBranchDesc" : "Mechanical"
		}, {
			"branchId" : 4,
			"projBranchDesc" : "Electrical Engineering"
		},
		 {
			"branchId" : 5,
			"projBranchDesc" : "Computer Science"
		}];*/
	};
	
	$scope.enterDegree = function(){
		$('#studentdegree1').show();
		$('#studentdegree1').val('');
		$('#s2id_studentdegree').hide();
	};
	$scope.enterMentorDegree = function(){
		$('#degreeOfMentor1').show();
		$('#degreeOfMentor1').val('');
		$('#s2id_degreeOfMentor').hide();
	};
	$scope.enterFacultyDegree = function(){
		$('#degreeOfFaculty1').show();
		$('#degreeOfFaculty1').val('');
		$('#s2id_degreeOfFaculty').hide();
	};

	$scope.search = function() {
		// alert($scope.form.searchTerm);
		$http({
			method : 'GET',
			data : $.param({}),
			url : 'getSuggestedBranches?q=' + $scope.searchTerm
		}).success(function(data, status, headers, config) {
			$scope.data = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};
	$scope.showError = function() {
		$('#pwdError').show();
	};
	$scope.hideError = function() {
		$('#pwdError').hide();
	};
	$scope.registerSubmit = function() {
		$scope.v = grecaptcha.getResponse();

		if($scope.v.length == 0)
		{
			error = true;

			errorString = 'You can not leave Captcha Code empty';
			$('getnewcaptcha').show();
		}


		/*var cval=$('#captchavalue span').text();
		   if (($('#captcha').val()== "") ||($('#captcha').val() != parseInt(cval))){

			  // alert(cval);   

               error = true;

               errorString = 'Captcha failed';
               $('getnewcaptcha').show();


        }*/
		else{
			$scope.message = "";
			if($scope.register.imgName==null){
				$scope.register.isPhoto = "N";
			}
			if($scope.register.imgName==null){
				$scope.register.isPhoto = "N";
			}

			$http({
				method : 'POST',
				url : 'registerRequest?res='+$scope.v,
				data : $.param($scope.register),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.message = [];
				if (data === 'success') {
					$scope.message.push("You profile has been created. Please use your credentials to login");
				}else if (data === 'Captcha Invalid'){
					$scope.message.push("Invalid Captcha");
				}else {
					$scope.message.push("Oops! An error has occured. Please contact the administrator.");
				}

			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};

});


techpedia.controller('RegisterController', function($scope, $http) {
	$scope.messageerrorCaptcha=[];
	$scope.messageSuccess = [];
	$scope.messageWarning = [];
	$scope.register = {};

	$scope.typeOfUser = function(data) {
		$scope.register.userType = data;
	};
	$scope.register.isPhoto = "Y";	
	$scope.$watch('file', function() {
		//$scope.register.photo = "data:" + $scope.file.filetype + ";base64," + $scope.file.base64;
		console.log($scope.file.filename);

		$scope.register.imgName = $scope.file.filename;
		$scope.register.imgByteArray = $scope.file.base64;
	}, true);
	$scope.$watch('file1', function() {
		$scope.register.logo = "data:" + $scope.file1.filetype + ";base64," + $scope.file1.base64;
	}, true);


	$scope.Exitfunction=function(){
		$scope.messageerrorCaptcha=[];
		$scope.messageSuccess = [];
		$scope.messageWarning = [];
		$scope.messageWarningEmail = [];
	};

	$scope.InitLoad = function() {
		
		
		 /*if($('#dateOfBirthDatePicker').val()==""){
			 alert("required class added successfully....");
			 $('#age').prop('required',true);
		 }*/

		var url= window.location.href;
		var userTypes = ''

			if(url.toLowerCase().indexOf('student') > -1)
			{

				userTypes = 'student';
				jQuery('#facultyBtn').removeClass('btn-info');
				jQuery('#collegeBtn').removeClass('btn-info');
				jQuery('#mentorBtn').removeClass('btn-info');
				jQuery('#industryBtn').removeClass('btn-info');
				jQuery('#studentBtn').addClass('btn-info');
			}
			else if(url.toLowerCase().indexOf('mentor') > -1)
			{				
				userTypes = 'mentor';
				jQuery('#studentBtn').removeClass('btn-info');
				jQuery('#collegeBtn').removeClass('btn-info');
				jQuery('#facultyBtn').removeClass('btn-info');
				jQuery('#industryBtn').removeClass('btn-info');
				jQuery('#mentorBtn').addClass('btn-info');
			}
			else if(url.toLowerCase().indexOf('college') > -1)
			{
				userTypes = 'college';
				jQuery('#facultyBtn').removeClass('btn-info');
				jQuery('#studentBtn').removeClass('btn-info');
				jQuery('#mentorBtn').removeClass('btn-info');
				jQuery('#industryBtn').removeClass('btn-info');
				jQuery('#collegeBtn').addClass('btn-info');
			}
			else if(url.toLowerCase().indexOf('industry') > -1)
			{
				userTypes = 'industry';
				jQuery('#facultyBtn').removeClass('btn-info');
				jQuery('#studentBtn').removeClass('btn-info');
				jQuery('#mentorBtn').removeClass('btn-info');
				jQuery('#collegeBtn').removeClass('btn-info');
				jQuery('#industryBtn').addClass('btn-info');
			}
			else if(url.toLowerCase().indexOf('faculty') > -1)
			{
				userTypes = 'faculty';
				jQuery('#studentBtn').removeClass('btn-info');
				jQuery('#collegeBtn').removeClass('btn-info');
				jQuery('#mentorBtn').removeClass('btn-info');
				jQuery('#industryBtn').removeClass('btn-info');
				jQuery('#facultyBtn').addClass('btn-info');
			}

		$scope.typeOfUser(userTypes);
		$scope.register.iSactive = "N";
		$scope.register.userType = userTypes;
		/*		$scope.data = [ {
			"branchId" : 1,
			"projBranchDesc" : "Chemical Engineering"
		}, {
			"branchId" : 2,
			"projBranchDesc" : "Electronic and Communiaction"
		}, {
			"branchId" : 3,
			"projBranchDesc" : "Mechanical"
		}, {
			"branchId" : 4,
			"projBranchDesc" : "Electrical Engineering"
		},
		 {
			"branchId" : 5,
			"projBranchDesc" : "Computer Science"
		}];*/
	};
	
	
	
	$scope.search = function() {
		// alert($scope.form.searchTerm);
		$http({
			method : 'GET',
			data : $.param({}),
			url : 'getSuggestedBranches?q=' + $scope.searchTerm
		}).success(function(data, status, headers, config) {
			$scope.data = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};
	
	$scope.enterDegree = function(){
		$('#studentdegree1').show();
		$('#studentdegree1').val('');
		$('#s2id_studentdegree').hide();
	};
	$scope.enterMentorDegree = function(){
		$('#degreeOfMentor1').show();
		$('#degreeOfMentor1').val('');
		$('#s2id_degreeOfMentor').hide();
	};
	$scope.enterFacultyDegree = function(){
		$('#degreeOfFaculty1').show();
		$('#degreeOfFaculty1').val('');
		$('#s2id_degreeOfFaculty').hide();
	};
	$scope.showError = function() {
		$('#pwdError').show();
	};
	$scope.hideError = function() {
		$('#pwdError').hide();
	};
	$scope.registerSubmit = function(jCaptcha) {
		$scope.message = "";
		
		if ($scope.register.isMobile==undefined) {
			$scope.register.isMobile = "N"
		}
		if($scope.file.filename==null){
			$scope.register.isPhoto = "N";
		}

		$http({
			method : 'POST',
			url : 'registerRequest?res='+jCaptcha,
			data : $.param($scope.register),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data === 'Invalid Captcha'){
				$scope.messageerrorCaptcha=[];
				$scope.messageerrorCaptcha.push("Invalid Captcha");
				reloadCaptcha();
			}
			else if (data.status=="success") {
				$scope.messageSuccess = [];
				$scope.messageSuccess.push("You profile has been created successfully.");
			}
			else if(data.status=="success with Email error")
			{
				$scope.messageWarningEmail = [];
				$scope.messageWarningEmail.push(data.description+" to your registered eamil id;");
			}

			else{
				$scope.messageWarning = [];
				$scope.messageWarning.push(data);
			}

		}).error(function(data, status, headers, config) {
			$scope.messageWarning = [];
			$scope.messageWarning.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	
	$scope.forward = function() {
		window.location.href="index";
	};
	
	$scope.remove =  function(){
		if($("#mobile").val()==""){
				$('#mobileYesNo').prop('required', false);
		}
	}

});

techpedia.controller('AddChallengeController', function($scope, $http) {
	$scope.data = {};

	/*$scope.InitChallengeLoad = function() {
		$scope.data = [ {
			"challengTypeId" : 10,
			"challengTypeDesc" : "Academic"
		}, {
			"challengTypeId" : 20,
			"challengTypeDesc" : "Industry"
		}, {
			"challengTypeId" : 30,
			"challengTypeDesc" : "Innovation"
		}];
	};*/

	$scope.searchChallengeType = function() {
		//	alert($scope.form.searchTerm);
		$http({
			method : 'GET',
			data : $.param({}),
			url : 'getsuggestedchallenges?q=' + $scope.searchTerm
		}).success(function(data, status, headers, config) {
			$scope.data = data;

		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};
	$scope.addChallenge = function() {
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'addChallengeRequest',
			data : $.param($scope.challenge),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];

			$scope.message.push("Challenge added succesfully");
			$scope.cssClass = "success";


		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.cssClass = "danger";
		});
	};



});



//test


techpedia.controller('ProjectsByBranchesController', function($scope, $http) {

	$scope.initialProjectsData = function() {
		$('#img').hide();
		$scope.isSearchResult = false;
		$scope.count = 1;
		$scope.message = [];
		$scope.projects = {};

		$scope.recentprojects = [ {
			projTitle : 'Loading title',
			projDescription : 'Loading description'
		} ];

		$scope.viewProject = function(project) {
			window.location = 'projectDetails' + project.projId;
		};





		// project macro branches		
		$http({
			method : 'POST',
			url : 'projectsMacroBranchesLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projectsMacroBranches = data;

		}).error(function(data, status, headers, config) {
			$scope.projectsMacroBranches = [ {
				projTitle : 'Failed to load data',
				projDescription : 'Please try again later'
			} ];
		});	


		$scope.makeActive = function() {
			document.getElementById("sidebarmenu").style.background = "#555";
		}


		/*$("#sidebarmenu").on('click', 'li a', function () {
		   // $("#sidebarli li.active").removeClass("active");
		    alert("li clicked....");
		    // adding classname 'active' to current click li 
		   // $(this).addClass("active");
		});
		 */
		/* $(".sidebarli li a").on("click", function() {
		    	alert("li clicked....");
		      $(this).addClass("active");
		    });*/


		$http({
			method : 'POST',
			url : 'ajax/macroBranchProjectsLoad',
			data : $.param({
				set : 1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projects = data;
			
			if(data.length>0){
			for(var i=0;i<$scope.projects.length;i++){
				$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc;
			}
			for(var i=0;i<$scope.projects.length;i++){

				if($scope.projects[i].projTitle.length>30){
					$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
				}
				/*if($scope.projects[i].projFacultyName.length>13){
					$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
				}
				if($scope.projects[i].projTeamLeaderName.length>13){
					$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
				}
				if($scope.projects[i].projCollege.length>13 ){
					$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
				}*/

			}
			}else{
				$scope.message.push("No Project is matiching to this Branch");
			}


		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};







	$scope.viewMore = function(setNumber,keyword,branch) {	
		/*alert(setNumber);*/
		$('#showMoreBtn').hide();
		$('#img').show();


		if (keyword) {
			/*alert("in if");*/
			$scope.message = [];
			$http({
				method : 'POST',
				url : 'ajax/searchProjectByKeyword',
				data : $.param({
					term : keyword,
					set : setNumber+1,
					branch : branch
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$('#img').hide();
				$('#showMoreBtn').show();
				if(data.length>0)
				{
					$scope.projects = $scope.projects.concat(data);

					for(var i=0;i<$scope.projects.length;i++){

						$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc;
					}
					for(var i=0;i<$scope.projects.length;i++){
						/*alert($scope.projects[i].projCollege);*/



						if($scope.projects[i].projTitle.length>30){
							$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
						}
						/*if($scope.projects[i].projCollege.length>13){
							$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
						}
						if($scope.projects[i].projFacultyName.length>13){
							$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
						}
						if($scope.projects[i].projTeamLeaderName.length>13){
							$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
						}*/

					}
				}


				else{
					$scope.message.push("No more Project found with this title");	
					$('#showMoreBtn').hide(); 
				}
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			//alert("view more in else=="+setNumber);
			$scope.message = [];
			$http({
				method : 'POST',
				url : 'ajax/macroBranchProjectsLoad',
				data : $.param({
					set : setNumber
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {

				$('#img').hide();
				$('#showMoreBtn').show();
				/*alert(data.length);*/
				if(data.length>0){
					$scope.projects = $scope.projects.concat(data);	
					for(var i=0;i<$scope.projects.length;i++){
						$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc;
					}
					for(var i=0;i<$scope.projects.length;i++){

						if($scope.projects[i].projTitle.length>30){
							$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
						}
						/*if($scope.projects[i].projCollege.length>13){
							$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
						}
						if($scope.projects[i].projFacultyName.length>13){
							$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
						}
						if($scope.projects[i].projTeamLeaderName.length>13){
							$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
						}*/

					}
				}else {
					$scope.message.push("No more Projects found");
					$('#showMoreBtn').hide(); 
				}


			}).error(function(data, status, headers, config) {

				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}

	};

	$scope.clickProject = function(id) {
		window.location = 'projectDetails' + id;
	};




	$scope.searchProjects = function(term, type,branch) {
		$scope.message = "";
		$("#search").click(function() {
			$("#hide").hide();
		});
		if (type == 'keyword') {
			$http({
				method : 'POST',
				url : 'ajax/searchProjectByKeyword',
				data : $.param({
					term : term,
					set : 1,
					branch : branch

				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.projects = data;
				for(var i=0;i<$scope.projects.length;i++){

					$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc;
				}
				for(var i=0;i<$scope.projects.length;i++){
					/*alert($scope.projects[i].projCollege);*/


					if($scope.projects[i].projTitle.length>30){
						$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
					}
					/*if($scope.projects[i].projCollege.length>13){
						$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
					}
					if($scope.projects[i].projFacultyName.length>13){
						$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
					}
					if($scope.projects[i].projTeamLeaderName.length>13){
						$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
					}*/


				}


				$scope.isSearchResult = true;
				$scope.count = 0;
				if(data.length <= 7){
					$("#showMoreBtn").hide();

				}else{
					$("#showMoreBtn").show();
				} 
				
				if($scope.projects.length==0){
					$scope.message.push("No project matching the keyword.");
				}
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			;// SERVICE NOT AVAILABLE
		}
	};

	$scope.clickMacroBranch = function(macroBranch) {
		window.location = 'projectByBranches' + macroBranch.replace(/\s/g, "-");;

	};

//	test
});


techpedia.controller('ProjectsPageController', function($scope, $http) {

	$scope.initialProjectsData = function() {
		$('#img').hide();
		$scope.isSearchResult = false;
		$scope.count = 1;
		$scope.message = [];
		$scope.projects = {};

		$scope.recentprojects = [ {
			projTitle : 'Loading title',
			projDescription : 'Loading description'
		} ];

		$scope.viewProject = function(project) {
			window.location = 'projectDetails' + project.projId;
		};


		//Recent Projects		
		$http({
			method : 'POST',
			url : 'latestProjectSpotlightLoad',
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
		$scope.recentProjectVisibility = function(){
			document.getElementById("recentProjects").style.display = "block";
			$('#popularProjects').hide();
			$('#recentProjects').show();
		}

		$http({
			method : 'POST',
			url : 'projectsFetch',
			data : $.param({
				set : 1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projects = data;
			for(var i=0;i<$scope.projects.length;i++){

				$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc;
			}
			for(var i=0;i<$scope.projects.length;i++){
				//alert($scope.projects[i].projTitle.length);


				if($scope.projects[i].projTitle.length>30){
					$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
				}
				/*if($scope.projects[i].projCollege.length>13){
					$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
				}
				if($scope.projects[i].projFacultyName.length>13){
					$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
				}
				if($scope.projects[i].projTeamLeaderName.length>13){
					$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
				}*/





			}
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};







	$scope.viewMore = function(setNumber,keyword,branch) {	
		/*alert(setNumber);*/
		$('#showMoreBtn').hide();
		$('#img').show();


		if (keyword) {
			/*alert("in if");*/
			$scope.message = [];
			$http({
				method : 'POST',
				url : 'ajax/searchProjectByKeyword',
				data : $.param({
					term : keyword,
					set : setNumber+1,
					branch : branch
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$('#img').hide();
				$('#showMoreBtn').show();
				if(data.length>0)
				{
					$scope.projects = $scope.projects.concat(data);

					for(var i=0;i<$scope.projects.length;i++){

						$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc;
					}
					for(var i=0;i<$scope.projects.length;i++){
						/*alert($scope.projects[i].projCollege);*/



						if($scope.projects[i].projTitle.length>30){
							$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
						}
						/*if($scope.projects[i].projCollege.length>13){
							$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
						}
						if($scope.projects[i].projFacultyName.length>13){
							$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
						}
						if($scope.projects[i].projTeamLeaderName.length>13){
							$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
						}*/

					}
				}


				else{
					$scope.message.push("No more Project found with this title");	
					$('#showMoreBtn').hide(); 
				}
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			/*alert("in else");*/
			$scope.message = [];
			$http({
				method : 'POST',
				url : 'projectsFetch',
				data : $.param({
					set : setNumber
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {

				$('#img').hide();
				$('#showMoreBtn').show();
				/*alert(data.length);*/
				if(data.length>0){
					$scope.projects = $scope.projects.concat(data);	
					for(var i=0;i<$scope.projects.length;i++){
						$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc;
					}
					for(var i=0;i<$scope.projects.length;i++){
						/*alert($scope.projects[i].projCollege);*/

						//alert($scope.projects[i].projTitle.length);
						if($scope.projects[i].projTitle.length>30){
							$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
						}
						/*if($scope.projects[i].projCollege.length>13){
							$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
						}
						if($scope.projects[i].projFacultyName.length>13){
							$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
						}
						if($scope.projects[i].projTeamLeaderName.length>13){
							$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
						}*/

					}
				}else {
					$scope.message.push("No more Projects found");
					$('#showMoreBtn').hide(); 
				}


			}).error(function(data, status, headers, config) {

				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}

	};

	$scope.clickProject = function(id) {
		window.location = 'projectDetails' + id;
	};

	$scope.searchProjects = function(term, type,branch) {
		$scope.message = "";
		$("#search").click(function() {
			$("#hide").hide();
		});
		if (type == 'keyword') {
			$http({
				method : 'POST',
				url : 'ajax/searchProjectByKeyword',
				data : $.param({
					term : term,
					set : 1,
					branch : branch

				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.projects = data;
				for(var i=0;i<$scope.projects.length;i++){

					$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].projBranchDesc;
				}
				for(var i=0;i<$scope.projects.length;i++){
					/*alert($scope.projects[i].projCollege);*/


					if($scope.projects[i].projTitle.length>30){
						$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
					}
					/*if($scope.projects[i].projCollege.length>13){
						$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
					}
					if($scope.projects[i].projFacultyName.length>13){
						$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
					}
					if($scope.projects[i].projTeamLeaderName.length>13){
						$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
					}*/


				}


				$scope.isSearchResult = true;
				$scope.count = 0;
				if(data.length <= 7){
					$("#showMoreBtn").hide();

				}else{
					$("#showMoreBtn").show();
				} 
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			;// SERVICE NOT AVAILABLE
		}
	};
});

/* GYTI Projects Controller Start */

techpedia.controller('GytiProjectsPageController', function($scope, $http) {

	$scope.initialProjectsData = function() {
		$('#img').hide();
		$scope.isSearchResult = false;
		$scope.count = 1;
		$scope.message = [];
		$scope.projects = {};

		$scope.recentprojects = [ {
			projTitle : 'Loading title',
			projDescription : 'Loading description'
		} ];

		$scope.viewProject = function(project) {
			window.location = 'projectDetails' + project.projId;
		};


		//Recent Projects		
		$http({
			method : 'POST',
			url : 'ajax/getLatestGytiProject',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			//alert("getLatestGytiProject.........")
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
		$scope.recentProjectVisibility = function(){
			document.getElementById("recentProjects").style.display = "block";
			$('#popularProjects').hide();
			$('#recentProjects').show();
		}

		$http({
			method : 'POST',
			url : 'ajax/gytiProjectsFetch',
			data : $.param({
				set : 1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projects = data;
			//alert("projects length==="+$scope.projects.length);
			for(var i=0;i<$scope.projects.length;i++){

				$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].branchName;
			}
			for(var i=0;i<$scope.projects.length;i++){

		
				if($scope.projects[i].projTitle.length>30){
					$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
				}
				/*if($scope.projects[i].projCollege.length>13){
					alert($scope.projects[i].projCollege.length);
					$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 14)+"...";
					alert($scope.projects[i].projCollege);
				}
				if($scope.projects[i].projFacultyName.length>13){
					$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 14)+"...";
				}
				if($scope.projects[i].projTeamLeaderName.length>13){
					$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 14)+"...";
				}*/
			}
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});





		$scope.viewMore = function(setNumber,keyword,branch) {	

			$('#showMoreBtn').hide();
			$('#img').show();


			if (keyword) {
				/*alert("in if");*/
				$scope.message = [];
				$http({
					method : 'POST',
					url : 'ajax/searchProjectByKeyword',
					data : $.param({
						term : keyword,
						set : setNumber+1,
						branch : branch
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {
					$('#img').hide();
					$('#showMoreBtn').show();
					if(data.length>0)
					{
						$scope.projects = $scope.projects.concat(data);

						for(var i=0;i<$scope.projects.length;i++){

							$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].branchName;
						}
						for(var i=0;i<$scope.projects.length;i++){
							//alert($scope.projects[i].projCollege);



							if($scope.projects[i].projTitle.length>30){
								$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
							}
							/*if($scope.projects[i].projCollege.length>13){
								$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
							}
							if($scope.projects[i].projFacultyName.length>13){
								$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
							}
							if($scope.projects[i].projTeamLeaderName.length>13){
								$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
							}*/

						}
					}


					else{
						$scope.message.push("No more Project found with this title");	
						$('#showMoreBtn').hide(); 
					}
				}).error(function(data, status, headers, config) {
					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
			} else {
				//alert("view more in else setNumber==="+setNumber);
				$scope.message = [];
				$http({
					method : 'POST',
					url : 'ajax/gytiProjectsFetch',
					data : $.param({
						set : setNumber
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).success(function(data, status, headers, config) {

					$('#img').hide();
					$('#showMoreBtn').show();
					//alert("data length==="+data.length);
					if(data.length>0){
						//alert("inside view more if");
						$scope.projects = $scope.projects.concat(data);	
						for(var i=0;i<$scope.projects.length;i++){
							$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].branchName;
						}
						for(var i=0;i<$scope.projects.length;i++){
						

							if($scope.projects[i].projTitle.length>30){
								$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
							}
							/*if($scope.projects[i].projCollege.length>13){
								$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
							}
							if($scope.projects[i].projFacultyName.length>13){
								$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
							}
							if($scope.projects[i].projTeamLeaderName.length>13){
								$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
							}*/

						}
					}else {
						//alert("inside view more else");
						$scope.message.push("No more Projects found");
						$('#showMoreBtn').hide(); 
					}


				}).error(function(data, status, headers, config) {

					$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
				});
			}

		};

	};


	$scope.clickProject = function(id) {
		window.location = 'projectDetails' + id;
	};

	$scope.searchProjects = function(term, type,branch) {
		$scope.message = "";
		$("#search").click(function() {
			$("#hide").hide();
		});
		if (type == 'keyword') {
			$http({
				method : 'POST',
				url : 'ajax/searchProjectByKeyword',
				data : $.param({
					term : term,
					set : 1,
					branch : branch

				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.projects = data;
				for(var i=0;i<$scope.projects.length;i++){

					$scope.projects[i].projBranchName = $scope.projects[i].projBranchList[0].branchName;
				}
				for(var i=0;i<$scope.projects.length;i++){
					/*alert($scope.projects[i].projCollege);*/


					if($scope.projects[i].projTitle.length>30){
						$scope.projects[i].projTitle=$scope.projects[i].projTitle.substring(0, 30)+"...";
					}
					/*if($scope.projects[i].projCollege.length>13){
						$scope.projects[i].projCollege=$scope.projects[i].projCollege.substring(0, 13)+"...";
					}
					if($scope.projects[i].projFacultyName.length>13){
						$scope.projects[i].projFacultyName=$scope.projects[i].projFacultyName.substring(0, 13)+"...";
					}
					if($scope.projects[i].projTeamLeaderName.length>13){
						$scope.projects[i].projTeamLeaderName=$scope.projects[i].projTeamLeaderName.substring(0, 13)+"...";
					}*/


				}


				$scope.isSearchResult = true;
				$scope.count = 0;
				if(data.length <= 7){
					$("#showMoreBtn").hide();

				}else{
					$("#showMoreBtn").show();
				} 
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			;// SERVICE NOT AVAILABLE
		}
	};
});

/* GYTI Projects Controller End */




techpedia.controller('MentorsPageController', function($scope, $http) {
	$scope.initialMentorsData = function() {
		$('#img').hide();
		$scope.count = 1;
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'mentorsFetch',
			data : $.param({
				set : 1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.mentors = data;
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.viewMore = function(setNumber) {
		$('#showMoreBtn').hide();
		$('#img').show();
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'mentorsFetch',
			data : $.param({
				set : setNumber
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$('#showMoreBtn').show();
			$('#img').hide();

			if(data.length <=8){
				$scope.mentors = $scope.mentors.concat(data);
			}else if(data.length=== 3961 ||data.length >8){
				$scope.message.push("No more mentor records found");
				$('#showMoreBtn').hide();
			}
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.clickMentor = function(id) {
		window.location = 'mentorDetails' + id;
	};
});

techpedia.controller('ChallengesPageController', function($scope, $http) {
	$scope.initialChallengesData = function() {
		$('#img').hide();
		$scope.isSearchResult = false;
		$scope.count = 1;
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'challengesFetch',
			data : $.param({
				set : 1
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			console.log(data);
			$scope.challenges = data;
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};


	/*	techpedia.controller('CollaborationPageController', function($scope, $http) {
		$scope.initialCollaborationData = function() {
			$('#img').hide();
			$scope.isSearchResult = false;
			$scope.count = 1;
			$scope.message = [];
			$http({
				method : 'POST',
				url : 'collaboration',
				data : $.param({
					set : 1
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				console.log(data);
				$scope.collaboration = data;
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		};*/

	$scope.viewMore = function(setNumber,searchTerm) {
		$('#showMoreBtn').hide();
		$('#img').show();
		/*alert(setNumber);*/
		if (searchTerm ) {
			$scope.message = [];
			$http({
				method : 'POST',
				url : 'ajax/searchChallengeByTitle',
				data : $.param({
					term : searchTerm,
					set : setNumber+1
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$('#showMoreBtn').show();
				$('#img').hide();
				if(data.length>0)
				{
					$scope.challenges = $scope.challenges.concat(data);
				}


				else{
					$scope.message.push("No more challenge records found with this title");	
					$('#showMoreBtn').hide();
				}

			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			$scope.message = [];
			$http({
				method : 'POST',
				url : 'challengesFetch',
				data : $.param({
					set : setNumber
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$('#showMoreBtn').show();
				$('#img').hide();

				if(data.length>0){
					$scope.challenges = $scope.challenges.concat(data);
				}else{
					$("#showMoreBtn").hide();
					$scope.message.push("No more challenge records found");	
					$('#showMoreBtn').hide();

				}
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");

			});
		}
	};
	$scope.clickChallenge = function(id) {
		window.location = 'challengeDetails' + id;
	};

	$scope.searchChallenge = function(term, type) {
		$scope.message = ""; 


		if (type == 'title') {

			$http({
				method : 'POST',
				url : 'ajax/searchChallengeByTitle',
				data : $.param({
					term : term,
					set : 1
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.challenges = data;
				$scope.isSearchResult = true;
				$scope.count = 0;
				if(data.length <= 7){
					$("#showMoreBtn").hide();

				}else{
					$("#showMoreBtn").show();
				}

			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			;// SERVICE NOT AVAILABLE
		}
	};
});

techpedia.controller('NewMemberController', function($scope, $http) {
	;
});

techpedia.controller("TestController", function($scope) {
	$scope.InitLoad = function() {
		;
	};
});
techpedia.directive('passwordMatch', [function () {
	return {
		restrict: 'A',
		scope:true,
		require: 'ngModel',
		link: function (scope, elem , attrs,control) {
			var checker = function () {

				//get the value of the first password
				var e1 = scope.$eval(attrs.ngModel); 

				//get the value of the other password  
				var e2 = scope.$eval(attrs.passwordMatch);
				return e1 == e2;
			};
			scope.$watch(checker, function (n) {

				//set the form control to valid if both 
				//passwords are the same, else invalid
				control.$setValidity("pwmatch", n);
			});
		}
	};
}]);




techpedia.controller('NewFacultyController', function($scope, $http) {

	$scope.initialEditProfileData = function() {
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'newFacultyLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			$scope.edit = data;
			alert("edit fname=="+scope.edit.firstName);
			$scope.edit.photo = '';
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		$scope.$watch('file1', function() {
			$scope.edit.logo = "data:" + $scope.file1.filetype + ";base64," + $scope.file1.base64;
		}, true);


		var dataArray = [];
		for (var i = 0; i < data.collge.length; i++) {
			//var id = data.projBranchList[i].branchId;
			var text = data.projBranchList[0];
			alert( "hai " + text);
			var json = {};
			//json.id = id;
			json.text = text;
			dataArray.push(json);

		}


		console.log(JSON.stringify(dataArray));
		$("#CollegeNames").select2("data", dataArray);
		/*$scope.data = [ {
			"branchId" : 1,
			"projBranchDesc" : "Chemical Engineering"
		}, {
			"branchId" : 2,
			"projBranchDesc" : "Electronic and Communiaction"
		}, {
			"branchId" : 3,
			"projBranchDesc" : "Mechanical"
		}, {
			"branchId" : 4,
			"projBranchDesc" : "Electrical Engineering"
		},{
			"branchId" : 5,
			"projBranchDesc" : "Computer Science"
		} ];*/
	};
	
	$scope.showError = function() {
		$('#pwdError').show();
	};
	$scope.hideError = function() {
		$('#pwdError').hide();
	};
	$scope.enterDegree = function(){
		$('#studentdegree1').show();
		$('#studentdegree1').val('');
		$('#s2id_studentdegree').hide();
	};
	$scope.enterMentorDegree = function(){
		$('#degreeOfMentor1').show();
		$('#degreeOfMentor1').val('');
		$('#s2id_degreeOfMentor').hide();
	};
	$scope.enterFacultyDegree = function(){
		$('#degreeOfFaculty1').show();
		$('#degreeOfFaculty1').val('');
		$('#s2id_degreeOfFaculty').hide();
	};

	$scope.search = function() {
		// alert($scope.form.searchTerm);
		$http({
			method : 'GET',
			data : $.param({}),
			url : 'getSuggestedBranches?q=' + $scope.searchTerm
		}).success(function(data, status, headers, config) {
			$scope.data = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};

	$scope.deleteCollege = function(){
		$scope.edit.collge = "";
		$('#CollegeNames').select2('data',null);
		$('#s2id_CollegeNames').show();
	};
	$scope.showCollege = function(){
		try{
			if($scope.edit.collge === ''){
				$('#s2id_CollegeNames').show();
			}else{
				$('#s2id_CollegeNames').hide();
			}
			return $scope.edit.collge === '';
		}catch(e){}
	};



	$scope.deleteUniversity = function(){
		$scope.edit.university = "";
		$('#university').select2('data',null);
		$('#s2id_University').show();
	};
	$scope.showUniversity = function(){
		try{
			if($scope.edit.university === ''){
				$('#s2id_university').show();
			}else{
				$('#s2id_university').hide();
			}
			return $scope.edit.university === '';
		}catch(e){}
	};





	$scope.deleteBranches = function(){
		$scope.edit.branchIdOfStudent2 = "";
		$('#branchIdOfStudent2').select2('data',null);
		$('#s2id_branchIdOfStudent2').show();
	};
	$scope.showBranches = function(){
		try{
			if($scope.edit.branchIdOfStudent2 === ''){
				$('#s2id_branchIdOfStudent2').show();
			}else{
				$('#s2id_branchIdOfStudent2').hide();
			}
			return $scope.edit.branchIdOfStudent2 === '';
		}catch(e){}
	};





	$scope.deleteCollgeOfFaculty = function(){
		$scope.edit.collgeOfFaculty = "";
		$('#collgeOfFaculty').select2('data',null);
		$('#s2id_collgeOfFaculty').show();
	};
	$scope.showCollgeOfFaculty = function(){
		try{
			if($scope.edit.collgeOfFaculty === ''){
				$('#s2id_collgeOfFaculty').show();
			}else{
				$('#s2id_collgeOfFaculty').hide();
			}
			return $scope.edit.collgeOfFaculty === '';
		}catch(e){}
	};



	$scope.deleteSpecializationOfFaculty = function(){
		$scope.edit.specializationOfFaculty2 = "";
		$('#specializationOfFaculty2').select2('data',null);
		$('#s2id_specializationOfFaculty2').show();
	};
	$scope.showSpecializationOfFaculty = function(){
		try{
			if($scope.edit.specializationOfFaculty2 === ''){
				$('#s2id_specializationOfFaculty2').show();
			}else{
				$('#s2id_specializationOfFaculty2').hide();
			}
			return $scope.edit.specializationOfFaculty2 === '';
		}catch(e){}
	};




	$scope.deleteUniversityOfFaculty = function(){
		$scope.edit.universityOfFaculty = "";
		$('#universityOfFaculty').select2('data',null);
		$('#s2id_universityOfFaculty').show();
	};
	$scope.showUniversityOfFaculty = function(){
		try{
			if($scope.edit.universityOfFaculty === ''){
				$('#s2id_universityOfFaculty').show();
			}else{
				$('#s2id_universityOfFaculty').hide();
			}
			return $scope.edit.universityOfFaculty === '';
		}catch(e){}
	};



	$scope.deleteBranchIdOfMentor2 = function(){
		$scope.edit.branchIdOfMentor2 = "";
		$('#branchIdOfMentor2').select2('data',null);
		$('#s2id_branchIdOfMentor2').show();
	};
	$scope.showBranchIdOfMentor2 = function(){
		try{
			if($scope.edit.branchIdOfMentor2 === ''){
				$('#s2id_branchIdOfMentor2').show();
			}else{
				$('#s2id_branchIdOfMentor2').hide();
			}
			return $scope.edit.branchIdOfMentor2 === '';
		}catch(e){}
	};



	//for university 	 	
	$scope.search1 = function() { 	 	
		alert($scope.form.searchUName); 	 	
		$http({ 	 	
			method : 'GET', 	 	
			data : $.param({}), 	 	
			url : 'getUniversityList?uName=' + $scope.searchUName 	 	
		}).success(function(data, status, headers, config) { 	 	
			$scope.data = data; 	 	
		}).error(function(data, status, headers, config) { 	 	
			// called asynchronously if an error occurs 	 	
			// or server returns response with an error status. 	 	
		}); 	 	
	};
	//--------------------------------------------------------------------------------

	
	$scope.Exitfunction=function(){
		$scope.messageerrorCaptcha=[];
		$scope.messageSuccess = [];
		$scope.messageWarning = [];
		$scope.messageWarningEmail = [];
	};
	$scope.newFaculty = function(jCaptcha) {
		//alert("first name==="+$scope.edit.firstName);
		if ($scope.edit.isMobile==undefined) {
			$scope.edit.isMobile = "N"
		}
		$http({
			method : 'POST',
			url : 'editTeamMemberProfileRequest?res='+jCaptcha,
			data : $.param($scope.edit),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {	
			//alert("data==="+data);
			if (data === 'Invalid Captcha'){
				$scope.messageerrorCaptcha=[];
				$scope.messageerrorCaptcha.push("Invalid Captcha");
				reloadCaptcha();
			}
			else if (data.status=="success") {
				$scope.messageSuccess = [];
				$scope.messageSuccess.push("You profile has been created. Please use your credentials to login");
			}
			else if(data.status=="success with Email error"){
				$scope.messageWarningEmail = [];
				$scope.messageWarningEmail.push(data.description);
			}
			else{
				$scope.messageWarning = [];
				$scope.messageWarning.push("Oops! An error has occured. Please contact the administrator.");
			}
		}).error(function(data, status, headers, config) {
			$scope.messageWarning = [];
			$scope.messageWarning.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	
	$scope.forward = function() {
		window.location.href="dashboard";
	};
});








/*techpedia.controller('NewFacultyController', function($scope, $http) {

	$scope.initialEditProfileData = function() {
		$scope.message = [];

		$http({
			method : 'POST',
			url : 'newFacultyLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			$scope.edit = data;
			$scope.edit.photo = '';
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		$scope.$watch('file1', function() {
			$scope.edit.logo = "data:" + $scope.file1.filetype + ";base64," + $scope.file1.base64;
		}, true);


		var dataArray = [];
		for (var i = 0; i < data.collge.length; i++) {
			//var id = data.projBranchList[i].branchId;
			var text = data.projBranchList[0];
			alert( "hai " + text);
			var json = {};
			//json.id = id;
			json.text = text;
			dataArray.push(json);

		}


		console.log(JSON.stringify(dataArray));
		$("#CollegeNames").select2("data", dataArray);
		$scope.data = [ {
			"branchId" : 1,
			"projBranchDesc" : "Chemical Engineering"
		}, {
			"branchId" : 2,
			"projBranchDesc" : "Electronic and Communiaction"
		}, {
			"branchId" : 3,
			"projBranchDesc" : "Mechanical"
		}, {
			"branchId" : 4,
			"projBranchDesc" : "Electrical Engineering"
		},{
			"branchId" : 5,
			"projBranchDesc" : "Computer Science"
		} ];
	};

	$scope.search = function() {
		// alert($scope.form.searchTerm);
		$http({
			method : 'GET',
			data : $.param({}),
			url : 'getSuggestedBranches?q=' + $scope.searchTerm
		}).success(function(data, status, headers, config) {
			$scope.data = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};

	$scope.deleteCollege = function(){
		$scope.edit.collge = "";
		$('#CollegeNames').select2('data',null);
		$('#s2id_CollegeNames').show();
	};
	$scope.showCollege = function(){
		try{
			if($scope.edit.collge === ''){
				$('#s2id_CollegeNames').show();
			}else{
				$('#s2id_CollegeNames').hide();
			}
			return $scope.edit.collge === '';
		}catch(e){}
	};



	$scope.deleteUniversity = function(){
		$scope.edit.university = "";
		$('#university').select2('data',null);
		$('#s2id_University').show();
	};
	$scope.showUniversity = function(){
		try{
			if($scope.edit.university === ''){
				$('#s2id_university').show();
			}else{
				$('#s2id_university').hide();
			}
			return $scope.edit.university === '';
		}catch(e){}
	};





	$scope.deleteBranches = function(){
		$scope.edit.branchIdOfStudent2 = "";
		$('#branchIdOfStudent2').select2('data',null);
		$('#s2id_branchIdOfStudent2').show();
	};
	$scope.showBranches = function(){
		try{
			if($scope.edit.branchIdOfStudent2 === ''){
				$('#s2id_branchIdOfStudent2').show();
			}else{
				$('#s2id_branchIdOfStudent2').hide();
			}
			return $scope.edit.branchIdOfStudent2 === '';
		}catch(e){}
	};





	$scope.deleteCollgeOfFaculty = function(){
		$scope.edit.collgeOfFaculty = "";
		$('#collgeOfFaculty').select2('data',null);
		$('#s2id_collgeOfFaculty').show();
	};
	$scope.showCollgeOfFaculty = function(){
		try{
			if($scope.edit.collgeOfFaculty === ''){
				$('#s2id_collgeOfFaculty').show();
			}else{
				$('#s2id_collgeOfFaculty').hide();
			}
			return $scope.edit.collgeOfFaculty === '';
		}catch(e){}
	};



	$scope.deleteSpecializationOfFaculty = function(){
		$scope.edit.specializationOfFaculty2 = "";
		$('#specializationOfFaculty2').select2('data',null);
		$('#s2id_specializationOfFaculty2').show();
	};
	$scope.showSpecializationOfFaculty = function(){
		try{
			if($scope.edit.specializationOfFaculty2 === ''){
				$('#s2id_specializationOfFaculty2').show();
			}else{
				$('#s2id_specializationOfFaculty2').hide();
			}
			return $scope.edit.specializationOfFaculty2 === '';
		}catch(e){}
	};




	$scope.deleteUniversityOfFaculty = function(){
		$scope.edit.universityOfFaculty = "";
		$('#universityOfFaculty').select2('data',null);
		$('#s2id_universityOfFaculty').show();
	};
	$scope.showUniversityOfFaculty = function(){
		try{
			if($scope.edit.universityOfFaculty === ''){
				$('#s2id_universityOfFaculty').show();
			}else{
				$('#s2id_universityOfFaculty').hide();
			}
			return $scope.edit.universityOfFaculty === '';
		}catch(e){}
	};



	$scope.deleteBranchIdOfMentor2 = function(){
		$scope.edit.branchIdOfMentor2 = "";
		$('#branchIdOfMentor2').select2('data',null);
		$('#s2id_branchIdOfMentor2').show();
	};
	$scope.showBranchIdOfMentor2 = function(){
		try{
			if($scope.edit.branchIdOfMentor2 === ''){
				$('#s2id_branchIdOfMentor2').show();
			}else{
				$('#s2id_branchIdOfMentor2').hide();
			}
			return $scope.edit.branchIdOfMentor2 === '';
		}catch(e){}
	};



	//for university 	 	
	$scope.search1 = function() { 	 	
		alert($scope.form.searchUName); 	 	
		$http({ 	 	
			method : 'GET', 	 	
			data : $.param({}), 	 	
			url : 'getUniversityList?uName=' + $scope.searchUName 	 	
		}).success(function(data, status, headers, config) { 	 	
			$scope.data = data; 	 	
		}).error(function(data, status, headers, config) { 	 	
			// called asynchronously if an error occurs 	 	
			// or server returns response with an error status. 	 	
		}); 	 	
	};
	//--------------------------------------------------------------------------------

	$scope.newFaculty = function() {
//		$scope.message = "";
		var cval=$('#captchavalue span').text();
		if (($('#captcha').val()== "") ||($('#captcha').val() != parseInt(cval))){

			// alert(cval);   

			error = true;

			errorString = 'Captcha failed';
			$('getnewcaptcha').show();


		}
		else{

			$http({
				method : 'POST',
				url : 'newFacultyRequest',
				data : $.param($scope.edit),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				if (data === 'success') {
					$scope.message = [];
					$scope.message.push("You Profile has been created Successfully");

				} else {
					$scope.message.push(data);
				}
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};
});*/

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

techpedia.directive('tooltip', function ($document, $compile) {
	return {
		restrict: 'A',
		scope: true,
		link: function (scope, element, attrs) {

			var tip = $compile('<div ng-class="tipClass">{{ text }}<div class="tooltip-arrow"></div></div>')(scope),
			tipClassName = 'tooltip',
			tipActiveClassName = 'tooltip-show';

			scope.tipClass = [tipClassName];
			scope.text = attrs.tooltip;

			if(attrs.tooltipPosition) {
				scope.tipClass.push('tooltip-' + attrs.tooltipPosition);
			}
			else {
				scope.tipClass.push('tooltip-down'); 
			}
			$document.find('body').append(tip);

			element.bind('mouseover', function (e) {
				tip.addClass(tipActiveClassName);

				var pos = e.target.getBoundingClientRect(),
				offset = tip.offset(),
				tipHeight = tip.outerHeight(),
				tipWidth = tip.outerWidth(),
				elWidth = pos.width || pos.right - pos.left,
				elHeight = pos.height || pos.bottom - pos.top,
				tipOffset = 10;

				if(tip.hasClass('tooltip-right')) {
					offset.top = pos.top - (tipHeight / 2) + (elHeight / 2);
					offset.left = pos.right + tipOffset;
				}
				else if(tip.hasClass('tooltip-left')) {
					offset.top = pos.top - (tipHeight / 2) + (elHeight / 2);
					offset.left = pos.left - tipWidth - tipOffset;
				}
				else if(tip.hasClass('tooltip-down')) {
					offset.top = pos.top + elHeight + tipOffset;
					offset.left = pos.left - (tipWidth / 2) + (elWidth / 2);
				}
				else {
					offset.top = pos.top - tipHeight - tipOffset;
					offset.left = pos.left - (tipWidth / 2) + (elWidth / 2);
				}

				tip.offset(offset);
			});

			element.bind('mouseout', function () {
				tip.removeClass(tipActiveClassName);
			});

			tip.bind('mouseover', function () {
				tip.addClass(tipActiveClassName);
			});

			tip.bind('mouseout', function () {
				tip.removeClass(tipActiveClassName);
			});


		}
	}
});

techpedia.directive('repeatDone', function() {
	return function(scope, element, attrs) {
		if (scope.$last) { // all are rendered
			scope.$eval(attrs.repeatDone);
		}
	}
})


techpedia.controller('CollegeAdminPageController', function($scope, $http,$filter,$timeout) {


	$scope.layoutDone = function() {
		//$('a[data-toggle="tooltip"]').tooltip(); // NOT CORRECT!
		$timeout(function() { $('.ActivateNews').tooltip();
		$('.deactivateNews').tooltip();
		$('.newsInDetail').tooltip();

		}, 0); // wait...
	}

	$scope.addNews={};
	$scope.addNews.newsId=0;
	$scope.InitLoad = function() {
		$scope.SelectedType="All News";
		$scope.bulkfileData=null;
		$scope.hideFlag=true;
		$http({
			method : 'POST',
			url : 'ajax/getCollegeRecentNewsAdmin',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.CollegeNewsAdmin=data;
			$scope.totalData=$scope.CollegeNewsAdmin.length;
			for(var i=0;i<$scope.CollegeNewsAdmin.length;i++){
				if($scope.CollegeNewsAdmin[i].isActive=="Y"){
					$scope.CollegeNewsAdmin[i].isActive=true;
				}
				if($scope.CollegeNewsAdmin[i].isActive=="N"){
					$scope.CollegeNewsAdmin[i].isActive=false;
				}

				$scope.CollegeNewsAdmin[i].selectedNewsDescription=$scope.CollegeNewsAdmin[i].newsDescription;
				if($scope.CollegeNewsAdmin[i].newsDescription.length>65){

					$scope.CollegeNewsAdmin[i].newsDescription=$scope.CollegeNewsAdmin[i].newsDescription.substring(0, 70)+"...";
				}
				$scope.CollegeNewsAdmin[i].selectedNewsHeadLine=$scope.CollegeNewsAdmin[i].newsHeadline;
				if($scope.CollegeNewsAdmin[i].newsHeadline.length>30){

					$scope.CollegeNewsAdmin[i].newsHeadline=$scope.CollegeNewsAdmin[i].newsHeadline.substring(0, 30)+"...";
				}
			}



			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};

			//$scope.gap =$scope.pagedItems.length;

			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =10;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.CollegeNewsAdmin ;

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
		$scope.SelectedType="All News";
		$scope.bulkfileData=null;
		$scope.hideFlag=true;
		$http({
			method : 'POST',
			url : 'ajax/getCollegeRecentNewsAdmin',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.CollegeNewsAdmin=data;
			$scope.totalData=$scope.CollegeNewsAdmin.length;
			for(var i=0;i<$scope.CollegeNewsAdmin.length;i++){
				if($scope.CollegeNewsAdmin[i].isActive=="Y"){
					$scope.CollegeNewsAdmin[i].isActive=true;
				}
				if($scope.CollegeNewsAdmin[i].isActive=="N"){
					$scope.CollegeNewsAdmin[i].isActive=false;
				}

				$scope.CollegeNewsAdmin[i].selectedNewsDescription=$scope.CollegeNewsAdmin[i].newsDescription;
				if($scope.CollegeNewsAdmin[i].newsDescription.length>65){

					$scope.CollegeNewsAdmin[i].newsDescription=$scope.CollegeNewsAdmin[i].newsDescription.substring(0, 70)+"...";
				}
				$scope.CollegeNewsAdmin[i].selectedNewsHeadLine=$scope.CollegeNewsAdmin[i].newsHeadline;
				if($scope.CollegeNewsAdmin[i].newsHeadline.length>30){

					$scope.CollegeNewsAdmin[i].newsHeadline=$scope.CollegeNewsAdmin[i].newsHeadline.substring(0, 30)+"...";
				}
			}



			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};

			//$scope.gap =$scope.pagedItems.length;

			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =itemsPerPage;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.CollegeNewsAdmin ;

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


	$scope.clickedNewsDetails=function(collegeNews){

		$scope.newsID=collegeNews.newsId;
		$scope.activeNewsHeadline=collegeNews.newsHeadline;

		var monthNames = ["January", "February", "March", "April", "May", "June",
		                  "July", "August", "September", "October", "November", "December"
		                  ];
		var dayNames = ['Sunday','Monday','Tuesday','Wednesday',
		                'Thursday','Friday','Saturday'];
		//$scope.selctedNewsDate=collegeNews.newsDate;
		$scope.newspubDate=collegeNews.newsDate;
		var selctedNewsDate=new Date(collegeNews.newsDate);

		$scope.selctedNewsYear=selctedNewsDate.getFullYear();
		$scope.selctedNewsDay=dayNames[selctedNewsDate.getDay()];
		$scope.selctedNewsMonth=monthNames[(selctedNewsDate.getMonth())];
		$scope.selctedNewsNoDay=selctedNewsDate.getDate();
		$scope.selectedNewsHeadLine=collegeNews.selectedNewsHeadLine;
		$scope.selectedNewsDescription=collegeNews.selectedNewsDescription;	
	};
	$scope.selectedCollegeNews = function(collegeNews) {

		$scope.selectedCollegeNewsID = collegeNews.newsId;
		$scope.selectedCollegeNewsHeadLine=collegeNews.newsHeadline;
		//alert("News ID"+$scope.selectedCollegeNewsID);
		//alert("News header"+$scope.selectedCollegeNewsHeadLine);
	};

	$scope.deleteCollegeNews=function(){
		//alert("deleting news ID"+$scope.selectedCollegeNewsID);
		$http({
			method : 'POST',
			url : 'ajax/deletCollegeRecentNewsAdmin',
			data : $.param({
				newsId:$scope.selectedCollegeNewsID
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.removeMsg=[];
				$scope.removeMsg.push("The news with headline\n"+"'"+$scope.selectedCollegeNewsHeadLine+"'"+"\nhas been deleted successfully.");
				$scope.InitLoad();
			} else {
				$scope.removeMsgerror = [];
				$scope.removeMsgerror.push("Some problem occured while deleting the college news");
			}

		}).error(function(data, status, headers, config) {
			$scope.removeMsgerror = [];
			$scope.removeMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		})
	};
	$scope.addCollegeRecentNews=function(){
		$scope.addNews.newsId=0;
		$http({
			method : 'POST',
			url : 'ajax/addCollegeRecentNewsAdmin',
			data : $.param($scope.addNews),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.addMsg=[];
				$scope.addMsg.push("The news with headline"+"::"+$scope.addNews.newsHeadline+"::"+"\nhas been added successfully.");
				$scope.InitLoad();
			} else {
				$scope.addMsgerror = [];
				$scope.addMsgerror.push("Some problem occured while adding the college news");
			}

		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		})

	};

	$scope.activateCollegeRecentNews=function(){
		console.log("news ID"+$scope.newsID);
		alert("news ID"+$scope.newsID);
		$http({
			method : 'POST',
			url : 'ajax/activateCollegeRecentNewsAdmin',
			data : $.param({
				newsId:$scope.newsID
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.actMsg=[];
				$scope.actMsg.push("The news with headline"+"::"+$scope.activeNewsHeadline+"::"+"\nhas been published successfully.");
				$scope.InitLoad();
			} else {
				$scope.actMsgerror = [];
				$scope.addMsgerror.push("Some problem occured while publishing the college news");
				$scope.InitLoad();

			}

		}).error(function(data, status, headers, config) {
			$scope.actMsgerror = [];
			$scope.actMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.InitLoad();

		})

	};

	$scope.ShowActiveNews=function(){
		$scope.SelectedType="Active News";
		$http({
			method : 'POST',
			url : 'ajax/getActiveCollegeRecentNewsAdmin',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.CollegeNewsAdmin=data;
			$scope.totalData=$scope.CollegeNewsAdmin.length;
			for(var i=0;i<$scope.CollegeNewsAdmin.length;i++){
				if($scope.CollegeNewsAdmin[i].isActive=="Y"){
					$scope.CollegeNewsAdmin[i].isActive=true;
				}
				if($scope.CollegeNewsAdmin[i].isActive=="N"){
					$scope.CollegeNewsAdmin[i].isActive=false;
				}

				$scope.CollegeNewsAdmin[i].selectedNewsDescription=$scope.CollegeNewsAdmin[i].newsDescription;
				if($scope.CollegeNewsAdmin[i].newsDescription.length>65){

					$scope.CollegeNewsAdmin[i].newsDescription=$scope.CollegeNewsAdmin[i].newsDescription.substring(0, 70)+"...";
				}
				$scope.CollegeNewsAdmin[i].selectedNewsHeadLine=$scope.CollegeNewsAdmin[i].newsHeadline;
				if($scope.CollegeNewsAdmin[i].newsHeadline.length>30){

					$scope.CollegeNewsAdmin[i].newsHeadline=$scope.CollegeNewsAdmin[i].newsHeadline.substring(0, 30)+"...";
				}
			}



			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};

			//$scope.gap =$scope.pagedItems.length;

			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =10;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.CollegeNewsAdmin ;

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


	$scope.ShowInActiveNews=function(){
		$scope.SelectedType="Inctive News";
		$http({
			method : 'POST',
			url : 'ajax/getInActiveCollegeRecentNewsAdmin',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.CollegeNewsAdmin=data;
			$scope.totalData=$scope.CollegeNewsAdmin.length;
			for(var i=0;i<$scope.CollegeNewsAdmin.length;i++){
				if($scope.CollegeNewsAdmin[i].isActive=="Y"){
					$scope.CollegeNewsAdmin[i].isActive=true;
				}
				if($scope.CollegeNewsAdmin[i].isActive=="N"){
					$scope.CollegeNewsAdmin[i].isActive=false;
				}

				$scope.CollegeNewsAdmin[i].selectedNewsDescription=$scope.CollegeNewsAdmin[i].newsDescription;
				if($scope.CollegeNewsAdmin[i].newsDescription.length>65){

					$scope.CollegeNewsAdmin[i].newsDescription=$scope.CollegeNewsAdmin[i].newsDescription.substring(0, 70)+"...";
				}
				$scope.CollegeNewsAdmin[i].selectedNewsHeadLine=$scope.CollegeNewsAdmin[i].newsHeadline;
				if($scope.CollegeNewsAdmin[i].newsHeadline.length>30){

					$scope.CollegeNewsAdmin[i].newsHeadline=$scope.CollegeNewsAdmin[i].newsHeadline.substring(0, 30)+"...";
				}
			}



			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};

			//$scope.gap =$scope.pagedItems.length;

			$scope.filteredItems = [];
			$scope.groupedItems = [];
			$scope.itemsPerPage =10;
			$scope.pagedItems = [];
			$scope.currentPage = 0;
			$scope.items = $scope.CollegeNewsAdmin ;

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
	/*$scope.Change=function(){

		alert("bulk upload");

	};*/

	$scope.master = null;
	$scope.reset = function() {
		$scope.bulkFile= angular.copy($scope.master);
	};
	$scope.UploadBulkXlsFile=function(){
		$scope.hideFlag=false;
		$scope.message = "";
		$http({
			method : 'POST',
			url : 'bulkUploadProjectDocumentByColgAdmn',
			data : $.param({
				documentName : $scope.file.filename,
				bulkDocumentBase64 : $scope.file.base64
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			if(data.status==="failure"){
				$("#successMsg").hide();
				$("#warningMsg").show();
				$scope.messageWarning = [];
				$scope.messageWarning.push(data.exceptionMessage);	
				$scope.hideFlag=true;
				//$scope.bulkfileData=null;
				//alert("Form"+document.getElementById("bulkUploadForm").name);
				document.getElementById("bulkUploadForm").reset();
				$scope.reset();
				$scope.InitLoad();
			}
			else if (data.status === "success") {
				$("#warningMsg").hide();
				$("#successMsg").show();
				document.getElementById("bulkUploadForm").reset();
				$scope.reset();
				$scope.messageSuccess = [];
				$scope.messageSuccess.push("Document uploaded succesfully");
				$scope.hideFlag=true;
				$scope.InitLoad();
			} else {
				$scope.messageWarning = [];
				$scope.messageWarning.push("Failed to upload document, Please try later");
				$scope.hideFlag=true;
			}
		}).error(function(data, status, headers, config) {

			$scope.messageWarning = [];
			$scope.messageWarning.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.hideFlag=true;
		});

	};





	$(document)
	.ready(
			function() {
				/*var validFilesTypes = [ "bmp", "gif", "png", "jpg",
				                        "jpeg", "doc", "docx", "xls", "xlsx", "htm",
				                        "html", "rar", "zip", "txt", "pdf" ];*/
				//	$scope.bulkfileData=$scope.file.filename;
				var validFilesTypes=["xls","xlsx"];
				$('.fileCheck').change(function() {
					var fileCheck=this;
					var filename=CheckExtension(fileCheck);

					if(filename)
						validateFileSize(fileCheck);

				});
				function CheckExtension(e) {
					/*global document: false */
					var file = e;
					//alert("E" + e);
					var path = file.value;
					//alert("PAth" + path);
					var ext = path.substring(path.lastIndexOf(".") + 1,
							path.length).toLowerCase();
					var isValidFile = false;
					for (var i = 0; i < validFilesTypes.length; i++) {
						if (ext == validFilesTypes[i]) {
							isValidFile = true;
							$scope.bulkfileData=$scope.file.filename;
							break;
						}
					}
					if (!isValidFile) {
						e.value = null;
						$scope.fileerrorMsg=[];
						$scope.fileerrorMsg.push("Invalid File.Valid extensions are: "+validFilesTypes.join(", "));
						//document.getElementById("error").style.color="red";

						//document.getElementById("errorfile").innerHTML="<i class='fa fa-exclamation-circle'></i>Invalid File.Valid extensions are: "+ validFilesTypes.join(", ");
						//alert($scope.fileerrorMsg);


					}

					return isValidFile;
				}
				function validateFileSize(e) {
					/*global document: false */
					var file = e;

					console.log(e);

					console.log(file.files[0]);
					var fileSize = file.files[0].size; //size in kb
					fileSize = fileSize / 1048576; //size in mb

					var isValidFile = false;
					if (fileSize !== 0 && fileSize <= 5) {
						isValidFile = true;
						$scope.bulkfileData=$scope.file.filename;
					}
					if (!isValidFile) {
						e.value = null;
						$scope.fileerrorMsg=[];
						$scope.fileerrorMsg.push("File Size Should be lesser than 5 MB");
						//alert($scope.fileerrorMsg);
					}
					return isValidFile;
				}
			});

	$scope.Reset=function(){
		$scope.messageWarning = [];
		$scope.messageSuccess = [];
		$scope.bulkFile=null;
		$scope.fileerrorMsg=[];
		$scope.message = [];
		$scope.bulkfileData=null;
		//alert("Form"+document.getElementById("bulkUploadForm").name);
		document.getElementById("bulkUploadForm").reset();
		reset();
		InitLoad();
		$scope.hideFlag=false;

	};




	$scope.downloadBulkUploadTempDocumentLink= function() {

		//window.location = document.docLink;
		$http({
			method : 'POST',
			url : 'ajax/BulkUploadTempDownloadFileLink',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			window.location = 'BulkUploadTempDownloadFile';

		})
	};
});

techpedia.controller('additionalInfoGytiController', function($scope, $http) {

	$scope.submitAcademicProjectToGyti={};
	$scope.submitAcademicProjectToGyti.projAppliedAwards="GYTI";
	/*$scope.submitAcademicProjectToGyti.projGuideName="test";*/


	$scope.message=[];
	$scope.InitLoad = function() {
		var min = 2008;
		 var date = new Date();
		 var currentYear = date.getFullYear()-1;
	    select = document.getElementById('awardYear');

	for (var i = min; i<=currentYear; i++){
	    var opt = document.createElement('option');
	    opt.value = i;
	    opt.innerHTML = i;
	    select.appendChild(opt);
	}
	};

	$scope.Exitfunction=function(){
		$scope.messageerrorCaptcha=[];
		$scope.messageSuccess = [];
		$scope.messageWarning = [];
		$scope.messageWarningEmail = [];
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
            // $scope.selectYear(d.format('YYYY'));
            }
        }); 

        
    });

	$scope.validateCheckboxes = function(additionalInnvationForm){
		
		
		var elements = document.getElementsByName("idea[]");
		for(var i=0; i < elements.length; i++){
			if(elements[i].checked && additionalInnvationForm==false) {
				return false;
			}
		}
		return true;
	}
	

	$scope.AcademicProjectToGyti = function(jCaptcha) {
		var checkboxArray=document.getElementsByName("idea[]");
		//alert("length=="+checkboxArray.length)

		var statusofinnovation = "";
		var count = 0;
		for(var i=0;i<checkboxArray.length;i++){
			if(checkboxArray[i].checked){

				count++;
				if(count>1)
				{
					statusofinnovation=statusofinnovation+","+checkboxArray[i].value;
				}else{
					statusofinnovation=statusofinnovation+checkboxArray[i].value;
				}
			}
		}
		//alert("whole string==="+statusofinnovation);
		$scope.submitAcademicProjectToGyti.projStatusInfo = statusofinnovation;

		$http({
			method : 'POST',
			url : 'submitAcademicProjectToGytiservice?res='+jCaptcha,
			data : $.param($scope.submitAcademicProjectToGyti),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data === 'Invalid Captcha'){
				$scope.messageerrorCaptcha=[];
				$scope.messageerrorCaptcha.push("Invalid Captcha");
				reloadCaptcha();
			}
			else if (data.status=="success") {
				$scope.messageSuccess = [];
				$scope.messageSuccess.push("Your project information has been submitted successfully for GYTI award.");
			}
			else if(data.status=="success with Email error"){
				$scope.messageWarningEmail = [];
				$scope.messageWarningEmail.push(data.description+" to your registered eamil id;");
			}
			else{
				$scope.messageWarning = [];
				$scope.messageWarning.push("Oops! An error has occured. Please contact the administrator.");
			}
		}).error(function(data, status, headers, config) {
			$scope.messageWarning = [];
			$scope.messageWarning.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};



});

techpedia.controller('ReviewDashBoardController',function($scope, $http){


	$scope.Initload=function()
	{
		$http({
			method : 'POST',
			url : 'ajax/getTotalGytiProjectsByCategory',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.getTotalGytiProjectsByCategoryOBJECT=data;

			/*var getTotalGytiProjectsByCategory=JSON.stringify(data);
			console.log("JSON String::"+getTotalGytiProjectsByCategory);*/

			//graph

			var chart = AmCharts.makeChart("chartdiv", {
				"theme": "light",
				"type": "serial",
				"title":"Total Submitted Innovations/Ideas",
				"dataProvider":$scope.getTotalGytiProjectsByCategoryOBJECT,

				/* [ 

				                 {
				                	 "category": "Electronics & Communication Engineering",
				                	 "totalProject": 789
				                 }, {
				                	 "category": "Electrical",
				                	 "totalProject":900
				                 }, {
				                	 "category": "Computer Science",
				                	 "totalProject": 301
				                 }, {
				                	 "category": "Information Technology",
				                	 "totalProject": 2905
				                 }, {
				                	 "category": "Metallurgy",
				                	 "totalProject": 2406
				                 },
				                 {
				                	 "category": "Chemical",
				                	 "totalProject": 2350
				                 }, {
				                	 "category": "Mechanical",
				                	 "totalProject": 600
				                 }, {
				                	 "category": "Food Technology",
				                	 "totalProject": 3015
				                 }, {
				                	 "category": "Civil",
				                	 "totalProject": 2950
				                 }, {
				                	 "category": "Bio-Technology",
				                	 "totalProject": 246
				                 },
				                 {
				                	 "category": "Textile",
				                	 "totalProject": 2350
				                 }, {
				                	 "category": "Aeronautical",
				                	 "totalProject": 0
				                 }, {
				                	 "category": "Instrumental",
				                	 "totalProject": 301
				                 }, {
				                	 "category": "Environmental",
				                	 "totalProject": 295
				                 }, {
				                	 "category": "Bio-Medical",
				                	 "totalProject": 246
				                 }

				                 ],*/
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
				"export": {
					"enabled": true
				}
			});




		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});



		/*google.charts.load('current', {packages: ['corechart', 'bar']});
		google.charts.setOnLoadCallback(drawBasic);*/

		/*function drawBasic() {

			var data = google.visualization.arrayToDataTable([
			                                                  ['Category', 'Total Project'],
			                                                  ['Electronics & Communication',200],
			                                                  ['Electrical', 379],
			                                                  ['Computer Science', 269],
			                                                  ['Information Technology', 209],
			                                                  ['Metallurgy', 3792],
			                                                  ['Chemical', 2695],
			                                                  ['Mechanical', 2099],
			                                                  ['Food Technology', 1000],
			                                                  ['Civil', 2130],
			                                                  ['Bio-Technology', 700],
			                                                  ['Bio-Medical', 900],
			                                                  ['Textile', 3000],
			                                                  ['Aeronautical', 2500],
			                                                  ['Instrumental', 3250],
			                                                  ['Environmental', 600]
			                                                  ]);

			var options = {
					title: 'Total Submitted Innovations/Ideas',
					height: '100%',
					//colors: ['#1b9e77', '#d95f02', '#7570b3'],
					colors:['#3575AD'],
					chartArea: {
						width: '50%',
						//height: '100%'

					},
					bars: 'horizontal',
					hAxis: {
						title: 'Total Submitted Project',
						format: 'decimal',
						minValue: 0
					},
					vAxis: {
						title: 'Category'
					}
			};

			var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

			chart.draw(data, options);
			var btns = document.getElementById('btn-group');

			btns.onclick = function (e) {

				if (e.target.tagName === 'BUTTON') {
					options.hAxis.format = e.target.id === 'none' ? '' : e.target.id;
					chart.draw(data, google.charts.Bar.convertOptions(options));
				}
			}
		};*/
	};

});

techpedia.controller('ReviewHeaderController',function($scope, $http){

	$scope.InitLoad=function()
	{
		//do some action here
	};


});

techpedia.controller('ReviewSideMenuController',function($scope, $http){

	$scope.InitLoad=function()
	{
		//do some action here
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
		//do some action here
	};
	$scope.registerReviewer=function(){
		$scope.ReviewerEmail=$scope.AddReviewer.revEmailId;
		$http({
			method : 'POST',
			url : 'ajax/AddReviwerByAdmin',
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

techpedia.controller('reviewerLoginController',function($scope, $http){

	$scope.InitLoad=function()
	{

	};
});

function ExitGYTIReview(){
	window.location.href="reviewGYTIProjects";
};


techpedia.controller('ReviewRatingController', function($scope,$http) {
	$scope.ReviewRatingVO={};
	$scope.InitLoad=function(){
		$scope.addMsg=[];
		$scope.addMsgerror = [];
		document.getElementById("revRatingPercentage").readOnly = true;
		$http({
			method : 'POST',
			url : 'ajax/getGytiProjectDetailforReview',
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
		})

	};

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
		//$scope.ReviewRatingVO.revRgstrId=12;
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
			url : 'ajax/submitReviewRating',
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


});


techpedia.controller('reviewerStatusController',function($scope, $http,$filter,$timeout){
	$scope.itemsPerPage=10;
	$scope.InitLoad=function()
	{
		$scope.SelectedType="All Reviewers";


		//$scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'ajax/getAllReviewer',
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

		//$scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'ajax/getAllReviewer',
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

	//Show Active Reviewers


	$scope.showActiveReviewers=function() {
		//alert("Active Reviewers====");
		$scope.SelectedType="Active Reviewers";


		//$scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'ajax/getActiveReviewers',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {


			$scope.sort = {       
					sortingOrder : "$index+1",
					reverse : false
			};

			//alert("Active******"+data.length);
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


	//Show Deactive Reviewers
	$scope.showDeactiveReviewers=function() {
		//alert("Inactive Reviewers");
		$scope.SelectedType="Inactive Reviewers";


		//$scope.gap =$scope.pagedItems.length;

		$http({
			method : 'POST',
			url : 'ajax/getDeactiveReviewers',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			//alert("Deactive");

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
		//$('a[data-toggle="tooltip"]').tooltip(); // NOT CORRECT!
		$timeout(function() {
			$('.ActivateReviewers').tooltip();
			$('.InActivateReviewers').tooltip();

		}, 0); // wait...
	}

	$scope.clickedReviewerDetails=function(reviewer){

		$scope.selectedReviewerName=reviewer.revFname;
		$scope.selectedUserId=reviewer.revUsrId;
	};

	/*data : $.param({}),
	url : 'getSuggestedBranches?q=' + $scope.searchTerm*/

	$scope.activateReviewer=function(userId,name){
		setTimeout(function() {
			$('#reviewerDetailModalToActivate').modal('hide');}, 1000);

		setTimeout(function() {
			$('#activateReviewerModal').modal('show');}, 2000);
		$http({
			method : 'POST',
			url : 'ajax/activateReviewerProfile',
			data : $.param({
				revUserId:userId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			//$('#reviewerDetailModalToActivate').modal('hide');

			if (data.status == 'success') {
				$scope.actMsg=[];
				$scope.actMsg.push("The Reviewer"+" "+name+" "+"\nhas been activated successfully.");
				$scope.InitLoad();
			} else {
				$scope.actMsgerror = [];
				$scope.addMsgerror.push("Some problem occured while publishing the college news");
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
			url : 'ajax/deActivateReviewerProfile',
			data : $.param({
				revUserId:userId
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			//$('#reviewerDetailModalToDeactivate').modal('hide');
			setTimeout(function() {$('#reviewerDetailModalToDeactivate').modal('hide');}, 5000);
			if (data.status == 'success') {
				$scope.actMsg=[];
				$scope.actMsg.push("The Reviewer"+" "+name+" "+"\nhas been deactivated successfully.");
				$scope.InitLoad();
			} else {
				$scope.actMsgerror = [];
				$scope.addMsgerror.push("Some problem occured while publishing the college news");
				$scope.InitLoad();

			}

		}).error(function(data, status, headers, config) {
			$scope.actMsgerror = [];
			$scope.actMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.InitLoad();

		})

	};

	/*Get Dummy Data for Example*/
	function getDummyData() {
		return [{
			Name: 'ABC',
			Category: 'Category1',
			Organization: 'Organization1',
			Designation: 'Designation1',
			Speciality: 'Speciality1',
			Action: 'Yes'
		}, {
			Name: 'PQR',
			Category: 'Category2',
			Organization: 'Organization2',
			Designation: 'Designation2',
			Speciality: 'Speciality2',
			Action: 'No'
		}, {
			Name: 'XYZ',
			Category: 'Category3',
			Organization: 'Organization3',
			Designation: 'Designation3',
			Speciality: 'Speciality3',
			Action: 'Yes'
		}, {
			Name: 'LMN',
			Category: 'Category4',
			Organization: 'Organization4',
			Designation: 'Designation4',
			Speciality: 'Speciality4',
			Action: 'No'
		}, {
			Name: 'BBD',
			Category: 'Category5',
			Organization: 'Organization5',
			Designation: 'Designation5',
			Speciality: 'Speciality5',
			Action: 'Yes'
		}, {
			Name: 'RST',
			Category: 'Category6',
			Organization: 'Organization6',
			Designation: 'Designation6',
			Speciality: 'Speciality6',
			Action: 'No'
		}, {
			Name: 'TST',
			Category: 'Category7',
			Organization: 'Organization7',
			Designation: 'Designation7',
			Speciality: 'Speciality7',
			Action: 'Yes'
		}, {
			Name: 'STR',
			Category: 'Category8',
			Organization: 'Organization8',
			Designation: 'Designation8',
			Speciality: 'Speciality8',
			Action: 'No'
		}, {
			Name: 'SDF',
			Category: 'Category9',
			Organization: 'Organization9',
			Designation: 'Designation9',
			Speciality: 'Speciality9',
			Action: 'Yes'
		}, {
			Name: 'PPT',
			Category: 'Category10',
			Organization: 'Organization10',
			Designation: 'Designation10',
			Speciality: 'Speciality10',
			Action: 'No'
		}, {
			Name: 'ODS',
			Category: 'Category11',
			Organization: 'Organization11',
			Designation: 'Designation11',
			Speciality: 'Speciality11',
			Action: 'Yes'
		}, {
			Name: 'CNF',
			Category: 'Category12',
			Organization: 'Organization12',
			Designation: 'Designation12',
			Speciality: 'Speciality12',
			Action: 'No'
		},{
			Name: 'JKL',
			Category: 'Category13',
			Organization: 'Organization13',
			Designation: 'Designation13',
			Speciality: 'Speciality13',
			Action: 'Yes'
		},{
			Name: 'JTL',
			Category: 'Category14',
			Organization: 'Organization14',
			Designation: 'Designation14',
			Speciality: 'Speciality14',
			Action: 'No'
		},{
			Name: 'JKL',
			Category: 'Category15',
			Organization: 'Organization15',
			Designation: 'Designation15',
			Speciality: 'Speciality15',
			Action: 'Yes'
		},{
			Name: 'TTR',
			Category: 'Category16',
			Organization: 'Organization16',
			Designation: 'Designation16',
			Speciality: 'Speciality16',
			Action: 'No'
		},{
			Name: 'USA',
			Category: 'Category17',
			Organization: 'Organization17',
			Designation: 'Designation17',
			Speciality: 'Speciality17',
			Action: 'Yes'
		},{
			Name: 'FGF',
			Category: 'Category18',
			Organization: 'Organization18',
			Designation: 'Designation18',
			Speciality: 'Speciality18',
			Action: 'No'
		},{
			Name: 'MNL',
			Category: 'Category19',
			Organization: 'Organization19',
			Designation: 'Designation19',
			Speciality: 'Speciality19',
			Action: 'Yes'
		},{
			Name: 'TTE',
			Category: 'Category20',
			Organization: 'Organization20',
			Designation: 'Designation20',
			Speciality: 'Speciality20',
			Action: 'No'
		}
		];
	}


	$scope.login=function(){
		alert("logged In hi....");
	}
});

techpedia.controller('revieweGYTIProjectsController',function($scope, $http,$filter,$timeout){	
	$scope.InitLoad=function(){
		/*alert("function called...");*/
		$http({
			method : 'POST',
			url : 'ajax/getAllGYTIProjetcByLoggdinReviewer',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			//$('#reviewerDetailModalToActivate').modal('hide');
			/*alert("response:1:"+JSON.stringify(data));
			alert("response:2:"+JSON.stringify(data.projectsProposedForReview));
			alert("response:3:"+JSON.stringify(data.projectsOptionalForReview[0].projUniversity));
			alert("response:4:"+JSON.stringify(data.projectsAlreadyReviewed));*/
			$scope.projectsProposedForReview=data.projectsProposedForReview;
			$scope.projectsOptionalForReview=data.projectsOptionalForReview;
			$scope.projectsAlreadyReviewed=data.projectsAlreadyReviewed;

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.Initload();

		})


	};

	$scope.viewGYTIProjDetails=function(projId){
		
		$http({
			method : 'POST',
			url : 'ajax/getGytiProjectDetailView',
			data : $.param({
				projId: projId

			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			$scope.GYTIProject=data;
			$scope.projBranchList=$scope.GYTIProject.projBranchList;	
			
		}).error(function(data, status, headers, config) {
			$scope.addMsgerror = [];
			$scope.addMsgerror.push("Possibly the service is down, Please contact the admin if problem persists.");
		})
			
	}
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
});

techpedia.controller('TechAdminPageController', function($scope, $http,$filter,$timeout){
	$scope.InitLoad=function(){
		$scope.bulkfileData=null;
		$scope.hideFlag=true;
	};
	
	$scope.master = null;
	$scope.reset = function() {
		$scope.bulkFile= angular.copy($scope.master);
	};
	$scope.UploadBulkXlsFile=function(){
		$scope.hideFlag=false;
		$scope.message = "";
		$http({
			method : 'POST',
			url : 'bulkUploadProjectDocumentByColgAdmn',
			data : $.param({
				documentName : $scope.file.filename,
				bulkDocumentBase64 : $scope.file.base64
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			if(data.status==="failure"){
				$("#successMsg").hide();
				$("#warningMsg").show();
				$scope.messageWarning = [];
				$scope.messageWarning.push(data.exceptionMessage);	
				$scope.hideFlag=true;
				//$scope.bulkfileData=null;
				//alert("Form"+document.getElementById("bulkUploadForm").name);
				document.getElementById("bulkUploadForm").reset();
				$scope.reset();
				$scope.InitLoad();
			}
			else if (data.status === "success") {
				$("#warningMsg").hide();
				$("#successMsg").show();
				document.getElementById("bulkUploadForm").reset();
				$scope.reset();
				$scope.messageSuccess = [];
				$scope.messageSuccess.push("Document uploaded succesfully");
				$scope.hideFlag=true;
				$scope.InitLoad();
			} else {
				$scope.messageWarning = [];
				$scope.messageWarning.push("Failed to upload document, Please try later");
				$scope.hideFlag=true;
			}
		}).error(function(data, status, headers, config) {

			$scope.messageWarning = [];
			$scope.messageWarning.push("Possibly the service is down, Please contact the admin if problem persists.");
			$scope.hideFlag=true;
		});

	};

	$(document)
	.ready(
			function() {
				/*var validFilesTypes = [ "bmp", "gif", "png", "jpg",
				                        "jpeg", "doc", "docx", "xls", "xlsx", "htm",
				                        "html", "rar", "zip", "txt", "pdf" ];*/
				//	$scope.bulkfileData=$scope.file.filename;
				var validFilesTypes=["xls","xlsx"];
				$('.fileCheck').change(function() {
					var fileCheck=this;
					var filename=CheckExtension(fileCheck);

					if(filename)
						validateFileSize(fileCheck);

				});
				function CheckExtension(e) {
					/*global document: false */
					var file = e;
					//alert("E" + e);
					var path = file.value;
					//alert("PAth" + path);
					var ext = path.substring(path.lastIndexOf(".") + 1,
							path.length).toLowerCase();
					var isValidFile = false;
					for (var i = 0; i < validFilesTypes.length; i++) {
						if (ext == validFilesTypes[i]) {
							isValidFile = true;
							$scope.bulkfileData=$scope.file.filename;
							break;
						}
					}
					if (!isValidFile) {
						e.value = null;
						$scope.fileerrorMsg=[];
						$scope.fileerrorMsg.push("Invalid File.Valid extensions are: "+validFilesTypes.join(", "));
						//document.getElementById("error").style.color="red";

						//document.getElementById("errorfile").innerHTML="<i class='fa fa-exclamation-circle'></i>Invalid File.Valid extensions are: "+ validFilesTypes.join(", ");
						//alert($scope.fileerrorMsg);


					}

					return isValidFile;
				}
				function validateFileSize(e) {
					/*global document: false */
					var file = e;

					console.log(e);

					console.log(file.files[0]);
					var fileSize = file.files[0].size; //size in kb
					fileSize = fileSize / 1048576; //size in mb

					var isValidFile = false;
					if (fileSize !== 0 && fileSize <= 5) {
						isValidFile = true;
						$scope.bulkfileData=$scope.file.filename;
					}
					if (!isValidFile) {
						e.value = null;
						$scope.fileerrorMsg=[];
						$scope.fileerrorMsg.push("File Size Should be lesser than 5 MB");
						//alert($scope.fileerrorMsg);
					}
					return isValidFile;
				}
			});

	$scope.Reset=function(){
		$scope.messageWarning = [];
		$scope.messageSuccess = [];
		$scope.bulkFile=null;
		$scope.fileerrorMsg=[];
		$scope.message = [];
		$scope.bulkfileData=null;
		//alert("Form"+document.getElementById("bulkUploadForm").name);
		document.getElementById("bulkUploadForm").reset();
		reset();
		InitLoad();
		$scope.hideFlag=false;

	};

	$scope.downloadBulkUploadTempDocumentLink= function() {

		//window.location = document.docLink;
		$http({
			method : 'POST',
			url : 'ajax/BulkUploadTempDownloadFileLink',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}

		}).success(function(data, status, headers, config) {
			window.location = 'BulkUploadTempDownloadFile';

		})
	};
});

techpedia.controller('techpediaArchiveController', function($scope, $http,$filter,$timeout) {
	
	$scope.InitLoad=function(){
		$http({
			method: 'GET',
			url: 'techpediaArchiveData',
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
			url: 'techpediaArchiveDataDownloadFileName',
			data:$.param({
				fileName : filename
			}),
			headers: {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			window.location = 'downloadTechpediaArchiveFile?fileName='+filename;
		}).error(function(data, status, headers, config){
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	}
	
});


techpedia.controller('NewTeamMemberController', function($scope, $http) {

	$scope.initialEditProfileData = function() {
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'ajax/editNewTeamMemberProfileLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			$scope.edit = data;
			alert("edit fname=="+scope.edit.firstName);
			$scope.edit.photo = '';
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
		$scope.$watch('file1', function() {
			$scope.edit.logo = "data:" + $scope.file1.filetype + ";base64," + $scope.file1.base64;
		}, true);


		var dataArray = [];
		for (var i = 0; i < data.collge.length; i++) {
			//var id = data.projBranchList[i].branchId;
			var text = data.projBranchList[0];
			alert( "hai " + text);
			var json = {};
			//json.id = id;
			json.text = text;
			dataArray.push(json);

		}


		console.log(JSON.stringify(dataArray));
		$("#CollegeNames").select2("data", dataArray);
		/*$scope.data = [ {
			"branchId" : 1,
			"projBranchDesc" : "Chemical Engineering"
		}, {
			"branchId" : 2,
			"projBranchDesc" : "Electronic and Communiaction"
		}, {
			"branchId" : 3,
			"projBranchDesc" : "Mechanical"
		}, {
			"branchId" : 4,
			"projBranchDesc" : "Electrical Engineering"
		},{
			"branchId" : 5,
			"projBranchDesc" : "Computer Science"
		} ];*/
	};
	
	$scope.showError = function() {
		$('#pwdError').show();
	};
	$scope.hideError = function() {
		$('#pwdError').hide();
	};
	$scope.enterDegree = function(){
		$('#studentdegree1').show();
		$('#studentdegree1').val('');
		$('#s2id_studentdegree').hide();
	};
	$scope.enterMentorDegree = function(){
		$('#degreeOfMentor1').show();
		$('#degreeOfMentor1').val('');
		$('#s2id_degreeOfMentor').hide();
	};
	$scope.enterFacultyDegree = function(){
		$('#degreeOfFaculty1').show();
		$('#degreeOfFaculty1').val('');
		$('#s2id_degreeOfFaculty').hide();
	};

	$scope.search = function() {
		// alert($scope.form.searchTerm);
		$http({
			method : 'GET',
			data : $.param({}),
			url : 'getSuggestedBranches?q=' + $scope.searchTerm
		}).success(function(data, status, headers, config) {
			$scope.data = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	};

	$scope.deleteCollege = function(){
		$scope.edit.collge = "";
		$('#CollegeNames').select2('data',null);
		$('#s2id_CollegeNames').show();
	};
	$scope.showCollege = function(){
		try{
			if($scope.edit.collge === ''){
				$('#s2id_CollegeNames').show();
			}else{
				$('#s2id_CollegeNames').hide();
			}
			return $scope.edit.collge === '';
		}catch(e){}
	};



	$scope.deleteUniversity = function(){
		$scope.edit.university = "";
		$('#university').select2('data',null);
		$('#s2id_University').show();
	};
	$scope.showUniversity = function(){
		try{
			if($scope.edit.university === ''){
				$('#s2id_university').show();
			}else{
				$('#s2id_university').hide();
			}
			return $scope.edit.university === '';
		}catch(e){}
	};





	$scope.deleteBranches = function(){
		$scope.edit.branchIdOfStudent2 = "";
		$('#branchIdOfStudent2').select2('data',null);
		$('#s2id_branchIdOfStudent2').show();
	};
	$scope.showBranches = function(){
		try{
			if($scope.edit.branchIdOfStudent2 === ''){
				$('#s2id_branchIdOfStudent2').show();
			}else{
				$('#s2id_branchIdOfStudent2').hide();
			}
			return $scope.edit.branchIdOfStudent2 === '';
		}catch(e){}
	};





	$scope.deleteCollgeOfFaculty = function(){
		$scope.edit.collgeOfFaculty = "";
		$('#collgeOfFaculty').select2('data',null);
		$('#s2id_collgeOfFaculty').show();
	};
	$scope.showCollgeOfFaculty = function(){
		try{
			if($scope.edit.collgeOfFaculty === ''){
				$('#s2id_collgeOfFaculty').show();
			}else{
				$('#s2id_collgeOfFaculty').hide();
			}
			return $scope.edit.collgeOfFaculty === '';
		}catch(e){}
	};



	$scope.deleteSpecializationOfFaculty = function(){
		$scope.edit.specializationOfFaculty2 = "";
		$('#specializationOfFaculty2').select2('data',null);
		$('#s2id_specializationOfFaculty2').show();
	};
	$scope.showSpecializationOfFaculty = function(){
		try{
			if($scope.edit.specializationOfFaculty2 === ''){
				$('#s2id_specializationOfFaculty2').show();
			}else{
				$('#s2id_specializationOfFaculty2').hide();
			}
			return $scope.edit.specializationOfFaculty2 === '';
		}catch(e){}
	};




	$scope.deleteUniversityOfFaculty = function(){
		$scope.edit.universityOfFaculty = "";
		$('#universityOfFaculty').select2('data',null);
		$('#s2id_universityOfFaculty').show();
	};
	$scope.showUniversityOfFaculty = function(){
		try{
			if($scope.edit.universityOfFaculty === ''){
				$('#s2id_universityOfFaculty').show();
			}else{
				$('#s2id_universityOfFaculty').hide();
			}
			return $scope.edit.universityOfFaculty === '';
		}catch(e){}
	};



	$scope.deleteBranchIdOfMentor2 = function(){
		$scope.edit.branchIdOfMentor2 = "";
		$('#branchIdOfMentor2').select2('data',null);
		$('#s2id_branchIdOfMentor2').show();
	};
	$scope.showBranchIdOfMentor2 = function(){
		try{
			if($scope.edit.branchIdOfMentor2 === ''){
				$('#s2id_branchIdOfMentor2').show();
			}else{
				$('#s2id_branchIdOfMentor2').hide();
			}
			return $scope.edit.branchIdOfMentor2 === '';
		}catch(e){}
	};



	//for university 	 	
	$scope.search1 = function() { 	 	
		alert($scope.form.searchUName); 	 	
		$http({ 	 	
			method : 'GET', 	 	
			data : $.param({}), 	 	
			url : 'getUniversityList?uName=' + $scope.searchUName 	 	
		}).success(function(data, status, headers, config) { 	 	
			$scope.data = data; 	 	
		}).error(function(data, status, headers, config) { 	 	
			// called asynchronously if an error occurs 	 	
			// or server returns response with an error status. 	 	
		}); 	 	
	};
	//--------------------------------------------------------------------------------

	
	$scope.Exitfunction=function(){
		$scope.messageerrorCaptcha=[];
		$scope.messageSuccess = [];
		$scope.messageWarning = [];
		$scope.messageWarningEmail = [];
	};
	$scope.newTeamMember = function(jCaptcha) {
		//alert("first name==="+$scope.edit.firstName);
		if ($scope.edit.isMobile==undefined) {
			$scope.edit.isMobile = "N"
		}
		$http({
			method : 'POST',
			url : 'editTeamMemberProfileRequest?res='+jCaptcha,
			data : $.param($scope.edit),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {	
			//alert("data==="+data);
			if (data === 'Invalid Captcha'){
				$scope.messageerrorCaptcha=[];
				$scope.messageerrorCaptcha.push("Invalid Captcha");
				reloadCaptcha();
			}
			else if (data.status=="success") {
				$scope.messageSuccess = [];
				$scope.messageSuccess.push("You profile has been created. Please use your credentials to login");
			}
			else if(data.status=="success with Email error"){
				$scope.messageWarningEmail = [];
				$scope.messageWarningEmail.push(data.description);
			}
			else{
				$scope.messageWarning = [];
				$scope.messageWarning.push("Oops! An error has occured. Please contact the administrator.");
			}
		}).error(function(data, status, headers, config) {
			$scope.messageWarning = [];
			$scope.messageWarning.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
	
	$scope.forward = function() {
		window.location.href="dashboard";
	};
});

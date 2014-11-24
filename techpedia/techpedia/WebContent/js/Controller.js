var techpedia = angular.module('techpedia', []);

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
			// TBD;
		});
	};

	$scope.viewMentor = function(mentor) {
		window.location = 'mentorDetails' + mentor.mentorId;
	};
});

techpedia.controller('IndexController', function($scope, $http) {
	$scope.InitLoad = function() {
		$http({
			method : 'POST',
			url : 'projectSpotlightLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projects = data;
		}).error(function(data, status, headers, config) {
			$scope.projects = [ {
				projTitle : 'Failed to load data',
				projDescription : 'Please try again later'
			} ];
		});

		var count = 0;
		setInterval(function() {
			count = (count + 1) % $scope.projects.length;
			$scope.project = $scope.projects[count];
			$scope.$apply();
		}, 3000);

		$scope.testimonials = [ {
			testimonial : 'I am extremely happy to see an initiative of SRISTI (Society for Research and Initiatives for Sustainable Technologies and Institutions) which has led to mapping of the mind of engineering youth of our country in an unprecedented manner.',
			cite : 'DR. A.P.J. ABDUL KALAM'
		}, {
			testimonial : 'I wish all the energy to the team and hope that they will continue to link academia, industry, informal sector and the creative youth of the country.',
			cite : 'Raj Shekhawat'
		}, {
			testimonial : 'I am particularly pleased to know that several of the innovations by the school children are also being valorized by engineering college students.',
			cite : 'A.K. Das'
		} ];

		var count2 = 0;
		setInterval(function() {
			count2 = (count2 + 1) % $scope.testimonials.length;
			$scope.testimonial = $scope.testimonials[count2];
			$scope.$apply();
		}, 3000);
	};

	$scope.viewProject = function(project) {
		window.location = 'projectDetails' + project.projId;
	};
});

techpedia.controller('LoginModalController', function($scope, $http) {
	$scope.InitLoad = function() {
		;
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
			if (data === 'Y') {
				$scope.message = [];
				$scope.message.push("Request sent. Check your email");
			} else {
				$scope.message = [];
				$scope.message.push("Failed to send reqest, try later");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.facebookLogin = function() {
		FB.getLoginStatus(function(response) {
			if (response.status === 'connected') {
				console.log('Logged in.');
				console.log(response.authResponse.accessToken);

				FB.api('/me', function(response) {
					console.log("ALREADY:- " + JSON.stringify(response));
				});

			} else {
				console.log('Trying login');
				FB.login(function(response) {
					if (response.status === 'connected') {
						console.log(response.authResponse.accessToken);
						FB.api('/me', function(response) {
							console.log("JUST:- " + JSON.stringify(response));
						});
					}
				}, {
					scope : 'public_profile,email'
				});
			}
		});
	};
});

techpedia.controller('ChallengeDetailsController', function($scope, $http) {
	$scope.InitLoad = function() {
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
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});

	};

	$scope.acceptChallenge = function(challenge) {
		window.location = window.location = 'acceptChallenge?challengeId=' + challenge.challengId;
	};

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
			if (data === 'Y') {
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

	$scope.downloadDocument = function(document) {
		window.location = document.docLink;
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
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.clickTeam = function(team) {
		window.location = 'teamDetails' + team.teamID;
	};
});

techpedia.controller('TeamDetailsController', function($scope, $http) {
	$scope.initLoad = function() {
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

	$scope.addMember = function(registerId) {
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
			alert(data);
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.removeMember = function(member) {
		if (confirm("Are you sure ?")) {
			$http({
				method : 'POST',
				url : 'ajax/removeTeamMember',
				data : $.param({
					registerId : member.teamMemRegstrId,
					projectId : $scope.projectId,
					teamId : $scope.teamId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				alert(data);
				$scope.initLoad();
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};
});

techpedia.controller('ManageChallengesController', function($scope, $http) {
	$scope.initLoad = function() {
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
		window.location = 'acceptChallenge?challengeId=' + challenge.challengId;
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
			if (data === 'Y') {
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

techpedia.controller('DashboardController', function($scope, $http) {
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
		}).error(function(data, status, headers, config) {
			$scope.message = [];
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
			$scope.message = [];
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
	$scope.manageProjectsInit = function() {
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
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
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
			$scope.message = [];
			if (data === 'Y') {
				$scope.message.push("Project submitted succesfully");
			} else {
				$scope.message.push("Some problem occured while submitting the project. Please try again later.");
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
				projectId : project.projId
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
			if (data === 'Y') {
				window.location = 'projectDetails' + $scope.chosenProject.projId;
				$scope.message = [];
				$scope.message.push("Mentor added");
			} else {
				$scope.message = [];
				$scope.message.push("Failed to add mentor");
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

	$scope.uploadProjectDocument = function() {
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
			if (data === 'Y') {
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
				if (data == 'Y') {
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
});

function ProjectDetail($scope, $http) {
	$scope.InitLoad = function() {
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
					set : 0,
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
					set : 0,
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
					if (data === 'N')
						$scope.doesFollow = false;
					else
						$scope.doesFollow = true;

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

	$scope.deleteMentor = function(mentor) {
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
			if (data === 'Y') {

				var index = $scope.projectMentorList.indexOf(mentor);
				$scope.projectMentorList.splice(index, 1);

				$scope.message = [];
				$scope.message.push("Mentor deleted");
			} else {
				$scope.message = [];
				$scope.message.push("Failed to delete mentor");
			}
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
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
			if (data === 'N')
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
			if (data === 'N')
				$scope.doesFollow = false;
			else
				$scope.doesFollow = true;

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.postComment = function(comment) {
		$http({
			method : 'POST',
			url : 'ajax/postComment',
			data : $.param({
				projectId : $scope.projectId,
				registerId : $scope.registerId,
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

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.deleteComment = function(comment, type) {
		if (confirm("Are you sure ?")) {
			$http({
				method : 'POST',
				url : 'ajax/deleteComment',
				data : $.param({
					projectId : $scope.projectId,
					commentId : comment.commentId,
					registerId : $scope.registerId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.message = [];
				if (data === 'N')
					alert('Failed to delete comment');
				else {
					if (type === 'public') {
						var index = $scope.publicComment.indexOf(comment);
						$scope.teamComment.splice(index, 1);
					} else {
						var index = $scope.teamComment.indexOf(comment);
						$scope.teamComment.splice(index, 1);
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
			if (data === 'Y') {
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

	$scope.downloadDocument = function(document) {
		window.location = document.docLink;
	};
};

function AddProjectController($scope, $http) {
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
				url : 'editProfileLoad',
				data : $.param({}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.addProject.university = data.university;
				$scope.addProject.studentID = data.studentID;
				$scope.addProject.collge = data.collge;
				$scope.addProject.state = data.state;
			}).error(function(data, status, headers, config) {
				$scope.message = [];
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
};

function ChangePhotoController($scope, $http) {
	$scope.InitLoad = function() {
		$scope.canSaveImage = false;
	};

	$scope.$watch('file', function() {
		$scope.editProfile = {};
		$scope.msg = {};
		var head = "data:" + $scope.file.filetype + ";base64,";
		$scope.editProfile.photo = head + $scope.file.base64;
		$scope.editProfile.photoSize = Math.round(($scope.editProfile.photo.length - head.length) * 3 / 4) / 1000;
		if ($scope.editProfile.photoSize > 10) {
			$scope.msg.size = "File size should not me bore than 10 KB";
		} else {
			$scope.msg.size = "";
		}
		if ($scope.editProfile.photo.indexOf("undefined") > -1) {
			$scope.editProfile.photo = "images/UserDefault.jpg";
			$scope.canSaveImage = false;
		} else {
			$scope.canSaveImage = true;
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
			alert($scope.id);
			$http({
				method : 'POST',
				url : 'ajax/changeImage',
				data : $.param({
					registerId : $scope.id,
					photoByteArray : $scope.file.base64
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
}
function EditProfileController($scope, $http) {
	$scope.initialEditProfileData = function() {
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'editProfileLoad',
			data : $.param({}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.edit = data;
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.editProfile = function() {
		$http({
			method : 'POST',
			url : 'editProfileRequest',
			data : $.param($scope.edit),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			if (data === 'success') {
				$scope.message.push("Profile edited");
			} else {
				$scope.message.push(data);
			}
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
};

function ChangePasswordController($scope, $http) {
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
};

function RegisterController($scope, $http) {
	$scope.message = [];
	$scope.register = {};
	$scope.register.userType = "student";
	$scope.typeOfUser = function(data) {
		$scope.register.userType = data;
	};

	$scope.$watch('file', function() {
		$scope.register.photo = "data:" + $scope.file.filetype + ";base64," + $scope.file.base64;
	}, true);

	$scope.InitLoad = function() {
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

	$scope.registerSubmit = function() {
		$http({
			method : 'POST',
			url : 'registerRequest',
			data : $.param($scope.register),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.message = [];
			if (data === 'success') {
				$scope.message.push("You profile has been created. Please use your credentials to login");
			} else {
				$scope.message.push(data);
			}

		}).error(function(data, status, headers, config) {
			$scope.message = [];
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};
};

function AddChallengeController($scope, $http) {
	$scope.data = {};
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
};

function ProjectsPageController($scope, $http) {
	$scope.initialProjectsData = function() {
		$scope.isSearchResult = false;
		$scope.count = 0;
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'projectsFetch',
			data : $.param({
				set : 0
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data, status, headers, config) {
			$scope.projects = data;
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.viewMore = function(setNumber) {
		if ($scope.isSearchResult) {
			$scope.message = [];
			$http({
				method : 'POST',
				url : 'ajax/searchProjectByKeyword',
				data : $.param({
					term : $scope.searchTerm,
					set : setNumber
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.projects = $scope.projects.concat(data);
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
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
				$scope.projects = $scope.projects.concat(data);
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}

	};

	$scope.clickProject = function(id) {
		window.location = 'projectDetails' + id;
	};

	$scope.searchProjects = function(term, type) {
		if (type == 'keyword') {
			$http({
				method : 'POST',
				url : 'ajax/searchProjectByKeyword',
				data : $.param({
					term : term,
					set : 0
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.projects = data;
				$scope.isSearchResult = true;
				$scope.count = 0;
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			;// SERVICE NOT AVAILABLE
		}
	};
};

function MentorsPageController($scope, $http) {
	$scope.initialMentorsData = function() {
		$scope.count = 0;
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'mentorsFetch',
			data : $.param({
				set : 0
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
			$scope.mentors = $scope.mentors.concat(data);
		}).error(function(data, status, headers, config) {
			$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
		});
	};

	$scope.clickMentor = function(id) {
		window.location = 'mentorDetails' + id;
	};
};

function ChallengesPageController($scope, $http) {
	$scope.initialChallengesData = function() {
		$scope.isSearchResult = false;
		$scope.count = 0;
		$scope.message = [];
		$http({
			method : 'POST',
			url : 'challengesFetch',
			data : $.param({
				set : 0
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

	$scope.viewMore = function(setNumber) {
		if ($scope.isSearchResult) {
			;
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
				$scope.challenges = $scope.challenges.concat(data);
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		}
	};
	$scope.clickChallenge = function(id) {
		window.location = 'challengeDetails' + id;
	};

	$scope.searchChallenge = function(term, type) {
		if (type == 'title') {
			$http({
				method : 'POST',
				url : 'ajax/searchChallengeByTitle',
				data : $.param({
					term : term,
					set : 0
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data, status, headers, config) {
				$scope.challenges = data;
				$scope.isSearchResult = true;
				$scope.count = 0;
			}).error(function(data, status, headers, config) {
				$scope.message.push("Possibly the service is down, Please contact the admin if problem persists.");
			});
		} else {
			;// SERVICE NOT AVAILABLE
		}
	};
};

function NewMemberController($scope, $http) {
	;
};

techpedia.controller("TestController", function($scope) {
	$scope.InitLoad = function() {
		;
	};
});
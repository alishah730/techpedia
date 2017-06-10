<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html ng-app="techpedia">
<title>Add Reviewer</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon-user.ico">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/jquery-ui.css">

<!-- <link
	href="https://code.jquery.com/ui/1.12.0-rc.2/themes/smoothness/jquery-ui.css"> -->
<!-- <link rel="stylesheet" href="css/select2-bootstrap.css"> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-css/1.4.6/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.css"> -->

<style type="text/css">
#Reviewheader {
	color: white;
	text-align: center;
	padding: 5px;
	background-color: #23282e;
	line-height: 40px;
	display: block;
	text-align: center;
	font-size: 20px;
}

.loaderBody {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('images/cubebox.gif') 50% 50% no-repeat
		rgb(249, 249, 249);
	text-align: center;
	font-size: 18px;
	padding-top: 120px;
}

input, select2-input {
	z-index: 0 !important;
}

.inputdemoErrors .inputErrorsApp {
	min-height: 48px;
}

.inputdemoErrors md-input-container>p {
	font-size: 0.8em;
	text-align: left;
	width: 100%;
}

md-input-container {
	margin: 0px;
}
/*--------------- Page style ---------------*/
</style>
</head>
<div class="" style="padding-left: 0px; padding-right: 0px;"><jsp:include
		page="template/reviewHeader.jsp"></jsp:include>
</div>

<div id="sideNavPanel" class="col-xs-2"
	style="padding-left: 0px; padding-right: 0px; margin-left: 0px;">
	<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
</div>
<%
	if (((String) (session.getAttribute("revUsrId"))).equals("TrsAdmin")) {
%>
<body>
	<div id="mainPanelBody" class="col-xs-10 col-md-10 content-wrapper"
		ng-controller="AddReviewerController" ng-init="InitLoad()"
		style="margin-left: 0px; margin-right: 0px; padding-left: 0px; padding-right: 0px">
		<div id="Reviewheader">
			<span>Add Reviewer</span>
		</div>


		<div>
			<form ng-submit="registerReviewer()" class="form-horizontal"
				id="addReviewerForm" name="addReviewerForm" method="post" novalidate>

				<div class="panel-body user-info"
					style="border-style: none;    box-shadow: 0 0 2em #1c1f22;">
					<div class="panel-heading"
						style="border-style: none; font-family: arial; font-weight: bold;background-color: #f5f5f5">Login
						Information</div>
					<div class="col-xs-12 col-md-6">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;</div>
						<div class="panel panel-default"
							style="border-style: none; background-color: #ffffff ;  box-shadow: 0 0 2em #1c1f22;">
							<div class="col-xs-12">

								<md-input-container class="md-block"> <label>
									Email</label> <input md-maxlength="100" required type="email"
									name="revEmailId" ng-model="AddReviewer.revEmailId"
									minlength="10" maxlength="100" ng-pattern="/^.+@.+\..+$/" />
								<div ng-messages="addReviewerForm.revEmailId.$error"
									role="alert" multiple>
									<div
										ng-message-exp="['required', 'minlength', 'maxlength', 'pattern']">
										Your email must be between 10 and 100 characters long and look
										like an e-mail address.</div>
								</div>
								</md-input-container>




								<!-- <div class="input-group input-group-sm">
										<span class="input-group-addon"
											style="border-right: 1px solid #ccc; background-color: #217690; width: 50px !important; font-family: arial; color: #ffffff;"><i
											class="fa fa-envelope"></i></span> <input name="revEmailId"
											type="email" id="email" style="width: 375px !important;"
											maxlength=100 class="form-control remail email-input"
											placeholder="Email" ng-model="AddReviewer.revEmailId"
											required data-toggle='tooltip' data-placement='right'
											title="Please enter valid email as a@a.com"
											required="required" />
									</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="addReviewerForm.revEmailId.$dirty && addReviewerForm.revEmailId.$error.required">Email
										is required</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="addReviewerForm.revEmailId.$dirty && addReviewerForm.revEmailId.$error.email">Email
										is not valid</div> -->

							</div>
						</div>
					</div>

					<!-- <div class="">&nbsp;</div> -->


					<div class="col-xs-12 col-md-6">
						<!-- USER INFO START -->
						<div>&nbsp;&nbsp;&nbsp;&nbsp;</div>
						<div class="panel panel-default"
							style="border-style: none; background-color: #f5f5f5;  box-shadow: 0 0 2em #1c1f22;">
							<div class="col-xs-12">


								<md-input-container class="md-block"> <label>
									User ID</label> <input md-maxlength="16" required type="text"
									name="revUsrId" ng-model="AddReviewer.revUsrId" minlength="6"
									maxlength="16" />
								<div ng-messages="addReviewerForm.revUsrId.$error" role="alert" multiple>
									<div ng-message-exp="['required', 'minlength', 'maxlength']" >
										User ID must be between 6 and 16 characters long</div>
								</div>
								</md-input-container>



								<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 50px !important; font-family: arial; color: #ffffff;"><i
										class="fa fa-user" aria-hidden="true"></i> </span> <input
										name="revUsrId" style="width: 375px !important;" type="text"
										class="form-control"
										placeholder="Please enter Reviewer user Id" id="revUsrId"
										ng-model="AddReviewer.revUsrId" required="required"
										ng-minlength="6" ng-maxlength="16" data-toggle='tooltip'
										data-placement='right' tooltip="Please enter Reviewer user Id"
										title='Please enter Reviewer user Id ' />
								</div>

								<p
									ng-show="addReviewerForm.revUsrId.$invalid && !addReviewerForm.revUsrId.$pristine"
									data-toggle="tooltip" data-original-title="Default tooltip"></p>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revUsrId.$dirty && addReviewerForm.revUsrId.$error.required">User
									Id is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revUsrId.$dirty && addReviewerForm.revUsrId.$error.minlength || addReviewerForm.revUsrId.$error.maxlength">User
									Id should be between 6 to 16 characters</div> -->
							</div>
						</div>
					</div>

				</div>

				<!-- <div class="col-xs-12 col-md-6">
					<div class="panel panel-default"
						style="border-style: none; background-color: #f5f5f5;">
						<div class="panel-heading"
							style="border-style: none; font-family: arial; font-weight: bold;">
							<div class="btn-group">Photograph</div>
						</div>
						<div class="panel-body photoRTC">
							<input ng-model="AddReviewer.photo" type="text" name="photo"
								id="photoByte64" style="display: none;" /> <input type="text"
								name="photo" id="photoByte64Size" style="display: none;" />
							<canvas class='canvas' width='160' height='120'
								style='display: none;'></canvas>
							<div class="col-xs-12">
								<div class="col-xs-3">
									<video class='live' width='160' height='120' autoplay></video>
									<img width=160 height=130 src='../images/gravatar.png'
										class='photo' alt='photo'>
								</div>

								<div class="col-xs-9">
									<div class="col-xs-12">
										<button class='takePhoto btn btn-info btn-sm'>Take photo</button>
														<button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
															photo</button>
										<input id='hidden-photo-input' type='file'
											accept='image*;capture=camera' style='display: none;'
											ng-file="file" base64 />
									</div>
									<div class="col-xs-12">&nbsp;</div>

									<button class='btn btn-sm btn-info'
										onclick="$('#hidden-photo-input').click();"
										style="background-color: #5cb85c; float: right;">Upload
										photo</button>
									<div class="col-xs-12" ng-show="msg.size.length>0">File
										size cannot be more than 10 KB</div>
									<div class="col-xs-12" ng-show="message.length>0">
										<div ng-repeat="msg in message">{{msg}}</div>
									</div>

								</div>
							</div>
						</div>
					</div>

				</div> -->
				<div class="clearfix">&nbsp;</div>
				<div class="col-xs-12 col-md-6">
					<!-- USER INFO START -->
					<div class="panel panel-default"
						style="border-style: none; background-color: #f5f5f5; box-shadow: 0 0 2em #1c1f22;">
						<div class="panel-heading"
							style="border-style: none; font-family: arial; font-weight: bold;">User
							Information</div>
						<div class="panel-body user-info"
							style="border-style: none; background-color: #ffffff;">
							<!-- <div class="col-xs-12">
								<div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Username
										*</span> <input name="userName" type="text" id="userName"
										style="width: 300px !important;" class="form-control"
										placeholder="Username" ng-model="AddReviewer.userName" required
										ng-maxlength="50" data-toggle='tooltip' data-placement='right'
										title='Please enter Username' />
								</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.userName.$dirty && addReviewerForm.userName.$error.required">User
									name is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.userName.$dirty && addReviewerForm.userName.$error.maxlength">User
									name cannot be more than 40 characters</div>

							</div> -->

							<!-- <div class="col-xs-12">&nbsp;</div> -->

							<div class="col-xs-12">

								<md-input-container class="md-block"> <label>First
									name </label> <input required name="revFname"
									ng-model="AddReviewer.revFname" ng-pattern="/^(\D)+$/" max=30>
								<div ng-messages="addReviewerForm.revFname.$error" multiple role="alert">
									<div ng-message="required">This is required.</div>
									<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
									<div ng-message="pattern">First Name can contain only
										alphabets.</div>
									<div ng-message="max">First name cannot be more than 30
										characters</div>
								</div>
								</md-input-container>




								<!-- <div class="input-group input-group-sm ">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">
										First name *</span> <input name="revFname" type="text" id="revFname"
										style="width: 300px !important;"
										class="form-control rname my-tooltip" placeholder="First name"
										ng-model="AddReviewer.revFname" required="required"
										ng-maxlength="50" ng-pattern="/^(\D)+$/" data-toggle='tooltip'
										data-placement='right'
										title='Please enter first name without special characters' />

								</div> -->
								<!-- 
								<div class="input-group input-group-sm"
									ng-class="{ 'has-error' : addReviewerForm.revFname.$invalid && !addReviewerForm.revFname.$pristine }">

									<span class="input-group-addon">First name *</span> <input
										type="text" name="revFname" class="form-control"
										ng-model="user.name" required data-toggle="tooltip"
										data-original-title="Default tooltip">

								</div> -->
								<!-- <p
									ng-show="addReviewerForm.revFname.$invalid && !addReviewerForm.revFname.$pristine"
									data-toggle="tooltip" data-original-title="Default tooltip"></p>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revFname.$dirty && addReviewerForm.revFname.$error.required">First
									name is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revFname.$dirty && addReviewerForm.revFname.$error.maxlength">First
									name cannot be more than 30 characters</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revFname.$dirty && addReviewerForm.revFname.$error.pattern">First
									Name can only contain text</div> -->
							</div>
							<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">


								<md-input-container class="md-block"> <label>Middle
									Name</label> <input name="revMname" ng-model="AddReviewer.revMname"
									ng-pattern="/^(\D)+$/" max=30>
								<div ng-messages="addReviewerForm.revMname.$error" multiple role="alert">
									<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
									<div ng-message="pattern">Middle Name can contain only
										alphabets.</div>
									<div ng-message="max">Middle name cannot be more than 30
										characters</div>
								</div>
								</md-input-container>
								<!-- 
								
							
								<div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Middle
										name </span> <input name="revMname" type="text"
										style="width: 300px !important;" class="form-control rname"
										placeholder="Middle name (Optional)"
										ng-model="AddReviewer.revMname" ng-maxlength="30"
										ng-pattern="/^(\D)+$/" />
								</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revMname.$dirty && addReviewerForm.revMname.$error.maxlength">Mid
									name cannot be more than 30 characters</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revMname.$dirty && addReviewerForm.revMname.$error.pattern">Name
									can only contain text</div> -->

							</div>
							<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">
							
							<md-input-container class="md-block"> <label>Last Name</label>
								<input  ng-model="AddReviewer.revLname"
									md-maxlength="30" max=30 name="revLname" rows="5"
									md-select-on-focus ng-pattern="/^(\D)+$/"/>
								<div ng-messages="addReviewerForm.revLname.$error" multiple role="alert">
									<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
									<!-- <div ng-message-exp="required">This is required</div> -->
									<div ng-message="pattern">Last name can contain alphabets only</div>
									<div ng-message="max">Last name can not be more than 30 characters</div>
								</div>
								</md-input-container>
							
							
								<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Last
										name *</span> <input name="revLname" type="text" id="revLname"
										style="width: 300px !important;" class="form-control rname"
										placeholder="Last name" ng-model="AddReviewer.revLname"
										required ng-maxlength="50" ng-pattern="/^(\D)+$/"
										data-toggle='tooltip' data-placement='right'
										title='Please enter last name without special characters' />
								</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revLname.$dirty && addReviewerForm.revLname.$error.required">Last
									name is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revLname.$dirty && addReviewerForm.revLname.$error.maxlength">Last
									name cannot be more than 30 characters</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revLname.$dirty && addReviewerForm.revLname.$error.pattern">Name
									can only contain text</div> -->
							</div>

							<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">
								<div class="input-group input-group-sm">
									<!-- <span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 116px; font-family: arial; color: #ffffff;">
										Gender *</span> --><!--  <span style="margin-left: 30px"> --> <label
										class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="option1"> <input type="radio" id="option1"
											ng-model="AddReviewer.revSex" required="required"
											name="revSex" class="mdl-radio__button active" value="M"
											checked="checked"><i style="font-size: 21px"
											class="fa fa-male" aria-hidden="true"></i>
									</label> <span>&nbsp;&nbsp;</span><label
										class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="option2"> <input type="radio" id="option2"
											ng-model="AddReviewer.revSex" required="required"
											name="revSex" class="mdl-radio__button" value="F"><i
											style="font-size: 21px" class="fa fa-female"
											aria-hidden="true"></i>
									</label>
									
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revSex.$dirty && addReviewerForm.revSex.$error.required">Gender
									is required</div>
							</div>
							<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">
							
							<md-input-container class="md-block"> <label>Organization</label>
								<input  required ng-model="AddReviewer.revOrgName"
									md-maxlength="100" maxlength=100 name="revOrgName" rows="5"
									md-select-on-focus />
								<div ng-messages="addReviewerForm.revOrgName.$error" multiple role="alert">
									<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
									<div ng-message-exp="['required', 'minlength', 'maxlength']">
										This is required and must be 100 characters only</div>
								</div>
								</md-input-container>
							
								<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Organization
										* </span> <input name="revOrgName" type="text" id="revOrgName"
										style="width: 300px !important;" class="form-control"
										placeholder="Organazation" ng-model="AddReviewer.revOrgName"
										required ng-maxlength="100" ng-pattern="/^(\D)+$/"
										data-toggle='tooltip' data-placement='right'
										title="Please enter a valid organazation name" />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revOrgName.$dirty && addReviewerForm.revOrgName.$error.required">Organization
									is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revOrgName.$dirty && addReviewerForm.revOrgName.$error.maxlength">Organization
									cannot be more than 100 characters</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revOrgName.$dirty && addReviewerForm.revOrgName.$error.pattern">Organization
									can only contain text</div> -->
							</div>

							<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">
							
							<md-input-container class="md-block"> <label>Designation</label>
								<input required ng-model="AddReviewer.revDesignation"
									md-maxlength="100" maxlength=100 name="revDesignation" rows="5"
									md-select-on-focus />
								<div ng-messages="addReviewerForm.revDesignation.$error" multiple role="alert">
									<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
									<div ng-message-exp="['required', 'minlength', 'maxlength']">
										This is required and must be 100 characters only</div>
								</div>
								</md-input-container>
								<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Designation
										*</span> <input name="revDesignation" type="text" id="revDesignation"
										style="width: 300px !important;" class="form-control"
										placeholder="Designation"
										ng-model="AddReviewer.revDesignation" required
										ng-maxlength="100" ng-pattern="/^(\D)+$/"
										data-toggle='tooltip' data-placement='right'
										title="Please enter a valid Designation name" />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revDesignation.$dirty && addReviewerForm.revDesignation.$error.required">Designation
									is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revDesignation.$dirty && addReviewerForm.revDesignation.$error.maxlength">Designation
									cannot be more than 100 characters</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revDesignation.$dirty && addReviewerForm.revDesignation.$error.pattern">Designation
									can only contain text</div> -->
							</div>


							<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">

								<md-input-container class="md-block"> <label>Specialization</label>
								<textarea required ng-model="AddReviewer.revSpeciality"
									md-maxlength="150" maxlength=150 name="revSpeciality" rows="5"
									md-select-on-focus></textarea>
								<div ng-messages="addReviewerForm.revSpeciality.$error">
									<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
									<div ng-message-exp="['required', 'minlength', 'maxlength']" multiple role="alert">
										This is required and must be 150 characters only</div>
								</div>
								</md-input-container>


								<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Specialization
										*</span>
									<textarea rows="3" cols="31" name="revSpeciality"
										id="revSpeciality" style="width: 300px !important;"
										placeholder="Specialization"
										ng-model="AddReviewer.revSpeciality" required
										ng-maxlength="100" data-toggle='tooltip'
										data-placement='right'
										title="Please enter a valid Designation name"></textarea>
									
									<textarea rows="3" cols="31" name="mentorProfile"
										id="mentorProfile" placeholder="Mentor Profile"
										ng-model="register.mentorProfile" style="resize: none;"
										data-toggle='tooltip' data-placement='right'
										title="Please enter mentor profile" ng-maxlength="1000"
										required></textarea>
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revSpeciality.$dirty && addReviewerForm.revSpeciality.$error.required">Organization
									is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revSpeciality.$dirty && addReviewerForm.revSpeciality.$error.maxlength">Organization
									cannot be more than 100 characters</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revSpeciality.$dirty && addReviewerForm.revSpeciality.$error.pattern">Organization
									can only contain text</div>
							</div> -->

								<div class="col-xs-12">&nbsp;</div>



							</div>
						</div>
						<!-- USER INFO END -->
					</div>
</div>
					<!-- PERSONAL INFO START -->
					<div class="col-xs-12 col-md-6">
						<div class="panel panel-default"
							style="border-style: none; background-color: #f5f5f5;  box-shadow: 0 0 2em #1c1f22;">
							<div class="panel-heading"
								style="border-style: none; font-family: arial; font-weight: bold;">Contact
								Information</div>
							<div class="panel-body personal-info"
								style="border-style: none; background-color: #ffffff;">

								<div class="col-xs-12">

									<md-input-container class="md-block"> <label>Mobile No.</label> <input md-maxlength="10" required name="revMobileNo"
										ng-model="AddReviewer.revMobileNo" ng-pattern="/^(\d)+$/"
										minlength=10 maxlength=10>
									<div ng-messages="addReviewerForm.revMobileNo.$error" multiple role="alert">
										<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
										<div
											ng-message-exp="['required', 'minlength', 'maxlength', 'pattern']">
											Mobile number must be 10 digits only</div>
									</div>
									</md-input-container>



									<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Mobile
										*</span> <input name="revMobileNo" type="text" id="revMobileNo"
										style="width: 300px !important;" class="form-control"
										placeholder="Mobile" ng-model="AddReviewer.revMobileNo"
										required ng-minlength=10 ng-maxlength=10
										ng-pattern="/^(\d)+$/" data-toggle='tooltip'
										data-placement='right'
										title='Mobile number should be 10 digits' />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revMobileNo.$dirty && addReviewerForm.revMobileNo.$error.required">Mobile
									number is required</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revMobileNo.$dirty && addReviewerForm.revMobileNo.$error.minlength || addReviewerForm.revMobileNo.$error.maxlength">Mobile
									number must be 10 digit long.</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revMobileNo.$dirty && addReviewerForm.revMobileNo.$error.pattern">Mobile
									number must contain only digits</div> -->

								</div>

								<div class="col-xs-12">&nbsp;</div>

								<div class="col-xs-12">

									<md-input-container class="md-block"> <label>Alternate
										No.</label> <input name="revAlternateNo"
										ng-model="AddReviewer.revAlternateNo" ng-pattern="/^(\d)+$/"
										max=15>
									<div ng-messages="addReviewerForm.revAlternateNo.$error" multiple role="alert">
										<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
										<div ng-message="pattern">Only Digits</div>
										<div ng-message="max">Maximum 15 digits allowed</div>
									</div>
									</md-input-container>


									<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Alternate
										No.</span> <input name="revAlternateNo" type="text"
										style="width: 300px !important;" class="form-control"
										placeholder="Landline (if any)"
										ng-model="AddReviewer.revAlternateNo" ng-maxlength="15"
										ng-pattern="/^(\d)+$/" />
								</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revAlternateNo.$dirty && addReviewerForm.revAlternateNo.$error.maxlength">Alternate
									No. must be less than 15 digits</div>

								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revAlternateNo.$dirty && addReviewerForm.revAlternateNo.$error.pattern">Alternate
									No. must contain only digits</div> -->

								</div>
								<!-- 	<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">
								<div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">District
										*</span> <input style="width: 300px !important;" name="district"
										type="text" id="district" class="form-control"
										placeholder="District" ng-model="AddReviewer.district"
										required ng-maxlength="100" ng-pattern="/^(\D)+$/"
										data-toggle='tooltip' data-placement='right'
										title="Please enter a valid district" />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.district.$dirty && addReviewerForm.district.$error.required">District
									is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.district.$dirty && addReviewerForm.district.$error.maxlength">District
									cannot be more than 100 characters</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.district.$dirty && addReviewerForm.district.$error.pattern">District
									can only contain text</div>
							</div> -->

								<div class="col-xs-12">&nbsp;</div>
								<div class="col-xs-12">
									<md-input-container class="md-block"> <label></label>
									<input id="state" required name="revState"
										ng-model="AddReviewer.revState">
									<div ng-messages="addReviewerForm.revState.$error" multiple role="alert">
										<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
										<div ng-message="required">This is required</div>
										<div ng-message="pattern">Only Alphabets</div>
									</div>
									</md-input-container>


									<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">State
										*</span> <input style="width: 300px !important;" name="revState"
										type="text" id="state" class="form-control"
										placeholder="State" ng-model="AddReviewer.revState" required
										ng-maxlength="100" ng-minlength="2" data-toggle='tooltip'
										data-placement='right' title="Please enter a valid State" />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revState.$dirty && addReviewerForm.revState.$error.required">State
									is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revState.$dirty && addReviewerForm.revState.$error.maxlength">State
									cannot be more than 100 characters</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revState.$dirty && addReviewerForm.revState.$error.pattern">State
									can only contain text</div> -->
								</div>

								<div class="col-xs-12">&nbsp;</div>

								<div class="col-xs-12">

									<md-input-container class="md-block"> <label></label>
									<input id="city" required name="revCity"
										ng-model="AddReviewer.revCity">
									<div ng-messages="addReviewerForm.revCity.$error" multiple role="alert">
										<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
										<div ng-message="required">This is required</div>
									</div>
									</md-input-container>



									<!-- <div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">City
										*</span>
									<select style="width: 300px !important;"  id="city" class="form-control" name="city"  ng-model="AddReviewer.city" required>
													<option value selected="selected" >select</option>
													</select>
									<input style="width: 300px !important;" name="revCity"
										type="text" id="city" class="form-control" placeholder="City"
										ng-model="AddReviewer.revCity" required ng-maxlength="100"
										data-toggle='tooltip' ng-minlength="2" data-placement='right'
										title="Please enter a valid city name" />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revCity.$dirty && addReviewerForm.revCity.$error.required">City
									is a required</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revCity.$dirty && addReviewerForm.revCity.$error.maxlength">City
									cannot be more than 100 characters</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="addReviewerForm.revCity.$dirty && addReviewerForm.revCity.$error.pattern">City
									can only contain text</div> -->

								</div>
								<div class="col-xs-12">&nbsp;</div>
								<!-- 
							<div class="col-xs-12">
								<div class="input-group input-group-sm">
									<span class="input-group-addon"
										style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Pincode
										*</span> <input style="width: 300px !important;" name="pincode"
										type="text" id="pincode" class="form-control"
										placeholder="Pincode" ng-model="AddReviewer.pincode" required
										ng-minlength="6" ng-maxlength="6" ng-pattern="/^(\d)+$/"
										data-toggle='tooltip' data-placement='right'
										title="Pincode contains only digits" />
								</div>
							</div> -->

							</div>

							<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">&nbsp;</div>
						</div>
					</div>

					<div class="col-xs-12 col-md-6">
						<!-- USER INFO START -->
						<div class="panel panel-default"
							style="border-style: none; background-color: #f5f5f5;    box-shadow: 0 0 2em #1c1f22;">
							<div class="panel-heading"
								style="border-style: none; font-family: arial; font-weight: bold;">Branch
								Information *</div>
							<div class="panel-body user-info"
								style="border-style: none; background-color: #ffffff;">

								<md-input-container class="md-block"> <label></label> <input required name="branchIdString"
									ng-model="AddReviewer.branchIdString" id="projectBranches">
								<div ng-messages="addReviewerForm.branchIdString.$error" multiple role="alert">
									<!-- <div ng-message="min">
								            You should charge at least $800 an hour. This job is a big deal... if you mess up,
								            everyone dies!
								          </div> -->
									<div ng-message="required">This is required</div>
								</div>
								</md-input-container>








								<!-- <div class="input-group input-group-sm">
								<span class="input-group-addon"
									style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Branch
									*</span>
								<input style="width: 300px !important;" type="text"
										class="form-control" placeholder="Search branches"
										ng-model="AddReviewer.branchIds" id="branchIdOfMentor2"
										value="" required data-toggle='tooltip' data-placement='right'
										title="Please enter Branch">
								<input style="width: 350px !important;" id="projectBranches"
									name="branchIdString" type="text" class="form-control"
									placeholder="Branches" ng-model="AddReviewer.branchIdString"
									required />

								 <div class="col-xs-12">
													<input type="text" class="form-control" placeholder="Search branches" id="branchIdOfStudent2"
														ng-model="searchTerm" ng-change="search()" value="" />
												</div>
									 <div class="col-xs-12" >
													<select id="branchIdOfStudent" class="form-control"
														ng-model="register.branchIdOfStudent" 
														ng-options="item.branchId as item.projBranchDesc for item in data" >
													</select>
												</div> 
							</div>
							<div class="alert alert-sm alert-danger alert-dismissible"
								role="alert"
								ng-show="addReviewerForm.branchIdString.$dirty && addReviewerForm.branchIdString.$error.required">Branch
								is required</div> -->




							</div>
						</div>
					</div>

					<div class="col-xs-12 col-md-12 col-xs-offset-5 col-md-offset-5">
						<button type="button" class="btn btn-primary reg-ctn-1"
							style="background-color: #5cb85c;" ng-click="registerReviewer()"
							data-toggle="modal" data-target="#addReviwerAlertModal"
							data-backdrop="static" data-keyboard="false"
							ng-disabled="addReviewerForm.$invalid">
							<i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp;Add
							Reviewer
						</button>
					</div>
			</form>
		</div>
		<div class=" col-xs-12 clearfix">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="clearfix col-xs-12">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="modal fade" data-easein="perspectiveDownIn"
			id="addReviwerAlertModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Add New Reviewer</h4>

					</div>
					<div class="modal-body"
						ng-hide="messageWarning.length>0 || messageSuccess.length>0 || message.length>0">

						<div class="loaderBody"
							ng-hide="messageWarning.length>0 || messageSuccess.length>0 || message.length>0">Please
							sit back and relax while we are adding new reviewer for you...</div>

					</div>




					<div class="modal-body" ng-show="messageSuccess.length>0"
						style="text-align: center;">
						<div>
							<i id="effect" class="fa fa-check-circle-o"
								style="color: green; font-size: 7em;"></i>
						</div>

						<div
							class="col-xs-12 xol-md-12 alert alert-success alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert" ng-repeat="msgSuccess in messageSuccess">

							<p>{{msgSuccess}}</p>
							<p>An email has been sent to {{ReviewerEmail}}</p>
						</div>


					</div>

					<div class="modal-body" ng-show="messageWarning.length>0"
						style="text-align: center;">
						<div>
							<i id="effect" class="fa fa-check-circle-o"
								style="color: #8a6d3b; font-size: 7em;"></i>
						</div>

						<div
							class="col-xs-12 xol-md-12 alert alert-warning alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert" ng-repeat="msgWarning in messageWarning">

							<p>{{msgWarning}}</p>
							<p>to :: {{ReviewerEmail}}</p>
						</div>
					</div>
					<div class="modal-body" style="text-align: center;"
						ng-show="message.length>0">
						<div style="text-align: center;">
							<i class="fa fa-exclamation-triangle"
								style="color: #E84F63; font-size: 50px; text-align: center;"></i>
						</div>
						<div
							class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							ng-repeat="msg in message">{{msg}}</div>


					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button data-dismiss="modal" type="button" class="btn btn-info"
							onclick="ExitToReviewDashBoard()">Exit</button>
					</div>
				</div>
			</div>
		</div>

      <div class="clearfix col-xs-12">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	</div>
	<script src="js/jquery-ui.js"></script>
	<!-- <script src="https://code.jquery.com/ui/1.12.0-rc.2/jquery-ui.js"
		integrity="sha256-6HSLgn6Ao3PKc5ci8rwZfb//5QUu3ge2/Sw9KfLuvr8="
		crossorigin="anonymous"></script> -->
	<!-- <script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/select2.min.js"></script> -->
	<script src="js/select2.min.js"></script>
	<script src="js/script.min.js"></script>
	<script type="text/javascript">
		$(".loaderBody").load(function() {
			$(".loaderBody").fadeOut("slow");
		})
	</script>
</body>
<%
	} else {
%>
<div id="mainPanelBody" class="col-xs-10 col-md-10">
	<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
		style="text-align: center; margin-top: 150px;">
		<h2>Sorry, Unauthorized access...!!</h2>
		<i style="color: red" class="fa fa-ban fa-5x" aria-hidden="true"></i>
	</div>
</div>
<%
	}
%>
</html>
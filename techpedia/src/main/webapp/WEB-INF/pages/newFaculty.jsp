<%@ page import="java.util.Random"%>
<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
<style>
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
}

.input-group-addon, .input-group-btn {
	width: 200px !important;
	width: 130px !important;
}

.input-group-addon, .input-group-btn, .input-group .form-control {
	display: table-cell;
	width: 100%;
}

.row {
	margin-right: -1px;
	margin-left: -1px;
}

.ui-icon {
	background-color: white;
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
</style>
<div class="clearfix"></div>
<div class="container customFont borderRadius style"
	ng-controller="NewTeamMemberController" ng-init="initialEditProfileData()">
	<div class="page-container">
		<div class="page-sidebar-wrapper"></div>
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-11">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							<%
								String typeofuser = (String) request.getParameter("usertype");
							%>
							<i class="fa fa-book" id="icon-size"></i>&nbsp;<span
								style="text-transform: capitalize; font-family: arial; font-weight: bold;">Register
								- {{edit.userType}}</span>
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li style="color: #262626 !important"><a
								style="color: #262626 !important" href="./">&nbsp;Home</a> <font
								style="color: black; font-size: 18px;">&raquo;</font></li>
							<li style="color: #262626 !important">Register</li>


						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>

				<!-- END PAGE HEADER-->

				<div class="row">
					<div class="alert alert-sm alert-danger alert-dismissible"
						role="alert" ng-show="registerBasicForm|anyInvalidDirtyFields">Please
						verify red marked fields as they are mandatory fields</div>
					<div class="alert alert-sm alert-danger alert-dismissible"
						role="alert"
						ng-show="registerAdditionalStudentForm|anyInvalidDirtyFields">Please
						verify red marked fields as they are mandatory fields</div>
					<div class="alert alert-sm alert-danger alert-dismissible"
						role="alert"
						ng-show="registerAdditionalCollegeForm|anyInvalidDirtyFields">Please
						verify red marked fields as they are mandatory fields</div>
					<div class="alert alert-sm alert-danger alert-dismissible"
						role="alert"
						ng-show="registerAdditionalFacultyForm|anyInvalidDirtyFields">Please
						verify red marked fields as they are mandatory fields</div>
					<div class="alert alert-sm alert-danger alert-dismissible"
						role="alert"
						ng-show="registerAdditionalMentorForm|anyInvalidDirtyFields">Please
						verify red marked fields as they are mandatory fields</div>
				</div>
				<div class="row">
					<div class="alert alert-sm alert-info alert-dismissible"
						role="alert" ng-show="registerBasicForm|anyEmptyFields">Please
						fill ' * ' marked fields to proceed to next step</div>
				</div>
				<div class="clearfix"></div>
				<div class="row">
					<div id="accordion" class=" accordion col-xs-12">
						<h3 class="reg-acc-1 acc-hover"
							style="background-color: #217690; font-family: arial; color: black;font-weight: bold;">General
							Information</h3>
						<div>
							<p>
							<div class="accordion-group">
								<form class="form-horizontal" id="registerBasicForm"
									name="registerBasicForm" method="post" novalidate>
									<div class="col-xs-12 col-md-6">
										<div class="panel panel-default"
											style="border-style: none; background-color: #f5f5f5">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">Login
												Information</div>
											<div class="panel-body user-info"
												style="border-style: none; background-color: #f5f5f5;">
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 50px !important; font-family: arial; color: #ffffff;"><i
															class="fa fa-envelope"></i></span> <input name="email"
															type="email" id="email" style="width: 375px !important;"
															maxlength=100 class="form-control remail email-input"
															placeholder="Email" ng-model="edit.email" required
															data-toggle='tooltip' data-placement='right'
															title="Please enter valid email as a@a.com" />
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.email.$dirty && registerBasicForm.email.$error.required">Email
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.email.$dirty && registerBasicForm.email.$error.email">Email
													is not valid</div>  -->

												</div>


												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 50px !important; font-family: arial; color: #ffffff;"><i
															class="fa fa-lock"></i></span> <input name="password"
															type="password" id="userPassword1"
															style="width: 375px !important;" class="form-control"
															placeholder="Password" ng-model="edit.password"
															required ng-model="edit.confirmPassword" required
															ng-minlength="6" ng-blur="showError()"
															ng-focus="hideError()" ng-maxlength="16"
															ng-pattern="/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%&^*-+ = /| < >{}]).{6,}$/"
															password-match="edit.password" data-toggle='tooltip'
															data-placement='right'
															title='Password should contain a minimum of 6 and a maximun of 16 characters with atleast one numeric value and one special character excluding (,.[]_\-)' />
													</div>

													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.required">Password
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.minlength">Password
													must be more than 6 characters long</div>-->
													<div id="pwdError"
														class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.pattern">Password
														should contain a minimum of 6 and a maximun of 16
														characters with atleast one numeric value and one special
														character excluding (,.[]_\-)</div>


												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 50px !important; font-family: arial; color: #ffffff;"><i
															class="fa fa-lock"></i></span> <input name="confirmPassword"
															style="width: 375px !important;" type="password"
															class="form-control" placeholder="Confirm password"
															id="confirmPassword" ng-model="edit.confirmPassword"
															required ng-minlength="6" ng-maxlength="16"
															ng-pattern="/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%&^*+ = /| < >{}]).{6,}$/"
															password-match="edit.password" data-toggle='tooltip'
															data-placement='right'
															title='Password & Confirm password should be same ' />
													</div>

													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.confirmPassword.$dirty && registerBasicForm.confirmPassword.$error.required">Password
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.confirmPassword.$dirty && registerBasicForm.confirmPassword.$error.minlength">Password
													must be more than 6 characters long</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.confirmPassword.$dirty && registerBasicForm.confirmPassword.$error.maxlength">Password
													must be less than 16 characters long</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.confirmPassword.$dirty && registerBasicForm.confirmPassword.$error.pwmatch">Passwords
													do not match</div> -->
													<!-- 				<div class="alert alert-sm alert-danger alert-dismissible" role="alert" 
													ng-show="registerBasicForm.confirmPassword.$dirty && registerBasicForm.confirmPassword.$error.passwordVerify">
        Fields are not equal!</div> -->
												</div>

											</div>
										</div>

									</div>

									<div class="col-xs-12 col-md-6">
										<div class="panel panel-default"
											style="border-style: none; background-color: #f5f5f5;">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">
										 	<div class="btn-group" ng-hide="edit.userType=='college'">Photograph</div> 
												<div class="btn-group" ng-show="edit.userType=='college'">College Logo</div>
											</div>
											<div class="panel-body photoRTC">
												<input ng-model="edit.photo" type="text" name="photo"
													id="photoByte64" style="display: none;" /> <input
													type="text" name="photo" id="photoByte64Size"
													style="display: none;" />
												<canvas class='canvas' width='160' height='120'
													style='display: none;'></canvas>
												<div class="col-xs-12">
													<div class="col-xs-3">
														<!-- <video class='live' width='160' height='120' autoplay></video> -->
														<img width=160 height=130 src='images/gravatar.png'
															class='photo' alt='photo'>
													</div>

													<div class="col-xs-9">
														<div class="col-xs-12">
															<!-- <button class='takePhoto btn btn-info btn-sm'>Take photo</button>
														<button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
															photo</button> -->
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

									</div>
									<div class="col-xs-12 col-md-6">
										<!-- USER INFO START -->
										<div class="panel panel-default"
											style="border-style: none; background-color: #f5f5f5">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">User
												Information</div>
											<div class="panel-body user-info"
												style="border-style: none; background-color: #f5f5f5;">
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Username
															*</span> <input name="userName" type="text" id="userName"
															style="width: 300px !important;" class="form-control"
															placeholder="Username" ng-model="edit.userName"
															required ng-maxlength="50" data-toggle='tooltip'
															data-placement='right' title='Please enter Username' />
													</div>

													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.userName.$dirty && registerBasicForm.userName.$error.required">User
													name is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.userName.$dirty && registerBasicForm.userName.$error.maxlength">User
													name cannot be more than 40 characters</div> -->

												</div>

												<div class="col-xs-12">&nbsp;</div>
												
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Email ID</span> <input name="email1"
															type="email" id="email1" style="width: 300px !important;"
															maxlength=100 class="form-control remail email-input"
															placeholder="Email" ng-model="edit.email" readonly
															data-toggle='tooltip' data-placement='right'
															title="Please enter valid email as a@a.com" />
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.email.$dirty && registerBasicForm.email.$error.required">Email
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.email.$dirty && registerBasicForm.email.$error.email">Email
													is not valid</div> -->

												</div>
												
												<div class="col-xs-12">&nbsp;</div>
												

												<div class="col-xs-12">
													<div class="input-group input-group-sm ">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">
															First name *</span> <input name="firstName" type="text"
															id="firstName" style="width: 300px !important;"
															class="form-control rname my-tooltip"
															placeholder="First name" ng-model="edit.firstName"
															required ng-maxlength="50" ng-pattern="/^(\D)+$/"
															data-toggle='tooltip' data-placement='right'
															title='Please enter firstname without special characters' />

													</div>

													<!--  <div class="input-group input-group-sm" ng-class="{ 'has-error' : registerBasicForm.firstName.$invalid && !registerBasicForm.firstName.$pristine }">									 
			
        <span class="input-group-addon">First name *</span>
        <input type="text" name="firstName" class="form-control" ng-model="user.name" required  data-toggle="tooltip" data-original-title="Default tooltip">
       
    </div> 
     <p ng-show="registerBasicForm.firstName.$invalid && !registerBasicForm.firstName.$pristine"  data-toggle="tooltip" data-original-title="Default tooltip">  -->

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.required">First
													name is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.maxlength">First
													name cannot be more than 50 characters</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.pattern">Name
													can only contain text</div>  
												</div>









												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Middle
															name </span> <input name="midName" type="text"
															style="width: 300px !important;"
															class="form-control rname"
															placeholder="Middle name (Optional)"
															ng-model="edit.midName" ng-maxlength="30"
															ng-pattern="/^(\D)+$/" />
													</div>

													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.midName.$dirty && registerBasicForm.midName.$error.maxlength">Mid
													name cannot be more than 30 characters</div>-->

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.midName.$dirty && registerBasicForm.midName.$error.pattern">Name
													can only contain text</div> 
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.midName.$dirty && registerBasicForm.midName.$error.maxlength">Last
													name cannot be more than 50 characters</div>

												</div>
												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Last
															name </span> <input name="lastName" type="text" id="lastName"
															style="width: 300px !important;"
															class="form-control rname" placeholder="Last name (Optional)"
															ng-model="edit.lastName" ng-maxlength="50"
															ng-pattern="/^(\D)+$/" data-toggle='tooltip'
															data-placement='right'
															title='Please enter lastname without special characters' />
													</div>

													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.required">Last
													name is required</div>-->
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.maxlength">Last
													name cannot be more than 50 characters</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.pattern">Name
													can only contain text</div> 
												</div>

												<div class="col-xs-12">&nbsp;</div>
												
													<div class="col-xs-12">

													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Gender *</span>
														<div class="form-group" style="margin-left: 10px;">

															
																<label class="radio-inline"> <input type="radio"
																	name="genderMale" id="gender" value="male" ng-model="edit.gender" required>Male
																</label> <label class="radio-inline"> <input
																	type="radio" name="genderFemale" id="gender" ng-model="edit.gender"  value="female">Female
																</label>
																<label class="radio-inline"> <input
																	type="radio" name="genderTrans" id="gender" ng-model="edit.gender"  value="trans">Trans
																</label>
															
														</div>
													</div>
												</div>
											<div class="col-xs-12">&nbsp;</div>
												
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Landline</span>
														<input name="homePhoneNo" type="text"
															style="width: 300px !important;" class="form-control"
															placeholder="Landline (if any)"
															ng-model="edit.homePhoneNo" ng-maxlength="15"
															ng-pattern="/^(\d)+$/" />
													</div>

													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.homePhoneNo.$dirty && registerBasicForm.homePhoneNo.$error.maxlength">Landline
													number must be less than 15 digits</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.homePhoneNo.$dirty && registerBasicForm.homePhoneNo.$error.pattern">Landline
													number must contain only digits</div> -->

												</div>
											<div class="col-xs-12">&nbsp;</div>
											
										<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Age*</span>
													<input name="age" type="text" id="age" style="width: 300px"
														class="form-control" placeholder="Age" required
														ng-model="edit.age" ng-value="personAge"
														ng-minlength=2 ng-maxlength=2 ng-pattern="/^(\d)+$/"
														data-toggle='tooltip' data-placement='right'
														title='Age should be in number only' />

												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerBasicForm.age.$dirty && registerBasicForm.age.$error.maxlength && registerBasicForm.age.$error.minlength">age should be of only two digit number</div>

												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerBasicForm.age.$dirty && registerBasicForm.age.$error.pattern">Age should be number only</div>
											</div>
											
											<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">

													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Mobile
															</span> <input name="mobile" type="text" id="mobile"
															style="width: 300px !important;" class="form-control"
															placeholder="Mobile" ng-model="edit.mobile" 
															ng-minlength=10 ng-maxlength=10 ng-pattern="/^(\d)+$/"
															data-toggle='tooltip' data-placement='right'
															title='Mobile number should be 10 digits' />
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.mobile.$dirty && registerBasicForm.mobile.$error.required">Mobile
													number is required</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.mobile.$dirty && registerBasicForm.mobile.$error.minlength || registerBasicForm.mobile.$error.maxlength">Mobile
													number must be 10 digit long.</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.mobile.$dirty && registerBasicForm.mobile.$error.pattern">Mobile
													number must contain only digits</div> -->

												</div>
											
												

												<!-- <div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Country
															*</span> <input name="country" type="text" id="country"
															style="width: 300px !important;" class="form-control"
															placeholder="Country" ng-model="edit.country"
															required ng-maxlength="100" ng-pattern="/^(\D)+$/"
															data-toggle='tooltip' data-placement='right'
															title="Please enter a valid Country name" />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.country.$dirty && registerBasicForm.country.$error.required">Country
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.country.$dirty && registerBasicForm.country.$error.maxlength">Country
													cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.country.$dirty && registerBasicForm.country.$error.pattern">Country
													can only contain text</div>
												</div> -->
											</div>
										</div>
										<!-- USER INFO END -->
									</div>

									<!-- PERSONAL INFO START -->
									<div class="col-xs-12 col-md-6">
										<div class="panel panel-default"
											style="border-style: none; background-color: #f5f5f5;">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">Contact
												Information</div>
											<div class="panel-body personal-info"
												style="border-style: none; background-color: #f5f5f5;">

												<div class="col-xs-12">

													<div class="input-group input-group-sm">
														<label style="font-weight:500;">Do you want to display your number on your
															profile?</label>
														<div class="form-group">

															<div class="col-sm-8">
																<label class="radio-inline"> <input type="radio"
																	name="mobileYesNo" id="mobileYesNo" value="Y" ng-model="edit.isMobile">Yes
																</label> <label class="radio-inline"> <input
																	type="radio" name="mobileYesNo" id="mobileYesNo" ng-model="edit.isMobile" ng-checked="true" value="N">No
																</label>
															</div>
														</div>
													</div>
												</div>
												
												
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Country
															*</span> <input name="country" type="text" id="country"
															style="width: 300px !important;" class="form-control"
															placeholder="Country" ng-model="edit.country"
															required ng-maxlength="100" ng-pattern="/^(\D)+$/"
															data-toggle='tooltip' data-placement='right'
															title="Please enter a valid Country name" />
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.country.$dirty && registerBasicForm.country.$error.required">Country
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.country.$dirty && registerBasicForm.country.$error.maxlength">Country
													cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.country.$dirty && registerBasicForm.country.$error.pattern">Country
													can only contain text</div> -->
												</div>
												
												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Address
															*</span> <input name="addrLn1" type="text" id="addrLn1"
															class="form-control" placeholder="Line 1(required)"
															ng-model="edit.addrLn1" required ng-max-length="100"
															data-toggle='tooltip' data-placement='right'
															title='Please enter address' />

														<div class="col-xs-12">&nbsp;</div>

														<input name="addrLn2" type="text" class="form-control"
															ng-model="edit.addrLn2" ng-max-length="100"
															placeholder="Line 2(optional)" />
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.addrLn1.$dirty && registerBasicForm.addrLn1.$error.required">Line
													1 is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.addrLn1.$dirty && registerBasicForm.addrLn1.$error.maxlength">Line
													1 cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.addrLn2.$dirty && registerBasicForm.addrLn2.$error.maxlength">Line
													2 cannot be more than 100 characters</div> -->

												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">District
															*</span> <input style="width: 300px !important;" name="district"
															type="text" id="district" class="form-control"
															placeholder="District" ng-model="edit.district"
															required ng-maxlength="100" ng-pattern="/^(\D)+$/"
															data-toggle='tooltip' data-placement='right'
															title="Please enter a valid district" />
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.district.$dirty && registerBasicForm.district.$error.required">District
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.district.$dirty && registerBasicForm.district.$error.maxlength">District
													cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.district.$dirty && registerBasicForm.district.$error.pattern">District
													can only contain text</div> -->
												</div>



												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">State
															*</span>
														<!-- <select style="width: 300px !important;"  id="state" name="state" class="form-control" onChange="populate(this.id,'city')" ng-model="edit.state" required>
														<option value selected="selected">select</option>
														<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
														<option value="Andhra Pradesh">Andhra Pradesh</option>
														<option value="Arunachal Pradesh">Arunachal Pradesh</option>
														<option value="Assam">Assam</option>
														<option value="Bihar">Bihar</option>
														<option value="Chandigarh">Chandigarh</option>
														<option value="Chhattisgarh">Chhattisgarh</option>
														<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
														<option value="Daman and Diu">Daman and Diu</option>
														<option value="National Capital Territory of Delhi">National Capital Territory of Delhi</option>
														<option value="Goa">Goa</option>
														<option value="Gujarat">Gujarat</option>
														<option value="Haryana">Haryana</option>
														<option value="Himachal Pradesh">Himachal Pradesh</option>
														<option value="Jammu and Kashmir">Jammu and Kashmir</option>
														<option value="Jharkhand">Jharkhand</option>
														<option value="Karnataka">Karnataka</option>
														<option value="Kerala">Kerala</option>
														<option value="Lakshadweep">Lakshadweep</option>
														<option value="Madhya Pradesh">Madhya Pradesh</option>
														<option value="Maharashtra">Maharashtra</option>
														<option value="Manipur">Manipur</option>
														<option value="Meghalaya">Meghalaya</option>
														<option value="Mizoram">Mizoram</option>
														<option value="Nagaland">Nagaland</option>
														<option value="Odisha">Odisha</option>
														<option value="Puducherry">Puducherry</option>
														<option value="Punjab">Punjab</option>
														<option value="Rajasthan">Rajasthan</option>
														<option value="Sikkim">Sikkim</option>
														<option value="Tamil Nadu">Tamil Nadu</option>
														<option value="Telangana">Telangana</option>
														<option value="Tripura">Tripura</option>
														<option value="Uttar Pradesh">Uttar Pradesh</option>
														<option value="Uttarakhand">Uttarakhand</option>
														<option value="West Bengal">West Bengal</option>
													</select> -->




														<input style="width: 300px !important;" name="state"
															type="text" id="state" class="form-control"
															placeholder="State" ng-model="edit.state" required
															ng-maxlength="100" data-toggle='tooltip'
															data-placement='right' title="Please enter a valid State" />
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.state.$dirty && registerBasicForm.state.$error.required">State
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.state.$dirty && registerBasicForm.state.$error.maxlength">State
													cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.state.$dirty && registerBasicForm.state.$error.pattern">State
													can only contain text</div> -->
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">City
															*</span>
														<!-- <select style="width: 300px !important;"  id="city" class="form-control" name="city"  ng-model="edit.city" required>
													<option value selected="selected" >select</option>
													</select> -->
														<input style="width: 300px !important;" name="city"
															type="text" id="city" class="form-control"
															placeholder="City" ng-model="edit.city" required
															ng-maxlength="100" data-toggle='tooltip'
															data-placement='right'
															title="Please enter a valid city name" />
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.city.$dirty && registerBasicForm.city.$error.required">City
													is a required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.city.$dirty && registerBasicForm.city.$error.maxlength">City
													cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.city.$dirty && registerBasicForm.city.$error.pattern">City
													can only contain text</div> -->

												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Pincode
															*</span> <input style="width: 300px !important;" name="pincode"
															type="text" id="pincode" class="form-control"
															placeholder="Pincode" ng-model="edit.pincode"
															required ng-minlength="6" ng-maxlength="6"
															ng-pattern="/^(\d)+$/" data-toggle='tooltip'
															data-placement='right'
															title="Pincode contains only digits" />
													</div>

													<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.pincode.$dirty && registerBasicForm.pincode.$error.required">Pincode
													is required</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.pincode.$dirty && registerBasicForm.pincode.$error.minlength || registerBasicForm.pincode.$error.maxlength">Pincode
													number must be 6 digit long</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.pincode.$dirty && registerBasicForm.pincode.$error.pattern">Pincode
													can only contain digits</div> -->

												</div>
											</div>
										</div>
									</div>


									<div class="col-xs-12">
										<!-- 									
<a href="#" class="btn btn-primary reg-ctn-1" onclick="checkEmpty()"><span
										style="color: white;">Continue</span></a> -->
										<a href="#"><input type="submit"
											class="btn btn-primary reg-ctn-1"
											style="margin-left: 91%; background-color: #5cb85c;"
											onclick="checkEmpty()" value="Continue"></a>
									</div>
								</form>
							</div>
						</div>

						<h3 class="reg-acc-2 acc-hover"
							ng-class="registerBasicForm.$invalid?'ui-state-disabled':'ui-state-default'"
							style="background-color: #217690; font-family: arial; color: black;font-weight: bold;">Additional
							Information</h3>
						<div>

							<form id="rfegisterAdditionalStudentForm"
								name="registerAdditionalStudentForm" method="post" novalidate>

								<div class="dynamic-div" id="student"
									ng-show="edit.userType=='student'">
									<div class="panel panel-default">
										<!-- <div id="profession" class="panel-heading">Student</div> -->
										<input name="userType1" id="userType1" type="hidden"
											style="display: none;" value="<%=typeofuser%>">
										<div class="panel-body"
											style="border-style: none; background-color: #f5f5f5;">
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Degree
														*</span> <input id="studentdegree" maxlength=100
														style="width: 300px !important;" name="degreeOfStudent"
														type="text" class="form-control" placeholder="Degree"
														ng-model="edit.degreeOfStudent" required
														ng-maxlength="100" ng-pattern="/^(\D)+$/" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter valid degree" />
														<input style="width: 188px !important;display:none;" class="form-control" required ng-model="edit.degreeOfStudent" id="studentdegree1"
														 />
														
														 <span
															class="input-group-addon btn-success btn-responsive"
															style="border-left: 1px solid #ccc; width: 10px;"  ng-click="enterDegree();"
															>Other</span>
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.degreeOfStudent.$dirty && registerAdditionalStudentForm.degreeOfStudent.$error.required">Degree
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.degreeOfStudent.$dirty && registerAdditionalStudentForm.degreeOfStudent.$error.maxlength">Degree
												max length is 100</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.degreeOfStudent.$dirty && registerAdditionalStudentForm.degreeOfStudent.$error.pattern">Degree
												can only contain text</div> -->
											</div>

											<!-- <div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Date
														of birth</span> <input id="dateOfBirthDatePicker"
														style="width: 300px !important;" name="dob" type="text"
														class="form-control"
														placeholder="Date of birth(YYYY-MM-DD)"
														ng-model="edit.dob" datepicker-angular 
														style="width: 217px;"  data-toggle='tooltip'
														data-placement='right' title="Please enter date of Birth" />
													<span class="input-group-addon">YYYY-MM-DD</span>

													<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerAdditionalStudentForm.dob.$dirty && registerAdditionalStudentForm.dob.$error.required">DOB
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerAdditionalStudentForm.dob.$dirty && registerAdditionalStudentForm.dob.$error.date">Not
													a valid date</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerAdditionalStudentForm.dob.$dirty && registerAdditionalStudentForm.dob.$error.minlength || registerAdditionalStudentForm.dob.$error.maxlength">Improper
													date format</div>
												</div>
											</div> -->

											

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Student
														ID *</span> <input name="studentID" type="text" id="studentID"
														style="width: 300px !important;" class="form-control"
														placeholder="Student ID" ng-model="edit.studentID"
														required data-toggle='tooltip' data-placement='right'
														title="Please enter valid ID" />
												</div>
												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.studentID.$dirty && registerAdditionalStudentForm.studentID.$error.required">Student
												ID is required</div> -->
											</div>

										<!-- 	<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Age*</span>
													<input name="age" type="text" id="age" style="width: 300px"
														class="form-control" placeholder="Age" required
														ng-model="edit.age" ng-value="personAge"
														ng-minlength=2 ng-maxlength=2 ng-pattern="/^(\d)+$/"
														data-toggle='tooltip' data-placement='right'
														title='Age should be in number only' />

												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalStudentForm.age.$dirty && registerAdditionalStudentForm.age.$error.maxlength && registerAdditionalStudentForm.age.$error.minlength">age should be of only two digit number</div>

												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalStudentForm.age.$dirty && registerAdditionalStudentForm.age.$error.pattern">Age should be number only</div>
											</div> -->



											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Branch
														*</span> <input style="width: 300px !important;" type="text"
														class="form-control" placeholder="Search branches"
														ng-model="edit.branchIdOfStudent"
														id="branchIdOfStudent2" value="" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter Branch">

													<!--  <div class="col-xs-12">
													<input type="text" class="form-control" placeholder="Search branches" id="branchIdOfStudent2"
														ng-model="searchTerm" ng-change="search()" value="" />
												</div> -->
													<!-- 	 <div class="col-xs-12" >
													<select id="branchIdOfStudent" class="form-control"
														ng-model="edit.branchIdOfStudent" 
														ng-options="item.branchId as item.projBranchDesc for item in data" >
													</select>
												</div>  -->
												</div>
											</div>
											
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">University
														*</span> <input style="width: 300px !important;"
														name="university" type="text" id="university"
														class="form-control" placeholder="University"
														ng-model="edit.university" required ng-maxlength="100"
														ng-pattern="/^(\D)+$/" data-toggle='tooltip'
														data-placement='right' title="Please enter  University" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.university.$dirty && registerAdditionalStudentForm.university.$error.required">University
												is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.university.$dirty && registerAdditionalStudentForm.university.$error.maxlength">University
												cannot be more than 100 characters</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.university.$dirty && registerAdditionalStudentForm.university.$error.pattern">University
												can only contain text</div> -->
											</div>
											
												<div class="col-xs-12">&nbsp;</div>
											
											

											
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">State
														*</span> <input style="width: 300px !important;"
														name="collegeState" type="text" id="collegeState"
														class="form-control collegeState" placeholder="State"
														ng-model="edit.collegeState" required
														ng-maxlength="100" data-toggle='tooltip'
														data-placement='right' title="Please enter a valid State" />
												</div>

											</div>
											
											


											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">College
														name *</span>
													<!--  <input id="CollegeNames"
													name="collge" type="text" class="form-control" placeholder="College name"
													ng-model="edit.collge" required ng-maxlength="100" ng-pattern="/^(\D)+$/"
													
													required data-toggle='tooltip' data-placement='right' 
														title="Please enter College Name" /> -->
													<input style="width: 300px !important;" type="text"
														class="form-control CollegeNames"
														placeholder="Search Colleges" id="CollegeNames"
														ng-model="edit.collge" value="" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter your college name">
												</div>


												<!--   <div class="col-xs-12"> 
													<input type="text" class="form-control" placeholder="Search branches" id="branchIdOfStudent2"
														ng-model="edit.branchIdOfStudent" ng-change="search()" value=""  required data-toggle='tooltip' data-placement='right' 
														title="Please enter Branch"/>
												</div>
                                                 -->

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.collge.$dirty && registerAdditionalStudentForm.collge.$error.required">College
												is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.collge.$dirty && registerAdditionalStudentForm.collge.$error.maxlength">College
												cannot be more than 100 characters</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.collge.$dirty && registerAdditionalStudentForm.collge.$error.pattern">College
												can only contain text</div> -->
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Completion
														Year *</span> <input id="studentCompletionYear"
														name="completionYear" type="text" class="form-control"
														style="width: 300px !important;"
														placeholder="Completion year(YYYY-MM-DD)"
														ng-model="edit.completionYear" datepicker-angular
														required style="width: 217px;" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter degree completion year" />
													<!-- <span
													class="input-group-addon" >YYYY-MM-DD</span> -->
												</div>
												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.completionYear.$dirty && registerAdditionalStudentForm.completionYear.$error.required">Student
												ID is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.completionYear.$dirty && registerAdditionalStudentForm.completionYear.$error.required">Improper
												date format</div> -->
											</div>
											


											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Facebook
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="Facebook Id"
														ng-model="edit.faceBookId" id="facebookId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter Facebook Id" http-prefixfb>

												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

								


											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Twitter
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="Twitter Id"
														ng-model="edit.twitterId" id="twitterId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter Twitter Id" http-prefixtwit>

												</div>
											</div>

											




											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">LinkedIn
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="LinkedIn Id"
														ng-model="edit.linkedinId" id="LinkedInId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter LinkedIn Id" http-prefixlink>

												</div>
											</div>

										</div>
									</div>
								</div>
							</form>

							<form id="registerAdditionalCollegeForm"
								name="registerAdditionalCollegeForm" method="post" novalidate>
								<input name="userType1" id="userType1" type="hidden"
									style="display: none;" value="<%=typeofuser%>">
								<div class="dynamic-div" id="college"
									ng-show="edit.userType=='college'">
									<div class="panel panel-default">
										<!-- <div id="profession" class="panel-heading">College</div> -->
										<div class="panel-body">
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;"
														class="input-group-addon">Contact Person Name *</span> <input
														style="width: 300px !important;"
														name="cntctPerNameofCollege" id="collegecontactname"
														type="text" class="form-control"
														placeholder="Contact Person Name"
														ng-model="edit.cntctPerNameofCollege" required
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter Contact Person Name" />
												</div>



												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.collegeName.$dirty && registerAdditionalCollegeForm.collegeName.$error.required">College
												name is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.collegeName.$dirty && registerAdditionalCollegeForm.collegeName.$error.pattern">College
												name can only contain text</div> -->
											</div>



											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;"
														class="input-group-addon">Contact Person email *</span> <input
														id="collgeContactEmail" style="width: 300px !important;"
														name="collgeContactEmail" maxlength=100 type="email"
														class="form-control" placeholder="Contact person email id"
														ng-model="edit.collgeContactEmail" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter Contact person Email" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.collgeContactEmail.$dirty && registerAdditionalCollegeForm.collgeContactEmail.$error.required">Contact person
												email is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.collgeContactEmail.$dirty && registerAdditionalCollegeForm.collgeContactEmail.$error.email">Not
												a valid email</div> -->
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">Principal name *</span> <input
														style="width: 300px !important;" name="prinicipalName"
														id="prinicipalName" type="text" class="form-control"
														placeholder="Principal name"
														ng-model="edit.prinicipalName" required
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter Principal Name of college" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalName.$dirty && registerAdditionalCollegeForm.prinicipalName.$error.required">College
												name is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalName.$dirty && registerAdditionalCollegeForm.prinicipalName.$error.pattern">College
												name can only contain text</div> -->
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">Principal email *</span> <input
														id="prinicipalEmail" style="width: 300px !important;"
														name="prinicipalEmail" maxlength=100 type="email"
														class="form-control" placeholder="Principal email id"
														ng-model="edit.prinicipalEmail" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter Principal Email" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalEmail.$dirty && registerAdditionalCollegeForm.prinicipalEmail.$error.required">Principal
												email is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalEmail.$dirty && registerAdditionalCollegeForm.prinicipalEmail.$error.email">Not
												a valid email</div> -->
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">University *</span> <input
														style="width: 300px !important;"
														name="affltUniversityOfCollege"
														id="affltUniversityOfCollege" type="text"
														class="form-control" placeholder="University name"
														ng-model="edit.affltUniversityOfCollege" required
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter University of college" />

												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.affltUniversityOfCollege.$dirty && registerAdditionalCollegeForm.affltUniversityOfCollege.$error.required">University
												name is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.affltUniversityOfCollege.$dirty && registerAdditionalCollegeForm.affltUniversityOfCollege.$error.pattern">University
												name can only contain text</div> -->
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">Techpedia faculty *</span> <input
														id="techpdaFactlyCoordtr" maxlength=100
														style="width: 300px !important;"
														name="techpdaFactlyCoordtr" type="text"
														class="form-control"
														placeholder="Techpedia faculty co-ordinator"
														ng-model="edit.techpdaFactlyCoordtr" required
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter Techpedia registered Faculty of college" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.techpdaFactlyCoordtr.$dirty && registerAdditionalCollegeForm.techpdaFactlyCoordtr.$error.required">Faculty
												co-ordinator name is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.techpdaFactlyCoordtr.$dirty && registerAdditionalCollegeForm.techpdaFactlyCoordtr.$error.pattern">Faculty
												co-ordinator name can only contain text</div> -->
											</div>

											<div class="col-xs-12">&nbsp;</div>



											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">Website link *</span> <input
														style="width: 300px !important;" name="webpage"
														id="webpage" type="url" class="form-control"
														placeholder="College url" ng-model="edit.webpage"
														required data-toggle='tooltip' data-placement='right'
														title="Please enter Website link of college" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.webpage.$dirty && registerAdditionalCollegeForm.webpage.$error.required">Please
												enter a valid URL</div> -->
											</div>



											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">Facility offered *</span> <input
														style="width: 300px !important;"
														name="facilitiesOffrdToStudents"
														id="facilitiesOffrdToStudents" type="text"
														class="form-control"
														placeholder="Facility offered to students"
														ng-model="edit.facilitiesOffrdToStudents" required
														required data-toggle='tooltip' data-placement='right'
														title="Please enter Facility offered to students" />
												</div>
											</div>
											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">Innovation club *</span> <input
														id="cntctInfoForNatnlInnovnClub" maxlength=100
														style="width: 300px !important;"
														name="cntctInfoForNatnlInnovnClub" type="text"
														class="form-control"
														placeholder="Innovation club contact info"
														ng-model="edit.cntctInfoForNatnlInnovnClub" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter innovation club contact information" />
												</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">College Name*</span> <input
														id="CollegeNames1" style="width: 300px !important;"
														name="CollegeNames1" type="text"
														class="form-control CollegeNames"
														placeholder="College Name" ng-model="edit.collegeName"
														required data-toggle='tooltip' data-placement='right'
														title="Please enter college name" />
												</div>
											</div>
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12 col-md-12 ">
												<div class="form-group">
													<span
														style="border-right: 1px solid #ccc; background-color: #217690; width: 150px !important; font-family: arial; color: #ffffff;"
														class="input-group-addon">About College *</span>
													<textarea style="resize: none;" class="form-control"
														ng-model="edit.collegeInfoForCollege"
														id="collegeInfoForCollege" name="collegeInfoForCollege"
														ng-blur="showMessageError()" ng-focus="hideMessageError()"
														placeholder="Display info on College Page" rows="3"
														ng-required="true" data-placement='right'
														title="Please enter display info about College"></textarea>
													<!-- <input id="collegeInfoForCollege"
													 name="collegeInfoForCollege" type="textarea" class="form-control"
													placeholder="Display info on College Page"
													ng-model="edit.collegeInfoForCollege" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter display info about College" /> -->
												</div>
											</div>
											<!-- <div class="col-xs-12 col-md-12 ">
    							<div class="form-group">
    									<span class="input-group-addon">About College *</span>
    								    <textarea style="resize: none;" class="form-control" ng-model="message"  id="message" name="message" ng-blur="showMessageError()" ng-focus="hideMessageError()" placeholder="Message*" rows="3" ng-required="true"></textarea>
    								    <span id="messageError" style="color:red" ng-show="contactUs.message.$dirty && contactUs.message.$invalid">
										<span ng-show="contactUs.message.$error.required">Message is required.</span>
										</span>
    							</div>
    									</div> -->
											<div class="col-xs-12">&nbsp;</div>

											<!-- <div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">College description *</span> <input
													id="collegeDesc" name="collegeDesc" type="text" class="form-control"
													placeholder="College description" ng-model="edit.collegeDesc" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter college description"/>
											</div>
										</div> -->

											<!-- <div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">College Logo</span> 
											<input ng-model="edit.logo" type="text" name="logo" id="logoByte64"
												style="display: none;" /> <input type="text" name="logo" id="logoByte64Size"
												style="display: none;" />
										
									

												
													<div class="col-xs-12">
														<img src="" class='logo' alt='logo'
														style="display: none;">
														<input id='hidden-logo-input' type='file' accept='image*;'
															style='display: none;' ng-file="file" base64 />
															<button class="btn btn-sm btn-info" onclick="$('#hidden-logo-input').click();">Upload Logo</button>
													</div>
											
											
										
										</div>
										<div class="input-group input-group-sm">
												<span class="input-group-addon" style="width: 138px;">Logo </span>
												<button class="btn btn-info choose-logo-btn">Choose logo</button>
													<img width=160 height=120 src='images/gravatar.png' class='logo' alt='logo'
														style="display: none;">
											
												<input id="hidden-logo-input" name="logo" type="file" class="logo" ng-model="edit.logo" accept="image/*" 
													placeholder="Logo" style="display: none;" /><input type="text" name="logo" id="logoByte64Size" onclick="alert()"
												style="display: none;" />
													
											</div>
					
										</div>
									 -->
											<!-- <div class="col-xs-12">
												<div class="panel panel-default">
													<div class="panel-heading">
														<div class="btn-group"
															style="border-style: none; font-family: arial; font-weight: bold;">College
															Logo</div>
													</div>
													<div class="panel-body photoRTC">
														<input ng-model="edit.logo" type="text" name="logo"
															id="photo1Byte64" style="display: none;" /> <input
															type="text" name="logo" id="photo1Byte64Size"
															style="display: none;" />
														<canvas class='canvas' width='160' height='120'
															style='display: none;'></canvas>
														<div class="col-xs-12">
															<div class="col-xs-3">
																<video class='live' width='160' height='120' autoplay></video>
																<img width=160 height=120 src='images/gravatar.png'
																	class='photo1' alt='photo' style="display: none;">
															</div>

															<div class="col-xs-9">
																<div class="col-xs-12">
																	<button class='takePhoto btn btn-info btn-sm'>Take photo</button>
																	<button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
															photo</button>
																	<input id='hidden-photo1-input' type='file'
																		accept='image*;capture=camera' style='display: none;'
																		ng-file="file1" base64 />
																</div>
																<div class="col-xs-12">&nbsp;</div>

																<button class='btn btn-sm btn-info'
																	onclick="$('#hidden-photo1-input').click();">Upload
																	logo</button>
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
										</div>
									</div>

								</div>
							</form>

							<form id="registerAdditionalFacultyForm"
								name="registerAdditionalFacultyForm" method="post" novalidate>
								<input name="userType1" id="userType1" type="hidden"
									style="display: none;" value="<%=typeofuser%>">
								<div class="dynamic-div" id="faculty"
									ng-show="edit.userType=='faculty'">
									<div class="panel panel-default">
										<!-- <div id="profession" class="panel-heading">Faculty</div> -->
										<div class="panel-body">

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Speciality
														*</span> <input style="width: 300px !important;" type="text"
														class="form-control" placeholder="Search branches"
														id="specializationOfFaculty2"
														ng-model="edit.specializationOfFaculty" value=""
														required data-toggle='tooltip' data-placement='right'
														title="Please enter specialised branch of faculty" />




													<!-- <div class="col-xs-12">
											<select class="form-control" ng-model="edit.specializationOfFaculty" 
													ng-options="item.branchId as item.projBranchDesc for item in data">
 													</select> 
												</div>  -->
												</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">State
														*</span> <input style="width: 300px !important;"
														name="collegeState1" type="text" id="collegeState1"
														class="form-control" placeholder="State"
														ng-model="edit.collegeState" required
														ng-maxlength="100" data-toggle='tooltip'
														data-placement='right' title="Please enter a valid State" />
												</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">College
														name *</span> <input style="width: 300px !important;"
														name="collgeOfFaculty" id="collgeOfFaculty" type="text"
														class="form-control" placeholder="College name"
														ng-model="edit.collgeOfFaculty" required
														ng-pattern="/^(\D)+$/" required required
														data-toggle='tooltip' data-placement='right'
														title="Please enter college of faculty" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.collgeOfFaculty.$dirty && registerAdditionalFacultyForm.collgeOfFaculty.$error.required">Faculty
												college is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.collgeOfFaculty.$dirty && registerAdditionalFacultyForm.collgeOfFaculty.$error.pattern">Faculty
												college can only contain text</div> -->
											</div>





											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Degree
														*</span> <input style="width: 300px !important;"
														id="facultydegree" maxlength=100 name="degreeOfFaculty"
														type="text" class="form-control" placeholder="Degree"
														ng-model="edit.degreeOfFaculty" required
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter degree of faculty" />
														<input style="width: 188px !important;display:none;" class="form-control" required ng-model="edit.degreeOfFaculty" id="degreeOfFaculty1"
														 />
														
														 <span
															class="input-group-addon btn-success btn-responsive"
															style="border-left: 1px solid #ccc; width: 10px;"  ng-click="enterFacultyDegree();"
															>Other</span>
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.degreeOfFaculty.$dirty && registerAdditionalFacultyForm.degreeOfFaculty.$error.required">Faculty
												degree is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.degreeOfFaculty.$dirty && registerAdditionalFacultyForm.degreeOfFaculty.$error.pattern">Faculty
												degree can only contain text</div> -->
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">University
														*</span> <input style="width: 300px !important;"
														name="universityOfFaculty" id="universityOfFaculty"
														type="text" class="form-control" placeholder="University"
														ng-model="edit.universityOfFaculty" required
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter University of faculty" />
												</div>
												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.universityOfFaculty.$dirty && registerAdditionalFacultyForm.universityOfFaculty.$error.required">University
												is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.universityOfFaculty.$dirty && registerAdditionalFacultyForm.universityOfFaculty.$error.pattern">University
												can only contain text</div> -->
											</div>


											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Experience
														*</span> <input style="width: 300px !important;"
														name="proffesionalExpOfFaculty"
														id="proffesionalExpOfFaculty" type="text"
														class="form-control"
														placeholder="Profeesional experience in months"
														ng-model="edit.proffesionalExpOfFaculty"
														ng-pattern="/^(\d)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter experience of faculty" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.proffesionalExpOfFaculty.$dirty && registerAdditionalFacultyForm.proffesionalExpOfFaculty.$error.pattern">Experience
												can only contain digits</div> -->
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Webpage
														link *</span> <input style="width: 300px !important;"
														name="psnlWebpgLink" id="psnlWebpgLink" type="url"
														class="form-control" placeholder="Personal webpage link"
														ng-model="edit.psnlWebpgLink" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter personal webpage link" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.psnlWebpgLink.$dirty && registerAdditionalFacultyForm.psnlWebpgLink.$error.url">Not
												a valid URL</div> -->
											</div>



											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Alumni
														*</span> <input style="width: 300px !important;" name="alumni"
														type="text" id="alumni" class="form-control"
														placeholder="Alumni" ng-model="edit.alumni"
														ng-pattern="/^(\D)+$/" required required
														data-toggle='tooltip' data-placement='right'
														title="Please enter alumni of faculty" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.alumni.$dirty && registerAdditionalFacultyForm.alumni.$error.pattern">Alumni
												can only contain text</div> -->
											</div>


											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Association
														list *</span> <input style="width: 300px !important;"
														id="facultycompletionyear" maxlength=100
														name="memshipInAssocns" type="text" class="form-control"
														placeholder="Association or membership name list"
														ng-model="edit.memshipInAssocns" required required
														data-toggle='tooltip' data-placement='right'
														title="Please enter Association or membership name list" />
												</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Facebook
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="Facebook Id"
														ng-model="edit.faceBookId" id="faceBookId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter Facebook Id" http-prefixfb>

												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Affiliated
														university *</span> <input name="affltUniversityOfFaculty"
														id="affltUniversityOfFaculty" type="text"
														style="width: 300px !important;" class="form-control"
														placeholder="Affiliated university name"
														ng-model="edit.affltUniversityOfFaculty"
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter Affilated University of faculty" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.affltUniversityOfFaculty.$dirty && registerAdditionalFacultyForm.affltUniversityOfFaculty.$error.pattern">Aff.
												University can only contain text</div> -->
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Twitter
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="Twitter Id"
														ng-model="edit.twitterId" id="twitterId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter Twitter Id" http-prefixtwit>

												</div>
											</div>



											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">LinkedIn
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="LinkedIn Id"
														ng-model="edit.LinkedinId" id="LinkedInId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter LinkedIn Id" http-prefixlink>

												</div>
											</div>

										</div>
									</div>
								</div>
							</form>

							<form id="registerAdditionalMentorForm"
								name="registerAdditionalMentorForm" method="post" novalidate>
								<input name="userType1" id="userType1" type="hidden"
									style="display: none;" value="<%=typeofuser%>">
								<div class="dynamic-div" id="mentor"
									ng-show="edit.userType=='mentor'">
									<div class="panel panel-default">
										<!-- <div id="profession" class="panel-heading">Mentor</div> -->
										<div class="panel-body">
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Speciality
														*</span> <input style="width: 300px !important;" type="text"
														class="form-control" placeholder="Search branches"
														id="branchIdOfMentor2"
														ng-model="edit.branchIdOfMentor" value="" required
														required data-toggle='tooltip' data-placement='right'
														title="Please enter specialised branch of mentor" />


													<!-- <div class="col-xs-12">
											<select class="form-control" ng-model="edit.branchIdOfMentor" 
													ng-options="item.branchId as item.projBranchDesc for item in data">
 													</select> 
												</div> -->

												</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Designation
														*</span> <input name="designationOfMentor"
														id="designationOfMentor" style="width: 300px !important;"
														type="text" class="form-control" placeholder="Designation"
														ng-model="edit.designationOfMentor" required
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter designation of mentor" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.designationOfMentor.$dirty && registerAdditionalMentorForm.designationOfMentor.$error.required">Designation
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.designationOfMentor.$dirty && registerAdditionalMentorForm.designationOfMentor.$error.pattern">Designation
												can only contain text</div> -->
											</div>




											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Degree
														*</span> <input name="degreeOfMentor" id="degreeOfMentor"
														type="text" style="width: 300px !important;"
														class="form-control" placeholder="Degree"
														ng-model="edit.degreeOfMentor" required
														ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter degree of mentor" />
														<input style="width: 188px !important;display:none;" class="form-control" required ng-model="edit.degreeOfMentor" id="degreeOfMentor1"
														 />
														
														 <span
															class="input-group-addon btn-success btn-responsive"
															style="border-left: 1px solid #ccc; width: 10px;"  ng-click="enterMentorDegree();"
															>Other</span>
												</div>
												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.degreeOfMentor.$dirty && registerAdditionalMentorForm.degreeOfMentor.$error.required">Degree
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.degreeOfMentor.$dirty && registerAdditionalMentorForm.degreeOfMentor.$error.pattern">Degree
												can only contain text</div> -->
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Facebook
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="Facebook Id"
														ng-model="edit.faceBookId" id="facebookId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter Facebook Id" http-prefixfb>

												</div>
											</div>



											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Webpage
														link *</span> <input style="width: 300px !important;"
														id="mentorwebpage" name="webpage" type="url"
														class="form-control" placeholder="Personal webpage link"
														ng-model="edit.webpage" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter personal webpage link  " />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.webpage.$dirty && registerAdditionalMentorForm.webpage.$error.url">Not
												a valid URL</div> -->
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Twitter
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="Twitter Id"
														ng-model="edit.twitterId" id="twitterId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter Twitter Id" http-prefixtwit>

												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Time
														spare *</span> <input name="timeUspaceForMentoringPerMnth"
														style="width: 300px !important;"
														id="timeUspaceForMentoringPerMnth" type="text"
														class="form-control"
														placeholder="Time spare for mentoring per month"
														ng-pattern="/^(\d)+$/"
														ng-model="edit.timeUspaceForMentoringPerMnth" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter time space for mentoring per month" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.timeUspaceForMentoringPerMnth.$dirty && registerAdditionalMentorForm.timeUspaceForMentoringPerMnth.$error.url">Time
												spare can only contain digits</div> -->
											</div>


											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">LinkedIn
														Id</span> <input style="width: 300px !important;" type="url"
														class="form-control" placeholder="LinkedIn Id"
														ng-model="edit.LinkedinId" id="LinkedInId" value=""
														data-toggle='tooltip' data-placement='right'
														title="Please enter LinkedIn Id" http-prefixlink>

												</div>
											</div>



											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Mentor
														profile *</span>
													<textarea rows="3" cols="31" name="mentorProfile"
														id="mentorProfile" placeholder="Mentor Profile"
														ng-model="edit.mentorProfile" style="resize: none;"
														data-toggle='tooltip' data-placement='right'
														title="Please enter mentor profile" ng-maxlength="1000"
														required></textarea>

												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.mentorProfile.$dirty && registerAdditionalMentorForm.mentorProfile.$error.required">
													Profile is required *</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.mentorProfile.$dirty && registerAdditionalMentorForm.mentorProfile.$error.maxlength">
													Profile cannot be more than 1000 characters</div>
											</div>



											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Experience
														*</span>
													<!-- <input
														name="professionalExperience" id="professionalExperience"
														 style="width: 300px !important;" type="text" class="form-control"
														placeholder="Professional experience in months"
														ng-model="edit.professionalExperience" required
														ng-pattern="/^(\d)+$/" required required
														data-toggle='tooltip' data-placement='right'
														title="Please enter proffesional experience in months of mentor" /> -->

													<textarea rows="3" cols="31" name="professionalExperience"
														id="professionalExperience"
														placeholder="Professional experience"
														ng-model="edit.professionalExperience"
														style="resize: none;" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter proffesional experience"
														ng-maxlength=1000;></textarea>

												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.professionalExperience.$dirty && registerAdditionalMentorForm.professionalExperience.$error.required">
													Experience is required *</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.professionalExperience.$dirty && registerAdditionalMentorForm.professionalExperience.$error.maxlength">
													Experience cannot be more than 1000 characters</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.professionalExperience.$dirty && registerAdditionalMentorForm.professionalExperience.$error.required">Experience
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.professionalExperience.$dirty && registerAdditionalMentorForm.professionalExperience.$error.pattern">Experience
												can only contain digits</div> -->
											</div>




											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Interest
														*</span>
													<!-- <input
														name="intOnGrassrtInnovators" id="intOnGrassrtInnovators"
														style="width: 300px !important;" type="text" class="form-control"
														placeholder="grass root innovators interest"
														ng-model="edit.intOnGrassrtInnovators" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter grass root innovators interest" /> -->

													<textarea rows="3" cols="31" name="intOnGrassrtInnovators"
														id="intOnGrassrtInnovators"
														placeholder="grass root innovators interest"
														ng-model="edit.intOnGrassrtInnovators"
														style="resize: none;" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter grass root innovators interest"
														ng-maxlength=1000;></textarea>

												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.intOnGrassrtInnovators.$dirty && registerAdditionalMentorForm.intOnGrassrtInnovators.$error.required">
													Interest is required *</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.intOnGrassrtInnovators.$dirty && registerAdditionalMentorForm.intOnGrassrtInnovators.$error.maxlength">
													Interest cannot be more than 1000 characters</div>
											</div>






											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Commitment
														*</span>
													<!-- <input
														style="width: 300px !important;" id="commitmentUBringIn" maxlength=100
														name="commitmentUBringIn" type="text" class="form-control"
														placeholder="Commitment you bring"
														ng-model="edit.commitmentUBringIn" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter commitment you bring" /> -->

													<textarea rows="3" cols="31" name="commitmentUBringIn"
														id="commitmentUBringIn" placeholder="Commitment you bring"
														ng-model="edit.commitmentUBringIn"
														style="resize: none;" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter commitment you bring"
														ng-maxlength=1000;></textarea>

												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.commitmentUBringIn.$dirty && registerAdditionalMentorForm.commitmentUBringIn.$error.required">
													Commitment Description is required *</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.commitmentUBringIn.$dirty && registerAdditionalMentorForm.commitmentUBringIn.$error.maxlength">
													Commitment Description cannot be more than 1000 characters</div>
											</div>


											<div class="col-xs-12">&nbsp;</div>


											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Association
														*</span>
													<!-- <input
														maxlength=200 name="institutionalAssctnInfo"
														 style="width: 300px !important;" id="institutionalAssctnInfo" type="text"
														class="form-control"
														placeholder="Institution association info"
														ng-model="edit.institutionalAssctnInfo" required
														data-toggle='tooltip' data-placement='right'
														title="Please enter Institutional Association Info" /> -->

													<textarea rows="3" cols="31" name="institutionalAssctnInfo"
														id="institutionalAssctnInfo"
														placeholder="Institution Association Info"
														ng-model="edit.institutionalAssctnInfo"
														style="resize: none;" required data-toggle='tooltip'
														data-placement='right'
														title="Please enter Institutional Association Info"
														ng-maxlength=1000;></textarea>

												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.institutionalAssctnInfo.$dirty && registerAdditionalMentorForm.institutionalAssctnInfo.$error.required">
													Institution Association InfoDescription is required *</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="registerAdditionalMentorForm.institutionalAssctnInfo.$dirty && registerAdditionalMentorForm.institutionalAssctnInfo.$error.maxlength">
													Institution Association Info Description cannot be more
													than 1000 characters</div>
											</div>

										</div>
									</div>
								</div>
							</form>


							<%-- 
<form id="registerAdditionalCollegeForm" name="registerAdditionalCollegeForm" method="post"
							novalidate>
							<input name="userType1" id="userType1" type="hidden" style="display: none;" value="<%=typeofuser %>">
							<div class="dynamic-div" id="college" ng-show="edit.userType=='college'">
								<div class="panel panel-default">
									<!-- <div id="profession" class="panel-heading">College</div> -->
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"> --%>

							<%-- 
						<form id="registerAdditionalIndustryForm" name="registerAdditionalIndustryForm" method="post"
							novalidate>
							<input name="userType1" id="userType1" type="hidden" style="display: none;" value="<%=typeofuser %>">
							<div class="dynamic-div" id="industry" ng-show="edit.userType=='industry'">
								<div class="panel panel-default">
								<!-- 	<div id="profession" class="panel-heading">Industry</div> -->
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Fax</span> <input name="fax" type="text"
													class="form-control" placeholder="Fax" ng-model="edit.fax" required
													ng-pattern="/^(\d)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalIndustryForm.fax.$dirty && registerAdditionalIndustryForm.fax.$error.required">Fax
												is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalIndustryForm.fax.$dirty && registerAdditionalIndustryForm.fax.$error.pattern">Fax
												can only contain digits</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Sector</span> <input id="industrycontactname"
													maxlength=100 name="operatnSectr" type="text" class="form-control"
													placeholder="Operation sector" ng-model="operatnSectr" />
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Product range </span> <input name="prdRng" type="text"
													class="form-control" placeholder="Product range" ng-model="edit.prdRng" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Support </span> <input name="kindOfSprtUProvideInnovtr"
													type="text" class="form-control" placeholder="Support provide to innovators"
													ng-model="edit.kindOfSprtUProvideInnovtr" />
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Experties</span> <input maxlength=100
													name="techngyExprtizOffrToOthers" type="text" class="form-control"
													placeholder="Technological experties" ng-model="edit.techngyExprtizOffrToOthers" />
											</div>
										</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Challenges</span> <input
													name="solnReqrdForTechnlgicalChlngs" type="text" class="form-control"
													placeholder="Solution required for technological challenges"
													ng-model="edit.solnReqrdForTechnlgicalChlngs" />
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon"> Associate industries</span> <input
													name="associateIndustry" type="text" class="form-control"
													placeholder="Associate industries name (if any)" ng-model="edit.associateIndustry" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Award</span> <input maxlength=100
													name="intrstToPoseInnovtnChlngAwrds" type="text" class="form-control"
													placeholder="Innovation chalenge awards"
													ng-model="edit.intrstToPoseInnovtnChlngAwrds" />
											</div>
										</div>
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12 col-md-6">
										<div class="input-group input-group-sm">
												<span class="input-group-addon">Contact Person  Name *</span> <input name="cntctPerNameofIndustry" id="industrycontactname"
													type="text" class="form-control" placeholder="Contact Person Name"
													ng-model="edit.cntctPerNameofIndustry" required ng-pattern="/^(\D)+$/" required   data-toggle='tooltip' data-placement='right' 
														title="Please enter Contact Person Name"/>
											</div>
											</div>
											<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
													<span class="input-group-addon">Contact Person Mobile *</span> <input name="cntctpersonmobile" type="text" id="cntctpersonmobile"
														class="form-control" placeholder="Contact Person Mobile" ng-model="edit.cntctpersonmobile" required
														ng-minlength=10 ng-maxlength=10  ng-pattern="/^(\d)+$/" data-toggle='tooltip' data-placement='right' 
														title='Mobile number should be 10 digits' />
												</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Contact Person email *</span> <input id="contactEmail"
													name="contactEmail" maxlength=100 type="email" class="form-control"
													placeholder="Contact Person email id" ng-model="edit.contactEmail"  required  data-toggle='tooltip' data-placement='right' 
														title="Please enter Contact Person Email"/>
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalEmail.$dirty && registerAdditionalCollegeForm.prinicipalEmail.$error.required">Principal
												email is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalEmail.$dirty && registerAdditionalCollegeForm.prinicipalEmail.$error.email">Not
												a valid email</div> -->
										</div>
											<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-12 ">
											<div class="form-group">
												<span class="input-group-addon">About Industry *</span> 
												  <textarea style="resize: none;" class="form-control" ng-model="edit.industryInfoForIndustry"  id="industryInfoForIndustry" name="industryInfoForIndustry" ng-blur="showMessageError()" ng-focus="hideMessageError()" placeholder="Display info on Industry Page" rows="3" ng-required="true" data-placement='right' title="Please enter display info about Industry" ></textarea>
											</div>
											<div class="col-xs-12">
									<div class="panel panel-default">
										<div class="panel-heading">
											<div class="btn-group">Industry Logo</div>
										</div>
										<div class="panel-body photoRTC">
											<input ng-model="edit.logo" type="text" name="logo" id="photo1Byte64"
												style="display: none;" /> <input type="text" name="logo" id="photo1Byte64Size"
												style="display: none;" />
											<canvas class='canvas' width='160' height='120' style='display: none;'></canvas>
											<div class="col-xs-12">
												<div class="col-xs-3">
													<video class='live' width='160' height='120' autoplay></video>
													<img width=160 height=120 src='images/gravatar.png' class='photo1' alt='photo'
														style="display: none;">
												</div>

												<div class="col-xs-9">
													<div class="col-xs-12">
														<!-- <button class='takePhoto btn btn-info btn-sm'>Take photo</button> -->
														<!-- <button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
															photo</button> -->
														<input id='hidden-photo1-input' type='file' accept='image*;capture=camera'
															style='display: none;' ng-file="file1" base64 />
													</div>
													<div class="col-xs-12">&nbsp;</div>
													
														<button class='btn btn-sm btn-info' onclick="$('#hidden-photo1-input').click();">Upload logo</button>
														<div class="col-xs-12" ng-show="msg.size.length>0">File size cannot be more than 10 KB</div>
							<div class="col-xs-12" ng-show="message.length>0">
								<div ng-repeat="msg in message">{{msg}}</div>
													</div>
													
												</div>
											</div>
										</div>
									</div>
								</div>
										</div>
									</div>
								</div>
							</div>
						</form> --%>
							<div class="col-xs-12">
								<!-- <a href="#" class="btn btn-primary reg-ctn-2"
								ng-disabled="registerAdditionalStudentForm.$invalid&&registerAdditionalCollegeForm.$invalid&&registerAdditionalFacultyForm.$invalid&&registerAdditionalMentorForm.$invalid"><span
								style="color: white;">Continue</span></a> -->
								<a href="#"><input type="submit"
									class="btn btn-primary reg-ctn-2"
									onclick="checkAdditionalEmpty()"
									style="margin-left: 91%; background-color: #5cb85c;"
									value="Continue"></a>
							</div>
						</div>

						<h3 class="reg-acc-3 acc-hover"
							style="background-color: #217690; font-family: arial; color: black; font-weight: bold;"
							ng-class="(registerAdditionalStudentForm.$valid)||registerAdditionalCollegeForm.$valid||registerAdditionalFacultyForm.$valid||registerAdditionalMentorForm.$valid?'ui-state-default':'ui-state-disabled'">Captcha{{registerAdditionalStudentForm.$valid}}{{registerAdditionalStudentForm.age.$valid}}{{edit.age}}</h3>
						<div>

							<div class="col-xs-12">
								<div class="col-xs-12 form-control "
									style="height: 85px !important">
									<div class="col-xs-4"
										style="padding-left: 0%; padding-right: 0%">
										<img src="jcaptcha.jpg" id="captcha_image"
											style="box-shadow: 0 0 2em #b2b2b2;" />
									</div>
									<div class="col-xs-4" style="margin-left: -120px;">
										<div class="col-xs-12">
											<a href="" onclick="reloadCaptcha()" alt="reload"><i
												style="" class="fa fa-refresh fa-2x"></i></a> <span
												style="color: red" role="alert"
												ng-show="messageerrorCaptcha.length>0"
												ng-repeat="msg in messageerrorCaptcha"><i
												class="fa fa-exclamation-triangle"></i> <strong>Invalid
													Captcha!</strong>&nbsp;Please Try Again... </span>
										</div>

										<div class="col-xs-12">
											<input class="form-control" placeholder="Enter the text here"
												type="text" name="jcaptcha" value="" ng-model="jCaptcha"
												style="width: 100%; margin-top: 8px" />
										</div>


									</div>
									<div class="col-xs-12 col-md-4">
										<!-- <a class="btn btn-primary reg-ctn-3" id="register"
											style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
											ng-click="registerSubmit()">Register</a> -->

										<button class="btn btn-primary reg-ctn-3" id="register"
											style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
											ng-click="newFaculty(jCaptcha)" ng-disabled="(!jCaptcha)"
											data-toggle="modal" data-target="#updateProfileAlertModal">Save</button>
									</div>
								</div>
							</div>
						</div>


						<%-- <div class="col-xs-12">
								<div class="col-xs-12 col-md-8">
									<div class="input-group input-group-sm" id="captchavalue">
										<div class="g-recaptcha"
											data-sitekey="6LcgrRQTAAAAALPL-I3d-X4mXCcCy-F22emjwxS3"></div>

										<span id="captchaVal" class="input-group-addon"
											style="border-right: 1px solid #ccc"> <%
											Random aRandom = new Random();
											long aStart = 1000;
											long aEnd = 9999;
											long range = (long) aEnd - (long) aStart + 1;
											long fraction = (long) (range * aRandom.nextDouble());
											int randomNumber = (int) (fraction + aStart);
											System.err.println("RANDOM NUMBER: " + randomNumber);
											out.write(String.valueOf(randomNumber));
										%>
										</span> <input name="captcha" type="text" class="form-control"
											id="captcha" placeholder="Captcha" />
									</div>

								</div>
								<div class="col-xs-12 col-md-4">
									<a class="btn btn-primary reg-ctn-3" id="register"
										style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
										ng-click="registerSubmit()">Register</a>
								</div>
							</div> --%>
					</div>
				</div>
				<!-- ERROR MESSAGE -->
				<div class="row error-place" style="display: none;">
					<div class="col-xs-11">
						<div class="panel panel-danger">
							<div class="panel-heading">Error:</div>
							<div class="panel-body error"></div>
						</div>
					</div>
				</div>
				<div class="col-xs-12">
					<div class="panel panel-info reg-response-panel"
						ng-show="message.length>0" ng-repeat="msg in message">
						<div class="panel-heading reg-response">{{msg}}</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Edit Profile alert -->
					<div class="modal fade" id="updateProfileAlertModal" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="background-color: #31b0d5; color: white; text-align: center">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Edit Profile</h4>
								</div>
								<div classs="modal-body" ng-show="messageerrorCaptcha.length>0"
									style="text-align: center;">
									<div class="col-xs-12" style="height: 70px;">
										<div style="color: red; padding-top: 25px;" role="alert"
											ng-show="messageerrorCaptcha.length>0"
											ng-repeat="msg in messageerrorCaptcha">
											<i class="fa fa-exclamation-triangle"></i> <strong>Invalid
												Captcha!</strong>&nbsp;Please Try Again...
										</div>
									</div>
									<button data-dismiss="modal" type="button" class="btn btn-info"
										ng-click="Exitfunction()">Try Again</button>
									<div class="clearfix">&nbsp;</div>
								</div>
								<div ng-hide="messageerrorCaptcha.length>0">
									<div class="modal-body"
										ng-hide="messageSuccess.length>0 || messageWarning.length>0 ||messageerrorCaptcha.length>0">
										<div class="loaderBody"
											ng-hide="messageWarning.length>0 || messageSuccess.length>0 ||messageerrorCaptcha.length>0">Please
											sit back and relax while we are saving your information...</div>
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
										</div>
									</div>
									<div class="modal-body" style="text-align: center;"
										ng-show="messageWarningEmail.length>0">
										<div style="text-align: center;">
											<i id="effect" class="fa fa-check-circle-o"
												style="color: #8a6d3b; font-size: 7em;"></i>
										</div>
										<div
											class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
											style="color: black; text-align: center; font-family: arial;"
											ng-repeat="msg in messageWarningEmail">{{msg}}</div>
									</div>

									<div class="modal-body" style="text-align: center;"
										ng-show="messageWarning.length>0">
										<div style="text-align: center;">
											<i class="fa fa-exclamation-triangle"
												style="color: #E84F63; font-size: 50px; text-align: center;"></i>
										</div>
										<div
											class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
											style="color: black; text-align: center; font-family: arial;"
											ng-repeat="msg in messageWarning">{{msg}}</div>
									</div>
									<div class="clearfix">&nbsp;</div>
									<div class="modal-footer"
										style="align: center; text-align: center;">
										<a href="dashboard" data-dismiss="modal" class="btn btn-info"
											ng-click="forward()">Exit</a>
									</div>
								</div>
							</div>
						</div>
					</div>

</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="js/dashboardJs/excanvas.min.js"></script> 
<![endif]-->

<!-- END JAVASCRIPTS -->
</body>

<script>
	function checkEmpty() {
		var empty = '';

		$("input", registerBasicForm).each(
				function() {
					// empty = ($(this).val() == "") ? true : false;
					if ($.trim($("#firstName").val()) === ""
							/* || $.trim($("#lastName").val()) === "" */
							|| $.trim($("#userName").val()) === ""
							|| $.trim($("#userPassword1").val()) === ""
							|| $.trim($("#confirmPassword").val()) === ""
							|| $.trim($("#age").val()) === ""
							/* || $.trim($("#mobile").val()) === "" */
							|| $.trim($("#addrLn1").val()) === ""
							|| $.trim($("#district").val()) === ""
							|| $.trim($("#city").val()) === ""
							|| $.trim($("#state").val()) === ""
							|| $.trim($("#country").val()) === ""
							|| $.trim($("#pincode").val()) === ""
							|| $.trim($("#email").val()) === "") {
						empty = "isempty";

					}

					else {
						empty = "notempty";

					}
				});
		//alert($("#firstName").val()+'###'+$("#lastName").val()+'###'+$("#userName").val()+'###'+$("#userPassword1").val()+'###'+$("#confirmPassword").val()+'###'+$("#mobile").val()+'###'+$("#addrLn1").val()+'###'+$("#district").val()+'###'+$("#city").val()+'###'+$("#state").val()+'###'+$("#country").val()+'###'+$("#pincode").val()+'###'+$("#email").val());
		//alert('password is '+$("#userPassword1").val());

		if (empty == "isempty") {
			alert("Some of the field are empty . Please fill the * marked field");
			return false;

		}
	}
	function checkAdditionalEmpty() {

		//alert($("#userType1").val());
		var empty = null;

		if ($("#userType1").val() === "student") {

			$("input", registerAdditionalStudentForm)
					.each(
							function() {

								if ($.trim($("#studentdegree").val()) === ""
										/* || $.trim($("#dateOfBirthDatePicker")
												.val()) === "" 
										|| $.trim($("#age").val()) === ""*/
										|| $.trim($("#studentID").val()) === ""
										|| $.trim($("#studentCompletionYear")
												.val()) === ""
										|| $.trim($("#CollegeNames").val()) === ""
										|| $.trim($("#university").val()) === ""
										|| $.trim($("#branchIdOfStudent2")
												.val()) === "")

								{
									empty = "isempty"

								}

								else {
									empty = "notempty";
								}
							});
			if (empty === "isempty") {
				alert("Some of the field are empty . Please fill the * marked field ");
				return false;

			}

		} else if ($("#userType1").val() === "college") {

			//alert('in college else');
			$("input", registerAdditionalCollegeForm)
					.each(
							function() {
								//if($(this).val() === ""){
								if ($.trim($("#cntctInfoForNatnlInnovnClub")
										.val()) === ""
										|| $.trim($("#CollegeNames1").val()) === ""
										|| $.trim($("#collegecontactname")
												.val()) === ""
										|| $.trim($("#prinicipalName").val()) === ""
										|| $
												.trim($(
														"#affltUniversityOfCollege")
														.val()) === ""
										|| $.trim($("#techpdaFactlyCoordtr")
												.val()) === ""
										|| $.trim($("#prinicipalEmail").val()) === ""
										|| $.trim($("#webpage").val()) === ""
										|| $.trim($(
												"#facilitiesOffrdToStudents")
												.val()) === "")

								{
									empty = "isempty"

								}

								else {
									empty = "notempty";
								}
							});

			// alert($("#collegecontactname").val()+'###'+$("#prinicipalName").val()+'###'+$("#affltUniversityOfCollege").val()+'###'+$("#collegecontactname").val()+'###'+$("#prinicipalEmail").val()+'###'+$("#webpage").val()+'###'+$("#collegeDesc").val()+'###'+$("#facilitiesOffrdToStudents").val());

			if (empty === "isempty") {

				alert("Some of the field are empty . Please fill the * marked field ");
				return false;

			}
		}

		else if ($("#userType1").val().toLowerCase() === "faculty") {
			$("input", registerAdditionalFacultyForm)
					.each(
							function() {
								//if($(this).val() === ""){
								if ($.trim($("#facultydegree").val()) === ""
										|| $.trim($("#collgeOfFaculty").val()) === ""
										|| $
												.trim($(
														"#specializationOfFaculty2")
														.val()) === ""
										|| $.trim($("#universityOfFaculty")
												.val()) === ""
										|| $
												.trim($(
														"#proffesionalExpOfFaculty")
														.val()) === ""
										|| $.trim($("#psnlWebpgLink").val()) === ""
										|| $.trim($("#alumni").val()) === ""
										|| $.trim($("#facultycompletionyear")
												.val()) === ""
										|| $
												.trim($(
														"#affltUniversityOfFaculty")
														.val()) === ""
										|| $.trim($("#collgeOfFaculty").val()) === "")

								{
									empty = "isempty"

								}

								else {
									empty = "notempty";
								}
							});
			if (empty === "isempty") {
				alert("Some of the field are empty . Please fill the * marked field ");
				return false;

			}
		} else if ($("#userType1").val().toLowerCase() === "mentor") {
			$("input", registerAdditionalMentorForm)
					.each(
							function() {
								//if($(this).val() === ""){
								if ($.trim($("#degreeOfMentor").val()) === ""
										|| $.trim($("#designationOfMentor")
												.val()) === ""
										|| $
												.trim($("#branchIdOfMentor2")
														.val()) === ""
										|| $.trim($("#professionalExperience")
												.val()) === ""
										|| $.trim($("#institutionalAssctnInfo")
												.val()) === ""
										|| $
												.trim($(
														"#timeUspaceForMentoringPerMnth")
														.val()) === ""
										|| $.trim($("#mentorProfile").val()) === ""
										|| $.trim($("#mentorwebpage").val()) === ""
										|| $.trim($("#intOnGrassrtInnovators")
												.val()) === ""
										|| $.trim($("#commitmentUBringIn")
												.val()) === "")

								{
									empty = "isempty"

								}

								else {
									empty = "notempty";
								}
							});
			if (empty === "isempty") {
				alert("Some of the field are empty . Please fill the * marked field ");
				return false;

			}
		}
	}
</script>
<script type="text/javascript">
	$(".loaderBody").load(function() {
		$(".loaderBody").fadeOut("slow");
	})
</script>
<!-- END BODY -->

<jsp:include page="template/footer.jsp" />
<script src="js/webrtc.js"></script>
<script src="js/jquery.autocomplete.js"></script>
<script src="js/logo.js"></script>
<!-- js 
================================================== -->
<!-- Javascript files placed here for faster loading -->
<!-- <script src="js/foundation.min.js"></script> -->
<script src="js/jquery-ui.js"></script>
<script src="js/angular.min.js"></script>
<script src="js/Controller.js"></script>
<script src="js/swfobject.js"></script>
<script src="js/jquery.FileReader.min.js"></script>
<!-- <script src="js/elasticslideshow.js"></script> -->
<!-- <script src="js/jquery.cycle.js"></script> -->
<!-- <script src="js/slidepanel.js"></script> -->
<!-- <script src="js/responsivemenu.js"></script> -->
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<!-- <link rel="stylesheet" href="css/components.css"> -->
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/customStyle.css">
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/custom.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/select2.min.js"></script>
<script src="js/script.min.js"></script>
<script src="js/StateCity.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</html>


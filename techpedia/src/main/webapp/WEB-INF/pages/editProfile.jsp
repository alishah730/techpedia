<%@ page import="java.util.Random"%>
<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
<style>
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
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
/* .input-group-addon, .input-group-btn {
width: 200px !important;
width: 130px !important;
} */

/* .input-group-addon, .input-group-btn, .input-group .form-control {
display: table-cell;
width: 100%;
} */
.heading {
	border-right: 1px solid #ccc;
	background-color: #217690;
	width: 130px;
	font-family: arial;
	color: #ffffff;
}

.inputbox {
	width: 298px;
}
</style>
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
     <script src="js/respond.min.js"></script>
 <![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
<div class="clearfix"></div>
<div class="container customFont borderRadius style"
	ng-controller="EditProfileController"
	ng-init="initialEditProfileData()">
	<div class="page-container">
		<div class="page-sidebar-wrapper"></div>
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<h3 class="page-title">
							<i class="fa fa-pencil-square-o" id="icon-size"></i> <span
								style="text-transform: capitalize; font-family: arial; font-weight: bold;">Edit
								Profile - {{edit.userType}}</span><span
								style="color: #262626 !important; padding-left: 64%; font-size: medium; font-family: arial; font-weight: bold;">Register
								Id : <%=session.getAttribute("id")%></span>
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li style="color: #262626 !important"><a
								style="color: #262626 !important" href="./">&nbsp;Home</a> <font
								style="color: black; font-size: 18px;">&raquo;</font></li>
							<li style="color: #262626 !important"><a
								style="color: #262626 !important" href="dashboard">&nbsp;Dashboard</a><font
								style="color: black; font-size: 18px;">&raquo;</font></li>
							<li style="color: #262626 !important">Edit Profile</li>


						</ul>

					</div>
				</div>


				<div class="clearfix"></div>

				<div class="col-xs-12 col-md-6">
					<div class="panel panel-default"
						ng-controller="ChangePhotoController" ng-init="InitLoad()"
						style="border-style: none; background-color: #f5f5f5">
						<div class="panel-heading"
							style="border-style: none; font-family: arial; font-weight: bold;">Change
							Profile Image</div>
						<div class="panel-body"
							style="border-style: none; background-color: #f5f5f5;">
							<%-- <div class="col-xs-2">
							<div class="panel panel-default">
								<div class="panel-heading">Current Image</div>
								<div class="panel-body">
									<img alt="" width=100 height=100 src="<%=session.getAttribute("photo")%>" />
								</div>
							</div>
						</div> --%>
							<%
								String photo = (String) session.getAttribute("photopath");
							%>

							<div class="panel-body" style="height: 163px;">
								<div class="col-xs-6 col-md-3">
									<%
										if (photo != null) {
									%>
									<img alt="" width=120 height=120 class="photo"
										src="${pageContext.request.contextPath}/image/<%=photo%>" />
									<%
										} else {
									%>
									<img alt="" width=120 height=120 class="photo"
										src="images/gravatar.png" />
									<%
										}
									%>
								</div>
								<div class="col-xs-6 col-md-3" style="padding-left: 74px;">
									<button class='btn btn-sm btn-info'
										style="background-color: #5cb85c; border-color: #4cae4c;"
										onclick="$('#hidden-photo-input').click();">Choose
										photo</button>
									<div class="col-xs-12">&nbsp;</div>

									<button class='btn btn-sm btn-info'
										style="background-color: #5cb85c; border-color: #4cae4c; width: 90px;"
										ng-click="saveImage()" ng-disabled="canSaveImage==false">Save
										Photo</button>
								</div>
							</div>


							<input ng-model="editProfile.photo" type="text" name="photo"
								id="photoByte64" style="display: none;" /> <input
								id='hidden-photo-input' type='file'
								accept='image*;capture=camera' style='display: none;'
								ng-file="file" base64 />

							<div class="col-xs-12"></div>
							<div class="col-xs-12">&nbsp;</div>
							<div class="col-xs-12"></div>

							<div class="col-xs-12" ng-show="msg.size.length>0">File
								size cannot be more than 10 KB</div>
							<div class="col-xs-12" ng-show="message.length>0">
								<div ng-repeat="msg in message">{{msg}}</div>

							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-6">
					<div class="panel panel-default"
						ng-controller="ChangePasswordController"
						style="border-style: none; background-color: #f5f5f5">
						<div class="panel-heading"
							style="border-style: none; font-family: arial; font-weight: bold;">Change
							password</div>
						<div class="panel-body"
							style="border-style: none; background-color: #f5f5f5;">
							<form name="changePasswordForm" novalidate>
								<div class="col-xs-12">
									<div class="input-group input-group-sm">
										<span class="input-group-addon heading">Old</span> <input
											style="width: 298px;" name="oldPassword" type="password"
											class="form-control inputbox" ng-model="data.oldpassword"
											placeholder="Old Password" required 
											title='Password should contain a minimum of 6 and a maximun of 16 characters with atleast one numeric value and one special character excluding (,.[]_\-)' />
									</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="changePasswordForm.oldPassword.$dirty && changePasswordForm.oldPassword.$error.required">Old
										password is required</div>
								</div>
								<div class="col-xs-12">&nbsp;</div>
								<div class="col-xs-12">
									<div class="input-group input-group-sm">
										<span class="input-group-addon heading">New</span> <input
											style="width: 298px;" name="newPassword" type="password"
											class="form-control" placeholder="New Password"
											ng-model="data.newpassword" required ng-minlength="6"
											ng-maxlength="16"
											ng-pattern="/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%&^*+ = /| < >{}]).{6,}$/"
											title='Password should contain a minimum of 6 and a maximun of 16 characters with atleast one numeric value and one special character excluding (,.[]_\-)' />
									</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="changePasswordForm.newPassword.$dirty && changePasswordForm.newPassword.$error.required">New
										password is required</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="changePasswordForm.newPassword.$dirty && changePasswordForm.newPassword.$error.minlength">Password
										must be 6 character long</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="changePasswordForm.newPassword.$dirty && changePasswordForm.newPassword.$error.maxlength">Password
										must less than 16 character long</div>
								</div>

								<div class="col-xs-12">&nbsp;</div>

								<div class="col-xs-12">
									<div class="input-group input-group-sm">
										<span class="input-group-addon heading">Confirm</span> <input
											style="width: 298px;" name="confirmPassword" type="password"
											class="form-control" placeholder="Confirm password"
											ng-model="confirmPassword" required ng-minlength="6"
											ng-maxlength="16"
											ng-pattern="/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%&^*+ = /| < >{}]).{6,}$/"
											password-match="data.newpassword"
											title='Password & Confirm password should be same ' />
									</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="changePasswordForm.confirmPassword.$dirty && changePasswordForm.confirmPassword.$error.required">Password
										confirmation is required</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="changePasswordForm.confirmPassword.$dirty && changePasswordForm.confirmPassword.$error.minlength">Password
										must be 6 character long</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="changePasswordForm.confirmPassword.$dirty && changePasswordForm.confirmPassword.$error.maxlength">Password
										must less than 16 character long</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="changePasswordForm.confirmPassword.$dirty && changePasswordForm.confirmPassword.$error.pwmatch">Passwords
										do not match</div>
								</div>
								<div class="col-xs-12">&nbsp;</div>
								<div class="col-xs-12 col-md-4">
									<a class="btn btn-primary"
										style="background-color: #5cb85c; border-color: #4cae4c;"
										ng-disabled="changePasswordForm.$invalid"
										ng-click="changePassword()">Change Password</a>
								</div>
							</form>
						</div>
						<div class="panel panel-info" ng-show="message.length>0">
							<div class="panel-heading">
								<div ng-repeat="msg in message">{{msg}}</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-12">&nbsp;</div>
				<div class="col-xs-12" ng-controller="EditProfileController"
					ng-init="initialEditProfileData();">



					<div class="panel panel-default"
						style="border-style: none; background-color: #f5f5f5">
						<div class="panel-heading"
							style="border-style: none; font-family: arial; font-weight: bold;">Change
							Profile</div>
						<div class="panel-body"
							style="border-style: none; background-color: #f5f5f5;">
							<div id="accordion" class="col-xs-12">
								<h3 class="reg-acc-1 acc-hover"
									style="background-color: #217690; font-family: arial; color: black;font-weight: bold;">General
									Information</h3>
								<div>
									<p>
									<div>
										<form id="registerBasicForm" name="registerBasicForm"
											method="post" novalidate>
											<div class="col-xs-12"></div>

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
															<div class="input-group input-group-sm ">
																<span class="input-group-addon heading"> First
																	name *</span> <input style="width: 298px;" name="firstName"
																	type="text" id="firstName"
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

															<!-- 		 <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.required">First
													name is required</div>-->
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.maxlength">First
													name cannot be more than 30 characters</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.pattern">Name
													can only contain text</div>  
														</div>









														<div class="col-xs-12">&nbsp;</div>

														<div class="col-xs-12">
															<div class="input-group input-group-sm">
																<span class="input-group-addon heading">Middle
																	name </span> <input style="width: 298px;" name="midName"
																	type="text" class="form-control rname"
																	placeholder="Middle name (Optional)"
																	ng-model="edit.midName" ng-maxlength="30"
																	ng-pattern="/^(\D)+$/" />
															</div>

														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.midName.$dirty && registerBasicForm.midName.$error.maxlength">Mid
													name cannot be more than 30 characters</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.midName.$dirty && registerBasicForm.midName.$error.pattern">Name
													can only contain text</div> 

														</div>
														<div class="col-xs-12">&nbsp;</div>

														<div class="col-xs-12">
															<div class="input-group input-group-sm">
																<span class="input-group-addon heading">Last name
																	</span> <input style="width: 298px;" name="lastName"
																	type="text" id="lastName" class="form-control rname"
																	placeholder="Last name" ng-model="edit.lastName"
																	 ng-maxlength="50" ng-pattern="/^(\D)+$/"
																	data-toggle='tooltip' data-placement='right'
																	title='Please enter lastname without special characters' />
															</div>

															<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.required">Last
													name is required</div>-->
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.maxlength">Last
													name cannot be more than 30 characters</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.pattern">Name
													can only contain text</div> 
														</div>

														<div class="col-xs-12">&nbsp;</div>

														<div class="col-xs-12">

															<div class="input-group input-group-sm">
																<span class="input-group-addon heading" style="width:98px;">Gender
																	*</span>
																<div class="form-group" style="margin-left: 10px;">


																	<label class="radio-inline"> <input
																		type="radio" name="genderMale" id="gender"
																		value="male" ng-model="edit.gender" required>Male
																	</label> <label class="radio-inline"> <input
																		type="radio" name="genderFemale" id="gender"
																		ng-model="edit.gender" value="female">Female
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
															<span class="input-group-addon heading"
																>Age*</span>
															<input name="age" type="text" id="age"
																style="width: 298px" class="form-control"
																placeholder="Age" required ng-model="edit.age"
																ng-value="personAge" ng-minlength=2 ng-maxlength=2
																ng-pattern="/^(\d)+$/" data-toggle='tooltip'
																data-placement='right'
																title='Age should be in number only' />

														</div>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="registerBasicForm.age.$dirty && registerBasicForm.age.$error.maxlength && registerBasicForm.age.$error.minlength">age
															should be of only two digit number</div>

														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="registerBasicForm.age.$dirty && registerBasicForm.age.$error.pattern">Age
															should be number only</div>
													</div> 
													
														<div class="col-xs-12">&nbsp;</div>

														<div class="col-xs-12">
															<div class="input-group input-group-sm">
																<span class="input-group-addon heading">Username
																	*</span> <input style="width: 298px;" name="userName"
																	type="text" id="userName" class="form-control"
																	placeholder="Username" ng-model="edit.userName"
																	required ng-maxlength="50" data-toggle='tooltip'
																	data-placement='right' disabled
																	title='Please enter Username' />
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
																<span class="input-group-addon heading">Email *</span> <input
																	style="width: 298px;" name="email" type="email"
																	id="email" maxlength=100
																	class="form-control remail email-input"
																	placeholder="Email" ng-model="edit.email" required
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
															<div class="input-group input-group-sm">
																<span class="input-group-addon heading">Landline</span>
																<input style="width: 298px;" name="homePhoneNo"
																	type="text" class="form-control"
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
																<span class="input-group-addon heading">Mobile</span>
																<input style="width: 298px;" name="mobile" type="text"
																	id="mobile" class="form-control" placeholder="Mobile"
																	ng-model="edit.mobile"  ng-minlength=10
																	ng-maxlength=10 ng-pattern="/^(\d)+$/"
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

														

														<div class="col-xs-12">&nbsp;</div>
													</div>
												</div>
												<!-- USER INFO END -->
											</div>

											<!-- PERSONAL INFO START -->
											<div class="col-xs-12 col-md-6">
												<div class="panel panel-default"
													style="border-style: none; background-color: #f5f5f5">
													<div class="panel-heading"
														style="border-style: none; font-family: arial; font-weight: bold;">Contact
														Information</div>
													<div class="panel-body personal-info"
														style="border-style: none; background-color: #f5f5f5;">

														<div class="col-xs-12">

															<div class="input-group input-group-sm">
																<label style="font-weight: 500;">Do you want to
																	display your number on your profile?</label>
																<div class="form-group">

																	<div class="col-sm-8">
																		<label class="radio-inline"> <input
																			type="radio" name="mobileYesNo" id="mobileYesNo"
																			value="Y" ng-model="edit.isMobile">Yes
																		</label> <label class="radio-inline"> <input
																			type="radio" name="mobileYesNo" id="mobileYesNo"
																			ng-model="edit.isMobile" ng-checked="true" value="N">No
																		</label>
																	</div>
																</div>
															</div>
														</div>
														<div class="col-xs-12">&nbsp;</div>
														<div class="col-xs-12">
															<div class="input-group input-group-sm">
																<span class="input-group-addon heading">Address *</span>
																<input style="width: 298px;" name="addrLn1" type="text"
																	id="addrLn1" class="form-control"
																	placeholder="Line 1(required)" ng-model="edit.addrLn1"
																	required ng-max-length="100" data-toggle='tooltip'
																	data-placement='right' title='Please enter address' />

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
																<span class="input-group-addon heading">District
																	*</span> <input style="width: 300px !important;"
																	name="district" type="text" id="district"
																	class="form-control" placeholder="District"
																	ng-model="edit.district" required ng-maxlength="100"
																	ng-pattern="/^(\D)+$/" data-toggle='tooltip'
																	data-placement='right'
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
																<span class="input-group-addon heading"
																	style="width: 92px !important;">State *</span>
																<!-- <select style="width: 300px !important;" id="state" name="state" class="form-control" onChange="populate(this.id,'city')" ng-model="edit.state" required>
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
																<input style="width: 280px;" name="state" type="text"
																	id="state" class="form-control" placeholder="State"
																	ng-model="edit.state" required ng-maxlength="100"
																	ng-pattern="/^(\D)+$/" data-toggle='tooltip'
																	data-placement='right'
																	title="Please enter a valid State" />
													
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
																<span class="input-group-addon heading"
																	style="width: 92px !important;">City *</span>
																<!-- <select style="width: 300px !important;" id="city" class="form-control" name="city"  ng-model="edit.city" required>
													<option ng-value="edit.city">{{edit.city}}</option>
													</select> -->
																<input style="width: 280px;" name="city" type="text"
																	id="city" class="form-control" placeholder="City"
																	ng-model="edit.city" required ng-maxlength="100"
																	ng-pattern="/^(\D)+$/" data-toggle='tooltip'
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
																<span class="input-group-addon heading">Country *</span>
																<input style="width: 298px;" name="country" type="text"
																	id="country" class="form-control" placeholder="Country"
																	ng-model="edit.country" required ng-maxlength="100"
																	ng-pattern="/^(\D)+$/" data-toggle='tooltip'
																	data-placement='right'
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
																<span class="input-group-addon heading">Pincode *</span>
																<input style="width: 300px !important;" name="pincode"
																	type="text" id="pincode" class="form-control"
																	placeholder="Pincode" ng-model="edit.pincode" required
																	ng-minlength="6" ng-maxlength="6"
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
												<a href="#"><input
													style="background-color: #5cb85c; border-color: #4cae4c;"
													type="submit" class="btn btn-primary reg-ctn-1"
													onclick="checkEmpty()" value="Continue"></a>
											</div>
										</form>
									</div>
								</div>

								<h3 class="reg-acc-2 acc-hover"
									ng-class="registerBasicForm.$invalid?'ui-state-disabled':'ui-state-default'"
									style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">Additional
									Information</h3>
								<div>
									<input name="userType" id="userType" type="hidden"
										style="display: none;" value="{{edit.userType}}">
									<form id="rfegisterAdditionalStudentForm"
										name="registerAdditionalStudentForm" method="post" novalidate>
										<div class="dynamic-div" id="student"
											ng-show="edit.userType=='student'">
											<div class="panel panel-default"
												style="border-style: none; background-color: #f5f5f5">
												<!-- <div id="profession" class="panel-heading">Student</div> -->
												<div class="panel-body"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Degree *</span> <input
																style="width: 310px;" id="studentdegree" maxlength=100
																name="degreeOfStudent" type="text" class="form-control"
																placeholder="Degree" ng-model="edit.degreeOfStudent"
																required ng-maxlength="100" ng-pattern="/^(\D)+$/"
																required data-toggle='tooltip' data-placement='right'
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
												<!-- 
													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Date of
																birth</span> <input style="width: 298px;"
																id="dateOfBirthDatePicker" name="dob" type="text"
																class="form-control" placeholder="Date of birth"
																ng-model="edit.dob" datepicker-angular 
																data-toggle='tooltip' data-placement='right'
																title="Please enter Date of birth" />
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
															<span class="input-group-addon heading">Student ID
																*</span> <input style="width: 310px;" name="studentID"
																type="text" id="studentID" class="form-control"
																placeholder="Student ID" ng-model="edit.studentID"
																required data-toggle='tooltip' data-placement='right'
																title="Please enter valid ID" />
														</div>
														<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.studentID.$dirty && registerAdditionalStudentForm.studentID.$error.required">Student
												ID is required</div> -->
													</div>
													
														<div class="col-xs-12">&nbsp;</div>
														
														
													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Branch *</span> <!-- <input
																type="text" class="form-control" id="branchIdOfStudent2"
																style="width: 285px;" ng-model="edit.branchIdOfStudent"> -->

															<input style="width: 310px;" class="form-control"
																ng-model="edit.branchIdOfStudent"
																id="branchIdOfStudent2"  /> <!-- <img alt="delete2" src="images/delete.png"
																ng-hide="showBranches()" ng-click="deleteBranches();" />
 -->
														</div>
													</div>
													
													<div class="col-xs-12 col-md-6">

														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">University
																*</span> <!-- <input style="width: 285px;" id="university"
																name="university" type="text" class="form-control"
																placeholder="University" ng-model="edit.university"
																required ng-maxlength="100" ng-pattern="/^(\D)+$/"
																required data-toggle='tooltip' data-placement='right'
																title="Please enter University" /> --> <input
																style="width: 310px;" class="form-control"
																ng-model="edit.university" id="university"
																/> <!-- <img
																alt="delete1" src="images/delete.png"
																ng-hide="showUniversity()"
																ng-click="deleteUniversity();" /> -->

														</div>



														<!-- 	<div class="input-group input-group-sm" >
												<span class="input-group-addon">University *</span> <input style="width: 186px !important;" id="university" name="university" type="text" 
													class="form-control" placeholder="University" ng-model="edit.university" required
													ng-maxlength="100" ng-pattern="/^(\D)+$/"  data-toggle='tooltip' data-placement='right' 
														title="Please enter  University"/>
														<input style="width: 186px !important;" class="form-control" ng-model="edit.university" id="university" ng-hide="showUniversity()"  readonly />
													   <img alt="delete" src="images/delete.png" class="photo" ng-hide="showUniversity()" ng-click="deleteUniversity();"/>
											</div> -->

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
													

													<!-- <div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon"
																style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Age*</span>
															<input name="age" type="text" id="age"
																style="width: 300px" class="form-control"
																placeholder="Age" required ng-model="edit.age"
																ng-value="personAge" ng-minlength=2 ng-maxlength=2
																ng-pattern="/^(\d)+$/" data-toggle='tooltip'
																data-placement='right'
																title='Age should be in number only' />

														</div>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="registerAdditionalStudentForm.age.$dirty && registerAdditionalStudentForm.age.$error.maxlength && registerAdditionalStudentForm.age.$error.minlength">age
															should be of only two digit number</div>

														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="registerAdditionalStudentForm.age.$dirty && registerAdditionalStudentForm.age.$error.pattern">Age
															should be number only</div>
													</div> -->

													

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6" id="clgState"
														>
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">State *</span> <input
																style="width: 310px;" name="collegeState" type="text"
																id="collegeState" class="form-control collegeState"
																placeholder="State" ng-model="edit.collegeState"
																required ng-maxlength="100" data-toggle='tooltip'
																data-placement='right'
																title="Please enter a valid State" />
														</div>

													</div>
													
													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">College
																name *</span> <!-- <input style="width: 285px;" id="CollegeNames"
																name="collge" type="text"
																class="form-control CollegeNames"
																placeholder="College name" ng-model="edit.collge"
																required ng-maxlength="100" ng-pattern="/^(\D)+$/"
																required data-toggle='tooltip' data-placement='right'
																title="Please enter College Name" /> --> <input
																style="width: 310px;" class="form-control"
																ng-model="edit.collge" id="CollegeNames"
																 /><!--  <img alt="delete"
																src="images/delete.png" ng-hide="showCollege()"
																ng-click="deleteCollege();" /> -->

														</div>
													</div>

													<!--   <div class="col-xs-12"> 
													<input type="text" class="form-control" placeholder="Search branches" id="branchIdOfStudent2"
														ng-model="register.branchIdOfStudent" ng-change="search()" value=""  required data-toggle='tooltip' data-placement='right' 
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


													
													<div class="col-xs-12">&nbsp;</div>
													
													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Completion
																Year *</span> <input style="width: 310px;"
																id="studentCompletionYear" name="completionYear"
																type="text" class="form-control"
																placeholder="Completion year"
																ng-model="edit.completionYear" datepicker-angular
																required data-toggle='tooltip' data-placement='right'
																title="Please enter Completion Year" />
															<!-- 	<span
													class="input-group-addon">YYYY-MM-DD</span> -->
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
															<span class="input-group-addon heading">Facebook
																ID</span> <input style="width: 310px;" name="facebookId"
																type="url" id="facebookId" class="form-control"
																placeholder="Facebook ID" ng-model="edit.faceBookId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid FacebookID" http-prefixfb/>
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>

													


													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Twitter ID</span>
															<input style="width: 310px;" name="twitterId" type="url"
																id="twitterId" class="form-control"
																placeholder="Twitter ID" ng-model="edit.twitterId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid TwitterID" http-prefixtwit/>
														</div>
													</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">LinkedIn
																ID</span> <input style="width:310px;" name="linkedInId"
																type="url" id="linkedInId" class="form-control"
																placeholder="LinkedIn ID" ng-model="edit.linkedinId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid linkedInID" http-prefixlink/>
														</div>
													</div>

												</div>
											</div>
										</div>
									</form>

									<form id="registerAdditionalCollegeForm"
										name="registerAdditionalCollegeForm" method="post" novalidate>
										<input name="userType" id="userType" type="hidden"
											style="display: none;" value="{{edit.userType}}">
										<div class="dynamic-div" id="college"
											ng-show="edit.userType=='college'">
											<div class="panel panel-default">
												<!-- <div id="profession" class="panel-heading">College</div> -->
												<div class="panel-body">
													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Contact
																Person Name *</span> <input style="width: 298px;"
																name="cntctPerNameofCollege" id="collegecontactname"
																type="text" class="form-control"
																placeholder="Contact Person Name"
																ng-model="edit.cntctPerNameofCollege" required
																ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
																data-placement='right' title="Please enter College Name" />
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
															<span class="input-group-addon heading">Principal
																name *</span> <input style="width: 298px;"
																name="prinicipalName" id="prinicipalName" type="text"
																class="form-control" placeholder="Principal name"
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

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">University
																*</span> <input style="width: 298px;"
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
															<span class="input-group-addon heading">Techpedia
																faculty *</span> <input style="width: 298px;"
																id="techpdaFactlyCoordtr" maxlength=100
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
															<span class="input-group-addon heading">Principal
																email *</span> <input style="width: 298px;"
																id="prinicipalEmail" name="prinicipalEmail"
																maxlength=100 type="email" class="form-control"
																placeholder="Principal email id"
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

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Website
																link *</span> <input style="width: 298px;" name="webpage"
																id="webpage" type="url" class="form-control"
																placeholder="College url" ng-model="edit.webpage"
																required data-toggle='tooltip' data-placement='right'
																title="Please enter Website link of college" />
														</div>

														<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.webpage.$dirty && registerAdditionalCollegeForm.webpage.$error.required">Please
												enter a valid URL</div> -->
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Facility
																offered *</span> <input style="width: 298px;"
																name="facilitiesOffrdToStudents"
																id="facilitiesOffrdToStudents" type="text"
																class="form-control"
																placeholder="Facility offered to students"
																ng-model="edit.facilitiesOffrdToStudents" required
																required data-toggle='tooltip' data-placement='right'
																title="Please enter Facility offered to students" />
														</div>
													</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Innovation
																club *</span> <input style="width: 298px;"
																id="cntctInfoForNatnlInnovnClub" maxlength=100
																name="cntctInfoForNatnlInnovnClub" type="text"
																class="form-control"
																placeholder="Innovation club contact info"
																ng-model="edit.cntctInfoForNatnlInnovnClub" required
																data-toggle='tooltip' data-placement='right'
																title="Please enter innovation club contact information" />
														</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>

													<!-- 	<div class="col-xs-12 col-md-6">
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
											
												<input id="hidden-logo-input" name="logo" type="file" class="logo" ng-model="register.logo" accept="image/*" 
													placeholder="Logo" style="display: none;" /><input type="text" name="logo" id="logoByte64Size" onclick="alert()"
												style="display: none;" />
													
											</div>
					
										</div>
									 -->
													<div class="col-xs-12">
														<div class="panel panel-default">
															<div class="panel-heading">
																<div class="btn-group">College Logo</div>
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
																		<img width=160 height=120 src='{{edit.logo}}'
																			class='photo1' alt='photo'">
																	</div>

																	<div class="col-xs-9">
																		<div class="col-xs-12">
																			<!-- <button class='takePhoto btn btn-info btn-sm'>Take photo</button> -->
																			<!-- <button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
															photo</button> -->
																			<input id='hidden-photo1-input' type='file'
																				accept='image*;capture=camera'
																				style='display: none;' ng-file="file1" base64 />
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
													</div>
												</div>
											</div>

										</div>
									</form>

									<form id="registerAdditionalFacultyForm"
										name="registerAdditionalFacultyForm" method="post" novalidate>

										<input name="userType" id="userType" type="hidden"
											style="display: none;" value="{{edit.userType}}">
										<div class="dynamic-div" id="faculty"
											ng-show="edit.userType=='faculty'">
											<div class="panel panel-default"
												style="border-style: none; background-color: #f5f5f5">
												<!-- <div id="profession" class="panel-heading">Faculty</div> -->
												<div class="panel-body"
													style="border-style: none; background-color: #f5f5f5;">

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Speciality
																*</span> <input style="width: 298px;" type="text"
																class="form-control" id="specializationOfFaculty2"
																ng-model="edit.specializationOfFaculty"
																style="width: 186px !important;" required
																data-toggle='tooltip' data-placement='right'
																title="Please enter specialised branch of faculty" /> <input
																style="width: 294px; !important;" class="form-control"
																ng-model="edit.projectBranchDescOfFaculty"
																ng-hide="showSpecializationOfFaculty()" readonly /> <img
																alt="delete1" src="images/delete.png"
																ng-hide="showSpecializationOfFaculty()"
																ng-click="deleteSpecializationOfFaculty();" />

														</div>
													</div>

													<div class="col-xs-12 col-md-6" id="facultyClgState"
														style="display: none;">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">State *</span> <input
																style="width: 298px;" name="collegeState1" type="text"
																id="collegeState1" class="form-control"
																placeholder="State" ng-model="edit.collegeState"
																required ng-maxlength="100" data-toggle='tooltip'
																data-placement='right'
																title="Please enter a valid State" />
														</div>

													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">College
																name *</span> <input style="width: 298px;"
																name="collgeOfFaculty" id="collgeOfFaculty" type="text"
																class="form-control" placeholder="College name"
																ng-model="edit.collgeOfFaculty" required
																ng-pattern="/^(\D)+$/" required required
																data-toggle='tooltip' data-placement='right'
																title="Please enter college of faculty" /> <input
																style="width: 294px; !important;" class="form-control"
																ng-model="edit.collgeOfFaculty" id="collgeOfFaculty"
																ng-hide="showCollgeOfFaculty()" readonly /> <img
																alt="delete1" src="images/delete.png"
																ng-hide="showCollgeOfFaculty()"
																ng-click="deleteCollgeOfFaculty();" />
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
															<span class="input-group-addon heading">Degree *</span> <input
																style="width: 298px;" id="facultydegree" maxlength=100
																name="degreeOfFaculty" type="text" class="form-control"
																placeholder="Degree" ng-model="edit.degreeOfFaculty"
																required ng-pattern="/^(\D)+$/" required
																data-toggle='tooltip' data-placement='right'
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
															<span class="input-group-addon heading">University
																*</span> <input style="width: 298px;"
																name="universityOfFaculty" id="universityOfFaculty"
																type="text" class="form-control"
																placeholder="University"
																ng-model="edit.universityOfFaculty" required
																ng-pattern="/^(\D)+$/" required data-toggle='tooltip'
																data-placement='right'
																title="Please enter University of faculty" /> <input
																style="width: 294px; !important;" class="form-control"
																ng-model="edit.universityOfFaculty"
																id="universityOfFaculty"
																ng-hide="showUniversityOfFaculty()" readonly /> <img
																alt="delete1" src="images/delete.png"
																ng-hide="showUniversityOfFaculty()"
																ng-click="deleteUniversityOfFaculty();" />
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
															<span class="input-group-addon heading">Experience
																*</span> <input style="width: 298px;"
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
															<span class="input-group-addon heading">Webpage
																link *</span> <input style="width: 298px;" name="psnlWebpgLink"
																id="psnlWebpgLink" type="url" class="form-control"
																placeholder="Personal webpage link"
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
															<span class="input-group-addon heading">Alumni *</span> <input
																style="width: 298px;" name="alumni" type="text"
																id="alumni" class="form-control" placeholder="Alumni"
																ng-model="edit.alumni" ng-pattern="/^(\D)+$/" required
																required data-toggle='tooltip' data-placement='right'
																title="Please enter alumni of faculty" />
														</div>

														<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.alumni.$dirty && registerAdditionalFacultyForm.alumni.$error.pattern">Alumni
												can only contain text</div> -->
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Association
																list *</span> <input style="width: 298px;"
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
															<span class="input-group-addon heading">Facebook
																ID</span> <input style="width: 298px;" name="facebookId"
																type="url" id="facebookId" class="form-control"
																placeholder="Facebook ID" ng-model="edit.faceBookId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid FacebookID" http-prefixfb/>
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Affiliated
																university *</span> <input style="width: 298px;"
																name="affltUniversityOfFaculty"
																id="affltUniversityOfFaculty" type="text"
																class="form-control"
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
															<span class="input-group-addon heading">Twitter ID</span>
															<input style="width: 298px;" name="twitterId" type="url"
																id="twitterId" class="form-control"
																placeholder="Twitter ID" ng-model="edit.twitterId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid TwitterID" http-prefixtwit/>
														</div>
													</div>




													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">LinkedIn
																ID</span> <input style="width: 298px;" name="linkedInId"
																type="url" id="linkedInId" class="form-control"
																placeholder="LinkedIn ID" ng-model="edit.linkedinId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid linkedInID" http-prefixlink />
														</div>
													</div>



												</div>
											</div>
										</div>
									</form>

									<form id="registerAdditionalMentorForm"
										name="registerAdditionalMentorForm" method="post" novalidate>
										<input name="userType" id="userType" type="hidden"
											style="display: none;" value="{{edit.userType}}">
										<div class="dynamic-div" id="mentor"
											ng-show="edit.userType=='mentor'">
											<div class="panel panel-default"
												style="border-style: none; background-color: #f5f5f5">
												<!-- <div id="profession" class="panel-heading">Mentor</div> -->
												<div class="panel-body"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Speciality
																*</span> <input style="width: 298px;" type="text"
																class="form-control" id="branchIdOfMentor2"
																ng-model="edit.branchIdOfMentor" required
																data-toggle='tooltip' data-placement='right'
																title="Please enter specialised branch of mentor" /> <input
																style="width: 294px !important;" type="text"
																class="form-control"
																ng-model="edit.projectBranchDescOfMentor"
																ng-hide="showBranchIdOfMentor2()" readonly /> <img
																alt="delete1" src="images/delete.png"
																ng-hide="showBranchIdOfMentor2()"
																ng-click="deleteBranchIdOfMentor2();" />

														</div>
													</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Designation
																*</span> <input style="width: 298px;"
																name="designationOfMentor" id="designationOfMentor"
																type="text" class="form-control"
																placeholder="Designation"
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
															<span class="input-group-addon heading">Degree *</span> <input
																style="width: 298px;" name="degreeOfMentor"
																id="degreeOfMentor" type="text" class="form-control"
																placeholder="Degree" ng-model="edit.degreeOfMentor"
																required ng-pattern="/^(\D)+$/" required
																data-toggle='tooltip' data-placement='right'
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
															<span class="input-group-addon heading">Facebook
																ID</span> <input style="width: 298px;" name="facebookId"
																type="url" id="facebookId" class="form-control"
																placeholder="Facebook ID" ng-model="edit.faceBookId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid FacebookID" http-prefixfb />
														</div>
													</div>



													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Webpage
																link *</span> <input style="width: 298px;" id="mentorwebpage"
																name="webpage" type="url" class="form-control"
																placeholder="Personal webpage link"
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
															<span class="input-group-addon heading">Twitter ID</span>
															<input style="width: 298px;" name="twitterId" type="url"
																id="twitterId" class="form-control"
																placeholder="Twitter ID" ng-model="edit.twitterId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid TwitterID" http-prefixtwit/>
														</div>
													</div>


													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Time spare
																*</span> <input style="width: 298px;"
																name="timeUspaceForMentoringPerMnth"
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
															<span class="input-group-addon heading">LinkedIn
																ID *</span> <input style="width: 298px;" name="linkedInId"
																type="url" id="linkedInId" class="form-control"
																placeholder="LinkedIn ID" ng-model="edit.linkedinId"
																data-toggle='tooltip' data-placement='right'
																title="Please enter valid linkedInID" http-prefixlink />
														</div>
													</div>


													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Mentor
																profile *</span>
															<textarea style="width: 298px;" rows="3" cols="32"
																name="mentorProfile" id="mentorProfile"
																placeholder="Mentor Profile"
																ng-model="edit.mentorProfile" style="resize:none;"
																required data-toggle='tooltip' data-placement='right'
																title="Please enter mentor profile" ng-maxlength=1000;></textarea>

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
															<span class="input-group-addon heading">Experience
																*</span>
															<!-- <input style="width:298px;"  name="professionalExperience" id="professionalExperience"
													type="text" class="form-control" placeholder="Professional experience in months"
								 					ng-model="edit.professionalExperience" required ng-pattern="/^(\d)+$/"  required required data-toggle='tooltip' data-placement='right' 
														title="Please enter proffesional experience in months of mentor"/> -->
															<textarea style="width: 298px;" rows="3" cols="32"
																name="professionalExperience"
																id="professionalExperience"
																placeholder="Professional experience"
																ng-model="edit.professionalExperience"
																style="resize:none;" required data-toggle='tooltip'
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
															<span class="input-group-addon heading">Interest *</span>
															<!--  <input  style="width:298px;" name="intOnGrassrtInnovators"  id="intOnGrassrtInnovators"
													type="text" class="form-control" placeholder="grass root innovators interest"
													ng-model="edit.intOnGrassrtInnovators" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter grass root innovators interest"/> -->
															<textarea style="width: 298px;" rows="3" cols="32"
																name="intOnGrassrtInnovators"
																id="intOnGrassrtInnovators"
																placeholder="grass root innovators interest"
																ng-model="edit.intOnGrassrtInnovators"
																style="resize:none;" required data-toggle='tooltip'
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
															<span class="input-group-addon heading">Commitment
																*</span>
															<!-- <input style="width:298px;"  id="commitmentUBringIn"
													maxlength=100 name="commitmentUBringIn" type="text" class="form-control"
													placeholder="Commitment you bring" ng-model="edit.commitmentUBringIn" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter commitment you bring"/> -->
															<textarea style="width: 298px;" rows="3" cols="32"
																name="commitmentUBringIn" id="commitmentUBringIn"
																placeholder="Commitment you bring"
																ng-model="edit.commitmentUBringIn" style="resize:none;"
																required data-toggle='tooltip' data-placement='right'
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
															Commitment Description cannot be more than 1000
															characters</div>
													</div>



													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12 col-md-6">
														<div class="input-group input-group-sm">
															<span class="input-group-addon heading">Association
																*</span>
															<!-- <input style="width:298px;"  maxlength=200
													name="institutionalAssctnInfo" id="institutionalAssctnInfo" type="text" class="form-control"
													placeholder="Institution association info" ng-model="edit.institutionalAssctnInfo" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter Institutional Association Info"/> -->
															<textarea style="width: 298px;" rows="3" cols="32"
																name="institutionalAssctnInfo"
																id="institutionalAssctnInfo"
																placeholder="Institution association info"
																ng-model="edit.institutionalAssctnInfo"
																style="resize:none;" required data-toggle='tooltip'
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

									<!-- <form id="registerAdditionalIndustryForm" name="registerAdditionalIndustryForm" method="post"
							novalidate>
							<div class="dynamic-div" id="industry" ng-show="register.userType=='industry'">
								<div class="panel panel-default">
									<div id="profession" class="panel-heading">Industry</div>
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Fax</span> <input name="fax" type="text"
													class="form-control" placeholder="Fax" ng-model="register.fax" required
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
													class="form-control" placeholder="Product range" ng-model="register.prdRng" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Support </span> <input name="kindOfSprtUProvideInnovtr"
													type="text" class="form-control" placeholder="Support provide to innovators"
													ng-model="register.kindOfSprtUProvideInnovtr" />
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Experties</span> <input maxlength=100
													name="techngyExprtizOffrToOthers" type="text" class="form-control"
													placeholder="Technological experties" ng-model="register.techngyExprtizOffrToOthers" />
											</div>
										</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Challenges</span> <input
													name="solnReqrdForTechnlgicalChlngs" type="text" class="form-control"
													placeholder="Solution required for technological challenges"
													ng-model="register.solnReqrdForTechnlgicalChlngs" />
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon"> Associate industries</span> <input
													name="associateIndustry" type="text" class="form-control"
													placeholder="Associate industries name (if any)" ng-model="register.associateIndustry" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Award</span> <input maxlength=100
													name="intrstToPoseInnovtnChlngAwrds" type="text" class="form-control"
													placeholder="Innovation chalenge awards"
													ng-model="register.intrstToPoseInnovtnChlngAwrds" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</form> -->
									<div class="col-xs-12">
										<!-- <a href="#" class="btn btn-primary reg-ctn-2"
								ng-disabled="registerAdditionalStudentForm.$invalid&&registerAdditionalCollegeForm.$invalid&&registerAdditionalFacultyForm.$invalid&&registerAdditionalMentorForm.$invalid"><span
								style="color: white;"></span></a> -->
										<a href="#"><input
											style="background-color: #5cb85c; border-color: #4cae4c;"
											type="submit" class="btn btn-primary reg-ctn-2"
											onclick="checkAdditionalEmpty()" value="Continue"></a>
									</div>
								</div>

								<h3 class="reg-acc-3 acc-hover"
									ng-class="registerAdditionalStudentForm.$valid||registerAdditionalCollegeForm.$valid||registerAdditionalFacultyForm.$valid||registerAdditionalMentorForm.$valid?'ui-state-default':'ui-state-disabled'"
									style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">Captcha</h3>
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
													<input class="form-control"
														placeholder="Enter the text here" type="text"
														name="jcaptcha" value="" ng-model="jCaptcha"
														style="width: 100%; margin-top: 8px" />
												</div>


											</div>
											<div class="col-xs-12 col-md-4">
												<!-- <a class="btn btn-primary reg-ctn-3" id="register"
											style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
											ng-click="registerSubmit()">Register</a> -->

												<button class="btn btn-primary" id="editProfile"
													style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
													ng-click="editProfile(jCaptcha)" ng-disabled="(!jCaptcha)"
													data-toggle="modal" data-target="#editProfileAlertModal">
													<i class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;Save
													Changes
												</button>
											</div>
											<input id="registertype" name="userType" type="hidden"
												ng-model="edit.userType" />
										</div>

									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="row error-place" style="display: none;">
						<div class="col-xs-12">
							<div class="panel panel-danger">

								<div class="panel-body error"></div>
							</div>
						</div>
					</div>
					<div class="alert alert-info" role="alert"
						ng-show="message.length>0" ng-repeat="msg in message">{{msg}}</div>

					<!-- Edit Profile alert -->
					<div class="modal fade" id="editProfileAlertModal" tabindex="-1"
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
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

</div>
<script type="text/javascript">
	$(".loaderBody").load(function() {
		$(".loaderBody").fadeOut("slow");
	})
</script>
</body>
<script>
	function checkEmpty() {
		var empty = null;

		$("input", registerBasicForm).each(
				function() {
					// empty = ($(this).val() == "") ? true : false;
					if ($.trim($("#firstName").val()) === ""
							/* || $.trim($("#lastName").val()) === "" */
							|| $.trim($("#userName").val()) === ""
							/* || $.trim($("#mobile").val()) === "" */
							|| $.trim($("#age").val()) === ""
							|| $.trim($("#addrLn1").val()) === ""
							|| $.trim($("#district").val()) === ""
							|| $.trim($("#city").val()) === ""
							|| $.trim($("#state").val()) === ""
							|| $.trim($("#country").val()) === ""
							|| $.trim($("#pincode").val()) === ""
							|| $.trim($("#email").val()) === "") {
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

	function checkAdditionalEmpty() {
		var empty = null;

		//alert($("#userType").val());
		if ($("#userType").val() == "student") {

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

		} else if ($("#userType").val() == "college") {
			$("input", registerAdditionalCollegeForm)
					.each(
							function() {
								//if($(this).val() === ""){
								if ($.trim($("#cntctInfoForNatnlInnovnClub")
										.val()) === ""
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
			if (empty === "isempty") {
				alert("Some of the field are empty . Please fill the * marked field ");
				return false;

			}
		}

		else if ($("#userType").val() == "faculty") {

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
		} else if ($("#userType").val() == "mentor") {
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
<script src="js/webrtc.js"></script>
<script src="js/logo.js"></script>
<script src="js/select2.min.js"></script>
<!-- <script src="https://www.google.com/recaptcha/api.js" async defer></script> -->
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
</html>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/customStyle.css">
<jsp:include page="template/footer.jsp" />
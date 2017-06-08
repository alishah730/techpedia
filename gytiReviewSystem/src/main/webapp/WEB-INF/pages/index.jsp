<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html ng-app="techpedia">
<title>Gyti Review System Login</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/three.js/r77/three.min.js"></script>
<script src="js/tween.min.js"></script>
<script src="js/TrackballControls.js"></script>
<script src="js/CSS3DRenderer.js"></script>



<link href="css/svgm.css" rel="stylesheet" type="text/css">
<style type="text/css">
#Reviewheader {
	background-color: #23282e;
	color: white;
	padding: 5px;
}

.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
}

.breadcrumb {
	background-color: #23282e;
	margin-bottom: 0px;
}

.borders {
	border: solid 1px balck;
	padding: 5px;
	box-shadow: 10px 10px 5px #888888;
	background-color: white;
}

.inputdemoIcons {
	/*
.right-icon {
  position: absolute;
  top: 4px;
  right: 2px;
  left: auto;
  margin-top: 0;
}
*/
	
}

.inputdemoIcons .inputIconDemo {
	min-height: 48px;
}

.inputdemoIcons md-input-container:not (.md-input-invalid ) >md-icon.email,
	.inputdemoIcons md-input-container:not (.md-input-invalid ) >md-icon.name
	{
	color: green;
}

.inputdemoIcons md-input-container:not (.md-input-invalid ) >md-icon.name
	{
	color: dodgerblue;
}

.inputdemoIcons md-input-container.md-input-invalid>md-icon.email,
	.inputdemoIcons md-input-container.md-input-invalid>md-icon.name {
	color: red;
}



html, body {
	height: 100%;
}

 body {
	background-color: #000000 !important;
	margin: 0;
	font-family: Helvetica, sans-serif;;
	overflow: hidden;
}

 a {
	color: #ffffff;
}

#info {
	position: absolute;
	width: 100%;
	color: #ffffff;
	padding: 5px;
	font-family: Monospace;
	font-size: 13px;
	font-weight: bold;
	text-align: center;
	z-index: 1;
}

#menu {
	position: absolute;
	bottom: 20px;
	width: 100%;
	text-align: center;
}

.element {
	width: 120px;
	height: 160px;
	box-shadow: 0px 0px 12px rgba(0, 255, 255, 0.5);
	border: 1px solid rgba(127, 255, 255, 0.25);
	text-align: center;
	cursor: default;
}

.element:hover {
	box-shadow: 0px 0px 12px rgba(0, 255, 255, 0.75);
	border: 1px solid rgba(127, 255, 255, 0.75);
}

.element .number {
	position: absolute;
	top: 20px;
	right: 20px;
	font-size: 12px;
	color: rgba(127, 255, 255, 0.75);
}

.element .symbol {
	position: absolute;
	top: 40px;
	left: 0px;
	right: 0px;
	font-size: 60px;
	font-weight: bold;
	color: rgba(255, 255, 255, 0.75);
	text-shadow: 0 0 10px rgba(0, 255, 255, 0.95);
}

.element .details {
	position: absolute;
	bottom: 15px;
	left: 0px;
	right: 0px;
	font-size: 12px;
	color: rgba(127, 255, 255, 0.75);
}

button {
	color: rgba(127, 255, 255, 0.75);
	background: transparent;
	outline: 1px solid rgba(127, 255, 255, 0.75);
	border: 0px;
	padding: 5px 10px;
	cursor: pointer;
}

button:hover {
	background-color: rgba(0, 255, 255, 0.5);
}

button:active {
	color: #000000;
	background-color: rgba(0, 255, 255, 0.75);
}


@media (max-width: 767px){
#container{
	margin-left: 0px !important
  }
}

 

</style>
</head>
<body class="content-wrapper" style="background-color: #f5f5f5">
	<div class="" style="padding-left: 0px; padding-right: 0px;">
		<jsp:include page="template/reviewHeader.jsp"></jsp:include>
	</div>
	<div id="sideNavPanel" class="col-xs-2"
		style="padding-left: 0px; padding-right: 0px; margin-left: 0px;">
		<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
	</div>

	 <!-- <svg id="svg-playground" height="100vh" class="col-xs-12 col-md-12" style="background-color:transparent;" >

    <circle class="simple-circle" cx="50" cy="50" r="100" stroke="transparent" stroke-width="3" fill="blue" />
	</svg> -->
	 <div id="container" style="margin-left: 20%"></div>
	<div ng-controller="reviewerLoginController" ng-init="InitLoad()"
		layout-padding ng-cloak class="inputdemoIcons">
		
		<div id="mainPanelBodyIndex" class="col-xs-4 col-md-4">
			
			<div class="">
				
				<div class="col-xs-12 borders"
					style="margin-right: 10px; margin-top: 15px;">

					<!-- 	<h4>Add Reviewer</h4> -->
					<h3>
						<i class="fa fa-reorder custom">&nbsp;&nbsp;Login</i>
					</h3>

					<div class="col-xs-12">&nbsp;&nbsp;</div>
					<form role="form" ng-submit="reviewerLogin()"
						id="reviewerLogin-form" name="reviewerLogin-form"
						style="padding-top: 5px;">

						<md-input-container class="md-block"> <md-icon
							md-svg-src="images/ic_email_24px.svg" class="email"></md-icon> <input
							ng-model="reviewer.emailId" name="email" id="email" type="email"
							placeholder="Email" ng-required="true" required minlength="10"
							maxlength="100" ng-pattern="/^.+@.+\..+$/" required> </md-input-container>
						<md-input-container class="md-block"> <md-icon
							md-svg-src="images/password.svg" class="name"></md-icon> <input
							ng-model="reviewer.password" type="password"
							placeholder="Password" ng-required="true" name="password"
							id="password" required> </md-input-container>
						<md-button class="md-primary pull-left" data-toggle="modal" data-target="#ForgotPasswordModal">Forgot Password</md-button>
						<md-button class="md-primary pull-left" data-toggle="modal" data-target="#ResetPasswordModal">Reset Password</md-button>
						<md-button ng-disabled="" class="md-raised md-primary pull-right"
							ng-click="reviewerLogin()">Login</md-button>
					</form>
					<div class="clearfix">&nbsp;</div>
					<div class="alert alert-sm alert-danger alert-dismissible"
						role="alert" ng-show="addMsgerror.length>0">
						<p ng-repeat="msg in addMsgerror">{{msg}}</p>
						&nbsp;OR&nbsp;
						<p ng-repeat=" msg1 in userNotFound">{{msg1}}</p>
					</div>
				</div>
				
			</div>

		</div>

		<!-- Forgot Password Modal -->
		<div class="modal fade" id="ForgotPasswordModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style=" border-bottom: 1px solid #ffffff;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 style="text-align: center;">
							<i class="fa fa-lock fa-5x"></i>
					</h3>
					<h2 class="text-center">Forgot Password?</h2>
						
						
					</div>
					<div class="modal-body">
						
						<div class="panel-body">

							<form class="form" name="forgotPasswordForm">
								<fieldset>
									<div class="form-group">
										<div class="input-group">
											 <span class="input-group-addon"><i
												class="glyphicon glyphicon-envelope color-blue"></i></span> <input
												id="emailId" name="emailId" placeholder="email address" ng-model="emailId"
												class="form-control" type="email" ng-pattern="/^.+@.+\..+$/" ng-required="true" required /> 
										</div>
										<span style="color: red"
												ng-show="forgotPasswordForm.emailId.$dirty"> <span
												ng-show="forgotPasswordForm.emailId.$error.required">
													Email is required.</span> <span
												ng-show="forgotPasswordForm.emailId.$error.pattern">Email
													is not valid.</span>
										</span>
									</div>
									<div class="form-group">
										<button class="btn btn-lg btn-primary btn-block" style="height:45px;" ng-click="forgotPassword()">Send My Password</button>
									</div>
								</fieldset>
							</form>

						</div>

					</div>
					<div class="modal-body"  id="messageSuccessDiv" ng-show="messageSuccess.length>0" ng-repeat="msg1 in messageSuccess"
									style="text-align: center;">
									<div
										class=" col-xs-12 xol-md-12 alert alert-success alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert">{{msg1}}</div>
					</div>
					<div class="modal-body" id="messageWarningDiv"  ng-show="messageWarning.length>0" ng-repeat="msg2 in messageWarning"
									style="text-align: center;">
									<div
										class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert">{{msg2}}</div>
					</div>
					<div class="modal-body" id="messageDiv" ng-show="message.length>0" ng-repeat="msg in message"
									style="text-align: center;">
									<div
										class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert">{{msg}}</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" ClickForgotPassword="ClickForgotPassword()">Close</button>
					</div>
				</div>

			</div>
		</div>
		
		
		
		<!--Reset Password Modal -->
		<div class="modal fade" id="ResetPasswordModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style=" border-bottom: 1px solid #ffffff;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					 <h3 style="color:black;font">Change Password <span class="extra-title muted"></span></h3>
						
						
					</div>
					<div class="modal-body">
						
						

							<form class="form" name="resetPasswordForm">
								<fieldset>
										<div class="form-group">
											<label for="userName">UserId</label>
											<input type="text" id="userName" name="userName" class="form-control" ng-model="PasswordResetVo.userName" 
											 ng-required="true" required>
										</div>
										<span style="color: red"
												ng-show="resetPasswordForm.userName.$dirty"> <span
												ng-show="resetPasswordForm.userName.$error.required">
													UserId is required.</span> 
										</span>
										
										<div class="form-group">
											<label for="oldpassword">Current Password</label>
											<input type="password" id="oldpassword" name="oldpassword" class="form-control" ng-model="PasswordResetVo.oldpassword"
											ng-pattern="/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%&^*-+ = /| < >{}]).{6,}$/"
											 ng-required="true" required>
									   </div>
									   <span style="color: red"
												ng-show="resetPasswordForm.oldpassword.$dirty"> <span
												ng-show="resetPasswordForm.oldpassword.$error.required">
													Current Password is required.</span> <span
												ng-show="resetPasswordForm.oldpassword.$error.pattern">Current Password
													is not valid.</span>
										</span>
										
									   <div class="form-group">
											<label for="newpassword">New Password</label>
											<input type="password" name="newpassword" id="newpassword" class="form-control" ng-model="PasswordResetVo.newpassword"
											 ng-pattern="/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%&^*-+ = /| < >{}]).{6,}$/" ng-required="true" required>
									   </div>
									   <span style="color: red"
												ng-show="resetPasswordForm.newpassword.$dirty"> <span
												ng-show="resetPasswordForm.newpassword.$error.required">
													New Password is required.</span> <span
												ng-show="resetPasswordForm.newpassword.$error.pattern">New Password
													is not valid.</span>
										</span>
								
								</fieldset>
							</form>

						

					</div>
					 <div class="modal-body"  id="messageResetSuccessDiv" ng-show="messageResetSuccess.length>0" ng-repeat="msg1 in messageResetSuccess"
									style="text-align: center;">
									<div
										class=" col-xs-12 xol-md-12 alert alert-success alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert">{{msg1}}</div>
					</div>
					<div class="modal-body" id="messageResetWarningDiv"  ng-show="messageResetWarning.length>0" ng-repeat="msg2 in messageResetWarning"
									style="text-align: center;">
									<div
										class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert">{{msg2}}</div>
					</div>
					<div class="modal-body" id="messageDiv" ng-show="message.length>0" ng-repeat="msg in message"
									style="text-align: center;">
									<div
										class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert">{{msg}}</div>
					</div> 
					<div class="modal-footer">
						        <button href="#" class="btn btn-info" data-dismiss="modal" aria-hidden="true" ng-click="ClickResetPassword()">Close</button>
						        <button href="#" class="btn btn-info" id="password_modal_save" ng-click="resetPassword()">Save changes</button>
					</div>
				</div>

			</div>
		</div>




	</div>
	
	<div id="menu">
			<!-- <button id="table">TABLE</button> -->
			<button id="sphere">SPHERE</button>
			<button id="helix">HELIX</button>
			<button id="grid">GRID</button>
		</div>
		
		<script>
			var table = [
			             	"H", "Gandhiyan", "Techpedia", 1, 1,
							"Y", "Young", "Techpedia", 18, 1,
							"T", "Technical", "Techpedia", 1, 2,
							"I", "Innovation", "Techpedia", 2, 2,
							
							"G", "Gandhiyan", "Techpedia", 13, 2,
							"Y", "Young", "Techpedia", 14, 2,
							"T", "Technical", "Techpedia", 15, 2,
							"I", "Innovation", "Techpedia", 16, 2,
							
							"G", "Gandhiyan", "Techpedia", 17, 2,
							"Y", "Young", "Techpedia", 18, 2,
							"T", "Technical", "Techpedia", 1, 3,
							"I", "Innovation", "Techpedia", 2, 3,
							
							"G", "Gandhiyan", "Techpedia", 13, 3,
							"Y", "Young", "Techpedia", 14, 3,
							"T", "Technical", "Techpedia", 15, 3,
							"I", "Innovation", "Techpedia", 16, 3,
							
							"G", "Gandhiyan", "Techpedia", 17, 3,
							"Y", "Young", "Techpedia", 18, 3,
							"T", "Technical", "Techpedia", 1, 4,
							"I", "Innovation", "Techpedia", 2, 4,
							
							"G", "Gandhiyan", "Techpedia", 3, 4,
							"Y", "Young", "Techpedia", 4, 4,
							"T", "Technical", "Techpedia", 5, 4,
							"I", "Innovation", "Techpedia", 6, 4,
							
							"G", "Gandhiyan", "Techpedia", 7, 4,
							"Y", "Young", "Techpedia", 8, 4,
							"T", "Technical", "Techpedia", 9, 4,
							"I", "Innovation", "Techpedia", 10, 4,
							
							"G", "Gandhiyan", "Techpedia", 11, 4,
							"Y", "Young", "Techpedia", 12, 4,
							"T", "Technical", "Techpedia", 13, 4,
							"I", "Innovation", "Techpedia", 14, 4,
							
							"G", "Gandhiyan", "Techpedia", 15, 4,
							"Y", "Young", "Techpedia", 16, 4,
							"T", "Technical", "Techpedia", 17, 4,
							"I", "Innovation", "Techpedia", 18, 4,
							
							"G", "Gandhiyan", "Techpedia", 1, 5,
							"Y", "Young", "Techpedia", 2, 5,
							"T", "Technical", "Techpedia", 3, 5,
							"I", "Innovation", "Techpedia", 4, 5,
							
							"G", "Gandhiyan", "Techpedia", 5, 5,
							"Y", "Young", "Techpedia", 6, 5,
							"T", "Technical", "Techpedia", 7, 5,
							"I", "Innovation", "Techpedia", 8, 5,
							
							"G", "Gandhiyan", "Techpedia", 9, 5,
							"Y", "Young", "Techpedia", 10, 5,
							"T", "Technical", "Techpedia", 11, 5,
							"I", "Innovation", "Techpedia", 12, 5,
							
							"G", "Gandhiyan", "Techpedia", 13, 5,
							"Y", "Young", "Techpedia", 14, 5,
							"T", "Technical", "Techpedia", 15, 5,
							"I", "Innovation", "Techpedia", 16, 5,
							
							"G", "Gandhiyan", "Techpedia", 17, 5,
							"Y", "Young", "Techpedia", 18, 5,
							"T", "Technical", "Techpedia", 1, 6,
							"I", "Innovation", "Techpedia", 2, 6,
							
							"G", "Gandhiyan", "Techpedia", 4, 9,
							"Y", "Young", "Techpedia", 5, 9,
							"T", "Technical", "Techpedia", 6, 9,
							"I", "Innovation", "Techpedia", 7, 9,
							
							"G", "Gandhiyan", "Techpedia", 8, 9,
							"Y", "Young", "Techpedia", 9, 9,
							"T", "Technical", "Techpedia", 10, 9,
							"I", "Innovation", "Techpedia", 11, 9,
							
							"G", "Gandhiyan", "Techpedia", 12, 9,
							"Y", "Young", "Techpedia", 13, 9,
							"T", "Technical", "Techpedia", 14, 9,
							"I", "Innovation", "Techpedia", 15, 9,
							
							"G", "Gandhiyan", "Techpedia", 16, 9,
							"Y", "Young", "Techpedia", 17, 9,
							"T", "Technical", "Techpedia", 18, 9,
							"I", "Innovation", "Techpedia", 4, 6,
							
							"G", "Gandhiyan", "Techpedia", 5, 6,
							"Y", "Young", "Techpedia", 6, 6,
							"T", "Technical", "Techpedia", 7, 6,
							"I", "Innovation", "Techpedia", 8, 6,
							
							"G", "Gandhiyan", "Techpedia", 9, 6,
							"Y", "Young", "Techpedia", 10, 6,
							"T", "Technical", "Techpedia", 11, 6,
							"I", "Innovation", "Techpedia", 12, 6,
							
							"G", "Gandhiyan", "Techpedia", 13, 6,
							"Y", "Young", "Techpedia", 14, 6,
							"T", "Technical", "Techpedia", 15, 6,
							"I", "Innovation", "Techpedia", 16, 6,
							
							"G", "Gandhiyan", "Techpedia", 17, 6,
							"Y", "Young", "Techpedia", 18, 6,
							"T", "Technical", "Techpedia", 1, 7,
							"I", "Innovation", "Techpedia", 2, 7,
							
							"G", "Gandhiyan", "Techpedia", 4, 10,
							"Y", "Young", "Techpedia", 5, 10,
							"T", "Technical", "Techpedia", 6, 10,
							"I", "Innovation", "Techpedia", 7, 10,
							
							"G", "Gandhiyan", "Techpedia", 8, 10,
							"Y", "Young", "Techpedia", 9, 10,
							"T", "Technical", "Techpedia", 10, 10,
							"I", "Innovation", "Techpedia", 11, 10,
							
							"G", "Gandhiyan", "Techpedia", 12, 10,
							"Y", "Young", "Techpedia", 13, 10,
							"T", "Technical", "Techpedia", 14, 10,
							"I", "Innovation", "Techpedia", 15, 10,
							
							"G", "Gandhiyan", "Techpedia", 16, 10,
							"Y", "Young", "Techpedia", 17, 10,
							"T", "Technical", "Techpedia", 18, 10,
							"I", "Innovation", "Techpedia", 4, 7,
							
							"G", "Gandhiyan", "Techpedia", 5, 7,
							"Y", "Young", "Techpedia", 6, 7,
							"T", "Technical","Techpedia", 7, 7,
							"I", "Innovation", "Techpedia", 8, 7,
							
							"G", "Gandhiyan", "Techpedia", 9, 7,
							"Y", "Young", "Techpedia", 10, 7,
							"T", "Technical", "Techpedia", 11, 7,
							"I", "Innovation", "Techpedia", 12, 7,
							
							"G", "Gandhiyan", "Techpedia", 13, 7,
							"Y", "Young", "Techpedia", 14, 7,
							"T", "Technical", "Techpedia", 15, 7,
							"I", "Innovation", "(293)", 16, 7,
							
							"T", "Techpedia", "Sristi", 17, 7,
							"S", "Sristi", "Sristi", 18, 7
				

				 			
				/* "H", "Hydrogen", "1.00794", 1, 1,
				"He", "Helium", "4.002602", 18, 1,
				"Li", "Lithium", "6.941", 1, 2,
				"Be", "Beryllium", "9.012182", 2, 2,
				"B", "Boron", "10.811", 13, 2,
				"C", "Carbon", "12.0107", 14, 2,
				"N", "Nitrogen", "14.0067", 15, 2,
				"O", "Oxygen", "15.9994", 16, 2,
				"F", "Fluorine", "18.9984032", 17, 2,
				"Ne", "Neon", "20.1797", 18, 2,
				"Na", "Sodium", "22.98976...", 1, 3,
				"Mg", "Magnesium", "24.305", 2, 3,
				"Al", "Aluminium", "26.9815386", 13, 3,
				"Si", "Silicon", "28.0855", 14, 3,
				"P", "Phosphorus", "30.973762", 15, 3,
				"S", "Sulfur", "32.065", 16, 3,
				"Cl", "Chlorine", "35.453", 17, 3,
				"Ar", "Argon", "39.948", 18, 3,
				"K", "Potassium", "39.948", 1, 4,
				"Ca", "Calcium", "40.078", 2, 4,
				"Sc", "Scandium", "44.955912", 3, 4,
				"Ti", "Titanium", "47.867", 4, 4,
				"V", "Vanadium", "50.9415", 5, 4,
				"Cr", "Chromium", "51.9961", 6, 4,
				"Mn", "Manganese", "54.938045", 7, 4,
				"Fe", "Iron", "55.845", 8, 4,
				"Co", "Cobalt", "58.933195", 9, 4,
				"Ni", "Nickel", "58.6934", 10, 4,
				"Cu", "Copper", "63.546", 11, 4,
				"Zn", "Zinc", "65.38", 12, 4,
				"Ga", "Gallium", "69.723", 13, 4,
				"Ge", "Germanium", "72.63", 14, 4,
				"As", "Arsenic", "74.9216", 15, 4,
				"Se", "Selenium", "78.96", 16, 4,
				"Br", "Bromine", "79.904", 17, 4,
				"Kr", "Krypton", "83.798", 18, 4,
				"Rb", "Rubidium", "85.4678", 1, 5,
				"Sr", "Strontium", "87.62", 2, 5,
				"Y", "Yttrium", "88.90585", 3, 5,
				"Zr", "Zirconium", "91.224", 4, 5,
				"Nb", "Niobium", "92.90628", 5, 5,
				"Mo", "Molybdenum", "95.96", 6, 5,
				"Tc", "Technetium", "(98)", 7, 5,
				"Ru", "Ruthenium", "101.07", 8, 5,
				"Rh", "Rhodium", "102.9055", 9, 5,
				"Pd", "Palladium", "106.42", 10, 5,
				"Ag", "Silver", "107.8682", 11, 5,
				"Cd", "Cadmium", "112.411", 12, 5,
				"In", "Indium", "114.818", 13, 5,
				"Sn", "Tin", "118.71", 14, 5,
				"Sb", "Antimony", "121.76", 15, 5,
				"Te", "Tellurium", "127.6", 16, 5,
				"I", "Iodine", "126.90447", 17, 5,
				"Xe", "Xenon", "131.293", 18, 5,
				"Cs", "Caesium", "132.9054", 1, 6,
				"Ba", "Barium", "132.9054", 2, 6,
				"La", "Lanthanum", "138.90547", 4, 9,
				"Ce", "Cerium", "140.116", 5, 9,
				"Pr", "Praseodymium", "140.90765", 6, 9,
				"Nd", "Neodymium", "144.242", 7, 9,
				"Pm", "Promethium", "(145)", 8, 9,
				"Sm", "Samarium", "150.36", 9, 9,
				"Eu", "Europium", "151.964", 10, 9,
				"Gd", "Gadolinium", "157.25", 11, 9,
				"Tb", "Terbium", "158.92535", 12, 9,
				"Dy", "Dysprosium", "162.5", 13, 9,
				"Ho", "Holmium", "164.93032", 14, 9,
				"Er", "Erbium", "167.259", 15, 9,
				"Tm", "Thulium", "168.93421", 16, 9,
				"Yb", "Ytterbium", "173.054", 17, 9,
				"Lu", "Lutetium", "174.9668", 18, 9,
				"Hf", "Hafnium", "178.49", 4, 6,
				"Ta", "Tantalum", "180.94788", 5, 6,
				"W", "Tungsten", "183.84", 6, 6,
				"Re", "Rhenium", "186.207", 7, 6,
				"Os", "Osmium", "190.23", 8, 6,
				"Ir", "Iridium", "192.217", 9, 6,
				"Pt", "Platinum", "195.084", 10, 6,
				"Au", "Gold", "196.966569", 11, 6,
				"Hg", "Mercury", "200.59", 12, 6,
				"Tl", "Thallium", "204.3833", 13, 6,
				"Pb", "Lead", "207.2", 14, 6,
				"Bi", "Bismuth", "208.9804", 15, 6,
				"Po", "Polonium", "(209)", 16, 6,
				"At", "Astatine", "(210)", 17, 6,
				"Rn", "Radon", "(222)", 18, 6,
				"Fr", "Francium", "(223)", 1, 7,
				"Ra", "Radium", "(226)", 2, 7,
				"Ac", "Actinium", "(227)", 4, 10,
				"Th", "Thorium", "232.03806", 5, 10,
				"Pa", "Protactinium", "231.0588", 6, 10,
				"U", "Uranium", "238.02891", 7, 10,
				"Np", "Neptunium", "(237)", 8, 10,
				"Pu", "Plutonium", "(244)", 9, 10,
				"Am", "Americium", "(243)", 10, 10,
				"Cm", "Curium", "(247)", 11, 10,
				"Bk", "Berkelium", "(247)", 12, 10,
				"Cf", "Californium", "(251)", 13, 10,
				"Es", "Einstenium", "(252)", 14, 10,
				"Fm", "Fermium", "(257)", 15, 10,
				"Md", "Mendelevium", "(258)", 16, 10,
				"No", "Nobelium", "(259)", 17, 10,
				"Lr", "Lawrencium", "(262)", 18, 10,
				"Rf", "Rutherfordium", "(267)", 4, 7,
				"Db", "Dubnium", "(268)", 5, 7,
				"Sg", "Seaborgium", "(271)", 6, 7,
				"Bh", "Bohrium", "(272)", 7, 7,
				"Hs", "Hassium", "(270)", 8, 7,
				"Mt", "Meitnerium", "(276)", 9, 7,
				"Ds", "Darmstadium", "(281)", 10, 7,
				"Rg", "Roentgenium", "(280)", 11, 7,
				"Cn", "Copernicium", "(285)", 12, 7,
				"Uut", "Unutrium", "(284)", 13, 7,
				"Fl", "Flerovium", "(289)", 14, 7,
				"Uup", "Ununpentium", "(288)", 15, 7,
				"Lv", "Livermorium", "(293)", 16, 7,
				"Uus", "Ununseptium", "(294)", 17, 7,
				"Uuo", "Ununoctium", "(294)", 18, 7 */
			];
			var camera, scene, renderer;
			var controls;
			var objects = [];
			var targets = { sphere: [], table: [],  helix: [], grid: [] };
			init();
			animate();
			function init() {
				camera = new THREE.PerspectiveCamera( 40, window.innerWidth / window.innerHeight, 1, 10000 );
				camera.position.z = 3000;
				scene = new THREE.Scene();
				// table
				for ( var i = 0; i < table.length; i += 5 ) {
					var element = document.createElement( 'div' );
					element.className = 'element';
					element.style.backgroundColor = 'rgba(0,127,127,' + ( Math.random() * 0.5 + 0.25 ) + ')';
					var number = document.createElement( 'div' );
					number.className = 'number';
					number.textContent ="V2.0";
					element.appendChild( number );
					var symbol = document.createElement( 'div' );
					symbol.className = 'symbol';
					symbol.textContent = table[ i ];
					element.appendChild( symbol );
					var details = document.createElement( 'div' );
					details.className = 'details';
					details.innerHTML = table[ i + 1 ] + '<br>' + table[ i + 2 ];
					element.appendChild( details );
					var object = new THREE.CSS3DObject( element );
					object.position.x = Math.random() * 4000 - 2000;
					object.position.y = Math.random() * 4000 - 2000;
					object.position.z = Math.random() * 4000 - 2000;
					scene.add( object );
					objects.push( object );
					//
					var object = new THREE.Object3D();
					object.position.x = ( table[ i + 3 ] * 140 ) - 1330;
					object.position.y = - ( table[ i + 4 ] * 180 ) + 990;
					targets.table.push( object );
				}
				// sphere
				var vector = new THREE.Vector3();
				for ( var i = 0, l = objects.length; i < l; i ++ ) {
					var phi = Math.acos( -1 + ( 2 * i ) / l );
					var theta = Math.sqrt( l * Math.PI ) * phi;
					var object = new THREE.Object3D();
					object.position.x = 800 * Math.cos( theta ) * Math.sin( phi );
					object.position.y = 800 * Math.sin( theta ) * Math.sin( phi );
					object.position.z = 800 * Math.cos( phi );
					vector.copy( object.position ).multiplyScalar( 2 );
					object.lookAt( vector );
					targets.sphere.push( object );
				}
				// helix
				var vector = new THREE.Vector3();
				for ( var i = 0, l = objects.length; i < l; i ++ ) {
					var phi = i * 0.175 + Math.PI;
					var object = new THREE.Object3D();
					object.position.x = 900 * Math.sin( phi );
					object.position.y = - ( i * 8 ) + 450;
					object.position.z = 900 * Math.cos( phi );
					vector.x = object.position.x * 2;
					vector.y = object.position.y;
					vector.z = object.position.z * 2;
					object.lookAt( vector );
					targets.helix.push( object );
				}
				// grid
				for ( var i = 0; i < objects.length; i ++ ) {
					var object = new THREE.Object3D();
					object.position.x = ( ( i % 5 ) * 400 ) - 800;
					object.position.y = ( - ( Math.floor( i / 5 ) % 5 ) * 400 ) + 800;
					object.position.z = ( Math.floor( i / 25 ) ) * 1000 - 2000;
					targets.grid.push( object );
				}
				//
				renderer = new THREE.CSS3DRenderer();
				renderer.setSize( window.innerWidth, window.innerHeight );
				renderer.domElement.style.position = 'absolute';
				document.getElementById( 'container' ).appendChild( renderer.domElement );
				//
				controls = new THREE.TrackballControls( camera, renderer.domElement );
				controls.rotateSpeed = 0.5;
				controls.minDistance = 500;
				controls.maxDistance = 6000;
				controls.addEventListener( 'change', render );
				var button = document.getElementById( 'table' );
				/* button.addEventListener( 'click', function ( event ) {
					transform( targets.table, 2000 );
				}, false ); */
				var button = document.getElementById( 'sphere' );
				button.addEventListener( 'click', function ( event ) {
					transform( targets.sphere, 2000 );
				}, false );
				var button = document.getElementById( 'helix' );
				button.addEventListener( 'click', function ( event ) {
					transform( targets.helix, 2000 );
				}, false );
				var button = document.getElementById( 'grid' );
				button.addEventListener( 'click', function ( event ) {
					transform( targets.grid, 2000 );
				}, false );
				transform( targets.sphere, 2000 );
				//transform( targets.table, 2000 );
				//
				window.addEventListener( 'resize', onWindowResize, false );
			}
			function transform( targets, duration ) {
				TWEEN.removeAll();
				for ( var i = 0; i < objects.length; i ++ ) {
					var object = objects[ i ];
					var target = targets[ i ];
					new TWEEN.Tween( object.position )
						.to( { x: target.position.x, y: target.position.y, z: target.position.z }, Math.random() * duration + duration )
						.easing( TWEEN.Easing.Exponential.InOut )
						.start();
					new TWEEN.Tween( object.rotation )
						.to( { x: target.rotation.x, y: target.rotation.y, z: target.rotation.z }, Math.random() * duration + duration )
						.easing( TWEEN.Easing.Exponential.InOut )
						.start();
				}
				new TWEEN.Tween( this )
					.to( {}, duration * 2 )
					.onUpdate( render )
					.start();
			}
			function onWindowResize() {
				camera.aspect = window.innerWidth / window.innerHeight;
				camera.updateProjectionMatrix();
				renderer.setSize( window.innerWidth, window.innerHeight );
				render();
			}
			function animate() {
				requestAnimationFrame( animate );
				TWEEN.update();
				controls.update();
			}
			function render() {
				renderer.render( scene, camera );
			}


			$("#").css("background-color", "yellow");
		</script>
		
		
		
		
	<script src="js/svgm.js"></script>
</body>
</html>
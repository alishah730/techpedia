<%@ page import="java.util.Random"%>
<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
 <style>
  .breadcrumb>li+li:before {
padding: 0 5px;
color: #ccc;
content: none;
} 

.input-group-addon, .input-group-btn {
width: 200px !important;
width: 200px !important;
}

.input-group-addon, .input-group-btn, .input-group .form-control {
display: table-cell;
width: 100%;
}
.row {
margin-right: -1px;
margin-left: -1px;
}
</style>
<div class="clearfix"></div>
<div class="container customFont borderRadius style">
<div class="page-container">
	<div class="page-sidebar-wrapper">
	
	</div>
	<div class="page-content-wrapper" ng-controller="RegisterController" ng-init="InitLoad()">
		<div class="page-content">
			<div class="row">
				<div class="col-md-11">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					<%String typeofuser = (String) request.getParameter("usertype"); %>
						<i class="fa fa-book" id="icon-size"></i>&nbsp;<span style="text-transform: capitalize;">Register - <%=typeofuser %></span>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li>Register</li>

						
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
	
			<!-- END PAGE HEADER-->

			<div class="row">
				<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="registerBasicForm|anyInvalidDirtyFields">Please verify red marked fields as they are mandatory fields</div>	
				<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="registerAdditionalStudentForm|anyInvalidDirtyFields">Please verify red marked fields as they are mandatory fields</div>
				<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="registerAdditionalCollegeForm|anyInvalidDirtyFields">Please verify red marked fields as they are mandatory fields</div>
				<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="registerAdditionalFacultyForm|anyInvalidDirtyFields">Please verify red marked fields as they are mandatory fields</div>
				<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="registerAdditionalMentorForm|anyInvalidDirtyFields">Please verify red marked fields as they are mandatory fields</div>
			</div>
			<div class="row">
			<div class="alert alert-sm alert-info alert-dismissible" role="alert" 
			ng-show="registerBasicForm|anyEmptyFields">Please fill ' * ' marked fields to proceed to next step</div>
			</div>
			<div class="clearfix"></div>
			<div class="row">
				<div id="accordion" class="col-xs-12">
					<h3 class="reg-acc-1 acc-hover  ">General Information</h3>
					<div>
						<p>
						<div>
							<form id="registerBasicForm" name="registerBasicForm" method="post" novalidate>
								<div class="col-xs-12">
								<div class="panel panel-default">
										<div class="panel-heading">Login Information</div>
										<div class="panel-body user-info">
										<div class="col-xs-12">
												<div class="input-group input-group-sm" >
													<span class="input-group-addon">Username *</span> <input name="userName" type="text" id="userName"
														class="form-control" placeholder="Username" ng-model="register.userName" required
														ng-maxlength="50" data-toggle='tooltip' data-placement='right' 
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
											<div class="input-group input-group-sm"  >
													<span class="input-group-addon">Password *</span> <input name="password" type="password" id="userPassword1"
														class="form-control" placeholder="Password" ng-model="register.password" required
														ng-model="register.confirmPassword" required ng-minlength="6" ng-maxlength="16" ng-pattern="/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%&^*-+ = /| < >{}]).{6,}$/" password-match="register.password" data-toggle='tooltip' data-placement='right' 
														title='Password should contain a minimum of 6 and a maximun of 16 characters with atleast one numeric value and one special character excluding (,.[]_\-)'/>
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.required">Password
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.minlength">Password
													must be more than 6 characters long</div>-->
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.pattern">Password should contain a minimum of 6 and a maximun of 16 characters with atleast one numeric value and one special character excluding (,.[]_\-)</div> 
													

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12" >
											<div class="input-group input-group-sm" >
													<span class="input-group-addon">Confirm *</span> <input name="confirmPassword"
														type="password" class="form-control" placeholder="Confirm password" id="confirmPassword"
														ng-model="register.confirmPassword" required ng-minlength="6" ng-maxlength="16"  ng-pattern="/^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%&^*+ = /| < >{}]).{6,}$/" password-match="register.password" data-toggle='tooltip' data-placement='right' 
														title='Password & Confirm password should be same '/>
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
										<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Email *</span> <input name="email" type="email" id="email"
														maxlength=100 class="form-control remail email-input" placeholder="Email"
														ng-model="register.email" required data-toggle='tooltip' data-placement='right' 
														title="Please enter valid email as a@a.com" />
												</div>
												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.email.$dirty && registerBasicForm.email.$error.required">Email
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.email.$dirty && registerBasicForm.email.$error.email">Email
													is not valid</div> -->

											</div>
										</div>
										</div>
							
</div>
								<div class="col-xs-12 col-md-6">
									<!-- USER INFO START -->
									<div class="panel panel-default">
										<div class="panel-heading">User Information</div>
										<div class="panel-body user-info">
											<div class="col-xs-12">
												 <div class="input-group input-group-sm " >
													<span class="input-group-addon"> First name *</span> 
													<input name="firstName" type="text" id="firstName"
														 class="form-control rname my-tooltip" placeholder="First name" ng-model="register.firstName"
														required ng-maxlength="50" ng-pattern="/^(\D)+$/" data-toggle='tooltip' data-placement='right' 
														title='Please enter firstname without special characters' />
														
												</div> 
												
			<!--  <div class="input-group input-group-sm" ng-class="{ 'has-error' : registerBasicForm.firstName.$invalid && !registerBasicForm.firstName.$pristine }">									 
			
        <span class="input-group-addon">First name *</span>
        <input type="text" name="firstName" class="form-control" ng-model="user.name" required  data-toggle="tooltip" data-original-title="Default tooltip">
       
    </div> 
     <p ng-show="registerBasicForm.firstName.$invalid && !registerBasicForm.firstName.$pristine"  data-toggle="tooltip" data-original-title="Default tooltip">  -->
											
										<!-- 		 <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.required">First
													name is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.maxlength">First
													name cannot be more than 30 characters</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.pattern">Name
													can only contain text</div>  -->
											</div>
											







											
										<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm" >
													<span class="input-group-addon">Middle name </span> <input name="midName" type="text"
														class="form-control rname" placeholder="Middle name (Optional)"
														ng-model="register.midName" ng-maxlength="30" ng-pattern="/^(\D)+$/" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.midName.$dirty && registerBasicForm.midName.$error.maxlength">Mid
													name cannot be more than 30 characters</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.midName.$dirty && registerBasicForm.midName.$error.pattern">Name
													can only contain text</div> -->

											</div>
											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm" >
													<span class="input-group-addon">Last name *</span> <input name="lastName" type="text" id="lastName"
														class="form-control rname" placeholder="Last name" ng-model="register.lastName"
														required ng-maxlength="50" ng-pattern="/^(\D)+$/" data-toggle='tooltip' data-placement='right' 
														title='Please enter lastname without special characters'/>
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.required">Last
													name is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.maxlength">Last
													name cannot be more than 30 characters</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.pattern">Name
													can only contain text</div> -->
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
										
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Mobile *</span> <input name="mobile" type="text" id="mobile"
														class="form-control" placeholder="Mobile" ng-model="register.mobile" required
														ng-minlength=10 ng-maxlength=10  ng-pattern="/^(\d)+$/" data-toggle='tooltip' data-placement='right' 
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

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Landline</span> <input name="homePhoneNo" type="text"
														class="form-control" placeholder="Landline (if any)" ng-model="register.homePhoneNo"
														ng-maxlength="15" ng-pattern="/^(\d)+$/" />
												</div>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.homePhoneNo.$dirty && registerBasicForm.homePhoneNo.$error.maxlength">Landline
													number must be less than 15 digits</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.homePhoneNo.$dirty && registerBasicForm.homePhoneNo.$error.pattern">Landline
													number must contain only digits</div> -->

											</div>

											<div class="col-xs-12"></div>
										</div>
									</div>
									<!-- USER INFO END -->
								</div>

								<!-- PERSONAL INFO START -->
								<div class="col-xs-12 col-md-6">
									<div class="panel panel-default">
										<div class="panel-heading">Contact Information</div>
										<div class="panel-body personal-info">

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Address *</span> <input name="addrLn1" type="text" id="addrLn1"
														class="form-control" placeholder="Line 1(required)" ng-model="register.addrLn1" required
														ng-max-length="100" data-toggle='tooltip' data-placement='right'
														title='Please enter address'/>

													<div class="col-xs-12">&nbsp;</div>

													<input name="addrLn2" type="text" class="form-control" ng-model="register.addrLn2"
														ng-max-length="100" placeholder="Line 2(optional)" />
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
											<div class="input-group input-group-sm" >
													<span class="input-group-addon">District *</span> <input name="district" type="text" id="district"
														class="form-control" placeholder="District" ng-model="register.district" required
														ng-maxlength="100" ng-pattern="/^(\D)+$/" data-toggle='tooltip' data-placement='right' 
														title="Please enter a valid district"/>
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
											<div class="input-group input-group-sm" >
													<span class="input-group-addon">City *</span> <input name="city" type="text" id="city"
														class="form-control" placeholder="City" ng-model="register.city" required 
														ng-maxlength="100" ng-pattern="/^(\D)+$/" data-toggle='tooltip' data-placement='right' 
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
													<span class="input-group-addon">State *</span> <input name="state" type="text" id="state"
														class="form-control" placeholder="State" ng-model="register.state" required
														ng-maxlength="100" ng-pattern="/^(\D)+$/" data-toggle='tooltip' data-placement='right' 
														title="Please enter a valid State"/>
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
													<span class="input-group-addon">Country *</span> <input name="country" type="text" id="country"
														class="form-control" placeholder="Country" ng-model="register.country" required
														ng-maxlength="100" ng-pattern="/^(\D)+$/" data-toggle='tooltip' data-placement='right' 
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
											<div class="input-group input-group-sm" >
													<span class="input-group-addon">Pincode *</span> <input name="pincode" type="text" id="pincode"
														class="form-control" placeholder="Pincode" ng-model="register.pincode" required
														ng-minlength="6" ng-maxlength="6" ng-pattern="/^(\d)+$/" data-toggle='tooltip' data-placement='right' 
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
											
											<div class="col-xs-12">&nbsp;</div>
										</div>
									</div>
								</div>

								 <div class="col-xs-12">
									<div class="panel panel-default">
										<div class="panel-heading">
											<div class="btn-group">Photograph</div>
										</div>
										<div class="panel-body photoRTC">
											<input ng-model="register.photo" type="text" name="photo" id="photoByte64"
												style="display: none;" /> <input type="text" name="photo" id="photoByte64Size"
												style="display: none;" />
											<canvas class='canvas' width='160' height='120' style='display: none;'></canvas>
											<div class="col-xs-12">
												<div class="col-xs-3">
													<!-- <video class='live' width='160' height='120' autoplay></video> -->
													<img width=160 height=120 src='images/gravatar.png' class='photo' alt='photo'
														>
												</div>

												<div class="col-xs-9">
													<div class="col-xs-12">
														<!-- <button class='takePhoto btn btn-info btn-sm'>Take photo</button>
														<button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
															photo</button> -->
														<input id='hidden-photo-input' type='file' accept='image*;capture=camera'
															style='display: none;' ng-file="file" base64 />
													</div>
													<div class="col-xs-12">&nbsp;</div>
													
														<button class='btn btn-sm btn-info' onclick="$('#hidden-photo-input').click();">Upload photo</button>
														<div class="col-xs-12" ng-show="msg.size.length>0">File size cannot be more than 10 KB</div>
							<div class="col-xs-12" ng-show="message.length>0">
								<div ng-repeat="msg in message">{{msg}}</div>
													</div>
													
												</div>
											</div>
										</div>
									</div>
								</div>
								 <div class="col-xs-12">
<!-- 									
<a href="#" class="btn btn-primary reg-ctn-1" onclick="checkEmpty()"><span
										style="color: white;">Continue</span></a> -->
										<a href="#"><input type="submit" class="btn btn-primary reg-ctn-1" onclick="checkEmpty()" value="Continue"></a>
								</div>
							</form>
						</div>
					</div>

					<h3 class="reg-acc-2 acc-hover"
						ng-class="registerBasicForm.$invalid?'ui-state-disabled':'ui-state-default'">Additional
						Information</h3>
					<div>
						
						<form id="rfegisterAdditionalStudentForm" name="registerAdditionalStudentForm" method="post"
							novalidate>
							
							<div class="dynamic-div" id="student" ng-show="register.userType=='student'">
								<div class="panel panel-default">
									<!-- <div id="profession" class="panel-heading">Student</div> -->
									<input name="userType1" id="userType1" type="hidden" style="display: none;" value="<%=typeofuser %>">
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Degree *</span> <input id="studentdegree" maxlength=100
													name="degreeOfStudent" type="text" class="form-control" placeholder="Degree"
													ng-model="register.degreeOfStudent" required ng-maxlength="100" ng-pattern="/^(\D)+$/" required data-toggle='tooltip' data-placement='right' 
														title="Please enter valid degree" />
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

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Date of birth *</span> <input id="dateOfBirthDatePicker"
													name="dob" type="text" class="form-control" placeholder="Date of birth"
													ng-model="register.dob" datepicker-angular required style="width: 217px;" required data-toggle='tooltip' data-placement='right' 
														title="Please enter date of Birth"/><span class="input-group-addon">YYYY-MM-DD</span>

												<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerAdditionalStudentForm.dob.$dirty && registerAdditionalStudentForm.dob.$error.required">DOB
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerAdditionalStudentForm.dob.$dirty && registerAdditionalStudentForm.dob.$error.date">Not
													a valid date</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerAdditionalStudentForm.dob.$dirty && registerAdditionalStudentForm.dob.$error.minlength || registerAdditionalStudentForm.dob.$error.maxlength">Improper
													date format</div> -->
											</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Student ID *</span> <input name="studentID" type="text" id="studentID"
													class="form-control" placeholder="Student ID" ng-model="register.studentID"  required data-toggle='tooltip' data-placement='right' 
														title="Please enter valid ID"/>
											</div>
											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.studentID.$dirty && registerAdditionalStudentForm.studentID.$error.required">Student
												ID is required</div> -->
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Completion Year *</span> <input
													id="studentCompletionYear" name="completionYear" type="text" class="form-control"
													placeholder="Completion year" ng-model="register.completionYear" datepicker-angular  required style="width: 217px;" required data-toggle='tooltip' data-placement='right' 
														title="Please enter degree completion year"/><span
													class="input-group-addon" >YYYY-MM-DD</span>
											</div>
											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.completionYear.$dirty && registerAdditionalStudentForm.completionYear.$error.required">Student
												ID is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.completionYear.$dirty && registerAdditionalStudentForm.completionYear.$error.required">Improper
												date format</div> -->
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">College name *</span><!--  <input id="CollegeNames"
													name="collge" type="text" class="form-control" placeholder="College name"
													ng-model="register.collge" required ng-maxlength="100" ng-pattern="/^(\D)+$/"
													
													required data-toggle='tooltip' data-placement='right' 
														title="Please enter College Name" /> -->
														<input style="width: 180px !important;" type="text" class="form-control" placeholder="Search Colleges" id="CollegeNames"
														ng-model="register.collge" value="" required data-toggle='tooltip' data-placement='right' 
														title="Please enter your college name">
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
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">University *</span> <input style="width: 180px !important;"name="university" type="text" id="university"
													class="form-control" placeholder="University" ng-model="register.university" required
													ng-maxlength="100" ng-pattern="/^(\D)+$/"  data-toggle='tooltip' data-placement='right' 
														title="Please enter  University"/>
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
												<span class="input-group-addon">Branch *</span>
												
													<input style="width: 180px !important;" type="text" class="form-control" placeholder="Search branches" ng-model="register.branchIdOfStudent" id="branchIdOfStudent2"
														  value=""  required data-toggle='tooltip' data-placement='right' 
														title="Please enter Branch">
												  
												<!--  <div class="col-xs-12">
													<input type="text" class="form-control" placeholder="Search branches" id="branchIdOfStudent2"
														ng-model="searchTerm" ng-change="search()" value="" />
												</div> -->
									<!-- 	 <div class="col-xs-12" >
													<select id="branchIdOfStudent" class="form-control"
														ng-model="register.branchIdOfStudent" 
														ng-options="item.branchId as item.projBranchDesc for item in data" >
													</select>
												</div>  -->
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>

						<form id="registerAdditionalCollegeForm" name="registerAdditionalCollegeForm" method="post"
							novalidate>
							<input name="userType1" id="userType1" type="hidden" style="display: none;" value="<%=typeofuser %>">
							<div class="dynamic-div" id="college" ng-show="register.userType=='college'">
								<div class="panel panel-default">
									<!-- <div id="profession" class="panel-heading">College</div> -->
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Contact Person  Name *</span> <input name="cntctPerNameofCollege" id="collegecontactname"
													type="text" class="form-control" placeholder="Contact Person Name"
													ng-model="register.cntctPerNameofCollege" required ng-pattern="/^(\D)+$/" required   data-toggle='tooltip' data-placement='right' 
														title="Please enter Contact Person Name"/>
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
												<span class="input-group-addon">Principal name *</span> <input name="prinicipalName" id="prinicipalName"
													type="text" class="form-control" placeholder="Principal name"
													ng-model="register.prinicipalName" required ng-pattern="/^(\D)+$/" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter Principal Name of college"/>
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
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">University *</span>  <input name="affltUniversityOfCollege" id="affltUniversityOfCollege"
													type="text" class="form-control" placeholder="University name"
													ng-model="register.affltUniversityOfCollege" required ng-pattern="/^(\D)+$/"   required data-toggle='tooltip' data-placement='right' 
														title="Please enter University of college"/> 
													 
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
												<span class="input-group-addon">Techpedia faculty *</span> <input id="techpdaFactlyCoordtr"
													maxlength=100 name="techpdaFactlyCoordtr" type="text" class="form-control"
													placeholder="Techpedia faculty co-ordinator" ng-model="register.techpdaFactlyCoordtr"
													required ng-pattern="/^(\D)+$/" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter Techpedia registered Faculty of college"/>
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
												<span class="input-group-addon">Principal email *</span> <input id="prinicipalEmail"
													name="prinicipalEmail" maxlength=100 type="email" class="form-control"
													placeholder="Principal email id" ng-model="register.prinicipalEmail"  required  data-toggle='tooltip' data-placement='right' 
														title="Please enter Principal Email"/>
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalEmail.$dirty && registerAdditionalCollegeForm.prinicipalEmail.$error.required">Principal
												email is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalEmail.$dirty && registerAdditionalCollegeForm.prinicipalEmail.$error.email">Not
												a valid email</div> -->
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Website link *</span> <input name="webpage" id="webpage" type="url"
													class="form-control" placeholder="College url" ng-model="register.webpage" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter Website link of college"/>
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.webpage.$dirty && registerAdditionalCollegeForm.webpage.$error.required">Please
												enter a valid URL</div> -->
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Facility offered *</span> <input
													name="facilitiesOffrdToStudents" id="facilitiesOffrdToStudents" type="text" class="form-control"
													placeholder="Facility offered to students"
													ng-model="register.facilitiesOffrdToStudents" required required data-toggle='tooltip' data-placement='right' 
														title="Please enter Facility offered to students" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Innovation club *</span> <input id="cntctInfoForNatnlInnovnClub"
													maxlength=100 name="cntctInfoForNatnlInnovnClub" type="text" class="form-control"
													placeholder="Innovation club contact info"
													ng-model="register.cntctInfoForNatnlInnovnClub" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter innovation club contact information" />
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>

										<!-- <div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">College description *</span> <input
													id="collegeDesc" name="collegeDesc" type="text" class="form-control"
													placeholder="College description" ng-model="register.collegeDesc" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter college description"/>
											</div>
										</div> -->

										<!-- <div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">College Logo</span> 
											<input ng-model="register.logo" type="text" name="logo" id="logoByte64"
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
											<input ng-model="register.logo" type="text" name="logo" id="photo1Byte64"
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
						</form>

						<form id="registerAdditionalFacultyForm" name="registerAdditionalFacultyForm" method="post"
							novalidate>
							<input name="userType1" id="userType1" type="hidden" style="display: none;" value="<%=typeofuser %>">
							<div class="dynamic-div" id="faculty" ng-show="register.userType=='faculty'">
								<div class="panel panel-default">
									<!-- <div id="profession" class="panel-heading">Faculty</div> -->
									<div class="panel-body">

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Degree *</span> <input id="facultydegree" maxlength=100
													name="degreeOfFaculty" type="text" class="form-control" placeholder="Degree"
													ng-model="register.degreeOfFaculty" required ng-pattern="/^(\D)+$/" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter degree of faculty"/>
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.degreeOfFaculty.$dirty && registerAdditionalFacultyForm.degreeOfFaculty.$error.required">Faculty
												degree is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.degreeOfFaculty.$dirty && registerAdditionalFacultyForm.degreeOfFaculty.$error.pattern">Faculty
												degree can only contain text</div> -->
										</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">College name *</span> <input style="width: 173px;" name="collgeOfFaculty" id="collgeOfFaculty"
													type="text" class="form-control" placeholder="College name"
													ng-model="register.collgeOfFaculty" required ng-pattern="/^(\D)+$/" required required data-toggle='tooltip' data-placement='right' 
														title="Please enter college of faculty"/>
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.collgeOfFaculty.$dirty && registerAdditionalFacultyForm.collgeOfFaculty.$error.required">Faculty
												college is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.collgeOfFaculty.$dirty && registerAdditionalFacultyForm.collgeOfFaculty.$error.pattern">Faculty
												college can only contain text</div> -->
										</div>
										

													
						

										<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Speciality *</span>
										
													<input style="width: 173px;" type="text" class="form-control" placeholder="Search branches" id="specializationOfFaculty2"
														ng-model="register.specializationOfFaculty"  value=""  required data-toggle='tooltip' data-placement='right' 
														title="Please enter specialised branch of faculty"/>
												
												
												
												
																							<!-- <div class="col-xs-12">
											<select class="form-control" ng-model="register.specializationOfFaculty" 
													ng-options="item.branchId as item.projBranchDesc for item in data">
 													</select> 
												</div>  -->
											</div>
										</div>
													<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">University *</span> <input style="width: 173px;" name="universityOfFaculty" id="universityOfFaculty"
													type="text" class="form-control" placeholder="University"
													ng-model="register.universityOfFaculty" required ng-pattern="/^(\D)+$/" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter University of faculty"/>
											</div>
											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.universityOfFaculty.$dirty && registerAdditionalFacultyForm.universityOfFaculty.$error.required">University
												is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.universityOfFaculty.$dirty && registerAdditionalFacultyForm.universityOfFaculty.$error.pattern">University
												can only contain text</div> -->
										</div>	
										<div class="col-xs-12">&nbsp;</div>
										
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">Experience *</span> <input name="proffesionalExpOfFaculty" id="proffesionalExpOfFaculty"
													type="text" class="form-control" placeholder="Profeesional experience in months"
													ng-model="register.proffesionalExpOfFaculty" ng-pattern="/^(\d)+$/"  required data-toggle='tooltip' data-placement='right' 
														title="Please enter experience of faculty" />
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.proffesionalExpOfFaculty.$dirty && registerAdditionalFacultyForm.proffesionalExpOfFaculty.$error.pattern">Experience
												can only contain digits</div> -->
										</div>
										
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">Webpage link *</span> <input name="psnlWebpgLink" id="psnlWebpgLink"
													type="url" class="form-control" placeholder="Personal webpage link"
													ng-model="register.psnlWebpgLink"  required data-toggle='tooltip' data-placement='right' 
														title="Please enter personal webpage link"/>
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.psnlWebpgLink.$dirty && registerAdditionalFacultyForm.psnlWebpgLink.$error.url">Not
												a valid URL</div> -->
										</div>

										<div class="col-xs-12">&nbsp;</div>
										
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">Alumni *</span> <input name="alumni" type="text" id="alumni"
													class="form-control" placeholder="Alumni" ng-model="register.alumni"
													ng-pattern="/^(\D)+$/" required required data-toggle='tooltip' data-placement='right' 
														title="Please enter alumni of faculty"/>
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.alumni.$dirty && registerAdditionalFacultyForm.alumni.$error.pattern">Alumni
												can only contain text</div> -->
										</div>
                                    <div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">Association list *</span> <input
													id="facultycompletionyear" maxlength=100 name="memshipInAssocns" type="text"
													class="form-control" placeholder="Association or membership name list"
													ng-model="register.memshipInAssocns" required required data-toggle='tooltip' data-placement='right' 
														title="Please enter Association or membership name list"/>
											</div>
										</div>
										

										<div class="col-xs-12">&nbsp;</div>
										
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">Affiliated university *</span> <input
													name="affltUniversityOfFaculty" id="affltUniversityOfFaculty" type="text" class="form-control"
													placeholder="Affiliated university name" ng-model="register.affltUniversityOfFaculty"
													ng-pattern="/^(\D)+$/" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter Affilated University of faculty" />
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.affltUniversityOfFaculty.$dirty && registerAdditionalFacultyForm.affltUniversityOfFaculty.$error.pattern">Aff.
												University can only contain text</div> -->
										</div>
										
									</div>
								</div>
							</div>
						</form>

						<form id="registerAdditionalMentorForm" name="registerAdditionalMentorForm" method="post"
							novalidate>
							<input name="userType1" id="userType1" type="hidden" style="display: none;" value="<%=typeofuser %>">
							<div class="dynamic-div" id="mentor" ng-show="register.userType=='mentor'">
								<div class="panel panel-default">
									<!-- <div id="profession" class="panel-heading">Mentor</div> -->
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Degree *</span> <input name="degreeOfMentor"  id="degreeOfMentor" type="text"
													class="form-control" placeholder="Degree" ng-model="register.degreeOfMentor" required
													ng-pattern="/^(\D)+$/" required data-toggle='tooltip' data-placement='right' 
														title="Please enter degree of mentor"/>
											</div>
											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.degreeOfMentor.$dirty && registerAdditionalMentorForm.degreeOfMentor.$error.required">Degree
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.degreeOfMentor.$dirty && registerAdditionalMentorForm.degreeOfMentor.$error.pattern">Degree
												can only contain text</div> -->
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">Designation *</span> <input name="designationOfMentor" id="designationOfMentor"
													type="text" class="form-control" placeholder="Designation"
													ng-model="register.designationOfMentor" required ng-pattern="/^(\D)+$/"   required data-toggle='tooltip' data-placement='right' 
														title="Please enter designation of mentor"/>
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
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Speciality *</span>

												
													<input style="width: 173px;" type="text" class="form-control" placeholder="Search branches" id="branchIdOfMentor2"
														ng-model="register.branchIdOfMentor"  value="" required required data-toggle='tooltip' data-placement='right' 
														title="Please enter specialised branch of mentor"/>
											
												
												 										<!-- <div class="col-xs-12">
											<select class="form-control" ng-model="register.branchIdOfMentor" 
													ng-options="item.branchId as item.projBranchDesc for item in data">
 													</select> 
												</div> -->

											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Experience *</span> <input name="professionalExperience" id="professionalExperience"
													type="text" class="form-control" placeholder="Professional experience in months"
								 					ng-model="register.professionalExperience" required ng-pattern="/^(\d)+$/"  required required data-toggle='tooltip' data-placement='right' 
														title="Please enter proffesional experience in months of mentor"/>
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.professionalExperience.$dirty && registerAdditionalMentorForm.professionalExperience.$error.required">Experience
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.professionalExperience.$dirty && registerAdditionalMentorForm.professionalExperience.$error.pattern">Experience
												can only contain digits</div> -->
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">Association *</span> <input maxlength=200
													name="institutionalAssctnInfo" id="institutionalAssctnInfo" type="text" class="form-control"
													placeholder="Institution association info" ng-model="register.institutionalAssctnInfo" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter Institutional Association Info"/>
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm"  >
												<span class="input-group-addon">Time spare *</span> <input
													name="timeUspaceForMentoringPerMnth" id="timeUspaceForMentoringPerMnth" type="text" class="form-control"
													placeholder="Time spare for mentoring per month" ng-pattern="/^(\d)+$/"
													ng-model="register.timeUspaceForMentoringPerMnth"  required data-toggle='tooltip' data-placement='right' 
														title="Please enter time space for mentoring per month" />
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.timeUspaceForMentoringPerMnth.$dirty && registerAdditionalMentorForm.timeUspaceForMentoringPerMnth.$error.url">Time
												spare can only contain digits</div> -->
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Mentor profile *</span>
												<textarea rows="3" cols="32" name="mentorProfile" id="mentorProfile" placeholder="Mentor Profile"
													ng-model="register.mentorProfile" style="resize:none;" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter mentor profile"></textarea>
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Webpage link *</span> <input id="mentorwebpage"
													name="webpage" type="url" class="form-control" placeholder="Personal webpage link"
													ng-model="register.webpage" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter personal webpage link  " />
											</div>

											<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.webpage.$dirty && registerAdditionalMentorForm.webpage.$error.url">Not
												a valid URL</div> -->
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Commitment *</span> <input id="commitmentUBringIn"
													maxlength=100 name="commitmentUBringIn" type="text" class="form-control"
													placeholder="Commitment you bring" ng-model="register.commitmentUBringIn" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter commitment you bring"/>
											</div>
										</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm" >
												<span class="input-group-addon">Interest *</span> <input name="intOnGrassrtInnovators"  id="intOnGrassrtInnovators"
													type="text" class="form-control" placeholder="grass root innovators interest"
													ng-model="register.intOnGrassrtInnovators" required  data-toggle='tooltip' data-placement='right' 
														title="Please enter grass root innovators interest"/>
											</div>
										</div>
										<div class="col-xs-12 col-md-6"></div>
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
								style="color: white;">Continue</span></a> -->
								<a href="#"><input type="submit" class="btn btn-primary reg-ctn-2" onclick="checkAdditionalEmpty()" value="Continue"></a>
						</div>
					</div>

					<h3 class="reg-acc-3 acc-hover"
						ng-class="registerAdditionalStudentForm.$valid||registerAdditionalCollegeForm.$valid||registerAdditionalFacultyForm.$valid||registerAdditionalMentorForm.$valid?'ui-state-default':'ui-state-disabled'">Captcha</h3>
					<div>
						<div class="col-xs-12">
							<div class="col-xs-12 col-md-8">
								<div class="input-group input-group-sm" id="captchavalue">
									<span id="captchaVal" class="input-group-addon" style="border-right: 1px solid #ccc">
										<%
											Random aRandom = new Random();
											long aStart = 1000;
											long aEnd = 9999;
											long range = (long) aEnd - (long) aStart + 1;
											long fraction = (long) (range * aRandom.nextDouble());
											int randomNumber = (int) (fraction + aStart);
											System.err.println("RANDOM NUMBER: " + randomNumber);
											out.write(String.valueOf(randomNumber));
										%>
									</span> <input name="captcha" type="text" class="form-control" id="captcha" placeholder="Captcha" />
								</div>

							</div>
							<div class="col-xs-12 col-md-4">
								<a class="btn btn-primary reg-ctn-3" id="register" ng-click="registerSubmit()" >Register</a>
							</div>
						</div>
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
					<div class="panel panel-info reg-response-panel" ng-show="message.length>0"
						ng-repeat="msg in message">
						<div class="panel-heading reg-response">{{msg}}</div>
					</div>
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

<!-- END JAVASCRIPTS --></body>

<script >
 function checkEmpty() {
    var empty = '';
    
    $("input", registerBasicForm).each(function() {
       // empty = ($(this).val() == "") ? true : false;
        if($.trim($("#firstName").val()) === "" || $.trim($("#lastName").val()) === ""|| $.trim($("#userName").val()) === ""|| $.trim($("#userPassword1").val()) === ""|| $.trim($("#confirmPassword").val()) === ""|| $.trim($("#mobile").val()) === ""|| $.trim($("#addrLn1").val()) === ""|| $.trim($("#district").val()) === ""|| $.trim($("#city").val()) === ""|| $.trim($("#state").val()) === ""|| $.trim($("#country").val()) === ""|| $.trim($("#pincode").val()) === ""|| $.trim($("#email").val()) === "")      {
        	empty="isempty";
            
        }
        
        else{
        	empty="notempty";
        	
        }
    });
    //alert($("#firstName").val()+'###'+$("#lastName").val()+'###'+$("#userName").val()+'###'+$("#userPassword1").val()+'###'+$("#confirmPassword").val()+'###'+$("#mobile").val()+'###'+$("#addrLn1").val()+'###'+$("#district").val()+'###'+$("#city").val()+'###'+$("#state").val()+'###'+$("#country").val()+'###'+$("#pincode").val()+'###'+$("#email").val());
    //alert('password is '+$("#userPassword1").val());
    
    if(empty == "isempty") {
      alert("Some of the field are empty . Please fill the * marked field");
      return false;
        
    }
}
 function checkAdditionalEmpty() {
	 
//alert($("#userType1").val());
	    var empty = null;

if($("#userType1").val()==="student"){

	    $("input", registerAdditionalStudentForm).each(function() {

	        if($.trim($("#studentdegree").val()) === "" || $.trim($("#dateOfBirthDatePicker").val()) === ""|| $.trim($("#studentID").val()) === ""|| $.trim($("#studentCompletionYear").val()) === ""|| $.trim($("#CollegeNames").val()) === ""|| $.trim($("#university").val()) === ""|| $.trim($("#branchIdOfStudent2").val()) ==="") 

{
	        	empty="isempty"

	        }


	        else{
	        	empty="notempty";
	        }
	    });
	    if(empty === "isempty") {
	        alert("Some of the field are empty . Please fill the * marked field ");
	        return false;

	    }

	    }
else if($("#userType1").val()==="college"){
	
//alert('in college else');
	     $("input", registerAdditionalCollegeForm).each(function() {
		      //if($(this).val() === ""){
		        if($.trim($("#cntctInfoForNatnlInnovnClub").val()) ===  ""||$.trim($("#collegecontactname").val()) ===  ""|| $.trim($("#prinicipalName").val()) === ""|| $.trim($("#affltUniversityOfCollege").val()) ==="" || $.trim($("#techpdaFactlyCoordtr").val()) ==="" || $.trim($("#prinicipalEmail").val()) ==="" || $.trim($("#webpage").val()) ===""||$.trim($("#facilitiesOffrdToStudents").val()) ==="") 

	   {
		        	empty="isempty"

		        }

		        else{
		        	empty="notempty";
		        }
		    });
	    
	    // alert($("#collegecontactname").val()+'###'+$("#prinicipalName").val()+'###'+$("#affltUniversityOfCollege").val()+'###'+$("#collegecontactname").val()+'###'+$("#prinicipalEmail").val()+'###'+$("#webpage").val()+'###'+$("#collegeDesc").val()+'###'+$("#facilitiesOffrdToStudents").val());
	     
		    if(empty === "isempty") {
		    	
		    	   
		        alert("Some of the field are empty . Please fill the * marked field ");
		        return false;

		    } 
	} 


else if($("#userType1").val().toLowerCase()==="faculty"){
 $("input", registerAdditionalFacultyForm).each(function() {
	      //if($(this).val() === ""){
	        if($.trim($("#facultydegree").val()) === ""|| $.trim($("#collgeOfFaculty").val()) === ""|| $.trim($("#specializationOfFaculty2").val()) === ""|| $.trim($("#universityOfFaculty").val()) === ""|| $.trim($("#proffesionalExpOfFaculty").val()) === ""|| $.trim($("#psnlWebpgLink").val()) === ""|| $.trim($("#alumni").val()) === ""|| $.trim($("#facultycompletionyear").val()) === ""|| $.trim($("#affltUniversityOfFaculty").val()) === ""|| $.trim($("#collgeOfFaculty").val()) === 
"") 

{
	        	empty="isempty"

	        }

	        else{
	        	empty="notempty";
	        }
	    });
	    if(empty === "isempty") {
	       alert("Some of the field are empty . Please fill the * marked field ");
	       return false;

	    } 
}
else if($("#userType1").val().toLowerCase()==="mentor"){
 $("input", registerAdditionalMentorForm).each(function() {
	      //if($(this).val() === ""){
	        if($.trim($("#degreeOfMentor").val()) === ""|| $.trim($("#designationOfMentor").val()) === ""|| $.trim($("#branchIdOfMentor2").val()) === ""|| $.trim($("#professionalExperience").val()) === ""|| $.trim($("#institutionalAssctnInfo").val()) === ""|| $.trim($("#timeUspaceForMentoringPerMnth").val()) === ""|| $.trim($("#mentorProfile").val()) === ""|| $.trim($("#mentorwebpage").val()) ===
             ""|| $.trim($("#intOnGrassrtInnovators").val()) === ""|| $.trim($("#commitmentUBringIn").val()) === "") 

{
	        	empty="isempty"

	        }

	        else{
	        	empty="notempty";
	        }
	    });
	    if(empty === "isempty") {
	        alert("Some of the field are empty . Please fill the * marked field ");
	        return false;

	    } 
}
	     } 
	    
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
</html>


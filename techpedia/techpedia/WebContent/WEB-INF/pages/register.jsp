<%@ page import="java.util.Random"%>
<html ng-app="techpedia">
<jsp:include page="template/dashboardHeader.jsp" />
<div class="clearfix"></div>
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div>
	<div class="page-content-wrapper">
		<div class="page-content">

			<div class="row">
				<div class="col-md-11">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-book" id="icon-size"></i>&nbsp;Register
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li>Register</li>

						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
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
			<!-- END PAGE HEADER-->

			<div class="clearfix"></div>
			<div class="row" ng-controller="RegisterController" ng-init="InitLoad()">
				<div id="accordion" class="col-xs-12">
					<h3 class="reg-acc-1 acc-hover  ">General Information</h3>
					<div>
						<p>
						<div>
							<form id="registerBasicForm" name="registerBasicForm" method="post" novalidate>
								<div class="col-xs-12">
									<div class="panel panel-default">
										<div class="panel-heading">
											<div class="btn-group">Type of user</div>
										</div>
										<div class="panel-body">

											<div class="btn-group">
												<div class="col-xs-12 col-md-2">
													<button class="btn btn-info reg-select" type="button" ng-click="typeOfUser('student')">Student</button>
												</div>
												<div class="col-xs-12 col-md-2">
													<button class="btn btn-default reg-select" type="button"
														ng-click="typeOfUser('college')">College</button>
												</div>
												<div class="col-xs-12 col-md-2">
													<button class="btn btn-default reg-select" type="button"
														ng-click="typeOfUser('faculty')">Faculty</button>
												</div>
												<div class="col-xs-12 col-md-2">
													<button class="btn btn-default reg-select" type="button"
														ng-click="typeOfUser('mentor')">Mentor</button>
												</div>
												<!-- <div class="col-xs-12 col-md-2">
													<button class="btn btn-default reg-select" type="button"
														ng-click="typeOfUser('industry')">Industry</button>
												</div> -->
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
												<div class="input-group input-group-sm">
													<span class="input-group-addon">First name</span> <input name="firstName" type="text"
														class="form-control rname" placeholder="First name" ng-model="register.firstName"
														required ng-maxlength="30" ng-pattern="/^(\D)+$/" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.firstName.$dirty && registerBasicForm.firstName.$error.required">First
													name is required</div>
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
													<span class="input-group-addon">Middle name</span> <input name="midName" type="text"
														class="form-control rname" placeholder="Middle name (Optional)"
														ng-model="register.midName" ng-maxlength="30" ng-pattern="/^(\D)+$/" />
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
													<span class="input-group-addon">Last name</span> <input name="lastName" type="text"
														class="form-control rname" placeholder="Last name" ng-model="register.lastName"
														required ng-maxlength="30" ng-pattern="/^(\D)+$/" />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.lastName.$dirty && registerBasicForm.lastName.$error.required">Last
													name is required</div>
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
													<span class="input-group-addon">Username </span> <input name="userName" type="text"
														class="form-control" placeholder="Username" ng-model="register.userName" required
														ng-maxlength="40" />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.userName.$dirty && registerBasicForm.userName.$error.required">User
													name is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.userName.$dirty && registerBasicForm.userName.$error.maxlength">User
													name cannot be more than 40 characters</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Password</span> <input name="password" type="password"
														class="form-control" placeholder="Password" ng-model="register.password" required
														ng-minlength="6" ng-maxlength="16" />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.required">Password
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.minlength">Password
													must be more than 6 characters long</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.password.$dirty && registerBasicForm.password.$error.maxlength">Password
													must be less than 16 characters long</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Confirm </span> <input name="confirmPassword"
														type="password" class="form-control" placeholder="Confirm password"
														ng-model="register.confirmPassword" required ng-minlength="6" ng-maxlength="16" />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
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
													do not match</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Mobile </span> <input name="mobile" type="text"
														class="form-control" placeholder="Mobile" ng-model="register.mobile" required
														ng-minlength=10 ng-maxlength=10 ng-pattern="/^(\d)+$/" />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.mobile.$dirty && registerBasicForm.mobile.$error.required">Mobile
													number is required</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.mobile.$dirty && registerBasicForm.mobile.$error.minlength || registerBasicForm.mobile.$error.maxlength">Mobile
													number must be 10 digit long.</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.mobile.$dirty && registerBasicForm.mobile.$error.pattern">Mobile
													number must contain only digits</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Landline</span> <input name="homePhoneNo" type="text"
														class="form-control" placeholder="Landline (if any)" ng-model="register.homePhoneNo"
														ng-maxlength="15" ng-pattern="/^(\d)+$/" />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.homePhoneNo.$dirty && registerBasicForm.homePhoneNo.$error.maxlength">Landline
													number must be less than 15 digits</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.homePhoneNo.$dirty && registerBasicForm.homePhoneNo.$error.pattern">Landline
													number must contain only digits</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>
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
													<span class="input-group-addon">Address </span> <input name="addrLn1" type="text"
														class="form-control" placeholder="Line 1" ng-model="register.addrLn1" required
														ng-max-length="100" />

													<div class="col-xs-12">&nbsp;</div>

													<input name="addrLn2" type="text" class="form-control" ng-model="register.addrLn2"
														ng-max-length="100" />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.addrLn1.$dirty && registerBasicForm.addrLn1.$error.required">Line
													1 is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.addrLn1.$dirty && registerBasicForm.addrLn1.$error.maxlength">Line
													1 cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.addrLn2.$dirty && registerBasicForm.addrLn2.$error.maxlength">Line
													2 cannot be more than 100 characters</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">District </span> <input name="district" type="text"
														class="form-control" placeholder="District" ng-model="register.district" required
														ng-maxlength="100" ng-pattern="/^(\D)+$/" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.district.$dirty && registerBasicForm.district.$error.required">District
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.district.$dirty && registerBasicForm.district.$error.maxlength">District
													cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.district.$dirty && registerBasicForm.district.$error.pattern">District
													can only contain text</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">City </span> <input name="city" type="text"
														class="form-control" placeholder="City" ng-model="register.city" required
														ng-maxlength="100" ng-pattern="/^(\D)+$/" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.city.$dirty && registerBasicForm.city.$error.required">City
													is a required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.city.$dirty && registerBasicForm.city.$error.maxlength">City
													cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.city.$dirty && registerBasicForm.city.$error.pattern">City
													can only contain text</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">State </span> <input name="state" type="text"
														class="form-control" placeholder="State" ng-model="register.state" required
														ng-maxlength="100" ng-pattern="/^(\D)+$/" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.state.$dirty && registerBasicForm.state.$error.required">State
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.state.$dirty && registerBasicForm.state.$error.maxlength">State
													cannot be more than 100 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.state.$dirty && registerBasicForm.state.$error.pattern">State
													can only contain text</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Country </span> <input name="country" type="text"
														class="form-control" placeholder="Country" ng-model="register.country" required
														ng-maxlength="100" ng-pattern="/^(\D)+$/" />
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
											</div>



											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Pincode </span> <input name="pincode" type="text"
														class="form-control" placeholder="Pincode" ng-model="register.pincode" required
														ng-minlength="6" ng-maxlength="6" ng-pattern="/^(\d)+$/" />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.pincode.$dirty && registerBasicForm.pincode.$error.required">Pincode
													is required</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.pincode.$dirty && registerBasicForm.pincode.$error.minlength || registerBasicForm.pincode.$error.maxlength">Pincode
													number must be 6 digit long</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.pincode.$dirty && registerBasicForm.pincode.$error.pattern">Pincode
													can only contain digits</div>

											</div>
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon">Email</span> <input name="email" type="email"
														maxlength=100 class="form-control remail email-input" placeholder="Email"
														ng-model="register.email" required />
												</div>

												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.email.$dirty && registerBasicForm.email.$error.required">Email
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="registerBasicForm.email.$dirty && registerBasicForm.email.$error.email">Email
													is not valid</div>

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
													<video class='live' width='160' height='120' autoplay></video>
													<img width=160 height=120 src='images/gravatar.png' class='photo' alt='photo'
														style="display: none;">
												</div>

												<div class="col-xs-9">
													<div class="col-xs-12">
														<button class='takePhoto btn btn-info btn-sm'>Take photo</button>
														<button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
															photo</button>
														<input id='hidden-photo-input' type='file' accept='image*;capture=camera'
															style='display: none;' ng-file="file" base64 />
													</div>
													<div class="col-xs-12">&nbsp;</div>
													<div class="col-xs-12">
														<button class='btn btn-sm btn-info photo-btn-click'>Upload photo</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xs-12">
									<a href="#" class="btn btn-primary reg-ctn-1" ng-disabled="registerBasicForm.$invalid"><span
										style="color: white;">Continue</span></a>
								</div>
							</form>
						</div>
					</div>

					<h3 class="reg-acc-2 acc-hover"
						ng-class="registerBasicForm.$invalid?'ui-state-disabled':'ui-state-default'">Additional
						Information</h3>
					<div>
						<input name="userType" id="userType" type="text" style="display: none;">
						<form id="registerAdditionalStudentForm" name="registerAdditionalStudentForm" method="post"
							novalidate>
							<div class="dynamic-div" id="student" ng-show="register.userType=='student'">
								<div class="panel panel-default">
									<div id="profession" class="panel-heading">Student</div>
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Degree </span> <input id="studentdegree" maxlength=100
													name="degreeOfStudent" type="text" class="form-control" placeholder="Degree"
													ng-model="register.degreeOfStudent" required ng-maxlength="100" ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.degreeOfStudent.$dirty && registerAdditionalStudentForm.degreeOfStudent.$error.required">Degree
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.degreeOfStudent.$dirty && registerAdditionalStudentForm.degreeOfStudent.$error.maxlength">Degree
												max length is 100</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.degreeOfStudent.$dirty && registerAdditionalStudentForm.degreeOfStudent.$error.pattern">Degree
												can only contain text</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Date of birth</span> <input id="dateOfBirthDatePicker"
													name="dob" type="text" class="form-control" placeholder="Date of birth"
													ng-model="register.dob" datepicker-angular /><span class="input-group-addon">YYYY-MM-DD</span>

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
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Student ID</span> <input name="studentID" type="text"
													class="form-control" placeholder="Student ID" ng-model="register.studentID" required />
											</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.studentID.$dirty && registerAdditionalStudentForm.studentID.$error.required">Student
												ID is required</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Completion Year </span> <input
													id="studentCompletionYear" name="completionYear" type="text" class="form-control"
													placeholder="Completion year" ng-model="register.completionYear" datepicker-angular /><span
													class="input-group-addon">YYYY-MM-DD</span>
											</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.completionYear.$dirty && registerAdditionalStudentForm.completionYear.$error.required">Student
												ID is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.completionYear.$dirty && registerAdditionalStudentForm.completionYear.$error.required">Improper
												date format</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">College name</span> <input id="CollegeNames"
													name="collge" type="text" class="form-control" placeholder="College name"
													ng-model="register.collge" required ng-maxlength="100" ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.collge.$dirty && registerAdditionalStudentForm.collge.$error.required">College
												is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.collge.$dirty && registerAdditionalStudentForm.collge.$error.maxlength">College
												cannot be more than 100 characters</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.collge.$dirty && registerAdditionalStudentForm.collge.$error.pattern">College
												can only contain text</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">University</span> <input name="university" type="text"
													class="form-control" placeholder="University" ng-model="register.university" required
													ng-maxlength="100" ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.university.$dirty && registerAdditionalStudentForm.university.$error.required">University
												is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.university.$dirty && registerAdditionalStudentForm.university.$error.maxlength">University
												cannot be more than 100 characters</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalStudentForm.university.$dirty && registerAdditionalStudentForm.university.$error.pattern">University
												can only contain text</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Branch</span>
												<div class="col-xs-12">
													<input type="text" class="form-control" placeholder="Search branches"
														ng-model="searchTerm" ng-change="search()" value="" />
												</div>
												<div class="col-xs-12">
													<select class="form-control" ng-model="register.branchIdOfStudent"
														ng-options="item.branchId as item.projBranchDesc for item in data">
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>

						<form id="registerAdditionalCollegeForm" name="registerAdditionalCollegeForm" method="post"
							novalidate>
							<div class="dynamic-div" id="college" ng-show="register.userType=='college'">
								<div class="panel panel-default">
									<div id="profession" class="panel-heading">College</div>
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">College name</span> <input name="collegeName"
													type="text" class="form-control" placeholder="College name"
													ng-model="register.collegeName" required ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.collegeName.$dirty && registerAdditionalCollegeForm.collegeName.$error.required">College
												name is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.collegeName.$dirty && registerAdditionalCollegeForm.collegeName.$error.pattern">College
												name can only contain text</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Principal name </span> <input name="prinicipalName"
													type="text" class="form-control" placeholder="Principal name"
													ng-model="register.prinicipalName" required ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalName.$dirty && registerAdditionalCollegeForm.prinicipalName.$error.required">College
												name is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalName.$dirty && registerAdditionalCollegeForm.prinicipalName.$error.pattern">College
												name can only contain text</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">University</span> <input name="affltUniversityOfCollege"
													type="text" class="form-control" placeholder="University name"
													ng-model="register.affltUniversityOfCollege" required ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.affltUniversityOfCollege.$dirty && registerAdditionalCollegeForm.affltUniversityOfCollege.$error.required">University
												name is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.affltUniversityOfCollege.$dirty && registerAdditionalCollegeForm.affltUniversityOfCollege.$error.pattern">University
												name can only contain text</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Techpedia faculty</span> <input id="collegecontactname"
													maxlength=100 name="techpdaFactlyCoordtr" type="text" class="form-control"
													placeholder="Techpedia faculty co-ordinator" ng-model="register.techpdaFactlyCoordtr"
													required ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.techpdaFactlyCoordtr.$dirty && registerAdditionalCollegeForm.techpdaFactlyCoordtr.$error.required">Faculty
												co-ordinator name is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.techpdaFactlyCoordtr.$dirty && registerAdditionalCollegeForm.techpdaFactlyCoordtr.$error.pattern">Faculty
												co-ordinator name can only contain text</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Principal email </span> <input id="collegecontactemail"
													name="prinicipalEmail" maxlength=100 type="email" class="form-control"
													placeholder="Principal email id" ng-model="register.principalEmail" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalEmail.$dirty && registerAdditionalCollegeForm.prinicipalEmail.$error.required">Principal
												email is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.prinicipalEmail.$dirty && registerAdditionalCollegeForm.prinicipalEmail.$error.email">Not
												a valid email</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Website link</span> <input name="webpage" type="text"
													class="form-control" placeholder="College url" ng-model="register.webpage" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalCollegeForm.webpage.$dirty && registerAdditionalCollegeForm.webpage.$error.required">Please
												enter a valid URL</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Facility offered</span> <input
													name="facilitiesOffrdToStudents" type="text" class="form-control"
													placeholder="Facility offered to students"
													ng-model="register.facilitiesOffrdToStudents" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Innovation club</span> <input id="collegecontactname"
													maxlength=100 name="cntctInfoForNatnlInnovnClub" type="text" class="form-control"
													placeholder="Innovation club contact info"
													ng-model="register.cntctInfoForNatnlInnovnClub" />
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">College description</span> <input
													id="collegecontactname" name="collegeDesc" type="text" class="form-control"
													placeholder="College description" ng-model="register.collegeDesc" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon logo" style="width: 138px;">Logo </span>
												<button class="btn btn-info choose-logo-btn">Choose logo</button>
												<input id="hidden-logo-input" name="logo" type="file" class="form-control"
													placeholder="Logo" style="display: none;" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>

						<form id="registerAdditionalFacultyForm" name="registerAdditionalFacultyForm" method="post"
							novalidate>
							<div class="dynamic-div" id="faculty" ng-show="register.userType=='faculty'">
								<div class="panel panel-default">
									<div id="profession" class="panel-heading">Faculty</div>
									<div class="panel-body">

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Degree </span> <input id="facultydegree" maxlength=100
													name="degreeOfFaculty" type="text" class="form-control" placeholder="Degree"
													ng-model="register.degreeOfFaculty" required ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.degreeOfFaculty.$dirty && registerAdditionalFacultyForm.degreeOfFaculty.$error.required">Faculty
												degree is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.degreeOfFaculty.$dirty && registerAdditionalFacultyForm.degreeOfFaculty.$error.pattern">Faculty
												degree can only contain text</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">College name</span> <input name="collgeOfFaculty"
													type="text" class="form-control" placeholder="College name"
													ng-model="register.collgeOfFaculty" required ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.collgeOfFaculty.$dirty && registerAdditionalFacultyForm.collgeOfFaculty.$error.required">Faculty
												college is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.collgeOfFaculty.$dirty && registerAdditionalFacultyForm.collgeOfFaculty.$error.pattern">Faculty
												college can only contain text</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Speciality </span>
												<div class="col-xs-12">
													<input type="text" class="form-control" placeholder="Search branches"
														ng-model="searchTerm" ng-change="search()" value="" />
												</div>
												<div class="col-xs-12">
													<select class="form-control" ng-model="register.branchIdOfMentor"
														ng-options="item.branchId as item.projBranchDesc for item in data">
													</select>
												</div>
											</div>
										</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Experience</span> <input name="proffesionalExpOfFaculty"
													type="text" class="form-control" placeholder="Profeesional experience in months"
													ng-model="register.proffesionalExpOfFaculty" ng-pattern="/^(\d)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.proffesionalExpOfFaculty.$dirty && registerAdditionalFacultyForm.proffesionalExpOfFaculty.$error.pattern">Experience
												can only contain digits</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Webpage link</span> <input name="psnlWebpgLink"
													type="text" class="form-control" placeholder="Personal webpage link"
													ng-model="register.psnlWebpgLink" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.psnlWebpgLink.$dirty && registerAdditionalFacultyForm.psnlWebpgLink.$error.url">Not
												a valid URL</div>
										</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">University</span> <input name="universityOfFaculty"
													type="text" class="form-control" placeholder="University"
													ng-model="register.universityOfFaculty" required ng-pattern="/^(\D)+$/" />
											</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.universityOfFaculty.$dirty && registerAdditionalFacultyForm.universityOfFaculty.$error.required">University
												is required</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.universityOfFaculty.$dirty && registerAdditionalFacultyForm.universityOfFaculty.$error.pattern">University
												can only contain text</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Alumni</span> <input name="alumni" type="text"
													class="form-control" placeholder="Alumni" ng-model="register.alumni"
													ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.alumni.$dirty && registerAdditionalFacultyForm.alumni.$error.pattern">Alumni
												can only contain text</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Association list</span> <input
													id="facultycompletionyear" maxlength=100 name="memshipInAssocns" type="text"
													class="form-control" placeholder="Association or membership name list"
													ng-model="register.memshipInAssocns" />
											</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Affiliated university</span> <input
													name="affltUniversityOfFaculty" type="text" class="form-control"
													placeholder="Affiliated university name" ng-model="register.affltUniversityOfFaculty"
													ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalFacultyForm.affltUniversityOfFaculty.$dirty && registerAdditionalFacultyForm.affltUniversityOfFaculty.$error.pattern">Aff.
												University can only contain text</div>
										</div>
									</div>
								</div>
							</div>
						</form>

						<form id="registerAdditionalMentorForm" name="registerAdditionalMentorForm" method="post"
							novalidate>
							<div class="dynamic-div" id="mentor" ng-show="register.userType=='mentor'">
								<div class="panel panel-default">
									<div id="profession" class="panel-heading">Mentor</div>
									<div class="panel-body">
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Degree </span> <input name="degreeOfMentor" type="text"
													class="form-control" placeholder="Degree" ng-model="register.degreeOfMentor" required
													ng-pattern="/^(\D)+$/" />
											</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.degreeOfMentor.$dirty && registerAdditionalMentorForm.degreeOfMentor.$error.required">Degree
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.degreeOfMentor.$dirty && registerAdditionalMentorForm.degreeOfMentor.$error.pattern">Degree
												can only contain text</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Designation </span> <input name="designationOfMentor"
													type="text" class="form-control" placeholder="Designation"
													ng-model="register.designationOfMentor" required ng-pattern="/^(\D)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.designationOfMentor.$dirty && registerAdditionalMentorForm.designationOfMentor.$error.required">Designation
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.designationOfMentor.$dirty && registerAdditionalMentorForm.designationOfMentor.$error.pattern">Designation
												can only contain text</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Speciality </span>

												<div class="col-xs-12">
													<input type="text" class="form-control" placeholder="Search branches"
														ng-model="searchTerm" ng-change="search()" value="" />
												</div>
												<div class="col-xs-12">
													<select class="form-control" ng-model="register.branchIdOfMentor"
														ng-options="item.branchId as item.projBranchDesc for item in data">
													</select>
												</div>

											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Experience</span> <input name="professionalExperience"
													type="text" class="form-control" placeholder="Professional experience in months"
													ng-model="register.professionalExperience" required ng-pattern="/^(\d)+$/" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.professionalExperience.$dirty && registerAdditionalMentorForm.professionalExperience.$error.required">Experience
												is required</div>
											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.professionalExperience.$dirty && registerAdditionalMentorForm.professionalExperience.$error.pattern">Experience
												can only contain digits</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Association </span> <input maxlength=200
													name="institutionalAssctnInfo" type="text" class="form-control"
													placeholder="Institution association info" ng-model="register.institutionalAssctnInfo" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Time spare </span> <input
													name="timeUspaceForMentoringPerMnth" type="text" class="form-control"
													placeholder="Time spare for mentoring per month" ng-pattern="/^(\d)+$/"
													ng-model="register.timeUspaceForMentoringPerMnth" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.timeUspaceForMentoringPerMnth.$dirty && registerAdditionalMentorForm.timeUspaceForMentoringPerMnth.$error.url">Time
												spare can only contain digits</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Mentor profile </span>
												<textarea rows="2" name="mentorProfile" placeholder="Mentor Profile"
													ng-model="register.mentorProfile"></textarea>
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Webpage link </span> <input id="mentorwebpage"
													name="webpage" type="text" class="form-control" placeholder="Personal webpage link"
													ng-model="register.webpage" />
											</div>

											<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
												ng-show="registerAdditionalMentorForm.webpage.$dirty && registerAdditionalMentorForm.webpage.$error.url">Not
												a valid URL</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Commitment </span> <input id="mentorwebpage"
													maxlength=100 name="commitmentUBringIn" type="text" class="form-control"
													placeholder="Commitment you bring" ng-model="register.commitmentUBringIn" />
											</div>
										</div>
										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">Interest</span> <input name="intOnGrassrtInnovators"
													type="text" class="form-control" placeholder="grass root innovators interest"
													ng-model="register.intOnGrassrtInnovators" />
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
							<a href="#" class="btn btn-primary reg-ctn-2"
								ng-disabled="registerAdditionalStudentForm.$invalid&&registerAdditionalCollegeForm.$invalid&&registerAdditionalFacultyForm.$invalid&&registerAdditionalMentorForm.$invalid"><span
								style="color: white;">Continue</span></a>
						</div>
					</div>

					<h3 class="reg-acc-3 acc-hover"
						ng-class="registerAdditionalStudentForm.$valid||registerAdditionalCollegeForm.$valid||registerAdditionalFacultyForm.$valid||registerAdditionalMentorForm.$valid?'ui-state-default':'ui-state-disabled'">Captcha</h3>
					<div>
						<div class="col-xs-12">
							<div class="col-xs-12 col-md-8">
								<div class="input-group input-group-sm">
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
								<a class="btn btn-primary reg-ctn-3" id="register" ng-click="registerSubmit()">Register</a>
							</div>
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
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="js/dashboardJs/excanvas.min.js"></script> 
<![endif]-->

<!-- END JAVASCRIPTS -->
<jsp:include page="template/loginModal.jsp" />
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
<script src="js/webrtc.js"></script>
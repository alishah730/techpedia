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
				<div class="col-md-12">
					<h3 class="page-title">
						<i class="fa fa-pencil-square-o" id="icon-size"></i> Edit Profile
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Edit Profile</li>

						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
					</ul>

				</div>
			</div>
			<div class="row error-place" style="display: none;">
				<div class="col-xs-12">
					<div class="panel panel-danger">
						<div class="panel-heading">Error:</div>
						<div class="panel-body error"></div>
					</div>
				</div>
			</div>

			<div class="clearfix"></div>

			<div class="row">
				<div class="panel panel-default" ng-controller="ChangePhotoController" ng-init="InitLoad()">
					<div class="panel-heading">Change Profile Image</div>
					<div class="panel-body">
						<div class="col-xs-2">
							<div class="panel panel-default">
								<div class="panel-heading">Current Image</div>
								<div class="panel-body">
									<img alt="" width=100 height=100 src="<%=session.getAttribute("photo")%>" />
								</div>
							</div>
						</div>
						<div class="col-xs-2">
							<div class="panel panel-default">
								<div class="panel-heading">New Image</div>
								<div class="panel-body">
									<img alt="" width=100 height=100 src="{{editProfile.photo}}" />
								</div>
							</div>
						</div>
						<input ng-model="editProfile.photo" type="text" name="photo" id="photoByte64"
							style="display: none;" /> <input id='hidden-photo-input' type='file'
							accept='image*;capture=camera' style='display: none;' ng-file="file" base64 />
						<div class="col-xs-8">
							<div class="col-xs-12">
								<button class='btn btn-sm btn-info' onclick="$('#hidden-photo-input').click();">Choose
									photo</button>
							</div>
							<div class="col-xs-12">&nbsp;</div>
							<div class="col-xs-12">
								<button class='btn btn-sm btn-info' ng-click="saveImage()" ng-disabled="canSaveImage==false">Save
									Photo</button>
							</div>

							<div class="col-xs-12" ng-show="msg.size.length>0">File size cannot be more then 10 KB</div>
							<div class="col-xs-12" ng-show="message.length>0">
								<div ng-repeat="msg in message">{{msg}}</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="panel panel-default" ng-controller="ChangePasswordController">
					<div class="panel-heading">Change password</div>
					<div class="panel-body">
						<form name="changePasswordForm" novalidate>
							<div class="col-xs-12">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">Old</span> <input name="oldPassword" type="password"
										class="form-control" ng-model="data.oldPassword" placeholder="Old Password" required
										ng-minlength="6" ng-maxlength="16" />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.oldPassword.$dirty && changePasswordForm.oldPassword.$error.required">Old
									password is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.oldPassword.$dirty && changePasswordForm.oldPassword.$error.minlength">Password
									must be 6 character long</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.oldPassword.$dirty && changePasswordForm.oldPassword.$error.maxlength">Password
									must less than 16 character long</div>
							</div>
							<div class="col-xs-12">&nbsp;</div>
							<div class="col-xs-12">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">New</span> <input name="newPassword" type="password"
										class="form-control" placeholder="New Password" ng-model="data.newPassword" required
										ng-minlength="6" ng-maxlength="16" />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.newPassword.$dirty && changePasswordForm.newPassword.$error.required">New
									password is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.newPassword.$dirty && changePasswordForm.newPassword.$error.minlength">Password
									must be 6 character long</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.newPassword.$dirty && changePasswordForm.newPassword.$error.maxlength">Password
									must less than 16 character long</div>
							</div>

							<div class="col-xs-12">&nbsp;</div>

							<div class="col-xs-12">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">Confirm</span> <input name="confirmPassword"
										type="password" class="form-control" placeholder="Confirm password"
										ng-model="confirmPassword" required ng-minlength="6" ng-maxlength="16"
										pw-check="newPassword" />
								</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.confirmPassword.$dirty && changePasswordForm.confirmPassword.$error.required">Password
									confirmation is required</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.confirmPassword.$dirty && changePasswordForm.confirmPassword.$error.minlength">Password
									must be 6 character long</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.confirmPassword.$dirty && changePasswordForm.confirmPassword.$error.maxlength">Password
									must less than 16 character long</div>
								<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
									ng-show="changePasswordForm.confirmPassword.$dirty && changePasswordForm.confirmPassword.$error.pwmatch">Passwords
									do not match</div>
							</div>
							<div class="col-xs-12">&nbsp;</div>
							<div class="col-xs-12 col-md-4">
								<a class="btn btn-primary" ng-disabled="changePasswordForm.$invalid"
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

			<div class="row" ng-controller="EditProfileController" ng-init="initialEditProfileData()">
				<div class="panel panel-default">
					<div class="panel-heading">Change Profile</div>
					<div class="panel-body">
						<form id="editForm" method="post" novalidate>
							<div id="accordion" class="col-xs-12">
								<h3 class="acc-gi acc-hover">General Information</h3>
								<div>
									<p>
									<div>
										<div class="col-xs-12 col-md-6">
											<!-- USER INFO START -->
											<div class="panel panel-default">
												<div class="panel-heading">User Information</div>
												<div class="panel-body user-info">
													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">First name</span> <input name="firstName" type="text"
																class="form-control rname" placeholder="First name" ng-model="edit.firstName" />
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Middle name</span> <input name="midName" type="text"
																class="form-control rname" placeholder="Middle name" ng-model="edit.midName" />
														</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Last name</span> <input name="lastName" type="text"
																class="form-control rname" placeholder="Last name" ng-model="edit.lastName" />
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Username </span> <input name="userName" type="text"
																class="form-control" placeholder="Username" ng-model="edit.userName" />
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Mobile </span> <input onkeypress='numOnly(event)'
																name="mobile" type="text" class="form-control" placeholder="Mobile"
																ng-model="edit.mobile" />
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Landline</span> <input onkeypress='numOnly(event)'
																name="homePhoneNo" type="text" class="form-control" placeholder="Landline (if any)"
																ng-model="edit.homePhoneNo" />
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>

										<!-- PERSONAL INFO START -->
										<div class="col-xs-12 col-md-6">
											<div class="panel panel-default">
												<div class="panel-heading">Contact Information</div>
												<div class="panel-body personal-info">

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Address </span> <input name="address" name="address"
																type="text" class="form-control" placeholder="Line 1" ng-model="edit.addrLn1" />

															<div class="col-xs-12">&nbsp;</div>

															<input name="address" name="address" type="text" class="form-control"
																placeholder="Line 2" ng-model="edit.addrLn2" />
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">District </span> <input name="district" type="text"
																class="form-control" placeholder="District" ng-model="edit.district" />
														</div>
													</div>



													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">City </span> <input name="city" type="text"
																class="form-control" placeholder="City" ng-model="edit.city" />
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">State </span> <input name="state" type="text"
																class="form-control" placeholder="State" ng-model="edit.state" />
														</div>
													</div>


													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Country </span> <input name="country" type="text"
																class="form-control" placeholder="Country" ng-model="edit.country" />
														</div>
													</div>


													<div class="col-xs-12">&nbsp;</div>

													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Pincode </span> <input onkeypress='numOnly(event)'
																name="pincode" type="text" class="form-control" placeholder="Pincode"
																ng-model="edit.pincode" />
														</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
													<div class="col-xs-12">
														<div class="input-group input-group-sm">
															<span class="input-group-addon">Email</span> <input name="email" type="email"
																class="form-control remail email-input" placeholder="Email" ng-model="edit.email" />
														</div>
													</div>

													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>

										<div class="col-xs-12">
											<a href="#" class="btn btn-primary continue-btn"><span style="color: white;">Continue</span></a>

										</div>
									</div>
								</div>

								<h3 class="acc-pi  acc-hover">Additional Information</h3>
								<div>
									<div class="dynamic-div" id="student" ng-show="edit.userType=='student'">
										<div class="panel panel-default">
											<div id="profession" class="panel-heading">Student</div>
											<div class="panel-body">

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Degree
														</span> <input name="degreeOfStudent" id="studentdegree" type="text" class="form-control"
															placeholder="Degree" ng-model="edit.degreeOfStudent" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Date
															of birth</span> <input onkeypress='noTyping(event)' id="dateOfBirthDatePicker" name="dob"
															type="text" class="form-control" placeholder="Date of birth" ng-model="edit.dob" />
														<span class="input-group-addon" style="border-left: 1px solid #ccc">YYYY-MM-DD</span>
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Enrollment
															number</span> <input name="studentID" type="text" class="form-control"
															placeholder="Student ID" ng-model="edit.studentID" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Year
														</span> <input name="completionYear" id="studentcompletionyear" type="text"
															class="form-control" placeholder="Completion year" ng-model="edit.completionYear" /><span
															class="input-group-addon">YYYY-MM-DD</span>
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">College
														</span> <input name="collge" id="studentcollege" type="text" class="form-control"
															placeholder="College" ng-model="edit.collge" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">University</span>
														<input name="university" type="text" class="form-control" placeholder="University"
															ng-model="edit.university" />
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="dynamic-div" id="college" ng-show="edit.userType=='college'">
										<div class="panel panel-default">
											<div id="profession" class="panel-heading">College</div>
											<div class="panel-body">
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">College
															name </span> <input name="cntctPerNameofCollege" id="collegecontactname" type="text"
															class="form-control" placeholder="College name" ng-model="edit.cntctPerNameofCollege" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Principal
															name </span> <input name="prinicipalName" type="text" class="form-control"
															placeholder="Principal name" ng-model="edit.prinicipalName" />
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">University</span>
														<input name="affltUniversityOfCollege" id="collegecontactname" type="text"
															class="form-control" placeholder="University name"
															ng-model="edit.affltUniversityOfCollege" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Techpedia
															faculty</span> <input id="collegecontactname" name="techpdaFactlyCoordtr" type="text"
															class="form-control" placeholder="Techpedia faculty co-ordinator"
															ng-model="edit.techpdaFactlyCoordtr" />
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Principal
															email </span> <input id="collegecontactemail" name="prinicipalEmail" type="text"
															class="form-control" placeholder="Principal email id" ng-model="edit.prinicipalEmail" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Website
															link</span> <input id="collegecontactname" name="webpage" type="text" class="form-control"
															placeholder="College url" ng-model="edit.webpage" />
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Facility
															offered</span> <input name="facilitiesOffrdToStudents" id="collegecontactname" type="text"
															class="form-control" placeholder="Facility offered to students"
															ng-model="edit.facilitiesOffrdToStudents" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Innovation
															club</span> <input name="cntctInfoForNatnlInnovnClub" id="collegecontactname" type="text"
															class="form-control" placeholder="Innovation club contact info"
															ng-model="edit.cntctInfoForNatnlInnovnClub" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">College
															description</span> <input id="collegecontactname" name="collegeDesc" type="text"
															class="form-control" placeholder="College description" ng-model="edit.collegeDesc" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon logo" style="width: 138px;">Logo </span>
														<button class="btn btn-info choose-logo-btn">Choose logo</button>

														<input id="hidden-logo-input" name="logo" type="file" class="form-control"
															placeholder="Logo" style="display: none;" />
													</div>
													<div id="name">
														<img src='{{edit.logo}}' />
													</div>
												</div>

											</div>
										</div>
									</div>

									<div class="dynamic-div" id="faculty" ng-show="edit.userType=='faculty'">
										<div class="panel panel-default">
											<div id="profession" class="panel-heading">Faculty</div>
											<div class="panel-body">
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Degree
														</span> <input name="degreeOfFaculty" id="facultydegree" type="text" class="form-control"
															placeholder="Degree" ng-model="edit.degreeOfFaculty" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">College
														</span> <input name="collgeOfFaculty" id="facultycompletionyear" type="text"
															class="form-control" placeholder="College name" ng-model="edit.collgeOfFaculty" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px;">Speciality
														</span> <input name="specializationOfFaculty" type="text" class="form-control"
															placeholder="Speciality" ng-model="edit.specializationOfFaculty" />
													</div>
												</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px">Experience</span>
														<input name="proffesionalExpOfFaculty" type="text" class="form-control"
															placeholder="Profeesional experience" ng-model="edit.proffesionalExpOfFaculty" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px">Webpage
															link</span> <input name="psnlWebpgLink" id="facultycompletionyear" type="text"
															class="form-control" placeholder="Personal webpage link"
															ng-model="edit.psnlWebpgLink" />
													</div>
												</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px">University</span>
														<input name="universityOfFaculty" id="facultycompletionyear" type="text"
															class="form-control" placeholder="University" ng-model="edit.universityOfFaculty" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px">Alumni</span>
														<input name="alumni" id="facultycompletionyear" type="text" class="form-control"
															placeholder="Alumni" ng-model="edit.alumni" />
													</div>
												</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px">Association
															list</span> <input name="memshipInAssocns" id="facultycompletionyear" type="text"
															class="form-control" placeholder="Association list" ng-model="edit.memshipInAssocns" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 138px">Affiliated
															university</span><input id="facultycompletionyear" name="affltUniversityOfFaculty"
															type="text" class="form-control" placeholder="Affiliated university name"
															ng-model="edit.affltUniversityOfFaculty" />
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="dynamic-div" id="mentor" ng-show="edit.userType=='mentor'">
										<div class="panel panel-default">
											<div id="profession" class="panel-heading">Mentor</div>
											<div class="panel-body">

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Degree
														</span> <input name="degreeOfMentor" id="mentordegree" type="text" class="form-control"
															placeholder="Degree" ng-model="edit.degreeOfMentor" />
													</div>
												</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Designation
														</span> <input name="designationOfMentor" type="text" class="form-control"
															placeholder="Designation" ng-model="edit.designationOfMentor" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Speciality
														</span> <input name="specializationOfMentor" type="text" class="form-control"
															placeholder="Speciality" ng-model="edit.specializationOfMentor" />
													</div>
												</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Experience</span>
														<input name="professionalExperience" type="text" class="form-control"
															placeholder="Professional experience" ng-model="edit.professionalExperience" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Association
														</span> <input name="institutionalAssctnInfo" type="text" class="form-control"
															placeholder="Institution association info" ng-model="edit.institutionalAssctnInfo" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Time
															spare </span> <input name="timeUspaceForMentoringPerMnth" type="text" class="form-control"
															placeholder="Time spare for mentoring per month"
															ng-model="edit.timeUspaceForMentoringPerMnth" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Mentor
															profile </span> <input name="mentorProfile" type="text" class="form-control"
															placeholder="Mentor profile" ng-model="edit.mentorProfile" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Webpage
															link </span> <input name="webpage" id="mentorwebpage" type="text" class="form-control"
															placeholder="Personal webpage link" ng-model="edit.webpage" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Commitment
														</span> <input name="commitmentUBringIn" id="mentorwebpage" type="text" class="form-control"
															placeholder="Commitment you bring" ng-model="edit.commitmentUBringIn" />
													</div>
												</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Interest</span>
														<input name="intOnGrassrtInnovators" id="mentorwebpage" type="text"
															class="form-control" placeholder="grass root innovators interest"
															ng-model="edit.intOnGrassrtInnovators" />
													</div>
												</div>
												<div class="col-xs-12 col-md-6"></div>
											</div>
										</div>
									</div>
									<div class="dynamic-div" id="industry" ng-show="edit.userType=='industry'">
										<div class="panel panel-default">
											<div id="profession" class="panel-heading">Industry</div>
											<div class="panel-body">
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Fax</span>
														<input name="fax" id="industrycontactname" type="text" class="form-control"
															placeholder="Fax" ng-model="edit.fax" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Sector</span>
														<input name="operatnSectr" id="industrycontactname" type="text" class="form-control"
															placeholder="Operation sector" ng-model="edit.operatnSectr" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Product
															range </span> <input name="prdRng" id="industrywebpage" type="text" class="form-control"
															placeholder="Product range" ng-model="edit.prdRng" />
													</div>
												</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Support
														</span> <input name="kindOfSprtUProvideInnovtr" type="text" class="form-control"
															placeholder="Support provide to innovators" ng-model="edit.kindOfSprtUProvideInnovtr" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Experties</span>
														<input name="techngyExprtizOffrToOthers" type="text" class="form-control"
															placeholder="Technological experties" ng-model="edit.techngyExprtizOffrToOthers" />
													</div>
												</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Challenges</span>
														<input name="solnReqrdForTechnlgicalChlngs" type="text" class="form-control"
															placeholder="Technological challenges" ng-model="edit.solnReqrdForTechnlgicalChlngs" />
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 col-md-6">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc; width: 135px">Award</span>
														<input name="intrstToPoseInnovtnChlngAwrds" type="text" class="form-control"
															placeholder="Innovation chalenge awards"
															ng-model="edit.intrstToPoseInnovtnChlngAwrds" />
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-btn-2"><span style="color: white;">Continue</span></a>
									</div>
								</div>
								<h3 class="acc-pi-1  acc-hover">Captcha</h3>
								<div>
									<div class="col-xs-12">
										<div class="col-xs-12 col-md-8">
											<div class="input-group input-group-sm">
												<span class="input-group-addon">1562 </span> <input name="captcha" name="captcha"
													type="text" class="form-control" placeholder="Captcha" />
											</div>
										</div>
										<div class="col-xs-12 col-md-4">
											<button class="btn btn-primary" ng-click="editProfile()">
												<span style="color: white;">Save Changes</span></a>
										</div>
										<input id="registertype" name="userType" type="hidden" ng-model="edit.userType" />
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="alert alert-info" role="alert" ng-show="message.length>0" ng-repeat="msg in message">{{msg}}</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
</body>
</html>
<jsp:include page="template/footer.jsp" />
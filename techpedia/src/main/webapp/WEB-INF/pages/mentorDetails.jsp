<%@page import="java.util.ArrayList"%>
<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
<head>
<link rel="stylesheet" href="css/progress_bar.css">
<style type="text/css">
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
}

.side {
	border-top: 1px solid #a9a9a9;
	margin-top: 0px
}
</style>

</head>
<body>
	<div class="clearfix"></div>
	<div class="container customFont borderRadius style">
		<div class="page-container">
			<div class="page-sidebar-wrapper">
				<%-- <jsp:include page="template/dashboardMenu.jsp" /> --%>
			</div>
			<div class="page-content-wrapper"
				ng-controller="MentorDetailsController" ng-init="initLoad()">
				<div class="page-content">
					<div class="row">
						<div class="col-md-12">
							
							<!-- <h3 class="page-title">
						<i class="fa fa-user" id="icon-size"></i> Mentors Details
					</h3> -->

							<ul class="page-breadcrumb breadcrumb">
								<%
									if (session.getAttribute("username") != null) {
								%>
								<li><a href="./">Home</a> &raquo; <a href="dashboard">Dashboard</a>
									&raquo; <a href="mentors">Mentors</a> &raquo; Mentors Details</li>

								<!-- <li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li> -->
								<%
									} else {
								%><li><a href="./">Home</a> &raquo;</li>
								<li><a href="mentors">Mentors</a> &raquo;</li>
								<li>Mentors Details</li>

								<%
									}
								%>
							</ul>

						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<!-- PROJECT DESCRIPTION-->

						<!-- end main content-->
						<!-- SLIDER-->

						<div class="col-md-1">&nbsp;</div>
						<div class="col-md-12" tyle="box-shadow: 0 0 2em #b2b2b2; font-family: arial ! imporatnt;">
						<div style="text-align: center;"
						ng-show="mentor.userType!='mentor'">
						<p>
							<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
						</p>
						<p>Sorry, There are no projects in this section to review.</p>
						</div>
						</div>
						<div class="col-md-12" ng-show="mentor.userType='mentor'"
							style="box-shadow: 0 0 2em #b2b2b2; font-family: arial ! imporatnt;">

							<h3 style="font-weight: bold; text-align: center;">Details
								of The Mentor</h3>

							<hr>
							<!-- imgae -->
							<div class="col-md-3" style="box-shadow: 0 0 2em #b2b2b2;">
								<div style="margin-left: 12px; margin-top: 20px;">
									<img
										ng-show="mentor.photoPath!=null"
										src="${pageContext.request.contextPath}/image/{{mentor.photoPath}}" class=" img-responsive" alt=""
										style="width: 200px; height: 200px; box-shadow: 0 0 2em #b2b2b2; margin-left: 12px;" />
									<img class=" img-responsive"
										ng-show="mentor.photoPath==null"
										src="images/gravatar.png"
										style="width: 200px; height: 200px; box-shadow: 0 0 2em #b2b2b2; margin-left: 12px;" />
									<div
										style="margin-left: 12px; margin-top: -40px; padding-top: 10px; bottom: 0; left: 0; width: 200px; height: 40px; position: relative; text-align: center; color: white; font-family: arial; opacity: 0.7; filter: alpha(opacity = 70); z-index: 4; background-color: black; overflow: hidden; text-overflow:">
										<p>
											<i class="fa fa-user"></i>&nbsp;<strong>{{mentor.firstName}}
												{{mentor.midName}} {{mentor.lastName}}</strong>
										</p>
										<div class="clearfix"></div>

									</div>
								</div>
								<div class="col-xs-11"
									style="text-align: center; margin-left: 12px;">
									<div>
										<h5 style="text-align: center;">Popularity</h5>
									</div>
									<div>


										<div class="Alimeter alianimate"
											style="text-align: center; color: white; margin-top: 0%;">
											<span style="width: {{mentor.popularity}}%"> <span></span>{{mentor.popularity}}%
											</span>
										</div>

									</div>
								</div>
								<div class="col-md-12" style="margin-top: -8px;">

									<div class="col-xs-12" style="font-weight: bold;">
										<h4 style="font-weight: bold;">General Information</h4>
									</div>




									<div class="col-xs-12" style="height: 3px"></div>

									<div ng-show="mentor.degreeOfMentor.length>0">
										<div class="col-xs-12 " style="font-weight: bold;">Degree</div>
										<div class="col-xs-12">
											<hr class="side">
										</div>
										<div class="col-xs-12" style="margin-top: -16px">{{mentor.degreeOfMentor}}</div>
									</div>

									<div class="col-xs-12" style="height: 3px"></div>

									<div ng-show="mentor.designationOfMentor.length>0">
										<div class="col-xs-12 " style="font-weight: bold;">Designation
										</div>
										<div class="col-xs-12">
											<hr class="side">
										</div>
										<div class="col-xs-12" style="margin-top: -16px">{{mentor.designationOfMentor}}</div>
									</div>

									<div class="col-xs-12" style="height: 3px"></div>

									<div
										ng-show="mentor.addrLn1.length>0 || mentor.addrLn2.length>0">
										<div class="col-xs-12" style="font-weight: bold;">Address
										</div>
										<div class="col-xs-12">
											<hr class="side">
										</div>
										<div class="col-xs-12" style="margin-top: -16px">{{mentor.addrLn1}}
											{{mentor.addrLn2}}</div>
									</div>

									<div class="col-xs-12" style="height: 3px"></div>

									<div ng-show="mentor.city.length>0">
										<div class="col-xs-12" style="font-weight: bold;">City</div>
										<div class="col-xs-12">
											<hr class="side">
										</div>
										<div class="col-xs-12" style="margin-top: -16px">{{mentor.city}}</div>
									</div>

									<div class="col-xs-12" style="height: 3px"></div>

									<div ng-show="mentor.state.length>0">
										<div class="col-xs-12 " style="font-weight: bold;">State
										</div>
										<div class="col-xs-12">
											<hr class="side">
										</div>
										<div class="col-xs-12" style="margin-top: -16px">{{mentor.state}}</div>
									</div>

									<div class="col-xs-12" style="height: 3px"></div>
									<div ng-show="mentor.pincode.length>0">
										<div class="col-xs-12" style="font-weight: bold;">PIN
											Code</div>
										<div class="col-xs-12">
											<hr class="side">
										</div>
										<div class="col-xs-12" style="margin-top: -16px">{{mentor.pincode}}</div>
									</div>


									<div class="col-xs-12" style="height: 3px"></div>

									<div ng-show="mentor.country.length>0">
										<div class="col-xs-12" style="font-weight: bold;">Country
										</div>
										<div class="col-xs-12">
											<hr class="side">
										</div>
										<div class="col-xs-12" style="margin-top: -16px">{{mentor.country}}</div>
									</div>



								</div>
								<div class="col-xs-12">
									<hr>
								</div>
								<div class="col-xs-12" style="margin-top: -8px;">
									<div class="col-xs-12" style="font-weight: bold;">
										<h4 style="font-weight: bold;">Contact Information</h4>
									</div>

									<div class="col-xs-12" style="height: 3px"></div>
									<div class="col-xs-12 " ng-show="mentor.isMobile">
										<i class="fa fa-phone-square"></i>&nbsp;<span>{{mentor.mobile}}</span>
									</div>
									<!-- <div class="col-xs-8">{{mentor.mobile}}</div> -->

									<div class="col-xs-12" style="height: 3px"></div>
									<div class="col-xs-12 ">
										<i class="fa fa-envelope-o"></i>&nbsp;<span>{{mentor.email}}</span>
									</div>
									<div class="col-xs-12">&nbsp;</div>

									<div class="col-xs-12">
										<a href="{{mentor.faceBookId}}" target="_blank"
											ng-show="mentor.faceBookId.length>0"><i
											class="fa fa-facebook-square fa-3x"
											style="color: #3A5795; font-size: 30"></i></a> <a
											ng-show="mentor.linkedinId.length>0"
											href="{{mentor.linkedinId}}" target="_blank"><i
											class="fa fa-linkedin-square fa-3x"
											style="color: #0077B5; font-size: 30"></i></a> <a
											ng-show="mentor.twitterId.length>0"
											href="{{mentor.twitterId}}" target="_blank"><i
											class="fa fa-twitter-square fa-3x"
											style="color: #1da1f2; font-size: 30"></i></a>
									</div>

								</div>


							</div>

							<!-- image end //4 -->


							<!-- details strat -->
							<div class="col-md-9" style="box-shadow: 0 0 2em #b2b2b2;">
								<div class="alert alert-info" style="margin-top: 60px;"
									ng-hide="mentor.institutionalAssctnInfo.length>0 || mentor.mentorProfile.length>0 || mentor.professionalExperience.length>0|| mentor.webpage.length>0">
									<h4>No Details Informations Available, Please contact your site
										administrator</h4>

								</div>




								<div class="col-xs-12" style="margin-top: 20px;"
									ng-show="mentor.institutionalAssctnInfo.length>0">
									<div class="col-xs-12" style="font-weight: bold;">Association:</div>

									<div class="col-xs-12" style="text-align: justify;">{{mentor.institutionalAssctnInfo}}</div>
								</div>

								<div ng-show="mentor.mentorProfile.length>0">
								<div class="col-xs-12">&nbsp;</div>
								<div class="col-xs-12" >
									<div class="col-xs-12" style="font-weight: bold;">Profile:</div>

									<div class="col-xs-12" style="text-align: justify;">{{mentor.mentorProfile}}</div>

								</div>
								</div>
								
								
								<div ng-show="mentor.professionalExperience.length>0">
								<div class="col-xs-12">&nbsp;</div>
								<div class="col-xs-12"
									>
									<div class="col-xs-12" style="font-weight: bold;">Experience
										:</div>

									<div class="col-xs-12" style="text-align: justify;">
										<p>{{mentor.professionalExperience}}</p>
									</div>


								</div>
								</div>

								<div ng-show="mentor.webpage.length>0">
								<div class="col-xs-12">&nbsp;</div>
								<div class="col-xs-12" >
									<div class="col-xs-12" style="font-weight: bold; height: 27px;">
										<img src="images/wwwbrowser.png"
											style="height: 27px; width: 27px;">
									</div>

									<div class="col-xs-12" style="text-align: justify;">
										<a href="{{mentor.webpage}}" target="_blank">{{mentor.webpage}}</a>
									</div>
								</div>
								</div>
								<div class="col-xs-12">
									<hr>
								</div>

							</div>
							<div class="col-xs-12">&nbsp;</div>
							<!-- details end//8 -->

						</div>
					</div>
					<div class="clearfix"></div>

					<!-- END CONTAINER
BEGIN FOOTER -->

				</div>
			</div>
		</div>
		<div class="modal fade bs-modal-sm" id="myModal" tabindex="-1"
			role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" style="padding-bottom: 10px" class="close"
							data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>

					</div>
					<div class="bs-example bs-example-tabs">
						<ul id="myTab" class="nav nav-tabs">
							<li class="active"><a href="#signin" data-toggle="tab">Sign
									In</a></li>
							<li class=""><a href="#signup" data-toggle="tab">Forgot
									Password</a></li>

						</ul>
					</div>
					<div class="modal-body">
						<div id="myTabContent" class="tab-content">

							<div class="tab-pane fade active in" id="signin">
								<form id="login-form" method="post">
									<fieldset>
										<!-- Sign In Form -->
										<!-- Text input-->
										<div class="control-group">
											<label class="control-label" for="userid">Username:</label>
											<div class="controls">
												<input id="username" name="username" type="text"
													class="form-control" placeholder="username"
													class="input-medium" required="required">
											</div>
										</div>

										<!-- Password input-->
										<div class="control-group">
											<label class="control-label" for="passwordinput">Password:</label>
											<div class="controls">
												<input id="password" name="password" class="form-control"
													type="password" placeholder="password" class="input-medium">
											</div>
										</div>

										<!-- Multiple Checkboxes (inline) -->
										<div class="control-group">
											<label class="control-label" for="rememberme"></label>
											<div class="controls">
												&nbsp;&nbsp;&nbsp; <label class="checkbox inline"
													for="rememberme-0"> <input type="checkbox"
													name="rememberme" id="rememberme-0" value="Remember me" />Remember
													me
												</label>
											</div>
										</div>

										<!-- Button -->
										<div class="control-group">
											<label class="control-label" for="signin"></label>
											<div class="controls">
												<input type="submit" class="btn btn-success"
													id="login-submit" value="Login" />
												<div id="login-error-div" style="color: red;"></div>
											</div>
										</div>

									</fieldset>
								</form>
							</div>
							<div class="tab-pane fade" id="signup">
								<form class="form-horizontal" method="post">
									<fieldset>

										<div class="control-group">
											<label class="control-label" for="Email">Please enter
												your registered Email:</label>
											<div class="controls">
												<input id="email" name="email" class="form-control"
													type="text" placeholder="xyz@abc.com" class="input-large"
													required="required">
												<div id="forgot-password-div" style="color: red;"></div>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="confirmsignup"></label>
											<div class="controls">
												<input type="submit" name="submit" class="btn btn-success"
													value="Submit" id="forgot-password" />
											</div>
										</div>
									</fieldset>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
<jsp:include page="template/footer.jsp" />

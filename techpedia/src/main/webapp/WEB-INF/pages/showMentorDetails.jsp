<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html ng-app="techpedia">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/progress_bar.css">
<style type="text/css">
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
}

.padding_justify {
	padding-right: 0px !important;
	text-align: justify !important;
	padding-left: 0px !important;
}
</style>
<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<jsp:include page="template/NewHeader.jsp" />
<body style="font-family: arial;">
	<div class="clearfix"></div>
	<div class="container customFont borderRadius style">
		<div class="page-container">
			<div class="page-sidebar-wrapper">
				<%-- <jsp:include page="template/dashboardMenu.jsp" /> --%>
			</div>
			<div class="page-content-wrapper"
				ng-controller="showMentorDetailsController" ng-init="initLoad()"
				style="font-family: arial !important">
				<div class="page-content">
					<div class="row">
						<%-- <div class="col-md-12">

							<h3 class="page-title">
								<i class="fa fa-user" id="icon-size"></i> Mentors Details
							</h3>
							<ul class="page-breadcrumb breadcrumb">
								<li><a href="./">Home</a> &raquo;</li>
								<li><a href="dashboard">Dashboard</a> &raquo;</li>
								<li>Mentors Details</li>


							</ul>



							<ul class="page-breadcrumb breadcrumb">
							<%
								if (session.getAttribute("username") != null) {
							%>
							<li><a href="./">Home</a> &raquo;</li>
							<li><a href="dashboard">Dashboard</a> &raquo;</li>
							<li><a href="mentors">Mentors</a> &raquo;</li>
							<li>Mentors Details</li>
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
							<li class="right"><a href="mentors">View all Mentors</a></li>
							<%
								}
							%>
						</ul>

						</div> --%>
					</div>
					<div class="clearfix"></div>
					<div class="row">

						<!-- SLIDER-->

						<!-- <div class="col-md-1">&nbsp;</div> -->
						<div class="col-xs-12">



							<div class="col-xs-6"
								style=" padding-left: 0px; padding-right: 0px; box-shadow: 0 0 2em #b2b2b2;">

								<h4 style="font-weight: bold; text-align: center;">Details
									of The Mentor</h4>

								<hr>
								<!-- imgae -->
								<div class="col-xs-4">
									<a href="mentorDetails{{mentor.rgstrId}}"
										ng-click="clickMentor(mentor.rgstrId)" target="_blank"><div
											style="width: 180px; height: 180px; box-shadow: 0 0 2em #b2b2b2;">
											<img
												ng-show="(mentor.photo=='data:undefined;base64,undefined')||(mentor.photo=='Photo path')"
												src="images/profile_icon.png"
												class="mentorpic img-responsive" alt=""
												style="width: 180px; height: 180px; box-shadow: 0 0 2em #b2b2b2;" />
											<img class="mentorpic img-responsive"
												ng-hide="(mentor.photo=='data:undefined;base64,undefined')||(mentor.photo=='Photo path')"
												src="{{mentor.photo||'images/UserDefault.jpg'}}"
												style="width: 180; height: 180; box-shadow: 0 0 2em #b2b2b2;" />
											<div
												style="margin-top: -40px; padding-top: 10px; bottom: 0; left: 0; width: 180px; height: 40px; position: relative; text-align: center; color: white; font-family: arial; opacity: 0.7; filter: alpha(opacity = 70); z-index: 4; background-color: black; overflow: hidden; text-overflow:">
												<p>
													<i class="fa fa-user"></i>&nbsp;<strong>{{mentor.firstName}}
														{{mentor.midName}} {{mentor.lastName}}</strong>
												</p>
												<div class="clearfix"></div>

											</div>
										</div></a>
									<div style="text-align: center;">
										<div>
											<h5>Popularity</h5>
										</div>
										<div>


											<div class="Alimeter alianimate"
												style="text-align: center; color: white; margin-top: 0%; margin-left: 14px;">
												<span style="width: {{mentor.popularity}}%"> <span></span>{{mentor.popularity}}%
												</span>
											</div>

										</div>
									</div>
									<div class="col-xs-12" style="left: -14px;bottom: -80px;">
										<a href="{{mentor.faceBookId}}" target="_blank" ng-show="mentor.faceBookId.length>0"><i
											class="fa fa-facebook-square fa-3x"
											style="color: #3A5795; font-size: 24"></i></a> <a
											href="{{mentor.linkedinId}}" target="_blank" ng-show="mentor.faceBookId.length>0"><i
											class="fa fa-linkedin-square fa-3x"
											style="color: #0077B5; font-size: 24"></i></a> <a
											href="{{mentor.twitterId}}" target="_blank" ng-show="mentor.faceBookId.length>0"><i
											class="fa fa-twitter-square fa-3x"
											style="color: #1da1f2; font-size: 24"></i></a>
									</div>
									
									
								</div>

								<!-- image end //4 -->


								<!-- details strat -->
								<div class="col-xs-8"
									style="padding-right: 0px; margin-top: -8px;">

									<div class="col-xs-12" style="font-weight: bold;">
										<h4 style="font-weight: bold;">General Information</h4>
									</div>

									<div class="col-xs-12" style="height: 3px"></div>
									<div ng-show="mentor.degreeOfMentor.length>0">
										<div class="col-xs-3">Degree</div>
										<div class="col-xs-1">:</div>
										<div class="col-xs-7 padding_justify">{{mentor.degreeOfMentor}}</div>
									</div>
									<div class="col-xs-12" style="height: 3px"></div>
									<div ng-show="mentor.professionalExperience.length>0">
										<div class="col-xs-3">Experience</div>
										<div class="col-xs-1">:</div>
										<div class="col-xs-7 padding_justify">
											{{mentor.professionalExperience}}<a
												href="mentorDetails{{mentor.rgstrId}}"
												ng-click="clickMentor(mentor.rgstrId)" target="_blank">more</a>
										</div>
									</div>
									<div class="col-xs-12" style="height: 3px"></div>
									<div ng-show="mentor.institutionalAssctnInfo.length>0">
										<div class="col-xs-3">Association</div>
										<div class="col-xs-1">:</div>
										<div class="col-xs-7 padding_justify">
											{{mentor.institutionalAssctnInfo}}<a
												href="mentorDetails{{mentor.rgstrId}}"
												ng-click="clickMentor(mentor.rgstrId)" target="_blank">more</a>
										</div>
									</div>
									<div class="col-xs-12" style="height: 3px"></div>

									<div ng-show="mentor.designationOfMentor.length>0">
										<div class="col-xs-3">Designation</div>
										<div class="col-xs-1">:</div>
										<div class="col-xs-7 padding_justify">{{mentor.designationOfMentor}}</div>
									</div>
									<div class="col-xs-12" style="height: 3px"></div>

									<div ng-show="mentor.city.length>0">
										<div class="col-xs-3">City</div>
										<div class="col-xs-1">:</div>
										<div class="col-xs-7 padding_justify">{{mentor.city}}</div>
									</div>

									<div class="col-xs-12" style="height: 3px"></div>

									<div ng-show="mentor.state.length>0">
										<div class="col-xs-3">State</div>
										<div class="col-xs-1">:</div>
										<div class="col-xs-7 padding_justify">{{mentor.state}}</div>
									</div>

									<div class="col-xs-12" style="font-weight: bold;">
										<h4 style="font-weight: bold;">Contact Information</h4>
									</div>

									<!-- <div class="col-xs-12" style="height: 3px"></div>
									<div class="col-xs-12 ">
										<i class="fa fa-phone-square fa-lg"></i>&nbsp;<span>{{mentor.mobile}}</span>
									</div> -->
									<!-- <div class="col-xs-8">{{mentor.mobile}}</div> -->

									<div class="col-xs-12" style="height: 3px"></div>
									<div class="col-xs-12 ">
										<i class="fa fa-envelope-o"></i>&nbsp;<span>{{mentor.email}}</span>
									</div>
									<div class="col-xs-12" style="height: 3px"></div>
									<div class="col-xs-12 " ng-show="mentor.webpage.length>0">
										<i class="fa fa-globe fa-lg"></i>&nbsp;<span><a href="{{mentor.webpage}}"target="_blank">{{mentor.webpage}}</a></span>
									</div>
									<!-- <div class="col-xs-8">{{mentor.email}}</div> -->







								</div>
								<!-- details end//8 -->
								<div class="col-xs-12">&nbsp;</div>
								
								

							</div>



							<div class="col-xs-6"
								style=" box-shadow: 0 0 2em #b2b2b2;">
								<h4 style="font-weight: bold; text-align: center;">Basic
									Information of the Project</h4>
								<hr>
								<div>
									Project Title :&nbsp;
									<p style="font-weight: bold;">{{projectdetails.projTitle}}</p>
								</div>
								<div
									style="text-align: justify; overflow: hidden; text-overflow: ellipsis;">
									Abstract :&nbsp;
									<p style="text-align: justify; overflow: hidden; text-overflow: ellipsis;">{{projectdetails.projAbstract}}</p>



								</div>
								


							<div class="col-xs-12">&nbsp;</div>
							</div>

							<div style="text-align: center; margin-left: 24px;"
								class="col-md-7">
								<button id="mybutton" class="btn btn-success btn-small"
									style="cursor: pointer; margin-top: 15px; margin-bottom: 15px;"

									data-toggle="modal"
									data-target="#teamLeaderApproveProjectModal">

									

									<i class="fa fa-check-square-o" style="font-size: 20px;">&nbsp;</i>Approve
								</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button id="mybutton" class="btn btn-danger btn-small"
									style="cursor: pointer; margin-top: 15px; margin-bottom: 15px;"

									data-toggle="modal"
									data-target="#teamLeaderDeclineProjectModal">

									

									<i class="fa fa-times" style="font-size: 20px;">&nbsp;</i>Decline
								</button>
							</div>

						</div>
						
												<%String teamLeaderEmail = (String)session.getAttribute("emailid");
												  String teamLeadFirstName = (String)session.getAttribute("firstname");
												  String teamLeadLastname = (String)session.getAttribute("lastname");
												  String teamLeadMiddleName = (String)session.getAttribute("middlename");
												  String projectId = session.getAttribute("projId").toString();
												 %>
						<div class="modal fade" id="teamLeaderApproveProjectModal" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">Do you want to
											Approve the project ?
										</h4>
									</div>
									<div class="modal-body">
									<button type="button" class="btn btn-info onapprovebuttonload"
											ng-click="teamLeaderApproveProject('Y','<%=projectId%>',mentor.rgstrId,mentor.email,mentor.firstName,mentor.lastName,'<%=teamLeaderEmail%>','<%=teamLeadFirstName%>','<%=teamLeadMiddleName%>','<%=teamLeadLastname%>')">Yes</button>
										&nbsp;&nbsp;<button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
										
									</div>
									<div class="modal-footer" style="text-align: center;">
										<div class="alert alert-sm alert-info alert-dismissible"
											role="alert" ng-show="message.length>0">
											<li style="list-style: none;" ng-repeat="msg in message">{{msg}}</li>
										</div>
									</div>
								</div>
							</div>
						</div>
<script>
$('.onapprovebuttonload').on("click",function (e) {
	
		e.preventDefault(); 

		setTimeout(function () {
	   window.location.reload();
    }, 2000); 

	});
</script>
						
						<div class="modal fade" id="teamLeaderDeclineProjectModal" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">Do you want to
											Decline the project ?
										</h4>
									</div>
									<div class="modal-body">
									<div class="form-group">
    								Decline Comments:<textarea style="resize: none;" class="form-control" ng-model="comment"  id="comment" name="comment" rows="4"></textarea>
    								</div>
									<button type="button" class="btn btn-info ondeclinebuttonload"
											ng-click="teamLeaderDeclineProject('N','<%=projectId%>',mentor.rgstrId,mentor.email,mentor.firstName,mentor.lastName,'<%=teamLeaderEmail%>','<%=teamLeadFirstName%>','<%=teamLeadMiddleName%>','<%=teamLeadLastname%>',comment)">Yes</button>
										&nbsp;&nbsp;<button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
										
									</div>
									<div class="modal-footer" style="text-align: center;">
										<div class="alert alert-sm alert-info alert-dismissible"
											role="alert" ng-show="message.length>0">
											<li style="list-style: none;" ng-repeat="msg in message">{{msg}}</li>
										</div>
									</div>
								</div>
							</div>
						</div>
<script>
$('.ondeclinebuttonload').on("click",function (e) {
	
		e.preventDefault(); 

		setTimeout(function () {
	   window.location.reload();
    }, 2000); 

	});
</script>


					</div>
					<!-- end sliderr-->


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


	

</body>
<jsp:include page="template/footer.jsp" />
</html>

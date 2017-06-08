<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="techpedia">
<head>
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script> -->
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<style>
.toggler {
	width: 500px;
	height: 200px;
}

#button {
	padding: .5em 1em;
	text-decoration: none;
}

#effect {
	width: 240px;
	height: 135px;
	position: relative;
}

#effect h3 {
	margin: 0;
	padding: 0.4em;
	text-align: center;
}
</style>
<script>
	$(function() {
		// run the currently selected effect
		function runEffect() {
			// run the effect
			$("#effect").show("blind", {
				times : 500,
				distance : 100
			}, 1000, callback);
		}
		;
		//callback function to bring a hidden box back
		function callback() {
			setTimeout(function() {
				$("#effect:visible").removeAttr("style").fadeOut();
			}, 50000);
		}
		;
		// set effect from select menu value
		$("#button").click(function() {
			runEffect();
			return false;
		});
		$("#effect").hide();
	});
</script>
<script src="js/sweetalert-dev.js"></script>
<link rel="stylesheet" href="css/sweetalert.css">
<body style="background-color: white">
	<div class="loaderBody"></div>
	<style>
.loaderBody {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('images/prettyPhoto/dark_rounded/loader.gif') 50% 50%
		no-repeat rgb(249, 249, 249);
}

.icon_table {
	width: 100%;
	font-color: #ffffff !important;
	/* height: 75px; */
}

.modal-body {
	max-height: calc(100vh - 210px);
	overflow-y: auto;
}

.icon_td {
	align-items: center;
	align-content: center;
	font-color: #ffffff !important;
}
</style>

	<script src="js/script.min.js"></script>
	<script src="js/select2.min.js"></script>
	<jsp:include page="template/NewHeader.jsp" />
	<script type="text/javascript">
		$(window).load(function() {
			$(".loaderBody").fadeOut("slow");
		})
	</script>
	<img src="images/View-Team-banner_V3.jpg" class="img-responsive"
		style="width: 100%; hegiht: 25%;">
	<div class="clearfix"></div>
	<div class="container customFont borderRadius style">
		<div class="page-container">
			<!-- BEGIN SIDEBAR -->
			<div class="page-sidebar-wrapper">
				<%-- 	<jsp:include page="template/dashboardMenu.jsp" /> --%>
			</div>

			<div class="page-content-wrapper"
				ng-controller="TeamDetailsController" ng-init="initLoad()">
				<div class="page-content">
					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN PAGE TITLE & BREADCRUMB-->
							<!-- <h3 class="page-title">
						<i class="fa fa-share" id="icon-size"></i> Team Details
						<small>dashboard & statistics</small>
					</h3> -->
							<ul class="page-breadcrumb breadcrumb">
								<li><a href="./">Home</a> &raquo; <a href="dashboard">Dashboard</a>
									&raquo; Teams</li>

								<!-- <li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li> -->
							</ul>


						</div>
					</div>
					<div class="clearfix"></div>

					<div class="row" style="background-color: white;">
						<div class="col s12"
							style="border-radius: 8px; /* width: 1079px; margin-left: 20px; */ height: 35px; padding-top: 9px; padding-left: 12px; background-color: #262626; color: white; margin-top: -20px;">
							{{teamName}}</div>
						<!-- <div class="col-md-12 left-border">
					<div class="col-md-6" style="top: 8px;">Team Name &raquo; {{teamName}}</div>
					<div class="col-md-6" style="top: 8px;">Project Name &raquo; {{projectName}}</div>
					<div class="col-md-3">
						<a href="addTeamMember" data-toggle="modal" id="search-new-members-button"
							data-target=".bs-modal-sm" class="btn btn-info add">Add new Member</a>
						<div class="col-md-12"></div>
					</div>
				</div> -->
						<br> <br> <br>
						<div class="col-md-12 col s12"
							style="background-color: #CCC; margin-top: -40px; margin-bottom: 30px; border-radius: 8px;">
							<div class="col-md-3 one1" ng-repeat="member in members"
								onmouseenter="$(this).children('.sticky1').show(200)"
								onmouseleave="$(this).children('.sticky1').hide(200)"
								style="border-radius: 5px">
								<!-- <table class="icon_table"> -->
								<!-- <tr> -->

								<!-- <div class="col-xs-4 sticky1" style="width: 250px; display:none; background-color:black; opacity:0.7; position: rea;">
								<table border="2px">
									<tr>
										<td>Student Name</td>
										<td>{{member.teamMemFName}}{{member.teamMemMName}} {{member.teamMemLName}}</td>
									</tr>
									<tr>
										<td>College</td>
										<td>{{member.college}}</td>
									</tr>
									<tr>
										<td>Branch</td>
										<td>Mechanical</td>
									</tr>
								</table>
							</div> -->

								<div class="col-xs-12" style="margin-top: 12px">
									<img ng-file="file"
										ng-show="(member.photo=='data:undefined;base64,undefined')||(member.photo=='Photo path')"
										src="images/profile_icon.png"
										style="height: 175px; width: 235px; z-index: 0; border-radius: 8px; z-index: 0;"
										width=100% /> <img ng-file="file"
										ng-hide="(member.photo=='data:undefined;base64,undefined')||(member.photo=='Photo path')"
										style="height: 175px; width: 235px; z-index: 0; border-radius: 8px; z-index: 0;"
										src="{{member.photo||'images/profile_icon.png'}}" width=100% />
									<div
										style="font-family: arial; font-size: 12; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; padding-top: 3px; bottom: 0; width: 235px; height: 60px; position: absolute; text-align: center; color: white; font-weight: bolder; opacity: 0.9; filter: alpha(opacity = 90); z-index: 4; background-color: #3f94ae;">

										<table class="icon_table">
											<tr>
												<td align="center"
													style="font-size: 14px; font-family: Arial;"><img
													id="" alt="" src="images/faculty-icon.png" /></td>
												<td align="center"
													style="font-size: 14px; font-family: Arial;"><img
													src="images/College-icon.png" /></td>
												<td align="center"
													style="font-size: 14px; font-family: Arial;"><img
													src="images/branches-icon.png" /></td>
											</tr>
											<tr>
												<td align="center"
													style="padding-top: 7px; color: #ffffff; font-size: 12px; font-family: Arial; text-overflow: ellipsis !important; overflow: hidden !important;"
													class="icon_td">{{member.teamMemFName}}</td>
												<td align="center"
													style="padding-top: 7px; color: #ffffff; font-size: 12px; font-family: Arial; text-overflow: ellipsis !important; overflow: hidden !important;"
													class="icon_td">{{member.college
													|truncate:true:18:'...'}}</td>
												<td align="center"
													style="padding-top: 7px; color: #ffffff; font-size: 12px; font-family: Arial; text-overflow: ellipsis !important; overflow: hidden !important;"
													class="icon_td">{{member.branchName |
													truncate:true:6:' '}}</td>
											</tr>

										</table>

										<%-- <%=session.getAttribute("teamId") %>
										<%=request.getParameter("teamDetails") %>
										<%=session.getAttribute("emailid") %>
										<%=session.getAttribute("id") %>
										<%=session.getAttribute("firstname") %> --%>
										



									</div>


								</div>


								<!-- </table> -->

								<i id="removeMember" data-toggle="modal"
									data-target="#removeMemberModal"
									ng-show="member.teamLeaderId ==<%=session.getAttribute("id")%> && member.teamLeaderId != member.teamMemRegstrId"
									ng-click="currentMember(member)" ng-disabled=""
									style="color: #555; font-size: 20px; float: right; position: relative; top: -186px; left: 16px;"
									class="fa fa-times-circle  "></i>

								<!-- ng-click="removeMember(member) -->
								<!-- <div class="col-xs-12">
								<p>{{member.state}}</p>
								<p>{{member.country}}</p>
								<p>{{member.college}}</p>
							</div> -->



							</div>

							

							<div id="added-new-members"></div>

							<div class="clearfix"></div>


							<!-- <div class="alert alert-sm alert-info alert-dismissible"
								role="alert" id="hide" ng-show="message.length>0">
								<p style="text-align: center">
									<button  disabled>Show more</button>
									Close
								<p ng-repeat="msg in message" style="text-align: center">{{msg}}</p>
								</p>
							</div> -->


							<!-- Replace Team Lead code Starts here  -->


							<div>
								<button id="replace"
									ng-click="replaceTeamLead(<%=session.getAttribute("id")%>)"
									style="float: left; padding-right: 10px; margin-right: 10px; margin-top: 15px; margin-bottom: 15px; margin-left: 700px; border-color: #4cae4c; background-color: #5cb85c"
									class="btn btn-danger">
									<i class="glyphicon glyphicon-refresh" style="font-size: 17px;">&nbsp;</i>Replace
									Team Lead
								</button>
							</div>
							

							<!-- modal fo remove member -->
							<div class="modal fade" id="removeMemberModal" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header"
											style="background-color: #31b0d5; color: white;">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">Remove Team
												Member</h4>

										</div>



										<div ng-hide="removeMsg.length>0" class="modal-body"
											style="text-align: center;">
											<div style="text-align: center;">
												<i class="fa fa-exclamation-triangle"
													style="color: #E84F63; font-size: 50px; text-align: center;"></i>
											</div>
											<p>
												Are You Sure To <strong>Remove</strong> This Member !!
											</p>
											<p>
												Team Member Name:&nbsp; <strong>{{memberName}}</strong>
											</p>
											<p>
												Registered ID:&nbsp;<strong>{{regID}}</strong>
											</p>


										</div>
										<div ng-show="removeMsg.length>0" class="modal-body"
											style="text-align: center;">
											<i id="effect" class="fa fa-check-circle-o"
												style="color: green; font-size: 7em;"></i>

											<div class="alert alert-sm alert-info alert-dismissible"
												role="alert" id="hide" ng-show="removeMsg.length>0">
												<p style="text-align: center">
												<p ng-repeat="msg in removeMsg" style="text-align: center">{{msg}}</p>

											</div>
											<div onload="window.location.reload()"></div>
										</div>


										<div ng-hide="removeMsg.length>0" class="modal-footer"
											style="align: center; text-align: center;">

											<button type="button" id="button"
												class="btn btn-info relodeOnSuccess"
												ng-click="removeMember()">Remove</button>
											<!-- <button type="button" class="btn btn-danger" ng-click="initiateProject('N')"
																		>Reject</button> -->
											<button data-dismiss="modal" type="button"
												class="btn btn-info">Cancel</button>
										</div>
										<div ng-show="removeMsg.length>0" class="modal-footer"
											style="align: center; text-align: center;">


											<!-- <button data-dismiss="modal" type="button"
												class="btn btn-info" onClick="window.location.reload()"
												href="javascript:window.location.reload(true)">Exit</button> -->
										</div>
									</div>
								</div>
							</div>
							<script type="text/javascript">
$('.relodeOnSuccess').click(function()
        {
           setTimeout(function(){location.reload();},2500); 
           /* alert("3 Seconds until Refresh"); */
           
        });
</script>

							<!-- Replace Team Lead code Ends here  -->







							<div ng-controller="MyCtrl"
								ng-repeat="member in members|limitTo:1">
								<div>
									<button id="mybutton" class="btn btn-info btn-small"
										style="cursor: pointer; border-color: #4cae4c; background-color: #5cb85c; margin-top: 15px; margin-bottom: 15px;"
										ng-click="showAlert()"
										ng-show="member.teamLeaderId==<%=session.getAttribute("id")%>">
										<i class="fa fa-user-plus" style="font-size: 20px;">&nbsp;</i>Add
										Team Member
									</button>
								</div>
								<div>
									<%
									if(session.getAttribute("usertype").equals("mentor")){
									%>
									<button class="btn btn-info btn-small"
										style="cursor: pointer; border-color: #4cae4c; background-color: #5cb85c; margin-top: 15px; margin-bottom: 15px;"
										ng-show="member.projMentor1Id==0 || member.projMentor2Id==0"
										data-toggle="modal" data-target="#requestBeMentorModal">
										Request to be Mentor</button>
										<%} %>
								</div>
								
								<div class="modal fade" id="requestBeMentorModal" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header" style="background-color:#31b0d5">
											<button type="button" class="close" data-dismiss="modal">
												<i class="fa fa-times"></i>
											</button>
											<h4 class="modal-title" id="myModalLabel">Do you want to
												be Mentor for this team?</h4>
												<%String mentorEmail = (String)session.getAttribute("emailid");
												  String registerId = session.getAttribute("id").toString();
												  String firstName = (String)session.getAttribute("firstname");
												  String lastname = (String)session.getAttribute("lastname");
												  String teamId = (String)session.getAttribute("teamId"); %>
										</div>
										<div class="modal-body"  style="text-align: center;">
										<br/>
										<button type="button" class="btn btn-info onrequestbuttonload" 
												ng-click="requestToBeMentor('<%=registerId%>','<%=mentorEmail%>','<%=firstName%>','<%=lastname%>',member.projId,'<%=teamId%>')">Request To be Mentor</button>
										&nbsp;&nbsp;<button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
										<br/><br/>
											
											</div>
										<div class="modal-footer" style="text-align: center;">
											<div class="alert alert-sm alert-info alert-dismissible"
												role="alert" ng-show="message.length>0">
												<li  style="list-style: none;" ng-repeat="msg in message">{{msg}}</li>
											</div>
											<!-- <button type="button" class="btn btn-danger" ng-click="initiateProject('N')"
																			>Reject</button> -->
											
										</div>
									</div>
								</div>
							</div>
							<script>
$('.onrequestbuttonload').on("click",function (e) {
	
		e.preventDefault(); 

		setTimeout(function () {
	   window.location.reload();
    }, 2000); 

	});
</script>
							
								<div class="col-md-12"></div>
								<div>
									<div ng-show="myvalue" class="hideByDefault">
										<div class="row" id="addTeamMember">
											<div class="col-xs-12">
												<div class="panel panel-primary">
													<div class="panel-heading"
														style="background-color: #217690 !important;">Add
														Team Member</div>
													<div class="panel-body">

														<form name="searchTeamMembers" novalidate>
															<!-- //firstName -->
															<div class="col-xs-6">
																<div style="height: 33px;">

																	<div class="col-xs-4"
																		style="border-top-left-radius: 8px; border-bottom-left-radius: 8px; height: 33px; background-color: #217690;">
																		<div
																			style="font-family: arial; color: white; margin-top: 6px; text-align: center;">First
																			Name</div>
																	</div>

																	<div class="col-xs-8 " style="height: 33px;">
																		<input
																			style="height: 33px; width: 100%; margin-left: -17px;"
																			type="text" name="firstName" class="form-control"
																			placeholder="First Name" ng-model="search.firstName">
																	</div>
																</div>

																<div class="col-xs-12">&nbsp;</div>


																<!-- //MiddleName -->
																<div style="height: 33px;">

																	<div class="col-xs-4 "
																		style="border-top-left-radius: 8px; border-bottom-left-radius: 8px; height: 33px; background-color: #217690;">
																		<div
																			style="font-family: arial; color: white; margin-top: 6px; text-align: center;">Middle
																			Name</div>
																	</div>

																	<div class="col-xs-8 " style="height: 33px;">
																		<input
																			style="height: 33px; width: 100%; margin-left: -17px;"
																			type="text" name="midName" class="form-control"
																			placeholder="Middle Name" ng-model="search.midName">
																	</div>
																</div>
																<div class="col-xs-12" style="height: 15px">&nbsp;</div>

																<!-- //lastName -->
																<div style="height: 33px;">

																	<div class="col-xs-4 "
																		style="border-top-left-radius: 8px; border-bottom-left-radius: 8px; height: 33px; background-color: #217690;">
																		<div
																			style="font-family: arial; color: white; margin-top: 6px; text-align: center;">Last
																			Name</div>
																	</div>

																	<div class="col-xs-8 " style="height: 33px;">
																		<input
																			style="height: 33px; width: 100%; margin-left: -17px;"
																			type="text" name="lastName" class="form-control"
																			placeholder="Last Name" ng-model="search.lastName">
																	</div>
																</div>
																<div class="col-xs-12">&nbsp;</div>

																<!-- //College -->
																<div style="height: 33px;">

																	<div class="col-xs-4 "
																		style="border-top-left-radius: 8px; border-bottom-left-radius: 8px; height: 33px; background-color: #217690;">
																		<div
																			style="font-family: arial; color: white; margin-top: 6px; text-align: center;">College</div>
																	</div>

																	<div class="col-xs-8" style="height: 33px;">
																		<input
																			style="height: 34px; width: 100%; margin-left: -17px;"
																			type="text" class="form-control"
																			placeholder="Search College" id="CollegeNames2"
																			name="college" ng-model="search.collge">
																	</div>
																</div>
																<div class="col-xs-12">&nbsp;</div>

																<!-- rollNo/Enrolment -->
																<div style="height: 33px;">

																	<div class="col-xs-4 "
																		style="border-top-left-radius: 8px; border-bottom-left-radius: 8px; height: 33px; background-color: #217690;">
																		<div
																			style="font-family: arial; color: white; margin-top: 6px; text-align: center;">Roll#/Enrolment
																			ID</div>
																	</div>

																	<div class="col-xs-8 " style="height: 33px;">
																		<input
																			style="height: 33px; width: 100%; margin-left: -17px;"
																			type="text" name="studentID" class="form-control"
																			placeholder="Enrollment" ng-model="search.studentID">
																	</div>
																</div>







																<div class="col-xs-12">&nbsp;</div>
																<div class="col-xs-12" style="text-align: center;">
																	<i data-toggle="modal" data-target="#addmemberModal"
																		ng-click=searchMember(search) type="submit"
																		name="submit" class="btn btn-sm btn-success"> <i
																		class="glyphicon glyphicon-search"></i>&nbsp;Search
																	</i>
																</div>
															</div>
														</form>






														<!-- Add member modal -->
														<div class="modal fade" id="addmemberModal" tabindex="-1"
															role="dialog" aria-labelledby="myModalLabel"
															aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header"
																		style="display: inline-block; width: 100%; background-color: #5bc0de; color: white;">
																		&nbsp;
																		<button style="margin-top: -14px; margin-left: 5px;"
																			type="button" class="close " data-dismiss="modal"
																			aria-hidden="true">
																			<i class="fa fa-times"></i>
																		</button>
																		&nbsp;
																		<Div class="modal-title" style="float: left">
																			<h4>Add Team Member</h4>
																		</div>
																		<div style="float: right;">
																			<i style="font-size: 25px;" class="fa fa-filter"></i>&nbsp;<input
																				type="text" ng-model="filterSearch"
																				style="border-radius: 5px; color: black !important;"
																				placeholder="Type Here">
																		</div>
																	</div>

																	<div style="height: 100px !important;"
																		class="alert alert-sm alert-info alert-dismissible"
																		role="alert" id="hide" ng-show="message1.length>0">
																		<p style="text-align: center">
																			<!-- <button  disabled>Show more</button> -->

																			<i class="fa fa-user-plus"
																				style="color: green; font-size: 3em;"></i>
																		</p>
																		<p ng-repeat="msg in message1"
																			style="text-align: center">{{msg}}</p>

																	</div>


																	<div class="modal-body"
																		style="height: 300px !important;">
																		<div ng-show="searchResults.length>0">

																			<div class="panel-body col-xs-12  no-collapse">
																				<!-- <i style="font-size: 25px;" class="fa fa-filter"></i>&nbsp;<input
																					type="text" ng-model="filterSearch"
																					style="border-radius: 5px;" placeholder="Type Here"> -->
																				<br /> <br />
																				<div class="table-responsive">
																					<table class="table table-striped">
																						<tr>
																							<th>ID#</th>
																							<th>Name</th>
																							<th>Choose</th>
																						</tr>
																						<tr
																							ng-repeat="result in searchResults | filter:filterSearch">
																							<td>{{result[0]}}</td>
																							<td>{{result[1]}}</td>
																							<td><btn style=""
																									class="btn btn-info btn-small"
																									ng-click="addMember(result[0],result[1])">Choose</btn></td>
																						</tr>

																						<!-- 
																					<li class="list-group-item" style="height: 50px"
																						ng-repeat="result in searchResults | filter:filterSearch">{{result[1]}}
																						<btn style="float: right;height: 34px;"
																							class="btn btn-info btn-small"
																							ng-click="addMember(result[0],result[1])">Choose</btn>

																					</li> -->
																					</table>
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="modal-footer">



																		<div
																			class="alert alert-sm alert-info alert-dismissible"
																			role="alert" id="hide" ng-show="message1.length>0">
																			<p style="text-align: center">
																				<!-- <button  disabled>Show more</button> -->
																				Close
																			<p ng-repeat="msg in message1"
																				style="text-align: center">{{msg}}</p>
																			</p>
																		</div>
																		<!-- <button type="button" class="btn btn-default"
																			data-dismiss="modal" ng-click="initLoad()"
																			onClick="window.location.reload()" href="javascript:window.location.reload(true)">
																		</button> -->

																		<button type="button" class="btn btn-info btn-small"
																			data-dismiss="modal" ng-click="initLoad()"
																			onClick="window.location.reload()"
																			href="javascript:window.location.reload(true)">Close
																		</button>
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
							</div>
						</div>




					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- END CONTAINER
BEGIN FOOTER -->





	<script>
		function MyCtrl($scope) {

			$scope.myvalue = false;

			$('#CollegeNames2').select2({
				minimumInputLength : 1,
				tags : [],
				tokenSeparators : [ "," ],
				maximumSelectionSize : 1,
				placeholder : "Choose Colleges",
				ajax : { // instead of writing the function to
					// execute the request we
					// use Select2's convenient helper
					url : "getSuggestedCollegeList",
					dataType : 'json',
					type : "GET",
					data : function(term) {

						return {
							q : term
						};
					},
					results : function(data) {
						return {
							results : $.map(data, function(item) {
								return {
									text : item,
									id : item
								};
							})
						};
					}
				}
			});
			$('#CollegeNames2').on("select2-blur", function(e) {

				$scope.search.collge = $('#CollegeNames2').val();
			});
			$scope.search.collge = $('#CollegeNames2').select2('data').text;
			$scope.showAlert = function() {
				$scope.myvalue = true;
			};
		}
	</script>

	<!--  END FOOTER -->
	<!--  BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time)
	BEGIN CORE PLUGINS -->

	<div class="sa-icon sa-warning pulseWarning" style="display: block;">
		<span class="sa-body pulseWarningIns"></span> <span
			class="sa-dot pulseWarningIns"></span>
	</div>
</body>
<!-- END BODY -->
<!--  <script>
	jQuery.noConflict();
</script>
 -->
</html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/customStyle.css">
<jsp:include page="template/footer.jsp" />

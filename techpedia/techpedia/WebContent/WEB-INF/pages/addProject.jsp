<%@ page import="java.util.Random"%>
<html ng-app="techpedia">
<jsp:include page="template/dashboardHeader.jsp" />
<div class="clearfix"></div>
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div>
	<div class="page-content-wrapper" ng-controller="AddProjectController" ng-init="InitLoad()">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-briefcase" id="icon-size"></i> Add Project
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li><a href="manageProjects">Manage Projects</a> &raquo;</li>
						<li>Add Project</li>
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
			<div class="row error-place" style="display: none;">
				<div class="col-xs-12">
					<div class="panel panel-danger">
						<div class="panel-heading">Error:</div>
						<div class="panel-body error"></div>
					</div>
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<%
				String challengeId = (String) request.getAttribute("challengeId");
			String challengeTitle = (String) request.getParameter("challengeTitle");
			  
			%>

			<div class="row">
				<%
					if (challengeId != null) {
				%>
				<div class="panel panel-info">
					<div class="panel-heading">
						This project will get created against <a target="_blank"
							href="challengeDetails<%=challengeId%>">Challenge:
						<%=challengeTitle%></a> 
					</div>
					<input style="display: none;" id="challengeId" name="challengeId" type="text"
						value=<%=challengeId%> />
				</div>
				<%
					}
				%>

				<div class="clearfix"></div>
				<div class="row">
					<div id="accordion" class="col-xs-12">
						<h3 class="acc-gi acc-hover">Project Information</h3>
						<div>
							<div>
								<form id="addProjectInformation" name="addProjectInformation" method="post" novalidate>
									<div class="col-xs-12 col-md-6">
										<!-- USER INFO START -->
										<div class="panel panel-default">
											<div class="panel-heading">Basic Information</div>
											<div class="panel-body project-basic-info">
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Title </span> <input
															id="projectTitle" name="projTitle" type="text" class="form-control rname"
															placeholder="Project Title" ng-model="addProject.projTitle" required />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
														ng-show="addProjectInformation.projTitle.$dirty && addProjectInformation.projTitle.$error.required">
														Project Title is required</div>

												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Branches</span> <input
															id="projectBranches" name="projBranchesString" type="text"
															class="form-control" placeholder="Project branches" ng-model="addProject.projBranchesString" required/>
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Keywords</span> <input
															id="projectKeywords" name="projKeywordsString" type="text" class="form-control"
															placeholder="Keywords"ng-model="addProject.projKeywordsString" required />
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Team Members</span> <input
															 id="teamMembers" name="projTeamMembersString" type="text"
															class="form-control" placeholder="Add Team Members" disabled
															ng-model="addProject.projTeamMembersString" onclick="makeDisable()" /> <span class="input-group-addon"
															style="border-left: 1px solid #ccc; width: 10px;" disabled> <a data-toggle="modal"
															data-target="#searchTeamMemberModal" href="#">Search</a></span>
													</div>

												</div>

												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Team Name</span>
														<input id="teamName" name="projTeamDesc" type="text" class="form-control"
															placeholder="Team Name" ng-model="addProject.projTeamDesc" required
															ng-pattern="/^(\D)+$/" />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
														ng-show="addProjectInformation.projTeamDesc.$dirty && addProjectInformation.projTeamDesc.$error.required">Team
														Members are required</div>
													<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
														ng-show="addProjectInformation.projTeamDesc.$dirty && addProjectInformation.projTeamDesc.$error.pattern">Team
														Members can only contain text</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
											</div>
										</div>

									</div>

									<div class="col-xs-12 col-md-6">
										<!-- USER INFO START -->
										<div class="panel panel-default">
											<div class="panel-heading">Project State Information</div>
											<div class="panel-body project-state-info">
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Start</span> <input
															id="projectStartDate" name="projStartDate" type="text" class="form-control"
															placeholder="Project Start Date" ng-model="addProject.projStartDate"
															datepicker-angular  /> <span class="input-group-addon"
															style="border-left: 1px solid #ccc">DD-MMM-YYYY</span>
													</div>


												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">End</span> <input
															id="projectEndDate" name="projEndDate" type="text" class="form-control"
															placeholder="Project End Date" ng-model="addProject.projEndDate" datepicker-angular  />
														<span class="input-group-addon" style="border-left: 1px solid #ccc">DD-MMM-YYYY</span>
													</div>

												</div>

												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Year </span> <input
															id="projectYear" name="projYear" type="text" class="form-control"
															placeholder="Project Year" readonly />
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Duration</span> <input
															id="projectDuration" name="projDuration" type="text" class="form-control"
															placeholder="Project duration (in months)" readonly /> <span
															class="input-group-addon" style="border-right: 1px solid #ccc">months</span>
													</div>

												</div>
												<div class="col-xs-12">&nbsp;</div>
											</div>
										</div>

									</div>
									<div class="col-xs-12 col-md-12">
										<div class="panel panel-default">
											<div class="panel-heading">Project Abstract</div>
											<div class="panel-body project-abstract-info">
												<div class="col-xs-12">
													<textarea id="projectAbstract" placeholder="Project abstract..." class="textarea-text"
														style="resize: none;" name="projAbstract" rows="3" ng-model="addProject.projAbstract"
														required></textarea>
													<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
														ng-show="addProjectInformation.projAbstract.$dirty && addProjectInformation.projAbstract.$error.required">Project
														Abstract is required</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-btn"
											ng-disabled="addProjectInformation.$invalid">Continue</a>
									</div>
								</form>
							</div>

						</div>
						<h3 class="acc-pi acc-hover"
							ng-class="addProjectInformation.$invalid?'ui-state-disabled':'ui-state-default'">Detailed
							Project Information</h3>
						<div>
							<form id="addDetailedProjectInformationForm" name="addDetailedProjectInformationForm"
								method="post" novalidate>
								<div class="col-xs-12 col-md-12">
									<div class="panel panel-default">
										<div class="panel-heading">Project Description</div>
										<div class="panel-body project-description-info">
											<div class="col-xs-12">
												<textarea id="projectDescription" placeholder="Project description..."
													class="textarea-text" style="resize: none;" name="projDescription" rows="5"
													ng-model="addProject.projDescription" required></textarea>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addDetailedProjectInformationForm.projDescription.$dirty && addDetailedProjectInformationForm.projDescription.$error.required">Project
													Description is required</div>
											</div>
											<div class="col-xs-12">&nbsp;</div>
										</div>
									</div>
								</div>

								<div class="col-xs-12">
									<div class="panel panel-default">
										<div id="profession" class="panel-heading">University info</div>
										<div class="panel-body project-detail-info">
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">University
													</span> <input name="projUniversity" id="projectUniversity" type="text" class="form-control"
														placeholder="Project University" value="IIT" readonly  onfocus="this.blur()" ng-model="addProject.university" />
												</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">College</span> <input
														name="projCollege" id="projectCollege" type="text" class="form-control"
														placeholder="Project College" value="IIT Kanpur" readonly ng-model="addProject.collge" />
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">State</span> <input
														name="projCollegeState" id="projectCollegeState" type="text" class="form-control"
														placeholder="Project College State" value="Kanpur" readonly
														ng-model="addProject.state" />
												</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Student ID</span>
													<input name="projStudentId" name="userRegisterationNumber" type="text"
														class="form-control" placeholder="Student ID" value="2009ECS31" readonly
														ng-model="addProject.studentID" />
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Faculty</span> <input
														id="projFaculty" name="projFaculty" type="text" class="form-control"
														placeholder="Choose faculty" /> <span class="input-group-addon"
														style="border-left: 1px solid #ccc"><a data-toggle="modal"
														data-target="#addNewFacultyModal" href="#">Add new</a></span>
												</div>

											</div>
											<div class="col-xs-12">&nbsp;</div>
										</div>
									</div>
								</div>

								<div class="col-xs-12">
									<div class="panel panel-default">
										<div id="profession" class="panel-heading">Additional Project Information</div>
										<div class="panel-body project-detail-info">
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Cost </span> <input
														id="projectEstimatedCost" name="projEstimationCost" type="text" class="form-control"
														placeholder="Estimated cost" ng-model="addProject.projEstimationCost" required
														ng-pattern="/^(\d)+$/" /> <span class="input-group-addon"
														style="border-right: 1px solid #ccc">INR </span>
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addDetailedProjectInformationForm.projEstimationCost.$dirty && addDetailedProjectInformationForm.projEstimationCost.$error.required">Estimated
													cost is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addDetailedProjectInformationForm.projEstimationCost.$dirty && addDetailedProjectInformationForm.projEstimationCost.$error.pattern">Estimated
													cost can only contain digits</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Project
														Image </span> <input placeholder="Project Image" id="projectPhoto" name="projImage"
														type="file" style="display: none;" />
													<button class="projectPhoto btn btn-info btn-sm">Upload photo</button>
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

										</div>
									</div>
									<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-btn-2"
											ng-disabled="addDetailedProjectInformationForm.$invalid">Continue</a>
									</div>
								</div>
							</form>
						</div>

						<h3 class="acc-pi-1 acc-hover"
							ng-class="addDetailedProjectInformationForm.$invalid?'ui-state-disabled':'ui-state-default'">Captcha</h3>
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
									<a href="addProjectRequest" class="btn btn-primary add-project-submit" style="width: 99px; height: 34px;">Add
										project</a>
								</div>
							</div>
						</div>
					</div>

					<div class="panel panel-success add-project-response-panel" style="display: none;">
						<div class="add-project-response panel-heading"></div>
					</div>
				</div>
				<div class="hr"></div>

				<input id="userId" type="text" style="display: none;"
					value=<%=session.getAttribute("username")%>>

				<div class="result-this"></div>

				<!-- Modal -->
				<div class="modal fade" id="addNewFacultyModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Add new faculty</h4>
							</div>
							<div class="modal-body">
								<form id="add-new-faculty-form">
									<div class="col-md-12">
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">First Name</span> <input id="newFacultyName" type="text"
													name="firstName" class="form-control" placeholder="Faculty Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">Mid Name</span> <input type="text" name="middleName"
													class="form-control" placeholder="Faculty Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">Last Name</span> <input type="text" name="lastName"
													class="form-control" placeholder="Faculty Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">College </span> <input type="text" name="college"
													class="form-control" placeholder="Faculty college">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">Email </span> <input type="text" name="email"
													class="form-control" placeholder="Enter Email address">
											</div>
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button id="add-faculty-submit-button" type="button" class="btn btn-primary"
									data-dismiss="modal">Add faculty</button>
							</div>
						</div>
					</div>
				</div>

				<!-- <div id="add-faculty-popup" style="display: none;">
				<form id="add-new-faculty-form">
					<div class="col-md-12">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">First Name</span> <input id="newFacultyName" type="text"
									name="firstName" class="form-control" placeholder="Faculty Name">
							</div>

						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">Mid Name</span> <input type="text" name="middleName"
									class="form-control" placeholder="Faculty Name">
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">Last Name</span> <input type="text" name="lastName"
									class="form-control" placeholder="Faculty Name">
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">College </span> <input type="text" name="college"
									class="form-control" placeholder="Faculty college">
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">Email </span> <input type="text" name="email"
									class="form-control" placeholder="Enter Email address">
							</div>
						</div>

						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12" style="text-align: center;">
							<input id="add-faculty-submit-button" type="submit" name="submit"
								class="btn btn-sm btn-success" />

						</div>
					</div>
				</form>
			</div> -->
				<div class="col-xs-12">&nbsp;</div>

				<div class="modal fade" id="searchTeamMemberModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Enter search parameters</h4>
							</div>
							<div class="modal-body">
								<form id="search-team-members-form">
									<div class="col-xs-12">
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">First Name </span> <input type="text" name="firstName"
													class="form-control" placeholder="First Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">Mid Name </span> <input type="text" name="middleName"
													class="form-control" placeholder="Middle Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">Last Name </span> <input type="text" name="lastName"
													class="form-control" placeholder="Last Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">College </span> <input type="text" name="college"
													class="form-control" placeholder="College">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon">Roll No: </span> <input type="text" name="enrollment"
													class="form-control" placeholder="Enrollment">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12" style="text-align: center;">
											<input id="search-team-members-submit-button" type="submit" name="submit" value="Search"
												class="btn btn-sm btn-success" />
										</div>
									</div>
								</form>
								<div id="fetched-team-members-container" style="display: none;">
									<div class="panel panel-default">
										<div class="panel-heading">Search results</div>
										<div class="panel-body">
											<select style="width: 100%" class="listbox" name="fetched-team-members"
												id="fetched-team-members" multiple="multiple">
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button id="choose-selected-team-members" type="button" class="btn btn-primary"
									data-dismiss="modal">Choose Selected</button>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->

<!-- END JAVASCRIPTS -->
<script type="text/javascript">
function makeDisable(){
var value=$('#teamMembers').val();

if(value === ''){
$("#teamMembers").prop("readonly",true);
}else{
$("#teamMembers").prop("readonly",false);
}
} 
</script>
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
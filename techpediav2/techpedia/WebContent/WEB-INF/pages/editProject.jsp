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
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-briefcase" id="icon-size"></i> Edit Project
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li><a href="manageProjects">Manage Projects</a> &raquo;</li>
						<li>Edit Project</li>
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

			<div class="clearfix"></div>
			<div class="row" ng-controller="EditProjectController" ng-init="InitLoad()">
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
														placeholder="Project Title" ng-model="edit.projTitle" required />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addProjectInformation.projTitle.$dirty && addProjectInformation.projTitle.$error.required">
													Project Title is required</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Branches</span> <input
														id="projectBranches" name="projBranchesString" type="text" class="form-control remail"
														placeholder="Project branches" />
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Keywords</span> <input
														id="projectKeywords" name="projKeywordsString" type="text" class="form-control"
														placeholder="Keywords" />
												</div>
											</div>
											<!-- 
											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Team</span> <input
														readonly id="teamMembers" name="projTeamMembersString" type="text"
														class="form-control" placeholder="Team Members"
														ng-model="edit.projTeamMembersString" /> <span class="input-group-addon"
														style="border-left: 1px solid #ccc; width: 10px;"> <a data-toggle="modal"
														data-target="#searchTeamMemberModal" href="#">Search</a></span>
												</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Team Name</span> <input
														id="teamName" name="projTeamDesc" type="text" class="form-control"
														placeholder="Team Name" ng-model="edit.projTeamDesc" required
														ng-pattern="/^(\D)+$/" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addProjectInformation.projTeamDesc.$dirty && addProjectInformation.projTeamDesc.$error.required">Team
													Members are required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addProjectInformation.projTeamDesc.$dirty && addProjectInformation.projTeamDesc.$error.pattern">Team
													Members can only contain text</div>
											</div>
											<div class="col-xs-12">&nbsp;</div> -->
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
														placeholder="Project Start Date" ng-model="edit.projStartDate" datepicker-angular />
													<span class="input-group-addon" style="border-left: 1px solid #ccc">DD-MMM-YYYY</span>
												</div>


											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">End</span> <input
														id="projectEndDate" name="projEndDate" type="text" class="form-control"
														placeholder="Project End Date" ng-model="edit.projEndDate" datepicker-angular /> <span
														class="input-group-addon" style="border-left: 1px solid #ccc">DD-MMM-YYYY</span>
												</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Year </span> <input
														id="projectYear" name="projYear" type="text" class="form-control"
														placeholder="Project Year" ng-model="edit.projYear" readonly />
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Duration</span> <input
														id="projectDuration" name="projDuration" type="text" class="form-control"
														placeholder="Project duration (in months)" ng-model="edit.projDuration" readonly /> <span
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
													style="resize: none;" name="projAbstract" rows="3" ng-model="edit.projAbstract"
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
									<a href="#" class="btn btn-primary continue-btn"> <!-- ng-disabled="addProjectInformation.$invalid" -->Continue
									</a>
								</div>
							</form>
						</div>

					</div>
					<h3 class="acc-pi acc-hover">
						<!-- ng-class="addProjectInformation.$invalid?'ui-state-disabled':'ui-state-default'" -->
						Detailed Project Information
					</h3>
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
												ng-model="edit.projDescription" required></textarea>
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
												<span class="input-group-addon" style="border-right: 1px solid #ccc">University </span>
												<input name="projUniversity" id="projectUniversity" type="text" class="form-control"
													placeholder="Project University" value="IIT" readonly ng-model="edit.university" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon" style="border-right: 1px solid #ccc">College</span> <input
													name="projCollege" id="projectCollege" type="text" class="form-control"
													placeholder="Project College" value="IIT Kanpur" readonly ng-model="edit.collge" />
											</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon" style="border-right: 1px solid #ccc">State</span> <input
													name="projCollegeState" id="projectCollegeState" type="text" class="form-control"
													placeholder="Project College State" value="Kanpur" readonly ng-model="edit.state" />
											</div>
										</div>

										<div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon" style="border-right: 1px solid #ccc">Student ID</span> <input
													name="projStudentId" name="userRegisterationNumber" type="text" class="form-control"
													placeholder="Student ID" value="2009ECS31" readonly ng-model="edit.studentID" />
											</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<!-- <div class="col-xs-12 col-md-6">
											<div class="input-group input-group-sm">
												<span class="input-group-addon" style="border-right: 1px solid #ccc">Faculty</span> <input
													id="projFaculty" name="projFaculty" type="text" class="form-control"
													placeholder="Choose faculty" /> <span class="input-group-addon"
													style="border-left: 1px solid #ccc"><a data-toggle="modal"
													data-target="#addNewFacultyModal" href="#">Add new</a></span>
											</div>

										</div> -->
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
													placeholder="Estimated cost" ng-model="edit.projEstimationCost" required
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
									<a href="#" class="btn btn-primary continue-btn-2"> <!-- ng-disabled="addDetailedProjectInformationForm.$invalid" -->Continue
									</a>
								</div>
							</div>
						</form>
					</div>

					<h3 class="acc-pi-1 acc-hover">
						<!-- ng-class="addDetailedProjectInformationForm.$invalid?'ui-state-disabled':'ui-state-default'" -->
						Captcha
					</h3>
					<div>
						<div class="col-xs-12">
							<div class="col-xs-12 col-md-8">
								<div class="input-group input-group-sm">
									<span class="input-group-addon" style="border-right: 1px solid #ccc">1562 </span> <input
										name="captcha" type="text" class="form-control" placeholder="Captcha" />
								</div>
							</div>
							<div class="col-xs-12 col-md-4">
								<a href="#" class="btn btn-primary add-project-submit" style="width: 99px; height: 34px;">Edit
									project</a>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-success edit-project-response-panel" style="display: none;">
					<div class="edit-project-response panel-heading"></div>
				</div>
			</div>
			<div class="hr"></div>

			<input id="userId" type="text" style="display: none;" value=<%=session.getAttribute("username")%>>

			<div class="result-this"></div>
			<div class="clearfix"></div>
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
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
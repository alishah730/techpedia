<html ng-app="techpedia">
<jsp:include page="template/dashboardHeader.jsp" />
<div class="clearfix"></div>
<div class="page-container" ng-controller="ManageProjectsController" ng-init="manageProjectsInit()">
	<div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div>
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-briefcase" id="icon-size"></i> Manage Projects
						<!-- <small>dashboard & statistics</small> -->
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Manage Projects</li>
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

			<div class="clearfix"></div>
			<div class="row">
				<div class="alert alert-sm alert-info alert-dismissible" role="alert" ng-show="message.length>0">
					<li ng-repeat="msg in message">{{msg}}</li>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 left-border">
					<div class="col-md-9" style="top: 8px;">
						Filter: <input type="text" ng-model="filterSearch">
					</div>

					<div class="col-md-3" ng-show="userType=='student'">
						<a href="addProject" class="btn btn-info add"><span class="glyphicon glyphicon-plus"></span>Add
							New Project</a>
					</div>
					<div class="col-md-12"></div>
				</div>

				<br> <br> <br>
				<div class="col-md-12 left-border">
					<div class="alert alert-info" role="alert" ng-show="projects==null||projects.length==0">Nothing
						to display</div>
					<div class="col-xs-12 one1" ng-repeat="project in projects | filter:filterSearch">
						<div class="panel panel-primary">
							<div class="panel-heading">
								{{project.projTitle}} (Lead: {{project.projTeamLeaderId}})<i
									style="float: right; position: relative; top: 3px;" class="fa fa-times-circle"
									ng-click="deleteProject(project)"></i>
							</div>
							<div class="panel-body">
								<div class="col-md-2">
									<img src="images/profile.jpg" width=50 height=65 />
								</div>
								<div class="col-md-7">
									<p>{{project.projDescription}}</p>
									<p class="sub-text-4"></p>
								</div>
								<div class="col-md-3">
									<div class="col-md-12">
										<div class="col-md-6">
											<a style="cursor: pointer; width: 66.5625" class="btn btn-info btn-sm"
												ng-click="viewProject(project.projId)">View</a>
										</div>

										

										<div class="col-md-6">
											<!-- ng-show="registerId==project.projTeamLeaderId"> -->
											<a style="cursor: pointer; width: 66.5625" class="btn btn-info btn-sm"
												ng-click="editProject(project)">Edit</a>
										</div> </div>
										
										<div class="col-md-12">&nbsp;</div>
										<div class="col-md-12">
										<div class="col-md-6">
											<!--  ng-show="registerId==project.projTeamLeaderId"> -->
											<a style="cursor: pointer; width: 66.5625" class="btn btn-info
												btn-sm"
												data-toggle="modal" data-target="#pitchMentorModal" ng-click="pitchProject(project)">Pitch&nbsp;&nbsp;</a>
										</div>
										
										<div class="col-md-6" ng-show="userType=='student'">
											<a style="cursor: pointer; width: 66.5625px" data-toggle="modal"
												data-target="#uploadModal" class="btn btn-info btn-sm"
												ng-click="currentProject(project)">Upload</a>
										</div>

										<div class="col-md-6" ng-show="userType=='student'&&registerId==project.projTeamLeaderId">
											<a style="cursor: pointer; width: 66.5625" class="btn btn-info
												btn-sm"
												ng-click="submitProject(project.projId)">Submit</a>
										</div>
										
										<div class="col-md-6">
											<a style="cursor: pointer; width: 66.5625px" class="btn btn-info btn-sm"
												data-toggle="modal" data-target="#approveProjectModal"
												ng-click="currentProject(project)">Approve</a>
										</div>

										</div>
										<div class="col-md-12">&nbsp;</div>
									<div class="col-md-12">
							
									<div class="col-md-6">
											<a style="cursor: pointer; width: 120px" class="btn btn-info
												btn-sm"
												data-toggle="modal" data-target="#closeProjectModal" ng-click="currentProject(project)">Close Project</a>
										</div>
										
										</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="alert alert-sm alert-info alert-dismissible" role="alert" ng-show="message.length>0">
					<li ng-repeat="msg in message">{{msg}}</li>
				</div>
			</div>

			<div class="clearfix"></div>
			<!-- MODAL -->
			<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Upload a document</h4>
						</div>
						<div class="modal-body">
							<input type="file" ng-file="file" base64>

							<div class="alert alert-sm alert-info alert-dismissible" role="alert"
								ng-show="message.length>0">
								<li ng-repeat="msg in message">{{msg}}</li>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" ng-click="uploadProjectDocument()">Upload</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="approveProjectModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Accept or reject the project ?</h4>
				</div>
				<div class="modal-body">If you are satisfied by the project contents, you may approve it.
					Otherwise, you may reject it.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" ng-click="initiateProject('Y')"
						data-dismiss="modal">Accept</button>
					<button type="button" class="btn btn-danger" ng-click="initiateProject('N')"
						data-dismiss="modal">Reject</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="closeProjectModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Close the project ?</h4>
				</div>
				<div class="modal-body">If you are satisfied with the project work, please close it.
					Otherwise, ask for modification.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" ng-click="closeProject('Y')" data-dismiss="modal">Close
						Project</button>
					<button type="button" class="btn btn-danger" ng-click="closeProject('N')" data-dismiss="modal">Modification
						needed</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="pitchMentorModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						Search mentor
						<div class="alert alert-sm alert-info alert-dismissible" role="alert"
							ng-show="message.length>0">
							<li ng-repeat="msg in message">{{msg}}</li>
						</div>
					</h4>
				</div>
				<div class="modal-body">
					<div class="col-xs-12" ng-repeat="mentor in suggestedMentors">
						<div class="col-md-2">
							<img class="pitch-image" src="{{mentor.photo||'images/UserDefault.jpg'}}" width=90 height=100 />
						</div>
						<div class="col-md-10">
							<div class="col-md-12">{{mentor.fname}} {{mentor.mname}} {{mentor.lname}}</div>
							<div class="col-md-12">{{mentor.designation}}</div>
							<div class="col-md-12">{{mentor.degree}}</div>
							<div class="col-md-12 red">Experience: {{mentor.experience}}</div>
							<div class="col-md-12">
								<a style="cursor: pointer;" class="btn btn-sm btn-success" ng-click="addMentor(mentor)">Add
									to project</a>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src=".js/respond.min.js"></script>
<script src="js/dashboardJs/excanvas.min.js"></script> 
<![endif]-->

</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />

<html ng-app="techpedia">
<jsp:include page="template/dashboardHeader.jsp" />
<div class="clearfix"></div>
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div>

	<div class="page-content-wrapper" ng-controller="TeamDetailsController" ng-init="initLoad()">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-share" id="icon-size"></i> Team Details
						<!-- <small>dashboard & statistics</small> -->
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Teams</li>

						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
					</ul>

				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">
				<div class="col-md-12 left-border">
					<div class="col-md-9" style="top: 8px;">Team Name &raquo; {{teamName}}</div>
					<div class="col-md-9" style="top: 8px;">Project Name &raquo; {{projectName}}</div>
					<div class="col-md-3">
						<!-- <a href="addTeamMember" data-toggle="modal" id="search-new-members-button"
							data-target=".bs-modal-sm" class="btn btn-info add">Add new Member</a> -->
						<div class="col-md-12"></div>
					</div>
				</div>
				<br> <br> <br>

				<div class="col-md-4 one1" ng-repeat="member in members">
					<div class="panel panel-primary">
						<div class="panel-heading">
							{{member.teamMemFName}} {{member.teamMemMName}} {{member.teamMemLName}} <i
								style="float: right; position: relative; top: 3px;" class="fa fa-times-circle"
								ng-click="removeMember(member)"></i>
						</div>
						<div class="panel-body">
							<div class="col-md-3">
								<img src="{{'data:image/jpeg;base64,'+member.photo||'images/UserDefault.jpg'}}" width=60 height=65 />
							</div>
							<div class="col-md-9">
								<p>{{member.state}}</p>
								<p>{{member.country}}</p>
								<p>{{member.college}}</p>
							</div>
						</div>
					</div>
				</div>
				<div id="added-new-members"></div>
			</div>
			<div class="clearfix"></div>
			<div class="row">
				<div class="col-xs-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Add team member</div>
						<div class="panel-body">
							<!-- <div class="panel panel-primary">
								<div class="panel-heading">Choose project</div>
								<div class="panel-body">
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
											{{chosenProject.projTitle}} <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li ng-repeat="project in projects"><a href="#" ng-click="chooseProject(project)">{{project.projTitle}}
											</a></li>
										</ul>
									</div>
								</div>
							</div> -->

							<div class="panel panel-primary">
								<div class="panel-heading">Search form</div>
								<div class="panel-body">
									<form name="searchTeamMembers" novalidate>
										<div class="col-xs-12">
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">First Name </span> <input type="text" name="firstName"
														class="form-control" placeholder="First Name" ng-model="search.firstName">
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">Mid Name </span> <input type="text" name="midName"
														class="form-control" placeholder="Middle Name" ng-model="search.midName">
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">Last Name </span> <input type="text" name="lastName"
														class="form-control" placeholder="Last Name" ng-model="search.lastName">
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">College </span> <input type="text" name="collge"
														class="form-control" placeholder="College" ng-model="search.collge">
												</div>
											</div>
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">Roll# </span> <input type="text" name="studentID"
														class="form-control" placeholder="Enrollment" ng-model="search.studentID">
												</div>
											</div>
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12" style="text-align: center;">
												<input ng-click=searchMember(search) type="submit" name="submit"
													class="btn btn-sm btn-success" />
											</div>
										</div>
									</form>
								</div>
							</div>

							<div class="panel panel-primary" ng-show="searchResults.length>0">
								<div class="panel-heading">Search results</div>
								<div class="panel-body">
									Filter: <input type="text" ng-model="filterSearch"><br /> <br />
									<ul class="list-group">
										<li class="list-group-item" ng-repeat="result in searchResults | filter:filterSearch">{{result[1]}}
											<button style="float: right;" class="btn btn-primary" ng-click="addMember(result[0])">Choose</button>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- END CONTAINER
BEGIN FOOTER -->
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

</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />

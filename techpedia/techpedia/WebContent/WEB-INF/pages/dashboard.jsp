<jsp:include page="template/NewHeader.jsp" />
<html ng-app="techpedia">
<style>
.breadcrumb>li+li:before {
padding: 0 5px;
color: #ccc;
content: none;
} 

.row {
margin-right: -1px;
margin-left: -1px;
}
img { max-width: 100%; }

</style>
<div class="clearfix"></div>


<div class="container customFont borderRadius style" >

<div class="page-container">
	<div class="page-sidebar-wrapper">
	
	</div>
	<div class="page-content-wrapper" ng-controller="DashboardController" ng-init="initLoad()">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<h3 class="page-title">Dashboard</h3>
					<ul class="page-breadcrumb breadcrumb" >
						<li ><a href="./">Home</a> <font  style="font-weight: bold; color: black; font-size:18px;">&raquo;</font></li>
						<li style="content:none !important;">Dashboard</li>
					
					</ul>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<div class="col-xs-6">
						Filter: <input type="text" ng-model="filterSearch" />
					</div>
					<div class="col-xs-6">
						Applied: {{clickFilterApplied}} <a href="#" ng-click="clickFilter('my')">My projects</a> | <a
							href="#" ng-click="clickFilter('follow')">Projects I Follow</a> | <a href="#"
							ng-click="clickFilter('all')">All</a>
					</div>
				</div>
			</div>

			<br />
			<div class="clearfix"></div>
	

			<div class="row" ng-show="showMyProjects">
				<div class="panel panel-primary">
					<div class="panel-heading">My Projects</div>
					<div class="panel-body">

						<div class="alert alert-sm alert-info alert-dismissible" role="alert" ng-show="myProjects==0">Nothing
							to display</div>

						<div class="col-xs-12" ng-repeat="project in myProjects | filter: filterSearch">
							<div class="panel panel-warning">
								<div class="panel-heading">{{project.projTitle}}</div>
								<div class="panel-body">
									<div class="col-md-4">
										<img src="{{project.projImage||'images/art/project.png'}}" />
									</div>
									<div class="col-md-6">
										<p>{{project.projDescription}}</p>
									</div>
									<div class="col-md-2">
										<div class="col-xs-12">
											<button class="btn btn-info" ng-click="viewProject(project)">View project</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="row" ng-show="showProjectsIFollow">
				<div class="panel panel-primary">
					<div class="panel-heading">Projects I Follow</div>
					<div class="panel-body">
						<div class="alert alert-sm alert-info alert-dismissible" role="alert"
							ng-show="projectsIFollow==0">Nothing to display</div>
						<div class="col-xs-12" ng-repeat="project in projectsIFollow | filter: filterSearch">
							<div class="panel panel-warning">
								<div class="panel-heading">{{project.projTitle}}</div>
								<div class="panel-body">
									<div class="col-md-4">
										<img src="{{project.projImage||'images/art/project.png'}}" />
									</div>
									<div class="col-md-6">
										<p>{{project.projDescription}}</p>
									</div>

									<div class="col-md-2">

										<div class="col-xs-12">
											<button class="btn btn-info" ng-click="viewProject(project)">View project</button>
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
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="js/dashboardJs/excanvas.min.js"></script> 
<![endif]-->
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
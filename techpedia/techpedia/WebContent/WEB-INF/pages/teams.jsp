<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
<div class="clearfix"></div>
<div class="container customFont borderRadius style" >
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<%-- <jsp:include page="template/dashboardMenu.jsp" /> --%>
	</div>

	<div class="page-content-wrapper" ng-controller="TeamsController" ng-init="InitLoad()">
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
           
			<div class="row-fluid">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					
					
					
					
					<div class="col-md-12">
					<div class="panel-heading col-md-6">Team Cloud</div>
					<div class="panel-heading col-md-6" style="float:left">
						Filter: <input type="text" ng-model="filterSearch">
					</div>
					</div>
					<hr>
					
				 	<div class="panel-body" ng-show="teams.length == null">This user does not belong to any team</div> 

					<!-- List group -->
					<ul class="list-group" ng-show="teams.length>0">
						<a class="btn btn-large btn-info" ng-repeat="team in teams | filter:filterSearch"  ng-click=clickTeam(team) style=" margin-top: 3px;  margin-bottom: 3px; margin-left: 3px; margin-right: 3px;">{{team.teamName}}
							<!-- <button style="float: right;" class="btn btn-sm btn-info" ng-click=clickTeam(team)>View
								Team</button> -->
						</a>
						
						
					</ul>
					
					
					
					
					
<!-- 					<div class="module-body" >
<div class="row-fluid">
<div class="span12">
<span id="likedUser"></span>
<span><a class="btn btn-large btn-success" href="team details" target="_parent">Team NAme</a> </span>

</div>
</div>
</div> -->
					
					
					
				</div>
			</div>
			<div class="clearfix"></div>

			<!-- END CONTAINER
BEGIN FOOTER -->
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

</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />

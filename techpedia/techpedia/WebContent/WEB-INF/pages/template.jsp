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

			<div class="row">Place for data</div>
			<div class="clearfix"></div>

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

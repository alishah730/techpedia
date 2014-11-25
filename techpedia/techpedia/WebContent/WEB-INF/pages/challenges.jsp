<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html ng-app="techpedia">
<!-- BEGIN HEAD -->
<jsp:include page="template/dashboardHeader.jsp" />
<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->

<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<jsp:include page="template/dashboardMenu.jsp" />
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->


			<!-- END STYLE CUSTOMIZER -->
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-bolt" id="icon-size"></i> Challenges
						<!-- <small>dashboard & statistics</small> -->
					</h3>
					<ul class="page-breadcrumb breadcrumb">

						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Challenges</li>

						<%
							} else {
						%>
						<li><a href="./">Home</a> &raquo;</li>
						<li>Challenges</li>
						<%
							}
						%>

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
			<!-- END PAGE HEADER-->
			<div class="clearfix"></div>
			<div class="content" ng-controller="ChallengesPageController" ng-init="initialChallengesData()">
				<div class="row">
					<div class="col-xs-3">
						Search by title: <input ng-model="searchTerm" />
						<button ng-click="searchChallenge(searchTerm, 'title')">Search</button>
					</div>
					<div class="col-xs-3">
						Filter: <input ng-model="filterSearch" />
					</div>
				</div>
				<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="message.length>0">
					<li ng-repeat="msg in message">{{msg}}</li>
				</div>

				<div class="alert alert-sm alert-info alert-dismissible" role="alert"
					ng-show="challenges.length==0">Nothing to display</div>

				<div class="row">
					<div id="portofolio" ng-repeat="challenge in challenges | filter:filterSearch">
						<a href="#" ng-click="clickChallenge(challenge.challengId)">
							<div class="col-md-3">
								<div class="post col-xs-12 category">
									<h5 class="header-customize">
										{{challenge.challengTitle}}
									</h5>
									<div class="portofoliothumb">
										<img src="{{challenge.challengImgPath||'images/no_project.png'}}" class="fourimage" alt="" />
									</div>
								</div>
							</div>
						</a>
					</div>
				</div>

				<div class="row">
					<br />
					<p style="text-align: center">
						<button ng-click="viewMore(count=count+1)">Show more</button>
					</p>
				</div>

				<div class="hr"></div>

			</div>
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

<!-- END JAVASCRIPTS -->
<jsp:include page="template/loginModal.jsp" />
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />

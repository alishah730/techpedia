<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
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
						<i class="fa fa-user" id="icon-size"></i> Mentors
						<!-- <small>dashboard & statistics</small> -->
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Mentors</li>

						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
						<%
							} else {
						%><li><a href="./">Home</a> &raquo;</li>
						<li>Mentors</li>
						<%
							}
						%>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<div class="clearfix"></div>
			<div class="content" ng-controller="MentorsPageController" ng-init="initialMentorsData()">
				<div class="row">
					Filter: <input ng-model="filterSearch" />
				</div>
				<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="message.length>0">
					<li ng-repeat="msg in message">{{msg}}</li>
				</div>

				<div class="alert alert-sm alert-info alert-dismissible" role="alert"
					ng-show="mentors.length==0">Loading mentors</div>

				<div class="row">
					<div id="portofolio" ng-repeat="mentor in mentors | filter:filterSearch">
						<a href="#" ng-click="clickMentor(mentor.rgstrId)">
							<div class="post col-md-3 category">
								<h5 class="header-customize">
									{{mentor.firstName}}<br />{{mentor.designationOfMentor}}
								</h5>
								<div class="portofoliothumb">
									<img src="{{mentor.photo||'images/UserDefault.jpg'}}" class="fourimage" alt="" />
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
			</div>
			<div class="hr"></div>
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

<jsp:include page="template/loginModal.jsp" />
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />

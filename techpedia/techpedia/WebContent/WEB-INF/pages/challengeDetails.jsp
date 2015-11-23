<%@page import="java.util.ArrayList"%>
<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
<div class="clearfix"></div>

<div class="container customFont borderRadius style" >
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<%-- <jsp:include page="template/dashboardMenu.jsp" /> --%>
	</div>

	<div class="page-content-wrapper" ng-controller="ChallengeDetailsController" ng-init="InitLoad()">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-bolt" id="icon-size"></i> Challenge Details
						<!-- <small>dashboard & statistics</small> -->
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li><a href="challenges">Challenges</a> &raquo;</li>
						<li>Challenge Details</li>
						<li class="right"><a href="challenges">View all Challenges</a></li>
						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
						<%
							} else {
						%><li><a href="./">Home</a> &raquo;</li>
						<li><a href="challenges">Challenges</a> &raquo;</li>
						<li>Challenge Details</li>
						<li class="right"><a href="challenges">View all Challenges</a></li>
						<%
							}
						%>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>

			<div class="clearfix"></div>
			<div class="row">
				<!-- PROJECT DESCRIPTION-->
				<div class="col-xs-12">
					<div class="sectiontitle">
						<div class="col-md-12">
							<div class="col-md-8">
								<h4>{{challenge.challengTitle}}</h4>
							</div>
							<%
								if (session.getAttribute("username") != null) {
							%>
							<div class="col-md-4">
								<a style="cursor: pointer" class="btn btn-info btn-sm accept-style"
									ng-click=acceptChallenge(challenge)>Accept</a><br> <br>
							</div>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<!-- Default panel contents -->

				<div class="col-xs-12">
					<div class="col-xs-6">
						<div class="col-xs-12">
							<table class="table">
								<tr>
									<td><b>Description:</b></td>
									<td>{{challenge.challengDescription}}</td>
								</tr>
								<tr>
									<td><b>Abstract:</b></td>
									<td>{{challenge.challengAbstract}}</td>
								</tr>
							</table>
						</div>
						<div class="col-xs-12">
							<div class="col-xs-12">
								<div class="panel panel-default">
									<div class="panel-heading">
										Document list <span ng-show="message.length>0" style="float: right"
											ng-repeat="msg in message">{{msg}}</span>
									</div>
									<div class="panel-body"></div>
									<ul class="list-group">
										<li class="list-group-item" ng-repeat="document in challengeDocumentList">{{document.docName}}
											<button ng-click=downloadDocumentLink(document) class="btn btn-sm btn-info">Download</button>
											<button ng-click=deleteDocument(document) class="btn btn-sm btn-info">Delete</button>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<!-- <div class="col-xs-6">
						<img src="{{challenge.challengImgPath||'images/no_project.png'}}" />
					</div> -->
					<!-- Table -->

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


</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />

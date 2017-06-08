
<jsp:include page="template/NewHeader.jsp" />

<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-archive.ico">
<html ng-app="techpedia">
<%if(session.getAttribute("usertype").equals("admin")){ %>
<body style="background-color: white !important">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
		rel="stylesheet">

	<style>
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none;
}

.nav-pills>li.active>a, .nav-pills>li.active>a:hover, .nav-pills>li.active>a:focus
	{
	background-color: #262626 !important;
}

.hov {
	text-decoration: none;
	background-color: #777777;
}

a:hover {
	background-color: #262626 !important
}

a:focus {
	background-color: #262626 !important
}

li.active {
	background-color: #262626 !important;
}

.row {
	margin-right: -1px;
	margin-left: -1px;
}

img {
	max-width: 100%;
}

#Reviewheader {
	color: white;
	text-align: center;
	padding: 5px;
	background-color: #23282e;
	line-height: 40px;
	display: block;
	text-align: center;
	font-size: 20px;
}
</style>
	<div class="clearfix"></div>


	<div class="container customFont borderRadius style"
		style="background-color: #3f94ae">

		<div class="page-container">
			<div class="page-sidebar-wrapper"></div>
			<div class="page-content-wrapper" ng-controller="techpediaArchiveController"
							ng-init="InitLoad()">
				<div class="page-content">
					<div class="row">
						<div class="col-md-12">
							<!-- <h3 class="page-title" style="color: white;">
							<font size="15"><i class="fa fa-dashboard custom"></i></font>&nbsp;DASHBOARD
						</h3> -->

							<ul class="page-breadcrumb breadcrumb"
								style="background-color: #217690; color: white !important;">
								<li><a style="color: white !important;" href="./">Home</a>
									<font style="font-weight: bold; color: white; font-size: 18px;">&raquo;</font></li>
								<li style="content: none !important;">Archive</li>

							</ul>
						</div>
					</div>
					<br>
					<div class="clearfix"></div>
					<!-- my project code starts here -->
					<div class="row">
						<div 
							style="margin-left: 0px; margin-right: 0px; padding-left: 0px; padding-right: 0px;">
							<div id="Reviewheader">
								<span>Techpedia Archive</span>
							</div>
							<div style="" class="col-xs-6 col-xs-offset-3">
								<table style="background-color: white;" class="table table-condensed table-hover">
									<tr style="text-align: center;">
										<th style="text-align: center; font-weight: bold;">File
											Name</th>
										<th style="text-align: center; font-weight: bold;">Download</th>
									</tr>
									<tr ng-repeat="file in fileArchive">
										<td>{{file}}</td>
										<td style="text-align: center;"><a href=""
											ng-click="downloadArchive(file)"><i style="color: green"
												class="fa fa-download" aria-hidden="true"></i></a></td>
									</tr>

								</table>
							</div>

						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<br>
				<div class="clearfix"></div>

			</div>
		</div>
	</div>
</body>
<%}
else{
%>
<div class="alert alert-danger" role="alert">Sorry, Access Denied... click here for <a href="dashboard">Dashboard</a></div>
<%} %>
</html>
<jsp:include page="template/footer.jsp" />
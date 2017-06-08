<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="techpedia" lang="en" class="no-js">
<title>Dashboard</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
<!-- Added for graph -->
<link href="https://www.amcharts.com/lib/3/plugins/export/export.css" media="all" rel="stylesheet" type="text/css" />
<script src="js/amcharts.js" type="text/javascript"></script>
<script src="https://www.amcharts.com/lib/3/serial.js" type="text/javascript"></script>
<script src="https://www.amcharts.com/lib/3/themes/light.js" type="text/javascript"></script>
<script src="js/export.js" type="text/javascript"></script>
<script src="js/responsive.min.js" type="text/javascript"></script>
</head>
<body >
	<div class="" style="padding-left: 0px; padding-right: 0px;">
			<jsp:include page="template/reviewHeader.jsp"></jsp:include>
	</div>
	<div id="sideNavPanel" class="col-xs-2" style="padding-left: 0px; padding-right: 0px;margin-left: 0px;"><jsp:include
			page="template/reviewSideMenu.jsp"></jsp:include></div>
	
	<div ng-controller="ReviewDashBoardController" ng-init="Initload()" >
		<div class="content-wrapper">
		<div id="mainPanelBody" class="col-xs-10 col-md-10"
			style="" >
			<div
				style="padding-left: 20px !important; background-color: #3575AD; color: white; height: 56px; padding-top: 15px; font-family: arial; font-size: 20px; font-weight: bolder;">
				DASHBOARD</div>

			<%-- 	<div>
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<ul class="page-breadcrumb breadcrumb">
						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home&nbsp;</a><font
							style="color: black; font-size: 18px;">&raquo;</font></li>
						<!-- <li><a href="dashboard">Dashboard&nbsp;</a><font
						style="color: black; font-size: 18px;">&raquo;</font></li> -->
						<li>Dashboard</li>
						<%
							} else {
						%><li><a href="./">Home&nbsp;</a><font
							style="color: black; font-size: 18px;">&raquo;</font></li>
						<li>Dashboard</li>
						<%
							}
						%>
					</ul>

				</div> --%>

			<div class="clearfix">&nbsp;</div>
			<!-- <div class="container-fluid"> -->
			<div class="row">
			<div class="col-xs-12 col-md-4"
				style="box-shadow: 0 0 2em #b2b2b2; background-color: white;">
				<div class="brandAdmin col-xs-12"></div>
				<div>&nbsp;</div>
				<a href="reviewGYTIProjects">
						<div class="col-xs-5 col-md-5">
								<img src="images/review.png" height="64px">
						</div>
						
							<div class="col-xs-7 col-md-7"
							style="font-family: corbel regular; font-size: 17px; color: #008bc1;">Review
							Innovations/Ideas
							</div>
						
					</a>
				<div class="col-xs-12">&nbsp;</div>

			</div>
			<div class="col-xs-12 col-md-4"
				style="box-shadow: 0 0 2em #b2b2b2; background-color: white;">
				<div class="brandAdmin col-xs-12"></div>
				<div>&nbsp;</div>
				<a href="">
					<div class="col-xs-5 col-md-5">
						<img src="images/total.png" height="64px">
					</div>
					<div class="col-xs-7 col-md-7"
						style="font-family: corbel regular; font-size: 17px; color: #008bc1;">Total
						Innovation Ideas</div>
				</a>
				<div class="col-xs-12">&nbsp;</div>
			</div>
			<div class="col-xs-12 col-md-4"
				style="box-shadow: 0 0 2em #b2b2b2; background-color: white;">
				<div class="brandAdmin col-xs-12"></div>
				<div>&nbsp;</div>
				<a href="">
					<div class="col-xs-5 col-md-5">
						<img alt="" src="images/total_idea.png" height="64px">
					</div>
					<div class="col-xs-7 col-md-7">
						<p
							style="font-family: verdana regular; font-size: 31px; color: #008bc1; margin-top: -17px;">2563</p>
						<p
							style="color: #292929; font-family: corbel regular; font-size: 13px">Total
							Submitted Ideas</p>
					</div>
				</a>
				<div class="col-xs-12 clearfix">&nbsp;</div>
			</div>
			</div>
			<!-- </div> -->
			
			<div class="col-xs-12 clearfix">&nbsp;</div>
			<div class="col-xs-12 " style="clear: both;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<!-- <div style="margin-top: 150px; height: 400px" class=""
						id="chart_div"></div> -->
			<div id="chartdiv"></div>
		</div>
		</div>
	</div>

	<a href="#0" class="cd-top">Top</a>
</body>

</html>
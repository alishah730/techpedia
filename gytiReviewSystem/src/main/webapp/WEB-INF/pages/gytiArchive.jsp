<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html ng-app="techpedia">
<title>GYTI Archive</title>
<link rel="shortcut icon" type="image/x-icon"
	href="images/favicon-archive.ico">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="template/reviewHeader.jsp"></jsp:include>
<style type="text/css">
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

.NormalFont {
	style: font-weight: normal !important;
}

/*--------------- Page style ---------------*/
</style>
</head>

<div id="sideNavPanel" class="col-xs-2"
	style="padding-left: 0px; padding-right: 0px; margin-left: 0px;">
	<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
</div>
<body>
	<div id="mainPanelBody" class="col-xs-10 col-md-10 content-wrapper"
		ng-controller="gytiArchiveController" ng-init="InitLoad()"
		style="margin-left: 0px; margin-right: 0px; padding-left: 0px; padding-right: 0px;">
		<div id="Reviewheader">
			<span>GYTI Review System Archive</span>
		</div>
		<div style="" class="col-xs-6 col-xs-offset-3">
			<table class="table table-striped table-condensed table-hover">
				<tr style="text-align: center;">
					<th style="text-align: center;font-weight: bold;">File Name</th>
					<th style="text-align: center; font-weight: bold;">Download</th>
				</tr>
				<tr ng-repeat="file in fileArchive">
					<td>{{file}}</td>
					<td style="text-align: center;"><a href="" ng-click="downloadArchive(file)"><i style="color: green" class="fa fa-download" aria-hidden="true"></i></a></td>
				</tr>

			</table>
		</div>

	</div>
</body>
<a href="#0" class="cd-top">Top</a>
</html>
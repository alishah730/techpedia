<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="techpedia">
<title>Review GITY Projects</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
.table-striped>tbody>tr:nth-child(odd)>td {
	background-color: #5F9EA0;
	color: black;
}
/* .row {
    margin-right: 0px !important;
    margin-left: 0px !important;
} */
.modal-dialog {
	width: 70% !important;
}

#Reviewheader {
	background-color: white;
	color: white;
	padding: 5px;
}

.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
}

.breadcrumb {
	background-color: white;
	margin-bottom: 0px;
}

@import
	url("https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css")
	;

.search {
	position: relative;
	color: #aaa;
	font-size: 16px;
}

.search input {
	/* width: 150px; */
	height: 30px;
	background: #fcfcfc;
	border: 1px solid #aaa;
	border-radius: 5px;
	box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;
}

.search input {
	text-indent: 25px;
}

.search .fa-search {
	position: absolute;
	top: 7px;
	left: 18px;
}

.tabsdemoStaticTabs md-tab-content {
	padding: 25px;
}

.tabsdemoStaticTabs md-tab-content:nth-child(1) {
	background-color: #42A5F5;
	height: auto;
}

.tabsdemoStaticTabs md-tab-content:nth-child(2) {
	background-color: #689F38;
	height: auto;
}

.tabsdemoStaticTabs md-tab-content:nth-child(3) {
	background-color: #26C6DA;
	height: auto;
}

.tabsdemoStaticTabs .after-tabs-area>span {
	margin-top: 25px;
	padding-right: 15px;
	vertical-align: middle;
	line-height: 30px;
	/* height: 35px; */
}

.tabsdemoStaticTabs .after-tabs-area>md-checkbox {
	margin-top: 26px;
	margin-left: 0;
}

/*
Copyright 2016 Google Inc. All Rights Reserved. 
Use of this source code is governed by an MIT-style license that can be in foundin the LICENSE file at http://material.angularjs.org/license.
*/
.notification-counter {
	font-family: Arial, Helvetica, sans-serif;
	padding: 5px 7px 4px 7px;
	color: #fff;
	line-height: 13px;
	text-shadow: none;
	/* position: absolute; */
	right: 10px;
	top: 11px;
	background: #5B6368;
	font-size: 11px;
	border-radius: 2px;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	box-shadow: 0 1px 1px rgba(255, 255, 255, 0.3), 0 1px 1px
		rgba(0, 0, 0, 0.2) inset;
	-webkit-box-shadow: 0 1px 1px rgba(255, 255, 255, 0.3), 0 1px 1px
		rgba(0, 0, 0, 0.2) inset;
	-moz-box-shadow: 0 1px 1px rgba(255, 255, 255, 0.3), 0 1px 1px
		rgba(0, 0, 0, 0.2) inset;
}

.carddemoBasicUsage .card-media {
	background-color: #999999;
}

.tabsdemoDynamicHeight md-content {
	background-color: transparent !important;
}

.tabsdemoDynamicHeight md-content md-tabs {
	background: #f6f6f6;
	border: 1px solid #e1e1e1;
}

.tabsdemoDynamicHeight md-content md-tabs md-tabs-wrapper {
	background: white;
}

.tabsdemoDynamicHeight md-content h1:first-child {
	margin-top: 0;
}

.modal-body {
	max-height: calc(100vh - 210px);
	overflow-y: auto;
}

.search {
	position: relative;
	color: #aaa;
	font-size: 16px;
}

.search input {
	/* width: 150px; */
	height: 30px;
	background: #fcfcfc;
	border: 1px solid #aaa;
	border-radius: 5px;
	box-shadow: 0 0 3px #ccc, 0 10px 15px #ebebeb inset;
}

.search input {
	text-indent: 25px;
}

.search .fa-search {
	position: absolute;
	top: 7px;
	left: 18px;
}

.tdWidth {
	width: 40%;
	text-align: justify;
}

td:last-child {
	text-align: justify;
}
.bootstrap-datetimepicker-widget table td,
.bootstrap-datetimepicker-widget table th {
  text-align: center;
  border-radius: 0px;
  background-color:  #2B6D8D;
  color:#fff;
}
</style>
<script src="js/script.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
</head>
<div class="" style="padding-left: 0px; padding-right: 0px;">
			<jsp:include page="template/reviewHeader.jsp"></jsp:include>
		</div>
		<div id="sideNavPanel" class="col-xs-2" style="padding-left: 0px; padding-right: 0px;margin-left: 0px;">
			<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
		</div>
<body style="background-color: #f5f5f5;">
	<div ng-controller="revieweGYTIProjectsController" ng-init="InitLoad()"
		ng-cloak="">
		
		
		<div id="mainPanelBody" class="col-xs-10 col-md-10">

			<div id="Reviewheader" style="background-color: #cecfd1;">
				<p
					style="font-size: 22px; color: black; text-align: justify; margin-top: 10px; margin-left: 10px;">REVIEW
					GYTI PROJECT</p>
			</div>

			<div id="Reviewheader" style="padding: 0px;">
				<!-- 	<h4>Add Reviewer</h4> -->
				<ul class="page-breadcrumb breadcrumb">
					<li style="color: gray;"><a href="./">Home&nbsp;</a> <font
						style="color: gray; font-size: 18px;">&raquo;</font></li>
					<li style="color: gray;"><a href="reviewDashboard">Dashboard&nbsp;</a><font
						style="color: #cecfd1; font-size: 18px;">&raquo;</font></li>
					<li style="color: gray;">Review GYTI Project<font
						style="color: #cecfd1; font-size: 18px;"></font></li>
						<li>
						<div class="col-xs-3 col-md-3 pull-right"
						style="display: inline-block;">
							<div class="form-group" style="z-index: 0">
							
								<div class='input-group date' id='datetimepicker'>
									<input  type='text' ng-model="currentYear" class="form-control yearCalender" style="z-index: 0" value="{{currentYear}}" readonly/> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span>
								</div>
							</div>

							<!-- <div class="col-xs-3" style="padding-right: 0px; color: black">Year
							&nbsp;</div>
						<div class="dropdown col-xs-4" style="padding-left: 0px;">
							<a class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown"
								style="background-color: white; color: black; font-size: 16px;">
								{{SelecetdYear}}&nbsp;&nbsp; <i class="fa fa-chevron-down"
								aria-hidden="true" style="margin-left: 10%;"></i>
							</a>
							<ul class="dropdown-menu" style="width: 90px;">
								<li><a href="" ng-click="selectYear(1990)">1990 </a></li>
								<li><a href="" ng-click="selectYear(1991)">1991 </a></li>
								<li><a href="" ng-click="selectYear(1992)">1992</a></li>
								<li><a href="" ng-click="selectYear(1993)">1993</a></li>
								<li><a href="" ng-click="selectYear(1994)">1994</a></li>
								<li><a href="" ng-click="selectYear(1995)">1995</a></li>
								<li><a href="" ng-click="selectYear(1996)">1996</a></li>
								<li><a href="" ng-click="selectYear(1997)">1997</a></li>
								<li><a href="" ng-click="selectYear(1998)">1998</a></li>
								<li><a href="" ng-click="selectYear(1999)">1999</a></li>
								<li><a href="" ng-click="selectYear(2000)">2000</a></li>
								<li><a href="" ng-click="selectYear(2001)">2001 </a></li>
								<li><a href="" ng-click="selectYear(2002)">2002</a></li>
								<li><a href="" ng-click="selectYear(2003)">2003</a></li>
								<li><a href="" ng-click="selectYear(2004)">2004</a></li>
								<li><a href="" ng-click="selectYear(2005)">2005</a></li>
								<li><a href="" ng-click="selectYear(2006)">2006</a></li>
								<li><a href="" ng-click="selectYear(2007)">2007</a></li>
								<li><a href="" ng-click="selectYear(2008)">2008</a></li>
								<li><a href="" ng-click="selectYear(2009)">2009</a></li>
								<li><a href="" ng-click="selectYear(2010)">2010</a></li>
								<li><a href="" ng-click="selectYear(2011)">2011 </a></li>
								<li><a href="" ng-click="selectYear(2012)">2012</a></li>
								<li><a href="" ng-click="selectYear(2013)">2013</a></li>
								<li><a href="" ng-click="selectYear(2014)">2014</a></li>
								<li><a href="" ng-click="selectYear(2015)">2015</a></li>
								<li><a href="" ng-click="selectYear(2016)">2016</a></li>
								
							</ul>
						</div> -->
					</div></li>
				</ul>
				
				
				
				
				
			</div>

			<div class="tabsdemoDynamicHeight">
				<md-content> <md-tabs md-dynamic-height=""
					md-border-bottom="">
					
					
				<!-- pending Projects Tab -->	
				 <md-tab> <md-tab-label>
				<md-tooltip md-direction="top">{{projectsProposedForReview.length}}&nbsp;
				projects to review</md-tooltip>Pending For Review&nbsp;&nbsp; <strong><md-span
						class="notification-counter">{{projectsProposedForReview.length}}</md-span></strong></md-tab-label>


				<md-tab-body>

				<div class="search">
					<span class="fa fa-search"></span> <input class="form-control"
						type="text" placeholder="Search..." ng-model="SearchText.$">
				</div>
				<div class="carddemoBasicUsage">
					<md-content class="md-padding" layout-xs="column" layout="row" flex
						layout-wrap>
					<div style="text-align: center;"
						ng-show="projectsProposedForReview.length==0">
						<p>
							<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
						</p>
						<p>Sorry, There are no projects in this section to review.</p>
					</div>
					<div flex-xs="" flex-gt-xs="33" layout="column"
						ng-repeat="proposedProjets in projectsProposedForReview | filter:SearchText">
						<md-card> <md-card-title> <md-card-title-text>
						<span class="md-headline">{{proposedProjets.projTitle}}</span> <!-- <span
												class="md-subhead">Medium</span> --> </md-card-title-text> <md-card-title-media>
						<div class="md-media-md card-media">
							
								<img ng-show="proposedProjets.photo1Path=='undefined'" src="images/Projects.jpg" class="md-card-image img-responsive"
								alt="GYTIProject">
							<img ng-show="proposedProjets.photo1Path !='undefined'" src="${pageContext.request.contextPath}/image/{{proposedProjets.photo1Path}}" class="md-card-image img-responsive"
								alt="GYTIProject">
						</div>
						</md-card-title-media> </md-card-title> <md-card-actions layout="row" layout-align="end center">
						<md-button
							class="md-raised "
							ng-click="viewGYTIProjDetails(proposedProjets.projId)"
							data-toggle="modal" data-target="#GYTIprojectDetailsModal">
						 <i class="fa fa-eye" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Details</span></md-button>
						 
						<!-- <md-button class="md-raised "
							ng-click="clickReview(proposedProjets.projId)"> <i
							class="fa fa-pencil" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Review</span></md-button> -->
						<md-button class="md-raised "
							ng-click="acceptReview(proposedProjets.projId)" data-toggle="modal" data-target="#acceptReviewModal"> <i 
							class="fa fa-check-square-o" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs">Accept</span></md-button>
							
						<md-button class="md-raised "
							ng-click="rejectReview(proposedProjets.projId)" data-toggle="modal" data-target="#rejectReviewModal"> <i
							class="fa fa fa-times" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs">Reject</span></md-button></md-card-actions> </md-card>
					</div>
					</md-content>
				</div>
				</md-tab-body> </md-tab> 
				
				
				<!-- Accept Projects Tab -->
				
				<md-tab> <md-tab-label> <md-tooltip
					md-direction="top">{{projectsAcceptedForReview.length}}&nbsp;
				projects accepted for review</md-tooltip>Accepted For Review&nbsp;&nbsp;<strong class="notification-counter">{{projectsAcceptedForReview.length}}</i></strong></md-tab-label>
				<md-tab-body>

				<div class="search">
					<span class="fa fa-search"></span> <input class="form-control"
						type="text" placeholder="Search..." ng-model="SearchText.$">
				</div>
				<div class="carddemoBasicUsage">
					<md-content class="md-padding" layout-xs="column" layout="row" flex
						layout-wrap>
					<div style="text-align: center;"
						ng-show="projectsAcceptedForReview.length==0">
						<p>
							<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
						</p>
						<p>Sorry, There are no projects in this section to review.</p>
					</div>
					<div flex-xs="" flex-gt-xs="33" layout="column"
						ng-repeat=" acceptedProjects in projectsAcceptedForReview | filter:SearchText">
						<md-card> <md-card-title> <md-card-title-text>
						<span class="md-headline">{{acceptedProjects.projTitle}}</span> <!-- <span
												class="md-subhead">Medium</span> --> </md-card-title-text> <md-card-title-media>
						<div class="md-media-md card-media">	
							<img ng-show="acceptedProjects.photo1Path =='undefined'" src="images/Projects.jpg" class="md-card-image img-responsive"
								alt="GYTIProject">
							<img ng-show="acceptedProjects.photo1Path !='undefined'"
							 src="${pageContext.request.contextPath}/image/{{acceptedProjects.photo1Path}}" class="md-card-image img-responsive"
								alt="GYTIProject">
						</div>
						</md-card-title-media> </md-card-title> <md-card-actions layout="row" layout-align="end center">
						<md-button class="md-raised"
							ng-click="viewGYTIProjDetails(acceptedProjects.projId)"
							data-toggle="modal" data-target="#GYTIprojectDetailsModal">
						<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Details</span></md-button>
						 <md-button class="md-raised " 
							ng-click="clickReview(acceptedProjects.projId)"> <i
							class="fa fa-pencil" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs">Review</span></md-button>
							 </md-card-actions> </md-card> 
					</div>
					</md-content>
				</div>
				</md-tab-body> </md-tab>
				
				
				<!-- Inprogress Projects Tab -->
				
				<md-tab> <md-tab-label> <md-tooltip
					md-direction="top">{{projectsInProgressForReview.length}}&nbsp;
				projects review is in process</md-tooltip>Review In Progress&nbsp;&nbsp;<strong class="notification-counter">{{projectsInProgressForReview.length}}</i></strong></md-tab-label>
				<md-tab-body>

				<div class="search">
					<span class="fa fa-search"></span> <input class="form-control"
						type="text" placeholder="Search..." ng-model="SearchText.$">
				</div>
				<div class="carddemoBasicUsage">
					<md-content class="md-padding" layout-xs="column" layout="row" flex
						layout-wrap>
					<div style="text-align: center;"
						ng-show="projectsInProgressForReview.length==0">
						<p>
							<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
						</p>
						<p>Sorry, There are no projects in this section to review.</p>
					</div>
					<div flex-xs="" flex-gt-xs="33" layout="column"
						ng-repeat=" inProgressProjects in projectsInProgressForReview | filter:SearchText">
						<md-card> <md-card-title> <md-card-title-text>
						<span class="md-headline">{{inProgressProjects.projTitle}}</span> <!-- <span
												class="md-subhead">Medium</span> --> </md-card-title-text> <md-card-title-media>
						<div class="md-media-md card-media">	
							<img ng-show="inProgressProjects.photo1Path =='undefined'" src="images/Projects.jpg" class="md-card-image img-responsive"
								alt="GYTIProject">
							<img ng-show="inProgressProjects.photo1Path !='undefined'"
							 src="${pageContext.request.contextPath}/image/{{inProgressProjects.photo1Path}}" class="md-card-image img-responsive"
								alt="GYTIProject">
						</div>
						</md-card-title-media> </md-card-title> <md-card-actions layout="row" layout-align="end center">
						<md-button class="md-raised"
							ng-click="viewGYTIProjDetails(inProgressProjects.projId)"
							data-toggle="modal" data-target="#GYTIprojectDetailsModal">
						<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Details</span></md-button>
						 <md-button class="md-raised"
							ng-click="EditReview(inProgressProjects.projId)"> <i
							class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Edit</span>
						Review</md-button> </md-card-actions> </md-card> 
					</div>
					</md-content>
				</div>
				</md-tab-body> </md-tab>
				
				
				<!-- Already Reviewed Projects Tab -->
				 <md-tab> <md-tab-label> <md-tooltip
					md-direction="top">{{projectsAlreadyReviewed.length}}&nbsp;
				projects reviewed and review can be updated</md-tooltip>Already
				Reviewed&nbsp;&nbsp;<strong class="notification-counter">{{projectsAlreadyReviewed.length}}</i></strong></md-tab-label>
				<md-tab-body>

				<div class="search">
					<span class="fa fa-search"></span> <input class="form-control"
						type="text" placeholder="Search..." ng-model="SearchText.$">
				</div>
				<div class="carddemoBasicUsage">
					<md-content class="md-padding" layout-xs="column" layout="row" flex
						layout-wrap>
					<div style="text-align: center;"
						ng-show="projectsAlreadyReviewed.length==0">
						<p>
							<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
						</p>
						<p>Sorry, There are no projects in this section to review.</p>
					</div>
					<div flex-xs="" flex-gt-xs="33" layout="column"
						ng-repeat=" reviewedProjects in projectsAlreadyReviewed | filter:SearchText">
						<md-card> <md-card-title> <md-card-title-text>
						<span class="md-headline">{{reviewedProjects.projTitle}}</span> <!-- <span
												class="md-subhead">Medium</span> --> </md-card-title-text> <md-card-title-media>
						<div class="md-media-md card-media">	
							<img ng-show="reviewedProjects.photo1Path =='undefined'" src="images/Projects.jpg" class="md-card-image img-responsive"
								alt="GYTIProject">
							<img ng-show="reviewedProjects.photo1Path !='undefined'"
							 src="${pageContext.request.contextPath}/image/{{reviewedProjects.photo1Path}}" class="md-card-image img-responsive"
								alt="GYTIProject">
						</div>
						</md-card-title-media> </md-card-title> <md-card-actions layout="row" layout-align="end center">
						<md-button class="md-raised"
							ng-click="viewGYTIProjDetails(reviewedProjects.projId)"
							data-toggle="modal" data-target="#GYTIprojectDetailsModal">
						<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Details</span></md-button>
						<md-button class="md-raised"
							ng-click="EditReview(reviewedProjects.projId)"> <i
							class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Edit</span>
						Review</md-button> </md-card-actions> </md-card>
					</div>
					</md-content>
				</div>
				</md-tab-body> </md-tab>
				
				
				<!-- optional Projects Tab -->
				<md-tab> <md-tab-label> <md-tooltip
					md-direction="top">{{projectsOptionalForReview.length}}&nbsp;
				projects to review</md-tooltip>Optional For Review&nbsp;&nbsp;<strong
					class="notification-counter">{{projectsOptionalForReview.length}}</strong></md-tab-label>


				<md-tab-body>
				<div class="search">
					<span class="fa fa-search"></span> <input class="form-control"
						type="text" placeholder="Search..." ng-model="SearchText.$">
				</div>

				<div class="carddemoBasicUsage">
					<md-content class="md-padding" layout="row" flex layout-wrap>
					<div style="text-align: center;"
						ng-show="projectsOptionalForReview.length==0">
						<p>
							<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
						</p>
						<p>Sorry, There are no projects in this section to review.</p>
					</div>
					<div flex-xs="" flex-gt-xs="33" layout="column"
						ng-repeat="optionalProjects in projectsOptionalForReview | filter:SearchText "
						flex>
						<md-card> <md-card-title> <md-card-title-text>
						<span class="md-headline">{{optionalProjects.projTitle}}</span> <!-- <span
												class="md-subhead">Medium</span> --> </md-card-title-text> <md-card-title-media>
						<div class="md-media-md card-media">
							<img ng-show="optionalProjects.photo1Path=='undefined' || optionalProjects.photo1Path==null" src="images/Projects.jpg" class="md-card-image img-responsive"
								alt="GYTIProject">
							<img ng-show="optionalProjects.photo1Path !='undefined'" src="${pageContext.request.contextPath}/image/{{optionalProjects.photo1Path}}" class="md-card-image img-responsive"
								alt="GYTIProject">
						</div>
						</md-card-title-media> </md-card-title> <md-card-actions layout="row" layout-align="end center">
						<md-button
							class="md-raised "
							ng-click="viewGYTIProjDetails(optionalProjects.projId)"
							data-toggle="modal" data-target="#GYTIprojectDetailsModal">
						<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Details</span></md-button>
						<md-button class="md-raised " 
							ng-click="clickReview(optionalProjects.projId)"> <i
							class="fa fa-pencil" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs">Review</span></md-button>
							
							<md-button class="md-raised "
							ng-click="clickToForward(optionalProjects.projId)"> <i
							class="fa fa-share" aria-hidden="true"></i>&nbsp;<span class="sr-only-xs"> Forward</span></md-button> </md-card-actions> </md-card>
					</div>
					</md-content>
				</div>
				</md-tab-body> </md-tab>
				 </md-tabs>
				 
				</md-content>
				
			</div>
			<!-- Poroject details Modal -->
			<div class="modal fade" data-easein="perspectiveDownIn" id="GYTIprojectDetailsModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"
							style="background-color: #31b0d5; color: white; text-align: center">
							<button ng-click="clicktoExitAndResetData()" type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">{{GYTIProject.projTitle}} &nbsp;</h4>
								<div class="dropdown col-xs-4 col-xs-offset10"
									style="width: 150px; padding-left: 0px;">
									<button ng-click="DownladPdf()" class="btn btn-success">Download</button>
								</div>
						</div>
						
						<div layout="row" layout-sm="column" layout-align="space-around" ng-hide="GYTIProject !=null && projteamLeader !=null">
            					<md-progress-circular class="md-accent"  md-diameter="60px"></md-progress-circular>
        				 </div>
						
						<div class="modal-body " ng-show="message.length>0 && GYTIProject ==null && projteamLeader ==null ">
						<p class="alert alert-info" role="alert" ng-repeat="msg in message">{{msg}}</p>
						</div>
						<div ng-show="GYTIProject !=null && projteamLeader !=null" class="modal-body" style="height: 550px;">
							<div class="panel-body col-xs-8  no-collapse">
								<!-- <div class="table-responsive"> -->
								<table
									class="table table-responsive table-condensed table-hover">
									<div
										style="background-color: black; color: white; text-align: center; height: 24px; border-radius: 4px; font-family: cursive;">


										User Details</div>
									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">Innovator/Teamleader</md-tooltip>
											<strong><i style="font-size: 21px;"
												class="fa fa-user" aria-hidden="true"></i></strong></td>
										<td><strong>:</strong></td>
										<td>{{projteamLeader.firstName}}
												{{projteamLeader.midName}} {{projteamLeader.lastName}}</td>
									</tr>
									<tr ng-show="GYTIProject.projUniversity.length>0">
										<td><md-tooltip md-direction="left" style="z-index:9999">University</md-tooltip><strong><i
												class="fa fa-university" aria-hidden="true"></i></strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projUniversity}}</td>

									</tr>
									<tr ng-show="GYTIProject.projCollege.length>0">
										<td><md-tooltip md-direction="left" style="z-index:9999">College</md-tooltip><strong><i
												class="fa fa-graduation-cap" aria-hidden="true"></i></strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projCollege}}</td>
									</tr>
									<tr ng-show="GYTIProject.projTeamMemberList.length>0">
										<td><md-tooltip md-direction="left" style="z-index:9999">Team
											Members</md-tooltip><strong><i class="fa fa-users"
												aria-hidden="true"></i></strong></td>
										<td><strong>:</strong></td>
										<td><span style="margin: 0px;"
												ng-repeat="members in GYTIProject.projTeamMemberList">
												<span >{{members.teamMemberName}}</span>
											</p></td>
									</tr>
									<!-- <tr ng-show="projteamLeader.email.length>0">
										<td><md-tooltip md-direction="left" style="z-index:9999">Email</md-tooltip><strong><i
												class="fa fa-envelope-o" aria-hidden="true"></i></strong></td>
										<td><strong>:</strong></td>
										<td>{{projteamLeader.email}}</td>
									</tr>
									<tr ng-show="projteamLeader.mobile.length>0">
										<td><md-tooltip md-direction="left" style="z-index:9999">Mobile
											No.</md-tooltip><strong><i class="fa fa-phone-square"
												aria-hidden="true"></i></strong></td>
										<td><strong>:</strong></td>
										<td>{{projteamLeader.mobile}}</td>
									</tr> -->
								</table>
								<!-- </div> -->
							</div>
							<div class="panel-body col-xs-4  no-collapse">

								<img ng-show="GYTIProject.photo1Path =='undefined'" src="images/Projects.jpg" class="md-card-image"
								alt="GYTIProject">
							<img ng-show="GYTIProject.photo1Path !='undefined'" src="${pageContext.request.contextPath}/image/{{GYTIProject.photo1Path}}" class="md-card-image"
								alt="GYTIProject">
							</div>
							<div class="panel-body col-xs-12  no-collapse">
								<!-- <div class="table-responsive"> -->
								<table
									class="table table-responsive table-condensed table-hover ">
									<div
										style="background-color: black; color: white; text-align: center; height: 24px; border-radius: 4px; font-family: cursive;">


										Innovation Details</div>
									<tr>
										<td class="tdWidth"><strong>Submission Year</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projAwardYear}}</td>
									</tr>
									<tr>
										<td class="tdWidth"><strong>Submission Date</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projStartDate}}</td>

									</tr>
									<tr>
										<td class="tdWidth"><strong>Category</strong></td>
										<td><strong>:</strong></td>
										<td><p style="margin: 0px;"
												ng-repeat="branch in projBranchList">{{branch.branchName}}</p></td>
									</tr>
									<tr ng-show="GYTIProject.projFacultyName.length>0">
										<td class="tdWidth"><strong>Research Guide /
												Supervisor Name</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projFacultyName}}</td>
									</tr>
									<tr ng-show="GYTIProject.projAcademicProgram.length>0">
										<td class="tdWidth"><strong>Project was
												completed under which Academic Program?</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projAcademicProgram}}
											</p>
										</td>
									</tr>
									<tr>
										<td class="tdWidth"><strong>In which year this
												project was finished or is tentatively going to be finished?</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projEndDate}}</td>
									</tr>
									<!-- <tr ng-show="GYTIProject.projFacultyName.length>0">
										<td class="tdWidth"><strong>Discipline / Sector
												of project</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projFacultyName}}</td>
									</tr> -->
									<tr ng-show="GYTIProject.projStatusInfo">
										<td class="tdWidth"><strong>Status of your
												innovation</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projStatusInfo}}</td>
									</tr>
									<tr ng-show="GYTIProject.projCopyrightInfo.length>0">
										<td class="tdWidth"><strong>Have you filed
												patent/copyright of your innovations</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projCopyrightInfo}}</td>
									</tr>
									<tr ng-show="GYTIProject.projProofInfo.length>0">
										<td class="tdWidth"><strong>If it is possible to
												be made proof of concept of your innovation , have you made
												it</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projProofInfo}}</td>
									</tr>
									<tr ng-show="GYTIProject.projFeature.length>0">
										<td class="tdWidth"><strong>Unique feature of
												your innovation</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projFeature}}</td>
									</tr>
									<tr ng-show="GYTIProject.projFrugalityInfo.length>0">
										<td class="tdWidth"><strong>Frugality of your
												innovations (cost effectiveness)</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projFrugalityInfo}}</td>
									</tr>
									<tr ng-show="GYTIProject.projObjectiveInfo.length>0">
										<td class="tdWidth"><strong>What is the exact
												problem that your project has addressed?</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projObjectiveInfo}}</td>
									</tr>
									<tr ng-show="GYTIProject.projImpactInfo.length>0">
										<td class="tdWidth"><strong>Proposed
												outcome/impact of your innovation ?</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projImpactInfo}}</td>
									</tr>
									<tr ng-show="GYTIProject.projContributeInfo.length>0">
										<td class="tdWidth"><strong>Who have made
												contribution towards this project and specific detail i.e.
												student team, faculty, mentor, anyone else.</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projContributeInfo}}</td>
									</tr>
									<tr ng-show="GYTIProject.projAbstract.length>0">
										<td class="tdWidth"><strong>Synopsis / Abstract
												of innovation</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projAbstract}}</td>
									</tr>
									<tr ng-show="GYTIProject.projRequiredResource.length>0">
										<td class="tdWidth"><strong>For research work to
												develop into a commercially viable product/service, what
												would be the resources required?</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projRequiredResource}}</td>
									</tr>
									<tr ng-show="GYTIProject.projResearchContinue.length>0">
										<td class="tdWidth"><strong>Do you think this
												research should continue further? If Yes, why and with what
												objective? If No, Why?</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projResearchContinue}}</td>
									</tr>
									<tr ng-show="GYTIProject.projPatentWork.length>0">
										<td class="tdWidth"><strong>Have you filed any
												patent for your research work? Yes or No If yes please give
												details</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projPatentWork}}</td>
									</tr>
									<tr ng-show="GYTIProject.projPublishedPaper.length>0">
										<td class="tdWidth"><strong>Have you published
												any Research paper in refereed Journal? Yes or No If yes
												please attach a copy or give reference</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projPublishedPaper}}</td>
									</tr>
									<tr ng-show="GYTIProject.projBenefitInfo.length>0">
										<td class="tdWidth"><strong>How do you feel that
												your innovation/project can 'Create more value/benefit from
												less resource/cost/effort for more and More People'?</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projBenefitInfo}}</td>
									</tr>
									<tr ng-show="GYTIProject.projOtherInfo.length>0">
										<td class="tdWidth"><strong>Any other
												information about your research you would like to share?</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projOtherInfo}}</td>
									</tr>
									<!--<tr>
										<td class="tdWidth"><strong>Discipline / Sector
												of project</strong></td>
										<td><strong>:</strong></td>
										<td></td>
									</tr> -->
								</table>
								<!-- </div> -->
							</div>




						</div>
						<div class="clearfix">&nbsp;</div>
						<div class="modal-footer"
							style="align: center; text-align: center;">

							<button data-dismiss="modal" type="button" class="btn btn-info"
								ng-click="clicktoExitAndResetData()">Exit</button>
						</div>
					</div>
				</div>
			</div>


<!-- Reject project modal-->
		<div class="modal fade" data-easein="perspectiveDownIn" id="rejectReviewModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Reject
							Innovation</h4>

					</div>
					<div class="modal-body" style="text-align: center;">

						 <i id="effect" class="fa fa-check-circle-o"
								style="color: green; font-size: 7em;"
								ng-show="addMsgSuccess.length>0"></i>

							<div class="alert alert-sm alert-info alert-dismissible"
								role="alert" id="hide"
								ng-show="addMsgSuccess.length>0 || addMsgerror.length>0">
								<p style="text-align: center">
									<span style="text-align: center" ng-show="addMsgSuccess.length>0"><p
											ng-repeat="msg in addMsgSuccess" style="text-align: center">{{msg}}</p></span>
									<span style="text-align: center" ng-show="addMsgerror.length>0"><p
											ng-repeat="msgerr in addMsgerror" style="text-align: center">{{msgerr}}</p></span>
							</div>
					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button data-dismiss="modal" type="button" class="btn btn-info" ng-click="InitLoad()">Exit</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- Accept project modal-->
		<div class="modal fade" data-easein="perspectiveDownIn" id="acceptReviewModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Accept
							Innovation</h4>

					</div>
					<div class="modal-body" style="text-align: center;">

						 <i id="effect" class="fa fa-check-circle-o"
								style="color: green; font-size: 7em;"
								ng-show="addMsgSuccess.length>0"></i>

							<div class="alert alert-sm alert-info alert-dismissible"
								role="alert" id="hide"
								ng-show="addMsgSuccess.length>0 || addMsgerror.length>0">
								<p style="text-align: center">
									<span style="text-align: center" ng-show="addMsgSuccess.length>0"><p
											ng-repeat="msg in addMsgSuccess" style="text-align: center">{{msg}}</p></span>
									<span style="text-align: center" ng-show="addMsgerror.length>0"><p
											ng-repeat="msgerr in addMsgerror" style="text-align: center">{{msgerr}}</p></span>
							</div>
					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button data-dismiss="modal" type="button" class="btn btn-info" ng-click="InitLoad()">Exit</button>
					</div>
				</div>
			</div>
		</div>


			<div class="col-xs-12">&nbsp;</div>

			<div class="col-xs-12">&nbsp;</div>

		</div>
	<a href="#0" class="cd-top">Top</a>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
</div>
</body>
</html>
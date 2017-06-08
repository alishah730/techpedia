<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html ng-app="techpedia">
<title>All Reviews</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
 .table-striped>tbody>tr:nth-child(odd)>td {
	background-color: #5F9EA0;
	color: black;
}

/* tr:nth-child(odd) {
    background-color: #5F9EA0;
	color: black;
} */
/* .row {
    margin-right: 0px !important;
    margin-left: 0px !important;
} */
/* .modal-dialog {
	width: 70%;
} */
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
	font-weight: bold;
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
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
</head>
<div class="" style="padding-left: 0px; padding-right: 0px;">
		<jsp:include page="template/reviewHeader.jsp"></jsp:include>
</div>
		
<%if(((String)(session.getAttribute("revUsrId"))).equals("TrsAdmin")){ %>
<body  style="background-color: #f5f5f5;">
<div id="sideNavPanel" class="col-xs-2" style="padding-left: 0px; padding-right: 0px;margin-left: 0px;">
			<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
</div>
	<div id="mainPanelBody"  class="col-xs-10 col-md-10 content-wrapper" ng-controller="getAllReviewsController" ng-init="InitLoad()"
		ng-cloak="">
		
		
		<div class=""  >

			<div id="Reviewheader" style="background-color: #cecfd1;">
				<p
					style="font-size: 22px; color: black; text-align: justify; margin-top: 10px; margin-left: 10px;">All
					Reviews</p>
			</div>

			<div id="Reviewheader" style="padding: 0px;">
				<!-- 	<h4>Add Reviewer</h4> -->
				<ul class="page-breadcrumb breadcrumb">
					<li style="color: gray;"><a href="./">Home&nbsp;</a> <font
						style="color: gray; font-size: 18px;">&raquo;</font></li>
					<li style="color: gray;"><a href="reviewDashboard">Dashboard&nbsp;</a><font
						style="color: #cecfd1; font-size: 18px;">&raquo;</font></li>
					<li style="color: gray;">All Reviews<font
						style="color: #cecfd1; font-size: 18px;"></font></li>
				</ul>
			</div>

			<div>
				<div class="" style="background-color: #23282e; height: 70px;">
				<div class="col-xs-12">&nbsp;</div>
				<!-- <div class="col-xs-3 col-md-3 pull-left" style="display: inline-block;">
					<div class="col-xs-3" style="padding-right: 0px; color: white">Show
						&nbsp;</div>
					<div class="dropdown col-xs-4" style="padding-left: 0px;">
						<a class="btn btn-primary dropdown-toggle ng-binding" type="button" data-toggle="dropdown" style="background-color: white; color: black; font-size: 16px;">
							10&nbsp;&nbsp; <i class="fa fa-chevron-down" aria-hidden="true" style="margin-left: 10%;"></i>
						</a>
						<ul class="dropdown-menu" style="width: 93%;">
							<li><a href="" ng-click="SelectItemNumber(5)">5 </a></li>
							<li><a href="" ng-click="SelectItemNumber(10)">10</a></li>
							<li><a href="" ng-click="SelectItemNumber(20)">20</a></li>
						</ul>
					</div>
					<div class="col-xs-3" style="padding-left: 0px; color: white;">&nbsp;entries</div>

				</div> -->
		
				<div class="col-xs-3 col-md-3" style="padding-left: 0px;">

					<div class="search">
						<span class="fa fa-search"></span> <input class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text" placeholder="Search..." ng-model="SearchText.$" aria-invalid="false">
					</div>

				</div>
				<div class="col-xs-4 col-md-4 pull-left" style="text-align: center;font-size:2vh; color: white; font-weight: bold">
				<p>Year Wise Projects Click here to download&nbsp;&nbsp;<i class="fa fa-long-arrow-right" aria-hidden="true" style="font-size:20px;color:white;"></i></p>
				</div>
				
				<div class="col-xs-3 col-md-3 pull-right">
				
							<div class="form-group" style="z-index: 0">
							
								<div class='input-group date' id='datetimepicker'>
									<input  type='text' ng-model="currentYear" class="form-control yearCalender" style="z-index: 0" readonly/> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span>
								</div>
							</div>
				</div>

				<div class="col-xs-2 col-md-2 pull-right">
					<div class="dropdown col-xs-4 col-xs-offset10" style="width: 150px; padding-left: 0px;">
					 	<i class="fa fa-file-pdf-o" aria-hidden="true" style="color:white; background-color: black;" ng-click="getAllReviewsPdf()"><md-tooltip>Download As Pdf</md-tooltip></i>
						<i class="fa fa-file-excel-o" aria-hidden="true" style="color:white; background-color: black;" ng-click="getAllReviewsXls()"><md-tooltip>Download As Xls</md-tooltip></i>
					</div>
				</div>
				<div class="col-xs-12">&nbsp;</div>

			</div>
				<div  class="tableResponsive">
					<table data-role="table"
						class="table ui-responsive table-condensed table-hover table-striped">
						<tr>
							<!-- <th custom-sort order="'reviewedDate'" sort="sort">Reviewed Date</th>
							<th custom-sort order="'participantId'" sort="sort">Participant ID</th>
							<th custom-sort order="'projTitle'" sort="sort">Title</th>
							<th custom-sort order="'projCategory'" sort="sort">Category</th>
							<th custom-sort order="'assignedByName'" sort="sort">Assigned By</th>
							<th custom-sort order="'reviewDoneByName'" sort="sort">Reviewed By</th>
							<th custom-sort order="'averageRating'" sort="sort">Average Rating</th> -->
							<td custom-sort order="'reviewedDate'" sort="sort">Reviewed Date</td>
							<td custom-sort order="'participantId'" sort="sort">Participant ID</td>
							<td custom-sort order="'projTitle'" sort="sort">Title</td>
							<td custom-sort order="'projCategory'" sort="sort">Category</td>
							<td custom-sort order="'assignedByName'" sort="sort">Assigned By</td>
							<td custom-sort order="'reviewDoneByName'" sort="sort">Reviewed By</td>
							<td custom-sort order="'averageRating'" sort="sort">Average Rating</td>
						</tr>
						<tr style="font-size: 13px;" ng-repeat="item in pagedItems[currentPage] | orderBy:sort.sortingOrder:sort.reverse  | filter:SearchText">
							<td>{{item.reviewedDate}}</td>
							<td>{{item.participantId}}</td>
							<td>{{item.projTitle}}&nbsp;<a href="" ng-click="downloadProjectSpecificReviewsPdf(item.participantId)" target="_blank"><i class="fa fa-file-pdf-o" style="color: red" aria-hidden="true"></i></a></td>
							<td>{{item.projCategory.join(",")}}</td>
							<td><p ng-repeat="assignedByAndReviewDoneByMapper in item.assignedByAndReviewDoneByMapperSet">{{assignedByAndReviewDoneByMapper.assignedByName}}</p></td>
							<td><p ng-repeat="assignedByAndReviewDoneByMapper in item.assignedByAndReviewDoneByMapperSet">
										{{assignedByAndReviewDoneByMapper.reviewDoneByName}}&nbsp;<a href="" data-toggle="modal"
											data-target="#ratingDetailsModal"
											ng-click="ShowDetailsReview(assignedByAndReviewDoneByMapper.ratingId,item.projTitle,assignedByAndReviewDoneByMapper.reviewDoneByName)"><i class="fa fa-info-circle" aria-hidden="true"></i></a>
									</p></td>
							<td>{{item.averageRating}}%</td>
						</tr> 
					</table>
				</div>
				<div style="text-align: center;"
						ng-show="ngOverallCalculatedReviewRatingVOs.length==0">
						<p>
							<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
						</p>
						<p>Sorry, There are no projects for this year.</p>
					</div>
				
				<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12"
				style="border: 1px solid black; margin-right: 12px; background-color: #23282e; height: 60px;">
				<div class="pagination pull-right" style="height: 50px;">
					<ul class="pagination" style="margin-top: -8px;">
						<li ng-class="{disabled: currentPage == 0}"><a href="#"
							ng-click="prevPage()"><i class="fa fa-backward"
								aria-hidden="true"></i>&nbsp;Prev</a></li>

						<li
							ng-repeat="n in range(pagedItems.length, currentPage, currentPage + pagedItems.length) "
							ng-class="{active: n == currentPage}" ng-click="setPage()">
							<a href ng-bind="n + 1">1</a>
						</li>

						<li ng-class="{disabled: (currentPage) == pagedItems.length - 1}">
							<a href="#" ng-click="nextPage()">Next &nbsp;<i
								class="fa fa-forward" aria-hidden="true"></i></a>
						</li>
					</ul>
				</div>
			</div>		
			</div>

			<!-- rating details modal -->
			<!-- data-easein="perspectiveDownIn" -->
			<div class="modal fade"  id="ratingDetailsModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"
							style="background-color: #31b0d5; color: white; text-align: center">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">{{projectTitle}}</h4>

						</div>
						<div class="modal-body " style="height: 550px;">
							<div
								style="background-color: black; color: white; text-align: center; height: 24px; border-radius: 4px; font-family: cursive;">
								Review And Rating Details</div>
							<div class="tableResponsive">
							<table class="table table-condensed table-hover">
								<tr>
									<td class="tdWidth"><strong>Reviewed By</strong></td>
									<td><strong>:</strong></td>
									<td>{{reviewedBy}}</td>
								</tr>
								<tr>
									<td class="tdWidth"><strong>Reviewe Start Date</strong></td>
									<td><strong>:</strong></td>
									<td>{{getReviewsByReviewer.reviewStartDate}}</td>
								</tr>
								<tr>
									<td class="tdWidth"><strong>Reviewe End Date</strong></td>
									<td><strong>:</strong></td>
									<td>{{getReviewsByReviewer.reviewEndDate}}</td>
								</tr>
							</table>
							<div>
								<table
									class="table  table-condensed table-hover">
									<div
										style="background-color: #7B7B7B; color: white; padding: 2px; height: 24px; border-radius: 4px; font-family: cursive;">
										Rating</div>
									<tr>
										<td class="tdWidth">Award Recommendation</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.revRecommendation}}</td>
									</tr>
									<tr ng-show="">
										<td class="tdWidth">Novelty</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.revNovelty}}</td>

									</tr>
									<tr ng-show="">
										<td class="tdWidth">Technical Rigor</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.revTechnicalRigor}}</td>
									</tr>
									<tr ng-show="">
										<td class="tdWidth">Social Application</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.revSocialApplication}}</td>
									</tr>
									<tr ng-show="">
										<td class="tdWidth">Frugality</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.revFrugality}}</td>
									</tr>
									<tr ng-show="">
										<td class="tdWidth">Rating percentage</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.revRatingPercentage}}</td>
									</tr>
								</table>
							</div>
							<div>
								<table
									class="table table-condensed table-hover">

									<div
										style="background-color: #7B7B7B; color: white; padding: 2px; height: 24px; border-radius: 4px; font-family: cursive;">
										Comments / Suggested Links</div>

									<tr>
										<td class="tdWidth">Comments</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.revComments}}</td>
									</tr>
									<tr>
										<td class="tdWidth">Suggested Links</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.revSuggestedLinks}}</td>
									</tr>

								</table>
							</div>
							<div>
								<table
									class="table  table-condensed table-hover">

									<div
										style="background-color: #7B7B7B; color: white; padding: 2px; height: 24px; border-radius: 4px; font-family: cursive;">
										Can Innovation/idea be taken forward?</div>
									<tr>
										<td class="tdWidth">Opinion</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.canIdeaBeTakenForward}}</td>
									</tr>
									<tr>
										<td class="tdWidth">Comments</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.canIdeaBeTakenForwardRemarks}}</td>
									</tr>

								</table>
							</div>

							<div>
								<table
									class="table  table-condensed table-hover">
									<div
										style="background-color: #7B7B7B; color: white; padding: 2px; height: 24px; border-radius: 4px; font-family: cursive;">
										Do you want more information from Author/Innovator</div>
									<tr>
										<td class="tdWidth">Opinion</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.moreInfoNeeded}}</td>
									</tr>
									<tr>
										<td class="tdWidth">Comments</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.moreInfoNeededRemarks}}</td>
									</tr>

								</table>
							</div>
							<div >
								<table
									class="table table-condensed table-hover">
									<div
										style="background-color: #7B7B7B; color: white; padding: 2px; height: 24px; border-radius: 4px; font-family: cursive;">
										Suggest this project to other reviewers</div>
									<tr>
										<td class="tdWidth">Suggest to other reviewers</td>
										<td><strong>:</strong></td>
										<td>{{getReviewsByReviewer.suggestToOtherRev}}</td>
									</tr>

								</table>
								</div>
							</div>

							<!-- <tr ng-show="projteamLeader.email.length>0">
									<td></td>
									<td><strong>:</strong></td>
									<td>{{getReviewsByReviewer.revRecommendation}}</td>
								</tr>
								<tr ng-show="projteamLeader.mobile.length>0">
									<td></td>
									<td><strong>:</strong></td>
									<td>{{getReviewsByReviewer.revRecommendation}}</td>
								</tr>
								<tr ng-show="GYTIProject.projTeamMemberList.length>0">
									<td></td>
									<td><strong>:</strong></td>
									<td>{{getReviewsByReviewer.revRecommendation}}</td>
								</tr>
								<tr ng-show="projteamLeader.email.length>0">
									<td></td>
									<td><strong>:</strong></td>
									<td>{{getReviewsByReviewer.revRecommendation}}</td>
								</tr>
								<tr ng-show="projteamLeader.mobile.length>0">
									<td></td>
									<td><strong>:</strong></td>
									<td>{{getReviewsByReviewer.revRecommendation}}</td>
								</tr> -->
						</div>
						<div class="clearfix">&nbsp;</div>
						<div class="modal-footer"
							style="align: center; text-align: center;">

							<button data-dismiss="modal" type="button" class="btn btn-info">Exit</button>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xs-12">&nbsp;</div>

			<div class="col-xs-12">&nbsp;</div>

		</div>
	</div>
<a href="#0" class="cd-top">Top</a>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
</body>
<%}else{ %>
<div id="sideNavPanel" class="col-xs-2" style="padding-left: 0px; padding-right: 0px;margin-left: 0px;">
			<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
</div>
	<div id="mainPanelBody" class="col-xs-10 col-md-10">
			<div  class="alert alert-sm alert-danger alert-dismissible"
						role="alert" style="text-align: center; margin-top: 150px;" >
				<h2>Sorry, Unauthorized access...!! </h2><i style="color: red" class="fa fa-ban fa-5x" aria-hidden="true"></i>		
			</div>
			</div>
		<%} %>
</html>
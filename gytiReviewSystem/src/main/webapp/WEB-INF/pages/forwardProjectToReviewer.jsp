<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="techpedia">
<title>Techpedia</title>
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
	width: 70%;
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

.tdWidth {
	width: 20%;
	text-align: justify;
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
	width: 25%;
	text-align: justify;
}

td:last-child {
	text-align: justify;
}
</style>
</head>
<div class="" style="padding-left: 0px; padding-right: 0px;">
	<jsp:include page="template/reviewHeader.jsp"></jsp:include>
</div>
<div id="sideNavPanel" class="col-xs-2"
	style="padding-left: 0px; padding-right: 0px; margin-left: 0px;">
	<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
</div>
<body style="background-color: #f5f5f5;">
	<div id="mainPanelBody" class="col-xs-10 col-md-10 content-wrapper"
		ng-controller="forwardProjectToReviewerController"
		ng-init="InitLoad()" ng-cloak="">
		<div class="" style="padding-left: 0px; padding-right: 0px;">

			<div id="Reviewheader" style="background-color: #cecfd1;">
				<h4>
					<i class="fa fa-reorder custom">&nbsp;&nbsp;Assign Reviewer</i>
				</h4>
			</div>

			<div id="Reviewheader" style="padding: 0px;">
				<!-- 	<h4>Add Reviewer</h4> -->
				<ul class="page-breadcrumb breadcrumb">
					<!-- <li style="color: gray;"><a href="./">Home&nbsp;</a> <font
						style="color: gray; font-size: 18px;">&raquo;</font></li> -->
					<li style="color: gray;"><a href="reviewDashboard">Dashboard&nbsp;</a><font
						style="color: #cecfd1; font-size: 18px;">&raquo;</font></li>
					<li style="color: gray;"><a href="reviewGYTIProjects">Review
							GYTI Project</a><font style="color: #cecfd1; font-size: 18px;">&raquo;</font></li>
					<li style="color: gray;">Review GYTI Project<font
						style="color: #cecfd1; font-size: 18px;"></font></li>
				</ul>
			</div>

			<!-- <div class="tabsdemoDynamicHeight">
			
			{{reviewerList}}
			</div> -->


			<!-- USER INFO START -->
			<div class="panel panel-default"
				style="border-style: none; background-color: #f5f5f5">
				<div class="panel-heading"
					style="color: white; background-color: #2E353D; height: 50px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">Innovation
					Details
					<div class="col-xs-3 col-md-3 pull-right" style="padding-left: 0px;">

						<div class="search">
							<span class="fa fa-search"></span> <input class="form-control"
								type="text" placeholder="Search..." ng-model="SearchText.$">
						</div>
					</div>
					</div>

				<!-- {{reviewerList}} -->
				<table class="table table-responsive table-condensed table-hover ">
					<tr>
						<td class="tdWidth"><strong>Innovation Title</strong></td>
						<td><strong>:</strong></td>
						<td>{{GYTIProject.projTitle}}</td>
					</tr>
					<tr>
						<td class="tdWidth"><strong>Category</strong></td>
						<td><strong>:</strong></td>
						<td><p style="margin: 0px;"
								ng-repeat="branch in projBranchList">{{branch.branchName}}</p></td>
					</tr>
					<tr>
						<td class="tdWidth"><strong>Select Reviewers</strong></td>
						<td><strong>:</strong></td>
						<td><table
								class="table table-responsive table-condensed table-hover ">
								<tr
									style="color: white; background-color: #2E353D; height: 20px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">
									<td>Assign</td>
									<td>Name</td>
									<td>Department</td>
								</tr>
								<tr>
								
								
								</tr>
								<tr ng-repeat="reviewer in reviewerList | filter:SearchText"
									ng-show="reviewer.revRgstrId!=<%=session.getAttribute("revRgstrId")%>">
									
									<td><input type="checkbox" name="assign[]"
										value="{{reviewer.revRgstrId}}"></td>
									<td><a data-toggle="modal" href="#ReviewerDetailsModal"
										ng-click="getReviewerDetails(reviewer.revEmailId)">{{reviewer.revFname}}</a></td>
									<td>{{reviewer.branchIds.join(", ")}}</td>
									
									
								</tr>
								

							</table>
							
							<div style="text-align: center;"
										ng-show="reviewerList.length==1 && reviewerList[0].revRgstrId==<%=session.getAttribute("revRgstrId")%>">
										<p>
											<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
										</p>
										<p>Sorry, There are no Reviewers....</p>
									</div>
							
							</td>
					</tr>
					<!-- <tr>
										<td class="tdWidth"><strong>Comments</strong></td>
										<td><strong>:</strong></td>
										<td>
											<textarea style="resize: none;" class="form-control"
											 id="comment" name="comment"
											rows="4"></textarea>
										</td>
							</tr> -->

					<tr>
						<td>
							<button type="button" data-toggle="modal" ng-disabled="reviewerList.length==1 && reviewerList[0].revRgstrId==<%=session.getAttribute("revRgstrId")%>"
								data-target="#ReviewerSuggestedModal"
								class="btn btn-primary reg-ctn-1"
								style="background-color: #5cb85c;"
								ng-click="assignReviewers(<%=session.getAttribute("GYTIReviweProjIdToForward")%>,<%=session.getAttribute("revRgstrId")%>)">
								<i class="fa fa-star-o" aria-hidden="true"></i> &nbsp;Assign
							</button> <a type="button" class="btn btn-primary reg-ctn-1"
							style="background-color: #5cb85c;" href="reviewGYTIProjects">
								<i class="fa fa-times" aria-hidden="true"></i>&nbsp;Cancel
						</a>
						</td>
					</tr>
				</table>

			</div>


			<div class="modal fade" data-easein="perspectiveDownIn" id="ReviewerDetailsModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"
							style="background-color: #31b0d5; color: white; text-align: center">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">{{GYTIProject.projTitle}}</h4>

						</div>
						<div class="modal-body" style="height: 550px;">
							<div class="panel-body col-xs-12  no-collapse">
								<!-- <div class="table-responsive"> -->
								<table
									class="table table-responsive table-condensed table-hover">
									<div
										style="background-color: black; color: white; text-align: center; height: 24px; border-radius: 4px; font-family: cursive;">


										Reviewer Details</div>
									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">Reviewer</md-tooltip>
											<strong>Name</strong></td>
										<td><strong>:</strong></td>
										<td>{{reviewerDetails.revFname}}
											{{reviewerDetails.revMname}} {{reviewerDetails.revLname}}</td>
									</tr>

									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">Gender</md-tooltip>
											<strong>Gender</strong></td>
										<td><strong>:</strong></td>
										<td>{{reviewerDetails.revSex}}</td>
									</tr>

									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">State</md-tooltip>
											<strong>State</strong></td>
										<td><strong>:</strong></td>
										<td>{{reviewerDetails.revState}}</td>
									</tr>

									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">City</md-tooltip>
											<strong>City</i></strong></td>
										<td><strong>:</strong></td>
										<td>{{reviewerDetails.revCity}}</td>
									</tr>

									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">Mobile
											No</md-tooltip> <strong>Mobile No</strong></td>
										<td><strong>:</strong></td>
										<td>{{reviewerDetails.revMobileNo}}</td>
									</tr>

									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">Organization</md-tooltip>
											<strong>Organization</td>
										<td><strong>:</strong></td>
										<td>{{reviewerDetails.revOrgName}}</td>
									</tr>

									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">Designation</md-tooltip>
											<strong>Designation</strong></td>
										<td><strong>:</strong></td>
										<td>{{reviewerDetails.revDesignation}}</td>
									</tr>

									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">Speciality</md-tooltip>
											<strong>Speciality</strong></td>
										<td><strong>:</strong></td>
										<td>{{reviewerDetails.revSpeciality}}</td>
									</tr>

									<tr>
										<td><md-tooltip md-direction="left" style="z-index:9999">Category</md-tooltip>
											<strong>Category</strong></td>
										<td><strong>:</strong></td>
										<td><p style="margin: 0px;"
												ng-repeat="branch in reviewerDetails.revBranchList">{{branch.branchName}}</p></td>
									</tr>
								</table>
								<!-- </div> -->
							</div>
							<!-- 	<div class="panel-body col-xs-4  no-collapse">

								<img style="" class="img-responsive" src="images/Projects.jpg">
							</div>
							<div class="panel-body col-xs-12  no-collapse">
								<div class="table-responsive">
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
										<td><a href="facultyDetails{{GYTIProject.projFaculty}}"
											target="_blank">{{GYTIProject.projFacultyName}}</a></td>
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
									<tr ng-show="GYTIProject.projFacultyName.length>0">
										<td class="tdWidth"><strong>Discipline / Sector
												of project</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projFacultyName}}</td>
									</tr>
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
									<tr ng-show="GYTIProject.projFacultyName.length>0">
										<td class="tdWidth"><strong>Have you published
												any Research paper in refereed Journal? Yes or No If yes
												please attach a copy or give reference</strong></td>
										<td><strong>:</strong></td>
										<td>{{GYTIProject.projFacultyName}}</td>
									</tr>
									<tr ng-show="GYTIProject.projPublishedPaper.length>0">
										<td class="tdWidth"><strong>Have you filed any
												patent for your research work? Yes or No If yes please give
												details</strong></td>
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
									<tr>
										<td class="tdWidth"><strong>Discipline / Sector
												of project</strong></td>
										<td><strong>:</strong></td>
										<td></td>
									</tr>
								</table>
								</div>
							</div> -->
						</div>
						<div class="clearfix">&nbsp;</div>
						<div class="modal-footer"
							style="align: center; text-align: center;">

							<button data-dismiss="modal" type="button" class="btn btn-info">Exit</button>
						</div>
					</div>
				</div>
			</div>


			<div class="modal fade" data-easein="perspectiveDownIn" id="ReviewerSuggestedModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"
							style="background-color: #31b0d5; color: white; text-align: center">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
						</div>
						<div layout="row" layout-sm="column" layout-align="space-around" ng-hide="successMsg.length>0 || errorMsg.length>0">
            					<md-progress-circular class="md-accent"  md-diameter="60px"></md-progress-circular>
        				 </div>
						<div class="modal-body" style="text-align: center;">
							<div class="alert alert-sm alert-success alert-dismissible"
								role="alert" id="hide"
								ng-show="successMsg.length>0 ">
									<span style="text-align: center" ng-show="successMsg.length>0"><p
											ng-repeat="msg in successMsg" style="text-align: center">{{msg}}</p></span>
									
							</div>
							<div class="alert alert-sm alert-warning alert-dismissible"
								role="alert" ng-show="errorMsg.length>0">
							<span style="text-align: center" ng-show="errorMsg.length>0"><p
											ng-repeat="msgerr in errorMsg" style="text-align: center">{{msgerr}}</p></span>
							</div>
						</div>
						<div class="clearfix">&nbsp;</div>
						<div class="modal-footer"
							style="align: center; text-align: center;">
							<button data-dismiss="modal" type="button" class="btn btn-info"
								onclick="ExitGYTIReview()">Exit</button>
						</div>
					</div>
				</div>
			</div>

			<div class="col-xs-12">&nbsp;</div>

			<div class="col-xs-12">&nbsp;</div>

		</div>
		<a href="#0" class="cd-top">Top</a>
</body>
</html>
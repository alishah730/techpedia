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
</style>
</head>
		<div class="" style="padding-left: 0px; padding-right: 0px;">
			<jsp:include page="template/reviewHeader.jsp"></jsp:include>
	</div>
	<div id="sideNavPanel" class="col-xs-2" style="padding-left: 0px; padding-right: 0px;margin-left: 0px;">
		<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
	</div>
<%if(((String)(session.getAttribute("revUsrId"))).equals("TrsAdmin")){ %>
<body  style="background-color: #f5f5f5;">
	<div id="mainPanelBody" class="col-xs-10 col-md-10 content-wrapper" ng-controller="reviewerStatusController" ng-init="InitLoad()">
		
		
		<div class=""
			style="padding-left: 0px; padding-right: 0px;">

			<div id="Reviewheader" style="background-color: #cecfd1;">
				<p
					style="font-size: 22px; color: black; text-align: justify; margin-top: 10px; margin-left: 10px;">PENDING
					REVIEWER FOR APPROVAL</p>
			</div>

			<div id="Reviewheader" style="padding: 0px;">
				<!-- 	<h4>Add Reviewer</h4> -->
				<ul class="page-breadcrumb breadcrumb">
					<li style="color: gray;"><a href="./">Home&nbsp;</a> <font
						style="color: gray; font-size: 18px;">&raquo;</font></li>
					<li style="color: gray;">Pending reviewer for approval<font
						style="color: #cecfd1; font-size: 18px;"></font></li>
				</ul>
			</div>



			<div class="col-xs-12"
				style="background-color: #23282e; margin-left: 12px; margin-right: 12px; height: 70px;">
				<div class="col-xs-12">&nbsp;</div>
				<div class="col-xs-3 col-md-3 pull-left"
					style="display: inline-block;">
					<div class="col-xs-3" style="padding-right: 0px; color: white">Show
						&nbsp;</div>
					<div class="dropdown col-xs-4" style="padding-left: 0px;">
						<a class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown"
							style="background-color: white; color: black; font-size: 16px;">
							{{itemsPerPage}}&nbsp;&nbsp; <i class="fa fa-chevron-down"
							aria-hidden="true" style="margin-left: 10%;"></i>
						</a>
						<ul class="dropdown-menu" style="width: 93%;">
							<li><a href="" ng-click="SelectItemNumber(5)">5 </a></li>
							<li><a href="" ng-click="SelectItemNumber(10)">10</a></li>
							<li><a href="" ng-click="SelectItemNumber(20)">20</a></li>
						</ul>
					</div>
					<div class="col-xs-3" style="padding-left: 0px; color: white;">&nbsp;entries</div>

				</div>




				<div class="col-xs-2 col-md-2">
					<p style="color: white;">Filter Records</p>
				</div>


				<div class="col-xs-3 col-md-3" style="padding-left: 0px;">

					<div class="search">
						<span class="fa fa-search"></span> <input class="form-control"
							type="text" placeholder="Search..." ng-model="SearchText.$">
					</div>

				</div>

				<div class="col-xs-2 col-md-2 ">
					<div class="dropdown col-xs-4 col-xs-offset10"
						style="width: 150px; padding-left: 0px;">
						<a class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown"
							style="background-color: white; color: black; font-size: 16px; margin-left: 120px;">
							{{SelectedType}}&nbsp;&nbsp;&nbsp; <i
							class="fa fa-caret-square-o-down custom" style=""></i>
						</a>
						<ul class="dropdown-menu" style="">
							<li><a href="" ng-click="InitLoad()"><i
									class="fa fa-align-justify" aria-hidden="true"></i>&nbsp;All
									Reviewers</a></li>
							<li><a href="" ng-click="showActiveReviewers()"><i
									class="fa fa-check-square-o" aria-hidden="true"
									style="color: green"></i>&nbsp;Active Reviewers</a></li>
							<li><a href="" ng-click="showDeactiveReviewers()"><i
									class="fa fa-ban" aria-hidden="true" style="color: red"></i>&nbsp;Inactive
									Reviewers</a></li>
						</ul>
					</div>


				</div>
				<div class="col-xs-12">&nbsp;</div>

			</div>


			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12">
				<table class="table table-striped" cellspacing="0" width="100%">
					<tr style="font-weight: bold;">
						<td custom-sort order="'Name'" sort="sort">NAME</td>
						<td custom-sort order="'Category'" sort="sort">CATEGORY</td>
						<td custom-sort order="'Organization'" sort="sort">ORGANIZATION</td>
						<td custom-sort order="'Designation'" sort="sort">DESIGNATION</td>
						<td custom-sort order="'Speciality'" sort="sort">SPECIALITY</td>
						<td custom-sort order="'Action'" sort="sort">ACTION</td>
					</tr>
					<tr style="font-size:13px;"
						ng-repeat="item in pagedItems[currentPage] | orderBy:sort.sortingOrder:sort.reverse  | filter:SearchText">
						<td>{{item.revFname}}</td>
						<td>{{item.branchIds.join(", ")}}</td>
						<td>{{item.revOrgName}}</td>
						<td>{{item.revDesignation}}</td>
						<td>{{item.revSpeciality}}</td>
						<td><a class="ActivateReviewers" repeat-done="layoutDone()"
							href="" ng-show="{{item.revStatus=='Y'}}"
							title="Click here to de-activate reviewer.." data-toggle="modal" data-target="#reviewerDetailModalToDeactivate" 
							ng-click="clickedReviewerDetails(item)"><i
								id="ActivateReviewers" class="fa fa-times-circle"
								style="color: red;"></i> </a> <a class="InActivateReviewers"
							href="" ng-show="{{item.revStatus=='N'}}"
							title="Click here to activate reviewer.." data-toggle="modal"
							data-target="#reviewerDetailModalToActivate" ng-click="clickedReviewerDetails(item)"><i
								id="InactivateReviewers" class="fa fa-check-circle"
								style="color: green"></i> </a></td>
					</tr>
				</table>
			</div>
			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12"
				style="border: 1px solid black; margin-left: 12px; margin-right: 12px; background-color: #23282e; height: 60px;">
				<div class="pagination pull-right" style="height: 50px;">
					<ul class="pagination" style="margin-top: -8px;">
						<li ng-class="{disabled: currentPage == 0}"><a href
							ng-click="prevPage()"><i class="fa fa-backward"
								aria-hidden="true"></i>&nbsp;Prev</a></li>

						<li
							ng-repeat="n in range(pagedItems.length, currentPage, currentPage + pagedItems.length) "
							ng-class="{active: n == currentPage}" ng-click="setPage()">
							<a href ng-bind="n + 1">1</a>
						</li>

						<li ng-class="{disabled: (currentPage) == pagedItems.length - 1}">
							<a href ng-click="nextPage()">Next &nbsp;<i
								class="fa fa-forward" aria-hidden="true"></i></a>
						</li>
					</ul>
				</div>
			</div>
		</div>


		<!-- Reviewer Details modal for activation-->
		<div class="modal fade" data-easein="perspectiveDownIn" id="reviewerDetailModalToActivate" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Activate 
							Reviewer...</h4>

					</div>
					<div class="modal-body">

						<div class="col-xs-10 xol-md-10"
							style="color: black; text-align: justify; font-family: arial;">

							Please confirm to activate {{selectedReviewerName}} ?</div>
					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button type="button" class="btn btn-success relodeOnSuccess" 
							ng-click="activateReviewer(selectedUserId,selectedReviewerName)">
							<i class="fa fa-newspaper-o" aria-hidden="true"></i>&nbsp;Activate
						</button>
						<button data-dismiss="modal" type="button" class="btn btn-info">Exit</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Activate Reviewer modal -->
		<div class="modal fade" data-easein="perspectiveDownIn" id="activateReviewerModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
					</div>
					<div layout="row" layout-sm="column" layout-align="space-around" ng-hide="actMsg.length>0 || actMsgerror.length>0">
            					<md-progress-circular class="md-accent"  md-diameter="60px"></md-progress-circular>
        				 </div>
					<div class="modal-body" ng-show="actMsg.length>0 || actMsgerror.length>0" style="text-align: center;">
							
							<div class="alert alert-sm alert-success alert-dismissible"
								role="alert" id="hide"
								ng-show="actMsg.length>0 ">
									<span style="text-align: center" ng-show="actMsg.length>0"><p
											ng-repeat="msg in actMsg" style="text-align: center">{{msg}}</p></span>
									
							</div>
							<div class="alert alert-sm alert-warning alert-dismissible"
								role="alert" ng-show="actMsgerror.length>0">
							<span style="text-align: center" ng-show="actMsgerror.length>0"><p
											ng-repeat="msgerr in actMsgerror" style="text-align: center">{{msgerr}}</p></span>
							</div>
						
					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button data-dismiss="modal" type="button" class="btn btn-info">Exit</button>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		<!-- Reviewer Details modal for deactivation-->
		<div class="modal fade" data-easein="perspectiveDownIn" id="reviewerDetailModalToDeactivate" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Deactivate
							Reviewer...</h4>

					</div>
					<div class="modal-body">

						<div class="col-xs-10 xol-md-10"
							style="color: black; text-align: justify; font-family: arial;">

							Please confirm to deactivate {{selectedReviewerName}} ?</div>
					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button type="button" class="btn btn-success relodeOnSuccess" 
							ng-click="deActivateReviewer(selectedUserId,selectedReviewerName)">
							<i class="fa fa-newspaper-o" aria-hidden="true"></i>&nbsp;Deactivate
						</button>
						<button data-dismiss="modal" type="button" class="btn btn-info">Exit</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Deactivate Reviewer modal -->
		<div class="modal fade" data-easein="perspectiveDownIn" id="deActivateReviewerModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
					</div>
					<div layout="row" layout-sm="column" layout-align="space-around" ng-hide="actMsg.length>0 || actMsgerror.length>0">
            					<md-progress-circular class="md-accent"  md-diameter="60px"></md-progress-circular>
        				 </div>
					<div class="modal-body" ng-show="actMsg.length>0 || actMsgerror.length>0" style="text-align: center;">
							
							<div class="alert alert-sm alert-success alert-dismissible"
								role="alert" id="hide"
								ng-show="actMsg.length>0 ">
									<span style="text-align: center" ng-show="actMsg.length>0"><p
											ng-repeat="msg in actMsg" style="text-align: center">{{msg}}</p></span>
									
							</div>
							<div class="alert alert-sm alert-warning alert-dismissible"
								role="alert" ng-show="actMsgerror.length>0">
							<span style="text-align: center" ng-show="actMsgerror.length>0"><p
											ng-repeat="msgerr in actMsgerror" style="text-align: center">{{msgerr}}</p></span>
							</div>
						
					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button data-dismiss="modal" type="button" class="btn btn-info">Exit</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%}else{ %>	<div id="mainPanelBody" class="col-xs-10 col-md-10">
			<div  class="alert alert-sm alert-danger alert-dismissible"
						role="alert" style="text-align: center; margin-top: 150px;" >
				<h2>Sorry, Unauthorized access...!! </h2><i style="color: red" class="fa fa-ban fa-5x" aria-hidden="true"></i>		
			</div>
			</div>
		<%} %>
</html>
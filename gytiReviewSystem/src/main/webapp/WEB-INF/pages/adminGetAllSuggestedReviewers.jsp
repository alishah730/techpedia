<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="" style="padding-left: 0px; padding-right: 0px;">
	<jsp:include page="template/reviewHeader.jsp"></jsp:include>
</div>
<html ng-app="techpedia">
<title>Techpedia</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
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

.loaderBody {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	background: url('images/cubebox.gif') 60% 60% no-repeat
		rgb(249, 249, 249);
	text-align: center;
	font-size: 18px;
	padding-top: 120px;
	background-size: 150px 150px;
}
.breadcrumb{
margin-bottom:0px;
}
</style>
</head>


<div id="sideNavPanel" class="col-xs-2"
	style="padding-left: 0px; padding-right: 0px; margin-left: 0px;">
	<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
</div>
<body style="background-color: #f5f5f5;">
	<div id="mainPanelBody" class="col-xs-10 col-md-10 content-wrapper"
		ng-controller="adminGetAllSuggestedReviewersController"
		ng-init="InitLoad()">
		<div class="" style="padding-left: 0px; padding-right: 0px;">

			<div id="Reviewheader" style="background-color: #cecfd1;">
				<p
					style="font-size: 22px; color: black; text-align: justify; margin-top: 10px; margin-left: 10px;">All
					Suggested Reviewers Request Status List</p>
			</div>

			<div id="Reviewheader" style="padding: 0px;">
				<!-- 	<h4>Add Reviewer</h4> -->
				<ul class="page-breadcrumb breadcrumb">
					<li style="color: gray;"><a href="./">Home&nbsp;</a> <font
						style="color: gray; font-size: 18px;">&raquo;</font></li>
					<li style="color: gray;">Suggested Reviewers By you<font
						style="color: #cecfd1; font-size: 18px;"></font></li>
				</ul>
			</div>
			<div id="angularLoader" layout="row" layout-sm="column"
				layout-align="space-around">
				<md-progress-circular class="md-accent" md-diameter="80px"></md-progress-circular>
			</div>
			<div id="noInfo" style="text-align: center;">
				<p>
					<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
				</p>
				<p>
					{{errorMessage}} click <a href="" ng-click="InitLoad()">here</a>
					to go back
				</p>
			</div>
			<div id="tableDataBody">
				<div class="col-xs-12" ng-show="data>0"
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
										Innovations</a></li>
								<li><a href="" ng-click="showPendingStatus()"><i
										class="fa fa-ban" aria-hidden="true" style="color: 	#808080"></i>&nbsp;Pending</a></li>
								<li><a href="" ng-click="showAccepetedStatus()"><i
										class="fa fa-check-square-o" aria-hidden="true" style="color: 	#87CEEB"></i>&nbsp;Accepted</a></li>
								<li><a href="" ng-click="showRejectedStatus()"><i
										class="fa fa-times" aria-hidden="true" style="color: red"></i>&nbsp;Rejected</a></li>
								<li><a href="" ng-click="showInProgressStatus()" ><i
									class="fa fa-star-half-o" aria-hidden="true" style="color: 	#FFA500"></i>&nbsp;InProgress</a></li>
								<li><a href="" ng-click="showReviewedStatus()" ><i
									class="fa fa-star" aria-hidden="true" style="color: green"></i>&nbsp;Reviewed</a></li>
							</ul>
						</div>


					</div>
					<div class="col-xs-12">&nbsp;</div>

				</div>
				<!-- <div class="loaderBody" id="loader" ng-hide="data>0"></div> -->

				<div class="col-xs-12">&nbsp;</div>
				<div class="col-xs-12 tableResponsive" ng-show="data>0">
					<table class="table table-striped" cellspacing="0" width="100%">
						<tr style="font-weight: bold;">
							<td custom-sort order="'Request Date'" sort="sort">Request
								Date</td>
							<td custom-sort order="'Title'" sort="sort">Title</td>
							<td custom-sort order="'Category'" sort="sort">Category</td>
							<td custom-sort order="'Assign From'" sort="sort">Assign
								From</td>
							<td custom-sort order="'Assign To'" sort="sort">Assign To</td>
							<td custom-sort order="'Assign Date'" sort="sort">Assign
								Date</td>
							<td custom-sort order="'Rating'" sort="sort">Rating</td>
							<td custom-sort order="'Status'" sort="sort">Status</td>
						</tr>
						<tr style="font-size:13px;"
							ng-repeat="item in pagedItems[currentPage] | orderBy:sort.sortingOrder:sort.reverse  | filter:SearchText">
							<td>{{item.reviewStartDate}}</td>
							<td>{{item.projTitle}}</td>
							<td>{{item.projBranchList.join(", ")}}</td>
							<td>{{item.assignedByName}}</td>
							<td>{{item.reviewerName}}</td>
							<td>{{item.reviewEndDate}}</td>
							<td>{{item.revRatingPercentage}}</td>
							<td ng-show="item.status=='pending'"><span
							class="label label-default">{{item.status}}</span></td>
							<td ng-show="item.status=='accepted'"><span
							class="label label-info">{{item.status}}</span></td>
							<td ng-show="item.status=='rejected'"><span
							class="label label-danger">{{item.status}}</span></td>
							<td ng-show="item.status=='inProgress'"><span
							class="label label-warning">{{item.status}}</span></td>
							<td ng-show="item.status=='reviewed'"><span
							class="label label-success">{{item.status}}</span></td>
						</tr>
					</table>
				</div>
				<div class="col-xs-12">&nbsp;</div>
				<div class="col-xs-12" ng-show="data>0"
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
		</div>



	</div>
	<script type="text/javascript">
			$(".loaderBody").load(function() {
				$(".loaderBody").fadeOut("slow");
			})
		</script>
		<a href="#0" class="cd-top">Top</a>
</body>
</html>
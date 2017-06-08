<%@page import="java.util.ArrayList"%>
<html ng-app="techpedia">
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.1/css/bootstrap.no-icons.min.css"> -->


<!-- <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<!-- <link rel="stylesheet" href="css/customizeToolTip.css"> -->
<style>

.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
}

.line-center {
	margin: 0;
	padding: 0 10px;
	background: #1c9cc3;
	display: inline-block;
}

h3 {
	text-align: center;
	position: relative;
	z-index: 2;
}

th, td {
	text-align: center !important;
}

h3:after {
	content: "";
	position: absolute;
	top: 50%;
	left: 0;
	right: 0;
	border-top: solid 2px white;
	z-index: -1;
}
/* calender */
@import
	url(http://fonts.googleapis.com/css?family=Source+Code+Pro|Oswald);

/****************************************/
/* Styling rules, such as font and colors */
.date-as-calendar {
	font-variant: normal;
	font-style: normal;
	font-weight: normal;
	font-family: "Helvetica", "Arial", sans-serif;
	/* It seems vertical-align: baseline does not work correctly with display: inline-flex. */
	vertical-align: top;
	/* margin: 1ex; */
	color: black;
	background: white;
	background: linear-gradient(to bottom right, #FFF 0%, #EEE 100%);
	border: 1px solid #888;
	border-radius: 3px;
	overflow: hidden;
	box-shadow: 2px 2px 2px -2px black;
}

.date-as-calendar .weekday, .date-as-calendar .day, .date-as-calendar .month,
	.date-as-calendar .year {
	text-align: center;
	line-height: 1.0;
}

.date-as-calendar .month {
	font-family: "Oswald", sans-serif;
	text-transform: uppercase;
	background: #B11;
	background: linear-gradient(to bottom right, #D66 0%, #A00 100%);
	color: white;
}

/****************************************/
/* Layout rules using position: absolute and pixels. */
.position-pixels.date-as-calendar {
	display: inline-block;
	position: relative;
	width: 64px;
	height: 64px;
}

.position-pixels.date-as-calendar .weekday, .position-pixels.date-as-calendar .day,
	.position-pixels.date-as-calendar .month, .position-pixels.date-as-calendar .year
	{
	display: block;
	position: absolute;
	left: 0;
	right: 0;
	width: 100%;
	height: 1em;
}

.position-pixels.date-as-calendar .month {
	top: 0px;
	font-size: 12px;
	padding: 2px 0;
}

.position-pixels.date-as-calendar .weekday {
	top: 16px;
	font-size: 10px;
}

.position-pixels.date-as-calendar .day {
	top: 26px;
	font-size: 24px;
}

.position-pixels.date-as-calendar .year {
	top: 50px;
	font-size: 14px;
}

/****************************************/
/* Layout rules using position: absolute and relative dimensions using em. */
.position-em.date-as-calendar {
	display: inline-block;
	position: relative;
	width: 4em;
	height: 4em;
}

.position-em.date-as-calendar .weekday, .position-em.date-as-calendar .day,
	.position-em.date-as-calendar .month, .position-em.date-as-calendar .year
	{
	display: block;
	position: absolute;
	left: 0;
	right: 0;
	width: 100%;
	height: 1em;
}

.position-em.date-as-calendar .month {
	top: 0px;
	font-size: 60%;
	padding: 0.1em 0;
}

.position-em.date-as-calendar .weekday {
	top: 1.6em;
	font-size: 0.6125em;
}

.position-em.date-as-calendar .day {
	top: 1.1em;
	font-size: 1.5em
}

.position-em.date-as-calendar .year {
	bottom: 0px;
	font-size: 0.87750em;
}

/****************************************/
/* Layout rules using display: inline-flex and relative dimensions using em. */
.inline-flex.date-as-calendar {
	display: inline-flex;
	flex-direction: column;
	flex-wrap: nowrap;
	justify-content: space-between;
	width: 4em;
	height: 4em;
}

.inline-flex.date-as-calendar .weekday, .inline-flex.date-as-calendar .day,
	.inline-flex.date-as-calendar .month, .inline-flex.date-as-calendar .year
	{
	display: block;
	flex: 1 1 auto;
}

.inline-flex.date-as-calendar .month {
	order: 1;
	font-size: 0.75em;
	padding: 0.1em 0;
}

.inline-flex.date-as-calendar .weekday {
	order: 2;
	font-size: 0.6125em;
}

.inline-flex.date-as-calendar .day {
	order: 3;
	font-size: 1.5em;
}

.inline-flex.date-as-calendar .year {
	order: 4;
	font-size: 0.87750em;
}

/****************************************/
/* Multiple sizes. */
.date-as-calendar.size0_5x {
	font-size: 8px;
}

.date-as-calendar.size0_75x {
	font-size: 12px;
}

.date-as-calendar.size1x {
	font-size: 16px;
}

.date-as-calendar.size1_25x {
	font-size: 20px;
}

.date-as-calendar.size1_5x {
	font-size: 24px;
}

.date-as-calendar.size1_75x {
	font-size: 28px;
}

.date-as-calendar.size2x {
	font-size: 32px;
}

.date-as-calendar.size3x {
	font-size: 48px;
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
</style>
<jsp:include page="template/NewHeader.jsp" />
</head>
<body >
	<div class="container" ng-controller="TechAdminPageController" ng-init="InitLoad()">
		<div class="col-xs-12" style="background-color: #d3d3d3;">
			<!-- <div class="col-xs-1" style="background-color: #d3d3d3;"></div> -->
			<div class="row">
				<div class="page-container">
					<div class="container borderRadius style"
						style="background-color: #ffffff;">
						<div class="col-xs-12" style="margin-left: -28px">
							<!-- BEGIN PAGE TITLE & BREADCRUMB-->
							<ul class="page-breadcrumb breadcrumb"
								style="background-color: white;">
								<%
									if (session.getAttribute("username") != null) {
								%>
								<li><a href="./">Home&nbsp;</a><font
									style="color: black; font-size: 18px;">&raquo;</font></li>
								<!-- <li><a href="dashboard">Dashboard&nbsp;</a><font
							style="color: black; font-size: 18px;">&raquo;</font></li> -->
								<li>College Admin</li>
								<%
									} else {
								%><li><a href="./">Home&nbsp;</a><font
									style="color: black; font-size: 18px;">&raquo;</font></li>
								<li>Techpedia Admin</li>
								<%
									}
								%>
							</ul>
						</div>

						<div class="col-xs-12"
							style="background-color: #d3d3d3; font-family: arial; font-size: 18px; font-weight: bold; margin-top: -20px; padding-top: 5px; padding-bottom: 5px">Upload
							Your Documents</div>
						<div class="row">
							<div class="col-xs-12" style="margin-top: 30px">
								<div class="row">
									<div class="col-xs-1"></div>
									<div class="col-xs-5" style="box-shadow: 0 0 2em #b2b2b2;">
										<div class="row">
											<div class="col-xs-12"
												style="margin-top: 10px; background-color: #217690; font-family: arial; font-size: 18px; font-weight: bold; padding-top: 5px; padding-bottom: 5px; color: white;">Upload
												Document</div>
											<div class="col-xs-12" style="margin-top: 20px">
												<form id="bulkUploadForm" name="bulkUploadForm">
													<div class="col-xs-3">Document*</div>
													<div class="col-xs-9">
														<input class="form-control fileCheck" type="file"
															ng-file="file" id="bulkFile"
															placeholder=".xls
								Only" ng-model="bulkFile"
															base64 required="required">
														<div ng-show="fileerrorMsg.length>0"
															class="alert alert-danger">
															 <span
																ng-repeat="errormsgFile in fileerrorMsg"><i
																class="fa fa-exclamation-circle" style="color: red"></i>&nbsp;{{errormsgFile}}</span>
														</div>

													</div>
													<div class="col-xs-12">&nbsp;</div>
													<!-- <div class="col-xs-3">Comments</div>
							<div class="col-xs-9">
								<textarea class="form-control"
									ng-class="{'btn-warning': inputComments.length >= 180, 'btn-danger': inputComments.length >= 201 }"
									rows="3" ng-model="inputComments"
									placeholder="What is your comments?"></textarea>
								<div>
									Characters left:<span
										ng-class="{'btn-warning': inputComments.length >= 120, 'btn-danger': inputComments.length >= 141 }">{{
										200 - inputComments.length}}/200</span>
								</div>
							</div> -->
													<div class="clearfix"></div>
													<div  id="successMsg" class="alert alert-success"
														ng-show="messageSuccess.length>0 ">
														<span ng-repeat="msgSuccess in messageSuccess"><i
															class="fa fa-exclamation-triangle"></i>&nbsp;{{msgSuccess}}
														</span>
													</div>
													<div id="warningMsg" class="alert alert-danger"
														ng-show="messageWarning.length>0">
														<span ng-repeat="msgWarning in messageWarning"><i
															class="fa fa-exclamation-triangle"></i>&nbsp;{{msgWarning}}
														</span>
													</div>
													<div class="col-xs-12">&nbsp;</div>
													<div class="alert alert-success col-xs-offset-4"
														ng-show="hideFlag==false">
														<span><img alt="Uploading" style="height: 30px"
															src="images/cubebox.gif">&nbsp;Uploading...</span>
													</div>

													<div class="col-xs-4"></div>
													<div class="col-xs-8">


														<button type="button" class="btn btn-primary"
															style="background-color: #217690; color: white;"
															ng-disabled="inputComments.length>=201 || (!bulkfileData)||hideFlag==false"
															ng-click="UploadBulkXlsFile()">
															<i class="fa fa-upload"></i>&nbsp;Upload
														</button>
														<!-- <a ng-hide="{{hideFlag}}" class="alert alert-success">
									<i class="fa fa-spinner fa-pulse"></i>&nbsp;Uploading...
								</a> -->
														<button type="reset" class="btn btn-primary"
															style="background-color: #217690; color: white;"
															ng-click="Reset()">
															<i class="fa fa-refresh"></i>&nbsp;Reset
														</button>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</form>
											</div>


										</div>
									</div>

									<div class="col-xs-1"></div>

									<div class="row">
										<div class="col-xs-4" style="box-shadow: 0 0 2em #b2b2b2;">
											<div class="row">
												<div class="col-xs-12"
													style="margin-top: 10px; background-color: #217690; font-family: arial; font-size: 18px; font-weight: bold; padding-top: 5px; padding-bottom: 5px; color: white;">Download
													the .xls template</div>
											</div>
											<div style="text-align: center;">

												<i class="fa fa-cloud-download fa-3x"
													style="color: #217690;"></i>
												<p>Click bellow to download the excel template</p>
												<a href="" ng-click="downloadBulkUploadTempDocumentLink()"><i
													class="fa fa-file-excel-o"
													style="color: green; font-size: 52px;"
													title="Download blank template with sample formatted content"></i></a>
												<div
													style="text-align: left !important; font-family: arial;">
													<strong>N.B:</strong>
													<h6>1.File size should not exceed 5 MB.</h6>
													<h6>2.Please do not change the columns/headers.</h6>
													<h6>3.The first row has been filled for your
														reference.</h6>
													<h6>4.It can upload only 5000 projects at one time.
														For more projects upload repeat the process.</h6>
												</div>

											</div>
										</div>
									</div>
									<div class="col-xs-12">&nbsp;</div>
									<div class="col-xs-1"></div>
								</div>
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<!-- <div class="col-xs-12"
							style="background-color: #d3d3d3; font-family: arial; font-size: 18px; font-weight: bold; margin-top: -20px; padding-top: 15px; padding-bottom: 5px">
							<div class="col-xs-3 col-md-3">Manage News Item
								&nbsp;&nbsp;</div>


							<div class="col-xs-3 col-md-3">
								<a href="" href="" id="addNews" data-toggle="modal"
									data-target="#addNewsModal"
									title="Click here to Add latest news into the college home page"><i
									class="fa fa-plus-square-o fa-2x" style="color: green"></i></a>
							</div>


						</div> -->

						<div class="col-xs-12">&nbsp;</div>
						<!-- <div class="">
							<div class="col-xs-12 col-md-12"
								style="box-shadow: 0 0 2em #b2b2b2; height: 50px;">
								<div class="col-xs-3 col-md-3" style="display: inline-block;">
									<div class="col-xs-3"
										style="padding-top: 12px; padding-right: 0px;">Show
										&nbsp;</div>
									<div class="dropdown col-xs-4"
										style="padding-top: 3px; padding-left: 0px;">
										<a class="btn btn-primary dropdown-toggle" type="button"
											data-toggle="dropdown"
											style="background-color: white; color: black; font-size: 16px; margin-top: 3px;">
											{{itemsPerPage}}&nbsp;&nbsp; <i class="fa fa-chevron-down"
											aria-hidden="true" style="margin-left: 10%;"></i>
										</a>
										<ul class="dropdown-menu" style="width: 93%;">
											<li><a href="" ng-click="SelectItemNumber(5)">5 </a></li>
											<li><a href="" ng-click="SelectItemNumber(10)">10</a></li>
											<li><a href="" ng-click="SelectItemNumber(20)">20</a></li>
										</ul>
									</div>
									<div class="col-xs-3"
										style="padding-top: 12px; padding-left: 0px;">&nbsp;entries</div>

								</div>
								<div class="col-xs-1 col-md-1"></div>
								<div class="col-xs-4 col-md-4" style="margin-top: 12px;">
									<div class="search">
										<span class="fa fa-search"></span> <input class="form-control"
											type="text" placeholder="Search..." ng-model="SearchText.$">
									</div>

								</div>
								<div class="col-xs-4 col-md-4 ">
									<div class="dropdown col-xs-4 col-xs-offset10 pull-right"
										style="padding-top: 3px; width: 150px; padding-left: 0px;">
										<a class="btn btn-primary dropdown-toggle" type="button"
											data-toggle="dropdown"
											style="background-color: white; color: black; font-size: 16px; margin-top: 3px;">
											{{SelectedType}}&nbsp;&nbsp;&nbsp; <i
											class="fa fa-caret-square-o-down custom" style=""></i>
										</a>
										<ul class="dropdown-menu" style="">
											<li><a href="" ng-click="InitLoad()"><i
													class="fa fa-align-justify" aria-hidden="true"></i>&nbsp;All
													News</a></li>
											<li><a href="" ng-click="ShowActiveNews()"><i
													class="fa fa-check-square-o" aria-hidden="true"
													style="color: green"></i>&nbsp;Active News</a></li>
											<li><a href="" ng-click="ShowInActiveNews()"><i
													class="fa fa-ban" aria-hidden="true" style="color: red"></i>&nbsp;Inactive
													News</a></li>
										</ul>
									</div>


								</div>
							</div>
						</div> -->
						<!-- <div class="clearfix">&nbsp;</div> -->
						<!-- <table
							class="display table table-bordered table-condensed table-hover table-striped"
							cellspacing="0" width="100%">
							<thead
								style="background-color: #217690; color: white; font-size: 16px !important;">

								<tr>
									<th>Sl.#</th>
									<th class="date" custom-sort order="'newsDate'" sort="sort">Date</th>
									<th class="headline" custom-sort order="'newsHeadline'"
										sort="sort">News Headline</th>
									<th class="description" custom-sort order="'newsDescription'"
										sort="sort">News Description</th>
									<th class="action" custom-sort order="'isActive'" sort="sort">Action</th>
								</tr>
							</thead>
							<tbody>
								<tr
									ng-repeat="item in pagedItems[currentPage] | orderBy:sort.sortingOrder:sort.reverse | filter:SearchText"
									ng-cloak>
									<td>{{$index+1}}</td>
									<td>{{item.newsDate | date:'dd-MMM-yyyy'}}</td>
									<td>{{item.newsHeadline}}</td>
									<td>{{item.newsDescription}}<a href=""
										repeat-done="layoutDone()" class="newsInDetail"
										style="float: right;" data-toggle="tooltip"
										data-placement="top" title="Click here for details"
										ng-click="clickedNewsDetails(item)"><i
											class="fa fa-external-link-square" data-toggle="modal"
											data-target="#newsInDetailModal"></i></a></td>
									<td><a repeat-done="layoutDone()" class="ActivateNews"
										id="ActivateNews" href=""
										title="Click here to publish this news on college page"
										ng-show="{{item.isActive}}==false" data-toggle="modal"
										data-target="#activateNewsModal"
										ng-click="clickedNewsDetails(item)"><i id="ActivateNews"
											class="fa fa-check-circle" aria-hidden="true"
											style="color: green;"></i> </a> <a
										title="Click here to remove this news from college page"
										class="deactivateNews" ng-show="{{item.isActive}}==true"
										href="" id="deactivateNews" data-toggle="modal"
										data-target="#deleteNewsModal"
										ng-click="selectedCollegeNews(item)"> <i
											id="deactivateNews" class="fa fa-times-circle"
											style="color: red"></i></a></td>
								</tr>
							</tbody>

						</table> -->

						<!-- <div>
							<div class="col-xs-12 col-md-12">
								<div class="pagination pull-right" style="margin-top: -30px;">
									<ul class="pagination">
										<li ng-class="{disabled: currentPage == 0}"><a href
											ng-click="prevPage()"><i class="fa fa-backward"
												aria-hidden="true"></i>&nbsp;Prev</a></li>

										<li
											ng-repeat="n in range(pagedItems.length, currentPage, currentPage + pagedItems.length) "
											ng-class="{active: n == currentPage}" ng-click="setPage()">
											<a href ng-bind="n + 1">1</a>
										</li>

										<li
											ng-class="{disabled: (currentPage) == pagedItems.length - 1}">
											<a href ng-click="nextPage()">Next &nbsp;<i
												class="fa fa-forward" aria-hidden="true"></i></a>
										</li>
									</ul>
								</div>

							</div>

						</div> -->





						<!-- 	<table id="collegeNewsTable"
					class="display table table-bordered table-condensed table-hover table-striped"
					cellspacing="0" width="100%">
					<thead
						style="background-color: #217690; color: white; font-size: 16px !important;">
						<tr align="center">
							<th>SL.#</th>
							<th>DATE</th>
							<th>NEWS HEADLINE</th>
							<th>NEWS DESCRIPTION</th>
							<th>REMOVE</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="collegeNews in CollegeNewsAdmin | filter:searchText">
							<td>{{$index+1}}</td>
							<td>{{collegeNews.newsDate | date:'dd-MMM-yyyy'}}</td>
							<td>{{collegeNews.newsHeadline}}</td>
							<td>{{collegeNews.newsDescription}}<a href=""
								style="float: right;" data-toggle="tooltip" data-placement="top"
								title="Click here for details"
								ng-click="clickedNewsDetails(collegeNews)"><i
									class="fa fa-external-link-square" data-toggle="modal"
									data-target="#newsInDetailModal"></i></a></td>
							<td><a href="" ng-show="{{collegeNews.isActive}}==false"
								data-toggle="modal" data-target="#activateNewsModal" href=""
								title="click here to publish this news on college page"
								ng-click="clickedNewsDetails(collegeNews)"><i
									class="fa fa-check-circle" aria-hidden="true"
									style="color: green;"></i> </a><a
								ng-show="{{collegeNews.isActive}}==true" href="" id="deleteNews"
								data-toggle="modal" data-target="#deleteNewsModal"
								ng-click="selectedCollegeNews(collegeNews)"><i
									class="fa fa-times-circle" style="color: red"></i></a></td>
						</tr>
					</tbody>
				</table> -->
					</div>
				</div>
			</div>

			<div class="col-xs-12">&nbsp;</div>
		</div>
		<!-- <div class="col-xs-1" style="background-color: #d3d3d3;"></div> -->


		<!-- delete college news modal -->
		<!-- <div class="modal fade" id="deleteNewsModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white;">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Delete College News</h4>

					</div>
					<div ng-hide="removeMsg.length>0" class="modal-body"
						style="text-align: center;">
						<div style="text-align: center;">
							<i class="fa fa-exclamation-triangle"
								style="color: #E84F63; font-size: 50px; text-align: center;"></i>
						</div>
						<p>
							Are You Sure To <strong>Delete</strong> This News !!
						</p>
						<p>
							News Head Line:&nbsp; <strong>{{selectedCollegeNewsHeadLine}}</strong>
						</p>
						<p>
							News Registered ID:&nbsp;<strong>{{selectedCollegeNewsID}}</strong>
						</p>


					</div>
					<div ng-show="removeMsg.length>0 || removeMsgerror.length>0"
						class="modal-body" style="text-align: center;">
						<i id="effect" class="fa fa-check-circle-o"
							style="color: green; font-size: 7em;"
							ng-hide="removeMsgerror.length>0"></i>

						<div class="alert alert-sm alert-info alert-dismissible"
							role="alert" id="hide"
							ng-show="removeMsg.length>0 || removeMsgerror.length>0">
							<p style="text-align: center">
								<span style="text-align: center" ng-show="removeMsg.length>0"><p
										ng-repeat="msg in removeMsg" style="text-align: center">{{msg}}</p></span>
								<span style="text-align: center"
									ng-show="removeMsgerror.length>0"><p
										ng-repeat="msgerr in removeMsgerror"
										style="text-align: center">{{msgerr}}</p></span>
						</div>
						<div onload="window.location.reload()"></div>
					</div>


					<div ng-hide="removeMsg.length>0" class="modal-footer"
						style="align: center; text-align: center;">

						<button type="button" id="button"
							class="btn btn-info relodeOnSuccess"
							ng-click="deleteCollegeNews()">
							<i class="fa fa-trash-o"></i>&nbsp;Delete
						</button>
						<button type="button" class="btn btn-danger" ng-click="initiateProject('N')"
																		>Reject</button>
						<button data-dismiss="modal" type="button" class="btn btn-info">
							<i class="fa fa-times-circle"></i>&nbsp;Cancel
						</button>
					</div>
					<div ng-show="removeMsg.length>0" class="modal-footer"
						style="align: center; text-align: center;">


						<button data-dismiss="modal" type="button"
												class="btn btn-info" onClick="window.location.reload()"
												href="javascript:window.location.reload(true)">Exit</button>
					</div>
				</div>
			</div>
		</div>
 -->
		<!-- Add news Modal -->
		<%-- <div class="modal fade" id="addNewsModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><%=session.getAttribute("collegeName")%></h4>

					</div>
					<div
						style="background-color: #d3d3d3; color: black; text-align: center">News
						Editor</div>
					<form name="addNewsForm" novalidate>
						<div ng-hide="addMsg.length>0" class="modal-body">


							<div class="form-group">
								<label for="newsHeadLine1">News Headline *</label> <input
									type="text" class="form-control has-warning" id="newsHeadLine1"
									placeholder="Head Line for the latest news" name="newsHeadline"
									ng-class="{'btn-warning':addNews.newsHeadline.length >= 80, 'btn-danger': addNews.newsHeadline.length >= 101 }"
									ng-model="addNews.newsHeadline" required>
							</div>
							<div style="margin-top: -15px;">
								Characters left:<span
									ng-class="{'btn-warning':addNews.newsHeadline.length >=80, 'btn-danger': addNews.newsHeadline.length >=90 }">{{
									100 - addNews.newsHeadline.length}}/100</span>
							</div>
							<div class="clearfix">&nbsp;</div>
							<div class="form-group">
								<label for="newsDetails1">News Description *</label>
								<textarea class="form-control" id="newsDetails1"
									placeholder="Details of the news"
									ng-class="{'btn-warning':addNews.newsDescription.length >= 480, 'btn-danger': addNews.newsDescription.length >= 501 }"
									rows="3" ng-model="addNews.newsDescription"
									name="newsDescription" required></textarea>
							</div>
							<div style="margin-top: -15px;">
								Characters left:<span
									ng-class="{'btn-warning':addNews.newsDescription.length >=450, 'btn-danger': addNews.newsDescription.length >=490 }">{{
									500 - addNews.newsDescription.length}}/500</span>
							</div>



						</div>
						<div ng-show="addMsg.length>0 || addMsgerror.length>0"
							class="modal-body" style="text-align: center;">
							<i id="effect" class="fa fa-check-circle-o"
								style="color: green; font-size: 7em;"
								ng-hide="addMsgerror.length>0"></i>

							<div class="alert alert-sm alert-info alert-dismissible"
								role="alert" id="hide"
								ng-show="addMsg.length>0 || addMsgerror.length>0">
								<p style="text-align: center">
									<span style="text-align: center" ng-show="addMsg.length>0"><p
											ng-repeat="msg in addMsg" style="text-align: center">{{msg}}</p></span>
									<span style="text-align: center"
										ng-show="removeMsgerror.length>0"><p
											ng-repeat="msgerr in addMsgerror" style="text-align: center">{{msgerr}}</p></span>
							</div>
							<div onload="window.location.reload()"></div>
						</div>


						<div ng-hide="addMsg.length>0" class="modal-footer"
							style="align: center; text-align: center;">

							<button type="button" id="button"
								class="btn btn-info relodeOnSuccess"
								ng-click="addCollegeRecentNews()"
								ng-disabled="(!addNews.newsHeadline)||(!addNews.newsDescription)||(addNews.newsDescription.length >=501)||(addNews.newsHeadline.length >=101)">
								<i class="fa fa-plus-square-o"></i>&nbsp;Add News
							</button>
							<!-- <button type="button" class="btn btn-danger" ng-click="initiateProject('N')"
																		>Reject</button> -->
							<button data-dismiss="modal" type="button" class="btn btn-info">
								<i class="fa fa-times-circle"></i>&nbsp;Cancel
							</button>
						</div>
						<div ng-show="removeMsg.length>0" class="modal-footer"
							style="align: center; text-align: center;">


							<!-- <button data-dismiss="modal" type="button"
												class="btn btn-info" onClick="window.location.reload()"
												href="javascript:window.location.reload(true)">Exit</button> -->
						</div>
					</form>
				</div>
			</div>
		</div> --%>
		<!-- news in detail modal -->
		<%-- <div class="modal fade" id="newsInDetailModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><%=session.getAttribute("collegeName")%></h4>

					</div>
					<div
						style="background-color: #d3d3d3; color: black; text-align: center; padding-top: 5px; font-family: arial; font-weight: bold;"
						class="col-xs-12">{{selectedNewsHeadLine | uppercase}}</div>
					<div class="modal-body">

						<div class="col-xs-10 xol-md-10"
							style="color: black; text-align: justify; font-family: arial;">

							{{selectedNewsDescription}}</div>

						<div class="col-xs-2 col-md-2"
							style="text-align: right; padding-left: 0px; padding-right: 0px;">
							<span style="text-align: right;"> Published on</span>
							<div
								style="color: black; float: right; text-align: center; margin-right: 6px;">
								<time datetime="{{newspubDate}}"
									class="date-as-calendar position-em size1x">
									<span class="weekday">{{selctedNewsDay}}</span> <span
										class="day">{{selctedNewsNoDay}}</span> <span class="month">{{selctedNewsMonth}}</span>
									<span class="year">{{selctedNewsYear}}</span>
								</time>
							</div>
						</div>

					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">


						<button data-dismiss="modal" type="button" class="btn btn-info">Exit</button>
					</div>
				</div>
			</div>
		</div> --%>

		<!-- Activate news modal -->
		<%-- <div class="modal fade" id="activateNewsModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><%=session.getAttribute("collegeName")%></h4>

					</div>
					<div ng-hide="actMsg.length>0">


						<div
							style="background-color: #d3d3d3; color: black; text-align: center; padding-top: 5px; font-family: arial; font-weight: bold;"
							class="col-xs-12">{{selectedNewsHeadLine | uppercase}}</div>
						<div class="modal-body">

							<div class="col-xs-10 xol-md-10"
								style="color: black; text-align: justify; font-family: arial;">

								{{selectedNewsDescription}}</div>

							<div class="col-xs-2 col-md-2"
								style="text-align: right; padding-left: 0px; padding-right: 0px;">
								<span style="text-align: right;"> Published on</span>
								<div
									style="color: black; float: right; text-align: center; margin-right: 6px;">
									<time datetime="{{newspubDate}}"
										class="date-as-calendar position-em size1x">
										<span class="weekday">{{selctedNewsDay}}</span> <span
											class="day">{{selctedNewsNoDay}}</span> <span class="month">{{selctedNewsMonth}}</span>
										<span class="year">{{selctedNewsYear}}</span>
									</time>
								</div>
							</div>

						</div>
						<div class="clearfix">&nbsp;</div>
					</div>
					<div ng-show="actMsg.length>0 || actMsgerror.length>0"
						class="modal-body" style="text-align: center;">
						<i id="effect" class="fa fa-check-circle-o"
							style="color: green; font-size: 7em;"
							ng-hide="actMsgerror.length>0"></i>

						<div class="alert alert-sm alert-info alert-dismissible"
							role="alert" id="hide"
							ng-show="actMsg.length>0 || actMsgerror.length>0">
							<p style="text-align: center">
								<span style="text-align: center" ng-show="actMsg.length>0"><p
										ng-repeat="msg in actMsg" style="text-align: center">{{msg}}</p></span>
								<span style="text-align: center" ng-show="actMsgerror.length>0"><p
										ng-repeat="msgerr in actMsgerror" style="text-align: center">{{msgerr}}</p></span>
						</div>
						<div onload="window.location.reload()"></div>
					</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">

						<button ng-hide="actMsg.length>0" type="button"
							class="btn btn-success relodeOnSuccess"
							ng-click="activateCollegeRecentNews()">
							<i class="fa fa-newspaper-o" aria-hidden="true"></i>&nbsp;Publish
						</button>
						<button data-dismiss="modal" type="button" class="btn btn-info">
							<i class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;Exit
						</button>
					</div>
				</div>
			</div>
		</div> --%>

	</div>
	<script type="text/javascript">
		$('.relodeOnSuccess').click(function() {
			setTimeout(function() {
				location.reload();
			}, 3000);
			/* alert("3 Seconds until Refresh"); */

		});
	</script>
	<!-- <script type="text/javascript">
	$(function() { $( document ).tooltip(); });
	</script> -->
	<!-- <script>
		$(document).ready(function() {
			$('#ActivateNews').tooltip({
				title : "Click here to publish this news on college page",
				animation : true
			});
			$('#deactivateNews').tooltip({
				title : "Click here to remove this news from college page",
				animation : true
			});
		});
	</script> -->
	<!-- <script type="text/javascript">jQuery.noConflict();</script> -->
</body>
<jsp:include page="template/footer.jsp" />
<!-- END BODY -->
</html>
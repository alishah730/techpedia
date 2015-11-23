<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
<div class="clearfix"></div>

<div class="container customFont borderRadius style" >

<div class="page-container">
	<div class="page-sidebar-wrapper">
		<%-- <jsp:include page="template/dashboardMenu.jsp" /> --%>
	</div>
	<div class="page-content-wrapper" ng-controller="ManageChallengesController" ng-init="initLoad()">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<h3 class="page-title">
						<i class="fa fa-thumbs-up" id="icon-size"></i> Manage Challenges
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Manage Challenges</li>
						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
					</ul>

				</div>
			</div>

			<div class="clearfix"></div>
			<div class="row">
				<div class="col-md-12 left-border">
					<div class="col-md-9" style="top: 10px;">
						Filter: <input type="text" ng-model="filterSearch">
					</div>
					<br> <br> <br>

					<div class="col-xs-12 ">
						<a href="addChallenge" class="btn btn-info challenge-padding addChallenge"><span
							class="glyphicon glyphicon-plus"></span>Add New Challenge</a>
					</div>
					<div class="col-md-12 challenge-padding">
						<br> <br>
					</div>
				</div>
				<div class="col-md-12 left-border challenge-padding">
					<div class="alert alert-info" role="alert" ng-show="challenges.length==0">Nothing to
						display</div>

					<div class="col-xs-12 one1" ng-repeat="challenge in challenges | filter:filterSearch">
						<div class="panel panel-primary">
							<div class="panel-heading">
								{{challenge.challengTitle}}
								<!-- <i style="float: right; position: relative; top: 3px;"
									class="fa fa-times-circle" ng-click="deleteChallenge(challenge)"></i> -->
							</div>
							<div class="panel-body">
								<div class="col-md-2">
									<img src="{{challenge.challengImgPath||'images/AllChallenge.png'}}" width=50 height=65 />
								</div>
								<div class="col-md-8">
									<p>{{challenge.challengAbstract}}</p>
									<p class="sub-text-4"></p>
								</div>
								<div class="row-fluid pull-right" style="margin-top:30px">
									
										
											<btn class="btn btn-info btn-sm" ng-click=viewChallenge(challenge)>View</btn>
										
										
										
											<btn class="btn btn-info btn-sm" ng-click="acceptChallenge(challenge)">Accept</btn>
										
										
										
										
											<btn data-toggle="modal" data-target="#uploadModal" class="btn btn-info btn-sm"
												ng-click="currentChallenge(challenge)">Upload</btn>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		
			<div class="clearfix"></div>
			<!-- Upload Modal -->
			<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Upload a document</h4>
						</div>
						<div class="modal-body">
							<input type="file" ng-file="file" base64>

							<div class="alert alert-sm alert-info alert-dismissible" role="alert"
								ng-show="message.length>0">
								<li ng-repeat="msg in message">{{msg}}</li>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" ng-click="uploadChallengeDocument()">Upload</button>
						</div>
					</div>
				</div>
			</div>
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

<html ng-app="techpedia">
<body  ng-controller="ManageChallengesController" ng-init="initLoad()">
<jsp:include page="template/NewHeader.jsp" />
<div class="clearfix"></div>

<div class="customFont" style="height:250px;background-color:#217690">
<img src="images/MANAGE-CHALLENGES-BANNER.jpg" class="img-responsive"" style="height:250px;">

<div class="col-md-3" ng-show="userType=='mentor'||userType=='faculty'" style="margin-left: 75%;margin-top: -5%;">
				
		<a href="addChallenge" class="btn btn-success btn-responsive"><span
		class="glyphicon glyphicon-plus" ></span>Add New Challenge</a>
</div>
</div>

<div class="container customFont borderRadius style" style="background-color:#3f94ae" >

<div class="page-container">
	<div class="page-sidebar-wrapper">
		<%-- <jsp:include page="template/dashboardMenu.jsp" /> --%>
	</div>
	<div class="page-content-wrapper">
		<div class="page-content">
		<!-- <div style="margin-left: 16px; color: #ffffff; font-size: 18px;">
						<i class="fa fa-bolt custom"></i> MANAGE CHALLENGES
		</div> -->
		<div class="col-md-12">&nbsp;</div>
		
			<div class="row">
				<div class="col-md-12">
					
				<ul class="page-breadcrumb breadcrumb" style="background-color: #217690; color: #ffffff !important" >
						<li><a style="color: #ffffff !important" href="./">Home&nbsp;</a> <font style="color: black; font-size:18px;">&raquo;</font>
						<a style="color: #ffffff !important"href=dashboard>Dashboard&nbsp;</a><font style="color: black;font-size:18px;">&raquo;</font>
					<!-- <li style="content:none !important;"> -->Manage Challenges</li>
					</ul>


				</div>
			</div>

			<div class="clearfix"></div>
			
			<div class="row">
			
			 <div
				style="border-radius: 8px; height: 48px; background-color: #2b2b2b; padding-top: 7px;margin-left: 14px;margin-right: 14px;">
				<div style="width: 50px; float: left; padding-top: 8px;">
					<span class="col-xs-2"
						style="color: white; width: 200px; padding-left: 10px;">{{clickFilterApplied}}</span>
				</div>
				<li class="dropdown-short">
				<span style=" margin-left: 70%;color: white; font-weight: bolder;">Sort By
							&nbsp;</span>
					<div class="dropdown" style="float: right; padding-right: 16px;">
						<a class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown"
							style="background-color: white; width: 200px; color: black; font-size: 16px;">
							{{clickFilterApplied}}&nbsp;&nbsp;&nbsp; <i
							class="fa fa-caret-square-o-down custom" style="margin-left: 10%;"></i>
						</a>
						<ul class="dropdown-menu" style="    width: 93%;">
							<li><a  ng-click="clickFilter1('my')"> <i
								class="fa fa-user">&nbsp;</i>My Challenges</a></li>
							<li><a class="working"
								ng-click="clickFilter1('all')"><i class="fa fa-reorder custom">&nbsp;</i>All Challenge</a></li>
							<li><a class="completed"
								ng-click="clickFilter1('follow')"><i class="fa fa-at">&nbsp;</i>Challenges I Follow</a></li>
							
						</ul>
					</div>
				</li>

			</div> 
			
			
			 
			<!-- <div class="col-md-12 left-border">
					<div class="col-md-3">
						Filter: <input type="text" ng-model="filterSearch">
					</div>
					<div class="col-xs-6">
						Applied: {{clickFilterApplied}} <a href="#" ng-click="clickFilter1('my')">My Challenges</a> | <a
							href="#" ng-click="clickFilter1('follow')">Challenges I Follow</a> | <a href="#"
							ng-click="clickFilter1('all')">All</a>
					</div>
				
				
					<div class="col-md-3" ng-show="userType=='mentor'||userType=='faculty'">
				
						<a href="addChallenge" class="btn btn-info challenge-padding addChallenge"><span
							class="glyphicon glyphicon-plus" ></span>Add New Challenge</a>
					</div>
					</ffdiv>
					<div class="col-md-12"></div>
				</div>  -->
				<div class="col-md-12 left-border">
					<div class="row">
				<div class="col-xs-12">
					
					
					
					<div class="clearfix"></div>
	
			<div class="row" ng-show="showchallenges">
				<div class="panel panel-primary">
			<!-- <div class="panel-heading">My Challenges</div> -->
			</div>
			 <div  ng-show="clickFilterApplied=='All Challenges'"
				>
				<div style="width: 50px; float: left; padding-top: -47px;">
					<span class="col-xs-2"
						style="color: white;font-family:arial; font-weight:bolder; width: 200px; padding-left: 18px;">MY CHALLENGES</span>
				</div>
			</div>
			<div class="col-md-12 left-border challenge-padding">
					<div class="alert alert-info" role="alert" ng-show="challenges.length==0">Nothing to
						display</div>

					<div class="col-xs-12" style="border-radius: 8px; height: 236px; background-color: #ffffff;  margin-top: 20px;"ng-repeat="challenge in challenges | filter:filterSearch">
						
				 <div style="float: left; padding-left: 12px;">
						<img
							src="${pageContext.request.contextPath}/image/{{challenge.photo1Path ||'/usr/Techpedia/Project/placeholders/placeholder.png'}}"
							alt=""
							style="height: 222px; width: 235px; padding-top: 15px; position: absolute; z-index: 0;" />
						<div
							style="margin-top: 167px; padding-top: 13px; bottom: 0; left: 0; width: 235px; height: 54px; position: relative; text-align: center; color: black; font-weight: bolder; opacity: 0.7; filter: alpha(opacity = 70); z-index: 4; background-color: white;">{{challenge.challengTitle}}</div>
				</div>
				<div
					style="font-family: arial; font-size: 14; height: 10em; right; text-align: justify; position: absolute; padding-left: 256px; padding-top: 20px; padding-right: 145px; overflow: hidden; text-overflow: ellipsis;">
					{{challenge.challengAbstract}}
				</div> 
					
					<div class="row-fluid pull-right" style="margin-top:190px">
									
										
											<btn class="btn btn-success btn-responsive" ng-click=viewChallenge(challenge)><i class="fa fa-eye"></i>&nbsp;View</btn>
										
										
										
											<!-- <btn class="btn btn-success btn-responsive" ng-click="acceptChallenge(challenge)">Accept</btn> -->
										
										
										
										
											<btn data-toggle="modal" data-target="#uploadModal" class="btn btn-success btn-responsive"
												ng-click="currentChallenge(challenge)"><i class="fa fa-upload"></i>&nbsp;Upload</btn>
										</div>	
						
						
					 <!-- <div class="panel panel-warning">
							<div class="panel-heading">
								{{challenge.challengTitle}}
								<i style="float: right; position: relative; top: 3px;"
									class="fa fa-times-circle" ng-click="deleteChallenge(challenge)"></i>
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
								</div>  -->
								
							</div>
						</div>
				
			</div>
			<div class="clearfix"></div>
			<div class="row" ng-show="showchallengesIFollow">
				<div class="panel panel-primary">
					<!-- <div class="panel-heading">Challenges I Follow</div> -->
			</div>
			
			 <div ng-show="clickFilterApplied=='All Challenges'"
				>
				<div style="width: 50px; float: left; padding-top: -47px;">
					<span class="col-xs-2"
						style="color: white;font-family:arial;font-weight:bolder; width: 250px; padding-left: 18px;">CHALLENGES I FOLLOW</span>
				</div>
			</div> 
			
			
			
					<!-- <div class="panel-body"> -->
					<div class="col-md-12 left-border challenge-padding">
						<div class="alert alert-sm alert-info alert-dismissible" role="alert"
							ng-show="challengesIFollow==0">Nothing to display</div>
						<div class="col-xs-12" style="border-radius: 8px; height: 236px; background-color: #ffffff;  margin-top: 20px;" ng-repeat="challenge in challengesIFollow | filter: filterSearch">
						
						
					<div style="float: left; padding-left: 12px;">
						<img
							src="${pageContext.request.contextPath}/image/{{challenge.photo1Path ||'/usr/Techpedia/Project/placeholders/placeholder.png'}}"
							alt=""
							style="height: 222px; width: 235px; padding-top: 15px; position: absolute; z-index: 0;" />
						<div
							style="margin-top: 167px; padding-top: 13px; bottom: 0; left: 0; width: 235px; height: 54px; position: relative; text-align: center; color: black; font-weight: bolder; opacity: 0.7; filter: alpha(opacity = 70); z-index: 4; background-color: white;">{{challenge.challengTitle}}
							</div>
				   </div>
				   <div
					style="font-family: arial; font-size: 14; height: 10em; right; text-align: justify; position: absolute; padding-left: 256px; padding-top: 20px; padding-right: 145px; overflow: hidden; text-overflow: ellipsis;">
					{{challenge.challengAbstract}}
				  </div> 
						<div class="row-fluid pull-right" style="margin-top:190px;">
										<div class="col-xs-12">
								<btn class="btn btn-success btn-responsive" ng-click=viewChallenge(challenge)><i class="fa fa-eye"></i>&nbsp;View</btn>
										</div>
									</div>
						
							<!-- <div class="panel panel-warning">
							<div class="panel-heading">
								{{challenge.challengTitle}}
								<i style="float: right; position: relative; top: 3px;"
									class="fa fa-times-circle" ng-click="deleteChallenge(challenge)"></i>
							</div>
							<div class="panel-body">
								<div class="col-md-2">
									<img src="{{challenge.challengImgPath||'images/AllChallenge.png'}}" width=50 height=65 />
								</div>
								<div class="col-md-8">
									<p>{{challenge.challengAbstract}}</p>
									<p class="sub-text-4"></p>
								</div>
								<div class="col-md-2">
										<div class="col-xs-12">
								<btn class="btn btn-info btn-sm" ng-click=viewChallenge(challenge)>View Challenges</btn>
										</div>
									</div>
									</div>
								</div> -->
						<!-- </div> -->
					</div>
				</div>
			</div>
				</div>
			</div>
					<br> <br> <br>


					<div class="col-xs-12 " ng-show="userType!='student'">

					<!-- <div class="col-xs-12 ">

						<a href="addChallenge" class="btn btn-info challenge-padding addChallenge"><span
							class="glyphicon glyphicon-plus"></span>Add New Challenge</a>
					</div> -->
					<div class="col-md-12 challenge-padding">
						<br> <br>
					</div>
				</div>
				<!-- <div class="col-md-12 left-border challenge-padding">
					<div class="alert alert-info" role="alert" ng-show="challenges.length==0">Nothing to
						display</div>

					<div class="col-xs-12 one1" ng-repeat="challenge in challenges | filter:filterSearch">
						<div class="panel panel-primary">
							<div class="panel-heading">
								{{challenge.challengTitle}}
								<i style="float: right; position: relative; top: 3px;"
									class="fa fa-times-circle" ng-click="deleteChallenge(challenge)"></i>
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
						</div> -->
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

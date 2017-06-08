<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html ng-app="techpedia">
<!-- BEGIN HEAD -->

<jsp:include page="template/NewHeader.jsp" />

 <style>
  .breadcrumb>li+li:before {
padding: 0 5px;
color: #ccc;
content: none;
} </style>
<!-- END HEADER -->
<div class="clearfix"></div>
<div class="customFont" style="height:301px">
	<img src="images/Challenges-Banner.jpg" class="img-responsive" style="width:100%; height:301px;">
</div>
<!-- BEGIN CONTAINER -->
<div class="container customFont borderRadius style" style="background-color: #3f94ae" >
	
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
	
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->


			<!-- END STYLE CUSTOMIZER -->
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<!-- <div style="color: #ffffff; font-size: 18px;margin-bottom:15px;">
						<i class="fa fa-bolt" id="icon-size"></i> CHALLENGES
						<small>dashboard & statistics</small>
					</div> -->
					<ul class="page-breadcrumb breadcrumb" style="background-color: #217690; color: white !important">

						<%
							if (session.getAttribute("username") != null) {
						%>
						<li style="color: #ffffff !important"><a style="color: #ffffff !important" href="./">Home&nbsp;</a> <font
							style=" color: #262626; font-size: 18px;">&raquo;</font></li>
						<li style="color: #ffffff !important"><a style="color: #ffffff !important" href="dashboard">Dashboard&nbsp;</a> <font
							style=" color: #262626; font-size: 18px;">&raquo;</font></li>
						<li style="color: #ffffff !important">Challenges</li>

						<%
							} else {
						%>
						<li style="color: #ffffff !important"><a style="color: #ffffff !important" href="./">Home</a> &raquo;</li>
						<li>Challenges</li>
						<%
							}
						%>

			
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<div class="clearfix"></div>
			<div class="content" ng-controller="ChallengesPageController" ng-init="initialChallengesData()">
				<div class="row">
					<div class="col-xs-6">
						<span  style="color:#ffffff">Search by title:</span> <input ng-model="searchTerm" ng-keydown="initialChallengesData()"/>
						<button class="btn btn-success btn-responsive" style="height:33px;" id="search" ng-click="searchChallenge(searchTerm, 'title')"><i class="fa fa-search"></i>&nbsp;Search</button>
					</div>
					<div class="col-xs-6" style="padding-left: 310px;">
						<span  style="color:#ffffff">Filter:</span> <input ng-model="filterSearch" />
					</div>
				</div>
				<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="message.length>0">
					<li ng-repeat="msg in message">{{msg}}</li>
				</div> -->

				<div class="alert alert-sm alert-info alert-dismissible" role="alert"
					ng-show="challenges.length==0">Nothing to display</div>

				<div class="row" style="padding-left: 20px; padding-right: 20px;">
					<div class="col-xs-12" style="border-radius:8px;;margin-left:3px;  height:240px; background-color: #ffffff;  margin-top: 20px;" 
					ng-repeat="challenge in challenges | filter:filterSearch">
						<!-- <a href="#" ng-click="clickChallenge(challenge.challengId)"> -->
						
						<div class="col-xs-3"style="float: left; padding-left: 12px;">
							<img src="{{challenge.challengImgPath||'images/banner_project.jpg'}}" alt=""
							style="height: 222px; width: 235px; padding-top: 15px; position: absolute; z-index: 0; " class="img-responsive" />
							<div class="col-xs-2"
							style="margin-top:168px;padding-top:13px;bottom: 0; left:0;width: 235px; height:54px; position: relative; text-align: center; color: black; font-weight: bolder; opacity: 0.7; filter: alpha(opacity = 70); z-index: 4; background-color: white;">{{challenge.challengTitle}}</div>
						</div>
						
					<div class="col-xs-9" style="font-family:arial; color:#262626;font-size: 14px; height: 12em; right; text-align: justify;padding-left: 0px;  padding-top: 20px; overflow: hidden; text-overflow: ellipsis;">
					<h5 style="font-family:Arial;font-weight:bold;font-size:14;color:#3f94ae;">DETAILS:</h5>{{challenge.challengDescription}}</div>
				    <div class="col-xs-8">&nbsp;</div>
					<div class="col-xs-2" style="margin-left: 58%;margin-bottom:30px;">
					<a class="btn btn-success btn-responsive" style="width:120px;text-align:center;" ng-click="clickChallenge(challenge.challengId)" href=""><i class="fa fa-book" ></i>&nbsp;Read More</a>
					</div>
							<!-- <div class="col-md-4">
								<div class="post col-xs-12 category">
									<h5 class="header-customize">
									<script>
									var title = challenge.challengTitle.length()
									if(title > 12) {
										
									}
								
									</script>
										{{challenge.challengTitle}}
									</h5>
									<div class="portofoliothumb">
										<img src="{{challenge.challengImgPath||'images/AllChallenge.png'}}" class="fourimage" alt="" style="width:200px; height:120px;"  />
									</div>
								</div>
							</div> -->
						<!-- </a> -->
					</div>
				</div>
				<div class="alert alert-sm alert-info alert-dismissible" role="alert" id="hide"
					ng-show="message.length>0">
					<p style="text-align: center">	<!-- <button  disabled>Show more</button> -->
					<p ng-repeat="msg in message" style="text-align: center">{{msg}}</p></p>
				</div>
				<div class="row" >
					<br />
					<p style="text-align: center">
						<button id="showMoreBtn" ng-click="viewMore(count=count+1,searchTerm)" ng-show="message.length>=0" ng-model="searchTerm" style="background-color:#ffffff;border-radius:8px;height:40px;width:120px;border-radius:6px; font-weight:bold;color:gray;">Show more</button>
						<img src="images/loading1.gif" id="img" style"display:none"width="42" height="42"/ >
					</p>
				</div>

				<div class="hr"></div>

			</div>
			<div class="clearfix"></div>
			

			<!-- END CONTAINER
BEGIN FOOTER -->

		</div>
	</div>
</div>

<!-- END FOOTER --></div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<p class="back-top floatright">
			<a href="#top"><span></span></a>
		</p>
<!-- END JAVASCRIPTS -->

</body>
<!-- END BODY -->
<jsp:include page="template/footer.jsp" />
</html>


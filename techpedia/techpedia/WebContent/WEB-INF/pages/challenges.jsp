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
<!-- BEGIN CONTAINER -->
<div class="container customFont borderRadius style" >
	
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
					<h3 class="page-title">
						<i class="fa fa-bolt" id="icon-size"></i> Challenges
						<!-- <small>dashboard & statistics</small> -->
					</h3>
					<ul class="page-breadcrumb breadcrumb" style="background-color: #D8D8D8;content:none;">

						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Challenges</li>

						<%
							} else {
						%>
						<li><a href="./">Home</a> &raquo;</li>
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
						Search by title: <input ng-model="searchTerm" />
						<button id="search" ng-click="searchChallenge(searchTerm, 'title')">Search</button>
					</div>
					<div class="col-xs-6">
						Filter: <input ng-model="filterSearch" />
					</div>
				</div>
				<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="message.length>0">
					<li ng-repeat="msg in message">{{msg}}</li>
				</div> -->

				<div class="alert alert-sm alert-info alert-dismissible" role="alert"
					ng-show="challenges.length==0">Nothing to display</div>

				<div class="row">
					<div id="portofolio" ng-repeat="challenge in challenges | filter:filterSearch">
						<a href="#" ng-click="clickChallenge(challenge.challengId)">
							<div class="col-md-4">
								<div class="post col-xs-12 category">
									<h5 class="header-customize">
								<!-- 	<script>
									var title = challenge.challengTitle.length()
									if(title > 12) {
										
									}
								
									</script> -->
										{{challenge.challengTitle}}
									</h5>
									<div class="portofoliothumb">
										<img src="{{challenge.challengImgPath||'images/AllChallenge.png'}}" class="fourimage" alt="" style="width:200px; height:120px;"  />
									</div>
								</div>
							</div>
						</a>
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
						<button id="showMoreBtn" ng-click="viewMore(count=count+1,searchTerm)" ng-show="message.length>=0" ng-model="searchTerm">Show more</button>
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


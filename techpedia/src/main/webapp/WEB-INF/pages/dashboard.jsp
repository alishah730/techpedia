<body style="background-color: white !important">
	<jsp:include page="template/NewHeader.jsp" />
	<div >
			<img src="images/DASHBOARD-BANNER.jpg" class="img-responsive" style="width:100%; height:154px;">

		<%
								String typeofuser = (String)session.getAttribute("usertype");
								if(typeofuser.equals("student")){
		%>

		<div class="col-md-3" 
			style="margin-left: 75%; margin-top: -4%;">

			<a href="addProject" class="btn btn-success btn-responsive"
				type="button"><span class="glyphicon glyphicon-plus "></span>Add
				New Project</a> <a href="newInnovation"
				class="btn btn-success btn-responsive" type="button"><span
				class="glyphicon glyphicon-plus "></span>Submit Innovation</a>
		</div>
		<%} %>
			
</div>
	
	
<html ng-app="techpedia">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<style>
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none;
}
.nav-pills > li.active > a, .nav-pills > li.active > a:hover, .nav-pills > li.active > a:focus {
    
    background-color: #262626 !important;
}
.hov {
    text-decoration: none;
    background-color: #777777;
}
a:hover{
background-color:#262626 !important
}
a:focus{
background-color:#262626 !important }
li.active{
background-color:#262626 !important;}
.row {
	margin-right: -1px;
	margin-left: -1px;
}

img {
	max-width: 100%;
}
</style>
<div class="clearfix"></div>


<div class="container customFont borderRadius style"
	style="background-color: #3f94ae">

	<div class="page-container">
		<div class="page-sidebar-wrapper"></div>
		<div class="page-content-wrapper" ng-controller="DashboardController"
			ng-init="initLoad()">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<!-- <h3 class="page-title" style="color: white;">
							<font size="15"><i class="fa fa-dashboard custom"></i></font>&nbsp;DASHBOARD
						</h3> -->

						<ul class="page-breadcrumb breadcrumb"
							style="background-color: #217690; color: white !important;">
							<li><a style="color: white !important;" href="./">Home</a> <font
								style="font-weight: bold; color: white; font-size: 18px;">&raquo;</font></li>
							<li style="content: none !important;">Dashboard</li>
							
						</ul>
					</div>
				</div>
				<div class="col-xs-6" style="margin-left: 33%;">
					<ul class="nav nav-pills" style="color: white;">
						<li ><a class="hov" data-toggle="tab" href="#"
							style="color: #ffffff;  font-weight: bold;"
							ng-click="clickFilter('my')"><i class="fa fa-user custom"></i>&nbsp;MY
								PROJECT</a></li>
						<li><a class="hov" ng-click="clickFilter('follow')" data-toggle="tab"
							href="#" style=" color: #ffffff; font-weight: bold;"><i
								class="fa fa-at"></i>&nbsp;FOLLOWING</a></li>
						<li ><a class="hov" ng-click="clickFilter('all')"
							data-toggle="tab" href="#"
							style=" color: #ffffff; font-weight: bold;"><i
								class="fa fa-reorder custom">&nbsp;</i>SHOW ALL</a></li>
					</ul>
				</div>
				<br>
				<div class="clearfix"></div>
				<!-- my project code starts here -->
				<div class="row" ng-show="showMyProjects">
					<div class="col s12"
						style="border-radius: 8px; /* width: 1079px; margin-left: 20px; */ height: 35px; padding-top: 9px; padding-left: 12px; background-color: #262626; color: white;">MY
						PROJECTS</div>

					<br>
					<!-- <div class="clearfix"></div> -->
					<div class="alert alert-info" role="alert"
						ng-show="message.length>0" ng-repeat="msg in message">{{msg}}</div>

					<div class="col s12"
						style="border-radius: 8px; /*  width: 1079px; */ height: 187px; background-color: #ffffff; /* margin-left: 20px; */ margin-bottom: 20px;"
						ng-repeat="project in myProjects | filter: filterSearch">

						<!-- <div class="alert alert-sm alert-info alert-dismissible"
						role="alert" ng-show="myProjects==0">Nothing to display</div> -->


						<div>
							<div style="float: left; padding-left: 12px;">
								<img
									style="height: 185px; width: 235px; padding-top: 15px; position: absolute; z-index: 0;"
									src="${pageContext.request.contextPath}/image/{{project.photo1Path ||'/usr/Techpedia/Project/placeholders/placeholder.png'}}" alt="" />
								<div
									style="margin-top: 56%; padding-top: 13px; bottom: 0; left: 0; width: 235px; height: 54px; position: relative; text-align: center; color: black; font-weight: bolder; opacity: 0.7; filter: alpha(opacity = 70); z-index: 4; background-color: white;">{{project.projTitle}}</div>
							</div>
							<div>
								<div
									style="padding-left: 265px; padding-top: 25px; arial; font-size: 14; color: #3f94ae; font-weight: bolder;">DETAILS:</div>
								<div class="col s6"
									style="margin-left: 265px; margin-right: 144px; font-family: arial; font-size: 14; height: 5em; right; text-align: justify; position: absolute; padding-top: 6px; overflow: hidden; text-overflow: ellipsis;">
									{{project.projDescription}}</div>
							</div>
							<div class="col s6" style="margin-top: 90px">
								<button class="btn btn-success btn-responsive"
									style="padding-left: 8px; /* margin-top: 85px;*/ margin-left: 66%;"
									class="btn btn-info" ng-click="viewProject(project)">
									<i class="fa fa-book">&nbsp;&nbsp;</i>Read More
								</button>
							</div>


						</div>
					</div>
				</div>
				<!-- my project code ends here -->
				<div class="clearfix"></div>
				<!-- followed project code starts here -->
				<div class="row" ng-show="showProjectsIFollow">
					<div class="col s12"
						style="border-radius: 8px; /* width: 1079px; margin-left: 20px; */ height: 35px; padding-top: 9px; padding-left: 12px; background-color: #262626; color: white;">PROJECTS
						I FOLLOW</div>

					<br>
					<div class="clearfix"></div>
					<div class="alert alert-info" role="alert"
						ng-show="message.length>0" ng-repeat="msg in message">{{msg}}</div>
					<div class="col s12"
						style="border-radius: 8px; /* width: 1079px; */ height: 187px; background-color: #ffffff; /* margin-left: 20px; */ margin-bottom: 20px;"
						ng-repeat="project in projectsIFollow | filter: filterSearch">


						<!-- <div class="alert alert-sm alert-info alert-dismissible"
						role="alert" ng-show="projectsIFollow==0">Nothing to display</div>
						<div> -->


						<div style="float: left; padding-left: 12px;">
							<img
								style="height: 185px; width: 235px; padding-top: 15px; position: absolute; z-index: 0;"
								src="${pageContext.request.contextPath}/image/{{project.photo1Path || '/usr/Techpedia/Project/placeholders/placeholder.png'}}" alt="" />
							<div
								style="margin-top: 56%; padding-top: 13px; bottom: 0; left: 0; width: 235px; height: 54px; position: relative; text-align: center; color: black; font-weight: bolder; opacity: 0.7; filter: alpha(opacity = 70); z-index: 4; background-color: white;">{{project.projTitle}}</div>
						</div>
						<div>
							<div
								style="padding-left: 265px; padding-top: 25px; arial; font-size: 14; color: #3f94ae; font-weight: bolder;">DETAILS:</div>
							<div
								style="margin-left: 265px; margin-right: 144px; font-family: arial; font-size: 14; height: 5em; right; text-align: justify; position: absolute; padding-top: 6px; overflow: hidden; text-overflow: ellipsis;">
								{{project.projDescription}}</div>
						</div>
						<div class="col s6" style="margin-top: 90px;">
							<button
								style="padding-left: 8px; /* margin-top: 85px; */ margin-left: 66%;"
								class="btn btn-success btn-responsive"" ng-click="viewProject(project)">
								<i class="fa fa-book">&nbsp;&nbsp;</i>Read More
							</button>
						</div>


					</div>
				</div>
			</div>



			<!-- followed project code ends here -->

			<br>
			<div class="clearfix"></div>





		</div>
	</div>
</div>
</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="js/dashboardJs/excanvas.min.js"></script> 
<![endif]-->
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
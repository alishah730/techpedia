<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<html ng-app="techpedia">
<body style="background-color:#d3d3d3">
<!-- BEGIN HEAD -->
 <style>
  .breadcrumb>li+li:before {
padding: 0 5px;
color: #ccc;
content: none !important;
} 
.category.height-adjust{
	height: 400px;
}

.project {
	padding: 10px;
	float: left;
	margin: 10px; 
	height: 382px !important;
	width: 262px !important;
	 line-height: 2.75;
	vertical-align: bottom !important;
	background: #f8f6f6;
	-moz-box-shadow: 1px 1px 1px #ccc;
	-webkit-box-shadow: 1px 1px 1px #ccc;
	box-shadow: 1px 1px 1px #ccc;
	position: relative;
	cursor: pointer;
	color: #ffffff !important;
	background-color: #3F94AE;
}

/** set color to white ***/
.white-text {
	color: #ffffff;
}





.icon_table {
	width: 100%;
	font-color:  #ffffff !important;
}

.icon_td {
	align-items: center;
	align-content: center;
		font-color:  #ffffff !important;
}

.desc1 {
	line-height: 1em;
	overflow: hidden;
	height: 9em;
	text-overflow: ellipsis;
	padding:2px;
	
	border: 5px;
}
.clear {
	clear: both;
}
.food-box-transparentbg {
	height: 50%;
	width: 100%;
	position: absolute;
	bottom: 0;
	left: 0;
	background: url(images/transparent_black.png);
	display: none;
	overflow: hidden;
	text-overflow: ellipsis;
	padding-top:10px;
}
.div1{
    display: none;
    color: white;
    text-align:justify;
}

</style>

<jsp:include page="template/NewHeader.jsp" />
<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="customFont" style="height:301px">
	<img src="images/Project_Banner.jpg" class="img-responsive" style="width:100%; height:301px;">
	</div>
<div class="container customFont borderRadius style" style="background-color: #ffffff;" >

<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	
	<div class="page-content-wrapper">
		<div class="page-content" bgcolor="#E6E6FA">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->


			<!-- END STYLE CUSTOMIZER -->
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<!-- <h3 class="page-title">
						<i class="fa fa-files-o" id="icon-size"></i> Projects
						<small>dashboard & statistics</small>
					</h3> -->
					<ul class="page-breadcrumb breadcrumb" style="background-color: #ffffff;margin-top:-10px;" >
						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home&nbsp;</a> <font style="color: black; font-size:18px;">&raquo;</font></li>
						<li><a href="dashboard">Dashboard&nbsp;</a> <font style=" color: black; font-size:18px;">&raquo;</font></li>
						<li>Projects</li>

						<!-- <li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li> -->
						<%
							} else {
						%><li><a href="./">Home&nbsp;</a> <font style=" color: black; font-size:18px;">&raquo;</font></li>
						<li>GYTI Projects</li>
						<%
							}
						%>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>

			<div class="clearfix"></div>
			<div class="content" ng-controller="GytiProjectsPageController" ng-init="initialProjectsData()">
				<div class="row" style="background-color:#ffffff;">
				<!--   
				 <div class="col-md-12" style="height:28px;background-color:#ffffff;">
				   
				   <h5 class="heading1" style="font-size:16px;font-weight: bold;font-family: Corbel;padding-left:14px;">NARROW YOUR SEARCH BY</h5>
				 </div>
				  -->
				   <div class="row" style="background-color:#d3d3d3; margin-left:8px;margin-right:8px;margin-top:-20px;'">
					<div class="col-sm-3" style="width:230px;padding-top:20px;padding-bottom:20px;font-weight:bold;">
						Keywords: <input type="text" style="height:33px;"ng-model="searchTerm" />
						</div>
						<div class="col-sm-3" style="width:230px;padding-top:20px;padding-bottom:20px;">
							<input style="" type="text" placeholder="Search branches" class="form-control" ng-model="Branch" id="branchIdOfStudent2"
														  value=""  required data-toggle='tooltip' data-placement='right' 
														title="Please enter Branch">
							<!-- <input style="width:220px;box-shadow: 2px 2px 2px 2px #d3d3d3" ng-model="Branch"  /> -->
							
					</div>
					<div class="col-sm-3" style="width:230px;padding-top:20px;padding-bottom:20px;">
					<button class="btn btn-success btn-responsive" style="height:33px;" ng-click="searchProjects(searchTerm, 'keyword',Branch)" ng-disabled="(!searchTerm) || (!Branch)" ><i class="fa fa-search"></i>&nbsp;Search</button>
					</div>
					<div class="col-sm-3" style="width:230px;padding-top:20px;padding-bottom:20px;float:right;font-weight:bold;">
					Filter: <input style="height:33px;" ng-model="filterSearch" />
					</div>
					
					</div>
				</div>
				<div class="col-md-12">&nbsp;</div>
				
				
				<!-- <div class="alert alert-sm alert-danger alert-dismissible" role="alert"
					ng-show="message.length>0">
					<li ng-repeat="msg in message">{{msg}}</li>
				</div> -->

				<div class="alert alert-sm alert-info alert-dismissible" role="alert"
					ng-show="projects.length==0">No project matching the keyword</div>


				<div class="row" style="background-color:#ffffff;">
				<div class="col-xs-12 col-md-9" style="background-color:#ffffff;" >
			
						<div ng-repeat="project in projects | filter:filterSearch" >
							<a href="#" ng-click="clickProject(project.projId)">
							<div class="post col-xs-12 col-md-4" style="background-color:#ffffff;" >
         <span>{{entry.title}}</span> 
            <div  class="project" onmouseenter="$(this).children('.div1').slideDown(600)" onmouseleave="$(this).children('.div1').slideUp(600)">
				
			
				<table class="icon_table" >
						<tr>
							<img src="${pageContext.request.contextPath}/image/{{project.photo1Path ||'/usr/Techpedia/Project/placeholders/placeholder.png' }}" width="226px" height="182px" class="fourimage" alt="" />
						</tr>
						
						<tr>
							<div align="center" style="font-size:15px;font-weight: bold;font-family: Corbel;">{{project.projTitle}}</div>
						</tr>
						<tr >
							<td align="center" style="font-size:12px; font-family: Arial;" class="icon_td"><img id="" alt="" src="images/student-icon.png"/> <div style="text-overflow:ellipsis !important;overflow: hidden !important;">{{project.teamLeaderName | truncate:true:14:'...'}}</div></td>
							<td align="center" style="font-size:12px;font-family: Arial;" class="icon_td"><img  alt="" src="images/faculty-icon.png"/><div>{{project.projFacultyName | truncate:true:14:'...'}}</div></td>
						</tr>
						<tr >
							<td align="center" style="font-size:12px;font-family: Arial;" class="icon_td" ><img alt="" src="images/College-icon.png"/><div>{{project.projCollege | truncate:true:14:'...'}}</div> </td>
							<td align="center" style="font-size:12px;font-family: Arial;" class="icon_td"><img alt="" src="images/branches-icon.png"/><div class="header-customize" font color="white" ng-model="project.projBranchList">
								{{project.projBranchName| truncate:true:14:'...'}}			</div></td>
						</tr>
					
				</table>
             <div class=" div1 food-box-transparentbg" >
             <span style="font-weight:bold;    padding-left: 6px;">Project  Abstract :</span>
            <div class="desc1">
            <div style="font-size:12px;font-family: Arial,Regular;padding-left:5px;padding-right:15px;">{{project.projAbstract}}</div>
            </div>
            </div>
            
           </div>
           
            </div>
        </div>

						</a>
						<div class="alert alert-sm alert-info alert-dismissible" role="alert" id="hide"
					ng-show="message.length>0">
					<p style="text-align: center">	<!-- <button  disabled>Show more</button> -->
					<p ng-repeat="msg in message" style="text-align: center">{{msg}}</p></p>
				</div>
				<div class="row">
					<br />
					<p style="text-align: center">
						<button id="showMoreBtn" style="background-color:#ffffff;border-radius:8px;height:40px;width:130px;box-shadow: 3px 3px 3px 3px #d3d3d3;margin-left: 35%;" ng-click="viewMore(count=count+1,searchTerm,Branch)" ng-show="message.length>=0" ng-model="keyword">Show more</button>
						 <img src="images/loading1.gif" id="img" style"display:none"width="42" height="42"/ >
					</p>
				</div>
				<!-- 
				 <div class="row" ng-show="message.length>0">
					<br />
					<p style="text-align: center">
					
						<div>No more projects to Display</div>
					</p>
				</div>  -->
				<div class="hr"></div>
					</div>

				<div class="col-xs-12 col-md-2" style="background-color:#d3d3d3;position: relative;
	cursor: pointer;width:245px;margin-left:18px;margin-top:9px;height: 1187px;" >
					
					<a ng-click="recentProjectVisibility()"><div style="color:black;font-family:Corbel;font-size:18px;font-weight: bold;padding-left:35px;">LATEST PROJECTS</div></a>
					
					 <!-- <div class="row row-centered" id="recentProjects" style="width:700px;display:none;margin-left: auto;margin-right: auto; float: none;"> -->
				
							<div class="col-xs-12" style="height:220px;padding-top:10px; align:center;margin-left:20px; margin-right:10px; width:180px;margin-bottom:5px;margin-top:5px;background-color: #3f94ae;" ng-repeat="project in recentprojects">
							
										
										<img src="${pageContext.request.contextPath}/image/{{project.photo1Path ||'/usr/Techpedia/Project/placeholders/placeholder.png'}}" class="fourimage" alt="" width="150px" height="100px" />
										<p style="font-size:15px;font-weight:bold; color:#ffffff;font-family: Corbel ;text-align:center;">{{project.projTitle}}</p> 
										<hr>
										<a class="btn btn-success btn-responsive" style="align:center; margin-left:20px;text-align:center;" ng-click="viewProject(project)" href=""><i class="fa fa-book fa-fw"></i>&nbsp;Read More</a>
										 <div class="col-xs-12">&nbsp;</div> 
						  </div>
					
	   		 <!-- </div> -->
				 	<!-- <hr style="background-color:black;color:black"/>  -->
					<ul class="next" align="justify" style="list-style-type: none;">
											
					</ul>
				</div>
				</div>
			</div>
			<div class="hr"></div>
			<div class="clearfix"></div>

			<!-- END CONTAINER
BEGIN FOOTER -->

		</div>
	</div>
</div>
</div>
<p class="back-top floatright">
			<a href="#top"><span></span></a>
		</p>
<!-- END FOOTER -->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>jQuery.noConflict();</script>
</body>
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<!-- END BODY -->
</html>

<jsp:include page="template/footer.jsp" />

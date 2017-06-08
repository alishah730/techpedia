<%@page import="java.util.ArrayList"%>
<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
 <img src="images/Challenges_with label.png" class="img-responsive" style="width:100%; hegiht:25%;">
<style>
.line{
border-top: 1px solid #a9a9a9;
margin-top:-10px;
width: 820px;
margin-right: 15px;
}
.side{
border-top: 1px solid #a9a9a9;
margin-top:1px;
margin-bottom: 5px;
}

.inside{
font-size:12px;font-family: Arial;margin-bottom: 10px;color:#262626;
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
.font_divs
{
font-size:15px;font-family: Corbel;font-weight:bold;
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
}
</style>
<div class="clearfix"></div>

<div class="container customFont borderRadius style" >
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<%-- <jsp:include page="template/dashboardMenu.jsp" /> --%>
	</div>

	<div class="page-content-wrapper" ng-controller="ChallengeDetailsController" ng-init="InitLoad()">
		<div class="page-content">
		
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<%
						if (session.getAttribute("username") != null) {
					%>
					<div class="col-md-12 pull-right" style="padding-bottom:5px;" ng-switch on="checkChallengeFollow" ng-show="challenge.rgstrId!=<%=session.getAttribute("id")%>">
				      <div class="col-md-12 pull-right" ng-switch-when="true"><a style="cursor: pointer;background-color:#709FDD;border-color:#709FDD; " class="btn btn-info btn-sm accept-style pull-right" ng-click="unfollow()">Unfollow</a><br></div>
				      <div class="col-md-12 pull-right" ng-switch-when="false"><a style="cursor: pointer;background-color:#709FDD;border-color:#709FDD;" class="btn btn-info btn-sm accept-style pull-right" ng-click="follow()">Follow</a><br></div>
				      <div class="col-md-12 pull-right" ng-switch-default><a style="cursor: pointer;background-color:#709FDD;border-color:#709FDD;" class="btn btn-info btn-sm accept-style pull-right" ng-click="follow()">follow</a></div>
 					</div>
					
					
					<%
						}
					%>
					<ul class="page-breadcrumb breadcrumb">
						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home</a> &raquo;
						<a href="dashboard">Dashboard</a> &raquo;
						<a href="challenges">Challenges</a> &raquo;
						Challenge Details  &raquo;
						{{challenge.challengTitle}}</li>
						<!-- <li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li> -->
						
						
						<%
							} else {
						%><li><a href="./">Home</a> &raquo;
						<a href="challenges">Challenges</a> &raquo;
						Challenge Details  &raquo;
						{{challenge.challengTitle}}</li>
						<%
							}
						%>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-bolt" id="icon-size"></i> Challenge Details
						<!-- <small>dashboard & statistics</small> -->
					</h3>
					
				</div>
			</div>

			<div class="clearfix"></div>
			<div class="row">
				<!-- PROJECT DESCRIPTION-->
				<div class="col-xs-12">
					<div class="sectiontitle">
						<div class="col-md-12">
							
							<%
								if (session.getAttribute("username") != null) {
							%>
							<div class="col-md-4">
								<a style="cursor: pointer" class="btn btn-info btn-sm accept-style" ng-show="challenge.rgstrId!=<%=session.getAttribute("id")%>"
									ng-click=acceptChallenge(challenge)>Accept</a><br> <br>
							</div>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<!-- Default panel contents -->

<div class="col-xs-12 col-md-9">
							<div class="panel-heading"  style="border:0; ;font-size:15px;font-family: Corbel;;font-weight:bold;background-color: #3f94ae;height: 30px;margin-bottom: 10px; width: 210px; color:white">
								CHALLENGE DESCRIPTION  
							</div>	
							<hr class="line">
			
						<div style="margin:10px;padding:5px;display:block!important;">
							
							<span style="font-size:12px;font-family: Arial; text-align: justify; text-justify: inter-word;">{{challenge.challengDescription}}</span> 
    						
						</div>
						<div class="panel-heading"  style="border:0; ;font-size:15px;font-family: Corbel;;font-weight:bold;background-color: #3f94ae;    height: 30px; margin-bottom: 10px; width: 210px; color:white">
								CHALLENGE ABSTRACT  
							</div>
							<hr class="line">
						<div style="margin:10px;padding:5px;">
							
							<span style="font-size:12px;font-family: Arial; text-align: justify;text-align:justify;">{{challenge.challengAbstract}}</span>
								<img src="images/Challenges_Img.png" class="img-responsive" align="left" style="    padding-right: 10px;">
						</div>
						
						
						<div class="panel-heading"  style="border:0; ;font-size:15px;font-family: Corbel;;font-weight:bold;background-color: #3f94ae;      margin-top: 235px;   height: 30px; margin-bottom: 10px; width: 210px; color:white">
								RELATED PROJECTS  
							</div>
						<hr class="line">
						
							<div ng-repeat="project in projects | filter:filterSearch" >
							<a href="#" ng-click="clickProject(project.projId)">
							<div class="post col-xs-12 col-md-4" style="background-color:#ffffff;color:#fffff" >
         <span>{{entry.title}}</span> 
            <div  class="project" onmouseenter="$(this).children('.div1').slideDown(600)" onmouseleave="$(this).children('.div1').slideUp(600)">
				
			
				<table class="icon_table" >
						<tr>
							<img src="${pageContext.request.contextPath}/image/{{project.photo1Path ||'E:/Techpedia/Project/UploadedDocuments/ProjectImages/defaultImage/placeholder.png'}}" width="226px" height="182px" class="fourimage" alt="" />
						</tr>
						
						<tr>
							<div align="center" style="font-size:15px;font-weight: bold;font-family: Corbel;color:#ffffff;">{{project.projTitle}}</div>
						</tr>
						<tr >
							<td align="center" style="font-size:12px; font-family: Arial;color:#ffffff;" class="icon_td"><img id="" alt="" src="images/student-icon.png"/> <div style="text-overflow:ellipsis !important;overflow: hidden !important;">{{project.projTeamLeaderName}}</div></td>
							<td align="center" style="font-size:12px;font-family: Arial;color:#ffffff;" class="icon_td"><img  alt="" src="images/faculty-icon.png"/><div>{{project.projFacultyName}}</div></td>
						</tr>
						<tr >
							<td align="center" style="font-size:12px;font-family: Arial;color:#ffffff;" class="icon_td" ><img alt="" src="images/College-icon.png"/><div>{{project.projCollege}}</div> </td>
							<td align="center" style="font-size:12px;font-family: Arial;color:#ffffff;" class="icon_td"><img alt="" src="images/branches-icon.png"/><div>
								{{project.projBranchList[0].projBranchDesc}}			</div></td>
						</tr>
					
				</table>
             <div class=" div1 food-box-transparentbg" >
            
            <div class="desc1">
            <div style="font-size:12px;font-family: Arial,Regular;padding-left:5px;padding-right:10px;">
            			<button
									style="background-color: #5cb85c; padding-left: 8px; width:140px;align:center;margin-left:50px;margin-top:40px;" 
									class="btn btn-info" ng-click="viewProject(project)">
									<i class="fa fa-book">&nbsp;&nbsp;</i>Project Details
						</button>
						<div class="col-xs-12">&nbsp;</div>
							<a class="btn btn-success btn-responsive" ng-hide="<%=session.getAttribute("username")%>==null" style="align:center; margin-left:50px;text-align:center;width:140px;" ng-click="clickTeam(project)">Team Details</a>
           					<a class="btn btn-success btn-responsive" ng-show="(<%=session.getAttribute("username")%>==null) && (userType=='mentor'||userType=='faculty')" style="align:center; margin-left:50px;text-align:center;width:140px;" ng-click="clickTeam(project)">Team Details</a>
            </div>
            </div>
            </div>
            
           </div>
           
            </div>
        </div>
    
						
						
						</div>
					
						
						<div class="col-xs-12 col-md-3">
					<div style="font-size:15px;font-family: Corbel;font-weight:bold;color:#262626; margin-top: 10px;">CHALLENGE  BASIC  INFORMATION</div><hr class="side">
					<div style="background-color: #d3d3d3;padding:20px;">
					
							<div class="font_divs">Challenge Start Date</div>	<hr class="side">
							<div class="inside">{{challenge.challengStartDate}}</div>
							
							<div class="font_divs">Project ID</div>	<hr class="side">
							<div class="inside">{{challenge.projId}}</div>
						
							<div class="font_divs">Registration ID</div><hr class="side">
							<div class="inside">{{challenge.rgstrId}}</div>
									
						
									
							<div class="font_divs">Challenge ID</div>	<hr class="side">
							<div class="inside">{{challenge.challengId}}</div>
							
							<div class="font_divs">Created By</div><hr class="side">
							<div class="inside">
									<div>{{challenge.userName}}</div>
									</div>
											
							<div class="font_divs">Challenge Title</div>	<hr class="side">
							<div class="inside">{{challenge.challengTitle}}</div>
						
					</div>
					
					<%if(session.getAttribute("id")!=null){ %>
				
					<div style="background-color: #d3d3d3;padding:20px; margin-top:10px;" >
					<div style="border:0; color:black;">
								Document list <span ng-show="deletedocmessage.length>0" style="float: right"
									ng-repeat="msg in deletedocmessage">{{msg}}</span>
							</div>
							<div>
								<div><ul class="list-group">
										<li class="list-group-item" ng-repeat="document in challengeDocumentList">{{document.docName}}
											<button ng-click=downloadDocumentLink(document) class="btn btn-sm btn-info">Download</button>
											<button ng-click=deleteDocument(document) class="btn btn-sm btn-info">Delete</button>
										</li>
									</ul>
								</div>
				
				
				
				</div><%} %>
						
				
				</div>
						
						
	
						
						

				

				</div>
			<div class="clearfix"></div>
			
				<div class="col-md-12 left-border">
					
							<div 
								style="border: 0; font-size:15px;font-family: Corbel;font-weight:bold;  color: black">COMMENTS
							</div>
							<hr class="side">
                
							

						

								<script type="text/javascript">
								$(document).ready(function(){
									$( "#techpedia" ).show();
									$("#facebook").hide();
									$( "#fb" ).click(function() {
										$( "#techpedia" ).hide();
										$("#facebook").show();
										});

										$( "#tech" ).click(function() {
										$( "#techpedia" ).show();
										$("#facebook").hide();
										});
								})
								
						</script>
						<div class="panel-body">
								<button  style="background-color: #2d2d2d;border: none;"><img  id="tech"  class="img-responsive"
								src="images/TPlogo.jpg" alt="" /></button>
								<button  style="background-color: #306199;border: none;margin-left: -2px;"><img id="fb"  class="img-responsive" 
								src="images/FBlogo.jpg" alt="Facebook" /></button>
								
								<!-- <div class="alert alert-info" role="alert" ng-show="message.length>0"
									ng-repeat="msg in message">{{msg}}</div>
									
								<div>-->
								<div id="facebook">

									<!-- facebook comments code starts here -->

									<div id="fb-root"></div>
									<script>
									(function(d, s, id) {
										var js, fjs = d.getElementsByTagName(s)[0];
										if (d.getElementById(id))
											return;
										js = d.createElement(s);
										js.id = id;
										js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.5";
										fjs.parentNode.insertBefore(js, fjs);
									}(document, 'script', 'facebook-jssdk'));
								</script>
									<div class=" panel-heading"
										style="font-size:15px;font-family: Corbel;font-weight:bold; background-color: #306199; font-color: white;margin-top: -6px; color: white">Facebook
										Comments</div>
									<div class="fb-comments"
										data-href="http://localhost:8080/techpedia/projectDetails{{projectdetails.projId}}"
										data-width="1072" data-numposts="5"></div>
									
									</div>



									<!-- facebook comments code ends here -->
						<!-- <div class="panel panel-warning" style="border:0;">
							<div class=" panel-heading"style="border:0;background-color: #E8E8E8 ; color:black">Comments 
												</div>
							<div class="panel-body"> -->
								<!-- <div class="alert alert-info" role="alert" ng-show="message.length>0"
									ng-repeat="msg in message">{{msg}}</div>
									
								<div				
 -->							
								<!-- <div id="fb-root" ></div>
									<script>(function(d, s, id) {
									  var js, fjs = d.getElementsByTagName(s)[0];
									  if (d.getElementById(id)) return;
									  js = d.createElement(s); js.id = id;
									  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.5";
									  fjs.parentNode.insertBefore(js, fjs);
									}(document, 'script', 'facebook-jssdk'));</script>
									<div class=" panel-heading"style="border:0; background-color: #4e69a2; color:white;border-color: #435a8b #3c5488 #334c83; color:black">FaceBook Comments 
												</div>
									<div class="fb-comments" data-href="http://localhost:8080/techpedia/projectDetails{{projectdetails.projId}}" data-width="1072" data-numposts="5"></div> -->
								<!-- <div class="col-md-12" ng-show="teamComments.length>0">
									<div class="panel panel-warning"style="border:0;">
										<div class=" panel-heading"style="border:0;background-color: #E8E8E8 ; color:black">Team Comments</div>
										<div class="panel-body">
											<ul class="list-group">
												<li class="list-group-item" ng-repeat="comment in teamComments"><span class="badge"
													ng-click="deleteComment(comment,'team')"
													ng-show="registerId==comment.regstrId||registerId==comment.projTeamLeaderId"
													style="cursor: pointer;">X</span><span class="badge">{{comment.fName}}
														{{comment.lName}}</span> {{comment.projComment}}</li>
											</ul>
											<div>
					<p  ng-repeat="msg in messageteamcomments" style="text-align: center">{{msg}}</p>
				</div>
											<div class="col-md-12" >
												<p style="text-align: center">
						<a href="#" ng-click="viewMoreTeamComments(comment,count=count+1)" id="teamcomments" >View more comments</a>
						
					</p>
											</div>
										</div>
									</div>
								</div>
-->
								
								<div id="techpedia">
		
								<div class="col-md-12" ng-show="Comments.length>0">
									<div class="panelpanel-warning"style="border:0;">
										<div class=" panel-heading"
												style="border: 0; background-color: #2d2d2d; font-size:15px;font-family: Corbel;font-weight:bold;color: white; margin-top: -6px;margin-left: -15px;">Team
												Comments</div>
										<div class="panel-body">
											<ul class="list-group">
												
												<!-- <span
													class="badge" ng-click="deletePublicComment(comment,'team')"
													style="cursor: pointer;">X
												</span>-->
												<li class="list-group-item" ng-repeat="comment in Comments">
												<span
													class="badge" ng-click="deleteChallengeComment(comment)"
													ng-show="registerId==comment.regstrId||registerId==comment.challengUserId"
													style="cursor: pointer;">X
												</span>
										
												<span class="badge">{{comment.fName}}{{comment.mName}}</span>
												{{comment.challengeComment}}
												</li>
											</ul>
											<div  
					>
					<p  ng-repeat="msg in messagepubliccomments" style="text-align: center">{{msg}}</p>
				</div>
											<div class="col-md-12" >
												<p style="text-align: center">
						<a href="#" ng-click="viewMoreComments(comment,count=count+1)" id="publiccomments">View more comments</a>
						
					</p>
											</div>
											
											
									</div>
								</div>	
										</div> 
										
											<div class="col-md-12" ng-show="publicComments.length>0">
										<div class="panelpanel-warning" style="border: 0;">
											<div class=" panel-heading"
												style="border: 0; background-color: #E8E8E8;font-size:15px;font-family: Corbel;font-weight:bold; color: black">Public
												Comments</div>
											<div class="panel-body">
											<ul class="list-group">
												
												<!-- <span
													class="badge" ng-click="deletePublicComment(comment,'team')"
													style="cursor: pointer;">X
												</span>-->
												<li class="list-group-item" ng-repeat="comment in Comments">
												<span
													class="badge" ng-click="deleteChallengeComment(comment)"
													ng-show="registerId==comment.regstrId||registerId==comment.challengUserId"
													style="cursor: pointer;">X
												</span>
										
												<span class="badge">{{comment.fName}}{{comment.mName}}</span>
												{{comment.challengeComment}}
												</li>
											</ul>
												<div>
													<p ng-repeat="msg in messagepubliccomments"
														style="text-align: center">{{msg}}</p>
												</div>
												<div class="col-md-12">
													<p style="text-align: center">
														<a href="#"
															ng-click="viewMorePublicComments(comment,count=count+1)"
															id="publiccomments">View more comments</a>

													</p>
												</div>


											</div>
										</div>
									</div>
										
										
										<div class="col-md-12">
									<div class="input-group">
										<span class="input-group-addon" style="height:48px">Comment:</span> <input type="text" ng-model="teamComment" id="commet"
											class="form-control" placeholder="Comment" style="height:48px !important;"><span class="input-group-addon" style="height:48px">

												<button class="btn btn-info " style="background-color:#709FDD;border-color:#709FDD;" ng-click="postpublicComment(teamComment,-1)">Post</button></span>

											
<%-- 											<button class="btn btn-info" ng-hide="$scope.registerId==<%=session.getAttribute("id") %>" ng-click="postComment(teamComment)">Post</button></span> --%>
									</div>
									<%-- <div class="input-group"  ng-hide="$scope.registerId==<%=session.getAttribute("id") %>">
										<span class="input-group-addon" style="height:48px">Comment:</span> <input type="text" ng-model="teamComment" id="commet"
											class="form-control" placeholder="Comment" style="height:48px !important;"><span class="input-group-addon" style="height:48px">

												<button class="btn btn-info" ng-show="$scope.registerId==<%=session.getAttribute("id") %>" ng-click="postpublicComment(teamComment,-1)">Post public</button></span>

											
											<button class="btn btn-info" style="background-color:#709FDD;border-color:#709FDD;" ng-click="postComment(teamComment)">Post</button></span>
									</div> --%>
								</div>
													
							</div>
								
								</div>
							</div>
						</div>
			
					<div class="clearfix"></div>
					<!-- END CONTAINER
BEGIN FOOTER -->

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

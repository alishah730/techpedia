<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
<head>

<script src="https://apis.google.com/js/platform.js" async defer>  </script>
<script>

      {"parsetags": "explicit"}

  </script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="https://platform.linkedin.com/in.js" type="text/javascript">
	lang: en_US
</script>

<style type="text/css">
#share-block ul, #share-block
h5 {
	display: none
}

#share-block ul.display-ie, #share-block h5.display-ie {
	display: block
}

@media screen and (min-width: 1280px) {
	#share-block ul, #share-block
h5 {
		display: block
	}
}

#share-block, #dontHide {
	position: fixed;
	left: 0;
	/* top: 47%; */
	/* 	//background-color: #FFF; */
	border-top-right-radius: 2px;
	border-bottom-right-radius: 2px;
	/* box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2); */
	text-align: left;
	z-index: 6000;
	top: 47%;
}

#share-block
h5 {
	margin: 0;
	border-bottom-right-radius: 2px;
	box-sizing: border-box;
	font-weight: normal;
	background-color: #e8e9eb;
	text-align: center;
	position: relative;
	font-size: 11px
}

#share-block h5
a.shareHide {
	padding: 6px;
	display: block;
	box-sizing: border-box;
	width: 100%;
	height: 100%;
	text-decoration: none;
	color: #777
}

#share-block h5 a.shareHide:hover {
	cursor: pointer;
	color: #444
}

#share-block h5.display-ie {
	padding-top: 2px
}

#share-block
li {
	height: 32px;
	width: 32px;
	margin: 8px;
	text-indent: -9999px;
	overflow: hidden
}

.row {
	margin-right: -1px;
	margin-left: -1px;
}

.line {
	border-top: 1px solid #a9a9a9;
	margin-top: -10px;
	width: 770px;
	margin-right: 15px;
}

.side {
	border-top: 1px solid #a9a9a9;
	margin-top: 1px;
	margin-bottom: 5px;
}

.inside {
	font-size: 12px;
	font-family: Arial;
	margin-bottom: 10px;
}

.font_divs {
	font-size: 15px;
	font-family: Corbel;
	font-weight: bold;
}
</style>

</head>
<body style="background-color: #3f94ae">
	<div id="facebook">

		<!-- facebook comments code starts here -->

		<div id="fb-root"></div>
		<script>
										(
														function(d, s, id) {
															var js, fjs = d
																	.getElementsByTagName(s)[0];
															if (d
																	.getElementById(id))
																return;
															js = d
																	.createElement(s);
															js.id = id;
															js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.5";
															fjs.parentNode
																	.insertBefore(
																			js,
																			fjs);
														}
																(
																		document,
																		'script',
																		'facebook-jssdk'));
									</script>
	</div>
	

	<div class="clearfix"></div>
	<div class="container customFont borderRadius style">
		<div class="page-container">
			<div class="page-sidebar-wrapper">
				<%-- <jsp:include page="template/dashboardMenu.jsp"></jsp:include> --%>
			</div>
			<div class="page-content-wrapper" ng-controller="ProjectDetail"
				ng-init="InitLoad()" style="text-align: justify;">
				<%
						String projrgstrid = String.valueOf((Long) session.getAttribute("id"));
					%>
				<div class="page-content">
					<!-- <link rel="canonical" href="{{urlLinkedIn}}" /> -->
					<img src="images/banner_project.jpg" class="img-responsive"
						style="width: 100%; hegiht: 25%;">

					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN PAGE TITLE & BREADCRUMB-->
							<h3 class="page-title">
								<i class="	fa fa-server" id="icon-size"
									style="border: 0;; font-size: 15px; font-family: Corbel; font-weight: bold; color: black"></i>
								Projects Details
								<!-- <small>dashboard & statistics</small> -->
							</h3>
							<ul class="page-breadcrumb breadcrumb"
								style="background-color: #FAFAF7;">
								<%
										if (session.getAttribute("username") != null) {
									%>

								<li><a href="./">Home&nbsp;</a><font
									style="color: black; font-size: 18px;">&raquo;</font> <a
									href="dashboard">Dashboard&nbsp;</a><font
									style="color: black; font-size: 18px;">&raquo;</font> <a
									href="project">Projects&nbsp;</a><font
									style="color: black; font-size: 18px;">&raquo;</font>

									{{projectdetails.projTitle}}</li>
								<!-- <li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li> -->
								<%
										} else {
									%><li><a href="./">Home&nbsp;</a> <font
									style="color: black; font-size: 18px;">&raquo;</font> <a
									href="project">Projects&nbsp;</a><font
									style="color: black; font-size: 18px;">&raquo;</font>

									{{projectdetails.projTitle}}</li>
								<%
										}
									%>
							</ul>
							<!-- END PAGE TITLE & BREADCRUMB-->
						</div>
					</div>

					<div class="clearfix"></div>


					<%
							if (session.getAttribute("username") != null) {
						%>
					<!-- 	<div class="col-md-8" ng-show="doesFollow">
						<a style="cursor: pointer; margin-right: 950px;" class="btn btn-info add" ng-click="follow()">Follow</a><br>
						<br>
					</div>

					<div class="col-md-8" ng-show="doesFollow">
						<a style="cursor: pointer; margin-right: 950px;" class="btn btn-info add" ng-click="unfollow()">Unfollow</a><br>
						<br>
					</div> -->

					<div class="col-md-12 pull-right" style="padding-bottom: 5px;"
						ng-switch on="doesFollow">
						<div class="col-md-12 pull-right" ng-switch-when="true">
							<a
								style="cursor: pointer; background-color: #709FDD; border-color: #709FDD;"
								class="btn btn-info btn-sm accept-style pull-right"
								ng-click="unfollow()">Unfollow</a><br>
						</div>
						<div class="col-md-12 pull-right" ng-switch-when="false">
							<a
								style="cursor: pointer; background-color: #709FDD; border-color: #709FDD;"
								class="btn btn-info btn-sm accept-style pull-right"
								ng-click="follow()">Follow</a><br>
						</div>
						<div class="col-md-12 pull-right" ng-switch-default>
							<a
								style="cursor: pointer; background-color: #709FDD; border-color: #709FDD;"
								class="btn btn-info btn-sm accept-style pull-right"
								ng-click="follow()">follow</a>
						</div>
					</div>

					<%
							}
						%>
					<!-- <img src="{{projectdetails.projImage}}" data-thumb="" alt="" /> -->

					<div class="col-xs-12 col-md-9">
						<!-- <div class="panel-heading"
							style="border: 0;; font-size: 15px; font-family: Corbel;; font-weight: bold; color: black">
							PROJECT DESCRIPTION</div>
						<hr class="line"> -->

						<%-- <div style="margin:10px;padding:5px;display:block!important;min-height:170px!important;">
							<img src="${pageContext.request.contextPath}/image/{{projectdetails.photo1Path ||'E:/Techpedia/Project/UploadedDocuments/ProjectImages/defaultImage/placeholder.png'}}" class="img-responsive" align="left" style="padding-right: 10px;height:176px !important;width:274px !important;">
							<span style="font-size:12px;font-family: Arial; text-align: justify;
    text-justify: inter-word;">{{projectdetails.projDescription}}</span> 		
						</div> --%>
						<div class="panel-heading"
							style="font-size: 15px; font-family: Corbel; font-weight: bold; color: black; display: block !important;">PROJECT
							ABSTRACT</div>
						<hr class="line">
						<div style="margin: 10px; padding: 5px;">

							<span
								style="font-size: 12px; font-family: Arial; text-align: justify; text-align: justify;">{{projectdetails.projAbstract}}</span>
							<img
								src="${pageContext.request.contextPath}/image/{{projectdetails.photo2Path ||'/usr/Techpedia/Project/placeholders/placeholder.png'}}"
								class="img-responsive"
								style="margin: 5px; height: 233px !important; width: 806px !important;">
						</div>



					</div>

					<div class="col-xs-12 col-md-3">
						<div
							style="font-size: 15px; font-family: Corbel; font-weight: bold; margin-top: 10px;">PROJECT
							BASIC INFORMATION</div>
						<hr class="side">
						<div style="background-color: #d3d3d3; padding: 20px;">
							<div class="font_divs">Project Start Date</div>
							<hr class="side">
							<div class="inside">{{projectdetails.projStartDate}}</div>

							<div class="font_divs">Team Members</div>
							<hr class="side">
							<div class="inside">
								<div ng-repeat="member in projectdetails.projTeamMemberList">
									<div>
										<a href="studentDetails{{member[0]}}" target="_blank">{{member[1]}}
											{{member[2]}} {{member[3]}}</a>
									</div>
								</div>
							</div>
							<div ng-show="projectMentorList.length>0">
								<div class="font_divs">Mentor</div>
								<hr class="side">
								<div class="inside">
									<div ng-repeat="mentor in projectMentorList">
										<div>
											<a href="mentorDetails{{mentor.rgstrId}}" target="_blank">{{mentor.fName}}
												{{mentor.mName}} {{mentor.lName}}</a>
										</div>
									</div>
								</div>
							</div>

							<div class="font_divs">Duration</div>
							<hr class="side">
							<div class="inside">{{projectdetails.projDuration}}&nbsp;Months</div>

							<div class="font_divs">Branch</div>
							<hr class="side">
							<div class="inside">
								<class
									="header-customize" ng-repeat="branch in projectdetails.projBranchList">
								{{branch.projBranchDesc}} 
							</div>
							<div ng-show="projectdetails.projFacultyName.length>0">
								<div class="font_divs">Faculty</div>
								<hr class="side">
								<div class="inside">
									<a href="facultyDetails{{projectdetails.projFaculty}}"
										target="_blank">{{projectdetails.projFacultyName}}</a>
								</div>
							</div>

						</div>

						<%
								if (session.getAttribute("id") != null) {
							%>

						<div
							style="background-color: #d3d3d3; padding: 20px; margin-top: 10px;">
							<div style="border: 0; color: black;">
								Document list <span ng-show="deletedocmessage.length>0"
									style="float: right" ng-repeat="msg in deletedocmessage">{{msg}}</span>
							</div>
							<div>
								<span
									ng-hide="(projectdetails.projTeamLeaderId==<%=projrgstrid%>|| document.regstrId==<%=projrgstrid%>||projectdetails.projFaculty==<%=projrgstrid%>||doesFollow==true || teamMember==true)">
									Documents can be viewed only by project members, faculty of the
									project and users following the project.</span></br>
								<div>
									<span style="background-color: #d3d3d3;"
										ng-repeat="document in projectDocumentList"
										ng-show="(projectdetails.projTeamLeaderId==<%=projrgstrid%>|| document.regstrId==<%=projrgstrid%>||projectdetails.projFaculty==<%=projrgstrid%>||doesFollow==true || teamMember==true)">{{document.docName}}</br>
										<a ng-click="downloadDocumentLink(document)"
										class="btn btn-sm btn-info"
										ng-show="(projectdetails.projTeamLeaderId==<%=projrgstrid%>|| document.regstrId==<%=projrgstrid%>||projectdetails.projFaculty==<%=projrgstrid%>||doesFollow==true || teamMember==true)">Download</a>
										<button ng-click=deleteDocument(document)
											ng-show="(projectdetails.projTeamLeaderId==<%=projrgstrid%>|| document.regstrId==<%=projrgstrid%>)&& !(projectdetails.projStatusId==4)"
											ng-click="datarefresh()" class="btn btn-sm btn-info">Delete</button>
										<hr class="side"></span>
								</div>
							</div>



						</div>
						<%
								}
							%>


					</div>

					<!-- <script type="text/javascript"
						src="http://platform.twitter.com/widgets.js"></script> -->

					<!--<div id="twtbox"></div>-->
					<!-- <div style="top: 47%;">
						<div id="share-block">

							<div>
								<a href="http://twitcount.com/btn" class="twitcount-button"
									data-count="horizontal" data-size="" data-url="{{urlLinkedIn}}"
									data-text="Entre your message here" data-related="Project"
									data-hashtag="Techpedia" data-via="techpedia_in">Tweet </a>
							</div>
							<script type="text/javascript"
								src="http://static1.twitcount.com/js/button.js"></script>



							<!-- <div id="twtbox"></div>
							<br>
							<script type="IN/Share" data-url=" {{urlLinkedIn}}"
								data-counter="right">

					   </script>
							<br>
							<g:plus action="share" annotation="bubble"></g:plus>
							<br>

							<div class="fb-share-button"
								data-href="http://techpedia.sristi.org/"
								data-layout="button_count"></div>
							<br>
							<div class="fb-like" data-href="{{urlLinkedIn}}"
								data-layout="button_count" data-action="like"
								data-show-faces="true" data-share="true"></div>
							<!-- <div class="g-plusone" data-href="https://www.facebook.com"></div> -->

							<!-- <div id="content">
							<div class="g-plusone"></div>
						</div>
						<script>
     							 gapi.plusone.go("content");
   						 </script>



							<script>
						window.twttr = (function(d, s, id) {
							var t, js, fjs = d.getElementsByTagName(s)[0];
							if (d.getElementById(id))
								return;
							js = d.createElement(s);
							js.id = id;
							js.src = "https://platform.twitter.com/widgets.js";
							fjs.parentNode.insertBefore(js, fjs);
							return window.twttr || (t = {
								_e : [],
								ready : function(f) {
									t._e.push(f)
								}
							});
						}(document, "script", "twitter-wjs"));
					</script>
							<script type="text/javascript">
						var link = document.createElement('a');
						link.setAttribute('href', 'https://twitter.com/share');
						link.setAttribute('class', 'twitter-share-button');
						link.setAttribute('style', 'margin-top:5px;');
						link.setAttribute('id', 'twitterbutton');
						link.setAttribute("data-text",
								"Entre your message here");
						link.setAttribute("data-via", "techpedia_in");
						link.setAttribute("data-size", "default");
						link.setAttribute("data-url", document.URL);
						link.setAttribute("data-hashtags", "Techpedia");
						link.setAttribute("data-count", "horizontal");

						var tweetdiv = document.getElementById('twtbox');
						tweetdiv.appendChild(link);

						twttr.widgets.load(); //very important
					</script>
							<script>
						$(document).ready(function() {

							$(".shareHide").click(function(e) {
								$("#share-block").toggle(500);
								$("#faAwesome").toggleClass("fa-rotate-270")
								$.get("/shareblock-disable");
							});
						});
					</script>


						</div>
						<br>
						<div style="clear: both;"></div>
						<div id="dontHide" style="margin-top: 10%">

							<a class="shareHide"> <i id="faAwesome"
								class="fa fa-share-alt-square fa-3x"></i>
							</a>

						</div>

					</div> -->



					<!--<script type="IN/Share" data-url=" {{urlLinkedIn}}"
						data-counter="right"> </script>-->










					<!-- <script type="text/javascript">
						$( window ).load(function() {
							
							    console.log( "ready!" );
							    var url=document.URL;
							});
						</script>
 -->





					<div class="row">

						<!-- 	codes for tab menu for comments strats here  -->


						<div class="col-md-12 left-border">


							<div
								style="border: 0; font-size: 15px; font-family: Corbel; font-weight: bold; color: black">COMMENTS
							</div>
							<hr class="side">

							<script type="text/javascript">
								$(document)
										.ready(function() {
											$("#techpedia").show();
											$("#facebook").hide();
											$('.fb-comments').hide();
											$("#fb").click(function() {
												$("#techpedia").hide();
												$("#techHeading").hide();
												$("#fbHeading").show();
												$("#facebook").hide();
												$('.fb-comments').show();
											});

											$("#tech").click(function() {
												$("#techHeading").show();
												$("#fbHeading").hide();
												$("#techpedia").show();
												$("#facebook").hide();
												$('.fb-comments').hide();
												
											});
										})
							</script>
							<div class="panel-body">
								<button style="background-color: #2d2d2d; border: none;">
									<img id="tech" class="img-responsive" src="images/TPlogo.jpg"
										alt="" />
								</button>
								<button
									style="background-color: #306199; border: none; margin-left: -2px;">
									<img id="fb" class="img-responsive" src="images/FBlogo.jpg"
										alt="Facebook" />
								</button>

								<!-- <div class="alert alert-info" role="alert" ng-show="message.length>0"
									ng-repeat="msg in message">{{msg}}</div>
									
								<div>-->

								<div class=" panel-heading" id="fbHeading"
									style="font-size: 15px; font-family: Corbel;  display:none; font-weight: bold; background-color: #306199; font-color: white; margin-top: -6px; color: white">Facebook
									Comments</div>
								<div class=" panel-heading" id="techHeading"
									style="font-size: 15px; font-family: Corbel; font-weight: bold; background-color: #333; font-color: white; margin-top: -6px; color: white">Techpedia
									Comments</div>
								<div class="fb-comments"
									data-href="http://localhost:8080/techpedia/projectDetails{{projectdetails.projId}}"
									data-width="1072" data-numposts="5"></div>





								<!-- facebook comments code ends here -->

							</div>

							<div id="techpedia">

								<div class="col-md-12" ng-show="teamComments.length>0">
									<div class="panel panel-warning" style="border: 0;">
										<div class=" panel-heading"
											style="border: 0; background-color: #2d2d2d; font-size: 15px; font-family: Corbel; font-weight: bold; color: white; margin-top: -6px; margin-left: -15px;">Team
											Comments</div>
										<div class="panel-body">
											<ul class="list-group">
												<li class="list-group-item"
													ng-repeat="comment in teamComments"><span
													class="badge" ng-click="deleteComment(comment,'team')"
													ng-show="registerId==comment.regstrId||registerId==comment.projTeamLeaderId"
													style="cursor: pointer;">X</span><span class="badge">{{comment.fName}}
														{{comment.lName}}</span> {{comment.projComment}}</li>
											</ul>
											<div>
												<p ng-repeat="msg in messageteamcomments"
													style="text-align: center">{{msg}}</p>
											</div>
											<div class="col-md-12">
												<p style="text-align: center">
													<a href="#"
														ng-click="viewMoreTeamComments(comment,count=count+1)"
														id="teamcomments">View more comments</a>

												</p>
											</div>
										</div>
									</div>
								</div>
								<!-- techpedia comments code starts here -->
								<div class="col-md-12" ng-show="publicComments.length>0">
									<div class="panelpanel-warning" style="border: 0;">
										<div class=" panel-heading"
											style="border: 0; background-color: #E8E8E8; font-size: 15px; font-family: Corbel; font-weight: bold; color: black">Public
											Comments</div>
										<div class="panel-body">
											<ul class="list-group">
												<li class="list-group-item"
													ng-repeat="comment in publicComments"><span
													class="badge"
													ng-click="deletePublicComment(comment,'team')"
													ng-show="registerId==comment.regstrId||registerId==comment.projTeamLeaderId"
													style="cursor: pointer;">X</span><span class="badge">{{comment.fName}}
														{{comment.lName}}</span> {{comment.projComment}}</li>
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

								<div class="col-xs-12">
									<div
										ng-show="$scope.registerId==<%=session.getAttribute("id")%>">

										<div class="col-xs-12">
											<div class="col-xs-2 "
												style="height: 48px; background-color: #E8E8E8; padding-top: 17px;">Comment:</div>
											<div class="col-xs-10"
												style="padding-left: 0px; padding-right: 0px;">

												<input type="text" ng-model="teamComment" id="commet"
													class="form-control" placeholder="Comment"
													style="height: 48px !important;">
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-xs-12">
											<div class="col-xs-12 form-control "
												style="height: 85px !important">
												<div class="col-xs-4"
													style="padding-left: 0%; padding-right: 0%">
													<img src="jcaptcha.jpg" id="captcha_image"
														style="box-shadow: 0 0 2em #b2b2b2;" />
												</div>
												<div class="col-xs-4" style="margin-left: -120px;">
													<div class="col-xs-12">
														<a href="" onclick="reloadCaptcha()" alt="reload"><i
															style="" class="fa fa-refresh fa-2x"></i></a> <span
															style="color: red" role="alert"
															ng-show="messageerrorCaptcha.length>0"
															ng-repeat="msg in messageerrorCaptcha"><i
															class="fa fa-exclamation-triangle"></i> <strong>Invalid
																Captcha!</strong>&nbsp;Please Try Again... </span>
													</div>

													<div class="col-xs-12">
														<input class="form-control"
															placeholder="Enter the text here" type="text"
															name="jcaptcha" value="" ng-model="jCaptcha"
															style="width: 100%; margin-top: 8px" />
													</div>


												</div>
												<div class="col-xs-4">
													<button class="btn btn-info"
														style="background-color: #709FDD; border-color: #709FDD; margin-left: 164px; margin-top: 40px;"
														ng-click="postpublicComment(teamComment,-1,jCaptcha)"
														ng-disabled="(!jCaptcha) ||(!teamComment)">Post
														public</button>
												</div>
											</div>
										</div>
									</div>

								</div>




								<div class="input-group"
									ng-hide="$scope.registerId==<%=session.getAttribute("id")%>">
									<span class="input-group-addon" style="height: 48px">Comment:</span>
									<input type="text" ng-model="teamComment" id="commet"
										class="form-control" placeholder="Comment"
										style="height: 48px !important;"><span
										class="input-group-addon" style="height: 48px"> <%-- 												<button class="btn btn-info" ng-show="$scope.registerId==<%=session.getAttribute("id") %>" ng-click="postpublicComment(teamComment,-1)">Post public</button></span> --%>
										<button class="btn btn-info"
											style="background-color: #709FDD; border-color: #709FDD;"
											ng-click="postComment(teamComment)">Post</button></span>
								</div>
							</div>

						</div>
						<div class="clearfix"></div>
						<div class="alert alert-info" role="alert"
							ng-show="message.length>0" ng-repeat="msg in message">{{msg}}</div>
						<div class="alert alert-success" role="alert"
							ng-show="messagesuccess.length>0"
							ng-repeat="msg in messagesuccess">{{msg}}</div>

					</div>


					<div class="clearfix"></div>

					<!-- techpedia comments code ends here -->



					<!-- END CONTAINER
BEGIN FOOTER -->

				</div>
			</div>
		</div>
	</div>
	</div>

	<div class="modal fade bs-modal-sm" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" style="padding-bottom: 10px" class="close"
						data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>

				</div>
				<div class="bs-example bs-example-tabs">
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#signin" data-toggle="tab">Sign
								In</a></li>
						<li class=""><a href="#signup" data-toggle="tab">Forgot
								Password</a></li>

					</ul>
				</div>
				<div class="modal-body">
					<div id="myTabContent" class="tab-content">

						<div class="tab-pane fade active in" id="signin">
							<form id="login-form" method="post">
								<fieldset>
									<!-- Sign In Form -->
									<!-- Text input-->
									<div class="control-group">
										<label class="control-label" for="userid">Username:</label>
										<div class="controls">
											<input id="username" name="username" type="text"
												class="form-control" placeholder="username"
												class="input-medium" required="required">
										</div>
									</div>

									<!-- Password input-->
									<div class="control-group">
										<label class="control-label" for="passwordinput">Password:</label>
										<div class="controls">
											<input id="password" name="password" class="form-control"
												type="password" placeholder="password" class="input-medium">
										</div>
									</div>

									<!-- Multiple Checkboxes (inline) -->
									<div class="control-group">
										<label class="control-label" for="rememberme"></label>
										<div class="controls">
											&nbsp;&nbsp;&nbsp; <label class="checkbox inline"
												for="rememberme-0"> <input type="checkbox"
												name="rememberme" id="rememberme-0" value="Remember me" />Remember
												me
											</label>
										</div>
									</div>

									<!-- Button -->
									<div class="control-group">
										<label class="control-label" for="signin"></label>
										<div class="controls">
											<input type="submit" class="btn btn-success"
												id="login-submit" value="Login" />
											<div id="login-error-div" style="color: red;"></div>
										</div>
									</div>

								</fieldset>
							</form>
						</div>
						<div class="tab-pane fade" id="signup">
							<form class="form-horizontal" method="post">
								<fieldset>

									<div class="control-group">
										<label class="control-label" for="Email">Please enter
											your registered Email:</label>
										<div class="controls">
											<input id="email" name="email" class="form-control"
												type="text" placeholder="xyz@abc.com" class="input-large"
												required="required">
											<div id="forgot-password-div" style="color: red;"></div>
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="confirmsignup"></label>
										<div class="controls">
											<input type="submit" name="submit" class="btn btn-success"
												value="Submit" id="forgot-password" />
										</div>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
<script type="text/javascript" src="http://s7.addthis.com/js/300/addthis_widget.js#pubid=ra-57022f2ba93cd1ba"></script>
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
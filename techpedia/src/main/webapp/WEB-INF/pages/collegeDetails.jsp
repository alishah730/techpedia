<%@page import="java.util.ArrayList"%>
<html ng-app="techpedia">

<head>
<style>
.animate_div {
	display: inline-block;
}

.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none;
}

.paginationclass {
	margin: 15px 28px;
}

.paginationclass div {
	border-bottom: 1px solid silver;
}

.paginationclass span {
	margin: 0px 15px;
	display: inline-block;
	padding: 5px 0px;
	text-align: left;
	width: 70px;
}

.pagination-controle li {
	display: inline-block;
}

.pagination-controle button {
	width: 63px;
	font-size: 12px;
	margin-left: 13px;
	cursor: pointer;
}

.pagination-div {
	margin-left: 20px;
}
</style>
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

.line {
	border-top: 1px solid #a9a9a9;
	margin-top: 0px;
	width: 770px;
	margin-right: 15px;
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
</style>
</head>
<jsp:include page="template/NewHeader.jsp" />
							<%
							String collegeName = (String)session.getAttribute("collegeName");
							%>
<img src="images/collegeDetailsBanner.jpg" class="img-responsive"
	style="height: 250px; width: 100%;">

<div class="customFont" style="background-color: #d3d3d3;">
	<div class="col-md-12" style="background-color: #217690;">
		<div class="col-xs-12 col-md-8"
			style="background-color: #217690;margin-left: 200px; margin-right: 200px;">
			<h3 class="page-title"
				style="color: white; font-weight: 700; font-size: 20px;">
				<span class="line-center" style="background-color: #217690;"><%-- ${collegeName} --%><%=collegeName%></span>
			</h3>
		</div>
	</div>
	<div class="container customFont borderRadius style"
		style="background-color: #d3d3d3;"
		ng-controller="CollegeDetailsController" ng-init="InitLoad(<%-- '${collegeName}' --%>'<%=collegeName%>')">
		<div class="row">
			<div class="page-container">
				<div class="page-sidebar-wrapper"></div>

				<div class="page-content-wrapper">
					<div class="page-content">

						<div class="row">
							<div class="container customFont borderRadius style"
								style="background-color: white; height: 85px;">
								<!-- BEGIN PAGE TITLE & BREADCRUMB-->

								<ul class="page-breadcrumb breadcrumb"
									style="background-color: white;">
									<%
										if (session.getAttribute("username") != null) {
									%>
									<li><a href="./">Home&nbsp;</a><font
										style="color: black; font-size: 18px;">&raquo;</font></li>
									<li><a href="dashboard">Dashboard&nbsp;</a><font
										style="color: black; font-size: 18px;">&raquo;</font></li>
									<li><a href="colleges">Colleges&nbsp;</a><font
										style="color: black; font-size: 18px;">&raquo;</font></li>
									<li><%-- ${collegeName} --%><%=collegeName%></li>

									<!-- <li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li> -->
									<%
										} else {
									%><li><a href="./">Home&nbsp;</a><font
										style="color: black; font-size: 18px;">&raquo;</font></li>
									<li><a href="colleges">Colleges&nbsp;</a><font
										style="color: black; font-size: 18px;">&raquo;</font></li>
									<li><%-- ${collegeName} --%><%=collegeName%></li>
									<%
										}
									%>
								</ul>

							</div>
						</div>
						<div class="clearfix"></div>
						<div class="row">
							<div class="container customFont borderRadius style"
								style="background-color: white;">
								<div class="col-xs-12 col-md-8">
									<div class="col-xs-12" style="background-color: white;">
									<%-- <%
										String collegeName = (String) request.getParameter("collegeName");
									%> --%>
										<!-- <h5 class="heading1">IIT Delhi</h5> -->
										<div
											style="color: black; font-family: Corbel; font-size: 18px; font-weight: bold;" ><%-- ${collegeName} --%><%=collegeName%></div>
										<hr class="line">

										<p class="next" align="justify"
											style="font-family: Arial Regular; font-size: 16px;">
											
											 <span style="color: #1c9cc3; font-size: 14px;">{{firstWord}}</span>
											{{restData}}
										</p>
										
									</div>



									<div class="col-xs-12"
										style="background-color: white; width: 762px;">
										<a ng-click="recentProjectVisibility()"><div style="color: black; font-family: Corbel; font-size: 18px; font-weight: bold;">LATEST
												PROJECTS</div></a>
										<hr class="line">

										<!-- <div class="row row-centered" id="recentProjects" style="width:700px;display:none;margin-left: auto;margin-right: auto; float: none;"> -->
										<div ng-init="showProjectData()">
										<ul>
										
											<li class="col s12"  
												style="display: inline-block; height: 215px; padding-top: 10px; align: center; margin-left: 20px; margin-right: 10px; width: 180px; margin-bottom: 5px; margin-top: 5px; background-color: #3f94ae;"
												ng-repeat="project in recentprojects | filter:filterSearch  | pagination : currentPage*itemsPerPage | limitTo: itemsPerPage">


												<img
													src="${pageContext.request.contextPath}/image/{{project.photo1Path ||'/usr/Techpedia/Project/placeholders/placeholder.png'}}"
													class="fourimage" alt="" width="150px" height="100px" style="margin-left: 15px;" />
												<p
													style="font-size: 15px; font-weight: bold; color: #ffffff; font-family: Corbel; text-align: center;">{{project.projTitle}}</p>
												<hr>
												<a class="btn btn-success btn-responsive"
													style="align: center; margin-left:35px; text-align: center;"
													ng-click="viewProject(project)" href=""><i
													class="fa fa-book fa-fw"></i>&nbsp;Read More</a>
												<div class="col-xs-12">&nbsp;</div>
											</li>
										</ul>

											
										</div>

										<div style="text-align: center;"
											ng-show="recentprojects.length==0">
											<p>
												<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
											</p>
											<p>Sorry, There are no projects.....</p>
										</div>

										<!-- </div> -->
										<!-- <hr style="background-color:black;color:black"/>  -->
										<ul class="next" align="justify"
											style="list-style-type: none;">

										</ul>
									</div>
									
									<div class="pagination-div pull-center">
												{{pageCount}}
												<ul class="pagination">
													<li ng-class="DisablePrevPage()"><a href
														ng-click="prevPage()"><i class="fa fa-backward"></i>&nbsp;Prev</a></li>
													<li ng-repeat="n in range()"
														ng-class="{active: n == currentPage}"
														ng-click="setPage(n)"><a href="#">{{n+1}}</a></li>
													<li ng-class="DisableNextPage()"><a href
														ng-click="nextPage()">Next&nbsp;<i
															class="fa fa-forward"></i></a></li>
												</ul>

											</div>


									<div class="col-xs-12"
										style="display: inline-block; background-color: #ffffff; width: 762px; height: 510px;">
										<div
											style="color: black; font-family: Corbel; font-size: 18px; font-weight: bold;">FACULTY</div>
										<hr class="line">
										<div ng-init="showData()">
										<ul style="list-style-type: none;">
											<li
												ng-repeat="faculty in faculties | filter:filterSearch  | pagination : currentPage1*itemsPerPage1 | limitTo: itemsPerPage1"
												class="col-xs-12"
												style="height: 215px; padding-top: 10px; align: center; margin-left: 20px; margin-right: 10px; width: 180px; margin-bottom: 5px; margin-top: 5px; background-color: #3f94ae;">

												<img
													src="${pageContext.request.contextPath}/image/{{faculty.photoPath}}"
													ng-show="faculty.photoPath!= null" class="fourimage" alt=""
													width="150px" height="100px" /> <img
													src="images/gravatar.png"
													ng-show="faculty.photoPath== null" class="fourimage" alt=""
													width="150px" height="100px" />
												<p
													style="font-size: 15px; font-weight: bold; color: #ffffff; font-family: Corbel; text-align: center;">{{faculty.facultyName}}</p>
												<hr>
												<a class="btn btn-success btn-responsive"
													style="align: center; margin-left: 18px; text-align: center;"
													ng-click="viewFaculty(faculty)" href=""><i
													class="fa fa-book fa-fw"></i>&nbsp;Read More</a>


											</li>
										</ul>
											
										</div>
										
									<div style="text-align: center;"
											ng-show="faculties.length==0">
											<p>
												<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
											</p>
											<p>Sorry, There are no Faculties.....</p>
										</div>
										<!-- <div class="col-xs-12" style="height:180px;padding-top:10px; align:center;margin-left:20px; margin-right:10px; width:200px;margin-bottom:5px;margin-top:5px;background-color: #3f94ae;" >
							
										
										<img src="images/DR_raghuNath.png" class="fourimage" alt="" width="150px" height="100px" />
										<p style="font-size:15px;font-weight:bold; color:#ffffff;font-family: Corbel ;text-align:center;">DR RaghuNath</p> 
										
									
										 
						  </div>
						  <div class="col-xs-12" style="height:180px;padding-top:10px; align:center;margin-left:20px; margin-right:10px; width:200px;margin-bottom:5px;margin-top:5px;background-color: #3f94ae;" >
							
										
										<img src="images/DR_raghuNath.png" class="fourimage" alt="" width="150px" height="100px" />
										<p style="font-size:15px;font-weight:bold; color:#ffffff;font-family: Corbel ;text-align:center;">DR RaghuNath</p> 
										
									 
										 
						  </div> -->
									</div>

 							<div class="pagination-div pull-center">
								{{pageCount}}
								<ul class="pagination faculty">
									<li ng-class="DisablePrevPage1()"><a href
										ng-click="prevPage1()"><i class="fa fa-backward"></i>&nbsp;Prev</a></li>
									<li ng-repeat="n in range1()"
										ng-class="{active: n == currentPage1}" ng-click="setPage1(n)">
										<a href="#">{{n+1}}</a>
									</li>
									<li ng-class="DisableNextPage1()"><a href
										ng-click="nextPage1()">Next&nbsp;<i class="fa fa-forward"></i></a></li>
								</ul>

							</div>


								</div>






								<div class="col-xs-12 col-md-4" style="background-color: white;">
									<div class="col-xs-12">
										<h5 class="heading1"
											style="font-size: 30px; font-family: corbel; color: #262626;">Latest
											News</h5>
										<div class="row-fluid" style="border-style: ridge;">
											<div class="span2"
												style="border-bottom: 2px solid #D0D0D0; margin-left: 10px; margin-right: 10px; margin-top: 10px; margin-bottom: 10px;"
												ng-repeat="news in recentnews">
												<p
													style="font-size: 16px; font-weight: 900px; color: #1c9cc3; font-family: Arial Regular;">{{news.newsHeadline}}</p>
												<p
													style="font-size: 14px; font-weight: 900px; font-family: Arial Regular;">{{news.newsDescription}}</p>
											</div>
											<div style="text-align: center;"
											ng-show="recentnews.length==0">
											<p>
												<i style="" class="fa fa-frown-o fa-3x" aria-hidden="true"></i>
											</p>
											<p>Sorry, There are no news .....</p>
										</div>
											<!--     <div class="span2" style="border-style: ridge;">
			   	Promoting both IPR protected and open source technologies and eventually develop
				techpedia.in into an online virtual incubator. Creating real-time online NMN (National
			    Mentoring Network) to harness skills, insights and experience of senior tech experts for
				mentoring young students.
			    </div>
			    <div class="span2" style="border-style: ridge;">
			   	Promoting both IPR protected and open source technologies and eventually develop
				techpedia.in into an online virtual incubator. Creating real-time online NMN (National
			    Mentoring Network) to harness skills, insights and experience of senior tech experts for
				mentoring young students.
			    </div>
			    <div class="span2" style="border-style: ridge;">
			   	Promoting both IPR protected and open source technologies and eventually develop
				techpedia.in into an online virtual incubator. Creating real-time online NMN (National
			    Mentoring Network) to harness skills, insights and experience of senior tech experts for
				mentoring young students.
			    </div> -->
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
</div>

<!-- END FOOTER -->
<%-- <!-- FOOTER CONTENT BEGIN -->
		<div id="copyright" class="container customFont" style="background-color:#D8D8D8;padding:5px;max-width:1130px;border-radius:5px;margin-top:20px;">
		<div id="footer" ng-controller="FooterController" ng-init="InitLoad()">
	<footer class="row" style="margin-left: 15%">
		<p class="back-top floatright">
			<a href="#top"><span></span></a>
		</p>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<h1 class="footer-title">Mentors</h1>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;" ng-click="viewMentor(mentor)"><img
					src="{{mentor.photo||'images/UserDefault.jpg'}}"
					alt="{{mentor.mentorFirstName}} {{mentor.mentorLastName}}"
					title="{{mentor.mentorFirstName}} {{mentor.mentorLastName}}" width=60 height=60 /></a>
			</div>
		</div>

		<div class="col-xs-12 col-sm-6 col-md-4">
			<h1 class="footer-title">Entrepreneurs</h1>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="${entrepreneurs[0]}" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="${entrepreneurs[1]}" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="${entrepreneurs[2]}" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="${entrepreneurs[3]}" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="${entrepreneurs[4]}" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="${entrepreneurs[5]}" width=60 height=60 />
			</div>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<h1 class="footer-title">Partners</h1>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="${partnersURL[0]}"><img src="${partners[0]}" width=60 height=60 /></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="${partnersURL[1]}"><img src="${partners[1]}" width=60 height=60 /></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="${partnersURL[2]}"><img src="${partners[2]}" width=60 height=60 /></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="${partnersURL[3]}"><img src="${partners[3]}" width=60 height=60 /></a>
			</div>

		</div>
	</footer>

</div>
<div class="copyright">
	<div class="row">
		<div class="col-xs-12">
			&copy;<span class="small"> Copyright 2013 Techpedia</span>
		</div>
	</div>
</div>
</div> --%>
<jsp:include page="template/footer.jsp" />
</body>
<!-- END BODY -->
<script src="js/jquery-ui.js"></script>
<script src="js/angular.min.js"></script>
<script src="js/Controller.js"></script>
<script src="js/swfobject.js"></script>
<script src="js/jquery.FileReader.min.js"></script>
<!-- <script src="js/elasticslideshow.js"></script> -->
<!-- <script src="js/jquery.cycle.js"></script> -->
<!-- <script src="js/slidepanel.js"></script> -->
<!-- <script src="js/responsivemenu.js"></script> -->
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/custom.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/select2.min.js"></script>
<script src="js/script.min.js"></script>
</html>



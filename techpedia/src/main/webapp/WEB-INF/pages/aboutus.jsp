<%@page import="java.util.ArrayList"%>
<html ng-app="techpedia">
<head>
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


<div class="customFont" style="background-color: #d3d3d3;">
	<div class="col-md-12" style="background-color: #217690; height: 75px;">
		<div class="col-xs-12 col-md-8"
			style="background-color: #217690; height: 75px; margin-left: 200px; margin-right: 200px;">
			<h3 class="page-title"
				style="color: white; font-weight: 500; font-size: 40px;">
				<span class="line-center" style="background-color: #217690;">ABOUT
					US</span>
			</h3>
		</div>
	</div>
	<div class="container customFont borderRadius style"
		style="background-color: #d3d3d3;" ng-controller="AboutUsController"
		ng-init="InitLoad()">
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
									<li>About Us</li>

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
									<li>About Us</li>
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
										<!-- <h5 class="heading1">About Us</h5>

					<hr /> -->
										<p class="next" align="justify"
											style="font-family: Arial Regular; font-size: 16px;">
											<span style="color: #1c9cc3; font-size: 14px;">Techpedia,</span>
											an initiative at SRISTI aims at putting the problems of
											micro, small and medium enterprises, informal sector,
											grassroots innovators and other social sectors on the agenda
											of the young technology students across the country. For over
											last sixty years, India has not utilized much the
											technological outputs of millions of students.
										</p>
										<p class="next" align="justify"
											style="font-family: Arial Regular; font-size: 14px;">But
											no more. Can a knowledge society really afford to ignore the
											huge talent distributed in thousands of polytechnics, diploma
											and degree colleges of engineering, pharmacy, medical
											science, agriculture etc.? SRISTI is providing a platform for
											the industry and academic institutions to collaborate,
											co-create and foster distributed and horizontal innovations.
											Most of the ideas mentioned here have been implemented in the
											state of Gujarat in close cooperation with Gujarat Technical
											University and initial results are extremely encouraging.</p>

									</div>

									<div class="col-xs-12"
										style="background-color: white; width: 762px;">

										<br> <br>
										<div class="col-xs-6">
											<br> <br> <br> <br> <img
												src="images/Challenges_Img2.png" class="img-responsive">
										</div>
										<div class="col-xs-6">
											<!-- <h5 class="heading1" style="color:#1c9cc3;font-weight:900;font-size:16px;">Key goals are:</h5> -->

											<ul class="next"
												style="list-style-type: none; font-family: Arial Regular; font-size: 12px;">
												<li class="heading1"
													style="color: #1c9cc3; font-weight: 900; font-size: 16px;">Key
													goals are:</li>
												<br>
												<li>Promotion of originality among technology students
													by making it impossible for them to do what has been done
													before. This will be possible only when they can find out
													what has been done before. Techpedia already has 1.4 lac
													technology projects done by 3.5 lac students from more than
													500 colleges in India.</li>
												</br>
												<li>Connecting the technical students with the problems
													of informal and unorganized sector and grassroots
													innovators.</li>
												</br>
												<li>Putting the technical problems of MSMEs on the
													agenda of students so that affordable solutions can be
													generated in a real time.</li>
												</br>
												<li>To harness collaborative potential of students
													across disciplines and colleges to solve persistent
													problems of our country in formal and informal sector.</li>
												</br>
												<li>Explore kho kho model (relay) of product
													development. Idea here is that if one student group has
													brought the solution of a particular problem to a specific
													stage, then next group within that department or somewhere
													else should be able to build upon it to take it forward.</li>
												</br>
											</ul>
										</div>
									</div>
									<div class="col-xs-12"
										style="background-color: #217690; width: 762px; height: 400px;">
										<br> <br>
										<div class="col-xs-10">
											<ul class="next"
												style="list-style-type: none; font-family: Arial Regular; font-size: 14px; color: white;">
												<li class="heading1"
													style="color: white; font-weight: 900; font-size: 18px;">Lorem
													Ipsum</li>
												<br>
												<li>It is obvious that no one institution or university
													can accomplish any of these golas.We have to create a
													collaborative culture so that problems of small
													enterprises,informal sector and local communities in
													disadvantaged regions can be solved in a time bound manner.
													Every time a student solved a real life problem, he/she
													does not merely become a better technologist but also a
													better human being.</li>
												<br>
												<li>It is true that not all student groups will be able
													to solve a complex technical problem in six to ten months.
													Many will jsut fail. The universities will have to develop
													a culture,which does not punish an honest failure.</li>
												<br>
												<li>Else,the risk avoidance culture will never evolve
													among our young minds. Likewise,not all expertise for
													guiding a student team may be available at the same college
													or department. Mentors from various sectors, retired
													scientists, and fellows of national academies should be
													able to guide the projects in which they have interest.</li>
												<br>
											</ul>
										</div>

										<div class="col-xs-2">
											<br> <br> <br> <br> <br> <br> <br>
											<img src="images/Challenges_Img1.png" class="img-responsive">
										</div>
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
									<div class="col-xs-12">
										<h5 class="heading1"
											style="font-size: 30px; font-family: corbel; color: #262626;">Recent
											Items</h5>
										<div class="row-fluid" style="border-style: ridge;">
											<div class="span2"
												style="border-bottom: 2px solid #D0D0D0; margin-left: 10px; margin-right: 10px; margin-top: 10px; margin-bottom: 10px;">
												<p
													style="font-size: 14px; font-weight: 900px; font-family: Arial Regular;">
													Promoting both IPR protected and open source technologies
													and eventually develop techpedia.in into an online virtual
													incubator. Creating real-time online NMN (National
													Mentoring Network) to harness skills, insights and
													experience of senior tech experts for mentoring young
													students.</p>
											</div>
											<div class="span2"
												style="border-bottom: 2px solid #D0D0D0; margin-left: 10px; margin-right: 10px; margin-top: 10px; margin-bottom: 10px;">
												<p
													style="font-size: 14px; font-weight: 900px; font-family: Arial Regular;">
													Promoting both IPR protected and open source technologies
													and eventually develop techpedia.in into an online virtual
													incubator. Creating real-time online NMN (National
													Mentoring Network) to harness skills, insights and
													experience of senior tech experts for mentoring young
													students.</p>
											</div>
											<div class="span2"
												style="border-bottom: 2px solid #D0D0D0; margin-left: 10px; margin-right: 10px; margin-top: 10px; margin-bottom: 10px;">
												<p
													style="font-size: 14px; font-weight: 900px; font-family: Arial Regular;">
													Promoting both IPR protected and open source technologies
													and eventually develop techpedia.in into an online virtual
													incubator. Creating real-time online NMN (National
													Mentoring Network) to harness skills, insights and
													experience of senior tech experts for mentoring young
													students.</p>
											</div>
											<div class="span2"
												style="border-bottom: 2px solid #D0D0D0; margin-left: 10px; margin-right: 10px; margin-top: 10px; margin-bottom: 10px;">
												<p
													style="font-size: 14px; font-weight: 900px; font-family: Arial Regular;">
													Promoting both IPR protected and open source technologies
													and eventually develop techpedia.in into an online virtual
													incubator.</p>
											</div>
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



<!-- FOOOTER 
================================================== -->

<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
     <script src="js/respond.min.js"></script>
 <![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
<!-- FOOTER CONTENT BEGIN -->
<html ng-app="techpedia">

<style>
.footer-round {
	width: 100px;
	height: 100px;
	border: 1px solid #ccc;
	margin-top: 7px;
	padding: 53px;
	display: block;
	border-radius: 100px;
	-webkit-border-radius: 100px;
	-moz-border-radius: 100px;
	background: url(), url(profile_icon.png) 0px no-repeat;
	background-size: cover !important;
}
</style>
<body>


	<div class="customFont" style="background-color: #1e1e1e;">
		<div class="container"
			style="background-color: #1e1e1e; margin-top: 10px;" id="footer"
			ng-controller="FooterController" ng-init="InitLoad()">
			<div class="row">




				<div class="col-xs-12 col-sm-6 col-md-4">
					<div class="col-xs-12">&nbsp;</div>
					<div class="row">
						<div>
							<h4
								style="font-size: 20px; color: white; font-family: Corbel; margin-top: 20px; margin-left: 90px;">QUICK
								LINKS</h4>
							<ul class="page-breadcrumb breadcrumb"
								style="background-color: #1E1E1E; font-family: Arial; font-size: 14px; margin-left: 80px;">
								<%
									if (session.getAttribute("username") != null) {
								%>
								<div>
									<li><a href="./"
										style="font-size: 15px; color: white; margin-left: 2px;">Home</a>
									</li>
								</div>
								<div>
									<li><a href="challenges"
										style="font-size: 15px; color: white">Challenges</a></li>
								</div>
								<div>
									<li><a href="mentors"
										style="font-size: 15px; color: white">Mentors</a></li>
								</div>
								<div>

									<%
								if (session.getAttribute("username") != null && (session.getAttribute("usertype").equals("student") || session.getAttribute("usertype").equals("mentor") ||
																					session.getAttribute("usertype").equals("college") || session.getAttribute("usertype").equals("faculty"))) {
							%>
									<li><a href="projects"
										style="font-size: 15px; color: white">Projects</a></li>
									<%
								} else if(session.getAttribute("username") != null && (session.getAttribute("usertype")!="student" || session.getAttribute("usertype")!="mentor" ||
								session.getAttribute("usertype")!="college" || session.getAttribute("usertype")!="faculty") ) {
							%>
									<li><a href="techpediaArchive"
										style="font-size: 15px; color: white">Archives</a></li>
									<%
								}
							%>

								</div>

								<%
									} else {
								%><div>
									<li><a href="./" style="margin-left: 2px;">Home</a> <font
										style="font-weight: bold; font-family: Arial; margin-left: 2px; color: black; font-size: 14px;"></font></li>
								</div>

								<div style="padding: 2px;">
									<li><a href="challenges">Challenges</a></li>
								</div>

								<div style="padding: 2px;">
									<li><a href="mentors">Mentors</a></li>
								</div>

								<div style="padding: 2px;">
									<li><a href="projects">Projects</a></li>
								</div>
								<%
									}
								%>
							</ul>
							<div class="span6" style="margin-left: 90px;">
								<a href="https://www.facebook.com/techpedia.in/" target="_blank"><i
									id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a>
								<a href="https://twitter.com/techpedia_in" target="_blank"><i
									id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a> <a
									href="https://plus.google.com/+techpediaIndia" target="_blank"><i
									id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
								<a href="https://www.youtube.com/user/techpediain"
									target="_blank"><i id="social-gp"
									class="fa fa-youtube-square fa-3x social"></i></a>
							</div>
						</div>
					</div>

				</div>


				<div class="col-xs-12 col-sm-6 col-md-4">

					<div class="col-xs-12">&nbsp;</div>
					<div class="row">
						<div>


							<h2
								style="font-size: 20px; color: white; margin-left: 20px; font-family: Corbel;">OUR
								ADDRESS</h2>

						</div>
					</div>
					<div class="col-xs-12">&nbsp;</div>
					<div class="span8" style="color: white; text-align: justify">
						<img alt="" style="margin-left: 4px;"
							src="images/location-icon.jpg" />
						<p
							style="font-size: 14px; color: white; font-family: Arial; tab-size: 2; margin-left: 38px; margin-top: -30px">

							Techpedia.in SRISTI, B/h Pharmacy College Mess, Nr. Boys Hostel
							Campus, University Area, Navrangpura, Ahmedabad - 380 009,
							Gujarat, India </br>
						</p>

						<div
							style="padding: 4px; font-size: 14px; color: white; font-family: Arial; tab-size: 2;">
							<img alt="" src="images/phone-icon.jpg"
								/ style="padding: 4px; font-size: 14px; color: white; font-family: Arial; tab-size: 2;">
							+91 8141989908</br>
						</div>

						<div
							style="padding: 4px; font-size: 14px; color: white; font-family: Arial; tab-size: 2;">
							<img alt="" src="images/message-icon.jpg"
								/ style="padding: 4px; font-size: 14px; color: white; font-family: Arial; tab-size: 2;">
							feedback@techpedia.in
						</div>
					</div>



				</div>

				<div class="col-xs-12 col-sm-6 col-md-4">
					<div class="col-xs-12">&nbsp;</div>
					<div class="row">
						<div>



							<h2
								style="font-size: 20px; color: white; margin-left: 90px; font-family: Corbel;">USE
								GOOGLE MAPS</h2>

						</div>
					</div>


					<!--  <ul>
                                    <li><a href="./" style="font-size:12px;color:white;">Home</a></li>
                                    <li><a href="challenges" style="font-size:12px;color:white;">Challenges</a></li>
                                    <li><a href="mentors" style="font-size:12px;color:white;">Mentors</a></li>
                                    <li><a href="projects" style="font-size:12px;color:white;">Projects</a></li>
                                </ul>
                          
                              <div class="span6">
				                <a href="https://www.facebook.com/techpedia.in/"><i id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a>
				                <a href=""><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
				                <a href=""><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
            				</div> -->
					<div>
						<script src="http://maps.googleapis.com/maps/api/js"></script>
						<script>
							var myCenter = new google.maps.LatLng(23.0374465,
									72.5663254);

							function initialize() {
								var mapProp = {
									center : myCenter,
									zoom : 5,
									mapTypeId : google.maps.MapTypeId.ROADMAP
								};

								var map = new google.maps.Map(document
										.getElementById("map-canvas"), mapProp);

								var marker = new google.maps.Marker({
									position : myCenter,
								});

								marker.setMap(map);
								mapcanvas.style.style = 'border:10px solid #ffffff';
							}

							google.maps.event.addDomListener(window, 'load',
									initialize);
						</script>
						<div id="map-canvas"
							style="height: 190px; width: 225px; margin-left: 50px; padding: 2px; background-color: white;"></div>
					</div>

				</div>




			</div>
			<div class="col-xs-12" style="width: 1206px;">
				<hr>
			</div>
			<div class="col-xs-12"
				style="width: 1106px; color: white; display: block;">
				<div class="col-xs-4">
					<div class="logo opacity" style="border-radius: 5px;">
						<a href="./"> <img
							style="width: 100px; height: 30px; margin-bottom: 10px;"
							class="img-responsive" src="images/Techpedia.png" alt="" /></a>
					</div>
				</div>
				<div class="col-xs-8">
					&copy;<span class="small"> Copyright 2013 Techpedia</span> <span
						class="small" style="tab-size: 2;">| This site is best
						viewed in IE 11, Chrome, Firefox and other HTML5 supported
						browsers only.</span>
				</div>
			</div>
		</div>
		<p class="back-top floatright">
			<a href="#top"><span></span></a>
		</p>
	</div>

	<%-- 	<div id="copyright" class="container customFont" style="padding:5px;border-radius:5px;margin-top:20px;width:100%;background-color:#1e1e1e;">
		<div id="footer" ng-controller="FooterController" ng-init="InitLoad()" style="border-radius:5px;width:100%;background-color:#1e1e1e;">
	<footer class="row" style="margin-left: 4%;width:100%;background-color:#1e1e1e;">
		<p class="back-top floatright">
			<a href="#top"><span></span></a>
		</p>
		
		<div class="col-xs-12 col-sm-6 col-md-4">
			
		<div class="col-xs-12">&nbsp;</div>
		<div class="row" style="padding-left:100px; ">
			<div class="col-sm-4 col-md-4">
			<h3 style="font-size:20px;color:white;">About Us</h3>
			</div>
		</div>
		<div class="col-xs-12">&nbsp;</div>
			<div class="span8" style="color:black; text-align:justify">
			<p style="font-size:12px;color:white;font-family: 'Signika', sans-serif;">SRISTI(Society for Research and Initiatives for Sustainable Technologies and Institutions)has established three national awards for innovative student projects in engineering,pharmacy,science and other applied technologies.
				These will be given away by Dr.R.A.Mashelkar,Chairperson of NIF at RashtrapatiBhavan in March 2016.</p>
			<a class="btn btn-success btn-responsive" style="float:left;" href="aboutus">Learn More</a>
			</div>
		<div class="col-xs-12">&nbsp;</div>
		<div class="col-xs-12">&nbsp;</div>
		<div class="col-xs-12">&nbsp;</div>
		
		</div>
		
	
		<div class="col-xs-12 col-sm-6 col-md-4">
		</div>
		
		
		
		<div class="col-xs-12 col-sm-6 col-md-4">
			<h2 class="footer-title" style="text-align:center;color:white">Mentors</h2>
			<div class="col-xs-6 col-sm-6 col-md-4" ng-repeat="mentor in mentors">
				<img ng-file="file" ng-show="(mentor.mentorImage=='data:undefined;base64,undefined')||(mentor.mentorImage=='Photo path')"
					style="cursor: pointer;background-size: cover!important;-webkit-border-radius: 100px; -moz-border-radius: 100px;border-radius: 100px;"
					src="images/profile_icon.png" 					
					alt="{{mentor.mentorFirstName}} {{mentor.mentorLastName}}"
					title="{{mentor.mentorFirstName}} {{mentor.mentorLastName}}" width=60 height=60
					ng-click="viewMentor(mentor)"
					 />
				 <img ng-file="file" ng-hide="(mentor.mentorImage=='data:undefined;base64,undefined')||(mentor.mentorImage=='Photo path')"
					style="cursor: pointer;background-size: cover!important;-webkit-border-radius: 100px; -moz-border-radius: 100px;border-radius: 100px;"
					src="{{mentor.mentorImage||'images/profile_icon.png'}}" 					
					alt="{{mentor.mentorFirstName}} {{mentor.mentorLastName}}"
					title="{{mentor.mentorFirstName}} {{mentor.mentorLastName}}" width=60 height=60
					ng-click="viewMentor(mentor)"
					 /> 
			</div>
		</div>

		<div class="col-xs-12 col-sm-6 col-md-4">
			<h2 class="footer-title" style="text-align:center;color:white">Entrepreneurs</h2>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img style="cursor: pointer;background-size: cover!important;-webkit-border-radius: 100px; -moz-border-radius: 100px;border-radius: 100px;background: url(${entrepreneurs[0]}) 0px no-repeat;"
					 src="images/team7.jpg" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img style="cursor: pointer;background-size: cover!important;-webkit-border-radius: 100px; -moz-border-radius: 100px;border-radius: 100px;background: url(${entrepreneurs[1]}) 0px no-repeat;"
				src="images/team8.jpg" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img style="cursor: pointer;background-size: cover!important;-webkit-border-radius: 100px; -moz-border-radius: 100px;border-radius: 100px;background: url(${entrepreneurs[2]}) 0px no-repeat;"
				src="images/team9.jpg" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img style="cursor: pointer;background-size: cover!important;-webkit-border-radius: 100px; -moz-border-radius: 100px;border-radius: 100px;background: url(${entrepreneurs[3]}) 0px no-repeat;"
				src="images/team10.jpg" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img style="cursor: pointer;background-size: cover!important;-webkit-border-radius: 100px; -moz-border-radius: 100px;border-radius: 100px;background: url(${entrepreneurs[4]}) 0px no-repeat;"
				src="images/team11.jpg" width=60 height=60 />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img style="cursor: pointer;background-size: cover!important;-webkit-border-radius: 100px; -moz-border-radius: 100px;border-radius: 100px;background: url(${entrepreneurs[5]}) 0px no-repeat;"
				src="images/team12.jpg" width=60 height=60 />
			</div>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<h2 class="footer-title" style="text-align:center;color:white">Partners</h2>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.ge.com"><img src="images/ge.jpg" width=60 height=60 style="padding:5px;border-radius:15px;"/></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.tcs.com"><img src="images/tcs.jpg" width=60 height=60 style="padding:5px;border-radius:15px;" /></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.birlasoft.com"><img src="images/birlasoft.jpg" width=60 height=60 style="padding:5px;border-radius:15px;" /></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.techmahindra.com/pages/default.aspx"><img src="images/techmahindra.jpg" width=60 height=60 style="padding:5px;border-radius:15px;" /></a>
			</div>

		</div>
	</footer>
	<div class="copyright" style="background-color:#3C3C3C;">
	<div class="row">
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" style="color:white;">
			&copy;<span class="small"> Copyright 2013 Techpedia</span>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" style="color:white;">
			<span class="small"> This site is best Viewed in IE 11, Chrome, Firefox and other HTML5 supported browsers only.</span>
		</div>
	</div>
</div>

</div>

</div> --%>
	<!-- js 
================================================== -->
	<!-- Javascript files placed here for faster loading -->
	<!-- <script src="js/foundation.min.js"></script> -->
	<!-- <script src="js/jquery-ui.js"></script> -->
	<!-- <script src="js/angular.min.js"></script> -->
	<!-- <script src="js/Controller.js"></script> -->
	<!-- <script src="js/swfobject.js"></script>
	<script src="js/jquery.FileReader.min.js"></script> -->
	<!-- <script src="js/elasticslideshow.js"></script> -->
	<!-- <script src="js/jquery.cycle.js"></script> -->
	<!-- <script src="js/slidepanel.js"></script> -->
	<!-- <script src="js/responsivemenu.js"></script> -->
	<!-- <script src="js/jquery.isotope.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/custom.js"></script> -->
	<!-- <script src="js/bootstrap.min.js"></script> -->
	<!-- <script src="js/select2.min.js"></script>
	<script src="js/script.min.js"></script> -->
</body>
</html>
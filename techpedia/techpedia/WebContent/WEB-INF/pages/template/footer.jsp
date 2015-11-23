<!-- FOOOTER 
================================================== -->

<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
     <script src="js/respond.min.js"></script>
 <![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
	<!-- FOOTER CONTENT BEGIN -->
	<html>
	
		<style>
		
		.footer-round  {
width: 100px;
height: 100px;
border: 1px solid #ccc;
margin-top: 7px;
padding: 53px;
display: block;
border-radius: 100px;
-webkit-border-radius: 100px;
-moz-border-radius: 100px;
background: url(),url(profile_icon.png) 0px no-repeat;
background-size: cover!important;
}	
	</style>
	<body>
		<div id="copyright" class="container customFont" style="padding:5px;max-width:1130px;border-radius:5px;margin-top:20px;">
		<div id="footer" ng-controller="FooterController" ng-init="InitLoad()" style="background-color:#3C3C3C;border-radius:5px;">
	<footer class="row" style="margin-left: 4%">
		<p class="back-top floatright">
			<a href="#top"><span></span></a>
		</p>
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

</div>
<!-- js 
================================================== -->
<!-- Javascript files placed here for faster loading -->
<!-- <script src="js/foundation.min.js"></script> -->
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
</body>
</html>
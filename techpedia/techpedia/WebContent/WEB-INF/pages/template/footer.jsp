<!-- FOOOTER 
================================================== -->
<link rel="stylesheet" href="css/responsive.css">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
     <script src="js/respond.min.js"></script>
 <![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
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
<!-- js 
================================================== -->
<!-- Javascript files placed here for faster loading -->
<script src="js/foundation.min.js"></script>
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
<script src="js/bootstrap.min.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/script.min.js"></script>
</body>
</html>
<!DOCTYPE html>
<html ng-app="techpedia">
<!-- BEGIN HEAD -->
<head>

<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="css/testimonialsliderstyle.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.jscrollpane.css"
	media="all" />
<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow&v1'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Coustard:900'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Rochester'
	rel='stylesheet' type='text/css' />

</head>
<style>
.col-xs-15, .col-sm-15, .col-md-15, .col-lg-15 {
	position: relative;
	min-height: 1px;
	padding-right: 10px;
	padding-left: 10px;
}

.col-xs-15 {
	width: 20%;
	float: left;
}

@media ( min-width : 768px) {
	.col-sm-15 {
		width: 20%;
		float: left;
	}
}

@media ( min-width : 992px) {
	.col-md-15 {
		width: 20%;
		float: left;
	}
}

@media ( min-width : 1200px) {
	.col-lg-15 {
		width: 20%;
		float: left;
	}
}

.circle {
	width: 180px;
	height: 180px;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
	border: solid 2px #FF8C00;
}

.btn-button-name, .btn-button-name:link, .btn-button-name:visited {
	background-color: transparent;
	border-radius: 0;
	color: white;
	border: 1px solid white;
	border-radius: 5px;
	width: 100px;
	height: 40px;
	display: block;
	padding: 10px 10px;
}

.btn-button-name:active, .btn-button-name:hover {
	background-color: #339900;
	color: #fff
}

/* slider css*/
.multi-item-carousel { .carousel-inner { > .item{ transition:.6sease-in-outall;
	
}

.active { &.left { left:-33%;
	
}

&
.right {
	left: 33%;
}

}
.next {
	left: 33%;
}

.prev {
	left: -33%;
}

}
.carouse-control { &.left , &.right{ background-image:none;
	background-color: transparent;
}

}
@media all and (transform-3d) , ( -webkit-transform-3d ) { &{
	.carousel-inner { > .item { transition:.6sease-in-outall;
		-webkit-backface-visibility: visible;
		backface-visibility: visible;
		-webkit-perspective: none;
		-webkit-transform: none !important;
		transform: none !important;
	}
}

}
}
}
.carousel-control1 .glyphicon-chevron-left, .carousel-control1 .glyphicon-chevron-right
	{
	position: absolute;
	top: 50%;
	z-index: 5;
	display: inline-block;
}

.carousel-control1 .glyphicon-chevron-left {
	left: 50%;
	margin-left: -10px;
}

.carousel-control1 .glyphicon-chevron-right {
	right: 50%;
	margin-right: -10px;
}

@media screen and (min-width: 768px) {
	.carousel-control1 .glyphicon-chevron-left, .carousel-control1 .glyphicon-chevron-right
		{
		width: 30px;
		height: 30px;
		margin-top: -15px;
		font-size: 30px;
	}
	.carousel-control1 .glyphicon-chevron-left {
		margin-left: -500px;
	}
	.carousel-control1 .glyphicon-chevron-right {
		margin-right: -500px;
	}
}

.red-tooltip + .tooltip > .tooltip-inner {background-color: black;}
.red-tooltip + .tooltip > .tooltip-arrow { border-bottom-color:black; }
</style>
<script>
	$('#theCarousel').carousel({
		interval : false
	})

	$('.multi-item-carousel .item').each(
			function() {
				var next = $(this).next();
				if (!next.length) {
					next = $(this).siblings(':first');
				}
				next.children(':first-child').clone().appendTo($(this));

				if (next.next().length > 0) {
					next.next().children(':first-child').clone().appendTo(
							$(this));
				} else {
					$(this).siblings(':first').children(':first-child').clone()
							.appendTo($(this));
				}
			});
</script>
<body>
	<div class="customFont" style="background-color: #1f1f1f;">
		<jsp:include page="template/NewHeader.jsp" />
	</div>
	<!-- BEGIN SLIDER -->
	<div id="my-slide" class="borderRadius"
		style="background-color: #1f1f1f; width: 100%;">
		<img data-lazy-src="images/banner1.jpg" /> <img
			data-lazy-src="images/banner2.jpg" /> <img
			data-lazy-src="images/banner3.jpg" /> <img
			data-lazy-src="images/banner4.jpg" /> <img
			data-lazy-src="images/banner5.jpg" />
	</div>
	<div class="customFont"
		style="background-color: #1c9cc3;">
		<div class="container" style="padding-left: 180px; padding-top: 40px;">

			<div class="col-sm-4 col-md-4">
				<img src="images/creativity-animation.gif" class="img-responsive">
				<h3 style="padding-left: 20px; color: #ffffff;"
					class="img-responsive">Creativity</h3>
			</div>

			<div class="col-sm-4 col-md-4">
				<img src="images/collaboration-animation.gif" class="img-responsive">
				<h3 style="padding-left: 1px; color: #ffffff;"
					class="img-responsive">Collaboration</h3>
			</div>
			<div class="col-sm-4 col-md-4">
				<img src="images/compassion-animation.gif" class="img-responsive">
				<h3 style="padding-left: 10px; color: #ffffff;"
					class="img-responsive">Compassion</h3>
			</div>


		</div>
	</div>
	<div class="customFont" style="background-color: #1f1f1f;">
		<div class="container" style="background-color: #1f1f1f;">
			<div class="row">
				<div ng-controller="IndexController" ng-init="InitLoad()"
					class="col-sm-6 col-md-6" style="right-padding: 50px;">
					<div class="row" style="padding-left: 20px; padding-right: 20px;">
						<div class="col-xs-12">&nbsp;</div>
						<div class="row" style="padding-left: 100px;">
							<div class="col-sm-3 col-md-3">
								<img src="images/sristi-icon.jpg" class="img-responsive">
							</div>
							<div class="col-sm-3 col-md-3">
								<h3
									style="font-size: 40px; color: #ffffff; font-family: Arial Bold">TECHPEDIA</h3>
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="span8" style="color: black; text-align: justify">
							<p
								style="font-size: 16px; color: #ffffff; font-family: 'Signika', sans-serif;">Techpedia,
								an initiative at SRISTI aims at putting the problems of micro,
								small and medium enterprises, informal sector, grassroots
								innovators and other social sectors on the agenda of the young
								technology students across the country. For over last sixty
								years, India has not utilized much the technological outputs of
								millions of students. But no more. Can a knowledge society
								really afford to ignore the huge talent distributed in thousands
								of polytechnics, diploma and degree colleges of engineering,
								pharmacy, medical science, agriculture etc.? SRISTI is providing
								a platform for the industry and academic institutions to
								collaborate, co-create and foster distributed and horizontal
								innovations. Most of the ideas mentioned here have been
								implemented in the state of Gujarat in close cooperation with
								Gujarat Technical University and initial results are extremely
								encouraging.</p>
							<a class="btn btn-success btn-responsive" style="float: right;"
								href="aboutus"><i class="fa fa-book"></i>&nbsp;Read More</a>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">&nbsp;</div>

					</div>

				</div>
				<div ng-controller="IndexController" ng-init="InitLoad()"
					class="col-sm-6 col-md-6" style="right-padding: 50px;padding-top: 45px;">
					<img src="images/welcome-to-techpedia.jpg" class="img-responsive">
				</div>
			</div>
			<!--  </div> -->
			<!--   <div class="container" style="width:100%;background-color:#1f1f1f;"> -->
			<div class="row">
				<div ng-controller="IndexController" ng-init="InitLoad()"
					class="col-sm-6 col-md-6" style="right-padding: 50px;">
					<img src="images/challengesTechpedia.jpg" class="img-responsive">
				</div>


				<div id="copyright" ng-controller="IndexController"
					ng-init="InitLoad()" class="col-sm-6 col-md-6">

					<div class="row" style="padding-left: 20px; padding-right: 20px;">
						<div class="row" style="padding-left: 200px;">
							<div class="col-sm-3 col-md-3">
								<h3
									style="font-size: 40px; color: #ffffff; font-family: Arial Bold"">CHALLENGES</h3>
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						
						<div class="span8" style="color: black; text-align: justify">
							<p
								style="font-size: 16px; color: #ffffff; font-family: 'Signika', sans-serif;">Techpedia,
								an initiative at SRISTI aims at putting the problems of micro,
								small and medium enterprises, informal sector, grassroots
								innovators and other social sectors on the agenda of the young
								technology students across the country. For over last sixty
								years, India has not utilized much the technological outputs of
								millions of students. But no more. Can a knowledge society
								really afford to ignore the huge talent distributed in thousands
								of polytechnics, diploma and degree colleges of engineering,
								pharmacy, medical science, agriculture etc.? SRISTI is providing
								a platform for the industry and academic institutions to
								collaborate, co-create and foster distributed and horizontal
								innovations. Most of the ideas mentioned here have been
								implemented in the state of Gujarat in close cooperation with
								Gujarat Technical University and initial results are extremely
								encouraging.</p>
							<a class="btn btn-success btn-responsive" style="float: right;"
								href="challenges"><i class="fa fa-eye"></i>&nbsp;View</a>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						
					</div>

					<!-- <div class="customFont borderRadius" style="background-color:#FAFAF7;padding:15px;">
			<div class="container">
				<div class="col-xs-6">
					<div class="col-xs-3">
						<section>
							<div class="Spotlights">
								<div>
									<h3 style="cursor: pointer;" ng-click="viewProject(project)">{{project.projTitle}}</h3>
									<p style="cursor: pointer;" ng-click="viewProject(project)">{{project.projDescription | truncate:true:150:'...'}}

									
									<p>
									<footer>
										<a href="projects" class="button scrolly">See all</a>
									</footer>
								</div>
							</div>
						</section>
					</div>

					<div class="col-xs-3">
						<div class="row no-collapse">
							<div class="col-xs-25">
								<a style="cursor: pointer;" ng-click="viewProject(project)" class="image full"><img
									class="img-responsive" src="{{project.projImage||'images/art/project.png'}}" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> -->
				</div>
			</div>

		</div>
	</div>

	<div class="customFont" style="background-color: #1c9cc3;">
		<div class="container" ng-controller="FooterController"
			ng-init="InitLoad()" style="width: 100%; background-color: #dbdddc;">
			<h2 class="footer-title"
				style="text-align: center; font-family: Arial Bold; font-size: 40px; color: #262626; margin-top: 24px; height: 18px;">OUR
				MENTORS</h2>
			<div class="container"
				style="padding-left: 190px; padding-right: 50px;">
				<div id="ca-container" class="ca-container">
					<div class="ca-wrapper">
						<div class="ca-item ca-item-1" style="width: 279px;">

							<div class="ca-item-main" style="border: solid 2px #FF8C00;">
								<p
									style="font-size: 20px; font-weight: 900px; color: #2491b2; font-family: 'Signika', sans-serif;">{{mentors[$index+0].mentorFirstName}}</p>
								<div>
									<img ng-file="file"
										ng-show="(mentors[$index+0].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+0].mentorImage=='Photo path')"
										src="images/profile_icon.png"
										alt="{{mentors[$index+0].mentorFirstName}} {{mentors[$index+0].mentorLastName}}"
										title="{{mentors[$index+0].mentorFirstName}} {{mentors[$index+0].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+0])" />
									<img ng-file="file"
										ng-hide="(mentors[$index+0].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+0].mentorImage=='Photo path')"
										src="{{mentors[$index+0].mentorImage||'images/profile_icon.png'}}"
										alt="{{mentors[$index+0].mentorFirstName}} {{mentors[$index+0].mentorLastName}}"
										title="{{mentors[$index+0].mentorFirstName}} {{mentors[$index+0].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+0])" />
								</div>
								</br>
								<div>
									<a class="btn btn-success btn-responsive"
										style="display: inline-block;"
										ng-click="viewMentor(mentors[$index+0])" href=""><i
										class="fa fa-book"></i>&nbsp;Learn More</a>
								</div>
								</br>
								<div class=""
									style="background-color: #292b38; height: 30px; padding-top: 4px;">
									<p
										style="font-size: 15px; font-weight: 900px; color: #ffffff; font-family: Arial;">
										{{mentors[$index+0].mentorBranch}}</p>
								</div>
							</div>
						</div>
						<div class="ca-item ca-item-1" style="width: 279px;">

							<div class="ca-item-main" style="border: solid 2px #FF8C00;">
								<p
									style="font-size: 20px; color: #2491b2; font-family: 'Signika', sans-serif;">{{mentors[$index+1].mentorFirstName}}</p>
								<div>
									<img ng-file="file"
										ng-show="(mentors[$index+1].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+1].mentorImage=='Photo path')"
										src="images/profile_icon.png"
										alt="{{mentors[$index+1].mentorFirstName}} {{mentors[$index+1].mentorLastName}}"
										title="{{mentors[$index+1].mentorFirstName}} {{mentors[$index+1].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+1])" />
									<img ng-file="file"
										ng-hide="(mentors[$index+1].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+1].mentorImage=='Photo path')"
										src="{{mentors[$index+1].mentorImage||'images/profile_icon.png'}}"
										alt="{{mentors[$index+1].mentorFirstName}} {{mentors[$index+1].mentorLastName}}"
										title="{{mentors[$index+1].mentorFirstName}} {{mentors[$index+1].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+1])" />
								</div>
								</br>
								<div>
									<a class="btn btn-success btn-responsive"
										style="display: inline-block;"
										ng-click="viewMentor(mentors[$index+1])" href=""><i
										class="fa fa-book"></i>&nbsp;Learn More</a>
								</div>
								</br>
								<div class=""
									style="background-color: #292b38; height: 30px; padding-top: 4px;">
									<p
										style="font-size: 15px; font-weight: 900px; color: #ffffff; font-family: Arial;">
										{{mentors[$index+1].mentorBranch}}</p>
								</div>

							</div>
						</div>
						<div class="ca-item ca-item-1" style="width: 279px;">

							<div class="ca-item-main" style="border: solid 2px #FF8C00;">
								<p
									style="font-size: 20px; color: #2491b2; font-family: 'Signika', sans-serif;">{{mentors[$index+2].mentorFirstName}}</p>
								<div>
									<img ng-file="file"
										ng-show="(mentors[$index+2].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+2].mentorImage=='Photo path')"
										src="images/profile_icon.png"
										alt="{{mentors[$index+2].mentorFirstName}} {{mentors[$index+2].mentorLastName}}"
										title="{{mentors[$index+2].mentorFirstName}} {{mentors[$index+2].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+2])" />
									<img ng-file="file"
										ng-hide="(mentors[$index+2].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+2].mentorImage=='Photo path')"
										src="{{mentors[$index+2].mentorImage||'images/profile_icon.png'}}"
										alt="{{mentors[$index+2].mentorFirstName}} {{mentors[$index+2].mentorLastName}}"
										title="{{mentors[$index+2].mentorFirstName}} {{mentors[$index+2].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+2])" />
								</div>
								</br>
								<div>
									<a class="btn btn-success btn-responsive"
										style="display: inline-block;"
										ng-click="viewMentor(mentors[$index+2])" href=""><i
										class="fa fa-book"></i>&nbsp;Learn More</a>
								</div>
								</br>
								<div class=""
									style="background-color: #292b38; height: 30px; padding-top: 4px;">
									<p
										style="font-size: 15px; font-weight: 900px; color: #ffffff; font-family: Arial;">
										{{mentors[$index+2].mentorBranch}}</p>
								</div>

							</div>
						</div>
						<div class="ca-item ca-item-1" style="width: 279px;">

							<div class="ca-item-main" style="border: solid 2px #FF8C00;">
								<p
									style="font-size: 20px; color: #2491b2; font-family: 'Signika', sans-serif;">{{mentors[$index+3].mentorFirstName}}</p>
								<div>
									<img ng-file="file"
										ng-show="(mentors[$index+3].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+3].mentorImage=='Photo path')"
										src="images/profile_icon.png"
										alt="{{mentors[$index+3].mentorFirstName}} {{mentors[$index+3].mentorLastName}}"
										title="{{mentors[$index+3].mentorFirstName}} {{mentors[$index+3].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+3])" />
									<img ng-file="file"
										ng-hide="(mentors[$index+3].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+3].mentorImage=='Photo path')"
										src="{{mentors[$index+3].mentorImage||'images/profile_icon.png'}}"
										alt="{{mentors[$index+3].mentorFirstName}} {{mentors[$index+3].mentorLastName}}"
										title="{{mentors[$index+3].mentorFirstName}} {{mentors[$index+3].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+3])" />
								</div>
								</br>
								<div>
									<a class="btn btn-success btn-responsive"
										style="display: inline-block;"
										ng-click="viewMentor(mentors[$index+3])" href=""><i
										class="fa fa-book"></i>&nbsp;Learn More</a>
								</div>
								</br>
								<div class=""
									style="background-color: #292b38; height: 30px; padding-top: 4px;">
									<p
										style="font-size: 15px; font-weight: 900px; color: #ffffff; font-family: Arial;">
										{{mentors[$index+3].mentorBranch}}</p>
								</div>

							</div>
						</div>
						<div class="ca-item ca-item-1" style="width: 279px;">

							<div class="ca-item-main" style="border: solid 2px #FF8C00;">
								<p
									style="font-size: 20px; color: #2491b2; font-family: 'Signika', sans-serif;">{{mentors[$index+4].mentorFirstName}}</p>
								<div>
									<img ng-file="file"
										ng-show="(mentors[$index+4].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+4].mentorImage=='Photo path')"
										src="images/profile_icon.png"
										alt="{{mentors[$index+4].mentorFirstName}} {{mentors[$index+4].mentorLastName}}"
										title="{{mentors[$index+4].mentorFirstName}} {{mentors[$index+4].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+4])" />
									<img ng-file="file"
										ng-hide="(mentors[$index+4].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+4].mentorImage=='Photo path')"
										src="{{mentors[$index+4].mentorImage||'images/profile_icon.png'}}"
										alt="{{mentors[$index+4].mentorFirstName}} {{mentors[$index+4].mentorLastName}}"
										title="{{mentors[$index+4].mentorFirstName}} {{mentors[$index+4].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+4])" />
								</div>
								</br>
								<div>
									<a class="btn btn-success btn-responsive"
										style="display: inline-block;"
										ng-click="viewMentor(mentors[$index+4])" href=""><i
										class="fa fa-book"></i>&nbsp;Learn More</a>
								</div>
								</br>
								<div class=""
									style="background-color: #292b38; height: 30px; padding-top: 4px;">
									<p
										style="font-size: 15px; font-weight: 900px; color: #ffffff; font-family: Arial">
										{{mentors[$index+4].mentorBranch}}</p>
								</div>

							</div>
						</div>
						<div class="ca-item ca-item-1" style="width: 279px;">

							<div class="ca-item-main" style="border: solid 2px #FF8C00;">
								<p
									style="font-size: 20px; color: #2491b2; font-family: 'Signika', sans-serif;">{{mentors[$index+5].mentorFirstName}}</p>
								<div>
									<img ng-file="file"
										ng-show="(mentors[$index+5].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+5].mentorImage=='Photo path')"
										src="images/profile_icon.png"
										alt="{{mentors[$index+5].mentorFirstName}} {{mentors[$index+5].mentorLastName}}"
										title="{{mentors[$index+5].mentorFirstName}} {{mentors[$index+5].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+5])" />
									<img ng-file="file"
										ng-hide="(mentors[$index+5].mentorImage=='data:undefined;base64,undefined')||(mentors[$index+5].mentorImage=='Photo path')"
										src="{{mentors[$index+5].mentorImage||'images/profile_icon.png'}}"
										alt="{{mentors[$index+5].mentorFirstName}} {{mentors[$index+5].mentorLastName}}"
										title="{{mentors[$index+5].mentorFirstName}} {{mentors[$index+5].mentorLastName}}"
										width=100 height=100 ng-click="viewMentor(mentors[$index+5])" />
								</div>
								</br>
								<div>
									<a class="btn btn-success btn-responsive"
										style="display: inline-block;"
										ng-click="viewMentor(mentors[$index+5])" href=""><i
										class="fa fa-book"></i>&nbsp;Learn More</a>
								</div>
								</br>
								<div class=""
									style="background-color: #292b38; height: 30px; padding-top: 4px;">
									<p
										style="font-size: 15px; font-weight: 900px; color: #ffffff; font-family: Arial;">
										{{mentors[$index+5].mentorBranch}}</p>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="customFont" style="background-color: #217790;">
		<div class="container" style="background-color: #217790;"
			ng-controller="IndexController" ng-init="InitLoad()">
			<h2 class="footer-title"
				style="text-align: center; font-family: Arial Bold; font-size: 40px; color: #ffffff;">
				PROJECTS CATEGORIES</h2>

			<div class="container" style="text-align: center;">
				<div class="row">
					<!-- <div class="col-sm-1">
						<a class="btn-button-name"

							style="display: inline-block; margin-left: -20px; text-align: center;"
							ng-click="popularProjectVisibility()" href="">
							<i
							class="fa fa-thumbs-up" ></i>&nbsp;POPULAR</a>
					</div>
					<div class="col-sm-1 " >
						<a class="btn-button-name" id="recentProjectsBtn"
							style="display: inline-block; margin-left: -20px; text-align: center;"
							ng-click="recentProjectVisibility()" href=""><img alt=""
							src="http://icons.iconarchive.com/icons/delacro/id/24/Recent-Documents-icon.png">&nbsp;RECENT</a>
					</div> -->

					<!-- <div class="btn-group" role="group">

						<button type="button" class="btn btn-default "
							ng-click="popularProjectVisibility()">
							<i class="fa fa-thumbs-up"></i>&nbsp;POPULAR
						</button>
					</div>
						<div class="btn-group" role="group">
						<button type="button" class="btn btn-default "
							ng-click="recentProjectVisibility()">
							<i class="fa fa-clock-o"></i>&nbsp;RECENT
						</button>
						</div> -->
					<!-- <div class="btn-group" role="group">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Project Category<span class="caret"></span>
						</button>
						<button type="button" class="btn btn-default">PROJECT CATEGORY</button>

						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="caret"></span> <span class="sr-only">Toggle
								Dropdown</span>
						</button>
						<ul class="dropdown-menu">
							<li  ng-repeat="macro in projectsMacroBranches"><a href="#">{{macro.macroBranchName}}</a></li>
							
						</ul>
						</div> -->
					<!-- <div class="col-xs-12">
						<div class="col-xs-3" ng-repeat="macro in projectsMacroBranches" style="height: 120px !important; width: 120px !important;" >
							<a style="text-align: center; font-family: Arial Bold; font-size: 15px; color: #ffffff !important;" href="#" ng-click="clickMacroBranch(macro.macroBranchName)">{{macro.macroBranchName}}</a>
							<img alt="" src="images/macrobranch/Aeronautical.jpg" class="img-responsive" width="120" height="120">
						</div>
					</div> -->
					<div class="col-xs-9" style="margin-left: 237px;">
						<div class="row">
							<div class="col-md-15 col-sm-3"
								ng-repeat="macro in projectsMacroBranches"
								style="margin-left: -70px; height: 170px;">
								<a href="" ng-click="clickMacroBranch(macro.macroBranchName)" class="macro-tooltip"  data-toggle="tooltip" data-placement="bottom"  title="{{macro.macroBranchName}}">
									<div>
										<img src="${pageContext.request.contextPath}/image/{{macro.photoPath ||'/usr/Techpedia/Project/placeholders/placeholder.png'}}"
											height="120px" width="120px" style="box-shadow: 0 0 2em #b2b2b2;">
									</div>
									
									<div style="color:#ffffff;margin-left:22px;margin-right:22px;">{{macro.macroBranch}}</div>
									
									
								</a>
<br/><br/>
							</div>

						</div>


					</div>



				</div>
			</div>
			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12">&nbsp;</div>


			<%-- <div class="row row-centered" id="popularProjects"
				style="width: 990px; display: block; margin-left: auto; margin-right: auto; float: none;">



				<div class="col-sm-3 col-md-3"
					style="border: solid 1px; width: 50px border-radius: 5px; background-color: #ffffff; border-radius: 10px;"
					ng-repeat="project in projects">


					<img
						src="${pageContext.request.contextPath}/image/{{project.photo1Path ||'E:/Techpedia/Project/UploadedDocuments/ProjectImages/defaultImage/placeholder.png'}}"
						class="img-responsive" alt="{{project.projTitle}}"
						style="height: 144px; width: 215px; padding-top: 10px;" />
					<p
						style="font-size: 14px; font-weight: 900px; color-black; font-family: 'Signika', sans-serif;">{{project.projTitle}}</p>
					<hr>
					<a class="btn btn-success btn-responsive"
						style="float: right; display: block"
						ng-click="viewProject(project)" href="">Details</a>
					<div class="col-xs-12">&nbsp;</div>

				</div>
			</div> --%>




			<%-- <div class="row row-centered" id="recentProjects"
				style="width: 990px; display: none; margin-left: auto; margin-right: auto; float: none;">

				<div class="col-sm-3 col-md-3"
					style="border: solid 1px; width: 50px border-radius: 5px; background-color: #ffffff; border-radius: 10px;"
					ng-repeat="project in recentprojects">


					<img
						src="${pageContext.request.contextPath}/image/{{project.photo1Path ||'E:/Techpedia/Project/UploadedDocuments/ProjectImages/defaultImage/placeholder.png'}}"
						class="img-responsive" alt="{{project.projTitle}}"
						style="height: 144px; width: 215px; padding-top: 10px;" />
					<p
						style="font-size: 14px; font-weight: 900px; color-black; font-family: 'Signika', sans-serif;">{{project.projTitle
						}}</p>
					<hr>
					<a class="btn btn-success btn-responsive" style="float: right;"
						ng-click="viewProject(project)" href="">Details</a>
					<div class="col-xs-12">&nbsp;</div>
				</div>

			</div>
 --%>



			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12">&nbsp;</div>

		</div>
	</div>

	<div class="customFont" style="background-color: #18404c;">
		<div class="container" ng-controller="IndexController"
			ng-init="InitLoad()" style="background-color: #18404c;">
			<h2 class="footer-title"
				style="text-align: center; font-family: Arial Bold; font-size: 40px; color: #ffffff;">TESTIMONIALS</h2>

			<div class="container">
				<div class="col-md-8 col-md-offset-2">
					<div class="carousel slide multi-item-carousel" id="theCarousel">
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-xs-4">
									<img src="images/Abdul-Kalam-Azad.png" class="img-responsive"
										style="margin-left: 30px;"> <br> <br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">I
										am extremely happy to see an initiative of SRISTI (Society for
										Research and Initiatives for Sustainable Technologies and
										Institutions) which has led to mapping of the mind of
										engineering youth of our country in an unprecedented manner.</p>
									<br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">Dr.
										A.P.J. Abdul Kalam</p>
								</div>
							</div>
							<div class="item">
								<div class="col-xs-4">
									<img src="images/DR_raghuNath.png" class="img-responsive"
										style="margin-left: 30px;"> <br> <br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">What
										touched me most was that these innovations were not just about
										making the next supercar or next superbike or super-plane:
										They were about making the life of every Indian, not some, a
										bit better. That means you're thinking not just from your head
										but from your heart. That's something very special.</p>
									<br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">Dr.
										R.A. Mashelkar</p>
								</div>
							</div>
							<div class="item">
								<div class="col-xs-4">
									<img src="images/3.png" class="img-responsive"
										style="margin-left: 30px;"> <br> <br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">I
										am particularly pleased to know that several of the
										innovations by the school children are also being valorized by
										engineering college students.</p>
									<br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">Prof
										XYZ</p>
								</div>
							</div>
							<div class="item">
								<div class="col-xs-4">
									<img src="images/1.png" class="img-responsive"
										style="margin-left: 30px;"> <br> <br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">I
										am particularly pleased to know that several of the
										innovations by the school children are also being valorized by
										engineering college students.</p>
									<br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">Prof
										ABC</p>
								</div>
							</div>
							<div class="item">
								<div class="col-xs-4">
									<img src="images/2.png" class="img-responsive"
										style="margin-left: 30px;"> <br> <br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">I
										am particularly pleased to know that several of the
										innovations by the school children are also being valorized by
										engineering college students.</p>
									<br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">Prof
										PQR</p>
								</div>
							</div>
							<div class="item">
								<div class="col-xs-4">
									<img src="images/3.png" class="img-responsive"
										style="margin-left: 30px;"> <br> <br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">I
										am particularly pleased to know that several of the
										innovations by the school children are also being valorized by
										engineering college students.</p>
									<br>
									<p
										style="font-size: 14px; color: #ffffff; font-family: 'Signika', sans-serif; text-align: justify;">Prof
										XYZ</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control1" href="#theCarousel"
							data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i></a>
						<a class="right carousel-control1" href="#theCarousel"
							data-slide="next"><i
							class="glyphicon glyphicon-chevron-right"></i></a>
					</div>
				</div>
			</div>

			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12">&nbsp;</div>

			<!-- <div class="container"  style="padding-left:150px;padding-right:120px;">
					
					<div class="col-sm-4 col-md-4"   ng-repeat="test in testimonial" >
					<div class="circle" style="background: url('{{test.image}}');" class="img-responsive"></div>
					<div class="col-xs-12">&nbsp;</div>
					<div class="col-xs-12">&nbsp;</div>
					<p style="font-size:14px;color:#ffffff;font-family: 'Signika', sans-serif;">{{test.testimonial | truncate:true:150:'...'}}</p>
					<cite style="font-size:16px;color:#ffffff;font-family: 'Signika', sans-serif;">- {{test.cite}}</cite>
					<div class="col-xs-12">&nbsp;</div>
					<div class="col-xs-12">&nbsp;</div>
				   </div>
			   </div>  -->
		</div>
	</div>
	<div class="customFont" style="background-color: #d3d3d3;">
		<div class="container" style="background-color: #d3d3d3;">
			<h2 class="footer-title"
				style="text-align: center; font-family: Arial Bold; font-size: 40px; color: #262626;">OUR
				PARTNERS</h2>
			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12">&nbsp;</div>
			<div class="container" style="padding-left: 320px;">
				<div class="col-sm-2 col-md-2">
					<a href="http://www.tcs.com"><img src="images/tcs.jpg"
						class="img-responsive" width=100 height=100
						style="padding: 5px; border-radius: 15px;" /></a>
				</div>

				<div class="col-sm-2 col-md-2">
					<a href="http://www.ge.com"><img src="images/ge.jpg"
						class="img-responsive" width=100 height=100
						style="padding: 5px; border-radius: 15px;" /></a>
				</div>

				<div class="col-sm-2 col-md-2">
					<a href="http://www.birlasoft.com"><img
						src="images/birlasoft.jpg" class="img-responsive" width=100
						height=100 style="padding: 5px; border-radius: 15px;" /></a>
				</div>

				<div class="col-sm-2 col-md-2">
					<a href="http://www.techmahindra.com/pages/default.aspx"><img
						src="images/techmahindra.jpg" class="img-responsive" width=100
						height=100 style="padding: 5px; border-radius: 15px;" /></a>
				</div>
			</div>
			<div class="col-xs-12">&nbsp;</div>
			<div class="col-xs-12">&nbsp;</div>
		</div>
	</div>

	<div class="customFont" style="background-color: #292929;">
		<!-- <div class="container" style="background-color:#292929;">
    	<h2 class="footer-title" style="text-align:center;font-weight:400;font-size:40px;color:white;">OUR PARTNERS</h2>
    	<div class="col-xs-12">&nbsp;</div>
		<div class="col-xs-12">&nbsp;</div>
		<div class="container"  style="padding-left: 320px;" >
			<div class="col-sm-2 col-md-2">
				<a href="http://www.tcs.com"><img src="images/tcs.jpg" class="img-responsive" width=100 height=100 style="padding:5px;border-radius:15px;"/></a>
			</div>

			<div class="col-sm-2 col-md-2">
				<a href="http://www.ge.com"><img src="images/ge.jpg" class="img-responsive" width=100 height=100 style="padding:5px;border-radius:15px;" /></a>
			</div>

			<div class="col-sm-2 col-md-2">
				<a href="http://www.birlasoft.com"><img src="images/birlasoft.jpg" class="img-responsive" width=100 height=100 style="padding:5px;border-radius:15px;" /></a>
			</div>

			<div class="col-sm-2 col-md-2">
				<a href="http://www.techmahindra.com/pages/default.aspx"><img src="images/techmahindra.jpg" class="img-responsive" width=100 height=100 style="padding:5px;border-radius:15px;" /></a>
			</div>
		</div>
		<div class="col-xs-12">&nbsp;</div>
		<div class="col-xs-12">&nbsp;</div>
    </div> -->
	</div>

	<!-- 	
     <div id="copyright" ng-controller="IndexController" ng-init="InitLoad()" class="container customFont" style="background-color:#FAFAF7;padding:5px;max-width:1130px;border-radius:5px;margin-top:20px;">
	<section id="third" class="main">
		<header>
			<div class="container">
				<h2>Testimonials</h2>
			</div>
		</header>
		<div class="content dark style3">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="testimonials" style="border-left: 0px;">
							<div>
								<p class="welcome" ng-repeat="test in testimonial">
									{{test.testimonial | truncate:true:150:'...'}} <cite>- {{test.cite}}</cite>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>  -->

	<!-- Table of Contents -->
	<!--<div class="container">
    	
    		<div class="col-sm-3" id="Table_of_Contents" >
    			<div class="list-group">
    				<span class="list-group-item" style="background-color: #026881; color: #fff;">Table of Contents</span>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#whats-included").offset().top }, 1000);'>What's included</a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#basic-setup-ltr").offset().top }, 1000);'>Basic setup</a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#basic-setup-rtl").offset().top }, 1000);'>Basic setup (rtl language layout)</a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#credits").offset().top }, 1000);'>Sources and Credits</a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#license").offset().top }, 1000);'>License </a>
    				<a class="list-group-item" href="javascript:;" onclick='$("html, body").delay(100).animate({scrollTop: $("#documentation").offset().top }, 1000);'>Online documentation</a>
    			</div>
    		</div>
    	</div> -->

	<!-- FOOTER CONTENT BEGIN -->
	<jsp:include page="template/footer.jsp" />
	<!-- 	<div id="copyright" class="container customFont" style="background-color:#FAFAF7;padding:5px;max-width:1130px;border-radius:5px;margin-top:20px;">
			<div id="footer" ng-controller="FooterController" ng-init="InitLoad()" class="ng-scope">
				<footer class="row" style="margin-left: 5%">
		
			<div class="col-xs-12 col-sm-6 col-md-4">
			<h3 class="footer-title">Mentors</h3>
			ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team1.jpg" alt="admin admin" title="admin admin" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team2.jpg" alt="jhnghjkhmhj gbg" title="jhnghjkhmhj gbg" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team3.jpg" alt="surej K " title="surej K " width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team4.jpg" alt="naimar nn" title="naimar nn" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team5.jpg" alt="Ronoldino rm" title="Ronoldino rm" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors<div class="col-xs-6 col-sm-6 col-md-4 footer-img ng-scope" ng-repeat="mentor in mentors">
				<a style="cursor: pointer;padding:5px;" ng-click="viewMentor(mentor)"><img src="images/footer/team6.jpg" alt="Prabhat Pathania" title="Prabhat Pathania" width="60" height="60"></a>
			</div>end ngRepeat: mentor in mentors
		</div>

		<div class="col-xs-12 col-sm-6 col-md-4">
			<h3 class="footer-title">Entrepreneurs</h3>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team7.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team8.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team9.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team10.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team11.jpg" width="60" height="60">
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<img src="images/footer/team12.jpg" width="60" height="60">
			</div>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-4">
			<h3 class="footer-title">Partners</h3>
			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.ge.com"><img src="images/footer/ge.jpg" width="60" height="60"></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.tcs.com"><img src="images/footer/tcs.jpg" width="60" height="60"></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.birlasoft.com"><img src="images/footer/birlasoft.jpg" width="60" height="60"></a>
			</div>

			<div class="col-xs-6 col-sm-6 col-md-4 footer-img">
				<a href="http://www.techmahindra.com/pages/default.aspx"><img src="images/footer/techmahindra.jpg" width="60" height="60"></a>
			</div>

		</div>
	</footer>

<br><br>
  
    <p>© 2014 Techpedia Design Team. All Right Reserved.</p>
	 
  </div>
 
</div> -->


	<script>
		//Start Fix MegaNavbar on scroll page
		//var navHeight = $('#main_navbar').offset().top;
		var navHeight = 150;
		FixMegaNavbar(navHeight);
		$(window).bind('scroll', function() {
			FixMegaNavbar(navHeight);
		});

		function FixMegaNavbar(navHeight) {
			if (!$('#main_navbar').hasClass('navbar-fixed-bottom')) {
				//console.log($(window).scrollTop());
				//console.log('navHeight='+navHeight);

				if ($(window).scrollTop() > navHeight) {
					$('#main_navbar').addClass('navbar-fixed-top')
					$('body').css({
						'margin-top' : $('#main_navbar').height() + 'px'
					});
					if ($('#main_navbar').parent('div').hasClass('container'))
						$('#main_navbar').children('div').addClass('container')
								.removeClass('container-fluid');
					else if ($('#main_navbar').parent('div').hasClass(
							'container-fluid'))
						$('#main_navbar').children('div').addClass(
								'container-fluid').removeClass('container');
				} else {
					$('#main_navbar').removeClass('navbar-fixed-top');
					$('#main_navbar').children('div').addClass(
							'container-fluid').removeClass('container');
					$('body').css({
						'margin-top' : ''
					});
				}
			}
		}
		//Start Fix MegaNavbar on scroll page

		//Start Fix MegaNavbar on scroll page
		//var tocHeight = $('#Table_of_Contents').offset().top;
		var tocHeight = 150;
		FixTOC(tocHeight);
		$(window).bind('scroll', function() {
			FixTOC(tocHeight);
		});

		function FixTOC(tocHeight) {

			if ($(window).scrollTop() > (tocHeight - 75)) {
				$('#Table_of_Contents').css({
					'position' : 'relative',
					'top' : (($(window).scrollTop() - tocHeight) + 90) + "px",
					'right' : 'auto'
				});
			} else {
				$('#Table_of_Contents').css({
					'position' : 'relative',
					'top' : '0px',
					'right' : 'auto'
				});
			}
		}
		//Start Fix MegaNavbar on scroll page

		//Next code used to prevent unexpected menu close when using some components (like accordion, tabs, forms, etc), please add the next JavaScript to your page
		$(window).load(function() {
			$(document).on('click', '.navbar .dropdown-menu', function(e) {
				e.stopPropagation();
			});
		});

		/*SCROLL PAGE TO TOP*/
		$(document).ready(function() {
			$(".toTop").css("display", "none");

			$(window).scroll(function() {
				if ($(window).scrollTop() > 0) {
					$(".toTop").fadeIn("slow");
				} else {
					$(".toTop").fadeOut("slow");
				}
			});

			$(".toTop").click(function() {
				event.preventDefault();
				$("html, body").animate({
					scrollTop : 0
				}, "slow");
			});
		});

		function userLogin() {
			jQuery('.dropdown-grid').removeClass('open');
		}
	</script>
	<script>
  
	   $(document).ready(function(){
		    $(".macro-tooltip").tooltip();
		});
	   


  </script> 
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<!-- the jScrollPane script -->
	<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
	<script type="text/javascript" src="js/jquery.contentcarousel.js"></script>
	<script type="text/javascript">
		$('#ca-container').contentcarousel();
	</script>
	<script>
		jQuery.noConflict();
	</script>

	   
</body>

</html>
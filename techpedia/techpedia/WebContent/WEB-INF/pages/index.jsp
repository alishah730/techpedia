<!DOCTYPE HTML>
<html ng-app="techpedia">
<head>
<meta charset="utf-8" />
<title>Techpedia</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<link href="http://fonts.googleapis.com/css?family=Roboto:100,100italic,300,300italic,400,400italic"
	rel="stylesheet" type="text/css" />
<!-- 
<noscript> -->
<link rel="stylesheet" href="css/skel-noscript.css" />
<!-- </noscript> -->
<link rel="stylesheet" href="css/style2.css">
<link rel="stylesheet" href="css/style-wide.css" />

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet" href="css/select2.css">
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/prettyphoto.css">
<!-- for gallery -->
<!-- <link rel="stylesheet" href="css/skins/teal.css">
 -->
<!-- skin color -->
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
     <script src="js/respond.min.js"></script>
 <![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/init.js"></script>
<script src="js/dashboardJs/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function noBack() {
		window.history.forward();
	}
	noBack();
	window.onload = noBack;
	window.onpageshow = function(evt) {
		if (evt.persisted)
			noBack();
	}
	window.onunload = function() {
		void (0);
	}
</script>

</head>
<body ng-controller="IndexController" ng-init="InitLoad()">

	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '700867383301572',
				xfbml : true,
				version : 'v2.1'
			});
		};

		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="./"> <img src="images/logo.png" alt="logo"
					class="logo-default" width="35" height="35" style="margin-top: -5px;" /><span
					class="pos_fixed" style="color: white;"> &nbsp;Techpedia</span></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<%
						if (session.getAttribute("username") != null) {
					%>
					<li class="active"><a href="dashboard">Dashboard</a></li>

					<%
						} else {
					%>
					<li class="active"><a href="./">Home</a></li>
					<%
						}
					%>
					<li><a href="projects">Projects</a></li>
					<li><a href="challenges">Challenges</a></li>
					<li><a href="mentors">Mentors</a></li>
					<%
						if (session.getAttribute("username") != null) {
					%>



					<li><div class="top-menu,collapse navbar-collapse">
							<ul class="nav navbar-nav pull-right,nav navbar-nav navbar-right">

								<!-- END TODO DROPDOWN -->
								<!-- BEGIN USER LOGIN DROPDOWN -->
								<li class="dropdown dropdown-user"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> <span
										class="username"> Hi, <%=session.getAttribute("username")%>
									</span> <i class="fa fa-angle-down"></i>
								</a>
									<ul class="dropdown-menu">
										<li><a href="editProfile"> <i class="fa fa-pencil-square-o"></i> Edit Profile
										</a></li>

										<li><a href="logout"> <i class="fa fa-share-square-o"></i> Log Out
										</a></li>
									</ul></li>
								<!-- END USER LOGIN DROPDOWN -->
								<!-- BEGIN QUICK SIDEBAR TOGGLER -->

								<!-- END QUICK SIDEBAR TOGGLER -->
							</ul>
						</div></li>
					<%-- 	<li><a href="logout">Logout</a></li><br>
			<li><a href="dashboard">Hi, <%=session.getAttribute("username") %> </a></li>
		 --%>
					<%
						} else {
					%>

					<li><a href="#signin" data-toggle="modal" data-target=".bs-modal-sm">Login</a></li>
					<li><a href="register">Register</a></li>

					<%
						}
					%>

					<!-- <li><a href="#signin" data-toggle="modal" data-target=".bs-modal-sm">Login</a></li>
					<li><a href="register">Register</a></li> -->
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<section id="header" class="dark">
		<header>
			<h1>Welcome to Techpedia</h1>
			<p>creativity,collaboration, compassion</p>
		</header>
		<footer>
			<a href="#first" class="button scrolly">What we do <span
				class="glyphicon glyphicon-arrow-down"></span></a>
		</footer>
	</section>

	<!-- First -->
	<section id="first" class="main">
		<header>
			<div class="container">
				<h2>
					"The most pathetic person in the world is some one who has sight but no vision"<br>- Helen
					Keller
				</h2>
			</div>
		</header>
		<div class="content dark style1 featured">
			<div class="container">
				<div class="row">
					<div class="4u">
						<section>
							<span class="feature-icon"><span class="fa fa-cloud"></span></span>
							<header>
								<h3>Ideate</h3>
							</header>
						</section>
					</div>
					<div class="4u">
						<section>
							<span class="feature-icon"><span class="fa fa-check-square-o"></span></span>

							<h3>Mentor</h3>
						</section>
					</div>
					<div class="4u">
						<section>
							<span class="feature-icon"><span class="fa fa-group"></span></span>
							<header>
								<h3>Collaborate</h3>
							</header>
						</section>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Second -->
	<section id="second" class="main">
		<header>
			<div class="container">
				<h2>Welcome</h2>
				<p>
					Techpedia, an initiative at SRISTI aims at putting the problems of micro, small and medium
					enterprises, informal sector, grassroots innovators and other social sectors on the agenda of
					the young technology students across the country. <a href="aboutus">Read More</a>
				</p>
			</div>
		</header>
		<div class="content dark style2">
			<div class="container">
				<div class="row">
					<div class="col-xs-6">
						<section>
							<div class="Spotlights">
								<div>
									<h3 style="cursor: pointer;" ng-click="viewProject(project)">{{project.projTitle}}</h3>
									<p style="cursor: pointer;" ng-click="viewProject(project)">{{project.projDescription}}
									
									<p>
									<footer>
										<a href="projects" class="button scrolly">See all</a>
									</footer>
								</div>
							</div>
						</section>
					</div>

					<div class="col-xs-6">
						<div class="row no-collapse">
							<div class="col-xs-12">
								<a style="cursor: pointer;" ng-click="viewProject(project)" class="image full"><img
									src="{{project.projImage||'images/no_project.png'}}" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Third -->
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
								<p class="welcome">
									{{testimonial.testimonial}} <cite>- {{testimonial.cite}}</cite>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Modal -->
	<jsp:include page="template/loginModal.jsp" />
</body>
</html>
<jsp:include page="template/footer.jsp" />
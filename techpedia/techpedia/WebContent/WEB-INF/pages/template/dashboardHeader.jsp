<head>
<meta charset="utf-8" />
<title>Techpedia</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=8">
<meta charset="utf-8" />
<meta HTTP-EQUIV="Pragma" content="no-cache">
<meta HTTP-EQUIV="Expires" content="-1">
Set the viewport width to device width for mobile
<meta name="viewport" content="width=device-width" /> -->

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<!-- 
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<link rel="stylesheet" href="css/homepage.css">
<link rel="stylesheet" href="css/nivoslider.css"> -->
<link rel="stylesheet" href="css/select2.css">
<link rel="stylesheet" href="css/select2-bootstrap.css">
<!-- <link rel="stylesheet" href="css/prettyphoto.css"> -->
<!-- for gallery -->
<!-- <link rel="stylesheet" href="css/skins/teal.css"> -->
<!-- skin color -->
<link rel="stylesheet" href="css/jquery-ui.css">

<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<!-- <link href="http://fonts.googleapis.com/css?family=Roboto:100,100italic,300,300italic,400,400italic" rel="stylesheet" type="text/css" /> -->
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
<link href="css/dashboardCss/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="css/dashboardCss/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/dashboardCss/uniform.default.css" rel="stylesheet" type="text/css" />
<link href="css/dashboardCss/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="css/dashboardCss/jquery.gritter.css" rel="stylesheet" type="text/css" />
<!-- <link href="css/dashboardCss/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
<link href="css/dashboardCss/fullcalendar.css" rel="stylesheet" type="text/css" />
<link href="css/dashboardCss/jqvmap.css" rel="stylesheet" type="text/css" /> -->
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="css/dashboardCss/tasks.css" rel="stylesheet" type="text/css" />
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="css/dashboardCss/components.css" rel="stylesheet" type="text/css" />
<link href="css/dashboardCss/plugins.css" rel="stylesheet" type="text/css" />
<link href="css/dashboardCss/layout.css" rel="stylesheet" type="text/css" />
<link href="css/dashboardCss/darkblue.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="css/dashboardCss/custom.css" rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
<![endif]-->
</head>
<!-- END HEAD -->
<body class="page-header-fixed page-quick-sidebar-over-content">
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

	<!-- BEGIN HEADER -->
	<div class="page-header navbar navbar-fixed-top">
		<!-- BEGIN HEADER INNER -->
		<div class="page-header-inner">
			<!-- BEGIN LOGO -->
			<div class="page-logo">
				<!-- <a href="index.html"> -->
				<a class="navbar-brand" href="./" style="padding-top: 5px;"> <img src="images/logo.png"
					alt="logo" class="logo-default" width="35" height="35" /><span style="color: white;">
						Techpedia</span></a>

				<div class="menu-toggler sidebar-toggler hide">
					<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
				</div>
			</div>
			<!-- END LOGO -->
			<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse"
				data-target=".navbar-collapse"><i class="fa fa-bars fa-2x" id="icon-bgclr"></i> </a>
			<!-- END RESPONSIVE MENU TOGGLER -->
			<!-- BEGIN TOP NAVIGATION MENU -->

			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<%
						if (session.getAttribute("username") != null) {
					%>
					<!-- END TODO DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown dropdown-user"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> <img alt=""
							class="img-circle" src="<%=session.getAttribute("photo")%>" /> <span class="username">
								Hi, <%=session.getAttribute("username")%>
						</span> <i class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown-menu">
							<li><a href="editProfile"> <i class="fa fa-pencil-square-o"></i> Edit Profile
							</a></li>

							<li><a href="logout"> <i class="fa fa-power-off"></i> Log Out
							</a></li>

						</ul></li>
					<%
						} else {
					%>

					<!-- <span class="username" style="color:white; position:relative;float:right;top:8px;"><i class="fa fa-user fa-2x"></i>
					Hi, Guest!</span> -->
					<li><div class="top-menu,collapse navbar-collapse">
							<ul class="nav navbar-nav pull-right,nav navbar-nav navbar-right">

								<!-- END TODO DROPDOWN -->
								<!-- BEGIN USER LOGIN DROPDOWN -->
								<li class="dropdown dropdown-user"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> <i
										class="fa fa-user"></i> <span class="username"> Hi, Guest! </span> <i
										class="fa fa-angle-down"></i>
								</a>
									<ul class="dropdown-menu">
										<li><a href="#signin" data-toggle="modal" data-target=".bs-modal-sm"><i
												class="fa fa-sign-in"></i>Login</a></li>
										<li><a href="register"><i class="fa fa-book"></i>Register</a></li>
									</ul></li>
								<!-- END USER LOGIN DROPDOWN -->
								<!-- BEGIN QUICK SIDEBAR TOGGLER -->

								<!-- END QUICK SIDEBAR TOGGLER -->
							</ul>
						</div></li>

					<%
						}
					%>

					<!-- END USER LOGIN DROPDOWN -->
					<!-- BEGIN QUICK SIDEBAR TOGGLER -->

					<!-- END QUICK SIDEBAR TOGGLER -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END HEADER INNER -->
	</div>
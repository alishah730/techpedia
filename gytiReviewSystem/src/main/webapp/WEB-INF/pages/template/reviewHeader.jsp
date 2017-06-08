<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html ng-app="techpedia">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<!-- Please maintain the order, keep jQuery min .js on top -->
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<!-- <script src="https://code.jquery.com/jquery-2.2.3.min.js"   integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="   crossorigin="anonymous"></script> -->
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script> -->
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-animate.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-aria.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-messages.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-touch.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-material/1.0.9/angular-material.min.js"></script>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://storage.googleapis.com/code.getmdl.io/1.0.6/material.min.js"></script>

<script src='https://cdnjs.cloudflare.com/ajax/libs/velocity/1.2.2/velocity.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/velocity/1.2.2/velocity.ui.min.js'></script>



<script src="js/jquery.menu-aim.js"></script>
<script src="js/modernizr.js"></script>
 <script src="js/main.js"></script>
<script src="js/windowResize.js"></script>

<!-- <!-- Compiled and minified CSS
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

  Compiled and minified JavaScript
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script> -->



<!-- <css> -->

<!-- <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/angular-material/1.0.9/angular-material.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.6/material.indigo-pink.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">


<link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->





<link rel="stylesheet" href="css/MegaNavbar.css">
<script type="text/javascript" src="js/ReviwerAdminController.js"></script>
<style type="text/css">
@
-webkit-viewport {
	width: device-width;
}

@
-moz-viewport {
	width: device-width;
}

@
-ms-viewport {
	width: device-width;
}

@
-o-viewport {
	width: device-width;
}

@
viewport {
	width: device-width;
}

#main_navbar {
	-webkit-transition: height 0.3s;
	-moz-transition: height 0.3s;
	transition: height 0.3s;
}

.header {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	background: #cc5350;
	color: #fff;
	z-index: 1000;
	height: 200px;
	overflow: hidden;
	-webkit-transition: height 0.3s;
	-moz-transition: height 0.3s;
	transition: height 0.3s;
	text-align: center;
	line-height: 160px;
}

.header.shrink {
	height: 100px;
	line-height: 80px;
}

.header h1 {
	font-size: 30px;
	font-weight: normal;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.navbar-fixed-bottom, .navbar-fixed-top {
	font-size: 24px;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.header.shrink h1 {
	font-size: 24px;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.affix {
	top: 0;
	width: 100%;
	-webkit-transition: all .5s ease-in-out;
	transition: all .5s ease-in-out;
}

.affix-top {
	position: static;
	top: -35px;
}

.affix+.container-fluid {
	padding-top: 70px;
}


#mainPanelBody{
margin-left: 0px;
padding-right: 0px !important;
padding-left: 0px !important; 
/* background-color: #d3d3d3;
box-shadow: 0 0 2em #b2b2b2; */
margin-top: 55px;
}
#mainPanelBodyIndex{
margin-left: 0px;
padding-right: 0px !important;
padding-left: 0px !important; 
/* background-color: #d3d3d3;
box-shadow: 0 0 2em #b2b2b2; */
margin-top: 55px;
}
.breadcrumb {
margin-bottom: 0px !important;
}
.md-headline {
    font-size: 16px;
    font-weight: 400;
    line-height: 20px;
}
/* @media (max-width: 767px) {
  .sr-only-xs {
    position: absolute;
    width: 1px;
    height: 1px;
    padding: 0;
    margin: -1px;
    overflow: hidden;
    clip: rect(0,0,0,0);
    border: 0;
  }
} */
@media (max-width: 767px){
body{
	overflow:auto;
	overflow-x: scroll;
	overflow-x: visible !important;
  }
 .modal-dialog{
 width: 95% !important;
 }
}

</style>

</head>
<body ng-controller="ReviewHeaderController" ng-init="InitLoad()">
	<header class="cd-main-header row" style="margin:0% !important">
		<a href="#0" class="cd-logo"><span id="openSideNav" class="w3-opennav w3-xlarge" onclick="w3_open()" style="color: white">&#9776; &nbsp;&nbsp;&nbsp;</span></a>
		 <div class="col-xs-4 col-xs-offset-4" style=" padding-top: 1%; text-align: center;font-size:2vh; color: white; font-weight: bold">
			<p>GYTI REVIEW SYSTEM</p>
		</div>
		<a href="#0" class="cd-nav-trigger">Menu<span></span></a>

		<nav class="cd-nav" style="z-index: 50">
		
			<ul class="cd-top-nav" style="z-index: 50">
				<%if(session.getAttribute("revfirstName")!=null){
				%>
				<li class="has-children account" style="z-index: 50">
					<a href="#0">
						Hi,&nbsp; <%=session.getAttribute("revfirstName")%>
					</a>
					<ul style="z-index: 50">

						<!-- <li><a href="#0"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;My Account</a></li> -->
						<li style="z-index: 50"><a  style="z-index: 50"href="editReviewerProfile"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;Edit Account</a></li>
						<li style="z-index: 50"><a style="z-index: 50" href="reviewerLogout"> <i class="fa fa-power-off" aria-hidden="true"></i><span
							class="title">&nbsp;Logout</a></li>
					</ul>
				</li>
				<%}else{
					%>
					<li class="">
					<a href="#">
					</a>
					</li>
					
				<% }%>
			</ul>
		</nav>
	</header> <!-- .cd-main-header -->
	 <!-- <svg id="svg-playground" height="100vh" class="col-xs-12 col-md-12" style="background-color:transparent;z-index:0;" >

    <circle class="simple-circle" cx="50" cy="50" r="100" stroke="transparent" stroke-width="3" fill="blue" />
	</svg> -->
	
	<a href="#0" class="cd-top">Top</a>
	<script type="text/javascript">
	$( document ).ready(function() {
		$('#sideNavPanel').show();
		//$('#sideNavPanel').hide();
		/* $('#mainPanelBody').addClass('col-xs-10 col-md-10');
		$('#mainPanelBody').removeClass('col-xs-10 col-md-10');*/
		/* $(window).on('load resize', function(){
			var win = $(this);
			if (win.width() < 766) {
		$('#sideNavPanel').addClass('col-xs-2 col-md-2');
		$('#mainPanelBody').addClass('col-xs-10 col-md-10') ;
			}
		}); */
		//$.cookie("currentURL",window.location.href);
		$('.modal').each(function (index) {
			    $(this).on('show.bs.modal', function (e) {
			        var open = $(this).attr('data-easein');
			        
			            $('.modal-dialog').velocity('transition.' + open);
			    });
			});
	});
	</script>
	<script>
	
		//$('#sideNavPanel').hide();
		function w3_open() {
			$('#sideNavPanel').show(300);
			$('#mainPanelBody').addClass('col-xs-10 col-md-10');
			$('#sideNavPanel').addClass('col-xs-2 col-md-2');
		}
		function w3_close() {
			$('#sideNavPanel').hide(300);
			$('#mainPanelBody').removeClass('col-xs-10 col-md-10');
			$('#mainPanelBody').addClass('col-xs-12 col-md-12');
		}
		 
		//$.cookie("currentURL",window.location.href);
		document.body.addEventListener('touchmove', function(){
 			 setTimeout(function(){
   					console.log('Touch Move');
 			 }, 1000);
});
</script>

</body>
</html>
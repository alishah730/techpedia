<!DOCTYPE&nbsp;html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6"> <![endif]-->
<!--[if IE 7 ]> <html lang="en" class="ie7"> <![endif]-->
<!--[if IE 8 ]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9 ]> <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html ng-app="techpedia" xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-US" lang="en-US"> <!--<![endif]-->


<!-- BEGIN HEAD -->
  <head>  
  <style>
  .breadcrumb>li+li:before {
padding: 0 5px;
color: #ccc;
content: none;
} 
.style{
background-color:#FAFAF7;
padding:20px;
max-width:1130px;
border-radius:5px;

}
  </style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Techpedia</title>	
	<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico" >
	<!-- <link rel="icon" href="images/favicon.ico" type="image/x-icon"> -->

  <!--  <meta content="" name="Lightweight and pure CSS MegaNavbar component, that uses the standard navbar markup, and the fluid grid system classes from Bootstrap 3. Work for fixed and responsive layout, and has the facility to include any Bootstrap component except dropdown. MegaNavbar is compatible with mobile devices and modern web browsers." />
    <meta content="" name="MegaNavbar.com" /> -->

    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">  <!--for Bootstrap CDN version-->
    <!--or for Bootstrap local/server version: <link href="js/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->

    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"> <!--for Font Awesome CDN version-->
    <!--or for Font Awesome local/server version: <link href="MegaNavbar/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"> -->

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link rel="stylesheet" type="text/css" href="css/MegaNavbar.css"/>
    <link rel="stylesheet" type="text/css" href="css/skins/navbar-inverse.css" title="inverse">
    <link rel="stylesheet" type="text/css" href="css/animation/animation.css" title="inverse">

    <!--Highlight-->
    <link href="js/documentation/assets/plugins/highlight/styles/github.css" rel="stylesheet" type="text/css" />
    
    <!-- jQuery JavaScript CDN version (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!--or for jQuery JavaScript local/server version: <script src="MegaNavbar/assets/plugins/jquery-1.11.1.min.js"></script>  -->

    <!-- Latest compiled and minified Bootstrap JavaScript CDN version -->
   <!--  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
    <!-- or for Bootstrap JavaScript local/server version: --> <script src="js/plugins/bootstrap/js/bootstrap.min.js"></script> 

    <!--Highlight-->
    <script src="documentation/assets/plugins/highlight/highlight.pack.js" type="text/javascript"></script>
    <script>hljs.initHighlightingOnLoad();</script>
	<!-- max image JS  -->
	<script type="text/javascript" src="js/plugins/jquery.maximage.js" charset="utf-8"></script>	
	<script type="text/javascript" src="js/plugins/jquery.superbgimage.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/plugins/jquery.cycle.all.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/plugins/jquery.cycle.all.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/plugins/response.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/plugins/devrama-slider.js" charset="utf-8"></script>
	
	<script type="text/javascript" src="js/plugins/jquery.fractionslider.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/plugins/jquery.jcarousel.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/plugins/jquery.localscroll.js" charset="utf-8"></script> 
	<script type="text/javascript" src="js/plugins/jquery.masonry.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/plugins/jquery.scrollto.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/plugins/jquery.slickforms.js" charset="utf-8"></script>
	
	<!-- CSS Files -->	
	<link rel="stylesheet" type="text/css" href="css/jquery.maximage.css">
	<link rel="stylesheet" type="text/css" href="css/jquery.maximage.min.css" />
	<!--<link rel="stylesheet" type="text/css" href="assets/css/screen.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/sliderstyle.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/fractionslider.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/reset.css" />-->
	
	
	
	
	
	
	<link href='http://fonts.googleapis.com/css?family=Signika:300&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
		<style>
		.toTop {position: fixed;right: 15px;bottom: 56px;z-index: 10000;color: #999;}
		.customFont {
			font-family: 'Signika', sans-serif;

		}
		.borderRadius {
			border-radius: 5px;
		}
		.collapse > p {
		font-size : 18px !important;		
		}
	</style>
</head>

<script type="text/javascript">

    function toggle_visibility(id) {
       var e = document.getElementById(id);
       if(e.style.display == 'block')
          e.style.display = 'none';
       else
          e.style.display = 'block';
    }
	
jQuery(document).ready(function() {

$('#my-slide').DrSlider({
    width: 1130,
    height: 400,
    userCSS: false,
    transitionSpeed: 1000,
    duration: 4000,
    showNavigation: true,
    classNavigation: undefined,
    navigationColor: '#4b4640',
    navigationHoverColor: '#000000',
    navigationHighlightColor: '#DFDFDF',
    navigationNumberColor: '#000000',
    positionNavigation: 'out-center-bottom',
    navigationType: 'circle',
    showControl: true,
    classButtonNext: undefined,
    classButtonPrevious: undefined,
    controlColor: '#FFFFFF',
    controlBackgroundColor: '#000000',
    positionControl: 'left-right',
    transition: 'slide-left',
    showProgress: true,
    progressColor: '#faebd7',
    pauseOnHover: true,
    onReady: undefined
});
	
	$(function(){
	  $('#maximage').maximage({
		cycleOptions: {
			fx: 'fade',
			// Speed has to match the speed for CSS transitions
			speed: 20000, 

		},		
		// cssBackgroundSize might be causing choppiness in retina display safari
		cssBackgroundSize: false 
	  });

	});

$(window).load(function(){
	/*$('.slider').fractionSlider({
		'fullWidth': 			true,
		'controls': 			true, 
		'pager': 				true,
		'responsive': 			true,
		'dimensions': 			"1000,400",
	    'increase': 			false,
		'pauseOnHover': 		true,
		'slideEndAnimation': 	true
	}); */

});
});
</script>

<body>

	
	<div id="maximage">
	<img src="images/art/bg1.jpg" alt="" width="1400" height="1050" />        
	<img src="images/art/bg2.jpg" alt="Coalesse" width="1400" height="1050" />
	<img src="images/art/bg3.jpg" alt="" width="1400" height="1050" />
	<img src="images/art/bg4.jpg" alt="" width="2048" height="1536" />
	<img src="images/art/bg5.jpg" alt="" width="2048" height="1536" />
	<!-- <img src="images/art/bg6.jpg" alt="" width="2048" height="1536" />
	<img src="images/art/bg7.jpg" alt="" width="2048" height="1536" /> -->
	</div>
	
		<div id="header">
			<div class="logo opacity" style="padding-left: 105px; padding-top: 10px; padding-bottom: 20px; border-radius: 5px;"><a href="./">
			<img style="width: 272px; height: 65px;
"src="images/Techpedia.png" alt="" /></a></div>
		</div>
	
	
	<!-- START OF NAV MENU -->
  <%--   <div class="container customFont">
    	<nav class="navbar navbar-inverse borderRadius" id="main_navbar" role="navigation">
    		<div class="container-fluid">
    			<!-- Brand and toggle get grouped for better mobile display -->
    			<div class="navbar-header">
    				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
    				<span class="sr-only">Toggle navigation</span>
    				<span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
    				</button>
    				<a class="navbar-brand" style="font-size:16px;" href="./"><i class="fa fa-home"></i> Home</a>
    			</div>
    			<!-- Collect the nav links, forms, and other content for toggling -->
    			<div class="collapse navbar-collapse" id="navbar-collapse-1">
    				<!-- text -->
    				<!-- <p class="navbar-text navbar-left"><i class="fa fa-h-square"></i>&nbsp;<span class="hidden-sm hidden-md">Mentors</span></p> -->
    				<a href="mentors" class="navbar-link navbar-left"><i class="fa fa-user"></i>&nbsp;<span class="hidden-sm hidden-md">Mentors</span></a>
    				<!-- regular link -->
    					
    			
    				
    				<a href="projects" class="navbar-link navbar-left"><i class="fa fa-cog"></i>&nbsp;<span class="hidden-sm hidden-md">Projects</span></a>
    					<%
    				if(session.getAttribute("username")!= null){
    				%>
    				<a href="manageProjects" class="navbar-link navbar-left"><i class="fa fa-cog"></i>&nbsp;<span class="hidden-sm hidden-md">Manage Projects</span></a>
    				<%
    				}%>
    				<a href="challenges" class="navbar-link navbar-left"><i class="fa fa-thumbs-o-up"></i>&nbsp;<span class="hidden-sm hidden-md">Challenges</span></a>
    					<%
    				if(session.getAttribute("username")!= null){
    				%>
    				<a href="manageChallenge" class="navbar-link navbar-left"><i class="fa fa-cog"></i>&nbsp;<span class="hidden-sm hidden-md">Manage Challenges</span></a>
    				<%
    				}%>
    				<ul class="nav navbar-nav navbar-left">
    					<!-- divider -->
    							 <li class="dropdown-short">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle" aria-expanded="true"><i class="fa fa-thumbs-o-up"></i>&nbsp<span class="hidden-sm">Challenges</span><span class="caret"></span></a>
    					
    						<ul class="dropdown-menu" id="challengesLi">
    						
    													 <li><a href="challenges"><i class="fa fa-book fa-fw"></i>&nbsp;View Challenges</a></li>
    						
    				<%
    				if(session.getAttribute("username")!= null){
    				%>
    					<li class="divider"></li>
 								<li class="active"><a href="manageChallenge"><i class="fa fa-pencil fa-fw"></i>&nbsp;Manage Challenges<span class="desc">View and Manage Challenges</span></a></li>
    							<%
    				}%>
    					</ul>
    					</li> 
    						 <li class="dropdown-short">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle" aria-expanded="true"><i class="fa fa-cog"></i>&nbsp;<span class="hidden-sm">Projects</span><span class="caret"></span></a>
    						<ul class="dropdown-menu" id="projectsLi">
<!--     							<li class="dropdown-header">Header. Menu items</li> -->
    							<!-- <li class="active"><a href="projects" class=""><span class="desc">Projects</span></a></li> -->
    							<li><a href="projects"><i class="fa fa-book fa-fw"></i>&nbsp;View Projects</a></li>


    								<%
    				if(session.getAttribute("username")!= null){
						 
    				%>
    				<li class="divider"></li>
								<li class="active"><a href="manageProjects"><i class="fa fa-cog fa-spin"></i>&nbsp; Manage Projects<span class="desc">View and Manage Projects</span></a></li>
    							<%
    				}%>
    				
    						
    						</ul>
    					</li>
    					
    					<li class="divider"></li>
    					    				<%
    				if(session.getAttribute("username")!= null){
    					%>
    				<a href="dashboard" class="navbar-link navbar-left"><i class="fa fa-link"></i>&nbsp;<span class="hidden-sm hidden-md">Dashboard</span></a>
    				<%
    				}
    				else {
    				%>
    				<li class="dropdown-short disabled hidden-sm hidden-md"><a>Dashboard</a></li>
    				<%
    				}
					%>
    					
    					<!-- dropdown default -->
    					<!-- <li class="dropdown-short">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle" aria-expanded="true"><i class="fa fa-bars"></i>&nbsp;<span class="hidden-sm">Short</span><span class="caret"></span></a>
    						<ul class="dropdown-menu">
    							<li class="dropdown-header">Header. Menu items</li>
    							<li class="divider"></li>
    							<li class="dropdown-right-onhover no-fix">
    								Menu item with submenu
    								<a href="javascript:;" data-toggle="collapse" data-target="#id_3ac0aa8ea29f2302" class="dropdown-toggle collapsed"><i class="fa fa-bars"></i> With submenu<span class="desc">Show on hover &amp; don't fix</span></a>
    								start submenu
    								<ul class="dropdown-menu collapse" id="id_3ac0aa8ea29f2302">
    									<li class="dropdown-header">Submenu header</li>
    									<li class="divider"></li>
    									<li class="dropdown-right-onhover">
    										Menu item with submenu
    										<a href="javascript:;" data-toggle="collapse" data-target="#id_c7a0dc0830f7d307" class="dropdown-toggle collapsed"><i class="fa fa-bars"></i> With submenu<span class="desc">Show on hover &amp; fix on click</span></a>
    										start submenu
    										<ul class="dropdown-menu collapse" id="id_c7a0dc0830f7d307">
    											<li class="dropdown-header">Submenu header</li>
    											<li class="divider"></li>
    											<li><a href="#" class="">Default item<span class="desc">Default description</span></a></li>
    											<li class="active"><a href="#" class="">Active item<span class="desc">Active description</span></a></li>
    											<li class="disabled"><a href="#" class="">Disabled item<span class="desc">Disabled description</span></a></li>
    											<li class="open"><a href="#" class="">Open item<span class="desc">Open description</span></a></li>
    											<li class="divider"></li>
    											<li>
    												<p><a href="#&quot;"><i class="fa fa-link"></i> Regular link<span class="desc">Regular link description</span></a></p>
    											</li>
    											<li class="divider"></li>
    											<li><a href="#">Separated link</a></li>
    										</ul>
    										end submenu
    									</li>
    									<li><a href="#" class="">Default item<span class="desc">Default description</span></a></li>
    									<li class="active"><a href="#" class="">Active item<span class="desc">Active description</span></a></li>
    									<li class="disabled"><a href="#" class="">Disabled item<span class="desc">Disabled description</span></a></li>
    									<li class="open"><a href="#" class="">Open item<span class="desc">Open description</span></a></li>
    									<li class="divider"></li>
    									<li>
    										<p><a href="#&quot;"><i class="fa fa-link"></i> Regular link<span class="desc">Regular link description</span></a></p>
    									</li>
    									<li class="divider"></li>
    									<li><a href="#">Separated link</a></li>
    								</ul>
    								end submenu
    							</li>
    							<li class="divider"></li>
    							<li><a href="#">Default item<span class="desc">Default description</span></a></li>
    							<li class="active"><a href="#" class="">Active item<span class="desc">Active description</span></a></li>
    							<li class="disabled"><a href="#" class="">Disabled item<span class="desc">Disabled description</span></a></li>
    							<li class="open"><a href="#" class="">Open item<span class="desc">Open description</span></a></li>
    							<li class="divider"></li>
    							<li>
    								<p><a href="#&quot;">Regular link<span class="desc">Regular link description</span></a></p>
    							</li>
    							<li class="divider"></li>
    							<li>
    								<form class="navbar-form navbar-right" role="search" style="margin-left: -15px;">
    									<div class="input-group"><input type="text" placeholder="input" class="form-control"><span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i>&nbsp;</button></span></div>
    								</form>
    							</li>
    						</ul>
    					</li> -->
    					<!-- divider -->
    					<!-- <li class="divider"></li>
    					dropdown disabled
    					<li class="dropdown-short disabled hidden-sm hidden-md"><a>Disabled</a></li>
    					divider
    					<li class="divider hidden-sm hidden-md"></li> -->
    					<!-- wide -->
    					<!-- <li class="dropdown-wide">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle"><i class="fa fa-check-square-o"></i>&nbsp;<span class="hidden-sm hidden-md">Wide</span><span class="caret"></span></a>
    						<ul class="dropdown-menu">
    							<li class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
    								<address>
    									<br>
    									<strong>MegaNavbar, Inc.</strong><br>
    									123 Folsom Ave, Suite 456<br>
    									San Francisco, CA 987654<br>
    									<abbr title="Phone">P:</abbr> (123) 456-7890
    								</address>
    								<address>
    									<strong>Full Name</strong><br>
    									<a href="mailto:#">first.last@example.com</a>
    								</address>
    							</li>
    							<li class="col-xs-6 col-sm-8 col-md-5 col-lg-5">
    								<form role="form">
    									<div class="form-group">
    										<label for="exampleInputEmail1">Email address</label>
    										<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
    									</div>
    									<div class="form-group">
    										<label for="exampleInputPassword1">Password</label>
    										<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    									</div>
    									<div class="form-group">
    										<div class="col-sm-8">
    											<div class="checkbox"><label><input type="checkbox"> Remember me</label></div>
    										</div>
    										<div class="col-sm-4">
    											<button type="submit" class="pull-right btn btn-default" onclick="userLogin();">Submit</button>
    										</div>
    									</div>
    								</form>
    							</li>
    							<li class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
    								<div class="embed-responsive embed-responsive-16by9">
    									<iframe class="embed-responsive-item" src="http://mapsurl.appspot.com/google/iframe.html#01L-sstHl9h2O"></iframe>
    								</div>
    							</li>
    						</ul>
    					</li> -->
    					<!-- divider -->
    					<!-- <li class="divider"></li>
    					<li class="dropdown-full dropdown-onhover">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle" aria-expanded="true"><i class="fa fa-leaf"></i>&nbsp;<span class="hidden-sm hidden-md">Envato</span><span class="caret"></span></a>
    						<div class="dropdown-menu no-padding HingeUpToDown">
    							<ul>
    								<li class="col-sm-12 dropdown-header text-center" style="padding-bottom: 15px; border-bottom: 1px solid #555; background: #1abc9c;color: white; margin: 0 -1px; width: calc(100% + 2px);">
    									<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
    									<h4><i class="fa fa-refresh fa-spin"></i> Everything you need for your next creative project.</h4>
    									<small class="" style="font-size: 13px; font-weight: normal; white-space: normal;">Over 4.5 million digital products created by a global community of designers, developers, photographers, illustrators &amp; producers.</small>
    									<p class="" style="font-size: 14px; font-weight: normal;"><i class="fa fa-arrow-down"></i> Try to click... <i class="fa fa-chevron-left"></i><i class="fa fa-chevron-right"></i> Try to resize</p>
    								</li>
    							</ul>
    							<ul id="myTab" style="margin-top: 1px;">
    								<li class="col-lg-2 col-md-2 col-sm-2 col-xs-6 no-padding" style="border-right: 1px solid #555;"><a href="#themeforest" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #1abc9c"></i> Themeforest<span class="desc"> marketplace</span></a></li>
    								<li class="col-lg-2 col-md-2 col-sm-2 col-xs-6 no-padding" style="border-right: 1px solid #555;"><a href="#codecanyon" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #e78733;"></i> Codecanyon<span class="desc"> marketplace</span></a></li>
    								<li class="col-lg-2 col-md-2 col-sm-2 col-xs-6 no-padding" style="border-right: 1px solid #555;"><a href="#videohive" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #e7a802;"></i> Videohive<span class="desc"> marketplace</span></a></li>
    								<li class="col-lg-2 col-md-2 col-sm-2 col-xs-6 no-padding" style="border-right: 1px solid #555;"><a href="#activeden" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #d35400;"></i> Activeden<span class="desc"> marketplace</span></a></li>
    								<li class="col-lg-2 col-md-2 col-sm-2 col-xs-6 no-padding" style="border-right: 1px solid #555;"><a href="#3docean" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #ab0f34;"></i> 3docean<span class="desc"> marketplace</span></a></li>
    								<li class="hidden-sm hidden-md hidden-lg col-xs-6 no-padding"><a href="#graphicriver" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #308eb1"></i> Graphicriver<span class="desc"> marketplace</span></a></li>
    								<li class="hidden-sm hidden-md hidden-lg col-xs-6 no-padding" style="border-right: 1px solid #555;"><a href="#audiojungle" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #9ac130"></i> Audiojungle<span class="desc"> marketplace</span></a></li>
    								<li class="hidden-sm hidden-md hidden-lg col-xs-6 no-padding"><a href="#photodune" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #0f8c98"></i> Photodune<span class="desc"> marketplace</span></a></li>
    								<li class="hidden-xs col-lg-2 col-md-2 col-sm-2 no-padding no-border-radius no-shadow dropdown-center-onhover no-fix rtl">
    									<a data-toggle="collapse" data-target="#id_4640f9fd6be74fcf" class="dropdown-toggle collapsed" aria-expanded="false"><i class="fa fa-star" style="color: #308eb1"></i><i class="fa fa-star" style="color: #9ac130"></i><i class="fa fa-star" style="color: #0f8c98"></i> More...<span class="desc">See more options</span></a>
    									<ul class="h-divided dropdown-menu no-padding col-lg-2 col-md-2 col-sm-2 col-xs-6 collapse" style="width: calc(100% + 2px); left: 0px; height: 2px;" id="id_4640f9fd6be74fcf" aria-expanded="false">
    										<li class="more"><a href="#graphicriver" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #308eb1"></i> Graphicriver<span class="desc"> marketplace</span></a></li>
    										<li class="more"><a href="#audiojungle" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #9ac130"></i> Audiojungle<span class="desc"> marketplace</span></a></li>
    										<li class="more"><a href="#photodune" role="tab" data-toggle="tab"><i class="fa fa-star" style="color: #0f8c98"></i> Photodune<span class="desc"> marketplace</span></a></li>
    									</ul>
    								</li>
    							</ul>
    							<div id="myTabContent" class="tab-content">
    								<div class="tab-pane" id="themeforest">
    									<ul class="row">
    										<li class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dropdown-header text-center" style="margin: 0 -1px; width: calc(100% + 2px); padding:0 15px;">
    											<h4 style="background: #1abc9c; color: white;">
    												16,000+ Site Templates and Themes from $3
    											</h4>
    										</li>
    									</ul>
    									<div class="divided">
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">All Items</a></li>
    											<li><a href="#">WordPress</a></li>
    											<li><a href="#">HTML</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Marketing</a></li>
    											<li><a href="#">CMS <span class="label label-danger pull-right">New</span></a></li>
    											<li><a href="#">eCommerce</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">PSD</a></li>
    											<li><a href="#">Tumblr</a></li>
    											<li><a href="#">Ghost</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Muse</a></li>
    											<li><a href="#">Plugins</a></li>
    											<li><a href="#">More...</a></li>
    										</ul>
    									</div>
    								</div>
    								<div class="tab-pane" id="codecanyon">
    									<ul class="row">
    										<li class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dropdown-header text-center" style="margin: 0 -1px; width: calc(100% + 2px); padding:0 15px;">
    											<h4 style="background: #e78733; color: white;">
    												10,000+ Scripts and Snippets from $2
    											</h4>
    										</li>
    									</ul>
    									<div class="divided">
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">All Items</a></li>
    											<li><a href="#">PHP Scripts</a></li>
    											<li><a href="#">WordPress</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">eCommerce</a></li>
    											<li><a href="#">JavaScript</a></li>
    											<li><a href="#">CSS</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Mobile</a></li>
    											<li><a href="#">HTML5</a></li>
    											<li><a href="#">Skins</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">WP Themes</a></li>
    											<li><a href="#">Plugins</a></li>
    											<li><a href="#">More</a></li>
    										</ul>
    									</div>
    								</div>
    								<div class="tab-pane " id="videohive">
    									<ul class="row">
    										<li class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dropdown-header text-center" style="margin: 0 -1px; width: calc(100% + 2px); padding:0 15px;">
    											<h4 style="background: #e7a802; color: white;">
    												100,000+ Royalty Free Video Files from $2
    											</h4>
    										</li>
    									</ul>
    									<div class="divided">
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">All Items</a></li>
    											<li><a href="#">Project Files</a></li>
    											<li><a href="#">Product Promo</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Apple Motion</a></li>
    											<li><a href="#">Motion Graphics</a></li>
    											<li><a href="#">Stock Footage</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Cinema 4D Templates</a></li>
    											<li><a href="#">Add Ons</a></li>
    											<li><a href="#">Logo Files</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">News Files</a></li>
    											<li><a href="#">Wedding Files</a></li>
    											<li><a href="#">More</a></li>
    										</ul>
    									</div>
    								</div>
    								<div class="tab-pane " id="activeden">
    									<ul class="row">
    										<li class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dropdown-header text-center" style="margin: 0 -1px; width: calc(100% + 2px); padding:0 15px;">
    											<h4 style="background: #d35400; color: white;">
    												11,000+ Flash &amp; Flex Files from $1
    											</h4>
    										</li>
    									</ul>
    									<div class="divided">
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">All Items</a></li>
    											<li><a href="#">Unity 3D</a></li>
    											<li><a href="#">Flash</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Animations</a></li>
    											<li><a href="#">Games</a></li>
    											<li><a href="#">Site Templates</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Video Players</a></li>
    											<li><a href="#">Image Viewers</a></li>
    											<li><a href="#">Flex</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Facebook Themes</a></li>
    											<li><a href="#">JSFL Extensions</a></li>
    											<li><a href="#">More</a></li>
    										</ul>
    									</div>
    								</div>
    								<div class="tab-pane " id="3docean">
    									<ul class="row">
    										<li class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dropdown-header text-center" style="margin: 0 -1px; width: calc(100% + 2px); padding:0 15px;">
    											<h4 style="background: #ab0f34; color: white;">
    												18,000+ 3D Models &amp; Accessories from $1
    											</h4>
    										</li>
    									</ul>
    									<div class="divided">
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">All Items</a></li>
    											<li><a href="#">3D Models</a></li>
    											<li><a href="#">Cars</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">HDRI Images</a></li>
    											<li><a href="#">CG Textures</a></li>
    											<li><a href="#">Materials &amp; Shaders</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Base Meshes</a></li>
    											<li><a href="#">Scripts &amp; Plugins</a></li>
    											<li><a href="#">2D Concepts</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Animation Data</a></li>
    											<li><a href="#">Render Setup</a></li>
    											<li><a href="#">More</a></li>
    										</ul>
    									</div>
    								</div>
    								<div class="tab-pane " id="graphicriver">
    									<ul class="row">
    										<li class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dropdown-header text-center" style="margin: 0 -1px; width: calc(100% + 2px); padding:0 15px;">
    											<h4 style="background: #308eb1; color: white;">
    												285,000+ Stock Graphics Files from $1
    											</h4>
    										</li>
    									</ul>
    									<div class="divided">
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">All Items</a></li>
    											<li><a href="#">Graphics</a></li>
    											<li><a href="#">Print</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Web Elements</a></li>
    											<li><a href="#">Add-ons</a></li>
    											<li><a href="#">Vectors</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Presentations</a></li>
    											<li><a href="#">Infographics</a></li>
    											<li><a href="#">Icons</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Fonts</a></li>
    											<li><a href="#">Logos</a></li>
    											<li><a href="#">More</a></li>
    										</ul>
    									</div>
    								</div>
    								<div class="tab-pane " id="audiojungle">
    									<ul class="row">
    										<li class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dropdown-header text-center" style="margin: 0 -1px; width: calc(100% + 2px); padding:0 15px;">
    											<h4 style="background: #9ac130; color: white;">
    												195,800 Royalty Free Audio Files from $1
    											</h4>
    										</li>
    									</ul>
    									<div class="divided">
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">All Items</a></li>
    											<li><a href="#">Music</a></li>
    											<li><a href="#">Music Packs</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Sound Effects</a></li>
    											<li><a href="#">Sound Packs</a></li>
    											<li><a href="#">Custom Sounds</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Source Files</a></li>
    											<li><a href="#">Source Packs</a></li>
    											<li><a href="#">Custom Source</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Logos</a></li>
    											<li><a href="#">Idents</a></li>
    											<li><a href="#">More ...</a></li>
    										</ul>
    									</div>
    								</div>
    								<div class="tab-pane " id="photodune">
    									<ul class="row">
    										<li class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dropdown-header text-center" style="margin: 0 -1px; width: calc(100% + 2px); padding:0 15px;">
    											<h4 style="background: #0f8c98 ; color: white;">
    												Royalty Free Stock Photography from $3
    											</h4>
    										</li>
    									</ul>
    									<div class="divided">
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">All Items</a></li>
    											<li><a href="#">Animals</a></li>
    											<li><a href="#">Architecture</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Business</a></li>
    											<li><a href="#">Food</a></li>
    											<li><a href="#">Health</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Sports</a></li>
    											<li><a href="#">People</a></li>
    											<li><a href="#">Technology</a></li>
    										</ul>
    										<ul class="col-sm-3 col-xs-6 col-md-3 h-divided">
    											<li><a href="#">Travel</a></li>
    											<li><a href="#">Nature</a></li>
    											<li><a href="#">More ...</a></li>
    										</ul>
    									</div>
    								</div>
    							</div>
    							<script>
    								$('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
    								    $('a[data-toggle="tab"]').each(function() {
    								 			    $(this).parent('li').removeClass('active');
    								    });
    								})

    								/*$('.carousel').carousel();*/
    							</script>
    						</div>
    					</li>
    			 -->	</ul>
    				<ul class="nav navbar-nav navbar-right">
    					<!-- search form -->
    					 <form class="navbar-form-expanded navbar-form navbar-left visible-lg-block visible-md-block visible-xs-block" role="search">
    						<div class="input-group">
    							<input type="text" class="form-control" data-width="80px" data-width-expanded="170px" placeholder="Search..." name="query">
    							<span class="input-group-btn"><button class="btn btn-default" type="submit"><i class="fa fa-search"></i>&nbsp;</button></span>
    						</div>
    					</form> 
    					<li class="dropdown-grid visible-sm-block">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle"><i class="fa fa-search"></i> Search</a>
    						<div class="dropdown-grid-wrapper" role="menu">
    							<ul class="dropdown-menu col-sm-6">
    								<li>
    									<form class="no-margin">
    										<div class="input-group">
    											<input type="text" class="form-control">
    											<span class="input-group-btn"><button class="btn btn-default" type="button">&nbsp;<i class="fa fa-search"></i></button></span>
    										</div>
    									</form>
    								</li>
    							</ul>
    						</div>
    					</li>
    					<!-- media -->
    						<%
    			 	if(session.getAttribute("username")!= null){
    				%>
    				<a href="teams" class="navbar-link navbar-left"><i class="fa fa-cog"></i>&nbsp;<span class="hidden-sm hidden-md">Teams</span></a>
    				<%
    				}%>
    					<!-- <li class="dropdown-grid">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle"><i class="fa fa-tasks"></i>&nbsp;<span class="hidden-sm">Teams</span><span class="caret"></span></a>
    						<div class="dropdown-grid-wrapper" role="menu">
    							<ul class="dropdown-menu col-xs-12 col-sm-10 col-md-8 col-lg-7">
    								<li>
    									<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    										<div class="row">
    											<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 divided" style="padding-right: 0;">
    												<ol class="carousel-indicators navbar-carousel-indicators h-divided">
    													<li data-target="#carousel-example-generic" data-slide-to="0" class="active"><a href="#" class="">Cars<span class="hidden-xs desc">Short description</span></a></li>
    													<li data-target="#carousel-example-generic" data-slide-to="1" class=""><a href="#" class="">Animals<span class="hidden-xs desc">Slide with caption</span></a></li>
    													<li data-target="#carousel-example-generic" data-slide-to="2" class=""><a href="#" class="">Nature<span class="hidden-xs desc">Short description</span></a></li>
    													<li data-target="#carousel-example-generic" data-slide-to="3" class=""><a href="#" class="">City<span class="hidden-xs desc">Short description</span></a></li>
    													<li data-target="#carousel-example-generic" data-slide-to="4" class=""><a href="#" class="">Space<span class="hidden-xs desc">Short description</span></a></li>
    												</ol>
    											</div>
    											<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
    												<div class="carousel-inner">
    													<div class="item active">
    														<div class="embed-responsive embed-responsive-16by9">
    															<img class="embed-responsive-item" src="images/cars.jpg">
    														</div>
    													</div>
    													<div class="item">
    														<div class="embed-responsive embed-responsive-16by9">
    															<img class="embed-responsive-item" src="images/animals.jpg">
    															<div class="carousel-caption">
    																<h3>The Eurasian eagle-owl</h3>
    																<p>(Bubo bubo) is a species of eagle-owl resident in much of Eurasia. It is sometimes called the European eagle-owl</p>
    															</div>
    														</div>
    													</div>
    													<div class="item">
    														<div class="embed-responsive embed-responsive-16by9">
    															<img class="embed-responsive-item" src="images/nature.jpg">
    														</div>
    													</div>
    													<div class="item">
    														<div class="embed-responsive embed-responsive-16by9">
    															<img class="embed-responsive-item" src="images/city.jpg">
    														</div>
    													</div>
    													<div class="item">
    														<div class="embed-responsive embed-responsive-16by9">
    															<img class="embed-responsive-item" src="images/space.jpg">
    														</div>
    													</div>
    												</div>
    											</div>
    										</div>
    									</div>
    									<script>
    										$('.carousel').carousel()
    									</script>
    								</li>
    							</ul>
    						</div>
    					</li> -->
    					
    							    				<%
    				if(session.getAttribute("username")!= null){
    					%>
    				<a href="teams" class="navbar-link navbar-left"><i class="fa fa-tasks"></i>&nbsp;<span class="hidden-sm hidden-md">Teams</span></a>
    				<%
    				}
    				else {
    				%>
    				<li class="dropdown-short disabled hidden-sm hidden-md"><a>Teams</a></li>
    				<%
    				}
					%>
    					
    					<!-- divider -->
    					<li class="divider"></li>
    					<%
						if (session.getAttribute("username") != null) {
					%><li class="dropdown-grid">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle"><i ><img style="height: 16px;width:16px;margin-bottom:3px; " alt=""
							class="img-circle" src="<%=session.getAttribute("photo")%>" /></i>&nbsp;<span class="hidden-sm">Hi, <%=session.getAttribute("firstname")%>&nbsp;<%=session.getAttribute("lastname")%></span>&nbsp;<i class="fa fa-angle-down"></i></a>
    						
					<!-- END TODO DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown dropdown-user"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> <img alt=""
							class="img-circle" src="<%=session.getAttribute("photo")%>" /> <span class="username">
								Hi, <%=session.getAttribute("firstname")%>&nbsp;<%=session.getAttribute("lastname")%>
						</span> <i class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown-menu">
							<li><a href="editProfile"> <i class="fa fa-pencil-square-o"></i><span class="title">Edit Profile</span>
							</a></li>

							<li><a href="logout"> <i class="fa fa-power-off"></i><span class="title">Log Out</span>
							</a></li>

						</ul></li> 
					<%
						} else {
					%>
    					<!-- account -->
    					<li class="dropdown-grid">
    						<a data-toggle="dropdown" href="javascript:;" class="dropdown-toggle"><i class="fa fa-lock"></i>&nbsp;<span class="hidden-sm">Account</span><span class="caret"></span></a>
    						<div class="dropdown-grid-wrapper" role="menu" ng-controller="LoginModalController" ng-init="InitLoad()">
    							<ul class="dropdown-menu col-xs-12 col-sm-10 col-md-8 col-lg-7">
    								<li>
    									<div id="carousel-example-account" class="carousel slide">
    										<div class="row">
    											<div class="col-lg-8 col-md-8 col-sm-8">
    												<div class="carousel-inner">
    													<div class="item active">
    														<h3 class="text-right" style="padding-top:0px; border-bottom: 1px solid #555;"><i class="fa fa-lock"></i> Sign in</h3>
    														<br>
    														<form class="form-horizontal" role="form" id="login-form">
    															<div class="form-group">
    																<label for="inputEmail3" class="col-sm-3 control-label">User-name</label>
    																<div class="col-sm-9"><input id="user" name="username" type="text" class="input-sm form-control" id="inputEmail3" placeholder="Email" autocomplete="off"></div>
    															</div>
    															<div class="form-group">
    																<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
    																<div class="col-sm-9"><input id="password" name="password" type="password" class="input-sm form-control" id="inputPassword3" placeholder="Password" autocomplete="off"></div>
    															</div>
    															<div class="form-group">
    																<div class="col-sm-offset-3 col-sm-9">
    																	<button type="submit" class="btn btn-default pull-right" id="login-submit"><i class="fa fa-unlock-alt"></i> Sign in</button>
    																	<div id="login-error-div" style="color: red;"></div>
    																</div>
    															</div>
    														</form>
    														<p class="text-primary" style="cursor: pointer;" data-target="#carousel-example-account" data-slide-to="1" ><small>Don't have a account? Sign up for FREE</small></p>
    														<p class="text-primary" style="cursor: pointer;" data-target="#carousel-example-account" data-slide-to="2" ><small>Lost Your Username?</small></p>
    														<p class="text-primary" style="cursor: pointer;" data-target="#carousel-example-account" data-slide-to="3" ><small>Lost Your Password?</small></p>
    													</div>
    													<div class="item">
    														<h3 class="text-right" style="padding-top:0px; border-bottom: 1px solid #555;"><i class="fa fa-user"></i> Create new account</h3>
    														<br>
    														<form class="form-horizontal" role="form">
    															<div class="form-group">
    																<!-- <label for="inputEmail3" class="col-sm-5 control-label">Email</label>-->
    																<div class="col-sm-offset-5 col-sm-7"> <a href="register?usertype=student" class="btn btn-default btn-block"><i class="fa fa-book"></i> Register as Student</a></div>
    															 
    															
    															 </div>
    															<div class="form-group">
    																<!-- <label for="inputPassword3" class="col-sm-5 control-label">Password</label> -->
    																<div class="col-sm-offset-5 col-sm-7"><a href="register?usertype=college" class="btn btn-default btn-block"><i class="fa fa-book"></i> Register as College</a></div>
    															</div>
    															<div class="form-group">
    																<!-- <label for="inputPassword3" class="col-sm-5 control-label">Password</label> -->
    																<div class="col-sm-offset-5 col-sm-7"><a href="register?usertype=mentor" class="btn btn-default btn-block"><i class="fa fa-book"></i> Register as Mentor</a></div>
    															</div>
    															<div class="form-group">
    																<!-- <label for="inputPassword3" class="col-sm-5 control-label">Confirm password</label> -->
    																<div class="col-sm-offset-5 col-sm-7"><a href="register?usertype=faculty" class="btn btn-default btn-block"><i class="fa fa-book"></i> Register as Faculty</a></div>
    															</div>
    															<!-- <div class="form-group">
    																<div class="col-sm-12">
    																	<div class="checkbox">
    																		<label>
    																		<input type="checkbox"> <small>I have read and agree to our <a href="#">Terms of use</a> and <a href="#">Privacy Policy</a>.</small>
    																		</label>
    																	</div>
    																</div>
    															</div> -->
    															<!-- <div class="form-group">
    																<div class="col-sm-offset-5 col-sm-7">
    																	<button class="btn btn-default pull-right" type="submit"><i class="fa fa-save"></i> Create an account</button>
    																</div>
    															</div> -->
    														</form>
    													</div>
    													<!-- Forgot your username -->
    													<div class="item">
    														<h3 class="text-right" style="padding-top:0px; border-bottom: 1px solid #555;"><i class="fa fa-warning"></i> Forgotten your Username?</h3>
    														<br>
    														<p class="text-justify">Enter your email address, you signed up with (or entered in your settings), and we'll send you an email with your username.</p>
    														<br>
    														<form id="lost_password" method="post" class="form" role="form">
    															<div class="input-group">
    																<input type="text" class="form-control" placeholder="Enter your username" autocomplete="off">
    																<span class="input-group-btn">
    																<button class="btn btn-default" type="button"><i class="fa fa-envelope"></i> Send it to me!</button>
    																</span>
    															</div>
    														</form>
    														<br><br>
    														<p class="text-justify"><small><i>If you've forgotten your username and password, you must first retrieve your username (using your email address) and then reset your password using those details.</i></small></p>
    													</div>
    													<!-- Forgot your password -->
    													<div class="item">
    														<h3 class="text-right" style="padding-top:0px; border-bottom: 1px solid #555;"><i class="fa fa-warning"></i> Forgot your password?</h3>
    														<br>
    														<p class="text-justify">Enter your username, and we'll send you an email with a link and instructions to reset your password.
    															If you signed up without an email address (or removed it from settings), visit the FAQ.
    														</p>
    														<br>
    														<form id="lost_password" method="post" class="form" role="form">
    															<div class="input-group">
    																<input type="text" class="form-control" id="forgotPassword" ng-model="token" placeholder="Enter your username" autocomplete="off">
    																<span class="input-group-btn">
    																<button class="btn btn-default" ng-click="forgotPassword()" type="button"><i class="fa fa-envelope"></i> Send it to me!</button>
    																</span>
    															</div>
    															<div class="col-xs-12" ng-show="message.length>0">
											<div ng-repeat="msg in message">{{msg}}</div>
										</div>
    														</form>
    														<br>
<!--     														<p class="text-justify"><small><i>If you've forgotten your username and password, you must first <span class="text-primary" style="cursor: pointer;" data-target="#carousel-example-account" data-slide-to="2">retrieve your username</span> (using your email address) and then reset your password using those details.</i></small></p> -->
    													</div>
    													<div class="item">
    														<h3 class="text-right" style="padding-top:0px; border-bottom: 1px solid #555;"><i class="fa fa-envelope"></i> Subscribe to our mailing list</h3>
    														<br>
    														<p class="text-justify" ><i><small>Get the freebies from us and latest updates about YourApp! We hate spam as much as you do, trust us we won't give your details away to other people.</small></i></p>
    														<br>
    														<form class="form-horizontal" role="form">
    															<div class="form-group">
    																<label for="inputEmail" class="col-sm-5 control-label">Your email address</label>
    																<div class="col-sm-7"><input type="text" class="input-sm form-control" id="inputEmail" name="inputEmail" placeholder="Your email address"></div>
    															</div>
    															<div class="form-group">
    																<label for="inputName" class="col-sm-5 control-label">Your Name</label>
    																<div class="col-sm-7"><input type="text" class="input-sm form-control" id="inputName" name="inputName" placeholder="Your Name"></div>
    															</div>
    															<br>
    															<div class="form-group">
    																<div class="col-sm-offset-5 col-sm-7">
    																	<button class="btn btn-default pull-right" type="submit"><i class="fa fa-envelope-o"></i> Subscribe</button>
    																</div>
    															</div>
    														</form>
    													</div>
    													<div class="item">
    														<h3 class="text-right" style="padding-top:0px; border-bottom: 1px solid #555;"><i class="fa fa-envelope"></i> Contact us</h3>
    														<br>
    														<div class="row">
    															<form class="" role="form">
    																<div class="col-xs-6 col-md-6 ">
    																	<div class="form-group">
    																		<input type="text" class="input-sm form-control" id="inputName" name="inputName" placeholder="Enter your name">
    																	</div>
    																</div>
    																<div class="col-xs-6 col-md-6 ">
    																	<div class="form-group">
    																		<input type="password" class="input-sm form-control" id="inputEmail" name="inputEmail" placeholder="Enter your email address">
    																	</div>
    																</div>
    																<div class="col-xs-12 col-md-12 ">
    																	<div class="form-group">
    																		<input type="password" class="input-sm form-control" id="inputSubject" name="inputSubject" placeholder="Subject ...">
    																	</div>
    																</div>
    																<div class="col-xs-12 col-md-12 ">
    																	<div class="form-group">
    																		<textarea style="resize: none;" class="form-control"  id="inputMessage" name="inputMessage" placeholder="Message" rows="3"></textarea>
    																	</div>
    																</div>
    																<div class="form-group col-sm-offset-3 col-sm-9">
    																	<button class="btn btn-default pull-right" type="submit"><i class="fa fa-chevron-circle-right"></i> Submit</button>
    																</div>
    															</form>
    														</div>
    													</div>
    												</div>
    											</div>
    											<div class="col-lg-4 col-md-4 col-sm-4" style="border-left: 1px solid #555;">
    												<ol class="carousel-indicators navbar-carousel-indicators" style="">
    													<li data-target="#carousel-example-account" data-slide-to="0" class="active"><a href="#" class="">Sign In<span class="desc">Already have an account? Log in</span></a></li>
    													<li data-target="#carousel-example-account" data-slide-to="1" class=""><a href="#" class="">Sign Up<span class="desc">Create new account</span></a></li>
    													<li data-target="#carousel-example-account" data-slide-to="2" class=""><a href="#" class="">Forgot username?<span class="desc">No problem, we can remind you by email</span></a></li>
    													<li data-target="#carousel-example-account" data-slide-to="3" class=""><a href="#" class="">Forgot password?<span class="desc">Don't worry, it happens!</span></a></li>
    													<li data-target="#carousel-example-account" data-slide-to="4" class=""><a href="#" class="">Subscribe<span class="desc">Subscribe to our Newsletters</span></a></li>
    													<li data-target="#carousel-example-account" data-slide-to="5" class=""><a href="#" class="">Contact us<span class="desc">If you have any questions ...</span></a></li>
    												</ol>
    											</div>
    										</div>
    									</div>
    								</li>
    							</ul>
    							<%
						}
					%></div>
    					</li>
    				</ul>
    			</div>
    		</div>
    	</nav>
    </div> --%>
	
	<!-- END OF NAV MENU -->
	<script type="text/javascript">
if(navigator.userAgent.toLowerCase().indexOf('msie') > -1) {  
window.location.href = "IEError";
	 } 
</script> 
 <script>
    	//Start Fix MegaNavbar on scroll page
    	//var navHeight = $('#main_navbar').offset().top;
		var navHeight = 150;
    	FixMegaNavbar(navHeight);
    	$(window).bind('scroll', function() {FixMegaNavbar(navHeight);});

    	function FixMegaNavbar(navHeight) {
    	    if (!$('#main_navbar').hasClass('navbar-fixed-bottom')) {
			//console.log($(window).scrollTop());
			//console.log('navHeight='+navHeight);
			
    	        if ($(window).scrollTop() > navHeight) {
    	            $('#main_navbar').addClass('navbar-fixed-top')
    	            $('body').css({'margin-top': $('#main_navbar').height()+'px'});
    	            if ($('#main_navbar').parent('div').hasClass('container')) $('#main_navbar').children('div').addClass('container').removeClass('container-fluid');
    	            else if ($('#main_navbar').parent('div').hasClass('container-fluid')) $('#main_navbar').children('div').addClass('container-fluid').removeClass('container');
    	        }
    	        else {
    	            $('#main_navbar').removeClass('navbar-fixed-top');
    	            $('#main_navbar').children('div').addClass('container-fluid').removeClass('container');
    	            $('body').css({'margin-top': ''});
    	        }
    	    }
    	}
    	//Start Fix MegaNavbar on scroll page


    	//Start Fix MegaNavbar on scroll page
    	//var tocHeight = $('#Table_of_Contents').offset().top;
		var tocHeight = 150;
    	FixTOC(tocHeight);
    	$(window).bind('scroll', function() {FixTOC(tocHeight);});

    	function FixTOC(tocHeight) {

    	        if ($(window).scrollTop() > (tocHeight-75)) {
                    $('#Table_of_Contents').css({'position':'relative', 'top':(($(window).scrollTop()-tocHeight)+90)+"px", 'right':'auto'});
    	        }
    	        else {
                    $('#Table_of_Contents').css({'position':'relative', 'top':'0px', 'right':'auto'});
    	        }
    	}
    	//Start Fix MegaNavbar on scroll page


    	//Next code used to prevent unexpected menu close when using some components (like accordion, tabs, forms, etc), please add the next JavaScript to your page
    	$( window ).load(function() {
    	    $(document).on('click', '.navbar .dropdown-menu', function(e) {e.stopPropagation();});
    	});

        /*SCROLL PAGE TO TOP*/
        $(document).ready(function() {
            $(".toTop").css("display", "none");

            $(window).scroll(function(){
                if($(window).scrollTop() > 0){$(".toTop").fadeIn("slow");} else {$(".toTop").fadeOut("slow");}
            });

            $(".toTop").click(function(){
                event.preventDefault();
                $("html, body").animate({scrollTop:0},"slow");
            });
        });
		
		function userLogin() {
		jQuery('.dropdown-grid').removeClass('open');
		}

    </script>

</body>



 <style>
  .breadcrumb>li+li:before {
padding: 0 5px;
color: #ccc;
content: none;
} </style>
<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="container customFont borderRadius style" >
	<h1>${result}</h1>	
<!-- <button type="button" class="btn btn-default" ng-click="activateProfile()">Activate</button> -->


<!-- END FOOTER --></div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<p class="back-top floatright">
			<a href="#top"><span></span></a>
		</p>
<!-- END JAVASCRIPTS -->

</body>
<!-- END BODY -->

</html>
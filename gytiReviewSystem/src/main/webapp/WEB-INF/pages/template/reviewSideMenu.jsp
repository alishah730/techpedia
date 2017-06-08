<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html ng-app="techpedia">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
#chartdiv {
	width: 100%;
	height: 435px;
	font-size: 11px;
}

.breadcrumb>li+li:before {
	/* padding: 0 5px;
	color: #ccc; */
	content: none !important;
}

.nav-side-menu {
	overflow: auto;
	font-family: verdana;
	font-size: 12px;
	font-weight: 200;
	background-color: #2e353d;
	position: fixed;
	/* top: 0px; */
	left: 0px;
	right: 0px;
	width: 250px;
	height: inherit;
	color: #e1ffff;
}

.nav-side-menu .brand {
	background-color: #23282e;
	line-height: 50px;
	display: block;
	text-align: center;
	font-size: 14px;
}

/* .nav-side-menu, .brand, .admin_img {
	position: fixed;
} */
.nav-side-menu .toggle-btn {
	display: none;
}

.nav-side-menu ul, .nav-side-menu li {
	list-style: none;
	padding: 0px;
	margin: 0px;
	line-height: 35px;
	cursor: pointer;

	/* .collapsed{
       .arrow:before{
                 font-family: FontAwesome;
                 content: "\f053";
                 display: inline-block;
                 padding-left:10px;
                 padding-right: 10px;
                 vertical-align: middle;
                 float:right;
            }
     } */
}


.nav-side-menu ul .sub-menu li:before, .nav-side-menu li .sub-menu li:before
	{
	font-family: FontAwesome;
	content: "\f105";
	display: inline-block;
	padding-left: 10px;
	padding-right: 10px;
	vertical-align: middle;
}

.nav-side-menu li {
	padding-left: 0px;
	border-left: 3px solid #2e353d;
	border-bottom: 1px solid #23282e;
}

.nav-side-menu li a {
	text-decoration: none;
	color: #e1ffff;
}

.nav-side-menu li a i {
	padding-left: 10px;
	width: 20px;
	padding-right: 20px;
}

.nav-side-menu li:hover {
	border-left: 3px solid #d19b3d;
	background-color: #4f5b69;
	-webkit-transition: all 1s ease;
	-moz-transition: all 1s ease;
	-o-transition: all 1s ease;
	-ms-transition: all 1s ease;
	transition: all 1s ease;
}

@media ( max-width : 576px) {
	.nav-side-menu {
		position: relative;
		width: 100%;
		margin-bottom: 10px;
	}
	.nav-side-menu .toggle-btn {
		display: block;
		cursor: pointer;
		position: absolute;
		right: 10px;
		top: 10px;
		z-index: 10 !important;
		padding: 3px;
		background-color: #ffffff;
		color: #000;
		width: 40px;
		text-align: center;
	}
	.brand {
		text-align: left !important;
		font-size: 22px;
		padding-left: 20px;
		line-height: 50px !important;
	}
}

@media ( min-width : 300px) {
	.nav-side-menu .menu-list .menu-content {
		display: block;
	}
}

body {
	margin: 0px;
	padding: 0px;
	max-width: 100%;
	overflow-x: hidden;
}

.style {
	background-color: #FAFAF7;
	padding: 20px;
	max-width: 1130px;
	border-radius: 5px;
}

.fontSize{
font-size: 15px;
font-weight: bold;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
	<div class="" ng-controller="ReviewSideMenuController"
		ng-init="InitLoad()">
		<main class="cd-main-content"
			style="padding-left: 0px; padding-right: 0px;"> 
			<nav class="cd-side-nav" style="display:none">
			<a id="CloseNav" href="javascript:void(0)" 
									  onclick="w3_close()"
							  class="w3-closenav w3-large">Close &times;</a>
		<ul>
			<li class="cd-label" style="font-size: 15px;">GYTI REVIEW SYSTEM</li>
			<%if(session.getAttribute("revfirstName")!=null){
									
									%>
			<li ><a class="fontSize" href="${techpediaUrl}">Techpedia</a></li>
			<li class="has-children overview fontSize">
			<%if(((String)(session.getAttribute("revUsrId"))).equals("TrsAdmin")){ %>
			<a href="adminDashboard">Dashboard</a>
			<%}else{ %>
			<a href="reviewDashboard">Dashboard</a>
			<%} %>
			

				<!-- <ul>
						<li><a href="#0">All Data</a></li>
						<li><a href="#0">Category 1</a></li>
						<li><a href="#0">Category 2</a></li>
					</ul> --></li>
			<li class="has-children notifications active"><a class="fontSize" href="#0">Reviews
					and Rating<!-- <span class="count">3</span> -->
			</a>

				<ul>
				<%if(((String)(session.getAttribute("revUsrId"))).equals("TrsAdmin")){ %>
					<li style="padding-left: 10% !important;"><a href="getAllReviews">All Reviews</a></li>
					<li style="padding-left: 10% !important;"><a href="allReviewsForLoggedInReviewer">Review Done<!-- <span class="count">3</span> --></a></li>
					<li style="padding-left: 10% !important;"><a href="gytiArchive">Archive</a></li>
					<%}else{ %>
						<li style="padding-left: 10% !important;"><a href="allReviewsForLoggedInReviewer">Review Done<!-- <span class="count">3</span> --></a></li>
						<li style="padding-left: 10% !important;"><a href="gytiArchive">Archive</a></li>
					<%} %>
					<!-- <li><a href="#0">Other</a></li> -->
				</ul></li>
			<li class="has-children users active"><a class="fontSize" href="#0">Action</a>
				<ul>
					<%if(((String)(session.getAttribute("revUsrId"))).equals("TrsAdmin")){ %>
					<li style="padding-left: 10% !important;"><a href="addReviewer">Add Reviewer</a></li>
					<li style="padding-left: 10% !important;"><a href="reviewerStatus">Reviewer Status</a></li>
					<li style="padding-left: 10% !important;"><a href="reviewGYTIProjects">Review Innovation</a></li>
					<%}else{ %>	
					<li style="padding-left: 10% !important;"><a href="reviewGYTIProjects">Review Innovation</a></li>
					<%} %>
					<!-- <li><a href="#0">Other</a></li> -->
				</ul></li>
				<li class="has-children users active"><a class="fontSize" href="#0">Suggest Reviewer</a>
				<ul>
					<%if(((String)(session.getAttribute("revUsrId"))).equals("TrsAdmin")){ %>
					<li style="padding-left: 10% !important;"><a href="adminGetAllSuggestedReviewers">All Request</a></li>
					<li style="padding-left: 10% !important;"><a href="suggestedReviewersByLoggedInReviewer">Requested By You</a></li>
					<%}else{ %>	
					<li style="padding-left: 10% !important;"><a href="suggestedReviewersByLoggedInReviewer">Requested By You</a></li>
					<%} %>
					<!-- <li><a href="#0">Other</a></li> -->
				</ul></li>
			<%
				}
				else{%>
					<li class=""><a class="fontSize" href="${techpediaUrl}">Techpedia</a></li>
			<%}%>
		</ul>

		<!-- <ul>
				<li class="cd-label">Secondary</li>
				<li class="has-children bookmarks">
					<a href="#0">Bookmarks</a>
					
					<ul>
						<li><a href="#0">All Bookmarks</a></li>
						<li><a href="#0">Edit Bookmark</a></li>
						<li><a href="#0">Import Bookmark</a></li>
					</ul>
				</li>
				<li class="has-children images">
					<a href="#0">Images</a>
					
					<ul>
						<li><a href="#0">All Images</a></li>
						<li><a href="#0">Edit Image</a></li>
					</ul>
				</li>

				<li class="has-children users">
					<a href="#0">Users</a>
					
					<ul>
						<li><a href="#0">All Users</a></li>
						<li><a href="#0">Edit User</a></li>
						<li><a href="#0">Add User</a></li>
					</ul>
				</li>
				<li class="has-children users">
					<a href="#0">Action</a>
					
					<ul>
						<li><a href="#0">All Users</a></li>
						<li><a href="#0">Edit User</a></li>
						<li><a href="#0">Add User</a></li>
					</ul>
				</li>
			</ul> -->
			 </nav> <!-- 
		<div class="content-wrapper">
			<h1>Responsive Sidebar Navigation</h1>
		</div>  --><!-- .content-wrapper -->
		 </main>
	</div>
	<!-- <script>
	$( document ).ready(function() {
		$('#sideNavPanel').hide();
		alert("loaded");
		function w3_open() {
			alert("open");
			$('#sideNavPanel').show();
			$('#mainPanelBody').addClass('col-xs-10');
			$('#sideNavPanel').addClass('col-xs-2');
		}
		function w3_close() {
			alert("close");
			$('#sideNavPanel').hide();
			$('#mainPanelBody').removeClass('col-xs-10');
			$('#mainPanelBody').addClass('col-xs-12');
			
		  document.getElementById("mainPanelBody").style.marginLeft = "0%";
		  document.getElementsByClassName("w3-sidenav")[0].style.display = "none";
		  document.getElementsByClassName("w3-opennav")[0].style.display = "inline-block";
		}
	})
</script> -->
</body>
</html>
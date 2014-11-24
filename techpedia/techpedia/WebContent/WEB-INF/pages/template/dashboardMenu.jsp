
<div class="page-sidebar navbar-collapse collapse">
	<!-- BEGIN SIDEBAR MENU -->
	<ul class="page-sidebar-menu" data-auto-scroll="true" data-slide-speed="200">
		<!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
		<li class="sidebar-toggler-wrapper">
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
			<div class="sidebar-toggler">
				<span style="color: white;"><i class="fa fa-outdent fa-2x"></i></span>
			</div> <!-- END SIDEBAR TOGGLER BUTTON -->
		</li>
		<!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
		<li class="sidebar-search-wrapper">
			<!-- BEGIN RESPONSIVE QUICK SEARCH FORM --> <!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
			<!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
			<form class="sidebar-search" action="extra_search.html" method="POST">
				<a href="javascript:;" class="remove"> <i class="icon-close"></i>
				</a>

			</form> <!-- END RESPONSIVE QUICK SEARCH FORM -->
		</li>
		<%
			if (session.getAttribute("username") != null) {
		%>
		<li><a href="dashboard"> <i class="fa fa-tachometer"></i> <span class="title">Dashboard</span>

				<!-- <img src="images/expand2.png" width="25" height="25"/></span> -->
		</a> <!-- <ul class="sub-menu-custom">
				<li><a href="#"><i class="fa fa-suitcase"></i> My Project
				</a></li>
				<li><a href="#"><i class="fa fa-rss-square"></i> Project I Follow
				</a></li>
				<li><a href="#"><i class="fa fa-users"></i> All
				</a></li>
			</ul> --></li>

		<li><a href="./"> <i class="fa fa-home"></i> <span class="title">Home</span> <!-- <span class="arrow "></span> -->
		</a></li>
		<li><a href="aboutus"> <i class="fa fa-info-circle"></i> <span class="title">About
					Us</span>
		</a></li>
		<li><a href="projects"> <span class="selected"></span> <i class="fa fa-files-o"></i> <span
				class="title">Projects</span></a></li>
		<li><a href="mentors"> <i class="fa fa-user"></i> <span class="title">Mentors</span></a></li>

		<li><a href="challenges"> <i class="fa fa-bolt"></i> <span class="title">Challenges</span></a>
		</li>

		<li><a href="teams"> <i class="fa fa-share"></i> <span class="title">Teams</span>
		</a></li>

		<li><a href="manageProjects"> <i class="fa fa-briefcase"></i> <span class="title">Manage
					Projects</span></a></li>

		<li><a href="manageChallenge"> <i class="fa fa-thumbs-up"></i> <span class="title">Manage
					Challenges</span></a></li>
		<!-- BEGIN FRONTEND THEME LINKS -->
		<!-- <li>
					<a href="#">
					
					<i class="fa fa-share-square-o"></i>
					<span class="title">
					
					Manage Teams </span></a></li> -->

	</ul>
	<%
		} else {
	%>
	<li><a href="./"> <i class="fa fa-home"></i> <span class="title">Home</span> <!-- <span class="arrow "></span> -->
	</a></li>
	<li class="start"><a href="aboutus"> <i class="fa fa-info-circle"></i> <span class="title">About
				Us</span>
	</a></li>
	<li><a href="projects"> <i class="fa fa-files-o"></i> <span class="title">Projects</span></a>
	</li>
	<li><a href="mentors"> <i class="fa fa-user"></i> <span class="title">Mentors</span></a></li>
	<li><a href="challenges"> <i class="fa fa-bolt"></i> <span class="title">Challenges</span></a>
	</li>
	<%
		}
	%>
	<!-- END SIDEBAR MENU -->
</div>

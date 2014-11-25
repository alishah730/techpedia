<!-- <link rel="stylesheet" href="css/jquery-ui.css"> -->
<!-- <script src="js/jquery.min.js"></script> -->
<script src="js/skel.min.js"></script>
<script src="js/init.js"></script>
<!-- <script src="js/dashboardJs/bootstrap-hover-dropdown.min.js" type="text/javascript"></script> -->

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="./"> <img src="images/logo.png" alt="logo" class="logo-default"
				width="35" height="35" style="margin-top: -5px;" /><span class="pos_fixed"
				style="color: white;"> &nbsp;Techpedia</span></a>
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
									class="username"> Hi, <%=session.getAttribute("firstname")%>&nbsp;<%=session.getAttribute("lastname")%>
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




<%@page import="java.util.ArrayList"%>
<html>
<jsp:include page="template/dashboardHeader.jsp" />
<div class="clearfix"></div>
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div>

	<div class="page-content-wrapper">
		<div class="page-content">

			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-info-circle" id="icon-size"></i> About Us

					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>About Us</li>

						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
						<%
							} else {
						%><li><a href="./">Home</a> &raquo;</li>
						<li>About Us</li>
						<%
							}
						%>
					</ul>

				</div>
			</div>
			<div class="clearfix"></div>
			<div class="row">

				<div class="col-xs-12">
					<h5 class="heading1">About Us</h5>

					<hr />
					<p class="next" align="justify">Techpedia, an initiative at SRISTI aims at putting the
						problems of micro, small and medium enterprises, informal sector, grassroots innovators and
						other social sectors on the agenda of the young technology students across the country. For
						over last sixty years, India has not utilized much the technological outputs of millions of
						students. But no more. Can a knowledge society really afford to ignore the huge talent
						distributed in thousands of polytechnics, diploma and degree colleges of engineering,
						pharmacy, medical science, agriculture etc.? SRISTI is providing a platform for the industry
						and academic institutions to collaborate, co-create and foster distributed and horizontal
						innovations. Most of the ideas mentioned here have been implemented in the state of Gujarat in
						close cooperation with Gujarat Technical University and initial results are extremely
						encouraging.</p>

				</div>

				<div class="col-xs-12">
					<br> <br>
					<h5 class="heading1">Our goals are:</h5>
					<hr />
					<ol class="next" align="justify">
						<li>Promotion of originality among technology students by making it impossible for them
							to do what has been done before. This will be possible only when they can find out what has
							been done before. Techpedia already has 1.4 lac technology projects done by 3.5 lac students
							from more than 500 colleges in India.</li>
						<li>Connecting the technical students with the problems of informal and unorganized
							sector and grassroots innovators.</li>
						<li>Putting the technical problems of MSMEs on the agenda of students so that affordable
							solutions can be generated in a real time.</li>
						<li>To harness collaborative potential of students across disciplines and colleges to
							solve persistent problems of our country in formal and informal sector.</li>
						<li>Explore kho kho model (relay) of product development. Idea here is that if one
							student group has brought the solution of a particular problem to a specific stage, then next
							group within that department or somewhere else should be able to build upon it to take it
							forward.</li>
						<li>To pose challenges to students to address unsolved problems of our society. Gandhiji
							had announced an award of 7700 pounds, ( approx Rs one lac ) to redesign charkha-spinning
							wheel. Today the value of this prize will be more than Rs10 crores. Industry association,
							government and others can offer attractive prizes for solving those problems which have
							remained unsolved so long.</li>
						<li>Promoting both IPR protected and open source technologies and eventually develop
							techpedia.in into an online virtual incubator. Creating real-time online NMN (National
							Mentoring Network) to harness skills, insights and experience of senior tech experts for
							mentoring young students.</li>
					</ol>
				</div>
			</div>
			<div class="clearfix"></div>

			<!-- END CONTAINER
BEGIN FOOTER -->

		</div>
	</div>
</div>
<!-- END FOOTER -->

<jsp:include page="template/loginModal.jsp" />
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />

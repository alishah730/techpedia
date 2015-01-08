<%@page import="java.util.ArrayList"%>

<jsp:include page="template/header.jsp" />
<!-- SUBHEADER
================================================== -->
<div id="subheader">
	<div class="row">
		<div class="col-md-12">
				<p class="left">User Details</p>
				
			</div>
	</div>
</div>
<div class="hr"></div>
<!-- CONTENT 
================================================== -->
<div class="row">
	<!-- PROJECT DESCRIPTION-->
	<div class="col-md-6">
		<div class="sectiontitle">
			<h4>${viewMentorDetails[0]}</h4>
		</div>

		<div class="panel panel-info">
			<!-- Default panel contents -->

			<!-- Table -->
			<table class="table">
				<tr>
					<td>Address</td>
					<td>${viewMentorDetails[1]}</td>
				</tr>
				<tr>
					<td>Personal</td>
					<td>${viewMentorDetails[2]}</td>
				</tr>
				<tr>
					<td>City</td>
					<td>${viewMentorDetails[3]}</td>
				</tr>
				<tr>
					<td>State</td>
					<td>${viewMentorDetails[4]}</td>
				</tr>
				<tr>
					<td>Country</td>
					<td>${viewMentorDetails[5]}</td>
				</tr>
				<tr>
					<td>ZipCode</td>
					<td>${viewMentorDetails[6]}</td>
				</tr>
				<tr>
					<td>Position</td>
					<td>${viewMentorDetails[7]}</td>
				</tr>
				<tr>
					<td>Degree</td>
					<td>${viewMentorDetails[8]}</td>
				</tr>
				<tr>
					<td>Association</td>
					<td>${viewMentorDetails[9]}</td>
				</tr>
				<tr>
					<td>Experience</td>
					<td>${viewMentorDetails[10]}</td>
				</tr>
				<tr>
					<td>Societies</td>
					<td>${viewMentorDetails[11]}</td>
				</tr>
				<tr>
					<td>Alumni</td>
					<td>${viewMentorDetails[12]}</td>
				</tr>
			</table>
		</div>


	</div>
	<!-- end main content-->
	<!-- SLIDER-->

	<div class="col-md-1">&nbsp;</div>
	<div class="col-md-5">

		<div>
			<br /> <br /> <br /> <br /> <img class="mentorpic"
				src="${viewMentorDetails[13]}" width=320 height=320 /> <br />
</div>
		<br />
		<div class="col-md-3">
			<h5>Popularity</h5>
		</div>

		<div class="col-md-7">
			<div class="progress">
				<div class="progress-bar progress-bar-success progress-bar-striped"
					role="progressbar" aria-valuenow="40" aria-valuemin="0"
					aria-valuemax="100" style="width: 40%">
					<span class="sr-only">40% Complete (success)</span>
				</div>
			</div>
		</div>
	</div>
	<!-- end sliderr-->
</div>
<div class="hr"></div>

<jsp:include page="template/footer.jsp" />
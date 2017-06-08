<%@ page import="java.util.Random"%>
<html ng-app="techpedia">
<jsp:include page="template/NewHeader.jsp" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<style>
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
}

.row {
	margin-right: -1px;
	margin-left: -1px;
}

.ui-icon {
	background-color: white;
}

.loaderBody {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url('images/cubebox.gif') 50% 50% no-repeat
		rgb(249, 249, 249);
	text-align: center;
	font-size: 18px;
	padding-top: 120px;
}
</style>
<div class="clearfix"></div>
<div class="container customFont borderRadius style"
	style="background-color: #ffffff; width: 100%;">
	<div class="page-container">

		<div class="page-content-wrapper"
			ng-controller="NewInnovationController" ng-init="InitLoad()"
			style="width: 1068px !important;">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							<i class="fa fa-briefcase" id="icon-size"></i> Add Innovation
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li style="color: #262626 !important"><a
								style="color: #262626 !important" href="./">Home&nbsp;</a><font
								style="color: black; font-size: 18px;">&raquo;</font></li>
							<li style="color: #262626 !important"><a
								style="color: #262626 !important" href="dashboard">Dashboard&nbsp;</a><font
								style="color: black; font-size: 18px;">&raquo;</font></li>
							<li>Add Innovation</li>
							<!-- <li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li> -->
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>

				<!-- END PAGE TITLE & BREADCRUMB-->
			</div>

			<div class="row error-place" style="display: none;">
				<div class="col-xs-12">
					<div class="panel panel-danger">
						<div class="panel-heading">Error:</div>
						<div class="panel-body error"></div>
					</div>
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<%
				String challengeId = (String) request.getAttribute("challengeId");
				String challengeTitle = (String) request.getParameter("challengeTitle");
			%>

			<div class="row">
				<%
					if (challengeId != null) {
				%>
				<div class="panel panel-info">
					<div class="panel-heading">
						This project will get created against <a target="_blank"
							href="challengeDetails<%=challengeId%>">Challenge: <%=challengeTitle%></a>
					</div>
					<input style="display: none;" id="challengeId" name="challengeId"
						type="text" value=<%=challengeId%> />
				</div>
				<%
					}
				%>
				<div class="clearfix"></div>
				<div class="row">
					<div id="accordion" class="col-xs-12">
						<h3 class="acc-gi acc-hover"
							style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">Project
							Information</h3>
						<div>
							<div>
								<form id="newInnovationInformation"
									name="newInnovationInformation" method="post" novalidate>
									<div class="col-xs-12 col-md-6"
										style="background-color: #f5f5f5; width: 492px; margin-right: 9px;">
										<!-- USER INFO START -->
										<div class="panel panel-default"
											style="border-style: none; background-color: #f5f5f5">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">Basic
												Information</div>
											<div class="panel-body project-basic-info"
												style="border-style: none; background-color: #f5f5f5;">
												<div class="col-xs-12">
													<div class="input-group input-group-sm">

														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Title
															*</span> <input style="width: 298px;" id="projectTitle"
															name="projTitle" type="text" class="form-control rname"
															placeholder="Project Title"
															ng-model="newInnovation.projTitle" required
															ng-maxlength="100" />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="newInnovationInformation.projTitle.$dirty && newInnovationInformation.projTitle.$error.required">
														Project Title is required</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="newInnovationInformation.projTitle.$dirty && newInnovationInformation.projTitle.$error.maxlength">
														Project Title cannot be more than 100 characters</div>

												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Branches
															*</span> <input style="width: 298px;" id="projectBranches"
															name="projBranchesString" type="text"
															class="form-control" placeholder="Project branches"
															ng-model="newInnovation.projBranchesString" required />
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Keywords
															*</span> <input style="width: 298px;" id="projectKeywords"
															name="projKeywordsString" type="text"
															class="form-control" placeholder="Keywords"
															ng-model="newInnovation.projKeywordsString" required />
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">Team
															Members</span> <input style="width: 225px;" id="teamMembers"
															name="projTeamMembersString" type="text"
															class="form-control" placeholder="Add Team Members"
															ng-model="newInnovation.projTeamMembersString"
															readonly="readonly" /> <span
															class="input-group-addon btn-success btn-responsive"
															style="border-left: 1px solid #ccc; width: 10px;"
															disabled> <a data-toggle="modal"
															data-target="#searchTeamMemberModal"
															style="color: #ffffff;" href="#"><i
																class="fa fa-search" aria-hidden="true"></i></a></span> <span
															class="input-group-addon btn-success btn-responsive"
															style="border-left: 1px solid #ccc; width: 10px;"
															disabled> <a data-toggle="modal"
															data-target="#addNewTeamMemberModal"
															style="color: #ffffff;" href="#">Add New</a></span>
													</div>

												</div>

												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Team
															Name</span> <input style="width: 298px;" id="teamName"
															name="projTeamDesc" type="text" class="form-control"
															placeholder="Team Name"
															ng-model="newInnovation.projTeamDesc"/>
													</div>
													<!-- <div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="newInnovationInformation.projTeamDesc.$dirty && newInnovationInformation.projTeamDesc.$error.required">Team
														Name is required</div> -->
													<!-- <div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="newInnovationInformation.projTeamDesc.$dirty && newInnovationInformation.projTeamDesc.$error.pattern">Team
														Members can only contain text</div> -->
												</div>
												<div class="col-xs-12">&nbsp;</div>


											</div>
										</div>

										<div class="panel panel-default"
											style="border-style: none; background-color: #f5f5f5">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">Project
												State Information</div>
											<div class="panel-body project-state-info"
												style="border-style: none; background-color: #f5f5f5">
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Start
															*</span> <input style="width: 298px;" id="projectStartDate"
															name="projStartDate" type="text" class="form-control"
															placeholder="Project Start Date(DD-MMM-YYYY)"
															ng-model="newInnovation.projStartDate" datepicker-angular />
														<!-- <span class="input-group-addon"
															style="border-left: 1px solid #ccc;">DD-MMM-YYYY</span> -->
													</div>


												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">End
															*</span> <input style="width: 298px;" id="projectEndDate"
															name="projEndDate" type="text" class="form-control"
															placeholder="Project End Date(DD-MMM-YYYY)"
															ng-model="newInnovation.projEndDate" datepicker-angular />
														<!-- <span class="input-group-addon"
															style="border-left: 1px solid #ccc;">DD-MMM-YYYY</span> -->
													</div>

												</div>

												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 105px; font-family: arial; color: #ffffff;">Year
														</span> <input style="width: 293px;" id="projectYear"
															name="projYear" type="text" class="form-control"
															placeholder="Project Year" readonly />
													</div>
												</div>

												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Duration</span>
														<input style="width: 229px;" id="projectDuration"
															name="projDuration" type="text" class="form-control"
															placeholder="Project duration (in months)" readonly /> <span
															class="input-group-addon"
															style="border-right: 1px solid #ccc;">months</span>
													</div>

												</div>
												<div class="col-xs-12">&nbsp;</div>
											</div>
										</div>

									</div>

									<div class="col-xs-12 col-md-6"
										style="background-color: #f5f5f5">

										<div class="panel panel-default" style="border-style: none;">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">Project
												Photo</div>

											<div class="panel-body project-basic-info"
												style="border-style: none; background-color: #f5f5f5;">
												<input ng-model="newInnovation.photo" type="text"
													name="photo" id="photoByte64" style="display: none;" /> <input
													type="text" name="photo" id="photoByte64Size"
													style="display: none;" />
												<canvas class='canvas' width='160' height='120'
													style='display: none;'></canvas>
												<div class="col-xs-12">
													<div class="col-xs-3">
														<!-- <video class='live' width='160' height='120' autoplay></video> -->
														<img width=160 height=120 src='images/placeholder.png'
															class='photo' id="img_id" alt='photo'>
													</div>

													<div class="col-xs-9">
														<div class="col-xs-12">
															<!-- <button class='takePhoto btn btn-info btn-sm'>Take photo</button>
														<button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
															photo</button> -->
															<input id='hidden-photo-input' type='file'
																accept='image*;capture=camera' style='display: none;'
																ng-file="file" base64 />
														</div>
														<div class="col-xs-12">&nbsp;</div>

														<button class='btn btn-success btn-responsive'
															onclick="$('#hidden-photo-input').click();"
															style="float: right;">
															<i class="fa fa-upload">&nbsp;</i>Upload photo
														</button>
														<div class="col-xs-12" ng-show="msg.size.length>0">File
															size cannot be more than 10 KB</div>
														<div class="col-xs-12" ng-show="message.length>0">
															<div ng-repeat="msg in message">{{msg}}</div>
														</div>

													</div>
												</div>
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">&nbsp;</div>


										<div class="col-xs-12" style="height: 25px;">&nbsp;</div>
										<!-- Project footer image -->

										<div class="panel panel-default" style="border-style: none;">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">Project
												Footer Photo</div>
											<div class="panel-body project-basic-info"
												style="border-style: none; background-color: #f5f5f5;">
												<input ng-model="newInnovation.photo" type="text"
													name="photo" id="photoByte64-footer" style="display: none;" />
												<input type="text" name="photo" id="photoByte64Size-footer"
													style="display: none;" />
												<canvas class='canvas' width='160' height='120'
													style='display: none;'></canvas>
												<div class="col-xs-12">
													<div class="col-xs-3">
														<video class='live' width='160' height='120' autoplay></video>
														<img width=160 height=120 src='images/placeholder.png'
															class='photo1' id="img_id_footer" alt='photo'>
													</div>

													<div class="col-xs-9">
														<div class="col-xs-12">
															<input id='hidden-photo-input-footer' type='file'
																accept='image*;capture=camera' style='display: none;'
																ng-file="file1" base64 />
														</div>
														<div class="col-xs-12">&nbsp;</div>

														<button class='btn  btn-success btn-responsive'
															onclick="$('#hidden-photo-input-footer').click();"
															style="float: right;">
															<i class="fa fa-upload">&nbsp;</i>Upload photo
														</button>
														<div class="col-xs-12" ng-show="msg.size.length>0">File
															size cannot be more than 10 KB</div>
														<div class="col-xs-12" ng-show="message.length>0">
															<div ng-repeat="msg in message">{{msg}}</div>
														</div>

													</div>
												</div>
											</div>
										</div>


										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">&nbsp;</div>


									</div>


									<!-- proejct image upload codes ends here -->
									<div class="col-xs-12">&nbsp;</div>

									<div class="col-xs-12 col-md-12">
										<div class="panel panel-default" style="border-style: none;">
											<div class="panel-heading"
												style="border-style: none; font-family: arial; font-weight: bold;">Project
												Abstract *</div>
											<div class="panel-body project-abstract-info"
												style="border-style: none; background-color: #f5f5f5;">
												<div class="col-xs-12">
													<textarea id="projectAbstract"
														placeholder="Project abstract..." class="textarea-text"
														style="width: 920px; height: 100px;" name="projAbstract"
														rows="3" ng-maxlength="1000"
														ng-model="newInnovation.projAbstract" required></textarea>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="newInnovationInformation.projAbstract.$dirty && newInnovationInformation.projAbstract.$error.required">Project
														Abstract is required</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="newInnovationInformation.projAbstract.$dirty && newInnovationInformation.projAbstract.$error.maxlength">
														Project Abstract cannot be more than 1000 characters</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
											</div>
										</div>
									</div>
									<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-btn"
											ng-disabled="newInnovationInformation.$invalid"
											style="margin-left: 91%; background-color: #5cb85c;">Continue</a>
									</div>
								</form>
							</div>

						</div>
						<h3 class="acc-pi acc-hover"
							ng-class="newInnovationInformation.$invalid?'ui-state-disabled':'ui-state-default'"
							style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">Detailed
							Project Information</h3>
						<div>

							<form id="addDetailedInnovationInformationForm"
								name="addDetailedInnovationInformationForm" method="post"
								novalidate>
								<div class="col-xs-12 col-md-12">
									<div class="panel panel-default" style="border-style: none;">
										<div class="panel-heading"
											style="border-style: none; font-family: arial; font-weight: bold;">Project
											Description</div>
										<div class="panel-body project-description-info"
											style="border-style: none; background-color: #f5f5f5;">
											<div class="col-xs-12">
												<textarea id="projectDescription"
													placeholder="Project description..." class="textarea-text"
													style="width: 920px; height: 100px;" name="projDescription"
													rows="5" ng-model="newInnovation.projDescription"
													ng-maxlength="1000" required></textarea>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="addDetailedInnovationInformationForm.projDescription.$dirty && addDetailedInnovationInformationForm.projDescription.$error.required">Project
													Description is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="addDetailedInnovationInformationForm.projDescription.$dirty && addDetailedInnovationInformationForm.projDescription.$error.maxlength">
													Project Description cannot be more than 1000 characters</div>
											</div>
											<div class="col-xs-12">&nbsp;</div>
										</div>
									</div>
								</div>

								<div class="col-xs-12">
									<div class="panel panel-default" style="border-style: none;">
										<div id="profession" class="panel-heading"
											style="border-style: none; font-family: arial; font-weight: bold;">University
											Information</div>
										<div class="panel-body project-detail-info"
											style="border-style: none; background-color: #f5f5f5;">
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">University
													</span> <input style="width: 340px;" name="projUniversity"
														id="projectUniversity" type="text" class="form-control"
														placeholder="Project University" value="IIT" readonly
														ng-model="newInnovation.university" />
												</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">College</span>
													<input style="width: 340px;" name="projCollege"
														id="projectCollege" type="text" class="form-control"
														placeholder="Project College" value="IIT Kanpur" readonly
														ng-model="newInnovation.collge" />
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">State</span>
													<input style="width: 340px;" name="projCollegeState"
														id="projectCollegeState" type="text" class="form-control"
														placeholder="Project College State" value="Kanpur"
														readonly ng-model="newInnovation.state" />
												</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">Student
														ID</span> <input style="width: 340px;" name="projStudentId"
														name="userRegisterationNumber" type="text"
														class="form-control" placeholder="Student ID"
														value="2009ECS31" readonly
														ng-model="newInnovation.studentID" />
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<!-- <div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">Faculty</span>
													<input style="width: 268px;" id="projFaculty"
														name="projFaculty" type="text" class="form-control"
														placeholder="Choose faculty" /> <span
														class="input-group-addon"
														style="border-left: 1px solid #ccc"><a
														data-toggle="modal" data-target="#addNewFacultyModal"
														href="#">Add new</a></span>
												</div>

											</div> -->
											<div class="col-xs-12">&nbsp;</div>
										</div>
									</div>
								</div>

								<div class="col-xs-12">
									<div class="panel panel-default" style="border-style: none;">
										<div id="profession" class="panel-heading"
											style="border-style: none; font-family: arial; font-weight: bold;">Additional
											Project Information</div>
										<div class="panel-body project-detail-info"
											style="border-style: none; background-color: #f5f5f5;">
											<div class="col-xs-12 col-md-6">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">Cost
													</span> <input style="width: 340px;" id="projectEstimatedCost"
														name="projEstimationCost" type="text" class="form-control"
														placeholder="Estimated cost"
														ng-model="newInnovation.projEstimationCost" required
														ng-pattern="/^(\d)+$/" /> <span class="input-group-addon"
														style="border-right: 1px solid #ccc">INR </span>
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="addDetailedInnovationInformationForm.projEstimationCost.$dirty && addDetailedInnovationInformationForm.projEstimationCost.$error.required">Estimated
													cost is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="addDetailedInnovationInformationForm.projEstimationCost.$dirty && addDetailedInnovationInformationForm.projEstimationCost.$error.pattern">Estimated
													cost can only contain digits</div>
											</div>

											<div class="col-xs-12 col-md-6">
												<!-- <div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Project
														Image </span> <input placeholder="Project Image" id="projectPhoto" name="projImage"
														type="file" style="display: none;" />
													<button class="projectPhoto btn btn-info btn-sm">Upload photo</button>
												</div> -->
											</div>

											<div class="col-xs-12">&nbsp;</div>

										</div>
									</div>
									<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-btn-2"
											ng-disabled="addDetailedInnovationInformationForm.$invalid"
											style="margin-left: 91%; background-color: #5cb85c;">Continue</a>
									</div>
								</div>
							</form>
						</div>


						<h3 class="acc-pi-1 acc-hover"
							ng-class="addDetailedInnovationInformationForm.$invalid?'ui-state-disabled':'ui-state-default'"
							style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">GYTI
							Detailed Innovation Information</h3>
						<div>

							<form id="addGytiDetailedProjectInformationForm"
								name="addGytiDetailedProjectInformationForm" method="post"
								novalidate>

								<div class="col-xs-12"
									style="background-color: #f5f5f5; margin-right: 9px;">
									<div class="panel panel-default"
										style="border-style: none; background-color: #f5f5f5">
										<div class="panel-heading"
											style="border-style: none; font-family: arial; font-weight: bold;">GYTI
											Innovation Basic Information</div>
										<div class="panel-body project-basic-info"
											style="border-style: none; background-color: #f5f5f5;">

											<div class="col-xs-12">
												<div class="input-group input-group-sm ">
													<span class="input-group-addon heading"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 442px; text-align: left; font-family: arial; color: #ffffff;">
														Name of nominator if third
														party(faculty/professional/NGO/others ) :</span> <input
														style="width: 298px;" name="nominatedBy" type="text"
														id="nominator" class="form-control rname my-tooltip"
														placeholder="Nominator"
														ng-model="newInnovation.nominatedBy" ng-maxlength="80"
														ng-pattern="/^(\D)+$/" data-toggle='tooltip'
														data-placement='right' title='Please enter nominator' />

												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 442px; text-align: left; font-family: arial; color: #ffffff;">
														Have you applied to GYTI before? If yes, which year : </span> <select
														name="projAwardYear" type="text" id="awardYear"
														style="width: 298px !important;" class="form-control"
														placeholder="Innovation year(YYYY)"
														ng-model="newInnovation.projAwardYear" ng-maxlength="4"
														ng-minlength="4" data-toggle='tooltip'
														title="Year should be in YYYY format" >
														<option value selected="selected">select</option>
														</select>
												</div>

											</div>
											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm ">
													<span class="input-group-addon heading"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 442px; text-align: left; font-family: arial; color: #ffffff;">
														Research Guide / Supervisor Name: * </span> <input style="width: 298px;"
														name="projGuideName" type="text" id="guideName" required
														class="form-control rname my-tooltip"
														placeholder="Guide name"
														ng-model="newInnovation.projGuideName" ng-maxlength="80"
														ng-pattern="/^(\D)+$/" data-toggle='tooltip'
														data-placement='right'
														title='Please enter name without special characters' />

												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 442px; text-align: left; font-family: arial; color: #ffffff;">Research
														Guide/ Supervisor Cell No(if any) :</span> <input
														name="projGuideMobile" type="text" id="mobile"
														style="width: 298px !important;" class="form-control"
														placeholder="Mobile"
														ng-model="newInnovation.projGuideMobile" ng-minlength=10
														ng-maxlength=10 ng-pattern="/^(\d)+$/"
														data-toggle='tooltip' data-placement='right'
														title='Mobile number should be 10 digits' />
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 442px; text-align: left; font-family: arial; color: #ffffff;">
														Research Guide E-mail (if any)<i class="fa fa-envelope"></i>
														: *
													</span> <input name="projGuideEmail" type="email" id="email"
														style="width: 298px !important;" maxlength=100 required
														class="form-control remail email-input"
														placeholder="Email"
														ng-model="newInnovation.projGuideEmail"
														data-toggle='tooltip' data-placement='right'
														title="Please enter valid email as a@a.com" />
												</div>

											</div>


											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 383px; text-align: left; font-family: arial; color: #ffffff;">
														In which year this project was finished or is tentatively
														going to be finished? :  </span> 
														
							
															<div class='input-group date' id='datetimepicker'>
																<input  type='text' name="projFinishYear" ng-model="newInnovation.projFinishYear" class="form-control yearCalender" style="width:260px;"/> <span
																	class="input-group-addon"> <span
																	class="glyphicon glyphicon-calendar"> </span>
																</span>
															</div>
														
													<!-- <input name="projFinishYear" id="datetimepicker"
														type="text" style="width: 298px !important;"
														class="form-control" placeholder="Innovation year(YYYY)"
														ng-model="newInnovation.projFinishYear" ng-maxlength="4"
														ng-minlength="4" data-toggle='tooltip'
														ng-pattern="/^(\d)+$/" required
														title="Year should be in YYYY format" /> -->
												</div>

											</div>
											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 442px; text-align: left; font-family: arial; color: #ffffff;">
														Project was completed under which Academic Program?: *</span> <select
														name="projAcademicProgram" type="text"
														style="width: 298px !important;" class="form-control"
														placeholder="Academic Program"
														ng-model="newInnovation.projAcademicProgram" required>
														<option value selected="selected">select</option>
														<option value="Academic">Academic</option>
														<option value="Diploma">Diploma</option>
														<option value="Undergraduate">Undergraduate</option>
														<option value="Postgraduate">Postgraduate</option>
														<option value="Doctoral">Doctoral</option>
														<option value="Post Doctoral">Post Doctoral</option>
													</select>
												</div>

											</div>
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 442px; text-align: left; font-family: arial; color: #ffffff;">
														Whether any reservation in showing it on website? </span> <select
														name="publishOnWebsite" type="text" id="publishonwebsite"
														style="width: 298px !important;" class="form-control"
														placeholder="Academic Program"
														ng-model="newInnovation.publishOnWebsite">
														<option value selected="selected">select</option>
														<option value="No restriction, publish it">No
															restriction, publish it</option>
														<option value="don't publish yet, patent pending">don't
															publish yet, patent pending</option>
													</select>
												</div>

											</div>

										</div>
									</div>
								</div>

								<div class="col-xs-12"
									style="background-color: #f5f5f5; margin-right: 9px;">
									<div class="panel panel-default"
										style="border-style: none; background-color: #f5f5f5">
										<div class="panel-heading"
											style="border-style: none; font-family: arial; font-weight: bold;">GYTI
											Innovation Specific Information:</div>
										<div class="panel-body project-basic-info"
											style="border-style: none; background-color: #f5f5f5;">
											<!-- <div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Discipline/Sector
														of project: </span> <input name="midName" type="text"
														style="width: 300px !important;"
														class="form-control rname"
														placeholder="Sector Of Project " ng-model=""
														ng-maxlength="30" ng-pattern="/^(\D)+$/" />
												</div>

											</div> -->

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12"
												style="box-shadow: 1px 1px 1px 1px #888888;">
												<div>
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">Status
														Of your Innovation :* </span>
													<!-- <input name="projStatusInfo"
														type="text" style="width: 300px !important;"
														class="form-control rname"
														placeholder="Status Of Innovation" required
														ng-model="newInnovation.projStatusInfo" ng-maxlength="30"
														ng-pattern="/^(\D)+$/" /> -->

													<!-- <label ng-repeat="projStatusInfo in projStatusArray">
  															<input type="checkbox" ng-model="newInnovation.projStatusInfo" checklist-value="projStatusInfo"> {{projStatusInfo}}
														</label> -->
													<input type="checkbox" name="idea[]" value="Idea"
														ng-model="idea1">Idea<br> <input
														type="checkbox" name="idea[]"
														value="Research Stage (Lab. Stage)" ng-model="idea2">Research
													Stage (Lab. Stage)<br> <input type="checkbox"
														name="idea[]" value="Proof of Concept" ng-model="idea3">Proof
													of Concept<br> <input type="checkbox" name="idea[]"
														value="Prototype" ng-model="idea4">Prototype<br>
													<input type="checkbox" name="idea[]" value="Product"
														ng-model="idea5">Product<br> <input
														type="checkbox" name="idea[]" value="Pre-Incubation Stage"
														ng-model="idea6">Pre-Incubation Stage<br> <input
														type="checkbox" name="idea[]"
														value="Already into the Market/Implementation"
														ng-model="idea7">Already into the
													Market/Implementation<br>

												</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 615px; text-align: left; font-family: arial; color: #ffffff;">Have
														you filed patent/copyright of your innovations :*</span> <select
														style="width: 300px !important;" id="projCopyrightInfo"
														name="projCopyrightInfo" class="form-control"
														ng-model="newInnovation.projCopyrightInfo" required>
														<option value selected="selected">select</option>
														<option value="Yes">Yes</option>
														<option value="No">No</option>
														<option value="Under Process">Under Process</option>
													</select>
												</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 615px; text-align: left; font-family: arial; color: #ffffff;">Have
														you developed proof of
														concept/model/formulation/process/product of your
														innovation,have you made it:</span> <select
														style="width: 300px !important;" id="projProofInfo"
														name="projProofInfo" class="form-control"
														ng-model="newInnovation.projProofInfo">
														<option value selected="selected">select</option>
														<option value="Yes">Yes</option>
														<option value="No">No</option>
													</select>
												</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 615px; text-align: left; font-family: arial; color: #ffffff;">
														Mention  at least 2 or 3 recent patent and/or  publication/s from which your technology is distinctly different: *</span> <input
														name="otherDistinguishablePatents" type="text"
														style="width: 300px !important;"
														class="form-control rname"
														placeholder="Distinguishable Patents" required
														ng-model="newInnovation.otherDistinguishablePatents"
														ng-maxlength="100" />
												</div>

											</div>
											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 615px; text-align: left; font-family: arial; color: #ffffff;">Unique
														feature of your innovation : </span> <input name="projFeature"
														type="text" style="width: 300px !important;"
														class="form-control rname"
														placeholder="Unique Features of Innovation"
														ng-model="newInnovation.projFeature" ng-maxlength="100" />
												</div>

											</div>
											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 615px; text-align: left; font-family: arial; color: #ffffff;">Frugality
														of your innovations (cost effectiveness) : </span> <input
														name="projFrugalityInfo" type="text"
														style="width: 300px !important;"
														class="form-control rname"
														placeholder="Frugality of Innovation"
														ng-model="newInnovation.projFrugalityInfo"
														ng-maxlength="100" />
												</div>

											</div>
											<div class="col-xs-12">&nbsp;</div>

											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon"
														style="border-right: 1px solid #ccc; background-color: #217690; width: 615px; font-family: arial; color: #ffffff;">Which
														exact problem (Technical / Social / Commercial /
														Professional) does your innovation address? :*</span> <select
														style="width: 300px !important;" id="projObjectiveInfoArea" name="projObjectiveInfoArea"
														required class="form-control"
														ng-model="newInnovation.projObjectiveInfoArea" required>
														<option value selected="selected">select</option>
														<option value="Technical">Technical</option>
														<option value="Social">Social</option>
														<option value="Commercial">Commercial</option>
														<option value="Professional">Professional</option>
													</select>
												</div>

											</div>

											<div class="col-xs-12">&nbsp;</div>


										</div>
									</div>
									<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-btn-3"
											ng-disabled="validateCheckboxes(addGytiDetailedProjectInformationForm.$invalid)"
											style="margin-left: 91%; background-color: #5cb85c;">Continue</a>
									</div>
								</div>




							</form>
						</div>


						<h3 class="acc-pi-2 acc-hover"
							ng-class="validateCheckboxes(addGytiDetailedProjectInformationForm.$invalid)?'ui-state-disabled':'ui-state-default'"
							style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">GYTI
							Innovation Detailed Information</h3>

						<div>

							<form id="addGytiSpecificProjectInformationForm"
								name="addGytiSpecificProjectInformationForm" method="post"
								novalidate>

								<div class="col-xs-12"
									style="background-color: #f5f5f5; margin-right: 9px;">
									<div class="panel panel-default"
										style="border-style: none; background-color: #f5f5f5">

										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">What
													is the exact problem that your project has been
													addressed?(600 words nearly)*:</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projObjectiveInfo" required
															placeholder="Project Objective...." class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projObjectiveInfo" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projObjectiveInfo"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projObjectiveInfo.$dirty && addGytiSpecificProjectInformationForm.projObjectiveInfo.$error.maxlength">
															Project Objective cannot be more than 1000 characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>
											<!-- <div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													Mention at least 2 or 3 recent patent and/or publication/s
													from which your technology is distinctly different: *</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projOtherPatentWork" required
															placeholder="Project Objective...." class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projOtherPatentWork" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projOtherPatentWork"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projOtherPatentWork.$dirty && addGytiSpecificProjectInformationForm.projOtherPatentWork.$error.maxlength">
															Project Other Patent Work cannot be more than 1000
															characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div> -->


										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													Add description/photo/video/news/commendation:</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projPhotoVideoNewsOthers" 
															placeholder="Project Objective...." class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projPhotoVideoNewsOthers" rows="3"
															ng-maxlength="5000"
															ng-model="newInnovation.projPhotoVideoNewsOthers"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projPhotoVideoNewsOthers.$dirty && addGytiSpecificProjectInformationForm.projPhotoVideoNewsOthers.$error.maxlength">
															Project Photo Video/News/Others cannot be more than 5000
															characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>


										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">Proposed
													outcome/impact of your innovation?(150 words nearly):</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projImpactInfo"
															placeholder="Project Impact...." class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projImpactInfo" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projImpactInfo"></textarea>

														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projImpactInfo.$dirty && addGytiSpecificProjectInformationForm.projImpactInfo.$error.maxlength">
															Project Impact cannot be more than 1000 characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>


										<div class="col-xs-12">&nbsp;</div>


										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													Who have made contribution towards this project and
													specific detail i.e student team,faculty,mentor,anyone
													else.(100 words):</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projContributeInfo"
															placeholder="Project Contribution...."
															class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projContributeInfo" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projContributeInfo"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projContributeInfo.$dirty && addGytiSpecificProjectInformationForm.projContributeInfo.$error.maxlength">
															Project Contribution cannot be more than 1000 characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>


										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													For Research work to develop into a commercially viable
													product/service,how much resources would be required?(250
													words): (Don't repeat content from first):</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projRequiredResource"
															placeholder="Project resource...." class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projRequiredResource" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projRequiredResource"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projRequiredResource.$dirty && addGytiSpecificProjectInformationForm.projRequiredResource.$error.maxlength">
															Project resource cannot be more than 1000 characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>


										<div class="col-xs-12">&nbsp;</div>


										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													Do you think this research should continue further?If Yes,
													why and with objective?If No,Why?(100 words):</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projResearchContinue"
															placeholder="Project research...." class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projResearchContinue" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projResearchContinue"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projResearchContinue.$dirty && addGytiSpecificProjectInformationForm.projResearchContinue.$error.maxlength">
															Project research cannot be more than 1000 characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>


										<div class="col-xs-12">&nbsp;</div>


										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													Have you filed any patent for your research work ?Yes or No
													If yes please give details: reference:</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projPatentWork"
															placeholder="Project patent work...."
															class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projPatentWork" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projPatentWork"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projPatentWork.$dirty && addGytiSpecificProjectInformationForm.projPatentWork.$error.maxlength">
															Project patent work cannot be more than 1000 characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>



										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													Have you published any research paper in refered
													journal?Yes or No If yse please attach a copy or give
													reference:</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projPublishedPaper"
															placeholder="Project published paper..."
															class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projPublishedPaper" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projPublishedPaper"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projPublishedPaper.$dirty && addGytiSpecificProjectInformationForm.projPublishedPaper.$error.maxlength">
															Project published paper cannot be more than 1000
															characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>


										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													Any other information about your research you would like to
													share?(Max 250 words):</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projOtherInfo"
															placeholder="Project other information..."
															class="textarea-text"
															style="width: 920px; height: 100px;" name="projOtherInfo"
															rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projOtherInfo"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projOtherInfo.$dirty && addGytiSpecificProjectInformationForm.projOtherInfo.$error.maxlength">
															Project other information cannot be more than 1000
															characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12"
											style="box-shadow: 1px 1px 1px 1px #888888;">
											<div class="panel panel-default" style="border-style: none;">
												<div class="panel-heading"
													style="border-style: none; font-family: arial; font-weight: bold;">
													How do you feel that your innovation/project can Create
													more value/from less material resources for more people?:</div>
												<div class="panel-body project-abstract-info"
													style="border-style: none; background-color: #f5f5f5;">
													<div class="col-xs-12">
														<textarea id="projBenefitInfo"
															placeholder="projBenefitInfo..." class="textarea-text"
															style="width: 920px; height: 100px;"
															name="projBenefitInfo" rows="3" ng-maxlength="1000"
															ng-model="newInnovation.projBenefitInfo"></textarea>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addGytiSpecificProjectInformationForm.projBenefitInfo.$dirty && addGytiSpecificProjectInformationForm.projBenefitInfo.$error.maxlength">
															Project Benefit Information cannot be more than 1000
															characters</div>
													</div>
													<div class="col-xs-12">&nbsp;</div>
												</div>
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>



									</div>
									
								</div>
								<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-btn-4"
											ng-disabled="addGytiSpecificProjectInformationForm.$invalid"
											style="margin-left: 91%; background-color: #5cb85c;">Continue</a>
									</div>
							</form>
						</div>




						<h3 class="acc-pi-3 acc-hover"
							ng-class="addGytiSpecificProjectInformationForm.$valid?'ui-state-default':'ui-state-disabled'"
							style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">CAPTCHA</h3>
						<div>
							<div class="col-xs-12">
								<div class="col-xs-12 form-control "
									style="height: 85px !important">
									<div class="col-xs-4"
										style="padding-left: 0%; padding-right: 0%">
										<img src="jcaptcha.jpg" id="captcha_image"
											style="box-shadow: 0 0 2em #b2b2b2;" />
									</div>
									<div class="col-xs-4" style="margin-left: -120px;">
										<div class="col-xs-12">
											<a href="" onclick="reloadCaptcha()" alt="reload"><i
												style="" class="fa fa-refresh fa-2x"></i></a>
											<div id="addProjectCaptchaError1" style="color: red"
												role="alert">
												<i class="fa fa-exclamation-triangle"></i> <strong>Invalid
													Captcha!</strong>&nbsp;Please Try Again...
											</div>
										</div>

										<div class="col-xs-12">
											<input class="form-control" id="newInnovationjCaptchaId"
												placeholder="Enter the text here" type="text"
												name="jcaptcha" value="" ng-model="jCaptcha"
												style="width: 100%; margin-top: 8px" />
										</div>


									</div>
									<div class="col-xs-12 col-md-4">
										<!-- <a class="btn btn-primary reg-ctn-3" id="register"
											style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
											ng-click="registerSubmit()">Register</a> -->

										<button class="btn btn-primary new-innovation-submit"
											id="new-innovation" data-toggle="modal"
											data-target="#submitNewInnovationAlertModal"
											style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
											ng-disabled="(!jCaptcha)">
											<i class="fa fa-cart-plus" aria-hidden="true"></i>&nbsp;Submit
											Innovation
										</button>
									</div>
								</div>
								<!-- <div class="col-xs-12 col-md-6">
									<a href="#" class="btn btn-primary new-innovation-submit"
										id="new-innovation"
										style="width: 158px; height: 34px; margin-left: 350px; margin-top: 38px; background-color: #5cb85c;"
										ng-click="AcademicProjectToGyti()">Submit Innovation</a>
								</div> -->
							</div>
						</div>
					</div>

				</div>
				<div class="hr"></div>

				<input id="userId" type="text" style="display: none;"
					value=<%=session.getAttribute("username")%>>

				<div class="result-this"></div>

				<!-- Modal -->
				<div class="modal fade" id="addNewFacultyModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Add new faculty</h4>
							</div>
							<div class="modal-body">
								<form id="add-new-faculty-form">
									<div class="col-md-12">
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">First
													Name *</span> <input style="width: 245px;" id="newFacultyName"
													type="text" name="firstName" class="form-control"
													placeholder="Faculty Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Mid
													Name</span> <input type="text" style="width: 250px;"
													id="newFacultyMName" name="middleName" class="form-control"
													placeholder="Faculty Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Last
													Name *</span> <input type="text" style="width: 245px;"
													id="newFacultyLName" name="lastName" class="form-control"
													placeholder="Faculty Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">College
													*</span> <input type="text" class="form-control"
													placeholder="Search Colleges" style="width: 248px;"
													id="CollegeNames" name="college" onchange="validate()"
													class="form-control">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Email
													*</span> <input name="email" id="email" type="email"
													class="form-control" style="width: 247px;"
													onchange="validate()" placeholder="Enter Email address"
													required>
											</div>
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer" style="border-top: 1px solid #ffffff;">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button id="add-faculty-submit-button" type="button"
									class="btn  btn-success btn-responsive" data-dismiss="modal"
									disabled="true">Add faculty</button>
							</div>
						</div>
					</div>
				</div>

				<!-- New Team Member Modal -->
				<div class="modal fade" id="addNewTeamMemberModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Add New Team
									Member</h4>
							</div>
							<div class="modal-body">
								<form id="add_new_Team_Member_form"
									name="add_new_Team_Member_form">
									<div class="col-md-12">
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">First
													Name *</span> <input style="width: 245px;" id="fName" type="text"
													name="fName" ng-model="addMember.fName"
													class="form-control" placeholder="First Name"
													ng-maxlength="50" ng-pattern="/^(\D)+$/"
													data-toggle='tooltip' data-placement='right' required
													title='Please enter firstname'>

											</div>
											<span style="color: red"
												ng-show="add_new_Team_Member_form.fName.$dirty"> <span
												ng-show="add_new_Team_Member_form.fName.$error.required">First
													name is required.</span> <span
												ng-show="add_new_Team_Member_form.fName.$error.maxlength">First
													name cannot be more than 50 characters.</span>
											</span>

										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Mid
													Name</span> <input type="text" style="width: 250px;" id="mName"
													name="mName" ng-model="addMember.mName"
													class="form-control" placeholder="Middle Name"
													ng-maxlength="50" ng-pattern="/^(\D)+$/"
													data-toggle='tooltip' data-placement='right'
													title='Please enter middleName'>
											</div>
											<span style="color: red"
												ng-show="add_new_Team_Member_form.mName.$dirty"> <span
												ng-show="add_new_Team_Member_form.mName.$error.maxlength">Middle
													name cannot be more than 50 characters.</span> <span
												ng-show="add_new_Team_Member_form.mName.$error.pattern">Middle
													Name can only contain text.</span>
											</span>

										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Last
													Name *</span> <input type="text" style="width: 245px;" id="lName"
													name="lName" ng-model="addMember.lName"
													class="form-control" placeholder="Last Name"
													ng-maxlength="50" ng-pattern="/^(\D)+$/"
													data-toggle='tooltip' data-placement='right'
													title='Please enter lastName'>
											</div>
											<span style="color: red"
												ng-show="add_new_Team_Member_form.lName.$dirty"> <span
												ng-show="add_new_Team_Member_form.lName.$error.maxlength">Last
													name cannot be more than 50 characters.</span> <span
												ng-show="add_new_Team_Member_form.lName.$error.pattern">Last
													Name can only contain text.</span>
											</span>

										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">Gender
													*</span>
												<div class="form-group" style="margin-left: 10px;">


													<label class="radio-inline"> <input type="radio"
														ng-model="addMember.gender" name="gender" id="gender1"
														value="male" required>Male
													</label> <label class="radio-inline"> <input type="radio"
														ng-model="addMember.gender" name="gender" id="gender2"
														value="female">Female
													</label>
													<label class="radio-inline"> <input type="radio" ng-model="addMember.gender"
														name="gender" id="gender3" 
														value="trans">Trans
													</label>

												</div>
											</div>
										</div>

										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">Age*</span>
												<input name="age" ng-model="addMember.age" type="text"
													id="age" style="width: 245px" class="form-control"
													placeholder="Age" required ng-minlength=2 ng-maxlength=2
													ng-pattern="/^(\d)+$/" data-toggle='tooltip'
													data-placement='right' title='Age should be in number only' />
											</div>
											<span style="color: red"
												ng-show="add_new_Team_Member_form.age.$dirty"> <span
												ng-show="add_new_Team_Member_form.age.$error.maxlength">
													age should be of only two digit number.</span> <span
												ng-show="add_new_Team_Member_form.age.$error.minlength">
													age should be of only two digit number.</span> <span
												ng-show="add_new_Team_Member_form.age.$error.pattern">Age
													should be number only.</span>
											</span>

										</div>

										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px; font-family: arial; color: #ffffff;">Branch
													*</span> <input style="width: 245px !important;" type="text"
													class="form-control" placeholder="Search branches"
													id="branchIdOfStudent2" name="branchId"
													ng-model="addMember.branchId" value="" required>

											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>

										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Email
													Id*</span> <input type="email" id="emailId" name="emailId"
													ng-model="addMember.emailId"
													style="width: 245px !important;" maxlength=100
													class="form-control" placeholder="Email" required
													data-toggle='tooltip' data-placement='right'
													title="Please enter valid email as a@a.com" />
											</div>
											<span style="color: red"
												ng-show="add_new_Team_Member_form.emailId.$dirty"> <span
												ng-show="add_new_Team_Member_form.emailId.$error.required">
													Email is required.</span> <span
												ng-show="add_new_Team_Member_form.emailId.$error.email">Email
													is not valid.</span>
											</span>


										</div>
									</div>
								</form>
							</div>
							<div class="modal-body" id="errorDiv"
								ng-show="Errormessage.length>0" ng-repeat="msg1 in Errormessage"
								style="text-align: center;">
								<div
									class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
									style="color: black; text-align: center; font-family: arial;"
									role="alert">{{msg1}}</div>
							</div>
							<div class="modal-body" id="successDiv"
								ng-show="Successmessage.length>0"
								ng-repeat="msg2 in Successmessage" style="text-align: center;">
								<div
									class=" col-xs-12 xol-md-12 alert alert-success alert-dismissible"
									style="color: black; text-align: center; font-family: arial;"
									role="alert">{{msg2}}</div>
							</div>
							<div class="modal-body" id="addTeamMemberMessageDiv" ng-show="teamMemberSuccessmessage.length>0" ng-repeat="msg in teamMembermessage"
									style="text-align: center;">
									<div
										class=" col-xs-12 xol-md-12 alert alert-success alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert">{{msg}}</div>
								</div>
							<div class="modal-footer" style="border-top: 1px solid #ffffff;">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button id="add-team-member-submit-button" type="button"
									ng-click="addTeamMember()"
									class="btn  btn-success btn-responsive"
									ng-disabled="add_new_Team_Member_form.$invalid">Add
									Team Member</button>
							</div>
						</div>
					</div>
				</div>

				<!-- <div id="add-faculty-popup" style="display: none;">
				<form id="add-new-faculty-form">
					<div class="col-md-12">
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">First Name</span> <input id="newFacultyName" type="text"
									name="firstName" class="form-control" placeholder="Faculty Name">
							</div>

						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">Mid Name</span> <input type="text" name="middleName"
									class="form-control" placeholder="Faculty Name">
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">Last Name</span> <input type="text" name="lastName"
									class="form-control" placeholder="Faculty Name">
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">College </span> <input type="text" name="college"
									class="form-control" placeholder="Faculty college">
							</div>
						</div>
						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12">
							<div class="input-group">
								<span class="input-group-addon">Email </span> <input type="text" name="email"
									class="form-control" placeholder="Enter Email address">
							</div>
						</div>

						<div class="col-xs-12">&nbsp;</div>
						<div class="col-xs-12" style="text-align: center;">
							<input id="add-faculty-submit-button" type="submit" name="submit"
								class="btn btn-sm btn-success" />

						</div>
					</div>
				</form>
			</div> -->
				<div class="col-xs-12">&nbsp;</div>

				<div class="modal fade" id="searchTeamMemberModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Enter search
									parameters</h4>
							</div>
							<div class="modal-body">
								<form id="search-team-members-form">
									<div class="col-xs-12">
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">First
													Name </span> <input type="text" name="firstName"
													style="width: 350px;" class="form-control"
													placeholder="First Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Mid
													Name </span> <input type="text" name="midName"
													style="width: 350px;" class="form-control"
													placeholder="Middle Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Last
													Name </span> <input type="text" name="lastName"
													style="width: 350px;" class="form-control"
													placeholder="Last Name">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">College
												</span> <input type="text" class="form-control"
													placeholder="Search Colleges" style="width: 350px;"
													id="CollegeNames1" name="collge">

											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12">
											<div class="input-group">
												<span class="input-group-addon"
													style="border-right: 1px solid #ccc; background-color: #217690; width: 100px !important; font-family: arial; color: #ffffff;">Roll
													No: </span> <input type="text" name="studentID"
													style="width: 350px;" class="form-control"
													placeholder="Enrollment">
											</div>
										</div>
										<div class="col-xs-12">&nbsp;</div>
										<div class="col-xs-12" style="text-align: center;">
											<button id="search-team-members-submit-button" name="submit"
												class="btn btn-sm btn-success">
												<i class="fa fa-search"></i>&nbsp;Search
											</button>
										</div>
									</div>
								</form>
								<div id="fetched-team-members-container" style="display: none;">
									<div class="panel panel-default">
										<div class="panel-heading">Search results</div>
										<div class="panel-body">
											<select style="width: 100%" class="listbox"
												name="fetched-team-members" id="fetched-team-members"
												onchange="makeDisable()" multiple="multiple">
											</select>
											<p name="fetched-team-members-novalue"
												id="fetched-team-members-novalue"
												style="text-align: center;"></p>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer" style="border-top: 1px solid #ffffff;">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button id="choose-selected-team-members" type="button"
									class="btn btn-primary" data-dismiss="modal" disabled="true">Choose
									Selected</button>
							</div>
						</div>
					</div>
				</div>

				<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header" style="background-color: #4FCDFF;">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true" onclick="clickExit()">&times;</span><span
										class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">
									<i class="fa fa-upload"></i>&nbsp;Upload a document
								</h4>
							</div>
							<div class="modal-body" id="uploadmodalId">

								<input id="choseefile" type="file" multiple name="choseefile[]"
									ng-file="file"
									onChange="addFileInput('uploadmodalId','choseefile')"
									base-sixty-four-input>


							</div>
							<div class="modal-footer">
								<div ng-show="upload==false"
									style="width: 69px; height: 89px; position: absolute; top: 66%; left: 50%; padding: 2px;">
									<i class="fa fa-spinner fa-pulse"
										style="font-size: 50px; color: #4FCDFF;"></i>
								</div>
								<div class="alert alert-sm alert-info alert-dismissible"
									style="list-style: none; text-align: center;" role="alert"
									ng-show="message.length>0">
									<li ng-repeat="msg in message">{{msg}}</li>
								</div>

								<button style="background-color: green" class="btn btn-primary"
									ng-click="uploadProjectDocument()">
									<i class="fa fa-upload"></i>&nbsp;Upload
								</button>
								<button type="button" class="btn btn-info" data-dismiss="modal"
									onclick="clickExit()">
									<i class="fa fa-smile-o fa-2x" aria-hidden="true"></i>&nbsp;Exit
								</button>
							</div>
						</div>
					</div>
				</div>


				<!-- <div class="modal fade" id="askForUploadModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header" style="background-color: #4FCDFF;">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true" ng-click="datarefresh()">&times;</span><span
										class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">
									<i class="fa fa-upload"></i>&nbsp;Upload a document
								</h4>
							</div>
							<div class="modal-body" id="uploadmodalId">


								<h4 class="modal-title">
									<div class="panel panel-success add-project-response-panel row"
										style="display: none;">
										<div class="add-project-response panel-heading">Innovation
											submitted succesfully.Do you want upload a document?</div>
									</div>
								</h4>

							</div>
							<div class="modal-footer">
								<button class="btn btn-info" ng-click="openUploadModal()">&nbsp;Yes
								</button>
								<button type="button" class="btn btn-info" data-dismiss="modal"
									onclick="clickExit()">&nbsp;No</button>

							</div>
						</div>
					</div>
				</div> -->

				<!--submit new innovation to GYTI alert -->
				<div class="modal fade" id="submitNewInnovationAlertModal"
					tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header"
								style="background-color: #31b0d5; color: white; text-align: center">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Submit New
									Innovation</h4>
							</div>

							<div classs="modal-body" id="addProjectCaptchaError"
								style="text-align: center;">
								<div class="col-xs-12" style="height: 70px;">
									<div style="color: red; padding-top: 25px;" role="alert">
										<i class="fa fa-exclamation-triangle"></i> <strong>Invalid
											Captcha!</strong>&nbsp;Please Try Again...
									</div>
								</div>
								<a data-dismiss="modal" type="button" class="btn btn-info"
									id="ExitfunctionScript">Try Again</a>
								<div class="clearfix">&nbsp;</div>
							</div>

							<div id="addProjectResponse">

								<div class="modal-body" id="loaderGIF">
									<div class="loaderBody" id="addProjectloaderBody">Please
										sit back and relax while we are saving your innovation ...</div>
								</div>
								<div class="modal-body" id="addProjectSuccess"
									style="text-align: center;">
									<div>
										<i id="effect" class="fa fa-check-circle-o"
											style="color: green; font-size: 7em;"></i>
									</div>
									<div
										class="addProjectSuccessMsg col-xs-12 xol-md-12 alert alert-success alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert"></div>
								</div>
								<div class="modal-body" style="text-align: center;"
									id="addProjectResponseEmailError">
									<div style="text-align: center;">
										<i id="effect" class="fa fa-check-circle-o"
											style="color: #8a6d3b; font-size: 7em;"></i>
									</div>
									<div
										class="addProjectResponseEmailErrorMsg col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"></div>
								</div>

								<div class="modal-body" style="text-align: center;"
									id="addProjectResponseError">
									<div style="text-align: center;">
										<i class="fa fa-exclamation-triangle"
											style="color: #E84F63; font-size: 50px; text-align: center;"></i>
									</div>
									<div
										class="addProjectResponseErrorMsg col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"></div>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="modal-footer"
									style="align: center; text-align: center;">
									<button data-dismiss="modal" class="btn btn-info"
										ng-click="openUploadModal()">
										<i class="fa fa-smile-o fa-2x" aria-hidden="true"></i>&nbsp;Yes
									</button>
									<button type="button" class="btn btn-info" data-dismiss="modal"
										onclick="clickExit()">
										<i class="fa fa-frown-o fa-2x" aria-hidden="true"></i>&nbsp;No
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>



				<script type="text/javascript">
					$(".loaderBody").load(function() {
						$(".loaderBody").fadeOut("slow");
					})
				</script>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>

<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->

<!-- END JAVASCRIPTS -->
<script type="text/javascript">
	function validate() {
		//alert("121");
		// 	var a = $('#newFacultyName').val().length;
		// 	alert(a);
		// 	if(a==0)
		if ($('#CollegeNames').val().length > 0
				&& $('#newFacultyLName').val().length > 0
				&& $('#newFacultyName').val().length > 0
				&& $('#email').val().length > 0) {
			$("#add-faculty-submit-button").prop("disabled", false);
		} else {
			$("#add-faculty-submit-button").prop("disabled", true);
		}
		// 	if ($('#newFacultyName').val().length   >   0   &&
		//         $('#newFacultyMName').val().length  >   0   &&
		//         $('#newFacultyLName').val().length  >   0   &&
		//         $('#CollegeNames').val().length  >   0   &&
		//         $('#email').val().length    >   0) {
		//         $("add-faculty-submit-button").prop("disabled", false);
		//     }
		//     else {
		//         $("add-faculty-submit-button").prop("disabled", true);
		//     }
	}
	function makeDisable() {
		var value = $('fetched-team-members:selected').text();

		if (value === '') {
			$("#choose-selected-team-members").prop('disabled', false);
		} else {
			$("#choose-selected-team-members").prop('disabled', true);
		}
	}

	// $(document).ready(function (){

	//     validate();
	//     $('#newFacultyName, #newFacultyMName, newFacultyLName,CollegeNames,email').change(validate);

	// });
</script>
<script type="text/javascript">
	$(document).keydown(
			function(e) {
				var doPrevent;
				if (e.keyCode == 8) {
					var d = e.srcElement || e.target;
					if (d.tagName.toUpperCase() == 'INPUT'
							|| d.tagName.toUpperCase() == 'TEXTAREA') {
						doPrevent = d.readOnly || d.disabled;
					} else
						doPrevent = true;
				} else
					doPrevent = false;

				if (doPrevent)
					e.preventDefault();
			});
</script>
<script>
	function addFileInput(modalName, firstInputId) {
		var fs = document.getElementById(modalName);

		// only add one if the last file-input field is not empty
		if (fs.lastElementChild.value != '') {
			var firstInputFile = document.getElementById(firstInputId);
			// var firstInputFile=$(".uploadclass");
			var newInputFile = document.createElement("input");
			newInputFile.type = firstInputFile.type;
			newInputFile.name = firstInputFile.name;
			newInputFile.id = firstInputFile.id;
			newInputFile.multiple = firstInputFile.multiple;
			newInputFile.base64 = firstInputFile.base64;
			newInputFile.onchange = firstInputFile.onchange;
			fs.appendChild(newInputFile);
		}

	}
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
<script src="js/webrtc.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/customStyle.css">
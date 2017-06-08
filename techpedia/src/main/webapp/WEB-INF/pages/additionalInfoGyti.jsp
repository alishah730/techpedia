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
<body>
	<div class="clearfix"></div>
	<div class="container customFont borderRadius style"
		style="background-color: #ffffff; width: 100%;">
		<div class="page-container">

			<div class="page-content-wrapper" ng-controller="additionalInfoGytiController" ng-init="InitLoad()" style="width: 1068px !important;">
				<div class="page-content">
					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN PAGE TITLE & BREADCRUMB-->
							<h3 class="page-title">
								<i class="fa fa-briefcase" id="icon-size"></i> GYTI Project
							</h3>
							<ul class="page-breadcrumb breadcrumb">
								<li style="color: #262626 !important"><a
									style="color: #262626 !important" href="./">Home&nbsp;</a><font
									style="color: black; font-size: 18px;">&raquo;</font></li>
								<li style="color: #262626 !important"><a
									style="color: #262626 !important" href="dashboard">Dashboard&nbsp;</a><font
									style="color: black; font-size: 18px;">&raquo;</font></li>
								<li style="color: #262626 !important"><a
									style="color: #262626 !important" href="manageProjects">Manage
										Projects&nbsp;</a><font style="color: black; font-size: 18px;">&raquo;</font></li>
								<li>GYTI Project</li>
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

						<div div id="accordion" class="col-xs-12">
							<h3
								style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">Additional
								GYTI Project Information</h3>
							<div>
								<div>
									<form id="submitAcademicProjectToGytiForm"
										name="submitAcademicProjectToGytiForm"
										 method="post"
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
														ng-model="submitAcademicProjectToGyti.nominatedBy" ng-maxlength="80"
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
														name="projPreviousAwardYear" type="text" id="awardYear"
														style="width: 298px !important;" class="form-control"
														placeholder="Innovation year(YYYY)"
														ng-model="submitAcademicProjectToGyti.projPreviousAwardYear" ng-maxlength="4"
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
														ng-model="submitAcademicProjectToGyti.projGuideName" ng-maxlength="80"
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
														ng-model="submitAcademicProjectToGyti.projGuideMobile" ng-minlength=10
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
														ng-model="submitAcademicProjectToGyti.projGuideEmail"
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
																<input  type='text' name="projFinishYear" ng-model="submitAcademicProjectToGyti.projFinishYear" class="form-control yearCalender" style="width:260px;"/> <span
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
														ng-model="submitAcademicProjectToGyti.projAcademicProgram" required>
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
														ng-model="submitAcademicProjectToGyti.publishOnWebsite">
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

								<div class="col-xs-12"	style="background-color: #f5f5f5; margin-right: 9px;">
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
														ng-model="submitAcademicProjectToGyti.projProofInfo">
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
														ng-model="submitAcademicProjectToGyti.otherDistinguishablePatents"
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
														ng-model="submitAcademicProjectToGyti.projFeature" ng-maxlength="100" />
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
														ng-model="submitAcademicProjectToGyti.projFrugalityInfo"
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
														ng-model="submitAcademicProjectToGyti.projObjectiveInfoArea" required>
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
									</div>
										<div class="col-xs-12">
											<a href="#" class="btn btn-primary continue-btn"
												ng-disabled="validateCheckboxes(submitAcademicProjectToGytiForm.$invalid)"
												style="margin-left: 91%; background-color: #5cb85c;">Continue</a>
										</div>
									</form>
								</div>

							</div>


							<h3 class="acc-pi acc-hover"
								ng-class="validateCheckboxes(submitAcademicProjectToGytiForm.$invalid)?'ui-state-disabled':'ui-state-default'"
								style="background-color: #217690; font-family: arial; color: black; font-weight: bold;">Detailed
								Project Information</h3>
							<div>

								<form id="addGytiSpecificProjectInformationForm"
									name="addGytiSpecificProjectInformationForm" method="post" novalidate>
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
															ng-model="submitAcademicProjectToGyti.projObjectiveInfo"></textarea>
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
															ng-model="submitAcademicProjectToGyti.projPhotoVideoNewsOthers"></textarea>
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
															ng-model="submitAcademicProjectToGyti.projImpactInfo"></textarea>

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
															ng-model="submitAcademicProjectToGyti.projContributeInfo"></textarea>
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
															ng-model="submitAcademicProjectToGyti.projRequiredResource"></textarea>
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
															ng-model="submitAcademicProjectToGyti.projResearchContinue"></textarea>
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
															ng-model="submitAcademicProjectToGyti.projPatentWork"></textarea>
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
															ng-model="submitAcademicProjectToGyti.projPublishedPaper"></textarea>
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
															ng-model="submitAcademicProjectToGyti.projOtherInfo"></textarea>
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
															ng-model="submitAcademicProjectToGyti.projBenefitInfo"></textarea>
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
										<a href="#" class="btn btn-primary continue-btn-2"
											ng-disabled="addGytiSpecificProjectInformationForm.$invalid"
											style="margin-left: 91%; background-color: #5cb85c;">Continue</a>
									</div>
								</form>
							</div>




							<h3 class="acc-pi-1 acc-hover"
								ng-class="addGytiSpecificProjectInformationForm.$invalid?'ui-state-disabled':'ui-state-default'"
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
													style="" class="fa fa-refresh fa-2x"></i></a> <span
													style="color: red" role="alert"
													ng-show="messageerrorCaptcha.length>0"
													ng-repeat="msg in messageerrorCaptcha"><i
													class="fa fa-exclamation-triangle"></i> <strong>Invalid
														Captcha!</strong>&nbsp;Please Try Again... </span>
											</div>
											<div class="col-xs-12">
												<input class="form-control"
													placeholder="Enter the text here" type="text"
													name="jcaptcha" value="" ng-model="jCaptcha"
													style="width: 100%; margin-top: 8px" />
											</div>
										</div>
										<div class="col-xs-12 col-md-4">
											<button
												class="btn btn-success" id="submitAcademicProjectToGyti"
												style="margin-left: 91%; margin-top: 14%;"
												ng-click="AcademicProjectToGyti(jCaptcha)"
												ng-disabled="(!jCaptcha)" data-toggle="modal"
												data-target="#additionalInfoGYTIAlertModal">
												<i class="fa fa-floppy-o" aria-hidden="true"></i>&nbsp;Submit
												Project
											</button>
										</div>
									</div>

									<!-- <div class="col-xs-12 col-md-6">
										<a class="btn btn-primary reg-ctn-3"
											ng-class="submitAcademicProjectToGytiForm.$invalid?'ui-state-disabled':'ui-state-default'"
											id="submitAcademicProjectToGyti"
											style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
											ng-click="AcademicProjectToGyti()">Save Project</a>
									</div> -->
								</div>
								<div class="alert alert-sm alert-info alert-dismissible"
									style="list-style: none; text-align: center;" role="alert"
									ng-show="message.length>0">
									<div ng-repeat="msg in message">{{msg}}</div>
								</div>
							</div>
						</div>
					</div>


					<div class="panel panel-success add-project-response-panel"
						style="display: none;">
						<div class="add-project-response panel-heading"></div>
					</div>

					<div class="hr"></div>

					<input id="userId" type="text" style="display: none;"
						value=<%=session.getAttribute("username")%>>

					<div class="result-this"></div>




					<div class="col-xs-12">&nbsp;</div>
				</div>

				<div class="clearfix"></div>

				<!--additional info alert -->
				<div class="modal fade" id="additionalInfoGYTIAlertModal"
					tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header"
								style="background-color: #31b0d5; color: white; text-align: center">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Submit Project
									For GYTI AWARD</h4>
							</div>
							<div classs="modal-body" ng-show="messageerrorCaptcha.length>0"
								style="text-align: center;">
								<div class="col-xs-12" style="height: 70px;">
									<div style="color: red; padding-top: 25px;" role="alert"
										ng-show="messageerrorCaptcha.length>0"
										ng-repeat="msg in messageerrorCaptcha">
										<i class="fa fa-exclamation-triangle"></i> <strong>Invalid
											Captcha!</strong>&nbsp;Please Try Again...
									</div>
								</div>
								<button data-dismiss="modal" type="button" class="btn btn-info"
									ng-click="Exitfunction()">Try Again</button>
								<div class="clearfix">&nbsp;</div>
							</div>
							<div ng-hide="messageerrorCaptcha.length>0">
								<div class="modal-body"
									ng-hide="messageSuccess.length>0 || messageWarning.length>0 ||messageerrorCaptcha.length>0">
									<div class="loaderBody"
										ng-hide="messageWarning.length>0 || messageSuccess.length>0 ||messageerrorCaptcha.length>0">Please
										sit back and relax while we are submitting your project for
										GYTI award...</div>
								</div>
								<div class="modal-body" ng-show="messageSuccess.length>0"
									style="text-align: center;">
									<div>
										<i id="effect" class="fa fa-check-circle-o"
											style="color: green; font-size: 7em;"></i>
									</div>
									<div
										class="col-xs-12 xol-md-12 alert alert-success alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										role="alert" ng-repeat="msgSuccess in messageSuccess">
										<p>{{msgSuccess}}</p>
									</div>
								</div>
								<div class="modal-body" style="text-align: center;"
									ng-show="messageWarningEmail.length>0">
									<div style="text-align: center;">
										<i id="effect" class="fa fa-check-circle-o"
											style="color: #8a6d3b; font-size: 7em;"></i>
									</div>
									<div
										class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										ng-repeat="msg in messageWarningEmail">{{msg}}</div>
								</div>

								<div class="modal-body" style="text-align: center;"
									ng-show="messageWarning.length>0">
									<div style="text-align: center;">
										<i class="fa fa-exclamation-triangle"
											style="color: #E84F63; font-size: 50px; text-align: center;"></i>
									</div>
									<div
										class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
										style="color: black; text-align: center; font-family: arial;"
										ng-repeat="msg in messageWarning">{{msg}}</div>
								</div>
								<div class="clearfix">&nbsp;</div>
								<div class="modal-footer"
									style="align: center; text-align: center;">
									<a href="./" data-dismiss="modal" class="btn btn-info"
										onclick="clickExit()">Exit</a>
								</div>
							</div>
						</div>
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
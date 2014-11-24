<html ng-app="techpedia">
<jsp:include page="template/dashboardHeader.jsp" />
<div class="clearfix"></div>
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div>
	<div class="page-content-wrapper" ng-controller="AddChallengeController">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">

					<h3 class="page-title">
						<i class="fa fa-thumbs-up" id="icon-size"></i> Add Challenge
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li><a href="manageProjects">Manage Challenge</a> &raquo;</li>
						<li>Add Challenge</li>
						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
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

			<div class="clearfix"></div>
			<div class="row">
				<form id="addChallengeForm" name="addChallengeForm" method="post" commandName="challenge"
					novalidate>
					<div id="accordion" class="col-xs-12">
						<h3 class="addChallenge-accordion-1 acc-hover">Challenge Information</h3>
						<div>
							<div>
								<div class="col-xs-12">
									<!-- USER INFO START -->
									<div class="panel panel-default">
										<div class="panel-heading">Basic Information</div>
										<div class="panel-body challenge-basic-info">
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">Title </span> <input
														id="challengeTitle" name="challengTitle" type="text" class="form-control rname"
														placeholder="Challenge Title" ng-model="challenge.challengeTitle" required
														ng-maxlength="30" ng-minlength="5" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeTitle.$dirty && addChallengeForm.challengeTitle.$error.required">Title
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeTitle.$dirty && addChallengeForm.challengeTitle.$error.maxlength">Title
													cannot be more than 30 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeTitle.$dirty && addChallengeForm.challengeTitle.$error.minlength">Title
													cannot be more than 5 characters</div>

												<div class="col-xs-12">&nbsp;</div>


												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon" style="border-right: 1px solid #ccc">Challenge
															Type</span> <select name="challengTypeId" class="form-control">
															<option value="20">Industry defined</option>
															<option value="10">Faculty/Student defined</option>
															<option value="30">Grassroot Innovations</option>
														</select>
													</div>

												</div>
												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12 ">
													<div class="input-group input-group-sm">
														<span class="input-group-addon">Start date</span> <input id="challengeStartDate"
															name="challengStartDate" type="text" class="form-control"
															placeholder="Challenge Start date" ng-model="challenge.projectStartdate" required
															datepicker-angular /><span class="input-group-addon">YYYY-MM-DD</span>

														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
															ng-show="addChallengeForm.projectStartdate.$dirty && addChallengeForm.projectStartdate.$error.required">Challenge
															Start date is required</div>
														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
															ng-show="addChallengeForm.projectStartdate.$dirty && addChallengeForm.projectStartdate.$error.date">Not
															a valid date</div>
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 ">
													<div class="input-group input-group-sm">
														<span class="input-group-addon">End date</span> <input id="challengeEndDate"
															name="challengEndDate" type="text" class="form-control"
															placeholder="Challenge End date" ng-model="challenge.projectEnddate" required
															datepicker-angular /><span class="input-group-addon">YYYY-MM-DD</span>

														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
															ng-show="addChallengeForm.projectEnddate.$dirty && addChallengeForm.projectEnddate.$error.required">Challenge
															End date is required</div>
														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
															ng-show="addChallengeForm.projectEnddate.$dirty && addChallengeForm.projectEnddate.$error.date">Not
															a valid date</div>

													</div>
												</div>

											</div>
										</div>


										<!-- USER INFO END -->
									</div>
								</div>

								<div class="col-xs-12">
									<!-- USER INFO START -->
									<div class="panel panel-default">
										<div class="panel-heading">Challenge Abstract</div>
										<div class="panel-body challenge-state-info">
											<div class="col-xs-12">
												<div class="input-group input-group-sm">

													<textarea id="challengeAbstract" placeholder="Challenge abstract..."
														class="textarea-text" style="resize: none; width: 100%" name="challengAbstract"
														rows="5" ng-model="challenge.challengeAbstract"></textarea>
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeAbstract.$dirty && addChallengeForm.challengeAbstract.$error.required">Challenge
													Abstract is required</div>
											</div>
										</div>
									</div>

									<div class="col-xs-12">&nbsp;</div>

									<div class="col-xs-12 col-md-12">
										<div class="panel panel-default">
											<div class="panel-heading">Challenge Description</div>
											<div class="panel-body project-description-info">
												<div class="col-xs-12">
													<div class="input-group input-group-sm">

														<textarea id="challengeDescription" placeholder="Challenge description..."
															class="textarea-text" style="resize: none;" name="challengDescription" rows="5"
															ng-model="challenge.challengeDescription"></textarea>
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
														ng-show="addChallengeForm.challengeDescription.$dirty && addChallengeForm.challengeDescription.$error.required">Challenge
														description is required</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
											</div>
										</div>

									</div>
									<div class="col-xs-12">
										<div class="panel panel-default">
											<div class="panel-heading">
												<div class="btn-group">Challenge Image</div>
											</div>
											<div class="panel-body photoRTC">
												<input type="text" name="challengeImage" id="photoByte64" style="display: none;" /> <input
													type="text" name="photo" id="photoByte64Size" style="display: none;" />
												<canvas class='canvas' width='160' height='120' style='display: none;'></canvas>
												<div class="col-xs-12">
													<div class="col-xs-3">
														<video class='live' width='160' height='120' autoplay></video>
														<img width=160 height=120 src='images/gravatar.png' class='photo' alt='photo'
															style="display: none;">
													</div>

													<div class="col-xs-9">
														<div class="col-xs-12">
															<button class='takePhoto btn btn-info btn-sm'>Take photo</button>
															<button class='retakePhoto btn btn-info btn-sm' style="display: none;">Retake
																photo</button>
															<input id='hidden-photo-input' type='file' accept='image*;capture=camera'
																style='display: none;' />
														</div>
														<div class="col-xs-12">&nbsp;</div>
														<div class="col-xs-12">
															<button class='btn btn-sm btn-info photo-btn-click'>Upload photo</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>


									<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-addChallenge"
											ng-disabled=" addChallengeForm.$invalid">Continue</a>
									</div>
								</div>
							</div>
						</div>
						<h3 class="addChallenge-accordion-2 acc-hover"
							ng-class="addChallengeForm.$invalid?'ui-state-disabled':'ui-state-default'">Captcha</h3>
						<div>
							<div class="col-xs-12">
								<div class="col-xs-12 col-md-8">
									<div class="input-group input-group-sm">
										<span class="input-group-addon" style="border-right: 1px solid #ccc">1562 </span> <input
											path="captcha" name="captcha" type="text" class="form-control" id="captcha"
											placeholder="Captcha" />
									</div>

								</div>
								<div class="col-xs-12 col-md-4">
									<a href="manageChallenge" id="add-challenge-button" id="challenge"><input type="button"
										class="btn  btn-info add-challenge-button" value="Add Challenge"> </a>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="row">
				<div class="panel panel-success challenge-response-panel">
					<div class="panel-heading challenge-response"></div>
					<div ng-repeat="msg in message">{{msg}}</div>
				</div>
			</div>
			<div class="hr"></div>
			<div class="result-this"></div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="js/dashboardJs/excanvas.min.js"></script> 
<![endif]-->
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
<script src="js/webrtc.js"></script>
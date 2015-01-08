<%@ page import="java.util.Random"%>
<html ng-app="techpedia">
<jsp:include page="template/dashboardHeader.jsp" />
<div class="clearfix"></div>
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div>
	<div class="page-content-wrapper" ng-controller="AddChallengeController" ng-init="InitChallengeLoad()">
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
											<!-- <div class="col-xs-12">&nbsp;</div> -->
											<div class="col-xs-12">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" >Title </span> <input
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
													should be more than 5 characters</div>
</div>
												<div class="col-xs-12">&nbsp;</div>


																		<div class="col-xs-12">
													<div class="input-group input-group-sm"><span class="input-group-addon" >Challenge
															Type *</span> 
													<input type="text" class="form-control" placeholder="Search Type" id="challengeTypeId2"
														ng-model="challenge.searchTerm" ng-change="searchChallengeType()" value="" />
												<select id="challengeTypeId" class="form-control" name="challengeTypeId"
														ng-model="challenge.challengeTypeId"
														ng-options="item.challengTypeId as item.challengTypeDesc for item in data">
													</select>
												</div>	
												
												<!-- 	<div class="input-group input-group-sm">
														<span class="input-group-addon" >Challenge
															Type *</span> <select name="challengTypeId" class="form-control">
															<option value="20">Industry </option>
															<option value="10">Academic</option>
															<option value="30">Innovation</option>
														</select>
													</div> -->
										<!-- 			<div class="col-xs-12">
													<select id="challengeTypeId" class="form-control" name="challengeTypeId"
														ng-model="challenge.challengeTypeId"
														ng-options="item.challengTypeId as item.challengTypeDesc for item in data">
													</select>
												</div>
 -->
												</div>
												<div class="col-xs-12">&nbsp;</div>

												<div class="col-xs-12 ">
													<div class="input-group input-group-sm">
														<span class="input-group-addon">Start date</span> <input id="challengStartDate"
															name="challengStartDate" type="text" class="form-control"
															placeholder="Challenge Start date" ng-model="challenge.challengStartdate" 
															datepicker-angular /><span class="input-group-addon">YYYY-MM-DD</span>

														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
															ng-show="addChallengeForm.challengStartDate.$dirty && addChallengeForm.challengStartDate.$error.required">Challenge
															Start date is required</div>
														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
															ng-show="addChallengeForm.challengStartDate.$dirty && addChallengeForm.challengStartDate.$error.date">Not
															a valid date</div>
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 ">
													<div class="input-group input-group-sm">
														<span class="input-group-addon">End date</span> <input id="challengCloseDate"
															name="challengCloseDate" type="text" class="form-control"
															placeholder="Challenge End date" ng-model="challenge.challengCloseDate" 
															datepicker-angular /><span class="input-group-addon">YYYY-MM-DD</span>

														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
															ng-show="addChallengeForm.challengCloseDate.$dirty && addChallengeForm.challengCloseDate.$error.required">Challenge
															End date is required</div>
														<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
															ng-show="addChallengeForm.challengCloseDate.$dirty && addChallengeForm.challengCloseDate.$error.date">Not
															a valid date</div>

													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
												<div class="input-group input-group-sm">
														<span class="input-group-addon">Challenge Source Fund</span> <input id="challengeSourceFund"
														name="challengeSourceFund" type="text" class="form-control" placeholder="Challenge Source Fund"
														ng-model="challenge.challengeSourceFund" required ng-maxlength="30" ng-minlength="5" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeSourceFund.$dirty && addChallengeForm.challengeSourceFund.$error.required">Challenge source fund
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeSourceFund.$dirty && addChallengeForm.challengeSourceFund.$error.maxlength">Challenge source fund
													cannot be more than 30 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeSourceFund.$dirty && addChallengeForm.challengeSourceFund.$error.minlength">Challenge source fund
													should be more than 5 characters</div>
												</div>	
											
										</div>


										<!-- USER INFO END -->
									</div>
								</div>
										<div class="col-xs-12">
									<!-- USER INFO START -->
									<div class="panel panel-default">
										<div class="panel-heading">Additional Information</div>
										<div class="panel-body challenge-basic-info">
										
										<div class="col-xs-12">
												<div class="input-group input-group-sm">
														<span class="input-group-addon">Challenge Impact</span> <input id="challengeImpact"
														name="challengeImpact" type="text" class="form-control" placeholder="Challenge Impact"
														ng-model="challenge.challengeImpact" required ng-maxlength="30" ng-minlength="5" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeImpact.$dirty && addChallengeForm.challengeImpact.$error.required">Challenge Impact
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeImpact.$dirty && addChallengeForm.challengeImpact.$error.maxlength">Challenge Impact
													cannot be more than 30 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeImpact.$dirty && addChallengeForm.challengeImpact.$error.minlength">Challenge Impact
													should be more than 5 characters</div>
												</div>	
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
												<div class="input-group input-group-sm">
														<span class="input-group-addon">Challenge Incentive</span> <input id="challengeIncentive"
														name="challengeIncentive" type="text" class="form-control" placeholder="Challenge Incentive"
														ng-model="challenge.challengeIncentive" required ng-maxlength="30" ng-minlength="5" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeIncentive.$dirty && addChallengeForm.challengeIncentive.$error.required">Challenge Incentive
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeIncentive.$dirty && addChallengeForm.challengeIncentive.$error.maxlength">Challenge Incentive
													cannot be more than 30 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeIncentive.$dirty && addChallengeForm.challengeIncentive.$error.minlength">Challenge Incentive
													should be more than 5 characters</div>
												</div>	
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
												<div class="input-group input-group-sm">
														<span class="input-group-addon">Challenge Delivery Expectation</span> <input id="challengeDeliveryExpectation"
														name="challengeDeliveryExpectation" type="text" class="form-control" placeholder="Challenge Delivery Expectation"
														ng-model="challenge.challengeDeliveryExpectation" required ng-maxlength="30" ng-minlength="5" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeDeliveryExpectation.$dirty && addChallengeForm.challengeDeliveryExpectation.$error.required">Challenge Delivery Expectation
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeDeliveryExpectation.$dirty && addChallengeForm.challengeDeliveryExpectation.$error.maxlength">Challenge Delivery Expectation
													cannot be more than 30 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeDeliveryExpectation.$dirty && addChallengeForm.challengeDeliveryExpectation.$error.minlength">Challenge Delivery Expectation
													should be more than 5 characters</div>
												</div>	
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
												<div class="input-group input-group-sm">
														<span class="input-group-addon">Challenge Benchmark</span> <input id="challengeBenchmark"
														name="challengeBenchmark" type="text" class="form-control" placeholder="Challenge Benchmark"
														ng-model="challenge.challengeBenchmark" required ng-maxlength="30" ng-minlength="5" />
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challenge.challengeBenchmark.$dirty && addChallengeForm.challenge.challengeBenchmark.$error.required">Challenge Benchmark
													is required</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challenge.challengeBenchmark.$dirty && addChallengeForm.challenge.challengeBenchmark.$error.maxlength">Challenge Benchmark
													cannot be more than 30 characters</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challenge.challengeBenchmark.$dirty && addChallengeForm.challenge.challengeBenchmark.$error.minlength">Challenge Benchmark
													should be more than 5 characters</div>
												</div>	
												<div class="col-xs-12">&nbsp;</div>
								<div class="col-xs-12 col-md-6">
									<!-- USER INFO START -->
									<div class="panel panel-default">
										<div class="panel-heading">Challenge Abstract</div>
										<div class="panel-body challenge-state-info">
											<div class="col-xs-12">
												<div class="input-group input-group-sm">

													<textarea id="challengeAbstract" placeholder="Challenge abstract..."
														class="textarea-text" style="resize: none; " name="challengAbstract"
														rows="4" cols="32" ng-model="challenge.challengeAbstract"></textarea>
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
													ng-show="addChallengeForm.challengeAbstract.$dirty && addChallengeForm.challengeAbstract.$error.required">Challenge
													Abstract is required</div>
											</div>
										</div>
									</div>

									</div>

									<div class="col-xs-12 col-md-6 ">
										<div class="panel panel-default">
											<div class="panel-heading">Challenge Description</div>
											<div class="panel-body challenge-state-info">
												
													<div class="input-group input-group-sm">

														<textarea id="challengeDescription" placeholder="Challenge description..."
															class="textarea-text" style="resize: none;" name="challengDescription" rows="4" cols="32"
															ng-model="challenge.challengeDescription"></textarea>
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible" role="alert"
														ng-show="addChallengeForm.challengeDescription.$dirty && addChallengeForm.challengeDescription.$error.required">Challenge
														description is required</div>
											
												
											</div>
										</div>

									</div>
									<div class="col-xs-12">&nbsp;</div>
									
											
									
									
									
									<div class="col-xs-12">
										<div class="panel panel-default" ng-controller="ChangePhotoController" ng-init="InitLoad()">
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
															
																<input ng-model="addChallenge.photo" type="text" name="photo" id="photoByte64"
							style="display: none;" /> <input id='hidden-photo-input' type='file'
							accept='image*;capture=camera' style='display: none;' ng-file="file" base64 />
														</div>
														<div class="col-xs-12">&nbsp;</div>
														<div class="col-xs-12">
															<button class='btn btn-sm btn-info' onclick="$('#hidden-photo-input').click();">Choose
									photo</button>
														</div>
														<div class="col-xs-12" ng-show="msg.size.length>0">File size cannot be more than 10 KB</div>
							<div class="col-xs-12" ng-show="message.length>0">
								<div ng-repeat="msg in message">{{msg}}</div>
							</div>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="col-xs-17">
												<div class="input-group input-group-sm">
													<span class="input-group-addon" style="border-right: 1px solid #ccc">
														Documents</span> <input placeholder="Project Image" id="projectPhoto" name="projImage"
														type="file" style="display: none;" />
													<button class="projectPhoto btn btn-info btn-sm">Upload Documents</button>
												</div>
											
											</div>
										
										
										
										
										</div>
										
										
										
										
										
										
										
										
										
										
								
								</div></div></div>
								<div class="col-xs-12">
										<a href="#" class="btn btn-primary continue-addChallenge"
											ng-disabled="addChallengeForm.$invalid">Continue</a>
									</div>
							</div>
						</div>
						<h3 class="addChallenge-accordion-2 acc-hover"
							ng-class="addChallengeForm.$invalid?'ui-state-disabled':'ui-state-default'">Captcha</h3>
						<div>
							<div class="col-xs-12">
								<div class="col-xs-12 col-md-8">
								<div class="input-group input-group-sm" id="captchavalue">
									<span id="captchaVal" class="input-group-addon" style="border-right: 1px solid #ccc" >
										<%
											Random aRandom = new Random();
											long aStart = 1000;
											long aEnd = 9999;
											long range = (long) aEnd - (long) aStart + 1;
											long fraction = (long) (range * aRandom.nextDouble());
											int randomNumber = (int) (fraction + aStart);
											System.err.println("RANDOM NUMBER: " + randomNumber);
											out.write(String.valueOf(randomNumber));
										%>
									</span> <input name="captcha" type="text" class="form-control" id="captcha" placeholder="Captcha" />
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
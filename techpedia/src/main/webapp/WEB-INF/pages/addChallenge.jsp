<%@ page import="java.util.Random"%>
<html ng-app="techpedia">

<jsp:include page="template/NewHeader.jsp" />
<style>
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none;
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

.ui-icon {
	background-color: white;
}
</style>
<div class="clearfix"></div>
<div class="container customFont borderRadius style">
	<div class="page-container">
		<div class="page-sidebar-wrapper">
			<%-- 		<jsp:include page="template/dashboardMenu.jsp" /> --%>
		</div>
		<div class="page-content-wrapper"
			ng-controller="AddChallengeController" ng-init="InitChallengeLoad()">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">

						<h3 class="page-title">
							<i class="fa fa-thumbs-up" id="icon-size"></i> Add Challenge
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><a href="./" style="color: black;">Home</a> &raquo;</li>
							<li><a href="dashboard" style="color: black;">Dashboard</a>
								&raquo;</li>
							<li><a href="manageChallenge" style="color: black;">Manage
									Challenge</a> &raquo;</li>
							<li>Add Challenge</li>

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
					<form id="addChallengeForm" name="addChallengeForm" method="post"
						commandName="challenge" novalidate>
						<div id="accordion" class="col-xs-12">
							<h3 class="addChallenge-accordion-1 acc-hover"
								style="background-color: #217690; color: black; font-weight: bold;">Challenge
								Information</h3>
							<div>
								<div>
									<div class="col-xs-12 col-md-6">
										<!-- USER INFO START -->
										<div class="panel panel-default">
											<div class="panel-heading"
												style="background-color: #217690; color: white;">Basic
												Information</div>
											<div class="panel-body challenge-basic-info">
												<!-- <div class="col-xs-12">&nbsp;</div> -->
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="width: 170px; background-color: #217690; color: white;">Title
															*</span> <input style="width: 270px;" id="challengeTitle"
															name="challengTitle" type="text"
															class="form-control rname" placeholder="Challenge Title"
															ng-model="challenge.challengeTitle" required
															ng-maxlength="30" ng-minlength="5" />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengTitle.$dirty && addChallengeForm.challengTitle.$error.required">
														<i class="fa fa-exclamation-triangle"></i>&nbspTitle is
														required
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengTitle.$dirty && addChallengeForm.challengTitle.$error.maxlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspTitle
														cannot be more than 30 characters
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengTitle.$dirty && addChallengeForm.challengTitle.$error.minlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspTitle
														should be more than 5 characters
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>


												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span
															style="width: 170px; background-color: #217690; color: white;"
															class="input-group-addon">Challenge Type *</span> <input
															type="text" style="width: 270px;" class="form-control"
															placeholder="Search Type" id="challengeTypeId2"
															name="challengTypeId" ng-model="challenge.challengTypeId"
															class="form-control" value="" />
														<!-- 	<select id="challengeTypeId" class="form-control" name="challengeTypeId"
														ng-model="challenge.challengeTypeId"
														ng-options="item.challengTypeId as item.challengTypeDesc for item in data">
													</select> -->
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
														<span class="input-group-addon"
															style="width: 170px; background-color: #217690; color: white;">Start
															date * </span> <input style="width: 270px;"
															id="challengStartDate" name="challengStartDate"
															type="text" class="form-control"
															placeholder="Challenge Start date (DD-MMM-YYYY)"
															ng-model="challenge.challengStartdate" datepicker-angular />
														<!-- <span
															class="btn btn-success input-group-addon"
															style="background-color: #5cb85c; border-color: #4cae4c; color: white; width: 110px;">DD-MMM-YYYY</span> -->

														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addChallengeForm.challengStartDate.$dirty && addChallengeForm.challengStartDate.$error.required">
															<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
															Start date is required
														</div>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addChallengeForm.challengStartDate.$dirty && addChallengeForm.challengStartDate.$error.date">
															<i class="fa fa-exclamation-triangle"></i>&nbspNot a
															valid date
														</div>
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12 ">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="width: 170px; background-color: #217690; color: white;">End
															date *</span> <input style="width: 270px;"
															id="challengCloseDate" name="challengCloseDate"
															type="text" class="form-control"
															placeholder="Challenge End date  (DD-MMM-YYYY)"
															ng-model="challenge.challengCloseDate" datepicker-angular />
														<!-- <span
															class="btn btn-success input-group-addon"
															style="background-color: #5cb85c; border-color: #4cae4c; color: white; width: 110px;">DD-MMM-YYYY</span> -->

														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addChallengeForm.challengCloseDate.$dirty && addChallengeForm.challengCloseDate.$error.required">
															<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
															End date is required
														</div>
														<div class="alert alert-sm alert-danger alert-dismissible"
															role="alert"
															ng-show="addChallengeForm.challengCloseDate.$dirty && addChallengeForm.challengCloseDate.$error.date">
															<i class="fa fa-exclamation-triangle"></i>&nbspNot a
															valid date
														</div>

													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="width: 170px; background-color: #217690; color: white;">Challenge
															Source Fund *</span> <input style="width: 270px;"
															id="challengeSourceFund" name="challengSourceFund"
															type="text" class="form-control"
															placeholder="Challenge Source Fund"
															ng-model="challenge.challengSourceFund" required
															ng-maxlength="30" ng-minlength="5" />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengSourceFund.$dirty && addChallengeForm.challengSourceFund.$error.required">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														source fund is required
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengSourceFund.$dirty && addChallengeForm.challengSourceFund.$error.maxlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														source fund cannot be more than 30 characters
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengSourceFund.$dirty && addChallengeForm.challengSourceFund.$error.minlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														source fund should be more than 5 characters
													</div>
												</div>

											</div>


											<!-- USER INFO END -->
										</div>
									</div>
									<div class="col-xs-12 col-md-6">
										<!-- USER INFO START -->
										<div class="panel panel-default">
											<div class="panel-heading"
												style="background-color: #217690; color: white;">Additional
												Information</div>
											<div class="panel-body challenge-basic-info">

												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="width: 217px; background-color: #217690; color: white;">Challenge
															Impact *</span> <input style="width: 222px;"
															id="challengeImpact" name="challengImpact" type="text"
															class="form-control" placeholder="Challenge Impact"
															ng-model="challenge.challengImpact" required
															ng-maxlength="30" ng-minlength="5" />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengImpact.$dirty && addChallengeForm.challengImpact.$error.required">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Impact is required
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengImpact.$dirty && addChallengeForm.challengImpact.$error.maxlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Impact cannot be more than 30 characters
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengImpact.$dirty && addChallengeForm.challengImpact.$error.minlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Impact should be more than 5 characters
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="width: 217px; background-color: #217690; color: white;">Challenge
															Incentive *</span>
														<!-- <input id="challengeIncentive"
														name="challengIsIncentiv" type="text" class="form-control" placeholder="Challenge Incentive"
														ng-model="challenge.challengIsIncentiv" required ng-maxlength="1" ng-minlength="1" /> -->

														<select style="width: 222px;" name="challengIsIncentiv"
															class="form-control" id="challengeIncentive"
															ng-model="challenge.challengIsIncentiv" required>
															<option>Y</option>
															<option>N</option>
														</select>


													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengIsIncentiv.$dirty && addChallengeForm.challengeIncentive.$error.required">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Incentive is required
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengIsIncentiv.$dirty && addChallengeForm.challengeIncentive.$error.maxlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Incentive cannot be more than 30 characters
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengIsIncentiv.$dirty && addChallengeForm.challengeIncentive.$error.minlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Incentive should be more than 5 characters
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="width: 217px; background-color: #217690; color: white;">Challenge
															Delivery Expectation *</span> <input style="width: 222px;"
															id="challengeDeliveryExpectation"
															name="challengDelivExpctatn" type="text"
															class="form-control"
															placeholder="Challenge Delivery Expectation"
															ng-model="challenge.challengDelivExpctatn" required
															ng-maxlength="30" ng-minlength="5" />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengDelivExpctatn.$dirty && addChallengeForm.challengDelivExpctatn.$error.required">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Delivery Expectation is required
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengDelivExpctatn.$dirty && addChallengeForm.challengDelivExpctatn.$error.maxlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Delivery Expectation cannot be more than 30 characters
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengDelivExpctatn.$dirty && addChallengeForm.challengDelivExpctatn.$error.minlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Delivery Expectation should be more than 5 characters
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
												<div class="col-xs-12">
													<div class="input-group input-group-sm">
														<span class="input-group-addon"
															style="width: 217px; background-color: #217690; color: white;">Challenge
															Benchmark *</span> <input style="width: 222px;"
															id="challengeBenchmark" name="challengBenchmark"
															type="text" class="form-control"
															placeholder="Challenge Benchmark"
															ng-model="challenge.challengBenchmark" required
															ng-maxlength="30" ng-minlength="5" />
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengBenchmark.$dirty && addChallengeForm.challengeBenchmark.$error.required">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Benchmark is required
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengBenchmark.$dirty && addChallengeForm.challengBenchmark.$error.maxlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Benchmark cannot be more than 30 characters
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengBenchmark.$dirty && addChallengeForm.challengBenchmark.$error.minlength">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Benchmark should be more than 5 characters
													</div>
												</div>
												<div class="col-xs-12">&nbsp;</div>
											</div>
										</div>
									</div>
									<div class="col-xs-12 col-md-12">
										<!-- USER INFO START -->
										<div class="panel panel-default">
											<div class="panel-heading"
												style="background-color: #217690; color: white;">Challenge
												Abstract *</div>
											<div class="panel-body challenge-state-info">
												<div class="col-xs-12">
													<div class="input-group input-group-sm">

														<textarea id="challengeAbstract"
															style="resize: none; width: 920px; height: 100px; border-radius: 12px;"
															placeholder="Challenge abstract..."
															class="textarea-text form-control"
															name="challengAbstract" rows="4" cols="32"
															ng-model="challenge.challengAbstract" required></textarea>
													</div>
													<div class="alert alert-sm alert-danger alert-dismissible"
														role="alert"
														ng-show="addChallengeForm.challengAbstract.$dirty && addChallengeForm.challengAbstract.$error.required">
														<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
														Abstract is required
													</div>
												</div>
											</div>
										</div>

									</div>

									<div class="col-xs-12 col-md-12 ">
										<div class="panel panel-default">
											<div class="panel-heading"
												style="background-color: #217690; color: white;">Challenge
												Description *</div>
											<div class="panel-body challenge-state-info">

												<div class="input-group input-group-sm">

													<textarea id="challengeDescription"
														style="margin-left: 17px; resize: none; width: 920px; height: 100px; border-radius: 12px;"
														placeholder="Challenge description..."
														class="textarea-text form-control"
														name="challengDescription" rows="4" cols="32"
														ng-model="challenge.challengDescription" required></textarea>
												</div>
												<div class="alert alert-sm alert-danger alert-dismissible"
													role="alert"
													ng-show="addChallengeForm.challengDescription.$dirty && addChallengeForm.challengDescription.$error.required">
													<i class="fa fa-exclamation-triangle"></i>&nbspChallenge
													description is required
												</div>


											</div>
										</div>

									</div>
									<div class="col-xs-12">&nbsp;</div>




									<!-- 
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
													<button class="projectPhoto btn btn-info btn-sm" ng-click="uploadChallengeDocument()">Upload Documents</button>
												</div>
											
											</div>
										
										
										
										
										</div>
										 -->











									<div class="col-xs-12">
										<a href="#" class="btn  btn-success continue-addChallenge"
											ng-disabled="addChallengeForm.$invalid">Continue</i></a>
									</div>
								</div>
							</div>
							<h3 class="addChallenge-accordion-2 acc-hover"
								ng-class="addChallengeForm.$invalid?'ui-state-disabled':'ui-state-default'"
								style="background-color: #217690; color: black; font-weight: bold;">Captcha</h3>
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
												<input class="form-control" id="addChallengejCaptchaId"
													placeholder="Enter the text here" type="text"
													name="jcaptcha" value="" ng-model="jCaptcha"
													style="width: 100%; margin-top: 8px" />
											</div>


										</div>
										<div class="col-xs-12 col-md-4">
											<!-- <a class="btn btn-primary reg-ctn-3" id="register"
											style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
											ng-click="registerSubmit()">Register</a> -->

											<button class="btn btn-primary add-challenge-button"
												id="add-challenge-button" data-toggle="modal"
												data-target="#addChallengeAlertModal"
												style="margin-left: 91%; margin-top: 14%; background-color: #5cb85c;"
												ng-disabled="(!jCaptcha)">
												<i class="fa fa-cart-plus" aria-hidden="true"></i>&nbsp;Add
												Challenge
											</button>
										</div>
									</div>


									<%-- <div class="col-xs-12 col-md-8">
										<div class="input-group input-group-sm" id="captchavalue">
											<div class="g-recaptcha"
												data-sitekey="6LcgrRQTAAAAALPL-I3d-X4mXCcCy-F22emjwxS3"></div>
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
										<a href="manageChallenge" id="add-challenge-button"
											id="challenge"><input type="button"
											class="btn  btn-success add-challenge-button"
											value="Add Challenge"></a>
									</div> --%>
								</div>
							</div>
						</div>
					</form>
				</div>

				<!--add challenge alert -->
				<div class="modal fade" id="addChallengeAlertModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header"
								style="background-color: #31b0d5; color: white; text-align: center">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Add New Challenge</h4>
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
										sit back and relax while we are saving your challenge
										information...</div>
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
									<a href="manageChallenge" onclick="clickExitChallenge()"
										data-dismiss="modal" class="btn btn-info">Exit</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div ng-show="message.length>0"
						class="panel panel-success challenge-response-panel">
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
	<script type="text/javascript">
		$(".loaderBody").load(function() {
			$(".loaderBody").fadeOut("slow");
		})
	</script>
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
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/customStyle.css">

<script src="js/webrtc.js"></script>
<script src="js/jquery.autocomplete.js"></script>
<script src="js/logo.js"></script>
<!-- js 
================================================== -->
<!-- Javascript files placed here for faster loading -->
<!-- <script src="js/foundation.min.js"></script> -->
<script src="js/jquery-ui.js"></script>
<script src="js/angular.min.js"></script>
<script src="js/Controller.js"></script>
<script src="js/swfobject.js"></script>
<script src="js/jquery.FileReader.min.js"></script>
<!-- <script src="js/elasticslideshow.js"></script> -->
<!-- <script src="js/jquery.cycle.js"></script> -->
<!-- <script src="js/slidepanel.js"></script> -->
<!-- <script src="js/responsivemenu.js"></script> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<!-- <link rel="stylesheet" href="css/components.css"> -->
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/customStyle.css">
<script src="js/jquery.isotope.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/custom.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/select2.min.js"></script>
<script src="js/script.min.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</html>

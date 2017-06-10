<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="techpedia">
<title>Techpedia</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- <link rel="stylesheet" href="css/jquery-ui.css"> -->
<link
	href="https://code.jquery.com/ui/1.12.0-rc.2/themes/smoothness/jquery-ui.css">
<!-- <link rel="stylesheet" href="css/select2-bootstrap.css"> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-css/1.4.6/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.css"> -->

<style type="text/css">
#Reviewheader {
	color: white;
	text-align: center;
	padding: 5px;
	background-color: #23282e;
	line-height: 40px;
	display: block;
	text-align: center;
	font-size: 20px;
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

.NormalFont {
	style: font-weight: normal !important;
}

/*--------------- Page style ---------------*/
</style>
</head>
<div class="" style="padding-left: 0px; padding-right: 0px;">
	<jsp:include page="template/reviewHeader.jsp"></jsp:include>
</div>
<div id="sideNavPanel" class="col-xs-2"
	style="padding-left: 0px; padding-right: 0px; margin-left: 0px;">
	<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
</div>
<body>
	<div id="mainPanelBody" class="col-xs-10 col-md-10 content-wrapper"
		ng-controller="EditReviewRatingController" ng-init="InitLoad()"
		style="margin-left: 0px; margin-right: 0px; padding-left: 0px; padding-right: 0px;">
		<div id="Reviewheader">
			<span>Review Innovation/Idea</span>
		</div>


		<div>
			<form ng-submit="ConfirmReviewSubmit(ReviewRatingVO)"
				class="form-horizontal" id="reviewRatingForm"
				name="reviewRatingForm" method="post" novalidate>

				<div class="carddemoBasicUsage">
					<md-content class="md-padding" layout="row" flex>
					<div flex-xs="" layout="column" flex>
						<md-card> <md-card-title> <md-card-title-text>
						<span class="md-headline">{{GYTIProject.projTitle}}</span> <span
							class="md-subhead"><strong> <md-tooltip
									md-direction="left">Supervisor</md-tooltip> <i
								style="font-size: 21px;" class="fa fa-user" aria-hidden="true"></i>&nbsp;&nbsp;:
						</strong> {{GYTIProject.projFacultyName}}</span> <span class="md-subhead"><strong><md-tooltip
									md-direction="left">Branch</md-tooltip><i
								class="fa fa-graduation-cap" aria-hidden="true"></i>&nbsp;&nbsp;:</strong>
							<span ng-repeat="branch in projBranchList">{{branch.branchName}},&nbsp;</span></span>
						<span class="md-subhead"><strong><md-tooltip
									md-direction="left">University</md-tooltip><i
								class="fa fa-university" aria-hidden="true"></i>&nbsp;&nbsp;:</strong>
							{{GYTIProject.projUniversity}}</span> <span class="md-subhead"><strong><md-tooltip
									md-direction="left">College</md-tooltip><i
								class="fa fa-university" aria-hidden="true"></i>&nbsp;&nbsp;:</strong>
							{{GYTIProject.projCollege}}</span> </md-card-title-text> <md-card-title-media>
						<div class="md-media-md card-media">
							<img src="images/Projects.jpg" class="md-card-image"
								alt="GYTIProject">
						</div>
						</md-card-title-media> </md-card-title> <!-- <md-card-actions layout="row" layout-align="end center">
						<md-button ng-click="clickReview(optionalProjects.projId)">Review</md-button>
						<md-button>Action 2</md-button> </md-card-actions> --> </md-card>
					</div>
					</md-content>
				</div>



				<div class="col-xs-12 col-md-12">
					<!-- USER INFO START -->
					<div class="panel panel-default"
						style="border-style: none; background-color: #f5f5f5">
						<div class="panel-body user-info"
							style="border-style: none; background-color: #f5f5f5;">
							<div class="form-group">
								<label class="col-sm-3 control-label" style="font-weight: bold;">Recommendation
									*:</label>
								<div class="col-sm-9" style="margin-top: 4px">
									<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="option1"> <input type="radio" required="required"
										id="option1" ng-model="ReviewRatingVO.revRecommendation"
										name="revRecommendation" class="mdl-radio__button active"
										value="Worthy to Award" checked="checked"><span
										style="font-weight: normal !important;">Worthy to Award</span>
									</label> <span>&nbsp;&nbsp;</span><label
										class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="option2"> <input type="radio" required="required"
										id="option2" ng-model="ReviewRatingVO.revRecommendation"
										name="revRecommendation" class="mdl-radio__button"
										value="Can be considered for appreciation"><span
										style="font-weight: normal !important;">Can be
											considered for appreciation</span>
									</label> <span>&nbsp;&nbsp;</span><label
										class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="option3"> <input type="radio" required="required"
										id="option3" ng-model="ReviewRatingVO.revRecommendation"
										name="revRecommendation" class="mdl-radio__button"
										value="None of the above Two"><span
										style="font-weight: normal !important;">None of the
											above Two</span>
									</label><span>&nbsp;&nbsp;</span><label
										class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="option4"> <input type="radio" required="required"
										id="option4" ng-model="ReviewRatingVO.revRecommendation"
										name="revRecommendation" class="mdl-radio__button"
										value="More Information Required"><span
										style="font-weight: normal !important;">More Information Required</span>
									</label><span>&nbsp;&nbsp;</span><label
										class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="option5"> <input type="radio" required="required"
										id="option5" ng-model="ReviewRatingVO.revRecommendation"
										name="revRecommendation" class="mdl-radio__button"
										value="Suggest to other Reviewer"><span
										style="font-weight: normal !important;">Suggest to other Reviewer</span>
									</label>

								</div>
								<div class="alert alert-sm alert-danger alert-dismissible"
									role="alert"
									ng-show="reviewRatingForm.revRecommendation.$dirty && reviewRatingForm.revRecommendation.$error.required">Recommendation
									is Required</div>
							</div>
							</div>
							</div>
							</div>


							<!-- <md-radio-group ng-model="data.group1"> <md-radio-button
								value="Apple" id="apple1">Apple</md-radio-button> <md-radio-button
								value="Banana"> Banana </md-radio-button> <md-radio-button
								value="Mango">Mango</md-radio-button> </md-radio-group> -->


				<div class="col-xs-12 col-md-12" id="mainDiv">
					<div class="col-xs-12 col-md-12" id="ratingDiv">
						<!-- USER INFO START -->
						<div class="panel panel-default"
							style="border-style: none; background-color: #f5f5f5">

							<div class="panel-body user-info"
								style="border-style: none; background-color: #f5f5f5;">


								<div class="panel-heading"
									style="color: white; background-color: #2E353D; height: 40px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">Rating</div>
								<div class="form-group" style="font-weight: normal !important;">
									<label class="col-sm-3 control-label"
										style="font-weight: bold;">Novelty *:</label>
									<div class="col-sm-9"
										style="margin-top: 4px; font-weight: normal !important;">
										<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty1"> <input type="radio"
											required="required" id="novelty1"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button" value="1"
											checked="checked"><span
											style="font-weight: normal !important;">1</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty2"> <input type="radio"
											required="required" id="novelty2"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button" value="2"><span
											style="font-weight: normal !important;">2</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty3"> <input type="radio"
											required="required" id="novelty3"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button" value="3"><span
											style="font-weight: normal !important;">3</span>
										</label><span>&nbsp;&nbsp;</span> <label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty4"> <input type="radio"
											required="required" id="novelty4"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button active" value="4"
											style="font-weight: normal !important;"><span
											style="font-weight: normal !important;">4</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty5"> <input type="radio"
											required="required" id="novelty5"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button" value="5"><span
											style="font-weight: normal !important;">5</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty6"> <input type="radio"
											required="required" id="novelty6"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button" value="6"><span
											style="font-weight: normal !important;">6</span>
										</label><span>&nbsp;&nbsp;</span> <label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty7"> <input type="radio"
											required="required" id="novelty7"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button active" value="7"><span
											style="font-weight: normal !important;">7</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty8"> <input type="radio"
											required="required" id="novelty8"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button" value="8"><span
											style="font-weight: normal !important;">8</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty9"> <input type="radio"
											required="required" id="novelty9"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button" value="9"><span
											style="font-weight: normal !important;">9</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="novelty10"> <input type="radio"
											required="required" id="novelty10"
											ng-model="ReviewRatingVO.revNovelty" name="novelty"
											class="clacPercentage mdl-radio__button" value="10"><span
											style="font-weight: normal !important;">10</span>
										</label>

									</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="reviewRatingForm.novelty.$dirty && reviewRatingForm.novelty.$error.required">Novelty
										is Required</div>
								</div>

								<div class="form-group" style="font-weight: normal !important;">
									<label class="col-sm-3 control-label"
										style="font-weight: bold;">Technical Rigor *:</label>
									<div class="col-sm-9"
										style="margin-top: 4px; font-weight: normal !important;">
										<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor1"> <input type="radio"
											id="revTechnicalRigor1"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button active" value="1"
											checked="checked"><span
											style="font-weight: normal !important;">1</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor2"> <input type="radio"
											id="revTechnicalRigor2"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button" value="2"><span
											style="font-weight: normal !important;">2</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor3"> <input type="radio"
											id="revTechnicalRigor3"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button" value="3"><span
											style="font-weight: normal !important;">3</span>
										</label><span>&nbsp;&nbsp;</span> <label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor4"> <input type="radio"
											id="revTechnicalRigor4"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button active" value="4"
											style="font-weight: normal !important;"><span
											style="font-weight: normal !important;">4</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor5"> <input type="radio"
											id="revTechnicalRigor5"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button" value="5"><span
											style="font-weight: normal !important;">5</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor6"> <input type="radio"
											id="revTechnicalRigor6"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button" value="6"><span
											style="font-weight: normal !important;">6</span>
										</label><span>&nbsp;&nbsp;</span> <label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor7"> <input type="radio"
											id="revTechnicalRigor7"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button active" value="7"><span
											style="font-weight: normal !important;">7</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor8"> <input type="radio"
											id="revTechnicalRigor8"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button" value="8"><span
											style="font-weight: normal !important;">8</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor9"> <input type="radio"
											id="revTechnicalRigor9"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button" value="9"><span
											style="font-weight: normal !important;">9</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revTechnicalRigor10"> <input type="radio"
											id="revTechnicalRigor10"
											ng-model="ReviewRatingVO.revTechnicalRigor"
											required="required" name="revTechnicalRigor"
											class="clacPercentage mdl-radio__button" value="10"><span
											style="font-weight: normal !important;">10</span>
										</label>


									</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="reviewRatingForm.revTechnicalRigor.$dirty && reviewRatingForm.revTechnicalRigor.$error.required">Technical
										Rigor is Required</div>
								</div>

								<div class="form-group" style="font-weight: normal !important;">
									<label class="col-sm-3 control-label"
										style="font-weight: bold;">Social Application *:</label>
									<div class="col-sm-9"
										style="margin-top: 4px; font-weight: normal !important;">
										<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication1"> <input type="radio"
											id="revSocialApplication1"
											ng-model="ReviewRatingVO.revSocialApplication"
											required="required" name="revSocialApplication"
											class="clacPercentage mdl-radio__button active" value="1"
											checked="checked"><span
											style="font-weight: normal !important;">1</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication2"> <input type="radio"
											id="revSocialApplication2"
											ng-model="ReviewRatingVO.revSocialApplication"
											required="required" name="revSocialApplication"
											class="clacPercentage mdl-radio__button" value="2"><span
											style="font-weight: normal !important;">2</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication3"> <input type="radio"
											id="revSocialApplication3"
											ng-model="ReviewRatingVO.revSocialApplication"
											required="required" name="revSocialApplication"
											class="clacPercentage mdl-radio__button" value="3"><span
											style="font-weight: normal !important;">3</span>
										</label><span>&nbsp;&nbsp;</span> <label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication4"> <input type="radio"
											id="revSocialApplication4"
											ng-model="ReviewRatingVO.revSocialApplication"
											required="required" name="revSocialApplication"
											class="clacPercentage mdl-radio__button active" value="4"
											style="font-weight: normal !important;"><span
											style="font-weight: normal !important;">4</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication5"> <input type="radio"
											id="revSocialApplication5"
											ng-model="ReviewRatingVO.revSocialApplication"
											required="required" name="revSocialApplication"
											class="clacPercentage mdl-radio__button" value="5"><span
											style="font-weight: normal !important;">5</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication6"> <input type="radio"
											id="revSocialApplication6"
											ng-model="ReviewRatingVO.revSocialApplication"
											required="required" name="revSocialApplication"
											class="clacPercentage mdl-radio__button" value="6"><span
											style="font-weight: normal !important;">6</span>
										</label><span>&nbsp;&nbsp;</span> <label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication7"> <input type="radio"
											id="revSocialApplication7"
											ng-model="ReviewRatingVO.revSocialApplication"
											required="required" name="revSocialApplication"
											class="clacPercentage mdl-radio__button active" value="7"><span
											style="font-weight: normal !important;">7</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication8"> <input type="radio"
											id="revSocialApplication8"
											ng-model="ReviewRatingVO.revSocialApplication"
											required="required" name="revSocialApplication"
											class="clacPercentage mdl-radio__button" value="8"><span
											style="font-weight: normal !important;">8</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication9"> <input type="radio"
											required="required" id="revSocialApplication9"
											ng-model="ReviewRatingVO.revSocialApplication"
											name="revSocialApplication"
											class="clacPercentage mdl-radio__button" value="9"><span
											style="font-weight: normal !important;">9</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revSocialApplication10"> <input type="radio"
											required="required" id="revSocialApplication10"
											ng-model="ReviewRatingVO.revSocialApplication"
											name="revSocialApplication"
											class="clacPercentage mdl-radio__button" value="10"><span
											style="font-weight: normal !important;">10</span>
										</label>

									</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="reviewRatingForm.revSocialApplication.$dirty && reviewRatingForm.revSocialApplication.$error.required">Social
										Application is Required</div>
								</div>


								<div class="form-group" style="font-weight: normal !important;">
									<label class="col-sm-3 control-label"
										style="font-weight: bold;">Frugality *:</label>
									<div class="col-sm-9"
										style="margin-top: 4px; font-weight: normal !important;">
										<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality1"> <input type="radio"
											required="required" id="revFrugality1"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button active" value="1"
											checked="checked"><span
											style="font-weight: normal !important;">1</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality2"> <input type="radio"
											required="required" id="revFrugality2"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button" value="2"><span
											style="font-weight: normal !important;">2</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality3"> <input type="radio"
											required="required" id="revFrugality3"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button" value="3"><span
											style="font-weight: normal !important;">3</span>
										</label><span>&nbsp;&nbsp;</span> <label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality4"> <input type="radio"
											required="required" id="revFrugality4"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button active" value="4"
											style="font-weight: normal !important;"><span
											style="font-weight: normal !important;">4</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality5"> <input type="radio"
											required="required" id="revFrugality5"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button" value="5"><span
											style="font-weight: normal !important;">5</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality6"> <input type="radio"
											required="required" id="revFrugality6"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button" value="6"><span
											style="font-weight: normal !important;">6</span>
										</label><span>&nbsp;&nbsp;</span> <label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality7"> <input type="radio"
											required="required" id="revFrugality7"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button active" value="7"><span
											style="font-weight: normal !important;">7</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality8"> <input type="radio"
											required="required" id="revFrugality8"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button" value="8"><span
											style="font-weight: normal !important;">8</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality9"> <input type="radio"
											required="required" id="revFrugality9"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button" value="9"><span
											style="font-weight: normal !important;">9</span>
										</label> <span>&nbsp;&nbsp;</span><label
											class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
											for="revFrugality10"> <input type="radio"
											required="required" id="revFrugality10"
											ng-model="ReviewRatingVO.revFrugality" name="revFrugality"
											class="clacPercentage mdl-radio__button" value="10"><span
											style="font-weight: normal !important;">10</span>
										</label>


									</div>
									<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="reviewRatingForm.revFrugality.$dirty && reviewRatingForm.revFrugality.$error.required">Frugality
										is Required</div>
								</div>
								<div class="form-group">
									<label for="revRatingPercentage" class="col-sm-3 control-label"
										style="font-weight: bold;">Rating percentage % *:</label>
									<div class="col-xs-2" readonly aria-label="Readonly field">
										<input type="text" name="revRatingPercentage"
											class="form-control" id="revRatingPercentage"
											ng-model="ReviewRatingVO.revRatingPercentage" readonly
											aria-label="Readonly field" />
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-xs-12 col-md-12">
						<!-- USER INFO START -->
						<div class="panel panel-default"
							style="border-style: none; background-color: #f5f5f5">
							<div class="panel-heading"
								style="color: white; background-color: #2E353D; height: 40px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">Comments
								/ Suggested Links</div>
							<div class="panel-body user-info"
								style="border-style: none; background-color: #f5f5f5;">
								<div class="form-group">
									<label for="revComments" class="col-sm-3 control-label"
										style="font-weight: bold;">Comments :</label>
									<div class="col-sm-9"
										style="margin-top: 4px; font-weight: normal !important;">
										<textarea
											ng-class="{'btn-warning': ReviewRatingVO.revComments.length >= 970, 'btn-danger': ReviewRatingVO.revComments.length >= 1001 }"
											name="revComments" class="form-control" rows="3"
											ng-maxlength="1000" id="revComments"
											ng-model="ReviewRatingVO.revComments"
											cols=""></textarea>
										<!-- <div class="alert alert-sm alert-danger alert-dismissible"
											role="alert"
											ng-show="reviewRatingForm.revComments.$dirty && reviewRatingForm.revComments.$error.required">Comments
											is Required</div> -->
										<div class="alert alert-sm alert-danger alert-dismissible"
											role="alert"
											ng-show="reviewRatingForm.revComments.$dirty && reviewRatingForm.revComments.$error.maxlength">
											Comments cannot be more than 1000 characters</div>
										Characters left:<span
											ng-class="{'btn-warning': ReviewRatingVO.revComments.length >= 920, 'btn-danger': ReviewRatingVO.revComments.length >= 1001 }">{{
											1000 - ReviewRatingVO.revComments.length}}/1000</span>
									</div>


								</div>
								<div class="form-group">
									<label for="revSuggestedLinks" class="col-sm-3 control-label"
										style="font-weight: bold;">Suggested Links:</label>
									<div class="col-sm-9">
										<textarea
											ng-class="{'btn-warning': ReviewRatingVO.revSuggestedLinks.length >= 970, 'btn-danger': ReviewRatingVO.revSuggestedLinks.length >= 1001 }"
											name="revSuggestedLinks" class="form-control" rows="3"
											ng-maxlength="1000" id="revSuggestedLinks"
											ng-model="ReviewRatingVO.revSuggestedLinks"
											placeholder="Please enter multiple links separated by coma(,)"></textarea>
										Characters left:<span
											ng-class="{'btn-warning': ReviewRatingVO.revSuggestedLinks.length >= 920, 'btn-danger': ReviewRatingVO.revSuggestedLinks.length >= 1001 }">{{
											1000 - ReviewRatingVO.revSuggestedLinks.length}}/1000</span>
										<div class="alert alert-sm alert-danger alert-dismissible"
											role="alert"
											ng-show="reviewRatingForm.revSuggestedLinks.$error.maxlength">
											Links cannot be more than 1000 characters</div>
									</div>
								</div>

							</div>
						</div>
					</div>

					<div class="col-xs-12 col-md-12">
						<!-- USER INFO START -->
						<div class="panel panel-default"
							style="border-style: none; background-color: #f5f5f5">
							<div class="panel-heading"
								style="color: white; background-color: #2E353D; height: 40px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">Can
								Innovation/idea be taken forward?</div>
							<div class="panel-body user-info"
								style="border-style: none; background-color: #f5f5f5;">
								<div class="form-group">
									<label for="revComments" class="col-sm-3 control-label"
										style="font-weight: bold;">Your Opinion:</label>
									<div class="col-sm-9"
										style="margin-top: 4px; font-weight: normal !important;">
										<md-radio-group
											ng-model="ReviewRatingVO.canIdeaBeTakenForward" layout="row"
											style="margin-left: 10px"> <md-radio-button
											value="Y" class="md-primary"
											style="font-weight: normal !important;" required="required">
										Yes </md-radio-button> <md-radio-button value="N" class="md-primary"
											style="font-weight: normal !important;" required="required">
										No </md-radio-button> </md-radio-group>
									</div>
								</div>
								<div class="form-group">
									<label for="canIdeaBeTakenForwardRemarks"
										class="col-sm-3 control-label" style="font-weight: bold;">Comments:</label>
									<div class="col-sm-9">
										<textarea
											ng-class="{'btn-warning': ReviewRatingVO.canIdeaBeTakenForwardRemarks.length >= 920, 'btn-danger': ReviewRatingVO.canIdeaBeTakenForwardRemarks.length >= 1001 }"
											name="canIdeaBeTakenForwardRemarks" class="form-control"
											rows="3" id="canIdeaBeTakenForwardRemarks"
											ng-maxlength="1000"
											ng-model="ReviewRatingVO.canIdeaBeTakenForwardRemarks"></textarea>
										<div class="alert alert-sm alert-danger alert-dismissible"
											role="alert"
											ng-show="reviewRatingForm.canIdeaBeTakenForwardRemarks.$error.maxlength">
											Comments cannot be more than 1000 characters</div>
										Characters left:<span
											ng-class="{'btn-warning': ReviewRatingVO.canIdeaBeTakenForwardRemarks.length >= 920, 'btn-danger': ReviewRatingVO.canIdeaBeTakenForwardRemarks.length >= 1001 }">{{
											1000 -
											ReviewRatingVO.canIdeaBeTakenForwardRemarks.length}}/1000</span>


									</div>
								</div>

							</div>
						</div>
					</div>




					<div class="col-xs-12 col-md-12">
						<!-- USER INFO START -->
						<div class="panel panel-default"
							style="border-style: none; background-color: #f5f5f5">
							<div class="panel-heading"
								style="color: white; background-color: #2E353D; height: 40px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">Do
								you want more information from Author/Innovator ?</div>
							<div class="panel-body user-info"
								style="border-style: none; background-color: #f5f5f5;">
								<div class="form-group">
									<label for="revComments" class="col-sm-3 control-label"
										style="font-weight: bold;">Your Opinion:</label>
									<div class="col-sm-9"
										style="margin-top: 4px; font-weight: normal !important;">
										<!-- <md-radio-group ng-model="ReviewRatingVO.moreInfoNeeded"
											layout="row" style="margin-left: 10px"> <md-radio-button
											value="Y" class="md-primary"
											style="font-weight: normal !important;" required="required" id="moreInfoNeeded9" ng-click="onChangeMoreInfo()">
										Yes </md-radio-button> <md-radio-button value="N" class="md-primary"
											style="font-weight: normal !important;" required="required" id="moreInfoNeeded10" ng-click="onChangeMoreInfo()">
										No </md-radio-button> </md-radio-group> -->
										
										<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="moreInfoNeeded9"> <input type="radio"
										id="moreInfoNeeded9" ng-model="ReviewRatingVO.moreInfoNeeded"
										name="moreInfoNeeded" class="mdl-radio__button" value="Y"><span
										style="font-weight: normal !important;">yes</span>
										</label> <span>&nbsp;&nbsp;</span><label
										class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="moreInfoNeeded10"> <input type="radio"
										id="moreInfoNeeded10" ng-model="ReviewRatingVO.moreInfoNeeded"
										name="moreInfoNeeded" class="mdl-radio__button" value="N"><span
										style="font-weight: normal !important;">No</span>
										</label>
									</div>
								</div>
								<div class="form-group" id="moreCommentDiv">
									<label for="moreInfoNeededRemarks"
										class="col-sm-3 control-label" style="font-weight: bold;">Comments:</label>
									<div class="col-sm-9">
										<textarea
											ng-class="{'btn-warning': ReviewRatingVO.moreInfoNeededRemarks.length >= 920, 'btn-danger': ReviewRatingVO.moreInfoNeededRemarks.length >= 1001 }"
											name="moreInfoNeededRemarks" class="form-control" rows="3"
											ng-maxlength="1000" id="moreInfoNeededRemarks"
											ng-model="ReviewRatingVO.moreInfoNeededRemarks"></textarea>
										<div class="alert alert-sm alert-danger alert-dismissible"
											role="alert"
											ng-show="reviewRatingForm.moreInfoNeededRemarks.$error.maxlength">
											Comments cannot be more than 1000 characters</div>
										Characters left:<span
											ng-class="{'btn-warning': ReviewRatingVO.moreInfoNeededRemarks.length >= 920, 'btn-danger': ReviewRatingVO.moreInfoNeededRemarks.length >= 1001 }">{{
											1000 - ReviewRatingVO.moreInfoNeededRemarks.length}}/1000</span>
									</div>
								</div>
								<div class="form-group" style="margin-top: 8px;text-align:center;" id="moreCommentButtonDiv">
									<button type="reset" value="Reset" id=""
										class="btn btn-primary reg-ctn-1"
										style="background-color: #5cb85c;margin-top:30px;margin-right:410px;" ng-click="moreInformationComments(ReviewRatingVO.moreInfoNeededRemarks)" data-toggle="modal" data-target="#moreInfoRequiredModal">
										<i class="fa fa-star-o" aria-hidden="true"></i> &nbsp;Submit
									</button>
						</div>

							</div>
						</div>
					</div>
					<div class="col-xs-12 col-md-12">
						<!-- USER INFO START -->
						<div class="panel panel-default"
							style="border-style: none; background-color: #f5f5f5">
							<div class="panel-heading"
								style="color: white; background-color: #2E353D; height: 40px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">Suggest
								this project to other reviewers</div>
							<div class="panel-body user-info"
								style="border-style: none; background-color: #f5f5f5;">
								<div class="form-group">
									<label for="revComments" class="col-sm-3 control-label"
										style="font-weight: bold;">Suggest to other reviewers:</label>
									<div class="col-sm-9"
										style="margin-top: 4px; font-weight: normal !important;">
										<!-- <md-radio-group ng-model="ReviewRatingVO.suggestToOtherRev"
											layout="row" style="margin-left: 10px"> <md-radio-button
											value="Y" class="md-primary"
											style="font-weight: normal !important;" required="required" id="suggestToOtherRev9" ng-click="onChangeSuggest()">
										Yes </md-radio-button> <md-radio-button value="N" class="md-primary"
											style="font-weight: normal !important;" required="required" id="suggestToOtherRev10" ng-click="onChangeSuggest()">
										No </md-radio-button> </md-radio-group> -->
										
										<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="suggestToOtherRev9"> <input type="radio"
										id="suggestToOtherRev9"
										ng-model="ReviewRatingVO.suggestToOtherRev"
										name="suggestToOtherRev" class="mdl-radio__button" value="Y"><span
										style="font-weight: normal !important;">yes</span>
										</label> <span>&nbsp;&nbsp;</span><label
										class="mdl-radio mdl-js-radio mdl-js-ripple-effect"
										for="suggestToOtherRev10"> <input type="radio"
										id="suggestToOtherRev10"
										ng-model="ReviewRatingVO.suggestToOtherRev"
										name="suggestToOtherRev" class="mdl-radio__button" value="N"><span
										style="font-weight: normal !important;">No</span>
										</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>


		<div class="col-xs-12 col-md-12" id="notifySuggestReviewerDiv">
			<div class="panel panel-default"
				style="border-style: none; background-color: #f5f5f5">
					<div class="panel-heading"
							style="color: white; background-color: #2E353D; height: 40px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">Suggest Reviewer</div>
				<div class="panel-body user-info"
					style="border-style: none; background-color: #f5f5f5;">
					<form class="form" name="suggestReviewerForm" action="">
						<div class="form-group" style="margin-top: 8px">
							<label class="col-sm-3 control-label" style="font-weight: bold;">Reviewer
								Name :</label>
							<div class="col-sm-9" >

								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user color-blue"></i></span> <input
										id="suggestedReviewerName" name="suggestedReviewerName" placeholder="Reviewer Name"
										ng-model="suggestedReviewerName" class="form-control" type="text"
										ng-pattern="/^(\D)+$/" ng-required="true" required
										ng-maxlength="50" />
								</div>
								<span style="color: red"
									ng-show="suggestReviewerForm.suggestedReviewerName.$dirty"> <span
									ng-show="suggestReviewerForm.suggestedReviewerName.$error.required">
										Name is required.</span> <span
									ng-show="suggestReviewerForm.suggestedReviewerName.$error.maxlength">
										Name cannot be more than 50 characters.</span> <span
									ng-show="suggestReviewerForm.suggestedReviewerName.$error.pattern">Name
										can only contain text.</span>
								</span>

							</div>
						</div>
						<div class="form-group" style="margin-top: 8px">
							<label class="col-sm-3 control-label" style="font-weight: bold;">Email
								Id :</label>
							<div class="col-sm-9" style="margin-top: 4px">

								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-envelope color-blue"></i></span> <input
										id="suggestedReviewerEmail" name="suggestedReviewerEmail" placeholder="email address"
										ng-model="suggestedReviewerEmail" class="form-control" type="email"
										ng-pattern="/^.+@.+\..+$/" ng-required="true" required />
								</div>
								<span style="color: red"
									ng-show="suggestReviewerForm.suggestedReviewerEmail.$dirty"> <span
									ng-show="suggestReviewerForm.suggestedReviewerEmail.$error.required">
										Email is required.</span> <span
									ng-show="suggestReviewerForm.suggestedReviewerEmail.$error.pattern">Email
										is not valid.</span>
								</span>

							</div>
						</div>
						<div class="form-group" style="margin-top: 8px;text-align:center;">
							<button type="reset" value="Reset"
								class="btn btn-primary reg-ctn-1"
								style="background-color: #5cb85c;margin-top:30px;margin-right:410px;" ng-click="notifyReviewer(<%=session.getAttribute("revRgstrId")%>,suggestedReviewerName,suggestedReviewerEmail)" data-toggle="modal" data-target="#notifyReviewerModal">
								<i class="fa fa-star-o" aria-hidden="true"></i> &nbsp;Submit
							</button>
						</div>
					</form>



				</div>
			</div>
		</div>
		
			<div class="col-xs-12 col-md-12" id="moreInfoRequiredDiv">
			<div class="panel panel-default"
				style="border-style: none; background-color: #f5f5f5">
					<div class="panel-heading"
							style="color: white; background-color: #2E353D; height: 40px; border-style: none; font-family: arial; font-weight: bold; font-size: 24;">More Information from Author/Innovator</div>
				<div class="panel-body user-info"
					style="border-style: none; background-color: #f5f5f5;">
					<form class="form" name="moreInfoRequiredForm" action="">
						
						<div class="form-group">
								<label for="moreInfoNeededRemarks"
									class="col-sm-3 control-label" style="font-weight: bold;">Comments:</label>
								<div class="col-sm-9">
									<textarea
										ng-class="{'btn-warning': comments.length >= 920, 'btn-danger': comments.length >= 1001 }"
										name="comments" class="form-control" rows="3"
										id="comments"  ng-maxlength="1000"
										ng-model="comments"></textarea>
										<div class="alert alert-sm alert-danger alert-dismissible"
										role="alert"
										ng-show="moreInfoRequiredForm.comments.$error.maxlength">
										Comments cannot be more than 1000 characters</div>
									Characters left:<span
										ng-class="{'btn-warning': comments.length >= 920, 'btn-danger': comments.length >= 1001 }">{{
										1000 - comments.length}}/1000</span>
								</div>
							</div>
						<div class="form-group" style="margin-top: 8px;text-align:center;">
							<button type="reset" value="Reset"
								class="btn btn-primary reg-ctn-1"
								style="background-color: #5cb85c;margin-top:30px;margin-right:410px;" ng-click="moreInformationComments(comments)" data-toggle="modal" data-target="#moreInfoRequiredModal">
								<i class="fa fa-star-o" aria-hidden="true"></i> &nbsp;Submit
							</button>
						</div>
					</form>



				</div>
			</div>
		</div>

		<div class="col-xs-12 col-md-12 col-xs-offset-5 col-md-offset-5" id="buttonsDiv">
					<!-- <button type="reset" value="Reset"
						class="btn btn-primary reg-ctn-1"
						style="background-color: #5cb85c;" ng-click="saveReviewRating()"  data-toggle="modal"
						data-target="#reviewRatingSaveResponseModal">
						<i class="fa fa-refresh" aria-hidden="true"></i> &nbsp;Save
					</button>-->
					<button ng-show="ReviewRatingVO.status=='reviewed'"
						ng-disabled="reviewRatingForm.$invalid || ReviewRatingVO.moreInfoNeededRemarks.length >= 1001 
							|| ReviewRatingVO.canIdeaBeTakenForwardRemarks.length >= 1001 || ReviewRatingVO.revSuggestedLinks.length >= 1001"
						type="button" class="btn btn-primary reg-ctn-1"
						style="background-color: #5cb85c;"
						ng-click="ConfirmReviewSubmit(ReviewRatingVO)" data-toggle="modal"
						data-target="#updateReviewRatingConfirmModal">
						<i class="fa fa-star-o" aria-hidden="true"></i> &nbsp;Save
						Rating and Review
					</button> 
					
					<button type="reset" value="Reset" ng-show="ReviewRatingVO.status=='inProgress'"
						class="btn btn-primary reg-ctn-1"
						style="background-color: #5cb85c;" ng-click="saveReviewRating()"  data-toggle="modal"
						data-target="#reviewRatingSaveResponseModal">
						<i class="fa fa-refresh" aria-hidden="true"></i> &nbsp;Save
					</button>
					<button ng-show="ReviewRatingVO.status=='inProgress'"
						ng-disabled="reviewRatingForm.$invalid || ReviewRatingVO.moreInfoNeededRemarks.length >= 1001 
							|| ReviewRatingVO.canIdeaBeTakenForwardRemarks.length >= 1001 || ReviewRatingVO.revSuggestedLinks.length >= 1001"
						type="button" class="btn btn-primary reg-ctn-1"
						style="background-color: #5cb85c;"
						ng-click="ConfirmReviewSubmit(ReviewRatingVO)" data-toggle="modal"
						data-target="#reviewRatingConfirmModal">
						<i class="fa fa-star-o" aria-hidden="true"></i> &nbsp;Submit
						Rating and Review
					</button>
					
					<!-- <button type="reset" value="Reset"
						class="btn btn-primary reg-ctn-1"
						style="background-color: #5cb85c;" ng-click="reset()">
						<i class="fa fa-refresh" aria-hidden="true"></i> &nbsp;Reset
					</button> -->
				</div>


		<!-- 
		<div class="col-xs-12">
			<div class="input-group input-group-sm ">
				<span class="input-group-addon"
					style="border-right: 1px solid #ccc; background-color: #217690; width: 130px; font-family: arial; color: #ffffff;">
					First name *</span> <input name="revFname" type="text" id="revFname"
					style="width: 300px !important;"
					class="form-control rname my-tooltip" placeholder="First name"
					ng-model="ReviewRatingVO.revFname" required="required"
					ng-maxlength="50" ng-pattern="/^(\D)+$/" data-toggle='tooltip'
					data-placement='right'
					title='Please enter first name without special characters' />

			</div>
			
								<div class="input-group input-group-sm"
									ng-class="{ 'has-error' : ReviewRatingVOForm.revFname.$invalid && !ReviewRatingVOForm.revFname.$pristine }">

									<span class="input-group-addon">First name *</span> <input
										type="text" name="revFname" class="form-control"
										ng-model="user.name" required data-toggle="tooltip"
										data-original-title="Default tooltip">

								</div>
			<p
				ng-show="ReviewRatingVOForm.revFname.$invalid && !ReviewRatingVOForm.revFname.$pristine"
				data-toggle="tooltip" data-original-title="Default tooltip"></p>
			<div class="alert alert-sm alert-danger alert-dismissible"
				role="alert"
				ng-show="ReviewRatingVOForm.revFname.$dirty && ReviewRatingVOForm.revFname.$error.required">First
				name is required</div>
			<div class="alert alert-sm alert-danger alert-dismissible"
				role="alert"
				ng-show="ReviewRatingVOForm.revFname.$dirty && ReviewRatingVOForm.revFname.$error.maxlength">First
				name cannot be more than 30 characters</div>

			<div class="alert alert-sm alert-danger alert-dismissible"
				role="alert"
				ng-show="ReviewRatingVOForm.revFname.$dirty && ReviewRatingVOForm.revFname.$error.pattern">First
				Name can only contain text</div>
		</div> -->
		<div class="col-xs-12">&nbsp;</div>

<!-- Reviewer Notify Modal -->
		
		<div class="modal fade" data-easein="perspectiveDownIn"
			id="notifyReviewerModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Notify Suggested Reviewer</h4>

					</div>
					<div class="modal-body" id="loderDiv"
						ng-hide="messageWarning.length>0 || messageSuccess.length>0 || message.length>0">

						<div class="loaderBody"
							ng-hide="messageWarning.length>0 || messageSuccess.length>0 || message.length>0">Please
							sit back and relax while we are sending mail to suggested reviewer...</div>

					</div>




					<div class="modal-body" ng-show="messageSuccess.length>0" id="messageSuccessDiv"
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
							<p>An email has been sent to {{NotifyReviewerVo.suggestedReviewerEmail}}</p>
						</div>


					</div>

					<div class="modal-body" ng-show="messageWarning.length>0" id="messageWarningDiv"
						style="text-align: center;">
						<div>
							<i id="effect" class="fa fa-check-circle-o"
								style="color: #8a6d3b; font-size: 7em;"></i>
						</div>

						<div
							class="col-xs-12 xol-md-12 alert alert-warning alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert" ng-repeat="msgWarning in messageWarning">

							<p>{{msgWarning}}</p>
						</div>
					</div>
					<div class="modal-body" style="text-align: center;" id="messageDiv"
						ng-show="message.length>0">
						<div style="text-align: center;">
							<i class="fa fa-exclamation-triangle"
								style="color: #E84F63; font-size: 50px; text-align: center;"></i>
						</div>
						<div
							class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							ng-repeat="msg in message">{{msg}}</div>


					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button data-dismiss="modal" type="button" class="btn btn-info"
						ng-click="ClickReviewRatingForSuggestReviewer()">Exit</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- More Info Required Modal -->
		
		<div class="modal fade" data-easein="perspectiveDownIn"
			id="moreInfoRequiredModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">More Information Required</h4>

					</div>
					<div class="modal-body" id="loderDiv"
						ng-hide="messageWarning.length>0 || messageSuccess.length>0 || message.length>0">

						<div class="loaderBody"
							ng-hide="messageWarning.length>0 || messageSuccess.length>0 || message.length>0">Please
							sit back and relax while we are sending mail to applicant for more information about this project...</div>

					</div>




					<div class="modal-body" ng-show="messageSuccess.length>0" id="messageSuccessDiv"
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

					<div class="modal-body" ng-show="messageWarning.length>0" id="messageWarningDiv"
						style="text-align: center;">
						<div>
							<i id="effect" class="fa fa-check-circle-o"
								style="color: #8a6d3b; font-size: 7em;"></i>
						</div>

						<div
							class="col-xs-12 xol-md-12 alert alert-warning alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert" ng-repeat="msgWarning in messageWarning">

							<p>{{msgWarning}}</p>
						</div>
					</div>
					<div class="modal-body" style="text-align: center;" id="messageDiv"
						ng-show="message.length>0">
						<div style="text-align: center;">
							<i class="fa fa-exclamation-triangle"
								style="color: #E84F63; font-size: 50px; text-align: center;"></i>
						</div>
						<div
							class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							ng-repeat="msg in message">{{msg}}</div>


					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button data-dismiss="modal" type="button" class="btn btn-info"
							ng-click="ClickReviewRatingForMoreInfo()">Exit</button>
					</div>
				</div>
			</div>
		</div>



	<!-- Save review rating success modal -->
		<div class="modal fade" data-easein="perspectiveDownIn"
			id="reviewRatingSaveResponseModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Save Review And
							Rating</h4>

					</div>
					<div style="text-align: center;" class="modal-body"
						id="saveSuccessMsgDiv" ng-show="saveSuccessMsg.length>0" >
						<div
							class="col-xs-12 xol-md-12 alert alert-success alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert" ng-repeat="saveSuccess in saveSuccessMsg">
						<p>{{saveSuccess}}</p>
						</div>
						
					</div>
					<div style="text-align: center;" class="modal-body"
						id="saveErrorMsgDiv" ng-show="saveErrorMsg.length>0">
						<div
							class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert" ng-repeat="saveError in saveErrorMsg">
						<p>{{saveError}}</p>
						</div>
					</div>
					<div style="text-align: center;" class="modal-body"
						id="MsgerrorDiv" ng-show="Msgerror.length>0">
						<div
							class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert"  ng-repeat="error in Msgerror">
						<p>{{error}}</p>
						</div>
					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button data-dismiss="modal" type="button" class="btn btn-info"
							ng-click="ExitGYTIReview()">Exit</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- Submit review rating confirm modal -->
		<div class="modal fade" data-easein="perspectiveDownIn" id="reviewRatingConfirmModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Submit Review And
							Rating</h4>

					</div>
					<div style="text-align: center;" class="modal-body"
						ng-hide="messageWarning.length>0 || messageSuccess.length>0 || message.length>0">
						<span>Are You Sure To Submit the Review and Rating For the
							Bellow Project</span>
						<p style="font-weight: bold;">
							<strong>{{projTitle}}</strong>
						</p>

					</div>

					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button ng-hide="addMsg.length>0" type="button"
							class="btn btn-primary reg-ctn-1"
							style="background-color: #5cb85c;"
							ng-click="submitReviewRating()" data-dismiss="modal"
							data-toggle="modal" data-target="#reviewRatingAlertModal"
							ng-disabled="">
							<i class="fa fa-star-o" aria-hidden="true"></i> &nbsp;Submit
						</button>


						<button data-dismiss="modal" type="button" class="btn btn-info"
							ng-click="ExitGYTIReview()">Exit</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Submit review rating alert modal -->
		<div class="modal fade" data-easein="perspectiveDownIn" id="reviewRatingAlertModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Submit Review And
							Rating</h4>

					</div>
					<div class="modal-body"
						ng-hide="addMsg.length>0 || addMsgerror.length>0">

						<div class="loaderBody"
							ng-hide="addMsg.length>0 || addMsgerror.length>0">Please
							sit back and relax while we are saving your review and rating for
							you...</div>

					</div>

					<div class="modal-body" ng-show="addMsg.length>0"
						style="text-align: center;">
						<div>
							<i id="effect" class="fa fa-check-circle-o"
								style="color: green; font-size: 7em;"></i>
						</div>

						<div
							class="col-xs-12 xol-md-12 alert alert-success alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert" ng-repeat="msgSuccess in addMsg">
							<p>{{msgSuccess}}</p>
						</div>
					</div>
					<div class="modal-body" style="text-align: center;"
						ng-show="addMsgerror.length>0">
						<div style="text-align: center;">
							<i class="fa fa-exclamation-triangle"
								style="color: #E84F63; font-size: 50px; text-align: center;"></i>
						</div>
						<div
							class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							ng-repeat="msg in addMsgerror">{{msg}}</div>


					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">

						<button data-dismiss="modal" type="button" class="btn btn-info"
							onclick="ExitGYTIReview()">Exit</button>
					</div>
				</div>
			</div>
		</div>


	<!-- Update review modal code -->
	<!-- 	<!-- Submit review rating confirm modal -->
		<div class="modal fade" data-easein="perspectiveDownIn" id="updateReviewRatingConfirmModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Update Review And
							Rating</h4>

					</div>
					<div style="text-align: center;" class="modal-body"
						ng-hide="messageWarning.length>0 || messageSuccess.length>0 || message.length>0">
						<span>Are You Sure To Submit the Review and Rating For the
							Bellow Project</span>
						<p style="font-weight: bold;">
							<strong>{{projTitle}}</strong>
						</p>

					</div>

					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">
						<button ng-hide="addMsg.length>0" type="button"
							class="btn btn-primary reg-ctn-1"
							style="background-color: #5cb85c;"
							ng-click="updateReviewRating()" data-dismiss="modal"
							data-toggle="modal" data-target="#reviewRatingAlertModal"
							ng-disabled="">
							<i class="fa fa-star-o" aria-hidden="true"></i> &nbsp;Update
						</button>


						<button data-dismiss="modal" type="button" class="btn btn-info"
							ng-click="ExitGYTIReview()">Exit</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" data-easein="perspectiveDownIn" id="reviewRatingAlertModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"
						style="background-color: #31b0d5; color: white; text-align: center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">update Review And
							Rating</h4>

					</div>
					<div class="modal-body"
						ng-hide="addMsg.length>0 || addMsgerror.length>0">

						<div class="loaderBody"
							ng-hide="addMsg.length>0 || addMsgerror.length>0">Please
							sit back and relax while we are saving your review and rating for
							you...</div>

					</div>

					<div class="modal-body" ng-show="addMsg.length>0"
						style="text-align: center;">
						<div>
							<i id="effect" class="fa fa-check-circle-o"
								style="color: green; font-size: 7em;"></i>
						</div>

						<div
							class="col-xs-12 xol-md-12 alert alert-success alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							role="alert" ng-repeat="msgSuccess in addMsg">
							<p>{{msgSuccess}}</p>
						</div>
					</div>
					<div class="modal-body" style="text-align: center;"
						ng-show="addMsgerror.length>0">
						<div style="text-align: center;">
							<i class="fa fa-exclamation-triangle"
								style="color: #E84F63; font-size: 50px; text-align: center;"></i>
						</div>
						<div
							class="col-xs-12 xol-md-12 alert alert-danger alert-dismissible"
							style="color: black; text-align: center; font-family: arial;"
							ng-repeat="msg in addMsgerror">{{msg}}</div>


					</div>
					<div class="clearfix">&nbsp;</div>
					<div class="modal-footer"
						style="align: center; text-align: center;">

						<button data-dismiss="modal" type="button" class="btn btn-info"
							onclick="ExitGYTIReview()">Exit</button>
					</div>
				</div>
			</div>
		</div> 

	</div>
	<!-- <script src="js/jquery-ui.js"></script> -->
	<script src="https://code.jquery.com/ui/1.12.0-rc.2/jquery-ui.js"
		integrity="sha256-6HSLgn6Ao3PKc5ci8rwZfb//5QUu3ge2/Sw9KfLuvr8="
		crossorigin="anonymous"></script>
	<!-- <script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/select2.min.js"></script> -->
	<script src="js/select2.min.js"></script>
	<script src="js/script.min.js"></script>
	<script type="text/javascript">
		$(".loaderBody").load(function() {
			$(".loaderBody").fadeOut("slow");
		})
	</script>
</body>
</html>
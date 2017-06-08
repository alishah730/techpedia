<div class="" style="padding-left: 0px; padding-right: 0px;">
		<jsp:include page="template/reviewHeader.jsp"></jsp:include>
</div>
<html ng-app="techpedia" lang="en" class="no-js">
<title>Activate Profile</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
</head>
<body>
	
	<div id="sideNavPanel" class="col-xs-2"
		style="padding-left: 0px; padding-right: 0px; margin-left: 0px;"><jsp:include
			page="template/reviewSideMenu.jsp"></jsp:include></div>

	<div ng-controller="activateReviewerProfileViaEmailController"
		ng-init="Initload()">
		<div class="content-wrapper">
			<div id="mainPanelBody" class="col-xs-10 col-md-10" style="">
				<div
					style="padding-left: 20px !important; background-color: #3575AD; color: white; height: 56px; padding-top: 15px; font-family: arial; font-size: 20px; font-weight: bolder;">
					Activate Account</div>
				<div class="col-xs-12 clearfix">&nbsp;</div>
				<div class="col-xs-12 " style="clear: both;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
				<div class="clearfix">&nbsp;</div>
				<div class="row" style="text-align: center;">
					<input type="hidden" ng-init="result='${result}'">
					<div ng-show="result== 'Congratulations, Your Profile has been Activated succesfully'" style="text-align: center;"
						class="alert alert-success" role="alert">
						<h1>${result} &nbsp;Please click <a href="./">here</a> for login</h1>
					</div>
					<div ng-show="result=='Failed to activate , Please visit after sometime'" style="text-align: center;"
						class="alert alert-danger" role="alert">
						<h1>${result}</h1>
					</div>
				</div>

				<div class="col-xs-12 clearfix">&nbsp;</div>
				<div class="col-xs-12 " style="clear: both;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			</div>
		</div>
	</div>

	<a href="#0" class="cd-top">Top</a>
</body>

</html>
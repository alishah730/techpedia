<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="techpedia">
<title>Gyti Review System Login Page</title>
<link rel="shortcut icon" type="image/x-icon" href="images/Techicon.ico">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
#Reviewheader {
	background-color: #23282e;
	color: white;
	padding: 5px;
}

.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none !important;
}

.breadcrumb {
	background-color: #23282e;
	margin-bottom: 0px;
}

.borders {
	border: solid 1px balck;
	padding: 5px;
	box-shadow: 10px 10px 5px #888888;
	background-color: white;
}

.inputdemoIcons {
	/*
.right-icon {
  position: absolute;
  top: 4px;
  right: 2px;
  left: auto;
  margin-top: 0;
}
*/
	
}

.inputdemoIcons .inputIconDemo {
	min-height: 48px;
}

.inputdemoIcons md-input-container:not (.md-input-invalid ) >md-icon.email
{
	color: green;
}

.inputdemoIcons md-input-container:not (.md-input-invalid ) >md-icon.password
	{
	color: dodgerblue;
}

.inputdemoIcons md-input-container.md-input-invalid>md-icon.email,
.inputdemoIcons md-input-container.md-input-invalid>md-icon.password {
	color: red;
}
</style>
</head>
<body class="content-wrapper" style="background-color: #f5f5f5">
	<div class=""
		style="padding-left: 0px; padding-right: 0px;">
		<jsp:include page="template/reviewHeader.jsp"></jsp:include>
	</div>
	<div id="sideNavPanel" class="col-xs-2" style="padding-left: 0px; padding-right: 0px;margin-left: 0px;">
		<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
	</div>
	

	<div ng-controller="reviewerLoginController" ng-init="InitLoad()"
		layout-padding="" ng-cloak="" class="inputdemoIcons">

		<div id="mainPanelBody" class="col-xs-10 col-md-10">

			<div class="container">
				
				<div class="col-xs-12">&nbsp;</div>
				<div class="col-md-6 borders" style="margin-right: 10px;  margin-top: 50px;">
				
				<!-- 	<h4>Add Reviewer</h4> -->
				<h3>
					<i class="fa fa-reorder custom">&nbsp;&nbsp;Login</i>
				</h3>
				
					<div class="col-xs-12">&nbsp;&nbsp;</div>			
					<form role="form" ng-submit="reviewerLogin()"
						id="reviewerLogin-form" name="reviewerLogin-form" style=" padding-top: 5px;">
						<md-input-container class="md-block"> <!-- Use floating placeholder instead of label -->
						<md-icon md-svg-src="images/ic_email_24px.svg" class="email"></md-icon>
						<input ng-model="reviewer.emailId" name="email" id="email"
							type="email" placeholder="Email" ng-required="true" required
							minlength="10" maxlength="100" ng-pattern="/^.+@.+\..+$/"
							required> </md-input-container>
						<md-input-container class="md-block"> <!-- Use floating placeholder instead of label -->
						<md-icon md-svg-src="images/password.svg" class="password"></md-icon>
						<input ng-model="reviewer.password" type="password"
							placeholder="Password" ng-required="true" name="password"
							id="password" required> </md-input-container>

						<md-button
							ng-disabled=""
							class="md-raised md-primary pull-right"
							ng-click="reviewerLogin()">Login</md-button>
					</form>
					<div class="clearfix">&nbsp;</div>
					<div class="alert alert-sm alert-danger alert-dismissible"
						role="alert" ng-show="addMsgerror.length>0">
						<p ng-repeat="msg in addMsgerror">{{msg}}</p>
						&nbsp;OR&nbsp;
						<p ng-repeat=" msg1 in userNotFound">{{msg1}}</p>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
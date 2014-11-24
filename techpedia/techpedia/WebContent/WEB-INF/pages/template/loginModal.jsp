<div class="modal fade bs-modal-sm" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="mySmallModalLabel" aria-hidden="true" ng-controller="LoginModalController"
	ng-init="InitLoad()">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" style="padding-bottom: 10px" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>

			</div>
			<div class="bs-example bs-example-tabs">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#signin" data-toggle="tab">Sign In</a></li>
					<li class=""><a href="#signup" data-toggle="tab">Forgot Password</a></li>

				</ul>
			</div>
			<div class="modal-body">
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in" id="signin">
						<form id="login-form" method="post" novalidate>
							<fieldset>
								<!-- Sign In Form -->
								<!-- Text input-->
								<div class="control-group">
									<label class="control-label" for="userid">Username:</label>
									<div class="controls">
										<input id="username" name="username" type="text" class="form-control"
											placeholder="username" class="input-medium" required="required">
									</div>
								</div>

								<!-- Password input-->
								<div class="control-group">
									<label class="control-label" for="passwordinput">Password:</label>
									<div class="controls">
										<input id="password" name="password" class="form-control" type="password"
											placeholder="password" class="input-medium">
									</div>
								</div>

								<!-- Multiple Checkboxes (inline) -->
								<!-- <div class="control-group">
									<label class="control-label" for="rememberme"></label>
									<div class="controls">
										<label class="checkbox inline" for="rememberme-0"> <input type="checkbox"
											name="rememberme" id="rememberme-0" value="Remember me" />Remember me
										</label>
									</div>
								</div> -->
								<div class="col-xs-12">&nbsp;</div>
								<!-- Button -->
								<div class="control-group">
									<label class="control-label" for="signin"></label>
									<div class="controls">
										<div class="col-xs-12">
											<input type="submit" class="btn btn-success" id="login-submit" value="Login" />
											<button style="width: 100px;" class="btn btn-info" ng-click="facebookLogin()">Facebook</button>
											<div id="login-error-div" style="color: red;"></div>
										</div>
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="tab-pane fade" id="signup">
						<form class="form-horizontal" method="post">
							<fieldset>
								<div class="control-group">
									<label class="control-label" for="Email">Please enter your registered email:</label>
									<div class="controls">
										<input id="email" name="email" class="form-control" type="text" placeholder="abc@def.com"
											class="input-large" required="required" ng-model="token">
										<div id="forgot-password-div" style="color: red;"></div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="confirmsignup"></label>
									<div class="controls">
										<div class="col-xs-12">
											<div class="col-xs-3">
												<a class="btn btn-sm btn-success" style="cursor: pointer;" ng-click="forgotPassword()">Submit</a>
											</div>
										</div>
										<div class="col-xs-12" ng-show="message.length>0">
											<div ng-repeat="msg in message">{{msg}}</div>
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
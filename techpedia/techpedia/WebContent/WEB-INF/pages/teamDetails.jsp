<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="techpedia">
<script src="js/script.min.js"></script>
<script src="js/select2.min.js"></script>
<jsp:include page="template/NewHeader.jsp" />
<div class="clearfix"></div>
<div class="container customFont borderRadius style" >
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
	<%-- 	<jsp:include page="template/dashboardMenu.jsp" /> --%>
	</div>

	<div class="page-content-wrapper" ng-controller="TeamDetailsController" ng-init="initLoad()">
		<div class="page-content">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
						<i class="fa fa-share" id="icon-size"></i> Team Details
						<!-- <small>dashboard & statistics</small> -->
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Teams</li>

						<!-- <li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li> -->
					</ul>

				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">
				<div class="col-md-12 left-border">
					<div class="col-md-6" style="top: 8px;">Team Name &raquo; {{teamName}}</div>
					<div class="col-md-6" style="top: 8px;">Project Name &raquo; {{projectName}}</div>
					<div class="col-md-3">
						<!-- <a href="addTeamMember" data-toggle="modal" id="search-new-members-button"
							data-target=".bs-modal-sm" class="btn btn-info add">Add new Member</a> -->
						<div class="col-md-12"></div>
					</div>
				</div>
				<br> <br> <br>

				<div class="col-md-4 one1" ng-repeat="member in members">
					<div class="panel panel-primary">
						<div class="panel-heading">
							{{member.teamMemFName}} {{member.teamMemMName}} {{member.teamMemLName}} 
						
							<i ng-show="member.teamLeaderId ==<%=session.getAttribute("id")%>&&member.teamLeaderId != member.teamMemRegstrId"
						       ng-disabled=""
								style="float: right; position: relative; top: 3px;" class="fa fa-times-circle"
								 ng-click="removeMember(member)"></i>
						</div>
						<div class="panel-body">
							<div class="col-md-3">
								<img src="{{member.photo||'images/UserDefault.jpg'}}" width=60 height=65 />
							</div>
							<div class="col-md-9">
								<p>{{member.state}}</p>
								<p>{{member.country}}</p>
								<p>{{member.college}}</p>
							</div>
						</div>
					</div>
				</div>
				<div id="added-new-members"></div>
			</div>
			<div class="clearfix"></div>
			
	<%-- 		<%
												
												if(session.getAttribute("username") != null){
												long registrId=((Long)session.getAttribute("id"));
												System.err.println("inJsp Value"+registrId);
												String rValue=String.valueOf(registrId);
												
												if(rValue != null){
													%>
											
													<c:set var="teamLeadrId" value="${member.teamLeadrId}" />
													
													<c:set var="rid" value="<%=registrId %>" scope="session" />
													
													<c:if test="${teamLeadrId == rid}"> --%>
					<div class="alert alert-sm alert-info alert-dismissible" role="alert" id="hide"
					ng-show="message.length>0">
					<p style="text-align: center">	<!-- <button  disabled>Show more</button> -->
					<p ng-repeat="msg in message" style="text-align: center">{{msg}}</p></p>
				</div>
													
         
			

    <div ng-controller="MyCtrl" ng-repeat="member in members|limitTo:1">
        <div ><button id="mybutton"  class="btn btn-info btn-small" style="cursor: pointer;" ng-click="showAlert()"  ng-show="member.teamLeaderId==<%=session.getAttribute("id")%>"
        >Add Team Member</button></div>
       <div class="col-md-12"></div>
        <div><div ng-show="myvalue" class="hideByDefault"> <div class="row" id="addTeamMember" >
				<div class="col-xs-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Add team member</div>
						<div class="panel-body" >
							<!-- <div class="panel panel-primary">
								<div class="panel-heading">Choose project</div>
								<div class="panel-body">
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
											{{chosenProject.projTitle}} <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li ng-repeat="project in projects"><a href="#" ng-click="chooseProject(project)">{{project.projTitle}}
											</a></li>
										</ul>
									</div>
								</div>
							</div> -->

							
								
								<div class="panel-body no-collapse">
									<form name="searchTeamMembers" novalidate>
										<div class="col-xs-6  one1">
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">First Name </span> <input type="text" name="firstName"
														class="form-control" placeholder="First Name" ng-model="search.firstName">
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">Mid Name </span> <input type="text" name="midName"
														class="form-control" placeholder="Middle Name" ng-model="search.midName">
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">Last Name </span> <input type="text" name="lastName"
														class="form-control" placeholder="Last Name" ng-model="search.lastName">
												</div>
											</div>

											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">College </span> <input  type="text" class="form-control" placeholder="Search Colleges" id="CollegeNames2"
														name="college" ng-model="search.collge" >
												</div>
											</div>
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12">
												<div class="input-group">
													<span class="input-group-addon">Roll# </span> <input type="text" name="studentID"
														class="form-control" placeholder="Enrollment" ng-model="search.studentID">
												</div>
											</div>
											<div class="col-xs-12">&nbsp;</div>
											<div class="col-xs-12" style="text-align: center;">
												<input ng-click=searchMember(search) type="submit" name="submit"
												   class="btn btn-sm btn-success" />
											</div>
										</div>
									</form>
								
							
							
							
							
							<div  ng-show="searchResults.length>0">
								
								<div class="panel-body col-xs-6 pull-right no-collapse">
									Filter: <input type="text" ng-model="filterSearch"><br /> <br />
									<ul class="list-group">
										<li class="list-group-item" ng-repeat="result in searchResults | filter:filterSearch">{{result[1]}}
											<btn style="float: right; padding-bottom:5px;" class="btn btn-info btn-small" ng-click="addMember(result[0])">Choose</btn>
										<!-- <btn style="cursor: pointer;"  class="btn btn-info btn-small" 
											
												ng-click="viewProject(project.projId)">View</btn> -->
										</li>
									</ul>
								</div>
							</div>
							</div>
							</div> 	
						</div>
					</div>
				</div>

			</div>	</div></div>
    </div>
</div>
			
			
												

 
			<!-- END CONTAINER
BEGIN FOOTER -->
		</div>
	</div>
</div>



<script>
function MyCtrl($scope) {

	  $scope.myvalue = false;
		
		$('#CollegeNames2').select2({
			minimumInputLength : 1,
			tags : [],
			tokenSeparators : [ "," ],
			maximumSelectionSize : 1,
			placeholder : "Choose Colleges",
			ajax : { // instead of writing the function to
				// execute the request we
				// use Select2's convenient helper
				url : "getSuggestedCollegeList",
				dataType : 'json',
				type : "GET",
				data : function(term) {
					
					return {
						q : term
					};
				},
				results : function(data) {
					return {
						results : $.map(data, function(item) {
							return {
								text : item,
								id : item
							};
						})
					};
				}
			}
		});
		$('#CollegeNames2').on("select2-blur", function(e) {
			
			$scope.search.collge=$('#CollegeNames2').val();
		});
		$scope.search.collge=$('#CollegeNames2').select2('data').text;
	  $scope.showAlert = function(){
	    $scope.myvalue = true;  
	  };
	}
</script>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->

</body>
<!-- END BODY -->
</html>
<link rel="stylesheet" href="css/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/customStyle.css">
<jsp:include page="template/footer.jsp" />

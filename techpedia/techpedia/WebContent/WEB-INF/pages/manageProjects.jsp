
<jsp:include page="template/NewHeader.jsp" />
<html ng-app="techpedia">
<style>
.breadcrumb>li+li:before {
padding: 0 5px;
color: #ccc;
content: none;
} 
</style>
<div class="clearfix"></div>
<div class="container customFont borderRadius style" >

<div class="page-container">
	<div class="page-sidebar-wrapper">
	
	</div>
<div class="page-container" ng-controller="ManageProjectsController" ng-init="manageProjectsInit()">
      <%String projrgstrid =String.valueOf((Long) session.getAttribute("id")); %>
	<%-- <div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div> --%>
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- <div class="row">
				<div class="col-md-12">
					BEGIN PAGE TITLE & BREADCRUMB
					<h3 class="page-title">
						<i class="fa fa-briefcase" id="icon-size"></i> Manage Projects
						<small>dashboard & statistics</small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li><a href="./">Home</a> &raquo;</li>
						<li><a href="dashboard">Dashboard</a> &raquo;</li>
						<li>Manage Projects</li>
						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips"
								data-placement="bottom" data-original-title="Change dashboard date range">
								<i class="icon-calendar"></i> <span></span> <i class="fa fa-angle-down"></i>
							</div>
						</li>
					</ul>
					END PAGE TITLE & BREADCRUMB
				</div>
				
			</div> -->
	<div class="row">
				<div class="col-md-12">
					<h3 class="page-title">Manage Projects</h3>
					<ul class="page-breadcrumb breadcrumb" >
						<li ><a href="./">Home</a> <font  style="font-weight: bold; color: black; font-size:18px;">&raquo;</font></li>
						<li ><a href=dashboard>Dashboard</a> <font  style="font-weight: bold; color: black; font-size:18px;">&raquo;</font></li>
					
						<li style="content:none !important;">Manage Projects</li>
					
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
<!-- 			<div class="row"> -->
<!-- 				<div class="alert alert-sm alert-info alert-dismissible" role="alert" ng-show="message.length>0"> -->
<!-- 					<li ng-repeat="msg in message">{{msg}}</li> -->
<!-- 				</div> -->
			</div>
			<div class="row">
				<div class="col-md-12 left-border">
					<div class="col-md-9" style="top: 8px;">
						Filter: <input type="text" ng-model="filterSearch">
					</div>

					<div class="col-md-3" ng-show="userType=='student'">
						<a href="addProject" style="background-color:#709FDD;border-color:#709FDD;"class="btn btn-info add"><span class="glyphicon glyphicon-plus"></span>Add
							New Project</a>
					</div>
					<div class="col-md-12"></div>
				</div>

				<br> <br> <br>
				<div class="col-md-12 left-border">
					<div class="alert alert-info" role="alert" ng-show="projects==null||projects.length==0">Nothing
						to display</div>
					<div class="col-xs-12 one1" ng-repeat="project in projects | filter:filterSearch">
					
						<div class="panel panel-primary" style="border-color:#E8E8E8; ">
							<div class="panel-heading">
								{{project.projTitle}}
								<!-- (Lead: {{project.projTeamLeaderId}}) --><i
									style="float: right; position: relative; top: 3px;" class="fa fa-times-circle"
									ng-click="deleteProject(project)"></i>
							</div>
							<div class="panel-body"  >
							<div class="panel panel-warning" ><div class="panel-heading" > <span  style="padding-left: 68%"  ng-show="project.projStatusId==3">Project Status : Submitted for final approval</span>
								<span style="padding-left: 68%" ng-show="project.projStatusId==0||project.projStatusId==1">Project Status : Pending Initial Approval</span>
								<span style="padding-left: 68%" ng-show="project.projStatusId==2">Project Status : Initiated and Active</span>
								<span style="padding-left: 68%" ng-show="project.projStatusId==4">Project Status : Completed</span></div></div>
								<div class="col-md-2">
									<img src="{{project.projImage||'images/art/project.png'}}"  width=50 height=65 />
								</div>
								<div class="col-md-7">
									<p>{{project.projDescription}}</p>
									<p class="sub-text-4"></p>
								</div>
								<div class="row-fluid pull-right" style="margin-top:30px">
									
											<btn style="cursor: pointer; background-color:#709FDD;border-color:#709FDD;"  class="btn btn-info btn-smallL"
											
												ng-click="viewProject(project.projId)">View</btn>
										

										

										
											<!-- ng-show="registerId==project.projTeamLeaderId"> -->
											<btn style="cursor: pointer; background-color:#709FDD;border-color:#709FDD;" class="btn btn-info btn-small"
												 ng-show="userType=='student'&&(project.projStatusId==0||project.projStatusId==1)"
												ng-click="editProject(project)">Edit</btn>
										
										
										
											<!--  ng-show="registerId==project.projTeamLeaderId"> -->
											<btn style="cursor: pointer; background-color:#709FDD;border-color:#709FDD;" class="btn btn-info
												btn-small"
												data-toggle="modal" data-target="#pitchMentorModal" 
												ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&(project.projTeamLeaderId==<%=projrgstrid %>))
												||(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='N'&&(project.projTeamLeaderId==<%=projrgstrid %>))"
												ng-disabled="project.projMentor1Id!=0&&project.projMentor2Id!=0"
												ng-click="pitchProject(project)">Pitch</btn>
										
											<!-- <a style="cursor: pointer;"  data-toggle="modal"
												data-target="#uploadModal" class="btn btn-info btn-small"  
											ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&(project.projMentor1Id==0||project.projMentor2Id==0)&&project.projTeamLeaderId!=0)||
                                                         (project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&project.projMentor1Id==0&&project.projMentor2Id==0)||
                                                         (project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&project.projMentor1Id!=0&&project.projMentor2Id!=0&&project.projTeamLeaderId!=0)||
                                                         (project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&project.projMentor1Id!=0&&project.projMentor2Id!=0)"
												ng-click="currentProject(project)">Upload</a> -->
												<btn style="cursor: pointer;background-color:#709FDD;border-color:#709FDD;"  data-toggle="modal"
												data-target="#uploadModal" class="btn btn-info btn-small"  
											ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y')||(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='N')"
												ng-click="currentProject(project)">Upload</btn>
										
										
											<btn style="cursor: pointer;background-color:#709FDD;border-color:#709FDD;" class="btn btn-info
												btn-small"
												ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&(project.projTeamLeaderId==<%=projrgstrid %>))"
												ng-click="submitProject(project.projId)">Submit</btn>
												<btn style="cursor: pointer;background-color:#709FDD;border-color:#709FDD;" class="btn btn-info
												btn-small"
												ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='N'&&(project.projTeamLeaderId==<%=projrgstrid %>))"
												ng-click="submitProject(project.projId)">Submit Again</btn>
									
										
										

									
							
							      
											<!-- <a style="cursor: pointer;"  class="btn btn-info btn-small"
												data-toggle="modal" data-target="#approveProjectModal"
												ng-show="(project.projStatusId==2&&userType=='faculty'&&project.projIsFacApprove=='N'&&project.projMentor1Id==0&&project.projMentor2Id==0)||
                                                         (project.projStatusId==2&&userType=='mentor'&&project.projIsFacApprove=='Y'&&project.projMentor1Id==0&&project.projMentor2Id==0)"
												ng-click="currentProject(project)">Approve</a> -->
												<btn style="cursor: pointer;background-color:#709FDD;border-color:#709FDD;"  class="btn btn-info btn-small"
												data-toggle="modal" data-target="#approveProjectModal"
												ng-show="(project.projStatusId==0&&userType=='faculty')"
												ng-click="currentProject(project)">Approve</btn>
										
									
									
											<btn style="cursor: pointer;background-color:#709FDD;border-color:#709FDD;"  class="btn btn-info
												btn-small"
												data-toggle="modal" data-target="#closeProjectModal" 
												ng-show="((project.projStatusId==3&&userType=='faculty'&&project.projIsFacApprove=='Y')
												||(project.projStatusId==3&&userType=='faculty'&&project.projIsFacApprove=='N'))"
												ng-click="currentProject(project)">Close</btn>
										
										
										</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			
<!-- 			<div class="row"> -->
<!-- 				<div class="alert alert-sm alert-info alert-dismissible" role="alert" ng-show="message.length>0"> -->
<!-- 					<li ng-repeat="msg in message">{{msg}}</li> -->
<!-- 				</div> -->
<!-- 			</div> -->

			<div class="clearfix"></div>
			<!-- MODAL -->
			<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span  aria-hidden="true" ng-click="datarefresh()">&times;</span><span class="sr-only" >Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Upload a document</h4>
						</div>
						<div class="modal-body">
							<input id=choseefile type="file" ng-file="file" base64>

							<div class="alert alert-sm alert-info alert-dismissible" role="alert"
								ng-show="message.length>0">
								<li ng-repeat="msg in message">{{msg}}</li>
							</div>
						</div>
						<div class="modal-footer">
							<button  class="btn btn-primary" ng-click="uploadProjectDocument()">Upload</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	

	<!-- Modal -->
	<div class="modal fade" id="approveProjectModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Accept or reject the project ?</h4>
				</div>
				<div class="modal-body">If you are satisfied by the project contents, you may approve it.
					Otherwise, you may reject it.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" ng-click="initiateProject('Y')"
						>Accept</button>
					<!-- <button type="button" class="btn btn-danger" ng-click="initiateProject('N')"
						>Reject</button> -->
						<div class="alert alert-sm alert-info alert-dismissible" role="alert"
								ng-show="message.length>0">
								<li ng-repeat="msg in message">{{msg}}</li>
							</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="closeProjectModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal_modl" >
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Close the project ?</h4>
				</div>
				<div class="modal-body">If you are satisfied with the project work, please close it.
					Otherwise, ask for modification.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" ng-click="closeProject('Y')" >Close
						Project</button>
					<button type="button" class="btn btn-danger" ng-click="closeProject('N')" >Modification
						needed</button>
						<div class="alert alert-sm alert-info alert-dismissible" role="alert"
							ng-show="message.length>0">
							<li ng-repeat="msg in message">{{msg}}</li>
						</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="pitchMentorModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true" ng-click="datarefresh()">&times;</span><span class="sr-only" ng-click="datarefresh()">Close</span>
					</button>
				
				</div>
				<div class="modal-body">
					<h3 class="modal-title" id="myModalLabel">
						Select Mentor
						<div class="alert alert-sm alert-info alert-dismissible" role="alert"
							ng-show="message.length>0">
							<li ng-repeat="msg in message">{{msg}}</li>
						</div>
					</h3>
				<div class="col-md-12">&nbsp;</div>
				<div class="col-md-12">&nbsp;</div>
					<div class="col-xs-12" ng-repeat="mentor in suggestedMentors">
						<div class="col-md-2">
						<img ng-show="(mentor.photo=='data:undefined;base64,undefined')||(mentor.photo=='Photo path')" src="images/profile_icon.png" width=90 height=100 />
						<img ng-hide="(mentor.photo=='data:undefined;base64,undefined')||(mentor.photo=='Photo path')" src="{{mentor.photo||'images/profile_icon.png'}}" width=90 height=100 />
						</div>
						<div class="col-md-10">
							<div class="col-md-12">{{mentor.fName}} {{mentor.mName}} {{mentor.lName}}</div>
							<div class="col-md-12">{{mentor.designation}}</div>
							<div class="col-md-12">{{mentor.degree}}</div>
							<div class="col-md-12 red">Experience: {{mentor.experience}}</div>
							<div class="col-md-12">
								<a style="cursor: pointer;" class="btn btn-sm btn-success" ng-click="addMentor(mentor)">Add
									to project</a>
									</div>
						</div>
						<div class="col-md-12">&nbsp;</div>
						<hr>
						<div class="col-md-12">&nbsp;</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>

</div>

<script>
/* $(document).ready(function()
		 {
$('#myModalLabel').on('hidden', function() {
    $(this).data('modal').$element.removeData();
})
}; */
</script>
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src=".js/respond.min.js"></script>
<script src="js/dashboardJs/excanvas.min.js"></script> 
<![endif]-->
</div><!--End tag of container customFont borderRadius style  -->
</div><!-- End tag of page container -->
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
<link rel="stylesheet" href="css/customStyle.css"/>
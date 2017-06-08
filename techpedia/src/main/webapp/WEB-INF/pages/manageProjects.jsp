<html ng-app="techpedia">
<head>
<style>
.breadcrumb>li+li:before {
	padding: 0 5px;
	color: #ccc;
	content: none;
}
</style>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body style="background-color: white !important"
	ng-controller="ManageProjectsController">
	<div>
		<jsp:include page="template/NewHeader.jsp" />
		<div class="customFont"
			style="height: 250px; background-color: #217690">
			<img src="images/MANAGE-PROJECTS-BANNER.jpg" class="img-responsive"
				" style="height: 250px;">


			<div class="col-md-3" ng-show="userType=='student'"
				style="margin-left: 75%; margin-top: -4%;">

				<a href="addProject" class="btn btn-success btn-responsive"
					type="button"><span class="glyphicon glyphicon-plus "></span>Add
					New Project</a>
			</div>

		</div>

	</div>





	<div class="container customFont borderRadius style"
		style="background-color: #3f94ae">

		<!-- <div class="page-container"> -->
		<div class="page-sidebar-wrapper"></div>
		<div class="page-container" ng-init="manageProjectsInit()">
			<%
				String projrgstrid = String.valueOf((Long) session.getAttribute("id"));
			%>
			<%-- <div class="page-sidebar-wrapper">
		<jsp:include page="template/dashboardMenu.jsp" />
	</div> --%>
			<!-- <div class="page-content-wrapper" style="background-color: white"> -->
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

				<!-- <div style="width: 1130px; background-color: #3f94ae"> -->
				<!-- <div style="margin-left: 16px; color: white; font-size: 18px;">
				<i class="fa fa-bolt custom"></i> MANAGE PROJECTS
			</div>
 -->
				<div class="row" style="color: white !important">
					<div class="col-md-12">

						<ul class="page-breadcrumb breadcrumb"
							style="background-color: #217690; color: #ffffff !important">
								<li><a style="color: white !important;" href="./">Home</a> <font
								style="font-weight: bold; color: white; font-size: 18px;">&raquo;</font></li>
								<li><a style="color: white !important;" href="dashboard">Dashboard&nbsp;</a> <font
								style="font-weight: bold; color: white; font-size: 18px;">&raquo;</font></li>
								<li style="content: none !important;">Manage
								Projects</li>

						</ul>

					</div>
				</div>
				<!-- <div style="height: 85px">
				<div ng-show="userType=='student'" align="center">
					<a href="addProject"
						class="btn btn-success btn-responsive" type="button"><span
						class="glyphicon glyphicon-plus "></span>Add New Project</a>
				</div>

			</div> -->

				<div
					style="border-radius: 8px; height: 48px; background-color: #2b2b2b; padding-top: 7px;">
					<div style="width: 50px; float: left; padding-top: 8px;">
						<span
							style="color: white; width: 100px; padding-top: 13px; padding-left: 10px;">PROJECTS</span>
					</div>
					<li class="dropdown-short"><span
						style="margin-left: 70%; color: white; font-weight: bolder;">Sort
							By &nbsp;</span>
						<div class="dropdown" style="float: right; padding-right: 16px;">
							<a class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown"
								style="background-color: white; width: 200px; color: black; font-size: 16px;">
								{{selectedItem}}&nbsp;&nbsp;&nbsp; <i
								class="fa fa-caret-square-o-down custom"
								style="margin-left: 10%;"></i>
							</a>
							<ul class="dropdown-menu" style="width: 93%;">
								<li><a
									ng-click=" allProject(<%=session.getAttribute("id")%>)"> <i
										class="fa fa-reorder custom">&nbsp;</i>All Project
								</a></li>
								<li><a
									ng-click=" allGytiProject(<%=session.getAttribute("id")%>)">
										<i class="fa fa-reorder custom">&nbsp;</i>All GYTI Projects
								</a></li>
								<li><a class="completed"
									ng-click="statusCompleted(<%=session.getAttribute("id")%>)"><i
										class="fa fa-check-square-o" style="color: green">&nbsp;</i>Completed
										Project</a></li>
								<li><a class="working"
									ng-click="statusWorking(<%=session.getAttribute("id")%>)"><i
										class="fa fa-spinner fa-pulse">&nbsp;</i>Working Project</a></li>
							</ul>
						</div></li>

				</div>



				<div class="alert alert-info" role="alert"
					ng-show="projects==null||projects.length==0">Nothing to
					display</div>
				<div class="col s12"
					style="border-radius: 8px; height: 236px; background-color: #ffffff; margin-left: 20px; margin-top: 20px;"
					ng-repeat="project in projects | filter:filterSearch">

					<div style="float: left; padding-left: 12px;">
						<img
							src="${pageContext.request.contextPath}/image/{{project.photo1Path ||'/usr/Techpedia/Project/placeholders/placeholder.png'}}"
							alt=""
							style="height: 222px; width: 235px; padding-top: 15px; position: absolute; z-index: 0;" />
						<div
							style="margin-top: 167px; padding-top: 13px; bottom: 0; left: 0; width: 235px; height: 54px; position: relative; text-align: center; color: black; font-weight: bolder; opacity: 0.7; filter: alpha(opacity = 70); z-index: 4; background-color: white;">{{project.projTitle}}</div>
					</div>
					<div
						style="font-family: arial; font-size: 14; height: 10em; right; text-align: justify; position: absolute; padding-left: 256px; padding-top: 20px; padding-right: 145px; overflow: hidden; text-overflow: ellipsis;">
						{{project.projDescription}}</div>
					<!-- <div style="clear: both;"></div> -->
					<div align="center !important">
						<div class="row-fluid pull-right"
							style="padding-top: 190px; padding-right: 20px;">

							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive"
								ng-click="viewProject(project.projId)">
							<i class="fa fa-eye">&nbsp;</i>View</btn>

							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive"
								ng-show="userType=='student'&&(project.projStatusId==4)"
								ng-click="additionalInfoGyti(project.projId)">
							<i class="fa fa-pencil-square-o">&nbsp;</i>Submit For GYTI</btn>



							<!-- ng-show="registerId==project.projTeamLeaderId"> -->
							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive"
								ng-show="userType=='student'&&(project.projStatusId==0||project.projStatusId==1)"
								ng-click="editProject(project)">
							<i class="fa fa-pencil-square-o">&nbsp;</i>Edit</btn>

							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive"
								ng-show="userType=='student'&&(project.projStatusId==11)"
								ng-click="editGytiInnovation(project)">
							<i class="fa fa-pencil-square-o">&nbsp;</i>Edit Gyti Project</btn>
							<btn style="cursor: pointer;" data-toggle="modal"
								data-target="#uploadModal"
								class="btn btn-success btn-responsive"
								ng-show="userType=='student'&&(project.projStatusId==11)"
								ng-click="currentProject(project)">
							<i class="fa fa-upload"></i>&nbsp;Upload</btn>


							<!--  ng-show="registerId==project.projTeamLeaderId"> -->
							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive" data-toggle="modal"
								data-target="#pitchMentorModal"
								ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&(project.projTeamLeaderId==<%=projrgstrid%>))
												
||(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='N'&&(project.projTeamLeaderId==<%=projrgstrid%>))"
								ng-disabled="project.projMentor1Id!=0&&project.projMentor2Id!=0"
								ng-click="pitchProject(project)">
							<i class="fa fa-code-fork"></i>&nbsp;Pitch</btn>

							<!-- <a style="cursor: pointer;"  data-toggle="modal"
												data-target="#uploadModal" class="btn btn-info btn-small"  
											
ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&(project.projMentor1Id==0||pro
ject.projMentor2Id==0)&&project.projTeamLeaderId!=0)||
                                                         
(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&project.projMentor1Id==0&&
project.projMentor2Id==0)||
                                                         
(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&project.projMentor1Id!=0&&
project.projMentor2Id!=0&&project.projTeamLeaderId!=0)||
                                                         
(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&project.projMentor1Id!=0&&
project.projMentor2Id!=0)"
												ng-click="currentProject(project)">Upload</a> -->
							<btn style="cursor: pointer;" data-toggle="modal"
								data-target="#uploadModal"
								class="btn btn-success btn-responsive"
								ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y')||(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='N')"
								ng-click="currentProject(project)">
							<i class="fa fa-upload"></i>&nbsp;Upload</btn>


							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive"
								ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='Y'&&(project.projTeamLeaderId==<%=projrgstrid%>))"
								ng-click="submitProject(project.projId)">
							<i class="fa fa-check-square-o">&nbsp;</i>Submit</btn>
							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive"
								ng-show="(project.projStatusId==2&&userType=='student'&&project.projIsFacApprove=='N'&&(project.projTeamLeaderId==<%=projrgstrid%>))"
								ng-click="submitProject(project.projId)">Submit Again</btn>



							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive"
								ng-show="(project.projStatusId==1&&userType=='student'&&project.projIsFacApprove=='N'&&(project.projTeamLeaderId==<%=projrgstrid%>))"
								ng-click="reSubmitProject(project.projId)">Resubmit</btn>



							<!-- <a style="cursor: pointer;"  class="btn btn-info btn-small"
												data-toggle="modal" data-target="#approveProjectModal"
												
ng-show="(project.projStatusId==2&&userType=='faculty'&&project.projIsFacApprove=='N'&&project.projMentor1Id==0&&
project.projMentor2Id==0)||
                                                         
(project.projStatusId==2&&userType=='mentor'&&project.projIsFacApprove=='Y'&&project.projMentor1Id==0&&p
roject.projMentor2Id==0)"
												ng-click="currentProject(project)">Approve</a> -->
							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive" data-toggle="modal"
								data-target="#approveProjectModal"
								ng-show="(project.projStatusId==0&&userType=='faculty')"
								ng-click="currentProject(project)">Approve</btn>


							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive" data-toggle="modal"
								data-target="#rejectProjectModal"
								ng-show="(project.projStatusId==0 && userType=='faculty')"
								ng-click="currentProject(project)">Reject</btn>

							<btn style="cursor: pointer;"
								class="btn btn-success btn-responsive" data-toggle="modal"
								data-target="#closeProjectModal"
								ng-show="((project.projStatusId==4&&userType=='faculty'&&project.projIsFacApprove=='Y')
												||(project.projStatusId==4&&userType=='faculty'&&project.projIsFacApprove=='N'))"
								ng-click="currentProject(project)">MarkProjectAsCompleted</btn>


						</div>
					</div>









				</div>










			</div>
			<div class="clearfix"></div>
			<!-- 			<div class="row"> -->
			<!-- 				<div class="alert alert-sm alert-info alert-dismissible" role="alert" ng-show="message.length>0"> -->
			<!-- 					<li ng-repeat="msg in message">{{msg}}</li> -->
			<!-- 				</div> -->

			<div class="row">
				<div class="col-md-12 left-border">
					<div class="col-md-9" style="top: 8px;">

						<!-- Project Filter codes starts here... -->
						<script type="text/javascript">
							$(document).ready(function() {
								$(".completed").click(function() {
									$(".statusWorking").hide();
									$(".statusComplete").show();
								});

								$(".working").click(function() {
									$(".statusWorking").show();
									$(".statusComplete").hide();
								});
								/* $('.allProject').click(function() {
									location.reload();
								}); */

								/* $(".all").click(function(){
									$(".statusWorking").show();
									$(".statusComplete").show();
								}) */
							})
						</script>







					</div>
					<!-- Project Filter codes ends here... -->





					<div class="col-md-12"></div>
				</div>




			</div>

			<br> <br> <br>

			<!-- 			<div class="row"> -->
			<!-- 				<div class="alert alert-sm alert-info alert-dismissible" role="alert" ng-show="message.length>0"> -->
			<!-- 					<li ng-repeat="msg in message">{{msg}}</li> -->
			<!-- 				</div> -->
			<!-- 			</div> -->

			<!-- MODAL -->
			<!-- <div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true" ng-click="datarefresh()">&times;</span><span
								class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><i class="fa fa-upload"></i>&nbsp;Upload a document</h4>
					</div>
					<div class="modal-body">
						<input id=choseefile type="file" ng-file="file" base64>

						<div class="alert alert-sm alert-info alert-dismissible"
							role="alert" ng-show="message.length>0">
							<li ng-repeat="msg in message">{{msg}}</li>
						</div>
					</div>
					<div class="modal-footer">
						<button style="background-color: green"
							class="btn btn-primary" ng-click="uploadProjectDocument()"><i class="fa fa-upload"></i>&nbsp;Upload</button>
					</div>
				</div>
			</div>
		</div> -->


			<!-- Testing multiple file uploads start-->
			<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true" ng-click="datarefresh()">&times;</span><span
									class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">
								<i class="fa fa-upload"></i>&nbsp;Upload a document
							</h4>
						</div>
						<div class="modal-body" id="uploadmodalId">
							<input id="choseefile" type="file" multiple name="choseefile[]"
								ng-file="file"
								onChange="addFileInput('uploadmodalId','choseefile')"
								base-sixty-four-input>


						</div>
						<div class="modal-footer">
							<div ng-show="upload==false"
								style="width: 69px; height: 89px; position: absolute; top: 66%; left: 50%; padding: 2px;">
								<i class="fa fa-spinner fa-pulse"
									style="font-size: 50px; color: #4FCDFF;"></i>
							</div>
							<div class="alert alert-sm alert-info alert-dismissible"
								style="list-style: none; text-align: center;" role="alert"
								ng-show="message.length>0">
								<li ng-repeat="msg in message">{{msg}}</li>
							</div>
							<button  class="btn btn-success"
								ng-click="uploadProjectDocument()">
								<i class="fa fa-upload"></i>&nbsp;Upload
							</button>
							<button type="button" class="btn btn-success" data-dismiss="modal">
								<i class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;Exit
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- Testing multiple file uploads end-->



			<!-- Modal -->
			<div class="modal fade" id="approveProjectModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Accept or reject
								the project ?</h4>
						</div>
						<div class="modal-body">If you are satisfied by the project
							contents, you may approve it. Otherwise, you may reject it.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-info"
								ng-click="initiateProject('Y')">Accept</button>
							<!-- <button type="button" class="btn btn-danger" ng-click="initiateProject('N')"
						>Reject</button> -->
							<div class="alert alert-sm alert-info alert-dismissible"
								role="alert" ng-show="message.length>0">
								<li ng-repeat="msg in message">{{msg}}</li>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal -->
			<div class="modal fade" id="rejectProjectModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Do you want to
								Reject the project ?</h4>
						</div>
						<div class="modal-body">
							If you are not satisfied by the project contents, give comments
							for rejection.
							<div class="form-group">
								<textarea style="resize: none;" class="form-control"
									ng-model="comment" id="comment" name="comment" rows="4"></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-info"
								ng-click="rejectProject('N',comment)">Reject</button>
							<!-- <button type="button" class="btn btn-danger" ng-click="initiateProject('N')"
						>Reject</button> -->
							<div class="alert alert-sm alert-info alert-dismissible"
								role="alert" ng-show="message.length>0">
								<li ng-repeat="msg in message">{{msg}}</li>
							</div>
						</div>
					</div>
				</div>
			</div>



			<!-- Modal -->
			<!--  <div class="modal fade" id="closeProjectModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal_modl">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Close the project ?</h4>
					</div>
					<div class="modal-body">If you are satisfied with the project
						work, please close it. Otherwise, ask for modification.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success"
							ng-click="closeProject('Y')">Close Project</button>
						<button type="button" class="btn btn-danger"
							ng-click="closeProject('N')">Modification needed</button>
						<div class="alert alert-sm alert-info alert-dismissible"
							role="alert" ng-show="message.length>0">
							<li ng-repeat="msg in message">{{msg}}</li>
						</div>
					</div>
				</div>
			</div>
		</div> 
		  -->
			<!-- Modal -->

			<div class="modal fade" id="closeProjectModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel1">If you want to
								mark project as completed,give your notes and grade.</h4>
							<h4 class="modal-title" id="myModalLabel2" style="display: none;">Give
								reasons for modification of project.</h4>
						</div>
						<div class="modal-body">

							<div class="form-group" id="grade">
								<span class="input-group">Grade</span> <select
									style="width: 190px !important;" id="type" name="type"
									class="form-control" ng-model="grade" required>
									<option value selected="selected">select</option>
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
									<option value="F">F</option>
								</select>
							</div>

							<div class="form-group" id="notes">
								<span class="input-group">Notes</span>
								<textarea style="resize: none;" class="form-control"
									ng-model="notes" id="notes" name="notes" rows="4"></textarea>
							</div>

							<div class="form-group" style="display: none;" id="rejectnotes">
								<span class="input-group">Reason for modification</span>
								<textarea style="resize: none;" class="form-control"
									ng-model="rejectReason" id="rejectReason" name="rejectReason"
									rows="4"></textarea>
							</div>

							<button type="button" class="btn btn-success"
								id="markascompleted"
								ng-click="markAsCompletedProject('Y',grade,notes)">Mark
								Project As Completed</button>
							<button type="button" class="btn btn-danger" id="modify"
								ng-click="rejectnotesPopup()">Modification needed</button>
							<button type="button" class="btn btn-danger"
								id="modifywithRejectNotes" style="display: none;"
								ng-click="modifyProject('N',rejectReason)">Modification
								needed</button>
							<div class="alert alert-sm alert-info alert-dismissible"
								role="alert" ng-show="message.length>0">
								<li ng-repeat="msg in message">{{msg}}</li>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Modal -->
			<div class="modal fade" id="pitchMentorModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true" ng-click="datarefresh()">&times;</span><span
									class="sr-only" ng-click="datarefresh()">Close</span>
							</button>

						</div>
						<div class="modal-body">
							<h3 class="modal-title" id="myModalLabel">
								Select Mentor
								<div class="alert alert-sm alert-info alert-dismissible"
									role="alert" ng-show="message.length>0">
									<li ng-repeat="msg in message">{{msg}}</li>
								</div>
							</h3>
							<div class="col-md-12">&nbsp;</div>
							<div class="col-md-12">&nbsp;</div>
							<div class="col-xs-12" ng-repeat="mentor in suggestedMentors">
								<div class="col-md-2">
									<img
										ng-show="(mentor.photo=='data:undefined;base64,undefined')||(mentor.photo=='Photo path')"
										src="images/profile_icon.png" width=90 height=100 /> <img
										ng-hide="(mentor.photo=='data:undefined;base64,undefined')||(mentor.photo=='Photo path')"
										src="{{mentor.photo||'images/profile_icon.png'}}" width=90
										height=100 />
								</div>
								<div class="col-md-10">
									<div class="col-md-12">{{mentor.fName}} {{mentor.mName}}
										{{mentor.lName}}</div>
									<div class="col-md-12">{{mentor.designation}}</div>
									<div class="col-md-12">{{mentor.degree}}</div>
									<div class="col-md-12 red">Experience:
										{{mentor.experience}}</div>
									<div class="col-md-12">
										<a style="cursor: pointer;" class="btn btn-sm btn-success"
											ng-click="addMentor(mentor)">Add to project</a>
									</div>
								</div>
								<div class="col-md-12">&nbsp;</div>
								<hr>
								<div class="col-md-12">&nbsp;</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

	</div>
	<script>
		function addFileInput(modalName, firstInputId) {
			var fs = document.getElementById(modalName);

			// only add one if the last file-input field is not empty
			if (fs.lastElementChild.value != '') {
				var firstInputFile = document.getElementById(firstInputId);
				// var firstInputFile=$(".uploadclass");
				var newInputFile = document.createElement("input");
				newInputFile.type = firstInputFile.type;
				newInputFile.name = firstInputFile.name;
				newInputFile.id = firstInputFile.id;
				newInputFile.multiple = firstInputFile.multiple;
				newInputFile.base64 = firstInputFile.base64;
				newInputFile.onchange = firstInputFile.onchange;
				fs.appendChild(newInputFile);
			}

		}
	</script>
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
	</div>
	<!--End tag of container customFont borderRadius style  -->
	</div>
	<!-- End tag of page container -->
</body>
<!-- END BODY -->
</html>
<jsp:include page="template/footer.jsp" />
<link rel="stylesheet" href="css/customStyle.css" />
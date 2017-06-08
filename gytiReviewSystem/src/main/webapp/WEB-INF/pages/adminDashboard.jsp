<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="techpedia" lang="en" class="no-js">

<title>Admin Dashboard</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon-dashboard.ico">
<head>
<!-- Added for graph -->
 <link href="https://www.amcharts.com/lib/3/plugins/export/export.css" media="all" rel="stylesheet" type="text/css" />
<script src="js/amcharts.js" type="text/javascript"></script>
<script src="https://www.amcharts.com/lib/3/serial.js" type="text/javascript"></script>
<script src="https://www.amcharts.com/lib/3/plugins/animate/animate.min.js" type="text/javascript"></script>
<script src="https://www.amcharts.com/lib/3/pie.js" type="text/javascript"></script>
<script src="https://www.amcharts.com/lib/3/themes/light.js" type="text/javascript"></script>
<script src="js/export.js" type="text/javascript"></script>
<script src="js/responsive.min.js" type="text/javascript"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.20/pdfmake.js"></script>
<script src="js/layout_1.js" type="text/javascript"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="css/jquery-ui.css">

<!-- <link
	href="https://code.jquery.com/ui/1.12.0-rc.2/themes/smoothness/jquery-ui.css"> -->
<!-- <link rel="stylesheet" href="css/select2-bootstrap.css"> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-css/1.4.6/select2-bootstrap.css">
<link rel="stylesheet" href="css/select2.css">
<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.css"> -->
<style type="text/css">
#chartdivProjectData {
	width		: 100%;
	height		: 435px;
	font-size	: 11px;
}
#chartdivYearWiseProjectData,#chartdivParticularYearWiseProjectData{
  width: 100%;
  height: 450px;
}
.amcharts-pie-item {
  opacity: 0.7;
  -webkit-transition: all .3s ease-out;
  transition: all .3s ease-out;
}
.amcharts-pie-item:hover {
  opacity: 1;
}
</style>
</head>
<div class="" style="padding-left: 0px; padding-right: 0px;">
<jsp:include page="template/reviewHeader.jsp"></jsp:include>
</div>
<%if(((String)(session.getAttribute("revUsrId"))).equals("TrsAdmin")){ %>
<body >
	<div id="sideNavPanel" class="col-xs-2" style="padding-left: 0px; padding-right: 0px;margin-left: 0px;"><jsp:include
			page="template/reviewSideMenu.jsp"></jsp:include></div>
	<div ng-controller="adminDashBoardController" ng-init="Initload()" >
		<div class="content-wrapper">
		<div id="mainPanelBody" class="col-xs-10 col-md-10"
			style="" class="container">
			<div
				style="padding-left: 20px !important; background-color: #3575AD; color: white; height: 56px; padding-top: 15px; font-family: arial; font-size: 20px; font-weight: bolder;">
				DASHBOARD</div>
				

			<%-- 	<div>
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<ul class="page-breadcrumb breadcrumb">
						<%
							if (session.getAttribute("username") != null) {
						%>
						<li><a href="./">Home&nbsp;</a><font
							style="color: black; font-size: 18px;">&raquo;</font></li>
						<!-- <li><a href="dashboard">Dashboard&nbsp;</a><font
						style="color: black; font-size: 18px;">&raquo;</font></li> -->
						<li>Dashboard</li>
						<%
							} else {
						%><li><a href="./">Home&nbsp;</a><font
							style="color: black; font-size: 18px;">&raquo;</font></li>
						<li>Dashboard</li>
						<%
							}
						%>
					</ul>

				</div> --%>
		<!--  <h1 class="page-header">
            <button class="btn btn-primary pull-right" ng-click="createReport();"><i class="fa fa-file-pdf-o" aria-hidden="true"></i>&nbsp;Download Report</button>
          </h1> -->
         <div class="col-xs-3 col-md-3 pull-right" style="margin-bottom: -15px;">
				
							<div class="form-group" style="z-index: 0">
							
								<div class='input-group date' id='datetimepicker'>
									<input  type='text' ng-model="loadCurrentYear" class="form-control yearCalender" style="z-index: 0" readonly/> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span>
								</div>
							</div>
				</div>
			<div class="clearfix">&nbsp;</div>
			 
				<div style="box-shadow: 0 0 2em #b2b2b2;">
				<div  id="chartdivParticularYearWiseProjectData"></div>
				</div>
			<div class="col-xs-12 ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="col-xs-12 " >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="col-xs-12 " >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="col-xs-12 " style="clear: both;" class="clearfix" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div style="box-shadow: 0 0 2em #b2b2b2;">
				<div  id="chartdivProjectData"></div>
			</div>
			<div class="col-xs-12 clearfix">&nbsp;</div>
			<div style="box-shadow: 0 0 2em #b2b2b2; height: 500px">
				<div   id="chartdivYearWiseProjectData"></div>
			</div>
			<div class="col-xs-12 ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="col-xs-12 " >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="col-xs-12 " >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="col-xs-12 " style="clear: both;" class="clearfix" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<!-- <div style="margin-top: 150px; height: 400px" class=""
						id="chart_div"></div> -->
			<div style="box-shadow: 0 0 2em #b2b2b2;height: 500px">
			<div  id="chartdiv"></div>
			</div>
			<!-- <div class="col-xs-3 col-md-3 pull-right" style="margin-bottom: -15px;">
				
							<div class="form-group" style="z-index: 0">
							
								<div class='input-group' id="projectBranches">
									<input  type='text' ng-model="branchName" class="form-control yearCalender" style="z-index: 0"/> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span>
								</div>
							</div>
				</div> -->
		</div>
			
		</div>
		
	</div>

	<a href="#0" class="cd-top">Top</a>
	
	<script type="text/javascript">

	/*
	 ** Helper function to find the table body out of the layout
	 */
/* 	function findThatBody(obj) {
	  var found = false;
	  for (key in obj) {
	    if (obj[key] instanceof Array) {
	      if (found = findThatBody(obj[key])) {
	        return found;
	      }
	    } else if (obj[key] instanceof Object) {
	      if (obj[key].table) {
	        return obj[key];
	      } else {
	        if (found = findThatBody(obj[key])) {
	          return found;
	        }
	      }
	    }
	  }
	  return found;
	} */
/* 	// WAIT UNTIL CHART HAS BEEN RENDERED
	chart.addListener( "rendered", function( e ) {

		// WAIT FOR FABRIC
		var interval = setInterval( function() {
			if ( window.fabric ) {
				clearTimeout( interval );

				// CAPTURE CHART
				e.chart["export"].capture( {}, function() {

					// SAVE TO JPG
					this.toPNG( {}, function( base64 ) {

						// LOG IMAGE DATA
						console.log( base64 );
					} );
				} );
			}
		}, 100 );

	} ); */
	/*
	 ** Create report
	 */
	/* function createReport() {
	  var pdf_images = 0;
	  var pdf_layout = layout_1; // global reference from layouts/layout_1.js

	  // Walkthrough all charts
	  for (var i = 0; i < AmCharts.charts.length; i++) {

	    // Capture the current state of the chart
	    AmCharts.charts[i].export.capture({}, function() {

	      // Export to PNG
	      this.toPNG({
	        multiplier: 5 // increased for the tutorial

	        // Add image to the layout reference
	      }, function(data) {
	        pdf_images++;
	        pdf_layout.images["image_" + pdf_images] = data;

	        // Once all has been processed create the PDF
	        if (pdf_images == AmCharts.charts.length) {

	          // Build the table dynamically
	          var rows = [
	            [{
	              text: 'Value'
	            }]
	          ]
	          for (var i1 = 0; i1 < this.setup.chart.dataProvider.length; i1++) {
	            rows.push([this.setup.chart.dataProvider[i1].value]);
	          }
	          findThatBody(pdf_layout).table.body = rows;

	          // Save as single PDF and offer as download
	          this.toPDF(pdf_layout, function(data) {
	            this.download(data, this.defaults.formats.PDF.mimeType, "GYTI Project Report.pdf");
	          });
	        }
	      });
	    });
	  }
	} */
	</script>
	<script src="js/jquery-ui.js"></script>
	<!-- <script src="https://code.jquery.com/ui/1.12.0-rc.2/jquery-ui.js"
		integrity="sha256-6HSLgn6Ao3PKc5ci8rwZfb//5QUu3ge2/Sw9KfLuvr8="
		crossorigin="anonymous"></script> -->
	<!-- <script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/select2.min.js"></script> -->
	<script src="js/select2.min.js"></script>
	<script src="js/script.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
</body>
<%}else{ %>
<div id="sideNavPanel" class="col-xs-2" style="padding-left: 0px; padding-right: 0px;margin-left: 0px;">
			<jsp:include page="template/reviewSideMenu.jsp"></jsp:include>
			</div>
	<div id="mainPanelBody" class="col-xs-10 col-md-10">
			<div  class="alert alert-sm alert-danger alert-dismissible"
						role="alert" style="text-align: center; margin-top: 150px;" >
				<h2>Sorry, Unauthorized access...!! </h2><i style="color: red" class="fa fa-ban fa-5x" aria-hidden="true"></i>		
			</div>
			</div>
		<%} %>

<!-- </html> -->
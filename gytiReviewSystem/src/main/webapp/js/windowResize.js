$(window).on('load resize', function(){
	var win = $(this);
	if (win.width() < 766) { 
		$('#sideNavPanel').removeClass('col-xs-2 col-md-2');
		$('#mainPanelBody').removeClass('col-xs-10 col-md-10');
		$('#mainPanelBody').addClass('col-xs-12 col-md-12');
		$('#openSideNav').hide();
		$('#CloseNav').hide();
		$('#mainPanelBodyIndex').removeClass('col-xs-4 col-md-4');
		$('#mainPanelBodyIndex').addClass('col-xs-8 col-md-8');
		$("#container").css("margin-left", "0px");
		$(".tableResponsive").addClass(" table-responsive");
	}
	/*else if(win.width()<=783 && win.width() >=766 ){
		$('#sideNavPanel').show();
		$('#openSideNav').hide();
		$('#sideNavPanel').addClass('col-xs-2 col-md-2');
		$('#mainPanelBody').addClass('col-xs-10 col-md-10');
	}*/
	else
	{
		$('#openSideNav').show();
		$('#mainPanelBody').removeClass('col-xs-12 col-md-12');
		$('#sideNavPanel').addClass('col-xs-2 col-md-2');
		$('#mainPanelBody').addClass('col-xs-12 col-md-12');
		$('#sideNavPanel').show();
		$('#mainPanelBodyIndex').removeClass('col-xs-8 col-md-8');
		$('#mainPanelBodyIndex').addClass('col-xs-4 col-md-4');
		$('#CloseNav').show();
		$(".tableResponsive").removeClass(" table-responsive");
		/*$('#sideNavPanel').hide();
		$('#openSideNav').show();*/
	}

});

$( document ).ready(function() {
	//$('#sideNavPanel').hide();
	/* $('#mainPanelBody').addClass('col-xs-10 col-md-10');
	$('#mainPanelBody').removeClass('col-xs-10 col-md-10');*/
	$(window).on('load resize', function(){
			var win = $(this);
			if (win.width() < 766) {		
									$('#sideNavPanel').removeClass('col-xs-2 col-md-2');
									$('#mainPanelBody').removeClass('col-xs-10 col-md-10');
									$('#mainPanelBody').addClass('col-xs-12 col-md-12');
									$('#openSideNav').hide();
									$('#CloseNav').hide();
									$('#mainPanelBodyIndex').removeClass('col-xs-4 col-md-4');
									$('#mainPanelBodyIndex').addClass('col-xs-8 col-md-8');
									}
			else{
				$('#sideNavPanel').addClass('col-xs-2 col-md-2');
				$('#mainPanelBody').addClass('col-xs-10 col-md-10') ;
			}
				});
	});
/*$( document ).ready(function() {
	$('#sideNavPanel').hide();
	function w3_open() {
		alert("open");
		$('#sideNavPanel').show();
		$('#mainPanelBody').addClass('col-xs-10');
		$('#sideNavPanel').addClass('col-xs-2');
	}
	function w3_close() {
		alert("close");
		$('#sideNavPanel').hide();
		$('#mainPanelBody').removeClass('col-xs-10');
		$('#mainPanelBody').addClass('col-xs-12');
		
	  document.getElementById("mainPanelBody").style.marginLeft = "0%";
	  document.getElementsByClassName("w3-sidenav")[0].style.display = "none";
	  document.getElementsByClassName("w3-opennav")[0].style.display = "inline-block";
	}
})*/


